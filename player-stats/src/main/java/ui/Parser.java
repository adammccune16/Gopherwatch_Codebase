package ui;

import gopherwatch_stats_objects.Hero;
import gopherwatch_stats_objects.Player;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
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

        // TODO PARSE REST OF FILE FOR PLAYER STATS

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
            String line = fileReader.nextLine().substring(11);
            System.out.println(line);
            if(line.equals(mapName)) {
                line = fileReader.nextLine();
                line = fileReader.nextLine().substring(11);
            }
            String[] tokens = line.split(",");

            // Update player total stats
            player.setTimePlayed(Double.parseDouble(tokens[0]));
            player.setElims(Integer.parseInt(tokens[3]));
            player.setFinalBlows(Integer.parseInt(tokens[4]));
            player.setDamageDone(Double.parseDouble(tokens[5]));
            player.setDeaths(Integer.parseInt(tokens[6]));
            player.setHealing(Double.parseDouble(tokens[7]));
            player.setBlocked(Double.parseDouble(tokens[8]));

            /*
            Hero current = player.getCurrentHero();
            if(!current.getName().equals(tokens[2])) {

            }
             */
        }
    }
}
