package com.codecool.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class AppUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name= "id")
    private Long id;
    @Column(name= "first_name")
    private String firstName;
    @Column(name= "last_name")
    private String lastName;
    @Column(name= "email",unique = true)
    private String email;
    @Column(name= "password")
    private String password;
    @Column(name= "address")
    private String address;
    @Column(name= "city")
    private String city;
    @Column(name= "is_admin")
    private Boolean isAdmin;
    @Column(name= "post_code")
    private String postCode;
    @Column(name= "lat")
    private Double lat;
    @Column(name= "lng")
    private Double lng;
    @Column(name= "enabled")
    private int enabled;
    @Column(name = "role")
    private String role;

    public AppUser() {
    }

    public AppUser(Long id, String firstName, String lastName, String email, String password, String address,
                   String postCode, String city, boolean isAdmin, double lat, double lng) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.postCode = postCode;
        this.city = city;
        this.isAdmin = isAdmin;
        this.lat = lat;
        this.lng = lng;
    }

    public static final class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String address;
        private String postCode;
        private String city;
        private Boolean isAdmin;
        private Double lat;
        private Double lng;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder postCode(String postCode) {
            this.postCode = postCode;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder isAdmin(boolean isAdmin) {
            this.isAdmin = isAdmin;
            return this;
        }

        public Builder lat(Double lat) {
            this.lat = lat;
            return this;
        }

        public Builder lng(Double lng) {
            this.lng = lng;
            return this;
        }

        public AppUser build() {
            AppUser appUser = new AppUser();
            appUser.id = this.id;
            appUser.firstName = this.firstName;
            appUser.lastName = this.lastName;
            appUser.email = this.email;
            appUser.password = this.password;
            appUser.address = this.address;
            appUser.postCode = this.postCode;
            appUser.city = this.city;
            appUser.isAdmin = this.isAdmin;
            appUser.lat = this.lat;
            appUser.lng = this.lng;
            return appUser;
        }
    }
}