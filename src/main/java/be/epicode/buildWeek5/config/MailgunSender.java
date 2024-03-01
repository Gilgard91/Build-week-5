package be.epicode.buildWeek5.config;

import be.epicode.buildWeek5.entities.Cliente;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MailgunSender {
    private String mailgunAPIKey;
    private String domainName;

    public MailgunSender(@Value("${mailgun.api.key}") String mailgunAPIKey, @Value("${mailgun.domain.name}") String domainName) {
        this.mailgunAPIKey = mailgunAPIKey;
        this.domainName = domainName;
    }

    public void sendRegistrationEmail(Cliente recipient) {
        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + domainName + "/messages")
                .basicAuth("api", mailgunAPIKey)
                .queryString("from", "Cosmin <kosmyn1994@gmail.com>")
                .queryString("to", recipient.getEmail())
                .queryString("subject", "Sign up successfully completed!")
                .queryString("text", "Gentile " + recipient.getNomeContatto() + recipient.getCognomeContatto() + ", \n Siamo lieti di annunciare che ora fai parte della SKRSKRR Gang dei caciottari! Oramai abbiamo i tuoi dati. Non puoi scappare. ").asJson();
        System.out.println(request.getBody());
    }

}
