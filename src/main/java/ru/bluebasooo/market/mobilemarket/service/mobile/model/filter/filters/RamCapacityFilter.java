package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import ru.bluebasooo.market.mobilemarket.service.mobile.model.Mobile;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.IncludeExcludeFilter;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MatchableFilter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RamCapacityFilter implements IncludeExcludeFilter<Integer>, MatchableFilter {
    private Set<Integer> includeRamCapacity = Set.of();
    private Set<Integer> excludeRamCapacity = Set.of();

    public RamCapacityFilter(
            Collection<Integer> include,
            Collection<Integer> exclude
    ) {
        this.includeRamCapacity = include == null ? includeRamCapacity : new HashSet<>(include);
        this.excludeRamCapacity = exclude == null ? excludeRamCapacity : new HashSet<>(exclude);
    }

    @Override
    public Collection<Integer> includes() {
        return includeRamCapacity;
    }

    @Override
    public Collection<Integer> excludes() {
        return excludeRamCapacity;
    }

    @Override
    public boolean isMatch(Mobile mobile) {
        var ramCapacity = mobile.getMobileInfo().getMemoryInfo().getRamSizeGb();

        return match(ramCapacity);
    }
}
