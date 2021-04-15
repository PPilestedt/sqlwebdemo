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

    @GetMapping(path="/add10newbooks")
    public String add10newbooks(){
        bookRepo.save(new Book("sagan om de bannlysta","tokien"));
        bookRepo.save(new Book("harekrishna","janne"));
        bookRepo.save(new Book("karesuandukniven","pelle"));
        bookRepo.save(new Book("sagan om de två tokarna","tokien"));
        bookRepo.save(new Book("Dildo","tokien"));

        bookRepo.save(new Book("sagan om de bannlysta 2","tokien"));
        bookRepo.save(new Book("harekrishna 2","janne"));
        bookRepo.save(new Book("karesuandukniven 2","pelle"));
        bookRepo.save(new Book("sagan om de två tokarna 2","tokien"));
        bookRepo.save(new Book("Dildo","tokien 2"));
        return "added 10 books";
    }
}
