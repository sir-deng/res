package com.tencent.mm.plugin.game.model;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.game.model.t.d;
import com.tencent.mm.plugin.game.model.t.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class aq {
    private static String O(LinkedList<h> linkedList) {
        if (bi.cC(linkedList)) {
            return "";
        }
        Writer stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            newSerializer.startTag(null, "userinfo");
            newSerializer.attribute(null, "jump_id", hVar.niS);
            newSerializer.startTag(null, "username");
            try {
                newSerializer.text(bi.aD(hVar.userName, ""));
            } catch (Exception e) {
                newSerializer.text("");
            }
            newSerializer.endTag(null, "username");
            newSerializer.startTag(null, "nickname");
            try {
                newSerializer.text(bi.aD(hVar.bgo, ""));
            } catch (Exception e2) {
                newSerializer.text("");
            }
            newSerializer.endTag(null, "nickname");
            newSerializer.startTag(null, "usericon");
            try {
                newSerializer.text(bi.aD(hVar.niP, ""));
            } catch (Exception e3) {
                newSerializer.text("");
            }
            try {
                newSerializer.endTag(null, "usericon");
                newSerializer.startTag(null, "profile");
                try {
                    newSerializer.text(bi.aD(hVar.niQ, ""));
                } catch (Exception e4) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "profile");
                newSerializer.startTag(null, "badge_icon");
                try {
                    newSerializer.text(bi.aD(hVar.niR, ""));
                } catch (Exception e5) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "badge_icon");
                newSerializer.endTag(null, "userinfo");
            } catch (Exception e6) {
                x.e("MicroMsg.GameXmlProcess", e6.getMessage());
                return "";
            }
        }
        newSerializer.endDocument();
        stringWriter.flush();
        stringWriter.close();
        return stringWriter.getBuffer().toString();
    }

    private static String a(LinkedList<h> linkedList, HashMap<String, d> hashMap) {
        if (bi.cC(linkedList) || hashMap.isEmpty()) {
            return "";
        }
        Writer stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            d dVar = (d) hashMap.get(hVar.niS);
            if (dVar != null) {
                newSerializer.startTag(null, "jump");
                newSerializer.attribute(null, SlookAirButtonFrequentContactAdapter.ID, hVar.niS);
                newSerializer.startTag(null, "jump_type");
                try {
                    newSerializer.text(String.valueOf(dVar.niJ));
                } catch (Exception e) {
                    try {
                        newSerializer.text("");
                    } catch (Exception e2) {
                        x.e("MicroMsg.GameXmlProcess", e2.getMessage());
                        return "";
                    }
                }
                newSerializer.endTag(null, "jump_type");
                newSerializer.startTag(null, "jump_url");
                try {
                    newSerializer.text(bi.aD(dVar.lZU, ""));
                } catch (Exception e3) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "jump_url");
                newSerializer.endTag(null, "jump");
            }
        }
        newSerializer.endDocument();
        stringWriter.flush();
        stringWriter.close();
        return stringWriter.getBuffer().toString();
    }

    public static String a(String str, LinkedList<h> linkedList, HashMap<String, d> hashMap) {
        if (bi.oN(str) || bi.cC(linkedList)) {
            return str;
        }
        String O = O(linkedList);
        if (bi.oN(O)) {
            return str;
        }
        String a = a(linkedList, hashMap);
        StringBuilder stringBuilder = new StringBuilder(str);
        try {
            if (stringBuilder.indexOf("<userinfo>") != -1) {
                stringBuilder.insert(stringBuilder.indexOf("<userinfo>"), "<usercount>" + linkedList.size() + 1 + "</usercount>");
            }
            if (stringBuilder.lastIndexOf("</userinfo>") != -1) {
                stringBuilder.insert(stringBuilder.lastIndexOf("</userinfo>") + 11, O);
            }
            if (!(stringBuilder.lastIndexOf("</jump>") == -1 || bi.oN(a))) {
                stringBuilder.insert(stringBuilder.lastIndexOf("</jump>") + 7, a);
            }
        } catch (Exception e) {
            x.e("MicroMsg.GameXmlProcess", e.getMessage());
            x.e("MicroMsg.GameXmlProcess", "xml is invalid : " + str);
        }
        return stringBuilder.toString();
    }
}
