package com.dappermoose.litcal.days;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *  Test the EasterDay class.
 * @author matt
 */
public class EasterDayTest
{
    /**
     * Dummy constructor.
     */
    public EasterDayTest ()
    {
    }

    /**
     * setup before class instantiation.
     */
    @BeforeClass
    public static void setUpClass ()
    {
    }

    /**
     * class tear down when done with all tests.
     */
    @AfterClass
    public static void tearDownClass ()
    {
    }

    /**
     * Setup before each test.
     */
    @Before
    public void setUp ()
    {
    }

    /**
     * Tear down after each test.
     */
    @After
    public void tearDown ()
    {
    }

    /**
     * Test of calcEaster method, with 2016.
     */
    @Test
    public void testCalcDateEaster2016 ()
    {
        System.out.println ("calcDateEaster - 2016");
        Assert.assertEquals (27, EasterDay.calcEaster (2016));
    }
}
