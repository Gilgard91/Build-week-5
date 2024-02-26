package be.epicode.buildWeek5.services;

import be.epicode.buildWeek5.entities.User;
import be.epicode.buildWeek5.exceptions.NotFoundException;
import be.epicode.buildWeek5.payloads.UserDTO;
import be.epicode.buildWeek5.repositories.UsersDAO;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class UsersService {

    @Autowired
    private UsersDAO usersDAO;
    @Autowired
    Cloudinary cloudinaryUploader;


    public User findById(UUID id) {
        return usersDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public User findByEmail(String email){
        return usersDAO.findByEmail(email).orElseThrow( () -> new NotFoundException("Email " + email + " non trovata"));
    }

    public List<User> getUsers(){
        return usersDAO.findAll();
    }

    public List<User> getUsersById(List<UUID> usersIds){
        return usersDAO.findAllById(usersIds);
    }

    public void findByIdAndDelete(UUID id){
        User found = this.findById(id);
        usersDAO.delete(found);
    }

    public User findByIdAndUpdate(UUID id, UserDTO body){
        User found = this.findById(id);
        found.setUsername(body.username());
        found.setEmail(body.email());
        found.setPassword(body.password());
        found.setName(body.name());
        found.setSurname(body.surname());
        found.setAvatar(body.avatar());
        found.setRole(body.role());
        return usersDAO.save(found);
    }

    public String uploadImg(MultipartFile img) throws IOException {
        String url = (String) cloudinaryUploader.uploader().upload(img.getBytes(), ObjectUtils.emptyMap()).get("url");
        return url;
    }
}
