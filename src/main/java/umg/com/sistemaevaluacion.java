import java.util.Scanner;

public class sistemaevaluacion {

    // Función que calcula el promedio de un arreglo de notas
    public static double calcularPromedio(double[] notas) {
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.length;
    }

    // Función que retorna la calificación literal
    public static char obtenerLiteral(double promedio) {
        if (promedio >= 90) return 'A';
        else if (promedio >= 80) return 'B';
        else if (promedio >= 70) return 'C';
        else if (promedio >= 60) return 'D';
        else return 'F';
    }

    // Función que indica si el estudiante aprueba
    public static boolean estaAprobado(char literal) {
        return literal == 'A' || literal == 'B' || literal == 'C';
    }

    // Procedimiento que muestra el resultado
    public static void mostrarResultado(String nombre, double[] notas) {
        double promedio = calcularPromedio(notas);
        char literal = obtenerLiteral(promedio);
        boolean aprobado = estaAprobado(literal);

        System.out.println("Estudiante: " + nombre);
        System.out.print("Notas: [");
        for (int i = 0; i < notas.length; i++) {
            System.out.print(notas[i]);
            if (i < notas.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.printf("Promedio: %.2f%n", promedio);
        System.out.println("Literal: " + literal);
        System.out.println("Resultado: " + (aprobado ? "Aprobado" : "Reprobado"));
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántos estudiantes deseas ingresar?: ");
        int totalEstudiantes = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        String[] nombres = new String[totalEstudiantes];
        double[][] todasLasNotas = new double[totalEstudiantes][];

        for (int i = 0; i < totalEstudiantes; i++) {
            System.out.print("Ingrese el nombre del estudiante #" + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();

            System.out.print("¿Cuántas notas tiene " + nombres[i] + "?: ");
            int cantidadNotas = scanner.nextInt();
            double[] notas = new double[cantidadNotas];

            for (int j = 0; j < cantidadNotas; j++) {
                System.out.print("Ingrese la nota #" + (j + 1) + ": ");
                notas[j] = scanner.nextDouble();
            }

            scanner.nextLine(); // Limpiar el buffer
            todasLasNotas[i] = notas;
        }

        System.out.println("\n=== Resultados Finales ===");
        for (int i = 0; i < totalEstudiantes; i++) {
            mostrarResultado(nombres[i], todasLasNotas[i]);
        }

        scanner.close();
    }
}
