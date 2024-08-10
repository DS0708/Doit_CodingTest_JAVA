package Tree.트라이;

import java.io.*;
import java.util.*;

public class P069_14425 {
  public static void main(String[] args) throws Exception{
    Map<String,Integer> map = new TreeMap<>();
    map.put("b",3);
    map.put("a",1);
    map.put("c",2);

    for(Map.Entry<String,Integer> entry : map.entrySet()){
      //System.out.println(entry.getKey() + " : " +entry.getValue());
    }

    List<Map.Entry<String,Integer>> entryList = new ArrayList<>(map.entrySet());
    Collections.sort(entryList,(o1,o2)->{
      return o2.getValue() - o1.getValue();
    });

    for(Map.Entry<String,Integer> entry : entryList) System.out.println(entry.getKey() + " : " +entry.getValue());

  }
}

