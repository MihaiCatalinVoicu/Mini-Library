package com.dev.MiniLibrary.service;

import com.dev.MiniLibrary.dto.request.AuthorCreateDTO;
import com.dev.MiniLibrary.dto.AuthorDTO;
import com.dev.MiniLibrary.dto.request.AuthorUpdateDTO;
import com.dev.MiniLibrary.entity.Author;
import com.dev.MiniLibrary.mapper.AuthorMapper;
import com.dev.MiniLibrary.repository.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorDTO createAuthor(AuthorCreateDTO createDTO) {
        Author author = authorMapper.toEntity(createDTO);
        Author savedAuthor = authorRepository.save(author);
        return authorMapper.toDTO(savedAuthor);
    }

    public AuthorDTO updateAuthor(Long id, AuthorUpdateDTO updateDTO) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Author not found"));

        authorMapper.updateEntityFromDTO(updateDTO, author);
        Author updatedAuthor = authorRepository.save(author);
        return authorMapper.toDTO(updatedAuthor);
    }
}
