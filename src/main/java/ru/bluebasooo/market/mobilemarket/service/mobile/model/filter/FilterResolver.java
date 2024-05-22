package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters.AccumulatorCapacityFilter;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters.BrandFilter;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters.DiagonalScreenFilter;

public class FilterResolver {

    public Query resolveFilter(Filter filter) {

    }

    private Criteria accumulatorCapacity(AccumulatorCapacityFilter filter) {
        var bigger = Criteria.where("mobileInfo.accumulatorInfo.batteryCapacity").gte(filter.min());
        var less = Criteria.where("mobileInfo.accumulatorInfo.batteryCapacity").lte(filter.max());

        return bigger.andOperator(less);
    }

    private Criteria brand(BrandFilter filter) {
        var include = Criteria.where("brand").in(filter.includes());
        var exclude = Criteria.where("brand").not().in(filter.excludes());

        return include.andOperator(exclude);
    }

    private Criteria diagonalScreen(DiagonalScreenFilter filter) {
        var min = Criteria.where("mobileInfo");
        return null;
    }

    

}
