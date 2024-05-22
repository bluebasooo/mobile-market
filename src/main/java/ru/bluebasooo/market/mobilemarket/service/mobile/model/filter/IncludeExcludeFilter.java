package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter;

import java.util.List;

public interface IncludeExcludeFilter<T> {
    List<T> includes();
    List<T> excludes();
}
