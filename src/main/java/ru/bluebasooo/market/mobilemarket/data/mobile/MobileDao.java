package ru.bluebasooo.market.mobilemarket.data.mobile;

import ru.bluebasooo.market.mobilemarket.data.mobile.entity.MobileEntity;

import java.util.List;
import java.util.Optional;

public interface MobileDao {
    Optional<MobileEntity> find(String id);

    List<MobileEntity> findAll();

    List<MobileEntity> findBatch(List<String> ids);
}
