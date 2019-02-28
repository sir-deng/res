package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.la;
import com.tencent.mm.f.a.pq;
import com.tencent.mm.f.a.pt;
import com.tencent.mm.f.a.qo;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.s.b;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.y.d;
import java.io.File;

public class OnlineVideoView extends RelativeLayout implements com.tencent.mm.plugin.sns.ui.af.a, com.tencent.mm.pluginsdk.ui.tools.f.a, com.tencent.mm.y.d.a {
    private int duration;
    private int fIU;
    private boolean fIV;
    private int fIW;
    private are fIx;
    private String fvn;
    private int hBH;
    private d jwC;
    ag kXJ;
    boolean kYN;
    f kYP;
    private al kYV;
    ImageView mBj;
    private TextView mBk;
    private boolean mBl;
    private boolean mBm;
    private int mBn;
    private ProgressBar mBp;
    private MMPinProgressBtn mBq;
    private Context mContext;
    private RelativeLayout mDg;
    private b ovm;
    private an qWV;
    private boolean rAN;
    private e rAQ;
    private int rAU;
    boolean rAV;
    String rAW;
    private boolean rAX;
    private a rAY;
    private TextView rAZ;
    private af rBa;
    private boolean rBb;
    private boolean rBc;
    private int rBd;
    private int rBe;
    private long rBf;
    private long rBg;
    private al rBh;
    private com.tencent.mm.plugin.sns.model.b.b rBi;
    private c rBj;
    c rBk;
    private long rBl;
    private int rBm;
    private c rdJ;

    public interface a {
    }

    static /* synthetic */ void a(OnlineVideoView onlineVideoView, int i) {
        if (onlineVideoView.fIW > 0) {
            x.w("MicroMsg.OnlineVideoView", "send video now, do nothing.");
            return;
        }
        x.i("MicroMsg.OnlineVideoView", "%d retransmit video req code %d, download finish path %s", Integer.valueOf(onlineVideoView.hashCode()), Integer.valueOf(i), ap.a(onlineVideoView.fvn, onlineVideoView.fIx));
        if (bi.oN(ap.a(onlineVideoView.fvn, onlineVideoView.fIx))) {
            onlineVideoView.fIW = i;
            onlineVideoView.t(true, 33);
            onlineVideoView.amd();
            g.pWK.a(354, 223, 1, false);
            return;
        }
        onlineVideoView.xO(i);
    }

    static /* synthetic */ void a(OnlineVideoView onlineVideoView, int i, boolean z) {
        if (onlineVideoView.fIU > 0) {
            x.w("MicroMsg.OnlineVideoView", "fav video now, do nothing.");
            return;
        }
        x.i("MicroMsg.OnlineVideoView", "%d fav video req code %d fromMain %b, download finish path %s", Integer.valueOf(onlineVideoView.hashCode()), Integer.valueOf(i), Boolean.valueOf(z), ap.a(onlineVideoView.fvn, onlineVideoView.fIx));
        if (bi.oN(ap.a(onlineVideoView.fvn, onlineVideoView.fIx))) {
            onlineVideoView.fIU = i;
            onlineVideoView.fIV = z;
            onlineVideoView.t(true, 35);
            onlineVideoView.amd();
            g.pWK.a(354, 224, 1, false);
            return;
        }
        onlineVideoView.O(i, z);
    }

    static /* synthetic */ void p(OnlineVideoView onlineVideoView) {
        x.i("MicroMsg.OnlineVideoView", "%d save video, download finish path %s", Integer.valueOf(onlineVideoView.hashCode()), ap.a(onlineVideoView.fvn, onlineVideoView.fIx));
        if (bi.oN(ap.a(onlineVideoView.fvn, onlineVideoView.fIx))) {
            onlineVideoView.rAX = true;
            onlineVideoView.t(true, 34);
            onlineVideoView.amd();
            g.pWK.a(354, 220, 1, false);
            return;
        }
        onlineVideoView.bAu();
    }

    public OnlineVideoView(Context context) {
        this(context, null);
    }

    public OnlineVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OnlineVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rAU = 0;
        this.rAV = false;
        this.mBl = false;
        this.kYN = false;
        this.fIx = null;
        this.rAX = false;
        this.rBa = null;
        this.rBc = false;
        this.duration = 0;
        this.rBd = 0;
        this.rBe = 0;
        this.rBf = 0;
        this.rBg = 0;
        this.mBn = 0;
        this.kXJ = new ag(Looper.getMainLooper());
        this.rBh = new al(new com.tencent.mm.sdk.platformtools.al.a() {
            public final boolean uG() {
                if (OnlineVideoView.this.rBa == null || OnlineVideoView.this.kYP == null) {
                    return false;
                }
                if (((View) OnlineVideoView.this.kYP).getAlpha() < 1.0f) {
                    OnlineVideoView.this.a(true, 1.0f);
                }
                if (OnlineVideoView.this.kYP.isPlaying()) {
                    OnlineVideoView.this.aVF();
                }
                try {
                    Object obj;
                    if (bi.oN(OnlineVideoView.this.rBa.hVi)) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj == null) {
                        return false;
                    }
                    return OnlineVideoView.this.rBa.iK(OnlineVideoView.this.kYP.getCurrentPosition() / 1000);
                } catch (Exception e) {
                    x.e("MicroMsg.OnlineVideoView", "online video timer check error : " + e.toString());
                    return false;
                }
            }
        }, true);
        this.kYV = new al(new com.tencent.mm.sdk.platformtools.al.a() {
            public final boolean uG() {
                if (OnlineVideoView.this.kYP == null) {
                    return false;
                }
                if (((View) OnlineVideoView.this.kYP).getAlpha() < 1.0f) {
                    OnlineVideoView.this.a(true, 1.0f);
                }
                if (OnlineVideoView.this.kYP.isPlaying()) {
                    OnlineVideoView.this.aVF();
                    OnlineVideoView.this.kYP.getCurrentPosition();
                }
                return true;
            }
        }, true);
        this.rBi = new com.tencent.mm.plugin.sns.model.b.b() {
            public final void Ky(String str) {
            }

            public final void aE(String str, boolean z) {
            }

            public final void buX() {
            }

            public final void aF(final String str, final boolean z) {
                OnlineVideoView.this.kXJ.postDelayed(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.OnlineVideoView", "%d weixin download finish[%b], go to prepare video", Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(z));
                        if (OnlineVideoView.this.fIx != null && z && bi.fA(OnlineVideoView.this.fIx.nMq, str)) {
                            ap.ej(OnlineVideoView.this.fvn, "");
                            String a = ap.a(OnlineVideoView.this.fvn, OnlineVideoView.this.fIx);
                            if (!bi.oN(a)) {
                                OnlineVideoView.this.aI(a, false);
                            }
                        }
                    }
                }, 100);
            }
        };
        this.rBj = new c<qo>() {
            {
                this.xmG = qo.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                qo qoVar = (qo) bVar;
                x.i("MicroMsg.OnlineVideoView", "%d sns video menu event local id[%s, %s]", Integer.valueOf(OnlineVideoView.this.hashCode()), qoVar.fIT.fvn, OnlineVideoView.this.fvn);
                if (bi.fA(qoVar.fIT.fvn, OnlineVideoView.this.fvn)) {
                    if (qoVar.fIT.fvG == 1) {
                        OnlineVideoView.a(OnlineVideoView.this, qoVar.fIT.fIW);
                    } else if (qoVar.fIT.fvG == 2) {
                        OnlineVideoView.a(OnlineVideoView.this, qoVar.fIT.fIU, qoVar.fIT.fIV);
                    } else if (qoVar.fIT.fvG == 3) {
                        OnlineVideoView.p(OnlineVideoView.this);
                    }
                }
                return false;
            }
        };
        this.rBk = new c<pt>() {
            {
                this.xmG = pt.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                final pt ptVar = (pt) bVar;
                x.i("MicroMsg.OnlineVideoView", "%d sns flip ui event. local id[%s, %s] opcode %d hadUiEvent %b", Integer.valueOf(OnlineVideoView.this.hashCode()), ptVar.fIp.fvn, OnlineVideoView.this.fvn, Integer.valueOf(ptVar.fIp.fvG), Boolean.valueOf(OnlineVideoView.this.rBc));
                if (ptVar.fIp.fvG == 2) {
                    OnlineVideoView.this.rBc = false;
                    OnlineVideoView.this.bAt();
                    OnlineVideoView.this.onDestroy();
                } else if (ptVar.fIp.fvG == 1) {
                    OnlineVideoView.this.kXJ.post(new Runnable() {
                        public final void run() {
                            if (!bi.fA(ptVar.fIp.fvn, OnlineVideoView.this.fvn)) {
                                OnlineVideoView.this.rBc = false;
                                OnlineVideoView.this.bAt();
                                OnlineVideoView.this.onDestroy();
                            } else if (OnlineVideoView.this.rBc) {
                                OnlineVideoView.this.requestLayout();
                            } else {
                                OnlineVideoView.this.rBc = true;
                                OnlineVideoView.this.onResume();
                            }
                        }
                    });
                }
                return false;
            }
        };
        this.rdJ = new c<la>() {
            {
                this.xmG = la.class.getName().hashCode();
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private boolean a(com.tencent.mm.f.a.la r14) {
                /*
                r13 = this;
                r3 = 2;
                r2 = 1;
                r12 = 0;
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;
                r0 = r0.rBa;
                if (r0 != 0) goto L_0x0023;
            L_0x000b:
                r0 = "MicroMsg.OnlineVideoView";
                r1 = "%d online video helper is null.";
                r2 = new java.lang.Object[r2];
                r3 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;
                r3 = r3.hashCode();
                r3 = java.lang.Integer.valueOf(r3);
                r2[r12] = r3;
                com.tencent.mm.sdk.platformtools.x.w(r0, r1, r2);
            L_0x0022:
                return r12;
            L_0x0023:
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.rBa;	 Catch:{ Exception -> 0x0054 }
                r1 = r14.fDe;	 Catch:{ Exception -> 0x0054 }
                r1 = r1.mediaId;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.My(r1);	 Catch:{ Exception -> 0x0054 }
                if (r0 == 0) goto L_0x0022;
            L_0x0033:
                r0 = r14.fDe;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.retCode;	 Catch:{ Exception -> 0x0054 }
                r1 = -21112; // 0xffffffffffffad88 float:NaN double:NaN;
                if (r0 != r1) goto L_0x0070;
            L_0x003b:
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r1 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ Exception -> 0x0054 }
                r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
                r4 = 218; // 0xda float:3.05E-43 double:1.077E-321;
                r6 = 1;
                r8 = 0;
                r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x0054 }
                r1 = r0.kXJ;	 Catch:{ Exception -> 0x0054 }
                r2 = new com.tencent.mm.plugin.sns.ui.OnlineVideoView$9;	 Catch:{ Exception -> 0x0054 }
                r2.<init>();	 Catch:{ Exception -> 0x0054 }
                r1.post(r2);	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x0054:
                r0 = move-exception;
                r1 = "MicroMsg.OnlineVideoView";
                r2 = new java.lang.StringBuilder;
                r3 = "online video callback error: ";
                r2.<init>(r3);
                r0 = r0.toString();
                r0 = r2.append(r0);
                r0 = r0.toString();
                com.tencent.mm.sdk.platformtools.x.e(r1, r0);
                goto L_0x0022;
            L_0x0070:
                r0 = r14.fDe;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.retCode;	 Catch:{ Exception -> 0x0054 }
                if (r0 == 0) goto L_0x00a3;
            L_0x0076:
                r0 = r14.fDe;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.retCode;	 Catch:{ Exception -> 0x0054 }
                r1 = -21006; // 0xffffffffffffadf2 float:NaN double:NaN;
                if (r0 == r1) goto L_0x00a3;
            L_0x007e:
                r0 = "MicroMsg.OnlineVideoView";
                r1 = "%d stream download online video error. retCode %d ";
                r2 = 2;
                r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0054 }
                r3 = 0;
                r4 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r4 = r4.hashCode();	 Catch:{ Exception -> 0x0054 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
                r3 = 1;
                r4 = r14.fDe;	 Catch:{ Exception -> 0x0054 }
                r4 = r4.retCode;	 Catch:{ Exception -> 0x0054 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.x.w(r0, r1, r2);	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x00a3:
                r0 = r14.fDe;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.fvG;	 Catch:{ Exception -> 0x0054 }
                switch(r0) {
                    case 1: goto L_0x00d0;
                    case 2: goto L_0x0205;
                    case 3: goto L_0x02c9;
                    case 4: goto L_0x02d1;
                    case 5: goto L_0x03c4;
                    case 6: goto L_0x043f;
                    default: goto L_0x00aa;
                };	 Catch:{ Exception -> 0x0054 }
            L_0x00aa:
                r0 = "MicroMsg.OnlineVideoView";
                r1 = "%d unknown event opcode %d";
                r2 = 2;
                r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0054 }
                r3 = 0;
                r4 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r4 = r4.hashCode();	 Catch:{ Exception -> 0x0054 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
                r3 = 1;
                r4 = r14.fDe;	 Catch:{ Exception -> 0x0054 }
                r4 = r4.fvG;	 Catch:{ Exception -> 0x0054 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.x.w(r0, r1, r2);	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x00d0:
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r2 = r0.rBa;	 Catch:{ Exception -> 0x0054 }
                r0 = r14.fDe;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.offset;	 Catch:{ Exception -> 0x0054 }
                r4 = (long) r0;	 Catch:{ Exception -> 0x0054 }
                r0 = r14.fDe;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.fDf;	 Catch:{ Exception -> 0x0054 }
                r3 = r14.fDe;	 Catch:{ Exception -> 0x0054 }
                r3 = r3.fDg;	 Catch:{ Exception -> 0x0054 }
                r6 = "MicroMsg.OnlineVideoViewHelper";
                r7 = "deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s startDownload[%d %d]";
                r8 = 5;
                r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x0054 }
                r9 = 0;
                r10 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
                r8[r9] = r10;	 Catch:{ Exception -> 0x0054 }
                r9 = 1;
                r10 = r2.hVo;	 Catch:{ Exception -> 0x0054 }
                r10 = java.lang.Integer.valueOf(r10);	 Catch:{ Exception -> 0x0054 }
                r8[r9] = r10;	 Catch:{ Exception -> 0x0054 }
                r9 = 2;
                r10 = r2.hVi;	 Catch:{ Exception -> 0x0054 }
                r8[r9] = r10;	 Catch:{ Exception -> 0x0054 }
                r9 = 3;
                r10 = java.lang.Long.valueOf(r0);	 Catch:{ Exception -> 0x0054 }
                r8[r9] = r10;	 Catch:{ Exception -> 0x0054 }
                r9 = 4;
                r10 = r2.hvr;	 Catch:{ Exception -> 0x0054 }
                r10 = java.lang.Long.valueOf(r10);	 Catch:{ Exception -> 0x0054 }
                r8[r9] = r10;	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.x.i(r6, r7, r8);	 Catch:{ Exception -> 0x0054 }
                r6 = r2.hVo;	 Catch:{ Exception -> 0x0054 }
                if (r6 == 0) goto L_0x0128;
            L_0x0118:
                r0 = "MicroMsg.OnlineVideoViewHelper";
                r1 = "moov had callback, do nothing.";
                com.tencent.mm.sdk.platformtools.x.w(r0, r1);	 Catch:{ Exception -> 0x0054 }
            L_0x0121:
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r0.rBb = true;	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x0128:
                r6 = r2.hvr;	 Catch:{ Exception -> 0x0054 }
                r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
                if (r6 <= 0) goto L_0x0160;
            L_0x012e:
                r2.hvr = r0;	 Catch:{ Exception -> 0x0054 }
                r0 = com.tencent.mm.sdk.platformtools.bi.Wy();	 Catch:{ Exception -> 0x0054 }
                r2.rBx = r0;	 Catch:{ Exception -> 0x0054 }
                r0 = r2.hVn;	 Catch:{ Exception -> 0x0144 }
                if (r0 != 0) goto L_0x0163;
            L_0x013a:
                r0 = "MicroMsg.OnlineVideoViewHelper";
                r1 = "parser is null, thread is error.";
                com.tencent.mm.sdk.platformtools.x.w(r0, r1);	 Catch:{ Exception -> 0x0144 }
                goto L_0x0121;
            L_0x0144:
                r0 = move-exception;
                r1 = "MicroMsg.OnlineVideoViewHelper";
                r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0054 }
                r3 = "deal moov ready error: ";
                r2.<init>(r3);	 Catch:{ Exception -> 0x0054 }
                r0 = r0.toString();	 Catch:{ Exception -> 0x0054 }
                r0 = r2.append(r0);	 Catch:{ Exception -> 0x0054 }
                r0 = r0.toString();	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.x.e(r1, r0);	 Catch:{ Exception -> 0x0054 }
                goto L_0x0121;
            L_0x0160:
                r0 = r2.hvr;	 Catch:{ Exception -> 0x0054 }
                goto L_0x012e;
            L_0x0163:
                r0 = r2.hVn;	 Catch:{ Exception -> 0x0144 }
                r1 = r2.hVj;	 Catch:{ Exception -> 0x0144 }
                r0 = r0.r(r1, r4);	 Catch:{ Exception -> 0x0144 }
                if (r0 == 0) goto L_0x01b8;
            L_0x016d:
                r0 = r2.hVn;	 Catch:{ Exception -> 0x0144 }
                r0 = r0.ihv;	 Catch:{ Exception -> 0x0144 }
                r2.hVo = r0;	 Catch:{ Exception -> 0x0144 }
                r0 = "MicroMsg.OnlineVideoViewHelper";
                r1 = "mp4 parse moov success. duration %d cdnMediaId %s isFastStart %b";
                r4 = 3;
                r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0144 }
                r5 = 0;
                r6 = r2.hVo;	 Catch:{ Exception -> 0x0144 }
                r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0144 }
                r4[r5] = r6;	 Catch:{ Exception -> 0x0144 }
                r5 = 1;
                r6 = r2.hVi;	 Catch:{ Exception -> 0x0144 }
                r4[r5] = r6;	 Catch:{ Exception -> 0x0144 }
                r5 = 2;
                r6 = java.lang.Boolean.valueOf(r3);	 Catch:{ Exception -> 0x0144 }
                r4[r5] = r6;	 Catch:{ Exception -> 0x0144 }
                com.tencent.mm.sdk.platformtools.x.i(r0, r1, r4);	 Catch:{ Exception -> 0x0144 }
                if (r3 != 0) goto L_0x019e;
            L_0x0196:
                r0 = new com.tencent.mm.plugin.sns.ui.af$1;	 Catch:{ Exception -> 0x0144 }
                r0.<init>();	 Catch:{ Exception -> 0x0144 }
                com.tencent.mm.sdk.platformtools.ah.y(r0);	 Catch:{ Exception -> 0x0144 }
            L_0x019e:
                r0 = r2.hVp;	 Catch:{ Exception -> 0x0144 }
                r1 = -1;
                if (r0 != r1) goto L_0x01b4;
            L_0x01a3:
                r0 = 1;
                r2.hVm = r0;	 Catch:{ Exception -> 0x0144 }
            L_0x01a6:
                r1 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ Exception -> 0x0144 }
                r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
                r4 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
                r6 = 1;
                r8 = 0;
                r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x0144 }
                goto L_0x0121;
            L_0x01b4:
                r0 = 2;
                r2.hVm = r0;	 Catch:{ Exception -> 0x0144 }
                goto L_0x01a6;
            L_0x01b8:
                r0 = "MicroMsg.OnlineVideoViewHelper";
                r1 = "mp4 parse moov error. cdnMediaId %s";
                r3 = 1;
                r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0144 }
                r4 = 0;
                r5 = r2.hVi;	 Catch:{ Exception -> 0x0144 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0144 }
                com.tencent.mm.sdk.platformtools.x.w(r0, r1, r3);	 Catch:{ Exception -> 0x0144 }
                com.tencent.mm.modelvideo.o.Uc();	 Catch:{ Exception -> 0x0144 }
                r0 = r2.hVi;	 Catch:{ Exception -> 0x0144 }
                r1 = 0;
                r2 = -1;
                com.tencent.mm.modelcdntran.f.f(r0, r1, r2);	 Catch:{ Exception -> 0x0144 }
                r1 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ Exception -> 0x0144 }
                r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
                r4 = 205; // 0xcd float:2.87E-43 double:1.013E-321;
                r6 = 1;
                r8 = 0;
                r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x0144 }
                r0 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ Exception -> 0x0144 }
                r1 = 13836; // 0x360c float:1.9388E-41 double:6.836E-320;
                r2 = 3;
                r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0144 }
                r3 = 0;
                r4 = 402; // 0x192 float:5.63E-43 double:1.986E-321;
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0144 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0144 }
                r3 = 1;
                r4 = com.tencent.mm.sdk.platformtools.bi.Wx();	 Catch:{ Exception -> 0x0144 }
                r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x0144 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0144 }
                r3 = 2;
                r4 = "";
                r2[r3] = r4;	 Catch:{ Exception -> 0x0144 }
                r0.h(r1, r2);	 Catch:{ Exception -> 0x0144 }
                goto L_0x0121;
            L_0x0205:
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r1 = r0.rBa;	 Catch:{ Exception -> 0x0054 }
                r0 = r14.fDe;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.mediaId;	 Catch:{ Exception -> 0x0054 }
                r2 = r14.fDe;	 Catch:{ Exception -> 0x0054 }
                r2 = r2.offset;	 Catch:{ Exception -> 0x0054 }
                r3 = r14.fDe;	 Catch:{ Exception -> 0x0054 }
                r3 = r3.length;	 Catch:{ Exception -> 0x0054 }
                r4 = 0;
                r1.hVv = r4;	 Catch:{ Exception -> 0x0054 }
                if (r2 < 0) goto L_0x021e;
            L_0x021c:
                if (r3 >= 0) goto L_0x0246;
            L_0x021e:
                r0 = "MicroMsg.OnlineVideoViewHelper";
                r1 = "deal data available error offset[%d], length[%d]";
                r4 = 2;
                r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0054 }
                r5 = 0;
                r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0054 }
                r4[r5] = r2;	 Catch:{ Exception -> 0x0054 }
                r2 = 1;
                r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x0054 }
                r4[r2] = r3;	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.x.w(r0, r1, r4);	 Catch:{ Exception -> 0x0054 }
            L_0x0238:
                r0 = r14.fDe;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.length;	 Catch:{ Exception -> 0x0054 }
                if (r0 <= 0) goto L_0x0022;
            L_0x023e:
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r1 = 1;
                r0.bZ(r1);	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x0246:
                r0 = r1.My(r0);	 Catch:{ Exception -> 0x0054 }
                if (r0 == 0) goto L_0x0238;
            L_0x024c:
                r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0054 }
                r0.<init>();	 Catch:{ Exception -> 0x0054 }
                r4 = r1.hVi;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.append(r4);	 Catch:{ Exception -> 0x0054 }
                r0 = r0.append(r2);	 Catch:{ Exception -> 0x0054 }
                r4 = "_";
                r0 = r0.append(r4);	 Catch:{ Exception -> 0x0054 }
                r0 = r0.append(r3);	 Catch:{ Exception -> 0x0054 }
                r0 = r0.toString();	 Catch:{ Exception -> 0x0054 }
                r4 = r1.rBt;	 Catch:{ Exception -> 0x0054 }
                r0 = r4.get(r0);	 Catch:{ Exception -> 0x0054 }
                r0 = (java.lang.Integer) r0;	 Catch:{ Exception -> 0x0054 }
                if (r0 == 0) goto L_0x02a4;
            L_0x0274:
                r4 = r0.intValue();	 Catch:{ Exception -> 0x0054 }
                if (r4 <= 0) goto L_0x02a4;
            L_0x027a:
                r0 = r0.intValue();	 Catch:{ Exception -> 0x0054 }
                r1.hVs = r0;	 Catch:{ Exception -> 0x0054 }
            L_0x0280:
                r0 = "MicroMsg.OnlineVideoViewHelper";
                r4 = "deal data available. offset[%d] length[%d] cachePlayTime[%d]";
                r5 = 3;
                r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0054 }
                r6 = 0;
                r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0054 }
                r5[r6] = r2;	 Catch:{ Exception -> 0x0054 }
                r2 = 1;
                r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x0054 }
                r5[r2] = r3;	 Catch:{ Exception -> 0x0054 }
                r2 = 2;
                r1 = r1.hVs;	 Catch:{ Exception -> 0x0054 }
                r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x0054 }
                r5[r2] = r1;	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.x.i(r0, r4, r5);	 Catch:{ Exception -> 0x0054 }
                goto L_0x0238;
            L_0x02a4:
                r0 = r1.hVn;	 Catch:{ Exception -> 0x02ad }
                r0 = r0.bu(r2, r3);	 Catch:{ Exception -> 0x02ad }
                r1.hVs = r0;	 Catch:{ Exception -> 0x02ad }
                goto L_0x0280;
            L_0x02ad:
                r0 = move-exception;
                r4 = "MicroMsg.OnlineVideoViewHelper";
                r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0054 }
                r6 = "deal data available file pos to video time error: ";
                r5.<init>(r6);	 Catch:{ Exception -> 0x0054 }
                r0 = r0.toString();	 Catch:{ Exception -> 0x0054 }
                r0 = r5.append(r0);	 Catch:{ Exception -> 0x0054 }
                r0 = r0.toString();	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.x.e(r4, r0);	 Catch:{ Exception -> 0x0054 }
                goto L_0x0280;
            L_0x02c9:
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r1 = 1;
                r0.bZ(r1);	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x02d1:
                r0 = "MicroMsg.OnlineVideoView";
                r1 = "%d download finish. cdnMediaId %s sendReqCode %d favFromScene %d";
                r2 = 4;
                r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0054 }
                r3 = 0;
                r4 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r4 = r4.hashCode();	 Catch:{ Exception -> 0x0054 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
                r3 = 1;
                r4 = r14.fDe;	 Catch:{ Exception -> 0x0054 }
                r4 = r4.mediaId;	 Catch:{ Exception -> 0x0054 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
                r3 = 2;
                r4 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r4 = r4.fIW;	 Catch:{ Exception -> 0x0054 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
                r3 = 3;
                r4 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r4 = r4.fIU;	 Catch:{ Exception -> 0x0054 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);	 Catch:{ Exception -> 0x0054 }
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.rBa;	 Catch:{ Exception -> 0x0054 }
                r1 = "MicroMsg.OnlineVideoViewHelper";
                r2 = "deal stream finish. playStatus %d cdnMediaId %s";
                r3 = 2;
                r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0054 }
                r4 = 0;
                r5 = r0.hVm;	 Catch:{ Exception -> 0x0054 }
                r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0054 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0054 }
                r4 = 1;
                r5 = r0.hVi;	 Catch:{ Exception -> 0x0054 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ Exception -> 0x0054 }
                r1 = 0;
                r0.hVv = r1;	 Catch:{ Exception -> 0x0054 }
                r1 = 3;
                r0.hVl = r1;	 Catch:{ Exception -> 0x0054 }
                r1 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ Exception -> 0x0054 }
                r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
                r4 = 206; // 0xce float:2.89E-43 double:1.02E-321;
                r6 = 1;
                r8 = 0;
                r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x0054 }
                r1 = r0.hVm;	 Catch:{ Exception -> 0x0054 }
                if (r1 != 0) goto L_0x0367;
            L_0x0341:
                r1 = "MicroMsg.OnlineVideoViewHelper";
                r2 = "it had not moov callback and download finish start to play video.";
                com.tencent.mm.sdk.platformtools.x.w(r1, r2);	 Catch:{ Exception -> 0x0054 }
                r0.bAF();	 Catch:{ Exception -> 0x0054 }
            L_0x034d:
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.fIW;	 Catch:{ Exception -> 0x0054 }
                if (r0 <= 0) goto L_0x0388;
            L_0x0355:
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r0.aVF();	 Catch:{ Exception -> 0x0054 }
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r1 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r1 = r1.fIW;	 Catch:{ Exception -> 0x0054 }
                r0.xO(r1);	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x0367:
                r1 = r0.hVm;	 Catch:{ Exception -> 0x0054 }
                r2 = 5;
                if (r1 != r2) goto L_0x034d;
            L_0x036c:
                r1 = "MicroMsg.OnlineVideoViewHelper";
                r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0054 }
                r3 = "it had play error, it request all video data finish, start to play.";
                r2.<init>(r3);	 Catch:{ Exception -> 0x0054 }
                r3 = r0.hVi;	 Catch:{ Exception -> 0x0054 }
                r2 = r2.append(r3);	 Catch:{ Exception -> 0x0054 }
                r2 = r2.toString();	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.x.w(r1, r2);	 Catch:{ Exception -> 0x0054 }
                r0.bAF();	 Catch:{ Exception -> 0x0054 }
                goto L_0x034d;
            L_0x0388:
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.fIU;	 Catch:{ Exception -> 0x0054 }
                if (r0 <= 0) goto L_0x03a8;
            L_0x0390:
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r0.aVF();	 Catch:{ Exception -> 0x0054 }
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r1 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r1 = r1.fIU;	 Catch:{ Exception -> 0x0054 }
                r2 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r2 = r2.fIV;	 Catch:{ Exception -> 0x0054 }
                r0.O(r1, r2);	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x03a8:
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.rAX;	 Catch:{ Exception -> 0x0054 }
                if (r0 == 0) goto L_0x03bc;
            L_0x03b0:
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r0.aVF();	 Catch:{ Exception -> 0x0054 }
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r0.bAu();	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x03bc:
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r1 = 1;
                r0.bZ(r1);	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x03c4:
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.rAU;	 Catch:{ Exception -> 0x0054 }
                if (r0 != r2) goto L_0x0428;
            L_0x03cc:
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.rBa;	 Catch:{ Exception -> 0x0054 }
                r1 = r14.fDe;	 Catch:{ Exception -> 0x0054 }
                r1 = r1.mediaId;	 Catch:{ Exception -> 0x0054 }
                r2 = r14.fDe;	 Catch:{ Exception -> 0x0054 }
                r2 = r2.offset;	 Catch:{ Exception -> 0x0054 }
                r3 = r14.fDe;	 Catch:{ Exception -> 0x0054 }
                r3 = r3.length;	 Catch:{ Exception -> 0x0054 }
                r1 = r0.My(r1);	 Catch:{ Exception -> 0x0054 }
                if (r1 == 0) goto L_0x041d;
            L_0x03e4:
                r0.progress = r2;	 Catch:{ Exception -> 0x0054 }
                r0.qnf = r3;	 Catch:{ Exception -> 0x0054 }
                r1 = r0.progress;	 Catch:{ Exception -> 0x0054 }
                r1 = r1 * 100;
                r2 = r0.qnf;	 Catch:{ Exception -> 0x0054 }
                r1 = r1 / r2;
                r0.rBv = r1;	 Catch:{ Exception -> 0x0054 }
                r1 = "MicroMsg.OnlineVideoViewHelper";
                r2 = "deal video[%s] progress callback[%d, %d]. downloadedPercent[%d]";
                r3 = 4;
                r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0054 }
                r4 = 0;
                r5 = r0.hVi;	 Catch:{ Exception -> 0x0054 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0054 }
                r4 = 1;
                r5 = r0.progress;	 Catch:{ Exception -> 0x0054 }
                r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0054 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0054 }
                r4 = 2;
                r5 = r0.qnf;	 Catch:{ Exception -> 0x0054 }
                r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0054 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0054 }
                r4 = 3;
                r5 = r0.rBv;	 Catch:{ Exception -> 0x0054 }
                r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0054 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ Exception -> 0x0054 }
            L_0x041d:
                r1 = r0.rBv;	 Catch:{ Exception -> 0x0054 }
                r2 = 100;
                if (r1 < r2) goto L_0x0022;
            L_0x0423:
                r1 = 3;
                r0.hVl = r1;	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x0428:
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.rAU;	 Catch:{ Exception -> 0x0054 }
                if (r0 != r3) goto L_0x0022;
            L_0x0430:
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r1 = r14.fDe;	 Catch:{ Exception -> 0x0054 }
                r1 = r1.offset;	 Catch:{ Exception -> 0x0054 }
                r2 = r14.fDe;	 Catch:{ Exception -> 0x0054 }
                r2 = r2.length;	 Catch:{ Exception -> 0x0054 }
                r0.kXJ.post(new com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass12(r1, r2));	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
            L_0x043f:
                r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.this;	 Catch:{ Exception -> 0x0054 }
                r0 = r0.rBa;	 Catch:{ Exception -> 0x0054 }
                r1 = "MicroMsg.OnlineVideoViewHelper";
                r2 = "deal had dup video. cdnMediaId %s";
                r3 = 1;
                r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0054 }
                r4 = 0;
                r5 = r0.hVi;	 Catch:{ Exception -> 0x0054 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0054 }
                com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ Exception -> 0x0054 }
                r0.bAF();	 Catch:{ Exception -> 0x0054 }
                goto L_0x0022;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.OnlineVideoView.5.a(com.tencent.mm.f.a.la):boolean");
            }
        };
        this.rAQ = new e() {
            public final void bcn() {
                x.i("MicroMsg.OnlineVideoView", "%d on texture update.", Integer.valueOf(OnlineVideoView.this.hashCode()));
                try {
                    OnlineVideoView.this.a(true, 1.0f);
                } catch (Exception e) {
                    x.e("MicroMsg.OnlineVideoView", "texture view update. error " + e.toString());
                }
            }
        };
        this.ovm = new b() {
            public final long baf() {
                x.i("MicroMsg.OnlineVideoView", "%d sns video get online cache", Integer.valueOf(OnlineVideoView.this.hashCode()));
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, Boolean.valueOf(true));
                try {
                    if (OnlineVideoView.this.rBb && OnlineVideoView.this.rBa != null) {
                        return (long) OnlineVideoView.this.rBa.hVs;
                    }
                } catch (Exception e) {
                }
                return 0;
            }
        };
        this.mContext = context;
        x.i("MicroMsg.OnlineVideoView", "%d ui init view.", Integer.valueOf(hashCode()));
        LayoutInflater.from(context).inflate(i.g.qOo, this);
        this.mBj = (ImageView) findViewById(i.f.cVD);
        this.mDg = (RelativeLayout) findViewById(i.f.cVB);
        this.rAZ = (TextView) findViewById(i.f.cUZ);
        this.rAZ.setVisibility(8);
        this.mBq = (MMPinProgressBtn) findViewById(i.f.cVq);
        this.mBp = (ProgressBar) findViewById(i.f.cVi);
        this.mBk = (TextView) findViewById(i.f.cVG);
        com.tencent.mm.modelcontrol.d.Na();
        if (com.tencent.mm.modelcontrol.d.Nh()) {
            this.mBm = true;
            this.kYP = new VideoPlayerTextureView(context);
            ((VideoPlayerTextureView) this.kYP).ovm = this.ovm;
            ((VideoPlayerTextureView) this.kYP).vEX = true;
            g.pWK.a(354, 148, 1, false);
        } else {
            this.mBm = false;
            this.kYP = new VideoTextureView(context);
            g.pWK.a(354, 149, 1, false);
        }
        this.kYP.a((com.tencent.mm.pluginsdk.ui.tools.f.a) this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.mDg.addView((View) this.kYP, layoutParams);
        a(false, 0.0f);
    }

    public final void bAt() {
        x.d("MicroMsg.OnlineVideoView", "%d unRegister sns ui event", Integer.valueOf(hashCode()));
        com.tencent.mm.sdk.b.a.xmy.c(this.rBk);
    }

    public final void a(are are, String str, int i) {
        this.fvn = str;
        this.hBH = i;
        an cjI = an.cjI();
        cjI.time = this.hBH;
        this.qWV = cjI;
        if (this.fIx != are) {
            this.fIx = are;
            boolean c = ae.bwc().c(this.fIx, this.mBj, i.e.black, this.mContext.hashCode(), this.qWV);
            x.i("MicroMsg.OnlineVideoView", "%d fresh thumb image %b", Integer.valueOf(hashCode()), Boolean.valueOf(c));
        }
        this.rAV = false;
        x.i("MicroMsg.OnlineVideoView", "%d set video data[%s, %d] isPreview %b ", Integer.valueOf(hashCode()), this.fvn, Integer.valueOf(this.hBH), Boolean.valueOf(this.rAV));
    }

    public final void onResume() {
        x.d("MicroMsg.OnlineVideoView", "%d on resume %s", Integer.valueOf(hashCode()), bi.chl());
        this.rBf = bi.Wy();
        if (this.rBa == null) {
            x.i("MicroMsg.OnlineVideoView", "%d logic init, create new helper and add listener.", Integer.valueOf(hashCode()));
            this.rBa = new af(this);
            com.tencent.mm.sdk.b.a.xmy.b(this.rdJ);
            com.tencent.mm.sdk.b.a.xmy.b(this.rBj);
            ae.bwa().a(this.rBi);
            this.jwC = new d();
            this.jwC.a(this);
            if (com.tencent.mm.o.a.uy() != null) {
                com.tencent.mm.o.a.uy().wI();
            }
        }
        if (!this.mBl) {
            bAq();
        }
        this.rAN = true;
    }

    public final void onPause() {
        x.d("MicroMsg.OnlineVideoView", "%d on pause %s ", Integer.valueOf(hashCode()), bi.chl());
        bAv();
        if (this.kYP != null) {
            this.kYP.stop();
        }
    }

    public final void onDestroy() {
        x.d("MicroMsg.OnlineVideoView", "%d on destroy %s", Integer.valueOf(hashCode()), bi.chl());
        this.rBg = bi.Wy();
        x.i("MicroMsg.OnlineVideoView", "%d logic unInit", Integer.valueOf(hashCode()));
        bAy();
        this.kYP.stop();
        com.tencent.mm.sdk.b.a.xmy.c(this.rdJ);
        com.tencent.mm.sdk.b.a.xmy.c(this.rBj);
        ae.bwa().b(this.rBi);
        bAv();
        this.kXJ.removeCallbacksAndMessages(null);
        if (this.rBa != null) {
            this.rBa.bAE();
            this.rBa.clear();
        }
        if (com.tencent.mm.o.a.uy() != null) {
            com.tencent.mm.o.a.uy().wH();
        }
        if (this.jwC != null) {
            this.jwC.bz(false);
        }
        this.jwC = null;
        this.fIx = null;
        this.fvn = null;
        this.rBa = null;
        this.rBe = 0;
    }

    private void xO(int i) {
        String str = am.r(ae.getAccSnsPath(), this.fIx.nMq) + com.tencent.mm.plugin.sns.data.i.e(this.fIx);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("image_path", str);
        intent.putExtra("Retr_Msg_Type", 11);
        x.i("MicroMsg.OnlineVideoView", "send video path %s reqCode %d", str, Integer.valueOf(i));
        com.tencent.mm.bl.d.a(this.mContext, ".ui.transmit.SelectConversationUI", intent, i);
        this.fIW = 0;
    }

    private void O(final int i, final boolean z) {
        this.kXJ.post(new Runnable() {
            public final void run() {
                m LR = ae.bwf().LR(OnlineVideoView.this.fvn);
                if (LR != null) {
                    x.i("MicroMsg.OnlineVideoView", "fav download video[%s] farFromScene %d isFromMain %b", OnlineVideoView.this.fvn, Integer.valueOf(i), Boolean.valueOf(z));
                    cg cgVar = new cg();
                    cgVar.frk.frr = i;
                    cgVar.frk.activity = (Activity) OnlineVideoView.this.mContext;
                    com.tencent.mm.plugin.sns.i.a.a(cgVar, LR);
                    com.tencent.mm.sdk.b.a.xmy.m(cgVar);
                    if (cgVar.frl.ret == 0) {
                        g.pWK.a(354, 225, 1, false);
                    } else {
                        g.pWK.a(354, 226, 1, false);
                    }
                    if (z) {
                        com.tencent.mm.sdk.b.b pqVar = new pq();
                        pqVar.fIm.fsC = LR.bza();
                        pqVar.fIm.fAR = com.tencent.mm.plugin.sns.data.i.g(LR);
                        com.tencent.mm.sdk.b.a.xmy.m(pqVar);
                    }
                    OnlineVideoView.this.fIU = 0;
                    if (OnlineVideoView.this.kYP == null) {
                        return;
                    }
                    if (bi.oN(OnlineVideoView.this.kYP.Uy())) {
                        x.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", Integer.valueOf(OnlineVideoView.this.hashCode()));
                        String a = ap.a(OnlineVideoView.this.fvn, OnlineVideoView.this.fIx);
                        if (!bi.oN(a)) {
                            OnlineVideoView.this.aI(a, false);
                        }
                    } else if (!OnlineVideoView.this.kYP.isPlaying()) {
                        OnlineVideoView.this.kYP.start();
                    }
                }
            }
        });
    }

    private void bAu() {
        long Wz = bi.Wz();
        String nK = t.nK(ap.a(this.fvn, this.fIx));
        if (bi.oN(nK)) {
            Toast.makeText(this.mContext, this.mContext.getString(j.eTt), 1).show();
            g.pWK.a(354, 222, 1, false);
        } else {
            Toast.makeText(this.mContext, this.mContext.getString(j.eTu, new Object[]{nK}), 1).show();
            com.tencent.mm.platformtools.d.b(nK, this.mContext);
            g.pWK.a(354, 221, 1, false);
        }
        this.rAX = false;
        x.i("MicroMsg.OnlineVideoView", "%d save downloaded video finish %d %s", Integer.valueOf(hashCode()), Long.valueOf(bi.bB(Wz)), r0);
        this.kXJ.post(new Runnable() {
            public final void run() {
                if (OnlineVideoView.this.kYP == null) {
                    return;
                }
                if (bi.oN(OnlineVideoView.this.kYP.Uy())) {
                    x.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", Integer.valueOf(OnlineVideoView.this.hashCode()));
                    String a = ap.a(OnlineVideoView.this.fvn, OnlineVideoView.this.fIx);
                    if (!bi.oN(a)) {
                        OnlineVideoView.this.aI(a, false);
                    }
                } else if (!OnlineVideoView.this.kYP.isPlaying()) {
                    OnlineVideoView.this.kYP.start();
                }
            }
        });
    }

    private void a(final boolean z, final float f) {
        this.kXJ.post(new Runnable() {
            public final void run() {
                x.i("MicroMsg.OnlineVideoView", "%d switch video model isVideoPlay %b %f", Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(z), Float.valueOf(f));
                View view = (View) OnlineVideoView.this.kYP;
                if (z) {
                    OnlineVideoView.this.mDg.setAlpha(f);
                    OnlineVideoView.this.mDg.setVisibility(0);
                    view.setAlpha(f);
                    view.setVisibility(0);
                    if (((double) f) >= 1.0d) {
                        OnlineVideoView.this.mBj.setVisibility(8);
                        return;
                    }
                    return;
                }
                OnlineVideoView.this.mDg.setVisibility(8);
                view.setVisibility(8);
                OnlineVideoView.this.mBj.setVisibility(0);
            }
        });
    }

    private void bAq() {
        String str;
        if (this.rAV) {
            str = this.rAW;
        } else {
            str = ap.a(this.fvn, this.fIx);
        }
        x.i("MicroMsg.OnlineVideoView", "%d toggleVideo local id %s finish path %s isPreview %b", Integer.valueOf(hashCode()), this.fvn, str, Boolean.valueOf(this.rAV));
        if (bi.oN(str)) {
            a(false, 0.0f);
            t(false, 0);
            amd();
            return;
        }
        x.i("MicroMsg.OnlineVideoView", "%d sns video already download finish, play now", Integer.valueOf(hashCode()));
        a(true, 0.0f);
        aI(str, false);
    }

    private void t(boolean z, int i) {
        if (this.fIx == null) {
            x.w("MicroMsg.OnlineVideoView", "%d start download video but media is null.", Integer.valueOf(hashCode()));
        } else if (this.rBa == null) {
            x.w("MicroMsg.OnlineVideoView", "%d start download video but helper is null.", Integer.valueOf(hashCode()));
        } else if (this.fIx.wEO == 2) {
            x.w("MicroMsg.OnlineVideoView", "%d it start download video, url type is weixin", Integer.valueOf(hashCode()));
            this.rAU = 3;
            ae.bwa().a(this.fIx, 4, null, this.qWV);
        } else {
            boolean z2;
            int i2;
            af afVar;
            are are;
            int i3;
            String str;
            if (!z) {
                com.tencent.mm.modelcontrol.d.Na();
                if (com.tencent.mm.modelcontrol.d.Ng()) {
                    x.i("MicroMsg.OnlineVideoView", "%d it start online download video", Integer.valueOf(hashCode()));
                    this.rAU = 1;
                    z2 = true;
                    if (i == 0) {
                        i = 30;
                    }
                    i2 = i;
                    afVar = this.rBa;
                    are = this.fIx;
                    i3 = this.hBH;
                    str = this.fvn;
                    afVar.fIx = are;
                    afVar.hBH = i3;
                    afVar.fsC = str;
                    afVar.hVj = ap.D(are);
                    afVar.hVi = ap.aL(i3, are.nlE);
                    if (!bi.oN(afVar.hVj) && !bi.oN(afVar.hVi)) {
                        x.i("MicroMsg.OnlineVideoViewHelper", "start online download video %s isPlayMode %b", afVar.hVi, Boolean.valueOf(z2));
                        ae.bwd().a(are, i3, str, z2, true, i2);
                        afVar.hVl = 1;
                        afVar.hvr = bi.Wy();
                        if (z2) {
                            g.pWK.a(354, 201, 1, false);
                            return;
                        } else {
                            g.pWK.a(354, 202, 1, false);
                            return;
                        }
                    }
                }
            }
            x.i("MicroMsg.OnlineVideoView", "%d it start offline download video", Integer.valueOf(hashCode()));
            this.rAU = 2;
            z2 = false;
            if (i == 0) {
                i = 31;
            }
            i2 = i;
            afVar = this.rBa;
            are = this.fIx;
            i3 = this.hBH;
            str = this.fvn;
            afVar.fIx = are;
            afVar.hBH = i3;
            afVar.fsC = str;
            afVar.hVj = ap.D(are);
            afVar.hVi = ap.aL(i3, are.nlE);
            if (!bi.oN(afVar.hVj)) {
            }
        }
    }

    private void amd() {
        this.kXJ.post(new Runnable() {
            public final void run() {
                x.i("MicroMsg.OnlineVideoView", "%d show loading. downloadMode %d", Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(OnlineVideoView.this.rAU));
                if (OnlineVideoView.this.rAU == 1) {
                    if (!(OnlineVideoView.this.mBp == null || OnlineVideoView.this.mBp.getVisibility() == 0)) {
                        OnlineVideoView.this.mBp.setVisibility(0);
                    }
                    if (!(OnlineVideoView.this.mBq == null || OnlineVideoView.this.mBq.getVisibility() == 8)) {
                        OnlineVideoView.this.mBq.setVisibility(8);
                    }
                }
                if (OnlineVideoView.this.rAU == 2) {
                    if (!(OnlineVideoView.this.mBq == null || OnlineVideoView.this.mBq.getVisibility() == 0)) {
                        OnlineVideoView.this.mBq.setVisibility(0);
                    }
                    if (!(OnlineVideoView.this.mBp == null || OnlineVideoView.this.mBp.getVisibility() == 8)) {
                        OnlineVideoView.this.mBp.setVisibility(8);
                    }
                }
                if (OnlineVideoView.this.rAU == 3) {
                    if (!(OnlineVideoView.this.mBq == null || OnlineVideoView.this.mBq.getVisibility() == 0)) {
                        OnlineVideoView.this.mBq.setVisibility(0);
                        OnlineVideoView.this.mBq.czF();
                    }
                    if (OnlineVideoView.this.mBp != null && OnlineVideoView.this.mBp.getVisibility() != 8) {
                        OnlineVideoView.this.mBp.setVisibility(8);
                    }
                }
            }
        });
    }

    private void aVF() {
        this.kXJ.post(new Runnable() {
            public final void run() {
                if (!(OnlineVideoView.this.mBp == null || OnlineVideoView.this.mBp.getVisibility() == 8)) {
                    x.i("MicroMsg.OnlineVideoView", "%d hide loading.", Integer.valueOf(OnlineVideoView.this.hashCode()));
                    OnlineVideoView.this.mBp.setVisibility(8);
                }
                if (OnlineVideoView.this.mBq != null && OnlineVideoView.this.mBq.getVisibility() != 8) {
                    x.i("MicroMsg.OnlineVideoView", "%d hide progress.", Integer.valueOf(OnlineVideoView.this.hashCode()));
                    OnlineVideoView.this.mBq.setVisibility(8);
                }
            }
        });
    }

    protected final void bZ(boolean z) {
        if (!this.rBb) {
            this.kYV.K(500, 500);
        } else if (z) {
            ah.y(new Runnable() {
                public final void run() {
                    if (!(OnlineVideoView.this.kYP == null || OnlineVideoView.this.rBa == null)) {
                        OnlineVideoView.this.rBa.iK(OnlineVideoView.this.kYP.getCurrentPosition() / 1000);
                    }
                    OnlineVideoView.this.rBh.K(500, 500);
                }
            });
        } else {
            this.rBh.K(500, 500);
        }
    }

    protected final void bAv() {
        this.rBh.TN();
        this.kYV.TN();
    }

    public final void onError(int i, int i2) {
        x.e("MicroMsg.OnlineVideoView", "%d on play video error what %d extra %d. isOnlinePlay %b isMMVideoPlayer[%b]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.rBb), Boolean.valueOf(this.mBm));
        if (this.rBb) {
            g.pWK.a(354, 230, 1, false);
        } else {
            g.pWK.a(354, 231, 1, false);
        }
        this.mBn = i2;
        bAy();
        final String Uy = this.kYP.Uy();
        this.rBd = this.kYP.getCurrentPosition() / 1000;
        if (this.rBb) {
            if (i == -2) {
                this.kYP.stop();
            } else if (i == -3) {
                this.rBe = i;
                this.kYP.pause();
            } else {
                bAv();
                this.kYP.stop();
            }
            try {
                amd();
                if (this.rBa != null) {
                    af afVar = this.rBa;
                    String str = afVar.hVi + 0 + "_-1";
                    if (!afVar.rBt.containsKey(str)) {
                        x.i("MicroMsg.OnlineVideoViewHelper", "request all data. [%s]", afVar.hVi);
                        o.Uc();
                        com.tencent.mm.modelcdntran.f.f(afVar.hVi, 0, -1);
                        afVar.rBt.put(str, Integer.valueOf(0));
                        g.pWK.a(354, 207, 1, false);
                        g.pWK.h(13836, Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.ap.CTRL_INDEX), Long.valueOf(bi.Wx()), "");
                    }
                    afVar.hVm = 5;
                    afVar.hVr = true;
                    afVar.hVu = false;
                }
                bAy();
                return;
            } catch (Exception e) {
                return;
            }
        }
        this.kYP.stop();
        this.mBl = true;
        a(false, 0.0f);
        if (!bi.oN(Uy)) {
            x.w("MicroMsg.OnlineVideoView", "%d start third player to play", Integer.valueOf(hashCode()));
            this.kXJ.post(new Runnable() {
                public final void run() {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.fromFile(new File(Uy)), "video/*");
                    try {
                        OnlineVideoView.this.getContext().startActivity(intent);
                    } catch (Exception e) {
                        x.e("MicroMsg.OnlineVideoView", "startActivity fail, activity not found");
                        h.h(OnlineVideoView.this.getContext(), j.egf, j.egg);
                    }
                }
            });
        }
    }

    public final void hY() {
        x.i("MicroMsg.OnlineVideoView", "%d onPrepared playErrorCode[%d] onErrorPlayTimeSec[%d]", Integer.valueOf(hashCode()), Integer.valueOf(this.mBn), Integer.valueOf(this.rBd));
        this.mBn = 0;
        if (this.rBd > 0) {
            sV(this.rBd);
            this.rBd = 0;
            return;
        }
        this.rBe = 0;
        aVF();
        bAx();
        this.kYP.start();
        this.duration = this.kYP.getDuration() / 1000;
        x.i("MicroMsg.OnlineVideoView", "%d start play duration %d sns local id %s ", Integer.valueOf(hashCode()), Integer.valueOf(this.duration), this.fvn);
        bZ(false);
    }

    public final void vi() {
        x.i("MicroMsg.OnlineVideoView", "%d on completion", Integer.valueOf(hashCode()));
        if (this.rAY != null) {
            return;
        }
        if (com.tencent.mm.compatible.util.d.fP(18) || !this.mBm) {
            sV(0);
        } else if (this.kYP != null) {
            String Uy = this.kYP.Uy();
            this.kYP.stop();
            aI(Uy, this.rBb);
        }
    }

    public final int ck(int i, int i2) {
        return 0;
    }

    public final void cl(int i, int i2) {
    }

    public final void aI(String str, boolean z) {
        x.i("MicroMsg.OnlineVideoView", "%d prepare video isOnlinePlay %b filePath %s", Integer.valueOf(hashCode()), Boolean.valueOf(z), str);
        if (bi.oN(str)) {
            x.w("MicroMsg.OnlineVideoView", "%d prepare video but filepath is null.", Integer.valueOf(hashCode()));
            return;
        }
        this.rBb = z;
        if (this.kYP != null) {
            VideoPlayerTextureView videoPlayerTextureView;
            if (this.rBe != -3) {
                if (this.kYP instanceof VideoPlayerTextureView) {
                    boolean z2;
                    videoPlayerTextureView = (VideoPlayerTextureView) this.kYP;
                    if (this.rBb) {
                        com.tencent.mm.kernel.g.Dr();
                        z2 = com.tencent.mm.kernel.g.Dq().Db().getBoolean(com.tencent.mm.storage.w.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, false);
                    } else {
                        z2 = false;
                    }
                    videoPlayerTextureView.gD(z2);
                    ((VideoPlayerTextureView) this.kYP).gE(z);
                }
                this.kYP.a(this.rAQ);
                this.kYP.setVideoPath(str);
                a(true, 0.0f);
            } else {
                x.i("MicroMsg.OnlineVideoView", "%d prepare video reset source", Integer.valueOf(hashCode()));
                if (this.kYP instanceof VideoPlayerTextureView) {
                    videoPlayerTextureView = (VideoPlayerTextureView) this.kYP;
                    x.i("MicroMsg.VideoPlayerTextureView", "%d reset source ", Integer.valueOf(videoPlayerTextureView.hashCode()));
                    if (videoPlayerTextureView.vES != null) {
                        com.tencent.mm.plugin.s.i iVar = videoPlayerTextureView.vES;
                        if (iVar.ovB != null) {
                            iVar.ovB.bar();
                        }
                    }
                }
                sV(this.rBd);
            }
        }
        com.tencent.mm.kernel.g.Dr();
        if (((Integer) com.tencent.mm.kernel.g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, Integer.valueOf(0))).intValue() == 1) {
            this.mBk.setText(com.tencent.mm.plugin.sight.base.d.FL(str));
            this.mBk.setVisibility(0);
        }
    }

    public final boolean bAw() {
        x.i("MicroMsg.OnlineVideoView", "%d resumeByDataGain", Integer.valueOf(hashCode()));
        if (this.kYP.isPlaying()) {
            return true;
        }
        bAx();
        boolean start = this.kYP.start();
        aVF();
        return start;
    }

    public final void TM() {
        x.i("MicroMsg.OnlineVideoView", "%d pauseByDataBlock", Integer.valueOf(hashCode()));
        bAy();
        amd();
        if (this.kYP.isPlaying()) {
            x.i("MicroMsg.OnlineVideoView", "%d pause play", Integer.valueOf(hashCode()));
            bAy();
            this.kYP.pause();
        }
    }

    public final void sV(int i) {
        x.i("MicroMsg.OnlineVideoView", "%d seek second %d afterSeekPlay %b", Integer.valueOf(hashCode()), Integer.valueOf(i), Boolean.valueOf(true));
        this.rBe = 0;
        aVF();
        this.kYP.c((double) (i * 1000), true);
        bZ(false);
    }

    private void bAx() {
        this.rBl = bi.Wy();
        x.d("MicroMsg.OnlineVideoView", "%d notePlayVideo notePlayVideo %d ", Integer.valueOf(hashCode()), Long.valueOf(this.rBl));
    }

    private void bAy() {
        if (this.rBl > 0) {
            this.rBm = (int) (((long) this.rBm) + ((bi.Wy() - this.rBl) / 1000));
        }
        x.i("MicroMsg.OnlineVideoView", "%d notePauseVideo playVideoDuration %d ", Integer.valueOf(hashCode()), Integer.valueOf(this.rBm));
        this.rBl = 0;
    }

    public final int bAz() {
        if (this.rBm < 0) {
            this.rBm = 0;
        }
        x.i("MicroMsg.OnlineVideoView", "%d get play video duration [%d]", Integer.valueOf(hashCode()), Integer.valueOf(this.rBm));
        return this.rBm;
    }

    public final int bAA() {
        return this.mBn;
    }

    public final int bAB() {
        int i;
        if (this.rBg <= 0 || this.rBf <= 0) {
            i = 0;
        } else {
            i = (int) (this.rBg - this.rBf);
        }
        if (i < 0) {
            return 0;
        }
        return i;
    }
}
