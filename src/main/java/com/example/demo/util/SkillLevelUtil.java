package com.example.demo.util;

public class SkillLevelUtil {

    public static int levelRank(String level) {
        if ("BEGINNER".equals(level)) return 1;
        if ("INTERMEDIATE".equals(level)) return 2;
        if ("EXPERT".equals(level)) return 3;
        return 0;
    }

    public static int priorityRank(String p) {
        if ("LOW".equals(p)) return 1;
        if ("MEDIUM".equals(p)) return 2;
        if ("HIGH".equals(p)) return 3;
        return 0;
    }
}
