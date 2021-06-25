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

    private int previousElims;
    private int previousFinalBlows;
    private double previousDamageDone;
    private int previousDeaths;
    private double previousHealing;
    private double previousBlocked;
    private double previousTimePlayed;

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

    public int getPreviousElims() { return previousElims; }

    public void setPreviousElims(int previousElims) { this.previousElims = previousElims; }

    public int getPreviousFinalBlows() { return previousFinalBlows; }

    public void setPreviousFinalBlows(int previousFinalBlows) { this.previousFinalBlows = previousFinalBlows; }

    public double getPreviousDamageDone() { return previousDamageDone; }

    public void setPreviousDamageDone(double previousDamageDone) { this.previousDamageDone = previousDamageDone; }

    public int getPreviousDeaths() { return previousDeaths; }

    public void setPreviousDeaths(int previousDeaths) { this.previousDeaths = previousDeaths; }

    public double getPreviousHealing() { return previousHealing; }

    public void setPreviousHealing(double previousHealing) { this.previousHealing = previousHealing; }

    public double getPreviousBlocked() { return previousBlocked; }

    public void setPreviousBlocked(double previousBlocked) { this.previousBlocked = previousBlocked; }

    public double getPreviousTimePlayed() { return previousTimePlayed; }

    public void setPreviousTimePlayed(double previousTimePlayed) { this.previousTimePlayed = previousTimePlayed; }

    public void setCurrentStats(double timePlayed, int elims, int finalBlows, double damageDone, int deaths, double healing, double blocked) {
        setTimePlayed(timePlayed);
        setElims(elims);
        setFinalBlows(finalBlows);
        setDamageDone(damageDone);
        setDeaths(deaths);
        setHealing(healing);
        setBlocked(blocked);
    }

        public void setPreviousStats(double timePlayed, int elims, int finalBlows, double damageDone, int deaths, double healing, double blocked) {
        setPreviousTimePlayed(timePlayed);
        setPreviousElims(elims);
        setPreviousFinalBlows(finalBlows);
        setPreviousDamageDone(damageDone);
        setPreviousDeaths(deaths);
        setPreviousHealing(healing);
        setPreviousBlocked(blocked);
    }

    public void Print() {
        System.out.printf("%nPlayer Name: %s%n", getName());
        System.out.println("=".repeat(getName().length() + 13));
    }
}
