package com.codecool.service;

import com.codecool.dao.UserRepository;
import com.codecool.model.AppUser;
import com.codecool.modelDTO.UserAddressDTO;
import com.codecool.modelDTO.UserNameDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        given(userRepository.findAll()).willReturn(prepareMockData());
        when(userRepository.findAppUserAddressByItemId(1)).thenReturn(prepareUserAddress());
        when(userRepository.findAppUserNmeByItemId(1)).thenReturn(prepareFullUserName());
    }

    @Test
    public void should_return_all_users() {
        //when:
        List<AppUser> users = userService.getAllAppUsers();

        //then:
        Assertions.assertEquals(4, users.size());
        Assertions.assertEquals("Joanna", users.get(0).getFirstName());
        Assertions.assertEquals("Miłosz", users.get(2).getFirstName());

    }


    @Test
    public void should_return_only_when_IsAdmin_is_true() {
        //when:
        List<AppUser> admins = userService.getAllAdmins();

        //then:
        Assertions.assertEquals(2, admins.size());
        Assertions.assertEquals("Joanna", admins.get(0).getFirstName());
        Assertions.assertEquals("Miłosz", admins.get(1).getFirstName());
        Assertions.assertEquals(2, admins.size());
    }


    @Test
    public void should_return_only_when_IsAdmin_is_false() {
        //when:
        List<AppUser> admins = userService.getAllRenters();

        //then:
        Assertions.assertEquals(2, admins.size());
        Assertions.assertEquals("Rafał", admins.get(0).getFirstName());
        Assertions.assertEquals("Michał", admins.get(1).getFirstName());
        Assertions.assertEquals(2, admins.size());
    }

    @Test
    public void should_return_user_addressDTO_when_item_id_is_passed() {

        //when:
        UserAddressDTO userAddressDTO = userService.getUserAddressByItemId(1);

        //then:
        verify(userRepository, times(1)).findAppUserAddressByItemId(1);
        Assertions.assertEquals("Kraków", userAddressDTO.getCity());
        Assertions.assertEquals("Karmelicka 9", userAddressDTO.getAddress());
    }


    @Test
    public void should_return_user_nameDTO_when_item_id_is_passed() {

        //when:
        UserNameDTO userNameDTO = userService.getUserNameByItemId(1);

        //then:
        verify(userRepository, times(1)).findAppUserNmeByItemId(1);
        Assertions.assertEquals("Jan", userNameDTO.getFirstName());
        Assertions.assertEquals("Truskolaski", userNameDTO.getLastName());

    }

    private List<AppUser> prepareMockData() {
        AppUser appUser1 = new AppUser.Builder()
                .firstName("Joanna")
                .isAdmin(true)
                .email("jbrzuchacz@gmail.com")
                .build();

        AppUser appUser2 = new AppUser.Builder()
                .firstName("Rafał")
                .isAdmin(false)
                .build();
        AppUser appUser3 = new AppUser.Builder()
                .firstName("Miłosz")
                .isAdmin(true)
                .build();

        AppUser appUser4 = new AppUser.Builder()
                .firstName("Michał")
                .isAdmin(false)
                .build();

        return Arrays.asList(appUser1, appUser2, appUser3, appUser4);
    }

    private String[] prepareUserAddress() {
        return new String[]{"Karmelicka 9,Kraków,31-807", ""};
    }

    private String prepareFullUserName() {
        return "Jan,Truskolaski";
    }
}