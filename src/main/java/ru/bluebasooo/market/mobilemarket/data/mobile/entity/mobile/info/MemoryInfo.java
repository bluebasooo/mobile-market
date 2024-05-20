package ru.bluebasooo.market.mobilemarket.data.mobile.entity.mobile.info;

import lombok.Value;

import java.util.List;

@Value
public class MemoryInfo {
    String ramType;
    Integer ramSize;
    Integer hdrSize;
    List<String> slots;
    List<String> supportCards;
    Integer memoryCardMaxSizeGb;
}
