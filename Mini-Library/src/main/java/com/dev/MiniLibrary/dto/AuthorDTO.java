package com.dev.MiniLibrary.dto;

import com.dev.MiniLibrary.entity.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public record AuthorDTO(

        Long id,

        @NotBlank
        String firstName,

        @NotBlank
        String LastName,

        String Nationality,

        @Past
        LocalDate birthDate,

        List<Book> bookIds) {
}
