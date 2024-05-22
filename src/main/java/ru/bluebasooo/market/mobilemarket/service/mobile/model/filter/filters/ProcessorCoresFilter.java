package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import ru.bluebasooo.market.mobilemarket.service.mobile.model.Mobile;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.IncludeExcludeFilter;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MatchableFilter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ProcessorCoresFilter implements IncludeExcludeFilter<Integer>, MatchableFilter {
    private Set<Integer> includeProcessorCores = Set.of();
    private Set<Integer> excludeProcessorCores = Set.of();

    public ProcessorCoresFilter(
            Collection<Integer> include,
            Collection<Integer> exclude
    ) {
        this.includeProcessorCores = include == null ? includeProcessorCores : new HashSet<>(include);
        this.excludeProcessorCores = exclude == null ? excludeProcessorCores : new HashSet<>(exclude);
    }

    @Override
    public Collection<Integer> includes() {
        return includeProcessorCores;
    }

    @Override
    public Collection<Integer> excludes() {
        return excludeProcessorCores;
    }

    @Override
    public boolean isMatch(Mobile mobile) {
        var processorCores = mobile.getMobileInfo().getOsInfoEntity().getProcessorCores();

        return match(processorCores);
    }
}
