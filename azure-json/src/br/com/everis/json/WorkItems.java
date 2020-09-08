
package br.com.everis.json;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkItems {

	@SerializedName("value")
	@Expose
	private JsonArray value = null;

	public JsonArray getValue() {
		return value;
	}

	public void setValue(JsonArray value) {
		this.value = value;
	}

}
