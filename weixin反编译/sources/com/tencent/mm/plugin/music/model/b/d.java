package com.tencent.mm.plugin.music.model.b;

import android.text.TextUtils;
import com.tencent.mm.au.a;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private static aa<String, String> oQM = new aa(20);
    private static aa<String, Long> oQN = new aa(20);

    public static void f(a aVar) {
        boolean z = true;
        boolean z2 = false;
        if (aVar == null) {
            x.e("MicroMsg.Music.MusicUrlParser", "GetShakeMusicUrl, music is null");
            return;
        }
        int i;
        boolean isWifi = ao.isWifi(ad.getContext());
        PBool pBool = new PBool();
        String a = g.a(bi.oN(aVar.field_songWifiUrl) ? aVar.field_songWebUrl : aVar.field_songWifiUrl, aVar.field_songWapLinkUrl, isWifi, pBool);
        x.i("MicroMsg.Music.MusicUrlParser", "parsePlayUrl mSrc:%s", a);
        x.i("MicroMsg.Music.MusicUrlParser", "songWifiUrl:%s", aVar.field_songWifiUrl);
        String str = "MicroMsg.Music.MusicUrlParser";
        String str2 = "isWifi:%d, isQQMusic:%d";
        Object[] objArr = new Object[2];
        if (isWifi) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(pBool.value ? 1 : 0);
        x.i(str, str2, objArr);
        if (isWifi) {
            z2 = pBool.value;
        }
        if (g.Gs(a)) {
            x.i("MicroMsg.Music.MusicUrlParser", "can match shake music wifi url");
        } else {
            z = z2;
        }
        aVar.hJE = a;
        e.at(a, z);
    }

    public static void dD(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            oQM.put(str, str2);
            oQN.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static String GN(String str) {
        String str2 = (TextUtils.isEmpty(str) || !oQM.bu(str)) ? null : (String) oQM.get(str);
        if (str2 == null) {
            return str;
        }
        return str2;
    }

    public static boolean g(a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.hJE)) {
            return false;
        }
        if (!GO(aVar.hJE)) {
            return false;
        }
        if (g.tJ(aVar.field_musicType)) {
            if (e.i(aVar)) {
                x.i("MicroMsg.Music.MusicUrlParser", "qq music pieceFile cache is valid");
                return false;
            }
        } else if (e.h(aVar)) {
            x.i("MicroMsg.Music.MusicUrlParser", "music cache is valid");
            return false;
        }
        if (!oQM.bu(aVar.hJE)) {
            return true;
        }
        long j = 0;
        if (oQN.bu(aVar.hJE)) {
            j = ((Long) oQN.get(aVar.hJE)).longValue();
        }
        if (System.currentTimeMillis() - j <= 86400000) {
            return false;
        }
        oQM.remove(aVar.hJE);
        oQN.remove(aVar.hJE);
        x.i("MicroMsg.Music.MusicUrlParser", "shake music url in cache is timeout");
        return true;
    }

    public static boolean GO(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("wxshakemusic")) {
            return true;
        }
        return false;
    }

    public static String GP(String str) {
        if (!GO(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf("wxshakemusic");
        if (lastIndexOf > 1) {
            return str.substring(0, lastIndexOf - 1);
        }
        return str;
    }
}
