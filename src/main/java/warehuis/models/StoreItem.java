package warehuis.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="store_item")
@IdClass(StoreItemId.class)
public class StoreItem implements Serializable{
	@Id
	private int idStoreItem;
	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;*/
	
	@JsonBackReference
	@Id
	@ManyToOne(cascade=CascadeType.MERGE)
	//@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn
	//@NotFound(action=NotFoundAction.IGNORE)
	private Store store;
	
	@JsonManagedReference
	@Id
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn
	private Item item;// = new HashSet<Item>();
	//private String uuid = UUID.randomUUID().toString();
	private double price;
	private double salePrice;
	private int numberItems;
	
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	/*public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}*/
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public int getNumberItems() {
		return numberItems;
	}
	public void setNumberItems(int numberItems) {
		this.numberItems = numberItems;
	}
	public int getIdStoreItem() {
		return idStoreItem;
	}
	public void setIdStoreItem(int idStoreItem) {
		this.idStoreItem = idStoreItem;
	}
	@Override
	public String toString() {
		return this.store.getCode()+"-"+this.item.getCode()+"-"+this.numberItems+"-"+this.price;
	}
	
}
