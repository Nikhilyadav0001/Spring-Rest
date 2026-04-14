package nikhil.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import nikhil.model.Book;

public interface IBookRepo extends JpaRepository<Book, Integer> {

}