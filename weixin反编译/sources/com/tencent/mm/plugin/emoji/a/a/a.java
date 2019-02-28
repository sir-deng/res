package com.tencent.mm.plugin.emoji.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ak;
import java.util.HashMap;

public abstract class a extends BaseAdapter {
    private final String TAG = "MicroMsg.BaseEmojiListAdapter";
    private final String gIW = "lock";
    public AbsListView lAl;
    public c lAm;
    public com.tencent.mm.plugin.emoji.model.h.a lAn;
    protected volatile boolean lAo = false;
    private int lAp = 0;
    private int lAq = 0;
    private HashMap<String, com.tencent.mm.plugin.emoji.a.a> lzX;
    public Context mContext;

    public abstract int aBl();

    public abstract int aBm();

    public abstract int aBn();

    public abstract View b(int i, View view, ViewGroup viewGroup);

    public abstract com.tencent.mm.plugin.emoji.a.a c(Context context, View view);

    public abstract void oV(int i);

    public abstract void oW(int i);

    public abstract void oX(int i);

    public /* synthetic */ Object getItem(int i) {
        return oY(i);
    }

    public a(Context context) {
        this.mContext = context;
        if (this.mContext != null) {
            this.lzX = new HashMap();
        }
    }

    public final void a(c cVar) {
        if (cVar != null && this.lAm != cVar) {
            this.lAm = cVar.aBq();
            notifyDataSetChanged();
        }
    }

    public void aBk() {
        if (this.lzX != null) {
            this.lzX.clear();
        }
        super.notifyDataSetChanged();
        this.lAo = true;
    }

    public void notifyDataSetChanged() {
        Object[] objArr;
        int i;
        this.lAo = false;
        if (this.lAm != null) {
            this.lAm.notifyDataSetChanged();
            objArr = new Object[1];
            i = this.lAp;
            this.lAp = i + 1;
            objArr[0] = Integer.valueOf(i);
            x.d("MicroMsg.BaseEmojiListAdapter", "xxx data Notify: %d", objArr);
        }
        objArr = new Object[1];
        i = this.lAq;
        this.lAq = i + 1;
        objArr[0] = Integer.valueOf(i);
        x.v("MicroMsg.BaseEmojiListAdapter", "xxx ui Notify: %d", objArr);
        aBk();
    }

    public final void b(final f fVar) {
        ah.y(new Runnable() {
            public final void run() {
                if (fVar != null) {
                    a.this.lAm = a.this.a(fVar);
                    a.this.notifyDataSetChanged();
                }
            }
        });
    }

    public c a(f fVar) {
        return new c(fVar);
    }

    public int getCount() {
        return this.lAm == null ? 0 : this.lAm.size();
    }

    public f oY(int i) {
        return this.lAm == null ? null : this.lAm.pb(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        com.tencent.mm.plugin.emoji.a.a aVar = null;
        if (view != null) {
            aVar = (com.tencent.mm.plugin.emoji.a.a) view.getTag();
        }
        f oY = oY(i);
        if (aVar == null) {
            aVar = c(this.mContext, view);
            view = aVar.aBh();
            this.lzX.put(a(oY), aVar);
        } else if (!bi.oN(a(oY))) {
            if (this.lzX.containsValue(aVar)) {
                this.lzX.remove(aVar.aBa());
            }
            this.lzX.put(a(oY), aVar);
        }
        aVar.mPosition = i;
        aVar.lyW = oY;
        View b = b(i, view, viewGroup);
        aVar.aBg();
        return b;
    }

    public static String a(f fVar) {
        if (fVar == null) {
            return null;
        }
        if (fVar.lAx == com.tencent.mm.plugin.emoji.a.a.f.a.lAG) {
            return fVar.lAz.fgJ + "_cell";
        }
        return fVar.lAy.vPI;
    }

    public void clear() {
        if (this.lzX != null) {
            this.lzX.clear();
            this.lzX = null;
        }
        if (this.lAm != null) {
            this.lAm.clear();
            this.lAm = null;
        }
        this.lAo = false;
    }

    public void be(String str, int i) {
        if (this.lzX != null && this.lAm != null && str != null) {
            f yA = this.lAm.yA(str);
            if (yA != null) {
                a(yA, str, i);
            }
            if (!(yA == null || this.lAm == null || yA.mStatus != -1)) {
                x.i("MicroMsg.BaseEmojiListAdapter", "force refresh status");
                yA.a(this.lAm.lAv, this.lAm.yE(str), this.lAm.yC(str));
            }
            com.tencent.mm.plugin.emoji.a.a yz = yz(str);
            if (yz != null) {
                String aBa = yz.aBa() == null ? null : yz.aBa();
                if (aBa != null && aBa.equals(str)) {
                    yz.aBg();
                }
            }
        }
    }

    public final com.tencent.mm.plugin.emoji.a.a yz(String str) {
        if (this.lzX == null) {
            return null;
        }
        return (com.tencent.mm.plugin.emoji.a.a) this.lzX.get(str);
    }

    public final void bf(String str, int i) {
        if (this.lzX != null && this.lAm != null && str != null) {
            f yA = this.lAm.yA(str);
            if (yA != null) {
                if (i >= 0 && i < 100) {
                    a(yA, str, 6);
                    yA.sm = i;
                }
                if (i >= 100) {
                    a(yA, str, 7);
                }
            }
            com.tencent.mm.plugin.emoji.a.a yz = yz(str);
            if (yz != null) {
                String aBa = yz.aBa() == null ? null : yz.aBa();
                if (aBa != null && aBa.equals(str)) {
                    yz.aBg();
                }
            }
        }
    }

    public final void a(f fVar, String str, int i) {
        if (fVar != null && str != null) {
            fVar.eR(i);
            ak akVar = (ak) this.lAm.lAt.get(str);
            if (akVar != null) {
                akVar.DH(i);
            }
        }
    }

    public final void amN() {
        if (this.lAo) {
            super.notifyDataSetChanged();
        }
    }
}
