/*
В левом верхнем углу прямоугольной таблицы размером N×M находится черепашка.
В каждой клетке таблицы записано некоторое число. Черепашка может перемещаться вправо или вниз,
при этом маршрут черепашки заканчивается в правом нижнем углу таблицы.

Подсчитаем сумму чисел, записанных в клетках, через которую проползла черепашка
(включая начальную и конечную клетку). Найдите наибольшее возможное значение
этой суммы и маршрут, на котором достигается эта сумма.
*/


import java.util.Random;

public class Task004 {
    public int task004() {
        Random random = new Random();

        int min = 0;
        int max = 100;

        // Установление размеров таблицы
        int rows = random.nextInt((max - min) + 1) + min;
        int columns = random.nextInt((max - min) + 1) + min;

        // Запонение таблицы
        int[][] grid = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = random.nextInt((max - min) + 1) + min;
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }

        // Создание таблицы dp
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];

        // Заполнение первой строки
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        // Заполнение первого столбца
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        // Заполнение остальной части таблицы dp
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        // Вывод максимального штрафа для достижения правого нижнего угла
        return dp[rows-1][columns-1];
    }
}
