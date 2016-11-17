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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;
//stock
@Entity
@Table(name = "users")

public class users implements java.io.Serializable {
	private Integer Id;
	private String Name;
	private Set<chat> chats = new HashSet<chat>(0);

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@GeneratedValue(strategy = GenerationType.AUTO, generator = "qSqId")//(strategy = IDENTITY)
	//@SequenceGenerator(name = "gSqId", sequenceName = "sqId")
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() { return this.Id; }
	public void setId(Integer typeId) { this.Id = typeId; }
	
	@Column(name = "name", unique = true, nullable = false, length = 20)
	public String getName() { return this.Name; }
	public void setName(String typeName) { this.Name = typeName; }

	@ManyToMany( targetEntity = chat.class, fetch = FetchType.EAGER, cascade = { CascadeType.ALL } )
	@JoinTable(name = "chat2user", joinColumns = { 
			@JoinColumn(name = "uid", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "id", nullable = false, updatable = false) })
	public Set<chat> getChats() { return this.chats; }
	public void setChats(Set<chat> chats) { this.chats = chats; }

}
