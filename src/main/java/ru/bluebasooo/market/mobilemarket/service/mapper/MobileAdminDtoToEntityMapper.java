package ru.bluebasooo.market.mobilemarket.service.mapper;

import org.springframework.stereotype.Component;
import ru.bluebasooo.market.mobilemarket.data.mobile.entity.mobile.MobileEntity;
import ru.bluebasooo.market.mobilemarket.grpc.proto.MobileId;
import ru.bluebasooo.market.mobilemarket.grpc.proto.MobileRequest;
import ru.bluebasooo.market.mobilemarket.grpc.proto.MobileResponse;
import ru.bluebasooo.market.mobilemarket.grpc.proto.MobilesResponse;

import java.util.List;

@Component
public class MobileAdminDtoToEntityMapper {

    private final MobileInfoAdminDtoToEntityMapper mobileInfoMapper;

    public MobileEntity toEntity(MobileRequest mobileRequest) {
        var builder = MobileEntity.builder()
                .price(mobileRequest.getPrice())
                .mobileInfo(mobileInfoMapper.toEntity(mobileRequest.getInfo()))
                .imgUrls(mobileRequest.getImgUrlsList());

        if (mobileRequest.hasId()) {
            builder = builder.id(mobileRequest.getId().getId());
        }

        return builder.build();
    }

    public MobileResponse toResponse(MobileEntity mobileEntity) {
        return MobileResponse.newBuilder()
                .setId(MobileId.newBuilder()
                        .setId(mobileEntity.getId())
                        .build())
                .setPrice(mobileEntity.getPrice())
                .setInfo(mobileInfoMapper.toDto(mobileEntity.getMobileInfo()))
                .addAllImgUrls(mobileEntity.getImgUrls())
                .build();
    }

    public MobilesResponse toResponse(List<MobileEntity> mobileEntities) {
        var mobileResponses = mobileEntities.stream()
                .map(this::toResponse)
                .toList();

        return MobilesResponse.newBuilder()
                .addAllMobiles(mobileResponses)
                .build();
    }
}
