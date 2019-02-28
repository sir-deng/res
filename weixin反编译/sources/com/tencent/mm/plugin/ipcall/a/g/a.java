package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class a {
    private static String TAG = "MicroMsg.IPCallActivityMsgInfo";
    public String fpg = "";
    public int kzz = 0;
    public String nMl = "";
    public String nMm = "";
    public String nkL = "";

    public static a Dg(String str) {
        x.d(TAG, "getIPCallActivityMsgInfoFromXML:" + str);
        a aVar = new a();
        int indexOf = str.indexOf("<ActivityInfo");
        if (indexOf == -1) {
            x.e(TAG, "msgContent not start with <ActivityInfo");
            return aVar;
        }
        Map y = bj.y(str.substring(indexOf), "ActivityInfo");
        if (y == null) {
            x.e(TAG, "XmlParser values is null, xml %s", str);
            return null;
        }
        if (y.containsKey(".ActivityInfo.Title")) {
            aVar.fpg = (String) y.get(".ActivityInfo.Title");
        }
        if (y.containsKey(".ActivityInfo.Desc")) {
            aVar.nkL = (String) y.get(".ActivityInfo.Desc");
        }
        if (y.containsKey(".ActivityInfo.ImgUrl")) {
            aVar.nMl = (String) y.get(".ActivityInfo.ImgUrl");
        }
        if (y.containsKey(".ActivityInfo.StartBtnText")) {
            aVar.nMm = (String) y.get(".ActivityInfo.StartBtnText");
        }
        if (y.containsKey(".ActivityInfo.ActivityType")) {
            aVar.kzz = bi.getInt((String) y.get(".ActivityInfo.ActivityType"), 0);
        }
        x.d(TAG, "msgInfo:", aVar.toString());
        return aVar;
    }
}
