package il.imthedoggo.reportrepair2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReportRepair2 {

        public static void main(String[] args) {
            List<Integer> list =  new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader("./src/il/imthedoggo/reportrepair1/input"))) {
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
                    loop3:
                    for (Integer k: list) {
                        if(j.equals(i) && k.equals(j)) {
                            continue loop3;
                        }
                        if((i+j+k)==2020) {
                            System.out.println("i = " + i);
                            System.out.println("j = " + j);
                            System.out.println("k = " + k);
                            System.out.println(i*j*k);
                            break loop1;
                        }
                    }
                }
            }
        }
    }
