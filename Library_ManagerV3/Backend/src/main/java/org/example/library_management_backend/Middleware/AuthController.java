@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<APIResponse<String>> login(@RequestBody LoginRequest request) {
        User user = userService.findByUsername(request.getUsername());

        // BCrypt
        if (user == null || !user.getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new APIResponse<>(ResponseCode.UNAUTHORIZED, null));
        }

        String token = jwtUtil.generateToken(user.getUserName(), user.getRole().name());
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS, token));
    }
}