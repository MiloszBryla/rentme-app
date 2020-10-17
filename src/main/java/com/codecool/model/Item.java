package com.codecool.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="items")
public class Item {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name= "name")
    private String name;
    @Column(name= "description")
    private String description;
    @Column(name= "price")
    private double price;
    @Column(name= "pic_url")
    private String picUrl;
    @ManyToOne (cascade=CascadeType.MERGE)
    @JoinColumn(name= "owner_id")
    private AppUser owner;
    @ManyToOne (cascade=CascadeType.MERGE)
    @JoinColumn(name= "category_id")
    private Category category;

    public Item(String name, String description, double price, String picUrl, AppUser owner, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.picUrl = picUrl;
        this.owner = owner;
        this.category = category;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String description;
        private double price;
        private Category category;
        private String picUrl;
        private String city;
        private AppUser owner;

        public Item.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Item.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Item.Builder description(String description) {
            this.description = description;
            return this;
        }

        public Item.Builder price(double price) {
            this.price = price;
            return this;
        }

        public Item.Builder category(Category category) {
            this.category = category;
            return this;
        }

        public Item.Builder picUrl(String picUrl) {
            this.picUrl = picUrl;
            return this;
        }


        public Item.Builder owner(AppUser owner) {
            this.owner = owner;
            return this;
        }

        public Item build() {
            Item item = new Item();
            item.id = this.id;
            item.name = this.name;
            item.description = this.description;
            item.price = this.price;
            item.category = this.category;
            item.picUrl = this.picUrl;
            item.owner = this.owner;

            return item;
        }
}
}
