package ru.bluebasooo.market.mobilemarket.service.mobile.model.info;

import lombok.Builder;
import lombok.Value;
import ru.bluebasooo.market.mobilemarket.data.mobile.entity.info.MobileType;

@Value
@Builder
public class CommonInfo {
    MobileType type;
    String fullName;
    Integer yearRelease;
}
