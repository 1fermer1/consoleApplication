package fileLogic;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Random;

public class RandomAdapter implements JsonSerializer<Random>, JsonDeserializer<Random> {
    @Override
    public JsonElement serialize(Random random, Type type, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("seed", random.nextLong());
        return jsonObject;
    }
    @Override
    public Random deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        long seed = jsonObject.get("seed").getAsLong();
        return new Random(seed);
    }


}
