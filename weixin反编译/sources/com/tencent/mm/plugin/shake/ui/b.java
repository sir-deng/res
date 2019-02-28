package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.be.j;
import com.tencent.mm.be.k;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.o;

final class b extends o<j> {
    private int asN = -1;
    private MMActivity fnF;
    protected f kHo;
    protected c kHp;
    protected d kHr = MMSlideDelView.cql();
    protected e oUV;
    private k qwl;

    static class a {
        TextView hxK;
        ImageView ikl;
        View kHy;
        TextView kHz;
        TextView otc;

        a() {
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        j jVar = (j) obj;
        if (jVar == null) {
            jVar = new j();
        }
        jVar.b(cursor);
        return jVar;
    }

    public b(Context context, k kVar, int i) {
        super(context, new j());
        this.fnF = (MMActivity) context;
        this.asN = i;
        this.qwl = kVar;
    }

    public final void a(f fVar) {
        this.kHo = fVar;
    }

    public final void a(e eVar) {
        this.oUV = eVar;
    }

    public final void a(c cVar) {
        this.kHp = cVar;
    }

    public final void wx(int i) {
        aUU();
        this.asN = i;
        XH();
    }

    protected final void XI() {
        XH();
    }

    public final void XH() {
        k kVar = this.qwl;
        setCursor(kVar.gLA.rawQuery("SELECT * FROM " + kVar.getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + this.asN, null));
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        j jVar = (j) getItem(i);
        if (view == null) {
            View view2 = (MMSlideDelView) View.inflate(this.fnF, R.i.dbe, null);
            a aVar2 = new a();
            View inflate = View.inflate(this.fnF, R.i.drc, null);
            aVar2.ikl = (ImageView) inflate.findViewById(R.h.bYA);
            aVar2.hxK = (TextView) inflate.findViewById(R.h.cci);
            aVar2.otc = (TextView) inflate.findViewById(R.h.cIR);
            aVar2.kHy = view2.findViewById(R.h.cOJ);
            aVar2.kHz = (TextView) view2.findViewById(R.h.cOK);
            view2.setView(inflate);
            view2.kHo = this.kHo;
            view2.kHp = this.kHp;
            view2.kHr = this.kHr;
            view2.mGx = false;
            view2.setTag(aVar2);
            view = view2;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.kHy.setTag(Long.valueOf(jVar.field_svrid));
        aVar.kHy.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.v("MicroMsg.SayHiAdapter", "on delView clicked");
                b.this.kHr.aVg();
                if (b.this.oUV != null) {
                    b.this.oUV.bp(view.getTag());
                }
            }
        });
        aVar.hxK.setText(i.b(this.fnF, au.d.Yb(jVar.field_content).getDisplayName(), aVar.hxK.getTextSize()));
        aVar.otc.setText(jVar.field_sayhicontent);
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.ikl, jVar.field_sayhiuser);
        return view;
    }
}
