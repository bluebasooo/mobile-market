package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import ru.bluebasooo.market.mobilemarket.service.mobile.model.Mobile;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MatchableFilter;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MinMaxFilter;

public class PriceFilter implements MinMaxFilter<Double>, MatchableFilter {
    private double minPrice = Double.MIN_VALUE;
    private double maxPrice = Double.MAX_VALUE;

    public PriceFilter(
            Double min,
            Double max
    ) {
        this.minPrice = min == null ? minPrice : min;
        this.maxPrice = max == null ? maxPrice : max;
    }

    @Override
    public Double min() {
        return minPrice;
    }

    @Override
    public Double max() {
        return maxPrice;
    }

    @Override
    public boolean isMatch(Mobile mobile) {
        var price = mobile.getPrice();

        return match(price);
    }
}
