package ru.bluebasooo.market.mobilemarket.data.mobile.entity.mobile.info;

import lombok.Value;

import java.util.List;

@Value
public class ConstructionInfo {
    String corpusType;
    String screenSaver;
    List<String> materials;
    List<String> protections;
}
