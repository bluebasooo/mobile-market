package ru.bluebasooo.market.mobilemarket.data.mobile;

import ru.bluebasooo.market.mobilemarket.entity.mobile.MobileEntity;

import java.util.Optional;

public interface MobileDao {
    Optional<MobileEntity> find(String id);
}
