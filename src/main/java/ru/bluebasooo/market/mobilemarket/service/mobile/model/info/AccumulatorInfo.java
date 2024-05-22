package ru.bluebasooo.market.mobilemarket.service.mobile.model.info;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
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
