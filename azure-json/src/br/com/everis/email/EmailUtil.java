package br.com.everis.email;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.event.TransportEvent;
import javax.mail.event.TransportListener;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import br.com.everis.json.TesteCaseTestApprover1TIMDM;
import br.com.everis.json.TesteCaseTestApprover2TIMDM;
import br.com.everis.json.TesteCaseTestApprover3TIMDM;
import br.com.everis.json.TesteCaseTestApprover4TIMDM;
import br.com.everis.json.TesteCaseTestApprover5TIMDM;
import br.com.everis.json.Value;

public class EmailUtil {
	
	static Logger logger = Logger.getLogger(EmailUtil.class.getName());
	static SimpleFormatter sf = new SimpleFormatter();
	//static MailLogger mailLogger = new MailLogger(EmailUtil.class, prefix, session);

	public static void sendMail(Map<String, List<Value>> workItemsGroup) throws Exception {
		FileHandler fh = new FileHandler("D:/Logs_Azure_EnviaEmail/EmailUtilJSON.log", 10000000, 10 ,true);
		logger.addHandler(fh);
		fh.setFormatter(sf);
		logger.info("Preparing to send E-MAIL");
		Properties props = new Properties();
		

//		//Relay de E-mail
//	    props.put("mail.smtp.auth", "false");
//	    props.put("mail.smtp.starttls.enable", "true");
//	    props.put("mail.smtp.host", "timrelayapp04.internal.timbrasil.com.br");
//	    props.put("mail.smtp.port", "25");
//	    props.put("mail.smtp.ssl.trust", "timrelayapp04.internal.timbrasil.com.br");
//	    props.put("mail.debug", "true");


		props.put("mail.smtp.host", "timrelayapp04.internal.timbrasil.com.br");
		//props.put("mail.smtp.socketFactory.port", "25");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "false");
		//props.put("mail.smtp.port", "25");
		props.put("mail.debug", "true");

//		Session session = Session.getInstance(props, new Authenticator() {	
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(accountMail, password);
//			}
//		});
	    
	    Session session = Session.getInstance(props);
	    session.getDebugOut();
	    PrintStream out = new PrintStream("D:/Logs_Azure_EnviaEmail/EmailUtilJSON_events.log", "UTF-8");
		session.setDebugOut(out);

	    MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("azure@timbrasil.com.br"));
		message.setHeader("Content-Transfer-Encoding", "quoted-printable");
		message.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
		String HTMLcontent = "";
		
		
		//laço para verificar os aprovadores:
		String aprovador1;
		String aprovador2;
		String aprovador3;
		String aprovador4;
		String aprovador5;
		String aprovador6;
		String aprovador7;
		String aprovador8;
		String aprovador9;
		String aprovador10;
		String testeCaseCenario;
		String testeCaseFuncionalidade;
		String testeCaseDataDelivery;
		Integer indexOfValueList;
		Address[] addressesTO;
		
		Set<String> emailList = new HashSet<>();
		Object[] setA = null;
		
		for (Map.Entry<String, List<Value>> entry: workItemsGroup.entrySet()) {
			List<Value> valueList = entry.getValue();
			indexOfValueList = 0;
			HTMLcontent += "<html xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" xmlns:dt=\"uuid:C2F41010-65B3-11d1-A29F-00AA00C14882\" xmlns:m=\"http://schemas.microsoft.com/office/2004/12/omml\" xmlns=\"http://www.w3.org/TR/REC-html40\">"
					+ "<head><meta http-equiv=Content-Type content=\"text/html; charset=ISO-8859-1\"><meta name=Generator content=\"Microsoft Word 15 (filtered medium)\">\r\n" + 
					"<style><!--\r\n" + 
					"/* Font Definitions */\r\n" + 
					"@font-face\r\n" + 
					"	{font-family:\"Cambria Math\";\r\n" + 
					"	panose-1:2 4 5 3 5 4 6 3 2 4;}\r\n" + 
					"@font-face\r\n" + 
					"	{font-family:Calibri;\r\n" + 
					"	panose-1:2 15 5 2 2 2 4 3 2 4;}\r\n" + 
					"/* Style Definitions */\r\n" + 
					"p.MsoNormal, li.MsoNormal, div.MsoNormal\r\n" + 
					"	{margin:0cm;\r\n" + 
					"	margin-bottom:.0001pt;\r\n" + 
					"	font-size:11.0pt;\r\n" + 
					"	font-family:\"Calibri\",sans-serif;\r\n" + 
					"	mso-fareast-language:EN-US;}\r\n" + 
					"a:link, span.MsoHyperlink\r\n" + 
					"	{mso-style-priority:99;\r\n" + 
					"	color:#0563C1;\r\n" + 
					"	text-decoration:underline;}\r\n" + 
					"a:visited, span.MsoHyperlinkFollowed\r\n" + 
					"	{mso-style-priority:99;\r\n" + 
					"	color:#954F72;\r\n" + 
					"	text-decoration:underline;}\r\n" + 
					"span.EstiloDeEmail17\r\n" + 
					"	{mso-style-type:personal-compose;\r\n" + 
					"	font-family:\"Calibri\",sans-serif;\r\n" + 
					"	color:windowtext;}\r\n" + 
					".MsoChpDefault\r\n" + 
					"	{mso-style-type:export-only;\r\n" + 
					"	mso-fareast-language:EN-US;}\r\n" + 
					"@page WordSection1\r\n" + 
					"	{size:612.0pt 792.0pt;\r\n" + 
					"	margin:70.85pt 3.0cm 70.85pt 3.0cm;}\r\n" + 
					"div.WordSection1\r\n" + 
					"	{page:WordSection1;}\r\n" + 
					"--></style><!--[if gte mso 9]><xml>\r\n" + 
					"<o:shapedefaults v:ext=\"edit\" spidmax=\"1026\" />\r\n" + 
					"</xml><![endif]--><!--[if gte mso 9]><xml>\r\n" + 
					"<o:shapelayout v:ext=\"edit\">\r\n" + 
					"<o:idmap v:ext=\"edit\" data=\"1\" />\r\n" + 
					"</o:shapelayout></xml><![endif]-->\r\n" + 
					"</head>\r\n" + 
					"<body lang=\"PT-BR\" link=\"#0563C1\" vlink=\"#954F72\">\r\n" + 
					"<div class=\"WordSection1\">\r\n" + 
					"<p class=\"MsoNormal\"><b>Prezados,</b><br>\r\n" + 
					"Seguem os cenários que já estão com evidências disponíveis para devida validação das áreas de negócio em relação ao projeto - "
					+ valueList.get(indexOfValueList).getCodigoFQATIMDM() + " - "
					+ valueList.get(indexOfValueList).getCodigoDemandaTIMDM()
					+ ".<o:p></o:p></p>\r\n" + 
					"<p class=\"MsoNormal\"><o:p>&nbsp;</o:p></p>"
					+ "<table class=MsoNormalTable border=1 cellpadding=0>\r\n"
					+ "<th width=\"44\" nowrap=\"\" style=\"width:33.25pt;border:solid windowtext 1.0pt;background:#17365D;padding:0cm 3.5pt 0cm 3.5pt;height:19.55pt\">\r\n" + 
					"<p class=\"MsoNormal\" align=\"center\" style=\"text-align:center\"><b><span style=\"font-size:10.0pt;font-family:&quot;Times New Roman&quot;,serif;color:white;mso-fareast-language:PT-BR\">ID<o:p></o:p></span></b></p>\r\n" + 
					"</th>\r\n" + 
					"<th width=\"116\" nowrap=\"\" style=\"width:87.0pt;border:solid windowtext 1.0pt;border-left:none;background:#17365D;padding:0cm 3.5pt 0cm 3.5pt;height:19.55pt\">\r\n" + 
					"<p class=\"MsoNormal\" align=\"center\" style=\"text-align:center\"><b><span style=\"font-size:10.0pt;font-family:&quot;Times New Roman&quot;,serif;color:white;mso-fareast-language:PT-BR\">Cenário<o:p></o:p></span></b></p>\r\n" + 
					"</th>\r\n" + 
					"<th width=\"191\" nowrap=\"\" style=\"width:143.0pt;border:solid windowtext 1.0pt;border-left:none;background:#17365D;padding:0cm 3.5pt 0cm 3.5pt;height:19.55pt\">\r\n" + 
					"<p class=\"MsoNormal\" align=\"center\" style=\"text-align:center\"><b><span style=\"font-size:10.0pt;font-family:&quot;Times New Roman&quot;,serif;color:white;mso-fareast-language:PT-BR\">Área Usuária<o:p></o:p></span></b></p>\r\n" + 
					"</th>\r\n" + 
					"<th width=\"115\" nowrap=\"\" style=\"width:86.0pt;border:solid windowtext 1.0pt;border-left:none;background:#17365D;padding:0cm 3.5pt 0cm 3.5pt;height:19.55pt\">\r\n" + 
					"<p class=\"MsoNormal\" align=\"center\" style=\"text-align:center\"><b><span style=\"font-size:10.0pt;font-family:&quot;Times New Roman&quot;,serif;color:white;mso-fareast-language:PT-BR\">Código da Demanda<o:p></o:p></span></b></p>\r\n" + 
					"</th>\r\n" + 
					"<th width=\"75\" nowrap=\"\" style=\"width:56.0pt;border:solid windowtext 1.0pt;border-left:none;background:#17365D;padding:0cm 3.5pt 0cm 3.5pt;height:19.55pt\">\r\n" + 
					"<p class=\"MsoNormal\" align=\"center\" style=\"text-align:center\"><b><span style=\"font-size:10.0pt;font-family:&quot;Times New Roman&quot;,serif;color:white;mso-fareast-language:PT-BR\">Código FQA<o:p></o:p></span></b></p>\r\n" + 
					"</th>\r\n" + 
					"<th width=\"97\" nowrap=\"\" style=\"width:150.0pt;border:solid windowtext 1.0pt;border-left:none;background:#17365D;padding:0cm 3.5pt 0cm 3.5pt;height:19.55pt\">\r\n" + 
					"<p class=\"MsoNormal\" align=\"center\" style=\"text-align:center\"><b><span style=\"font-size:10.0pt;font-family:&quot;Times New Roman&quot;,serif;color:white;mso-fareast-language:PT-BR\">Funcionalidade<o:p></o:p></span></b></p>\r\n" + 
					"</th>\r\n" + 
					"<th width=\"125\" nowrap=\"\" style=\"width:94.0pt;border:solid windowtext 1.0pt;border-left:none;background:#17365D;padding:0cm 3.5pt 0cm 3.5pt;height:19.55pt\">\r\n" + 
					"<p class=\"MsoNormal\" align=\"center\" style=\"text-align:center\"><b><span style=\"font-size:10.0pt;font-family:&quot;Times New Roman&quot;,serif;color:white;mso-fareast-language:PT-BR\">Status<o:p></o:p></span></b></p>\r\n" + 
					"</th>\r\n" + 
					"<th width=\"144\" nowrap=\"\" style=\"width:108.0pt;border:solid windowtext 1.0pt;border-left:none;background:#17365D;padding:0cm 3.5pt 0cm 3.5pt;height:19.55pt\">\r\n" + 
					"<p class=\"MsoNormal\" align=\"center\" style=\"text-align:center\"><b><span style=\"font-size:10.0pt;font-family:&quot;Times New Roman&quot;,serif;color:white;mso-fareast-language:PT-BR\">Data Delivery<o:p></o:p></span></b></p>\r\n" + 
					"</th>\r\n" + 
					"<th width=\"155\" nowrap=\"\" style=\"width:220.0pt;border:solid windowtext 1.0pt;border-left:none;background:#17365D;padding:0cm 3.5pt 0cm 3.5pt;height:19.55pt\">\r\n" + 
					"<p class=\"MsoNormal\" align=\"center\" style=\"text-align:center\"><b><span style=\"font-size:10.0pt;font-family:&quot;Times New Roman&quot;,serif;color:white;mso-fareast-language:PT-BR\">Aprovadores<o:p></o:p></span></b></p>\r\n" + 
					"</th>\r\n" + 
					"</tr>" + 
					"</tr>" 
					+ "  <tr>\r\n";
		for (Value item : valueList) {
			//TODO - verifica quais aprovadores existem:
			aprovador1 = item.getTesteCaseTestApprover1TIMDM() == null ? "" : item.getTesteCaseTestApprover1TIMDM().getUserName();
			aprovador2 = item.getTesteCaseTestApprover2TIMDM() == null ? "" : "," + item.getTesteCaseTestApprover2TIMDM().getUserName();
			aprovador3 = item.getTesteCaseTestApprover3TIMDM() == null ? "" : "," + item.getTesteCaseTestApprover3TIMDM().getUserName();
			aprovador4 = item.getTesteCaseTestApprover4TIMDM() == null ? "" : "," + item.getTesteCaseTestApprover4TIMDM().getUserName();
			aprovador5 = item.getTesteCaseTestApprover5TIMDM() == null ? "" : "," + item.getTesteCaseTestApprover5TIMDM().getUserName();
			aprovador6 = item.getTesteCaseTestApprover6TIMDM() == null ? "" : "," + item.getTesteCaseTestApprover6TIMDM().getUserName();
			aprovador7 = item.getTesteCaseTestApprover7TIMDM() == null ? "" : "," + item.getTesteCaseTestApprover7TIMDM().getUserName();
			aprovador8 = item.getTesteCaseTestApprover8TIMDM() == null ? "" : "," + item.getTesteCaseTestApprover8TIMDM().getUserName();
			aprovador9 = item.getTesteCaseTestApprover9TIMDM() == null ? "" : "," + item.getTesteCaseTestApprover9TIMDM().getUserName();
			aprovador10 = item.getTesteCaseTestApprover10TIMDM() == null ? "" : "," + item.getTesteCaseTestApprover10TIMDM().getUserName();
			
			//TODO - Verifica se os itens cenário, funcionalidade e data delivery existem
			testeCaseCenario = item.getTesteCaseCenarioTIMDM() == null ? "N/A" : item.getTesteCaseCenarioTIMDM();
			testeCaseFuncionalidade = item.getTesteCaseFuncionalidadeTIMDM() == null ? "N/A" : item.getTesteCaseFuncionalidadeTIMDM();
			testeCaseDataDelivery = item.getTesteCaseDataDeliveryTIMDM() == null ? "N/A" : item.getTesteCaseDataDeliveryTIMDM();

			if (item.getTesteCaseTestApprover1TIMDM() != null) {
				emailList.add(item.getTesteCaseTestApprover1TIMDM().getUserEmail());
			}
			if (item.getTesteCaseTestApprover2TIMDM() != null) {
				emailList.add(item.getTesteCaseTestApprover2TIMDM().getUserEmail());
			}
			if (item.getTesteCaseTestApprover3TIMDM() != null) {
				emailList.add(item.getTesteCaseTestApprover3TIMDM().getUserEmail());
			}
			if (item.getTesteCaseTestApprover4TIMDM() != null) {
				emailList.add(item.getTesteCaseTestApprover4TIMDM().getUserEmail());
			}
			if (item.getTesteCaseTestApprover5TIMDM() != null) {
				emailList.add(item.getTesteCaseTestApprover5TIMDM().getUserEmail());
			}
			
			if (item.getTesteCaseTestApprover6TIMDM() != null) {
				emailList.add(item.getTesteCaseTestApprover6TIMDM().getUserEmail());
			}
			if (item.getTesteCaseTestApprover7TIMDM() != null) {
				emailList.add(item.getTesteCaseTestApprover7TIMDM().getUserEmail());
			}
			if (item.getTesteCaseTestApprover8TIMDM() != null) {
				emailList.add(item.getTesteCaseTestApprover8TIMDM().getUserEmail());
			}
			if (item.getTesteCaseTestApprover9TIMDM() != null) {
				emailList.add(item.getTesteCaseTestApprover9TIMDM().getUserEmail());
			}
			if (item.getTesteCaseTestApprover10TIMDM() != null) {
				emailList.add(item.getTesteCaseTestApprover10TIMDM().getUserEmail());
			}
			
			//TODO - Adiciona os e-mails na lista, sem repetir
			setA = emailList.toArray();
			
					HTMLcontent += 
							 
					"    <td width=\"44\" valign=\"middle\" style=\"width:auto;border:solid windowtext 1.0pt;border-top:none;background:white;padding:0cm 3.5pt 0cm 3.5pt;height:30.75pt\">\r\n" + 
					"<p class=\"MsoNormal\" align=\"center\" style=\"text-align:right\"><u><span style=\"color:#0563C1;mso-fareast-language:PT-BR\"><a href=\"https://dev.azure.com/timbrasil/Producao/_workitems/edit/"
					+ item.getWorkItemId().toString()
					+ "target=\"_blank\"><span style=\"color:#0563C1\"> "
					+ item.getWorkItemId().toString() + " </span></a><o:p></o:p></span></u></p>\r\n" + 
							"</td>" 
							+ "<td width=\"116\" valign=\"middle\" style=\"width:auto;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;background:white;padding:0cm 3.5pt 0cm 3.5pt;height:30.75pt\">\r\n" + 
							"<p class=\"MsoNormal\"><span style=\"color:black;mso-fareast-language:PT-BR\">" + testeCaseCenario + "<o:p></o:p></span></p></td>\r\n" 
					+ "    <td width=\"191\" valign=\"middle\" style=\"width:auto;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;background:white;padding:0cm 3.5pt 0cm 3.5pt;height:30.75pt\">\r\n" + 
					"<p class=\"MsoNormal\"><span style=\"color:black;mso-fareast-language:PT-BR\">"
					+ item.getTesteCaseAreaUsuariaTIMDM().toString() + "<o:p></o:p></span></p></td>\r\n" 
					+ "<td width=\"115\" valign=\"middle\" style=\"width:auto;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;background:white;padding:0cm 3.5pt 0cm 3.5pt;height:30.75pt\">\r\n" + 
					"<p class=\"MsoNormal\"><span style=\"color:black;mso-fareast-language:PT-BR\">" + item.getCodigoDemandaTIMDM().toString() + "<o:p></o:p></span></p></td>\r\n" 
					+ "<td width=\"75\" valign=\"middle\" style=\"width:auto;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;background:white;padding:0cm 3.5pt 0cm 3.5pt;height:30.75pt\">\r\n" + 
					"<p class=\"MsoNormal\"><span style=\"color:black;mso-fareast-language:PT-BR\"> "
					+ item.getCodigoFQATIMDM().toString() + "<o:p></o:p></span></p></td>\r\n" 
					+ " <td width=\"97\" valign=\"middle\" style=\"width:auto;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;background:white;padding:0cm 3.5pt 0cm 3.5pt;height:30.75pt\">\r\n" + 
					"<p class=\"MsoNormal\"><span style=\"color:black;mso-fareast-language:PT-BR\">" + testeCaseFuncionalidade + "<o:p></o:p></span></p></td>\r\n"
					+ " <td width=\"125\" valign=\"middle\" style=\"width:auto;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;background:white;padding:0cm 3.5pt 0cm 3.5pt;height:30.75pt\">\r\n" + 
					"<p class=\"MsoNormal\"><span style=\"color:black;mso-fareast-language:PT-BR\">" + item.getState().toString() + "<o:p></o:p></span></p></td>\r\n" 
					+ " <td width=\"144\" valign=\"middle\" style=\"width:auto;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;background:white;padding:0cm 3.5pt 0cm 3.5pt;height:30.75pt\">\r\n" + 
					"<p class=\"MsoNormal\" align=\"right\" style=\"text-align:right\"><span style=\"color:black;mso-fareast-language:PT-BR\">" + testeCaseDataDelivery + "<o:p></o:p></span></p></td>\r\n" 
					+ " <td width=\"260\" valign=\"middle\" style=\"width:auto;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;background:white;padding:0cm 3.5pt 0cm 3.5pt;height:30.75pt\">\r\n" + 
					"<p class=\"MsoNormal\"><span style=\"color:black;mso-fareast-language:PT-BR\"> " 
					+ aprovador1
					+ aprovador2
					+ aprovador3
					+ aprovador4
					+ aprovador5
					+ aprovador6
					+ aprovador7
					+ aprovador8
					+ aprovador9
					+ aprovador10
					+ " <o:p></o:p></span></p></td></tr>";
		}
		
		for (int e = 0; e < setA.length; e++) {
			message.addRecipients(Message.RecipientType.TO, setA[e].toString());
		}
		
		HTMLcontent += "</table></br>";
		Thread.sleep(2000);
		String[] nomeDemandaSplit = valueList.get(indexOfValueList).getArea().getAreaPath().split("\\\\");
		
		if(valueList.get(indexOfValueList).getUrlDashboard() != ""){
		HTMLcontent +=
				"<table class=\"MsoNormalTable\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" width=\"0\" style=\"width:127.0pt;border-collapse:collapse;margin-left:4.8pt;margin-right:4.8pt\">\r\n" + 
				"<tr style=\"height:15.0pt\">\r\n" + 
				"<td width=\"169\" nowrap=\"\" style=\"width:127.0pt;border:none;border-left:solid black 1.0pt;background:#17365D;padding:0cm 3.5pt 0cm 3.5pt;height:15.0pt\">\r\n" + 
				"<p class=\"MsoNormal\" align=\"center\" style=\"text-align:center;mso-element:frame;mso-element-frame-hspace:7.05pt;mso-element-wrap:around;mso-element-anchor-vertical:paragraph;mso-element-anchor-horizontal:column;mso-element-top:.05pt;mso-height-rule:exactly\">\r\n" + 
				"<b><span style=\"font-size:10.0pt;font-family:&quot;Times New Roman&quot;,serif;color:white;mso-fareast-language:PT-BR\">Link do Dashboard no Azure<o:p></o:p></span></b></p>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr style=\"height:30.0pt\">\r\n" + 
				"<td width=\"169\" style=\"width:127.0pt;border:none;border-left:solid black 1.0pt;padding:0cm 3.5pt 0cm 3.5pt;height:30.0pt\">\r\n" + 
				"<p class=\"MsoNormal\" align=\"center\" style=\"text-align:center;mso-element:frame;mso-element-frame-hspace:7.05pt;mso-element-wrap:around;mso-element-anchor-vertical:paragraph;mso-element-anchor-horizontal:column;mso-element-top:.05pt;mso-height-rule:exactly\">\r\n" + 
				"<u><span style=\"color:#0563C1;mso-fareast-language:PT-BR\"><a href=\""
				+ valueList.get(indexOfValueList).getUrlDashboard()
				+ "\"><span style=\"color:#0563C1\">"
				+ valueList.get(indexOfValueList).getCodigoFQATIMDM()
				+ "</span></a><o:p></o:p></span></u></p>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</table></br><br><br>" 
				+ "<br><br>"
				+ "</html>";
				} else {
					HTMLcontent += 
							 "<br><br>"
							+ "</html>";
				}
		//Address[] addresses = InternetAddress.parse("anunes_everis@timbrasil.com.br,fosantos_everis@timbrasil.com.br,gchiarapa_value@timbrasil.com.br");
		Address[] addressesCC = InternetAddress.parse(valueList.get(indexOfValueList).getDestinatarios());
		//InternetAddress address = new InternetAddress("gchiarapa_value@timbrasil.com.br");
		//message.setRecipient(Message.RecipientType.TO, address);
		message.setRecipients(Message.RecipientType.CC, addressesCC);
		message.setSubject("Delivery do UAT" + " - " + valueList.get(indexOfValueList).getCodigoFQATIMDM() + " - " + valueList.get(indexOfValueList).getCodigoDemandaTIMDM() + " - " + nomeDemandaSplit[0]);
		logger.info("HTML E-mail content of: " + valueList.get(indexOfValueList).getCodigoFQATIMDM() + HTMLcontent);
		message.setContent(HTMLcontent, "text/html; charset=\"UTF-8\"");
		Transport.send(message);
		
		logger.info("E-mail of FQA CODE "+ valueList.get(indexOfValueList).getCodigoFQATIMDM() +" sent to: " + message.getHeader("TO", ",") + " and CC " + message.getHeader("CC", ",")); //+valueList.get(indexOfValueList).getDestinatarios());
		Thread.sleep(1000);
		//TODO clear e-mail content, subject and message recipients TO and CC:
		HTMLcontent = "";
		message.setSubject("");
		message.setRecipients(Message.RecipientType.TO, "");
		message.setRecipients(Message.RecipientType.CC, "");
		emailList.clear();
		indexOfValueList++;
		}
		logger.info("====================== Emails Sent!!!! ===========================");
	}

}
