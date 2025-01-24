package thaopech.insee.lab6;

public class GuessGameV2 extends GuessGame {

    public GuessGameV2() {
        setMin(1);
        setMax(100);
        setMaxTries(10);
        setAnswer(0);
        setAttempts(0);
    }

    public GuessGameV2(int min, int max, int maxTries) {
        super.configureGame(min, max, maxTries);
        setAnswer(0);
        setAttempts(0);
    }

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

    @Override
    public String toString() {
        return "[" +
            "Min: " + getMin() +
            ", Max: " + getMax() +
            ", Max Tries: " + getMaxTries() +
            ", Attemps: " + getAttempts() + "]";
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
