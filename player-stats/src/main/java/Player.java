public interface Player {
    /**
     * @return player name
     */
    String getName();

    /**
     * @return player eliminations
     */
    int getElims();

    /**
     * @return player final blows
     */
    int getFinalBlows();

    /**
     * @return player damage
     */
    int getDamage();

    /**
     * @return player deaths
     */
    int getDeaths();

    /**
     * @return player healing
     */
    int getHealing();

    /**
     * @return player blocked
     */
    int getBlocked();

    /**
     * @return player time played
     */
    int getPlayerTime();

    /**
     * @return list of heroes
     */
    List<Heroes> getHeroes();
}
