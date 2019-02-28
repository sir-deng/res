package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.fts.d.h;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.search.ui.c.f;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import java.util.HashSet;

public final class e extends b implements b {
    private ag qhu = new ag(Looper.getMainLooper());
    private f qii;
    private boolean qij;

    public e(c cVar, String str, int i) {
        super(cVar);
        Context context = cVar.getContext();
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(JsApiSetBackgroundAudioState.CTRL_INDEX));
        f fVar = (f) h.a(hashSet, context, (b) this, i).get(0);
        fVar.mRD = str;
        if (s.eX(str)) {
            as.Hm();
            fVar.qid = c.Fo().hG(str);
        }
        this.qii = fVar;
    }

    public final void a(i iVar, String str) {
        wh(iVar.qw(0));
        notifyDataSetChanged();
        H(getCount(), true);
    }

    protected final com.tencent.mm.plugin.fts.d.a.b qx(int i) {
        com.tencent.mm.plugin.fts.d.a.b qx = this.qii.qx(i);
        if (qx != null) {
            qx.mVk = i;
            qx.pageType = 4;
        }
        return qx;
    }

    protected final void bqD() {
        this.qij = false;
        this.qii.a(this.fEe, this.qhu, new HashSet());
    }

    protected final boolean a(View view, com.tencent.mm.plugin.fts.d.a.b bVar, boolean z) {
        this.qii.a(view, bVar, z);
        if (bVar.mVr && !this.qij) {
            this.qij = true;
            com.tencent.mm.bb.e.b(this.fEe, true, this.qii.aNV(), -2);
        }
        return false;
    }

    public final void finish() {
        super.finish();
        if (!this.qij) {
            this.qij = true;
            com.tencent.mm.bb.e.b(this.fEe, false, this.qii.aNV(), -2);
        }
    }

    protected final int aNW() {
        return this.qii.aNV();
    }
}
