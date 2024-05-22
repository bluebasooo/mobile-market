package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import lombok.Value;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.IncludeExcludeFilter;

import java.util.List;

@Value
public class RamCapacityFilter implements IncludeExcludeFilter<Integer> {

    List<Integer> includeRamCapacity;
    List<Integer> excludeRamCapacity;

    @Override
    public List<Integer> includes() {
        return includeRamCapacity;
    }

    @Override
    public List<Integer> excludes() {
        return excludeRamCapacity;
    }
}
