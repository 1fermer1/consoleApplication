package fileLogic;
import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import com.google.gson.*;

public class ZonedDateTimeAdapter implements JsonDeserializer<ZonedDateTime>, JsonSerializer<ZonedDateTime> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;

    @Override
    public ZonedDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        String datetimeString = json.getAsJsonPrimitive().getAsString();
        return ZonedDateTime.parse(datetimeString, formatter);
    }

    @Override
    public JsonElement serialize(ZonedDateTime zonedDateTime, Type type, JsonSerializationContext context) {
        String value = formatter.format(zonedDateTime);
        return context.serialize(value);
    }
}
