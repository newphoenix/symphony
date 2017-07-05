package ba.sec.app.secApp.modelx;
// Generated Jul 5, 2017 1:57:06 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Link generated by hbm2java
 */
@Entity
@Table(name = "link", catalog = "rest_db")
public class Link implements java.io.Serializable {

	private static final long serialVersionUID = 5062393606199160063L;
	
	private Integer id;
	private User user;
	private String link;
	private String tag;

	public Link() {
	}

	public Link(User user, String link, String tag) {
		this.user = user;
		this.link = link;
		this.tag = tag;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "link", nullable = false, length = 512)
	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(name = "tag", nullable = false, length = 512)
	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
