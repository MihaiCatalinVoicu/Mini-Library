package com.dev.MiniLibrary.dto;

import com.dev.MiniLibrary.entity.Author;
import com.dev.MiniLibrary.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public record BookDTO(

        Long id,

        @NotBlank
        String title,

        @NotBlank
        @Pattern(regexp = "^[0-9]{10,13}$")
        String isbn,

        Integer publicationYear,

        Boolean available,

        @NotNull
        Author authorId,

        @NotNull
        Category categoryId) {


}
