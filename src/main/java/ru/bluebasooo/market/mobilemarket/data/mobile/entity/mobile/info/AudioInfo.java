package ru.bluebasooo.market.mobilemarket.data.mobile.entity.mobile.info;

import lombok.Value;

import java.util.List;

@Value
public class AudioInfo {
    List<String> audioCodecs;
    boolean isFMSupported;
}
