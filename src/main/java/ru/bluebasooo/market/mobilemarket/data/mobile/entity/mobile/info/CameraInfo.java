package ru.bluebasooo.market.mobilemarket.data.mobile.entity.mobile.info;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class CameraInfo {
    Integer cameras;
    List<Integer> megapixels;
    Integer maxZoom;
    List<String> supportedVideoResolutions;
    List<String> supportedVideoCodecs;
}
