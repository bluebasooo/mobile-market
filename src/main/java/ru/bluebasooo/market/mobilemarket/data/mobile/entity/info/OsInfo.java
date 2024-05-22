package ru.bluebasooo.market.mobilemarket.data.mobile.entity.info;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class OsInfo {
    OsType osType;
    String version;
    String osName;
    String processorType;
    Integer processorCores;
    Double maxProcessorFrequency;
    String processorConfigurationInfo;
    Integer processorSize;
    String graphicProcessor;
}
