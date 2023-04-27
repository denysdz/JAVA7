import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.console;

public class Main {

    private static ArrayList<String> channels = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static void fillByDefault () {
        channels.add("1+1");
        channels.add("Новий канал");
        channels.add("СТБ");
        channels.add("Discovery");
        channels.add("Mega");
        channels.add("Плюс");
        channels.add("ICTV");
        channels.add("Перший");
        channels.add("M1");
        channels.add("Toronto");
    }

    private static void showMenu() {
        System.out.println("Виберіть опцію: ");
        System.out.println("0: Відобразити всі телеканали");
        System.out.println("1: Добавити телеканал");
        System.out.println("2: Пошук телеканалу");
        System.out.println("3: Видалити телеканал");

        String option = scanner.nextLine();

        switch (option) {
            case "0":
                for (int i=0; i<channels.size(); i++) {
                    System.out.println(i+1 + ": " + channels.get(i));
                }
                showMenu();
                break;
            case "1":
                System.out.println("Введіть назву телеканалу");
                String name = scanner.nextLine();
                channels.add(name);
                System.out.println("Телеканал додано");
                showMenu();
                break;
            case "2":
                System.out.println("Введіть номер телеканалу");
                String searchNumber = scanner.nextLine();
                try {
                    System.out.println(searchNumber + ": " + channels.get(Integer.parseInt(searchNumber)-1));
                    showMenu();
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println("Телеканалу з таким номером не знайдено");
                    showMenu();
                    ex.printStackTrace();
                } catch (NumberFormatException ex) {
                    System.out.println("Тільки цифри");
                    showMenu();
                }
                showMenu();
                break;
            case "3":
                System.out.println("Введіть номер телеканалу який хочете видалити: ");
                String removeNumber = scanner.nextLine();
                try {
                    channels.remove(Integer.parseInt(removeNumber) - 1);
                    System.out.println("Телеканал успішно видалено");
                    showMenu();
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println("Телеканалу з таким номером не знайдено");
                    showMenu();
                    ex.printStackTrace();
                } catch (NumberFormatException ex) {
                    System.out.println("Тільки цифри");
                    showMenu();
                }
                break;
            default:
                System.out.println("Невірна опція. Спробуйте ще раз.");
                showMenu();
                break;
        }
    }
    public static void main(String[] args) {
        fillByDefault();
        if (!channels.isEmpty())
            System.out.println("Кількість телеканалів: " + channels.size());
        showMenu();
    }

}