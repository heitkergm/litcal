package com.dappermoose.litcal.init;

import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
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

        System.setProperty ("spring.devtools.restart.enabled", "false");
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

        if (ctx.getMessage ("mail.to", new Object[] {}, Locale.getDefault ()) == null)
        {
            System.out.println ("mail.to message not defined");
        }
        else
        {
            System.out.println ("preparing email message");
            msg.setFrom (ctx.getMessage ("mail.sender", new Object[] {}, Locale.getDefault ()));
            msg.setTo (ctx.getMessage ("mail.to", new Object[] {}, Locale.getDefault ()));
            msg.setSubject (ctx.getMessage ("mail.subject", new Object[] {}, Locale.getDefault ()));
            msg.setText (ctx.getMessage ("mail.upmsg", new Object[] {}, Locale.getDefault ()));
            mailer.send (msg);
            System.out.println ("Sent email message");
        }
    }

    /**
     * protected constructor.
     */
    protected Application ()
    {
    }
}
