package hasmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestionNotas2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Double> estudiantes = new HashMap<>();

        int totalNotas = 0;
        int estudiantesGanan = 0;
        int estudiantesPierden = 0;
        int estudiantesRecuperacion = 0;
        int estudiantesSinRecuperacion = 0;
        double sumaPromedios = 0;

        System.out.print("Ingrese la cantidad de estudiantes: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el nombre del estudiante: ");
            String nombre = scanner.next();

            double nota1, nota2, nota3;

            do {
                System.out.print("Ingrese la nota 1 (0-5): ");
                nota1 = scanner.nextDouble();
            } while (nota1 < 0 || nota1 > 5);

            do {
                System.out.print("Ingrese la nota 2 (0-5): ");
                nota2 = scanner.nextDouble();
            } while (nota2 < 0 || nota2 > 5);

            do {
                System.out.print("Ingrese la nota 3 (0-5): ");
                nota3 = scanner.nextDouble();
            } while (nota3 < 0 || nota3 > 5);

            // Calcular promedio
            double promedio = (nota1 + nota2 + nota3) / 3;
            estudiantes.put(nombre, promedio);

            totalNotas += 3;
            sumaPromedios += promedio;

            if (promedio >= 3.5) {
                estudiantesGanan++;
            } else if (promedio > 2) {
                estudiantesPierden++;
                estudiantesRecuperacion++;
            } else {
                estudiantesPierden++;
                estudiantesSinRecuperacion++;
            }
        }

        double promedioGeneral = sumaPromedios / n;

        scanner.close();

        System.out.println("\nCantidad total de estudiantes validados: " + estudiantes.size());
        System.out.println("Cantidad total de notas ingresadas: " + totalNotas);
        System.out.println("Cantidad de estudiantes que ganan la materia: " + estudiantesGanan);
        System.out.println("Cantidad de estudiantes que pierden la materia: " + estudiantesPierden);
        System.out.println("Cantidad de estudiantes que pueden recuperar: " + estudiantesRecuperacion);
        System.out.println("Cantidad de estudiantes que pierden sin recuperación: " + estudiantesSinRecuperacion);
        System.out.println("Promedio de las notas finales obtenidas: " + promedioGeneral);

        System.out.println("\nListado de estudiantes y sus notas finales:");
        for (Map.Entry<String, Double> entry : estudiantes.entrySet()) {
            System.out.println("Nombre: " + entry.getKey() + " - Nota Final: " + entry.getValue());
        }
    }
}
