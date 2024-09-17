/*
В каждой клетке прямоугольной таблицы N×M записано некоторое число.
Изначально игрок находится в левой верхней клетке.
За один ход ему разрешается перемещаться в соседнюю клетку либо вправо, либо вниз (влево и вверх перемещаться запрещено).
При проходе через клетку с игрока берут столько килограммов еды, какое число записано в этой клетке (еду берут также за
первую и последнюю клетки его пути).

Требуется найти минимальный вес еды в килограммах, отдав которую игрок может попасть в правый нижний угол.
*/

import java.util.Random;

public class Task003 {
    public int task003() {
        Random random = new Random();

        int minRowsColumns = 1;
        int maxRowsColumns = 20;
        int minValue = 0;
        int maxValue = 100;

        // Установление размеров таблицы
        int rows = random.nextInt((maxRowsColumns - minRowsColumns) + 1) + minRowsColumns;
        int columns = random.nextInt((maxRowsColumns - minRowsColumns) + 1) + minRowsColumns;

        // Запонение таблицы
        int[][] grid = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = random.nextInt((maxValue - minValue) + 1) + minValue;
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
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        // Вывод минимального штрафа для достижения правого нижнего угла
        return dp[rows-1][columns-1];
    }
}
