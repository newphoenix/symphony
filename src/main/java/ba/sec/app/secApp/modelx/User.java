package ba.sec.app.secApp.modelx;
// Generated Jul 3, 2017 10:18:42 PM by Hibernate Tools 4.3.1.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "user", catalog = "rest_db2", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5573824329871407153L;
	
	private Integer id;
	
	@NotBlank(message="Email is required")
	@Email(message="Please enter correct email address")
	private String email;
	
	@NotBlank(message="Password is requied")
	private String password;
	
	@NotBlank(message="FirstName is required")
	private String firstname;
	
	@NotBlank(message="LastName is requied")
	private String lastname;
	private boolean enabled;
	private Set<Link> links = new HashSet<Link>(0);
	private Set<Authority> authorities = new HashSet<Authority>(0);

	public User() {
	}

	public User(String email, String password, String firstname, String lastname, boolean enabled) {
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.enabled = enabled;
	}

	public User(String email, String password, String firstname, String lastname, boolean enabled, Set<Link> links,
			Set<Authority> authorities) {
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.enabled = enabled;
		this.links = links;
		this.authorities = authorities;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "email", unique = true, nullable = false, length = 60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 128)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "firstname", nullable = false)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname", nullable = false)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Link> getLinks() {
		return this.links;
	}

	public void setLinks(Set<Link> links) {
		this.links = links;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Authority> getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

}
