package edu.wctc;

public class FloridaFormatter implements DriversLicenseFormatter{
    @Override
    public String formatLicenseNumber(DriverLicense driversLicense) {
        String number = "";
        number += driversLicense.getSoundexCode() + "-";
        number += String.format("%03d", driversLicense.getFirstNameMiddleInitial()) + "-";
        number += Integer.toString(driversLicense.getBirthYear()).substring(2,4) + "-";
        number += String.format("%03d", driversLicense.getBirthMonthDayGender()) + "-";
        number += driversLicense.getOverflow();

        return number;
    }
}
