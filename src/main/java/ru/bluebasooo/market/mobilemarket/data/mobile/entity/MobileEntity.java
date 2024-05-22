package ru.bluebasooo.market.mobilemarket.data.mobile.entity;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;

import java.util.List;

@Value
@Builder
public class MobileEntity {
    @Id
    String id;
    Double price;
    String name;
    String brand;
    MobileInfoEntity mobileInfo;
    List<String> imgUrls;
}
