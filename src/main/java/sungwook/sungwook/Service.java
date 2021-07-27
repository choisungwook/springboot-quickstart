package sungwook.sungwook;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Service {
    private List<Book> books = new ArrayList<>();

    @GetMapping("/books")
    public List<Book> GetBooks() {
        return books;
    }

    @PostMapping("/add")
    public List<Book> Add(@RequestBody Book book){
        books.add(book);

        return books;
    }

    @PutMapping("/update/{id}")
    public String Update(@RequestBody Book new_book, @PathVariable int id){
        Book find_book = books.stream()
                .filter(book -> book.getId() == id)
                .findAny()
                .orElse(null);

        if(find_book != null){
            find_book.setAuthor(new_book.getAuthor());
            find_book.setName(new_book.getName());
            find_book.setPrice(new_book.getPrice());

            return "success";
        }

        return "the book is not exist";
    }

    @DeleteMapping("/delete/{id}")
    public Book Delete(@PathVariable int id){
        Book find_book = books.stream()
                .filter(book -> book.getId() == id)
                .findAny()
                .orElse(null);

        if(find_book != null){
            books.remove(find_book);
        }

        return find_book;
    }
}
