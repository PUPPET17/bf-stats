package com.puppet17.bfstats.po;

/**
 * @author PUPPET17
 * @version 1.0
 * @date 2024/1/29
 */
public class Weapon {

    private String weaponName;

    private String type;

    private String image;

    private String timeEquipped;

    private int kills;

    private double killsPerMinute;

    private int headshotKills;

    private String headshots;

    private Long shotsFired;

    private Long shotsHit;

    private String accuracy;

    private double hitVKills;

    public Weapon() {
    }

    public Weapon(String weaponName, String type, String image, String timeEquipped, int kills, double killsPerMinute, int headshotKills, String headshots, Long shotsFired, Long shotsHit, String accuracy, double hitVKills) {
        this.weaponName = weaponName;
        this.type = type;
        this.image = image;
        this.timeEquipped = timeEquipped;
        this.kills = kills;
        this.killsPerMinute = killsPerMinute;
        this.headshotKills = headshotKills;
        this.headshots = headshots;
        this.shotsFired = shotsFired;
        this.shotsHit = shotsHit;
        this.accuracy = accuracy;
        this.hitVKills = hitVKills;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTimeEquipped() {
        return timeEquipped;
    }

    public void setTimeEquipped(String timeEquipped) {
        this.timeEquipped = timeEquipped;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public double getKillsPerMinute() {
        return killsPerMinute;
    }

    public void setKillsPerMinute(double killsPerMinute) {
        this.killsPerMinute = killsPerMinute;
    }

    public int getHeadshotKills() {
        return headshotKills;
    }

    public void setHeadshotKills(int headshotKills) {
        this.headshotKills = headshotKills;
    }

    public String getHeadshots() {
        return headshots;
    }

    public void setHeadshots(String headshots) {
        this.headshots = headshots;
    }

    public Long getShotsFired() {
        return shotsFired;
    }

    public void setShotsFired(Long shotsFired) {
        this.shotsFired = shotsFired;
    }

    public Long getShotsHit() {
        return shotsHit;
    }

    public void setShotsHit(Long shotsHit) {
        this.shotsHit = shotsHit;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public double getHitVKills() {
        return hitVKills;
    }

    public void setHitVKills(double hitVKills) {
        this.hitVKills = hitVKills;
    }
}
