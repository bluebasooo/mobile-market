package ru.bluebasooo.market.mobilemarket.entity.mobile.info;

import lombok.Value;

@Value
public class OsInfo {
    OsType osType;
    String verision;
    String osName;
    String processorType;
    Integer numOfCores;
    String maxFrequenceOfProcessor;
    String configurationInfoOfProccessor;
    String sizeOfProcessor;
    String graphicProcessorName;
}
