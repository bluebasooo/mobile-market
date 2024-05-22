package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import lombok.Value;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MinMaxFilter;

@Value
public class WidthFilter implements MinMaxFilter<Double> {
    double minWidth;
    double maxWidth;

    @Override
    public Double min() {
        return minWidth;
    }

    @Override
    public Double max() {
        return maxWidth;
    }
}
