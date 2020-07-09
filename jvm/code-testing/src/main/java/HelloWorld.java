
import models.Person;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.time.Month;
import java.util.*;

public class HelloWorld {

    private static final Integer MAX_ITERATIONS = 10000000;

    /**
     * Función principal para la ejecución del programa.
     * @param args
     */
    public static void main(String[] args) {
        // basicExercises();
        optimizeExercises();

        fullTestMethod1WithStringBuilder();
        fullTestMethod2WithStringUtils();
        fullTestMethod3WithChars();

    }

    private static void basicExercises() {
        final String MESSAGE = "Este es un mensaje constante";
        printMessage(MESSAGE);
        variablesTypes();
        showDialog();
        operations();
        qualifications();
        salaryCalculate();
        seedCapital();
        sellCars();
        studentQualifications();
        sumPowTwo();
        hoursToWeeks();
        coefficient();
    }

    /**
     * Impresión en consola
     */
    private static void printMessage(String message) {
        System.out.println(message);
        System.out.println("Hola que tal, mi nombre es Arturo López");
        System.out.println("Estos son ejercicios de programación");
    }

    /**
     * Tipos de variables primitivos.
     */
    private static void variablesTypes() {
        byte byteVariable = 127; //Rango -128 a 127 (8 bits)
        short shortVariable = 32767; //Rango -32,768 a 32,767 (16 bits)
        int intVariable = 2147483647; //Rango -2,147,483,648 a 2,147,483,647 (32 bits)
        long longVariable = 9223372036854775807L; //Rango -9,223,372,036,854,775,808 a -9,223,372,036,854,775,807 (64 bits)
        float floatDecimal = 3.45f; //Rango 1.4e-045 a 3.4e+038 (32 bits)
        double doubleDecimal = 1.8; //Rango 4.9e-324 a 1.8e+308 (64 bits)
        char charVariable = 'a';
        boolean boolVar = true;
        System.out.println("Byte Var: " + byteVariable);
        System.out.println("Short Var: " + shortVariable);
        System.out.println("Int Var: " + intVariable);
        System.out.println("Long Var: " + longVariable);
        System.out.println("Float Var: " + floatDecimal);
        System.out.println("Double Var: " + doubleDecimal);
        System.out.println("Char Var: " + charVariable);
        System.out.println("Boolean Var: " + boolVar);
        Scanner input = new Scanner(System.in);
        int valueInput;
        System.out.print("Ingresa un número: ");
        valueInput = input.nextInt();
        System.out.println("El valor ingresado es '" + valueInput + "'");
    }

    /**
     * Mostrar dialogo para capturar una cadena.
     */
    private static void showDialog() {
        String inputDialog = JOptionPane.showInputDialog("Ingresa una cadena: ");
        System.out.println(inputDialog);
        JOptionPane.showMessageDialog(null, inputDialog);
    }

    /**
     * Operaciones y operadores
     */
    private static void operations() {
        double base = 5, pow = 2;
        double randomNumber = Math.random();
        double totalValue = base * randomNumber;
        double squareValue = Math.sqrt(totalValue);
        double resultPow = Math.pow(totalValue, pow);
        long roundPow = Math.round(resultPow);
        System.out.println("Un valor aleatorio es: " + randomNumber);
        System.out.println("El valor por trabajar es: " + totalValue);
        System.out.println("La raíz cuadrada es: " + squareValue);
        System.out.println("Número '"+ base +"' multiplicado por '" + randomNumber + "' y el resultado '" + totalValue + "' elevado por '"+ pow +"' es: " + resultPow);
        System.out.println("El valor del resultado es: " + roundPow);
    }

    /**
     * Primer ejercicio para calcular e imprimir la suma de 3 calificaciones.
     */
    private static void qualifications() {
        final long SCORE_ONE = getRandomScore();
        final long SCORE_TWO = getRandomScore();
        final long SCORE_THREE = getRandomScore();
        final long TOTAL = SCORE_ONE + SCORE_TWO + SCORE_THREE;
        final long NUMBER_OF_SCORES = 3;
        final long AVERAGE_SCORE = Math.round(TOTAL / NUMBER_OF_SCORES);
        System.out.println("Primera calificación " + SCORE_ONE);
        System.out.println("Segunda calificación " + SCORE_TWO);
        System.out.println("Tercera calificación " + SCORE_THREE);
        System.out.println("La suma de las 3 calificaciones es: " + TOTAL);
        System.out.println("El promedio de las calificaciones es:  " + AVERAGE_SCORE);
        if (AVERAGE_SCORE > 90) {
            System.out.println("EL ALUMNO HA SOBRESALIDO EN LA MATERIA");
        } else if (AVERAGE_SCORE > 59 && AVERAGE_SCORE < 90) {
            System.out.println("EL ALUMNO HA OBTENIDO HA PASADO");
        } else {
            System.out.println("EL ALUMNO HA OBTENIDO UNA CALIFICACIÓN REPROBATORIA");
        }
    }

    /**
     * Obtener un valor aleatorio y con el redondeo aplicado, que representa una calificación aleatoria.
     * @return long - valor de la calificación
     */
    private static long getRandomScore() {
        double value = Math.random() * 100;
        return Math.round(value);
    }

    /**
     * Función para calcular el salario de un empleado.
     */
    private static void salaryCalculate() {
        final int WORKING_DAYS = 7;
        double salaryByHour = getRandomScore();
        double workHours = 8 * WORKING_DAYS;
        double salary = Math.round(salaryByHour * workHours);

        System.out.println("El salario por hora es de $" + salaryByHour +" MXN");
        System.out.println("El empleado ha trabajado los " + WORKING_DAYS + " días, en jornadas de 8 horas y su salario calculado es de $" + salary +" MXN");
    }

    /**
     * Mostrar el capital semilla y calcular el ingreso de cada empleado:
     * Detalles del ejercicio:
     * Guillermo tiene N dólares.
     * Luis tiene la mitad de lo que posee Guillermo.
     * Juan tiene la mitad de lo que posee Luis y Guillermo juntos.
     * Calcular e imprimir la cantidad de dinero que tienen entre los tres.
     */
    private static void seedCapital() {
        final long PERSON_ONE = getRandomScore();                       //Guillermo
        final long PERSON_TWO = PERSON_ONE / 2;                         //Luis
        final long PERSON_THREE = (PERSON_ONE + PERSON_TWO) / 2;        //Juan
        final long PERSON_TOTAL = PERSON_ONE + PERSON_TWO + PERSON_THREE;
        System.out.println("La cantidad de salario que percibe Guillermo es $" + PERSON_ONE +" MXN");
        System.out.println("La cantidad de salario que percibe Luis es $" + PERSON_TWO +" MXN");
        System.out.println("La cantidad de salario que percibe Juan es $" + PERSON_THREE +" MXN");
        System.out.println("La cantidad de dinero de los tres es $" + PERSON_TOTAL +" MXN");
    }

    /**
     * Calcular el salario de un vendedor de carros.
     * Detalles del ejercicio:
     * Una compañía de venta de carros usados, paga a su personal de ventas un salario de $1,000 pesos mensuales,
     * más una comisión de $150 pesos por cada carro vendido, más el 5% del valor de venta por carro.
     * Hacer un programa que calcule e imprima el salario mensual del vendedor.
     */
    private static void sellCars() {
        final long SALARY = 1000;
        final long COMMISSION_INCOME = 150;
        final float COMMISSION_PERCENTAGE = 0.05f;

        for(int month = 1; month <= 12; month++) {
            final long CAR_SALES = getRandomScore();
            long carSalesTotal = 0;
            for (int i = 0; i < CAR_SALES; i++) {
                carSalesTotal += getRandomScore() * 1000;
            }
            long total = (long) (SALARY + (CAR_SALES * COMMISSION_INCOME) + (carSalesTotal * COMMISSION_PERCENTAGE));
            System.out.println("$" + total + " pesos es el salario del vendedor en el mes de '" + Month.of(month).toString() + "' por " + CAR_SALES +" carros vendidos con un monto de $" + carSalesTotal + " pesos");
        }
    }

    /**
     * Calcular las calificaciones finales de un estudiante.
     * Detalles del ejercicio:
     * Las calificación final de un estudiante de informática se calculan con base a las calificaciones de cuatro
     * aspectos de su rendimiento académico: participación, primer examen parcial, segundo examen parcial y examen final.
     * Sabiendo que las calificaciones anteriores entran en la calificación final con ponderaciones de un 10%, 25%, 25% y
     * 40%.
     * Hacer un programa que calcule la calificación final de los estudiantes.
     */
    private static void studentQualifications() {
        float participation, firstExam, secondExam, thirdExam, qualification;
        participation = getRandomScore();
        firstExam = getRandomScore();
        secondExam = getRandomScore();
        thirdExam = getRandomScore();

        participation *= 0.10;
        firstExam *= 0.25;
        secondExam *= 0.25;
        thirdExam *= 0.40;

        qualification = participation + firstExam + secondExam + thirdExam;
        System.out.println("La calificación del alumno es: " + qualification);
    }

    /**
     * Hacer un programa que calcule el cuadrado de una suma
     * (a+b)^2 = a^2 + b^2 + 2ab
     */
    private static void sumPowTwo() {
        double firstValue = 13;
        double secondValue = 30;
        double total = Math.pow((firstValue + secondValue), 2);
        double firstValuePow2 = Math.pow(firstValue, 2);
        double secondValuePow2 = Math.pow(secondValue, 2);
        double multiply = 2 * firstValue * secondValue;
        double total2 = firstValuePow2 + secondValuePow2 + multiply;

        System.out.println("(a+b)^2 = a^2 + b^2 + 2ab: " + total);

        System.out.println("a^2: " + firstValuePow2);
        System.out.println("b^2: " + secondValuePow2);
        System.out.println("2ab: " + multiply);
        System.out.println(total + " = " + total2);
    }

    /**
     * Construir un programa que, dado un número total de horas, devuelve el número de semanas, días y horas
     * equivalentes. Por ejemplo, dado un total de 1000 horas debe mostrar 5 semanas, 6 días y 16 horas.
     */
    private static void hoursToWeeks() {
        final int TOTAL_HOURS = 1000;
        int weeks, days, hours;

        weeks = TOTAL_HOURS / 168;
        days = TOTAL_HOURS % 168 / 24;
        hours = TOTAL_HOURS % 24;

        System.out.println("Semanas : " + weeks);
        System.out.println("Dias : " + days);
        System.out.println("Horas : " + hours);
    }

    /**
     * Construir un programa que calcule y muestre en pantalla las raíces de la ecuación de segundo grado de
     * coeficientes reales.
     * ax^2 + bx + c = 0
     * x = (-b +- square (b^2 - 4ac)) / 2a
     */
    private static void coefficient() {
        int a = 1, b = 2, c = 3;
        double square = Math.sqrt(Math.abs(Math.pow(b, 2) - (4 * a * c)));

        double x1 = ((b * -1) + square) / (2 * a);
        double totalX1 = (a * Math.pow(x1, 2)) + (b * x1) + c;

        double x2 = ((b * -1) - square) / (2 * a);
        double totalX2 = (a * Math.pow(x2, 2)) + (b * x2) + c;
        System.out.println("x1 : " + x1);
        System.out.println("x2 : " + x2);
        System.out.println("Total x1 : " + totalX1);
        System.out.println("Total x2: " + totalX2);
    }

    /** Optimizaciones **/
    private static void optimizeExercises() {
        System.out.println("Optimizaciones");
        String uuid = UUID.randomUUID().toString();
        System.out.println("StringBuilder");
        System.out.println(replaceCharsWithStringBuilder(uuid));
        System.out.println(replaceCharsWithStringBuilder(uuid.substring(0, 4)));
        System.out.println(replaceCharsWithStringBuilder(uuid.substring(0,1)));
        System.out.println(replaceCharsWithStringBuilder(""));
        System.out.println(replaceCharsWithStringBuilder(null));
        System.out.println("StringUtils");
        System.out.println(replaceCharsWithStringUtils(uuid));
        System.out.println(replaceCharsWithStringUtils(uuid.substring(0, 4)));
        System.out.println(replaceCharsWithStringUtils(uuid.substring(0,1)));
        System.out.println(replaceCharsWithStringUtils(""));
        System.out.println(replaceCharsWithStringUtils(null));
        System.out.println("Chars");
        System.out.println(replaceCharsWithChars(uuid));
        System.out.println(replaceCharsWithChars(uuid.substring(0, 4)));
        System.out.println(replaceCharsWithChars(uuid.substring(0,1)));
        System.out.println(replaceCharsWithChars(""));
        System.out.println(replaceCharsWithChars(null));
    }

    /** Método 1 **/
    private static void fullTestMethod1WithStringBuilder() {
        long start = System.nanoTime();
        System.out.println("StringBuilder");
        String uuid = UUID.randomUUID().toString();
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            replaceCharsWithStringBuilder(uuid);
        }
        System.out.println("Tiempo total de la ejecución: " + ((System.nanoTime()-start) / 1000000) + "ms");
    }

    private static String replaceCharsWithStringBuilder(String token) {
        if (token != null) {
            if (token.length() > 0 && token.length() > 4) {
                StringBuilder sb = new StringBuilder();
                String part = token.substring(0, 4);
                sb.append(part);
                for (int i = 5; i < token.length(); i++) {
                    sb.append("*");
                }
                return sb.toString();
            } else {
                return  token;
            }
        }
        return "";
    }

    /** Método 2 **/
    private static void fullTestMethod2WithStringUtils() {
        long start = System.nanoTime();
        System.out.println("StringUtils");
        String uuid = UUID.randomUUID().toString();
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            replaceCharsWithStringUtils(uuid);
        }
        System.out.println("Tiempo total de la ejecución: " + ((System.nanoTime()-start) / 1000000) + "ms");
    }

    private static String replaceCharsWithStringUtils(String token) {
        if (token != null) {
            if (token.length() > 0 && token.length() > 4) {
                String masking = StringUtils.repeat("x", 36);
                return StringUtils.overlay(token, masking, 4, 36);
            } else {
                return token;
            }
        }
        return "";
    }

    /** Método 3 **/
    private static void fullTestMethod3WithChars() {
        long start = System.nanoTime();
        System.out.println("Chars");
        String uuid = UUID.randomUUID().toString();
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            replaceCharsWithChars(uuid);
        }
        System.out.println("Tiempo total de la ejecución: " + ((System.nanoTime()-start) / 1000000) + "ms");
    }

    private static String replaceCharsWithChars(String token) {
        if (token != null) {
            if (token.length() > 0 && token.length() > 4) {
                char[] tokenChars = token.toCharArray();
                token.getChars(0, 4, tokenChars, 0);
                Arrays.fill(tokenChars, 4, tokenChars.length, '*');
                return new String(tokenChars);
            } else {
                return token;
            }
        }
        return "";
    }

}
