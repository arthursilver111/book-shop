package com.example.bookshop.service;

import com.example.bookshop.dto.BookRequestDto;
import com.example.bookshop.dto.BookResponseDto;
import com.example.bookshop.exepction.EntityNotFoundException;
import com.example.bookshop.mapper.BookMapper;
import com.example.bookshop.model.Book;
import com.example.bookshop.repository.BookRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookResponseDto findById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Could not find book with id: " + id));
        return bookMapper.mapToDto(book);
    }

    @Override
    public BookResponseDto save(BookRequestDto bookRequestDto) {
        Book book = bookRepository.save(bookMapper.dtoToMap(bookRequestDto));
        return bookMapper.mapToDto(book);
    }

    @Override
    public List<BookResponseDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
