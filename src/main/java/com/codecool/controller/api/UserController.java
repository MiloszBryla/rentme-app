package com.codecool.controller.api;

import com.codecool.converter.AppUserConverter;
import com.codecool.model.AppUser;
import com.codecool.modelDTO.ItemForListDTO;
import com.codecool.modelDTO.UserAddressDTO;
import com.codecool.modelDTO.AppUserDTO;
import com.codecool.modelDTO.UserNameDTO;
import com.codecool.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;


@Controller
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/admins", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public List<AppUserDTO> getAllAdmins() {
        return AppUserConverter.entitiesToDTO(userService.getAllAdmins());
    }

    @GetMapping(value = "/renters", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public List<AppUserDTO> getAllRenters() {
        return AppUserConverter.entitiesToDTO(userService.getAllRenters());
    }

    @GetMapping(value = "/renters/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public AppUserDTO findUserById(@PathVariable("id") Long id) {
        return AppUserConverter.entityToDTO(userService.getUserById(id));
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @GetMapping(value = "/renters", params = "email", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public AppUserDTO findUserByEmail(@RequestParam(value="email") String email) {
        return AppUserConverter.entityToDTO(userService.getUserByEmail(email));
    }

    @GetMapping(value = "/admins/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public AppUserDTO findAdminById(@PathVariable("id") Long id) {
        return AppUserConverter.entityToDTO(userService.getUserById(id));
    }


    @GetMapping(value = "/address", params = "byItemId", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public UserAddressDTO findUserAddressByItemId(@RequestParam(value="byItemId") Long itemId) {
        return userService.getUserAddressByItemId(itemId);
    }


    @GetMapping(params = "byItemId", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public UserNameDTO findUserNameByItemId(@RequestParam(value="byItemId") Long itemId) {
        return userService.getUserNameByItemId(itemId);
    }


    @PostMapping()
    @ResponseBody
    @ResponseStatus(CREATED)
    public ResponseEntity<Object> attemptToAddUser(@RequestBody AppUserDTO appUserDTO) {

        if (userService.checkIfEmailAlreadyExist(appUserDTO)) {
            return ResponseEntity.status(CONFLICT).body("Email is already in use");
        } else {
            userService.addUser(AppUserConverter.DTOtoEntity(appUserDTO));
            return ResponseEntity.status(CREATED).body("Account has been created.");
        }
    }


    @PutMapping
    @ResponseBody
    @ResponseStatus(OK)
    public void updateUser(@RequestBody AppUser appUser) {
        userService.updateUser(appUser);
    }


    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(NO_CONTENT)
    public void deleteAppUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
    }

}
