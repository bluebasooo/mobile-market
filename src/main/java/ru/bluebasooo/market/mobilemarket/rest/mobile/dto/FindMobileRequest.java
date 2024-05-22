package ru.bluebasooo.market.mobilemarket.rest.mobile.dto;

import lombok.Builder;
import lombok.Value;

@Value
public class FindMobileRequest {
    String searchRequest;
    FilterDto filterDto;
}
