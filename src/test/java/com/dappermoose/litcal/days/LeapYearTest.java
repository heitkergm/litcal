package com.dappermoose.litcal.days;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *  Test the DateUtilities class.
 * @author matt
 */
public class LeapYearTest
{
    /**
     * Dummy constructor.
     */
    public LeapYearTest ()
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
     * Test of isLeapYear method, with 1900.
     */
    @Test
    public void testIsLeapYear1900 ()
    {
        System.out.println ("isLeapYear - 1900");
        Assert.assertFalse (LeapYear.isLeapYear (1900));
    }

    /**
     * Test of isLeapYear method, with 2000.
     */
    @Test
    public void testIsLeapYear2000 ()
    {
        System.out.println ("isLeapYear - 2000");
        Assert.assertTrue (LeapYear.isLeapYear (2000));
    }

    /**
     * Test of isLeapYear method, with 2016.
     */
    @Test
    public void testIsLeapYear2016 ()
    {
        System.out.println ("isLeapYear - 2016");
        Assert.assertTrue (LeapYear.isLeapYear (2016));
    }

    /**
     * Test of isLeapYear method, with 2013.
     */
    @Test
    public void testIsLeapYear2013 ()
    {
        System.out.println ("isLeapYear - 2013");
        Assert.assertFalse (LeapYear.isLeapYear (2013));
    }

    /**
     * Test of isLeapYear method, with 2014.
     */
    @Test
    public void testIsLeapYear2014 ()
    {
        System.out.println ("isLeapYear - 2014");
        Assert.assertFalse (LeapYear.isLeapYear (2014));
    }

    /**
     * Test of isLeapYear method, with 2015.
     */
    @Test
    public void testIsLeapYear2015 ()
    {
        System.out.println ("isLeapYear - 2015");
        Assert.assertFalse (LeapYear.isLeapYear (2015));
    }
}
