package org.example;

import org.junit.*;

/**
 * @author qxlx
 * @date 2024/11/17 15:04
 */
public class ScoreDemoTest {


    private ScoreDemo scoreDemo = new ScoreDemo();

    @BeforeClass
    public static void initBeforeClass() {
        System.out.println("BeforeClass");
    }

    @AfterClass
    public static void downAfterClass() {
        System.out.println("AfterClass");
    }

    @Before
    public void initBefore() {
        System.out.println("before....");
    }

    @After
    public void downAfer() {
        System.out.println("after....");
    }

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