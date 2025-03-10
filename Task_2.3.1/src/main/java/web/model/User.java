package web.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name="name")
    @NotBlank(message = "name is required field")
    private String name;

    @Column(name="lastname")
    @NotBlank(message = "surname is required field")
    private String lastName;

    @Column(name="email")
    @NotBlank(message = "email is required field")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Email must contain @")
    private String login;

    public User(){}

    public User(String name, String lastName,String login){
        this.name = name;
        this.lastName = lastName;
        this.login = login;
    }

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public String getLogin() {
        return login;
    }
}
