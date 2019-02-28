package org.b.g;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import org.b.b.b;

public final class c {
    private static final Map<String, String> AIl;
    private static String CHARSET = "UTF-8";

    static {
        Map hashMap = new HashMap();
        hashMap.put("*", "%2A");
        hashMap.put("+", "%20");
        hashMap.put("%7E", "~");
        AIl = Collections.unmodifiableMap(hashMap);
    }

    public static String encode(String str) {
        d.j(str, "Cannot encode null object");
        try {
            String encode = URLEncoder.encode(str, CHARSET);
            Iterator it = AIl.entrySet().iterator();
            while (true) {
                String str2 = encode;
                if (!it.hasNext()) {
                    return str2;
                }
                Entry entry = (Entry) it.next();
                String str3 = (String) entry.getKey();
                encode = str2.replaceAll(Pattern.quote(str3), (String) entry.getValue());
            }
        } catch (Exception e) {
            throw new b("Charset not found while encoding string: " + CHARSET, e);
        }
    }

    public static String decode(String str) {
        d.j(str, "Cannot decode null object");
        try {
            return URLDecoder.decode(str, CHARSET);
        } catch (Exception e) {
            throw new b("Charset not found while decoding string: " + CHARSET, e);
        }
    }
}
