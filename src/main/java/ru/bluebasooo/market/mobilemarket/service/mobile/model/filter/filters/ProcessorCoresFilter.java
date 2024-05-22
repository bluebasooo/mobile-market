package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import lombok.Value;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.IncludeExcludeFilter;

import java.util.List;

@Value
public class ProcessorCoresFilter implements IncludeExcludeFilter<Integer> {
    List<Integer> includeProcessorCores;
    List<Integer> excludeProcessorCores;

    @Override
    public List<Integer> includes() {
        return includeProcessorCores;
    }

    @Override
    public List<Integer> excludes() {
        return excludeProcessorCores;
    }
}
