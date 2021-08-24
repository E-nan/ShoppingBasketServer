# ShoppingBasketServer
스프링 부트 장바구니 서버

## API 명세서
### 유저API
- 회원가입(/user/insert)
- 파라미터: userId, userPw, userName, userAddress

- 회원검색(/user/select)
- 파라미터: userId

- 회원탈퇴(/user/delete)
- 파라미터: userNo

### 상품API
- 상품등록(/item/insert)
- 파라미터: itemName, itemPrice, itemDescription

- 상품검색(/item/select)
- 파라미터: itemName

- 상품제거(/item/delete)
- 파라미터: itemNo

### 장바구니API
- 장바구니 담기(/basket/insert)
- 파라미터: 

- 장바구니 검색(/basket/select)
- 파라미터:

- 장바구니 제거(/basket/delete)
- 파라미터:

### 주문API
- 장바구니상품 주문하기(/orders/insert)
- 파라미터:

- 주문내역 검색(/orders/select)
- 파라미터:

- 주문내역 제거(/orders/delete)
- 파라미터:
