package com.dappermoose.litcal.action;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dappermoose.litcal.formbean.Litcal;

// TODO: Auto-generated Javadoc
/**
 * The Class LitcalAction.
 */
@Controller
public class MainAction
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
    @RequestMapping (value = "/main")
    public String mainAction (final Model model)
    {
        Litcal litcal = new Litcal ();
        model.addAttribute ("litcal", litcal);
        return "main";
    }
}
