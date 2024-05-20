package ru.bluebasooo.market.mobilemarket.data.mobile.dao;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import ru.bluebasooo.market.mobilemarket.data.mobile.MobileAdminDao;
import ru.bluebasooo.market.mobilemarket.data.mobile.entity.mobile.MobileEntity;

import java.util.List;
import java.util.Optional;

public class MobileMongoAdminDao implements MobileAdminDao {

    private MongoTemplate template;

    @Override
    public void create(MobileEntity entity) {
        template.insert(entity, "src/proto/mobile");
    }

    @Override
    public void update(MobileEntity updateForEntity) {
        var query = Query.query(Criteria.where("_id").is(updateForEntity.getId()));
        var updateQuery = new Update()
                .set("price", updateForEntity.getPrice())
                .set("mobileInfo", updateForEntity.getMobileInfo())
                .set("imgUrls", updateForEntity.getImgUrls());

        template.updateFirst(query, updateQuery, MobileEntity.class, "src/proto/mobile");
    }

    @Override
    public void delete(String id) {
        var query = Query.query(Criteria.where("_id").is(id));

        template.remove(query, MobileEntity.class, "src/proto/mobile");
    }

    @Override
    public List<MobileEntity> findAll() {
        return template.findAll(MobileEntity.class, "src/proto/mobile");
    }

    @Override
    public Optional<MobileEntity> find(String id) {
        var query = Query.query(Criteria.where("_id").is(id));

        return Optional.ofNullable(
                template.findOne(query, MobileEntity.class, "src/proto/mobile")
        );
    }
}
