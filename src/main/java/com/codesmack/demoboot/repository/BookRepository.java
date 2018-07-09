package com.codesmack.demoboot.repository;

import com.codesmack.demoboot.repository.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Aniruddha on 09-07-2018.
 */
public interface BookRepository extends JpaRepository <Book, Long> {
    List<Book> findByReader(final String reader);
}
