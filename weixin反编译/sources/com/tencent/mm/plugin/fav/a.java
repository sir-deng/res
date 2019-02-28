package com.tencent.mm.plugin.fav;

import android.os.Looper;
import com.tencent.mm.ad.d.b;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class a implements l {
    public final b a(String str, Map<String, String> map, com.tencent.mm.ad.d.a aVar) {
        x.i("MicroMsg.Fav.FavNewXmlConsumer", "consumeNewXml subtype: %s values: %s", str, map.toString());
        int i = -1;
        switch (str.hashCode()) {
            case -1938535405:
                if (str.equals("resendfavitem")) {
                    i = 1;
                    break;
                }
                break;
            case -1648140403:
                if (str.equals("uploadfavitem")) {
                    i = 0;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                com.tencent.mm.sdk.b.b fwVar = new fw();
                fwVar.fwl.type = 38;
                fwVar.fwl.fwu = (String) map.get(".sysmsg.favids");
                com.tencent.mm.sdk.b.a.xmy.a(fwVar, Looper.getMainLooper());
                g.pW(1);
                break;
            case 1:
                com.tencent.mm.sdk.b.b fwVar2 = new fw();
                fwVar2.fwl.type = 39;
                fwVar2.fwl.fwu = (String) map.get(".sysmsg.favitem.favid");
                fwVar2.fwl.fwv = (String) map.get(".sysmsg.favitem.dataidlist");
                com.tencent.mm.sdk.b.a.xmy.a(fwVar2, Looper.getMainLooper());
                g.pW(0);
                break;
        }
        return null;
    }
}
