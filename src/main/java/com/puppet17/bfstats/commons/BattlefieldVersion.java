package com.puppet17.bfstats.commons;

/**
 * @author xyx
 * @date 2024/8/19
 */
public enum BattlefieldVersion {
    
    BATTLEFIELD_1("1", "https://api.gametools.network/bf1/all/?format_values=true&platform=pc&skip_battlelog=false&lang=en-us&name="),
    
    BATTLEFIELD_V("V", "https://api.gametools.network/bfv/all/?format_values=true&platform=pc&skip_battlelog=false&lang=en-us&name=");
    private final String versionName;
    private final String url;
    
    BattlefieldVersion(String versionName, String url) {
        this.versionName = versionName;
        this.url = url;
    }
    
    public String getVersionName() {
        return versionName;
    }
    
    public String getUrl() {
        return url;
    }
    
    public static BattlefieldVersion fromString(String versionName) {
        for (BattlefieldVersion version : BattlefieldVersion.values()) {
            if (version.getVersionName().equalsIgnoreCase(versionName)) {
                return version;
            }
        }
        throw new IllegalArgumentException(versionName);
    }
}

