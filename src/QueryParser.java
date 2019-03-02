import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//static helper class to parse incoming http queries
public class QueryParser {

    public static void parseQuery(String query, Map<String, Object> params) throws UnsupportedEncodingException {

        if (query != null) {

            String pairs[] = query.split("[&]");

            for (String pair : pairs) {

                String param[] = pair.split("[=]");
                String key = null;
                String value = null;

                if (param.length > 0) {

                    key = URLDecoder.decode(param[0], System.getProperty("file.encoding"));

                }

                if (param.length > 1) {

                    value = URLDecoder.decode(param[1], System.getProperty("file.encoding"));

                }

                if (params.containsKey(key)) {

                    Object obj = params.get(key);

                    if (obj instanceof List<?>) {

                        List<String> values = (List<String>) obj;
                        values.add(value);

                    } else if (obj instanceof String) {

                        List<String> values = new ArrayList<String>();

                        values.add((String) obj);
                        values.add(value);
                        params.put(key, values);

                    }
                } else {

                    params.put(key, value);

                }
            }
        }

    }

}
