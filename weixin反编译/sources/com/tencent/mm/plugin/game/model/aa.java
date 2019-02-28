package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.model.t.a;
import com.tencent.mm.plugin.game.model.t.d;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;

public final class aa {
    public static aa niX;

    static aa aRf() {
        if (niX == null) {
            niX = new aa();
        }
        return niX;
    }

    static void c(Map<String, String> map, t tVar) {
        String str = ".sysmsg.gamecenter.jump_info.jump";
        tVar.nhX.clear();
        int i = 0;
        while (true) {
            String str2;
            if (i == 0) {
                str2 = str;
            } else {
                str2 = str + i;
            }
            if (map.containsKey(str2)) {
                String str3 = (String) map.get(str2 + ".$id");
                d dVar = new d();
                dVar.niJ = bi.getInt((String) map.get(str2 + ".jump_type"), 0);
                dVar.lZU = bi.aD((String) map.get(str2 + ".jump_url"), "");
                if (!bi.oN(str3)) {
                    tVar.nhX.put(str3, dVar);
                }
                i++;
            } else {
                return;
            }
        }
    }

    static void d(Map<String, String> map, t tVar) {
        tVar.niA = bi.getInt((String) map.get(".sysmsg.gamecenter.report.msg_subtype"), 0);
        tVar.niB = bi.aD((String) map.get(".sysmsg.gamecenter.report.noticeid"), "");
    }

    static void e(Map<String, String> map, t tVar) {
        boolean z;
        boolean z2 = true;
        tVar.nij.url = bi.aD((String) map.get(".sysmsg.gamecenter.float_layer.open_url"), "");
        a aVar = tVar.nij;
        if (bi.getInt((String) map.get(".sysmsg.gamecenter.float_layer.full_screen"), 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        aVar.nhE = z;
        tVar.nij.orientation = bi.getInt((String) map.get(".sysmsg.gamecenter.float_layer.orientation"), 0);
        aVar = tVar.nij;
        if (bi.getInt((String) map.get(".sysmsg.gamecenter.float_layer.is_transparent"), 0) != 1) {
            z2 = false;
        }
        aVar.niF = z2;
    }
}
