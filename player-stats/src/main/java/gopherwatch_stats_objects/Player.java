package gopherwatch_stats_objects;

import java.util.ArrayList;

public class Player {
    private String name;
    private int elims;
    private int finalBlows;
    private double damageDone;
    private int deaths;
    private double healing;
    private double blocked;
    private double timePlayed;
    private ArrayList<Hero> heroesPlayed = new ArrayList<>();
    private Hero currentHero;

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
}
