package il.imthedoggo.reportrepair1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReportRepair {

    public static void main(String[] args) {
        List<Integer> list =  new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("./src/main/java/il/imthedoggo/reportrepair1/input"))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Integer.valueOf(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        loop1:
        for (Integer i : list) {
            loop2:
            for (Integer j: list) {
                if(j.equals(i)) {
                    continue loop2;
                }
                if((i+j)==2020) {
                    System.out.println("i = " + i);
                    System.out.println("j = " + j);
                    System.out.println(i*j);
                    break loop1;
                }
            }
        }
    }
}