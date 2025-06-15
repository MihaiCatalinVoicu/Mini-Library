package com.dev.MiniLibrary.mapper;

import com.dev.MiniLibrary.dto.AuthorDTO;
import com.dev.MiniLibrary.dto.request.AuthorCreateDTO;
import com.dev.MiniLibrary.dto.request.AuthorUpdateDTO;
import com.dev.MiniLibrary.entity.Author;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface AuthorMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "books", ignore = true)
    Author toEntity(AuthorCreateDTO dto);

    AuthorDTO toDTO(Author entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "books", ignore = true)
    void updateEntityFromDTO(AuthorUpdateDTO dto, @MappingTarget Author entity);

    @IterableMapping(elementTargetType = AuthorDTO.class)
    List<AuthorDTO> toDTOList(List<Author> entities);

    // Eliminăm afterMapping dacă cauzează probleme
    // Sau îl modificăm pentru a folosi setter-ele direct
    @AfterMapping
    default void afterMapping(@MappingTarget Author author) {
        if (author.getNationality() != null) {
            author.setNationality(author.getNationality().toUpperCase());
        }
    }
}