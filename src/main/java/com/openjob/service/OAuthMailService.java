//package com.openjob.service;
//
//import com.google.api.client.auth.oauth2.Credential;
//import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
//import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
//import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.googleapis.json.GoogleJsonError;
//import com.google.api.client.googleapis.json.GoogleJsonResponseException;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.client.json.gson.GsonFactory;
//import com.google.api.client.util.store.FileDataStoreFactory;
//import com.google.api.services.gmail.Gmail;
//import com.google.api.services.gmail.GmailScopes;
//import com.google.api.services.gmail.model.Message;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.codec.binary.Base64;
//import org.springframework.stereotype.Service;
//
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.io.*;
//import java.nio.file.Paths;
//import java.security.GeneralSecurityException;
//import java.util.List;
//import java.util.Properties;
//
//@Service
//@Slf4j
//public class OAuthMailService {
//    private static final String APPLICATION_NAME = "OpenJob";
//    private static final String FROM_ADDRESS = "openjob.team@gmail.com";
//    private static final String TO_ADDRESS = "duongvannam2001@gmail.com";
//    private static final String SUBJECT = "Test";
//    private static final String BODY = "ALOOOOOOOOOOOOOoo";
//    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
//    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
//    private static final List<String> SCOPES = List.of(GmailScopes.GMAIL_SEND);
//    private final Gmail service;
//
//    OAuthMailService() throws GeneralSecurityException, IOException {
//        NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
//        service = new Gmail.Builder(httpTransport, JSON_FACTORY, getCredentials(httpTransport))
//                .setApplicationName(APPLICATION_NAME)
//                .build();
//    }
//
//    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
//            throws IOException {
//        // Load client secrets.
//        InputStream in = OAuthMailService.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
//        if (in == null) {
//            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
//        }
//        GoogleClientSecrets clientSecrets =
//                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
//
//        // Build flow and trigger user authorization request.
//        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
//                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
//                .setDataStoreFactory(new FileDataStoreFactory(Paths.get("tokens").toFile()))
//                .setAccessType("offline")
//                .build();
//        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
//        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
//    }
//
//
//    public void sendEmail() throws IOException, MessagingException {
//        // Encode as MIME message
//        Properties props = new Properties();
//        Session session = Session.getDefaultInstance(props, null);
//        MimeMessage email = new MimeMessage(session);
//        email.setFrom(new InternetAddress(FROM_ADDRESS));
//        email.addRecipient(javax.mail.Message.RecipientType.TO,
//                new InternetAddress(TO_ADDRESS));
//        email.setSubject(SUBJECT);
//        email.setText(BODY);
//
//        // Encode and wrap the MIME message into a gmail message
//        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//        email.writeTo(buffer);
//        byte[] rawMessageBytes = buffer.toByteArray();
//        String encodedEmail = Base64.encodeBase64URLSafeString(rawMessageBytes);
//        Message message = new Message();
//        message.setRaw(encodedEmail);
//
//        // Send
//        try {
//            message = service.users().messages().send("me", message).execute();
//            log.debug("Message id: " + message.getId());
//        } catch (GoogleJsonResponseException e) {
//            // TODO(developer) - handle error appropriately
//            GoogleJsonError error = e.getDetails();
//            if (error.getCode() == 403) {
//                log.error("Unable to send email: " + e.getDetails());
//                System.err.println("Unable to send email: " + e.getDetails());
//            } else {
//                throw e;
//            }
//        }
//    }
//
//}
