package com.tencent.mm.ap;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class f {
    public static e a(e eVar) {
        if (eVar == null) {
            return null;
        }
        if (!eVar.Pk()) {
            return eVar;
        }
        e hT = o.PC().hT(eVar.hBK);
        if (hT != null) {
            return hT;
        }
        return eVar;
    }

    public static boolean b(e eVar) {
        if (eVar == null) {
            return false;
        }
        int i = eVar.offset;
        int i2 = eVar.hmZ;
        long j = eVar.fGj;
        if (eVar.Pk()) {
            e hT = o.PC().hT(eVar.hBK);
            i = hT.offset;
            i2 = hT.hmZ;
            j = hT.fGj;
        }
        if (i2 == 0) {
            return true;
        }
        if ((i != i2 || i2 == 0) && j == 0) {
            return false;
        }
        return true;
    }

    public static String c(e eVar) {
        if (eVar == null) {
            return "";
        }
        if (!eVar.Pk()) {
            return eVar.hBB;
        }
        e hT = o.PC().hT(eVar.hBK);
        if (hT == null) {
            return "";
        }
        return hT.hBB;
    }

    public static String c(String str, String str2, String str3, String str4) {
        if (bi.oN(str)) {
            return null;
        }
        return String.format("<appinfo><appid>%s</appid><mediatagname>%s</mediatagname><messageext>%s</messageext><messageaction>%s</messageaction></appinfo>", new Object[]{str, bi.oM(str2), bi.oM(str3), bi.oM(str4)});
    }

    public static final a ln(String str) {
        if (bi.oN(str)) {
            return null;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        Map y = bj.y(str, "msg");
        if (y == null) {
            x.e("MicroMsg.ImgInfoLogic", "parseImg failed");
            return null;
        }
        a aVar = new a();
        aVar.appId = (String) y.get(".msg.appinfo.appid");
        aVar.mediaTagName = (String) y.get(".msg.appinfo.mediatagname");
        aVar.messageExt = (String) y.get(".msg.appinfo.messageext");
        aVar.messageAction = (String) y.get(".msg.appinfo.messageaction");
        return aVar;
    }
}
