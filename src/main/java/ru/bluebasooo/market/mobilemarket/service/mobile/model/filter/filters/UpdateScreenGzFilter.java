package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import lombok.Value;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.IncludeExcludeFilter;

import java.util.List;

@Value
public class UpdateScreenGzFilter implements IncludeExcludeFilter<Integer> {
    List<Integer> includeUpdateScreenGz;
    List<Integer> excludeUpdateScreenGz;

    @Override
    public List<Integer> includes() {
        return includeUpdateScreenGz;
    }

    @Override
    public List<Integer> excludes() {
        return excludeUpdateScreenGz;
    }
}
