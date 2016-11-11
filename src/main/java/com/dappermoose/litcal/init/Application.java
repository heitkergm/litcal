package com.dappermoose.litcal.init;

import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * This is the class containing the main program for spring boot.
 */
@SpringBootApplication
@ServletComponentScan
public class Application
{
    /**
     * This is the main program for spring boot.
     *
     * @param args the command line arguments
     *
     */
    public static void main (final String[] args)
    {
        TimeZone.setDefault (TimeZone.getTimeZone ("UTC"));

        ApplicationContext ctx = SpringApplication.run (Application.class, args);

        System.out.println ("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames ();
        Arrays.sort (beanNames);
        for (String beanName : beanNames)
        {
            System.out.println (beanName);
        }

        sendStartupEmail (ctx);
    }

    private static void sendStartupEmail (final ApplicationContext ctx)
    {
        MailSender mailer = ctx.getBean (MailSender.class);
        SimpleMailMessage msg = new SimpleMailMessage ();
        Environment env = ctx.getEnvironment ();

        if (env.containsProperty ("mail.to"))
        {
            msg.setFrom (ctx.getMessage ("mail.sender", new Object[] {}, Locale.getDefault ()));
            msg.setTo (env.getProperty ("mail.to"));
            msg.setSubject (ctx.getMessage ("mail.subject", new Object[] {}, Locale.getDefault ()));
            msg.setText (ctx.getMessage ("mail.upmsg", new Object[] {}, Locale.getDefault ()));
            mailer.send (msg);
        }
    }

    protected Application ()
    {
    }
}
