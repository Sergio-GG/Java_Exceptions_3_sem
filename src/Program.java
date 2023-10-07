import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Program {
    public static void main(String[] args) throws MyNumException, WrongDataException, IOException, InvalidCharException {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Фамилию: ");
        String surname = scanner.nextLine();


        System.out.println("Введите Имя: ");
        String name = scanner.nextLine();


        System.out.println("Введите Отчество: ");
        String secondName = scanner.nextLine();


        System.out.println("Введите дату рождения в формате dd.mm.yyyy: ");
        String regexp = "(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[012])\\.((19|20)\\d\\d)";
        String dateOfBirth = scanner.nextLine();
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(dateOfBirth);
        String date;
        if (matcher.matches()) {
            date = matcher.group();
        } else {
            throw new WrongDataException("Дата введена в неправильном формате");
        }


        System.out.println("Введите номер телефона: ");
        long phoneNumber;
        String ph;
        try {
            phoneNumber = scanner.nextLong();
            ph = Long.toString(phoneNumber);
        } catch (InputMismatchException e) {
            throw new MyNumException("Введенное значение не является числом");
        }



        System.out.println("Введите пол (f/m): ");
        char ch1 = 'f';
        char ch2 = 'm';
        char sex = scanner.next().charAt(0);
        if (sex != ch1 && sex != ch2) {
            throw new InvalidCharException("Неверный символ пола");
        }


        FileWriter fileWriter = new FileWriter(surname, true);
        fileWriter.write("<" + surname + ">");
        fileWriter.write("<" + name + ">");
        fileWriter.write("<" + secondName + ">");
        fileWriter.write("<" + date + ">");
        fileWriter.write("<" + ph + ">");
        fileWriter.write("<" + sex + ">");
        fileWriter.close();

    }
}
