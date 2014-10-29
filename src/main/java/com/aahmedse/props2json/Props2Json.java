package com.aahmedse.props2json;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import java.util.Scanner;

/**
 * 
 * 
 * 
 * @author aahmed
 * 
 */
public class Props2Json {

	public static void main(String args[]) throws IOException {

		Scanner sc = new Scanner(System.in);
		Properties p = new Properties();

		StringBuilder prop_buffer = new StringBuilder();

		while (sc.hasNextLine()) {
			prop_buffer.append(sc.nextLine() + "\n");
		}

		p.load(new StringReader(prop_buffer.toString()));

		System.out.println(PropsToJsonUtil.convertToJson(p));

	}

}
