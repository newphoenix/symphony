package ba.sec.app.dto;

import java.io.Serializable;
import java.util.List;

public class TagResult implements Serializable{
	
	private static final long serialVersionUID = -2808104807108078000L;
	
	private String msg;
	private List<String> tags;
	
	public TagResult(){}
	
	public TagResult(String msg, List<String> tags) {
		super();
		this.msg = msg;
		this.tags = tags;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
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
		TagResult other = (TagResult) obj;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "TagResult [msg=" + msg + ", tags=" + tags + "]";
	}

	
	
	

	
	
	
	

	

	
	
	
}
