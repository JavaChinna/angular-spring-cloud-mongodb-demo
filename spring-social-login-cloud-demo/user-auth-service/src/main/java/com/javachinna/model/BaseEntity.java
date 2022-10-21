package com.javachinna.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public abstract class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7363399724812884337L;

	protected String id;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (!this.getClass().isInstance(o))
			return false;

		BaseEntity other = (BaseEntity) o;

		return id != null && id.equals(other.getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}