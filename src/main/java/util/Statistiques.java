package main.java.util;

import java.util.*;

public class Statistiques {

    public static Map<Integer, List<String>> countWords(String motif, String s, Integer tailleMin, Integer presence){

        Map<String, Integer> result = new TreeMap<>();
        Arrays.stream(s.replaceAll("\n", " ").split(" "))
        .map(c -> c.replaceAll("\\{", "")
                   .replaceAll("\\(", "")
                   .replaceAll("\\[", "")
                   .replaceAll("]", "")
                   .replaceAll("\\.", "")
                   .replaceAll("^−.*", "")
                   .replaceAll(",", "")
                   .replaceAll(";", "")
                   .replaceAll("\\)", ""))
                   .filter(a -> a.replaceAll("'", "").length() > tailleMin)
                   .map(a -> a.toLowerCase())
                   .forEach(b -> result.put(b, result.get(b) != null ? result.get(b) + 1 : 1));

        Map<Integer, List<String>> result_ = new TreeMap<>();
        result.entrySet().stream()
                .filter(a->a.getKey().length() > tailleMin )
                .filter(a->a.getValue() > presence )
                .map(a -> {
                    if (motif.equals(a.getKey())
                            || motif.equals(a.getKey().substring(1))
                            || motif.equals(a.getKey().substring(2))
                            || motif.equals(a.getKey().substring(0, a.getKey().length() -1))
                            || motif.equals(a.getKey().substring(0, a.getKey().length() -2))
                            ){
                        a.setValue(0);
                    }
                    return a;
                })
                .forEach(a -> {
            if (result_.get(a.getValue()) != null && a.getValue() > 0){
                List<String> liste = result_.get(a.getValue());
                liste.add(a.getKey());
                result_.put(a.getValue(), liste);
            }
            else if (a.getValue() > 0){
                List<String> liste = new ArrayList<>();
                liste.add(a.getKey());
                result_.put(a.getValue(), liste);
            }
        });

        return result_;
    }
}
