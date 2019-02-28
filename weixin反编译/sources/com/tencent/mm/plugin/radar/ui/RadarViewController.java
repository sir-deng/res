package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.c.b.i;
import b.c.b.j;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.radar.b.c.m;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.c.bbo;
import com.tencent.mm.protocal.c.bbp;
import com.tencent.mm.protocal.c.bbr;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public final class RadarViewController extends RelativeLayout implements com.tencent.mm.plugin.radar.b.c.c, com.tencent.mm.plugin.radar.b.e.d {
    private static final String TAG = TAG;
    static final /* synthetic */ b.e.d[] pDC = new b.e.d[]{j.a(new i(j.R(RadarViewController.class), "waveView", "getWaveView()Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;")), j.a(new i(j.R(RadarViewController.class), "memberDetailView", "getMemberDetailView()Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;")), j.a(new i(j.R(RadarViewController.class), "grid", "getGrid()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;")), j.a(new i(j.R(RadarViewController.class), "radarTips", "getRadarTips()Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;")), j.a(new i(j.R(RadarViewController.class), "newRadarTip", "getNewRadarTip()Landroid/widget/TextView;")), j.a(new i(j.R(RadarViewController.class), "newRadarTipLoading", "getNewRadarTipLoading()Landroid/widget/ProgressBar;")), j.a(new i(j.R(RadarViewController.class), "quitBtn", "getQuitBtn()Landroid/widget/Button;")), j.a(new i(j.R(RadarViewController.class), "radarBgMask", "getRadarBgMask()Landroid/view/View;"))};
    public static final b pFD = new b();
    private final int pFA = 33554432;
    private final int pFB = (this.pFA + 1);
    private final int pFC = (this.pFA + 2);
    private final b.b pFm = b.c.b(new h(this));
    private final b.b pFn = i.C(this, com.tencent.mm.plugin.radar.a.c.pBl);
    private final b.b pFo = i.C(this, com.tencent.mm.plugin.radar.a.c.pBA);
    private final b.b pFp = i.C(this, com.tencent.mm.plugin.radar.a.c.pBC);
    private final b.b pFq = i.C(this, com.tencent.mm.plugin.radar.a.c.pBq);
    private final b.b pFr = i.C(this, com.tencent.mm.plugin.radar.a.c.pBr);
    private final b.b pFs = i.C(this, com.tencent.mm.plugin.radar.a.c.pBu);
    private final b.b pFt = i.C(this, com.tencent.mm.plugin.radar.a.c.pBh);
    com.tencent.mm.plugin.radar.b.e pFu;
    com.tencent.mm.plugin.radar.b.c pFv;
    c pFw;
    com.tencent.mm.plugin.radar.b.e.e pFx = com.tencent.mm.plugin.radar.b.e.e.SEARCHING;
    private final boolean pFy;
    final OnClickListener pFz = new f(this);

    private final class a {
        private int pFE;
        final boolean pFF;
        final a pFG = new a(this);

        public static final class a extends ag {
            final /* synthetic */ a pFI;

            a(a aVar) {
                this.pFI = aVar;
            }

            public final void handleMessage(Message message) {
                b.c.b.e.i(message, "msg");
                if (message.obj instanceof View) {
                    Object obj = message.obj;
                    if (obj == null) {
                        throw new b.i("null cannot be cast to non-null type android.view.View");
                    }
                    View view = (View) obj;
                    view.setVisibility(0);
                    view.clearAnimation();
                    if (!this.pFI.pFF) {
                        Object tag = view.getTag(RadarViewController.this.pFC);
                        if (!(tag instanceof Animation)) {
                            tag = null;
                        }
                        Animation animation = (Animation) tag;
                        if (animation == null) {
                            animation = this.pFI.getInAnimation();
                        }
                        view.startAnimation(animation);
                    }
                }
            }
        }

        public a() {
            g gVar = g.pFl;
            Object context = RadarViewController.this.getContext();
            b.c.b.e.h(context, "context");
            this.pFF = g.dp(context);
        }

        public final Animation getInAnimation() {
            Object loadAnimation = AnimationUtils.loadAnimation(RadarViewController.this.getContext(), com.tencent.mm.plugin.radar.a.a.pBa);
            b.c.b.e.h(loadAnimation, "AnimationUtils.loadAnima…anim.radar_user_turn_out)");
            return loadAnimation;
        }

        public final int bmP() {
            this.pFE++;
            return this.pFE;
        }

        public final void h(int i, View view) {
            b.c.b.e.i(view, "view");
            Message obtainMessage = this.pFG.obtainMessage();
            obtainMessage.what = cq(view);
            obtainMessage.obj = view;
            view.setVisibility(4);
            this.pFG.sendMessageDelayed(obtainMessage, (long) ((i + 1) * 500));
        }

        final int cq(View view) {
            Object tag = view.getTag(RadarViewController.this.pFB);
            if (!(tag instanceof Integer)) {
                tag = null;
            }
            Integer num = (Integer) tag;
            return num != null ? num.intValue() : -1;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    public static final class e implements com.tencent.mm.plugin.radar.ui.RadarMemberView.b {
        final /* synthetic */ RadarViewController pFH;

        e(RadarViewController radarViewController) {
            this.pFH = radarViewController;
        }

        public final void a(bbr bbr, com.tencent.mm.plugin.radar.b.c.e eVar) {
            b.c.b.e.i(bbr, "member");
            g gVar = g.pFl;
            String b = g.b(bbr);
            if (eVar != null) {
                switch (h.pDt[eVar.ordinal()]) {
                    case 1:
                        RadarViewController.c(this.pFH).pCU.put(Long.valueOf(this.pFH.pFv.ID(b)), new com.tencent.mm.plugin.radar.b.e.c(bbr, eVar));
                        this.pFH.d(b, com.tencent.mm.plugin.radar.b.c.e.Verifying);
                        return;
                    case 2:
                        int i;
                        String str;
                        String username;
                        int i2;
                        long j;
                        com.tencent.mm.plugin.radar.b.c e = this.pFH.pFv;
                        b.c.b.e.i(b, "username");
                        Object h = com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class);
                        b.c.b.e.h(h, "service(IMessengerStorage::class.java)");
                        Object Xv = ((com.tencent.mm.plugin.messenger.foundation.a.h) h).Ff().Xv(b);
                        b.c.b.e.h(Xv, "contact");
                        CharSequence username2 = Xv.getUsername();
                        if (username2 == null || b.f.g.Y(username2)) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (i != 0) {
                            str = b;
                        } else {
                            username = Xv.getUsername();
                            b.c.b.e.h((Object) username, "contact.username");
                            str = username;
                        }
                        username = (String) e.pCh.get(str);
                        CharSequence charSequence = username;
                        if (charSequence == null || b.f.g.Y(charSequence)) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        if (i2 != 0) {
                            com.tencent.mm.plugin.radar.b.c.b bVar = com.tencent.mm.plugin.radar.b.c.pCl;
                            x.e(com.tencent.mm.plugin.radar.b.c.TAG, "Verify Contact username(%s) error, verifyTicket is null", str);
                            e.ID(str);
                            j = -1;
                        } else {
                            com.tencent.mm.storage.au.d Yb = com.tencent.mm.storage.au.d.Yb(username);
                            long currentTimeMillis = System.currentTimeMillis();
                            com.tencent.mm.plugin.radar.b.c.a aVar = new com.tencent.mm.plugin.radar.b.c.a(new m(e, username, currentTimeMillis));
                            Xv = Yb.ckx();
                            b.c.b.e.h(Xv, "verify.verifyTicket");
                            b.c.b.e.i(Xv, "verifyTicket");
                            String str2 = "username is null";
                            boolean z = str != null && str.length() > 0;
                            Assert.assertTrue(str2, z);
                            aVar.onStart();
                            com.tencent.mm.kernel.g.CN().d((k) new o(str, Xv, 48));
                            j = currentTimeMillis;
                        }
                        RadarViewController.c(this.pFH).pCU.put(Long.valueOf(j), new com.tencent.mm.plugin.radar.b.e.c(bbr, eVar));
                        this.pFH.d(b, com.tencent.mm.plugin.radar.b.c.e.Verifying);
                        return;
                    default:
                        return;
                }
            }
        }

        public final void b(bbr bbr, com.tencent.mm.plugin.radar.b.c.e eVar) {
            Object b;
            if (bbr != null) {
                g gVar = g.pFl;
                b = g.b(bbr);
            } else {
                b = null;
            }
            View view = (View) RadarViewController.d(this.pFH).pFO.get(b);
            if (view != null) {
                Object tag = view.getTag();
                if (tag == null) {
                    throw new b.i("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
                }
                a aVar = (a) tag;
                if (eVar != com.tencent.mm.plugin.radar.b.c.e.Stranger) {
                    aVar.pFS.bmu();
                }
            }
            this.pFH.bmG().bmQ();
        }
    }

    public final class c extends a {
        private final Context context;
        final /* synthetic */ RadarViewController pFH;
        bbr[] pFJ = new bbr[12];
        HashMap<String, String> pFK = new HashMap();
        HashMap<String, Integer> pFL = new HashMap();
        final a pFM;
        private int pFN;
        HashMap<String, View> pFO = new HashMap();
        private boolean pFP;

        public final class a {
            TextView pFQ;
            ImageView pFR;
            RadarStateView pFS;
            RadarStateChooseView pFT;
            ImageView pFU;
            final /* synthetic */ c pFV;

            public a(c cVar, TextView textView, ImageView imageView, RadarStateView radarStateView, RadarStateChooseView radarStateChooseView, ImageView imageView2) {
                b.c.b.e.i(textView, "tvMemberName");
                b.c.b.e.i(imageView, "ivMemberAvatar");
                b.c.b.e.i(radarStateView, "vMemberState");
                b.c.b.e.i(radarStateChooseView, "vMemberChooseState");
                b.c.b.e.i(imageView2, "ivMemberAvatarMask");
                this.pFV = cVar;
                this.pFQ = textView;
                this.pFR = imageView;
                this.pFS = radarStateView;
                this.pFT = radarStateChooseView;
                this.pFU = imageView2;
            }
        }

        public c(RadarViewController radarViewController, RadarSpecialGridView radarSpecialGridView, Context context) {
            b.c.b.e.i(radarSpecialGridView, "radarGridView");
            b.c.b.e.i(context, "context");
            this.pFH = radarViewController;
            super(radarSpecialGridView, context);
            this.context = context;
            this.pFM = new a();
        }

        public final int getCount() {
            if (this.pFP) {
                return 0;
            }
            return ((Object[]) this.pFJ).length;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void ad(java.util.LinkedList<com.tencent.mm.protocal.c.bbr> r11) {
            /*
            r10 = this;
            r3 = 1;
            r2 = 0;
            if (r11 == 0) goto L_0x000a;
        L_0x0004:
            r0 = r11.size();
            if (r0 == 0) goto L_0x000c;
        L_0x000a:
            if (r11 != 0) goto L_0x000d;
        L_0x000c:
            return;
        L_0x000d:
            r0 = r10;
            r0 = (com.tencent.mm.plugin.radar.ui.RadarViewController.c) r0;
            r1 = r0.pFJ;
            r1 = (java.lang.Object[]) r1;
            r5 = r1.length;
            r4 = r2;
        L_0x0016:
            if (r4 >= r5) goto L_0x0045;
        L_0x0018:
            r6 = r11.iterator();
        L_0x001c:
            r1 = r6.hasNext();
            if (r1 == 0) goto L_0x0041;
        L_0x0022:
            r1 = r6.next();
            r1 = (com.tencent.mm.protocal.c.bbr) r1;
            r7 = com.tencent.mm.plugin.radar.ui.g.pFl;
            r7 = com.tencent.mm.plugin.radar.ui.g.c(r1);
            r8 = com.tencent.mm.plugin.radar.ui.g.pFl;
            r8 = r0.pFJ;
            r8 = r8[r4];
            r8 = com.tencent.mm.plugin.radar.ui.g.c(r8);
            r7 = b.c.b.e.h(r7, r8);
            if (r7 == 0) goto L_0x001c;
        L_0x003e:
            r11.remove(r1);
        L_0x0041:
            r1 = r4 + 1;
            r4 = r1;
            goto L_0x0016;
        L_0x0045:
            r5 = r11.iterator();
        L_0x0049:
            r0 = r5.hasNext();
            if (r0 == 0) goto L_0x00bb;
        L_0x004f:
            r0 = r5.next();
            r0 = (com.tencent.mm.protocal.c.bbr) r0;
            r6 = java.lang.System.currentTimeMillis();
            r1 = (int) r6;
            r1 = r1 % 6;
            r6 = java.lang.Math.abs(r1);
            r1 = r10.pFJ;
            r7 = r1.length;
            r4 = r2;
        L_0x0064:
            if (r4 >= r7) goto L_0x0049;
        L_0x0066:
            r1 = r4 + r6;
            r8 = r1 % 12;
            r1 = 4;
            if (r8 == r1) goto L_0x0070;
        L_0x006d:
            r1 = 7;
            if (r8 != r1) goto L_0x0074;
        L_0x0070:
            r1 = r4 + 1;
            r4 = r1;
            goto L_0x0064;
        L_0x0074:
            r1 = r10.pFJ;
            r9 = r1[r8];
            if (r9 == 0) goto L_0x0098;
        L_0x007a:
            r1 = r9.kyG;
            r1 = (java.lang.CharSequence) r1;
            if (r1 == 0) goto L_0x0086;
        L_0x0080:
            r1 = b.f.g.Y(r1);
            if (r1 == 0) goto L_0x00b5;
        L_0x0086:
            r1 = r3;
        L_0x0087:
            if (r1 == 0) goto L_0x00b9;
        L_0x0089:
            r1 = r9.wjz;
            r1 = (java.lang.CharSequence) r1;
            if (r1 == 0) goto L_0x0095;
        L_0x008f:
            r1 = b.f.g.Y(r1);
            if (r1 == 0) goto L_0x00b7;
        L_0x0095:
            r1 = r3;
        L_0x0096:
            if (r1 == 0) goto L_0x00b9;
        L_0x0098:
            r1 = r3;
        L_0x0099:
            if (r1 == 0) goto L_0x0070;
        L_0x009b:
            r1 = r10.pFJ;
            r1[r8] = r0;
            r1 = r10.pFL;
            r4 = com.tencent.mm.plugin.radar.ui.g.pFl;
            r4 = "member";
            b.c.b.e.h(r0, r4);
            r0 = com.tencent.mm.plugin.radar.ui.g.b(r0);
            r4 = java.lang.Integer.valueOf(r2);
            r1.put(r0, r4);
            goto L_0x0049;
        L_0x00b5:
            r1 = r2;
            goto L_0x0087;
        L_0x00b7:
            r1 = r2;
            goto L_0x0096;
        L_0x00b9:
            r1 = r2;
            goto L_0x0099;
        L_0x00bb:
            r0 = r11.size();
            if (r0 <= 0) goto L_0x000c;
        L_0x00c1:
            r10.bmd();
            r0 = com.tencent.mm.plugin.radar.b.d.pCM;
            r0 = r11.size();
            r1 = com.tencent.mm.plugin.radar.b.d.fAL;
            if (r1 != 0) goto L_0x0110;
        L_0x00ce:
            if (r0 <= 0) goto L_0x0110;
        L_0x00d0:
            r4 = com.tencent.mm.plugin.radar.b.d.blY();
            r6 = com.tencent.mm.plugin.radar.b.d.pCI;
            r4 = r4 - r6;
            r1 = (float) r4;
            r4 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
            r1 = r1 * r4;
            r4 = 1148846080; // 0x447a0000 float:1000.0 double:5.676053805E-315;
            r1 = r1 / r4;
            r4 = com.tencent.mm.plugin.radar.b.d.TAG;
            r5 = "FoundFirstFriendTimeSpent %s";
            r6 = new java.lang.Object[r3];
            r7 = java.lang.Float.valueOf(r1);
            r6[r2] = r7;
            com.tencent.mm.sdk.platformtools.x.d(r4, r5, r6);
            r4 = com.tencent.mm.plugin.report.service.g.pWK;
            r5 = b.c.b.l.AEg;
            r5 = "%s";
            r6 = new java.lang.Object[r3];
            r1 = java.lang.Float.valueOf(r1);
            r6[r2] = r1;
            r1 = java.util.Arrays.copyOf(r6, r3);
            r1 = java.lang.String.format(r5, r1);
            r2 = "java.lang.String.format(format, *args)";
            b.c.b.e.h(r1, r2);
            r2 = 10682; // 0x29ba float:1.4969E-41 double:5.2776E-320;
            r4.k(r2, r1);
        L_0x0110:
            r1 = com.tencent.mm.plugin.radar.b.d.fAL;
            r1 = r1 + r0;
            com.tencent.mm.plugin.radar.b.d.fAL = r1;
            r1 = com.tencent.mm.plugin.radar.b.d.pCJ;
            r0 = r0 + r1;
            com.tencent.mm.plugin.radar.b.d.pCJ = r0;
            goto L_0x000c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.ui.RadarViewController.c.ad(java.util.LinkedList):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.view.View A(android.view.View r11, int r12) {
            /*
            r10 = this;
            r0 = com.tencent.mm.plugin.radar.ui.RadarViewController.pFD;
            r0 = com.tencent.mm.plugin.radar.ui.RadarViewController.TAG;
            r1 = "getview RadarStatus%s";
            r2 = 1;
            r2 = new java.lang.Object[r2];
            r3 = 0;
            r4 = r10.pFH;
            r4 = r4.pFx;
            r2[r3] = r4;
            com.tencent.mm.sdk.platformtools.x.d(r0, r1, r2);
            r0 = r10.pFJ;
            r0 = r0[r12];
            r7 = r0;
            r7 = (com.tencent.mm.protocal.c.bbr) r7;
            if (r7 == 0) goto L_0x03ca;
        L_0x001f:
            r0 = r7.kyG;
            r0 = (java.lang.CharSequence) r0;
            if (r0 == 0) goto L_0x002b;
        L_0x0025:
            r0 = b.f.g.Y(r0);
            if (r0 == 0) goto L_0x008e;
        L_0x002b:
            r0 = 1;
        L_0x002c:
            if (r0 == 0) goto L_0x0092;
        L_0x002e:
            r0 = r7.wjz;
            r0 = (java.lang.CharSequence) r0;
            if (r0 == 0) goto L_0x003a;
        L_0x0034:
            r0 = b.f.g.Y(r0);
            if (r0 == 0) goto L_0x0090;
        L_0x003a:
            r0 = 1;
        L_0x003b:
            if (r0 == 0) goto L_0x0092;
        L_0x003d:
            r0 = 1;
        L_0x003e:
            if (r0 != 0) goto L_0x03ca;
        L_0x0040:
            r0 = com.tencent.mm.plugin.radar.ui.g.pFl;
            r9 = com.tencent.mm.plugin.radar.ui.g.b(r7);
            r0 = r10.pFH;
            r1 = r0.pFx;
            if (r11 != 0) goto L_0x03d0;
        L_0x004c:
            r0 = r10.context;
            r2 = com.tencent.mm.plugin.radar.a.d.pBI;
            r3 = 0;
            r0 = android.view.View.inflate(r0, r2, r3);
            if (r0 != 0) goto L_0x005a;
        L_0x0057:
            b.c.b.e.cKr();
        L_0x005a:
            r2 = r10.pFH;
            r2 = r2.pFB;
            r3 = r10.pFM;
            r3 = r3.bmP();
            r3 = java.lang.Integer.valueOf(r3);
            r0.setTag(r2, r3);
            r2 = r10.pFH;
            r2 = r2.pFC;
            r3 = r10.pFM;
            r3 = r3.getInAnimation();
            r0.setTag(r2, r3);
            r8 = r0;
        L_0x007d:
            r0 = com.tencent.mm.plugin.radar.a.c.pBv;
            r3 = r8.findViewById(r0);
            if (r3 != 0) goto L_0x0094;
        L_0x0085:
            r0 = new b.i;
            r1 = "null cannot be cast to non-null type android.widget.ImageView";
            r0.<init>(r1);
            throw r0;
        L_0x008e:
            r0 = 0;
            goto L_0x002c;
        L_0x0090:
            r0 = 0;
            goto L_0x003b;
        L_0x0092:
            r0 = 0;
            goto L_0x003e;
        L_0x0094:
            r3 = (android.widget.ImageView) r3;
            r0 = com.tencent.mm.plugin.radar.a.c.pBp;
            r4 = r8.findViewById(r0);
            if (r4 != 0) goto L_0x00a7;
        L_0x009e:
            r0 = new b.i;
            r1 = "null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateView";
            r0.<init>(r1);
            throw r0;
        L_0x00a7:
            r4 = (com.tencent.mm.plugin.radar.ui.RadarStateView) r4;
            r0 = com.tencent.mm.plugin.radar.a.c.pBx;
            r2 = r8.findViewById(r0);
            if (r2 != 0) goto L_0x00ba;
        L_0x00b1:
            r0 = new b.i;
            r1 = "null cannot be cast to non-null type android.widget.TextView";
            r0.<init>(r1);
            throw r0;
        L_0x00ba:
            r2 = (android.widget.TextView) r2;
            r0 = com.tencent.mm.plugin.radar.a.c.pBw;
            r6 = r8.findViewById(r0);
            if (r6 != 0) goto L_0x00cd;
        L_0x00c4:
            r0 = new b.i;
            r1 = "null cannot be cast to non-null type android.widget.ImageView";
            r0.<init>(r1);
            throw r0;
        L_0x00cd:
            r6 = (android.widget.ImageView) r6;
            r0 = com.tencent.mm.plugin.radar.a.c.pBo;
            r5 = r8.findViewById(r0);
            if (r5 != 0) goto L_0x00e0;
        L_0x00d7:
            r0 = new b.i;
            r1 = "null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateChooseView";
            r0.<init>(r1);
            throw r0;
        L_0x00e0:
            r5 = (com.tencent.mm.plugin.radar.ui.RadarStateChooseView) r5;
            r0 = 0;
            r3.setVisibility(r0);
            r0 = 0;
            r4.setVisibility(r0);
            r0 = 0;
            r2.setVisibility(r0);
            r0 = 0;
            r6.setVisibility(r0);
            r0 = com.tencent.mm.plugin.radar.b.e.e.SEARCHING;
            if (r1 == r0) goto L_0x00fa;
        L_0x00f6:
            r0 = com.tencent.mm.plugin.radar.b.e.e.SEARCH_RETRUN;
            if (r1 != r0) goto L_0x014d;
        L_0x00fa:
            r0 = 0;
            r4.setVisibility(r0);
            r0 = 8;
            r5.setVisibility(r0);
        L_0x0103:
            r0 = new com.tencent.mm.plugin.radar.ui.RadarViewController$c$a;
            r1 = r10;
            r0.<init>(r1, r2, r3, r4, r5, r6);
            r8.setTag(r0);
            r0 = 7;
            if (r12 == r0) goto L_0x0114;
        L_0x010f:
            r0 = r12 % 3;
            r1 = 1;
            if (r0 != r1) goto L_0x0157;
        L_0x0114:
            r0 = com.tencent.mm.plugin.radar.a.c.pBd;
            r0 = r8.findViewById(r0);
            r1 = "anotherConvertView.findV…d<View>(R.id.bottom_stub)";
            b.c.b.e.h(r0, r1);
            r1 = 0;
            r0.setVisibility(r1);
            r0 = com.tencent.mm.plugin.radar.a.c.pBH;
            r0 = r8.findViewById(r0);
            r1 = "anotherConvertView.findV…ById<View>(R.id.top_stub)";
            b.c.b.e.h(r0, r1);
            r1 = 8;
            r0.setVisibility(r1);
        L_0x0135:
            if (r11 == 0) goto L_0x0139;
        L_0x0137:
            if (r8 == r11) goto L_0x013e;
        L_0x0139:
            r0 = r10.pFO;
            r0.put(r9, r8);
        L_0x013e:
            r0 = r8.getTag();
            if (r0 != 0) goto L_0x0179;
        L_0x0144:
            r0 = new b.i;
            r1 = "null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder";
            r0.<init>(r1);
            throw r0;
        L_0x014d:
            r0 = 8;
            r4.setVisibility(r0);
            r0 = 0;
            r5.setVisibility(r0);
            goto L_0x0103;
        L_0x0157:
            r0 = com.tencent.mm.plugin.radar.a.c.pBH;
            r0 = r8.findViewById(r0);
            r1 = "anotherConvertView.findV…ById<View>(R.id.top_stub)";
            b.c.b.e.h(r0, r1);
            r1 = 0;
            r0.setVisibility(r1);
            r0 = com.tencent.mm.plugin.radar.a.c.pBd;
            r0 = r8.findViewById(r0);
            r1 = "anotherConvertView.findV…d<View>(R.id.bottom_stub)";
            b.c.b.e.h(r0, r1);
            r1 = 8;
            r0.setVisibility(r1);
            goto L_0x0135;
        L_0x0179:
            r0 = (com.tencent.mm.plugin.radar.ui.RadarViewController.c.a) r0;
            r2 = r0.pFQ;
            r1 = r10.pFH;
            r3 = r1.getContext();
            r1 = r7.kzN;
            r1 = (java.lang.CharSequence) r1;
            r4 = r0.pFQ;
            r4 = r4.getTextSize();
            r1 = com.tencent.mm.pluginsdk.ui.d.i.b(r3, r1, r4);
            r1 = (java.lang.CharSequence) r1;
            r2.setText(r1);
            r1 = com.tencent.mm.plugin.radar.ui.b.a.pDB;
            r1 = r0.pFR;
            com.tencent.mm.plugin.radar.ui.b.a.a(r1, r9);
            r1 = com.tencent.mm.plugin.radar.a.c.pBf;
            r1 = r8.findViewById(r1);
            r2 = "view.findViewById(R.id.radar_avatar_container)";
            b.c.b.e.h(r1, r2);
            r2 = new com.tencent.mm.plugin.radar.ui.RadarViewController$d;
            r3 = r10.pFH;
            r2.<init>(r3, r7);
            r1.setTag(r2);
            r1 = r10.pFH;
            r1 = r1.pFx;
            r2 = com.tencent.mm.plugin.radar.b.e.e.SEARCHING;
            if (r1 == r2) goto L_0x01c3;
        L_0x01bb:
            r1 = r10.pFH;
            r1 = r1.pFx;
            r2 = com.tencent.mm.plugin.radar.b.e.e.SEARCH_RETRUN;
            if (r1 != r2) goto L_0x02fe;
        L_0x01c3:
            r1 = r0.pFU;
            r2 = com.tencent.mm.plugin.radar.a.b.pBc;
            r1.setBackgroundResource(r2);
            r1 = r0.pFS;
            r2 = 1;
            r1.pEC = r2;
            r1.bmt();
            r1 = r0.pFT;
            r2 = 0;
            r1.pEw = r2;
            r2 = 8;
            r1.setVisibility(r2);
            r1 = r10.pFH;
            r1 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r1);
            r1 = r1.a(r7, false);
            if (r1 != 0) goto L_0x021a;
        L_0x01e8:
            r1 = r10.pFH;
            r1 = r1.pFv;
            r1 = r1.IE(r9);
            r2 = r10.pFH;
            r2 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r2);
            r3 = "member";
            b.c.b.e.i(r7, r3);
            r3 = "state";
            b.c.b.e.i(r1, r3);
            r3 = r7.kyG;
            r4 = "member.UserName";
            b.c.b.e.h(r3, r4);
            r2.b(r3, r1);
            r3 = r7.wjz;
            r4 = "member.EncodeUserName";
            b.c.b.e.h(r3, r4);
            r2.b(r3, r1);
        L_0x021a:
            r2 = r10.pFH;
            r2 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r2);
            r3 = 1;
            r2 = r2.a(r7, r3);
            r3 = r0.pFS;
            if (r2 != 0) goto L_0x022b;
        L_0x0229:
            r2 = com.tencent.mm.plugin.radar.b.c.e.Stranger;
        L_0x022b:
            r4 = "state";
            b.c.b.e.i(r2, r4);
            r3.init();
            r4 = r3.pED;
            r5 = 0;
            r4.removeMessages(r5);
            r3.clearAnimation();
            r3.pDh = r2;
            r2 = 0;
            r3.pEt = r2;
            r3.bmt();
            r3 = r0.pFS;
            r0 = "state";
            b.c.b.e.i(r1, r0);
            r3.init();
            r0 = com.tencent.mm.plugin.radar.ui.RadarStateView.pEG;
            r0 = com.tencent.mm.plugin.radar.ui.RadarStateView.TAG;
            r2 = new java.lang.StringBuilder;
            r4 = " turnToState : ";
            r2.<init>(r4);
            r2 = r2.append(r1);
            r2 = r2.toString();
            com.tencent.mm.sdk.platformtools.x.d(r0, r2);
            r0 = 0;
            r2 = r3.pDh;
            if (r2 != r1) goto L_0x02b6;
        L_0x026e:
            r3.bmt();
        L_0x0271:
            r0 = r10.pFH;
            r0 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r0);
            r1 = "member";
            b.c.b.e.i(r7, r1);
            r1 = r7.kyG;
            r2 = "member.UserName";
            b.c.b.e.h(r1, r2);
            r2 = 0;
            r0.a(r1, r2);
            r1 = r7.wjz;
            r2 = "member.EncodeUserName";
            b.c.b.e.h(r1, r2);
            r2 = 0;
            r0.a(r1, r2);
            if (r12 != 0) goto L_0x029f;
        L_0x0297:
            r0 = r10.pFL;
            r0 = r0.size();
            r10.pFN = r0;
        L_0x029f:
            r0 = r10.pFL;
            r0 = r0.remove(r9);
            if (r0 == 0) goto L_0x02b5;
        L_0x02a7:
            r0 = r10.pFM;
            r1 = r10.pFN;
            r2 = r10.pFL;
            r2 = r2.size();
            r1 = r1 - r2;
            r0.h(r1, r8);
        L_0x02b5:
            return r8;
        L_0x02b6:
            r2 = r3.getVisibility();
            if (r2 != 0) goto L_0x02ed;
        L_0x02bc:
            r2 = 1;
        L_0x02bd:
            if (r2 == 0) goto L_0x02c3;
        L_0x02bf:
            r3.bmv();
            r0 = 1;
        L_0x02c3:
            r2 = com.tencent.mm.plugin.radar.ui.RadarStateView.pEG;
            r2 = com.tencent.mm.plugin.radar.ui.RadarStateView.TAG;
            r4 = new java.lang.StringBuilder;
            r5 = " delay : ";
            r4.<init>(r5);
            r4 = r4.append(r0);
            r4 = r4.toString();
            com.tencent.mm.sdk.platformtools.x.d(r2, r4);
            r3.pDh = r1;
            r1 = r3.pDh;
            r2 = com.tencent.mm.plugin.radar.b.c.e.Stranger;
            if (r1 == r2) goto L_0x0271;
        L_0x02e4:
            if (r0 != 0) goto L_0x02ef;
        L_0x02e6:
            r0 = r3.pED;
            r1 = 0;
            r0.sendEmptyMessage(r1);
            goto L_0x0271;
        L_0x02ed:
            r2 = 0;
            goto L_0x02bd;
        L_0x02ef:
            r0 = r3.pED;
            r1 = 0;
            r2 = com.tencent.mm.plugin.radar.ui.RadarStateView.pEF;
            r2 = r2 + 20;
            r2 = (long) r2;
            r0.sendEmptyMessageDelayed(r1, r2);
            goto L_0x0271;
        L_0x02fe:
            r1 = r10.pFH;
            r1 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r1);
            r1 = r1.pCR;
            r2 = com.tencent.mm.plugin.radar.ui.g.pFl;
            r2 = com.tencent.mm.plugin.radar.ui.g.c(r7);
            r1 = r1.get(r2);
            r1 = (java.lang.String) r1;
            r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
            if (r1 != 0) goto L_0x03c4;
        L_0x0318:
            r1 = r0.pFS;
            r2 = 0;
            r1.pEC = r2;
            r2 = 8;
            r1.setVisibility(r2);
            r1 = r0.pFT;
            r2 = 1;
            r1.pEw = r2;
            r1.bmt();
            r1 = r10.pFH;
            r1 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r1);
            if (r7 == 0) goto L_0x0346;
        L_0x0332:
            r2 = com.tencent.mm.plugin.radar.ui.g.pFl;
            r2 = com.tencent.mm.plugin.radar.ui.g.b(r7);
            r1 = r1.pCV;
            r1 = r1.get(r2);
            r1 = (com.tencent.mm.plugin.radar.b.e.a) r1;
            if (r1 != 0) goto L_0x0344;
        L_0x0342:
            r1 = com.tencent.mm.plugin.radar.b.e.a.UnSelected;
        L_0x0344:
            if (r1 != 0) goto L_0x0348;
        L_0x0346:
            r1 = com.tencent.mm.plugin.radar.b.e.a.UnSelected;
        L_0x0348:
            r2 = com.tencent.mm.plugin.radar.b.e.a.UnSelected;
            if (r1 == r2) goto L_0x0352;
        L_0x034c:
            r2 = r0.pFU;
            r3 = 0;
            r2.setBackgroundDrawable(r3);
        L_0x0352:
            r2 = r0.pFT;
            r0 = "status";
            b.c.b.e.i(r1, r0);
            r0 = r2.pEx;
            r0 = b.c.b.e.h(r0, r1);
            r0 = r0 ^ 1;
            if (r0 == 0) goto L_0x0373;
        L_0x0364:
            r2.pEx = r1;
            r0 = r2.pEx;
            r1 = com.tencent.mm.plugin.radar.ui.e.pEz;
            r0 = r0.ordinal();
            r0 = r1[r0];
            switch(r0) {
                case 1: goto L_0x039b;
                case 2: goto L_0x03b1;
                default: goto L_0x0373;
            };
        L_0x0373:
            if (r12 != 0) goto L_0x037d;
        L_0x0375:
            r0 = r10.pFL;
            r0 = r0.size();
            r10.pFN = r0;
        L_0x037d:
            r0 = r10.pFL;
            r1 = com.tencent.mm.plugin.radar.ui.g.pFl;
            r1 = com.tencent.mm.plugin.radar.ui.g.c(r7);
            r0 = r0.remove(r1);
            if (r0 == 0) goto L_0x02b5;
        L_0x038b:
            r0 = r10.pFM;
            r1 = r10.pFN;
            r2 = r10.pFL;
            r2 = r2.size();
            r1 = r1 - r2;
            r0.h(r1, r8);
            goto L_0x02b5;
        L_0x039b:
            r0 = r2.pEw;
            if (r0 == 0) goto L_0x0373;
        L_0x039f:
            r2.bmt();
            r0 = 1;
            r2.pEt = r0;
            r0 = r2.pEu;
            r0 = r0.getValue();
            r0 = (android.view.animation.Animation) r0;
            r2.startAnimation(r0);
            goto L_0x0373;
        L_0x03b1:
            r0 = r2.pEw;
            if (r0 == 0) goto L_0x0373;
        L_0x03b5:
            r2.bmt();
            r0 = r2.pEv;
            r0 = r0.getValue();
            r0 = (android.view.animation.Animation) r0;
            r2.startAnimation(r0);
            goto L_0x0373;
        L_0x03c4:
            r8 = r10.B(r11, r12);
            goto L_0x02b5;
        L_0x03ca:
            r8 = r10.B(r11, r12);
            goto L_0x02b5;
        L_0x03d0:
            r8 = r11;
            goto L_0x007d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.ui.RadarViewController.c.A(android.view.View, int):android.view.View");
        }

        private final View B(View view, int i) {
            if (view == null) {
                view = View.inflate(this.context, com.tencent.mm.plugin.radar.a.d.pBI, null);
                if (view == null) {
                    b.c.b.e.cKr();
                }
                view.setTag(this.pFH.pFB, Integer.valueOf(this.pFM.bmP()));
                view.setTag(this.pFH.pFC, this.pFM.getInAnimation());
            }
            Object findViewById = view.findViewById(com.tencent.mm.plugin.radar.a.c.pBv);
            b.c.b.e.h(findViewById, "anotherConvertView.findV…ar_result_item_avatar_iv)");
            findViewById.setVisibility(8);
            findViewById = view.findViewById(com.tencent.mm.plugin.radar.a.c.pBw);
            b.c.b.e.h(findViewById, "anotherConvertView.findV…sult_item_avatar_mask_iv)");
            findViewById.setVisibility(8);
            findViewById = view.findViewById(com.tencent.mm.plugin.radar.a.c.pBx);
            b.c.b.e.h(findViewById, "anotherConvertView.findV…_result_item_username_tv)");
            findViewById.setVisibility(4);
            findViewById = view.findViewById(com.tencent.mm.plugin.radar.a.c.pBp);
            b.c.b.e.h(findViewById, "anotherConvertView.findV….radar_member_state_view)");
            findViewById.setVisibility(4);
            findViewById = view.findViewById(com.tencent.mm.plugin.radar.a.c.pBo);
            b.c.b.e.h(findViewById, "anotherConvertView.findV…member_state_choose_view)");
            findViewById.setVisibility(4);
            if (i == 7 || i % 3 == 1) {
                findViewById = view.findViewById(com.tencent.mm.plugin.radar.a.c.pBd);
                b.c.b.e.h(findViewById, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
                findViewById.setVisibility(0);
                findViewById = view.findViewById(com.tencent.mm.plugin.radar.a.c.pBH);
                b.c.b.e.h(findViewById, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
                findViewById.setVisibility(8);
            } else {
                findViewById = view.findViewById(com.tencent.mm.plugin.radar.a.c.pBH);
                b.c.b.e.h(findViewById, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
                findViewById.setVisibility(0);
                findViewById = view.findViewById(com.tencent.mm.plugin.radar.a.c.pBd);
                b.c.b.e.h(findViewById, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
                findViewById.setVisibility(8);
            }
            return view;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void d(com.tencent.mm.protocal.c.bbr r4) {
            /*
            r3 = this;
            r2 = 1;
            r1 = 0;
            if (r4 == 0) goto L_0x0022;
        L_0x0004:
            r0 = r4.kyG;
            r0 = (java.lang.CharSequence) r0;
            if (r0 == 0) goto L_0x0010;
        L_0x000a:
            r0 = b.f.g.Y(r0);
            if (r0 == 0) goto L_0x0026;
        L_0x0010:
            r0 = r2;
        L_0x0011:
            if (r0 == 0) goto L_0x002a;
        L_0x0013:
            r0 = r4.wjz;
            r0 = (java.lang.CharSequence) r0;
            if (r0 == 0) goto L_0x001f;
        L_0x0019:
            r0 = b.f.g.Y(r0);
            if (r0 == 0) goto L_0x0028;
        L_0x001f:
            r0 = r2;
        L_0x0020:
            if (r0 == 0) goto L_0x002a;
        L_0x0022:
            r0 = r2;
        L_0x0023:
            if (r0 == 0) goto L_0x002c;
        L_0x0025:
            return;
        L_0x0026:
            r0 = r1;
            goto L_0x0011;
        L_0x0028:
            r0 = r1;
            goto L_0x0020;
        L_0x002a:
            r0 = r1;
            goto L_0x0023;
        L_0x002c:
            r0 = com.tencent.mm.plugin.radar.ui.g.pFl;
            if (r4 != 0) goto L_0x0033;
        L_0x0030:
            b.c.b.e.cKr();
        L_0x0033:
            r0 = com.tencent.mm.plugin.radar.ui.g.b(r4);
            r1 = r3.pFH;
            r1 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r1);
            r1 = r1.pCR;
            r1 = r1.containsKey(r0);
            if (r1 == 0) goto L_0x005e;
        L_0x0045:
            r1 = r3.pFH;
            r1 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r1);
            r1 = r1.pCR;
            r0 = r1.get(r0);
            if (r0 != 0) goto L_0x005c;
        L_0x0053:
            r0 = new b.i;
            r1 = "null cannot be cast to non-null type kotlin.String";
            r0.<init>(r1);
            throw r0;
        L_0x005c:
            r0 = (java.lang.String) r0;
        L_0x005e:
            r1 = r3.pFK;
            r1.put(r0, r0);
            goto L_0x0025;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.ui.RadarViewController.c.d(com.tencent.mm.protocal.c.bbr):void");
        }
    }

    public final class d {
        private bbr pDg;
        final /* synthetic */ RadarViewController pFH;

        public d(RadarViewController radarViewController, bbr bbr) {
            b.c.b.e.i(bbr, "member");
            this.pFH = radarViewController;
            this.pDg = bbr;
        }
    }

    static final class f implements OnClickListener {
        final /* synthetic */ RadarViewController pFH;

        f(RadarViewController radarViewController) {
            this.pFH = radarViewController;
        }

        public final void onClick(View view) {
            if (this.pFH.pFx == com.tencent.mm.plugin.radar.b.e.e.SEARCHING || this.pFH.pFx == com.tencent.mm.plugin.radar.b.e.e.SEARCH_RETRUN) {
                Context context = this.pFH.getContext();
                if (context == null) {
                    throw new b.i("null cannot be cast to non-null type android.app.Activity");
                }
                ((Activity) context).finish();
                return;
            }
            RadarViewController radarViewController = this.pFH;
            c d = RadarViewController.d(this.pFH);
            LinkedList linkedList = new LinkedList();
            int length = ((Object[]) d.pFJ).length;
            for (int i = 0; i < length; i++) {
                Object obj = d.pFJ[i];
                if (obj != null) {
                    linkedList.add(obj);
                }
            }
            if (radarViewController.ac(linkedList)) {
                this.pFH.bmG().bmQ();
                this.pFH.bmG().setVisibility(0);
                RadarViewController.c(this.pFH).blZ();
                this.pFH.a(com.tencent.mm.plugin.radar.b.e.e.SEARCH_RETRUN);
            } else {
                this.pFH.a(com.tencent.mm.plugin.radar.b.e.e.SEARCHING);
            }
            RadarViewController.d(this.pFH).bmd();
        }
    }

    static final class h extends b.c.b.f implements b.c.a.a<RadarWaveView> {
        final /* synthetic */ RadarViewController pFH;

        h(RadarViewController radarViewController) {
            this.pFH = radarViewController;
        }

        public final /* synthetic */ Object invoke() {
            Context context = this.pFH.getContext();
            if (context != null) {
                return (RadarWaveView) ((Activity) context).findViewById(com.tencent.mm.plugin.radar.a.c.pBF);
            }
            throw new b.i("null cannot be cast to non-null type android.app.Activity");
        }
    }

    public static final class g implements com.tencent.mm.plugin.radar.ui.RadarSpecialGridView.a {
        final /* synthetic */ RadarViewController pFH;

        static final class a implements Runnable {
            final /* synthetic */ bbr pEa;
            final /* synthetic */ g pFX;
            final /* synthetic */ View pFY;
            final /* synthetic */ com.tencent.mm.plugin.radar.b.c.e pFZ;

            a(g gVar, View view, bbr bbr, com.tencent.mm.plugin.radar.b.c.e eVar) {
                this.pFX = gVar;
                this.pFY = view;
                this.pEa = bbr;
                this.pFZ = eVar;
            }

            public final void run() {
                this.pFX.pFH.bmH().a(this.pFY, this.pEa, this.pFZ);
                this.pFX.pFH.bmG().bmR();
            }
        }

        g(RadarViewController radarViewController) {
            this.pFH = radarViewController;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void g(int r7, android.view.View r8) {
            /*
            r6 = this;
            r3 = 1;
            r2 = 0;
            r0 = "view";
            b.c.b.e.i(r8, r0);
            r0 = r6.pFH;
            r0 = com.tencent.mm.plugin.radar.ui.RadarViewController.d(r0);
            r0 = r0.pFJ;
            r0 = r0[r7];
            r0 = (com.tencent.mm.protocal.c.bbr) r0;
            if (r0 != 0) goto L_0x0017;
        L_0x0016:
            return;
        L_0x0017:
            r1 = r6.pFH;
            r1 = r1.pFx;
            r4 = com.tencent.mm.plugin.radar.ui.h.pEz;
            r1 = r1.ordinal();
            r1 = r4[r1];
            switch(r1) {
                case 1: goto L_0x003b;
                case 2: goto L_0x003b;
                case 3: goto L_0x00c9;
                default: goto L_0x0026;
            };
        L_0x0026:
            r0 = com.tencent.mm.plugin.radar.ui.RadarViewController.pFD;
            r0 = com.tencent.mm.plugin.radar.ui.RadarViewController.TAG;
            r1 = "unknow status for grid view %s";
            r3 = new java.lang.Object[r3];
            r4 = r6.pFH;
            r4 = r4.pFx;
            r3[r2] = r4;
            com.tencent.mm.sdk.platformtools.x.d(r0, r1, r3);
            goto L_0x0016;
        L_0x003b:
            r1 = com.tencent.mm.plugin.radar.ui.g.pFl;
            r4 = com.tencent.mm.plugin.radar.ui.g.b(r0);
            if (r0 == 0) goto L_0x0061;
        L_0x0043:
            r1 = r0.kyG;
            r1 = (java.lang.CharSequence) r1;
            if (r1 == 0) goto L_0x004f;
        L_0x0049:
            r1 = b.f.g.Y(r1);
            if (r1 == 0) goto L_0x0091;
        L_0x004f:
            r1 = r3;
        L_0x0050:
            if (r1 == 0) goto L_0x0062;
        L_0x0052:
            r1 = r0.wjz;
            r1 = (java.lang.CharSequence) r1;
            if (r1 == 0) goto L_0x005e;
        L_0x0058:
            r1 = b.f.g.Y(r1);
            if (r1 == 0) goto L_0x0093;
        L_0x005e:
            r1 = r3;
        L_0x005f:
            if (r1 == 0) goto L_0x0062;
        L_0x0061:
            r2 = r3;
        L_0x0062:
            if (r2 != 0) goto L_0x0016;
        L_0x0064:
            r1 = r6.pFH;
            r1 = com.tencent.mm.plugin.radar.ui.RadarViewController.d(r1);
            r1 = r1.pFO;
            r1 = r1.get(r4);
            r1 = (android.view.View) r1;
            r2 = r6.pFH;
            r2 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r2);
            r2 = r2.a(r0, false);
            if (r1 == 0) goto L_0x00b5;
        L_0x007e:
            r3 = com.tencent.mm.plugin.radar.b.c.e.Stranger;
            if (r2 == r3) goto L_0x00b5;
        L_0x0082:
            r1 = r1.getTag();
            if (r1 != 0) goto L_0x0095;
        L_0x0088:
            r0 = new b.i;
            r1 = "null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder";
            r0.<init>(r1);
            throw r0;
        L_0x0091:
            r1 = r2;
            goto L_0x0050;
        L_0x0093:
            r1 = r2;
            goto L_0x005f;
        L_0x0095:
            r1 = (com.tencent.mm.plugin.radar.ui.RadarViewController.c.a) r1;
            r1 = r1.pFS;
            r1.bmv();
            r3 = new com.tencent.mm.sdk.platformtools.ag;
            r3.<init>();
            r1 = new com.tencent.mm.plugin.radar.ui.RadarViewController$g$a;
            r1.<init>(r6, r8, r0, r2);
            r0 = r1;
            r0 = (java.lang.Runnable) r0;
            r1 = com.tencent.mm.plugin.radar.ui.RadarStateView.pEG;
            r1 = com.tencent.mm.plugin.radar.ui.RadarStateView.pEF;
            r4 = (long) r1;
            r3.postDelayed(r0, r4);
            goto L_0x0016;
        L_0x00b5:
            r1 = r6.pFH;
            r1 = r1.bmH();
            r1.a(r8, r0, r2);
            r0 = r6.pFH;
            r0 = r0.bmG();
            r0.bmR();
            goto L_0x0016;
        L_0x00c9:
            if (r0 == 0) goto L_0x00e9;
        L_0x00cb:
            r1 = r0.kyG;
            r1 = (java.lang.CharSequence) r1;
            if (r1 == 0) goto L_0x00d7;
        L_0x00d1:
            r1 = b.f.g.Y(r1);
            if (r1 == 0) goto L_0x011f;
        L_0x00d7:
            r1 = r3;
        L_0x00d8:
            if (r1 == 0) goto L_0x0123;
        L_0x00da:
            r1 = r0.wjz;
            r1 = (java.lang.CharSequence) r1;
            if (r1 == 0) goto L_0x00e6;
        L_0x00e0:
            r1 = b.f.g.Y(r1);
            if (r1 == 0) goto L_0x0121;
        L_0x00e6:
            r1 = r3;
        L_0x00e7:
            if (r1 == 0) goto L_0x0123;
        L_0x00e9:
            r1 = r3;
        L_0x00ea:
            if (r1 != 0) goto L_0x013b;
        L_0x00ec:
            r1 = r6.pFH;
            r4 = com.tencent.mm.plugin.radar.ui.RadarViewController.d(r1);
            if (r0 == 0) goto L_0x0152;
        L_0x00f4:
            r1 = com.tencent.mm.plugin.radar.ui.g.pFl;
            r1 = com.tencent.mm.plugin.radar.ui.g.b(r0);
            r5 = r4.pFH;
            r5 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r5);
            r5 = r5.pCR;
            r5 = r5.containsKey(r1);
            if (r5 == 0) goto L_0x0127;
        L_0x0108:
            r5 = r4.pFH;
            r5 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r5);
            r5 = r5.pCR;
            r1 = r5.get(r1);
            if (r1 != 0) goto L_0x0125;
        L_0x0116:
            r0 = new b.i;
            r1 = "null cannot be cast to non-null type kotlin.String";
            r0.<init>(r1);
            throw r0;
        L_0x011f:
            r1 = r2;
            goto L_0x00d8;
        L_0x0121:
            r1 = r2;
            goto L_0x00e7;
        L_0x0123:
            r1 = r2;
            goto L_0x00ea;
        L_0x0125:
            r1 = (java.lang.String) r1;
        L_0x0127:
            r4 = r4.pFK;
            r1 = r4.containsKey(r1);
            if (r1 == 0) goto L_0x0152;
        L_0x012f:
            r1 = r3;
        L_0x0130:
            if (r1 != 0) goto L_0x0154;
        L_0x0132:
            r1 = r6.pFH;
            r1 = com.tencent.mm.plugin.radar.ui.RadarViewController.d(r1);
            r1.d(r0);
        L_0x013b:
            r1 = r6.pFH;
            r1 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r1);
            r1.a(r0);
            com.tencent.mm.plugin.radar.ui.RadarViewController.bmO();
            r0 = r6.pFH;
            r0 = com.tencent.mm.plugin.radar.ui.RadarViewController.d(r0);
            r0.bmd();
            goto L_0x0016;
        L_0x0152:
            r1 = r2;
            goto L_0x0130;
        L_0x0154:
            r1 = r6.pFH;
            r4 = com.tencent.mm.plugin.radar.ui.RadarViewController.d(r1);
            if (r0 == 0) goto L_0x017a;
        L_0x015c:
            r1 = r0.kyG;
            r1 = (java.lang.CharSequence) r1;
            if (r1 == 0) goto L_0x0168;
        L_0x0162:
            r1 = b.f.g.Y(r1);
            if (r1 == 0) goto L_0x01ad;
        L_0x0168:
            r1 = r3;
        L_0x0169:
            if (r1 == 0) goto L_0x01b1;
        L_0x016b:
            r1 = r0.wjz;
            r1 = (java.lang.CharSequence) r1;
            if (r1 == 0) goto L_0x0177;
        L_0x0171:
            r1 = b.f.g.Y(r1);
            if (r1 == 0) goto L_0x01af;
        L_0x0177:
            r1 = r3;
        L_0x0178:
            if (r1 == 0) goto L_0x01b1;
        L_0x017a:
            r1 = r3;
        L_0x017b:
            if (r1 != 0) goto L_0x013b;
        L_0x017d:
            r1 = com.tencent.mm.plugin.radar.ui.g.pFl;
            if (r0 != 0) goto L_0x0184;
        L_0x0181:
            b.c.b.e.cKr();
        L_0x0184:
            r1 = com.tencent.mm.plugin.radar.ui.g.b(r0);
            r2 = r4.pFH;
            r2 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r2);
            r2 = r2.pCR;
            r2 = r2.containsKey(r1);
            if (r2 == 0) goto L_0x01b5;
        L_0x0196:
            r2 = r4.pFH;
            r2 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r2);
            r2 = r2.pCR;
            r1 = r2.get(r1);
            if (r1 != 0) goto L_0x01b3;
        L_0x01a4:
            r0 = new b.i;
            r1 = "null cannot be cast to non-null type kotlin.String";
            r0.<init>(r1);
            throw r0;
        L_0x01ad:
            r1 = r2;
            goto L_0x0169;
        L_0x01af:
            r1 = r2;
            goto L_0x0178;
        L_0x01b1:
            r1 = r2;
            goto L_0x017b;
        L_0x01b3:
            r1 = (java.lang.String) r1;
        L_0x01b5:
            r2 = r4.pFK;
            r2.remove(r1);
            goto L_0x013b;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.ui.RadarViewController.g.g(int, android.view.View):void");
        }
    }

    private final TextView bmK() {
        return (TextView) this.pFq.getValue();
    }

    private final ProgressBar bmL() {
        return (ProgressBar) this.pFr.getValue();
    }

    private final View bmN() {
        return (View) this.pFt.getValue();
    }

    final RadarWaveView bmG() {
        return (RadarWaveView) this.pFm.getValue();
    }

    final RadarMemberView bmH() {
        return (RadarMemberView) this.pFn.getValue();
    }

    final RadarSpecialGridView bmI() {
        return (RadarSpecialGridView) this.pFo.getValue();
    }

    final RadarTipsView bmJ() {
        return (RadarTipsView) this.pFp.getValue();
    }

    final Button bmM() {
        return (Button) this.pFs.getValue();
    }

    public RadarViewController(Context context, AttributeSet attributeSet) {
        b.c.b.e.i(context, "mContext");
        super(context, attributeSet);
        com.tencent.mm.plugin.radar.b.e.d dVar = this;
        Object applicationContext = context.getApplicationContext();
        b.c.b.e.h(applicationContext, "mContext.getApplicationContext()");
        this.pFu = new com.tencent.mm.plugin.radar.b.e(dVar, applicationContext);
        this.pFv = new com.tencent.mm.plugin.radar.b.c(this, context);
    }

    public static final /* synthetic */ void bmO() {
    }

    public static final /* synthetic */ com.tencent.mm.plugin.radar.b.e c(RadarViewController radarViewController) {
        com.tencent.mm.plugin.radar.b.e eVar = radarViewController.pFu;
        if (eVar == null) {
            b.c.b.e.adf("radarManager");
        }
        return eVar;
    }

    public static final /* synthetic */ c d(RadarViewController radarViewController) {
        c cVar = radarViewController.pFw;
        if (cVar == null) {
            b.c.b.e.adf("adapter");
        }
        return cVar;
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        b.c.b.e.i(keyEvent, "event");
        if (i != 4 || !bmH().isShowing()) {
            return false;
        }
        bmH().dismiss();
        return true;
    }

    private final void d(String str, com.tencent.mm.plugin.radar.b.c.e eVar) {
        com.tencent.mm.plugin.radar.b.e eVar2 = this.pFu;
        if (eVar2 == null) {
            b.c.b.e.adf("radarManager");
        }
        if (str == null) {
            b.c.b.e.cKr();
        }
        com.tencent.mm.plugin.radar.b.c.e IF = eVar2.IF(str);
        if (IF != null && IF != eVar) {
            eVar2 = this.pFu;
            if (eVar2 == null) {
                b.c.b.e.adf("radarManager");
            }
            eVar2.b(str, eVar);
            c cVar = this.pFw;
            if (cVar == null) {
                b.c.b.e.adf("adapter");
            }
            cVar.bmd();
        }
    }

    public final void a(boolean z, boolean z2, String str, String str2, long j) {
        com.tencent.mm.plugin.radar.b.e eVar;
        if (z) {
            d(str2, com.tencent.mm.plugin.radar.b.c.e.Added);
        } else if (z2) {
            d(str2, com.tencent.mm.plugin.radar.b.c.e.Verifying);
        } else {
            RadarTipsView bmJ = bmJ();
            if (str == null) {
                str = "";
            }
            bmJ.IG(str);
            eVar = this.pFu;
            if (eVar == null) {
                b.c.b.e.adf("radarManager");
            }
            com.tencent.mm.plugin.radar.b.e.c cVar = (com.tencent.mm.plugin.radar.b.e.c) eVar.pCU.get(Long.valueOf(j));
            if (cVar != null) {
                g gVar = g.pFl;
                d(g.b(cVar.pDg), cVar.pDh);
                gVar = g.pFl;
                d(g.c(cVar.pDg), cVar.pDh);
            }
        }
        eVar = this.pFu;
        if (eVar == null) {
            b.c.b.e.adf("radarManager");
        }
        eVar.pCU.remove(Long.valueOf(j));
    }

    public final void a(boolean z, String str, String str2, long j) {
        com.tencent.mm.plugin.radar.b.e eVar;
        if (z) {
            d(str2, com.tencent.mm.plugin.radar.b.c.e.Added);
        } else {
            RadarTipsView bmJ = bmJ();
            if (str == null) {
                str = "";
            }
            bmJ.IG(str);
            eVar = this.pFu;
            if (eVar == null) {
                b.c.b.e.adf("radarManager");
            }
            com.tencent.mm.plugin.radar.b.e.c cVar = (com.tencent.mm.plugin.radar.b.e.c) eVar.pCU.get(Long.valueOf(j));
            if (cVar != null) {
                g gVar = g.pFl;
                d(g.b(cVar.pDg), cVar.pDh);
            }
        }
        eVar = this.pFu;
        if (eVar == null) {
            b.c.b.e.adf("radarManager");
        }
        eVar.pCU.remove(Long.valueOf(j));
    }

    public final void J(com.tencent.mm.storage.x xVar) {
        b.c.b.e.i(xVar, "contact");
        com.tencent.mm.plugin.radar.b.e eVar = this.pFu;
        if (eVar == null) {
            b.c.b.e.adf("radarManager");
        }
        Object username = xVar.getUsername();
        b.c.b.e.h(username, "contact.username");
        if (eVar.IF(username) == null) {
            eVar = this.pFu;
            if (eVar == null) {
                b.c.b.e.adf("radarManager");
            }
            username = xVar.vZ();
            b.c.b.e.h(username, "contact.encryptUsername");
            if (eVar.IF(username) == null) {
                LinkedList linkedList = new LinkedList();
                username = xVar.getUsername();
                b.c.b.e.h(username, "contact.username");
                Object vZ = xVar.vZ();
                b.c.b.e.h(vZ, "contact.encryptUsername");
                Object vW = xVar.vW();
                b.c.b.e.h(vW, "contact.nickname");
                bbr bbr = new bbr();
                bbr.wLT = 100;
                bbr.kyG = username;
                bbr.kzN = vW;
                bbr.whs = "";
                bbr.wjz = vZ;
                linkedList.add(bbr);
                ab(linkedList);
            }
        }
        if (bmH().isShowing()) {
            RadarMemberView bmH = bmH();
            username = xVar.vZ();
            b.c.b.e.h(username, "contact.encryptUsername");
            bmH.c(username, com.tencent.mm.plugin.radar.b.c.e.NeedVerify);
        }
        d(xVar.getUsername(), com.tencent.mm.plugin.radar.b.c.e.NeedVerify);
        d(xVar.vZ(), com.tencent.mm.plugin.radar.b.c.e.NeedVerify);
    }

    public final void I(com.tencent.mm.storage.x xVar) {
        b.c.b.e.i(xVar, "contact");
        if (bmH().isShowing()) {
            RadarMemberView bmH = bmH();
            Object vZ = xVar.vZ();
            b.c.b.e.h(vZ, "contact.encryptUsername");
            bmH.c(vZ, com.tencent.mm.plugin.radar.b.c.e.Added);
        }
        d(xVar.getUsername(), com.tencent.mm.plugin.radar.b.c.e.Added);
        d(xVar.vZ(), com.tencent.mm.plugin.radar.b.c.e.Added);
    }

    public final void hx(boolean z) {
    }

    public final void a(int i, int i2, LinkedList<bbr> linkedList) {
        if (i == 0 && i2 == 0) {
            ab(linkedList);
            return;
        }
        x.e(TAG, "radar member return error : %s, type : %s ", Integer.valueOf(i2), Integer.valueOf(i));
        RadarTipsView bmJ;
        Object string;
        if (2 == i) {
            bmJ = bmJ();
            string = getContext().getString(com.tencent.mm.plugin.radar.a.f.exR);
            b.c.b.e.h(string, "context.getString(R.string.net_warn_no_network)");
            bmJ.IG(string);
            return;
        }
        bmJ = bmJ();
        string = getContext().getString(com.tencent.mm.plugin.radar.a.f.pBY);
        b.c.b.e.h(string, "context.getString(R.string.radar_tips_network_err)");
        bmJ.IG(string);
    }

    public final void b(int i, int i2, LinkedList<bbo> linkedList) {
        int i3 = 0;
        if (i == 0 && i2 == 0 && linkedList != null) {
            a(com.tencent.mm.plugin.radar.b.e.e.RALATIONCHAIN_RETRUN);
            c cVar = this.pFw;
            if (cVar == null) {
                b.c.b.e.adf("adapter");
            }
            c(cVar.pFH).pCV.clear();
            c(cVar.pFH).pCR.clear();
            cVar.pFK.clear();
            cVar.pFL.clear();
            LinkedList linkedList2 = null;
            if (linkedList != null && linkedList.size() > 0) {
                int i4;
                LinkedList linkedList3 = new LinkedList();
                int size = linkedList.size();
                for (i4 = 0; i4 < size; i4++) {
                    bbo bbo = (bbo) linkedList.get(i4);
                    bbp bbp = new bbp();
                    bbp.wOI = bbo.kyG;
                    linkedList3.add(bbp);
                    Map map = c(cVar.pFH).pCR;
                    Object obj = bbo.wjz;
                    b.c.b.e.h(obj, "radarchatroomMember.EncodeUserName");
                    Object obj2 = bbo.kyG;
                    b.c.b.e.h(obj2, "radarchatroomMember.UserName");
                    map.put(obj, obj2);
                    HashMap hashMap = cVar.pFL;
                    g gVar = g.pFl;
                    hashMap.put(g.a(bbo), Integer.valueOf(0));
                }
                i4 = ((Object[]) cVar.pFJ).length;
                while (i3 < i4) {
                    bbr bbr = cVar.pFJ[i3];
                    Map map2 = c(cVar.pFH).pCR;
                    g gVar2 = g.pFl;
                    if (!bi.oN((String) map2.get(g.c(bbr)))) {
                        d(cVar.pFH).d(bbr);
                        c(cVar.pFH).a(bbr);
                    }
                    i3++;
                }
                linkedList2 = linkedList3;
            }
            c(cVar.pFH).pCQ = linkedList2;
            c cVar2 = this.pFw;
            if (cVar2 == null) {
                b.c.b.e.adf("adapter");
            }
            cVar2.bmd();
            return;
        }
        a(com.tencent.mm.plugin.radar.b.e.e.SEARCHING);
        RadarTipsView bmJ = bmJ();
        Object string = getContext().getString(com.tencent.mm.plugin.radar.a.f.pBY);
        b.c.b.e.h(string, "context.getString(R.string.radar_tips_network_err)");
        bmJ.IG(string);
    }

    private final void ab(LinkedList<bbr> linkedList) {
        c cVar;
        if (linkedList == null) {
            b.c.b.e.cKr();
        }
        if (linkedList.size() == 0) {
            c cVar2 = this.pFw;
            if (cVar2 == null) {
                b.c.b.e.adf("adapter");
            }
            if (cVar2.getCount() == 0) {
                bmJ().hz(true);
                x.d(TAG, "members got, size : " + linkedList.size());
                x.d(TAG, "has friend:%s", String.valueOf(ac(linkedList)));
                cVar = this.pFw;
                if (cVar == null) {
                    b.c.b.e.adf("adapter");
                }
                cVar.ad(linkedList);
                if (this.pFy && r0) {
                    a(com.tencent.mm.plugin.radar.b.e.e.SEARCH_RETRUN);
                    return;
                }
            }
        }
        bmJ().hz(false);
        x.d(TAG, "members got, size : " + linkedList.size());
        x.d(TAG, "has friend:%s", String.valueOf(ac(linkedList)));
        cVar = this.pFw;
        if (cVar == null) {
            b.c.b.e.adf("adapter");
        }
        cVar.ad(linkedList);
        if (this.pFy) {
        }
    }

    private final boolean ac(LinkedList<bbr> linkedList) {
        boolean z = false;
        if (linkedList == null) {
            b.c.b.e.cKr();
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.radar.b.c.e IE;
            boolean z2;
            bbr bbr = (bbr) it.next();
            com.tencent.mm.plugin.radar.b.e eVar = this.pFu;
            if (eVar == null) {
                b.c.b.e.adf("radarManager");
            }
            b.c.b.e.h((Object) bbr, "member");
            com.tencent.mm.plugin.radar.b.c.e a = eVar.a(bbr, false);
            if (a == null) {
                g gVar = g.pFl;
                String b = g.b(bbr);
                IE = this.pFv.IE(b);
                com.tencent.mm.plugin.radar.b.e eVar2 = this.pFu;
                if (eVar2 == null) {
                    b.c.b.e.adf("radarManager");
                }
                eVar2.b(b, IE);
            } else {
                IE = a;
            }
            if (IE == com.tencent.mm.plugin.radar.b.c.e.Added) {
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        return z;
    }

    private final void a(com.tencent.mm.plugin.radar.b.e.e eVar) {
        this.pFx = eVar;
        com.tencent.mm.plugin.radar.b.e eVar2;
        switch (h.pFW[eVar.ordinal()]) {
            case 1:
                bmN().setVisibility(8);
                bmM().setText(com.tencent.mm.plugin.radar.a.f.pBV);
                bmL().setVisibility(8);
                bmK().setText("");
                bmG().bmQ();
                bmG().setVisibility(0);
                eVar2 = this.pFu;
                if (eVar2 == null) {
                    b.c.b.e.adf("radarManager");
                }
                eVar2.blZ();
                return;
            case 2:
                bmN().setVisibility(8);
                bmL().setVisibility(8);
                bmK().setText("");
                return;
            case 3:
                if (bmN().getVisibility() != 0) {
                    bmN().setAnimation(AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.radar.a.a.pAT));
                    bmN().setVisibility(0);
                }
                bmM().setText(com.tencent.mm.plugin.radar.a.f.dEy);
                eVar2 = this.pFu;
                if (eVar2 == null) {
                    b.c.b.e.adf("radarManager");
                }
                eVar2.bma();
                bmL().setVisibility(0);
                bmK().setText(com.tencent.mm.plugin.radar.a.f.pBW);
                bmG().bmR();
                bmG().setVisibility(4);
                bmI().setVisibility(4);
                c cVar = this.pFw;
                if (cVar == null) {
                    b.c.b.e.adf("adapter");
                }
                cVar.pFL.clear();
                cVar.pFO.clear();
                for (String str : cVar.pFO.keySet()) {
                    Object obj = (View) cVar.pFO.get(str);
                    if (obj != null) {
                        a aVar = cVar.pFM;
                        b.c.b.e.h(obj, "it");
                        b.c.b.e.i(obj, "view");
                        int cq = aVar.cq(obj);
                        if (cq > 0) {
                            aVar.pFG.removeMessages(cq);
                        }
                        obj.clearAnimation();
                    }
                }
                cVar.bmd();
                return;
            case 4:
                bmN().setVisibility(0);
                eVar2 = this.pFu;
                if (eVar2 == null) {
                    b.c.b.e.adf("radarManager");
                }
                eVar2.bma();
                bmL().setVisibility(8);
                bmK().setText(com.tencent.mm.plugin.radar.a.f.pBS);
                bmI().setVisibility(0);
                return;
            case 5:
                bmN().setVisibility(8);
                eVar2 = this.pFu;
                if (eVar2 == null) {
                    b.c.b.e.adf("radarManager");
                }
                eVar2.bma();
                bmL().setVisibility(0);
                bmK().setText(com.tencent.mm.plugin.radar.a.f.pBT);
                return;
            default:
                return;
        }
    }
}
