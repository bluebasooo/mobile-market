package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import ru.bluebasooo.market.mobilemarket.service.mobile.model.Mobile;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.IncludeExcludeFilter;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MatchableFilter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class HddCapacityFilter implements IncludeExcludeFilter<Integer>, MatchableFilter {
    private Set<Integer> includesHddCapacity = Set.of();
    private Set<Integer> excludesHddCapacity = Set.of();

    public HddCapacityFilter(
            Collection<Integer> include,
            Collection<Integer> exclude
    ) {
        this.includesHddCapacity = include == null ? includesHddCapacity : new HashSet<>(include);
        this.excludesHddCapacity = exclude == null ? excludesHddCapacity : new HashSet<>(exclude);
    }

    @Override
    public Collection<Integer> includes() {
        return includesHddCapacity;
    }

    @Override
    public Collection<Integer> excludes() {
        return excludesHddCapacity;
    }

    @Override
    public boolean isMatch(Mobile mobile) {
        var hddCapacity = mobile.getMobileInfo().getMemoryInfoEntity().getHddSizeGb();

        return match(hddCapacity);
    }
}
