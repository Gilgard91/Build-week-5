package be.epicode.buildWeek5.services;

import be.epicode.buildWeek5.entities.User;
import be.epicode.buildWeek5.exceptions.UnauthorizedException;
import be.epicode.buildWeek5.payloads.UserDTO;
import be.epicode.buildWeek5.payloads.UserLoginDTO;
import be.epicode.buildWeek5.repositories.UsersDAO;
import be.epicode.buildWeek5.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JWTTools jwtTools;
    @Autowired
    private UsersDAO usersDAO;
    @Autowired
    private UsersService usersService;
    @Autowired
    private PasswordEncoder bcrypt;


    public User save(UserDTO body){
        User newUser = new User(body.username(),body.email(), bcrypt.encode(body.password()),
                body.name(),body.surname(),body.avatar(),body.role());
        return usersDAO.save(newUser);
    }

    public String authenticateUserAndGenerateToken(UserLoginDTO payload) {
        User user = usersService.findByEmail(payload.email());
        if (bcrypt.matches(payload.password(), user.getPassword())) {
            return jwtTools.createToken(user);
        } else {
            throw new UnauthorizedException("Credenziali sbagliate!");
        }
    }

}
