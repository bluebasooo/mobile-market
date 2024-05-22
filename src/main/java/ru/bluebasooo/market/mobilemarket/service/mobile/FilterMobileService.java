package ru.bluebasooo.market.mobilemarket.service.mobile;


import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ru.bluebasooo.market.mobilemarket.rest.mobile.dto.FilterDto;

public class FilterMobileService {

    private Query resolveFilter(FilterDto filterDto) {
        var start = Criteria.where();
    }
}
