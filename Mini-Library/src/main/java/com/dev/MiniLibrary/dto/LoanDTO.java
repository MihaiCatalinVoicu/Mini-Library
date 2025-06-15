package com.dev.MiniLibrary.dto;

import com.dev.MiniLibrary.entity.Book;
import com.dev.MiniLibrary.entity.LibraryUser;
import java.time.LocalDate;
public record LoanDTO(Long id,

                      Book bookId,

                      LibraryUser uiserId,

                      LocalDate loanDate,

                      LocalDate dueDate,

                      LocalDate returnDate) {
}
