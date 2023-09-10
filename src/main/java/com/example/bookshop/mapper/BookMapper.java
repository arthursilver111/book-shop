package com.example.bookshop.mapper;

import com.example.bookshop.config.MapperConfig;
import com.example.bookshop.dto.BookRequestDto;
import com.example.bookshop.dto.BookResponseDto;
import com.example.bookshop.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookResponseDto mapToDto(Book book);

    Book dtoToMap(BookRequestDto bookRequestDto);
}
