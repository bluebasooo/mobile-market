package ru.bluebasooo.market.mobilemarket.data.mobile.entity.mobile;

import lombok.Value;
import org.springframework.data.annotation.Id;

import java.util.List;

@Value
public class MobileEntity {
    @Id
    String id;
    Double price;
    MobileInfoEntity mobileInfo;
    List<String> imgUrls;
}
