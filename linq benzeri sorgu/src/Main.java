import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> myList = Arrays.asList("apple", "banana", "cherry");


        List<String> filteredList = myList.stream()
                .filter(s -> s.startsWith("c"))
                .collect(Collectors.toList());


        System.out.println("Filtrelenmiş Liste:");
        for (String item : filteredList) {
            System.out.println(item);
        }
    }
}
