
package br.com.everis.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Area {

	@SerializedName("AreaPath")
	@Expose
	private String areaPath;

	public String getAreaPath() {
		return areaPath;
	}

	public void setAreaPath(String areaPath) {
		this.areaPath = areaPath;
	}

}
