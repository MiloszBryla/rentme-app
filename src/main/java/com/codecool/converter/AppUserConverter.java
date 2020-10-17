package com.codecool.converter;

import com.codecool.model.AppUser;
import com.codecool.modelDTO.AppUserDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppUserConverter {

    public static AppUserDTO entityToDTO(AppUser appUser) {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setId(appUser.getId());
        appUserDTO.setFirstName(appUser.getFirstName());
        appUserDTO.setLastName(appUser.getLastName());
        appUserDTO.setEmail(appUser.getEmail());
        appUserDTO.setAddress(appUser.getAddress());
        appUserDTO.setPostCode(appUser.getPostCode());
        appUserDTO.setCity(appUser.getCity());
        appUserDTO.setIsAdmin(appUser.getIsAdmin());
        appUserDTO.setLat(appUser.getLat());
        appUserDTO.setLng(appUser.getLng());
        return appUserDTO;
    }

    public static List<AppUserDTO> entitiesToDTO(List<AppUser> appUsers) {
        return appUsers.stream()
                .map(AppUserConverter::entityToDTO)
                .collect(Collectors.toList());
    }


    public static AppUser DTOtoEntity(AppUserDTO appUserDTO) {
        AppUser appUser = new AppUser();
        appUser.setId(appUserDTO.getId());
        appUser.setFirstName(appUserDTO.getFirstName());
        appUser.setLastName(appUserDTO.getLastName());
        appUser.setEmail(appUserDTO.getEmail());
        appUser.setAddress(appUserDTO.getAddress());
        appUser.setPostCode(appUserDTO.getPostCode());
        appUser.setCity(appUserDTO.getCity());
        appUser.setLat(appUserDTO.getLat());
        appUser.setLng(appUserDTO.getLng());
        appUser.setEmail(appUserDTO.getEmail());
        appUser.setPostCode(appUserDTO.getPostCode());
        appUser.setRole(appUserDTO.getRole());
        appUser.setPassword(appUserDTO.getPassword());
        appUser.setIsAdmin(appUserDTO.getIsAdmin());
        return appUser;
    }

}

