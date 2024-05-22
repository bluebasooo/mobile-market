package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import ru.bluebasooo.market.mobilemarket.service.mobile.model.Mobile;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MatchableFilter;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MinMaxFilter;

public class ProcessorFrequencyFilter implements MinMaxFilter<Double>, MatchableFilter {
    private double minProcessorFrequency = Double.MIN_VALUE;
    private double maxProcessorFrequency = Double.MAX_VALUE;

    public ProcessorFrequencyFilter(
            Double min,
            Double max
    ) {
        this.minProcessorFrequency = min == null ? minProcessorFrequency : min;
        this.maxProcessorFrequency = max == null ? maxProcessorFrequency : max;
    }

    @Override
    public Double min() {
        return minProcessorFrequency;
    }

    @Override
    public Double max() {
        return maxProcessorFrequency;
    }

    @Override
    public boolean isMatch(Mobile mobile) {
        var processorFrequency = mobile.getMobileInfo().getOsInfoEntity().getMaxProcessorFrequency();

        return match(processorFrequency);
    }
}
