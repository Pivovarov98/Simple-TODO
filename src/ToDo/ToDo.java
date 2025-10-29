package ToDo;

import java.util.Scanner;

public class ToDo implements CRUDInterface {
    String[] data = new String[10];

    public ToDo() {
    }

    @Override
    public void create() {
        while (true) {
            System.out.println("Введите номер заметки для записи от 1 до " + data.length + " или 0 для выхода");
            int numNote = new Scanner(System.in).nextInt();

            if (isExit(numNote)) {
                break;
            } else if (isInputCorrect(numNote, "create")) {
                continue;
            }

            System.out.println("-".repeat(50) + "\nВведите свою заметку");
            String note = new Scanner(System.in).nextLine();

            data[numNote - 1] = numNote + ". " + note;
            System.out.println("Заметка записана!\n" + "-".repeat(50));

            if (!isContinue("create")) {
                break;
            }
        }
    }

    @Override
    public void read() {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                System.out.println((i + 1) + ".");
                continue;
            }
            System.out.println(data[i]);
        }
    }

    @Override
    public void update() {
        while (true) {
            System.out.println("Введите номер заметки для обновления от 1 до " + data.length + " или 0 для выхода");
            int numNote = new Scanner(System.in).nextInt();

            if (isExit(numNote)) {
                break;
            } else if (isInputCorrect(numNote, "update")) {
                continue;
            }

            System.out.println("-".repeat(50) + "\nВведите новую заметку");
            String note = new Scanner(System.in).nextLine();
            data[numNote - 1] = numNote + ". " + note;
            System.out.println("Заметка обновлена!\n" + "-".repeat(50));

            if (!isContinue("update")) {
                break;
            }
        }
    }

    @Override
    public void delete() {
        while (true) {
            System.out.println("Введите номер заметки для удаления от 1 до " + data.length + " или 0 для выхода");
            int numNote = new Scanner(System.in).nextInt();

            if (isExit(numNote)) {
                break;
            } else if (isInputCorrect(numNote, "delete")) {
                continue;
            }

            data[numNote - 1] = null;
            System.out.println("Запись удалена!\n" + "-".repeat(50));

            if (!isContinue("delete")) {
                break;
            }
        }
    }

    boolean isInputCorrect(int input, String method) {
        if (input > data.length || input < 0) {
            System.out.println("-".repeat(50) + "\nВы ввели некорретный номер");
            return true;
        }

        if (data[input - 1] != null && method.equals("create")) {
            System.out.println("-".repeat(50) + "\nПод данным номером уже есть заметка");
            return true;
        }

        if (data[input - 1] == null && (method.equals("update") || method.equals("delete"))) {
            System.out.println("-".repeat(50) + "\nПод данным номером ещё нет записи");
            return true;
        }
        return false;
    }

    boolean isContinue(String method) {
        switch (method) {
            case "delete" -> System.out.println("Желаете удалить ещё одну заметку?\n1 - да | 2 - нет");
            case "update" -> System.out.println("Желаете обновить ещё одну заметку?\n1 - да | 2 - нет");
            case "create" -> System.out.println("Желаете сделать ещё одну заметку?\n1 - да | 2 - нет");
        }
        int choice = new Scanner(System.in).nextInt();

        if (choice != 1 && choice != 2) {
            System.out.println("Вы ввели некорретный номер\n" + "-".repeat(50));
            isContinue(method);
        } else return choice == 1;
        return false;
    }

    boolean isExit(int input) {
        return input == 0;
    }
}