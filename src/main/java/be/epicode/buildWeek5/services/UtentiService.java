package be.epicode.buildWeek5.services;

import be.epicode.buildWeek5.entities.Utente;
import be.epicode.buildWeek5.exceptions.NotFoundException;
import be.epicode.buildWeek5.payloads.UtentiDTO;
import be.epicode.buildWeek5.repositories.UtentiDAO;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class UtentiService {

    @Autowired
    private UtentiDAO utentiDAO;
    @Autowired
    Cloudinary cloudinaryUploader;


    public Utente findById(UUID id) {
        return utentiDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public Utente findByEmail(String email){
        return utentiDAO.findByEmail(email).orElseThrow( () -> new NotFoundException("Email " + email + " non trovata"));
    }

    public List<Utente> getUsers(){
        return utentiDAO.findAll();
    }

    public List<Utente> getUsersById(List<UUID> usersIds){
        return utentiDAO.findAllById(usersIds);
    }

    public void findByIdAndDelete(UUID id){
        Utente found = this.findById(id);
        utentiDAO.delete(found);
    }

    public Utente findByIdAndUpdate(UUID id, UtentiDTO body){
        Utente found = this.findById(id);
        found.setUsername(body.username());
        found.setEmail(body.email());
        found.setPassword(body.password());
        found.setNome(body.nome());
        found.setCognome(body.cognome());
        found.setAvatar(body.avatar());
        found.setRuolo(body.ruolo());
        return utentiDAO.save(found);
    }

    public String uploadImg(MultipartFile img, UUID id) throws IOException {
        Utente found = findById(id);
        String url = (String) cloudinaryUploader.uploader().upload(img.getBytes(), ObjectUtils.emptyMap()).get("url");
        found.setAvatar(url);
        utentiDAO.save(found);
        return url;
    }
}
