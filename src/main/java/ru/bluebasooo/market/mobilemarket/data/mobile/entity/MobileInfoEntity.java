package ru.bluebasooo.market.mobilemarket.data.mobile.entity;

import lombok.Builder;
import lombok.Value;
import ru.bluebasooo.market.mobilemarket.data.mobile.entity.info.*;

@Value
@Builder
public class MobileInfoEntity {
    CommonInfoEntity commonInfoEntity;
    CellInfoEntity cellInfoEntity;
    ScreenInfoEntity screenInfoEntity;
    ConstructionInfoEntity constructionInfoEntity;
    OsInfoEntity osInfoEntity;
    MemoryInfoEntity memoryInfoEntity;
    CameraInfoEntity cameraInfoEntity;
    AudioInfoEntity audioInfoEntity;
    AdditionalInfoEntity additionalInfoEntity;
    AccumulatorInfoEntity accumulatorInfoEntity;
    SizeInfoEntity sizeInfoEntity;
}
