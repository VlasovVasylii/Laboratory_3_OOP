import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> testCases = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(10, 20, 30, 40, 50, 60),
                List.of(7, 8, 9, 10, 11),
                List.of(42),
                List.of(5, 5, 5, 5, 5, 5, 5),
                List.of() // Пустой список
        );

        for (List<Integer> testCase : testCases) {
            System.out.println("Input: " + testCase);
            int result = pairwiseSum(testCase);
            System.out.println("Final result: " + result);
            System.out.println();
        }
    }

    public static int pairwiseSum(List<Integer> numbers) {
        if (numbers.size() == 0) return 0;
        List<Integer> currentList = new ArrayList(numbers);

        // Число итераций равно логарифму по основанию 2, округлённому вверх до целого
        for (int j = 0; j < (int) Math.ceil(Math.log(currentList.size()) / Math.log(2)); j++) {
            // Суммируем все пары чисел в начало листа
            for (int i = 0; i < currentList.size() - 1; i += 2) {
                currentList.set(i / 2, currentList.get(i) + currentList.get(i + 1));
            }

            // Если длина нечётная, то сначала дёргаем последний элемент в середину,
            // а потом зануляем оставшуюся половину
            if (currentList.size() % 2 != 0) {
                currentList.set(currentList.size() / 2, currentList.get(currentList.size() - 1));
                for (int i = currentList.size() / 2 + 1; i < currentList.size(); i++) {
                    currentList.set(i, 0);
                }
            } else {
                for (int i = currentList.size() / 2; i < currentList.size(); i++) {
                    currentList.set(i, 0);
                }
            }

            // Выводим промежуточные суммы
            System.out.println("Intermediate sum: " + currentList);
        }

        return currentList.get(0);
    }
}
