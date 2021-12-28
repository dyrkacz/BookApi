package pl.coderslab.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String type;


    public Book map(){
        Book book = new Book();
        book.setId(id);
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setType(type);
        return book;
    }
}
