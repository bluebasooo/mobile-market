package ru.bluebasooo.market.mobilemarket.data.mobile.entity.mobile;

import lombok.Builder;
import lombok.Value;
import ru.bluebasooo.market.mobilemarket.data.mobile.entity.mobile.info.*;

@Value
@Builder
public class MobileInfoEntity {
    CommonInfo commonInfo;
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
