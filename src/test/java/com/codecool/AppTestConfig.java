package com.codecool;

import com.codecool.controller.api.CategoriesController;
import com.codecool.controller.api.ItemController;
import com.codecool.controller.api.UserController;
import com.codecool.converter.AppUserConverter;
import com.codecool.converter.ItemConverter;
import com.codecool.dao.UserRepository;
import com.codecool.model.Category;
import com.codecool.model.Item;
import com.codecool.service.CategoryService;
import com.codecool.service.ItemService;
import com.codecool.service.UserService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
public class AppTestConfig {

    @Bean
    public AppUserConverter appUserConverter() {
        return new AppUserConverter();
    }

    @Bean
    public ItemConverter itemConverter() {
        return new ItemConverter();
    }

    @Bean
    public UserController userController() {
        return new UserController(userService());
    }

    @Bean
    public CategoriesController categoriesController() {
        return new CategoriesController(categoryService());
    }

    @Bean
    public CategoryService categoryService() {
        return Mockito.mock(CategoryService.class);
    }

    @Bean
    public UserService userService() {
        return Mockito.mock(UserService.class);
    }

    @Bean
    public ItemService itemService() {
        return Mockito.mock(ItemService.class);
    }

    @Bean
    public Category category() {
        return Mockito.mock(Category.class);
    }

    @Bean
    public ItemController itemController() {
        return new ItemController(itemService(), itemConverter());
    }
}

