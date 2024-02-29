package be.epicode.buildWeek5.entities;

import be.epicode.buildWeek5.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "utenti")
@JsonIgnoreProperties({"password", "credentialsNonExpired", "accountNonExpired", "authorities", "accountNonLocked", "enabled"})
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private UUID id;

    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    private String name;
    private String surname;
    private String avatar;
    @Enumerated(EnumType.STRING)
    private UserRole role;

//    @JsonIgnore
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Customer customer;

    public User(String username, String email, String password, String name, String surname, String avatar, UserRole role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.avatar = avatar;
        this.role = role;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
