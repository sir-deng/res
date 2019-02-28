package com.tencent.mm.sdk.platformtools;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class bj {
    private static ThreadLocal<XmlPullParser> xre = new ThreadLocal();

    private static class a {
        private XmlPullParser xrf;
        private String xrg;
        private StringBuilder xrh = new StringBuilder();
        private Map<String, String> xri;
        private Map<Integer, Integer> xrj;

        public a(String str, String str2) {
            this.xrg = str2;
            XmlPullParser xmlPullParser = (XmlPullParser) bj.xre.get();
            this.xrf = xmlPullParser;
            if (xmlPullParser == null) {
                ThreadLocal chr = bj.xre;
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                this.xrf = newPullParser;
                chr.set(newPullParser);
            }
            this.xrf.setInput(new StringReader(str));
            this.xrj = new HashMap();
            this.xri = new HashMap();
        }

        public final Map<String, String> chs() {
            int eventType = this.xrf.getEventType();
            while (eventType != 1) {
                int next = this.xrf.next();
                String str;
                if (next == 2) {
                    this.xrh.append('.').append(this.xrf.getName());
                    String stringBuilder = this.xrh.toString();
                    int hashCode = stringBuilder.hashCode();
                    Integer num = (Integer) this.xrj.get(Integer.valueOf(hashCode));
                    if (num != null) {
                        num = Integer.valueOf(num.intValue() + 1);
                        this.xrh.append(num);
                        this.xrj.put(Integer.valueOf(hashCode), num);
                        str = stringBuilder + num;
                    } else {
                        this.xrj.put(Integer.valueOf(hashCode), Integer.valueOf(0));
                        str = stringBuilder;
                    }
                    this.xri.put(str, "");
                    for (int i = 0; i < this.xrf.getAttributeCount(); i++) {
                        this.xri.put(str + ".$" + this.xrf.getAttributeName(i), this.xrf.getAttributeValue(i));
                    }
                    eventType = next;
                } else if (next == 4) {
                    str = this.xrf.getText();
                    if (str != null) {
                        this.xri.put(this.xrh.toString(), str);
                    }
                    eventType = next;
                } else {
                    if (next == 3) {
                        this.xrh = this.xrh.delete(this.xrh.lastIndexOf("."), this.xrh.length());
                        if (this.xrh.length() == 0) {
                            break;
                        }
                    }
                    eventType = next;
                }
            }
            return this.xri;
        }
    }

    public static Map<String, String> y(String str, String str2) {
        Map<String, String> map = null;
        int indexOf = str == null ? -1 : str.indexOf("<" + str2);
        if (indexOf < 0) {
            x.e("MicroMsg.SDK.XmlParser", "can not find the tag <%s>", str2);
            return map;
        }
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        try {
            return new a(str, str2).chs();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.XmlParser", e, "[ %s ]", str);
            return map;
        }
    }

    public static String b(Node node) {
        Writer stringWriter = new StringWriter();
        try {
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("omit-xml-declaration", "yes");
            newTransformer.transform(new DOMSource(node), new StreamResult(stringWriter));
        } catch (TransformerException e) {
            x.e("MicroMsg.SDK.XmlParser", "nodeToString: %s", e.getMessage());
        }
        return stringWriter.toString();
    }
}
