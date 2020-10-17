package com.codecool.dao;

import com.codecool.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

@Repository
public interface ItemRepository  extends JpaRepository<Item, Long> {
    Item getItemById(Long id);

    @Query("Select i from Item i where upper(i.name) like %:searchPhrase%")
    List<Item> findItemsByNameContaining (String searchPhrase);

    @Query("select i from Item i left join i.category c where upper(i.category.description) like %:searchPhrase%")
    List<Item> findItemsByCategory (String searchPhrase);

    @Query("select i from Item i left join i.owner u where i.owner.id = :userId")
    List<Item> findItemsByUser (Long userId);

}


