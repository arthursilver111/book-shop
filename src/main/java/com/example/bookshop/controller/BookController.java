package com.example.bookshop.controller;

import com.example.bookshop.dto.BookRequestDto;
import com.example.bookshop.dto.BookResponseDto;
import com.example.bookshop.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookResponseDto getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponseDto createBook(@RequestBody BookRequestDto bookRequestDto) {
        return bookService.save(bookRequestDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponseDto> getAll() {
        return bookService.findAll();
    }
}
