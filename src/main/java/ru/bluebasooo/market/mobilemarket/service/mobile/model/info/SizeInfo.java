package ru.bluebasooo.market.mobilemarket.service.mobile.model.info;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SizeInfo {
    Double length;
    Double width;
    Double height;
    Double weight;
}
