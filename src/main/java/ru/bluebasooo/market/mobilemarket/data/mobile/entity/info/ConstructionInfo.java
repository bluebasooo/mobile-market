package ru.bluebasooo.market.mobilemarket.data.mobile.entity.info;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class ConstructionInfo {
    String corpusType;
    String screenSaver;
    List<String> materials;
    List<String> protections;
}
