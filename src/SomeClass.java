import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SomeClass {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("jan");
        names.add("piotr");
        names.add("tomek");
        names.add("john");

        //sprwadzi ta liste
        //usunie wszystkich ktorzy zaczynaja se na litere j
        //a z pozostałych imion zrobi kapitałki

        List<String> newNames = oldJava(names);
        System.out.println(newNames);
    }

    private static List<String> oldJava(List<String> names) {
        List<String> newNames = new ArrayList<>();
        for(String name: names){
            if(!name.startsWith("j")){
                String upperCasedName = name.toUpperCase();
                newNames.add(upperCasedName);
            }
        }
        return newNames;
    }

    private static List<String> newJava(List<String> names) {
            return names.stream()
                .filter(name -> !name.startsWith("j"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
