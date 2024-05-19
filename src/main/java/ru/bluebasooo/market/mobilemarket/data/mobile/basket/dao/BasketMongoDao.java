package ru.bluebasooo.market.mobilemarket.data.mobile.basket.dao;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ru.bluebasooo.market.mobilemarket.data.mobile.basket.BasketDao;
import ru.bluebasooo.market.mobilemarket.entity.basket.BasketEntity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class BasketMongoDao implements BasketDao {

    private MongoTemplate template;

    @Override
    public Optional<BasketEntity> find(String id) {
        var query = Query.query(Criteria.where("_id").is(id));

        return Optional.ofNullable(
                template.findOne(query, BasketEntity.class, "baskets")
        );
    }

    @Override
    public void upsertBatch(Collection<BasketEntity> basketEntities) {
        template.insertAll(basketEntities); //TODO upsert many
    }
}
