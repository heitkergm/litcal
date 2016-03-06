package com.dappermoose.litcal.days;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *  Test the DateUtilities class
 * @author matt
 */
public class DateUtilitiesTest
{

    public DateUtilitiesTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    /**
     * Test of isLeapYear method, of class DateUtilities.
     */
    @Test
    public void testIsLeapYear()
    {
        System.out.println("isLeapYear");
        assertEquals (false, DateUtilities.isLeapYear (1900));
        assertEquals (true, DateUtilities.isLeapYear (2000));
        assertEquals (true, DateUtilities.isLeapYear (2016));
        assertEquals (false, DateUtilities.isLeapYear (2013));
        assertEquals (false, DateUtilities.isLeapYear (2014));
        assertEquals (false, DateUtilities.isLeapYear (2015));
    }
}
