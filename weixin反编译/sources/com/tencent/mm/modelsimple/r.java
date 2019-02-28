package com.tencent.mm.modelsimple;

import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.rz;
import com.tencent.mm.f.a.sb;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.afj;
import com.tencent.mm.protocal.c.afk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.ar;

public final class r extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    private String hPj;

    public r(String str) {
        this.hPj = str;
        a aVar = new a();
        aVar.hnT = new afj();
        aVar.hnU = new afk();
        aVar.uri = "/cgi-bin/micromsg-bin/getprofile";
        aVar.hnS = HardCoderJNI.SCENE_QUIT_CHATTING;
        this.gLB = aVar.Kf();
        ((afj) this.gLB.hnQ.hnY).kyG = str;
    }

    public final int getType() {
        return HardCoderJNI.SCENE_QUIT_CHATTING;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (bi.oN(this.hPj)) {
            x.e("MicroMsg.NetSceneGetProfile", "null or empty username");
            return -1;
        }
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetProfile", "get profile ret: errType=" + i2 + " errCode=" + i3 + " errMsg=" + str);
        if (i2 == 0 && i3 == 0) {
            afk afk = (afk) this.gLB.hnR.hnY;
            com.tencent.mm.sdk.b.b sbVar = new sb();
            sbVar.fKD.fKE = afk;
            com.tencent.mm.sdk.b.a.xmy.m(sbVar);
            sbVar = new rz();
            sbVar.fKB.fKC = afk.wtX.xbc;
            com.tencent.mm.sdk.b.a.xmy.m(sbVar);
            if (com.tencent.mm.y.q.FY().equals(afk.wtW.wfM.toString()) && !bi.oN(afk.wtX.wbZ)) {
                g.Dq().Db().a(w.a.USERINFO_SELFINFO_SMALLIMGURL_STRING, afk.wtX.wbZ);
            }
            x.d("MicroMsg.NetSceneGetProfile", "summersafecdn resp.UserInfo.PluginSwitch[%d], GrayscaleFlag[%d]", Integer.valueOf(afk.wtW.wHk), Integer.valueOf(afk.wtX.xaW));
            g.Dq().Db().set(64, Integer.valueOf(afk.wtX.vMj));
            g.Dq().Db().set(144385, Integer.valueOf(afk.wtX.xaW));
            g.Dq().Db().set(40, Integer.valueOf(afk.wtW.wHk));
            g.Dq().Db().set(339975, Integer.valueOf(afk.wtX.xbe));
            x.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d", Integer.valueOf(afk.wtX.xbe));
            g.Dq().Db().a(w.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(afk.wtX.woN));
            x.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d %d", Integer.valueOf(afk.wtX.xbe), Integer.valueOf(afk.wtX.woN));
            g.Dq().Db().set(208903, afk.wtX.vSF);
            g.Dq().Db().set(274433, afk.wtX.wGv);
            g.Dq().Db().set(274434, afk.wtX.wGu);
            g.Dq().Db().set(274436, afk.wtX.xaX);
            g.Dq().Db().a(w.a.USERINFO_PROFILE_WEIDIANINFO_STRING, bi.aD(afk.wtX.fXy, ""));
            g.Dq().Db().a(w.a.USERINFO_F2F_RING_TONE_STRING, afk.wtX.xbg);
            x.d("MicroMsg.NetSceneGetProfile", "weidianInfo:%s", afk.wtX.fXy);
            ar.hhz.S("last_login_use_voice", afk.wtW.wHk);
            if (VERSION.SDK_INT < 23) {
                System.putString(ad.getContext().getContentResolver(), "89884a87498ef44f", afk.wtX.xbd);
            }
        }
        this.gLE.a(i2, i3, str, this);
    }
}
