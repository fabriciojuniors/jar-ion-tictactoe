package com.ion.tictactoe.resource;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.ion.tictactoe.services.FirebaseMessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class FirebaseMessagingResource {

    public class Note {
        private String subject;
        private String content;
        private Map<String, String> data;
        private String image;

        public Note(String subject, String content, Map<String, String> data, String image) {
            this.subject = subject;
            this.content = content;
            this.data = data;
            this.image = image;
        }

        public Note(){}

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Map<String, String> getData() {
            return data;
        }

        public void setData(Map<String, String> data) {
            this.data = data;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    /*******************************/
    @Autowired
    FirebaseMessagingService service;

    @RequestMapping("/send-notification")
    @ResponseBody
    public String sendNotification() throws FirebaseMessagingException, IOException {
        return service.sendNotification();
    }
}
