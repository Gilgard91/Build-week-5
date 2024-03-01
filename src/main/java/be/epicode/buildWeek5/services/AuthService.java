package be.epicode.buildWeek5.services;

import be.epicode.buildWeek5.entities.Utente;
import be.epicode.buildWeek5.exceptions.UnauthorizedException;
import be.epicode.buildWeek5.payloads.UtentiDTO;
import be.epicode.buildWeek5.payloads.UtentiLoginDTO;
import be.epicode.buildWeek5.repositories.UtentiDAO;
import be.epicode.buildWeek5.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JWTTools jwtTools;
    @Autowired
    private UtentiDAO utentiDAO;
    @Autowired
    private UtentiService utentiService;
    @Autowired
    private PasswordEncoder bcrypt;


    public Utente save(UtentiDTO body){
        Utente newUtente = new Utente(body.username(),body.email(), bcrypt.encode(body.password()),
                body.nome(),body.cognome(),body.avatar(),body.ruolo());
        return utentiDAO.save(newUtente);
    }

    public String authenticateUserAndGenerateToken(UtentiLoginDTO payload) {
        Utente utente = utentiService.findByEmail(payload.email());
        if (bcrypt.matches(payload.password(), utente.getPassword())) {
            return jwtTools.createToken(utente);
        } else {
            throw new UnauthorizedException("Credenziali sbagliate!");
        }
    }

}
