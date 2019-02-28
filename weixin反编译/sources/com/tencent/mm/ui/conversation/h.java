package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.h.m;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.o;
import com.tencent.mm.y.as;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import java.util.HashMap;
import java.util.Map.Entry;

public final class h extends o<ae> implements com.tencent.mm.sdk.e.m.b {
    private static long zfX = 2000;
    private String fDP;
    protected f kHo;
    protected c kHp;
    protected e kHq;
    protected d kHr = MMSlideDelView.cql();
    private float yvV = -1.0f;
    private float yvW = -1.0f;
    private float yvX = -1.0f;
    HashMap<String, a> yvZ;
    private boolean zfL = false;
    private boolean zfM = false;
    public String zfS = "";
    private final int zfU;
    private final int zfV;
    private boolean zfY = false;
    al zfZ = new al(as.Dt().oFY.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            if (h.this.zfY) {
                h.this.cxj();
            }
            return false;
        }
    }, false);
    private ColorStateList[] zhY = new ColorStateList[5];

    private class a {
        public int kZv;
        public CharSequence nickName;
        public boolean vmD;
        public boolean ywa;
        public CharSequence zgd;
        public CharSequence zge;
        public int zgf;
        public int zgg;
        public boolean zgj;
        public boolean zgl;
        public boolean zgn;
        public int zgo;
        public boolean zia;

        private a() {
        }

        /* synthetic */ a(h hVar, byte b) {
            this();
        }
    }

    public static class b {
        public ImageView ikK;
        public ImageView ywg;
        public View ywi;
        public NoMeasuredTextView zib;
        public NoMeasuredTextView zic;
        public NoMeasuredTextView zid;
        public TextView zie;
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

    public h(Context context, String str, com.tencent.mm.ui.o.a aVar) {
        super(context, new ae());
        this.xQN = aVar;
        this.fDP = str;
        this.yvZ = new HashMap();
        this.zhY[0] = com.tencent.mm.bu.a.Z(context, R.e.bsO);
        this.zhY[1] = com.tencent.mm.bu.a.Z(context, R.e.btl);
        this.zhY[3] = com.tencent.mm.bu.a.Z(context, R.e.btv);
        this.zhY[2] = com.tencent.mm.bu.a.Z(context, R.e.btj);
        this.zhY[2] = com.tencent.mm.bu.a.Z(context, R.e.btj);
        this.zhY[4] = com.tencent.mm.bu.a.Z(context, R.e.btb);
        if (com.tencent.mm.bu.a.ez(context)) {
            this.zfV = context.getResources().getDimensionPixelSize(R.f.buD);
            this.zfU = context.getResources().getDimensionPixelSize(R.f.buE);
        } else {
            this.zfV = context.getResources().getDimensionPixelSize(R.f.buC);
            this.zfU = context.getResources().getDimensionPixelSize(R.f.buF);
        }
        this.yvV = (float) com.tencent.mm.bu.a.aa(context, R.f.bvL);
        this.yvW = (float) com.tencent.mm.bu.a.aa(context, R.f.bvt);
        this.yvX = (float) com.tencent.mm.bu.a.aa(context, R.f.bvX);
        as.Hm();
        com.tencent.mm.y.c.Fk().a(this);
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

    public final void onPause() {
        if (this.kHr != null) {
            this.kHr.aVf();
        }
        this.zfL = false;
    }

    public final void onResume() {
        boolean z = true;
        this.zfL = true;
        Time time = new Time();
        time.setToNow();
        String charSequence = m.a("MM/dd", time).toString();
        if (this.zfS.equals(charSequence)) {
            z = false;
        }
        this.zfS = charSequence;
        if (z) {
            cxi();
        }
        if (this.zfM) {
            super.a(null, null);
            this.zfM = false;
        }
    }

    protected final void XI() {
        XH();
    }

    public final void XH() {
        aUU();
        as.Hm();
        setCursor(com.tencent.mm.y.c.Fk().c(s.hgU, null, this.fDP));
        if (this.xQN != null) {
            this.xQN.XE();
        }
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        View inflate;
        int i2;
        a aVar;
        ae aeVar = (ae) getItem(i);
        String str = aeVar.field_username;
        b bVar2 = null;
        if (view != null) {
            bVar2 = (b) view.getTag();
        }
        if (view == null || bVar2 == null) {
            bVar = new b();
            if (com.tencent.mm.bu.a.ez(this.context)) {
                inflate = View.inflate(this.context, R.i.dfi, null);
            } else {
                inflate = View.inflate(this.context, R.i.dfh, null);
            }
            bVar.ikK = (ImageView) inflate.findViewById(R.h.bLM);
            bVar.zib = (NoMeasuredTextView) inflate.findViewById(R.h.cAs);
            bVar.zib.O(this.yvV);
            bVar.zib.setTextColor(this.zhY[3]);
            bVar.zib.yoG = true;
            bVar.zic = (NoMeasuredTextView) inflate.findViewById(R.h.cTY);
            bVar.zic.O(this.yvX);
            bVar.zic.setTextColor(this.zhY[4]);
            bVar.zic.yoG = false;
            bVar.zic.En();
            bVar.zid = (NoMeasuredTextView) inflate.findViewById(R.h.csB);
            bVar.zid.O(this.yvW);
            bVar.zid.setTextColor(this.zhY[0]);
            bVar.zid.yoG = true;
            bVar.zie = (TextView) inflate.findViewById(R.h.cSe);
            bVar.zie.setBackgroundResource(com.tencent.mm.ui.tools.s.ge(this.context));
            bVar.ywg = (ImageView) inflate.findViewById(R.h.cpv);
            bVar.ywi = inflate.findViewById(R.h.bLP);
            inflate.findViewById(R.h.cQF).setVisibility(8);
            inflate.findViewById(R.h.cuf).setVisibility(8);
            inflate.setTag(bVar);
        } else {
            bVar = bVar2;
            inflate = view;
        }
        a aVar2 = (a) this.yvZ.get(str);
        as.Hm();
        com.tencent.mm.k.a Xv = com.tencent.mm.y.c.Ff().Xv(str);
        if (aVar2 == null) {
            a aVar3 = new a();
            if (Xv != null) {
                aVar3.zgg = (int) Xv.gKO;
            } else {
                aVar3.zgg = -1;
            }
            aVar3.zgl = Xv != null;
            boolean z = Xv != null && Xv.AQ();
            aVar3.zgn = z;
            z = Xv != null && Xv.AP();
            aVar3.zgj = z;
            aVar3.zia = aeVar.field_unReadCount > 0;
            aVar3.kZv = 0;
            if (j(aeVar) == 34 && aeVar.field_isSend == 0 && !t.oN(aeVar.field_content) && !new n(aeVar.field_content).hXo) {
                aVar3.kZv = 1;
            }
            aVar3.nickName = i.b(this.context, r.a(Xv, str, false), bVar.zib.gu.getTextSize());
            aVar3.zgd = h(aeVar);
            int textSize = (int) bVar.zid.gu.getTextSize();
            z = aVar3.zgj && aVar3.zia;
            aVar3.zge = c(aeVar, textSize, z);
            aVar3.zgo = aeVar.field_attrflag;
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
            aVar3.zgf = i2;
            as.Hm();
            aVar3.ywa = com.tencent.mm.y.c.Fk().g(aeVar);
            aVar3.vmD = w.cfR();
            this.yvZ.put(str, aVar3);
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        if (aVar.zgd == null) {
            aVar.zgd = h(aeVar);
        }
        if (aVar.zgj && aVar.zia) {
            bVar.zid.setTextColor(this.zhY[0]);
        } else {
            bVar.zid.setTextColor(this.zhY[aVar.kZv]);
        }
        com.tencent.mm.booter.notification.a.h.fv(bVar.zid.getWidth());
        com.tencent.mm.booter.notification.a.h.fw((int) bVar.zid.gu.getTextSize());
        com.tencent.mm.booter.notification.a.h.a(bVar.zid.gu);
        if (aVar.zgf != -1) {
            bVar.zid.Fl(aVar.zgf);
            bVar.zid.mA(true);
        } else {
            bVar.zid.mA(false);
        }
        bVar.zid.setText(aVar.zge);
        bVar.zib.mB(false);
        bVar.zib.setText(aVar.nickName);
        LayoutParams layoutParams = bVar.zic.getLayoutParams();
        if (aVar.zgd.length() > 9) {
            if (layoutParams.width != this.zfV) {
                layoutParams.width = this.zfV;
                bVar.zic.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.zfU) {
            layoutParams.width = this.zfU;
            bVar.zic.setLayoutParams(layoutParams);
        }
        bVar.zic.setText(aVar.zgd);
        if (aVar.zgj) {
            bVar.ywg.setVisibility(0);
        } else {
            bVar.ywg.setVisibility(8);
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(bVar.ikK, str);
        bVar.zie.setVisibility(4);
        bVar.ywi.setVisibility(4);
        if (aVar.zgl && aVar.zgg != 0) {
            i2 = aeVar.field_unReadCount;
            if (aVar.zgj) {
                View view2 = bVar.ywi;
                if (i2 > 0) {
                    i2 = 0;
                } else {
                    i2 = 4;
                }
                view2.setVisibility(i2);
            } else if (i2 > 99) {
                bVar.zie.setText(R.l.eSf);
                bVar.zie.setVisibility(0);
            } else if (i2 > 0) {
                bVar.zie.setText(String.valueOf(i2));
                bVar.zie.setVisibility(0);
            }
        }
        if (!aVar.ywa || aeVar.field_conversationTime == -1) {
            inflate.findViewById(R.h.bYZ).setBackgroundResource(R.g.bBy);
        } else {
            inflate.findViewById(R.h.bYZ).setBackgroundResource(R.g.bBx);
        }
        a.xVN.a(inflate, String.valueOf(aVar.nickName), aeVar.field_unReadCount, String.valueOf(aVar.zgd), String.valueOf(aVar.zge));
        return inflate;
    }

    private static int j(ae aeVar) {
        int i = 1;
        String str = aeVar.field_msgType;
        if (str == null || str.length() <= 0) {
            return i;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException e) {
            return i;
        }
    }

    private CharSequence c(ae aeVar, int i, boolean z) {
        CharSequence replace;
        if (t.oN(aeVar.field_editingMsg) || (aeVar.field_atCount > 0 && aeVar.field_unReadCount > 0)) {
            CharSequence charSequence = aeVar.field_digest;
            if (charSequence != null && charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                return new SpannableString(i.e(this.context, charSequence, (float) i));
            }
            String str;
            if (j(aeVar) == 47 || j(aeVar) == 1048625) {
                String ZD = ZD(aeVar.field_digest);
                str = "";
                if (ZD != null) {
                    return "[" + ZD + "]";
                }
                if (aeVar.field_digest != null && aeVar.field_digest.contains(":")) {
                    str = aeVar.field_digest.substring(0, aeVar.field_digest.indexOf(":"));
                    ZD = ZD(aeVar.field_digest.substring(aeVar.field_digest.indexOf(":") + 1).replace(" ", ""));
                    if (ZD != null) {
                        ZD = "[" + ZD + "]";
                        return t.oN(str) ? ZD : str + ": " + ZD;
                    }
                }
                ZD = this.context.getString(R.l.dER);
                aeVar.dH(t.oN(str) ? ZD : str + ": " + ZD);
            }
            if (!t.oN(aeVar.field_digest)) {
                if (t.oN(aeVar.field_digestUser)) {
                    str = aeVar.field_digest;
                } else {
                    str = (aeVar.field_isSend == 0 && s.eX(aeVar.field_username)) ? r.L(aeVar.field_digestUser, aeVar.field_username) : r.gw(aeVar.field_digestUser);
                    try {
                        str = String.format(aeVar.field_digest, new Object[]{str});
                    } catch (Exception e) {
                    }
                }
                replace = str.replace(10, ' ');
                if (aeVar.field_atCount > 0 || aeVar.field_unReadCount <= 0) {
                    if (z && aeVar.field_unReadCount > 1) {
                        replace = this.context.getString(R.l.eut, new Object[]{Integer.valueOf(aeVar.field_unReadCount), replace});
                    }
                    return i.c(this.context, replace, i);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.context.getString(R.l.euq));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                spannableStringBuilder.append(" ").append(i.c(this.context, replace, i));
                return spannableStringBuilder;
            }
            str = com.tencent.mm.booter.notification.a.h.a(aeVar.field_isSend, aeVar.field_username, aeVar.field_content, j(aeVar), this.context);
            replace = str.replace(10, ' ');
            if (aeVar.field_atCount > 0) {
            }
            replace = this.context.getString(R.l.eut, new Object[]{Integer.valueOf(aeVar.field_unReadCount), replace});
            return i.c(this.context, replace, i);
        }
        replace = new SpannableStringBuilder(this.context.getString(R.l.euu));
        replace.setSpan(new ForegroundColorSpan(-5569532), 0, replace.length(), 33);
        replace.append(" ").append(i.c(this.context, aeVar.field_editingMsg, i));
        return replace;
    }

    private static String ZD(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yF(str);
    }

    private CharSequence h(ae aeVar) {
        if (aeVar.field_status == 1) {
            return this.context.getString(R.l.euN);
        }
        return aeVar.field_conversationTime == Long.MAX_VALUE ? "" : com.tencent.mm.pluginsdk.h.n.c(this.context, aeVar.field_conversationTime, true);
    }

    private void cxi() {
        if (this.yvZ != null) {
            for (Entry value : this.yvZ.entrySet()) {
                ((a) value.getValue()).zgd = null;
            }
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.e("MicroMsg.EnterpriseConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
            return;
        }
        a((String) obj, null);
    }

    public final void a(String str, l lVar) {
        x.i("MicroMsg.EnterpriseConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", Boolean.valueOf(this.zfL), Boolean.valueOf(this.zfM), str);
        if (!(t.oN(str) || this.yvZ == null)) {
            this.yvZ.remove(str);
        }
        if (this.zfL) {
            x.d("MicroMsg.EnterpriseConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", Boolean.valueOf(this.zfY), Boolean.valueOf(this.zfZ.cgx()));
            this.zfY = true;
            if (this.zfZ.cgx()) {
                cxj();
                return;
            }
            return;
        }
        this.zfM = true;
    }

    private void cxj() {
        ah.y(new Runnable() {
            public final void run() {
                if (as.Hp()) {
                    long Wy = t.Wy();
                    super.a(null, null);
                    x.d("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", Long.valueOf(t.bA(Wy) * 3), Long.valueOf(h.zfX), Boolean.valueOf(h.this.zfY));
                    h.zfX = (Wy + h.zfX) / 2;
                    h.this.zfY = false;
                    al c = h.this.zfZ;
                    long cxw = h.zfX;
                    c.K(cxw, cxw);
                    return;
                }
                h.this.zfZ.TN();
                x.e("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange acc has not ready");
            }
        });
    }
}
