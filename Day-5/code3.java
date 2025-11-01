import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        try {
            String text = s.nextLine();
            System.out.println("Original string: " + text);
            checkVowels(text);
        } catch (NoVowelsException e) {
            System.out.println("String does not contain any vowels");
        }
    }

    public static void checkVowels(String text) throws NoVowelsException {
        String lower = text.toLowerCase();
        boolean containsVowel = false;
        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                containsVowel = true;
                break;
            }
        }
        if (containsVowel) {
            System.out.println("String contains vowels");
        } else {
            throw new NoVowelsException();
        }
    }
}

class NoVowelsException extends Exception {
   
}