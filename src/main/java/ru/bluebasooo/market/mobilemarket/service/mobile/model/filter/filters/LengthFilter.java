package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import lombok.Value;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MinMaxFilter;

@Value
public class LengthFilter implements MinMaxFilter<Double> {
    double minLength;
    double maxLength;

    @Override
    public Double min() {
        return minLength;
    }

    @Override
    public Double max() {
        return maxLength;
    }
}
