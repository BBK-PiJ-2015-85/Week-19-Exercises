import java.util.Arrays;

public class Lambdas {

    //question 2
    public static int compare(String s1, String s2) {
        int compareFlag = 0;
        if (s1.contains("e") && !s2.contains("e")) {
            compareFlag = -1;
        } else if (s2.contains("e") && !s1.contains("e")) {
            compareFlag = 1;
        }
        return compareFlag;
    }

    //question 3
    public static String betterString(String s1, String s2, TwoStringPredicate tsp) {
        if (tsp.twoStringBoolean(s1, s2)) {
            return s1;
        } else {
            return s2;
        }
    }

    //question 4
    public static <T> T betterEntry(T e1, T e2, TwoElementPredicate tep) {
        if (tep.twoElementBoolean(e1, e2)) {
            return e1;
        } else {
            return e2;
        }
    }

    public static void main(String... args) { // varargs alternative to String[]
        String[] stringArray = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
        System.out.println("***** Question 1 *****");
        System.out.println("Original list: " + Arrays.asList(stringArray));
        Arrays.sort(stringArray, (s1, s2) -> s1.length() - s2.length());
        System.out.println("In order of length: " + Arrays.asList(stringArray));
        Arrays.sort(stringArray, (s1, s2) -> s2.length() - s1.length());
        System.out.println("In reverse length order: " + Arrays.asList(stringArray));
        Arrays.sort(stringArray, (s1, s2) -> s1.charAt(0) - s2.charAt(0));
        System.out.println("In alphabetical order: " + Arrays.asList(stringArray));
        Arrays.sort(stringArray, (s1, s2) -> {
            int compareFlag = 0;
            if (s1.contains("e") && !s2.contains("e")) {
                compareFlag = -1;
            } else if (s2.contains("e") && !s1.contains("e")) {
                compareFlag = 1;
            }
            return (compareFlag);
        });
        System.out.println("All that contain \"e\" first: " + Arrays.asList(stringArray));

        System.out.println("\n***** Question 2 *****");
        Arrays.sort(stringArray, (s1, s2) -> s1.length() - s2.length());
        System.out.println("Original list: " + Arrays.asList(stringArray));
        Arrays.sort(stringArray, (Lambdas::compare));
        System.out.println("All that contain \"e\" first using method reference: " + Arrays.asList(stringArray));


        System.out.println("\n***** Question 3 *****");
        String string1 = "test1";
        String string2 = "second test";
        System.out.println(Lambdas.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length()));
        System.out.println(Lambdas.betterString(string1, string2, (s1, s2) -> s1.contains("1")));

        System.out.println("\n***** Question 3 *****");
        System.out.println(Lambdas.betterEntry(string1, string2, (String s1, String s2) -> s1.length() > s2.length()));
        System.out.println(Lambdas.betterEntry(string1, string2, (String s1, String s2) -> s1.length() > s2.length()));
        System.out.println(Lambdas.betterEntry(10, 20, (x, y) -> x > y));
    }
}
