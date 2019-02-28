package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.MergeCursor;
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
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.f.a.rk;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.o;
import com.tencent.mm.y.as;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class d extends o<ae> implements com.tencent.mm.sdk.e.m.b {
    private static long zfX = 2000;
    private String inJ;
    protected com.tencent.mm.ui.base.MMSlideDelView.f kHo;
    protected com.tencent.mm.ui.base.MMSlideDelView.c kHp;
    protected com.tencent.mm.ui.base.MMSlideDelView.e kHq;
    protected com.tencent.mm.ui.base.MMSlideDelView.d kHr = MMSlideDelView.cql();
    protected List<String> koG = null;
    private boolean odb = false;
    boolean ryS = false;
    private float yvV = -1.0f;
    protected float yvW = -1.0f;
    private float yvX = -1.0f;
    private ColorStateList[] yvY = new ColorStateList[5];
    HashMap<String, d> yvZ;
    private boolean zfI = true;
    private f zfJ;
    private com.tencent.mm.pluginsdk.ui.d zfK;
    private boolean zfL = false;
    private boolean zfM = false;
    private boolean zfN = false;
    private boolean zfO = false;
    private c zfP;
    private com.tencent.mm.sdk.b.c zfQ = null;
    private b zfR = null;
    public String zfS = "";
    final e zfT = new e();
    private final int zfU;
    private final int zfV;
    private a zfW;
    private boolean zfY = false;
    private al zfZ = new al(as.Dt().oFY.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            if (d.this.zfY) {
                d.this.cxj();
            }
            return false;
        }
    }, false);

    private class a {
        public String bgo;
        public String content;
        public int zgb;
        public String zgc;

        private a() {
        }

        /* synthetic */ a(d dVar, byte b) {
            this();
        }
    }

    private class d {
        public int kZv;
        public CharSequence nickName;
        public boolean tYt;
        public boolean vmD;
        public boolean ywa;
        public CharSequence zgd;
        public CharSequence zge;
        public int zgf;
        public int zgg;
        public int zgh;
        public boolean zgi;
        public boolean zgj;
        public boolean zgk;
        public boolean zgl;
        public boolean zgm;
        public boolean zgn;
        public int zgo;

        private d() {
        }

        /* synthetic */ d(d dVar, byte b) {
            this();
        }
    }

    private class e {
        boolean initialized;
        x jQP;
        String talker;
        Integer zgp;

        public e() {
            this.initialized = false;
            this.talker = null;
            this.initialized = false;
            this.jQP = null;
            this.zgp = null;
        }
    }

    public interface f {
    }

    private class c implements com.tencent.mm.sdk.e.m.b {
        final /* synthetic */ d zga;

        public final void a(int i, m mVar, Object obj) {
            if (obj == null || !(obj instanceof String)) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
                return;
            }
            String str = (String) obj;
            if (!this.zga.zfL && str != null && !str.equals("") && this.zga.yvZ != null && this.zga.yvZ.containsKey(Integer.valueOf(i))) {
                this.zga.yvZ.remove(Integer.valueOf(i));
                this.zga.zfO = true;
            }
        }
    }

    public interface b {
    }

    public static class g {
        public ImageView ikK;
        public TextView kHx;
        public NoMeasuredTextView ywd;
        public NoMeasuredTextView ywe;
        public NoMeasuredTextView ywf;
        public ImageView ywg;
        public ImageView ywh;
        public View ywi;
        public NoMeasuredTextView zgq;
        public ImageView zgr;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (ae) obj;
        if (this.odb) {
            if (cursor.getString(0) != null && cursor.getString(0).equals("1")) {
                if (obj == null) {
                    obj = new ae();
                }
                obj.dH("");
                obj.dI("");
                obj.b(cursor);
                return obj;
            } else if (cursor.getString(0).equals("2")) {
                as.Hm();
                ag Xq = com.tencent.mm.y.c.Ff().Xq(x.k(cursor));
                if (Xq == null) {
                    Xq = new x();
                    Xq.b(cursor);
                    as.Hm();
                    com.tencent.mm.y.c.Ff().P(Xq);
                }
                if (obj == null) {
                    obj = new ae();
                }
                obj.eR(2);
                obj.aj(-1);
                obj.eS(1);
                obj.setContent(this.context.getString(R.l.ekz));
                obj.setUsername(Xq.field_username);
                obj.eP(0);
                obj.dG(Integer.toString(1));
                obj.dH("");
                obj.dI("");
                return obj;
            }
        }
        if (obj == null) {
            obj = new ae();
        }
        obj.dH("");
        obj.dI("");
        obj.b(cursor);
        return obj;
    }

    public d(Context context, com.tencent.mm.ui.o.a aVar) {
        super(context, new ae());
        this.xQN = aVar;
        this.yvY[0] = com.tencent.mm.bu.a.Z(context, R.e.bsO);
        this.yvY[1] = com.tencent.mm.bu.a.Z(context, R.e.btl);
        this.yvY[3] = com.tencent.mm.bu.a.Z(context, R.e.btv);
        this.yvY[2] = com.tencent.mm.bu.a.Z(context, R.e.btj);
        this.yvY[2] = com.tencent.mm.bu.a.Z(context, R.e.btj);
        this.yvY[4] = com.tencent.mm.bu.a.Z(context, R.e.btb);
        this.yvZ = new HashMap();
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
    }

    public final void a(com.tencent.mm.ui.base.MMSlideDelView.f fVar) {
        this.kHo = fVar;
    }

    public final void a(com.tencent.mm.ui.base.MMSlideDelView.e eVar) {
        this.kHq = eVar;
    }

    public final void a(com.tencent.mm.ui.base.MMSlideDelView.c cVar) {
        this.kHp = cVar;
    }

    public void detach() {
    }

    private CharSequence h(ae aeVar) {
        if (aeVar.field_status == 1) {
            return this.context.getString(R.l.euN);
        }
        return aeVar.field_conversationTime == Long.MAX_VALUE ? "" : n.c(this.context, aeVar.field_conversationTime, true);
    }

    protected final void XI() {
        XH();
    }

    public final void onPause() {
        if (this.kHr != null) {
            this.kHr.aVf();
        }
        this.zfL = false;
    }

    private void cxi() {
        if (this.yvZ != null) {
            for (Entry value : this.yvZ.entrySet()) {
                ((d) value.getValue()).zgd = null;
            }
        }
    }

    public final void onResume() {
        boolean z = true;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ConversationAdapter", "dkpno onResume mIsFront:%b  mNeedReCreate:%b mChangedBackground:%b mContactBackground:%b", Boolean.valueOf(this.zfL), Boolean.valueOf(this.zfN), Boolean.valueOf(this.zfM), Boolean.valueOf(this.zfO));
        this.zfL = true;
        Time time = new Time();
        time.setToNow();
        String charSequence = com.tencent.mm.pluginsdk.h.m.a("MM/dd", time).toString();
        if (this.zfS.equals(charSequence)) {
            z = false;
        }
        this.zfS = charSequence;
        if (z) {
            cxi();
        }
        if (this.zfN && this.zfR != null) {
            this.zfN = false;
        }
        if (this.zfM || this.zfO) {
            super.a(null, null);
            this.zfM = false;
            this.zfO = false;
        }
    }

    public final void onDestroy() {
        this.zfZ.TN();
        this.zfR = null;
        this.zfP = null;
        if (this.yvZ != null) {
            this.yvZ.clear();
            this.yvZ = null;
        }
        aUU();
        this.xQN = null;
        detach();
    }

    public void XH() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ConversationAdapter", "dkpno resetCursor search:%b", Boolean.valueOf(this.odb));
        if (this.odb) {
            Cursor[] cursorArr = new Cursor[2];
            cursorArr[0] = as.Hm().hgk.a(s.hgU, this.koG, this.inJ);
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            if (this.koG != null && this.koG.size() > 0) {
                arrayList.addAll(this.koG);
            }
            while (cursorArr[0].moveToNext()) {
                try {
                    String string = cursorArr[0].getString(cursorArr[0].getColumnIndex("username"));
                    arrayList.add(string);
                    if (!string.endsWith("@chatroom")) {
                        arrayList2.add(string);
                    }
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ConversationAdapter", "block user " + string);
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.ConversationAdapter", e, "", new Object[0]);
                }
            }
            arrayList.add("officialaccounts");
            arrayList.add("helper_entry");
            cursorArr[1] = as.Hm().hgl.b(this.inJ, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
            setCursor(new MergeCursor(cursorArr));
        } else {
            as.Hm();
            setCursor(com.tencent.mm.y.c.Fk().a(s.hgU, this.koG, com.tencent.mm.l.a.gKQ, false));
        }
        if (!(this.zfJ == null || this.inJ == null)) {
            getCursor().getCount();
        }
        super.notifyDataSetChanged();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        g gVar;
        int i2;
        d dVar;
        ae aeVar = (ae) getItem(i);
        String str = aeVar.field_username;
        e eVar = this.zfT;
        eVar.talker = str;
        eVar.jQP = null;
        eVar.zgp = null;
        eVar.initialized = false;
        if (!t.oN(str)) {
            eVar.initialized = true;
        }
        this.zfW = new a();
        if (view == null) {
            g gVar2 = new g();
            if (com.tencent.mm.bu.a.ez(this.context)) {
                inflate = View.inflate(this.context, R.i.dfi, null);
            } else {
                inflate = View.inflate(this.context, R.i.dfh, null);
            }
            gVar2.ikK = (ImageView) inflate.findViewById(R.h.bLM);
            com.tencent.mm.pluginsdk.ui.a.b.a(gVar2.ikK, str);
            com.tencent.mm.pluginsdk.ui.a aVar = (com.tencent.mm.pluginsdk.ui.a) gVar2.ikK.getDrawable();
            if (this.zfK != null) {
                this.zfK.a(aVar);
            }
            gVar2.ywd = (NoMeasuredTextView) inflate.findViewById(R.h.cAs);
            gVar2.zgq = (NoMeasuredTextView) inflate.findViewById(R.h.cPj);
            gVar2.ywe = (NoMeasuredTextView) inflate.findViewById(R.h.cTY);
            gVar2.ywf = (NoMeasuredTextView) inflate.findViewById(R.h.csB);
            gVar2.kHx = (TextView) inflate.findViewById(R.h.cSe);
            gVar2.kHx.setBackgroundResource(com.tencent.mm.ui.tools.s.ge(this.context));
            gVar2.ywg = (ImageView) inflate.findViewById(R.h.cpv);
            gVar2.ywi = inflate.findViewById(R.h.bLP);
            gVar2.ywh = (ImageView) inflate.findViewById(R.h.cQF);
            gVar2.zgr = (ImageView) inflate.findViewById(R.h.cuf);
            inflate.setTag(gVar2);
            gVar2.ywf.O(this.yvW);
            gVar2.ywe.O(this.yvX);
            gVar2.ywd.O(this.yvV);
            gVar2.zgq.O(this.yvW);
            gVar2.ywf.setTextColor(this.yvY[0]);
            gVar2.ywe.setTextColor(this.yvY[4]);
            gVar2.ywd.setTextColor(this.yvY[3]);
            gVar2.zgq.setTextColor(this.yvY[0]);
            gVar2.ywf.yoG = true;
            gVar2.ywe.yoG = false;
            gVar2.ywd.yoG = true;
            gVar2.zgq.yoG = true;
            gVar2.ywe.En();
            gVar = gVar2;
        } else {
            gVar = (g) view.getTag();
            inflate = view;
        }
        d dVar2 = (d) this.yvZ.get(str);
        if (dVar2 == null) {
            String str2;
            d dVar3 = new d();
            eVar = this.zfT;
            if (eVar.initialized && eVar.jQP == null) {
                as.Hm();
                eVar.jQP = com.tencent.mm.y.c.Ff().Xv(eVar.talker);
            }
            ag agVar = eVar.jQP;
            if (agVar != null) {
                dVar3.zgh = agVar.fXs;
                dVar3.zgg = (int) agVar.gKO;
            } else {
                dVar3.zgh = -1;
                dVar3.zgg = -1;
            }
            dVar3.zgl = agVar != null;
            boolean z = agVar != null && agVar.AQ();
            dVar3.zgn = z;
            z = agVar != null && agVar.fXi == 0;
            dVar3.zgm = z;
            dVar3.tYt = s.eX(str);
            z = dVar3.tYt && dVar3.zgm && aeVar.field_unReadCount > 0;
            dVar3.zgk = z;
            dVar3.kZv = 0;
            if (wv(aeVar.field_msgType) == 34 && aeVar.field_isSend == 0 && !t.oN(aeVar.field_content)) {
                str2 = aeVar.field_content;
                if (str.equals("qmessage") || str.equals("floatbottle")) {
                    String[] split = str2.split(":");
                    if (split != null && split.length > 3) {
                        str2 = split[1] + ":" + split[2] + ":" + split[3];
                    }
                }
                if (!new com.tencent.mm.modelvoice.n(str2).hXo) {
                    dVar3.kZv = 1;
                }
            }
            str2 = r.a(agVar, str, dVar3.tYt);
            if (dVar3.tYt && str2 == null) {
                dVar3.nickName = this.context.getString(R.l.dSY);
            } else {
                dVar3.nickName = i.b(this.context, r.a(agVar, str, dVar3.tYt), gVar.ywd.gu.getTextSize());
            }
            dVar3.zgd = h(aeVar);
            dVar3.zge = a(aeVar, (int) gVar.ywf.gu.getTextSize(), dVar3.zgk);
            dVar3.zgo = aeVar.field_attrflag;
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
            dVar3.zgf = i2;
            dVar3.zgi = s.a(aeVar);
            as.Hm();
            dVar3.ywa = com.tencent.mm.y.c.Fk().g(aeVar);
            z = agVar != null && agVar.AP();
            dVar3.zgj = z;
            dVar3.vmD = w.cfR();
            this.yvZ.put(str, dVar3);
            dVar = dVar3;
        } else {
            dVar = dVar2;
        }
        if (dVar.zgd == null) {
            dVar.zgd = h(aeVar);
        }
        if (dVar.zgk || s.hg(aeVar.field_parentRef)) {
            gVar.ywf.setTextColor(this.yvY[0]);
        } else {
            gVar.ywf.setTextColor(this.yvY[dVar.kZv]);
        }
        h.fv(gVar.ywf.getWidth());
        h.fw((int) gVar.ywf.gu.getTextSize());
        h.a(gVar.ywf.gu);
        if (str.toLowerCase().endsWith("@t.qq.com")) {
            gVar.ywd.Fm(R.g.bDc);
            gVar.ywd.mB(true);
        } else {
            gVar.ywd.mB(false);
        }
        i2 = dVar.zgf;
        if (i2 != -1) {
            gVar.ywf.Fl(i2);
            gVar.ywf.mA(true);
        } else {
            gVar.ywf.mA(false);
        }
        gVar.ywd.setText(dVar.nickName);
        gVar.zgq.setVisibility(8);
        LayoutParams layoutParams = gVar.ywe.getLayoutParams();
        if (dVar.zgd.length() > 9) {
            if (layoutParams.width != this.zfV) {
                layoutParams.width = this.zfV;
                gVar.ywe.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.zfU) {
            layoutParams.width = this.zfU;
            gVar.ywe.setLayoutParams(layoutParams);
        }
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ConversationAdapter", "layout update time width %d", Integer.valueOf(layoutParams.width));
        gVar.ywe.setText(dVar.zgd);
        gVar.ywf.setText(dVar.zge);
        if (dVar.tYt && dVar.zgm) {
            gVar.ywg.setVisibility(0);
        } else if (dVar.zgj) {
            gVar.ywg.setVisibility(0);
        } else {
            gVar.ywg.setVisibility(8);
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(gVar.ikK, str);
        if (this.zfI) {
            if (aeVar == null || gVar == null || dVar == null) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ConversationAdapter", "handle show tip cnt, but conversation or viewholder is null");
            } else {
                gVar.kHx.setVisibility(4);
                gVar.ywi.setVisibility(4);
                if (s.hg(aeVar.field_username)) {
                    gVar.ywi.setVisibility(aeVar.field_unReadCount > 0 ? 0 : 4);
                    gVar.ywd.setTextColor(this.yvY[3]);
                } else {
                    NoMeasuredTextView noMeasuredTextView = gVar.ywd;
                    ColorStateList colorStateList = (dVar.zgl && dVar.zgh == 1) ? this.yvY[2] : this.yvY[3];
                    noMeasuredTextView.setTextColor(colorStateList);
                    if (!dVar.zgl || dVar.zgg == 0) {
                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ConversationAdapter", "handle show tip count, but talker is null");
                    } else if (s.hg(aeVar.field_parentRef)) {
                        gVar.ywi.setVisibility(aeVar.field_unReadCount > 0 ? 0 : 4);
                    } else if (dVar.zgj && dVar.zgn) {
                        gVar.ywi.setVisibility(aeVar.field_unReadCount > 0 ? 0 : 4);
                    } else if (dVar.tYt && dVar.zgm) {
                        gVar.ywi.setVisibility(aeVar.field_unReadCount > 0 ? 0 : 4);
                    } else {
                        i2 = aeVar.field_unReadCount;
                        if (i2 > 99) {
                            gVar.kHx.setText(R.l.eSf);
                            gVar.kHx.setVisibility(0);
                        } else if (i2 > 0) {
                            gVar.kHx.setText(aeVar.field_unReadCount);
                            gVar.kHx.setVisibility(0);
                        }
                        this.zfW.zgb = i2;
                    }
                }
            }
        }
        if (!dVar.zgi && dVar.ywa && as.Hp()) {
            as.Hm();
            com.tencent.mm.y.c.Fk().f(aeVar);
        }
        if (!dVar.ywa || aeVar.field_conversationTime == -1) {
            inflate.findViewById(R.h.bYZ).setBackgroundResource(R.g.bBy);
        } else {
            inflate.findViewById(R.h.bYZ).setBackgroundResource(R.g.bBx);
        }
        com.tencent.mm.bl.d.cdJ();
        com.tencent.mm.sdk.b.b rkVar = new rk();
        rkVar.fJX.fJZ = true;
        com.tencent.mm.sdk.b.a.xmy.m(rkVar);
        if (!(0 == com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 7, 0) || aeVar.field_username.equals(rkVar.fJY.fKb))) {
            aeVar.ak(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 6, aeVar.field_conversationTime));
            as.Hm();
            com.tencent.mm.y.c.Fk().a(aeVar, aeVar.field_username);
        }
        if (com.tencent.mm.pluginsdk.q.a.viX == null || !com.tencent.mm.pluginsdk.q.a.viX.MW(aeVar.field_username)) {
            gVar.ywh.setVisibility(8);
        } else {
            gVar.ywh.setVisibility(0);
            if (aeVar.field_username.equals(rkVar.fJY.fKb)) {
                gVar.ywh.setImageResource(R.k.dBl);
            } else {
                gVar.ywh.setImageResource(R.k.dBk);
            }
        }
        if (com.tencent.mm.pluginsdk.q.a.vje == null || !com.tencent.mm.pluginsdk.q.a.vje.Ei(aeVar.field_username)) {
            gVar.zgr.setVisibility(8);
        } else {
            gVar.zgr.setVisibility(0);
        }
        this.zfW.content = String.valueOf(dVar.zge);
        this.zfW.bgo = String.valueOf(dVar.nickName);
        this.zfW.zgc = String.valueOf(dVar.zgd);
        a aVar2 = this.zfW;
        a.xVN.a(inflate, aVar2.bgo, aVar2.zgb, aVar2.zgc, aVar2.content);
        a(str, gVar);
        a(aeVar, dVar.ywa, i, false);
        return inflate;
    }

    protected void a(String str, g gVar) {
    }

    protected void a(ae aeVar, boolean z, int i, boolean z2) {
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

    private CharSequence a(ae aeVar, int i, boolean z) {
        CharSequence replace;
        if (t.oN(aeVar.field_editingMsg) || (aeVar.field_atCount > 0 && aeVar.field_unReadCount > 0)) {
            CharSequence charSequence = aeVar.field_digest;
            if (charSequence != null && charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                return new SpannableString(i.e(this.context, charSequence, (float) i));
            }
            int i2;
            String str;
            String str2 = aeVar.field_username;
            if (str2.equals("qqmail")) {
                as.Hm();
                if (t.e((Integer) com.tencent.mm.y.c.Db().get(17, null)) == 1) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i2 == 0) {
                    return this.context.getString(R.l.eMI);
                }
            }
            if (str2.equals("tmessage")) {
                as.Hm();
                bc FE = com.tencent.mm.y.c.Fn().FE("@t.qq.com");
                if (FE == null || !FE.isEnable()) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                if (i2 == 0) {
                    return this.context.getString(R.l.eMI);
                }
            }
            if (aeVar.field_msgType != null && (aeVar.field_msgType.equals("47") || aeVar.field_msgType.equals("1048625"))) {
                str2 = ZD(aeVar.field_digest);
                str = "";
                if (str2 != null) {
                    return "[" + str2 + "]";
                }
                if (aeVar.field_digest != null && aeVar.field_digest.contains(":")) {
                    str = aeVar.field_digest.substring(0, aeVar.field_digest.indexOf(":"));
                    str2 = ZD(aeVar.field_digest.substring(aeVar.field_digest.indexOf(":") + 1).replace(" ", ""));
                    if (str2 != null) {
                        str2 = "[" + str2 + "]";
                        return t.oN(str) ? str2 : str + ": " + str2;
                    }
                }
                str2 = this.context.getString(R.l.dER);
                aeVar.dH(t.oN(str) ? str2 : str + ": " + str2);
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
                    if (!z && aeVar.field_unReadCount > 1) {
                        replace = this.context.getString(R.l.eut, new Object[]{Integer.valueOf(aeVar.field_unReadCount), replace});
                    } else if (aeVar.field_unReadCount > 1 && s.hg(aeVar.field_parentRef)) {
                        replace = this.context.getString(R.l.eut, new Object[]{Integer.valueOf(aeVar.field_unReadCount), replace});
                    }
                    return i.c(this.context, replace, i);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.context.getString(R.l.euq));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                spannableStringBuilder.append(" ").append(i.c(this.context, replace, i));
                return spannableStringBuilder;
            }
            str = h.a(aeVar.field_isSend, aeVar.field_username, aeVar.field_content, wv(aeVar.field_msgType), this.context);
            replace = str.replace(10, ' ');
            if (aeVar.field_atCount > 0) {
            }
            if (!z) {
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
        return ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yF(str);
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
            return;
        }
        a((String) obj, null);
    }

    public final void a(String str, l lVar) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", Boolean.valueOf(this.zfL), Boolean.valueOf(this.zfM), str);
        if (!(t.oN(str) || this.yvZ == null)) {
            this.yvZ.remove(str);
        }
        if (this.zfL) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", Boolean.valueOf(this.zfY), Boolean.valueOf(this.zfZ.cgx()));
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
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", Long.valueOf(t.bA(Wy) * 3), Long.valueOf(d.zfX), Boolean.valueOf(d.this.zfY));
                    d.zfX = (Wy + d.zfX) / 2;
                    d.this.zfY = false;
                    al f = d.this.zfZ;
                    long cxk = d.zfX;
                    f.K(cxk, cxk);
                    return;
                }
                d.this.zfZ.TN();
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ConversationAdapter", "dkpno handleDataChange acc has not ready");
            }
        });
    }
}
