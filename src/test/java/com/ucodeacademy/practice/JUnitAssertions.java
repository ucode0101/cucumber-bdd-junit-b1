package com.ucodeacademy.practice;


import org.junit.Assert;
import org.junit.Test;

public class JUnitAssertions {

    @Test
    public void jUnitAssertion(){

        Assert.assertTrue("Failed", 5 > 3);

        Assert.assertEquals("failed", 10,"ab");

        //Assert.assertArrayEquals();

    }

    @Test(expected = ArithmeticException.class)
    public void expectedException(){

        System.out.println(78 / 0);

    }

}
