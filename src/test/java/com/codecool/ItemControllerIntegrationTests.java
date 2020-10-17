package com.codecool;


import com.codecool.model.AppUser;
import com.codecool.model.Category;
import com.codecool.model.Item;
import com.codecool.modelDTO.AppUserDTO;
import com.codecool.modelDTO.ItemDTO;
import com.codecool.service.ItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppTestConfig.class})
@WebAppConfiguration
public class ItemControllerIntegrationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Autowired
    private ItemService itemService;


    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void should_return_item_by_id() throws Exception {
        Long id = 1L;
        when(itemService.findById(id))
                .thenReturn(new Item.Builder()
                .name("Item")
                .price(13.99)
                .picUrl("picture")
                .description("Example")
                .build()
                );

        mockMvc.perform(get("/api/items/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("Item"))
                .andExpect(jsonPath("$.description").value("Example"))
                .andExpect(jsonPath("$.picUrl").value("picture"))
                .andExpect(jsonPath("$.price").value(13.99));

    }
    @Test
    public void should_return_created_status_code_when_item_added() throws Exception {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setName("Item");
        itemDTO.setPrice(13.99);
        itemDTO.setPicUrl("picture.jpg");


        mockMvc.perform(post("/api/items")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(itemDTO))
        ).andExpect(status().isCreated());
        verify(itemService, times(1)).addItem(any(Item.class));
    }

    @Test
    public void should_return_no_content_status_code_when_item_deleted() throws Exception {
        mockMvc.perform(delete("/api/items/{id}", 1))
                .andExpect(status().isNoContent());
    }

    @Test
    public void should_return_OK_status_code_when_item_updated() throws Exception {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setName("Item");
        itemDTO.setPrice(13.99);
        itemDTO.setPicUrl("picture.jpg");



        mockMvc.perform(put("/api/items")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(itemDTO)))
                .andExpect(status().isOk());
    }


}
