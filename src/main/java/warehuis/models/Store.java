package warehuis.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="store")
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	private String code;
	private String email;
	@Column(name="enabled", columnDefinition="INT(1)")
	private boolean isActive;
	//@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	private String uuid = UUID.randomUUID().toString();
	@JsonManagedReference
	@OneToMany(fetch=FetchType.EAGER, mappedBy="store", cascade = {CascadeType.PERSIST/*, CascadeType.MERGE*/}, orphanRemoval=true)
	private List<StoreItem> storeItem = new ArrayList<StoreItem>();
	public Store() {}
	public Store(String code, String email, boolean isActive, Date created) {
		super();
		this.code = code;
		this.email = email;
		this.isActive = isActive;
		this.created = created;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<StoreItem> getStoreItem() {
		
		return storeItem;
	}
	public void setStoreItem(List<StoreItem> storeItem) {
		this.storeItem = storeItem;
	}
}
