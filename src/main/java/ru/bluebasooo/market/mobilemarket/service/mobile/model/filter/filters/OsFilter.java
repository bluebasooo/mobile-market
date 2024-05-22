package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import ru.bluebasooo.market.mobilemarket.service.mobile.model.Mobile;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.IncludeExcludeFilter;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MatchableFilter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class OsFilter implements IncludeExcludeFilter<String>, MatchableFilter {
    private Set<String> includeOs = Set.of();
    private Set<String> excludeOs = Set.of();

    public OsFilter(
            Collection<String> include,
            Collection<String> exclude
    ) {
        this.includeOs = include == null ? includeOs : new HashSet<>(include);
        this.excludeOs = exclude == null ? excludeOs : new HashSet<>(exclude);
    }

    @Override
    public Collection<String> includes() {
        return includeOs;
    }

    @Override
    public Collection<String> excludes() {
        return excludeOs;
    }

    @Override
    public boolean isMatch(Mobile mobile) {
        var os = mobile.getMobileInfo().getOsInfoEntity().getOsName();

        return match(os);
    }
}
