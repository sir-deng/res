package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.mm.bb.a;
import com.tencent.mm.bb.e;
import com.tencent.mm.plugin.fts.d.h;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.search.a.c;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;

public final class g extends b implements b {
    private int mVj;
    private boolean odb;
    private ag qhu = new ag(Looper.getMainLooper());
    private boolean qij;
    private i qip;
    private a qiq;
    private boolean qir;
    private ag qis = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    x.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is true");
                    if (!g.this.qir && g.this.getCount() > 0) {
                        c.bqz().aOa();
                        n.qWB.start();
                        g.this.notifyDataSetChanged();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private boolean qit;

    public g(c cVar, int i, int i2) {
        super(cVar);
        this.mVj = i;
        Context context = getContext();
        int i3 = -1;
        switch (i) {
            case -15:
                i3 = 4224;
                break;
            case -13:
                i3 = 4208;
                break;
            case -7:
                i3 = 4192;
                break;
            case -5:
                i3 = 4144;
                break;
            case -4:
                i3 = 4112;
                break;
            case -3:
                i3 = 4128;
                break;
            case -2:
                i3 = 4160;
                break;
            case -1:
                i3 = 4176;
                break;
        }
        x.i("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | uiLogicType=%d", Integer.valueOf(i3), Integer.valueOf(i3));
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(i3));
        this.qip = (i) h.a(hashSet, context, (b) this, i2).get(0);
        this.qiq = new a();
    }

    protected final com.tencent.mm.plugin.fts.d.a.b qx(int i) {
        com.tencent.mm.plugin.fts.d.a.b qx = this.qip.qx(i);
        if (qx != null) {
            qx.mVk = i;
            qx.pageType = 2;
        }
        return qx;
    }

    protected final void bqD() {
        this.odb = true;
        this.qij = false;
        this.qiq.reset();
        this.qip.a(this.fEe, this.qhu, new HashSet());
    }

    protected final void clearCache() {
        super.clearCache();
        this.qip.abi();
        this.qip.aNT();
        this.qis.removeMessages(1);
    }

    protected final boolean a(View view, com.tencent.mm.plugin.fts.d.a.b bVar, boolean z) {
        this.qip.a(view, bVar, z);
        if (bVar.mVr) {
            x.d("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", Integer.valueOf(bVar.mVj), Integer.valueOf(bVar.mUl), Integer.valueOf(bVar.mVk), Integer.valueOf(bVar.mVl), bVar.mVm, Long.valueOf(bVar.mVn));
            if (!this.qij) {
                e.b(this.fEe, true, aNW(), bVar.mVj);
                this.qij = true;
            }
            e.a(bVar, this.qiq);
        } else if (bVar instanceof com.tencent.mm.plugin.search.ui.a.g) {
            this.qit = true;
            e.a(bVar, this.qiq);
        }
        return false;
    }

    public final void finish() {
        if (!this.qij) {
            this.qij = true;
            if (!this.qit) {
                e.b(this.fEe, false, aNW(), this.mVj);
            }
        }
        this.qiq.reset();
        super.finish();
    }

    public final void a(i iVar, String str) {
        if (str.equals(this.fEe)) {
            this.odb = false;
        }
        wh(iVar.qw(0));
        notifyDataSetChanged();
        H(getCount(), true);
        this.qiq.hMn = System.currentTimeMillis();
        a aVar = this.qiq;
        for (i.a aVar2 : ((com.tencent.mm.plugin.fts.d.c) iVar).mUm) {
            aVar.hMo = aVar2.mUI.size() + aVar.hMo;
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.qir = true;
            c.bqz().aNY();
            n.qWB.pause();
            x.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is false");
            return;
        }
        this.qir = false;
        if (!c.bqz().aNZ()) {
            this.qis.removeMessages(1);
            this.qis.sendEmptyMessageDelayed(1, 200);
        }
    }

    protected final int aNW() {
        return this.qip.aNW();
    }
}
