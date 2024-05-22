package ru.bluebasooo.market.mobilemarket.service.mobile.model.info;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ScreenInfo {
    Double diagonal;
    String sizeInPixels;
    String matrixType;
    Integer screenUpdatesGz;
    String pixelsDensity;
    String ratio;
}
