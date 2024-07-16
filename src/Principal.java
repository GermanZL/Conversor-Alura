import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Conexion conversion = new Conexion();
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        System.out.println("\nBienvenido al conversor de monedas\n");
        String menu = """
                1) Dolar --> Peso Chileno
                2) Peso Chileno --> Dolar
                3) Dolar --> Peso Argentino
                4) Peso Argentino --> Dolar
                5) Dólar --> Peso colombiano
                6) Peso colombiano --> Dólar 
                7) Salir 
                """;

        while ( opcion != 7 ) {
            System.out.println(menu);
            System.out.println("Elija una opción:");
            opcion = teclado.nextInt();

            if (opcion == 7){
                System.out.println("Adios");
                break;
            }

            System.out.println("Ingresar monto a convertir: ");
            double monto = teclado.nextDouble();

            try{
                switch (opcion){
                    case 1:
                        conversion.convertirValor("USD", "CLP", monto);
                        break;
                    case 2:
                        conversion.convertirValor("CLP", "USD", monto);
                        break;
                    case 3:
                        conversion.convertirValor("USD", "ARS", monto);
                        break;
                    case 4:
                        conversion.convertirValor("ARS", "USD", monto);
                        break;
                    case 5:
                        conversion.convertirValor("USD", "COP", monto);
                        break;
                    case 6:
                        conversion.convertirValor("COP", "USD", monto);
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
            }
            catch (IOException | InterruptedException e){
                System.out.println("Error al realizar la conversion: " + e.getMessage());
            }
        }
        teclado.close();
    }
}