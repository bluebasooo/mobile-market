package ru.bluebasooo.market.mobilemarket.data.mobile.entity.info;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CellInfoEntity {
    String bluetoothVersion;
    String wifiStandard;
    boolean isNfcSupport;
}
