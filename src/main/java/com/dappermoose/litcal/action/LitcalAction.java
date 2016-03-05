package com.dappermoose.litcal.action;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dappermoose.litcal.formbean.Litcal;

// TODO: Auto-generated Javadoc
/**
 * The Class LitcalAction.
 */
@Controller
public class LitcalAction
{
    /** The message source. */
    @Inject
    private MessageSource messageSource;

    @Inject
    private ApplicationContext context;

    /**
     * Main action. Display the form.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping (value = "/main", method = RequestMethod.GET)
    public String mainAction (final Model model)
    {
        Litcal litcal = new Litcal ();
        model.addAttribute ("litcal", litcal);
        return "main";
    }

    /**
     * Process register action.
     *
     * @param litcal the formbean
     * @param res the res
     * @param model the model
     * @param request the request
     * @return the string
     */
    @RequestMapping (value = "/main", method = RequestMethod.POST)
    public String processLitcalAction (
            @Valid @ModelAttribute ("litcal") final Litcal litcal,
            final BindingResult res, final Model model,
            final HttpServletRequest request)
    {
        if (res.hasErrors ())
        {
            model.addAttribute ("litcal", litcal);
            return "main";
        }

        return "calendar";
    }
}
