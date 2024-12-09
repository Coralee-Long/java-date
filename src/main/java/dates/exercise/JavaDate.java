package dates.exercise;

import java.lang.invoke.LambdaConversionException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class JavaDate {
    public static void main(String[] args) {

        // Step 1: Write code to output the current date and time.
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("STEP 1: Current date and time: " + localDateTime);

        System.out.println("----------------------------------");

        // Step 2: Add a timespan of 2 weeks to the current date and output the new date.
        LocalDateTime futureDate = LocalDateTime.now().plusMonths(2);
        System.out.println("STEP 2: New date ( + 2 months): " + futureDate);

        System.out.println("----------------------------------");

        // Step 3: Compare the current date with a specified future date and output
        // whether the current date is before or after the specified date.
        LocalDate dateToCheck1 = LocalDate.of(2023,12,25);
        LocalDate dateToCheck2 = LocalDate.of(2024, 12, 25);
        LocalDate dateToCheck3 = LocalDate.of(2024, 12, 9);
        System.out.println("STEP 3: Check if current date is before or after the specified date:");
        System.out.println("--------CASE 1: " + dateToCheck1);
        checkIfBeforeOrAfter(dateToCheck1);
        System.out.println("--------CASE 1: " + dateToCheck2);
        checkIfBeforeOrAfter(dateToCheck2);
        System.out.println("--------CASE 1: " + dateToCheck3);
        checkIfBeforeOrAfter(dateToCheck3);

        System.out.println("----------------------------------");

        //Step 4: Calculate the difference in days between two arbitrary dates and output the result.
        LocalDate date1 = LocalDate.of(2023,12,25);
        LocalDate date2 = LocalDate.of(2024,12,25);
        System.out.println("STEP 4: Calculate diff of days between dates: ");
        calculateDiffOfDays(dateToCheck1, dateToCheck2);

        System.out.println("----------------------------------");
    }

    public static void checkIfBeforeOrAfter(LocalDate dateToCheck) {
        LocalDate dateNow = LocalDate.now();
        String checkBeforeAfter = dateNow.isBefore(dateToCheck) ? "before " : "after ";
        System.out.println(" --> The current date: " + dateNow + " is " + checkBeforeAfter + "the Specified Date: " + dateToCheck);

    }

    public static void calculateDiffOfDays(LocalDate date1, LocalDate date2) {
        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        System.out.println("There are " + daysBetween + " between " + date1 + " and " + date2 + ".");

    }
}


