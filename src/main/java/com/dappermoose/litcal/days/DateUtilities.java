
package com.dappermoose.litcal.days;

/**
 * a collection of utilities.
 *
 * @author matt
 */
public final class DateUtilities
{
    private DateUtilities ()
    {
    }

    /**
     * determines whether the give year is a leap year.
     *
     * @param year the year to evaluate
     * @return true/false, depending on whether a leap year or not.
     */
    public static Boolean isLeapYear (final int year)
    {
        Boolean retVal = Boolean.FALSE;

        if (year % 400 == 0)
        {
            retVal = Boolean.TRUE;
        }
        else
        {
            if ((year % 100 != 0) && (year % 4 == 0))
            {
                retVal = Boolean.TRUE;
            }
        }

        return retVal;
    }
}
