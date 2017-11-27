package warehuis.models;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="item", uniqueConstraints={@UniqueConstraint(columnNames={"code"})})
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	private String code;
	private String name;
	private String description;
	private String imageUrl;
	private String uuid = UUID.randomUUID().toString();
	@JsonBackReference
	@OneToMany (mappedBy="item")
	private Set<StoreItem> storeItem = new HashSet<StoreItem>();
	public Set<StoreItem> getStoreItem() {
		return storeItem;
	}
	public void setStoreItem(Set<StoreItem> storeItem) {
		this.storeItem = storeItem;
	}
	//@JoinTable
	//private Set<Inventory> inventory;
	//private Set<Store> store;
	public Item() {
		
	}
	public Item(String code, String name, String description, String imageUrl) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		//this.store = store;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/*public Set<Store> getStore() {
		return store;
	}
	public void setStore(Set<Store> store) {
		System.out.print(store.size());
		this.store = store;
	}*/
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	@Override
	public String toString() {
		return "Item [code=" + code + ", name=" + name + ", description=" + description + ", uuid=" + uuid + "]";
	}
}
