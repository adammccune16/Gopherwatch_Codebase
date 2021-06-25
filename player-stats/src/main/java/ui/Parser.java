package ui;

import gopherwatch_stats_objects.Hero;
import gopherwatch_stats_objects.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Parser {
    public void Run() throws FileNotFoundException {
        ArrayList<Player> playersInMap;

        File directory = new File("C:\\Users\\Ryan\\Documents\\Overwatch\\Workshop\\NEEDS_TO_BE_ADDED");
        File fileList[] = directory.listFiles();

        for(File file: fileList) {
            //System.out.printf("%n%s%n", file.getName());
            Scanner fileReader = new Scanner(file);

            // needed to avoid errors when parsing the log
            String mapName = fileReader.nextLine().substring(11);

            // creates the players
            playersInMap = generatePlayers(fileReader);

            while(fileReader.hasNext()){
                for(Player player: playersInMap) {
                    updatePlayer(player, getTokens(fileReader, mapName));
                }
            }
            debug(playersInMap);
        }
    }

    public static ArrayList<Player> generatePlayers(Scanner fileReader) {
        String line = fileReader.nextLine().substring(11);
        String[] tokens = line.split(",");
        ArrayList<Player> players = new ArrayList<>();

        for (String token : tokens) {
            players.add(new Player(token));
        }

        return players;
    }

    public static String[] getTokens(Scanner fileReader, String mapName) {
        String line = fileReader.nextLine().substring(11);
        if(line.equals(mapName)) {
            fileReader.nextLine();
            line = fileReader.nextLine().substring(11);
        }
        return line.split(",");
    }

    public static void updatePlayer(Player player, String[] tokens) {
        double timePlayed = Double.parseDouble(tokens[0]);
        int elims = Integer.parseInt(tokens[3]);
        int finalBlows = Integer.parseInt(tokens[4]);
        double damageDone = Double.parseDouble(tokens[5]);
        int deaths = Integer.parseInt(tokens[6]);
        double healing = Double.parseDouble(tokens[7]);
        double blocked = Double.parseDouble(tokens[8]);

        // Update player total stats
        player.setCurrentStats(timePlayed, elims, finalBlows, damageDone, deaths, healing, blocked);

        // update players hero list
        updateHero(player, tokens, timePlayed, elims, finalBlows, damageDone, deaths, healing, blocked);
    }

    public static void updateHero(Player player, String[] tokens, double time, int e, int fB, double dD, int d, double h, double b) {
        // First Hero
        if(player.getHeroes().isEmpty()) {
            Hero newHero = new Hero(tokens[2]);
            player.setCurrentHero(newHero);
            player.getHeroes().add(newHero);
        }

        Hero currentHero = player.getCurrentHero();

        if(!currentHero.getName().equals(tokens[2])) { // New Hero Played
            createNewHero(currentHero, player, tokens, time, e, fB, dD, d, h, b);
        } else {  // Hero already played
            updateCurrentHero(currentHero, player, time, e, fB, dD, d, h, b);
        }
    }

    public static void updateCurrentHero(Hero cHero, Player player, double time, int e, int fB, double dD, int d, double h, double b) {
        cHero.setTimePlayed(time - player.getPreviousTimePlayed());
        cHero.setElims(e - player.getPreviousElims());
        cHero.setFinalBlows(fB - player.getPreviousFinalBlows());
        cHero.setDamageDone(dD - player.getPreviousDamageDone());
        cHero.setDeaths(d - player.getPreviousDeaths());
        cHero.setHealing(h - player.getPreviousHealing());
        cHero.setBlocked(b - player.getPreviousBlocked());
    }

    public static void createNewHero(Hero cHero, Player player, String[] tokens, double time, int e, int fB, double dD, int d, double h, double b) {
        updateCurrentHero(cHero, player, time, e, fB, dD, d, h, b);

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

    public void debug(ArrayList<Player> players) {
        for(Player player: players) {
            ArrayList<Hero> heroesPlayed = player.getHeroes();
            for(Hero hero: heroesPlayed) {
                System.out.print(player.getName() + ",");
                hero.Print();
                System.out.print("\n");
            }
        }
    }
}