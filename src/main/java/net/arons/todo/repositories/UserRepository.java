package net.arons.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.arons.todo.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmailAndPassword(String email, String password);
}
