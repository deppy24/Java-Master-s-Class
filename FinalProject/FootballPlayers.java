package FinalProject;

import java.util.Random;

public class FootballPlayers {
    private int playerID;
    private String playerName;
    private int playerAge;
    private Position playerPosition;
    private int playerCapability;

    public enum Position {
        GOALKEEPER, DEFENDER,STRIKER
    }

    public FootballPlayers(int playerID, String playerName, int playerAge, Position playerPosition, int capability) {
        if (playerID <= 0 || playerID > 99) {
            Random random = new Random();
            playerID = random.nextInt(99) + 1;
            System.out.println("Invalid player details provided. Player will get a random ID between 1-99.");
        }
        if (!playerName.matches("[a-zA-Z]+")) {
            System.out.println("The name must contain only alphabetic characters.");
            throw new IllegalArgumentException("Invalid player name: " + playerName);
        }
        if (playerAge < 18 || playerAge > 40) {
            System.out.println("Player age must be between 18 and 40.");
            throw new IllegalArgumentException("Invalid player age: " + playerAge);
        }
        if (capability < 0 || capability > 100) {
            Random random = new Random();
            capability = random.nextInt(101);
            System.out.println("Invalid player capability provided. Player will get a random capability between 0-100.");
        }

        this.playerID = playerID;
        this.playerName = playerName;
        this.playerAge = playerAge;
        this.playerPosition = playerPosition;
        this.playerCapability = capability;
    }

    //Οριζουμε getters για να μπορουμε να προσπελασουμε τα πεδια της κλασης εξωτερικα της κλασης
    //Δεν οριζουμε setters γιατι δεν θελουμε να αλλαξουμε τα πεδια της κλασης μετα την δημιουργια του αντικειμενου
    public int getPlayerID() {
        return playerID;
    }
    public String getPlayerName() {
        return playerName;
    }
    public int getPlayerAge(){
        return playerAge;
    }
    public Position getPlayerPosition() {
        return playerPosition;
    }
    public int getPlayerCapability() {
        return playerCapability;
    }
    
    //Οριζουμε την μεθοδο toString για να μπορουμε να εκτυπωσουμε τα πεδια της κλασης με κατανοητο τροπο
    @Override
    public String toString() {
        return "FootballPlayers{" +
                "playerID=" + playerID +
                ", playerName='" + playerName + '\'' +
                ", playerAge=" + playerAge +
                ", playerPosition=" + playerPosition +
                ", playerCapability=" + playerCapability +
                '}';
    }
   
}
