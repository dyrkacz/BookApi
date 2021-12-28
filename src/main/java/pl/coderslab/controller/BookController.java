package pl.coderslab.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import pl.coderslab.model.Book;
import pl.coderslab.model.BookDto;
import pl.coderslab.model.JsonResponse;
import pl.coderslab.service.MockBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final MockBookService mockBookService;

    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Book> findAll() {
        return mockBookService.findAll();
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public Book newBook(@RequestBody BookDto bookDto) {
        Book book = bookDto.map();
        return mockBookService.updateBook(book);

    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Book getBook(@PathVariable Long id) {
        return mockBookService.getBook(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public JsonResponse deleteBook(@PathVariable Long id) {
        if(mockBookService.deleteBook(id)){
            return new JsonResponse(HttpStatus.OK,String.format("Object [%s] successfully removed",id));
        }
        return new JsonResponse(HttpStatus.NOT_FOUND,String.format("Object [%s] not found in DB",id));
    }


    @RequestMapping(value = "",method = RequestMethod.PUT)
    public Book updateBook(@RequestBody BookDto bookDto) {
        Book book = bookDto.map();
        return mockBookService.updateBook(book);
    }




}