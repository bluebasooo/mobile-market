package ru.bluebasooo.market.mobilemarket.entity.mobile.info;

import lombok.Value;

@Value
public class AccumulaterInfo {
    AccummalaterType type;
    String emkost; //TODO
    boolean isFastCharge;
    boolean remoteCharge;
    Integer timeLiveMusicListnening;
    Integer timeLiveVideoViewieng;
    String chargeInterface; //Type-C micro
    boolean isOTGSupport;
    String headphoneInterface;
}
