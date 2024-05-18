package ru.bluebasooo.market.mobilemarket.entity.mobile.info;

import lombok.Value;

@Value
public class CellInfo {
    String bluetoothVersion;
    String wifiStandart;
    boolean nfcSupport;
}
