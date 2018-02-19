package drapps.leagueoflegendshq.models;

import io.realm.RealmObject;

/**
 * Created by Diogo on 04/06/2017.
 */

public class ChampionRankedStats extends RealmObject {

    private int id;
    private int totalSessionsPlayed;
    private int totalSessionsWon;
    private int totalSessionsLost;
    private int totalChampionKills;
    private int totalDamageDealt;
    private int totalDamageTaken;
    private int mostChampionKillsPerSession;
    private int totalMinionKills;
    private int totalDoubleKills;
    private int totalTripleKills;
    private int totalQuadraKills;
    private int totalPentaKills;
    private int totalDeathsPerSession;
    private int totalGoldEarned;
    private int totalTurretsKilled;
    private int totalPhysicalDamageDealt;
    private  int totalMagicDamageDealt;
    private int totalAssists;
    private int maxChampionsKilled;
    private int maxNumDeaths;

    private int maxTimeSpentLiving;

    public int getTotalSessionsPlayed() {
        return totalSessionsPlayed;
    }

    public void setTotalSessionsPlayed(int totalSessionsPlayed) {
        this.totalSessionsPlayed = totalSessionsPlayed;
    }

    public int getTotalSessionsWon() {
        return totalSessionsWon;
    }

    public void setTotalSessionsWon(int totalSessionsWon) {
        this.totalSessionsWon = totalSessionsWon;
    }

    public int getTotalSessionsLost() {
        return totalSessionsLost;
    }

    public void setTotalSessionsLost(int totalSessionsLost) {
        this.totalSessionsLost = totalSessionsLost;
    }

    public int getTotalChampionKills() {
        return totalChampionKills;
    }

    public void setTotalChampionKills(int totalChampionKills) {
        this.totalChampionKills = totalChampionKills;
    }

    public int getTotalDamageDealt() {
        return totalDamageDealt;
    }

    public void setTotalDamageDealt(int totalDamageDealt) {
        this.totalDamageDealt = totalDamageDealt;
    }

    public int getTotalDamageTaken() {
        return totalDamageTaken;
    }

    public void setTotalDamageTaken(int totalDamageTaken) {
        this.totalDamageTaken = totalDamageTaken;
    }

    public int getMostChampionKillsPerSession() {
        return mostChampionKillsPerSession;
    }

    public void setMostChampionKillsPerSession(int mostChampionKillsPerSession) {
        this.mostChampionKillsPerSession = mostChampionKillsPerSession;
    }

    public int getTotalMinionKills() {
        return totalMinionKills;
    }

    public void setTotalMinionKills(int totalMinionKills) {
        this.totalMinionKills = totalMinionKills;
    }

    public int getTotalDoubleKills() {
        return totalDoubleKills;
    }

    public void setTotalDoubleKills(int totalDoubleKills) {
        this.totalDoubleKills = totalDoubleKills;
    }

    public int getTotalTripleKills() {
        return totalTripleKills;
    }

    public void setTotalTripleKills(int totalTripleKills) {
        this.totalTripleKills = totalTripleKills;
    }

    public int getTotalQuadraKills() {
        return totalQuadraKills;
    }

    public void setTotalQuadraKills(int totalQuadraKills) {
        this.totalQuadraKills = totalQuadraKills;
    }

    public int getTotalPentaKills() {
        return totalPentaKills;
    }

    public void setTotalPentaKills(int totalPentaKills) {
        this.totalPentaKills = totalPentaKills;
    }

    public int getTotalDeathsPerSession() {
        return totalDeathsPerSession;
    }

    public void setTotalDeathsPerSession(int totalDeathsPerSession) {
        this.totalDeathsPerSession = totalDeathsPerSession;
    }

    public int getTotalGoldEarned() {
        return totalGoldEarned;
    }

    public void setTotalGoldEarned(int totalGoldEarned) {
        this.totalGoldEarned = totalGoldEarned;
    }

    public int getTotalTurretsKilled() {
        return totalTurretsKilled;
    }

    public void setTotalTurretsKilled(int totalTurretsKilled) {
        this.totalTurretsKilled = totalTurretsKilled;
    }

    public int getTotalPhysicalDamageDealt() {
        return totalPhysicalDamageDealt;
    }

    public void setTotalPhysicalDamageDealt(int totalPhysicalDamageDealt) {
        this.totalPhysicalDamageDealt = totalPhysicalDamageDealt;
    }

    public int getTotalMagicDamageDealt() {
        return totalMagicDamageDealt;
    }

    public void setTotalMagicDamageDealt(int totalMagicDamageDealt) {
        this.totalMagicDamageDealt = totalMagicDamageDealt;
    }

    public int getTotalAssists() {
        return totalAssists;
    }

    public void setTotalAssists(int totalAssists) {
        this.totalAssists = totalAssists;
    }

    public int getMaxChampionsKilled() {
        return maxChampionsKilled;
    }

    public void setMaxChampionsKilled(int maxChampionsKilled) {
        this.maxChampionsKilled = maxChampionsKilled;
    }

    public int getMaxNumDeaths() {
        return maxNumDeaths;
    }

    public void setMaxNumDeaths(int maxNumDeaths) {
        this.maxNumDeaths = maxNumDeaths;
    }

    public int getMaxTimeSpentLiving() {
        return maxTimeSpentLiving;
    }

    public void setMaxTimeSpentLiving(int maxTimeSpentLiving) {
        this.maxTimeSpentLiving = maxTimeSpentLiving;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
