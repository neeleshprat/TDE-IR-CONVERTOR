package main.java;

import ir.beans.TableStructured;
import ir.beans.old.TableStructured_old;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import tde.beans.Table;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class TdeIrConnector {

	public static void main(String[] args) {

		HashMap<String, Table> tables = loadTables();

		convert_new(tables);

	}

	public static HashMap<String, Table> loadTables() {

		HashMap<String, Table> tables = new HashMap<String, Table>();

		Gson gson;
		Configuration configuration;

		gson = new Gson();
		configuration = Configuration.getInstance();

		File tableFolder = configuration.getResultsFolder();
		File[] tableFiles = tableFolder.listFiles();
		try {
			for (File file : tableFiles) {
				if (!file.getName().startsWith(".")) {
					Table table;

					table = gson.fromJson(Files.toString(file, Charsets.UTF_8),
							Table.class);

					tables.put(table.getId(), table);
				}
			}
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Loading tables completed" + "\n");
		return tables;
	}

	public static void convert_old(HashMap<String, Table> tables) {

		for (Table table : tables.values()) {

			TableStructured_old tableStructured_old = new TableStructured_old();
			tableStructured_old.transform(table);
			tableStructured_old.save();

		}

		System.out.println("Saving tableStructured in old format completed");
	}

	public static void convert_new(HashMap<String, Table> tables) {

		for (Table table : tables.values()) {

			TableStructured tableStructured = new TableStructured();
			tableStructured.transform(table);
			tableStructured.save();
		}

		System.out.println("Saving tableStructured in new format completed");
	}

}
