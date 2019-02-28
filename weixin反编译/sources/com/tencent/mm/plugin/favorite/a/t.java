package com.tencent.mm.plugin.favorite.a;

import android.os.Bundle;
import com.tencent.mm.f.a.kq;
import com.tencent.mm.plugin.favorite.a.i.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class t implements a {
    public static i mwG = null;
    private static t mwH = null;
    public int duration;
    public int fws;
    public String path;

    public static t aJE() {
        if (mwH == null) {
            mwH = new t();
        }
        return mwH;
    }

    public static i aJF() {
        if (mwG == null) {
            mwG = new i();
        }
        return mwG;
    }

    public static i aJG() {
        return mwG;
    }

    public final void bl(String str, int i) {
        x.d("MicroMsg.WNNoteVoicePlayLogic", "on play, my path %s, my duration %d, play path %s", this.path, Integer.valueOf(this.duration), str);
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 1);
        if (bi.aD(str, "").equals(this.path)) {
            bundle.putBoolean("result", false);
        } else {
            bundle.putBoolean("result", true);
        }
        bundle.putInt("position", i);
        b kqVar = new kq();
        kqVar.fCS.fCM = bundle;
        kqVar.fCS.type = 4;
        com.tencent.mm.sdk.b.a.xmy.m(kqVar);
    }

    public final void onFinish() {
        mwG.stopPlay();
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 2);
        b kqVar = new kq();
        kqVar.fCS.fCM = bundle;
        kqVar.fCS.type = 4;
        com.tencent.mm.sdk.b.a.xmy.m(kqVar);
    }

    public final void onPause() {
        mwG.aJj();
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 3);
        b kqVar = new kq();
        kqVar.fCS.fCM = bundle;
        kqVar.fCS.type = 4;
        com.tencent.mm.sdk.b.a.xmy.m(kqVar);
    }
}
