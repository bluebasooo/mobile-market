package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import ru.bluebasooo.market.mobilemarket.service.mobile.model.Mobile;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.IncludeExcludeFilter;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MatchableFilter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UpdateScreenGzFilter implements IncludeExcludeFilter<Integer>, MatchableFilter {
    Set<Integer> includeUpdateScreenGz = Set.of();
    Set<Integer> excludeUpdateScreenGz = Set.of();

    public UpdateScreenGzFilter(
            Collection<Integer> include,
            Collection<Integer> exclude
    ) {
        this.includeUpdateScreenGz = include == null ? includeUpdateScreenGz : new HashSet<>(include);
        this.excludeUpdateScreenGz = exclude == null ? excludeUpdateScreenGz : new HashSet<>(exclude);
    }

    @Override
    public Collection<Integer> includes() {
        return includeUpdateScreenGz;
    }

    @Override
    public Collection<Integer> excludes() {
        return excludeUpdateScreenGz;
    }

    @Override
    public boolean isMatch(Mobile mobile) {
        var updateScreenGz = mobile.getMobileInfo().getScreenInfo().getScreenUpdatesGz();

        return match(updateScreenGz);
    }
}
