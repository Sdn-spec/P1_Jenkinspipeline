package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {
    @Test
    public void testAdd() {
        App app = new App();
        // Testing if 2 + 3 equals 5
        assertEquals(5, app.add(2, 3));
    }
}