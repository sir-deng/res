package com.tencent.mm.plugin.scanner;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.j.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class a {

    private static class a implements l {
        private a() {
        }

        public final Bundle j(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            Set bph = a.bpg();
            StringBuilder stringBuilder = new StringBuilder();
            if (!(bph == null || bph.isEmpty())) {
                Iterator it = bph.iterator();
                stringBuilder.append((String) it.next());
                while (it.hasNext()) {
                    stringBuilder.append("|");
                    stringBuilder.append((String) it.next());
                }
                bundle2.putString("wxCodePrefix", stringBuilder.toString());
            }
            return bundle2;
        }
    }

    public static boolean aF(int i, String str) {
        if (i != 22 || bi.oN(str)) {
            return false;
        }
        String str2;
        Set bpg;
        if (ad.cgj() || (Looper.myLooper() == Looper.getMainLooper() && !g.fm("com.tencent.mm"))) {
            bpg = bpg();
        } else {
            Set hashSet = new HashSet();
            Bundle a = f.a("com.tencent.mm", null, a.class);
            str2 = "";
            if (a != null) {
                str2 = a.getString("wxCodePrefix", "");
            }
            String[] split = str2.split("|");
            for (int i2 = 0; i2 < split.length; i2++) {
                if (!bi.oN(split[i2])) {
                    hashSet.add(split[i2]);
                }
            }
            bpg = hashSet;
        }
        for (String str22 : bpg) {
            if (str.startsWith(str22)) {
                return true;
            }
        }
        return false;
    }

    private static Set<String> bpg() {
        Set<String> hashSet = new HashSet();
        hashSet.add("k");
        hashSet.add("l");
        if (ad.cgj()) {
            String F;
            String str = "";
            c Ag = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Ag();
            if (Ag != null) {
                F = Ag.F("ScanCode", "weAppCodePrefix");
            } else {
                F = str;
            }
            x.v("MicroMsg.QRCodeLogic", "getWxCodePrefix(%s)", F);
            if (!bi.oN(F)) {
                String[] split = F.split("|");
                for (int i = 0; i < split.length; i++) {
                    if (!bi.oN(split[i])) {
                        hashSet.add(split[i]);
                    }
                }
            }
        }
        return hashSet;
    }
}
