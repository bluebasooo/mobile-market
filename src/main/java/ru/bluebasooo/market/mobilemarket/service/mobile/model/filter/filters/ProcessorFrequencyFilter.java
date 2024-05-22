package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MinMaxFilter;

public class ProcessorFrequencyFilter implements MinMaxFilter<Double> {
    double minProcessorFrequency;
    double maxProcessorFrequency;

    @Override
    public Double min() {
        return minProcessorFrequency;
    }

    @Override
    public Double max() {
        return maxProcessorFrequency;
    }
}
