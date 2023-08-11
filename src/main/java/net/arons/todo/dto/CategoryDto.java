package net.arons.todo.dto;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.arons.todo.model.Category;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {

    private Long id;

    private String name;

    private String description;

    private UserDto user;

    private List<TodoDto> todoList;

    // convert a CategoryDto object to Category entity
    public static Category toEntity(CategoryDto categoryDto){
        Category category = new Category();

        category.setUser(UserDto.toEntity(categoryDto.getUser()));
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        return category;
    }

    // convert a Category entity to a CategoryDto object
    public static CategoryDto fromEntity(Category category){
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .todoList(
                    category.getTodoList() != null ? category.getTodoList().stream().map(TodoDto::fromEntity).collect(Collectors.toList()) : null
                )
                .build();
    }
}
