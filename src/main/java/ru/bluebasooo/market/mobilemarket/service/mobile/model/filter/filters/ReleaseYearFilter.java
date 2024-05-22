package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import ru.bluebasooo.market.mobilemarket.service.mobile.model.Mobile;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MatchableFilter;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MinMaxFilter;

public class ReleaseYearFilter implements MinMaxFilter<Integer>, MatchableFilter {
    private int minYear = Integer.MIN_VALUE;
    private int maxYear = Integer.MAX_VALUE;

    public ReleaseYearFilter(
            Integer min,
            Integer max
    ) {
        this.minYear = min == null ? minYear : min;
        this.maxYear = max == null ? maxYear : max;
    }

    @Override
    public Integer min() {
        return minYear;
    }

    @Override
    public Integer max() {
        return maxYear;
    }

    @Override
    public boolean isMatch(Mobile mobile) {
        var yearRelease = mobile.getMobileInfo().getCommonInfo().getYearRelease();

        return match(yearRelease);
    }
}
