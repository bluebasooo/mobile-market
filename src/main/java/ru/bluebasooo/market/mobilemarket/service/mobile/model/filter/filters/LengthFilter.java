package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import ru.bluebasooo.market.mobilemarket.service.mobile.model.Mobile;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MatchableFilter;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MinMaxFilter;

public class LengthFilter implements MinMaxFilter<Double>, MatchableFilter {
    private double minLength = Double.MIN_VALUE;
    private double maxLength = Double.MAX_VALUE;

    public LengthFilter(Double min, Double max) {
        this.minLength = min == null ? minLength : min;
        this.maxLength = max == null ? maxLength : max;
    }

    @Override
    public Double min() {
        return minLength;
    }

    @Override
    public Double max() {
        return maxLength;
    }

    @Override
    public boolean isMatch(Mobile mobile) {
        var diagonal = mobile.getMobileInfo().getScreenInfo().getDiagonal();

        return match(diagonal);
    }
}
