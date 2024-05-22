package ru.bluebasooo.market.mobilemarket.service.basket;

import org.springframework.stereotype.Service;
import ru.bluebasooo.market.mobilemarket.cache.basket.BasketCache;
import ru.bluebasooo.market.mobilemarket.data.basket.BasketDao;
import ru.bluebasooo.market.mobilemarket.data.basket.entity.BasketEntity;
import ru.bluebasooo.market.mobilemarket.rest.basket.dto.BasketResponse;
import ru.bluebasooo.market.mobilemarket.rest.basket.dto.BasketUpdateRequest;
import ru.bluebasooo.market.mobilemarket.rest.basket.dto.ProductDto;
import ru.bluebasooo.market.mobilemarket.service.basket.mapper.BasketDtoToEntityMapper;
import ru.bluebasooo.market.mobilemarket.service.mobile.MobileReadService;

import java.util.List;

@Service
public class BasketService {

    private final BasketCache cache;
    private final BasketDtoToEntityMapper mapper;
    private final MobileReadService mobileService;

    public BasketService(
            BasketDao basketDao,
            BasketDtoToEntityMapper mapper,
            MobileReadService mobileService
    ) {
        this.cache = new BasketCache(basketDao);
        this.mapper = mapper;
        this.mobileService = mobileService;
    }

    public void updateBasket(String id, BasketUpdateRequest basketDto) {
        var basket = mapper.toEntity(id, basketDto);

        cache.update(basket);
    }

    public void cleanBasket(String id) {
        cache.update(new BasketEntity(id, List.of()));
    }

    public BasketResponse readBasket(String id) {
        var basket = cache.get(id);
        var mobiles = mobileService.findMobilesById(basket.getProductId())
                .stream()
                .map(mobile -> new ProductDto(mobile.getName(), mobile.getPrice(), true))
                .toList();

        return new BasketResponse(mobiles);
    }

}
