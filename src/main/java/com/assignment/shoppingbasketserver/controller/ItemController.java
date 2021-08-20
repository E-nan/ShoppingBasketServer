package com.assignment.shoppingbasketserver.controller;

import com.assignment.shoppingbasketserver.dao.ItemDao;
import com.assignment.shoppingbasketserver.dto.ItemDto;
import com.assignment.vo.ItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemDao itemDao;

    @RequestMapping("/item/insert")
    public void insertItem(ItemVo itemVo){

        ItemDto itemDto = ItemDto.builder()
                .item_name(itemVo.getItem_name())
                .item_price(itemVo.getItem_price())
                .item_description(itemVo.getItem_description()).build();

        itemDao.insertItem(itemDto);
    }

    @RequestMapping("/item/select")
    public List<ItemDto> selectItem(@RequestParam(required = false) String item_name){

        List<ItemDto> itemDtoList = itemDao.selectItem(item_name);

        return itemDtoList;
    }

    @RequestMapping("item/delete")
    public void deleteItem(@RequestParam Long item_no){

        itemDao.deleteItem(item_no);
    }
}
