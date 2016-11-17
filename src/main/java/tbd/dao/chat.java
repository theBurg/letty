package tbd.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "chats")

public class chat implements java.io.Serializable {
	private Integer Id;
	private String Name;
        private Set<users> users = new HashSet<users>(0);

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@GeneratedValue(strategy = GenerationType.AUTO, generator = "sqId")//(strategy = IDENTITY)
	//@SequenceGenerator(name = "sqId", sequenceName = "sqId")
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() { return this.Id; }
	public void setId(Integer id) { this.Id = id; }
	
        @Column(name = "name", unique = true, nullable = false, length = 20)
	public String getName() { return this.Name; }
	public void setName(String Name) { this.Name = Name; }

	@XmlTransient
        @ManyToMany(fetch = FetchType.EAGER, mappedBy = "chats")
	public Set<users> getUsers() { return this.users; }
	public void setUsers(Set<users> users) { this.users = users; }
}
