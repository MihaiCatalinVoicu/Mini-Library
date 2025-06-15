package com.dev.MiniLibrary.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthorCreateDTO(

        @NotBlank(message = "First name is required")
        @Size(min = 2, max = 100, message = "First name must be between 2 and 100 characters")
        String firstName,

        @NotBlank(message = "Last name is required")
        @Size(min = 3, max = 100, message = "Last name must be between 3 and 100 characters")
        String lastName,

        @Size(min = 3, max = 20, message = "Nationality must be between 3 and 20 characters")
        String nationality) {
}
