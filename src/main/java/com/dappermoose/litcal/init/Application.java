package com.dappermoose.litcal.init;

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
        sendStartupEmail (ctx);
    }

    private static void sendStartupEmail (final ApplicationContext ctx)
    {
        MailSender mailer = ctx.getBean (MailSender.class);
        SimpleMailMessage msg = new SimpleMailMessage ();

        String envProp = System.getenv ("MAIL_TO");
        String recipient;
        recipient = envProp != null ? envProp :
                ctx.getMessage ("mail.to", new Object[] {}, Locale.getDefault ());

        if (recipient == null)
        {
            System.err.println ("mail.to property not defined and no MAIL_TO environment variable");
        }
        else
        {
            msg.setFrom (ctx.getMessage ("mail.sender", new Object[] {}, Locale.getDefault ()));
            msg.setTo (recipient);
            msg.setSubject (ctx.getMessage ("mail.subject", new Object[] {}, Locale.getDefault ()));
            msg.setText (ctx.getMessage ("mail.upmsg", new Object[] {}, Locale.getDefault ()));
            mailer.send (msg);
        }
    }

    /**
     * protected constructor.
     */
    protected Application ()
    {
    }
}
