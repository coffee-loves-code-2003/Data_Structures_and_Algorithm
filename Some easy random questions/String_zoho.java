import java.util.*;

public class String_zoho {
    public static void main(String[] args) {
        Scanner rs = new Scanner(System.in);
        TreeMap<Integer, String> map = new TreeMap<>();
        String input = rs.nextLine();
        String[] inputs = input.split(" ");
        int inputs_length = inputs.length;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < inputs_length; i++) {
            StringBuilder sb = new StringBuilder();
            int string_length = inputs[i].length();
            int index = 0;
            int multiplier = 1; // To handle multi-digit index
            for (int j = string_length - 1; j >= 0; j--) {
                char ch = inputs[i].charAt(j);
                if (Character.isDigit(ch)) {
                    index += (ch - '0') * multiplier;
                    multiplier *= 10;
                } else {
                    sb.insert(0, ch); // Insert characters in reverse order
                }
            }
            map.put(index, sb.toString());
        }
        for (Map.Entry<Integer, String> object : map.entrySet()) {
            result.append(object.getValue()).append(" ");
        }
        System.out.println(result.toString());
    }
}
