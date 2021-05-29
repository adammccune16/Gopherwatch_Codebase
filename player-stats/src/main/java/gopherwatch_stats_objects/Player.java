package gopherwatch_stats_objects;

import java.util.ArrayList;

public class Player {
    // player total stat variables
    private String name;
    private int elims;
    private int finalBlows;
    private double damageDone;
    private int deaths;
    private double healing;
    private double blocked;
    private double timePlayed;
    private ArrayList<Hero> heroesPlayed = new ArrayList<>();

    // player current hero stats
    private Hero currentHero;

    private int previousPlayedElims;
    private int previousPlayedFinalBlows;
    private double previousPlayedDamageDone;
    private int previousPlayedDeaths;
    private double previousPlayedHealing;
    private double previousPlayedBlocked;
    private double previousPlayedTimePlayed;

    public Player(String name) {
        this.name = name;
        this.elims = 0;
        this.finalBlows = 0;
        this.damageDone = 0.0;
        this.deaths = 0;
        this.healing = 0.0;
        this.blocked = 0.0;
        this.timePlayed = 0.0;
        this.currentHero = null;
    }

    public String getName() { return name; }

    public int getElims() { return elims; }

    public int getFinalBlows() { return finalBlows; }

    public double getDamageDone() { return damageDone; }

    public int getDeaths() { return deaths; }

    public double getHealing() { return healing; }

    public double getBlocked() { return blocked; }

    public double getTimePlayed() { return timePlayed; }

    public Hero getCurrentHero()  { return currentHero; }

    public void setName(String name) { this.name = name; }

    public void setElims(int elims) { this.elims = elims; }

    public void setFinalBlows(int finalBlows) { this.finalBlows = finalBlows; }

    public void setDamageDone(double damageDone) { this.damageDone = damageDone; }

    public void setDeaths(int deaths) { this.deaths = deaths; }

    public void setHealing(double healing) { this.healing = healing; }

    public void setBlocked(double blocked) { this.blocked = blocked; }

    public void setTimePlayed(double timePlayed) { this.timePlayed = timePlayed; }

    public void setCurrentHero(Hero currentHero)  { this.currentHero = currentHero; }

    public ArrayList<Hero> getHeroes() { return heroesPlayed; }

    public int getPreviousPlayedElims() { return previousPlayedElims; }

    public void setPreviousPlayedElims(int previousPlayedElims) { this.previousPlayedElims = previousPlayedElims; }

    public int getPreviousPlayedFinalBlows() { return previousPlayedFinalBlows; }

    public void setPreviousPlayedFinalBlows(int previousPlayedFinalBlows) { this.previousPlayedFinalBlows = previousPlayedFinalBlows; }

    public double getPreviousPlayedDamageDone() { return previousPlayedDamageDone; }

    public void setPreviousPlayedDamageDone(double previousPlayedDamageDone) { this.previousPlayedDamageDone = previousPlayedDamageDone; }

    public int getPreviousPlayedDeaths() { return previousPlayedDeaths; }

    public void setPreviousPlayedDeaths(int previousPlayedDeaths) { this.previousPlayedDeaths = previousPlayedDeaths; }

    public double getPreviousPlayedHealing() { return previousPlayedHealing; }

    public void setPreviousPlayedHealing(double previousPlayedHealing) { this.previousPlayedHealing = previousPlayedHealing; }

    public double getPreviousPlayedBlocked() { return previousPlayedBlocked; }

    public void setPreviousPlayedBlocked(double previousPlayedBlocked) { this.previousPlayedBlocked = previousPlayedBlocked; }

    public double getPreviousPlayedTimePlayed() { return previousPlayedTimePlayed; }

    public void setPreviousPlayedTimePlayed(double previousPlayedTimePlayed) { this.previousPlayedTimePlayed = previousPlayedTimePlayed; }
}
