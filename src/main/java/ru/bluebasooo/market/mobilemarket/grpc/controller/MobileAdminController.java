package ru.bluebasooo.market.mobilemarket.grpc.controller;

import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Controller;
import ru.bluebasooo.market.mobilemarket.grpc.proto.*;
import ru.bluebasooo.market.mobilemarket.service.MobileAdminService;

@Controller
public class MobileAdminController extends MobileAdminServiceGrpc.MobileAdminServiceImplBase {

    private final MobileAdminService mobileAdminService;

    public MobileAdminController(MobileAdminService mobileAdminService) {
        this.mobileAdminService = mobileAdminService;
    }

    @Override
    public void createMobile(MobileRequest request, StreamObserver<Empty> responseObserver) {
        try {
            mobileAdminService.saveMobile(request);

            responseObserver.onNext(Empty.getDefaultInstance());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void findMobile(MobileId request, StreamObserver<MobileResponse> responseObserver) {
        try {
            var response = mobileAdminService.findMobile(request.getId());

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void updateMobile(MobileRequest request, StreamObserver<Empty> responseObserver) {
        try {
            mobileAdminService.updateMobile(request);

            responseObserver.onNext(Empty.getDefaultInstance());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void deleteMobile(MobileId request, StreamObserver<Empty> responseObserver) {
        try {
            mobileAdminService.deleteMobile(request.getId());

            responseObserver.onNext(Empty.getDefaultInstance());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void findAllMobiles(Empty request, StreamObserver<MobilesResponse> responseObserver) {
        try {
            var response = mobileAdminService.findAllMobiles();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }
}
