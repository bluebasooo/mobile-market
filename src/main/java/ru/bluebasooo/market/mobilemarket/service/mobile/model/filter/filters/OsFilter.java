package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import lombok.Value;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.IncludeExcludeFilter;

import java.util.List;

@Value
public class OsFilter implements IncludeExcludeFilter<String> {
    List<String> includeOs;
    List<String> excludeOs;

    @Override
    public List<String> includes() {
        return includeOs;
    }

    @Override
    public List<String> excludes() {
        return excludeOs;
    }
}
