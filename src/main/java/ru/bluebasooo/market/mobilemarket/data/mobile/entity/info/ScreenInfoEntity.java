package ru.bluebasooo.market.mobilemarket.data.mobile.entity.info;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ScreenInfoEntity {
    Double diagonal;
    String sizeInPixels;
    String matrixType;
    Integer screenUpdatesGz;
    String pixelsDensity;
    String ratio;
}
