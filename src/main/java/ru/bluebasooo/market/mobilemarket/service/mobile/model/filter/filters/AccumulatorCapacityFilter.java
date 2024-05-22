package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import ru.bluebasooo.market.mobilemarket.service.mobile.model.Mobile;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MatchableFilter;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MinMaxFilter;


public class AccumulatorCapacityFilter implements MinMaxFilter<Integer>, MatchableFilter {
    private int minAccumulatorCapacity = Integer.MIN_VALUE;
    private int maxAccumulatorCapacity = Integer.MAX_VALUE;

    public AccumulatorCapacityFilter(
            Integer min,
            Integer max
    ) {
        this.minAccumulatorCapacity = min == null ? minAccumulatorCapacity : min;
        this.maxAccumulatorCapacity = max == null ? maxAccumulatorCapacity : min;
    }

    @Override
    public Integer min() {
        return minAccumulatorCapacity;
    }

    @Override
    public Integer max() {
        return maxAccumulatorCapacity;
    }

    @Override
    public boolean isMatch(Mobile mobile) {
        var battaryCapacity = mobile.getMobileInfo().getAccumulatorInfo().getBatteryCapacity();

        return match(battaryCapacity);
    }
}
