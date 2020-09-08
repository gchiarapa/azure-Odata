
package br.com.everis.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Value {

	@SerializedName("WorkItemId")
	@Expose
	private Integer workItemId;
	@SerializedName("State")
	@Expose
	private String state;
	@SerializedName("CodigoDemanda_TIMDM")
	@Expose
	private String codigoDemandaTIMDM;
	@SerializedName("CodigoFQA_TIMDM")
	@Expose
	private String codigoFQATIMDM;
	@SerializedName("TesteCase_AreaUsuaria_TIMDM")
	@Expose
	private String testeCaseAreaUsuariaTIMDM;
	@SerializedName("TesteCase_Cenario_TIMDM")
	@Expose
	private String testeCaseCenarioTIMDM;
	@SerializedName("TesteCase_DataDelivery_TIMDM")
	@Expose
	private String testeCaseDataDeliveryTIMDM;
	@SerializedName("TesteCase_Funcionalidade_TIMDM")
	@Expose
	private String testeCaseFuncionalidadeTIMDM;
	@SerializedName("TesteCase_TestApprover1_TIMDM")
	@Expose
	private TesteCaseTestApprover1TIMDM testeCaseTestApprover1TIMDM;
	@SerializedName("TesteCase_TestApprover2_TIMDM")
	@Expose
	private TesteCaseTestApprover2TIMDM testeCaseTestApprover2TIMDM;
	@SerializedName("TesteCase_TestApprover3_TIMDM")
	@Expose
	private TesteCaseTestApprover3TIMDM testeCaseTestApprover3TIMDM;
	@SerializedName("TesteCase_TestApprover4_TIMDM")
	@Expose
	private TesteCaseTestApprover4TIMDM testeCaseTestApprover4TIMDM;
	@SerializedName("TesteCase_TestApprover5_TIMDM")
	@Expose
	private TesteCaseTestApprover5TIMDM testeCaseTestApprover5TIMDM;
	@SerializedName("Custom.TesteCase_TestApprover6")
	@Expose
	private TesteCaseTestApprover6TIMDM testeCaseTestApprover6TIMDM;
	@SerializedName("Custom.TesteCase_TestApprover7")
	@Expose
	private TesteCaseTestApprover7TIMDM testeCaseTestApprover7TIMDM;
	@SerializedName("Custom.TesteCase_TestApprover8")
	@Expose
	private TesteCaseTestApprover8TIMDM testeCaseTestApprover8TIMDM;
	@SerializedName("Custom.TesteCase_TestApprover9")
	@Expose
	private TesteCaseTestApprover9TIMDM testeCaseTestApprover9TIMDM;
	@SerializedName("Custom.TesteCase_TestApprover10")
	@Expose
	private TesteCaseTestApprover10TIMDM testeCaseTestApprover10TIMDM;
	@SerializedName("Area")
	@Expose
	private Area area;

	private String destinatarios;
	
	private String urlDashboard;
	
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

	public String getCodigoDemandaTIMDM() {
		return codigoDemandaTIMDM;
	}

	public void setCodigoDemandaTIMDM(String codigoDemandaTIMDM) {
		this.codigoDemandaTIMDM = codigoDemandaTIMDM;
	}

	public String getCodigoFQATIMDM() {
		return codigoFQATIMDM;
	}

	public void setCodigoFQATIMDM(String codigoFQATIMDM) {
		this.codigoFQATIMDM = codigoFQATIMDM;
	}

	public String getTesteCaseAreaUsuariaTIMDM() {
		return testeCaseAreaUsuariaTIMDM;
	}

	public void setTesteCaseAreaUsuariaTIMDM(String testeCaseAreaUsuariaTIMDM) {
		this.testeCaseAreaUsuariaTIMDM = testeCaseAreaUsuariaTIMDM;
	}

	public String getTesteCaseCenarioTIMDM() {
		return testeCaseCenarioTIMDM;
	}

	public void setTesteCaseCenarioTIMDM(String testeCaseCenarioTIMDM) {
		this.testeCaseCenarioTIMDM = testeCaseCenarioTIMDM;
	}

	public void setTesteCaseDataDeliveryTIMDM(String testeCaseDataDeliveryTIMDM) {

		this.testeCaseDataDeliveryTIMDM = testeCaseDataDeliveryTIMDM;

	}

	public String getTesteCaseDataDeliveryTIMDM() {
		return testeCaseDataDeliveryTIMDM;
	}

	public String getTesteCaseFuncionalidadeTIMDM() {
		return testeCaseFuncionalidadeTIMDM;
	}

	public void setTesteCaseFuncionalidadeTIMDM(String testeCaseFuncionalidadeTIMDM) {
		this.testeCaseFuncionalidadeTIMDM = testeCaseFuncionalidadeTIMDM;
	}

	public TesteCaseTestApprover1TIMDM getTesteCaseTestApprover1TIMDM() {
		return testeCaseTestApprover1TIMDM;
	}

	public void setTesteCaseTestApprover1TIMDM(TesteCaseTestApprover1TIMDM testeCaseTestApprover1TIMDM) {
		this.testeCaseTestApprover1TIMDM = testeCaseTestApprover1TIMDM;
	}

	public TesteCaseTestApprover2TIMDM getTesteCaseTestApprover2TIMDM() {
		return testeCaseTestApprover2TIMDM;
	}

	public void setTesteCaseTestApprover2TIMDM(TesteCaseTestApprover2TIMDM testeCaseTestApprover2TIMDM) {
		this.testeCaseTestApprover2TIMDM = testeCaseTestApprover2TIMDM;
	}

	public TesteCaseTestApprover3TIMDM getTesteCaseTestApprover3TIMDM() {
		return testeCaseTestApprover3TIMDM;
	}

	public void setTesteCaseTestApprover3TIMDM(TesteCaseTestApprover3TIMDM testeCaseTestApprover3TIMDM) {
		this.testeCaseTestApprover3TIMDM = testeCaseTestApprover3TIMDM;
	}

	public TesteCaseTestApprover4TIMDM getTesteCaseTestApprover4TIMDM() {
		return testeCaseTestApprover4TIMDM;
	}

	public void setTesteCaseTestApprover4TIMDM(TesteCaseTestApprover4TIMDM testeCaseTestApprover4TIMDM) {
		this.testeCaseTestApprover4TIMDM = testeCaseTestApprover4TIMDM;
	}

	public TesteCaseTestApprover5TIMDM getTesteCaseTestApprover5TIMDM() {
		return testeCaseTestApprover5TIMDM;
	}

	public void setTesteCaseTestApprover5TIMDM(TesteCaseTestApprover5TIMDM testeCaseTestApprover5TIMDM) {
		this.testeCaseTestApprover5TIMDM = testeCaseTestApprover5TIMDM;
	}

	public TesteCaseTestApprover6TIMDM getTesteCaseTestApprover6TIMDM() {
		return testeCaseTestApprover6TIMDM;
	}

	public void setTesteCaseTestApprover6TIMDM(TesteCaseTestApprover6TIMDM testeCaseTestApprover6TIMDM) {
		this.testeCaseTestApprover6TIMDM = testeCaseTestApprover6TIMDM;
	}

	public TesteCaseTestApprover7TIMDM getTesteCaseTestApprover7TIMDM() {
		return testeCaseTestApprover7TIMDM;
	}

	public void setTesteCaseTestApprover7TIMDM(TesteCaseTestApprover7TIMDM testeCaseTestApprover7TIMDM) {
		this.testeCaseTestApprover7TIMDM = testeCaseTestApprover7TIMDM;
	}

	public TesteCaseTestApprover8TIMDM getTesteCaseTestApprover8TIMDM() {
		return testeCaseTestApprover8TIMDM;
	}

	public void setTesteCaseTestApprover8TIMDM(TesteCaseTestApprover8TIMDM testeCaseTestApprover8TIMDM) {
		this.testeCaseTestApprover8TIMDM = testeCaseTestApprover8TIMDM;
	}

	public TesteCaseTestApprover9TIMDM getTesteCaseTestApprover9TIMDM() {
		return testeCaseTestApprover9TIMDM;
	}

	public void setTesteCaseTestApprover9TIMDM(TesteCaseTestApprover9TIMDM testeCaseTestApprover9TIMDM) {
		this.testeCaseTestApprover9TIMDM = testeCaseTestApprover9TIMDM;
	}

	public TesteCaseTestApprover10TIMDM getTesteCaseTestApprover10TIMDM() {
		return testeCaseTestApprover10TIMDM;
	}

	public void setTesteCaseTestApprover10TIMDM(TesteCaseTestApprover10TIMDM testeCaseTestApprover10TIMDM) {
		this.testeCaseTestApprover10TIMDM = testeCaseTestApprover10TIMDM;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getDestinatarios() {
		return destinatarios;
	}

	public void setDestinatarios(String destinatarios) {
		this.destinatarios = destinatarios;
	}

	public String getUrlDashboard() {
		return urlDashboard;
	}

	public void setUrlDashboard(String urlDashboard) {
		this.urlDashboard = urlDashboard;
	}

}
