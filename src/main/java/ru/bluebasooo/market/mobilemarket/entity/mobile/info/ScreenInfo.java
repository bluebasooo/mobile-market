package ru.bluebasooo.market.mobilemarket.entity.mobile.info;

import lombok.Value;

@Value
public class ScreenInfo {
    String size;
    String pixSize; //TODO better name
    String matrixType; //TODO enum
    String gzUpdate; //TODO more
    String pixelsPlot; //TODO more information name
    String screenFloat; // sootnoshenie storon
}
