package org.example;

public class ScoreDemo
{
    public String scoreLevel(int score)
    {
        if (score < 80) {
            return "中";
        } else if (score < 90) {
            return "良";
        } else {
            return "优";
        }
    }
}
