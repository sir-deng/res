package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.af.a.j;
import com.tencent.mm.af.a.l;
import com.tencent.mm.af.y;
import com.tencent.mm.ap.o;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.protocal.c.ht;
import com.tencent.mm.protocal.c.hw;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class BizChatSearchUI extends MMActivity implements com.tencent.mm.pluginsdk.ui.tools.p.a, com.tencent.mm.ui.bizchat.BizChatSearchListView.a {
    p kLM;
    String kMt;
    private OnScrollListener nrQ = new OnScrollListener() {
        boolean kLA = false;

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0 && this.kLA && BizChatSearchUI.this.ywB.ywQ) {
                a a = BizChatSearchUI.this.ywB;
                if (a.crz() && !a.ywS) {
                    a.ywS = true;
                    as.CN().a(new l(a.kMt, a.liS, a.ywW), 0);
                    a.crB();
                }
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i + i2 == i3) {
                this.kLA = true;
            } else {
                this.kLA = false;
            }
        }
    };
    private int scene;
    TextView ywA;
    private a ywB;
    private String ywx;
    private c ywy;
    BizChatSearchListView ywz;

    private static class b {
        public View contentView;
        public TextView lmd;
        public View mVw;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    private static class c {
        View kLC;
        View kLD;
        View kLE;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        final void q(boolean z, boolean z2) {
            int i;
            int i2 = 0;
            View view = this.kLC;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view.setVisibility(i);
            this.kLD.setVisibility(8);
            View view2 = this.kLE;
            if (!z2) {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
    }

    private static class d {
        public View contentView;
        public TextView mVG;

        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    private static class e {
        public View contentView;
        public ImageView jIs;
        public TextView mVG;

        private e() {
        }

        /* synthetic */ e(byte b) {
            this();
        }
    }

    private static class g {
        public static int ywZ = 0;
        public static int yxa = 1;
        public static int yxb = 2;
        public static int yxc = 3;
        public static int yxd = 4;
        public static int yxe = 5;
        public static int yxf = 6;
        public static int yxg = 1;
        public static int yxh = 2;
        public Object data;
        public int kZv;

        public g() {
            this.kZv = ywZ;
            this.data = null;
        }

        public g(int i, Object obj) {
            this.kZv = i;
            this.data = obj;
        }
    }

    private static class a extends BaseAdapter implements com.tencent.mm.ad.e {
        public static int ywD = 3;
        private int Pb = 0;
        private Context context;
        private com.tencent.mm.ap.a.a.c hEY;
        String kMt;
        String liS;
        private int scene;
        private int ywE;
        boolean ywF;
        boolean ywG;
        private ArrayList<com.tencent.mm.af.a.c> ywH = new ArrayList();
        private ArrayList<Object> ywI = new ArrayList();
        private ArrayList<com.tencent.mm.af.a.c> ywJ = new ArrayList();
        private g ywK;
        private ArrayList<g> ywL = new ArrayList();
        private g ywM;
        private g ywN;
        private ArrayList<g> ywO = new ArrayList();
        private g ywP;
        public boolean ywQ = true;
        public boolean ywR = false;
        public boolean ywS = false;
        private boolean ywT = true;
        private int ywU = 0;
        public boolean ywV = false;
        int ywW = 0;

        public final /* synthetic */ Object getItem(int i) {
            return FE(i);
        }

        public a(Context context, String str, int i) {
            boolean z;
            boolean z2 = false;
            this.context = context;
            this.kMt = str;
            this.scene = i;
            if (this.scene == 1 || this.scene == 2) {
                z = true;
            } else {
                z = false;
            }
            this.ywF = z;
            if (this.scene == 1 || this.scene == 3) {
                z2 = true;
            }
            this.ywG = z2;
            this.ywE = this.scene == 1 ? ywD : Integer.MAX_VALUE;
            com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
            aVar.hFo = com.tencent.mm.af.a.e.bZ(this.kMt);
            aVar.hFl = true;
            aVar.hFI = true;
            aVar.hFA = R.k.bBC;
            this.hEY = aVar.PQ();
            if (this.ywF) {
                as.CN().a(1364, (com.tencent.mm.ad.e) this);
            }
        }

        public final int getCount() {
            return this.Pb;
        }

        public final int getItemViewType(int i) {
            g FE = FE(i);
            if (FE != null) {
                return FE.kZv;
            }
            return g.ywZ;
        }

        public final int getViewTypeCount() {
            return g.yxf;
        }

        public final g FE(int i) {
            int i2;
            if (i < this.ywU) {
                if (i == 0) {
                    if (this.ywK == null) {
                        this.ywK = new g(g.yxe, Integer.valueOf(g.yxg));
                    }
                    return this.ywK;
                } else if (i == this.ywU - 1 && this.ywR && cry()) {
                    if (this.ywM == null) {
                        this.ywM = new g();
                    }
                    this.ywM.kZv = g.yxd;
                    this.ywM.data = Integer.valueOf(g.yxg);
                    return this.ywM;
                } else if (i == this.ywU - 1 && this.ywQ && cry()) {
                    if (this.ywM == null) {
                        this.ywM = new g();
                    }
                    this.ywM.kZv = g.yxc;
                    this.ywM.data = Integer.valueOf(g.yxg);
                    return this.ywM;
                } else {
                    i2 = i - 1;
                    if (i2 >= 0 && i2 < this.ywL.size()) {
                        return (g) this.ywL.get(i2);
                    }
                }
            } else if (i == this.ywU) {
                if (this.ywN == null) {
                    this.ywN = new g(g.yxe, Integer.valueOf(g.yxh));
                }
                return this.ywN;
            } else if (i == this.Pb - 1 && this.ywT && cry()) {
                if (this.ywP == null) {
                    this.ywP = new g(g.yxc, Integer.valueOf(g.yxh));
                }
                return this.ywP;
            } else {
                i2 = (i - this.ywU) - 1;
                if (i2 >= 0 && i2 < this.ywO.size()) {
                    return (g) this.ywO.get(i2);
                }
            }
            return new g();
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z = true;
            g FE = FE(i);
            String str;
            CharSequence a;
            if (FE.kZv == g.yxa || FE.kZv == g.yxb) {
                CharSequence charSequence;
                String str2;
                boolean z2;
                CharSequence charSequence2;
                boolean z3;
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(R.i.diU, viewGroup, false);
                    view.measure(ViewGroup.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824), viewGroup.getPaddingLeft() + viewGroup.getPaddingRight(), -1), MeasureSpec.makeMeasureSpec(-2, 1073741824));
                    f fVar = new f();
                    fVar.ikK = (ImageView) view.findViewById(R.h.bLM);
                    fVar.ikL = (TextView) view.findViewById(R.h.cSB);
                    fVar.ikM = (TextView) view.findViewById(R.h.caU);
                    fVar.contentView = view.findViewById(R.h.cJR);
                    view.setTag(fVar);
                }
                f fVar2 = (f) view.getTag();
                String str3 = "";
                String str4 = "";
                String str5 = "";
                Object charSequence22;
                Object charSequence3;
                if (FE.data instanceof com.tencent.mm.af.a.c) {
                    com.tencent.mm.af.a.c cVar = (com.tencent.mm.af.a.c) FE.data;
                    if (cVar != null) {
                        if (!cVar.Mz()) {
                            j ca = y.Mp().ca(cVar.field_bizChatServId);
                            if (ca != null) {
                                str4 = ca.field_userName;
                                str = ca.field_headImageUrl;
                            }
                        }
                        str4 = cVar.field_chatName;
                        str = cVar.field_headImageUrl;
                    } else {
                        str = str4;
                        str4 = str3;
                    }
                    charSequence3 = str5;
                    str2 = str;
                    z2 = false;
                    charSequence22 = str4;
                    z3 = true;
                } else if (FE.data instanceof ht) {
                    ht htVar = (ht) FE.data;
                    hw hwVar = htVar.vUk;
                    str2 = hwVar.kTk;
                    str5 = hwVar.vUc;
                    boolean equals = "userid".equals(htVar.vUl);
                    z3 = !equals;
                    String str6 = htVar.vUm;
                    charSequence22 = str2;
                    str2 = str5;
                    z2 = equals;
                    charSequence3 = str6;
                } else {
                    str2 = str4;
                    charSequence22 = str3;
                    charSequence3 = str5;
                    z3 = false;
                    z2 = false;
                }
                if (z3) {
                    a = a(this.context, com.tencent.mm.bb.b.a(charSequence22, this.liS), com.tencent.mm.plugin.fts.d.d.b.mUs);
                } else {
                    a = a(this.context, new SpannableString(charSequence22), com.tencent.mm.plugin.fts.d.d.b.mUs);
                }
                if (z2) {
                    str = this.context.getString(R.l.dMM);
                    SpannableString a2 = a(this.context, com.tencent.mm.bb.b.a(charSequence3, this.liS), com.tencent.mm.plugin.fts.d.d.b.mUs);
                    charSequence22 = TextUtils.concat(new CharSequence[]{str, a2});
                } else {
                    charSequence22 = "";
                }
                if (FE.kZv == g.yxa && i == this.ywU - 1 && this.ywU != this.Pb) {
                    z = false;
                }
                o(fVar2.contentView, z);
                o.PG().a(str2, fVar2.ikK, this.hEY);
                com.tencent.mm.plugin.fts.d.e.a(a, fVar2.ikL);
                com.tencent.mm.plugin.fts.d.e.a(charSequence22, fVar2.ikM);
                return view;
            } else if (FE.kZv == g.yxe) {
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(R.i.djd, viewGroup, false);
                    b bVar = new b();
                    bVar.lmd = (TextView) view.findViewById(R.h.coz);
                    bVar.mVw = view.findViewById(R.h.cCr);
                    bVar.contentView = view.findViewById(R.h.cJR);
                    view.setTag(bVar);
                }
                b bVar2 = (b) view.getTag();
                str = ((Integer) FE.data).intValue() == g.yxg ? this.context.getResources().getString(R.l.dMK) : ((Integer) FE.data).intValue() == g.yxh ? this.context.getResources().getString(R.l.dMD) : "";
                com.tencent.mm.plugin.fts.d.e.a(str, bVar2.lmd);
                if (i == 0) {
                    bVar2.mVw.setVisibility(8);
                } else {
                    bVar2.mVw.setVisibility(0);
                }
                bVar2.contentView.setBackgroundResource(R.g.bDr);
                return view;
            } else if (FE.kZv == g.yxc) {
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(R.i.djn, viewGroup, false);
                    e eVar = new e();
                    eVar.mVG = (TextView) view.findViewById(R.h.cSc);
                    eVar.jIs = (ImageView) view.findViewById(R.h.coQ);
                    eVar.contentView = view.findViewById(R.h.cJR);
                    view.setTag(eVar);
                }
                e eVar2 = (e) view.getTag();
                a = "";
                if (((Integer) FE.data).intValue() == g.yxg) {
                    a = this.context.getResources().getString(R.l.dMJ);
                } else if (((Integer) FE.data).intValue() == g.yxh) {
                    Object string = this.context.getResources().getString(R.l.dMI);
                }
                if (((Integer) FE.data).intValue() == g.yxg && this.ywU != this.Pb) {
                    z = false;
                }
                o(eVar2.contentView, z);
                eVar2.mVG.setText(a);
                eVar2.jIs.setImageResource(R.k.dyR);
                return view;
            } else if (FE.kZv != g.yxd) {
                return null;
            } else {
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(R.i.djf, viewGroup, false);
                    d dVar = new d();
                    dVar.mVG = (TextView) view.findViewById(R.h.cSc);
                    dVar.contentView = view.findViewById(R.h.cJR);
                    view.setTag(dVar);
                }
                d dVar2 = (d) view.getTag();
                if (((Integer) FE.data).intValue() == g.yxg && this.ywU != this.Pb) {
                    z = false;
                }
                o(dVar2.contentView, z);
                dVar2.mVG.setText(this.context.getResources().getString(R.l.dMF));
                return view;
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r9, int r10, java.lang.String r11, com.tencent.mm.ad.k r12) {
            /*
            r8 = this;
            r1 = 0;
            r2 = 1;
            r3 = 0;
            r0 = r8.ywF;
            if (r0 == 0) goto L_0x0045;
        L_0x0007:
            r0 = r12.getType();
            r4 = 1364; // 0x554 float:1.911E-42 double:6.74E-321;
            if (r0 != r4) goto L_0x0045;
        L_0x000f:
            r0 = r12 instanceof com.tencent.mm.af.a.l;
            if (r0 == 0) goto L_0x0045;
        L_0x0013:
            r8.ywS = r3;
            r12 = (com.tencent.mm.af.a.l) r12;
            r0 = r12.gLB;
            if (r0 == 0) goto L_0x0046;
        L_0x001b:
            r0 = r12.gLB;
            r0 = r0.hnQ;
            r0 = r0.hnY;
            if (r0 == 0) goto L_0x0046;
        L_0x0023:
            r0 = r12.gLB;
            r0 = r0.hnQ;
            r0 = r0.hnY;
            r0 = (com.tencent.mm.protocal.c.hu) r0;
        L_0x002b:
            r4 = r0.foW;
            r5 = r0.vUh;
            r6 = r8.liS;
            r6 = r4.equals(r6);
            if (r6 == 0) goto L_0x0045;
        L_0x0037:
            r6 = r8.kMt;
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x0045;
        L_0x003f:
            r5 = r8.ywW;
            r0 = r0.offset;
            if (r5 == r0) goto L_0x0048;
        L_0x0045:
            return;
        L_0x0046:
            r0 = r1;
            goto L_0x002b;
        L_0x0048:
            if (r9 != 0) goto L_0x004c;
        L_0x004a:
            if (r10 == 0) goto L_0x0050;
        L_0x004c:
            r8.crx();
            goto L_0x0045;
        L_0x0050:
            r0 = r12.gLB;
            if (r0 == 0) goto L_0x0074;
        L_0x0054:
            r0 = r12.gLB;
            r0 = r0.hnR;
            r0 = r0.hnY;
            if (r0 == 0) goto L_0x0074;
        L_0x005c:
            r0 = r12.gLB;
            r0 = r0.hnR;
            r0 = r0.hnY;
            r0 = (com.tencent.mm.protocal.c.hv) r0;
        L_0x0064:
            if (r0 == 0) goto L_0x0070;
        L_0x0066:
            r1 = r0.vUn;
            if (r1 == 0) goto L_0x0070;
        L_0x006a:
            r1 = r0.vUn;
            r1 = r1.ret;
            if (r1 == 0) goto L_0x0076;
        L_0x0070:
            r8.crx();
            goto L_0x0045;
        L_0x0074:
            r0 = r1;
            goto L_0x0064;
        L_0x0076:
            r1 = r0.vUo;
            r0 = r0.vUp;
            r5 = r8.liS;
            r5 = r4.equals(r5);
            if (r5 == 0) goto L_0x0045;
        L_0x0082:
            r8.ywR = r3;
            r5 = r8.ywW;
            r6 = r1.size();
            r5 = r5 + r6;
            r8.ywW = r5;
            r5 = r8.cry();
            if (r5 == 0) goto L_0x00b3;
        L_0x0093:
            r5 = r8.ywI;
            r5 = r5.size();
            r6 = r8.ywH;
            r6 = r6.size();
            if (r5 >= r6) goto L_0x00a5;
        L_0x00a1:
            r8.bm(r4, r2);
            goto L_0x0045;
        L_0x00a5:
            r4 = r8.ywI;
            r4 = r4.size();
            r5 = r8.ywH;
            r5 = r5.size();
            if (r4 > r5) goto L_0x0101;
        L_0x00b3:
            r4 = r8.crz();
            if (r4 == 0) goto L_0x00bb;
        L_0x00b9:
            r8.ywQ = r0;
        L_0x00bb:
            r0 = r8.crA();
            if (r0 != 0) goto L_0x0045;
        L_0x00c1:
            r4 = r1.iterator();
        L_0x00c5:
            r0 = r4.hasNext();
            if (r0 == 0) goto L_0x0101;
        L_0x00cb:
            r0 = r4.next();
            r1 = r0;
            r1 = (com.tencent.mm.protocal.c.ht) r1;
            r5 = r1.vUk;
            r0 = r5.vUi;
            r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
            if (r0 != 0) goto L_0x00c5;
        L_0x00dc:
            r0 = r8.ywH;
            r6 = r0.iterator();
        L_0x00e2:
            r0 = r6.hasNext();
            if (r0 == 0) goto L_0x0106;
        L_0x00e8:
            r0 = r6.next();
            r0 = (com.tencent.mm.af.a.c) r0;
            r7 = r5.vUi;
            r0 = r0.field_bizChatServId;
            r0 = r7.equals(r0);
            if (r0 == 0) goto L_0x00e2;
        L_0x00f8:
            r0 = r2;
        L_0x00f9:
            if (r0 != 0) goto L_0x00c5;
        L_0x00fb:
            r0 = r8.ywI;
            r0.add(r1);
            goto L_0x00c5;
        L_0x0101:
            r8.mJ(r2);
            goto L_0x0045;
        L_0x0106:
            r0 = r3;
            goto L_0x00f9;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.bizchat.BizChatSearchUI.a.a(int, int, java.lang.String, com.tencent.mm.ad.k):void");
        }

        private void crx() {
            if (crz()) {
                this.ywR = false;
                this.ywV = true;
                crB();
            }
        }

        private boolean cry() {
            return this.scene == 1;
        }

        final boolean crz() {
            return this.scene == 2;
        }

        private boolean crA() {
            return this.scene == 3;
        }

        private static SpannableString a(Context context, Spannable spannable, int i) {
            int i2 = 0;
            SpannableString c = i.c(context, spannable, i);
            ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannable.getSpans(0, spannable.length(), ForegroundColorSpan.class);
            if (foregroundColorSpanArr != null) {
                int length = foregroundColorSpanArr.length;
                while (i2 < length) {
                    Object obj = foregroundColorSpanArr[i2];
                    c.setSpan(obj, spannable.getSpanStart(obj), spannable.getSpanEnd(obj), spannable.getSpanFlags(obj));
                    i2++;
                }
            }
            return c;
        }

        private static void o(View view, boolean z) {
            if (z) {
                view.setBackgroundResource(R.g.bBy);
            } else {
                view.setBackgroundResource(R.g.bBz);
            }
        }

        final void bm(String str, boolean z) {
            com.tencent.mm.af.a.b Mo = y.Mo();
            String str2 = this.kMt;
            List<com.tencent.mm.af.a.c> arrayList = new ArrayList();
            if (!bi.oN(str)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("select BizChatInfo.*");
                stringBuilder.append(" from BizChatConversation , BizChatInfo");
                stringBuilder.append(" where BizChatConversation.brandUserName").append(" = '").append(str2).append("'");
                stringBuilder.append(" and BizChatInfo.brandUserName").append(" = '").append(str2).append("'");
                stringBuilder.append(" and BizChatConversation.bizChatId");
                stringBuilder.append(" = BizChatInfo.bizChatLocalId");
                stringBuilder.append(" and BizChatInfo.chatName").append(" like '%").append(str).append("%'");
                stringBuilder.append(" order by BizChatConversation.flag").append(" desc");
                stringBuilder.append(" , BizChatConversation.lastMsgTime").append(" desc");
                x.d("MicroMsg.BizConversationStorage", "getBizChatConversationSearchCursor: sql:%s", stringBuilder.toString());
                Cursor rawQuery = Mo.rawQuery(stringBuilder.toString(), new String[0]);
                if (rawQuery != null) {
                    if (rawQuery.moveToFirst()) {
                        do {
                            com.tencent.mm.af.a.c cVar = new com.tencent.mm.af.a.c();
                            cVar.b(rawQuery);
                            arrayList.add(cVar);
                        } while (rawQuery.moveToNext());
                    }
                    rawQuery.close();
                }
            }
            abi();
            for (com.tencent.mm.af.a.c cVar2 : arrayList) {
                boolean Mz = cVar2.Mz();
                if (Mz && this.ywG) {
                    this.ywJ.add(cVar2);
                } else if (!Mz && this.ywF) {
                    this.ywI.add(cVar2);
                    this.ywH.add(cVar2);
                }
            }
            if (this.ywF) {
                boolean z2;
                if (this.ywI.size() <= this.ywE) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.ywR = z2;
            }
            mJ(z);
        }

        final void ZE(final String str) {
            if (this.ywF) {
                ah.h(new Runnable() {
                    public final void run() {
                        if (str.equals(a.this.liS)) {
                            as.CN().a(new l(a.this.kMt, str, 0), 0);
                        }
                    }
                }, 200);
            }
        }

        final void abi() {
            this.ywW = 0;
            this.ywI.clear();
            this.ywH.clear();
            this.ywJ.clear();
        }

        final void mJ(boolean z) {
            int i;
            int i2 = 1;
            this.ywL.clear();
            this.ywO.clear();
            for (i = 0; i < Math.min(this.ywE, this.ywI.size()); i++) {
                this.ywL.add(new g(g.yxa, this.ywI.get(i)));
            }
            for (i = 0; i < Math.min(this.ywE, this.ywJ.size()); i++) {
                this.ywO.add(new g(g.yxb, this.ywJ.get(i)));
            }
            int size = this.ywI.size();
            int size2 = this.ywJ.size();
            if (this.scene != 2) {
                this.ywQ = this.ywI.size() > this.ywE;
            }
            this.ywT = this.ywJ.size() > this.ywE;
            if (size > 0 || this.ywR) {
                size = Math.min(size, this.ywE) + 1;
                if (cry()) {
                    i = (this.ywR || this.ywQ) ? 1 : 0;
                    i += size;
                } else {
                    i = size;
                }
            } else {
                i = 0;
            }
            this.ywU = i;
            if (size2 > 0) {
                i = (i + 1) + Math.min(size2, this.ywE);
                if (cry()) {
                    if (!this.ywT) {
                        i2 = 0;
                    }
                    i += i2;
                }
            }
            this.Pb = i;
            if (z) {
                notifyDataSetChanged();
                crB();
            }
        }

        final void crB() {
            BizChatSearchUI bizChatSearchUI = (BizChatSearchUI) this.context;
            if (!cry()) {
                if (bi.oN(this.liS)) {
                    bizChatSearchUI.ywA.setVisibility(0);
                    bizChatSearchUI.ywA.setText("");
                    bizChatSearchUI.ywz.setVisibility(8);
                } else if (crz() && this.ywR) {
                    bizChatSearchUI.ywA.setVisibility(0);
                    bizChatSearchUI.ywA.setText(R.l.dMF);
                    bizChatSearchUI.ywz.setVisibility(8);
                } else if (crz() && this.ywV) {
                    bizChatSearchUI.ywA.setVisibility(0);
                    bizChatSearchUI.ywA.setText(R.l.dMG);
                    bizChatSearchUI.ywz.setVisibility(8);
                } else if (getCount() <= 0) {
                    bizChatSearchUI.ywA.setVisibility(0);
                    bizChatSearchUI.ywA.setText(com.tencent.mm.plugin.fts.d.f.a(bizChatSearchUI.getString(R.l.eIR), bizChatSearchUI.getString(R.l.eIQ), com.tencent.mm.plugin.fts.d.b.a.d(this.liS, this.liS)).mVW);
                    bizChatSearchUI.ywz.setVisibility(8);
                } else {
                    bizChatSearchUI.ywA.setVisibility(8);
                    bizChatSearchUI.ywz.setVisibility(0);
                }
                if (!crz()) {
                    return;
                }
                if (this.ywS) {
                    bizChatSearchUI.FD(1);
                } else if (this.ywQ) {
                    bizChatSearchUI.FD(2);
                } else {
                    bizChatSearchUI.FD(0);
                }
            } else if (bi.oN(this.liS)) {
                bizChatSearchUI.ywA.setVisibility(8);
                bizChatSearchUI.ywz.setVisibility(8);
            } else if (getCount() <= 0) {
                bizChatSearchUI.ywA.setVisibility(0);
                bizChatSearchUI.ywz.setVisibility(8);
            } else {
                bizChatSearchUI.ywA.setVisibility(8);
                bizChatSearchUI.ywz.setVisibility(0);
            }
        }
    }

    private static class f {
        public View contentView;
        public ImageView ikK;
        public TextView ikL;
        public TextView ikM;

        private f() {
        }

        /* synthetic */ f(byte b) {
            this();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final void XC() {
    }

    public final void XD() {
    }

    protected final void initView() {
        if (bi.oN(this.kMt)) {
            this.kMt = getIntent().getStringExtra("enterprise_biz_name");
            this.scene = getIntent().getIntExtra("biz_chat_search_scene", 1);
            this.ywx = getIntent().getStringExtra("biz_chat_search_text");
            if (bi.oN(this.kMt)) {
                finish();
            }
        }
        this.ywz = (BizChatSearchListView) findViewById(R.h.bNS);
        this.ywA = (TextView) findViewById(R.h.cAC);
        this.ywB = new a(this.mController.xRr, this.kMt, this.scene);
        if (this.ywB.crz()) {
            this.ywy = new c();
            BizChatSearchListView bizChatSearchListView = this.ywz;
            c cVar = this.ywy;
            View inflate = View.inflate(this.mController.xRr, R.i.dmL, null);
            cVar.kLC = inflate.findViewById(R.h.ctD);
            cVar.kLD = inflate.findViewById(R.h.ctz);
            cVar.kLE = inflate.findViewById(R.h.ctF);
            cVar.kLC.setVisibility(8);
            cVar.kLD.setVisibility(8);
            cVar.kLE.setVisibility(8);
            bizChatSearchListView.addFooterView(inflate);
            FD(0);
        }
        this.ywz.setAdapter(this.ywB);
        this.ywz.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                long j2 = -1;
                g FE = BizChatSearchUI.this.ywB.FE(i);
                MMActivity mMActivity = BizChatSearchUI.this;
                Intent intent;
                if (FE.kZv == g.yxa || FE.kZv == g.yxb) {
                    com.tencent.mm.af.a.c cVar;
                    if (FE.data instanceof com.tencent.mm.af.a.c) {
                        cVar = (com.tencent.mm.af.a.c) FE.data;
                        j2 = cVar != null ? cVar.field_bizChatLocalId : -1;
                    } else if (FE.data instanceof ht) {
                        hw hwVar = ((ht) FE.data).vUk;
                        String str = mMActivity.kMt;
                        j jVar = new j();
                        jVar.field_userId = hwVar.vUi;
                        jVar.field_userName = hwVar.kTk;
                        jVar.field_brandUserName = str;
                        jVar.field_headImageUrl = hwVar.vUc;
                        jVar.field_profileUrl = hwVar.vUq;
                        jVar.field_UserVersion = hwVar.ver;
                        jVar.field_addMemberUrl = hwVar.vUg;
                        if (!y.Mp().b(jVar) ? y.Mp().a(jVar) : true) {
                            cVar = new com.tencent.mm.af.a.c();
                            cVar.field_bizChatServId = jVar.field_userId;
                            cVar.field_brandUserName = jVar.field_brandUserName;
                            cVar.field_chatName = jVar.field_userName;
                            cVar.field_chatType = 1;
                            cVar = com.tencent.mm.af.a.e.e(cVar);
                            if (cVar != null) {
                                com.tencent.mm.af.a.a aT = y.Mo().aT(cVar.field_bizChatLocalId);
                                aT.field_bizChatId = cVar.field_bizChatLocalId;
                                aT.field_unReadCount = 0;
                                if (bi.oN(aT.field_brandUserName)) {
                                    aT.field_brandUserName = cVar.field_brandUserName;
                                    aT.field_lastMsgTime = System.currentTimeMillis();
                                    aT.field_flag = aT.field_lastMsgTime;
                                }
                                if (!y.Mo().b(aT)) {
                                    y.Mo().a(aT);
                                }
                                j2 = cVar.field_bizChatLocalId;
                            }
                        }
                    }
                    if (!bi.oN(mMActivity.kMt) && j2 >= 0) {
                        intent = new Intent();
                        intent.putExtra("Chat_User", mMActivity.kMt);
                        intent.putExtra("key_biz_chat_id", j2);
                        intent.putExtra("finish_direct", true);
                        intent.putExtra("key_need_send_video", false);
                        intent.putExtra("key_is_biz_chat", true);
                        com.tencent.mm.bl.d.a(mMActivity.mController.xRr, ".ui.chatting.ChattingUI", intent);
                    }
                } else if (FE.kZv != g.yxc) {
                } else {
                    if (((Integer) FE.data).intValue() == g.yxg) {
                        intent = new Intent(mMActivity.mController.xRr, BizChatSearchUI.class);
                        intent.putExtra("enterprise_biz_name", mMActivity.kMt);
                        intent.putExtra("biz_chat_search_scene", 2);
                        intent.putExtra("biz_chat_search_text", mMActivity.kLM.bVF());
                        mMActivity.startActivity(intent);
                    } else if (((Integer) FE.data).intValue() == g.yxh) {
                        intent = new Intent(mMActivity.mController.xRr, BizChatSearchUI.class);
                        intent.putExtra("enterprise_biz_name", mMActivity.kMt);
                        intent.putExtra("biz_chat_search_scene", 3);
                        intent.putExtra("biz_chat_search_text", mMActivity.kLM.bVF());
                        mMActivity.startActivity(intent);
                    }
                }
            }
        });
        this.ywz.yww = this;
        if (this.ywB.crz()) {
            this.ywz.setOnScrollListener(this.nrQ);
        }
        this.kLM = new p();
        this.kLM.nC(this.ywB.cry());
        this.kLM.a(this);
        this.kLM.vFI = false;
    }

    public final void XB() {
    }

    public final void XA() {
        finish();
    }

    public final void pd(String str) {
        CharSequence charSequence = null;
        if (!bi.oN(str) || this.ywx == null) {
            a aVar = this.ywB;
            aVar.liS = str;
            if (bi.oN(str)) {
                aVar.abi();
                aVar.ywR = false;
                aVar.ywV = false;
                aVar.mJ(true);
                return;
            } else if (aVar.crz()) {
                aVar.ywR = true;
                aVar.ywV = false;
                aVar.crB();
                aVar.bm(str, false);
                aVar.ZE(str);
                return;
            } else {
                aVar.bm(str, true);
                if (aVar.ywF && aVar.ywR) {
                    aVar.ZE(str);
                    return;
                }
                return;
            }
        }
        String str2 = this.ywx;
        this.ywx = null;
        if (!str2.equals("")) {
            this.kLM.aay(str2);
        }
        p pVar = this.kLM;
        if (this.ywB.cry()) {
            charSequence = this.mController.xRr.getResources().getString(R.l.dMH);
        } else if (this.ywB.crz()) {
            charSequence = this.mController.xRr.getResources().getString(R.l.dML);
        } else if (this.ywB.crA()) {
            charSequence = this.mController.xRr.getResources().getString(R.l.dME);
        }
        pVar.setHint(charSequence);
        this.kLM.clearFocus();
    }

    public final boolean pc(String str) {
        aWY();
        return true;
    }

    public final void asZ() {
        aWY();
    }

    public final void ata() {
    }

    protected void onPause() {
        super.onPause();
        this.kLM.cancel();
        this.kLM.clearFocus();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.kLM.a((FragmentActivity) this, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.kLM.a(this, menu);
        return true;
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
    }

    protected final int getLayoutId() {
        return R.i.dgA;
    }

    public final boolean atb() {
        aWY();
        return false;
    }

    public final void FD(int i) {
        if (this.ywy != null) {
            c cVar = this.ywy;
            switch (i) {
                case 1:
                    cVar.q(true, false);
                    return;
                case 2:
                    cVar.q(false, true);
                    return;
                default:
                    cVar.q(false, false);
                    return;
            }
        }
    }
}
