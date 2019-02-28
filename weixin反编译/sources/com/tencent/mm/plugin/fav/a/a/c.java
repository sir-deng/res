package com.tencent.mm.plugin.fav.a.a;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.c.wa;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class c {
    public static void a(Map<String, String> map, wa waVar) {
        if (map == null || waVar == null) {
            x.w("MicroMsg.FavTagParser", "maps is null or item is null");
            return;
        }
        String str;
        waVar.wmn.clear();
        int i = 0;
        while (i < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            str = (String) map.get(".favitem.taglist.tag" + (i > 0 ? Integer.valueOf(i) : ""));
            if (str == null) {
                break;
            }
            waVar.wmn.add(str);
            i++;
        }
        if (!waVar.wmn.isEmpty()) {
            x.d("MicroMsg.FavTagParser", "user def tag not empty, res=%s", waVar.wmn);
        }
        waVar.wmm.clear();
        i = 0;
        while (i < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            str = (String) map.get(".favitem.recommendtaglist.tag" + (i > 0 ? Integer.valueOf(i) : ""));
            if (str == null) {
                break;
            }
            waVar.wmm.add(str);
            i++;
        }
        if (!waVar.wmm.isEmpty()) {
            x.d("MicroMsg.FavTagParser", "recommended tag not empty, res=%s", waVar.wmm);
        }
    }

    public static String a(wa waVar) {
        int i = 0;
        if (waVar == null || (waVar.wmn.isEmpty() && waVar.wmm.isEmpty())) {
            x.v("MicroMsg.FavTagParser", "tag list toXml data list empty");
            return "";
        }
        int i2;
        StringBuffer stringBuffer = new StringBuffer();
        int size = waVar.wmn.size();
        stringBuffer.append("<taglist count='").append(size).append("'>");
        for (i2 = 0; i2 < size; i2++) {
            stringBuffer.append("<tag>").append(bi.Wm((String) waVar.wmn.get(i2))).append("</tag>");
        }
        stringBuffer.append("</taglist>");
        i2 = waVar.wmm.size();
        stringBuffer.append("<recommendtaglist count='").append(i2).append("'>");
        while (i < i2) {
            stringBuffer.append("<tag>").append(bi.Wm((String) waVar.wmm.get(i))).append("</tag>");
            i++;
        }
        stringBuffer.append("</recommendtaglist>");
        return stringBuffer.toString();
    }
}
