package br.com.everis.json;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.everis.email.EmailUtil;

public class AnalyzeJSON extends Exception {

	String PAT = "";

	String AuthStr = ":" + PAT;
	Base64 base64 = new Base64();

	String encodedPAT = new String(base64.encode(AuthStr.getBytes()));

	String destinatarios = "";
	String urlDashboard = "";

	Logger logger = Logger.getLogger(AnalyzeJSON.class.getName());

	SimpleFormatter sf = new SimpleFormatter();

	public void getOdata() {

		try {

			FileHandler fh = new FileHandler("D:/Logs_Azure_EnviaEmail/ReadJSON.log", 10000000, 10, true);
			logger.addHandler(fh);
			fh.setFormatter(sf);

			URL url = new URL(
					"");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			logger.info("Connecting to URL: " + url);

			con.setRequestProperty("Authorization", "Basic " + encodedPAT);
			con.setRequestProperty("Content-type", "application/json");
			con.setRequestMethod("GET");
			con.setDoOutput(true);
			con.setDoInput(true);
			// System.out.println("URL - " + url.toString());
			// System.out.println("PAT - " + encodedPAT);
			logger.info("HTTP Method = " + con.getRequestMethod());
			logger.info("Response Code: " + con.getResponseCode());

			if (con.getResponseCode() == con.HTTP_OK) {
				String responseBody;
				InputStream response = con.getInputStream();
				try (Scanner scanner = new Scanner(response, "UTF-8")) {
					responseBody = (scanner.useDelimiter("\\A").next());
					logger.info("Response Body: " + responseBody);
					// System.out.println(responseBody);
				}

				// JsonElement jSParser = new JsonParser().parse(responseBody);
				JsonElement jsp = JsonParser.parseString(responseBody);
				JsonObject jo = jsp.getAsJsonObject();
				JsonArray jsonobjtworkItemsvalue = jsp.getAsJsonObject().get("value").getAsJsonArray();
				// System.out.println(jo);
				Gson gson = new Gson();
				Gson gsonB = new GsonBuilder().serializeNulls().create();
				// System.out.println(gsonB);
				Value value;
				ValueWorkItemEmail valueWorkItemEmail = new ValueWorkItemEmail();

				// System.out.println(jsonobjtworkItemsvalue);

				List<Value> lista = new ArrayList<Value>();
				String testeCaseDataHourDeliveryTIMDM;
				String testeCaseDataDeliveryTIM;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat sdfDDMMAAAA = new SimpleDateFormat("dd/MM/yyyy");
				String destinatariosValue = "";
				String urlDashboardValue = "";

				for (int x = 0; x < jsonobjtworkItemsvalue.size(); x++) {
					value = gsonB.fromJson(jsonobjtworkItemsvalue.get(x), Value.class);
					try {
						Date dateSysCreatedDateHour = sdf.parse(value.getTesteCaseDataDeliveryTIMDM());
						String sysCreatedDateFormat = sdfDDMMAAAA.format(dateSysCreatedDateHour);
						testeCaseDataHourDeliveryTIMDM = value.getTesteCaseDataDeliveryTIMDM().substring(11, 19);
						testeCaseDataDeliveryTIM = sysCreatedDateFormat + " - " + testeCaseDataHourDeliveryTIMDM;
						value.setTesteCaseDataDeliveryTIMDM(testeCaseDataDeliveryTIM);
					} catch (Exception e) {
						e.getMessage();
						logger.info(e.getMessage());
					}
					lista.add(value);
				}

				logger.info("Work Items List: " + lista);

				Map<String, List<Value>> workItemsGroup = lista.stream()
						.collect(Collectors.groupingBy(Value::getCodigoFQATIMDM));

				logger.info("Grouped list by FQA CODE: " + workItemsGroup.keySet());

				for (Map.Entry<String, List<Value>> entry : workItemsGroup.entrySet()) {
					List<Value> valueList = entry.getValue();
					this.getDestinatarios(entry.getKey());
					for (int i = 0; i < valueList.size(); i++) {
						valueList.get(i).setDestinatarios(destinatarios);
						valueList.get(i).setUrlDashboard(urlDashboard);
						logger.info("Destinatarios: " + valueList.get(i).getDestinatarios());
					}
					destinatarios = "";
				}

				logger.info("Starting to send E-mail");
				EmailUtil.sendMail(workItemsGroup);
				logger.info("============================ End of Method =================================");
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.severe(e.getMessage());
		}

	}

	public void getDestinatarios(String codigoFQA) {

		JsonArray jSonDestinatariosURL = null;

		try {

			URL url = new URL(
					"");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			logger.info("Connecting to URL E-mail Work Item of " + codigoFQA + ": " + url);

			con.setRequestProperty("Authorization", "Basic " + encodedPAT);
			con.setRequestProperty("Content-type", "application/json");
			con.setRequestMethod("GET");
			con.setDoOutput(true);
			con.setDoInput(true);
			// System.out.println("URL - " + url.toString());
			// System.out.println("PAT - " + encodedPAT);
			// System.out.println(con.getRequestMethod());

			logger.info("Request Method: " + con.getRequestMethod() + " and Response Code " + con.getResponseCode());

			if (con.getResponseCode() == con.HTTP_OK) {
				String responseBody;
				InputStream response = con.getInputStream();
				try (Scanner scanner = new Scanner(response, "UTF-8")) {
					responseBody = (scanner.useDelimiter("\\A").next());
					logger.info("Recipients Response Body of " + codigoFQA + ": " + responseBody);
					// System.out.println(responseBody);
				}

				// JsonElement jSParser = new JsonParser().parse(responseBody);
				JsonElement jsp = JsonParser.parseString(responseBody);
				JsonObject jo = jsp.getAsJsonObject();
				jSonDestinatariosURL = jsp.getAsJsonObject().get("value").getAsJsonArray();
				ValueWorkItemEmail valueWorkItemEmail;
				Gson gsonB = new GsonBuilder().serializeNulls().create();
				if (jSonDestinatariosURL.size() != 0) {

					for (int x = 0; x < jSonDestinatariosURL.size(); x++) {
						valueWorkItemEmail = gsonB.fromJson(jSonDestinatariosURL.get(x), ValueWorkItemEmail.class);
						destinatarios += valueWorkItemEmail.getDestinatariosParaEnvioTIMDM()+ ";";
						urlDashboard = valueWorkItemEmail.getURLProjetoTIMDM();
					}
					destinatarios = destinatarios.replaceAll(";", ",");
				} else {
					destinatarios = "";
					urlDashboard = "";
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
			logger.severe(e.getMessage());
			System.err.println(e);
		}
		logger.info("============================ End of Method =================================");
	}

}
