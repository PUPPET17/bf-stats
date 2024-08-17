package com.puppet17.bfstats.po;

import java.util.ArrayList;

/**
 * @author PUPPET17
 * @version 1.0
 * @date 2024/1/28
 */
public class PlayerStats {

    private String userId;

    private String avatar;

    private String userName;

    private Long id;

    private int rank;

    private String rankImg;

    private String rankName;

    private double skill;

    private double scorePerMinute;

    private double killsPerMinute;

    private String winPercent;

    private String bestClass;

    private String accuracy;

    private String headshots;

    private String timePlayed;

    private int secondsPlayed;

    private double killDeath;

    private double infantryKillDeath;

    private double infantryKillsPerMinute;

    private int kills;

    private int deaths;

    private int wins;

    private int loses;

    private double longestHeadShot;

    private int revives;

    private int dogtagsTaken;

    private int highestKillStreak;

    private int roundsPlayed;

    private String awardScore;

    private String bonusScore;

    private String squadScore;

    private String currentRankProgress;

    private String totalRankProgress;

    private int avengerKills;

    private int saviorKills;

    private int headShots;

    private int heals;

    private int repairs;

    private int killAssists;

    private ArrayList<Weapon> weapons;

    public PlayerStats(String userId, String avatar, String userName, Long id, int rank, String rankImg, String rankName, double skill, double scorePerMinute, double killsPerMinute, String winPercent, String bestClass, String accuracy, String headshots, String timePlayed, int secondsPlayed, double killDeath, double infantryKillDeath, double infantryKillsPerMinute, int kills, int deaths, int wins, int loses, double longestHeadShot, int revives, int dogtagsTaken, int highestKillStreak, int roundsPlayed, String awardScore, String bonusScore, String squadScore, String currentRankProgress, String totalRankProgress, int avengerKills, int saviorKills, int headShots, int heals, int repairs, int killAssists, ArrayList<Weapon> weapons) {
        this.userId = userId;
        this.avatar = avatar;
        this.userName = userName;
        this.id = id;
        this.rank = rank;
        this.rankImg = rankImg;
        this.rankName = rankName;
        this.skill = skill;
        this.scorePerMinute = scorePerMinute;
        this.killsPerMinute = killsPerMinute;
        this.winPercent = winPercent;
        this.bestClass = bestClass;
        this.accuracy = accuracy;
        this.headshots = headshots;
        this.timePlayed = timePlayed;
        this.secondsPlayed = secondsPlayed;
        this.killDeath = killDeath;
        this.infantryKillDeath = infantryKillDeath;
        this.infantryKillsPerMinute = infantryKillsPerMinute;
        this.kills = kills;
        this.deaths = deaths;
        this.wins = wins;
        this.loses = loses;
        this.longestHeadShot = longestHeadShot;
        this.revives = revives;
        this.dogtagsTaken = dogtagsTaken;
        this.highestKillStreak = highestKillStreak;
        this.roundsPlayed = roundsPlayed;
        this.awardScore = awardScore;
        this.bonusScore = bonusScore;
        this.squadScore = squadScore;
        this.currentRankProgress = currentRankProgress;
        this.totalRankProgress = totalRankProgress;
        this.avengerKills = avengerKills;
        this.saviorKills = saviorKills;
        this.headShots = headShots;
        this.heals = heals;
        this.repairs = repairs;
        this.killAssists = killAssists;
        this.weapons = weapons;
    }

    public PlayerStats() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getRankImg() {
        return rankImg;
    }

    public void setRankImg(String rankImg) {
        this.rankImg = rankImg;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public double getSkill() {
        return skill;
    }

    public void setSkill(double skill) {
        this.skill = skill;
    }

    public double getScorePerMinute() {
        return scorePerMinute;
    }

    public void setScorePerMinute(double scorePerMinute) {
        this.scorePerMinute = scorePerMinute;
    }

    public double getKillsPerMinute() {
        return killsPerMinute;
    }

    public void setKillsPerMinute(double killsPerMinute) {
        this.killsPerMinute = killsPerMinute;
    }

    public String getWinPercent() {
        return winPercent;
    }

    public void setWinPercent(String winPercent) {
        this.winPercent = winPercent;
    }

    public String getBestClass() {
        return bestClass;
    }

    public void setBestClass(String bestClass) {
        this.bestClass = bestClass;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getHeadshots() {
        return headshots;
    }

    public void setHeadshots(String headshots) {
        this.headshots = headshots;
    }

    public String getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(String timePlayed) {
        this.timePlayed = timePlayed;
    }

    public int getSecondsPlayed() {
        return secondsPlayed;
    }

    public void setSecondsPlayed(int secondsPlayed) {
        this.secondsPlayed = secondsPlayed;
    }

    public double getKillDeath() {
        return killDeath;
    }

    public void setKillDeath(double killDeath) {
        this.killDeath = killDeath;
    }

    public double getInfantryKillDeath() {
        return infantryKillDeath;
    }

    public void setInfantryKillDeath(double infantryKillDeath) {
        this.infantryKillDeath = infantryKillDeath;
    }

    public double getInfantryKillsPerMinute() {
        return infantryKillsPerMinute;
    }

    public void setInfantryKillsPerMinute(double infantryKillsPerMinute) {
        this.infantryKillsPerMinute = infantryKillsPerMinute;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public double getLongestHeadShot() {
        return longestHeadShot;
    }

    public void setLongestHeadShot(double longestHeadShot) {
        this.longestHeadShot = longestHeadShot;
    }

    public int getRevives() {
        return revives;
    }

    public void setRevives(int revives) {
        this.revives = revives;
    }

    public int getDogtagsTaken() {
        return dogtagsTaken;
    }

    public void setDogtagsTaken(int dogtagsTaken) {
        this.dogtagsTaken = dogtagsTaken;
    }

    public int getHighestKillStreak() {
        return highestKillStreak;
    }

    public void setHighestKillStreak(int highestKillStreak) {
        this.highestKillStreak = highestKillStreak;
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public void setRoundsPlayed(int roundsPlayed) {
        this.roundsPlayed = roundsPlayed;
    }

    public String getAwardScore() {
        return awardScore;
    }

    public void setAwardScore(String awardScore) {
        this.awardScore = awardScore;
    }

    public String getBonusScore() {
        return bonusScore;
    }

    public void setBonusScore(String bonusScore) {
        this.bonusScore = bonusScore;
    }

    public String getSquadScore() {
        return squadScore;
    }

    public void setSquadScore(String squadScore) {
        this.squadScore = squadScore;
    }

    public String getCurrentRankProgress() {
        return currentRankProgress;
    }

    public void setCurrentRankProgress(String currentRankProgress) {
        this.currentRankProgress = currentRankProgress;
    }

    public String getTotalRankProgress() {
        return totalRankProgress;
    }

    public void setTotalRankProgress(String totalRankProgress) {
        this.totalRankProgress = totalRankProgress;
    }

    public int getAvengerKills() {
        return avengerKills;
    }

    public void setAvengerKills(int avengerKills) {
        this.avengerKills = avengerKills;
    }

    public int getSaviorKills() {
        return saviorKills;
    }

    public void setSaviorKills(int saviorKills) {
        this.saviorKills = saviorKills;
    }

    public int getHeadShots() {
        return headShots;
    }

    public void setHeadShots(int headShots) {
        this.headShots = headShots;
    }

    public int getHeals() {
        return heals;
    }

    public void setHeals(int heals) {
        this.heals = heals;
    }

    public int getRepairs() {
        return repairs;
    }

    public void setRepairs(int repairs) {
        this.repairs = repairs;
    }

    public int getKillAssists() {
        return killAssists;
    }

    public void setKillAssists(int killAssists) {
        this.killAssists = killAssists;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }
}
