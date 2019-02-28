package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;

public final class h extends a {
    private CharSequence mVy;
    private b zeB = new b();
    com.tencent.mm.ui.contact.a.a.a zeC = new a();

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public TextView mVB;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(f.qlC, viewGroup, false);
            a aVar = (a) h.this.zeC;
            aVar.mVB = (TextView) inflate.findViewById(e.cpQ);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            com.tencent.mm.plugin.fts.d.e.a(h.this.mVy, ((a) aVar).mVB);
        }

        public final boolean Xb() {
            return false;
        }
    }

    public h(int i) {
        super(6, i);
    }

    public final void bH(Context context) {
        this.mVy = com.tencent.mm.plugin.fts.d.f.a(context.getString(com.tencent.mm.plugin.selectcontact.a.h.eIR), context.getString(com.tencent.mm.plugin.selectcontact.a.h.eIQ), com.tencent.mm.plugin.fts.d.b.a.d(this.fEe, this.fEe)).mVW;
    }

    public final com.tencent.mm.ui.contact.a.a.b WZ() {
        return this.zeB;
    }

    protected final com.tencent.mm.ui.contact.a.a.a Xa() {
        return this.zeC;
    }
}
