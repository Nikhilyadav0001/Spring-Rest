package nikhil.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import nikhil.model.User;

public interface IUserRepo extends JpaRepository<User, Integer> {

}
