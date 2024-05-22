package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters;

import lombok.Value;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MinMaxFilter;

@Value
public class AccumulatorCapacityFilter implements MinMaxFilter<Integer> {
    int minAccumulatorCapacity;
    int maxAccumulatorCapacity;

    @Override
    public Integer min() {
        return minAccumulatorCapacity;
    }

    @Override
    public Integer max() {
        return maxAccumulatorCapacity;
    }
}
