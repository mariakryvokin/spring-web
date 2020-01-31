package app.models;

/*import app.models.jbax.DateAdapter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;*/

import app.models.jbax.DateAdapter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;
import java.util.List;
/*import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;
import java.util.List;*/

//@XmlType(name = "user", propOrder = {"id", "firstName", "lastName", "email", "birthday", "roles"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
@Entity(name = "users")
@Table(name = "users")
public class User {
    public User() {
    }

/*
    public User(String firstName, String lastName, String email, Date birthday, String password, List<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
        this.password = password;
        this.roles = roles;
    }
*/

    @XmlElement
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @XmlElement
    @Column(name = "first_name")
    private String firstName;

    @XmlElement
    @Column(name = "last_name")
    private String lastName;

    @XmlElement
    @Column(name = "email")
    private String email;


    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlElement
   // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    //@Column(name = "birthday")
    private Date birthday;

   /* @XmlTransient
    @Column(name = "password")
    private String password;

    @XmlElementWrapper(name = "usersRoles")
    @XmlElement(name = "role")
    @ManyToMany()
    @JoinTable(
            name = "users_has_roles",
            joinColumns = {@JoinColumn(name = "users_id")},
            inverseJoinColumns = {@JoinColumn(name = "roles_name")}
    )
    private List<Role> roles;

    @XmlTransient
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @XmlTransient
    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets;


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
*//*
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }*//*

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }*/
}

