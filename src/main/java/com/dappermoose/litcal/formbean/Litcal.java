package com.dappermoose.litcal.formbean;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * The Litcal formbean.
 */
@Getter
@Setter
@EqualsAndHashCode
public class Litcal
{
    /**
     * The calendar year.
     *
     * @param year for the liturgical calendar
     * @return the year
     */
    @NotNull (message = "{litcal.year.required}")
    @Min (value = 2000, message = "{litcal.year.min}")
    private Integer year;
}
