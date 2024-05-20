package ru.bluebasooo.market.mobilemarket.service;

import org.springframework.stereotype.Service;
import ru.bluebasooo.market.mobilemarket.data.mobile.MobileAdminDao;
import ru.bluebasooo.market.mobilemarket.grpc.proto.MobileRequest;
import ru.bluebasooo.market.mobilemarket.grpc.proto.MobileResponse;
import ru.bluebasooo.market.mobilemarket.grpc.proto.MobilesResponse;
import ru.bluebasooo.market.mobilemarket.service.mapper.MobileAdminDtoToEntityMapper;

@Service
public class MobileAdminService {
    
    private final MobileAdminDao mobileAdminDao;
    private final MobileAdminDtoToEntityMapper mapper;

    public MobileAdminService(
            MobileAdminDao mobileAdminDao,
            MobileAdminDtoToEntityMapper mapper) {
        this.mobileAdminDao = mobileAdminDao;
        this.mapper = mapper;
    }
    
    public void saveMobile(MobileRequest request) {
        var entity = mapper.toEntity(request);

        mobileAdminDao.create(entity);
    }

    public MobileResponse findMobile(String id) {
        var entity = mobileAdminDao.find(id)
                .orElseThrow(() -> new RuntimeException("No mobile admin found with id: " + id)); //TODO custom exception

        return mapper.toResponse(entity);
    }

    public void updateMobile(MobileRequest request) {
        var entity = mapper.toEntity(request);

        mobileAdminDao.update(entity);
    }

    public void deleteMobile(String id) {
        mobileAdminDao.delete(id);
    }

    public MobilesResponse findAllMobiles() {
        var entityList = mobileAdminDao.findAll();

        return mapper.toResponse(entityList);
    }
    
}
