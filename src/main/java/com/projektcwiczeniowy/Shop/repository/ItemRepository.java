package com.projektcwiczeniowy.Shop.repository;

import com.projektcwiczeniowy.Shop.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository <Item, Long> {
}
