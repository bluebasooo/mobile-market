package ru.bluebasooo.market.mobilemarket.service.mobile.model.info;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class MemoryInfo {
    String ramType;
    Integer ramSizeGb;
    Integer hddSizeGb;
    List<String> slots;
    List<String> supportCards;
    Integer memoryCardMaxSizeGb;
}
