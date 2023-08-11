package net.arons.todo.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.arons.todo.model.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String userName;

    private String password;

    @JsonIgnore
    private List<CategoryDto> category;

    // converts a UserDto object to a User entity
    public static User toEntity(UserDto userDto){
        
        final User user = new User();

        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setCategory(
            userDto.getCategory() != null ? userDto.getCategory().stream().map(CategoryDto::toEntity).collect(Collectors.toList()) : null
        );

        return user;
    }

    // converts a User entity to a UserDto object
    public static UserDto fromEntity(User user){
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .userName(user.getUserName())
                .password(user.getPassword())
                .email(user.getEmail())
                .category(
                    user.getCategory() != null ? user.getCategory().stream().map(CategoryDto::fromEntity).collect(Collectors.toList()) : null
                )
                .build();

    }
}
