package ru.bluebasooo.market.mobilemarket.data.mobile.entity.info;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CommonInfoEntity {
    MobileType type;
    String fullName;
    Integer yearRelease;
}
