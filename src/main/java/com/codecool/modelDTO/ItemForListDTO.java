package com.codecool.modelDTO;

import com.codecool.model.AppUser;
import com.codecool.model.Category;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ItemForListDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Category category;
    private String picUrl;
    private AppUserDTO owner;
}
