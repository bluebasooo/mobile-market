package ru.bluebasooo.market.mobilemarket.service.mobile.mapper;

import org.springframework.stereotype.Component;
import ru.bluebasooo.market.mobilemarket.data.mobile.entity.MobileEntity;
import ru.bluebasooo.market.mobilemarket.data.mobile.entity.MobileInfoEntity;
import ru.bluebasooo.market.mobilemarket.data.mobile.entity.info.*;
import ru.bluebasooo.market.mobilemarket.data.mobile.entity.info.CommonInfoEntity;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.Mobile;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.MobileInfo;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.info.*;

@Component
public class MobileReadEntityToModelMapper {

    public Mobile toModel(MobileEntity mobileEntity) {
        return Mobile.builder()
                .brand(mobileEntity.getBrand())
                .name(mobileEntity.getName())
                .mobileInfo(toMobileInfo(mobileEntity.getMobileInfo()))
                .price(mobileEntity.getPrice())
                .build();
    }

    private MobileInfo toMobileInfo(MobileInfoEntity mobileInfoEntity) {
        return MobileInfo.builder()
                .commonInfo(toCommonInfo(mobileInfoEntity.getCommonInfoEntity()))
                .cellInfo(toCellInfo(mobileInfoEntity.getCellInfoEntity()))
                .screenInfo(toScreenInfo(mobileInfoEntity.getScreenInfoEntity()))
                .constructionInfo(toConstructionInfo(mobileInfoEntity.getConstructionInfoEntity()))
                .osInfo(toOsInfo(mobileInfoEntity.getOsInfoEntity()))
                .memoryInfo(toMemoryInfo(mobileInfoEntity.getMemoryInfoEntity()))
                .cameraInfo(toCameraInfo(mobileInfoEntity.getCameraInfoEntity()))
                .audioInfo(toAudioInfo(mobileInfoEntity.getAudioInfoEntity()))
                .additionalInfo(toAdditionalInfo(mobileInfoEntity.getAdditionalInfoEntity()))
                .sizeInfo(toSizeInfo(mobileInfoEntity.getSizeInfoEntity()))
                .build();
    }

    private SizeInfo toSizeInfo(SizeInfoEntity sizeInfoEntity) {
        return SizeInfo.builder()
                .height(sizeInfoEntity.getHeight())
                .length(sizeInfoEntity.getLength())
                .weight(sizeInfoEntity.getWeight())
                .width(sizeInfoEntity.getWidth())
                .build();
    }

    private AdditionalInfo toAdditionalInfo(AdditionalInfoEntity additionalInfoEntity) {
        return AdditionalInfo.builder()
                .isHeadphoneInBox(additionalInfoEntity.isHeadphoneInBox())
                .isBiometricSupport(additionalInfoEntity.isBiometricSupport())
                .isChargeInBox(additionalInfoEntity.isChargeInBox())
                .boxInItems(additionalInfoEntity.getBoxInItems())
                .build();
    }

    private AudioInfo toAudioInfo(AudioInfoEntity audioInfoEntity) {
        return AudioInfo.builder()
                .audioCodecs(audioInfoEntity.getAudioCodecs())
                .isFMSupported(audioInfoEntity.isFMSupported())
                .build();
    }

    private CameraInfo toCameraInfo(CameraInfoEntity cameraInfoEntity) {
        return CameraInfo.builder()
                .cameras(cameraInfoEntity.getCameras())
                .maxZoom(cameraInfoEntity.getMaxZoom())
                .megapixels(cameraInfoEntity.getMegapixels())
                .supportedVideoCodecs(cameraInfoEntity.getSupportedVideoCodecs())
                .supportedVideoResolutions(cameraInfoEntity.getSupportedVideoResolutions())
                .build();
    }

    private MemoryInfo toMemoryInfo(MemoryInfoEntity memoryInfoEntity) {
        return MemoryInfo.builder()
                .hddSizeGb(memoryInfoEntity.getHddSizeGb())
                .memoryCardMaxSizeGb(memoryInfoEntity.getMemoryCardMaxSizeGb())
                .ramSizeGb(memoryInfoEntity.getRamSizeGb())
                .ramType(memoryInfoEntity.getRamType())
                .slots(memoryInfoEntity.getSlots())
                .supportCards(memoryInfoEntity.getSupportCards())
                .build();
    }

    private OsInfo toOsInfo(OsInfoEntity osInfoEntity) {
        return OsInfo.builder()
                .osType(osInfoEntity.getOsType())
                .version(osInfoEntity.getVersion())
                .osName(osInfoEntity.getOsName())
                .processorType(osInfoEntity.getProcessorType())
                .processorCores(osInfoEntity.getProcessorCores())
                .maxProcessorFrequency(osInfoEntity.getMaxProcessorFrequency())
                .processorConfigurationInfo(osInfoEntity.getProcessorConfigurationInfo())
                .processorSize(osInfoEntity.getProcessorSize())
                .graphicProcessor(osInfoEntity.getGraphicProcessor())
                .build();
    }

    private ConstructionInfo toConstructionInfo(ConstructionInfoEntity constructionInfoEntity) {
        return ConstructionInfo.builder()
                .corpusType(constructionInfoEntity.getCorpusType())
                .screenSaver(constructionInfoEntity.getScreenSaver())
                .materials(constructionInfoEntity.getMaterials())
                .protections(constructionInfoEntity.getProtections())
                .build();
    }

    private ScreenInfo toScreenInfo(ScreenInfoEntity screenInfoEntity) {
        return ScreenInfo.builder()
                .diagonal(screenInfoEntity.getDiagonal())
                .sizeInPixels(screenInfoEntity.getSizeInPixels())
                .matrixType(screenInfoEntity.getMatrixType())
                .screenUpdatesGz(screenInfoEntity.getScreenUpdatesGz())
                .pixelsDensity(screenInfoEntity.getPixelsDensity())
                .ratio(screenInfoEntity.getRatio())
                .build();
    }

    private CellInfo toCellInfo(CellInfoEntity cellInfoEntity) {
        return CellInfo.builder()
                .bluetoothVersion(cellInfoEntity.getBluetoothVersion())
                .wifiStandard(cellInfoEntity.getWifiStandard())
                .isNfcSupport(cellInfoEntity.isNfcSupport())
                .build();
    }

    private CommonInfo toCommonInfo(CommonInfoEntity commonInfoEntity) {
        return CommonInfo.builder()
                .type(commonInfoEntity.getType())
                .fullName(commonInfoEntity.getFullName())
                .yearRelease(commonInfoEntity.getYearRelease())
                .build();
    }
}
