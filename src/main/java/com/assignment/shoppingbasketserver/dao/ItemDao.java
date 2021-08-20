package com.assignment.shoppingbasketserver.dao;

import com.assignment.shoppingbasketserver.dto.ItemDto;
import com.assignment.shoppingbasketserver.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItemDao {

    void insertItem(ItemDto itemDto);
    List<ItemDto> selectItem(String itemName);
    void deleteItem(Long itemNo);
}
