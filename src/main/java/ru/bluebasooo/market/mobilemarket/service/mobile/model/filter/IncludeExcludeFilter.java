package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter;

import java.util.Collection;
import java.util.List;

public interface IncludeExcludeFilter<T> {
    Collection<T> includes();
    Collection<T> excludes();

    default boolean match(T param) {
        boolean isInclude = includes().isEmpty() ? true : includes().contains(param);
        boolean isNotExclude = excludes().isEmpty() ? true : !excludes().contains(param);

        return isInclude && isNotExclude;
    }
}
