package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import ru.bluebasooo.market.mobilemarket.service.mobile.model.Mobile;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MatchableFilter;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MinMaxFilter;


public class DiagonalScreenFilter implements MinMaxFilter<Double>, MatchableFilter {
    private double minDiagonalScreen = Double.MIN_VALUE;
    private double maxDiagonalScreen = Double.MAX_VALUE;

    public DiagonalScreenFilter(
            Double min,
            Double max
    ) {
        this.minDiagonalScreen = min == null ? minDiagonalScreen : min;
        this.maxDiagonalScreen = max == null ? maxDiagonalScreen : max;
    }

    @Override
    public boolean isMatch(Mobile mobile) {
        var diagonal = mobile.getMobileInfo().getScreenInfoEntity().getDiagonal();

        return match(diagonal);
    }

    @Override
    public Double min() {
        return minDiagonalScreen;
    }

    @Override
    public Double max() {
        return maxDiagonalScreen;
    }
}
