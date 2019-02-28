package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;

public final class g extends a {
    public String mVt;
    private b zey = new b();
    a zez = new a();

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(f.qlB, viewGroup, false);
            a aVar = g.this.zez;
            aVar.lmd = (TextView) inflate.findViewById(e.coz);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            com.tencent.mm.plugin.fts.d.e.a(((g) aVar2).mVt, ((a) aVar).lmd);
        }

        public final boolean Xb() {
            return false;
        }
    }

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public TextView lmd;

        public a() {
            super();
        }
    }

    public g(int i) {
        super(0, i);
    }

    public final void bH(Context context) {
    }

    public final com.tencent.mm.ui.contact.a.a.b WZ() {
        return this.zey;
    }

    protected final com.tencent.mm.ui.contact.a.a.a Xa() {
        return this.zez;
    }
}
