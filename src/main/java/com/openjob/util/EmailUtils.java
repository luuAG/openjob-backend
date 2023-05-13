package com.openjob.util;

import com.openjob.model.dto.enums.EmailCase;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailUtils {
    private final Configuration configuration;
    private final JavaMailSender javaMailSender;

    @Async
    public void sendEmail(String recipient, String subject, Map<String, Object> data, EmailCase emailCase) throws MessagingException, TemplateException, IOException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject(subject);
        helper.setTo(recipient);
        String emailContent = getEmailContent(data, emailCase);
        helper.setText(emailContent, true);
        javaMailSender.send(mimeMessage);
    }

    String getEmailContent(Map<String, Object> data, EmailCase emailCase) throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter();
        configuration.getTemplate(emailCase.getTemplate()).process(data, stringWriter);
        return stringWriter.getBuffer().toString();
    }
}
