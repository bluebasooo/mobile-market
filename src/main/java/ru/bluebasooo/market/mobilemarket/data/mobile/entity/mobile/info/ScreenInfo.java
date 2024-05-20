package ru.bluebasooo.market.mobilemarket.data.mobile.entity.mobile.info;

import lombok.Value;

@Value
public class ScreenInfo {
    String size;
    String sizeInPixels; //TODO better name
    String matrixType;
    String screenUpdatesGz;
    String pixelsDensity; //TODO more information name
    String ratio;
}
