import java.util.*;


public class Romans {

    public static boolean isRoman(String s) {
        return s.matches("[CLXVI]+");
    }


    public static int romanToArabic(String value) {
        String number = value.toUpperCase();
        List<RomanNumbers> numbersList = RomanNumbers.getReverseSortedValues();
        int result = 0;

        for (int i = 0; number.length() > 0; ) {
            RomanNumbers sym = numbersList.get(i);  // temporary var with enum constant

            if (number.startsWith(sym.name())) {    // if char or chars sequence equals enum const's name
                result += sym.getValue();   // then get const's value and add it to the result variable
                number = number.substring(sym.name().length()); // then create new string [entrance : ]
            } else {
                i++;    // else check next
            }
        }

        return result;
    }


    public static String arabicToRoman(int number) {
        List<RomanNumbers> numbersList = RomanNumbers.getReverseSortedValues();
        StringBuilder result = new StringBuilder();

        for (int i = 0; number > 0; ) {
            RomanNumbers sym = numbersList.get(i);  // temporary var with enum constant

            if (sym.getValue() <= number) { // if const's value less or equal to the number
                result.append(sym.name());  // append enum const's name to the result
                number -= sym.getValue();   // then subtract const's value from the number
            } else {
                i++;    // else check next
            }
        }

        return result.toString();
    }

    enum RomanNumbers {
        I(1),
        IV(4),
        V(5),
        IX(9),
        X(10),
        XL(40),
        L(50),
        XC(90),
        C(100);

        private int value;

        RomanNumbers(int value) {
            this.value = value;
        }


        public int getValue() {
            return value;
        }


        public static ArrayList<RomanNumbers> getReverseSortedValues() {
            ArrayList<RomanNumbers> reversedValues = new ArrayList<>(9);
            reversedValues.addAll(Arrays.asList(RomanNumbers.values()));
            Collections.reverse(reversedValues);

            return reversedValues;
        }

    }

}



