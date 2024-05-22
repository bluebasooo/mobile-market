package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter;

public interface MinMaxFilter<T extends Comparable<T>> {
    T min();
    T max();

    default boolean match(T param) {
        return param.compareTo(min()) >= 0 && param.compareTo(max()) <= 0;
    }
}
