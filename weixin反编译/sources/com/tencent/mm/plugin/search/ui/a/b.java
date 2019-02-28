package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.storage.x;

public abstract class b extends com.tencent.mm.plugin.fts.d.a.b {
    public j iZi;
    public x jQP;
    public CharSequence kNg;
    public CharSequence kNh;
    public String qjG;
    a qjH = new a();
    public String username;

    public class a extends com.tencent.mm.plugin.fts.d.a.b.a {
        public View contentView;
        public ImageView ikK;
        public TextView ikL;
        public TextView ikM;
        TextView qjI;

        public a() {
            super();
        }
    }

    public abstract class b extends com.tencent.mm.plugin.fts.d.a.b.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.diU, viewGroup, false);
            a aVar = b.this.qjH;
            aVar.ikK = (ImageView) inflate.findViewById(R.h.bLM);
            aVar.ikL = (TextView) inflate.findViewById(R.h.cSB);
            aVar.ikM = (TextView) inflate.findViewById(R.h.caU);
            aVar.qjI = (TextView) inflate.findViewById(R.h.cry);
            aVar.contentView = inflate.findViewById(R.h.cJR);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
            a aVar2 = (a) aVar;
            b bVar2 = (b) bVar;
            cm(aVar2.contentView);
            com.tencent.mm.pluginsdk.ui.a.b.a(aVar2.ikK, bVar2.username);
            e.a(bVar2.kNg, aVar2.ikL);
            e.a(bVar2.kNh, aVar2.ikM);
            e.a(bVar2.qjG, aVar2.qjI);
        }
    }

    public b(int i) {
        super(1, i);
    }

    protected final com.tencent.mm.plugin.fts.d.a.b.a adH() {
        return this.qjH;
    }

    public final int adJ() {
        return this.iZi.mRZ;
    }
}
