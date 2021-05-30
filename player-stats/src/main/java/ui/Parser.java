package ui;

import gopherwatch_stats_objects.Hero;
import gopherwatch_stats_objects.Player;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Parser {
    private ArrayList<Player> playersInMap = new ArrayList<>();

    public void Run() throws FileNotFoundException {
        // Scanner console = new Scanner(System.in);

        // TODO CREATE THE ABILITY TO ENTER ANOTHER FILE NAME
        FileInputStream fIn = new FileInputStream("C:\\Users\\Ryan\\Documents\\Overwatch\\Workshop\\Log-2021-05-03-22-59-19.txt");
        Scanner fileReader = new Scanner(fIn);

        String mapName = fileReader.nextLine().substring(11);

        // creates the players
        playersInMap = generatePlayers(fileReader);

        while(fileReader.hasNext()){
            updatePlayers(playersInMap, fileReader, mapName);
        }

        fileReader.close();

        for(Player player: playersInMap) {
            System.out.printf("%nPlayer Name: %s%n", player.getName());
            System.out.println("=".repeat(player.getName().length() + 13));
            System.out.printf("Time Played: %.2f%n", player.getTimePlayed());
            System.out.printf("Eliminations: %d%n", player.getElims());
            System.out.printf("Final Blows: %d%n", player.getFinalBlows());
            System.out.printf("Damage Done: %.2f%n", player.getDamageDone());
            System.out.printf("Deaths: %d%n", player.getDeaths());
            System.out.printf("Healing Done: %.2f%n", player.getHealing());
            System.out.printf("Damage Blocked: %.2f%n", player.getBlocked());

            ArrayList<Hero> heroesPlayed = player.getHeroes();
            for(Hero hero: heroesPlayed) {
                System.out.printf("%nHero Name: %s%n", hero.getName());
                System.out.println("=".repeat(hero.getName().length() + 11));
                System.out.printf("Time Played: %.2f%n", hero.getTimePlayed());
                System.out.printf("Eliminations: %d%n", hero.getElims());
                System.out.printf("Final Blows: %d%n", hero.getFinalBlows());
                System.out.printf("Damage Done: %.2f%n", hero.getDamageDone());
                System.out.printf("Deaths: %d%n", hero.getDeaths());
                System.out.printf("Healing Done: %.2f%n", hero.getHealing());
                System.out.printf("Damage Blocked: %.2f%n", hero.getBlocked());
            }
        }
    }

    public static String readString(String prompt, Scanner console) {
        System.out.print(prompt);
        return console.nextLine();
    }

    public static ArrayList<Player> generatePlayers(Scanner fileReader) {
        String line = fileReader.nextLine().substring(11);
        String[] tokens = line.split(",");
        ArrayList<Player> players = new ArrayList<>();

        for(int i = 0; i < tokens.length; i++) {
            players.add(new Player(tokens[i]));
        }

        return players;
    }

    public static void updatePlayers(ArrayList<Player> players, Scanner fileReader, String mapName) {
        for(Player player: players) {
            String[] tokens = getTokens(fileReader, mapName);

            double timePlayed = Double.parseDouble(tokens[0]);
            int elims = Integer.parseInt(tokens[3]);
            int finalBlows = Integer.parseInt(tokens[4]);
            double damageDone = Double.parseDouble(tokens[5]);
            int deaths = Integer.parseInt(tokens[6]);
            double healing = Double.parseDouble(tokens[7]);
            double blocked = Double.parseDouble(tokens[8]);

            // Update player total stats
            player.setCurrentStats(timePlayed, elims, finalBlows, damageDone, deaths, healing, blocked);

            // First Hero
            if(player.getHeroes().isEmpty()) {
                Hero newHero = new Hero(tokens[2]);
                player.setCurrentHero(newHero);
                player.getHeroes().add(newHero);
            }

            Hero currentHero = player.getCurrentHero();

            // New Hero Played
            if(!currentHero.getName().equals(tokens[2])) {
                createNewHero(currentHero, player, tokens, timePlayed, elims, finalBlows, damageDone, deaths, healing, blocked);
            } else {
                updateHero(currentHero, player, timePlayed, elims, finalBlows, damageDone, deaths, healing, blocked);
            }
        }
    }

    public static String[] getTokens(Scanner fileReader, String mapName) {
        String line = fileReader.nextLine().substring(11);
        System.out.println(line);
        if(line.equals(mapName)) {
            fileReader.nextLine();
            line = fileReader.nextLine().substring(11);
        }
        String[] tokenList = line.split(",");
        return tokenList;
    }

    public static void updateHero(Hero cHero, Player player, double time, int e, int fB, double dD, int d, double h, double b) {
        cHero.setTimePlayed(time - player.getPreviousTimePlayed());
        cHero.setElims(e - player.getPreviousElims());
        cHero.setFinalBlows(fB - player.getPreviousFinalBlows());
        cHero.setDamageDone(dD - player.getPreviousDamageDone());
        cHero.setDeaths(d - player.getPreviousDeaths());
        cHero.setHealing(h - player.getPreviousHealing());
        cHero.setBlocked(b - player.getPreviousBlocked());
    }

    public static void createNewHero(Hero cHero, Player player, String[] tokens, double time, int e, int fB, double dD, int d, double h, double b) {
        updateHero(cHero, player, time, e, fB, dD, d, h, b);

        player.setPreviousStats(time, e, fB, dD, d, h, b);

        ArrayList<Hero> heroes = player.getHeroes();
        boolean hasPlayedHeroBefore = false;
        int index = 0;
        for(Hero hero: heroes) {
            if(hero.getName().equals(tokens[2])) {
                hasPlayedHeroBefore = true;
                index = heroes.indexOf(hero);
                break;
            }
        }

        if(!hasPlayedHeroBefore) {
            Hero newHero = new Hero(tokens[2]);
            player.setCurrentHero(newHero);
            player.getHeroes().add(newHero);
        } else {
            player.setCurrentHero(heroes.get(index));
        }
    }
}
