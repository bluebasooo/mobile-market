package ru.bluebasooo.market.mobilemarket.data.mobile;

import ru.bluebasooo.market.mobilemarket.data.mobile.entity.mobile.MobileEntity;

import java.util.List;

public interface MobileAdminDao extends MobileDao {
    void create(MobileEntity entity);
    void update(MobileEntity updateForEntity);
    void delete(String id);
    List<MobileEntity> findAll();
}
