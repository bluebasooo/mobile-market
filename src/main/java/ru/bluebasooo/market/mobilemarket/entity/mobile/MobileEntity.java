package ru.bluebasooo.market.mobilemarket.entity.mobile;

import lombok.Value;

import java.util.List;

@Value
public class MobileEntity {
    String id;
    Double price;
    MobileInfoEntity mobileInfo;
    List<String> imgUrls;
}
