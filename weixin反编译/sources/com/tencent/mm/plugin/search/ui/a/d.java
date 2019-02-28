package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.a.c;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.fts.d.j;
import com.tencent.mm.y.r;

public final class d extends c {
    public int count;
    private a qjN = new a();
    b qjO = new b();
    public String talker;

    public class a extends com.tencent.mm.plugin.fts.d.a.b.b {
        public a() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.diV, viewGroup, false);
            b bVar = d.this.qjO;
            bVar.lmd = (TextView) inflate.findViewById(com.tencent.mm.plugin.fts.d.j.d.coz);
            bVar.contentView = inflate.findViewById(com.tencent.mm.plugin.fts.d.j.d.cJR);
            bVar.mVw = inflate.findViewById(R.h.cCr);
            bVar.ikK = (ImageView) inflate.findViewById(R.h.bLM);
            inflate.setTag(bVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
            b bVar2 = (b) aVar;
            e.a(d.this.mVt, bVar2.lmd);
            bVar2.contentView.setBackgroundResource(j.c.bDr);
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar2.ikK, d.this.talker);
            if (d.this.position == 0) {
                bVar2.mVw.setVisibility(8);
            } else {
                bVar2.mVw.setVisibility(0);
            }
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
            return false;
        }
    }

    public class b extends com.tencent.mm.plugin.fts.d.a.b.a {
        public View contentView;
        public ImageView ikK;
        public TextView lmd;
        public View mVw;

        public b() {
            super();
        }
    }

    public d(int i) {
        super(i);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, Object... objArr) {
        CharSequence ellipsize = TextUtils.ellipsize(r.gw(this.talker), com.tencent.mm.plugin.fts.d.d.b.mUv, 500.0f, TruncateAt.MIDDLE);
        this.mVt = context.getString(R.l.eJm, new Object[]{ellipsize});
    }

    public final com.tencent.mm.plugin.fts.d.a.b.b adG() {
        return this.qjN;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b.a adH() {
        return this.qjO;
    }
}
