package vincentweilasto.restful.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "users")
public class User implements Serializable {

    @Id
    @Column(length = 100, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100)
    private String token;

    @Column(name = "token_expired_at", unique = true)
    private Long tokenExpiredAt;

    @OneToMany(mappedBy = "user")
    private List<Contact> contacts;
}
