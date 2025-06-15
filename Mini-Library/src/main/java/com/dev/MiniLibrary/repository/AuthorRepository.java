package com.dev.MiniLibrary.repository;

import com.dev.MiniLibrary.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    // Căutare după nume complet
    Optional<Author> findByFirstNameAndLastName(String firstName, String lastName);

    // Căutare după naționalitate
    List<Author> findByNationality(String nationality);

    // Căutare personalizată
    @Query("SELECT a FROM Author a WHERE LOWER(a.firstName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
            "OR LOWER(a.lastName) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Author> searchAuthors(@Param("searchTerm") String searchTerm);

    // Verificare existență
    boolean existsByFirstNameAndLastName(String firstName, String lastName);
}
