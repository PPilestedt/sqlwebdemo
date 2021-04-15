package com.example.sqlwebdemo;

import com.example.sqlwebdemo.Models.Book;

import java.util.ArrayList;
import java.util.List;

public class DAO {

    private List<Book> booklist = new ArrayList<>();

    public DAO(){

    }

    public List<Book> getBooklist(){
        return booklist;
    }
}
