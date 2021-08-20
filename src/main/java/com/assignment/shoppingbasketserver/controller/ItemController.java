package com.assignment.shoppingbasketserver.controller;

import com.assignment.shoppingbasketserver.dao.ItemDao;
import com.assignment.shoppingbasketserver.dto.ItemDto;
import com.assignment.shoppingbasketserver.vo.ItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemDao itemDao;

    /**
     * 상품 등록
     * @param itemVo
     */
    @RequestMapping("/item/insert")
    public void insertItem(ItemVo itemVo){

        ItemDto itemDto = ItemDto.builder()
                .itemName(itemVo.getItemName())
                .itemPrice(itemVo.getItemPrice())
                .itemDescription(itemVo.getItemDescription()).build();

        itemDao.insertItem(itemDto);
    }

    /**
     * 상품 검색(파라미터 값이 없으면 전체 검색)
     * @param itemName
     * @return
     */
    @RequestMapping("/item/select")
    public List<ItemDto> selectItem(@RequestParam(required = false) String itemName){

        List<ItemDto> itemDtoList = itemDao.selectItem(itemName);

        return itemDtoList;
    }

    /**
     * 상품 삭제
     * @param itemNo
     */
    @RequestMapping("item/delete")
    public void deleteItem(@RequestParam Long itemNo){

        itemDao.deleteItem(itemNo);
    }
}
