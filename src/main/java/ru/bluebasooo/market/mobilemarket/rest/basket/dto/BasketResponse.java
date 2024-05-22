package ru.bluebasooo.market.mobilemarket.rest.basket.dto;

import lombok.Value;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.Mobile;

import java.util.List;

@Value
public class BasketResponse {
    List<ProductDto> mobiles;
}
