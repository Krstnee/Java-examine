import java.util.BitSet;

public class task31 {
    public static void main(String[] args) {
        BitSet bitSet1 = new BitSet(8);
        BitSet bitSet2 = new BitSet(8);

        // Установка битов в первом BitSet
        bitSet1.set(0);
        bitSet1.set(2);
        bitSet1.set(4);
        bitSet1.set(6);

        // Установка битов во втором BitSet
        bitSet2.set(1);
        bitSet2.set(3);
        bitSet2.set(5);
        bitSet2.set(7);

        // Печать BitSet'ов
        System.out.println("BitSet 1: " + bitSet1);
        System.out.println("BitSet 2: " + bitSet2);

        // Битовая операция AND
        BitSet andResult = (BitSet) bitSet1.clone();
        andResult.and(bitSet2);
        System.out.println("AND результат: " + andResult);

        // Битовая операция OR
        BitSet orResult = (BitSet) bitSet1.clone();
        orResult.or(bitSet2);
        System.out.println("OR результат: " + orResult);

        // Битовая операция XOR
        BitSet xorResult = (BitSet) bitSet1.clone();
        xorResult.xor(bitSet2);
        System.out.println("XOR результат: " + xorResult);

        // Маскирование
        BitSet mask = new BitSet(8);
        mask.set(1);
        mask.set(4);
        BitSet maskedResult = (BitSet) bitSet1.clone();
        maskedResult.and(mask);
        System.out.println("Маскирование результат: " + maskedResult);
    }
}
//В данном примере создаются два объекта класса BitSet - bitSet1 и bitSet2. Затем устанавливаются определенные биты в каждом из
// них. Затем выполняются битовые операции AND, OR и XOR, а также маскирование с использованием методов класса BitSet.
// Результаты операций выводятся на консоль.