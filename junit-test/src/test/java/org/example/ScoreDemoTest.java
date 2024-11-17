package org.example;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author qxlx
 * @date 2024/11/17 15:04
 */
public class ScoreDemoTest {

    private ScoreDemo scoreDemo = new ScoreDemo();

    @Test
    public void scoreLevelTest() {
        Assert.assertEquals("中",scoreDemo.scoreLevel(70));
    }

    @Test
    public void scoreLevelTest2() {
        Assert.assertEquals("良",scoreDemo.scoreLevel(85));
    }

    @Test
    public void scoreLevelTest3() {
        Assert.assertEquals("优",scoreDemo.scoreLevel(95));
    }

}