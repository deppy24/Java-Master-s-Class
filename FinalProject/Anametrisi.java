package FinalProject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Anametrisi {
    private FootballTeam homeTeam;
    private FootballTeam awayTeam;
    private int homeGoals = 0;
    private int awayGoals = 0;
    private final Random random = new Random();
    private Map<FootballPlayers, Integer> strikerGoals = new HashMap<>();
    private Map<FootballPlayers, Integer> defenderFails = new HashMap<>();

    // Team creation and draft print
    public void printDraft() {
        // Home team
        List<FootballPlayers> homePlayers = List.of(
            new FootballPlayers(1, "HomeGK", 25, FootballPlayers.Position.GOALKEEPER, 80),
            new FootballPlayers(2, "HomeDEF", 22, FootballPlayers.Position.DEFENDER, 55),
            new FootballPlayers(3, "HomeDEFu", 23, FootballPlayers.Position.DEFENDER, 70),
            new FootballPlayers(4, "HomeDEFuu", 24, FootballPlayers.Position.DEFENDER, 87),
            new FootballPlayers(5, "HomeDEFj", 25, FootballPlayers.Position.DEFENDER, 72),
            new FootballPlayers(6, "HomeDEFjj", 26, FootballPlayers.Position.DEFENDER, 65),
            new FootballPlayers(7, "HomeSTRb", 27, FootballPlayers.Position.STRIKER, 80),
            new FootballPlayers(8, "HomeSTRbb", 28, FootballPlayers.Position.STRIKER, 78),
            new FootballPlayers(9, "HomeSTRd", 29, FootballPlayers.Position.STRIKER, 82),
            new FootballPlayers(10, "HomeSTRdd", 30, FootballPlayers.Position.STRIKER, 60),
            new FootballPlayers(11, "HomeSTRx", 24, FootballPlayers.Position.STRIKER, 76)
        );

        // Away team
        List<FootballPlayers> awayPlayers = List.of(
            new FootballPlayers(12, "AwayGK", 25, FootballPlayers.Position.GOALKEEPER, 77),
            new FootballPlayers(13, "AwayDEFi", 22, FootballPlayers.Position.DEFENDER, 75),
            new FootballPlayers(14, "AwayDEFii", 23, FootballPlayers.Position.DEFENDER, 73),
            new FootballPlayers(15, "AwayDEFk", 24, FootballPlayers.Position.DEFENDER, 70),
            new FootballPlayers(16, "AwayDEFkk", 25, FootballPlayers.Position.DEFENDER, 85),
            new FootballPlayers(17, "AwayDEFm", 26, FootballPlayers.Position.DEFENDER, 59),
            new FootballPlayers(17, "AwaySTRuu", 27, FootballPlayers.Position.STRIKER, 77),
            new FootballPlayers(18, "AwaySTRr", 28, FootballPlayers.Position.STRIKER, 81),
            new FootballPlayers(19, "AwaySTRrr", 29, FootballPlayers.Position.STRIKER, 79),
            new FootballPlayers(20, "AwaySTRt", 30, FootballPlayers.Position.STRIKER, 59),
            new FootballPlayers(21, "AwaySTRtt", 24, FootballPlayers.Position.STRIKER, 54)
        );

        homeTeam = new FootballTeam("HomeTeam", homePlayers);
        awayTeam = new FootballTeam("AwayTeam", awayPlayers);

        System.out.println("Home Team:");
        System.out.println(homeTeam);
        System.out.println("Away Team:");
        System.out.println(awayTeam);
    }

    // Returns a random defender from the list
    private FootballPlayers getRandomDefender(List<FootballPlayers> players) {
        List<FootballPlayers> defenders = players.stream()
                .filter(p -> p.getPlayerPosition() == FootballPlayers.Position.DEFENDER)
                .toList();
        return defenders.get(random.nextInt(defenders.size()));
    }

    // Returns a random striker from the list
    private FootballPlayers getRandomStriker(List<FootballPlayers> players) {
        List<FootballPlayers> strikers = players.stream()
                .filter(p -> p.getPlayerPosition() == FootballPlayers.Position.STRIKER)
                .toList();
        return strikers.get(random.nextInt(strikers.size()));
    }

    // Returns the goalkeeper from the list
    private FootballPlayers getGoalkeeper(List<FootballPlayers> players) {
        return players.stream()
                .filter(p -> p.getPlayerPosition() == FootballPlayers.Position.GOALKEEPER)
                .findFirst()
                .orElseThrow();
    }

    // Offense: returns true if a goal is scored, false otherwise
    private boolean offense(FootballTeam attackingTeam, FootballTeam defendingTeam) {
        FootballPlayers striker = getRandomStriker(attackingTeam.getPlayers());
        FootballPlayers defender = getRandomDefender(defendingTeam.getPlayers());
        FootballPlayers goalkeeper = getGoalkeeper(defendingTeam.getPlayers());

        System.out.println("Offense: " + striker.getPlayerName() + " (Capability: " + striker.getPlayerCapability() +
            ") vs " + defender.getPlayerName() + " (Capability: " + defender.getPlayerCapability() + ")");

        if (striker.getPlayerCapability() > defender.getPlayerCapability()) {
            System.out.println("The striker passed the defender!");
            System.out.println("Now faces the goalkeeper " + goalkeeper.getPlayerName() + " (Capability: " + goalkeeper.getPlayerCapability() + ")");
            // Defender failed, count it
            defenderFails.put(defender, defenderFails.getOrDefault(defender, 0) + 1);

            if (striker.getPlayerCapability() > goalkeeper.getPlayerCapability()) {
                System.out.println("GOAL by " + striker.getPlayerName() + "!");
                strikerGoals.put(striker, strikerGoals.getOrDefault(striker, 0) + 1);
                return true;
            } else {
                System.out.println("SAVE by the goalkeeper!");
                return false;
            }
        } else {
            System.out.println("The defender stopped the attack!");
            return false;
        }
    }

    // Starts the match with two halves and 10 attacks per team per half
    public void startGame() {
        if (homeTeam == null || awayTeam == null) {
            throw new IllegalStateException("There are not two properly structured teams to start the match.");
        }
        System.out.println("The match between " + homeTeam.getTeamName() + " and " + awayTeam.getTeamName() + " begins!\n");

        for (int half = 1; half <= 2; half++) {
            System.out.println("---- Half " + half + " ----");
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0) {
                    System.out.println("\nAttack " + (i + 1) + ": " + homeTeam.getTeamName());
                    if (offense(homeTeam, awayTeam)) homeGoals++;
                } else {
                    System.out.println("\nAttack " + (i + 1) + ": " + awayTeam.getTeamName());
                    if (offense(awayTeam, homeTeam)) awayGoals++;
                }
            }
            System.out.println("\nScore at half " + half + ": " + homeTeam.getTeamName() + " " + homeGoals + " - " + awayGoals + " " + awayTeam.getTeamName() + "\n");
        }

    }

    public void printResults() {
        System.out.println("Final score: " + homeTeam.getTeamName() + " " + homeGoals + " - " + awayGoals + " " + awayTeam.getTeamName());
    }

    public void printBestOffencePlayer() {
        FootballPlayers best = null;
        int maxGoals = -1;
        for (Map.Entry<FootballPlayers, Integer> entry : strikerGoals.entrySet()) {
            if (entry.getValue() > maxGoals) {
                maxGoals = entry.getValue();
                best = entry.getKey();
            }
        }
        if (best != null) {
            System.out.println("Best offensive player: " + best.getPlayerName() + " with " + maxGoals + " goals.");
        } else {
            System.out.println("No offensive player scored a goal.");
        }
    }

    public void printWorstDefencePlayer() {
        FootballPlayers worst = null;
        int maxFails = -1;
        for (Map.Entry<FootballPlayers, Integer> entry : defenderFails.entrySet()) {
            if (entry.getValue() > maxFails) {
                maxFails = entry.getValue();
                worst = entry.getKey();
            }
        }
        if (worst != null) {
            System.out.println("Worst defender: " + worst.getPlayerName() + " was passed " + maxFails + " times.");
        } else {
            System.out.println("No defender was passed.");
        }
    }

    public static void main(String[] args) {
        try {
            Anametrisi match = new Anametrisi();
            match.printDraft();
            match.startGame();
            match.printResults();
            match.printBestOffencePlayer();
            match.printWorstDefencePlayer();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
