package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.af.m;
import com.tencent.mm.bx.d;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.contact.f;
import com.tencent.mm.ui.o;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.r;
import java.util.List;

public final class a extends o<f> {
    public static final ColorStateList nUY = com.tencent.mm.bu.a.Z(ad.getContext(), R.e.bth);
    public static final ColorStateList nUZ = com.tencent.mm.bu.a.Z(ad.getContext(), R.e.bsO);
    List<String> nVa;

    protected static class a {
        public AddressView nVd;

        public a(View view) {
            this.nVd = (AddressView) view.findViewById(R.h.cyE);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return sc(i);
    }

    public a(Context context) {
        super(context, new f());
    }

    public final int getCount() {
        return super.getCount();
    }

    public final f sc(int i) {
        if (rq(i)) {
            return (f) aSn();
        }
        f fVar;
        if (this.xQM != null) {
            fVar = (f) this.xQM.get(Integer.valueOf(i));
            if (fVar != null) {
                return fVar;
            }
        }
        if (i < 0 || !getCursor().moveToPosition(i)) {
            return null;
        }
        fVar = a(null, getCursor());
        if (this.xQM == null) {
            mb(true);
        }
        if (this.xQM == null) {
            return fVar;
        }
        this.xQM.put(Integer.valueOf(i), fVar);
        return fVar;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        String gQ;
        CharSequence charSequence = null;
        ag agVar = sc(i).jQP;
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.context, R.i.deX, null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        b.a(aVar.nVd, agVar.field_username);
        if (agVar.field_verifyFlag != 0) {
            gQ = com.tencent.mm.y.ak.a.hhx.gQ(agVar.field_verifyFlag);
            if (gQ != null) {
                aVar.nVd.setMaskBitmap(m.ki(gQ));
            } else {
                aVar.nVd.setMaskBitmap(null);
            }
        } else {
            aVar.nVd.setMaskBitmap(null);
        }
        if (agVar.field_deleteFlag == 1) {
            aVar.nVd.setNickNameTextColor(nUZ);
        } else {
            aVar.nVd.setNickNameTextColor(nUY);
        }
        aVar.nVd.updateTextColors();
        CharSequence charSequence2 = agVar.xuN;
        if (charSequence2 == null) {
            try {
                Context context = this.context;
                gQ = agVar.field_username;
                charSequence2 = r.gw(agVar.field_username);
                String str = "";
                if (str.length() > 0 && !str.equals(charSequence2)) {
                    StringBuilder stringBuilder = new StringBuilder(32);
                    stringBuilder.append(charSequence2);
                    stringBuilder.append("(");
                    stringBuilder.append(str);
                    stringBuilder.append(")");
                    charSequence2 = stringBuilder.toString();
                }
                charSequence = i.b(context, charSequence2, aVar.nVd.getNickNameSize());
            } catch (Exception e) {
            }
            if (charSequence == null) {
                charSequence = "";
            }
            aVar.nVd.setName(charSequence);
            agVar.xuN = charSequence;
        } else {
            aVar.nVd.setName(charSequence2);
        }
        aVar.nVd.updatePositionFlag();
        return view;
    }

    public final synchronized void XH() {
        Cursor clB;
        Object obj = Looper.myLooper() == Looper.getMainLooper() ? 1 : null;
        if (this.nVa == null || this.nVa.size() <= 0) {
            clB = d.clB();
        } else {
            as.Hm();
            clB = c.Ff().cM(this.nVa);
        }
        if (obj != null) {
            i(clB);
        } else {
            ah.y(new Runnable() {
                public final void run() {
                    a.this.i(clB);
                }
            });
        }
    }

    protected final void XI() {
        XH();
    }

    private static f a(f fVar, Cursor cursor) {
        if (fVar == null) {
            fVar = new f();
        }
        as.Hm();
        x Xq = c.Ff().Xq(x.k(cursor));
        if (Xq == null) {
            fVar.jQP.b(cursor);
            as.Hm();
            c.Ff().P(fVar.jQP);
        } else {
            fVar.jQP = Xq;
        }
        return fVar;
    }

    public final void i(Cursor cursor) {
        aUU();
        setCursor(cursor);
        notifyDataSetChanged();
    }
}
