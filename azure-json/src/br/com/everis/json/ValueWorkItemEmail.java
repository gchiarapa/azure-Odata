
package br.com.everis.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ValueWorkItemEmail {

	@SerializedName("WorkItemId")
	@Expose
	public Integer workItemId;
	
	@SerializedName("State")
	@Expose
	public String state;
	
	@SerializedName("CodigoFQA_TIMDM")
	@Expose
	public String codigoFQATIMDM;
	
	@SerializedName("DestinatariosParaEnvio_TIMDM")
	@Expose
	public String destinatariosParaEnvioTIMDM;
	
	@SerializedName("URLProjeto_TIMDM")
	@Expose
	public String uRLProjetoTIMDM;

	public Integer getWorkItemId() {
		return workItemId;
	}

	public void setWorkItemId(Integer workItemId) {
		this.workItemId = workItemId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCodigoFQATIMDM() {
		return codigoFQATIMDM;
	}

	public void setCodigoFQATIMDM(String codigoFQATIMDM) {
		this.codigoFQATIMDM = codigoFQATIMDM;
	}
	
	public void setDestinatariosParaEnvioTIMDM(String destinatariosParaEnvioTIMDM) {
		this.destinatariosParaEnvioTIMDM = destinatariosParaEnvioTIMDM;
	}

	public String getDestinatariosParaEnvioTIMDM() {
		return destinatariosParaEnvioTIMDM;
	}


	public String getURLProjetoTIMDM() {
		return uRLProjetoTIMDM;
	}

	public void setURLProjetoTIMDM(String uRLProjetoTIMDM) {
		this.uRLProjetoTIMDM = uRLProjetoTIMDM;
	}


}
