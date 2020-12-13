package il.imthedoggo.toboggantrajectory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Toboggantrajectory {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("./src/il/imthedoggo/toboggantrajectory/map"))) {
            Scanner scan = new Scanner(br);

            List<List<Boolean>> xmasMap = new ArrayList<>();
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                List<Boolean> row = line.chars().mapToObj(s-> (s == '#')).collect(Collectors.toList());
                xmasMap.add(row);
            }

            int column = 0;
            int treesHit = 0;
            for (int x = 0;x<xmasMap.size();x++) {
                List<Boolean> row = xmasMap.get(x);
                Boolean isTree = row.get(column);
                if (isTree) {
                    treesHit++;
                }
                column= column+3;
                //column= column % row.size();

                if (column>=row.size()) {
                    column = column - row.size();
                }
            }
            System.out.println("trees hit: " + treesHit);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//First try
//
//    String line;
//    int pos = 0;
//    int treeAmount = 0;
//            while ((line = br.readLine()) != null) {
//                char[] charArray = line.toCharArray();
//
//                    System.out.println("amount of pos: " + pos);
//
//
//                    if (charArray[pos] == '#') {
//                        treeAmount++;
//                    }
//
//                    if ((pos+3) >= charArray.length) {
//                        pos = 3 - ((pos+3) - charArray.length);
//                    } else {
//                        pos = pos + 3;
//                        //next line
//                    }
//            }
//          System.out.println("amount of trees: " + treeAmount);