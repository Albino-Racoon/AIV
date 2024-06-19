
package com.mail.SpringMail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("khalx.steam@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);

        System.out.println("Email sent!");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendMail() {

        String recipient = "jasa.kokalj@gmail.com";
        String subject = "Izbrani ste kot zdravnik:)";
        String text = "Pacient z id-jem "+1+"vas je izbral za osebnega zdravnika. "+"                                                                 " +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "Lep pozdrav, ekipa e-zdravnik:=)";
        sendEmail(recipient, subject, text);
   /*for (int i=1;i<10;i++){
       String text1 = "Pacient z id-jem "+i+"vas je izbral za osebnega zdravnika. "+"                                                                 " +
               "" +
               "" +
               "" +
               "" +
               "" +
               "" +
               "" +
               "" +
               "Lep pozdrav, ekipa e-zdravnik:=)";
       sendEmail(recipient, subject, text1);
       System.out.println(i);

        }


*/
    }
}