package ru.bluebasooo.market.mobilemarket.service.mapper;

import org.springframework.stereotype.Component;
import ru.bluebasooo.market.mobilemarket.data.mobile.entity.mobile.MobileInfoEntity;
import ru.bluebasooo.market.mobilemarket.data.mobile.entity.mobile.info.*;
import ru.bluebasooo.market.mobilemarket.grpc.mobile.proto.*;

@Component
public class MobileInfoAdminDtoToEntityMapper {


    public MobileInfoEntity toEntity(MobileInfoProto mobileInfo) {
        return MobileInfoEntity.builder()
                .commonInfo(toCommonInfo(mobileInfo.getCommonInfo()))
                .cellInfo(toCellInfo(mobileInfo.getCellInfo()))
                .screenInfo(toScreenInfo(mobileInfo.getScreenInfo()))
                .constructionInfo(toConstructionInfo(mobileInfo.getConstructionInfo()))
                .osInfo(toOsInfo(mobileInfo.getOsInfo()))
                .memoryInfo(toMemoryInfo(mobileInfo.getMemoryInfo()))
                .cameraInfo(toCameraInfo(mobileInfo.getCameraInfo()))
                .audioInfo(toAudioInfo(mobileInfo.getAudioInfo()))
                .additionalInfo(toAdditionalInfo(mobileInfo.getAdditionalInfo()))
                .accumulatorInfo(toAccumulatorInfo(mobileInfo.getAccumulaterInfo()))
                .sizeInfo(toSizeInfo(mobileInfo.getSizeInfo()))
                .build();
    }

    private CommonInfo toCommonInfo(CommonInfoProto commonInfoProto) {
        var mobileType = switch (commonInfoProto.getType()) {
            case SMARTPHONE -> MobileType.SMARTPHONE;
            case UNRECOGNIZED -> throw new IllegalArgumentException(); //TODO custom excpetion
        };
        return CommonInfo.builder()
                .type(mobileType)
                .fullName(commonInfoProto.getFullName())
                .yearRelease(commonInfoProto.getYearRelease())
                .build();
    }

    private CellInfo toCellInfo(CellInfoProto cellInfoProto) {
        return CellInfo.builder()
                .bluetoothVersion(cellInfoProto.getBluetoothVersion())
                .wifiStandard(cellInfoProto.getWifiStandard())
                .isNfcSupport(cellInfoProto.getNfcSupport())
                .build();
    }

    private ScreenInfo toScreenInfo(ScreenInfoProto screenInfoProto) {
        return ScreenInfo.builder()
                .size(screenInfoProto.getSize())
                .sizeInPixels(screenInfoProto.getSizeInPixels())
                .matrixType(screenInfoProto.getMatrixType())
                .screenUpdatesGz(screenInfoProto.getScreenUpdatesGz())
                .pixelsDensity(screenInfoProto.getPixelsDensity())
                .ratio(screenInfoProto.getRatio())
                .build();
    }

    private ConstructionInfo toConstructionInfo(ConstructionInfoProto constructionInfoProto) {
        return ConstructionInfo.builder()
                .corpusType(constructionInfoProto.getCorpusType())
                .screenSaver(constructionInfoProto.getScreenSaver())
                .materials(constructionInfoProto.getMaterialsList())
                .protections(constructionInfoProto.getProtectionsList())
                .build();
    }

    private OsInfo toOsInfo(OsInfoProto osInfoProto) {
        var osType = switch (osInfoProto.getOsType()) {
            case ANDROID -> OsType.ANDROID;
            case UNRECOGNIZED -> throw new IllegalArgumentException();
        };

        return OsInfo.builder()
                .osType(osType)
                .version(osInfoProto.getVersion())
                .osName(osInfoProto.getOsName())
                .processorType(osInfoProto.getProcessorType())
                .processorCores(osInfoProto.getProcessorCores())
                .maxProcessorFrequency(osInfoProto.getMaxProcessorFrequency())
                .processorConfigurationInfo(osInfoProto.getProcessorConfigurationInfo())
                .processorSize(osInfoProto.getProcessorSize())
                .graphicProcessor(osInfoProto.getGraphicProcessor())
                .build();
    }

    private MemoryInfo toMemoryInfo(MemoryInfoProto memoryInfoProto) {
        return MemoryInfo.builder()
                .ramType(memoryInfoProto.getRamType())
                .ramSizeGb(memoryInfoProto.getRamSizeGb())
                .hdrSizeGb(memoryInfoProto.getHddSizeGb())
                .slots(memoryInfoProto.getSlotsList())
                .supportCards(memoryInfoProto.getSupportCardsTypesList())
                .memoryCardMaxSizeGb(memoryInfoProto.getMemoryCardMaxSizeGb())
                .build();
    }

    private CameraInfo toCameraInfo(CameraInfoProto cameraInfoProto) {
        return CameraInfo.builder()
                .cameras(cameraInfoProto.getCameras())
                .megapixels(cameraInfoProto.getMegapixelsList())
                .maxZoom(cameraInfoProto.getMaxZoom())
                .supportedVideoCodecs(cameraInfoProto.getSupportVideoCodecsList())
                .supportedVideoResolutions(cameraInfoProto.getSupportVideoResolutionsList())
                .build();
    }

    private AudioInfo toAudioInfo(AudioInfoProto audioInfoProto) {
        return AudioInfo.builder()
                .audioCodecs(audioInfoProto.getAudioCodecsList())
                .isFMSupported(audioInfoProto.getFmSupport())
                .build();
    }

    private AdditionalInfo toAdditionalInfo(AdditionalInfoProto additionalInfoProto) {
        return AdditionalInfo.builder()
                .isBiometricSupport(additionalInfoProto.getBiometricSupport())
                .isHeadphoneInBox(additionalInfoProto.getHeadphoneInBox())
                .isChargeInBox(additionalInfoProto.getChargeInBox())
                .boxInItems(additionalInfoProto.getBoxInItemsList())
                .build();
    }

    private AccumulatorInfo toAccumulatorInfo(AccumulatorInfoProto accumulatorInfoProto) {
        return AccumulatorInfo.builder()
                .accumulatorType(accumulatorInfoProto.getAccumulatorType())
                .batteryCapacity(accumulatorInfoProto.getBatteryCapacity())
                .isFastCharge(accumulatorInfoProto.getFastCharge())
                .isRemoteChargeSupport(accumulatorInfoProto.getRemoteCharge())
                .ttlMusicListening(accumulatorInfoProto.getTtlMusicListening())
                .ttlVideoViewing(accumulatorInfoProto.getTtlVideoViewing())
                .chargeInterface(accumulatorInfoProto.getChargeInterface())
                .isOTGSupport(accumulatorInfoProto.getOtgSupport())
                .headphoneInterface(accumulatorInfoProto.getHeadphoneInterface())
                .build();
    }

    private SizeInfo toSizeInfo(SizeInfoProto sizeInfoProto) {
        return SizeInfo.builder()
                .length(sizeInfoProto.getLength())
                .width(sizeInfoProto.getWidth())
                .height(sizeInfoProto.getHeight())
                .weight(sizeInfoProto.getWeight())
                .build();
    }

    public MobileInfoProto toDto(MobileInfoEntity entity) {
        return MobileInfoProto.newBuilder()
                .setCommonInfo(toCommonInfoProto(entity.getCommonInfo()))
                .setCellInfo(toCellInfoProto(entity.getCellInfo()))
                .setScreenInfo(toScreenInfoProto(entity.getScreenInfo()))
                .setConstructionInfo(toConstructionInfoProto(entity.getConstructionInfo()))
                .setOsInfo(toOsInfoProto(entity.getOsInfo()))
                .setMemoryInfo(toMemoryInfoProto(entity.getMemoryInfo()))
                .setCameraInfo(toCameraInfoProto(entity.getCameraInfo()))
                .setAudioInfo(toAudioInfoProto(entity.getAudioInfo()))
                .setAdditionalInfo(toAdditionalInfoProto(entity.getAdditionalInfo()))
                .setAccumulaterInfo(toAccumulatorInfoProto(entity.getAccumulatorInfo()))
                .setSizeInfo(toSizeInfoProto(entity.getSizeInfo()))
                .build();
    }

    private CommonInfoProto toCommonInfoProto(CommonInfo commonInfo) {
        var mobileTypeProto = switch(commonInfo.getType()) {
            case SMARTPHONE -> MobileTypeProto.SMARTPHONE;
        };

        return CommonInfoProto.newBuilder()
                .setType(mobileTypeProto)
                .setFullName(commonInfo.getFullName())
                .setYearRelease(commonInfo.getYearRelease())
                .build();
    }

    private CellInfoProto toCellInfoProto(CellInfo cellInfo) {
        return CellInfoProto.newBuilder()
                .setBluetoothVersion(cellInfo.getBluetoothVersion())
                .setWifiStandard(cellInfo.getWifiStandard())
                .setNfcSupport(cellInfo.isNfcSupport())
                .build();
    }

    private ScreenInfoProto toScreenInfoProto(ScreenInfo screenInfo) {
        return ScreenInfoProto.newBuilder()
                .setSize(screenInfo.getSize())
                .setSizeInPixels(screenInfo.getSizeInPixels())
                .setMatrixType(screenInfo.getMatrixType())
                .setScreenUpdatesGz(screenInfo.getScreenUpdatesGz())
                .setPixelsDensity(screenInfo.getPixelsDensity())
                .setRatio(screenInfo.getRatio())
                .build();
    }

    private ConstructionInfoProto toConstructionInfoProto(ConstructionInfo constructionInfo) {
        return ConstructionInfoProto.newBuilder()
                .setCorpusType(constructionInfo.getCorpusType())
                .setScreenSaver(constructionInfo.getScreenSaver())
                .addAllMaterials(constructionInfo.getMaterials())
                .addAllProtections(constructionInfo.getProtections())
                .build();
    }

    private OsInfoProto toOsInfoProto(OsInfo osInfo) {
        var osType = switch (osInfo.getOsType()) {
            case ANDROID -> OsTypeProto.ANDROID;
        };

        return OsInfoProto.newBuilder()
                .setOsType(osType)
                .setVersion(osInfo.getVersion())
                .setOsName(osInfo.getOsName())
                .setProcessorType(osInfo.getProcessorType())
                .setProcessorCores(osInfo.getProcessorCores())
                .setMaxProcessorFrequency(osInfo.getMaxProcessorFrequency())
                .setProcessorConfigurationInfo(osInfo.getProcessorConfigurationInfo())
                .setProcessorSize(osInfo.getProcessorSize())
                .setGraphicProcessor(osInfo.getGraphicProcessor())
                .build();
    }

    private MemoryInfoProto toMemoryInfoProto(MemoryInfo memoryInfo) {
        return MemoryInfoProto.newBuilder()
                .setRamType(memoryInfo.getRamType())
                .setRamSizeGb(memoryInfo.getRamSizeGb())
                .setHddSizeGb(memoryInfo.getRamSizeGb())
                .setMemoryCardMaxSizeGb(memoryInfo.getMemoryCardMaxSizeGb())
                .addAllSlots(memoryInfo.getSlots())
                .addAllSupportCardsTypes(memoryInfo.getSupportCards())
                .build();
    }

    private CameraInfoProto toCameraInfoProto(CameraInfo cameraInfo) {
        return CameraInfoProto.newBuilder()
                .setCameras(cameraInfo.getCameras())
                .setMaxZoom(cameraInfo.getMaxZoom())
                .addAllMegapixels(cameraInfo.getMegapixels())
                .addAllSupportVideoResolutions(cameraInfo.getSupportedVideoResolutions())
                .addAllSupportVideoCodecs(cameraInfo.getSupportedVideoCodecs())
                .build();
    }

    private AudioInfoProto toAudioInfoProto(AudioInfo audioInfo) {
        return AudioInfoProto.newBuilder()
                .addAllAudioCodecs(audioInfo.getAudioCodecs())
                .setFmSupport(audioInfo.isFMSupported())
                .build();
    }

    private AdditionalInfoProto toAdditionalInfoProto(AdditionalInfo additionalInfo) {
        return AdditionalInfoProto.newBuilder()
                .setBiometricSupport(additionalInfo.isBiometricSupport())
                .setHeadphoneInBox(additionalInfo.isHeadphoneInBox())
                .setChargeInBox(additionalInfo.isChargeInBox())
                .addAllBoxInItems(additionalInfo.getBoxInItems())
                .build();
    }

    private AccumulatorInfoProto toAccumulatorInfoProto(AccumulatorInfo accumulatorInfo) {
        return AccumulatorInfoProto.newBuilder()
                .setAccumulatorType(accumulatorInfo.getAccumulatorType())
                .setBatteryCapacity(accumulatorInfo.getBatteryCapacity())
                .setFastCharge(accumulatorInfo.isFastCharge())
                .setRemoteCharge(accumulatorInfo.isRemoteChargeSupport())
                .setTtlMusicListening(accumulatorInfo.getTtlMusicListening())
                .setTtlVideoViewing(accumulatorInfo.getTtlVideoViewing())
                .setChargeInterface(accumulatorInfo.getChargeInterface())
                .setOtgSupport(accumulatorInfo.isOTGSupport())
                .setHeadphoneInterface(accumulatorInfo.getHeadphoneInterface())
                .build();
    }

    private SizeInfoProto toSizeInfoProto(SizeInfo sizeInfo) {
        return SizeInfoProto.newBuilder()
                .setLength(sizeInfo.getLength())
                .setWidth(sizeInfo.getWidth())
                .setHeight(sizeInfo.getHeight())
                .setWeight(sizeInfo.getWeight())
                .build();
    }

}
