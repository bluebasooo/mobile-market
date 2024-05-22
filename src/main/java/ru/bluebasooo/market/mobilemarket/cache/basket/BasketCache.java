package ru.bluebasooo.market.mobilemarket.cache.basket;

import ru.bluebasooo.market.mobilemarket.cache.BaseCache;
import ru.bluebasooo.market.mobilemarket.data.basket.BasketDao;
import ru.bluebasooo.market.mobilemarket.data.basket.entity.BasketEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BasketCache { //TODO interface
    private final BasketDao basketDao;
    private final BaseCache<String, BasketEntity> cache;
    private final ExecutorService executorService;

    public BasketCache(
            BasketDao basketDao
    ) {
        this.basketDao = basketDao;
        this.cache = new BaseCache<>();
        this.executorService = Executors.newFixedThreadPool(2);
    }

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

        return basket;
    }

    private void fetchBaskets() {
        basketDao.upsertBatch(cache.getOld());
    }

}
