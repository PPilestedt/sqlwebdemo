package com.example.sqlwebdemo;

import com.example.sqlwebdemo.Models.Book;
import com.example.sqlwebdemo.Repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SqlwebdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqlwebdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository repository){
        return args -> {
            repository.save(new Book("sagan om de bannlysta","tokien"));
            repository.save(new Book("harekrishna","janne"));
            repository.save(new Book("karesuandukniven","pelle"));
            repository.save(new Book("sagan om de två tokarna","tokien"));
            repository.save(new Book("Dildo","tokien"));
        };
    }
}
