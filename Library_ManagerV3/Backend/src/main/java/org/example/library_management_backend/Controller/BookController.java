package org.example.library_management_backend.Controller;


import org.example.library_management_backend.Configuration.APIResponse;
import org.example.library_management_backend.Configuration.ResponseCode;
import org.example.library_management_backend.Model.Entity.Book;
import org.example.library_management_backend.Model.Entity.User;
import org.example.library_management_backend.Model.Repository.BookRepository;
import org.example.library_management_backend.Model.Service.BookService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Book")
public class BookController {

    BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'MANAGEMENT', 'ADMIN')")
    public ResponseEntity<APIResponse<Book>> findBookById(@PathVariable int id) {

        Book book =  this.bookService.getBookById(id);

        APIResponse<Book> apiResponse = new APIResponse<>(ResponseCode.SUCCESS, book);

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }

    @GetMapping("/0")
    @PreAuthorize("hasAnyRole('USER', 'MANAGEMENT', 'ADMIN')")
    public ResponseEntity<APIResponse<List<Book>>> findAll() {
        List<Book> listDBBook = bookService.getAllBooks();
        APIResponse<List<Book>> apiResponse = new APIResponse<>(ResponseCode.SUCCESS,listDBBook);

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);    }

    @PostMapping
    @PreAuthorize("hasAnyRole('MANAGEMENT', 'ADMIN')")
    public ResponseEntity<APIResponse<Book>> saveBook(@RequestBody Book newBook){
        bookService.saveBook(newBook);

        APIResponse<Book> apiResponse = new APIResponse<>(ResponseCode.SUCCESS, newBook);

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('MANAGEMENT', 'ADMIN')") 
    public ResponseEntity<APIResponse<Book>> deleteBookById(@PathVariable int id){
        Book bookRemove = bookService.getBookById(id);
        bookService.deleteBook(bookRemove);

        return new ResponseEntity<>(
                new APIResponse<>(ResponseCode.SUCCESS, bookRemove),
                HttpStatus.OK
        );

    }
}
