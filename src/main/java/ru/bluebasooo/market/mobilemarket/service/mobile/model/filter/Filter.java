package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter;

import lombok.Value;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.Mobile;

import java.util.List;

@Value
public class Filter {
    List<MatchableFilter> filters;

    public boolean isMatch(Mobile mobile) {
        if (filters == null) return true;

        return filters.stream()
                .allMatch((filter) -> filter.isMatch(mobile));
    }
}
