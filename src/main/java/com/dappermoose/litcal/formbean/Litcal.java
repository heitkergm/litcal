package com.dappermoose.litcal.formbean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * The Class Litcal.
 */
public class Litcal
{
    @NotNull (message = "{litcal.year.required}")
    @Min (value = 2000, message = "{litcal.year.min}")
    private Integer year;

    /**
     * Gets the year.
     *
     * @return the year
     */
    public Integer getYear ()
    {
        return year;
    }

    /**
     * Sets the year.
     *
     * @param yearNew the new year value
     */
    public void setYear (final Integer yearNew)
    {
        year = yearNew;
    }
}
