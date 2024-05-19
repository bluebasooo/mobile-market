package ru.bluebasooo.market.mobilemarket.cache.basket;

import ru.bluebasooo.market.mobilemarket.cache.BaseCache;
import ru.bluebasooo.market.mobilemarket.data.mobile.basket.BasketDao;
import ru.bluebasooo.market.mobilemarket.entity.basket.BasketEntity;

import java.util.Map;
import java.util.concurrent.ExecutorService;

public class BasketCache { //TODO interface
    //TODO executor
    private BasketDao basketDao;
    private BaseCache<String, BasketEntity> cache;
    private ExecutorService executorService;

    //TODO Lru map which batches updates
    public BasketCache() {}

    public BasketEntity getBasket(String id) {
        if (cache.contains(id)) {
            return cache.get(id);
        }

        var basket = basketDao.find(id)
                .orElseThrow(() -> new RuntimeException("Basket not found")); //TODO custom exception

        cache.put(id, basket);

        if (cache.getOldSize() > 50) {
            executorService.submit(this::fetchBaskets);
        }
    }

    private void fetchBaskets() {
        basketDao.upsertBatch(cache.getOld());
    }

}