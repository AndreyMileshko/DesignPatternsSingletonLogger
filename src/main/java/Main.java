import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int listLength = 0;
        int valueLimit = 0;
        int thresholdValue = 0;

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        try {
            System.out.print("Введите размер списка: ");
            listLength = Integer.parseInt(scanner.nextLine());
            System.out.print("Введите верхнюю границу для значений: ");
            valueLimit = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            logger.log("Неверный ввод параметра. Завершаем программу.");
            System.exit(0);
        }
        logger.log("Создаём и наполняем список");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < listLength; i++) {
            list.add(random.nextInt(valueLimit));
        }
        logger.log("Вот случайный список: " + list.toString().replace("[", "")
                .replace("]", "")
                .replace(",", ""));
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        try {
            thresholdValue = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            logger.log("Неверный ввод параметра. Завершаем программу.");
            System.exit(0);
        }
        Filter filter = new Filter(thresholdValue);
        logger.log("Запускаем фильтрацию");
        List<Integer> filteredList = filter.filterOut(list);
        logger.log(String.format("Прошло фильтр %d элемента из %d", filteredList.size(), list.size()));
        logger.log("Выводим результат на экран");
        logger.log("Отфильтрованный список: " + filteredList.toString().replace("[", "")
                .replace("]", "")
                .replace(",", ""));
        logger.log("Завершаем программу.");
    }
}
