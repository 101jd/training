/*
Необходимо реализовать функцию, которая проверяет,
можно ли одну строку получить из другой не более, чем за одно исправление
(удаление, добавление, изменение символа).

task001("cat", "dog") // false
task001("ca", "cats") // false
task001("catr", "cast") // false
task001("cat", "at") // true
task001("cat", "acts") // false
task001("tcut", "cut") // true
*/

public class Task001 {
    public boolean task001(String a, String b) {
        // Если разница в длине строк больше 1, сразу возвращаем false
        if (Math.abs(a.length() - b.length()) > 1) {
            return false;
        }

        // Если строка a короче, меняем их местами для удобства
        if (a.length() < b.length()) {
            return task001(b, a);
        }

        int diffCount = 0;
        int i = 0, j = 0;

        // Проходим по обеим строкам
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) != b.charAt(j)) {
                diffCount++;
                // Если строки равной длины, это должно быть замена символа
                if (a.length() == b.length()) {
                    j++;
                }
                // Если строки разной длины, пропускаем символ из более длинной строки
                if (diffCount > 1) {
                    return false;
                }
            } else {
                j++; // если символы совпадают, переходим к следующему символу строки b
            }
            i++; // всегда двигаем указатель строки a
        }

        return true;
    }
}
