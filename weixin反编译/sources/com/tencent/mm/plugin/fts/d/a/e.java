package com.tencent.mm.plugin.fts.d.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.d.j.d;
import com.tencent.mm.plugin.fts.d.j.f;
import com.tencent.mm.plugin.fts.d.j.g;
import com.tencent.mm.sdk.platformtools.x;

public class e extends b {
    public String mVD;
    private b mVE = new b();
    private a mVF = new a();

    public class b extends com.tencent.mm.plugin.fts.d.a.b.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(com.tencent.mm.plugin.fts.d.j.e.djn, viewGroup, false);
            a aVar = new a();
            aVar.mVG = (TextView) inflate.findViewById(d.cSc);
            aVar.jIs = (ImageView) inflate.findViewById(d.coQ);
            aVar.contentView = inflate.findViewById(d.cJR);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, b bVar, Object... objArr) {
            a aVar2 = (a) aVar;
            e eVar = (e) bVar;
            cm(aVar2.contentView);
            aVar2.mVG.setText(eVar.mVD);
            aVar2.jIs.setImageResource(f.dyR);
        }

        public final boolean a(Context context, b bVar) {
            Intent intent = new Intent();
            intent.putExtra("detail_query", e.this.mRM.mRl);
            intent.putExtra("detail_type", e.this.mVj);
            intent.putExtra("Search_Scene", e.this.mUl);
            com.tencent.mm.bl.d.b(context, "search", ".ui.FTSDetailUI", intent);
            return true;
        }
    }

    public class a extends com.tencent.mm.plugin.fts.d.a.b.a {
        public View contentView;
        public ImageView jIs;
        public TextView mVG;

        public a() {
            super();
        }
    }

    public e(int i) {
        super(12, i);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, Object... objArr) {
        if (com.tencent.mm.plugin.fts.d.e.qy(this.mVj) == null) {
            this.mVD = "";
        } else {
            this.mVD = context.getResources().getString(g.mUY, new Object[]{r0});
        }
        x.i("MicroMsg.FTS.FTSMoreDataItem", "fillDataItem: tip=%s", this.mVD);
    }

    public com.tencent.mm.plugin.fts.d.a.b.b adG() {
        return this.mVE;
    }

    public com.tencent.mm.plugin.fts.d.a.b.a adH() {
        return this.mVF;
    }
}
