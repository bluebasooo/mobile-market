package ru.bluebasooo.market.mobilemarket.data.mobile.entity.mobile.info;

import lombok.Value;

@Value
public class AccumulatorInfo {
    String accumulatorType;
    Integer batteryCapacity;
    boolean isFastCharge;
    boolean isRemoteChargeSupport;
    Integer ttlMusicListening;
    Integer ttlVideoViewing;
    String chargeInterface; //Type-C micro
    boolean isOTGSupport;
    String headphoneInterface;
}
