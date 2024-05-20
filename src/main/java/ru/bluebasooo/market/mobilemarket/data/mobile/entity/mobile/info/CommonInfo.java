package ru.bluebasooo.market.mobilemarket.data.mobile.entity.mobile.info;

import lombok.Value;

import java.time.LocalDate;

@Value
public class CommonInfo {
    MobileType type;
    String fullName; //TODO more good name
    LocalDate yearRelease;
}
