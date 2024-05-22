package ru.bluebasooo.market.mobilemarket.rest.basket.dto;

import lombok.Value;

import java.util.List;

@Value
public class BasketUpdateRequest {
    List<String> productsId;
}
