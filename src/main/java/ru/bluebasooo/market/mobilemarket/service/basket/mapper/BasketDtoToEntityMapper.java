package ru.bluebasooo.market.mobilemarket.service.basket.mapper;

import org.springframework.stereotype.Component;
import ru.bluebasooo.market.mobilemarket.data.basket.entity.BasketEntity;
import ru.bluebasooo.market.mobilemarket.rest.basket.dto.BasketResponse;
import ru.bluebasooo.market.mobilemarket.rest.basket.dto.BasketUpdateRequest;
import ru.bluebasooo.market.mobilemarket.rest.basket.dto.ProductDto;

import java.util.List;

@Component
public class BasketDtoToEntityMapper {

    public BasketEntity toEntity(String id, BasketUpdateRequest basketDto) {
        return new BasketEntity(id, basketDto.getProductsId());
    }

    public BasketResponse toDto(List<ProductDto> products) {
        return new BasketResponse(products);
    }

}
