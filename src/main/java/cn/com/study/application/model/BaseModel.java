package cn.com.study.application.model;

import java.io.Serializable;

public class BaseModel implements Serializable {

	protected int zid;
	protected String uid;

	public int getZid() {
		return zid;
	}

	public void setZid(int zid) {
		this.zid = zid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
}