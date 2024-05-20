package ru.bluebasooo.market.mobilemarket.data.mobile.entity.mobile.info;

import lombok.Value;

@Value
public class OsInfo {
    OsType osType;
    String version;
    String osName;
    String processorType;
    Integer processorCores;
    String maxProcessorFrequency;
    String processorConfigurationInfo;
    String processorSize;
    String graphicProcessor;
}
