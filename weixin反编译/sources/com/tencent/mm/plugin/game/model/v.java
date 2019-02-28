package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.model.t.a;
import com.tencent.mm.plugin.game.model.t.h;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;

public final class v {
    static String y(Map<String, String> map) {
        return bi.aD((String) map.get(".sysmsg.gamecenter.formatcontent"), "");
    }

    static void a(Map<String, String> map, t tVar) {
        tVar.nhS.clear();
        String str = ".sysmsg.gamecenter.userinfo";
        int i = 0;
        while (true) {
            String str2;
            if (i == 0) {
                str2 = str;
            } else {
                str2 = str + i;
            }
            if (map.containsKey(str2)) {
                h hVar = new h();
                hVar.userName = bi.aD((String) map.get(str2 + ".username"), "");
                hVar.bgo = bi.aD((String) map.get(str2 + ".nickname"), "");
                hVar.niP = bi.aD((String) map.get(str2 + ".usericon"), "");
                hVar.niR = bi.aD((String) map.get(str2 + ".badge_icon"), "");
                hVar.niS = bi.aD((String) map.get(str2 + ".$jump_id"), "");
                tVar.nhS.add(hVar);
                i++;
            } else {
                return;
            }
        }
    }

    static long z(Map<String, String> map) {
        return bi.getLong((String) map.get(".sysmsg.game_control_info.control_flag"), 0);
    }

    static void b(Map<String, String> map, t tVar) {
        boolean z;
        boolean z2 = true;
        tVar.nij.url = bi.aD((String) map.get(".sysmsg.gamecenter.floatlayer.open_url"), "");
        a aVar = tVar.nij;
        if (bi.getInt((String) map.get(".sysmsg.gamecenter.floatlayer.full_screen"), 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        aVar.nhE = z;
        tVar.nij.orientation = bi.getInt((String) map.get(".sysmsg.gamecenter.floatlayer.orientation"), 0);
        aVar = tVar.nij;
        if (bi.getInt((String) map.get(".sysmsg.gamecenter.floatlayer.is_transparent"), 0) != 1) {
            z2 = false;
        }
        aVar.niF = z2;
    }
}
