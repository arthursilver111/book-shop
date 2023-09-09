package com.example.bookshop.service;

import com.example.bookshop.dto.BookRequestDto;
import com.example.bookshop.dto.BookResponseDto;
import java.util.List;

public interface BookService {
    BookResponseDto findById(Long id);

    BookResponseDto save(BookRequestDto requestDto);

    List<BookResponseDto> findAll();
}
