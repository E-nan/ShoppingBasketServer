-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema shopping_basket
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema shopping_basket
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `shopping_basket` DEFAULT CHARACTER SET utf8 ;
USE `shopping_basket` ;

-- -----------------------------------------------------
-- Table `shopping_basket`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_no` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(100) NOT NULL,
  `user_pw` VARCHAR(100) NOT NULL,
  `user_name` VARCHAR(100) NOT NULL,
  `user_address` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`user_no`)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `shopping_basket`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `item_no` INT NOT NULL AUTO_INCREMENT,
  `item_name` VARCHAR(50) NOT NULL,
  `item_price` DECIMAL(10,0) NOT NULL,
  `item_description` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`item_no`)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `shopping_basket`.`basket`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basket`;
CREATE TABLE `basket` (
  `basket_no` INT NOT NULL AUTO_INCREMENT,
  `user_no` INT NOT NULL,
  `item_no` INT NOT NULL,
  `item_count` INT NOT NULL,
  PRIMARY KEY (`basket_no`),
  CONSTRAINT fk_basket_user_no FOREIGN KEY(user_no) REFERENCES user(user_no),
  CONSTRAINT fk_bakset_item_no FOREIGN KEY(item_no) REFERENCES item(item_no)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `shopping_basket`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_no` INT NOT NULL AUTO_INCREMENT,
  `user_no` INT NOT NULL,
  `item_no` INT NOT NULL,
  `item_count` INT NOT NULL,
  `order_price` DECIMAL(10,0) NOT NULL,
  `order_date` DATETIME NOT NULL,
  PRIMARY KEY (`order_no`),
  CONSTRAINT fk_orders_user_no FOREIGN KEY(user_no) REFERENCES user(user_no),
  CONSTRAINT fk_orders_item_no FOREIGN KEY(item_no) REFERENCES item(item_no)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
