package be.tcla.bookinventory.repository;

import be.tcla.bookinventory.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<Book, Integer> {
}
