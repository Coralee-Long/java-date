package dates.bonus_exercise;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Animal {
    String name;
    LocalDate birthday;


public Animal(String name, LocalDate birthday) {
    this.name = name;
    this.birthday = birthday;
}

    public static void main (String[] args) {

        Animal animal1 = new Animal("giraffe", LocalDate.of(2021, 5, 8));
        Animal animal2 = new Animal("lion", LocalDate.of(2019, 12, 25));
        Animal animal3 = new Animal("dog", LocalDate.of(2024, 12, 9));

        calculateNumOfDays(animal1); // Number of days until the next birthday of giraffe is: 150
        calculateNumOfDays(animal2); // Number of days until the next birthday of lion is: 16
        calculateNumOfDays(animal3); // Happy birthday, dog! 🎉
    }

    public static void calculateNumOfDays(Animal animal) {
        LocalDate today = LocalDate.now();

        // Get the next birthday (adjust the year if it has already passed)
        LocalDate nextBirthday = animal.birthday.withYear(today.getYear());

        // Adjust to next year only if the birthday has passed (not if it is today)
        if (nextBirthday.isBefore(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }

        // Calculate the number of days between today and the next birthday
        long numOfDays = ChronoUnit.DAYS.between(today, nextBirthday);;

        if (numOfDays == 0) {
            System.out.println("Happy birthday, " + animal.name + "! 🎉");
        } else {
            System.out.println("Number of days until the next birthday of " + animal.name + " is: " + numOfDays);
        }

    };

}
