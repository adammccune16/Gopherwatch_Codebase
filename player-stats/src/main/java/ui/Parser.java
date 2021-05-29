package ui;

import gopherwatch_stats_objects.Player;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Parser {
    private ArrayList<Player> playersInMap = new ArrayList<>();

    public void Run() throws FileNotFoundException {
        System.out.println("App is running");
        Scanner console = new Scanner(System.in);

        // TODO CREATE THE ABILITY TO ENTER ANOTHER FILE NAME
        FileInputStream fIn = new FileInputStream("C:\\Users\\Ryan\\Documents\\Overwatch\\Workshop\\Log-2021-05-03-22-59-19.txt");
        Scanner fileReader = new Scanner(fIn);

        String mapName = fileReader.nextLine();
        System.out.println(mapName);

        // creates the players
        playersInMap = generatePlayers(fileReader);

        // TODO PARSE REST OF FILE FOR PLAYER STATS

        fileReader.close();
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
}
