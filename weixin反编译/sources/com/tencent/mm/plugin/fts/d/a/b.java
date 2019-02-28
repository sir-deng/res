package com.tencent.mm.plugin.fts.d.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.j.c;
import com.tencent.mm.sdk.platformtools.x;

public abstract class b {
    public String info;
    public final int kZv;
    public e mRM;
    public int mUl;
    public boolean mVh;
    public boolean mVi = true;
    public int mVj;
    public int mVk;
    public int mVl;
    public String mVm;
    public long mVn;
    public boolean mVo;
    public int mVp;
    public int mVq;
    public boolean mVr;
    public int pageType;
    public final int position;

    public abstract class b {
        public abstract View a(Context context, ViewGroup viewGroup);

        public abstract void a(Context context, a aVar, b bVar, Object... objArr);

        public abstract boolean a(Context context, b bVar);

        public static void a(String str, j jVar) {
            ((m) g.k(m.class)).updateTopHitsRank(str, jVar, 0);
        }

        public final void cm(View view) {
            if (b.this.mVi) {
                view.setBackgroundResource(c.bBy);
            } else {
                view.setBackgroundResource(c.bBz);
            }
        }

        public final void cn(View view) {
            if (b.this.mVi) {
                view.setBackgroundResource(c.bDq);
            } else {
                view.setBackgroundResource(c.bDK);
            }
        }
    }

    public abstract class a {
    }

    public abstract void a(Context context, a aVar, Object... objArr);

    public abstract b adG();

    public abstract a adH();

    public b(int i, int i2) {
        this.kZv = i;
        this.position = i2;
        x.v("MicroMsg.FTS.FTSDataItem", "create data item | viewType=%d | position=%d", Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final void cG(int i, int i2) {
        this.mVp = i;
        this.mVq = i2;
        this.mVr = true;
    }

    public int adJ() {
        return 0;
    }

    public String adI() {
        return "";
    }

    public int aOf() {
        return 0;
    }

    public boolean aOg() {
        return false;
    }

    public int aOh() {
        return 0;
    }
}
