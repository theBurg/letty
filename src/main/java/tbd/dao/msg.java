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

@Entity
@Table(name = "msg")

public class msg implements java.io.Serializable {
	private Integer Id;
	private Integer Cid;
        private String Msg;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() { return this.Id; }
	public void setId(Integer controlId) { this.Id = controlId; }
	
	@Column(name = "cid", unique = false, nullable = false, length = 20)
	public Integer getCid() { return this.Cid; }
	public void setCid(Integer cId) { 
            this.Cid = cId; }

	@Column(name = "msg", unique = false, nullable = false, length = 20)
	public String getMsg() { return this.Msg; }
	public void setMsg(String Msg) { 
            this.Msg = Msg; }
}
