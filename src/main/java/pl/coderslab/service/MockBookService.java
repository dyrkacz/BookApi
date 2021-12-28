package pl.coderslab.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Data
public class MockBookService {
    private List<Book> list = new ArrayList<>();

    public MockBookService(){
        Book book1 = new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
        Book book2 = new Book(2L, "1118324631766", "How to be mean",
                "Piotr Adamczyk", "Coderslab", "life");
        Book book3 = new Book(3L, "1128324631766", "How not teach people",
                "Adam Wlodarczyk", "Coderslab", "life");
        list.add(book1);
        list.add(book2);
        list.add(book3);
    }

    public List<Book> findAll(){
        return list;
    }
    public Book getBook(Long id){
        return list.stream().filter(it->it.getId()==id).findFirst().orElse(null);
    }
    public boolean deleteBook(Long id){
        return list.removeIf(it->it.getId()==id);
    }
    public Book updateBook(Book book){
        deleteBook(book.getId());
        if(book.getId()==null){
           book.setId(list.stream().sorted((it1, it2) -> Long.compare(it2.getId(), it1.getId())).findFirst().orElse(null).getId()+1);
        }
        list.add(book);
        list = list.stream().sorted().collect(Collectors.toList());
        return book;
    }



}
