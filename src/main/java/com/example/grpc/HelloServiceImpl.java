package com.example.grpc;

import com.example.grpc.gencode.HelloRequest;
import com.example.grpc.gencode.HelloResponse;
import com.example.grpc.gencode.HelloServiceGrpc.HelloServiceImplBase;

import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceImplBase {
     
    @Override
    public void hello(
      HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
 
        String greeting = new StringBuilder()
          .append("Hello, ")
          .append(request.getFirstName())
          .append(" ")
          .append(request.getLastName())
          .toString();
 
        HelloResponse response = HelloResponse.newBuilder()
          .setGreeting(greeting)
          .build();
 
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
