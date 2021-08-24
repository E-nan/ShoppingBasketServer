package com.assignment.shoppingbasketserver.controller;

import com.assignment.shoppingbasketserver.dao.ItemDao;
import com.assignment.shoppingbasketserver.dto.ItemDto;
import com.assignment.shoppingbasketserver.util.Message;
import com.assignment.shoppingbasketserver.vo.ItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemDao itemDao;

    /**
     * 상품 등록
     * @param itemVo
     * @return 성공, 실패 여부에 따라 메시지 및 결과 리턴
     */
    @RequestMapping("/insert")
    public ResponseEntity<Message> insertItem(ItemVo itemVo){

        Message message = new Message();
        HttpStatus httpStatus = null;

        ItemDto itemCheckDto = itemDao.selectItemByName(itemVo.getItemName());

        if(itemCheckDto != null){
            message.setMessage("이미 존재하는 상품명입니다.");
            message.setData(itemCheckDto);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        else{
            ItemDto itemDto = ItemDto.builder()
                    .itemName(itemVo.getItemName())
                    .itemPrice(itemVo.getItemPrice())
                    .itemDescription(itemVo.getItemDescription()).build();

            int result = itemDao.insertItem(itemDto);

            if(result != 0){
                message.setMessage("상품 등록 성공하셨습니다.");
                message.setData(itemDto);
                httpStatus = HttpStatus.OK;
            }
            else{
                message.setMessage("상품 등록 실패하셨습니다.");
                message.setData(null);
                httpStatus = HttpStatus.BAD_REQUEST;
            }
        }

        return new ResponseEntity<>(message, httpStatus);
    }

    /**
     * 상품 검색(파라미터 값이 없으면 전체 검색)
     * @param itemName
     * @return 성공, 실패 여부에 따라 메시지 및 결과 리턴
     */
    @RequestMapping("/select")
    public ResponseEntity<Message> selectItem(@RequestParam(required = false) String itemName){

        Message message = new Message();
        HttpStatus httpStatus = null;

        List<ItemDto> itemDtoList = itemDao.selectItemLikeName(itemName);

        if(itemDtoList.size() == 0){
            message.setMessage("조건에 맞는 상품이 없습니다.");
            message.setData("입력한 상품 이름 : " + itemName);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        else{
            message.setMessage("상품 목록 조회에 성공하셨습니다.");
            message.setData(itemDtoList);
            httpStatus = HttpStatus.OK;
        }

        return new ResponseEntity<>(message, httpStatus);
    }

    /**
     * 상품 삭제
     * @param itemNo
     * @return 성공, 실패 여부에 따라 메시지 및 결과 리턴
     */
    @RequestMapping("/delete")
    public ResponseEntity<Message> deleteItem(@RequestParam Long itemNo){

        Message message = new Message();
        HttpStatus httpStatus = null;

        ItemDto itemCheckDto = itemDao.selectItemByNo(itemNo);

        if(itemCheckDto == null){
            message.setMessage("존재하지 않는 상품입니다.");
            message.setData("입력한 상품번호 : " + itemNo);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        else{
            int result = itemDao.deleteItem(itemNo);

            if(result != 0){
                message.setMessage("상품 삭제 성공");
                message.setData(itemCheckDto);
                httpStatus = HttpStatus.OK;
            }
            else{
                message.setMessage("상품 삭제 실패");
                message.setData(itemCheckDto);
                httpStatus = HttpStatus.BAD_REQUEST;
            }
        }

        return new ResponseEntity<>(message, httpStatus);
    }
}
