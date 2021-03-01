package edu.wctc;

public class WisconsinFormatter implements DriversLicenseFormatter{
    @Override
    public String formatLicenseNumber(DriverLicense driversLicense) {
        String number = "";
        number += driversLicense.getSoundexCode() + "-";
        number += String.format("%03d", driversLicense.getFirstNameMiddleInitial());
        number += Integer.toString(driversLicense.getBirthYear()).charAt(2) + "-" + Integer.toString(driversLicense.getBirthYear()).charAt(3);
        number += String.format("%03d", driversLicense.getBirthMonthDayGender()) + "-";
        number += String.format("%02d", driversLicense.getOverflow());

        return number;
    }
}
