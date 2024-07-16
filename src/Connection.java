import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Connection {

    static final String api_key = "26bd0b1ecdb4a76e23d28d69";
    private static final String api_url = "https://v6.exchangerate-api.com/v6/" + api_key + "/latest/";

    public static void convertirValor (String monedaInicial, String monedaConvertida, double valor) throws IOException, InterruptedException {
        String url = api_url + monedaInicial;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Conversor monedaUtil = new Conversor();
        double tasa = monedaUtil.obtenerTasaConversion(response.body(), monedaConvertida);
        if (tasa == 0){
            System.out.println("");
        }
        else{
            double resultado = valor * tasa;
            System.out.println("El monto " + valor + " " +
                    "(" + monedaInicial + ")" +" equivale a --> " + resultado + " " +
                    "(" + monedaConvertida + ")\n"
            );
        }
    }
}
