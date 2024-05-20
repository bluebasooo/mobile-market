package ru.bluebasooo.market.mobilemarket.data.mobile.entity.mobile.info;

import lombok.Value;

import java.util.List;

@Value
public class AdditionalInfo {
    boolean isBiometricSupport;
    boolean isHeadphoneInComplect;
    boolean isChargeInComplect;
    List<String> boxInItems;
}
