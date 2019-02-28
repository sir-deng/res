package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.af.a.j;
import com.tencent.mm.af.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.tools.s;
import java.util.HashMap;

public final class b extends o<com.tencent.mm.af.a.a> implements com.tencent.mm.sdk.e.m.b {
    protected f kHo;
    protected c kHp;
    protected e kHq;
    protected d kHr = MMSlideDelView.cql();
    private final String kMt;
    private com.tencent.mm.ap.a.a.c liE = null;
    private final MMFragmentActivity yvU;
    private float yvV = -1.0f;
    private float yvW = -1.0f;
    private float yvX = -1.0f;
    private ColorStateList[] yvY = new ColorStateList[5];
    HashMap<String, a> yvZ;

    private class a {
        String hvv;
        public boolean kYN;
        String mNc;
        public boolean ywa;
        public com.tencent.mm.af.a.a ywb;

        private a() {
            this.hvv = null;
            this.mNc = null;
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }
    }

    public static class b {
        public ImageView ikK;
        public TextView kHx;
        public NoMeasuredTextView ywd;
        public NoMeasuredTextView ywe;
        public NoMeasuredTextView ywf;
        public ImageView ywg;
        public ImageView ywh;
        public View ywi;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        com.tencent.mm.af.a.a aVar = (com.tencent.mm.af.a.a) obj;
        if (aVar == null) {
            aVar = new com.tencent.mm.af.a.a();
        }
        aVar.b(cursor);
        return aVar;
    }

    public b(Context context, com.tencent.mm.ui.o.a aVar, String str) {
        super(context, new com.tencent.mm.af.a.a());
        this.xQN = aVar;
        this.yvU = (MMFragmentActivity) context;
        this.kMt = str;
        this.yvZ = new HashMap();
        this.yvY[0] = com.tencent.mm.bu.a.Z(context, R.e.bsO);
        this.yvY[1] = com.tencent.mm.bu.a.Z(context, R.e.btl);
        this.yvY[3] = com.tencent.mm.bu.a.Z(context, R.e.btv);
        this.yvY[2] = com.tencent.mm.bu.a.Z(context, R.e.btj);
        this.yvY[2] = com.tencent.mm.bu.a.Z(context, R.e.btj);
        this.yvY[4] = com.tencent.mm.bu.a.Z(context, R.e.btb);
        this.yvV = (float) com.tencent.mm.bu.a.aa(context, R.f.bvL);
        this.yvW = (float) com.tencent.mm.bu.a.aa(context, R.f.bvt);
        this.yvX = (float) com.tencent.mm.bu.a.aa(context, R.f.bvX);
        com.tencent.mm.ap.a.a.c.a aVar2 = new com.tencent.mm.ap.a.a.c.a();
        aVar2.hFo = com.tencent.mm.af.a.e.bZ(this.kMt);
        aVar2.hFl = true;
        aVar2.hFI = true;
        aVar2.hFA = R.k.bBC;
        this.liE = aVar2.PQ();
    }

    public final void XH() {
        aUU();
        setCursor(y.Mo().km(this.kMt));
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
        b bVar;
        b bVar2;
        int i2;
        com.tencent.mm.af.a.a aVar = (com.tencent.mm.af.a.a) getItem(i);
        if (view != null) {
            bVar = (b) view.getTag();
        } else {
            bVar = null;
        }
        if (view == null || bVar == null) {
            View inflate;
            b bVar3 = new b();
            if (com.tencent.mm.bu.a.ez(this.yvU)) {
                inflate = View.inflate(this.yvU, R.i.dfi, null);
            } else {
                inflate = View.inflate(this.yvU, R.i.dfh, null);
            }
            bVar3.ikK = (ImageView) inflate.findViewById(R.h.bLM);
            bVar3.ywd = (NoMeasuredTextView) inflate.findViewById(R.h.cAs);
            bVar3.ywe = (NoMeasuredTextView) inflate.findViewById(R.h.cTY);
            bVar3.ywf = (NoMeasuredTextView) inflate.findViewById(R.h.csB);
            bVar3.kHx = (TextView) inflate.findViewById(R.h.cSe);
            bVar3.kHx.setBackgroundResource(s.ge(this.yvU));
            bVar3.ywg = (ImageView) inflate.findViewById(R.h.cpv);
            bVar3.ywi = inflate.findViewById(R.h.bLP);
            bVar3.ywh = (ImageView) inflate.findViewById(R.h.cQF);
            inflate.setTag(bVar3);
            bVar3.ywf.O(this.yvW);
            bVar3.ywe.O(this.yvX);
            bVar3.ywd.O(this.yvV);
            bVar3.ywf.setTextColor(this.yvY[0]);
            bVar3.ywe.setTextColor(this.yvY[4]);
            bVar3.ywd.setTextColor(this.yvY[3]);
            bVar3.ywf.yoG = true;
            bVar3.ywe.yoG = false;
            bVar3.ywd.yoG = true;
            bVar3.ywe.En();
            view = inflate;
            bVar2 = bVar3;
        } else {
            bVar2 = bVar;
        }
        long j = aVar.field_bizChatId;
        a aVar2 = (a) this.yvZ.get(String.valueOf(j));
        if (aVar2 == null) {
            aVar2 = new a();
            y.Mo();
            aVar2.ywa = com.tencent.mm.af.a.b.c(aVar);
            com.tencent.mm.af.a.c ag = y.Mn().ag(j);
            if (ag.Mz()) {
                aVar2.hvv = ag.field_chatName;
                aVar2.kYN = ag.hr(1);
                aVar2.mNc = ag.field_headImageUrl;
            } else {
                j ca = y.Mp().ca(ag.field_bizChatServId);
                if (ca != null) {
                    aVar2.hvv = ca.field_userName;
                    aVar2.kYN = ca.hr(1);
                    aVar2.mNc = ca.field_headImageUrl;
                }
            }
            if (bi.oN(aVar2.hvv)) {
                aVar2.hvv = this.yvU.getString(R.l.eFK);
            }
            aVar2.ywb = aVar;
            this.yvZ.put(String.valueOf(j), aVar2);
        }
        bVar2.ywh.setVisibility(8);
        bVar2.ywe.setText(aVar2.ywb.field_status == 1 ? this.yvU.getString(R.l.euN) : n.c(this.yvU, aVar2.ywb.field_lastMsgTime, true));
        com.tencent.mm.ap.o.PG().a(aVar2.mNc, bVar2.ikK, this.liE);
        if (aVar2.kYN) {
            bVar2.ywg.setVisibility(0);
        } else {
            bVar2.ywg.setVisibility(8);
        }
        bVar2.ywd.setText(i.c(this.yvU, aVar2.hvv, (int) bVar2.ywd.gu.getTextSize()));
        CharSequence a = a(aVar2.ywb, (int) bVar2.ywf.gu.getTextSize(), aVar2.hvv);
        switch (aVar2.ywb.field_status) {
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
        bVar2.ywd.mB(false);
        if (i2 != -1) {
            bVar2.ywf.Fl(i2);
            bVar2.ywf.mA(true);
        } else {
            bVar2.ywf.mA(false);
        }
        bVar2.ywf.setText(a);
        bVar2.ywf.setTextColor(com.tencent.mm.bu.a.Z(this.yvU, R.e.btk));
        if (wv(aVar2.ywb.field_msgType) == 34 && aVar2.ywb.field_isSend == 0 && !bi.oN(aVar2.ywb.field_content) && !new com.tencent.mm.modelvoice.n(aVar2.ywb.field_content).hXo) {
            bVar2.ywf.setTextColor(com.tencent.mm.bu.a.Z(this.yvU, R.e.btl));
        }
        if (aVar2.kYN) {
            if (aVar2.ywb.field_unReadCount > 0) {
                bVar2.ywi.setVisibility(0);
            } else {
                bVar2.ywi.setVisibility(4);
            }
            bVar2.kHx.setVisibility(4);
        } else {
            bVar2.ywi.setVisibility(4);
            if (aVar2.ywb.field_unReadCount > 99) {
                bVar2.kHx.setText(R.l.eSf);
                bVar2.kHx.setVisibility(0);
                x.v("MicroMsg.BizChatConversationAdapter", "has unread 100");
            } else if (aVar2.ywb.field_unReadCount > 0) {
                bVar2.kHx.setText(aVar2.ywb.field_unReadCount);
                bVar2.kHx.setVisibility(0);
                x.v("MicroMsg.BizChatConversationAdapter", "has unread");
            } else {
                bVar2.kHx.setVisibility(4);
                x.v("MicroMsg.BizChatConversationAdapter", "no unread");
            }
        }
        if (aVar2.ywa) {
            view.findViewById(R.h.bYZ).setBackgroundResource(R.g.bBx);
        } else {
            view.findViewById(R.h.bYZ).setBackgroundResource(R.g.bBy);
        }
        return view;
    }

    private static String ZD(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yF(str);
    }

    private CharSequence a(com.tencent.mm.af.a.a aVar, int i, String str) {
        CharSequence spannableStringBuilder;
        if (bi.oN(aVar.field_editingMsg) || (aVar.field_atCount > 0 && aVar.field_unReadCount > 0)) {
            String str2 = aVar.field_digest;
            if (aVar.field_msgType != null && (aVar.field_msgType.equals("47") || aVar.field_msgType.equals("1048625"))) {
                String ZD = ZD(aVar.field_digest);
                str2 = "";
                if (ZD != null) {
                    return "[" + ZD + "]";
                }
                if (aVar.field_digest != null && aVar.field_digest.contains(":")) {
                    str2 = aVar.field_digest.substring(0, aVar.field_digest.indexOf(":"));
                    ZD = ZD(aVar.field_digest.substring(aVar.field_digest.indexOf(":") + 1).replace(" ", ""));
                    if (ZD != null) {
                        ZD = "[" + ZD + "]";
                        return bi.oN(str2) ? ZD : str2 + ": " + ZD;
                    }
                }
                ZD = this.yvU.getString(R.l.dER);
                aVar.field_digest = bi.oN(str2) ? ZD : str2 + ": " + ZD;
            }
            if (bi.oN(aVar.field_digest)) {
                str2 = "";
            } else if (bi.oN(aVar.field_digestUser)) {
                str2 = aVar.field_digest;
            } else {
                try {
                    str2 = String.format(aVar.field_digest, new Object[]{str});
                } catch (Exception e) {
                    str2 = aVar.field_digest;
                }
            }
            CharSequence replace = str2.replace(10, ' ');
            if (aVar.field_atCount <= 0 || aVar.field_unReadCount <= 0) {
                return i.c(this.yvU, replace, i);
            }
            spannableStringBuilder = new SpannableStringBuilder(this.yvU.getString(R.l.euq));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append(" ").append(i.c(this.yvU, replace, i));
            return spannableStringBuilder;
        }
        spannableStringBuilder = new SpannableStringBuilder(this.yvU.getString(R.l.euu));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
        spannableStringBuilder.append(" ").append(i.c(this.yvU, aVar.field_editingMsg, i));
        return spannableStringBuilder;
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

    public final void a(int i, m mVar, Object obj) {
        super.a(i, mVar, obj);
    }

    public final void fV(long j) {
        if (this.yvZ != null) {
            this.yvZ.remove(String.valueOf(j));
        }
    }
}
