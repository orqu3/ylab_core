package homework_2.task_3;

/*
  Task3
      Реализовать функцию нечеткого поиска

              fuzzySearch("car", "ca6$$#_rtwheel"); // true
              fuzzySearch("cwhl", "cartwheel"); // true
              fuzzySearch("cwhee", "cartwheel"); // true
              fuzzySearch("cartwheel", "cartwheel"); // true
              fuzzySearch("cwheeel", "cartwheel"); // false
              fuzzySearch("lw", "cartwheel"); // false
   */
public class Main {

    public static void main(String[] args) {
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel"));
        System.out.println(fuzzySearch("cwhl", "cartwheel"));
        System.out.println(fuzzySearch("cwhee", "cartwheel"));
        System.out.println(fuzzySearch("cartwheel", "cartwheel"));
        System.out.println(fuzzySearch("cwheeel", "cartwheel"));
        System.out.println(fuzzySearch("lw", "cartwheel"));
    }

    private static boolean fuzzySearch(String target, String original) {
        if (target == null || original == null
                || original.length() < target.length()
                || original.length() == target.length()
                && original.charAt(0) != target.charAt(0)) {
            return false;
        }
        int i = 0;
        for (int j = 0; j < original.length(); ++j) {
            char targetChar = target.charAt(i);
            char originalChar = original.charAt(j);
            if (targetChar == originalChar) {
                ++i;
                if (i == target.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}


