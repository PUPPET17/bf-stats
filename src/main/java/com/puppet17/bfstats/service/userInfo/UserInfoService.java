package com.puppet17.bfstats.service.userInfo;

import com.puppet17.bfstats.po.PlayerForm;

/**
 * The interface User info service.
 *
 * @author PUPPET17
 * @version 1.0
 * @date 2024 /1/5
 */
public interface UserInfoService {

    /**
     * Gets player info.
     *
     * @param name the name
     * @return the player info
     */
    PlayerForm getPlayerInfoAsEntity(String name);

}
