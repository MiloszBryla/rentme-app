package com.codecool.modelDTO;

import com.codecool.App;
import com.codecool.model.AppUser;
import com.codecool.model.Category;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ItemDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private Category category;
    private String picUrl;
    private AppUser owner;


    public static final class Builder {
        private Long id;
        private String name;
        private String description;
        private double price;
        private Category category;
        private String picUrl;
        private AppUser owner;

        public ItemDTO.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public ItemDTO.Builder name(String name) {
            this.name = name;
            return this;
        }

        public ItemDTO.Builder description(String description) {
            this.description = description;
            return this;
        }

        public ItemDTO.Builder price(double price) {
            this.price = price;
            return this;
        }

        public ItemDTO.Builder category(Category category) {
            this.category = category;
            return this;
        }

        public ItemDTO.Builder picUrl(String picUrl) {
            this.picUrl = picUrl;
            return this;
        }

        public ItemDTO.Builder owner(AppUser owner) {
            this.owner = owner;
            return this;
        }

        public ItemDTO build() {
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.id = this.id;
            itemDTO.name = this.name;
            itemDTO.description = this.description;
            itemDTO.price = this.price;
            itemDTO.category = this.category;
            itemDTO.picUrl = this.picUrl;
            itemDTO.owner = this.owner;

            return itemDTO;
        }
    }
}
