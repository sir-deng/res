package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.x;

public abstract class a {
    public static final int mUs = com.tencent.mm.bu.a.aa(ad.getContext(), c.bvL);
    public static final TextPaint mUt = new TextPaint();
    public static final int mUu = com.tencent.mm.bu.a.aa(ad.getContext(), c.bvt);
    public static final TextPaint mUv = new TextPaint();
    public String fEe;
    public String fqA;
    public x jQP;
    public boolean kLA;
    public final int kZv;
    public e mRM;
    public int mVk;
    public int mVp;
    public int mVq;
    public final int position;
    public boolean sbt;
    public int scene;
    public boolean zbR;
    public boolean zbS;
    public boolean zed;
    boolean zee;
    public boolean zef;

    public class a {
    }

    public abstract class b {
        public abstract boolean Xb();

        public abstract View a(Context context, ViewGroup viewGroup);

        public abstract void a(Context context, a aVar, a aVar2, boolean z, boolean z2);
    }

    public abstract b WZ();

    public abstract a Xa();

    public abstract void bH(Context context);

    static {
        mUt.setTextSize((float) mUs);
        mUv.setTextSize((float) mUu);
    }

    public a(int i, int i2) {
        this.kZv = i;
        this.position = i2;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BaseContactDataItem", "Create BaseContactDataItem viewType=%d | position=%d", Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final void cG(int i, int i2) {
        this.mVp = i;
        this.mVq = i2;
    }

    public boolean aOg() {
        return false;
    }
}
