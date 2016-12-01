package com.dappermoose.litcal.days;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *  Test the WeekDay class.
 * @author matt
 */
public class WeekDayTest
{
    /**
     * Dummy constructor.
     */
    public WeekDayTest ()
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
     * Test of calcDate method, with 2016/08/12.
     */
    @Test
    public void testCalcDateWeekDayFri20160812 ()
    {
        System.out.println ("calcDate - 2016/08/12");
        Assert.assertEquals (5, WeekDay.calcWeekDate (2016, 8, 12));
    }

    /**
     * Test of calDate method, with 2000/01/01.
     */
    @Test
    public void testCalcDateWeekDayFri20160101 ()
    {
        System.out.println ("calcDate - 2016/01/01");
        Assert.assertEquals (5, WeekDay.calcWeekDate (2016, 1, 1));
    }
}