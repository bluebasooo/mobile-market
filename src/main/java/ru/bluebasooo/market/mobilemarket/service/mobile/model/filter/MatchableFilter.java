package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter;

import ru.bluebasooo.market.mobilemarket.service.mobile.model.Mobile;

public interface MatchableFilter {
    boolean isMatch(Mobile mobile);
}
