package com.example.sqlwebdemo.Controllers;

import com.example.sqlwebdemo.Models.Book;
import com.example.sqlwebdemo.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    BookRepository bookRepo;

    @GetMapping(path="/add")
    public @ResponseBody String addNewBook(@RequestParam String title,@RequestParam String author){
        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        bookRepo.save(book);
        return "Saved";
    }

    @GetMapping(path="/all")
    public Iterable<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    @GetMapping(path="/findtitle")
    public @ResponseBody Iterable<Book> findByTitle(@RequestParam String title){
        return bookRepo.findByTitle(title);
    }

    @GetMapping(path="/findauthor")
    public @ResponseBody Iterable<Book> findByAuthor(@RequestParam String author){
        return bookRepo.findByAuthor(author);
    }
}
