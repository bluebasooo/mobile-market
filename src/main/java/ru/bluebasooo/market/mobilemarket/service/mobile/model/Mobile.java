package ru.bluebasooo.market.mobilemarket.service.mobile.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Mobile {
    String name;
    Double price;
    String brand;
    MobileInfo mobileInfo;
}
