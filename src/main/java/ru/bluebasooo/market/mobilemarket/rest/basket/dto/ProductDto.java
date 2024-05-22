package ru.bluebasooo.market.mobilemarket.rest.basket.dto;

import lombok.Value;

@Value
public class ProductDto {
    String name;
    Double price;
    Boolean inOrder;
}
