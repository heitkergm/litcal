package com.dappermoose.litcal.action;

// import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

// import org.springframework.context.ApplicationContext;
// import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dappermoose.litcal.days.EasterDay;
import com.dappermoose.litcal.days.LeapYear;
import com.dappermoose.litcal.days.WeekDay;
import com.dappermoose.litcal.formbean.Litcal;

import lombok.extern.log4j.Log4j2;

// TODO: Auto-generated Javadoc
/**
 * The Class LitcalAction.
 */
@Controller
@Log4j2
public class CalendarAction
{
    /** The message source. */
    /*
    @Inject
    private MessageSource messageSource;

    @Inject
    private ApplicationContext context;
    */
    /**
     * Process the make calendar action action.
     *
     * @param litcal the formbean
     * @param res the res
     * @param model the model
     * @param request the request
     * @return the string
     */
    @RequestMapping (value = "/calendar")
    public String processCalendarAction (
            @Valid @ModelAttribute ("litcal") final Litcal litcal,
            final BindingResult res, final Model model,
            final HttpServletRequest request)
    {
        if (res.hasErrors ())
        {
            model.addAttribute ("litcal", litcal);
            return "main";
        }

        Integer year = litcal.getYear ();
        LOG.debug ("year is " + year);
        model.addAttribute ("year", year);
        model.addAttribute ("isLeapYear", LeapYear.isLeapYear (year));
        model.addAttribute ("weekDay", WeekDay.calcWeekDate (year, 1, 1));
        model.addAttribute ("xmasDay", WeekDay.calcWeekDate (year, 12, 25));
        model.addAttribute ("easterDay", EasterDay.calcEaster (year));
        return "calendar";
    }
}
