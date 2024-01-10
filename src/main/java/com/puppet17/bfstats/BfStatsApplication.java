package com.puppet17.bfstats;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author PUPPET17
 * @version 1.0
 * @date 2024/1/5
 */
@SpringBootApplication
@Configurable
public class BfStatsApplication {
    public static void main(String[] args) {
        SpringApplication.run(BfStatsApplication.class);
    }
}
