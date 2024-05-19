package ru.bluebasooo.market.mobilemarket.data.mobile.basket;

import ru.bluebasooo.market.mobilemarket.entity.basket.BasketEntity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BasketDao {
    Optional<BasketEntity> find(String id);
    void upsertBatch(Collection<BasketEntity> basketEntities);
}
