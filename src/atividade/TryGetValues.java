package atividade;
import java.util.Scanner;

public class TryGetValues {

    public static void tryGetAge(int newAge) {

        int age;
        Scanner scanner = new Scanner(System.in);

        do {
            try {
                age = scanner.nextInt();
                if (!ValidateValues.isValidAge(age)) {
                    System.out.println("Please, choose an valid age.");
                    tryGetAge(newAge);
                    break;
                } else {
                    newAge = age;
                }
            } catch (Exception e) {
                System.out.println("Please, choose an valid age.");
                tryGetAge(newAge);
                break;
            }
        } while (false);
    }

    public static void tryGetMenuOption(int maxValue) {

        Scanner scanner = new Scanner(System.in);
        int option = 0;

        do {
            try {
                option = scanner.nextInt();

                if (ValidateValues.isInvalidOption(option, maxValue)) {
                    System.out.println("Please, choose an valid option.");
                    tryGetMenuOption(maxValue);
                    return;
                } else {
                    Main.dealMenuChoice(option);
                }

            } catch (Exception e) {
                System.out.println("Please, choose an valid option.");
                tryGetMenuOption(maxValue);
                return;
            }
        } while (ValidateValues.isInvalidOption(option, maxValue));
    }

    public static int choice = 0;

    public static void tryGetOption(int maxValue) {


        Scanner scanner = new Scanner(System.in);
        int option = 0;

        do {
            try {
                option = scanner.nextInt();
                if (ValidateValues.isInvalidOption(option, maxValue)) {


                    System.out.println("Please, choose an valid option.");
                    tryGetOption(maxValue);
                    return;
                } else {
                    choice = option;
                }
            } catch (Exception e) {

                System.out.println("Please, choose an valid option.");
                tryGetOption(maxValue);
                return;
            }
        } while (ValidateValues.isInvalidOption(option, maxValue));
    }

    public static Category tryGetCategoryOption() {

        Scanner scanner = new Scanner(System.in);
        int option = 0;

        try {
            option = scanner.nextInt();
            if (ValidateValues.isInvalidOption(option, 7)) {
                System.out.println("Please, choose an valid option.");
                tryGetCategoryOption();
                //break;
            } else {
                return tryGetCategory(option);
            }
        } catch (Exception e) {
            System.out.println("Please, choose an valid option.");
            tryGetCategoryOption();
            //break;
        }
        return tryGetCategory(option);
    }

    private static Category tryGetCategory(int category) {
        return switch (category) {
            case 1 -> Category.social;
            case 2 -> Category.business;
            case 3 -> Category.religious;
            case 4 -> Category.academics;
            case 5 -> Category.cultural;
            case 6 -> Category.entertainment;
            case 7 -> Category.sports;
            default -> null;
        };
    }

}
