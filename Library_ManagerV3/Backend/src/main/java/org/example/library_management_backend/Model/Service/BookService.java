package org.example.library_management_backend.Model.Service;


import jakarta.transaction.Transactional;
import org.example.library_management_backend.Exception.BookException.BookNotFoundException;
import org.example.library_management_backend.Exception.UserException.UserNotFoundException;
import org.example.library_management_backend.Model.Entity.Book;
import org.example.library_management_backend.Model.Entity.User;
import org.example.library_management_backend.Model.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookService{

    BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }


    public Book getBookById(int Id){
        return bookRepository.findById(Id)
                .orElseThrow(() -> new BookNotFoundException("Không tìm thấy User Id " + Id));
    }

    public void deleteBook(Book book){
        bookRepository.delete(book);

    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public void saveBook(Book book){
        bookRepository.save(book);
    }



}
