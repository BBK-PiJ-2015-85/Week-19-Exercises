import java.util.Arrays;

public class Lambdas {

    public static int compare(String s1, String s2) {
        int compareFlag = 0;
        if (s1.contains("e") && !s2.contains("e")) {
            compareFlag = -1;
        } else if (s2.contains("e") && !s1.contains("e")) {
            compareFlag = 1;
        }
        return compareFlag;
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


    }
}
