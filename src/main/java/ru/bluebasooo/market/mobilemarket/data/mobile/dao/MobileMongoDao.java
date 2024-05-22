package ru.bluebasooo.market.mobilemarket.data.mobile.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ru.bluebasooo.market.mobilemarket.data.mobile.MobileDao;
import ru.bluebasooo.market.mobilemarket.data.mobile.entity.MobileEntity;
import ru.bluebasooo.market.mobilemarket.rest.mobile.dto.FilterDto;

import java.util.List;
import java.util.Optional;

@Repository
public class MobileMongoDao implements MobileDao {
    private MongoTemplate template;

    @Override
    public Optional<MobileEntity> find(String id) {
        var query = Query.query(Criteria.where("_id").is(id));

        return Optional.ofNullable(
                template.findOne(query, MobileEntity.class, "src/proto/mobile")
        );
    }

    @Override
    public List<MobileEntity> findAll() {
        return template.findAll(MobileEntity.class);
    }

    @Override
    public List<MobileEntity> findBatch(List<String> ids) {
        var criterias = ids.stream().map(Criteria::where).toList();
        var query = Query.query(new Criteria().orOperator(criterias));

        return template.find(query, MobileEntity.class);
    }
}
