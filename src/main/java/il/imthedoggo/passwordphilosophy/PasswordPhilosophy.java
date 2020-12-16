package il.imthedoggo.passwordphilosophy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class PasswordPhilosophy {

    public static void main(String[] args) {
        List<String> passwordList =  new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("./src/main/java/il/imthedoggo/passwordphilosophy/passwords"))) {
            String line;
            while ((line = br.readLine()) != null) {
                passwordList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int correctPwCounter =  0;
        for (String l: passwordList) {
            String[] split = l.split(" ");
            String range = split[0];
            String findChar = split[1];
            String password = split[2];
            System.out.println(range + " " + findChar + " " + password);

            String[] minMax = range.split("-");
            String min = minMax[0];
            String max = minMax[1];
            int lower = Integer.parseInt(min);
            int upper = Integer.parseInt(max);
            System.out.println(lower + " " + upper);

            String[] charArray = findChar.split(":");
            String givenChar = charArray[0];
            char charChar = givenChar.charAt(0);
            System.out.println(charChar);

            int counter = 0;
            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) == charChar) {
                    counter++;
                }
            }

            if (counter >= lower && counter <= upper) {
                correctPwCounter++;
            }
            System.out.println("correct PWs: " + correctPwCounter);
        }
    }
}