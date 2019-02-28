package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.BaseAdapter;
import com.tencent.mm.a.f;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;

public abstract class b<T> extends BaseAdapter {
    private static int nqF = 500;
    protected Context mContext;
    protected LinkedList<T> njn;
    a nqC;
    protected boolean nqD = false;
    private f<String, Bitmap> nqE;
    private al nqG = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            b.this.notifyDataSetChanged();
            return false;
        }
    }, false);
    private final com.tencent.mm.sdk.e.j.a nqH = new com.tencent.mm.sdk.e.j.a() {
        public final void a(String str, l lVar) {
            b.this.nqG.TN();
            long JS = (long) b.nqF;
            b.this.nqG.K(JS, JS);
        }
    };

    public interface a {
        void rf(int i);
    }

    public b(Context context) {
        this.mContext = context;
        this.njn = new LinkedList();
        this.nqE = new f(20);
        an.biT().c(this.nqH);
    }

    public void P(LinkedList<T> linkedList) {
        if (linkedList != null) {
            this.njn.addAll(linkedList);
            if (this.nqC != null) {
                this.nqC.rf(this.njn.size());
            }
            super.notifyDataSetChanged();
        } else if (this.nqC != null) {
            this.nqC.rf(this.njn.size());
        }
    }

    public void Q(LinkedList<T> linkedList) {
        if (linkedList != null) {
            this.njn = linkedList;
            if (this.nqC != null) {
                this.nqC.rf(this.njn.size());
            }
            super.notifyDataSetChanged();
        } else if (this.nqC != null) {
            this.nqC.rf(this.njn.size());
        }
    }

    protected final void remove(int i) {
        if (this.njn != null && i >= 0 && i <= this.njn.size() - 1) {
            this.njn.remove(i);
            if (this.nqC != null) {
                this.nqC.rf(this.njn.size());
            }
            super.notifyDataSetChanged();
        }
    }

    public void clear() {
        if (this.njn != null) {
            this.njn.clear();
        }
        if (this.nqE != null) {
            this.nqE.a(new com.tencent.mm.a.f.a<String, Bitmap>() {
            });
        }
        this.nqE = null;
        an.biT().j(this.nqH);
    }

    protected final Bitmap CI(String str) {
        if (bi.oN(str)) {
            return null;
        }
        Bitmap bitmap;
        if (this.nqE.bu(str)) {
            bitmap = (Bitmap) this.nqE.get(str);
            if (!(bitmap == null || bitmap.isRecycled())) {
                return bitmap;
            }
        }
        bitmap = g.b(str, 1, com.tencent.mm.bu.a.getDensity(this.mContext));
        if (bitmap == null || bitmap.isRecycled()) {
            return bitmap;
        }
        this.nqE.l(str, bitmap);
        return bitmap;
    }

    public int getCount() {
        return this.njn.size();
    }

    public Object getItem(int i) {
        return this.njn.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
