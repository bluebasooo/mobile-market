package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import lombok.Value;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MinMaxFilter;

@Value
public class ScreenResolutionFilter implements MinMaxFilter<Integer> {
    int minScreenResolution;
    int maxScreenResolution;

    @Override
    public Integer min() {
        return minScreenResolution;
    }

    @Override
    public Integer max() {
        return maxScreenResolution;
    }
}
