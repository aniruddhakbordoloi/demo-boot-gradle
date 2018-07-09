package com.codesmack.demoboot.controller;

import com.codesmack.demoboot.repository.BookRepository;
import com.codesmack.demoboot.repository.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Aniruddha on 09-07-2018.
 */
@Controller
@RequestMapping("/")
public class BookListController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value="/{reader}", method= RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader, Model model) {
        final List<Book> bookList = bookRepository.findByReader(reader);
        if (null != bookList) {
            model.addAttribute("books", bookList);
        }
        return "bookList";
    }

    @RequestMapping(value="/{reader}", method=RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        bookRepository.save(book);
        return "redirect:/{reader}";
    }
}
