package fileLogic.editors;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.ZonedDateTime;

public class DateEditor implements JsonDeserializer<ZonedDateTime>, JsonSerializer<ZonedDateTime>  {
    @Override
    public ZonedDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String stringDateTime = json.getAsJsonPrimitive().getAsString();
        return ZonedDateTime.parse(stringDateTime);
    }

    @Override
    public JsonElement serialize(ZonedDateTime src, Type typeOfSrc, JsonSerializationContext context) {
        String stringDateTime = src.toString();
        return context.serialize(stringDateTime);
    }
}
