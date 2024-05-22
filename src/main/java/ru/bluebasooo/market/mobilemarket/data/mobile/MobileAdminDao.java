package ru.bluebasooo.market.mobilemarket.data.mobile;

import ru.bluebasooo.market.mobilemarket.data.mobile.entity.MobileEntity;

import java.util.List;
import java.util.Optional;

public interface MobileAdminDao {
    void create(MobileEntity entity);
    void update(MobileEntity updateForEntity);
    void delete(String id);
    List<MobileEntity> findAll();
    Optional<MobileEntity> find(String id);
}
