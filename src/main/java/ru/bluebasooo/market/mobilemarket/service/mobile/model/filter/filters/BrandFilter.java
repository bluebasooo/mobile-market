package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import ru.bluebasooo.market.mobilemarket.service.mobile.model.Mobile;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.IncludeExcludeFilter;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MatchableFilter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class BrandFilter implements IncludeExcludeFilter<String>, MatchableFilter {
    private Set<String> includesCompanies = Set.of();
    private Set<String> excludesCompanies = Set.of();

    public BrandFilter(
            Collection<String> include,
            Collection<String> exclude
    ) {
        this.includesCompanies = include == null ? includesCompanies : new HashSet<>(include);
        this.excludesCompanies = exclude == null ? excludesCompanies : new HashSet<>(exclude);
    }

    @Override
    public Collection<String> includes() {
        return includesCompanies;
    }

    @Override
    public Collection<String> excludes() {
        return excludesCompanies;
    }

    @Override
    public boolean isMatch(Mobile mobile) {
        var company = mobile.getBrand();

        return match(company);
    }
}
