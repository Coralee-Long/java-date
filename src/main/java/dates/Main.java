package dates;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        // 1. Get the current LocalDate (just the date without time)
        LocalDate localDate = LocalDate.now();
        System.out.println("LocalDate = " + localDate);

        // 2. Get the current LocalDateTime (date and time without timezone)
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime = " + localDateTime);

        // 3. Get the current ZonedDateTime (date, time, and timezone info)
        // Use system default timezone (e.g., Europe/Berlin in this case)
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("ZonedDateTime = " + zonedDateTime);

        // 4. Convert ZonedDateTime to Instant (a moment in time in UTC)
        Instant instant = zonedDateTime.toInstant();
        System.out.println("Instant = " + instant);

        // 5. Convert Instant to LocalDateTime in the default timezone
        ZoneId zoneId = ZoneId.systemDefault(); // Get the system's default timezone
        LocalDateTime convertedDateTime = instant.atZone(zoneId).toLocalDateTime();
        System.out.println("convertedDateTime = " + convertedDateTime);

        // 6. Convert LocalDateTime back to Instant
        // This requires specifying the timezone to get the exact moment in UTC
        ZoneId zoneId2 = ZoneId.systemDefault(); // Again, the system's default timezone
        Instant convertedLocalDateTime = localDateTime.atZone(zoneId2).toInstant();
        System.out.println("convertedLocalDateTime = " + convertedLocalDateTime);

        // 7. Format LocalDate using DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd.MMMM yyyy HH:mm:ss");
        System.out.println("Formatted Date and Time = " + formatter.format(localDateTime));
        // Example Output: Monday, 09.December 2024 14:30:45

            // Pattern Explanation:
            // - dd = day (e.g., 09)
            // - MM = numeric month (e.g., 12)
            // - MMM = abbreviated month name (e.g., Dec)
            // - MMMM = full month name (e.g., December)
            // - yyyy = full year (e.g., 2024)
            // - HH = 24-hour hour (e.g., 14 for 2 PM)
            // - mm = minutes (e.g., 05)
            // - ss = seconds (e.g., 30)

        // 8. Convert a String into LocalDateTime
        String time = "12.08.2025 : 15:33:25";
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd.MM.yyyy : HH:mm:ss");
        LocalDateTime convertedFromString = LocalDateTime.parse(time, formatter2);
        System.out.println("convertedFromString = " + convertedFromString);
        // Example Output: 2025-08-12T15:33:25

        // 9. Calculating Differences Between Two Time Points
        // Calculate difference between two time points
        LocalDateTime start = LocalDateTime.of(2024, 12, 1, 9, 30);
        LocalDateTime end = LocalDateTime.of(2024, 12, 8, 9, 55);

        // Calculate hours difference
        long hoursBetween = ChronoUnit.HOURS.between(start, end);
        System.out.println("hoursBetween = " + hoursBetween);
        // Example Output: 168

        // Calculate seconds difference
        long secondsBetween = ChronoUnit.SECONDS.between(start, end);
        System.out.println("secondsBetween = " + secondsBetween);
        // Example Output: 606300

    }
}
