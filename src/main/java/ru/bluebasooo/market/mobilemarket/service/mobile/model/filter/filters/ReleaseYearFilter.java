package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import lombok.Value;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MinMaxFilter;

@Value
public class ReleaseYearFilter implements MinMaxFilter<Integer> {
    int minYear;
    int maxYear;

    @Override
    public Integer min() {
        return minYear;
    }

    @Override
    public Integer max() {
        return maxYear;
    }
}
