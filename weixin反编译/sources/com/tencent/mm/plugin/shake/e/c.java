package com.tencent.mm.plugin.shake.e;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import java.util.LinkedList;
import java.util.Map;

public final class c {

    public static class a {
        public String field_id;
        public String field_playstatid;
        public String field_playurl;
        public String field_shareurl;
        public String field_source;
        public String field_subtitle;
        public String field_thumburl;
        public String field_title;
        public String field_topic;
        public String field_xml;
        public LinkedList<a> qha;
    }

    public static a JT(String str) {
        if (str == null) {
            return null;
        }
        String str2 = "";
        Map y = bj.y(str, "tv");
        if (y == null) {
            return null;
        }
        a aVar = new a();
        aVar.field_id = bi.oM((String) y.get(str2 + ".tv.id"));
        aVar.field_topic = bi.oM((String) y.get(str2 + ".tv.topic"));
        aVar.field_title = bi.oM((String) y.get(str2 + ".tv.title"));
        aVar.field_subtitle = bi.oM((String) y.get(str2 + ".tv.subtitle"));
        aVar.field_thumburl = bi.oM((String) y.get(str2 + ".tv.thumburl"));
        aVar.field_shareurl = bi.oM((String) y.get(str2 + ".tv.shareurl"));
        aVar.field_playurl = bi.oM((String) y.get(str2 + ".tv.playurl"));
        aVar.field_playstatid = bi.oM((String) y.get(str2 + ".tv.playurl$statid"));
        aVar.field_source = bi.oM((String) y.get(str2 + ".tv.source"));
        aVar.qha = a.l(y, str2 + ".tv");
        aVar.field_xml = str;
        return aVar;
    }

    public static String b(a aVar) {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("<tv>");
        if (!bi.oN(aVar.field_id)) {
            stringBuilder.append("<id>" + bi.Wm(aVar.field_id) + "</id>");
        }
        stringBuilder.append("<title>" + bi.Wm(aVar.field_title) + "</title>");
        stringBuilder.append("<subtitle>" + bi.Wm(aVar.field_subtitle) + "</subtitle>");
        stringBuilder.append("<topic>" + bi.Wm(aVar.field_topic) + "</topic>");
        stringBuilder.append("<thumburl>" + bi.Wm(aVar.field_thumburl) + "</thumburl>");
        stringBuilder.append("<shareurl>" + bi.Wm(aVar.field_shareurl) + "</shareurl>");
        if (bi.oN(aVar.field_playstatid)) {
            stringBuilder.append("<playurl>" + bi.Wm(aVar.field_playurl) + "</playurl>");
        } else {
            stringBuilder.append("<playurl statid=\"" + aVar.field_playstatid + "\">" + bi.Wm(aVar.field_playurl) + "</playurl>");
        }
        stringBuilder.append("<source>" + bi.Wm(aVar.field_source) + "</source>");
        stringBuilder.append("</tv>");
        return stringBuilder.toString();
    }

    public static String a(Context context, a aVar) {
        com.tencent.mm.x.g.a aVar2 = new com.tencent.mm.x.g.a();
        aVar2.title = aVar.field_title;
        if (bi.oN(aVar.field_topic)) {
            aVar2.description = aVar.field_subtitle;
        } else {
            aVar2.description = aVar.field_topic;
        }
        aVar2.type = 20;
        aVar2.url = aVar.field_shareurl;
        aVar2.action = "";
        if (k.bsk()) {
            aVar2.appName = context.getString(R.l.eIB);
            aVar2.appId = "wxaf060266bfa9a35c";
        }
        aVar2.thumburl = aVar.field_thumburl;
        aVar2.hdl = b(aVar);
        return com.tencent.mm.x.g.a.a(aVar2, null, null);
    }
}
