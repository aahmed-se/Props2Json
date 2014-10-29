package com.aahmedse.props2json;

import java.util.Properties;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class PropsToJsonUtil {

	private static final Pattern floatPattern = Pattern.compile("^-?[0-9]+(\\.[0-9]+)?$");
	private static final Pattern intPattern = Pattern.compile("^-?[0-9]+$");

	/**
	 * Converts the properties object into a JSON string.
	 * 
	 * @param properties The properties object to convert.
	 * @return A JSON string representing the object.
	 */
	public static String convertToJson(Properties properties) {
		JsonObject json = new JsonObject();
		for (Object key : properties.keySet()) {

			String baseKey = key.toString();
			String[] splittedKey = baseKey.split("\\.");

			JsonObject nestedObject = json;

			for (int i = 0; i < splittedKey.length - 1; ++i) {
				if (!json.has(splittedKey[i])) {
					json.add(splittedKey[i], new JsonObject());
				}
				nestedObject = json.getAsJsonObject(splittedKey[i]);
			}

			String finalKeyElement = splittedKey[splittedKey.length - 1];

			String value = properties.getProperty(baseKey);

			String[] splitedValue = value.split("\\,");

			if (splitedValue.length == 1) {

				if (value.toLowerCase().equals("true") || value.toLowerCase().equals("false")) {
					nestedObject.addProperty(finalKeyElement, Boolean.parseBoolean(value));
				} else if (intPattern.matcher(value).matches()) {
					nestedObject.addProperty(finalKeyElement, Integer.parseInt(value));
				} else if (floatPattern.matcher(value).matches()) {
					nestedObject.addProperty(finalKeyElement, Float.parseFloat(value));
				} else {
					nestedObject.addProperty(finalKeyElement, value);
				}

			}

			else {
				JsonArray elementArray = new JsonArray();
				for (String val : splitedValue) {
					
					if (val.toLowerCase().equals("true") || val.toLowerCase().equals("false")) {
						elementArray.add(new JsonPrimitive(Boolean.parseBoolean(val)));
					} else if (intPattern.matcher(val).matches()) {
						elementArray.add(new JsonPrimitive(Integer.parseInt(val)));
					} else if (floatPattern.matcher(val).matches()) {
						elementArray.add(new JsonPrimitive(Float.parseFloat(val)));
					} else {
						elementArray.add(new JsonPrimitive(val));
					}
				}
				nestedObject.add(finalKeyElement, elementArray);
			}

		}
		return new Gson().toJson(json);
	}	
}
