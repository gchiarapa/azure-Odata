package br.com.everis.test;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import br.com.everis.json.AnalyzeJSON;

public class TesteJSON {

	public static void main(String[] args) throws Exception {
		Logger logger = Logger.getLogger(AnalyzeJSON.class.getName());
		SimpleFormatter sf = new SimpleFormatter();

		AnalyzeJSON ljson = new AnalyzeJSON();
		ljson.getOdata();
		FileHandler fh = new FileHandler("D:/Logs_Azure_EnviaEmail/ExecuteJSON.log", 10000000, 10, true);
		logger.addHandler(fh);
		fh.setFormatter(sf);
		logger.info("Execution finished!");
	}

}
