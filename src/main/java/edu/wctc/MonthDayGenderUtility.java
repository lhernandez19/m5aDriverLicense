package edu.wctc;

import java.time.DateTimeException;
import java.time.LocalDate;

public class MonthDayGenderUtility {
    private final int MOD_MALE = 0;
    private final int MOD_FEMALE = 500;
    private final char CODE_MALE = 'M';
    private final char CODE_FEMALE = 'F';

    public int encodeMonthDayGender(int year, int month, int day, char genderCode) throws UnknownGenderCodeException, InvalidBirthdayException {
        if (Character.toUpperCase(genderCode) != CODE_MALE && Character.toUpperCase(genderCode) != CODE_FEMALE) {
            throw new UnknownGenderCodeException(genderCode);
        } else {
            try {
                LocalDate birthDate = LocalDate.of(year, month, day);
                int genderMod = Character.toUpperCase(genderCode) == 'M'
                        ? MOD_MALE
                        : MOD_FEMALE;

                return (month - 1) * 40 + day + genderMod;

            } catch (DateTimeException dte) {
                throw new InvalidBirthdayException(year, month, day);
            }
        }
    }
}
