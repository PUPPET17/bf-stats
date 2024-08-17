package com.puppet17.bfstats.utils.algorithms;

/**
 * @author xyx
 * @date 2024/4/28
 */
public class LCS {

    public static String lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // 构建一个二维数组来存储子问题的解
        int[][] dp = new int[m + 1][n + 1];

        // 通过比较两个字符串，填充dp数组
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 构建最长公共子序列
        int index = dp[m][n];
        char[] lcs = new char[index];
        int i = m, j = n;
        while (i > 0 && j > 0) {
            // 如果当前字符在s1和s2中都相同，则它是LCS的一部分
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs[index - 1] = s1.charAt(i - 1);
                i--;
                j--;
                index--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return new String(lcs);
    }
}
