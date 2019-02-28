package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import java.util.ArrayList;
import java.util.List;

public final class b {

    private static class a {
        List<String> qpF;

        private a() {
            this.qpF = new ArrayList();
        }

        /* synthetic */ a(byte b) {
            this();
        }

        final String cdh() {
            if (this.qpF == null || this.qpF.size() == 0) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (String append : this.qpF) {
                stringBuffer.append(append);
                stringBuffer.append(";");
            }
            return stringBuffer.toString();
        }

        final void Jh(String str) {
            this.qpF = new ArrayList();
            if (str != null && str.length() != 0) {
                for (Object add : str.split(";")) {
                    this.qpF.add(add);
                }
            }
        }
    }

    public static boolean Tp(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppNewIconUtil", "markNew fail, appId is empty");
            return false;
        }
        t Db = g.Dq().Db();
        if (Db == null) {
            x.e("MicroMsg.AppNewIconUtil", "markNew fail, cfgStg is null");
            return false;
        }
        a aVar = new a();
        aVar.Jh((String) Db.get(69121, null));
        if (!aVar.qpF.contains(str)) {
            aVar.qpF.add(str);
        }
        Db.set(69121, aVar.cdh());
        return true;
    }

    public static boolean Tq(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, appId is empty");
            return false;
        }
        t Db = g.Dq().Db();
        if (Db == null) {
            x.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, cfgStg is null");
            return false;
        }
        a aVar = new a();
        aVar.Jh((String) Db.get(69121, null));
        if (aVar.qpF.contains(str)) {
            aVar.qpF.remove(str);
        }
        Db.set(69121, aVar.cdh());
        return true;
    }
}
