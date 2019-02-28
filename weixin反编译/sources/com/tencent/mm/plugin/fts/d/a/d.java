package com.tencent.mm.plugin.fts.d.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.plugin.fts.d.j.e;
import com.tencent.mm.plugin.fts.d.j.g;

public final class d extends b {
    com.tencent.mm.plugin.fts.d.a.b.a mVA = new a();
    CharSequence mVy;
    private com.tencent.mm.plugin.fts.d.a.b.b mVz = new b();

    public class a extends com.tencent.mm.plugin.fts.d.a.b.a {
        public TextView mVB;
        public View mVw;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.plugin.fts.d.a.b.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(e.mUP, viewGroup, false);
            a aVar = (a) d.this.mVA;
            aVar.mVB = (TextView) inflate.findViewById(com.tencent.mm.plugin.fts.d.j.d.cpQ);
            aVar.mVw = inflate.findViewById(com.tencent.mm.plugin.fts.d.j.d.cCr);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, b bVar, Object... objArr) {
            a aVar2 = (a) aVar;
            com.tencent.mm.plugin.fts.d.e.a(d.this.mVy, aVar2.mVB);
            if (d.this.position == 0) {
                aVar2.mVw.setVisibility(8);
            } else {
                aVar2.mVw.setVisibility(0);
            }
        }

        public final boolean a(Context context, b bVar) {
            return false;
        }
    }

    public d(int i) {
        super(18, i);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, Object... objArr) {
        Object charSequence = TextUtils.ellipsize(this.mRM.mRl, com.tencent.mm.plugin.fts.d.d.b.mUv, 400.0f, TruncateAt.MIDDLE).toString();
        this.mVy = f.a(context.getString(g.eIR), context.getString(g.eIQ), com.tencent.mm.plugin.fts.d.b.a.d(charSequence, charSequence)).mVW;
    }

    public final com.tencent.mm.plugin.fts.d.a.b.b adG() {
        return this.mVz;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b.a adH() {
        return this.mVA;
    }
}
