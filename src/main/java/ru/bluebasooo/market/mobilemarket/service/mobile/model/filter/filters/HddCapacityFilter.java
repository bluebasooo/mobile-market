package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import lombok.Value;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.IncludeExcludeFilter;

import java.util.List;

@Value
public class HddCapacityFilter implements IncludeExcludeFilter<Integer> {
    List<Integer> includesHddCapacity;
    List<Integer> excludesHddCapacity;

    @Override
    public List<Integer> includes() {
        return includesHddCapacity;
    }

    @Override
    public List<Integer> excludes() {
        return excludesHddCapacity;
    }
}
