package com.assignment.shoppingbasketserver.controller;

import com.assignment.shoppingbasketserver.dao.BasketDao;
import com.assignment.shoppingbasketserver.dto.BasketDto;
import com.assignment.shoppingbasketserver.dto.BasketJoinItemDto;
import com.assignment.shoppingbasketserver.util.Message;
import com.assignment.shoppingbasketserver.vo.BasketVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    private BasketDao basketDao;

    @RequestMapping("/insert")
    public ResponseEntity<Message> insertBasket(BasketVo basketVo){

        Message message = new Message();
        HttpStatus httpStatus = null;

        List<BasketDto> basketDtoList = basketDao.selectBasket(basketVo);

        if(basketDtoList.size() != 0){
            BasketDto basketDto = basketDtoList.get(0);

            int result = basketDao.updateBasket(basketDto);

            if(result != 0){
                List<BasketDto> basketUpdateDtoList = basketDao.selectBasket(basketVo);
                BasketDto basketUpdateDto = basketUpdateDtoList.get(0);

                message.setMessage("기존 장바구니 상품 개수 증가 성공");
                message.setData(basketUpdateDto);
                httpStatus = HttpStatus.OK;
            }
            else{
                message.setMessage("기존 장바구니 상품 개수 증가 실패");
                message.setData(null);
                httpStatus = HttpStatus.BAD_REQUEST;
            }
        }
        else{
            BasketDto basketDto = BasketDto.builder()
                    .userNo(basketVo.getUserNo())
                    .itemNo(basketVo.getItemNo())
                    .build();

            int result = basketDao.insertBasket(basketDto);

            if(result != 0){
                message.setMessage("장바구니 상품 추가 성공");
                message.setData(basketDto);
                httpStatus = HttpStatus.OK;
            }
            else{
                message.setMessage("장바구니 상품 추가 실패");
                message.setData(basketDto);
                httpStatus = HttpStatus.BAD_REQUEST;
            }
        }

        return new ResponseEntity<>(message, httpStatus);
    }

    @RequestMapping("/select")
    public ResponseEntity<Message> selectBasket(BasketVo basketVo){

        Message message = new Message();
        HttpStatus httpStatus = null;

        if(basketVo.getUserNo() == null){
            message.setMessage("회원번호값 오류");
            message.setData(basketVo);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        else{
            List<BasketJoinItemDto> basketJoinItemDtoList = basketDao.selectBasketJoinItem(basketVo);

            message.setMessage("장바구니 조회 성공");
            message.setData(basketJoinItemDtoList);
            httpStatus = HttpStatus.OK;
        }

        return new ResponseEntity<>(message, httpStatus);
    }

    // 다중 삭제 고려 수정 예정
    @RequestMapping("/delete")
    public ResponseEntity<Message> deleteBasket(BasketVo basketvo){

        Message message = new Message();
        HttpStatus httpStatus = null;

        List<BasketDto> basketDtoList = basketDao.selectBasket(basketvo);

        if(basketDtoList.size() == 0){
            message.setMessage("삭제할 장바구니 없음");
            message.setData(basketvo);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        else{
            basketDao.deleteBasket(basketvo);

            message.setMessage("장바구니 삭제 성공");
            message.setData(basketDtoList);
            httpStatus = HttpStatus.OK;
        }

        return new ResponseEntity<>(message, httpStatus);
    }
}
