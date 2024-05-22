package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import lombok.Value;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MinMaxFilter;

@Value
public class PriceFilter implements MinMaxFilter<Double> {
    double minPrice;
    double maxPrice;

    @Override
    public Double min() {
        return minPrice;
    }

    @Override
    public Double max() {
        return maxPrice;
    }
}
