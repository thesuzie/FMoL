import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Alice {

  public static void main(String[] args) {
    try {
      HashMap<Character,Integer> letter_count = new HashMap<>();
      HashMap<Character, HashMap<Character,Integer>> adjacent_count = new HashMap<>();
      HashMap<Character, Float> char_prob = new HashMap<>();
      HashMap<Character, HashMap<Character,Float>> transition_prob = new HashMap<>();
      int total_chars= 1;
      File alice = new File("././alice.txt");

      FileReader a = new FileReader(alice);
      char x = (char) a.read();
      letter_count.put(x,1);


      while (a.ready()){
        char y = (char) a.read();
        if(letter_count.containsKey(y)){
          letter_count.put(y, letter_count.get(y)+1);
        }else{
          letter_count.put(y,1);
        }
        if(adjacent_count.containsKey(x)){
          if(adjacent_count.get(x).containsKey(y)){
            adjacent_count.get(x).put(y,adjacent_count.get(x).get(y)+1);
          }else{
            adjacent_count.get(x).put(y,1);
          }
        }else{
          adjacent_count.put(x, (HashMap<Character, Integer>) (new HashMap<>()).put(y,1));
        }

        x=y;
        total_chars++;
      }

      for (char k : letter_count.keySet()){
        char_prob.put(k, (float) (letter_count.get(k)/total_chars));

        for(char t : adjacent_count.get(k).keySet()){
          transition_prob.put(k,
              (HashMap<Character, Float>) (new HashMap<>()).put(t, adjacent_count.get(k).get(t)/total_chars));
        }
      }

      String generated = "";
      while(generated.length() < 20){
      // use calculated probabilities to generate words
      }


    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
