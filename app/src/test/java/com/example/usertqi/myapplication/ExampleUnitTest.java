package com.example.usertqi.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void mytest() {
        float value = 40f;
        int oldAngle = 110;
        int angle = (int) ((oldAngle + value) % 360);
        assertEquals(160, angle);

        value = 120;

    }
}