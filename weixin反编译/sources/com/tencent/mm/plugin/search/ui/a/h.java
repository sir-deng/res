package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.sdk.platformtools.bi;

public final class h extends com.tencent.mm.plugin.fts.d.a.b {
    public String mRD;
    public boolean qkj;
    public CharSequence qkk;
    private b qkl = new b();
    private a qkm = new a();

    public class a extends com.tencent.mm.plugin.fts.d.a.b.a {
        public View contentView;
        public ImageView jIs;
        public TextView mVG;
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
            View inflate = LayoutInflater.from(context).inflate(R.i.diY, viewGroup, false);
            a aVar = new a();
            aVar.mVG = (TextView) inflate.findViewById(R.h.cSc);
            aVar.jIs = (ImageView) inflate.findViewById(R.h.coQ);
            aVar.mVw = inflate.findViewById(R.h.cCr);
            aVar.contentView = inflate.findViewById(R.h.cJR);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
            a aVar2 = (a) aVar;
            h hVar = (h) bVar;
            cm(aVar2.contentView);
            aVar2.mVG.setText(hVar.qkk);
            aVar2.jIs.setImageResource(R.k.dyR);
            if (h.this.position == 0 || !h.this.qkj) {
                aVar2.mVw.setVisibility(8);
            } else {
                aVar2.mVw.setVisibility(0);
            }
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
            Intent intent = new Intent();
            intent.putExtra("key_talker_query", h.this.mRM.mRo[0]);
            intent.putExtra("key_query", h.this.mRM.mRo[1]);
            intent.putExtra("Search_Scene", h.this.mUl);
            if (bi.oN(h.this.mRD)) {
                d.b(context, "search", ".ui.FTSTalkerMessageUI", intent);
            } else {
                intent.putExtra("key_conv", h.this.mRD);
                intent.putExtra("detail_type", 1);
                d.b(context, "search", ".ui.FTSConvTalkerMessageUI", intent);
            }
            return true;
        }
    }

    public h(int i) {
        super(19, i);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, Object... objArr) {
        CharSequence ellipsize = TextUtils.ellipsize(this.mRM.mRo[0], com.tencent.mm.plugin.fts.d.d.b.mUv, 200.0f, TruncateAt.MIDDLE);
        CharSequence ellipsize2 = TextUtils.ellipsize(this.mRM.mRo[1], com.tencent.mm.plugin.fts.d.d.b.mUv, 400.0f, TruncateAt.MIDDLE);
        if (bi.oN(this.mRD)) {
            this.qkk = TextUtils.concat(new CharSequence[]{context.getString(R.l.eJn), f.b(ellipsize, ellipsize.length()), context.getString(R.l.eJo), f.b(ellipsize2, ellipsize2.length()), context.getString(R.l.eJp)});
            return;
        }
        this.qkk = TextUtils.concat(new CharSequence[]{context.getString(R.l.eJq), f.b(ellipsize, ellipsize.length()), context.getString(R.l.eJo), f.b(ellipsize2, ellipsize2.length()), context.getString(R.l.eJp)});
    }

    public final com.tencent.mm.plugin.fts.d.a.b.b adG() {
        return this.qkl;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b.a adH() {
        return this.qkm;
    }
}
