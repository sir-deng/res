package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.fts.d.f;

public final class a extends com.tencent.mm.plugin.fts.d.a.b {
    public CharSequence qjC;
    private b qjD = new b();
    private a qjE = new a();

    public class a extends com.tencent.mm.plugin.fts.d.a.b.a {
        public View contentView;
        public ImageView jIs;
        public TextView mVG;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.plugin.fts.d.a.b.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.djo, viewGroup, false);
            a aVar = new a();
            aVar.jIs = (ImageView) inflate.findViewById(R.h.coQ);
            aVar.mVG = (TextView) inflate.findViewById(R.h.cSc);
            aVar.contentView = inflate.findViewById(R.h.cJR);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
            a aVar2 = (a) aVar;
            cm(aVar2.contentView);
            e.a(a.this.qjC, aVar2.mVG);
            aVar2.jIs.setImageResource(R.k.dAJ);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
            return false;
        }
    }

    public a(int i) {
        super(10, i);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, Object... objArr) {
        this.qjC = f.a(context.getResources().getString(R.l.ekD), "", com.tencent.mm.plugin.fts.d.b.a.d(this.mRM.mRl, this.mRM.mRl)).mVW;
    }

    public final com.tencent.mm.plugin.fts.d.a.b.b adG() {
        return this.qjD;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b.a adH() {
        return this.qjE;
    }
}
