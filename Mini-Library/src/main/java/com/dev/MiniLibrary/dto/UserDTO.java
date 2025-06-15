package com.dev.MiniLibrary.dto;

import com.dev.MiniLibrary.entity.Loan;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public record UserDTO(

        Long id,

        @NotBlank
        String firstName,

        @NotBlank
        String lastName,

        @Email
        String email,

        LocalDate registrationDate,

        List<Loan> loanIds

) {
}
