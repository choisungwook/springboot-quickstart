package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestAPI {

    private List<Book> bookList = new ArrayList<>();

    @RequestMapping(method = RequestMethod.GET, path="/books")
    public List<Book> GetAll(){
        return bookList;
    }

    @RequestMapping(method = RequestMethod.POST, path="/add")
    public String Add(@RequestBody Book book){
        bookList.add(book);
        return "Add";
    }

    @RequestMapping(method = RequestMethod.PUT, path="/update/{id}")
    public String Update(@RequestBody Book tobook, @PathVariable int id){

        Book find_book = bookList.stream()
                .filter(book -> book.getId() == id)
                .findAny()
                .orElse(null);

        if(find_book != null){
            find_book.setAuthor(tobook.getAuthor());
            find_book.setName(tobook.getName());
            find_book.setPrice(tobook.getPrice());

            return "success";
        }

        return "not valid";
    }

    @RequestMapping(method = RequestMethod.DELETE, path="/delete/{id}")
    public String Delete(@PathVariable int id){

        Book find_book = bookList.stream()
                .filter(book -> book.getId() == id)
                .findAny()
                .orElse(null);

        if(find_book != null){
            bookList.remove(find_book);
            return "success";
        }

        return "not valid";
    }
}
