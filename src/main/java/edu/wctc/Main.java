package edu.wctc;

import java.util.Scanner;

public class Main {
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter first name: ");
        String firstName = keyboard.nextLine();

        System.out.print("Enter middle initial: ");
        String middleInitial = keyboard.nextLine();

        System.out.print("Enter last name: ");
        String lastName = keyboard.nextLine();

        System.out.print("Enter year: ");
        int year = Integer.parseInt(keyboard.nextLine());

        System.out.print("Enter month (1 - 12): ");
        int month = Integer.parseInt(keyboard.nextLine());

        System.out.print("Enter day of birth ( 1 - 28/31): ");
        int day = Integer.parseInt(keyboard.nextLine());

        System.out.print("Enter gender code (M or F): ");
        char genderCode = keyboard.next().charAt(0);

        try {
            DriverLicense driversLicense = new DriverLicense();

            FirstNameUtility firstNameUtility = new FirstNameUtility();
            driversLicense.setFirstNameMiddleInitial(firstNameUtility.encodeFirstName(firstName, middleInitial));

            LastNameUtility lastNameUtility = new LastNameUtility();
            driversLicense.setSoundexCode(lastNameUtility.encodeLastName(lastName));

            MonthDayGenderUtility monthDayGenderUtility = new MonthDayGenderUtility();
            driversLicense.setBirthMonthDayGender(monthDayGenderUtility.encodeMonthDayGender(year, month, day, genderCode));

            driversLicense.setBirthYear(year);

            driversLicense.setOverflow(0);

            WisconsinFormatter wisconsinFormatter = new WisconsinFormatter();
            FloridaFormatter floridaFormatter = new FloridaFormatter();

            System.out.printf("Your Wisconsin license # is %s%n", wisconsinFormatter.formatLicenseNumber(driversLicense));
            System.out.printf("Your Florida license # is %s%n", floridaFormatter.formatLicenseNumber(driversLicense));
        } catch (MissingNameException | UnknownGenderCodeException | InvalidBirthdayException e) {
            System.out.println(e.getMessage());
        }

    }



}
