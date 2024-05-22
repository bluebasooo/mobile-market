package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import lombok.Value;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.IncludeExcludeFilter;

import java.util.List;

@Value
public class BrandFilter implements IncludeExcludeFilter<String> {
    List<String> includesCompanies;
    List<String> excludesCompanies;

    @Override
    public List<String> includes() {
        return includesCompanies;
    }

    @Override
    public List<String> excludes() {
        return excludesCompanies;
    }
}
