
public class task18 {
    private char[] bits;

    public task18(char[] bits) {
        this.bits = bits.clone();
    }

    public char[] getBits() {
        return bits.clone();
    }

    public void setBits(char[] bits) {
        this.bits = bits.clone();
    }

    public static task18 fromDecimal(int decimal, int length) {
        if (decimal < 0) {
            throw new IllegalArgumentException("Десятичное число не может быть отрицательным");
        }

        char[] bits = new char[length];
        for (int i = length - 1; i >= 0; i--) {
            bits[i] = (char) (decimal % 2 + '0');
            decimal /= 2;
        }

        return new task18(bits);
    }

    public int toDecimal() {
        int decimal = 0;
        int power = bits.length - 1;

        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == '1') {
                decimal += Math.pow(2, power);
            }
            power--;
        }

        return decimal;
    }

    public static task18 fromString(String binaryString) {
        char[] bits = binaryString.toCharArray();

        // Проверяем, что каждый символ равен '0' или '1'
        for (char bit : bits) {
            if (bit != '0' && bit != '1') {
                throw new IllegalArgumentException("Некорректная строка двоичного числа");
            }
        }

        return new task18(bits);
    }

    public String toString() {
        return new String(bits);
    }
}
