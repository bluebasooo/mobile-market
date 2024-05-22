package ru.bluebasooo.market.mobilemarket.data.mobile.entity.info;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class MemoryInfoEntity {
    String ramType;
    Integer ramSizeGb;
    Integer hddSizeGb;
    List<String> slots;
    List<String> supportCards;
    Integer memoryCardMaxSizeGb;
}
