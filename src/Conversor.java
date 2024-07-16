import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Conversor {

    public double obtenerTasaConversion(String jsonRespuesta, String divisa) {
        JsonObject json = JsonParser.parseString(jsonRespuesta).getAsJsonObject();

        JsonObject tasaConversion = json.getAsJsonObject("conversion_rates");
        return tasaConversion.get(divisa).getAsDouble();
    }

}
