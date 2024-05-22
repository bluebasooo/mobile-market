package ru.bluebasooo.market.mobilemarket.data.mobile.entity.info;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ScreenInfo {
    String size;
    String sizeInPixels;
    String matrixType;
    String screenUpdatesGz;
    String pixelsDensity;
    String ratio;
}
