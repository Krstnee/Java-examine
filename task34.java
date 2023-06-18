import java.util.ArrayList;
import java.util.List;

public class task34 {
    public static void main(String[] args) {
        List<String> names1 = new ArrayList<>();
        names1.add("Катя");
        names1.add("Маша");
        names1.add("Арина");

        List<String> names2 = new ArrayList<>();
        names2.add("Бэтмен");
        names2.add("Робин");
        names2.add("Альфред");

        System.out.println("Имена 1:");
        for (String name : names1) {
            System.out.println(name);
        }

        System.out.println("Имена 2:");
        for (String name : names2) {
            System.out.println(name);
        }
    }
}
