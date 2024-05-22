package ru.bluebasooo.market.mobilemarket.service.mobile.mapper;

import org.springframework.stereotype.Component;
import ru.bluebasooo.market.mobilemarket.data.mobile.entity.MobileInfoEntity;
import ru.bluebasooo.market.mobilemarket.data.mobile.entity.info.*;
import ru.bluebasooo.market.mobilemarket.grpc.mobile.proto.*;

@Component
public class MobileInfoAdminDtoToEntityMapper {


    public MobileInfoEntity toEntity(MobileInfoProto mobileInfo) {
        return MobileInfoEntity.builder()
                .commonInfoEntity(toCommonInfo(mobileInfo.getCommonInfo()))
                .cellInfoEntity(toCellInfo(mobileInfo.getCellInfo()))
                .screenInfoEntity(toScreenInfo(mobileInfo.getScreenInfo()))
                .constructionInfoEntity(toConstructionInfo(mobileInfo.getConstructionInfo()))
                .osInfoEntity(toOsInfo(mobileInfo.getOsInfo()))
                .memoryInfoEntity(toMemoryInfo(mobileInfo.getMemoryInfo()))
                .cameraInfoEntity(toCameraInfo(mobileInfo.getCameraInfo()))
                .audioInfoEntity(toAudioInfo(mobileInfo.getAudioInfo()))
                .additionalInfoEntity(toAdditionalInfo(mobileInfo.getAdditionalInfo()))
                .accumulatorInfoEntity(toAccumulatorInfo(mobileInfo.getAccumulaterInfo()))
                .sizeInfoEntity(toSizeInfo(mobileInfo.getSizeInfo()))
                .build();
    }

    private CommonInfoEntity toCommonInfo(CommonInfoProto commonInfoProto) {
        var mobileType = switch (commonInfoProto.getType()) {
            case SMARTPHONE -> MobileType.SMARTPHONE;
            case UNRECOGNIZED -> throw new IllegalArgumentException(); //TODO custom excpetion
        };
        return CommonInfoEntity.builder()
                .type(mobileType)
                .fullName(commonInfoProto.getFullName())
                .yearRelease(commonInfoProto.getYearRelease())
                .build();
    }

    private CellInfoEntity toCellInfo(CellInfoProto cellInfoProto) {
        return CellInfoEntity.builder()
                .bluetoothVersion(cellInfoProto.getBluetoothVersion())
                .wifiStandard(cellInfoProto.getWifiStandard())
                .isNfcSupport(cellInfoProto.getNfcSupport())
                .build();
    }

    private ScreenInfoEntity toScreenInfo(ScreenInfoProto screenInfoProto) {
        return ScreenInfoEntity.builder()
                .diagonal(screenInfoProto.getDiagonal())
                .sizeInPixels(screenInfoProto.getSizeInPixels())
                .matrixType(screenInfoProto.getMatrixType())
                .screenUpdatesGz(screenInfoProto.getScreenUpdatesGz())
                .pixelsDensity(screenInfoProto.getPixelsDensity())
                .ratio(screenInfoProto.getRatio())
                .build();
    }

    private ConstructionInfoEntity toConstructionInfo(ConstructionInfoProto constructionInfoProto) {
        return ConstructionInfoEntity.builder()
                .corpusType(constructionInfoProto.getCorpusType())
                .screenSaver(constructionInfoProto.getScreenSaver())
                .materials(constructionInfoProto.getMaterialsList())
                .protections(constructionInfoProto.getProtectionsList())
                .build();
    }

    private OsInfoEntity toOsInfo(OsInfoProto osInfoProto) {
        var osType = switch (osInfoProto.getOsType()) {
            case ANDROID -> OsType.ANDROID;
            case UNRECOGNIZED -> throw new IllegalArgumentException();
        };

        return OsInfoEntity.builder()
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

    private MemoryInfoEntity toMemoryInfo(MemoryInfoProto memoryInfoProto) {
        return MemoryInfoEntity.builder()
                .ramType(memoryInfoProto.getRamType())
                .ramSizeGb(memoryInfoProto.getRamSizeGb())
                .hddSizeGb(memoryInfoProto.getHddSizeGb())
                .slots(memoryInfoProto.getSlotsList())
                .supportCards(memoryInfoProto.getSupportCardsTypesList())
                .memoryCardMaxSizeGb(memoryInfoProto.getMemoryCardMaxSizeGb())
                .build();
    }

    private CameraInfoEntity toCameraInfo(CameraInfoProto cameraInfoProto) {
        return CameraInfoEntity.builder()
                .cameras(cameraInfoProto.getCameras())
                .megapixels(cameraInfoProto.getMegapixelsList())
                .maxZoom(cameraInfoProto.getMaxZoom())
                .supportedVideoCodecs(cameraInfoProto.getSupportVideoCodecsList())
                .supportedVideoResolutions(cameraInfoProto.getSupportVideoResolutionsList())
                .build();
    }

    private AudioInfoEntity toAudioInfo(AudioInfoProto audioInfoProto) {
        return AudioInfoEntity.builder()
                .audioCodecs(audioInfoProto.getAudioCodecsList())
                .isFMSupported(audioInfoProto.getFmSupport())
                .build();
    }

    private AdditionalInfoEntity toAdditionalInfo(AdditionalInfoProto additionalInfoProto) {
        return AdditionalInfoEntity.builder()
                .isBiometricSupport(additionalInfoProto.getBiometricSupport())
                .isHeadphoneInBox(additionalInfoProto.getHeadphoneInBox())
                .isChargeInBox(additionalInfoProto.getChargeInBox())
                .boxInItems(additionalInfoProto.getBoxInItemsList())
                .build();
    }

    private AccumulatorInfoEntity toAccumulatorInfo(AccumulatorInfoProto accumulatorInfoProto) {
        return AccumulatorInfoEntity.builder()
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

    private SizeInfoEntity toSizeInfo(SizeInfoProto sizeInfoProto) {
        return SizeInfoEntity.builder()
                .length(sizeInfoProto.getLength())
                .width(sizeInfoProto.getWidth())
                .height(sizeInfoProto.getHeight())
                .weight(sizeInfoProto.getWeight())
                .build();
    }

    public MobileInfoProto toDto(MobileInfoEntity entity) {
        return MobileInfoProto.newBuilder()
                .setCommonInfo(toCommonInfoProto(entity.getCommonInfoEntity()))
                .setCellInfo(toCellInfoProto(entity.getCellInfoEntity()))
                .setScreenInfo(toScreenInfoProto(entity.getScreenInfoEntity()))
                .setConstructionInfo(toConstructionInfoProto(entity.getConstructionInfoEntity()))
                .setOsInfo(toOsInfoProto(entity.getOsInfoEntity()))
                .setMemoryInfo(toMemoryInfoProto(entity.getMemoryInfoEntity()))
                .setCameraInfo(toCameraInfoProto(entity.getCameraInfoEntity()))
                .setAudioInfo(toAudioInfoProto(entity.getAudioInfoEntity()))
                .setAdditionalInfo(toAdditionalInfoProto(entity.getAdditionalInfoEntity()))
                .setAccumulaterInfo(toAccumulatorInfoProto(entity.getAccumulatorInfoEntity()))
                .setSizeInfo(toSizeInfoProto(entity.getSizeInfoEntity()))
                .build();
    }

    private CommonInfoProto toCommonInfoProto(CommonInfoEntity commonInfoEntity) {
        var mobileTypeProto = switch(commonInfoEntity.getType()) {
            case SMARTPHONE -> MobileTypeProto.SMARTPHONE;
        };

        return CommonInfoProto.newBuilder()
                .setType(mobileTypeProto)
                .setFullName(commonInfoEntity.getFullName())
                .setYearRelease(commonInfoEntity.getYearRelease())
                .build();
    }

    private CellInfoProto toCellInfoProto(CellInfoEntity cellInfoEntity) {
        return CellInfoProto.newBuilder()
                .setBluetoothVersion(cellInfoEntity.getBluetoothVersion())
                .setWifiStandard(cellInfoEntity.getWifiStandard())
                .setNfcSupport(cellInfoEntity.isNfcSupport())
                .build();
    }

    private ScreenInfoProto toScreenInfoProto(ScreenInfoEntity screenInfoEntity) {
        return ScreenInfoProto.newBuilder()
                .setDiagonal(screenInfoEntity.getDiagonal())
                .setSizeInPixels(screenInfoEntity.getSizeInPixels())
                .setMatrixType(screenInfoEntity.getMatrixType())
                .setScreenUpdatesGz(screenInfoEntity.getScreenUpdatesGz())
                .setPixelsDensity(screenInfoEntity.getPixelsDensity())
                .setRatio(screenInfoEntity.getRatio())
                .build();
    }

    private ConstructionInfoProto toConstructionInfoProto(ConstructionInfoEntity constructionInfoEntity) {
        return ConstructionInfoProto.newBuilder()
                .setCorpusType(constructionInfoEntity.getCorpusType())
                .setScreenSaver(constructionInfoEntity.getScreenSaver())
                .addAllMaterials(constructionInfoEntity.getMaterials())
                .addAllProtections(constructionInfoEntity.getProtections())
                .build();
    }

    private OsInfoProto toOsInfoProto(OsInfoEntity osInfoEntity) {
        var osType = switch (osInfoEntity.getOsType()) {
            case ANDROID -> OsTypeProto.ANDROID;
        };

        return OsInfoProto.newBuilder()
                .setOsType(osType)
                .setVersion(osInfoEntity.getVersion())
                .setOsName(osInfoEntity.getOsName())
                .setProcessorType(osInfoEntity.getProcessorType())
                .setProcessorCores(osInfoEntity.getProcessorCores())
                .setMaxProcessorFrequency(osInfoEntity.getMaxProcessorFrequency())
                .setProcessorConfigurationInfo(osInfoEntity.getProcessorConfigurationInfo())
                .setProcessorSize(osInfoEntity.getProcessorSize())
                .setGraphicProcessor(osInfoEntity.getGraphicProcessor())
                .build();
    }

    private MemoryInfoProto toMemoryInfoProto(MemoryInfoEntity memoryInfoEntity) {
        return MemoryInfoProto.newBuilder()
                .setRamType(memoryInfoEntity.getRamType())
                .setRamSizeGb(memoryInfoEntity.getRamSizeGb())
                .setHddSizeGb(memoryInfoEntity.getRamSizeGb())
                .setMemoryCardMaxSizeGb(memoryInfoEntity.getMemoryCardMaxSizeGb())
                .addAllSlots(memoryInfoEntity.getSlots())
                .addAllSupportCardsTypes(memoryInfoEntity.getSupportCards())
                .build();
    }

    private CameraInfoProto toCameraInfoProto(CameraInfoEntity cameraInfoEntity) {
        return CameraInfoProto.newBuilder()
                .setCameras(cameraInfoEntity.getCameras())
                .setMaxZoom(cameraInfoEntity.getMaxZoom())
                .addAllMegapixels(cameraInfoEntity.getMegapixels())
                .addAllSupportVideoResolutions(cameraInfoEntity.getSupportedVideoResolutions())
                .addAllSupportVideoCodecs(cameraInfoEntity.getSupportedVideoCodecs())
                .build();
    }

    private AudioInfoProto toAudioInfoProto(AudioInfoEntity audioInfoEntity) {
        return AudioInfoProto.newBuilder()
                .addAllAudioCodecs(audioInfoEntity.getAudioCodecs())
                .setFmSupport(audioInfoEntity.isFMSupported())
                .build();
    }

    private AdditionalInfoProto toAdditionalInfoProto(AdditionalInfoEntity additionalInfoEntity) {
        return AdditionalInfoProto.newBuilder()
                .setBiometricSupport(additionalInfoEntity.isBiometricSupport())
                .setHeadphoneInBox(additionalInfoEntity.isHeadphoneInBox())
                .setChargeInBox(additionalInfoEntity.isChargeInBox())
                .addAllBoxInItems(additionalInfoEntity.getBoxInItems())
                .build();
    }

    private AccumulatorInfoProto toAccumulatorInfoProto(AccumulatorInfoEntity accumulatorInfoEntity) {
        return AccumulatorInfoProto.newBuilder()
                .setAccumulatorType(accumulatorInfoEntity.getAccumulatorType())
                .setBatteryCapacity(accumulatorInfoEntity.getBatteryCapacity())
                .setFastCharge(accumulatorInfoEntity.isFastCharge())
                .setRemoteCharge(accumulatorInfoEntity.isRemoteChargeSupport())
                .setTtlMusicListening(accumulatorInfoEntity.getTtlMusicListening())
                .setTtlVideoViewing(accumulatorInfoEntity.getTtlVideoViewing())
                .setChargeInterface(accumulatorInfoEntity.getChargeInterface())
                .setOtgSupport(accumulatorInfoEntity.isOTGSupport())
                .setHeadphoneInterface(accumulatorInfoEntity.getHeadphoneInterface())
                .build();
    }

    private SizeInfoProto toSizeInfoProto(SizeInfoEntity sizeInfoEntity) {
        return SizeInfoProto.newBuilder()
                .setLength(sizeInfoEntity.getLength())
                .setWidth(sizeInfoEntity.getWidth())
                .setHeight(sizeInfoEntity.getHeight())
                .setWeight(sizeInfoEntity.getWeight())
                .build();
    }

}
