package ba.sec.app.dto;

import java.io.Serializable;
import java.util.List;

import ba.sec.app.secApp.modelx.Link;

public class LinkResult implements Serializable{
	
	private static final long serialVersionUID = -2808104807108078658L;
	
	private String msg;
	private List<Link> links;
	
	public LinkResult(){}

	public LinkResult(String msg, List<Link> links) {
		super();
		this.msg = msg;
		this.links = links;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((links == null) ? 0 : links.hashCode());
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
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
		LinkResult other = (LinkResult) obj;
		if (links == null) {
			if (other.links != null)
				return false;
		} else if (!links.equals(other.links))
			return false;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LinkResult [msg=" + msg + ", links=" + links + "]";
	}

	
	
	

	
	
	
	

	

	
	
	
}
