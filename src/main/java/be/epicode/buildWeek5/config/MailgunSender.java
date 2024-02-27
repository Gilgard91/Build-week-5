package be.epicode.buildWeek5.config;

import be.epicode.buildWeek5.entities.Customer;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MailgunSender {
    private String mailgunAPIKey;
    private String domainName;

    public MailgunSender(@Value("${mailgun.apikey}") String mailgunAPIKey, @Value("${mailgun.domainname}") String domainName) {
        this.mailgunAPIKey = mailgunAPIKey;
        this.domainName = domainName;
    }

    public void sendRegistrationEmail(Customer recipient) {
        Unirest.post("https://api.mailgun.net/v3/" + domainName + "/messages")
                .basicAuth("api", mailgunAPIKey)
                .queryString("from", "Ajeje Brazof <polpinato00@gmail.com>")
                .queryString("to", recipient.getEmail())
                .queryString("subject", "Sign up successfully completed!")
                .queryString("text", "Thank you " + recipient.getNameContact()).asJson();
    }
}
