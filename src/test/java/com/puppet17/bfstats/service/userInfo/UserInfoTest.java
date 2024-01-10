package com.puppet17.bfstats.service.userInfo;

import com.puppet17.bfstats.pojo.PlayerForm;
import com.puppet17.bfstats.service.stats.Bf1StatsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
/**
 * @author PUPPET17
 * @version 1.0
 * @date 2024/1/6
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserInfoTest {
    @Resource
    private UserInfoService userInfoService;
    @Test
    public void test_getPlayerInfoAsEntity() {
        PlayerForm playerForm = userInfoService.getPlayerInfoAsEntity("17puppet");
        String userId =  playerForm.getUserId();
        System.out.println("userId = " + userId);
    }
}
