package com.assignment.shoppingbasketserver.dao;

import com.assignment.shoppingbasketserver.dto.ItemDto;
import com.assignment.shoppingbasketserver.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItemDao {

    int insertItem(ItemDto itemDto);
    ItemDto selectItemByNo(int itemNo);
    ItemDto selectItemByName(String itemName);
    List<ItemDto> selectItemLikeName(String itemName);
    int deleteItem(int itemNo);
}
