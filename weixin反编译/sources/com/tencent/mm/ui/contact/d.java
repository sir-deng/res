package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.o;
import com.tencent.mm.y.as;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import java.util.List;

public final class d extends o<x> {
    protected MMActivity fnF;
    b hxF = null;
    private b.b hxG = null;
    protected f kHo;
    protected c kHp;
    protected com.tencent.mm.ui.base.MMSlideDelView.d kHr = MMSlideDelView.cql();
    protected List<String> koG = null;
    protected e oUV;
    com.tencent.mm.pluginsdk.ui.d vuA;
    protected String yYA = null;

    protected static class a {
        public TextView kKL;
        public MaskLayout lji;
        public TextView nOK;
        public ViewGroup zak;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        as.Hm();
        Object Xq = com.tencent.mm.y.c.Ff().Xq(x.k(cursor));
        if (Xq != null) {
            return Xq;
        }
        x xVar = new x();
        xVar.b(cursor);
        as.Hm();
        com.tencent.mm.y.c.Ff().P(xVar);
        return xVar;
    }

    public d(Context context, String str) {
        super(context, new x());
        this.fnF = (MMActivity) context;
        this.yYA = str;
        this.hxF = new b(new com.tencent.mm.ui.applet.b.a() {
            public final Bitmap la(String str) {
                return com.tencent.mm.ac.b.a(str, false, -1);
            }
        });
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

    public final int getCount() {
        return getCursor().getCount();
    }

    protected final void XI() {
        XH();
    }

    public final synchronized void XH() {
        as.Hm();
        Cursor b = com.tencent.mm.y.c.Ff().b(this.yYA, "", this.koG);
        aUU();
        setCursor(b);
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.hxG == null) {
            this.hxG = new b.b() {
                public final String hF(int i) {
                    if (i < 0 || i >= d.this.getCount()) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomContactAdapter", "pos is invalid");
                        return null;
                    }
                    x xVar = (x) d.this.getItem(i);
                    return xVar == null ? null : xVar.field_username;
                }

                public final int NP() {
                    return d.this.getCount();
                }
            };
        }
        if (this.hxF != null) {
            this.hxF.a(i, this.hxG);
        }
        if (view == null) {
            view = View.inflate(this.fnF, R.i.dcT, null);
            a aVar2 = new a();
            aVar2.nOK = (TextView) view.findViewById(R.h.bYB);
            aVar2.lji = (MaskLayout) view.findViewById(R.h.bYz);
            aVar2.kKL = (TextView) view.findViewById(R.h.bYD);
            aVar2.zak = (ViewGroup) view.findViewById(R.h.bYC);
            LayoutParams layoutParams = aVar2.zak.getLayoutParams();
            layoutParams.height = (int) (((float) com.tencent.mm.bu.a.ab(this.fnF, R.f.buB)) * com.tencent.mm.bu.a.ey(this.fnF));
            aVar2.zak.setLayoutParams(layoutParams);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        x xVar = (x) getItem(i - 1);
        int i2 = xVar == null ? -1 : xVar.field_showHead;
        xVar = (x) getItem(i);
        if (i == 0) {
            CharSequence Y = Y(xVar);
            if (t.oN(Y)) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", xVar.field_username, Integer.valueOf(i));
                aVar.nOK.setVisibility(8);
            } else {
                aVar.nOK.setVisibility(0);
                aVar.nOK.setText(Y);
                aVar.nOK.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            if (getItem(i + 1) == null) {
                aVar.zak.setBackgroundResource(0);
            }
        } else if (i <= 0 || xVar.field_showHead == i2) {
            aVar.nOK.setVisibility(8);
            a(aVar, i, i2);
        } else {
            CharSequence Y2 = Y(xVar);
            aVar.zak.setBackgroundResource(R.g.bBy);
            if (t.oN(Y2)) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", xVar.field_username, Integer.valueOf(i));
                aVar.nOK.setVisibility(8);
            } else {
                aVar.nOK.setVisibility(0);
                aVar.nOK.setText(Y2);
                if (xVar.field_showHead == 32) {
                    aVar.nOK.setCompoundDrawablesWithIntrinsicBounds(R.g.bDG, 0, 0, 0);
                    aVar.nOK.setCompoundDrawablePadding(2);
                } else {
                    aVar.nOK.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
            }
            a(aVar, i, i2);
        }
        aVar.kKL.setTextColor(com.tencent.mm.bu.a.Z(this.fnF, !s.hq(xVar.field_username) ? R.e.bth : R.e.bti));
        ImageView imageView = (ImageView) aVar.lji.view;
        com.tencent.mm.pluginsdk.ui.a.b.a(imageView, xVar.field_username);
        com.tencent.mm.pluginsdk.ui.a aVar3 = (com.tencent.mm.pluginsdk.ui.a) imageView.getDrawable();
        if (this.vuA != null) {
            this.vuA.a(aVar3);
        }
        aVar.lji.cqE();
        try {
            aVar.kKL.setText(i.c(this.fnF, r.gw(xVar.field_username), (int) aVar.kKL.getTextSize()));
        } catch (Exception e) {
            aVar.kKL.setText("");
        }
        return view;
    }

    private void a(a aVar, int i, int i2) {
        x xVar = (x) getItem(i + 1);
        if (xVar == null || !(xVar.field_showHead == i2 || t.oN(Y(xVar)))) {
            aVar.zak.setBackgroundResource(0);
        }
    }

    private String Y(x xVar) {
        if (xVar.field_showHead == 31) {
            return "";
        }
        if (xVar.field_showHead == 43) {
            return this.fnF.getString(R.l.eFK);
        }
        return String.valueOf((char) xVar.field_showHead);
    }
}
