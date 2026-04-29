package org.example.library_management_backend.Middleware;

import org.example.library_management_backend.Configuration.APIResponse;
import org.example.library_management_backend.Configuration.ResponseCode;
import org.example.library_management_backend.Model.Entity.User; // ✅ Đúng class User
import org.example.library_management_backend.Model.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<APIResponse<String>> login(@RequestBody LoginRequest request) {
        User user;

        try {
            user = userService.findByUsername(request.getUsername());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new APIResponse<>(ResponseCode.UNAUTHORIZED, null));
        }

        if (!user.getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new APIResponse<>(ResponseCode.UNAUTHORIZED, null));
        }

        // ✅ getUserName() thay vì getName(), getRole() thay vì getRoles()
        String token = jwtUtil.generateToken(user.getUserName(), user.getRole().name());

        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS, token));
    }
}