package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.fts.d.f;

public final class i extends com.tencent.mm.plugin.fts.d.a.b {
    public int actionType = -1;
    public j iZi;
    public CharSequence muA;
    public String muD;
    public CharSequence qko;
    public String qkp;
    public c qkq;
    private b qkr = new b();
    a qks = new a();

    public class a extends com.tencent.mm.plugin.fts.d.a.b.a {
        public View contentView;
        public ImageView ikK;
        public TextView ikL;
        public TextView ikM;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.plugin.fts.d.a.b.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.diU, viewGroup, false);
            a aVar = i.this.qks;
            aVar.ikK = (ImageView) inflate.findViewById(R.h.bLM);
            aVar.ikL = (TextView) inflate.findViewById(R.h.cSB);
            aVar.ikM = (TextView) inflate.findViewById(R.h.caU);
            aVar.contentView = inflate.findViewById(R.h.cJR);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
            a aVar2 = (a) aVar;
            i iVar = (i) bVar;
            cm(aVar2.contentView);
            e.a(i.this.muA, aVar2.ikL);
            e.a(i.this.qko, aVar2.ikM);
            e.a(context, aVar2.ikK, null, iVar.muD, R.k.dyQ);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
            i iVar = (i) bVar;
            com.tencent.mm.plugin.fts.d.a.b.b.a(i.this.mRM.mRl, iVar.iZi);
            if (!((com.tencent.mm.plugin.appbrand.n.e) g.h(com.tencent.mm.plugin.appbrand.n.e.class)).tG(iVar.qkq.field_url)) {
                Intent intent;
                if (iVar.qkq.field_actionType == 2) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", iVar.qkq.field_url);
                    d.b(context, "webview", ".ui.tools.WebViewUI", intent);
                } else if (!com.tencent.mm.plugin.search.a.a.K(context, iVar.qkq.field_featureId)) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", iVar.qkq.field_updateUrl);
                    d.b(context, "webview", ".ui.tools.WebViewUI", intent);
                }
            }
            return true;
        }
    }

    public i(int i) {
        super(3, i);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, Object... objArr) {
        boolean z = true;
        this.qkq = (c) this.iZi.userData;
        if (this.qkq != null) {
            boolean z2;
            this.muA = this.qkq.field_title;
            this.qko = this.qkq.field_tag;
            this.muD = this.qkq.field_iconPath;
            this.qkp = this.qkq.field_androidUrl;
            this.actionType = this.qkq.field_actionType;
            switch (this.iZi.mRc) {
                case 1:
                    z = false;
                    z2 = false;
                    break;
                case 2:
                    z2 = false;
                    break;
                case 3:
                    z2 = true;
                    break;
                case 4:
                    this.qko = f.a(com.tencent.mm.plugin.fts.d.b.a.a(this.qko, this.mRM)).mVW;
                    return;
                default:
                    return;
            }
            this.muA = f.a(com.tencent.mm.plugin.fts.d.b.a.a(this.muA, this.mRM, z, z2)).mVW;
        }
    }

    public final com.tencent.mm.plugin.fts.d.a.b.b adG() {
        return this.qkr;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b.a adH() {
        return this.qks;
    }

    public final String adI() {
        return this.qkq.field_title;
    }

    public final int adJ() {
        return this.iZi.mRZ;
    }
}
