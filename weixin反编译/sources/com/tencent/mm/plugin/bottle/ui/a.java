package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.o;
import com.tencent.mm.y.as;

final class a extends o<ae> implements b {
    private final MMActivity fnF;
    protected f kHo;
    protected c kHp;
    protected e kHq;
    protected d kHr = MMSlideDelView.cql();

    public static class a {
        public ImageView ikK;
        public TextView kHt;
        public TextView kHu;
        public TextView kHv;
        public ImageView kHw;
        public TextView kHx;
        public View kHy;
        public TextView kHz;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        ae aeVar = (ae) obj;
        if (aeVar == null) {
            aeVar = new ae();
        }
        aeVar.dH("");
        aeVar.dI("");
        aeVar.b(cursor);
        return aeVar;
    }

    public a(Context context, com.tencent.mm.ui.o.a aVar) {
        super(context, new ae());
        this.xQN = aVar;
        this.fnF = (MMActivity) context;
    }

    public final void XH() {
        as.Hm();
        setCursor(com.tencent.mm.y.c.Fk().cjv());
        if (this.xQN != null) {
            this.xQN.XE();
        }
        super.notifyDataSetChanged();
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final void a(f fVar) {
        this.kHo = fVar;
    }

    public final void a(e eVar) {
        this.kHq = eVar;
    }

    public final void a(c cVar) {
        this.kHp = cVar;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void onPause() {
        if (this.kHr != null) {
            this.kHr.aVf();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int i2;
        ae aeVar = (ae) getItem(i);
        if (view == null) {
            a aVar2 = new a();
            View view2 = (MMSlideDelView) View.inflate(this.fnF, R.i.dbe, null);
            View inflate = View.inflate(this.fnF, R.i.dtk, null);
            aVar2.ikK = (ImageView) inflate.findViewById(R.h.bLM);
            aVar2.kHt = (TextView) inflate.findViewById(R.h.cAs);
            aVar2.kHu = (TextView) inflate.findViewById(R.h.cTY);
            aVar2.kHv = (TextView) inflate.findViewById(R.h.csB);
            aVar2.kHw = (ImageView) inflate.findViewById(R.h.cPr);
            aVar2.kHx = (TextView) inflate.findViewById(R.h.cSe);
            aVar2.kHy = view2.findViewById(R.h.cOJ);
            aVar2.kHz = (TextView) view2.findViewById(R.h.cOK);
            view2.setView(inflate);
            view2.kHo = this.kHo;
            view2.kHp = this.kHp;
            view2.kHr = this.kHr;
            view2.mGx = false;
            view2.setTag(aVar2);
            aVar = aVar2;
            view = view2;
        } else {
            aVar = (a) view.getTag();
        }
        as.Hm();
        aVar.kHt.setText(A(com.tencent.mm.y.c.Ff().Xv(aeVar.field_username)));
        aVar.kHu.setText(aeVar.field_status == 1 ? this.fnF.getString(R.l.euN) : n.c(this.fnF, aeVar.field_conversationTime, true));
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.ikK, x.Xk(aeVar.field_username));
        as.Hm();
        aVar.kHv.setText(i.b(this.fnF, com.tencent.mm.y.c.Fk().ux().a(aeVar.field_isSend, aeVar.field_username, aeVar.field_content, wv(aeVar.field_msgType), this.fnF), aVar.kHv.getTextSize()));
        aVar.kHv.setTextColor(com.tencent.mm.bu.a.Z(this.fnF, R.e.btk));
        if (wv(aeVar.field_msgType) == 34 && aeVar.field_isSend == 0 && !bi.oN(aeVar.field_content) && !new com.tencent.mm.modelvoice.n(aeVar.field_content).hXo) {
            aVar.kHv.setTextColor(com.tencent.mm.bu.a.Z(this.fnF, R.e.btl));
        }
        switch (aeVar.field_status) {
            case 0:
                i2 = -1;
                break;
            case 1:
                i2 = R.k.dzp;
                break;
            case 2:
                i2 = -1;
                break;
            case 5:
                i2 = R.k.dzo;
                break;
            default:
                i2 = -1;
                break;
        }
        if (i2 != -1) {
            aVar.kHw.setBackgroundResource(i2);
            aVar.kHw.setVisibility(0);
        } else {
            aVar.kHw.setVisibility(8);
        }
        aVar.kHy.setTag(aeVar.field_username);
        aVar.kHy.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.sdk.platformtools.x.v("MicroMsg.BottleConversationAdapter", "on delView clicked");
                a.this.kHr.aVg();
                if (a.this.kHq != null) {
                    a.this.kHq.bp(view.getTag());
                }
            }
        });
        i2 = view.getPaddingBottom();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingLeft = view.getPaddingLeft();
        if (aeVar.field_unReadCount > 100) {
            aVar.kHx.setText("...");
            aVar.kHx.setVisibility(0);
            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.BottleConversationAdapter", "has unread 100");
        } else if (aeVar.field_unReadCount > 0) {
            aVar.kHx.setText(aeVar.field_unReadCount);
            aVar.kHx.setVisibility(0);
            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.BottleConversationAdapter", "has unread");
        } else {
            aVar.kHx.setVisibility(4);
            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.BottleConversationAdapter", "no unread");
        }
        view.setBackgroundResource(R.g.bDI);
        view.setPadding(paddingLeft, paddingTop, paddingRight, i2);
        return view;
    }

    final String A(x xVar) {
        return com.tencent.mm.plugin.bottle.a.c.a(this.fnF, xVar);
    }

    private static int wv(String str) {
        int i = 1;
        if (str == null || str.length() <= 0) {
            return i;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException e) {
            return i;
        }
    }

    protected final void XI() {
        XH();
    }
}
