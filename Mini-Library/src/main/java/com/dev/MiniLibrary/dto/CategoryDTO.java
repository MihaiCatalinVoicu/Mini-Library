package com.dev.MiniLibrary.dto;

import com.dev.MiniLibrary.entity.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.List;
public record CategoryDTO(

        Long id,

        @NotBlank
        String name,

        @Size(min = 10, max = 200, message = "Description mush contain between 10 and 200 characters ")
        String description,

        List<Book> bookIds) {
}
