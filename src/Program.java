import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Program {
    public static void main(String[] str){
        List<Integer> arr = IntStream.range(1, 11).boxed().collect(Collectors.toList());
        arr.set(2,6);
        arr.set(3,7);
        arr.set(4,8);

        FindDuplicates2(arr);
    }
    public static void FindDuplicates1(List<Integer> arr){
        Map<Integer, Integer> duplicates = new HashMap<>();

        arr.forEach(e-> duplicates.put(e, duplicates.get(e) == null ? 1 : duplicates.get(e) + 1));

        List<Map.Entry<Integer, Integer>> result = duplicates.entrySet().stream().filter(e-> e.getValue() > 1).collect(Collectors.toList());
        result.forEach(e-> System.out.println(String.format("Число/цифра %d повторяется %d раз",e.getKey(), e.getValue())));

    }
    public static void FindDuplicates2(List<Integer> arr){
        var result = arr.stream().collect(Collectors.groupingBy(e->e, Collectors.counting())).entrySet().stream().filter(r->r.getValue() > 1);
        result.forEach((k)-> System.out.println( k.getKey() + " " + k.getValue()) );
    }
}
