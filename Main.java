// You are given a array of strings, to have to group them based on similar anagrams, with duplicates removed, with additional constraints: Characters can be capital and small.

// Example:
// {'Good', "pan", "nap", "dog", "god"}

// Output
// [['Good', 'dog', 'god'],
// ['nap', 'pan']]
import java.util.*;

class Main {

  public static List<List<String>> groupAnagrams(String[] strs){
    Map<String, List> ans = new HashMap<String, List>();
    for(String s: strs){
      Set<Character> ch = new HashSet<>();
      for(int i = 0; i < s.length(); i++)
        ch.add(Character.toLowerCase(s.charAt(i)));
      Arrays.sort(ch.toArray());

      String key = String.valueOf(ch);
      if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
         ans.get(key).add(s);
    }

    return new ArrayList(ans.values());
  }

  public static List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        for (String str: strs) {
            int bitmask = 0;
            for (char ch : str.toCharArray()) {
                bitmask |= 1 << (ch - 'a');
            }
            map.putIfAbsent(bitmask, new ArrayList<>());
            map.get(bitmask).add(str);
        }
        return new ArrayList<>(map.values());
    }

  public static void main (String[] args) {
    System.out.println(groupAnagrams(new String[]{"Good", "pan", "nap", "dog", "god"}));
    System.out.println(groupAnagrams2(new String[]{"Good", "pan", "nap", "dog", "god"}));
  }
}