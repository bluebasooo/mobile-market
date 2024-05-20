package ru.bluebasooo.market.mobilemarket.data.mobile.entity.mobile.info;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CommonInfo {
    MobileType type;
    String fullName; //TODO more good name
    String yearRelease;
}
