//package com.openjob.service;
//
//import com.openjob.model.entity.base.BaseUser;
//import freemarker.template.Configuration;
//import freemarker.template.TemplateException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.io.StringWriter;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//@RequiredArgsConstructor
//public class EmailService {
//    private final Configuration configuration;
//    private final JavaMailSender javaMailSender;
//
//    public void sendEmail(BaseUser baseUser) throws MessagingException, IOException, TemplateException {
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
//        helper.setSubject("Welcome To SpringHow.com");
//        helper.setTo("duongvannam2001@gmail.com");
//        String emailContent = getEmailContent(baseUser);
//        helper.setText(emailContent, true);
//        javaMailSender.send(mimeMessage);
//    }
//
//    String getEmailContent(BaseUser baseUser) throws IOException, TemplateException {
//        StringWriter stringWriter = new StringWriter();
//        Map<String, Object> model = new HashMap<>();
//        model.put("user", baseUser);
//        configuration.getTemplate("account_creation_mail.ftlh").process(model, stringWriter);
//        return stringWriter.getBuffer().toString();
//    }
//}
