package ru.bluebasooo.market.mobilemarket.data.mobile.entity.info;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class AudioInfo {
    List<String> audioCodecs;
    boolean isFMSupported;
}
