package FinalProject;

import java.util.List;

public class FootballTeam {
    private String teamName;
    private List<FootballPlayers> players;

    public FootballTeam(String teamName, List<FootballPlayers> players) {
        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException("Players list cannot be null or empty.");
        }
        if (teamName == null || teamName.isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be null or empty.");
        }
        if (!teamName.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Team name must contain only alphabetic characters.");
        }

        long goalkeepers = players.stream().filter(p -> p.getPlayerPosition() == FootballPlayers.Position.GOALKEEPER).count();
        long defenders = players.stream().filter(p -> p.getPlayerPosition() == FootballPlayers.Position.DEFENDER).count();
        long strikers = players.stream().filter(p -> p.getPlayerPosition() == FootballPlayers.Position.STRIKER).count();
        // Check if the team has exactly 1 GOALKEEPER, 4 DEFENDERs, and 5 STRIKERs

         if (goalkeepers != 1 || defenders !=5  || strikers != 5) {
            throw new IllegalArgumentException("Team must have 1 GOALKEEPER, 5 DEFENDERs, and 5 STRIKERs.");
         }

        this.players = players;
        this.teamName = teamName;
    }
    public String getTeamName() {
        return teamName;
    }
    public List<FootballPlayers> getPlayers() {
        return players;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Football Team: ").append(teamName).append("\n");
        sb.append("Players:\n");
        for (FootballPlayers player : players) {
            sb.append("ID: ").append(player.getPlayerID())
              .append(", Name: ").append(player.getPlayerName())
              .append(", Age: ").append(player.getPlayerAge())
              .append(", Position: ").append(player.getPlayerPosition())
              .append(", Capability: ").append(player.getPlayerCapability()).append("\n");
        }
        return sb.toString();
    }
}
