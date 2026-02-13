package CsvUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class CsvUtils {

    public static List<Map<String,String>> readCsvAsMaps(String classpathCsv) {
        List<Map<String,String>> rows = new ArrayList<>();
        try (InputStream is = CsvUtils.class.getClassLoader().getResourceAsStream(classpathCsv)) {
            if (is == null) throw new RuntimeException("CSV not found on classpath: " + classpathCsv);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                String headerLine = br.readLine();
                if (headerLine == null) return rows;

                String[] headers = headerLine.split(",", -1);
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.trim().isEmpty()) continue;
                    String[] vals = line.split(",", -1);
                    Map<String,String> map = new LinkedHashMap<>();
                    for (int i = 0; i < headers.length; i++) {
                        String key = headers[i].trim();
                        String val = i < vals.length ? vals[i].trim() : "";
                        map.put(key, val);
                    }
                    rows.add(map);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to read CSV: " + classpathCsv, e);
        }
        return rows;
    }

    public static Map<String,String> getRowBy(List<Map<String,String>> rows, String column, String value) {
        for (Map<String,String> row : rows) {
            if (value.equalsIgnoreCase(row.getOrDefault(column, ""))) {
                return row;
            }
        }
        throw new RuntimeException("No row found where " + column + "=" + value);
    }
}