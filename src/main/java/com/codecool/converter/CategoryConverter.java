package com.codecool.converter;

import com.codecool.model.Category;
import com.codecool.modelDTO.CategoryDTO;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryConverter {

    public List<CategoryDTO> entitiesToDTO(List<Category> categories) {
        return categories.stream()
                .map(category -> entityToDTO(category))
                .collect(Collectors.toList());
    }

    public CategoryDTO entityToDTO(Category category) {
        return new CategoryDTO();
    }

}
