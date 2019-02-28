package com.tencent.mm.plugin.sns.f;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.kn;
import com.tencent.mm.f.a.ko;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.ui.ab;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c implements e, com.tencent.mm.plugin.sns.model.e {
    public static final Pattern rgd = Pattern.compile("\\{richtext:([\\s\\S]*?)\\}");
    public static final Pattern rge = Pattern.compile("\\{sex:([\\s\\S]*?):([\\s\\S]*?):([\\s\\S]*?)\\}");
    private com.tencent.mm.plugin.sns.g.c ras;
    public final int rfV = 500;
    private List<d> rfW;
    public ListView rfX;
    public av rfY;
    public Map<Long, Integer> rfZ = new HashMap();
    public final int rfr = 14;
    public HashSet<Long> rga = new HashSet();
    public HashSet<Long> rgb = new HashSet();
    private HashMap<Long, a> rgc = new HashMap();
    private com.tencent.mm.pluginsdk.ui.d.n.a rgf = new com.tencent.mm.pluginsdk.ui.d.n.a() {
        public final void bK(Object obj) {
        }
    };

    static class a {
        long mEndTime = -1;
        long mStartTime = -1;
        long raf;
        d rgp;
        int rgq = 0;
        int rgr = 0;
        String rgs = "";
        String rgt = "";
        String rgu;

        public a(long j, long j2, String str, d dVar) {
            this.rgp = dVar;
            this.mStartTime = j;
            this.raf = j2;
            this.rgu = str;
        }

        public final void dA(int i, int i2) {
            this.rgq = i;
            this.rgr = i2;
        }

        public final void q(int i, int i2, int i3, int i4) {
            if (i != -1 && i2 != -1) {
                String str = i + ":" + i2 + ":" + i3 + ":" + i4;
                String str2 = i + ":" + i2;
                if (!str.equals(this.rgs)) {
                    if (!this.rgs.startsWith(str2) || i3 != 0 || i4 != 0) {
                        this.rgs = str;
                        str = i + ":" + i2 + ":" + i3 + ":" + i4;
                        if (!bi.oN(this.rgt)) {
                            this.rgt += "|";
                        }
                        this.rgt += str;
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(c cVar, Context context, View view, a aVar, b bVar, com.tencent.mm.plugin.sns.ui.a.a.c cVar2, d dVar) {
        x.i("MicroMsg.SnSABTestMgr", "processButtonClick");
        if (view.getTag() instanceof blf) {
            cVar.a(context, (blf) view.getTag(), aVar, bVar, cVar2, dVar);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.SnSABTestMgr", "onSceneend " + i + " errCode " + i2);
        com.tencent.mm.sdk.b.a.xmy.m(new kn());
    }

    public final void init() {
        List arrayList = new ArrayList();
        for (com.tencent.mm.storage.c cVar : com.tencent.mm.y.c.c.IL().WV("10001").values()) {
            d dVar = new d();
            if (cVar == null) {
                x.i("MicroMsg.SnsABTestStrategy", "abtest is null");
            } else if (cVar.isValid()) {
                Map civ = cVar.civ();
                if (civ != null) {
                    x.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + cVar.field_expId + " " + cVar.field_layerId + " " + cVar.field_startTime + " " + cVar.field_endTime);
                    dVar.d(cVar.field_layerId, cVar.field_expId, civ);
                    int i = (!dVar.fsk || dVar.rgw == null || dVar.rgw.size() <= 0) ? 0 : 1;
                    if (i != 0) {
                        arrayList.add(dVar);
                    }
                }
            } else {
                x.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
            }
        }
        this.rfW = arrayList;
        this.rfZ.clear();
        this.rga.clear();
        this.rgc.clear();
        this.ras = null;
        if (this.rfW != null && this.rfW.size() != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            g.Dr();
            String stringBuilder2 = stringBuilder.append(g.Dq().cachePath).append("ws_1100004").toString();
            x.i("MicroMsg.SnSABTestMgr", "filepath to list  " + stringBuilder2);
            byte[] d = FileOp.d(stringBuilder2, 0, -1);
            if (d != null) {
                try {
                    this.ras = (com.tencent.mm.plugin.sns.g.c) new com.tencent.mm.plugin.sns.g.c().aH(d);
                    x.i("MicroMsg.SnSABTestMgr", "fileToList " + (System.currentTimeMillis() - currentTimeMillis));
                    if (this.ras == null) {
                        x.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId parser error");
                    } else {
                        x.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId size " + this.ras.rgM.size());
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SnSABTestMgr", e, "", new Object[0]);
                    FileOp.deleteFile(stringBuilder2);
                }
            }
        }
    }

    private void eJ(long j) {
        if (this.ras == null) {
            this.ras = new com.tencent.mm.plugin.sns.g.c();
        }
        if (this.ras.rgM.size() > 500) {
            this.ras.rgM.remove(0);
        }
        this.ras.rgM.add(Long.valueOf(j));
    }

    public final void clean() {
        this.rfX = null;
        this.rfY = null;
        if (this.rga != null) {
            Iterator it = this.rga.iterator();
            while (it.hasNext()) {
                Long l = (Long) it.next();
                k qVar = new q(l.longValue(), 0, 0, null);
                g.Dr();
                g.Dp().gRu.a(qVar, 0);
                x.i("MicroMsg.SnSABTestMgr", "report id " + l);
            }
        }
        if (this.rgc != null) {
            for (a a : this.rgc.values()) {
                a(a);
            }
            this.rgc.clear();
        }
        if (this.rfW.size() != 0 && this.ras != null) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            g.Dr();
            String stringBuilder2 = stringBuilder.append(g.Dq().cachePath).append("ws_1100004").toString();
            x.i("MicroMsg.SnSABTestMgr", "listToFile to list  " + stringBuilder2);
            try {
                byte[] toByteArray = this.ras.toByteArray();
                com.tencent.mm.a.e.b(stringBuilder2, toByteArray, toByteArray.length);
                x.i("MicroMsg.SnSABTestMgr", "listTofile " + (System.currentTimeMillis() - currentTimeMillis) + " igNoreAbTestId " + this.ras.rgM.size());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnSABTestMgr", e, "listToFile failed: " + stringBuilder2, new Object[0]);
            }
        }
    }

    public static void c(View view, com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        cVar.rUt = false;
        cVar.rUs = (ViewStub) view.findViewById(f.qLo);
        cVar.rUs.setVisibility(8);
        cVar.rUx = (ViewStub) view.findViewById(f.qKD);
        cVar.rUx.setVisibility(8);
    }

    public final void a(android.content.Context r21, com.tencent.mm.protocal.c.blf r22, com.tencent.mm.plugin.sns.ui.a.a.c r23) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r20 = this;
        r2 = com.tencent.mm.sdk.platformtools.w.cfS();
        if (r2 != 0) goto L_0x000a;
    L_0x0006:
        b(r23);
    L_0x0009:
        return;
    L_0x000a:
        r0 = r20;
        r2 = r0.rfW;
        if (r2 == 0) goto L_0x001a;
    L_0x0010:
        r0 = r20;
        r2 = r0.rfW;
        r2 = r2.size();
        if (r2 != 0) goto L_0x001e;
    L_0x001a:
        b(r23);
        goto L_0x0009;
    L_0x001e:
        r0 = r20;
        r2 = r0.rgb;
        r0 = r22;
        r4 = r0.vWS;
        r3 = java.lang.Long.valueOf(r4);
        r2 = r2.contains(r3);
        if (r2 == 0) goto L_0x004f;
    L_0x0030:
        b(r23);
        r0 = r23;
        r2 = r0.rUP;
        r3 = 8;
        r2.setVisibility(r3);
        r0 = r23;
        r2 = r0.ikK;
        r3 = 8;
        r2.setVisibility(r3);
        r0 = r23;
        r2 = r0.nav;
        r3 = 8;
        r2.setVisibility(r3);
        goto L_0x0009;
    L_0x004f:
        r0 = r22;
        r2 = r0.vPp;
        if (r2 == 0) goto L_0x0063;
    L_0x0055:
        r0 = r22;
        r2 = r0.vPp;
        r3 = com.tencent.mm.plugin.sns.model.ae.bvL();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0067;
    L_0x0063:
        b(r23);
        goto L_0x0009;
    L_0x0067:
        r0 = r20;
        r2 = r0.ras;
        if (r2 == 0) goto L_0x0085;
    L_0x006d:
        r0 = r20;
        r2 = r0.ras;
        r2 = r2.rgM;
        r0 = r22;
        r4 = r0.vWS;
        r3 = java.lang.Long.valueOf(r4);
        r2 = r2.contains(r3);
        if (r2 == 0) goto L_0x0085;
    L_0x0081:
        b(r23);
        goto L_0x0009;
    L_0x0085:
        r2 = 0;
        if (r22 == 0) goto L_0x02b4;
    L_0x0088:
        r0 = r22;	 Catch:{ Exception -> 0x00d8 }
        r2 = r0.wVe;	 Catch:{ Exception -> 0x00d8 }
        r2 = com.tencent.mm.platformtools.n.a(r2);	 Catch:{ Exception -> 0x00d8 }
        r3 = com.tencent.mm.sdk.platformtools.bi.by(r2);	 Catch:{ Exception -> 0x00d8 }
        if (r3 == 0) goto L_0x00c9;
    L_0x0096:
        r2 = 0;
        r3 = r2;
    L_0x0098:
        r2 = 0;
        r0 = r20;
        r4 = r0.rfZ;
        r0 = r22;
        r6 = r0.vWS;
        r5 = java.lang.Long.valueOf(r6);
        r4 = r4.containsKey(r5);
        if (r4 == 0) goto L_0x00dc;
    L_0x00ab:
        r0 = r20;
        r2 = r0.rfZ;
        r0 = r22;
        r4 = r0.vWS;
        r4 = java.lang.Long.valueOf(r4);
        r2 = r2.get(r4);
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        r4 = -1;
        if (r2 != r4) goto L_0x00dc;
    L_0x00c4:
        b(r23);
        goto L_0x0009;
    L_0x00c9:
        r3 = new com.tencent.mm.protocal.c.bln;	 Catch:{ Exception -> 0x00d8 }
        r3.<init>();	 Catch:{ Exception -> 0x00d8 }
        r2 = r3.aH(r2);	 Catch:{ Exception -> 0x00d8 }
        r2 = (com.tencent.mm.protocal.c.bln) r2;	 Catch:{ Exception -> 0x00d8 }
        r2 = r2.wVp;	 Catch:{ Exception -> 0x00d8 }
        r3 = r2;
        goto L_0x0098;
    L_0x00d8:
        r2 = move-exception;
        r2 = 0;
        r3 = r2;
        goto L_0x0098;
    L_0x00dc:
        r4 = r2;
        r9 = 0;
        r0 = r20;
        r2 = r0.rfW;
        r5 = r2.iterator();
    L_0x00e6:
        r2 = r5.hasNext();
        if (r2 == 0) goto L_0x00fe;
    L_0x00ec:
        r2 = r5.next();
        r2 = (com.tencent.mm.plugin.sns.f.d) r2;
        if (r2 != 0) goto L_0x00f9;
    L_0x00f4:
        b(r23);
        goto L_0x0009;
    L_0x00f9:
        r6 = r2.rgv;
        if (r6 != r3) goto L_0x00e6;
    L_0x00fd:
        r9 = r2;
    L_0x00fe:
        if (r9 != 0) goto L_0x0105;
    L_0x0100:
        b(r23);
        goto L_0x0009;
    L_0x0105:
        r2 = r9.rgw;
        r2 = r2.size();
        if (r4 < r2) goto L_0x0112;
    L_0x010d:
        b(r23);
        goto L_0x0009;
    L_0x0112:
        r2 = r9.rgw;
        r17 = r2.get(r4);
        r17 = (com.tencent.mm.plugin.sns.f.d.b) r17;
        r0 = r17;
        r10 = r0.showType;
        b(r23);
        if (r3 <= 0) goto L_0x02af;
    L_0x0123:
        r0 = r20;
        r2 = r0.rgc;
        r0 = r22;
        r4 = r0.vWS;
        r3 = java.lang.Long.valueOf(r4);
        r2 = r2.containsKey(r3);
        if (r2 != 0) goto L_0x021f;
    L_0x0135:
        r3 = new com.tencent.mm.plugin.sns.f.c$a;
        r4 = java.lang.System.currentTimeMillis();
        r0 = r22;
        r6 = r0.vWS;
        r0 = r22;
        r12 = r0.vWS;
        r8 = com.tencent.mm.plugin.sns.data.i.er(r12);
        r3.<init>(r4, r6, r8, r9);
        r0 = r17;
        r2 = r0.iSI;
        r2 = r2.size();
        r3.dA(r10, r2);
        r0 = r20;
        r2 = r0.rgc;
        r0 = r22;
        r4 = r0.vWS;
        r4 = java.lang.Long.valueOf(r4);
        r2.put(r4, r3);
    L_0x0164:
        r2 = 1;
        if (r10 != r2) goto L_0x0288;
    L_0x0167:
        r0 = r17;
        r3 = r0.title;
        r0 = r23;
        r2 = r0.rUt;
        if (r2 != 0) goto L_0x01a2;
    L_0x0171:
        r0 = r23;
        r2 = r0.rUs;
        r2 = r2.inflate();
        r0 = r23;
        r0.rUu = r2;
        r2 = 1;
        r0 = r23;
        r0.rUt = r2;
        r0 = r23;
        r2 = r0.rUu;
        r4 = com.tencent.mm.plugin.sns.i.f.qJb;
        r2 = r2.findViewById(r4);
        r2 = (android.widget.TextView) r2;
        r0 = r23;
        r0.rUw = r2;
        r0 = r23;
        r2 = r0.rUu;
        r4 = com.tencent.mm.plugin.sns.i.f.qGe;
        r2 = r2.findViewById(r4);
        r2 = (android.widget.LinearLayout) r2;
        r0 = r23;
        r0.rUv = r2;
    L_0x01a2:
        r0 = r23;
        r2 = r0.rUu;
        r4 = 0;
        r2.setVisibility(r4);
        r0 = r23;
        r2 = r0.rUw;
        r2.setText(r3);
        r0 = r17;
        r4 = r0.iSI;
        r2 = r4.size();
        r0 = r23;
        r3 = r0.rUv;
        r3 = r3.getChildCount();
        if (r2 == r3) goto L_0x023e;
    L_0x01c3:
        r0 = r23;
        r2 = r0.rUv;
        r2.removeAllViews();
        r2 = 0;
        r3 = r2;
    L_0x01cc:
        r2 = r4.size();
        if (r3 >= r2) goto L_0x023e;
    L_0x01d2:
        r2 = r4.get(r3);
        r2 = (com.tencent.mm.plugin.sns.f.d.a) r2;
        r5 = new android.widget.TextView;
        r0 = r23;
        r6 = r0.rUv;
        r6 = r6.getContext();
        r5.<init>(r6);
        r2 = r2.rgx;
        r5.setText(r2);
        r2 = 0;
        r6 = 0;
        r7 = 10;
        r0 = r21;
        r7 = com.tencent.mm.bu.a.fromDPToPix(r0, r7);
        r8 = 0;
        r5.setPadding(r2, r6, r7, r8);
        r2 = 0;
        r5.setVisibility(r2);
        r2 = 1;
        r6 = 1096810496; // 0x41600000 float:14.0 double:5.41896386E-315;
        r7 = com.tencent.mm.bu.a.ev(r21);
        r6 = r6 * r7;
        r5.setTextSize(r2, r6);
        r2 = r21.getResources();
        r6 = com.tencent.mm.plugin.sns.i.c.btS;
        r2 = r2.getColor(r6);
        r5.setTextColor(r2);
        r0 = r23;
        r2 = r0.rUv;
        r2.addView(r5);
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x01cc;
    L_0x021f:
        r0 = r20;
        r2 = r0.rgc;
        r0 = r22;
        r4 = r0.vWS;
        r3 = java.lang.Long.valueOf(r4);
        r2 = r2.get(r3);
        r2 = (com.tencent.mm.plugin.sns.f.c.a) r2;
        r0 = r17;
        r3 = r0.iSI;
        r3 = r3.size();
        r2.dA(r10, r3);
        goto L_0x0164;
    L_0x023e:
        r2 = 0;
    L_0x023f:
        r3 = r4.size();
        if (r2 >= r3) goto L_0x0009;
    L_0x0245:
        r16 = r4.get(r2);
        r16 = (com.tencent.mm.plugin.sns.f.d.a) r16;
        r0 = r23;
        r3 = r0.rUv;
        r12 = r3.getChildAt(r2);
        r12 = (android.widget.TextView) r12;
        r3 = com.tencent.mm.plugin.sns.f.f.a(r16);
        r0 = r22;
        r13 = a(r3, r0);
        r10 = r20;
        r11 = r21;
        r14 = r22;
        r15 = r23;
        r18 = r9;
        r3 = r10.a(r11, r12, r13, r14, r15, r16, r17, r18);
        r12.setText(r3);
        r0 = r22;
        r12.setTag(r0);
        r13 = new com.tencent.mm.plugin.sns.f.c$1;
        r14 = r20;
        r15 = r21;
        r18 = r23;
        r19 = r9;
        r13.<init>(r15, r16, r17, r18, r19);
        r12.setOnClickListener(r13);
        r2 = r2 + 1;
        goto L_0x023f;
    L_0x0288:
        r2 = 4;
        if (r10 != r2) goto L_0x029a;
    L_0x028b:
        r13 = r20;
        r14 = r21;
        r15 = r22;
        r16 = r23;
        r18 = r9;
        r13.a(r14, r15, r16, r17, r18);
        goto L_0x0009;
    L_0x029a:
        r2 = 2;
        if (r10 != r2) goto L_0x02af;
    L_0x029d:
        r13 = r20;
        r14 = r21;
        r15 = r22;
        r16 = r23;
        r18 = r9;
        r2 = r13.b(r14, r15, r16, r17, r18);
        if (r2 == 0) goto L_0x0009;
    L_0x02ad:
        goto L_0x0009;
    L_0x02af:
        b(r23);
        goto L_0x0009;
    L_0x02b4:
        r3 = r2;
        goto L_0x0098;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.f.c.a(android.content.Context, com.tencent.mm.protocal.c.blf, com.tencent.mm.plugin.sns.ui.a.a$c):void");
    }

    private boolean a(Context context, blf blf, com.tencent.mm.plugin.sns.ui.a.a.c cVar, b bVar, d dVar) {
        cVar.nav.setBackgroundDrawable(null);
        int i = cVar.position - 1;
        if (this.rfY != null) {
            WeakReference weakReference = (WeakReference) this.rfY.rNu.get(Integer.valueOf(i));
            if (!(weakReference == null || weakReference.get() == null)) {
                ((View) weakReference.get()).setBackgroundDrawable(null);
            }
        }
        if (!cVar.rUy) {
            cVar.rUz = cVar.rUx.inflate();
            cVar.rUy = true;
            cVar.rUA = (LinearLayout) cVar.rUz.findViewById(f.qJz);
        }
        cVar.rUz.setVisibility(0);
        cVar.rUP.setVisibility(8);
        cVar.ikK.setVisibility(8);
        List list = bVar.iSI;
        if (list.size() != cVar.rUA.getChildCount()) {
            cVar.rUA.removeAllViews();
            int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(context, 10);
            for (i = 0; i < list.size(); i++) {
                View textView = new TextView(context);
                textView.setBackgroundResource(i.e.qEV);
                textView.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
                textView.setTextSize(1, 14.0f * com.tencent.mm.bu.a.ev(context));
                textView.setTextColor(context.getResources().getColor(com.tencent.mm.plugin.sns.i.c.black));
                cVar.rUA.addView(textView);
            }
        }
        i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return true;
            }
            final a aVar = (a) list.get(i2);
            TextView textView2 = (TextView) cVar.rUA.getChildAt(i2);
            textView2.setText(aVar.rgx);
            textView2.setTag(blf);
            String a = a(f.a(aVar), blf);
            final Context context2 = context;
            final b bVar2 = bVar;
            final com.tencent.mm.plugin.sns.ui.a.a.c cVar2 = cVar;
            final d dVar2 = dVar;
            textView2.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    c.a(c.this, context2, view, aVar, bVar2, cVar2, dVar2);
                }
            });
            textView2.setText(a(context, textView2, a, blf, cVar, aVar, bVar, dVar), BufferType.SPANNABLE);
            if (aVar.actionType != 5) {
                textView2.setCompoundDrawablePadding(com.tencent.mm.bu.a.fromDPToPix(context, 5));
                textView2.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(i.i.qOA), null, null, null);
            }
            i = i2 + 1;
        }
    }

    private boolean b(Context context, blf blf, com.tencent.mm.plugin.sns.ui.a.a.c cVar, b bVar, d dVar) {
        if (bVar.iSI.size() != 2) {
            return false;
        }
        final a aVar = (a) bVar.iSI.get(0);
        a aVar2 = (a) bVar.iSI.get(1);
        String a = a(f.a(aVar), blf);
        String a2 = a(f.a(aVar2), blf);
        String a3 = a(bVar.title, blf);
        String string = context.getString(j.dGZ);
        final Context context2 = context;
        final blf blf2 = blf;
        final b bVar2 = bVar;
        final com.tencent.mm.plugin.sns.ui.a.a.c cVar2 = cVar;
        final d dVar2 = dVar;
        AnonymousClass3 anonymousClass3 = new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                x.i("MicroMsg.SnSABTestMgr", "onClick alert1");
                c.this.a(context2, blf2, aVar, bVar2, cVar2, dVar2);
            }
        };
        final Context context3 = context;
        final blf blf3 = blf;
        final a aVar3 = aVar2;
        final b bVar3 = bVar;
        final com.tencent.mm.plugin.sns.ui.a.a.c cVar3 = cVar;
        final d dVar3 = dVar;
        h.a(context, a3, string, a, a2, (DialogInterface.OnClickListener) anonymousClass3, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                x.i("MicroMsg.SnSABTestMgr", "onClick alert2");
                c.this.a(context3, blf3, aVar3, bVar3, cVar3, dVar3);
            }
        });
        return true;
    }

    private void a(com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (cVar != null) {
            Context context = cVar.nav.getContext();
            if (context != null) {
                if (cVar.nav.getBackground() == null) {
                    cVar.nav.setBackgroundResource(i.e.bBy);
                    cVar.nav.setPadding(com.tencent.mm.bu.a.fromDPToPix(context, 12), com.tencent.mm.bu.a.fromDPToPix(context, 12), com.tencent.mm.bu.a.fromDPToPix(context, 12), com.tencent.mm.bu.a.fromDPToPix(context, 8));
                }
                int i = cVar.position - 1;
                if (this.rfY != null) {
                    WeakReference weakReference = (WeakReference) this.rfY.rNu.get(Integer.valueOf(i));
                    if (weakReference != null && weakReference.get() != null) {
                        ((View) weakReference.get()).setBackgroundResource(i.e.bBy);
                        ((View) weakReference.get()).setPadding(com.tencent.mm.bu.a.fromDPToPix(context, 12), com.tencent.mm.bu.a.fromDPToPix(context, 12), com.tencent.mm.bu.a.fromDPToPix(context, 12), com.tencent.mm.bu.a.fromDPToPix(context, 8));
                    }
                }
            }
        }
    }

    private void a(Context context, blf blf, a aVar, b bVar, com.tencent.mm.plugin.sns.ui.a.a.c cVar, d dVar) {
        x.i("MicroMsg.SnSABTestMgr", "processButtonClick snsobj " + blf.vPp + " " + blf.vWS);
        int i = aVar.rgz - 1;
        a aVar2 = (a) this.rgc.get(Long.valueOf(blf.vWS));
        if (aVar2 != null) {
            aVar2.q(bVar.showType, bVar.iSI.size(), aVar.index, aVar.actionType);
            aVar2.rgq = -1;
            aVar2.rgr = -1;
        }
        String str;
        if (aVar.actionType == 3) {
            this.rga.add(Long.valueOf(blf.vWS));
            this.rfZ.put(Long.valueOf(blf.vWS), Integer.valueOf(i));
        } else if (aVar.actionType == 1) {
            this.rfZ.put(Long.valueOf(blf.vWS), Integer.valueOf(i));
            eJ(blf.vWS);
            b(cVar);
        } else if (aVar.actionType == 5) {
            if (this.rga.contains(Long.valueOf(blf.vWS))) {
                this.rga.remove(Long.valueOf(blf.vWS));
                eJ(blf.vWS);
                b(cVar);
                if (this.rgc.containsKey(Long.valueOf(blf.vWS))) {
                    a((a) this.rgc.remove(Long.valueOf(blf.vWS)));
                }
            }
            this.rfZ.put(Long.valueOf(blf.vWS), Integer.valueOf(-1));
            a(cVar);
            return;
        } else if (aVar.actionType == 7) {
            if (i < dVar.rgw.size()) {
                b bVar2 = (b) dVar.rgw.get(i);
                if (bVar2.showType == 2) {
                    b(context, blf, cVar, bVar2, dVar);
                    return;
                } else if (bVar2.showType == 5) {
                    u.makeText(context, bi.aD(bVar2.title, ""), 0).show();
                    eJ(blf.vWS);
                    b(cVar);
                    return;
                }
            }
        } else if (aVar.actionType == 6) {
            u.makeText(context, bi.aD(context.getString(j.qPU), ""), 0).show();
            this.rgb.add(Long.valueOf(blf.vWS));
            b(cVar);
            com.tencent.mm.sdk.b.a.xmy.m(new ko());
            a(cVar);
            return;
        } else if (aVar.actionType == 2) {
            str = aVar.jumpUrl;
            x.i("MicroMsg.SnSABTestMgr", "jump url " + str);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("useJs", true);
            com.tencent.mm.plugin.sns.c.a.ihN.j(intent, context);
            eJ(blf.vWS);
            b(cVar);
            a(cVar);
            return;
        } else if (aVar.actionType == 8) {
            return;
        } else {
            if (aVar.actionType == 4) {
                str = blf.vPp;
                List linkedList = new LinkedList();
                linkedList.add(str);
                k vVar = new v(1, 5, "", linkedList.size(), linkedList, 0);
                g.Dr();
                g.Dp().gRu.a(vVar, 0);
            }
        }
        if (i == 4 || i == 1) {
            a(context, blf, cVar);
        }
    }

    private static void b(com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (cVar != null) {
            if (cVar.rUs != null) {
                cVar.rUs.setVisibility(8);
            }
            if (cVar.rUu != null) {
                cVar.rUu.setVisibility(8);
            }
            if (cVar.rUx != null) {
                cVar.rUx.setVisibility(8);
            }
            if (cVar.rUz != null) {
                cVar.rUz.setVisibility(8);
            }
            if (cVar.rUP.getVisibility() == 8) {
                cVar.rUP.setVisibility(0);
            }
            if (cVar.ikK.getVisibility() == 8) {
                cVar.ikK.setVisibility(0);
            }
            if (cVar.nav.getVisibility() == 8) {
                cVar.nav.setVisibility(0);
            }
        }
    }

    private static String a(String str, blf blf) {
        Throwable e;
        String str2;
        try {
            if (bi.oN(str)) {
                return "";
            }
            int i;
            String str3 = blf.vPp;
            g.Dr();
            ag Xv = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xv(str3);
            if (str.contains("{username}")) {
                str = str.replace("{username}", Xv.AX());
            }
            if (Xv.fXa == 1) {
                i = 0;
            } else if (Xv.fXa == 2) {
                i = 1;
            } else {
                i = 2;
            }
            while (true) {
                str2 = str;
                Matcher matcher = rge.matcher(str2);
                if (!matcher.find() || matcher.groupCount() != 3) {
                    return str2;
                }
                CharSequence group;
                CharSequence group2 = matcher.group();
                if (i == 0) {
                    group = matcher.group(1);
                } else if (i == 1) {
                    try {
                        group = matcher.group(2);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } else {
                    group = matcher.group(3);
                }
                str = str2.replace(group2, group);
            }
        } catch (Throwable e3) {
            e = e3;
            str2 = str;
            x.printErrStackTrace("MicroMsg.SnSABTestMgr", e, "settext error ", new Object[0]);
            return str2;
        }
    }

    private SpannableString a(Context context, TextView textView, String str, blf blf, com.tencent.mm.plugin.sns.ui.a.a.c cVar, a aVar, b bVar, d dVar) {
        Matcher matcher = rgd.matcher(str);
        if (!matcher.find() || matcher.groupCount() != 1) {
            return com.tencent.mm.pluginsdk.ui.d.i.a(context, (CharSequence) str);
        }
        CharSequence group = matcher.group();
        Object group2 = matcher.group(1);
        int indexOf = str.indexOf(group);
        CharSequence replace = str.replace(group, group2);
        textView.setOnClickListener(null);
        textView.setClickable(true);
        SpannableString spannableString = new SpannableString(replace);
        textView.setOnTouchListener(new ab());
        final Context context2 = context;
        final blf blf2 = blf;
        final a aVar2 = aVar;
        final b bVar2 = bVar;
        final com.tencent.mm.plugin.sns.ui.a.a.c cVar2 = cVar;
        final d dVar2 = dVar;
        spannableString.setSpan(new n(blf.vPp, new com.tencent.mm.pluginsdk.ui.d.n.a() {
            public final void bK(Object obj) {
                c.this.a(context2, blf2, aVar2, bVar2, cVar2, dVar2);
            }
        }), indexOf, group2.length() + indexOf, 33);
        return spannableString;
    }

    public final void a(int i, String str, long j, String str2, bpb bpb, boolean z, bf bfVar) {
    }

    public final void a(int i, String str, long j, String str2, bpb bpb, boolean z) {
        if (this.rgc.containsKey(Long.valueOf(j))) {
            a aVar = (a) this.rgc.get(Long.valueOf(j));
            if (aVar.mEndTime == -1) {
                aVar.mEndTime = System.currentTimeMillis();
            }
            aVar.q(aVar.rgq, aVar.rgr, 0, 0);
        }
    }

    private static void a(a aVar) {
        d dVar = aVar.rgp;
        if (dVar != null) {
            String str = dVar.rfU;
            String str2 = dVar.rfT;
            String str3 = aVar.rgu;
            aVar.q(aVar.rgq, aVar.rgr, 0, 0);
            String str4 = aVar.rgt;
            if (bi.oN(str4)) {
                str4 = aVar.rgq + ":" + aVar.rgr + ":0:0";
            }
            String str5 = "";
            long j = aVar.mStartTime / 1000;
            if (aVar.mEndTime == -1) {
                aVar.mEndTime = System.currentTimeMillis();
            }
            long j2 = aVar.mEndTime / 1000;
            if (aVar != null) {
                x.i("MicroMsg.SnSABTestMgr", "report layerId: " + str + " expid " + str2 + " acton " + str4 + " starttime " + j + " timelineId: " + str3);
                com.tencent.mm.plugin.report.service.g.pWK.h(11917, str, str2, str5, str5, Integer.valueOf(1), str3, str4, Long.valueOf(j), Long.valueOf(j2));
            }
        }
    }
}
