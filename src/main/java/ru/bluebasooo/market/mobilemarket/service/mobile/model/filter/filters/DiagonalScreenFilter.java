package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import lombok.Value;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MinMaxFilter;

@Value
public class DiagonalScreenFilter implements MinMaxFilter<Double> {
    double minDiagonalScreen;
    double maxDiagonalScreen;

    @Override
    public Double min() {
        return maxDiagonalScreen;
    }

    @Override
    public Double max() {
        return maxDiagonalScreen;
    }
}
