package com.tencent.mm.plugin.appbrand.media;

import android.text.TextUtils;
import com.tencent.mm.au.b;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class d {
    public String fsi;
    public String fwG;
    public int fwH;
    private HashMap<String, c> hzv;
    public String jFc;
    public String jFd;

    private static class a {
        private static d jFe = new d();
    }

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.hzv = new HashMap();
    }

    public final boolean by(String str, String str2) {
        if (str2.equalsIgnoreCase("play")) {
            x.i("MicroMsg.AppBrandMusicPlayerManager", "play option appid %s, pre appid %s", str, this.jFc);
            return true;
        }
        if (str.equalsIgnoreCase(this.jFc)) {
            ati Qz = b.Qz();
            if (Qz != null && Qz.wdd.equals(this.jFd)) {
                return true;
            }
        }
        return false;
    }

    public final void a(c cVar, String str) {
        if (this.hzv.get(str) != null) {
            x.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already add appid: %s", str);
            return;
        }
        com.tencent.mm.sdk.b.a.xmy.b(cVar);
        this.hzv.put(str, cVar);
    }

    public final void sB(String str) {
        if (this.hzv.get(str) == null) {
            x.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already remove appid: %s", str);
            return;
        }
        com.tencent.mm.sdk.b.a.xmy.c((c) this.hzv.remove(str));
        this.hzv.remove(str);
    }

    public final boolean tO(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.AppBrandMusicPlayerManager", "appId is empty");
            return false;
        } else if (!str.equalsIgnoreCase(this.jFc)) {
            x.e("MicroMsg.AppBrandMusicPlayerManager", "appId is not equals pre play id");
            return false;
        } else if (TextUtils.isEmpty(this.jFd)) {
            x.e("MicroMsg.AppBrandMusicPlayerManager", "now app not play music");
            return false;
        } else {
            ati Qz = b.Qz();
            if (Qz == null) {
                x.e("MicroMsg.AppBrandMusicPlayerManager", "wrapper is null");
                return false;
            } else if (!this.jFd.equalsIgnoreCase(Qz.wdd)) {
                x.e("MicroMsg.AppBrandMusicPlayerManager", "musicId is diff");
                return false;
            } else if (b.Qx()) {
                return true;
            } else {
                x.i("MicroMsg.AppBrandMusicPlayerManager", "MusicHelper.isPlayingMusic FALSE");
                return false;
            }
        }
    }
}
