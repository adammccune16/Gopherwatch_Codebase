public class Hero {
    private final String name;
    private int elims;
    private int finalBlows;
    private int damageDone;
    private int deaths;
    private int healing;
    private int blocked;
    private int timePlayed;

    public String getName() { return name; }

    public int getElims() { return elims; }

    public int getFinalBlows() { return finalBlows; }

    public int getDamageDone() { return damageDone; }

    public int getDeaths() { return deaths; }

    public int getHealing() { return healing; }

    public int getBlocked() { return blocked; }

    public int getTimePlayed() { return timePlayed; }

    public void setName(String name) { this.name = name; }

    public void setElims(int elims) { this.elims = elims; }

    public void setFinalBlows(int finalBlows) { this.finalBlows = finalBlows; }

    public void setDamageDone(int damageDone) { this.damageDone = damageDone; }

    public void setDeaths(int deaths) { this.deaths = deaths; }

    public void setHealing(int healing) { this.healing = healing; }

    public void setBlocked(int blocked) { this.blocked = blocked; }

    public void setTimePlayed(int timePlayed) { this.timePlayed = timePlayed; }
}
