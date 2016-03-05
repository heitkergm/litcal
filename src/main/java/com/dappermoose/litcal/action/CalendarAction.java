package com.dappermoose.litcal.action;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dappermoose.litcal.formbean.Litcal;

// TODO: Auto-generated Javadoc
/**
 * The Class LitcalAction.
 */
@Controller
public class CalendarAction
{
    private static final Logger LOG = LoggerFactory.getLogger (CalendarAction.class.getName ());

    /** The message source. */
    @Inject
    private MessageSource messageSource;

    @Inject
    private ApplicationContext context;

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

        LOG.debug ("year is " + litcal.getYear ());
        model.addAttribute ("year", litcal.getYear ());
        return "calendar";
    }
}
