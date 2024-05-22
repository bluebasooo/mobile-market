package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import ru.bluebasooo.market.mobilemarket.service.mobile.model.Mobile;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MatchableFilter;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MinMaxFilter;

public class WidthFilter implements MinMaxFilter<Double>, MatchableFilter {
    private double minWidth = Double.MIN_VALUE;
    private double maxWidth = Double.MAX_VALUE;

    public WidthFilter(
            Double min,
            Double max
    ) {
        this.minWidth = min == null ? minWidth : min;
        this.maxWidth = max == null ? maxWidth : max;
    }

    @Override
    public Double min() {
        return minWidth;
    }

    @Override
    public Double max() {
        return maxWidth;
    }

    @Override
    public boolean isMatch(Mobile mobile) {
        var width = mobile.getMobileInfo().getSizeInfoEntity().getWidth();

        return match(width);
    }
}
