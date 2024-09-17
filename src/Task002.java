/*
Рассмотрим три числа a, b и c. Упорядочим их по возрастанию.
Какое число будет стоять между двумя другими?
*/

import java.util.Arrays;

public class Task002 {
    public int task002(String numsString) {
        // Чтение строки с числами
        String[] numsStringArray = numsString.split(" ");
        int[] nums = new int[numsStringArray.length];

        try {
            // Проверка, что введено ровно три числа
            if (numsStringArray.length != 3) {
                throw new IllegalArgumentException("Должно быть введено ровно три числа.");
            }

            // Преобразование строк в целые числа
            for (int i = 0; i < 3; i++) {
                nums[i] = Integer.parseInt(numsStringArray[i]);
            }

            // Сортировка массива
            Arrays.sort(nums);
        } catch (NumberFormatException e) {
            // Обработка исключения, если ввёдённое значение не является числом
            System.out.println("Ошибка: одно из введенных значений не является числом.");
        }
        // Возвращение среднего значения
        return nums[1];
    }
}

