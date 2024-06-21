package com.authzed.api.v1;

import java.util.function.BiFunction;

import io.quarkus.grpc.MutinyClient;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1/schema_service.proto")
public class SchemaServiceClient implements SchemaService, MutinyClient<MutinySchemaServiceGrpc.MutinySchemaServiceStub> {

    private final MutinySchemaServiceGrpc.MutinySchemaServiceStub stub;

    public SchemaServiceClient(String name, io.grpc.Channel channel,
            BiFunction<String, MutinySchemaServiceGrpc.MutinySchemaServiceStub, MutinySchemaServiceGrpc.MutinySchemaServiceStub> stubConfigurator) {
        this.stub = stubConfigurator.apply(name, MutinySchemaServiceGrpc.newMutinyStub(channel));
    }

    private SchemaServiceClient(MutinySchemaServiceGrpc.MutinySchemaServiceStub stub) {
        this.stub = stub;
    }

    public SchemaServiceClient newInstanceWithStub(MutinySchemaServiceGrpc.MutinySchemaServiceStub stub) {
        return new SchemaServiceClient(stub);
    }

    @Override
    public MutinySchemaServiceGrpc.MutinySchemaServiceStub getStub() {
        return stub;
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.SchemaServiceOuterClass.ReadSchemaResponse> readSchema(
            com.authzed.api.v1.SchemaServiceOuterClass.ReadSchemaRequest request) {
        return stub.readSchema(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.SchemaServiceOuterClass.WriteSchemaResponse> writeSchema(
            com.authzed.api.v1.SchemaServiceOuterClass.WriteSchemaRequest request) {
        return stub.writeSchema(request);
    }
}
