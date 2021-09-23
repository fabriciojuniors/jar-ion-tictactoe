package com.ion.tictactoe.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.ion.tictactoe.resource.FirebaseMessagingResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FirebaseMessagingService {

    private final FirebaseMessaging firebaseMessaging;
    private final String TOKEN = "AAAAJ51uL6A:APA91bHG6dXUrTPLhZqQ9vxBZy38XP1V7QS3uw591Eo809Ddb2LZ4689wqYCnRzBWAOj7UvfdKugR0edW981hAMV7eqGmjsUr0NxY5ChEVoOFTi_bfJIhf8SVZ_2yOQwHrbdqZR6mDZR";
    public FirebaseMessagingService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }


    public String sendNotification() throws FirebaseMessagingException, IOException {

        Notification notification = Notification
                .builder()
                .setTitle("note.getSubject()")
                .setBody("note.getContent()")
                .build();

        GoogleCredentials googleCredentials = GoogleCredentials
                .fromStream(new ClassPathResource("firebase-service-account.json").getInputStream());

        Message message = Message
                .builder()
                .setToken(TOKEN)
                .setNotification(notification)
                //.putAllData(note.getData())
                .putData("sender_id", "170144968608")
                .build();

        return firebaseMessaging.send(message);
    }

}
