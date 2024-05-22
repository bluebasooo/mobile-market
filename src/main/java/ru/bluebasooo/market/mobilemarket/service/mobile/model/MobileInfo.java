package ru.bluebasooo.market.mobilemarket.service.mobile.model;

import lombok.Builder;
import lombok.Value;
import ru.bluebasooo.market.mobilemarket.data.mobile.entity.info.CommonInfoEntity;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.info.*;

@Value
@Builder
public class MobileInfo {
    CommonInfoEntity commonInfo;
    CellInfo cellInfo;
    ScreenInfo screenInfo;
    ConstructionInfo constructionInfo;
    OsInfo osInfo;
    MemoryInfo memoryInfo;
    CameraInfo cameraInfo;
    AudioInfo audioInfo;
    AdditionalInfo additionalInfo;
    AccumulatorInfo accumulatorInfo;
    SizeInfo sizeInfo;
}
