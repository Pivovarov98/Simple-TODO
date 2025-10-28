import ToDo.ToDo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToDo notion = new ToDo();

        while (true) {
            System.out.println("-".repeat(50)
                    + "\nВыберите действие:"
                    + "\n1. Создать заметку"
                    + "\n2. Вывести все заметки"
                    + "\n3. Изменить заметку"
                    + "\n4. Удалить заметку"
                    + "\n5. Выйти");

            int input = new Scanner(System.in).nextInt();

            if (input == 5) {
                break;
            } else if (input < 1 || input > 5) {
                System.out.println("Некорректный ввод\n" + "-".repeat(50));
            }

            switch (input) {
                case 1 -> notion.create();
                case 2 -> notion.read();
                case 3 -> notion.update();
                case 4 -> notion.delete();
            }
        }
    }
}
