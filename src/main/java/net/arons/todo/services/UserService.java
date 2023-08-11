package net.arons.todo.services;

import java.util.List;

import net.arons.todo.dto.UserDto;

public interface UserService {

    UserDto save(UserDto user);

    List<UserDto> findAll();

    UserDto findById(Long id);

    void delete(Long id);

    UserDto login(UserDto user);
}
