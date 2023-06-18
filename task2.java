public class task2 {
    public static void main(String[] args) {
        String input = "I have 3 cats, 4 dogs, and 1 turtle";

        int[] digits = extractDigits(input);

        // Вывод массива в консоль
        for (int digit : digits) {
            System.out.println(digit);
        }
    }

    public static int[] extractDigits(String input) {
        String digitsOnly = input.replaceAll("\\D", ""); // Удаление всех символов, кроме цифр

        // Формирование массива цифр
        int[] result = new int[digitsOnly.length()];
        for (int i = 0; i < digitsOnly.length(); i++) {
            result[i] = Character.getNumericValue(digitsOnly.charAt(i)); // Преобразование символа в цифру
        }

        return result;
    }
}
