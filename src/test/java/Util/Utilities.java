package Util;

import com.google.common.io.ByteStreams;
import io.dropwizard.util.Resources;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utilities {

    public static JSONObject getPayloadObjectFromFile(String FileName) {

        return new JSONObject(fixture(FileName, StandardCharsets.UTF_8));

    }

    private static String fixture(String filename, Charset charset) {
        final URL resource = Resources.getResource(filename);
        try (InputStream inputStream = resource.openStream()) {
            return new String(ByteStreams.toByteArray(inputStream), charset).trim();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String getDate(String format) {
        LocalDate date = LocalDate.now();
        String formattedDate = date.format(DateTimeFormatter.ofPattern(format));
        return formattedDate;
    }


}
