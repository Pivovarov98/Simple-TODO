package ToDo;

import java.util.Scanner;

public class ToDo implements CRUDInterface {
    String[] data = new String[10];

    public ToDo() {
    }

    @Override
    public void create() {
        while (true) {
            System.out.println("Введите номер заметки для записи от 1 до 10 или 0 для выхода");
            int numNote = new Scanner(System.in).nextInt();

            if (numNote == 0) {
                break;
            } else if (numNote > 10 || numNote < 0) {
                System.out.println("Вы ввели некорретный номер");
                System.out.println("-".repeat(50));
                continue;
            }

            if (data[numNote - 1] != null) {
                System.out.println("Под данным номером уже есть заметка.");
                System.out.println("-".repeat(50));
                continue;
            }

            System.out.println("-".repeat(50));
            System.out.println("Введите свою заметку");
            String note = new Scanner(System.in).nextLine();

            data[numNote - 1] = numNote + ". " + note;

            System.out.println("Заметка записана!\n" + "-".repeat(50) + "\nЖелаете сделать ещё одну заметку?\n1 - да | 2 - нет");
            int choice = new Scanner(System.in).nextInt();
            if (choice == 1) {
                continue;
            } else if (choice == 2) {
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
            System.out.println("Введите номер заметки для обновления от 1 до 10 или 0 для выхода");
            int numNote = new Scanner(System.in).nextInt();

            if(isExit(numNote)){
                break;
            }else if (isInputCorrect(numNote)){
                continue;
            }

            System.out.println("-".repeat(50));
            System.out.println("Введите новую заметку");
            String note = new Scanner(System.in).nextLine();
            data[numNote - 1] = numNote + ". " + note;
            System.out.println("Заметка обновлена!\n" + "-".repeat(50) + "\nЖелаете обновить ещё одну заметку?\n1 - да | 2 - нет");
            int choice = new Scanner(System.in).nextInt();
            if (choice == 1) {
                continue;
            } else if (choice == 2) {
                break;
            }
        }
    }

    @Override
    public void delete() {
        while (true) {
            System.out.println("Введите номер заметки для удаления от 1 до 10 или 0 для выхода");
            int numNote = new Scanner(System.in).nextInt();

            if(isExit(numNote)){
                break;
            }else if (isInputCorrect(numNote)){
                continue;
            }

            data[numNote - 1] = null;
            System.out.println("Запись удалена!\n" + "-".repeat(50));

            System.out.println("Желаете удалить ещё одну заметку?\n1 - да | 2 - нет");
            int choice = new Scanner(System.in).nextInt();
            if (choice == 1) {
                continue;
            } else if (choice == 2) {
                break;
            }
        }
    }

    boolean isInputCorrect(int input){
        if (input > 10 || input < 0) {
            System.out.println("-".repeat(50) + "\nВы ввели некорретный номер");
            return true;
        }

        if (data[input - 1] == null) {
            System.out.println("-".repeat(50) + "\nПод данным номером ещё нет записи.");
            return true;
        }
        return false;
    }

    boolean isExit(int input){
        return input == 0;
    }
}