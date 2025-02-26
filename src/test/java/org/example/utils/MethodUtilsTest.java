package org.example.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MethodUtilsTest {

    private MethodUtils methodUtils;

    @BeforeEach
    void setUp() {

        methodUtils = new MethodUtils();
    }

    @Test
    void add() {

        assertEquals(5, methodUtils.add(2,3));
    }


    @Test
    void sub() {

        assertEquals(9,methodUtils.sub(15,6));
    }

    @Test
    void mul() {

        assertEquals(2,methodUtils.mul(1,2));
    }

    @Test
    void div() {
        assertEquals(2,methodUtils.div(2,1));
    }
}