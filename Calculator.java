import MyExceptions.NumberIsOutOfRange;


public class Calculator {

    public static boolean isIncompatible(int n) {
        return n < 1 || n > 10; // check if number is incompatible (0 < n < 11 ? true : false)
    }


    public static String calculate(String a, String b, String op) throws NumberIsOutOfRange {
        int n1 = Romans.romanToArabic(a);
        int n2 = Romans.romanToArabic(b);

        if (isIncompatible(n1) | (isIncompatible(n2))) throw new NumberIsOutOfRange();

        int res = calculate(n1, n2, op);
        if (res < 1) return " ";   // roman number can't be less or equal 0

        return Romans.arabicToRoman(res);
    }


    public static int calculate(int a, int b, String op) throws NumberIsOutOfRange {

        if (isIncompatible(a) | (isIncompatible(b))) throw new NumberIsOutOfRange();

        switch (op) {
            case ("+"):
                return add(a, b);
            case ("-"):
                return subtract(a, b);
            case ("*"):
                return multiply(a, b);
            default:
                return divide(a, b);
        }
    }


    private static int multiply(int a, int b) {
        return a * b;
    }


    private static int subtract(int a, int b) {
        return a - b;
    }


    private static int add(int a, int b) {
        return a + b;
    }


    private static int divide(int a, int b) {
        return a / b;
    }

}
