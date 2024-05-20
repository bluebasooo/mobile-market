package ru.bluebasooo.market.mobilemarket.grpc.controller;

import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Controller;
import ru.bluebasooo.market.mobilemarket.grpc.proto.*;

@Controller
public class MobileAdminController extends MobileAdminServiceGrpc.MobileAdminServiceImplBase {

    @Override
    public void createMobile(MobileRequest request, StreamObserver<Empty> responseObserver) {
        try {
            responseObserver.onNext(Empty.getDefaultInstance());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void findMobile(MobileId request, StreamObserver<MobileResponse> responseObserver) {
        try {
            responseObserver.onNext(MobileResponse.newBuilder().build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void updateMobile(MobileRequest request, StreamObserver<Empty> responseObserver) {
        try {
            responseObserver.onNext(Empty.getDefaultInstance());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void deleteMobile(MobileId request, StreamObserver<Empty> responseObserver) {
        try {
            responseObserver.onNext(Empty.getDefaultInstance());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void findAllMobiles(Empty request, StreamObserver<MobilesResponse> responseObserver) {
        try {
            responseObserver.onNext(MobilesResponse.newBuilder().build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }
}
