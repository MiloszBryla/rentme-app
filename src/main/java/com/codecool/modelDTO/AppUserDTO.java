package com.codecool.modelDTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppUserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String city;
    private String postCode;
    private Double lat;
    private Double lng;
    private String role;
    private String password;
    private Boolean isAdmin;


    public static final class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String address;
        private String city;
        private String postCode;
        private Boolean isAdmin;
        private Double lat;
        private Double lng;
        private String role;
        private String password;


        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder isAdmin(Boolean isAdmin) {
            this.isAdmin = isAdmin;
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

        public Builder postcode(String postcode) {
            this.postCode = postcode;
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

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }


        public AppUserDTO build() {
            AppUserDTO appUserDTO = new AppUserDTO();
            appUserDTO.id = this.id;
            appUserDTO.firstName = this.firstName;
            appUserDTO.lastName = this.lastName;
            appUserDTO.email = this.email;
            appUserDTO.address = this.address;
            appUserDTO.postCode = this.postCode;
            appUserDTO.city = this.city;
            appUserDTO.postCode = this.postCode;
            appUserDTO.lat = this.lat;
            appUserDTO.lng = this.lng;
            appUserDTO.role = this.role;
            appUserDTO.password = this.password;
            appUserDTO.isAdmin = this.isAdmin;
            return appUserDTO;
        }
    }
}
