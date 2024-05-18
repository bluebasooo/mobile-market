package ru.bluebasooo.market.mobilemarket.entity.mobile.info;

import lombok.Value;

import java.util.List;

@Value
public class CameraInfo {
    Integer camerasNums;
    List<Integer> megapixels;
    Integer maxZoom;
    List<String> supportVideoResolutions;
    List<String> supportedVideoCodecs;
}
