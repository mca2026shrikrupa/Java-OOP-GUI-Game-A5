public abstract class Game {
    private int playerScore = 0;
    private int computerScore = 0;

    public abstract void play(String userChoice);

    public void updateScore(String winner) {
        if (winner.equals("You Win!")) {
            playerScore++;
        } else if (winner.equals("Computer Wins!")) {
            computerScore++;
        }
    }

    public void resetScore() {
        playerScore = 0;
        computerScore = 0;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }
}
