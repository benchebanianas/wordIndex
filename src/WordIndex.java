import java.io.*;
import java.util.*;

public class WordIndex {

    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> occurences = new HashMap<>();
        HashMap<String, Set<Integer>> lineOccurences = new HashMap<>();
        //File file = new File(args[0]);

        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String line;
        int lineNumber = 0;
        while ((line = br.readLine()) != null) {
            lineNumber++;
            //System.out.println(line);
            Scanner input = new Scanner(line);
            while (input.hasNext()) {
                String word  = input.next().toLowerCase();
                if(occurences.containsKey(word)){
                    lineOccurences.get(word).add(lineNumber/5 + 1);

                    occurences.put(word, occurences.get(word) + 1);
                }else{
                    occurences.put(word, 1);
                    Set<Integer> pageNumebrs = new HashSet<>();
                    pageNumebrs.add(lineNumber/5 +1);
                    lineOccurences.put(word, pageNumebrs);
                }
            }
        }

        Map<String, Integer> mapOcc = new TreeMap<>(occurences);
        Map<String, Set<Integer>> pageNum = new TreeMap<>(lineOccurences);
        System.out.println("Word count: " + mapOcc);
        System.out.println("page occur: " + pageNum);
    }
}
