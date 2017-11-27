package warehuis.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class StoreItemId implements Serializable{
	private int idStoreItem;

	public int getIdStoreItem() {
		return idStoreItem;
	}

	public void setIdStoreItem(int idStoreItem) {
		this.idStoreItem = idStoreItem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idStoreItem;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoreItemId other = (StoreItemId) obj;
		if (idStoreItem != other.idStoreItem)
			return false;
		return true;
	}
}
