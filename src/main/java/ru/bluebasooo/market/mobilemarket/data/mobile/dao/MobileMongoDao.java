package ru.bluebasooo.market.mobilemarket.data.mobile.dao;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ru.bluebasooo.market.mobilemarket.data.mobile.MobileDao;
import ru.bluebasooo.market.mobilemarket.data.mobile.entity.MobileEntity;
import ru.bluebasooo.market.mobilemarket.rest.mobile.dto.FilterDto;

import java.util.List;
import java.util.Optional;

public class MobileMongoDao implements MobileDao {
    private MongoTemplate template;

    @Override
    public List<MobileEntity> findMobile() {
        return List.of();
    }

    @Override
    public Optional<MobileEntity> find(String id) {
        var query = Query.query(Criteria.where("_id").is(id));

        return Optional.ofNullable(
                template.findOne(query, MobileEntity.class, "src/proto/mobile")
        );
    }

    private Query filterResolve(FilterDto filterDto) {

    }
}
