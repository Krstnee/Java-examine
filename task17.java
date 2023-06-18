import java.util.Arrays;

interface InArray {
    int[] sumArrays(int[] array1, int[] array2);
}

class ArraySum implements InArray {
    @Override
    public int[] sumArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Размеры массивов должны быть одинаковыми");
        }

        int[] result = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i] + array2[i];
        }
        return result;
    }
}

class OrArray implements InArray {
    @Override
    public int[] sumArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Размеры массивов должны быть одинаковыми");
        }

        int[] result = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i] | array2[i];
        }
        return result;
    }
}

public class task17 {
    public static void main(String[] args) {
        try {
            InArray arraySum = new ArraySum();
            int[] array1 = {1, 2, 3};
            int[] array2 = {4, 5, 6};
            int[] sumResult = arraySum.sumArrays(array1, array2);
            System.out.println("Сумма массивов: " + Arrays.toString(sumResult));

            InArray orArray = new OrArray();
            int[] orResult = orArray.sumArrays(array1, array2);
            System.out.println("Логическое ИЛИ массивов: " + Arrays.toString(orResult));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
