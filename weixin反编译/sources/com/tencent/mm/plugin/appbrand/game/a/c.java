package com.tencent.mm.plugin.appbrand.game.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.sdk.platformtools.bi;

public final class c extends com.tencent.mm.plugin.fts.d.a.b {
    public j iZi;
    public CharSequence iZk;
    public k jbh;
    public com.tencent.mm.plugin.appbrand.game.a.a.b jbi;
    private b jbj = new b();
    a jbk = new a();

    public class a extends com.tencent.mm.plugin.fts.d.a.b.a {
        public View contentView;
        public TextView iZn;
        public TextView iZo;
        public ImageView ikK;
        public TextView ikL;
        public TextView jbl;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.plugin.fts.d.a.b.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(h.iAf, viewGroup, false);
            a aVar = c.this.jbk;
            aVar.ikK = (ImageView) inflate.findViewById(g.bLM);
            aVar.ikL = (TextView) inflate.findViewById(g.cSB);
            aVar.contentView = inflate.findViewById(g.cJR);
            aVar.iZn = (TextView) inflate.findViewById(g.iyN);
            aVar.jbl = (TextView) inflate.findViewById(g.caU);
            aVar.iZo = (TextView) inflate.findViewById(g.iyW);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
            c cVar = (c) bVar;
            a aVar2 = (a) aVar;
            if (cVar.jbi == null) {
                aVar2.contentView.setVisibility(8);
                return;
            }
            aVar2.contentView.setVisibility(0);
            aVar2.ikL.setText(c.this.iZk);
            aVar2.iZo.setVisibility(8);
            aVar2.jbl.setVisibility(8);
            aVar2.iZn.setVisibility(8);
            CharSequence jx;
            if (cVar.jbh != null) {
                jx = com.tencent.mm.plugin.appbrand.appcache.a.jx(cVar.jbh.iIZ);
                if (bi.oN(jx)) {
                    aVar2.iZo.setVisibility(8);
                } else {
                    aVar2.iZo.setText(jx);
                    aVar2.iZo.setVisibility(0);
                }
            } else {
                jx = cVar.jbi.field_BriefIntro;
                if (bi.oN(jx)) {
                    aVar2.jbl.setVisibility(8);
                } else {
                    aVar2.jbl.setText(jx);
                    aVar2.jbl.setVisibility(0);
                }
            }
            com.tencent.mm.modelappbrand.a.b.Jp().a(aVar2.ikK, cVar.jbi.field_IconUrl, com.tencent.mm.modelappbrand.a.a.Jo(), f.hmb);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
            c cVar = (c) bVar;
            com.tencent.mm.sdk.b.b qrVar = new qr();
            qrVar.fJd.userName = cVar.jbi.field_UserName;
            qrVar.fJd.fJg = 0;
            if (cVar.jbh != null) {
                qrVar.fJd.fJg = cVar.jbh.iIZ;
            }
            qrVar.fJd.fJj = true;
            qrVar.fJd.scene = 1027;
            com.tencent.mm.sdk.b.a.xmy.m(qrVar);
            return true;
        }
    }

    public c(int i) {
        super(20, i);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, Object... objArr) {
        boolean z = true;
        boolean z2 = false;
        this.jbh = i.se(this.iZi.mRd);
        this.jbi = i.sd(this.iZi.mRd);
        if (this.jbi != null) {
            switch (this.iZi.mRc) {
                case 2:
                    break;
                case 3:
                    z2 = true;
                    break;
                default:
                    z = false;
                    break;
            }
            this.iZk = com.tencent.mm.plugin.fts.d.f.a(com.tencent.mm.plugin.fts.d.b.a.a(this.jbi.field_AppName, this.mRM, z, z2)).mVW;
            this.info = this.jbi.field_AppId;
        }
    }

    public final com.tencent.mm.plugin.fts.d.a.b.b adG() {
        return this.jbj;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b.a adH() {
        return this.jbk;
    }

    public final String adI() {
        if (this.jbi == null) {
            return ":";
        }
        return String.format("%s:%s", new Object[]{this.jbi.field_AppId, this.jbi.field_AppName});
    }

    public final int adJ() {
        return this.iZi.mRZ;
    }
}
