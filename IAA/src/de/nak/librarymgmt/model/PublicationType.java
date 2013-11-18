package de.nak.librarymgmt.model;

import java.io.Serializable;

/**
 * the publication type POJO
 */
public class PublicationType implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * the name of the publication type
	 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * the hash method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * the equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PublicationType other = (PublicationType) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * the to string method
	 */
	public String toString() {
		return this.name;
	}

}
