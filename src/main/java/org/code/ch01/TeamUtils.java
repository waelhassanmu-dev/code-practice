package org.code.ch01;

import java.util.*;
import java.util.stream.Collectors;

public class TeamUtils {

    public static void generateTeamsScores(List<Team> teams,
                                           int numberOfRounds) {
        Random random = new Random();
        teams.forEach(team -> {
            for (int i = 0; i < numberOfRounds; i++) {
                team.getScores().add(random.nextInt(11));
            }
        });
    }

    public static void revealResults(List<Team> teams) {

        if (teams.isEmpty() || teams.stream().allMatch(team -> team.getScores().isEmpty())) {
            System.out.println("The game hasn't started yet.");
            return;
        }

        TreeMap<Integer, List<Team>> scoreTeamsMap = teams.stream()
                .collect(Collectors.groupingBy(Team::sumTotalScore,
                        TreeMap::new, Collectors.toList()));

        //System.out.println("scoreTeamsMap -> " + scoreTeamsMap);

        Iterator<Integer> scoreResultsIterator = scoreTeamsMap.descendingKeySet()
                .stream()
                .iterator();

        System.out.println("Now for the results, the WINNER is...");
        announceResult(scoreResultsIterator.next(), scoreTeamsMap);

        while (scoreResultsIterator.hasNext()) {
            System.out.println("Then we have... ");
            announceResult(scoreResultsIterator.next(), scoreTeamsMap);
        }
    }

    private static void announceResult(int score, TreeMap<Integer, List<Team>> scoreTeamsMap) {

        List<Team> playersWithScore = scoreTeamsMap.get(score);

        if (playersWithScore.size() > 1) {
            System.out.println("It's a TIE!");
        }

        playersWithScore
                .forEach(team -> System.out.println("With " + score +
                        " points, it's team " + team.getPlayer1() + " and " +
                        team.getPlayer2() + "!"));

        System.out.println();
    }

    public static void main(String[] args) {
        Team team1 = new Team("Sally", "Roger");
        Team team2 = new Team("Eric", "Rebecca");
        Team team3 = new Team("Tony", "Shannon");

        List<Team> teams = List.of(team1, team2, team3);
        int numberOfRounds = 4;

        TeamUtils.generateTeamsScores(teams, numberOfRounds);

        TeamUtils.revealResults(teams);
    }
}
