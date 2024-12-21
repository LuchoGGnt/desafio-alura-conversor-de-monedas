package principal;

import logica.ConversorDeMonedas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String monedaBase = "", monedaObjetivo = "";
        double cantidad;

        while (true) {
            System.out.println("""
                ***************************************
                \tSISTEMA CONVERSOR DE MONEDAS
                ***************************************
                
                1) Dólar => Peso argentino
                2) Peso argentino => Dólar
                3) Dólar => Real brasileño
                4) Real brasileño => Dólar
                5) Dólar => Peso colombiano
                6) Peso colombiano => Dólar
                7) Otros
                
                9) Salir
                
                ***************************************
                """);
            System.out.print("Elija una opción válida: ");
            int opcion;
            try {
                opcion = input.nextInt();
                if (opcion < 1 || (opcion > 7 && opcion != 9)) {
                    throw new IllegalArgumentException("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error. " + e.getMessage());
                input.nextLine();
                continue;
            }

            if (opcion == 9) {
                System.out.println("Gracias por usar el conversor de monedas." +
                        "Que tenga un buen día :)");
                break;
            }

            ConversorDeMonedas conversor = new ConversorDeMonedas();

            switch (opcion) {
                case 1:
                    monedaBase = "USD"; monedaObjetivo = "ARS";
                    break;
                case 2:
                    monedaBase = "ARS"; monedaObjetivo = "USD";
                    break;
                case 3:
                    monedaBase = "USD"; monedaObjetivo = "BRL";
                    break;
                case 4:
                    monedaBase = "BRL"; monedaObjetivo = "USD";
                    break;
                case 5:
                    monedaBase = "USD"; monedaObjetivo = "COP";
                    break;
                case 6:
                    monedaBase = "COP"; monedaObjetivo = "USD";
                    break;
                case 7:
                    System.out.print("\nDijite el código ISO de la divisa base: ");
                    monedaBase = input.next().trim().replace(" ", "").toUpperCase();
                    System.out.print("\nDijite el código ISO de la divisa objetivo: ");
                    monedaObjetivo = input.next().trim().replace(" ", "").toUpperCase();
                    break;
            }

            System.out.print("\nIngrese el monto que desea convertir: ");
            double montoConvertido;

            try {
                cantidad = input.nextDouble();
                montoConvertido = conversor.convertirMoneda(monedaBase, monedaObjetivo, cantidad);
                if (cantidad <= 0) {
                    throw new IllegalArgumentException("Monto inválido.");
                }
            } catch (Exception e) {
                System.out.println("Error. " + e.getMessage());
                input.nextLine();
                continue;
            }

            System.out.println("\nEl valor " + cantidad + " [" + monedaBase +
                    "] corresponde al valor final de => " + montoConvertido +
                    " [" + monedaObjetivo + "]" );
        }
    }
}
