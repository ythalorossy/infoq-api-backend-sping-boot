package com.example.copsboot.infrastructure.json;
import com.example.orm.jpa.EntityId;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;
import java.io.IOException;
@JsonComponent
public class EntityIdJsonSerializer extends JsonSerializer<EntityId> {
    @Override
    public void serialize(EntityId entityId, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(entityId.asString());
    }
}