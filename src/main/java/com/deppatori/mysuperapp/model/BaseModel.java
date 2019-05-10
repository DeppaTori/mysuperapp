package com.deppatori.mysuperapp.model;

import org.bson.types.ObjectId;

public class BaseModel {
	private ObjectId _id;
	
	public ObjectId getId() {
		return _id;
	}

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	
	
}
