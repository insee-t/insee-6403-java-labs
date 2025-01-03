// Change it to read buffer or something?
// change getUserInput into other name
package thaopech.insee.lab6;

public class GuessGameV2 extends GuessGame {

    @Override
    public void configureGame(int min, int max, int maxTries) {

        while (max < min) {
            System.err.println("Invalid input: max must be greater than or equal to min.");
            System.out.print("Enter the min value: ");
            min = input.nextInt();
            System.out.print("Enter the max value: ");
            max = input.nextInt();
        }

        while (maxTries <= 0) {
            System.err.println("Invalid input: maxTries must be greater than 0.");
            System.out.print("Enter the maximum number of tries: ");
            maxTries = input.nextInt();
        }

        setMin(min);
        setMax(max);
        setMaxTries(maxTries);
    }

    public String toString() {
        return "[" +
            "Min: " + getMin() +
            ", Max: " + getMax() +
            ", Max Tries: " + getMaxTries() +
            ", Attemps: " + getAttempts() + "]";
    }

    public int numberGuessingResponse(int userGuess, int index) {

        int answer = getAnswer();
        if (userGuess == answer) {
            System.out.println("Congratulations! You've guessed  the number in " + index + (index == 1 ? " attempts" : " attempt"));
            return 0;
        }
        if (userGuess > answer) {
            System.out.println("Try a lower number!");
            return 1;
        }
        System.out.println("Try a higher number!");
        return 1;
    }

    @Override
    public boolean playSingleGame() {

        System.out.println("Welcome to the Number Guessing Game V2!");
        generateAnswer();

        for (int guessIndex = 1; guessIndex <= getMaxTries(); guessIndex++) {
            int userGuess = getUserGuess();
            while (userGuess < getMin() || userGuess > getMax()) {
                System.err.println(String.format("The number must be between %d and %d", getMin(), getMax()));
                userGuess = getUserGuess();
            }

            if (numberGuessingResponse(userGuess, guessIndex) == 0) {
                return true;
            }
        }

        System.out.println("Sorry, you've used all your attempts. The correct answer was: " + getAnswer());

        return false;
    }
}
