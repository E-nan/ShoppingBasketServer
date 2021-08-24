# ShoppingBasketServer
스프링 부트 장바구니 서버입니다.

유저API를 통해서 회원가입을 할 수 있고, 상품API를 통해서 상품을 등록할 수 있습니다.
가입된 유저가 등록된 상품을 장바구니에 담고, 장바구니에 담긴 상품을 삭제 및 조회할 수 있으며, 장바구니에 담긴 상품을 주문할 수 있습니다.
주문하면 장바구니에서 상품이 사라지게되고, 주문내역으로 이동합니다.

## API 명세서

## 유저API
- 회원가입: `/user`
  - Method: **POST**
  - Param: -
  - Body: UserVo
    - `userId` 👉 String, 유저 아이디
    - `userPw` 👉 String, 유저 비밀번호
    - `userName` 👉 String, 유저 이름
    - `userAddress` 👉 String, 유저 주소

- 회원검색: `/user` or `/user/{userId}`
  - Method: **GET**
  - Param:
    - `userId` 👉 String, 유저 아이디, required = false
  - Body: -

- 회원탈퇴: `/user`
  - Method: **DELETE**
  - Param:
    - `userNo` 👉 String, 유저 번호
  - Body: -

## 상품API
- 상품등록: `/item`
  - Method: **POST**
  - Param: -
  - Body: ItemVo
    - `itemName` 👉 String, 상품 이름
    - `itemPrice` 👉 BigDecimal, 상품 가격
    - `itemDescription` 👉 String, 상품 설명

- 상품검색: `/item` or `/item/{itemId}`
  - Method: **GET**
  - Param:
    - `itemName` 👉 String, 상품 이름, required = false
  - Body: -

- 상품제거: `/item`
  - Method: **DELETE**
  - Param:
    - `itemNo` 👉 String, 상품 번호
  - Body: -

## 장바구니API
- 상품등록: `/basket`
  - Method: **POST**
  - Param: -
  - Body: BasketVo
    - `userNo` 👉 Integer, 유저 번호
    - `itemNo` 👉 Integer, 상품 번호

- 상품검색: `/basket`
  - Method: **GET**
  - Param: -
  - Body: BasketVo (required = false)
    - `userNo` 👉 Integer, 유저 번호
    - `itemNo` 👉 Integer, 상품 번호

- 상품제거: `/basket`
  - Method: **DELETE**
  - Param: -
  - Body: BasketVo, (required = false)
    - `userNo` 👉 Integer, 유저 번호
    - `itemNo` 👉 Integer, 상품 번호

## 주문API
- 장바구니 주문: `/orders`
  - Method: **POST**
  - Param: -
  - Body: BasketVo
    - `userNo` 👉 Integer, 유저 번호
    - `itemNo` 👉 Integer, 상품 번호

- 주문내역: `/orders`
  - Method: **GET**
  - Param: -
  - Body: OrdersVo
    - `orderNo` 👉 String, 주문 번호
    - `userNo` 👉 Integer, 유저 번호

- 주문내역 제거: `/orders`
  - Method: **DELETE**
  - Param: -
  - Body: OrdersVo
    - `orderNo` 👉 String, 주문 번호
    - `userNo` 👉 Integer, 유저 번호
