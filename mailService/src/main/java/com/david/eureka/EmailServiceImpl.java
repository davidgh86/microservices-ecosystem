package com.david.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import sun.nio.ch.DatagramSocketAdaptor;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    public MailRepository mailRepository;

    @Override
    public void sendSimpleMessage(UserDto input) {
        try {

            Mail newMail = new Mail();
            newMail.setTo(input.getUsername());
            newMail.setSubject("TestSubject");
            newMail.setText("TestText");

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(newMail.getTo());
            message.setSubject(newMail.getSubject());
            message.setText(newMail.getText());

            mailRepository.save(newMail);
            emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }
}