package com.dev.MiniLibrary.dto;

import com.dev.MiniLibrary.entity.Book;
import com.dev.MiniLibrary.entity.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public record LoanDTO(Long id,

                      Book bookId,

                      User uiserId,

                      LocalDate loanDate,

                      LocalDate dueDate,

                      LocalDate returnDate) {
}
