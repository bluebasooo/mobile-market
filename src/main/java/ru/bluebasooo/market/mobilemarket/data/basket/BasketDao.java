package ru.bluebasooo.market.mobilemarket.data.basket;

import ru.bluebasooo.market.mobilemarket.data.basket.entity.BasketEntity;

import java.util.Collection;
import java.util.Optional;

public interface BasketDao {
    Optional<BasketEntity> find(String id);
    void upsertBatch(Collection<BasketEntity> basketEntities);
}
