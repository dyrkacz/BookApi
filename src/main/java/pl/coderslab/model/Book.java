package pl.coderslab.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Comparable<Book>{
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String type;


    @Override
    public int compareTo(Book book) {
        return Long.compare(this.id, book.getId());
    }
}
