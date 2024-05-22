package ru.bluebasooo.market.mobilemarket.service.mobile.model.info;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class AdditionalInfo {
    boolean isBiometricSupport;
    boolean isHeadphoneInBox;
    boolean isChargeInBox;
    List<String> boxInItems;
}
