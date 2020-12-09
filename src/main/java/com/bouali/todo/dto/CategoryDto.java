package com.bouali.todo.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.bouali.todo.model.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {

	private Long id;

	private String name;

	private String description;

	private UserDto user;

	private List<TodoDto> todoList;

	public static Category toEntity(CategoryDto categoryDto) {
		Category category = new Category();
		category.setUser(UserDto.toEntity(categoryDto.getUser()));
		category.setId(categoryDto.getId());
		category.setName(categoryDto.getName());
		category.setDescription(categoryDto.getDescription());
//		category.setUser(UserDto.toEntity(categoryDto.getUser()));
		return category;
	}

	public static CategoryDto fromEntity(Category category) {
		return CategoryDto.builder().id(category.getId()).name(category.getName())
				.description(category.getDescription())
//				.user(UserDto.fromEntity(category.getUser()))
				.todoList(category.getTodoList() != null
						? category.getTodoList().stream().map(TodoDto::fromEntity).collect(Collectors.toList())
						: null)
				.build();
	}
}
