package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.ActionBarContainer;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.af.a.h;
import com.tencent.mm.f.a.bk;
import com.tencent.mm.f.a.dv;
import com.tencent.mm.f.a.eq;
import com.tencent.mm.f.a.fg;
import com.tencent.mm.f.a.iy;
import com.tencent.mm.f.a.jx;
import com.tencent.mm.f.a.kc;
import com.tencent.mm.f.a.kt;
import com.tencent.mm.f.a.ld;
import com.tencent.mm.f.a.ln;
import com.tencent.mm.f.a.mp;
import com.tencent.mm.f.a.nq;
import com.tencent.mm.f.a.oi;
import com.tencent.mm.f.a.rv;
import com.tencent.mm.f.a.sq;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsimple.aj;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bdd;
import com.tencent.mm.protocal.c.beq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.AllRemindMsgUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.b.aa;
import com.tencent.mm.ui.chatting.b.ab;
import com.tencent.mm.ui.chatting.b.ac;
import com.tencent.mm.ui.chatting.b.ad;
import com.tencent.mm.ui.chatting.b.ae;
import com.tencent.mm.ui.chatting.b.d;
import com.tencent.mm.ui.chatting.b.f;
import com.tencent.mm.ui.chatting.b.h.AnonymousClass10;
import com.tencent.mm.ui.chatting.b.h.AnonymousClass3;
import com.tencent.mm.ui.chatting.b.h.AnonymousClass4;
import com.tencent.mm.ui.chatting.b.h.AnonymousClass5;
import com.tencent.mm.ui.chatting.b.h.AnonymousClass6;
import com.tencent.mm.ui.chatting.b.h.AnonymousClass7;
import com.tencent.mm.ui.chatting.b.h.AnonymousClass8;
import com.tencent.mm.ui.chatting.b.h.AnonymousClass9;
import com.tencent.mm.ui.chatting.b.i;
import com.tencent.mm.ui.chatting.b.j;
import com.tencent.mm.ui.chatting.b.k;
import com.tencent.mm.ui.chatting.b.l;
import com.tencent.mm.ui.chatting.b.m;
import com.tencent.mm.ui.chatting.b.n;
import com.tencent.mm.ui.chatting.b.o;
import com.tencent.mm.ui.chatting.b.p;
import com.tencent.mm.ui.chatting.b.q;
import com.tencent.mm.ui.chatting.b.s;
import com.tencent.mm.ui.chatting.b.v;
import com.tencent.mm.ui.chatting.b.w;
import com.tencent.mm.ui.chatting.b.y;
import com.tencent.mm.ui.chatting.b.z;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.bd;
import com.tencent.mm.y.be;
import com.tencent.recovery.wx.util.NetUtil;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

@SuppressLint({"DefaultLocale", "ValidFragment"})
@TargetApi(11)
public class ChattingUI extends MMFragmentActivity {
    public u yEn;
    public ag yyu = new ag();

    public static class a extends u implements e, com.tencent.mm.plugin.messenger.foundation.a.a.c.a, com.tencent.mm.sdk.e.j.a, com.tencent.mm.sdk.e.m.b, p {
        public static String yEQ;
        public static boolean yFf = false;
        private String fAd = null;
        public x fBc;
        private final c gBo = new ag(com.tencent.mm.ui.chatting.ag.a.yGf, null);
        public boolean hJu = false;
        @SuppressLint({"HandlerLeak"})
        private ag handler = new ag();
        private long mBackOnKeyDownTS = 0;
        public ClipboardManager mCW;
        private boolean mHasBackOnKeyDown = false;
        public boolean ocy = true;
        MMPullDownView otm;
        public r tipDialog = null;
        boolean vwT = false;
        private boolean xTP = false;
        private long[] yAI = null;
        public q yAM;
        private String yAP;
        public boolean yAR = false;
        public ad yEA;
        public v yEB;
        public com.tencent.mm.ui.chatting.b.b yEC;
        public m yED;
        public d yEE;
        public com.tencent.mm.ui.chatting.b.r yEF;
        public com.tencent.mm.ui.chatting.b.u yEG;
        public j yEH;
        public com.tencent.mm.ui.chatting.b.a yEI;
        public y yEJ;
        public com.tencent.mm.ui.chatting.b.e yEK;
        public com.tencent.mm.ui.chatting.b.c yEL;
        public n yEM;
        private z yEN;
        public k yEO;
        public f yEP;
        private int yER = -1;
        private View yES;
        private TextView yET;
        public boolean yEU = false;
        private boolean yEV = false;
        private bc yEW;
        ListView yEX;
        private boolean yEY = true;
        private boolean yEZ = false;
        public ac yEq;
        public ab yEr;
        public s yEs;
        public i yEt;
        public aa yEu;
        public o yEv;
        public w yEw;
        public com.tencent.mm.ui.chatting.b.x yEx;
        public l yEy;
        public q yEz;
        private final List<b> yFa = new LinkedList();
        private int yFb = 0;
        private com.tencent.mm.ui.base.i yFc = null;
        public boolean yFd = false;
        protected boolean yFe = false;
        protected boolean yFg = true;
        private long yFh = -1;
        private boolean yFi = false;
        private long yFj = 0;
        boolean yFk = false;
        public ChattingFooterMoreBtnBar yFl;
        public s yFm;
        private n yFn = null;
        public int yFo = -1;
        private com.tencent.mm.ui.bindqq.b yFp;
        private final al yFq = new al(new com.tencent.mm.sdk.platformtools.al.a() {
            public final boolean uG() {
                a.this.yAM.csz();
                return true;
            }
        }, true);
        private View yFr;
        private boolean yFs = false;
        private Runnable yFt = new Runnable() {
            public final void run() {
                if (a.this.yFs || a.this.yi != 0) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUI", "error state user has touch listview, not need to scroll to last. userTouched: %s state: %s", Boolean.valueOf(a.this.yFs), Integer.valueOf(a.this.yi));
                    return;
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "first time in, scroll to last");
                a.this.mU(true);
            }
        };
        private boolean yFu = false;
        private boolean yFv = false;
        private int yFw = 0;
        private final int yFx = 10;
        public boolean yFy = false;
        private int yi = 0;
        public boolean yxU = false;
        public ae yyW;
        private com.tencent.mm.ui.base.q yyX;

        /* renamed from: com.tencent.mm.ui.chatting.ChattingUI$a$15 */
        class AnonymousClass15 implements OnClickListener {
            final /* synthetic */ au hgB;

            public AnonymousClass15(au auVar) {
                this.hgB = auVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                a.this.az(this.hgB);
            }
        }

        /* renamed from: com.tencent.mm.ui.chatting.ChattingUI$a$24 */
        class AnonymousClass24 implements OnCancelListener {
            final /* synthetic */ au hgJ;
            final /* synthetic */ com.tencent.mm.modelsimple.z yFF;

            public AnonymousClass24(au auVar, com.tencent.mm.modelsimple.z zVar) {
                this.hgJ = auVar;
                this.yFF = zVar;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "cancel revoke msg:%d", Long.valueOf(this.hgJ.field_msgId));
                as.CN().c(this.yFF);
            }
        }

        interface a {
        }

        static /* synthetic */ boolean o(a aVar) {
            if (!com.tencent.mm.y.s.hq(aVar.csn()) && com.tencent.mm.y.s.eX(aVar.csn())) {
                as.Hm();
                ak XF = com.tencent.mm.y.c.Fk().XF(aVar.csn());
                if (XF == null || (XF.field_showTips & 1) > 0) {
                    return false;
                }
                as.Hm();
                if (com.tencent.mm.y.c.Ff().Xv(aVar.csn()).fXi == 1 && aVar.yFb >= 40) {
                    return true;
                }
            }
            return false;
        }

        public final boolean csR() {
            return this.yxU;
        }

        public final boolean csS() {
            return this.yAR;
        }

        public final boolean csT() {
            return this.yEL.vus;
        }

        public final boolean csU() {
            return this.yEL.yHs;
        }

        public final boolean csV() {
            return this.yFd;
        }

        public final x csW() {
            return this.fBc;
        }

        public final void V(x xVar) {
            this.fBc = xVar;
        }

        public final String vZ() {
            return this.fAd;
        }

        public final String csn() {
            if (this.fBc == null) {
                return null;
            }
            if (x.gB(this.fBc.field_username)) {
                return this.yAP;
            }
            return this.fBc.field_username;
        }

        public final boolean csX() {
            return this.yEV;
        }

        public final void mO(boolean z) {
            this.yEV = z;
        }

        public final void ZK(String str) {
            this.yAP = str;
        }

        public final String csY() {
            return this.yAP;
        }

        public final boolean csZ() {
            return this.vwT;
        }

        public final void mP(boolean z) {
            this.vwT = z;
        }

        public final boolean cta() {
            return this.yFm != null && this.yFm.yBT;
        }

        public final com.tencent.mm.af.d ctb() {
            return this.yEL.kKo;
        }

        public final com.tencent.mm.af.a.c ctc() {
            return this.yEL.yvJ;
        }

        public final com.tencent.mm.af.a.j ctd() {
            return this.yEL.poq;
        }

        public final u cte() {
            return this;
        }

        public final boolean ctf() {
            return this.yFk;
        }

        public final ag ctg() {
            return this.handler;
        }

        public final void cpZ() {
            if (this.yAM != null) {
                this.yAM.notifyDataSetChanged();
            }
        }

        public final long cth() {
            return this.yFj;
        }

        public final boolean cti() {
            return this.xTP;
        }

        public final void mQ(boolean z) {
            this.xTP = z;
        }

        public final String ctj() {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "getSender " + (this.yEW == null) + " " + (this.yEW == null ? com.tencent.mm.y.q.FY() : this.yEW.name));
            return this.yEW == null ? com.tencent.mm.y.q.FY() : this.yEW.name;
        }

        public final bc ctk() {
            return this.yEW;
        }

        public final ListView ctl() {
            return this.yEX;
        }

        public final q ctm() {
            return this.yAM;
        }

        public final MMPullDownView ctn() {
            return this.otm;
        }

        public final s cto() {
            return this.yFm;
        }

        public final ChatFooter ctp() {
            return this.yEM.ctp();
        }

        public final ChatFooterCustom ctq() {
            return this.yEM.ctq();
        }

        public final void dismissDialog() {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
        }

        public final void b(r rVar) {
            this.tipDialog = rVar;
        }

        public final void crW() {
            if (this.yyX != null) {
                this.yyX.dismiss();
            }
        }

        public final boolean ctr() {
            return this.yEG.yAH;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void crM() {
            /*
            r10 = this;
            r8 = 2;
            r1 = 1;
            r2 = 0;
            r3 = r10.yEP;
            r0 = r3.fhH;
            r0 = r0.cte();
            r4 = 0;
            r0.setMMSubTitle(r4);
            r0 = r3.fhH;
            r0 = r0.csn();
            r0 = com.tencent.mm.y.s.gE(r0);
            if (r0 == 0) goto L_0x002f;
        L_0x001b:
            r0 = r3.fhH;
            r0 = r0.cte();
            r1 = r3.fhH;
            r1 = r1.csW();
            r1 = r1.AW();
            r0.setMMTitle(r1);
        L_0x002e:
            return;
        L_0x002f:
            r0 = r3.yEG;
            r0 = r0.yJp;
            if (r0 == 0) goto L_0x0041;
        L_0x0035:
            r0 = r3.fhH;
            r0 = r0.cte();
            r1 = com.tencent.mm.R.l.eII;
            r0.setMMTitle(r1);
            goto L_0x002e;
        L_0x0041:
            r0 = r3.fhH;
            r0 = r0.csn();
            r0 = com.tencent.mm.storage.x.Xd(r0);
            if (r0 == 0) goto L_0x0083;
        L_0x004d:
            r0 = r3.fhH;
            r4 = r0.ctp();
            r0 = r4.mcj;
            r5 = com.tencent.mm.R.h.bVG;
            r0 = r0.findViewById(r5);
            r0 = (android.widget.TextView) r0;
            r4.vwE = r0;
            r0 = r4.oqa;
            r1 = new android.text.InputFilter[r1];
            r4 = new android.text.InputFilter$LengthFilter;
            r5 = 140; // 0x8c float:1.96E-43 double:6.9E-322;
            r4.<init>(r5);
            r1[r2] = r4;
            r0.setFilters(r1);
            r0 = r3.fhH;
            r0 = r0.cte();
            r1 = r3.fhH;
            r1 = r1.csW();
            r1 = r1.AX();
            r0.setMMTitle(r1);
            goto L_0x002e;
        L_0x0083:
            r0 = r3.fhH;
            r0 = r0.csn();
            r0 = com.tencent.mm.y.s.hn(r0);
            if (r0 == 0) goto L_0x00a3;
        L_0x008f:
            r0 = r3.fhH;
            r0 = r0.cte();
            r1 = r3.fhH;
            r1 = r1.csW();
            r1 = r1.AW();
            r0.setMMTitle(r1);
            goto L_0x002e;
        L_0x00a3:
            r0 = r3.fhH;
            r0 = r0.csn();
            r0 = com.tencent.mm.storage.x.gB(r0);
            if (r0 == 0) goto L_0x011f;
        L_0x00af:
            r0 = r3.fhH;
            r4 = r0.cte();
            r0 = r3.fhH;
            r5 = r0.cte();
            r6 = com.tencent.mm.R.l.dMR;
            r1 = new java.lang.Object[r1];
            r0 = r3.fhH;
            r7 = r0.csW();
            if (r7 == 0) goto L_0x0112;
        L_0x00c7:
            r0 = r7.getCountryCode();
            r0 = com.tencent.mm.storage.RegionCodeDecoder.Yl(r0);
            if (r0 == 0) goto L_0x0104;
        L_0x00d1:
            r0 = r7.getCity();
            r3 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
            if (r3 != 0) goto L_0x00ea;
        L_0x00db:
            r1[r2] = r0;
            r0 = r5.getMMString(r6, r1);
            r0 = r0.trim();
            r4.setMMTitle(r0);
            goto L_0x002e;
        L_0x00ea:
            r0 = r7.getProvince();
            r0 = com.tencent.mm.y.r.gy(r0);
            r3 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
            if (r3 == 0) goto L_0x00db;
        L_0x00f8:
            com.tencent.mm.storage.RegionCodeDecoder.ckE();
            r0 = r7.getCountryCode();
            r0 = com.tencent.mm.storage.RegionCodeDecoder.getLocName(r0);
            goto L_0x00db;
        L_0x0104:
            r0 = r7.getProvince();
            r0 = com.tencent.mm.y.r.gy(r0);
            r7 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
            if (r7 == 0) goto L_0x00db;
        L_0x0112:
            r0 = r3.fhH;
            r0 = r0.cte();
            r3 = com.tencent.mm.R.l.dNk;
            r0 = r0.getMMString(r3);
            goto L_0x00db;
        L_0x011f:
            r0 = r3.fhH;
            r0 = r0.csS();
            if (r0 == 0) goto L_0x01c4;
        L_0x0127:
            r0 = r3.fhH;
            r0 = r0.csW();
            r0 = r0.field_nickname;
            r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
            if (r0 == 0) goto L_0x018f;
        L_0x0135:
            r0 = r3.fhH;
            r0 = r0.csn();
            r0 = com.tencent.mm.y.m.gn(r0);
            if (r0 != 0) goto L_0x0158;
        L_0x0141:
            r0 = r3.fhH;
            r0 = r0.cte();
            r1 = r3.fhH;
            r1 = r1.cte();
            r2 = com.tencent.mm.R.l.dSY;
            r1 = r1.getMMString(r2);
            r0.setMMTitle(r1);
            goto L_0x002e;
        L_0x0158:
            r0 = r3.fhH;
            r0 = r0.cte();
            r4 = r3.fhH;
            r4 = r4.cte();
            r5 = com.tencent.mm.R.l.eiH;
            r6 = new java.lang.Object[r8];
            r7 = r3.fhH;
            r7 = r7.cte();
            r8 = com.tencent.mm.R.l.dSY;
            r7 = r7.getMMString(r8);
            r6[r2] = r7;
            r2 = r3.fhH;
            r2 = r2.csn();
            r2 = com.tencent.mm.y.m.gn(r2);
            r2 = java.lang.Integer.valueOf(r2);
            r6[r1] = r2;
            r1 = r4.getMMString(r5, r6);
            r0.setMMTitle(r1);
            goto L_0x002e;
        L_0x018f:
            r0 = r3.fhH;
            r0 = r0.cte();
            r4 = r3.fhH;
            r4 = r4.cte();
            r5 = com.tencent.mm.R.l.eiH;
            r6 = new java.lang.Object[r8];
            r7 = r3.fhH;
            r7 = r7.csW();
            r7 = r7.AW();
            r6[r2] = r7;
            r2 = r3.fhH;
            r2 = r2.csn();
            r2 = com.tencent.mm.y.m.gn(r2);
            r2 = java.lang.Integer.valueOf(r2);
            r6[r1] = r2;
            r1 = r4.getMMString(r5, r6);
            r0.setMMTitle(r1);
            goto L_0x002e;
        L_0x01c4:
            r0 = r3.yEL;
            r4 = r0.vus;
            if (r4 == 0) goto L_0x02b0;
        L_0x01ca:
            r4 = r0.yHs;
            if (r4 == 0) goto L_0x02a1;
        L_0x01ce:
            r4 = r0.ctW();
            r4 = com.tencent.mm.af.a.e.aZ(r4);
            r5 = r0.yvJ;
            r5 = r5.field_chatName;
            r5 = com.tencent.mm.sdk.platformtools.bi.oN(r5);
            if (r5 == 0) goto L_0x027c;
        L_0x01e0:
            if (r4 != 0) goto L_0x024f;
        L_0x01e2:
            r2 = r0.fhH;
            r2 = r2.cte();
            r0 = r0.fhH;
            r0 = r0.cte();
            r4 = com.tencent.mm.R.l.dSY;
            r0 = r0.getMMString(r4);
            r2.setMMTitle(r0);
        L_0x01f7:
            r0 = r1;
        L_0x01f8:
            if (r0 != 0) goto L_0x002e;
        L_0x01fa:
            r0 = r3.fhH;
            r0 = r0.cte();
            r1 = r3.fhH;
            r1 = r1.csW();
            r1 = r1.AX();
            r0.setMMTitle(r1);
            r0 = r3.yHX;
            r1 = r3.fhH;
            r1 = r1.csn();
            r1 = com.tencent.mm.storage.x.Xf(r1);
            r0.lS(r1);
            r0 = r3.fhH;
            r0 = r0.csn();
            r0 = com.tencent.mm.storage.x.Xg(r0);
            if (r0 == 0) goto L_0x002e;
        L_0x0228:
            r0 = r3.fhH;
            r1 = r0.cte();
            r0 = com.tencent.mm.openim.a.b.class;
            r0 = com.tencent.mm.kernel.g.h(r0);
            r0 = (com.tencent.mm.openim.a.b) r0;
            r2 = r3.fhH;
            r2 = r2.csW();
            r2 = r2.field_openImAppid;
            r3 = r3.fhH;
            r3 = r3.csW();
            r3 = r3.field_descWordingId;
            r0 = r0.aB(r2, r3);
            r1.setMMSubTitle(r0);
            goto L_0x002e;
        L_0x024f:
            r5 = r0.fhH;
            r5 = r5.cte();
            r6 = r0.fhH;
            r6 = r6.cte();
            r7 = com.tencent.mm.R.l.eiH;
            r8 = new java.lang.Object[r8];
            r0 = r0.fhH;
            r0 = r0.cte();
            r9 = com.tencent.mm.R.l.dSY;
            r0 = r0.getMMString(r9);
            r8[r2] = r0;
            r0 = java.lang.Integer.valueOf(r4);
            r8[r1] = r0;
            r0 = r6.getMMString(r7, r8);
            r5.setMMTitle(r0);
            goto L_0x01f7;
        L_0x027c:
            r5 = r0.fhH;
            r5 = r5.cte();
            r6 = r0.fhH;
            r6 = r6.cte();
            r7 = com.tencent.mm.R.l.eiH;
            r8 = new java.lang.Object[r8];
            r0 = r0.yvJ;
            r0 = r0.field_chatName;
            r8[r2] = r0;
            r0 = java.lang.Integer.valueOf(r4);
            r8[r1] = r0;
            r0 = r6.getMMString(r7, r8);
            r5.setMMTitle(r0);
            goto L_0x01f7;
        L_0x02a1:
            r2 = r0.fhH;
            r2 = r2.cte();
            r0 = r0.poq;
            r0 = r0.field_userName;
            r2.setMMTitle(r0);
            goto L_0x01f7;
        L_0x02b0:
            r0 = r2;
            goto L_0x01f8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ChattingUI.a.crM():void");
        }

        public static a cts() {
            return new a();
        }

        public a() {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "ChattingUIFragmet: %d ", Integer.valueOf(hashCode()));
            Bundle bundle = new Bundle();
            bundle.putInt(getClass().getName(), Integer.MAX_VALUE);
            setArguments(bundle);
            ctt();
        }

        @SuppressLint({"ValidFragment"})
        public a(boolean z) {
            super(true);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "ChattingUIFragmet(%b): %d ", Boolean.valueOf(true), Integer.valueOf(hashCode()));
            Bundle bundle = new Bundle();
            bundle.putInt(getClass().getName(), Integer.MAX_VALUE);
            setArguments(bundle);
            ctt();
        }

        private void ctt() {
            if (this.yEq == null) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "initConponentImp");
                this.yEq = new ac(this);
                this.yEr = new ab(this);
                this.yEs = new s(this);
                this.yEt = new i(this);
                this.yEu = new aa(this);
                this.yEv = new o(this);
                this.yEw = new w(this);
                this.yEx = new com.tencent.mm.ui.chatting.b.x(this);
                this.yEy = new l(this);
                this.yEz = new q(this);
                this.yEA = new ad(this);
                this.yEB = new v(this);
                this.yEC = new com.tencent.mm.ui.chatting.b.b(this);
                this.yyW = new ae(this);
                this.yED = new m(this);
                this.yEE = new d(this);
                this.yEF = new com.tencent.mm.ui.chatting.b.r(this);
                this.yEG = new com.tencent.mm.ui.chatting.b.u(this);
                this.yEH = new j(this);
                this.yEI = new com.tencent.mm.ui.chatting.b.a(this);
                this.yEN = new z(this);
                this.yEL = new com.tencent.mm.ui.chatting.b.c(this);
                this.yEM = new n(this);
                this.yEJ = new y(this);
                this.yEK = new com.tencent.mm.ui.chatting.b.e(this);
                this.yEO = new k(this);
                this.yEP = new f(this);
                this.yEB.yEy = this.yEy;
                this.yEB.yEA = this.yEA;
                this.yEz.yJd = this.yEP;
                this.yEF.yEu = this.yEu;
                n nVar = this.yEM;
                com.tencent.mm.ui.chatting.b.u uVar = this.yEG;
                q qVar = this.yEz;
                com.tencent.mm.ui.chatting.b.c cVar = this.yEL;
                v vVar = this.yEB;
                i iVar = this.yEt;
                j jVar = this.yEH;
                nVar.yEG = uVar;
                nVar.yEz = qVar;
                nVar.yEL = cVar;
                nVar.yEB = vVar;
                nVar.yEt = iVar;
                nVar.yEH = jVar;
                this.yEL.yEM = this.yEM;
                j jVar2 = this.yEH;
                n nVar2 = this.yEM;
                com.tencent.mm.ui.chatting.b.c cVar2 = this.yEL;
                jVar2.yEM = nVar2;
                jVar2.yEL = cVar2;
                y yVar = this.yEJ;
                com.tencent.mm.ui.chatting.b.c cVar3 = this.yEL;
                qVar = this.yEz;
                com.tencent.mm.ui.chatting.b.a aVar = this.yEI;
                com.tencent.mm.ui.chatting.b.e eVar = this.yEK;
                yVar.yEL = cVar3;
                yVar.yEz = qVar;
                yVar.yEI = aVar;
                yVar.yEK = eVar;
                com.tencent.mm.ui.chatting.b.e eVar2 = this.yEK;
                cVar3 = this.yEL;
                aa aaVar = this.yEu;
                eVar2.yEL = cVar3;
                eVar2.yEu = aaVar;
                k kVar = this.yEO;
                uVar = this.yEG;
                v vVar2 = this.yEB;
                ad adVar = this.yEA;
                com.tencent.mm.ui.chatting.b.a aVar2 = this.yEI;
                y yVar2 = this.yEJ;
                kVar.yEG = uVar;
                kVar.yEB = vVar2;
                kVar.yEA = adVar;
                kVar.yEI = aVar2;
                kVar.yEJ = yVar2;
                f fVar = this.yEP;
                cVar3 = this.yEL;
                com.tencent.mm.ui.chatting.b.u uVar2 = this.yEG;
                q qVar2 = this.yEz;
                com.tencent.mm.ui.chatting.b.b bVar = this.yEC;
                j jVar3 = this.yEH;
                fVar.yEL = cVar3;
                fVar.yEG = uVar2;
                fVar.yEz = qVar2;
                fVar.yEC = bVar;
                fVar.yEH = jVar3;
            }
        }

        public void setArguments(Bundle bundle) {
            super.setArguments(bundle);
            if (bundle != null && !bundle.containsKey(getClass().getName())) {
                bundle.putInt(getClass().getName(), Integer.MAX_VALUE);
            }
        }

        @SuppressLint({"DefaultLocale"})
        public final String gw(String str) {
            return this.yEK.gw(str);
        }

        @TargetApi(9)
        public final void mR(boolean z) {
            if (!getLandscapeMode()) {
                return;
            }
            if (!z) {
                setRequestedOrientation(-1);
            } else if (VERSION.SDK_INT >= 9) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "rotation %d", Integer.valueOf(getWindowManager().getDefaultDisplay().getOrientation()));
                switch (getWindowManager().getDefaultDisplay().getOrientation()) {
                    case 0:
                        setRequestedOrientation(1);
                        return;
                    case 1:
                        setRequestedOrientation(0);
                        return;
                    case 2:
                        setRequestedOrientation(9);
                        return;
                    case 3:
                        setRequestedOrientation(8);
                        return;
                    default:
                        return;
                }
            } else if (getMMResources().getConfiguration().orientation == 2) {
                setRequestedOrientation(0);
            } else if (getMMResources().getConfiguration().orientation == 1) {
                setRequestedOrientation(1);
            }
        }

        public boolean getUserVisibleHint() {
            return !ctD();
        }

        protected int getLayoutId() {
            return R.i.dcZ;
        }

        protected View getLayoutView() {
            boolean z = true;
            String str = "MicroMsg.ChattingUI";
            String str2 = "call getLayoutView, result is NULL ? %B";
            Object[] objArr = new Object[1];
            if (this.yFr != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            com.tencent.mm.sdk.platformtools.x.d(str, str2, objArr);
            return this.yFr;
        }

        protected void dealContentView(View view) {
            super.dealContentView(view);
            f fVar = this.yEP;
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.ChattingHeadereMgr", "dealContentView");
            if (fVar.cue()) {
                if (fVar.yHV == null) {
                    fVar.yHV = (ActionBarContainer) ((ViewStub) view.findViewById(R.h.bTP)).inflate();
                }
                fVar.yHW.xSD.Fl = (ViewGroup) view;
            }
        }

        public final void d(View view, View view2) {
            boolean z;
            boolean z2 = true;
            String str = "MicroMsg.ChattingUI";
            String str2 = "call prepareLayoutView, mLayoutViewCache cache is NULL ? %B";
            Object[] objArr = new Object[1];
            if (this.yFr == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            com.tencent.mm.sdk.platformtools.x.d(str, str2, objArr);
            this.yFr = view;
            f fVar = this.yEP;
            str = "MicroMsg.ChattingUI.ChattingHeadereMgr";
            str2 = "call prepareLayoutView, mAbContentViewCache cache is NULL ? %B";
            objArr = new Object[1];
            if (view2 != null) {
                z2 = false;
            }
            objArr[0] = Boolean.valueOf(z2);
            com.tencent.mm.sdk.platformtools.x.d(str, str2, objArr);
            fVar.yHY = view2;
        }

        public void setMMTitle(int i) {
            setMMTitle(getMMString(i));
        }

        public void setMMTitle(String str) {
            CharSequence b;
            f fVar = this.yEP;
            fVar.fhH.cte().thisResources().getDimensionPixelSize(R.f.but);
            if (x.Xg(fVar.fhH.csW().field_username)) {
                com.tencent.mm.openim.a.b bVar = (com.tencent.mm.openim.a.b) g.h(com.tencent.mm.openim.a.b.class);
                Context context = com.tencent.mm.sdk.platformtools.ad.getContext();
                String str2 = fVar.fhH.csW().field_openImAppid;
                b = bVar.b(context, str, com.tencent.mm.bu.a.aa(com.tencent.mm.sdk.platformtools.ad.getContext(), R.f.but));
            } else {
                b = com.tencent.mm.pluginsdk.ui.d.i.c(fVar.fhH.cte().getContext(), str, com.tencent.mm.bu.a.aa(fVar.fhH.cte().getContext(), R.f.but));
            }
            fVar.yHX.setTitle(b);
            fVar.fhH.cte().updateDescription(fVar.fhH.cte().getMMString(R.l.dQM, b));
        }

        public void setMMSubTitle(String str) {
            f fVar = this.yEP;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.ChattingHeadereMgr", "now connect state, text : %s", str);
            CharSequence c = com.tencent.mm.pluginsdk.ui.d.i.c(fVar.fhH.cte().getContext(), str, com.tencent.mm.bu.a.aa(fVar.fhH.cte().getContext(), R.f.bvt));
            com.tencent.mm.ui.b bVar = fVar.yHX;
            if (c == null || bi.oN(c.toString())) {
                bVar.xLZ.setVisibility(8);
                return;
            }
            bVar.xLZ.setVisibility(0);
            bVar.xLZ.setText(c);
            if (com.tencent.mm.bu.a.ez(bVar.xLZ.getContext())) {
                bVar.xLZ.setTextSize(1, 14.0f);
                bVar.ikL.setTextSize(1, 18.0f);
            }
        }

        public void setMMSubTitle(int i) {
            setMMSubTitle(getMMString(i));
        }

        public void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
            this.yEP.setBackBtn(onMenuItemClickListener);
        }

        public void setTitlePhoneIconVisibility(int i) {
            int i2;
            int i3 = 0;
            com.tencent.mm.ui.b bVar = this.yEP.yHX;
            if (i == 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            ImageView imageView = bVar.xMb;
            if (i2 == 0) {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }

        public void setTitleMuteIconVisibility(int i) {
            com.tencent.mm.ui.b bVar;
            com.tencent.mm.ui.b bVar2;
            int i2;
            ImageView imageView;
            int i3 = 0;
            f fVar = this.yEP;
            if (com.tencent.mm.y.s.hl(fVar.fhH.csn())) {
                bVar = fVar.yHX;
            } else {
                bVar = fVar.yHX;
                if (i == 0) {
                    bVar2 = bVar;
                    i2 = 1;
                    imageView = bVar2.xMa;
                    if (i2 == 0) {
                        i3 = 8;
                    }
                    imageView.setVisibility(i3);
                }
            }
            bVar2 = bVar;
            i2 = 0;
            imageView = bVar2.xMa;
            if (i2 == 0) {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }

        public final void FS(int i) {
            int i2;
            int i3 = 0;
            com.tencent.mm.ui.b bVar = this.yEP.yHX;
            if (i == 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            ImageView imageView = bVar.xMd;
            if (i2 == 0) {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }

        public final void ctu() {
            q qVar;
            int i = 100;
            this.yEZ = true;
            this.yEU = true;
            w wVar = this.yEw;
            wVar.yJQ = false;
            wVar.yJR = false;
            yEQ = this.fBc.field_username;
            as.Hm();
            ak XF = com.tencent.mm.y.c.Fk().XF(this.fBc.field_username);
            if (XF != null) {
                this.yFb = XF.field_unReadCount;
                List list = null;
                if (this.yEL.vus) {
                    com.tencent.mm.ui.chatting.b.c cVar = this.yEL;
                    com.tencent.mm.af.a.a aT = com.tencent.mm.af.y.Mo().aT(cVar.ctW());
                    if (aT.field_unReadCount <= 100) {
                        i = aT.field_unReadCount;
                    }
                    as.Hm();
                    list = com.tencent.mm.y.c.Fi().h(cVar.fhH.csW().field_username, cVar.ctW(), i);
                } else if (XF != null && XF.field_unReadCount > 0) {
                    if (XF.field_unReadCount <= 100) {
                        i = XF.field_unReadCount;
                    }
                    as.Hm();
                    list = com.tencent.mm.y.c.Fh().bz(this.fBc.field_username, i);
                }
                if (list != null) {
                    if (list.size() > 0) {
                        this.yFj = ((au) list.get(0)).field_createTime;
                    }
                    x xVar = this.yEJ.yKA;
                    if (!(xVar.yFH == null || xVar.fhH == null)) {
                        z zVar = xVar.yFH;
                        Activity thisActivity = xVar.fhH.cte().thisActivity();
                        zVar.kPq = list;
                        zVar.yFM = thisActivity;
                        if (zVar.mHandler != null) {
                            zVar.mHandler.sendEmptyMessageDelayed(0, 800);
                        }
                    }
                }
                if (this.yFj == 0) {
                    cg ao;
                    if (this.yEL.vus) {
                        as.Hm();
                        ao = com.tencent.mm.y.c.Fi().ao(this.fBc.field_username, this.yEL.ctW());
                    } else {
                        as.Hm();
                        ao = com.tencent.mm.y.c.Fh().Fc(this.fBc.field_username);
                    }
                    if (!(ao == null || bi.oN(ao.field_talker))) {
                        this.yFj = ao.field_createTime;
                    }
                }
            }
            removeAllOptionMenu();
            crN();
            if (this.yxU) {
                com.tencent.mm.bd.d.chatType = 1;
            } else {
                com.tencent.mm.bd.d.chatType = 0;
            }
            crM();
            this.yEO.cus();
            this.yEC.bTe();
            if (this.yFi && this.yFn == null) {
                this.yFn = new n(this, this.yAM, this.yEM.ctp(), this.yEM.ctq(), this.fBc, this.yxU, this.yAI);
                n nVar = this.yFn;
                nVar.yAD.yEG.cuJ();
                qVar = nVar.yAE;
                qVar.yBU = true;
                qVar.csD();
                nVar.yAE.csC();
                if (nVar.yAI != null) {
                    for (long fX : nVar.yAI) {
                        nVar.yAE.fX(fX);
                    }
                }
                if (nVar.yAF != null) {
                    nVar.yAF.setVisibility(8);
                }
                if (nVar.yAG != null) {
                    nVar.yAG.setVisibility(8);
                }
                nVar.yAD.yEO.cur();
                nVar.yAD.hideVKB();
                nVar.yAD.ctB();
                nVar.yAD.showOptionMenu(2, true);
            }
            qVar = this.yAM;
            String csn = csn();
            d dVar = this.yyW.yBy;
            String ctj = ctj();
            qVar.yBX = new TreeSet();
            qVar.yBz = csn;
            if (x.gB(csn)) {
                qVar.hnt = x.Xk(ctj);
            } else {
                qVar.hnt = ctj;
            }
            qVar.yBy = dVar;
            com.tencent.mm.sdk.b.b iyVar = new iy();
            iyVar.fAs.fAm = 0;
            iyVar.fAs.ael = com.tencent.mm.sdk.platformtools.w.cfV();
            if (com.tencent.mm.y.s.eX(csn)) {
                iyVar.fAs.fAu = true;
            } else {
                iyVar.fAs.fAu = false;
            }
            com.tencent.mm.sdk.b.a.xmy.m(iyVar);
            qVar.talker = csn;
            qVar.kMn = qVar.yAN.yEL.ctW();
            qVar.csw();
        }

        public final void ctv() {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "jacks onFragment Close");
            this.yEZ = false;
            j jVar = this.yEH;
            if (jVar.fhH.csT()) {
                com.tencent.mm.af.a.a aT = com.tencent.mm.af.y.Mo().aT(jVar.yEL.ctW());
                if (jVar.fhH.ctp() != null && (jVar.yIx == null || !jVar.fhH.ctp().ccf().trim().equals(jVar.yIx))) {
                    jVar.yIx = jVar.fhH.ctp().ccf().trim();
                    aT.field_editingMsg = jVar.yIx;
                    aT.field_flag = com.tencent.mm.af.a.b.a(aT, 1, bi.oN(aT.field_editingMsg) ? aT.field_lastMsgTime : System.currentTimeMillis());
                    com.tencent.mm.af.y.Mo().b(aT);
                    com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ChattingUI.SearchImp", "set editMsg history");
                }
            } else {
                com.tencent.mm.storage.ae XF;
                com.tencent.mm.storage.ae aeVar;
                if (g.Do().CF()) {
                    as.Hm();
                    XF = com.tencent.mm.y.c.Fk().XF(jVar.fhH.csn());
                } else {
                    XF = null;
                }
                if (XF != null || jVar.fhH.ctp() == null || bi.oN(jVar.fhH.ctp().ccf().trim())) {
                    aeVar = XF;
                } else {
                    ak aeVar2 = new com.tencent.mm.storage.ae(jVar.fhH.csW().field_username);
                    aeVar2.aj(System.currentTimeMillis());
                    if (jVar.fhH.csX()) {
                        aeVar2.gc(4194304);
                    }
                    as.Hm();
                    com.tencent.mm.y.c.Fk().d(aeVar2);
                    aeVar = aeVar2;
                }
                if (!(aeVar == null || jVar.fhH.ctp() == null || (jVar.yIx != null && jVar.fhH.ctp().ccf().trim().equals(jVar.yIx)))) {
                    jVar.yIx = jVar.fhH.ctp().ccf().trim();
                    aeVar.dK(jVar.fhH.ctp().ccf().trim());
                    aeVar.ak(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 1, bi.oN(aeVar.field_editingMsg) ? aeVar.field_conversationTime : System.currentTimeMillis()));
                    as.Hm();
                    com.tencent.mm.y.c.Fk().a(aeVar, aeVar.field_username, false);
                    com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ChattingUI.SearchImp", "jacks set editMsg history");
                }
            }
            com.tencent.mm.ui.chatting.b.c cVar = this.yEL;
            bd.w("bizflag", false);
            if (cVar.vus) {
                cVar.ctY();
                com.tencent.mm.af.y.Mw();
                com.tencent.mm.af.a.c cVar2 = cVar.yvJ;
                if (com.tencent.mm.kernel.a.gC(g.Do().gRd)) {
                    aj.a(cVar2.field_brandUserName, 8, "EnterpriseChatStatus", String.format("%s;%s;%d", new Object[]{cVar2.field_brandUserName, cVar2.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000)}));
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BizChatStatusNotifyService", "quitChat:arg:%s", r2);
                }
            }
            if (as.Hp()) {
                if (cVar.vus) {
                    com.tencent.mm.af.y.Mn().a(cVar.ywo);
                }
                if (cVar.fhH.csW() != null && cVar.fhH.csW().ciN()) {
                    com.tencent.mm.af.y.Ml().a(cVar.yHx);
                }
                if (com.tencent.mm.k.a.ga(cVar.fhH.csW().field_type) && cVar.fhH.csW().ciN() && !com.tencent.mm.af.f.eG(cVar.fhH.csn())) {
                    com.tencent.mm.af.y.Mu();
                    com.tencent.mm.af.k.kg(cVar.fhH.csn());
                }
                com.tencent.mm.af.y.Mt().b(cVar.yHv);
            }
            if (com.tencent.mm.app.plugin.a.a.a(cVar.kKo) && cVar.yHq != null) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.BizMgr", "hardevice brand account, init event : %s, notify exit chattingui", cVar.fhH.ctL());
                cVar.yHq.a(2, cVar.kKo);
                cVar.fhH.cte().setMMSubTitle(null);
            }
            if (com.tencent.mm.k.a.ga(cVar.fhH.csW().field_type) && cVar.fhH.csW().ciN() && cVar.yHr != 0 && cVar.fhH.cte().getIntExtra("biz_click_item_position", 0) > 0) {
                com.tencent.mm.plugin.report.service.g.pWK.h(10638, cVar.fhH.csn(), Integer.valueOf(((int) (System.currentTimeMillis() - cVar.yHr)) / 1000), Integer.valueOf(cVar.fhH.cte().getIntExtra("biz_click_item_unread_count", 0)), Integer.valueOf(cVar.fhH.cte().getIntExtra("biz_click_item_position", 0)));
                cVar.yHr = 0;
            }
            if (cVar.yHq != null) {
                com.tencent.mm.app.plugin.a.a aVar = cVar.yHq;
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now release the event listener");
                if (aVar.fhI != null) {
                    com.tencent.mm.sdk.b.a.xmy.c(aVar.fhI);
                    aVar.fhI = null;
                    if (aVar.fhL != null) {
                        aVar.fhL.clear();
                    }
                }
                aVar.fhM = false;
                if (aVar.fhJ != null) {
                    com.tencent.mm.sdk.b.a.xmy.c(aVar.fhJ);
                    aVar.fhJ = null;
                }
                cVar.yHq = null;
            }
            com.tencent.mm.sdk.b.b rvVar = new rv();
            rvVar.fKt.type = 3;
            com.tencent.mm.sdk.b.a.xmy.m(rvVar);
            this.yEA.yLr.clear();
            com.tencent.mm.plugin.sight.decode.a.b.Ez();
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "[unregitListener]");
            com.tencent.mm.ap.o.PA().hCL = null;
            as.CN().b(522, (e) this);
            as.CN().b(110, (e) this);
            as.CN().b(10, (e) this);
            as.CN().b(127, (e) this);
            as.CN().b(594, (e) this);
            as.CN().b(551, (e) this);
            as.CN().b(525, (e) this);
            as.CN().b(610, (e) this);
            as.CN().b(137, (e) this);
            com.tencent.mm.ui.chatting.b.e eVar = this.yEK;
            com.tencent.mm.pluginsdk.d.b.b(jx.class.getName(), eVar.yHM);
            com.tencent.mm.pluginsdk.d.b.b(kc.class.getName(), eVar.yHM);
            if (as.Hp()) {
                as.Hm();
                com.tencent.mm.y.c.Fo().j(eVar.yHK);
                com.tencent.mm.sdk.b.a.xmy.c(eVar.yHJ);
                com.tencent.mm.sdk.b.a.xmy.c(eVar.yHL);
            }
            as.CN().b(223, (e) this);
            com.tencent.mm.ui.chatting.b.a aVar2 = this.yEI;
            am amVar = aVar2.yHi;
            aVar2.fhH.cte().getContext();
            am.yGI.remove(amVar);
            amVar.yGH.clear();
            am.a(amVar.yGG.getContext(), null);
            if (as.Hp()) {
                an.aqK().j(aVar2.yHj);
                an.biT().j(aVar2.yHk);
            }
            o oVar = this.yEv;
            oVar.TN();
            com.tencent.mm.sdk.b.a.xmy.c(oVar.yIZ);
            com.tencent.mm.ui.chatting.gallery.f fVar = oVar.yJb;
            fVar.tj.clear();
            fVar.aPa();
            if (as.Hp()) {
                as.Hm();
                com.tencent.mm.y.c.Ff().b(this);
                com.tencent.mm.sdk.b.a.xmy.c(this.yEq.yLn);
                com.tencent.mm.sdk.b.a.xmy.c(this.yEz.yJh);
                com.tencent.mm.storage.as.a aVar3 = this.yEw;
                com.tencent.mm.sdk.b.a.xmy.c(aVar3.yJW);
                as.Hm();
                com.tencent.mm.y.c.Fk().a(aVar3);
                as.Hm();
                com.tencent.mm.y.c.Fh().a((com.tencent.mm.plugin.messenger.foundation.a.a.c.a) this);
                com.tencent.mm.sdk.b.a.xmy.c(this.yEs.jil);
                com.tencent.mm.ac.n.JF().b(this.yEP.yIb);
                l lVar = this.yEy;
                com.tencent.mm.sdk.b.a.xmy.c(lVar.yIE);
                com.tencent.mm.sdk.b.a.xmy.c(lVar.yIF);
            }
            y yVar = this.yEJ;
            if (yVar.yKA != null) {
                x xVar = yVar.yKA;
                if (xVar.yFH != null) {
                    z zVar = xVar.yFH;
                    zVar.mHandler.removeMessages(0);
                    if (zVar.yFL != null) {
                        zVar.yFL.stop();
                    }
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.EggMgr", "egg has been stop");
                }
            }
            HardCoderJNI.stopPerformace(HardCoderJNI.hcSendMsgEnable, yVar.yKG);
            yVar.yKG = 0;
            com.tencent.mm.sdk.b.a.xmy.m(new bk());
            crW();
            if (this.yAM != null) {
                this.yAM.csw();
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "ChattingUI resetAdapter");
            }
        }

        public void onActivityCreated(Bundle bundle) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onActivityCreated %d", Integer.valueOf(hashCode()));
            super.onActivityCreated(bundle);
            crK();
        }

        private void ctw() {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "doCreateOnerousJob!!! rawUserName:%s", this.yAP);
            com.tencent.mm.sdk.b.b rvVar = new rv();
            rvVar.fKt.type = 4;
            com.tencent.mm.sdk.b.a.xmy.m(rvVar);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "[regitListener]");
            as.CN().a(522, (e) this);
            as.CN().a(110, (e) this);
            as.CN().a(10, (e) this);
            as.CN().a(127, (e) this);
            as.CN().a(610, (e) this);
            as.CN().a(594, (e) this);
            as.CN().a(551, (e) this);
            as.CN().a(525, (e) this);
            as.CN().a(137, (e) this);
            as.Hm();
            com.tencent.mm.y.c.Ff().a(this);
            as.Hm();
            com.tencent.mm.y.c.Fh().a((com.tencent.mm.plugin.messenger.foundation.a.a.c.a) this, Looper.getMainLooper());
            as.CN().a(223, (e) this);
            com.tencent.mm.sdk.b.a.xmy.b(this.yEq.yLn);
            com.tencent.mm.sdk.b.a.xmy.b(this.yEz.yJh);
            com.tencent.mm.storage.as.a aVar = this.yEw;
            as.Hm();
            com.tencent.mm.y.c.Fk().a(aVar, Looper.getMainLooper());
            com.tencent.mm.sdk.b.a.xmy.b(aVar.yJW);
            com.tencent.mm.sdk.b.a.xmy.b(this.yEs.jil);
            com.tencent.mm.sdk.b.a.xmy.b(this.yEv.yIZ);
            com.tencent.mm.ui.chatting.b.b bVar = this.yEC;
            com.tencent.mm.ay.r.QP().c(bVar.yHo);
            com.tencent.mm.ay.r.QO().c(bVar.yHo);
            com.tencent.mm.ap.o.PA().hCL = this.yEB;
            l lVar = this.yEy;
            com.tencent.mm.sdk.b.a.xmy.b(lVar.yIE);
            com.tencent.mm.sdk.b.a.xmy.b(lVar.yIF);
            com.tencent.mm.ui.chatting.b.e eVar = this.yEK;
            if (!com.tencent.mm.y.s.hq(eVar.fhH.csn()) && com.tencent.mm.y.s.eX(eVar.fhH.csn())) {
                as.Hm();
                com.tencent.mm.storage.ae XF = com.tencent.mm.y.c.Fk().XF(eVar.fhH.csn());
                if (XF == null || (XF.field_showTips & 2) > 0) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.ChatroomImp", "jacks ont need auto display name because : already tips");
                } else {
                    as.Hm();
                    com.tencent.mm.storage.q hG = com.tencent.mm.y.c.Fo().hG(eVar.fhH.csn());
                    if (hG == null || hG.My().size() < 20) {
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.ChatroomImp", "jacks ont need auto display name because : member nums too few");
                    } else if (!(hG == null || hG.ciI())) {
                        com.tencent.mm.y.m.a(eVar.fhH.csn(), hG, true);
                        XF.field_showTips = 2;
                        XF.fXY = true;
                        as.Hm();
                        com.tencent.mm.y.c.Fk().a(XF, eVar.fhH.csn());
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.ChatroomImp", "Jacks Show auto Display name tips");
                        com.tencent.mm.y.l.a(eVar.fhH.csn(), null, eVar.fhH.cte().getMMString(R.l.dTl), false, "", 0);
                    }
                }
            }
            as.Hm();
            com.tencent.mm.y.c.Fo().c(eVar.yHK);
            com.tencent.mm.pluginsdk.d.b.a(jx.class.getName(), eVar.yHM);
            com.tencent.mm.pluginsdk.d.b.a(kc.class.getName(), eVar.yHM);
            com.tencent.mm.sdk.b.a.xmy.b(eVar.yHJ);
            com.tencent.mm.sdk.b.a.xmy.b(eVar.yHL);
            if (com.tencent.mm.y.s.eX(eVar.fhH.csW().field_username) && com.tencent.mm.y.m.gg(eVar.fhH.csW().field_username)) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.ChatroomImp", "chattingui find chatroom contact need update %s", eVar.fhH.csW().field_username);
                com.tencent.mm.y.ak.a.hhv.Q(eVar.fhH.csW().field_username, "");
            }
            if (!(com.tencent.mm.pluginsdk.q.a.vjd == null || eVar.fhH.csW().field_username.equals(com.tencent.mm.pluginsdk.q.a.vjd.aWh()))) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.ChatroomImp", "chatting oncreate end track %s", com.tencent.mm.pluginsdk.q.a.vjd.aWh());
                rvVar = new eq();
                rvVar.fub.username = eVar.fhH.csW().field_username;
                com.tencent.mm.sdk.b.a.xmy.m(rvVar);
            }
            eVar.cuc();
            as.Hm();
            if (com.tencent.mm.y.c.Fa()) {
                aj.S(this.yAP, 2);
            }
            rvVar = new ld();
            rvVar.fDo.talker = this.fBc.field_username;
            com.tencent.mm.sdk.b.a.xmy.m(rvVar);
            if (x.Xg(this.fBc.field_username)) {
                ((com.tencent.mm.openim.a.b) g.h(com.tencent.mm.openim.a.b.class)).aA(this.fBc.field_openImAppid, this.fBc.field_descWordingId);
            }
        }

        public void crK() {
            int i;
            x xVar;
            String str;
            String str2;
            boolean z;
            com.tencent.mm.ui.chatting.b.x xVar2 = this.yEx;
            xVar2.yKs = System.currentTimeMillis();
            xVar2.yKt = true;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "do Create !!!!");
            this.mHasBackOnKeyDown = false;
            this.yFy = false;
            this.mBackOnKeyDownTS = 0;
            boolean oN = bi.oN(this.yAP);
            getStringExtra("Chat_User").equals(this.yAP);
            this.yFu = false;
            this.yFv = false;
            this.yEY = true;
            this.yEV = false;
            this.yEq.yLm.clear();
            this.yFg = true;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "resetBaseParams rawUserName from :%s to :%s ", this.yAP, getStringExtra("Chat_User"));
            this.yEV = getBooleanExtra("key_is_temp_session", false).booleanValue();
            this.yAP = getStringExtra("Chat_User");
            this.yFe = getBooleanExtra("finish_direct", false).booleanValue();
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "isFromSearch  " + this.yFe);
            as.Hm();
            this.fBc = com.tencent.mm.y.c.Ff().Xv(this.yAP);
            com.tencent.mm.f.b.ag agVar = this.fBc;
            String str3 = this.yAP;
            String str4 = "MicroMsg.ChattingUI";
            String str5 = "protectContactNotExist user:%s contact:%d ";
            Object[] objArr = new Object[2];
            objArr[0] = str3;
            if (agVar == null) {
                i = -1;
            } else {
                i = (int) agVar.gKO;
            }
            objArr[1] = Integer.valueOf(i);
            com.tencent.mm.sdk.platformtools.x.w(str4, str5, objArr);
            if (agVar == null || ((int) agVar.gKO) == 0 || bi.oN(agVar.field_username)) {
                xVar = new x();
                xVar.setUsername(str3);
                xVar.Ao();
                xVar.eC(3);
                as.Hm();
                com.tencent.mm.y.c.Ff().R(xVar);
                as.Hm();
                x Xv = com.tencent.mm.y.c.Ff().Xv(str3);
                if (Xv == null) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI", "protectContactNotExist contact get from db is null!");
                } else {
                    xVar = Xv;
                }
            } else {
                com.tencent.mm.f.b.ag xVar3 = agVar;
            }
            this.fBc = xVar3;
            if (bi.oN(this.fBc.field_encryptUsername)) {
                str = this.fBc.field_username;
            } else {
                str = this.fBc.field_encryptUsername;
            }
            this.fAd = str;
            this.yFi = getBooleanExtra("expose_edit_mode", false).booleanValue();
            this.yAI = getArguments().getLongArray("expose_selected_ids");
            q qVar = this.yEz;
            boolean booleanValue = qVar.fhH.cte().getBooleanExtra("lbs_mode", false).booleanValue();
            qVar.fhH.mP(booleanValue);
            qVar.kBn = qVar.fhH.cte().getStringExtra("lbs_ticket");
            if (booleanValue) {
                str2 = qVar.fhH.csW().field_username;
                if (!(str2 == null || com.tencent.mm.y.s.gG(str2))) {
                    qVar.fhH.csW().setUsername(qVar.fhH.csY());
                    qVar.fhH.csW().di(null);
                    as.Hm();
                    com.tencent.mm.y.c.Ff().a(str2, qVar.fhH.csW());
                    qVar.fhH.ZK(qVar.fhH.csW().field_username);
                }
            }
            str = new com.tencent.mm.storage.bc.a(csn()).Yo("");
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "new RoleInfo.Parser(getTalkerUserName())" + str);
            as.Hm();
            this.yEW = com.tencent.mm.y.c.Fn().FE(str);
            str = csn();
            this.yAR = str.endsWith("@chatroom");
            this.yFd = ZL(str);
            if (this.yAR) {
                this.xTP = com.tencent.mm.y.m.gf(csn());
            }
            if (this.yAR || this.yEL.yHs) {
                z = true;
            } else {
                z = false;
            }
            this.yxU = z;
            w wVar = this.yEw;
            wVar.yJQ = false;
            wVar.yJU = wVar.fhH.csS();
            f fVar = this.yEP;
            fVar.qxe = fVar.fhH.cte().getIntExtra("add_scene", 0);
            fVar.cuf();
            com.tencent.mm.ac.n.JF().a(fVar.yIb);
            fVar.setBackBtn(fVar.yIc);
            if (bi.oN(this.yAP)) {
                com.tencent.mm.plugin.report.service.g.pWK.a(110, 0, 1, true);
            }
            com.tencent.mm.booter.notification.queue.b xp = com.tencent.mm.booter.notification.queue.b.xp();
            str2 = this.fBc.field_username;
            if (!t.oN(str2)) {
                xp.gBW.es(str2);
            }
            if (oN) {
                this.mCW = (ClipboardManager) getContext().getSystemService("clipboard");
                as.CN().a(new be(new com.tencent.mm.y.be.a() {
                    public final void a(com.tencent.mm.network.e eVar) {
                        if (eVar != null) {
                            String str;
                            String str2;
                            i iVar = i.this;
                            String ispId = eVar.getIspId();
                            long j = !bi.oN(ispId) ? bi.getLong(ispId, 0) : 0;
                            String str3 = "TypingTrigger";
                            String str4 = "TypingInterval";
                            if (j != 0) {
                                str = str3 + "_ISP" + j;
                                str2 = str4 + "_ISP" + j;
                            } else {
                                str2 = str4;
                                str = str3;
                            }
                            str = bi.aD(com.tencent.mm.j.g.Af().getValue(str), PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT);
                            str2 = bi.aD(com.tencent.mm.j.g.Af().getValue(str2), "15");
                            iVar.yIr = bi.getInt(str, 0);
                            iVar.hZI = bi.getInt(str2, 0);
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.DirectScendImp", "ispId: %d, trigger:%d, interval:%d", Long.valueOf(j), Integer.valueOf(iVar.yIr), Integer.valueOf(iVar.hZI));
                            if (!(iVar.yIr == -1 || iVar.yIr == -2 || iVar.yIr > 0)) {
                                iVar.yIr = 10;
                            }
                            if (iVar.hZI <= 0) {
                                iVar.hZI = 15;
                            }
                            eVar.setSignallingStrategy((long) (iVar.hZI * 1000), 20000);
                        }
                    }
                }), 0);
                this.handler.post(new Runnable() {
                    public final void run() {
                        a.this.yEP.cuf();
                        a.this.crM();
                    }
                });
            }
            crO();
            com.tencent.mm.ui.chatting.b.c cVar = this.yEL;
            if (cVar.fhH.cte().getIntExtra("biz_click_item_position", 0) > 0) {
                cVar.yHr = System.currentTimeMillis();
            }
            cVar.vus = cVar.fhH.cte().getBooleanExtra("key_is_biz_chat", false).booleanValue();
            cVar.fhH.cte().getLongExtra("key_biz_chat_id", -1);
            if (cVar.vus) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.BizMgr", "getBizChatInfo");
                as.Dt().g(new Runnable() {
                    public final void run() {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (!c.this.vus || c.this.yvJ == null || c.this.fhH.csW() == null) {
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.BizMgr", "bizChatInfo:%s  talker:%s", c.this.yvJ, c.this.fhH.csW());
                        } else {
                            c.this.ctY();
                            com.tencent.mm.af.y.Mw();
                            com.tencent.mm.af.a.c cVar = c.this.yvJ;
                            if (com.tencent.mm.kernel.a.gC(g.Do().gRd)) {
                                aj.a(cVar.field_brandUserName, 7, "EnterpriseChatStatus", String.format("%s;%s;%d", new Object[]{cVar.field_brandUserName, cVar.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000)}));
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BizChatStatusNotifyService", "enterChat:arg:%s", r3);
                            }
                            if (c.this.yHs) {
                                if (c.this.yvJ.MA()) {
                                    com.tencent.mm.af.y.Mr();
                                    h.ak(c.this.yvJ.field_bizChatServId, c.this.fhH.csW().field_username);
                                } else {
                                    com.tencent.mm.af.a.e.f(c.this.yvJ);
                                }
                            }
                            com.tencent.mm.af.n nVar = c.this;
                            if (!(!nVar.vus || nVar.yvJ == null || bi.oN(nVar.yvJ.field_brandUserName))) {
                                String cb = com.tencent.mm.af.y.Mp().cb(nVar.yvJ.field_brandUserName);
                                com.tencent.mm.af.a.j ca = com.tencent.mm.af.y.Mp().ca(cb);
                                String str = "MicroMsg.ChattingUI.BizMgr";
                                String str2 = "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s";
                                Object[] objArr = new Object[3];
                                objArr[0] = nVar.yvJ.field_brandUserName;
                                objArr[1] = cb;
                                objArr[2] = Boolean.valueOf(ca == null);
                                com.tencent.mm.sdk.platformtools.x.i(str, str2, objArr);
                                if (bi.oN(cb) || ca == null || ca.MA() || bi.oN(ca.field_addMemberUrl)) {
                                    com.tencent.mm.af.y.Mr();
                                    h.a(nVar.yvJ.field_brandUserName, nVar);
                                }
                            }
                        }
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.BizMgr", "willen test  updateBizChatInfo use time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }
                }, 500);
            }
            if (cVar.fhH.csW() != null && cVar.fhH.csW().ciN()) {
                com.tencent.mm.af.y.Mv().jz(cVar.fhH.csW().field_username);
            }
            cVar.yFh = cVar.fhH.cte().getLongExtra("key_biz_chat_id", -1);
            cVar.kKo = com.tencent.mm.af.f.jV(cVar.fhH.csn());
            if (cVar.vus) {
                cVar.yvJ = com.tencent.mm.af.y.Mn().ag(cVar.yFh);
                cVar.yvJ = com.tencent.mm.af.a.e.a(cVar.yvJ, cVar.yFh);
            }
            z = cVar.vus && com.tencent.mm.af.a.e.kq(cVar.yvJ.field_bizChatServId);
            cVar.yHs = z;
            if (cVar.vus && !cVar.yHs) {
                cVar.poq = com.tencent.mm.af.y.Mp().ca(cVar.yvJ.field_bizChatServId);
                cVar.poq = com.tencent.mm.af.a.e.a(cVar.poq, cVar.yvJ.field_bizChatServId);
            }
            if (cVar.yHs) {
                cVar.fhH.mQ(com.tencent.mm.af.a.e.c(cVar.yvJ));
            }
            if (com.tencent.mm.app.plugin.a.a.a(cVar.kKo) && cVar.yHq == null) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.BizMgr", "hardevice brand account, init event : %s", cVar.fhH.ctL());
                cVar.yHq = new com.tencent.mm.app.plugin.a.a(cVar.fhH);
            }
            if (cVar.fhH.csW().ciN()) {
                com.tencent.mm.bd.d.chatType = 2;
            }
            if (com.tencent.mm.k.a.ga(cVar.fhH.csW().field_type) && cVar.fhH.csW().ciN() && !com.tencent.mm.af.f.eG(cVar.fhH.csn())) {
                com.tencent.mm.af.y.Mu().b(cVar.fhH.csn(), cVar.fhH.ctm().getCount() > 0 ? (au) cVar.fhH.ctm().getItem(cVar.fhH.ctm().getCount() - 1) : null);
            }
            if (cVar.vus) {
                com.tencent.mm.af.y.Mn().a(cVar.ywo, Looper.getMainLooper());
                com.tencent.mm.af.y.Mt().a(cVar.yHv);
            }
            if (cVar.fhH.csW() != null && cVar.fhH.csW().ciN()) {
                com.tencent.mm.af.y.Ml().a(cVar.yHx, Looper.getMainLooper());
            }
            j jVar = this.yEH;
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.SearchImp", "jacks mark reset keybord state");
            jVar.yIy = a.yIz;
            if (jVar.fhH.csW() != null) {
                if (jVar.fhH.csT()) {
                    str2 = com.tencent.mm.af.y.Mo().aT(jVar.yEL.ctW()).field_editingMsg;
                    jVar.yIw = str2;
                    jVar.yIx = str2;
                } else {
                    as.Hm();
                    ak XF = com.tencent.mm.y.c.Fk().XF(jVar.fhH.csn());
                    if (XF != null) {
                        str2 = XF.field_editingMsg;
                        jVar.yIw = str2;
                        jVar.yIx = str2;
                    }
                }
            }
            this.yEM.crK();
            com.tencent.mm.ui.chatting.b.r rVar = this.yEF;
            com.tencent.mm.sdk.b.b iyVar = new iy();
            iyVar.fAs.fAm = 0;
            iyVar.fAs.ael = com.tencent.mm.sdk.platformtools.w.cfV();
            if (com.tencent.mm.y.s.eX(rVar.fhH.csW().field_username)) {
                iyVar.fAs.fAu = true;
            } else {
                iyVar.fAs.fAu = false;
            }
            com.tencent.mm.sdk.b.a.xmy.m(iyVar);
            com.tencent.mm.ui.chatting.b.a aVar = this.yEI;
            aVar.pRC = com.tencent.mm.plugin.wallet.a.cs(aVar.fhH.csW().field_username, 1);
            aVar.pRC.aQ(1, aVar.fhH.csW().field_username);
            an.aqK().c(aVar.yHj);
            an.biT().c(aVar.yHk);
            if (aVar.yHi == null) {
                aVar.yHi = new am(aVar.fhH);
            }
            am amVar = aVar.yHi;
            aVar.fhH.cte().getContext();
            am.yGI.a(amVar, null);
            ctu();
            com.tencent.mm.ui.chatting.b.u uVar = this.yEG;
            uVar.yJB = uVar.fhH.cte().getBooleanExtra("need_hight_item", false).booleanValue();
            uVar.yJp = uVar.fhH.cte().getBooleanExtra("search_chat_content", false).booleanValue();
            uVar.yAH = uVar.fhH.cte().getBooleanExtra("show_search_chat_content_result", false).booleanValue();
            uVar.yJt = uVar.fhH.cte().getStringArrayList("highlight_keyword_list");
            uVar.yJs = uVar.fhH.cte().getLongExtra("msg_local_id", -1);
            uVar.yJr = uVar.fhH.cte().getBooleanExtra("from_global_search", false).booleanValue();
            uVar.yJq = uVar.fhH.cte().getBooleanExtra("img_gallery_enter_from_chatting_ui", false).booleanValue();
            if (uVar.yJs >= 0 && !uVar.yJC) {
                ah.h(new Runnable() {
                    public final void run() {
                        if (!u.this.yJC) {
                            u.this.yJC = true;
                            u.this.yJs = -1;
                            u.this.fhH.cpZ();
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SearchImp", "dismiss fts highlight");
                        }
                    }
                }, 2000);
            }
            if (uVar.yJp) {
                com.tencent.mm.plugin.report.service.g.pWK.a(219, 11, 1, true);
                com.tencent.mm.ui.chatting.b.g.a(uVar.fhH.cte(), R.h.cJz);
                uVar.yJo = uVar.fhH.cte().findViewById(R.h.cJE);
                uVar.yJx = uVar.fhH.cte().findViewById(R.h.cJx);
                uVar.fhH.ctl().setFocusable(false);
                uVar.fhH.ctl().setFocusableInTouchMode(false);
                uVar.yJx.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                    }
                });
                if (uVar.yJv == null) {
                    com.tencent.mm.ui.chatting.b.g.a(uVar.fhH.cte(), R.h.cWb);
                    uVar.yJv = (TextView) uVar.fhH.cte().findViewById(R.h.ceq);
                }
                uVar.yCy = new u(uVar.fhH.cte().getContext(), new au(), uVar.fhH.csn(), uVar.fhH.ctj(), uVar.fhH.csR());
                uVar.yCy.yDg = new com.tencent.mm.ui.chatting.u.a() {
                    public final void FQ(int i) {
                        u.this.FY(i);
                    }
                };
                uVar.yJw = (ListView) uVar.fhH.cte().findViewById(R.h.cJy);
                uVar.yJw.setAdapter(uVar.yCy);
                uVar.yJw.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        au auVar = (au) u.this.yCy.getItem(i);
                        if (auVar != null && !bi.oN(auVar.field_talker)) {
                            com.tencent.mm.plugin.report.service.g.pWK.h(10450, Integer.valueOf(1));
                            Intent intent = new Intent(u.this.fhH.cte().getContext(), ChattingUI.class);
                            intent.putExtra("Chat_User", auVar.field_talker);
                            intent.putExtra("finish_direct", true);
                            intent.putExtra("show_search_chat_content_result", false);
                            intent.putExtra("msg_local_id", auVar.field_msgId);
                            intent.putExtra("img_gallery_enter_from_chatting_ui", true);
                            u.this.fhH.cte().startActivity(intent);
                        }
                    }
                });
                uVar.yJw.setOnTouchListener(new OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        u.this.fhH.cte().hideVKB();
                        return false;
                    }
                });
                uVar.liK = new com.tencent.mm.ui.tools.p();
                uVar.liK.zvw = new com.tencent.mm.ui.tools.p.b() {
                    private int yJF = 0;

                    public final void pd(String str) {
                        if (bi.oN(str)) {
                            this.yJF = 0;
                            u.this.FY(-1);
                            return;
                        }
                        if (str.length() > this.yJF) {
                            com.tencent.mm.plugin.report.service.g.pWK.h(10451, Integer.valueOf(1));
                        }
                        this.yJF = str.length();
                        com.tencent.mm.plugin.report.service.g.pWK.h(10456, Integer.valueOf(1));
                        u.this.yCy.Ds(str);
                    }

                    public final void XA() {
                        new ag().post(new Runnable() {
                            public final void run() {
                                u.this.fhH.ctA();
                            }
                        });
                    }

                    public final void XB() {
                    }

                    public final boolean pc(String str) {
                        return false;
                    }

                    public final void XC() {
                    }

                    public final void XD() {
                    }
                };
                uVar.fhH.cte().addSearchMenu(true, uVar.liK);
                uVar.liK.nC(true);
            }
            if (uVar.yAH || uVar.yJr) {
                long longExtra = uVar.fhH.cte().getLongExtra("msg_local_id", -1);
                int r = uVar.fhH.ctm().r(longExtra, uVar.yJr);
                Window window = uVar.fhH.cte().getWindow();
                if (window != null) {
                    window.getDecorView().post(new com.tencent.mm.ui.chatting.b.u.AnonymousClass11(longExtra, r));
                } else {
                    uVar.fhH.ctl().postDelayed(new com.tencent.mm.ui.chatting.b.u.AnonymousClass12(longExtra, r), 100);
                }
            }
            if (this.ocy) {
                ctw();
            }
            this.yEx.crK();
            this.handler.postDelayed(new Runnable() {
                public final void run() {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "now try to activity the tools process");
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(com.tencent.mm.ui.e.h.xMS, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                    intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                    a.this.sendBroadcast(intent);
                }
            }, 3000);
        }

        public final void ctx() {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "ashutest::doJobOnAnimInEnd");
            if (this.ocy) {
                ctw();
                crL();
                y yVar = this.yEJ;
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.TextImp", "hardCoderEnterChattingStart %s", Integer.valueOf(yVar.yKE));
                HardCoderJNI.stopPerformace(HardCoderJNI.hcEnterChattingEnable, yVar.yKE);
                yVar.yKE = 0;
            }
        }

        public final void cty() {
            int i = 10;
            if (!(this.yEG.yAH || this.yEG.yJr)) {
                int i2 = this.yFw;
                this.yFw = i2 + 1;
                if (i2 < 10 && ((thisActivity() instanceof ChattingUI) || (thisActivity() instanceof AppBrandServiceChattingUI))) {
                    ListView listView = this.yEX;
                    Runnable anonymousClass27 = new Runnable() {
                        public final void run() {
                            if (a.this.yFs || a.this.yi != 0) {
                                a.this.yFw = 10;
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "scrollToLastProtect userTouched: %s state: %s", Boolean.valueOf(a.this.yFs), Integer.valueOf(a.this.yi));
                                return;
                            }
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "scrollToLastProtect tryScrollTimes : %s, lastvisible/total=%s/%s", Integer.valueOf(a.this.yFw), Integer.valueOf(a.this.yEX.getLastVisiblePosition()), Integer.valueOf(a.this.yEX.getCount() - 1));
                            if (a.this.yEX.getLastVisiblePosition() < a.this.yEX.getCount() - 1) {
                                a.this.mU(true);
                                a.this.cty();
                                return;
                            }
                            a.this.yFw = 10;
                        }
                    };
                    if (this.yFw != 1) {
                        i = 100;
                    }
                    listView.postDelayed(anonymousClass27, (long) i);
                    return;
                }
            }
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "scrollToLastProtect:%s, %s ,%s", Boolean.valueOf(this.yEG.yAH), Boolean.valueOf(this.yEG.yJr), Integer.valueOf(this.yFw));
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            LayoutParams layoutParams = onCreateView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -1);
            }
            onCreateView.setLayoutParams(layoutParams);
            return onCreateView;
        }

        public void onDestroy() {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "dktask FragmentonDestroy %s#0x%x task:%s ", thisActivity().getClass().getSimpleName(), Integer.valueOf(thisActivity().hashCode()), bi.fc(thisActivity()));
            if (this.yAP != null) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onDestroy %d", Integer.valueOf(hashCode()));
                this.yEM.bg();
                ctv();
                com.tencent.mm.sdk.b.b iyVar = new iy();
                iyVar.fAs.fAm = 2;
                com.tencent.mm.sdk.b.a.xmy.m(iyVar);
                com.tencent.mm.ui.chatting.b.b bVar = this.yEC;
                if (as.Hp()) {
                    com.tencent.mm.ay.r.QP().j(bVar.yHo);
                    com.tencent.mm.ay.r.QO().j(bVar.yHo);
                }
                bVar.ctU();
                ae aeVar = this.yyW;
                com.tencent.mm.modelvoice.r.b(aeVar.yBy);
                com.tencent.mm.modelvoice.e.b(aeVar.yBy);
                aeVar.releaseWakeLock();
                if (aeVar.yBy != null) {
                    aeVar.yBy.crQ();
                    com.tencent.mm.y.ad adVar = aeVar.yBy;
                    adVar.release();
                    adVar.yyV = null;
                    adVar.yza = false;
                    com.tencent.mm.sdk.b.a.xmy.c(adVar.yzf);
                    as.uy().b(adVar);
                }
                this.yAM.aUU();
                com.tencent.mm.ui.chatting.b.u uVar = this.yEG;
                uVar.yJC = true;
                if (uVar.yCy != null) {
                    uVar.yCy.aUU();
                }
                if (uVar.liK != null) {
                    uVar.liK.clearFocus();
                }
                this.yAM.xQN = null;
                as.Hm();
                if (com.tencent.mm.y.c.Fa()) {
                    aj.S(csn(), 5);
                }
                if (this.yEu.yKW != null) {
                    this.yEu.yKW.stop();
                }
                this.yFq.TN();
                if (this.yFp != null) {
                    this.yFp.onDetach();
                }
            }
            this.yEx.cuK();
            super.onDestroy();
            this.yFa.clear();
        }

        public void onStart() {
            f fVar = this.yEP;
            as.Hm().FM().a(new com.tencent.mm.y.b.e.a() {
                public final void ID() {
                    f.this.fhH.ctg().post(new Runnable() {
                        public final void run() {
                            f.this.cuj();
                        }
                    });
                }

                public final void IE() {
                    f.this.cuk();
                }
            });
            as.Hm().FN().a(new com.tencent.mm.y.b.e.a() {
                public final void ID() {
                    f.this.fhH.ctg().post(new Runnable() {
                        public final void run() {
                            f.this.cul();
                        }
                    });
                }

                public final void IE() {
                    f.this.cum();
                }
            });
            com.tencent.mm.y.b.b FO = as.Hm().FO();
            com.tencent.mm.y.b.b.a aVar = fVar.yIa;
            synchronized (com.tencent.mm.y.b.b.class) {
                FO.mListeners.add(aVar);
            }
            super.onStart();
        }

        public void onStop() {
            f fVar = this.yEP;
            if (g.Do().CF()) {
                as.Hm().FM().a(null);
                as.Hm().FN().a(null);
                com.tencent.mm.y.b.b FO = as.Hm().FO();
                com.tencent.mm.y.b.b.a aVar = fVar.yIa;
                synchronized (com.tencent.mm.y.b.b.class) {
                    FO.mListeners.remove(aVar);
                }
            }
            q qVar = this.yEz;
            ah.K(qVar.yJf);
            ah.K(qVar.yJg);
            super.onStop();
        }

        public final boolean AP() {
            return this.yyW.AP();
        }

        public void onCreate(Bundle bundle) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "dktask FragmentonCreate:%s#0x%x task:%s hc:%d", thisActivity().getClass().getSimpleName(), Integer.valueOf(thisActivity().hashCode()), bi.fc(thisActivity()), Integer.valueOf(hashCode()));
            ctt();
            f fVar = this.yEP;
            if (fVar.cue()) {
                fVar.yHW = new com.tencent.mm.ui.q();
                Object obj = fVar.yHW;
                u cte = fVar.fhH.cte();
                obj.xSC = cte;
                obj.xSD = new com.tencent.mm.ui.b.b(cte.thisActivity(), obj);
                fVar.fhH.cte().setActivityController(fVar.yHW);
            }
            if (this.mController != null) {
                this.mController.ae(3, true);
            }
            super.onCreate(bundle);
        }

        protected void crL() {
            boolean z;
            com.tencent.mm.pluginsdk.q.f fVar;
            ae aeVar;
            long currentTimeMillis;
            d dVar;
            com.tencent.mm.af.d.b bK;
            com.tencent.mm.platformtools.j.a aVar;
            com.tencent.mm.sdk.b.b lnVar;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onResumeOnerousJob!!!");
            com.tencent.mm.modelstat.d.b(3, "ChattingUI" + getIdentString(), hashCode());
            com.tencent.mm.sdk.b.b rvVar = new rv();
            rvVar.fKt.type = 0;
            if (this.yEX != null) {
                rvVar.fKt.fKw = this.yEX.getHeaderViewsCount();
                rvVar.fKt.fKu = this.yEX.getFirstVisiblePosition();
                rvVar.fKt.fKv = this.yEX.getLastVisiblePosition();
            }
            com.tencent.mm.sdk.b.a.xmy.m(rvVar);
            if (!this.isCurrentActivity && (thisActivity() instanceof LauncherUI)) {
                ((LauncherUI) thisActivity()).xPu.xOK.cnV();
            }
            com.tencent.mm.ui.chatting.b.c cVar = this.yEL;
            bd.w("bizflag", cVar.fhH.csX());
            if (cVar.kKo == null || com.tencent.mm.app.plugin.a.a.a(cVar.kKo)) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.BizMgr", "hardevice brand account, onresume: %s, notify switch view enter chattingui", cVar.fhH.ctL());
                if (cVar.yHq != null) {
                    cVar.yHq.a(1, cVar.kKo);
                }
            } else {
                cVar.fhH.cte().setMMSubTitle(null);
            }
            com.tencent.mm.af.d dVar2 = cVar.kKo;
            if (!(dVar2 == null || dVar2 == null)) {
                com.tencent.mm.af.d.b bK2 = dVar2.bK(false);
                if (bK2 != null && bK2.Lv()) {
                    z = true;
                    if (z) {
                        as.Dt().F(new Runnable() {
                            public final void run() {
                                b oiVar = new oi();
                                oiVar.fHa.userName = c.this.kKo.field_username;
                                com.tencent.mm.sdk.b.a.xmy.m(oiVar);
                            }
                        });
                    }
                    if (!com.tencent.mm.k.a.ga(cVar.fhH.csW().field_type) && cVar.fhH.csW().ciN() && cVar.kKo != null) {
                        bK2 = cVar.kKo.bK(false);
                        if (bK2 != null && bK2.Lg()) {
                            if (com.tencent.mm.modelgeo.c.OW() || com.tencent.mm.modelgeo.c.OX()) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (cVar.kKo.field_hadAlert == 0 || (cVar.kKo.Ld() && z)) {
                                String mMString = (cVar.kKo.field_hadAlert == 0 && z) ? cVar.fhH.cte().getMMString(R.l.dQQ, cVar.fhH.csW().AX()) : z ? cVar.fhH.cte().getMMString(R.l.dQR, cVar.fhH.csW().AX()) : cVar.fhH.cte().getMMString(R.l.dQP, cVar.fhH.csW().AX());
                                cVar.poA = com.tencent.mm.ui.base.h.a(cVar.fhH.cte().getContext(), mMString, cVar.fhH.cte().getMMString(R.l.dGZ), new com.tencent.mm.ui.chatting.b.c.AnonymousClass14(z), new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        c.this.kKo.field_hadAlert = 1;
                                        com.tencent.mm.af.d dVar = c.this.kKo;
                                        if (dVar != null) {
                                            dVar.field_brandFlag &= -5;
                                            com.tencent.mm.af.f.g(dVar);
                                        }
                                        com.tencent.mm.af.y.Mu().kh(c.this.fhH.csn());
                                    }
                                });
                            } else {
                                com.tencent.mm.af.y.Mu().kh(cVar.fhH.csn());
                            }
                        }
                        if (cVar.kKo.Le() && !(cVar.fhH.csW().ciN() && com.tencent.mm.af.a.Lb())) {
                            com.tencent.mm.y.ak.a.hhv.Q(cVar.fhH.csW().field_username, "");
                            com.tencent.mm.ac.b.ja(cVar.fhH.csW().field_username);
                        }
                        if (cVar.kKo.field_status == 1) {
                            cVar.kKo.field_status = 0;
                            com.tencent.mm.af.y.Ml().e(cVar.kKo);
                        }
                    } else if (!(cVar.fhH.cte().getBooleanExtra("key_has_add_contact", false).booleanValue() || com.tencent.mm.k.a.ga(cVar.fhH.csW().field_type) || !cVar.fhH.csW().ciN())) {
                        ah.y(new Runnable() {
                            public final void run() {
                                if (!com.tencent.mm.k.a.ga(c.this.fhH.csW().field_type) && c.this.fhH.csW().ciN()) {
                                    c.this.fhH.cte().setMMSubTitle(R.l.dQO);
                                }
                            }
                        });
                    }
                    cVar.ctX();
                    this.yEP.cug();
                    as.getNotification().eq(csn());
                    MMAppMgr.uq();
                    if (yFf) {
                        yFf = false;
                        mT(true);
                    }
                    this.yEu.mV(true);
                    this.yEM.cub();
                    fVar = this.yEu;
                    if (com.tencent.mm.pluginsdk.q.a.viX != null) {
                        com.tencent.mm.pluginsdk.q.a.viX.a(fVar);
                    }
                    if (com.tencent.mm.pluginsdk.q.a.vje != null) {
                        com.tencent.mm.pluginsdk.q.a.vje.a(fVar);
                    }
                    if (com.tencent.mm.pluginsdk.q.a.vjf != null) {
                        com.tencent.mm.pluginsdk.q.a.vjf.a(fVar);
                    }
                    if (!com.tencent.mm.sdk.b.a.xmy.d(this.gBo)) {
                        com.tencent.mm.sdk.b.a.xmy.b(this.gBo);
                    }
                    aeVar = this.yyW;
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.VoiceImp", "summeranrt resetAutoPlay looper[%s]", Looper.myLooper());
                    currentTimeMillis = System.currentTimeMillis();
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.VoiceImp", "resetAutoPlay autoPlay is:%s tid:%d looper:%s", aeVar.yBy, Long.valueOf(Thread.currentThread().getId()), Looper.myLooper());
                    if (aeVar.yBy != null) {
                        aeVar.yBy = new d(aeVar.fhH, aeVar, aeVar.fhH.csW().field_username);
                        com.tencent.mm.modelvoice.r.c(aeVar.yBy);
                        com.tencent.mm.modelvoice.e.a(aeVar.yBy);
                    } else {
                        aeVar.yBy.ZG(aeVar.fhH.csW().field_username);
                    }
                    as.Hm();
                    z = bi.a((Boolean) com.tencent.mm.y.c.Db().get(16387, null), true);
                    dVar = aeVar.yBy;
                    if (!dVar.yza) {
                        dVar.yyY = z;
                        dVar.crQ();
                    }
                    if (aeVar.fhH.ctb() != null) {
                        bK = aeVar.fhH.ctb().bK(false);
                        if (bK != null) {
                            if (bK.hqe != null) {
                                bK.hqt = bK.hqe.optInt("AudioPlayType", 0) != 1;
                            }
                            if (bK.hqt) {
                                aeVar.yBy.yyZ = false;
                            }
                        }
                    }
                    aeVar.fhH.ctm().yBy = aeVar.yBy;
                    aeVar.yBy.kIE = aeVar.kIH;
                    aeVar.yBy.bdX();
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.VoiceImp", "summeranrt resetAutoPlay end take[%s]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if (com.tencent.mm.y.s.he(aeVar.fhH.csn()) && com.tencent.mm.y.ak.a.hhy != null) {
                        com.tencent.mm.y.ak.a.hhy.a(aeVar.seU);
                    }
                    if (!com.tencent.mm.aq.b.PV()) {
                        aeVar.fhH.ctp().vxb = aeVar.yLx;
                    }
                    aeVar.cuT();
                    com.tencent.mm.modelvideo.o.Ub().a(this.yAM, as.Dt().oFY.getLooper());
                    aVar = this.yEv;
                    lnVar = new ln();
                    lnVar.fDI.fDJ = true;
                    com.tencent.mm.sdk.b.a.xmy.a(lnVar, Looper.getMainLooper());
                    com.tencent.mm.platformtools.j.b(aVar);
                }
            }
            z = false;
            if (z) {
                as.Dt().F(/* anonymous class already generated */);
            }
            if (!com.tencent.mm.k.a.ga(cVar.fhH.csW().field_type)) {
            }
            ah.y(/* anonymous class already generated */);
            cVar.ctX();
            this.yEP.cug();
            as.getNotification().eq(csn());
            MMAppMgr.uq();
            if (yFf) {
                yFf = false;
                mT(true);
            }
            this.yEu.mV(true);
            this.yEM.cub();
            fVar = this.yEu;
            if (com.tencent.mm.pluginsdk.q.a.viX != null) {
                com.tencent.mm.pluginsdk.q.a.viX.a(fVar);
            }
            if (com.tencent.mm.pluginsdk.q.a.vje != null) {
                com.tencent.mm.pluginsdk.q.a.vje.a(fVar);
            }
            if (com.tencent.mm.pluginsdk.q.a.vjf != null) {
                com.tencent.mm.pluginsdk.q.a.vjf.a(fVar);
            }
            if (com.tencent.mm.sdk.b.a.xmy.d(this.gBo)) {
                com.tencent.mm.sdk.b.a.xmy.b(this.gBo);
            }
            aeVar = this.yyW;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.VoiceImp", "summeranrt resetAutoPlay looper[%s]", Looper.myLooper());
            currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.VoiceImp", "resetAutoPlay autoPlay is:%s tid:%d looper:%s", aeVar.yBy, Long.valueOf(Thread.currentThread().getId()), Looper.myLooper());
            if (aeVar.yBy != null) {
                aeVar.yBy.ZG(aeVar.fhH.csW().field_username);
            } else {
                aeVar.yBy = new d(aeVar.fhH, aeVar, aeVar.fhH.csW().field_username);
                com.tencent.mm.modelvoice.r.c(aeVar.yBy);
                com.tencent.mm.modelvoice.e.a(aeVar.yBy);
            }
            as.Hm();
            z = bi.a((Boolean) com.tencent.mm.y.c.Db().get(16387, null), true);
            dVar = aeVar.yBy;
            if (dVar.yza) {
                dVar.yyY = z;
                dVar.crQ();
            }
            if (aeVar.fhH.ctb() != null) {
                bK = aeVar.fhH.ctb().bK(false);
                if (bK != null) {
                    if (bK.hqe != null) {
                        if (bK.hqe.optInt("AudioPlayType", 0) != 1) {
                        }
                        bK.hqt = bK.hqe.optInt("AudioPlayType", 0) != 1;
                    }
                    if (bK.hqt) {
                        aeVar.yBy.yyZ = false;
                    }
                }
            }
            aeVar.fhH.ctm().yBy = aeVar.yBy;
            if (aeVar.kIH) {
            }
            aeVar.yBy.kIE = aeVar.kIH;
            aeVar.yBy.bdX();
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.VoiceImp", "summeranrt resetAutoPlay end take[%s]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            com.tencent.mm.y.ak.a.hhy.a(aeVar.seU);
            if (com.tencent.mm.aq.b.PV()) {
                aeVar.fhH.ctp().vxb = aeVar.yLx;
            }
            aeVar.cuT();
            com.tencent.mm.modelvideo.o.Ub().a(this.yAM, as.Dt().oFY.getLooper());
            aVar = this.yEv;
            lnVar = new ln();
            lnVar.fDI.fDJ = true;
            com.tencent.mm.sdk.b.a.xmy.a(lnVar, Looper.getMainLooper());
            com.tencent.mm.platformtools.j.b(aVar);
        }

        public void onResume() {
            if (getWindow() != null) {
                getWindow().setBackgroundDrawableResource(R.e.btF);
            }
            List arrayList = new ArrayList(this.yFa);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                b bVar = (b) arrayList.get(i2);
                if (bVar != null) {
                    bVar.ctN();
                }
                i = i2 + 1;
            }
            boolean isShown = getContentView() != null ? getContentView().isShown() : false;
            boolean isShown2 = getView() != null ? getView().isShown() : false;
            if (ctD()) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onResume fragment not foreground, return,  chatting contentview is show %b, viewShow %b", Boolean.valueOf(isShown), Boolean.valueOf(isShown2));
                super.onResume();
                this.yEx.cuL();
            } else if (as.Hp()) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "ashutest::onResume %d,  chatting is show %b, viewShow %b", Integer.valueOf(hashCode()), Boolean.valueOf(isShown), Boolean.valueOf(isShown2));
                long currentTimeMillis = System.currentTimeMillis();
                this.yEK.cub();
                Object obj = this.yEJ;
                com.tencent.mm.plugin.bbom.q.a(obj.yKA);
                obj.yKD = new com.tencent.mm.ui.chatting.g.d(obj);
                obj.yKC = new com.tencent.mm.ui.chatting.g.c(obj);
                obj.yKB = new com.tencent.mm.ui.chatting.g.b(obj);
                if (this.yAM != null) {
                    com.tencent.mm.pluginsdk.ui.d.i.a(this.yAM.yyB);
                }
                super.onResume();
                com.tencent.mm.ui.chatting.b.x xVar = this.yEx;
                xVar.yKu = null;
                if (!com.tencent.mm.y.q.FY().equals(xVar.fhH.csn()) && ((xVar.fhH.csS() && xVar.fhH.csW().fXi == 0) || !com.tencent.mm.protocal.d.vHm)) {
                    xVar.yKu = xVar.fhH.csn();
                    xVar.kBf = System.currentTimeMillis();
                    xVar.yKw = 0;
                    as.Dt().F(new com.tencent.mm.ui.chatting.b.x.AnonymousClass4(xVar.yKu));
                }
                com.tencent.mm.pluginsdk.wallet.i.CU(6);
                this.yFk = true;
                this.yFq.K(300000, 300000);
                af.VI("keep_chatting_silent" + csn());
                as.Hm();
                com.tencent.mm.y.c.Fh().a(this.yAM.yCh, Looper.getMainLooper());
                this.yAM.ffS = true;
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingListAdapter", "adapter resume");
                this.yAM.csy();
                obj = (this.yFu || this.yEG.yAH || this.yEG.yJr) ? null : 1;
                if (obj != null) {
                    this.yFu = true;
                    this.yFv = true;
                    if (this.yEG.yAH || this.yEG.yJr) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "From Show Search ChatResult %b, From Gloabl Search %b", Boolean.valueOf(this.yEG.yAH), Boolean.valueOf(this.yEG.yJr));
                    } else {
                        this.yFs = false;
                        this.yEX.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                            public final void onGlobalLayout() {
                                a.this.yEX.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                                a.this.yFt.run();
                            }
                        });
                    }
                }
                if (this.yAR) {
                    w wVar = this.yEw;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str = wVar.fhH.csW().field_username;
                    as.Hm();
                    ak XF = com.tencent.mm.y.c.Fk().XF(str);
                    if (XF != null) {
                        long j = XF.field_lastSeq;
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onResume filterSeq[%d], lastSeq[%d], undeliverCount[%d], chatRoomId[%s]", Long.valueOf(XF.field_firstUnDeliverSeq), Long.valueOf(j), Integer.valueOf(XF.field_UnDeliverCount), str);
                        if (j > 0) {
                            as.Hm();
                            cg H = com.tencent.mm.y.c.Fh().H(str, j);
                            if (H.field_msgId == 0 && H.field_msgSeq != j) {
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onResume need getChatRoomMsg up msg == null[%b] svrid[%d], msgseq[%d], take[%d]ms", Boolean.valueOf(false), Long.valueOf(H.field_msgSvrId), Long.valueOf(H.field_msgSeq), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                ah.y(new com.tencent.mm.ui.chatting.b.w.AnonymousClass5(str, r6, j, r10));
                            }
                        }
                    }
                }
                if (isSupportNavigationSwipeBack()) {
                    getSwipeBackLayout().mEnable = true;
                    getSwipeBackLayout().init();
                }
                if (this.ocy) {
                    crL();
                }
                com.tencent.mm.sdk.platformtools.x.v("Test", "KEVIN Chatting OnResume: diff:%d  rawUserName:%s ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), this.yAP);
                this.yEx.cuL();
                z zVar = this.yEN;
                if (com.tencent.mm.y.q.GG().booleanValue()) {
                    if (!zVar.fhH.csW().ciN()) {
                        as.Hm();
                        zVar.yKQ = bi.c((Boolean) com.tencent.mm.y.c.Db().get(340228, null));
                        if (!(zVar.yKQ || zVar.fhH.cti())) {
                            zVar.i(Boolean.valueOf(true));
                        }
                        as.Hm();
                        zVar.yKR = bi.c((Boolean) com.tencent.mm.y.c.Db().get(340229, null));
                        long currentTimeMillis3 = System.currentTimeMillis();
                        as.Hm();
                        currentTimeMillis3 -= bi.a((Long) com.tencent.mm.y.c.Db().get(340240, null), 0);
                        if (zVar.yKQ && !zVar.yKR && currentTimeMillis3 >= 259200000) {
                            zVar.i(Boolean.valueOf(false));
                        }
                    }
                    zVar.fhH.ctp().vxa = zVar.yKT;
                }
                f fVar = this.yEP;
                if (com.tencent.mm.y.s.gE(fVar.fhH.csn())) {
                    fVar.fhH.cte().addIconOptionMenu(0, R.l.dCy, R.k.dvn, Boolean.valueOf(com.tencent.mm.plugin.x.a.bfU().ij(com.tencent.mm.av.b.hJT)).booleanValue(), fVar.yHZ);
                }
            } else {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUI", "account not ready, mabey not call onDestroy!!!");
                finish();
                this.yEx.cuL();
            }
        }

        public boolean hideVKB() {
            if (this.yEM.ctp() != null) {
                return bi.hideVKB(this.yEM.ctp());
            }
            return super.hideVKB();
        }

        public void onPause() {
            List arrayList = new ArrayList(this.yFa);
            for (int i = 0; i < arrayList.size(); i++) {
                b bVar = (b) arrayList.get(i);
                if (bVar != null) {
                    bVar.ctM();
                }
            }
            p.dismiss();
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "on chatting ui pause  rawuser:%s", this.yAP);
            com.tencent.mm.sdk.b.b rvVar = new rv();
            rvVar.fKt.type = 1;
            com.tencent.mm.sdk.b.a.xmy.m(rvVar);
            if (this.yAM != null) {
                com.tencent.mm.pluginsdk.ui.d.i.b(this.yAM.yyB);
            }
            this.yEM.cuu();
            if (this.yAP == null) {
                super.onPause();
                return;
            }
            boolean isShown;
            if (getContentView() != null) {
                isShown = getContentView().isShown();
            } else {
                isShown = false;
            }
            if (ctD() || !(this.isCurrentActivity || this.yFk)) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onPause fragment not foreground, hasPause:%b, chattingShow:%b", Boolean.valueOf(this.yFk), Boolean.valueOf(isShown));
                super.onPause();
                return;
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onPause %d, chattingShow:%b", Integer.valueOf(hashCode()), Boolean.valueOf(isShown));
            super.onPause();
            this.yFk = false;
            this.yAM.ffS = false;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingListAdapter", "adapter pause");
            j jVar = this.yEH;
            if (jVar.fhH.ctp() != null) {
                if (jVar.fhH.ctp().ccH()) {
                    jVar.yIy = a.yIA;
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.SearchImp", "jacks mark refreshKeyBordState keybord state: show");
                } else {
                    jVar.yIy = a.yIz;
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.SearchImp", "jacks mark refreshKeyBordState keybord state: hide");
                }
                jVar.yIw = jVar.fhH.ctp().ccf();
            }
            this.yEt.stopSignalling();
            com.tencent.mm.ui.chatting.b.u uVar = this.yEG;
            if (uVar.yJy) {
                uVar.cuJ();
                if (uVar.fhH.cto() != null) {
                    uVar.fhH.cto().csG();
                }
            }
            ae aeVar = this.yyW;
            if (com.tencent.mm.y.s.he(aeVar.fhH.csn()) && com.tencent.mm.y.ak.a.hhy != null) {
                com.tencent.mm.y.ak.a.hhy.b(aeVar.seU);
            }
            if (aeVar.yLw != null && aeVar.yLw.getVisibility() == 0) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.VoiceImp", "doPause set voiceinputMask GONE");
                aeVar.yLw.setVisibility(8);
            }
            aeVar.fhH.ctp().vxb = null;
            as.Hm();
            com.tencent.mm.y.c.Db().set(26, Boolean.valueOf(aeVar.kIH));
            if (!(com.tencent.mm.ui.p.cnO() || aeVar.yBy == null)) {
                aeVar.yBy.crQ();
                aeVar.yBy.crV();
                aeVar.yBy.release();
            }
            rvVar = new sq();
            com.tencent.mm.sdk.b.a.xmy.m(rvVar);
            if (!(rvVar.fLh.fLk || com.tencent.mm.o.a.Bd())) {
                as.Hn().xQ();
            }
            this.yFq.TN();
            crP();
            as.getNotification().eq("");
            y yVar = this.yEJ;
            com.tencent.mm.plugin.bbom.q.b(yVar.yKA);
            if (yVar.yKB != null) {
                yVar.yKB.release();
                yVar.yKB = null;
            }
            if (yVar.yKC != null) {
                yVar.yKC.release();
                yVar.yKC = null;
            }
            if (yVar.yKD != null) {
                yVar.yKD.release();
                yVar.yKD = null;
            }
            as.Hm();
            com.tencent.mm.y.c.Fh().a(this.yAM.yCh);
            com.tencent.mm.modelvideo.o.Ub().a(this.yAM);
            com.tencent.mm.platformtools.j.a aVar = this.yEv;
            com.tencent.mm.platformtools.j.c(aVar);
            aVar.TN();
            af.VJ("keep_app_silent");
            af.VJ("keep_chatting_silent" + csn());
            crW();
            com.tencent.mm.pluginsdk.q.f fVar = this.yEu;
            if (com.tencent.mm.pluginsdk.q.a.viX != null) {
                com.tencent.mm.pluginsdk.q.a.viX.b(fVar);
            }
            if (com.tencent.mm.pluginsdk.q.a.vje != null) {
                com.tencent.mm.pluginsdk.q.a.vje.b(fVar);
            }
            if (com.tencent.mm.pluginsdk.q.a.vjf != null) {
                com.tencent.mm.pluginsdk.q.a.vjf.b(fVar);
            }
            com.tencent.mm.ui.chatting.b.c cVar = this.yEL;
            if (com.tencent.mm.k.a.ga(cVar.fhH.csW().field_type) && cVar.fhH.csW().ciN() && cVar.kKo != null) {
                com.tencent.mm.af.y.Mu().Me();
                if (cVar.poA != null) {
                    cVar.poA.dismiss();
                }
            }
            hideVKB();
            rvVar = new ln();
            rvVar.fDI.fDJ = false;
            com.tencent.mm.sdk.b.a.xmy.a(rvVar, Looper.getMainLooper());
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "chattingui cancel pause auto download logic");
            com.tencent.mm.sdk.b.a.xmy.c(this.gBo);
            aj.clear();
            com.tencent.mm.ui.chatting.b.x xVar = this.yEx;
            if (!TextUtils.isEmpty(xVar.yKu) && xVar.fhH.csS()) {
                xVar.yKv = System.currentTimeMillis();
                String str = xVar.yKu;
                xVar.yKu = "";
                as.Dt().F(new com.tencent.mm.ui.chatting.b.x.AnonymousClass5(str));
            }
            z zVar = this.yEN;
            if (!zVar.fhH.csW().ciN() && com.tencent.mm.y.q.GG().booleanValue()) {
                zVar.c(Boolean.valueOf(false), Boolean.valueOf(false));
            }
        }

        public final String ctz() {
            return getIdentString();
        }

        protected String getIdentString() {
            if (this.fBc == null || ((int) this.fBc.gKO) == 0 || bi.oN(this.fBc.field_username)) {
                return "";
            }
            String str;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "getIdentString %s", this.fBc.field_username);
            com.tencent.mm.ui.chatting.b.c cVar = this.yEL;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.BizMgr", "getIdentString %s", cVar.fhH.csW().field_username);
            if (as.Hp()) {
                if (com.tencent.mm.af.f.eG(cVar.fhH.csW().field_username)) {
                    str = "_EnterpriseChat";
                } else if (com.tencent.mm.af.f.ka(cVar.fhH.csW().field_username)) {
                    str = "_EnterpriseFatherBiz";
                } else if (com.tencent.mm.af.f.jZ(cVar.fhH.csW().field_username)) {
                    str = "_EnterpriseChildBiz";
                }
                if (str == null) {
                    return str;
                }
                if (com.tencent.mm.y.s.eX(this.fBc.field_username)) {
                    return "_chatroom";
                }
                if (com.tencent.mm.y.s.gB(this.fBc.field_username)) {
                    return "_bottle";
                }
                if (com.tencent.mm.y.s.gC(this.fBc.field_username)) {
                    return "";
                }
                return "_QQ";
            }
            str = cVar.fhH.csW().ciN() ? "_bizContact" : null;
            if (str == null) {
                return str;
            }
            if (com.tencent.mm.y.s.eX(this.fBc.field_username)) {
                return "_chatroom";
            }
            if (com.tencent.mm.y.s.gB(this.fBc.field_username)) {
                return "_bottle";
            }
            if (com.tencent.mm.y.s.gC(this.fBc.field_username)) {
                return "";
            }
            return "_QQ";
        }

        public void onKeyboardStateChanged() {
            if (keyboardState() == 1) {
                this.yEX.post(new Runnable() {
                    public final void run() {
                        a.this.a(true, false, null);
                    }
                });
            }
        }

        public final boolean ctA() {
            if (isScreenEnable()) {
                goBack();
            } else {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUI", "Actionbar customView onclick screen not enable");
            }
            return true;
        }

        public final void ctB() {
            if (this.yFm != null) {
                if (this.yFm.yBT) {
                    showOptionMenu(false);
                } else {
                    crN();
                }
            }
            this.yyW.cuT();
        }

        public void crN() {
            f fVar = this.yEP;
            if (fVar.yEG.yJp || fVar.yEG.yAH) {
                fVar.fhH.cte().showOptionMenu(false);
                return;
            }
            if (com.tencent.mm.y.s.gE(fVar.fhH.csn())) {
                fVar.fhH.cte().addIconOptionMenu(0, R.l.dCy, R.k.dvn, Boolean.valueOf(com.tencent.mm.plugin.x.a.bfU().ij(com.tencent.mm.av.b.hJT)).booleanValue(), fVar.yHZ);
            } else if (com.tencent.mm.y.s.gL(fVar.fhH.csn())) {
                fVar.fhH.cte().addIconOptionMenu(0, R.l.dCy, R.k.dvn, fVar.yHZ);
                com.tencent.mm.plugin.report.service.g.pWK.k(10071, "1");
            } else if (com.tencent.mm.y.s.gM(fVar.fhH.csn())) {
                fVar.fhH.cte().addIconOptionMenu(0, R.l.dCy, R.k.dvn, fVar.yHZ);
            } else if (com.tencent.mm.y.s.hl(fVar.fhH.csn())) {
                fVar.fhH.cte().addIconOptionMenu(0, R.l.dCy, R.k.dvn, fVar.yHZ);
            } else if (com.tencent.mm.y.s.hq(fVar.fhH.csn())) {
                if (com.tencent.mm.y.s.gX(fVar.fhH.csn())) {
                    fVar.fhH.cte().showOptionMenu(false);
                    return;
                }
                fVar.fhH.cte().addIconOptionMenu(0, R.l.dCy, R.k.dvn, fVar.yHZ);
            } else if (x.Xd(fVar.fhH.csn()) || x.Xf(fVar.fhH.csn()) || x.gB(fVar.fhH.csn())) {
                fVar.fhH.cte().addIconOptionMenu(0, R.l.dSN, R.k.dvk, fVar.yHZ);
            } else if (fVar.fhH.csX() && com.tencent.mm.ui.chatting.b.g.ZP(fVar.fhH.csn())) {
                fVar.fhH.cte().addIconOptionMenu(0, R.l.dSN, R.k.dzK, fVar.yHZ);
            } else if (!fVar.fhH.csn().endsWith("@chatroom") && !fVar.yEL.vus) {
                if (!(!(1 == bi.getInt(com.tencent.mm.j.g.Af().getValue("VOIPShowInChat"), 0)) || com.tencent.mm.y.s.gI(fVar.fhH.csn()) || fVar.fhH.csn().endsWith("@chatroom") || x.Xd(fVar.fhH.csn()) || x.Xf(fVar.fhH.csn()) || x.gB(fVar.fhH.csn()))) {
                    if (1 == bi.getInt(com.tencent.mm.j.g.Af().getValue("VOIPCallType"), 0)) {
                        fVar.fhH.cte().addIconOptionMenu(2, R.l.dTA, R.k.dvo, fVar.yIf);
                    } else {
                        fVar.fhH.cte().addIconOptionMenu(1, R.l.dTB, R.k.dvp, fVar.yIf);
                    }
                }
                fVar.fhH.cte().addIconOptionMenu(0, R.l.dSN, R.k.dvk, fVar.yHZ);
            } else if (fVar.fhH.cti()) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.ChattingHeadereMgr", "cpan show chatroom right btn");
                fVar.fhH.cte().addIconOptionMenu(0, R.l.dSN, R.k.dvc, fVar.yHZ);
                fVar.fhH.cte().showOptionMenu(true);
            } else if (!fVar.yEL.vus || fVar.yEL.yHs) {
                fVar.fhH.cte().showOptionMenu(false);
                return;
            } else {
                fVar.fhH.cte().addIconOptionMenu(0, R.l.dSN, R.k.dvk, fVar.yHZ);
                fVar.fhH.cte().showOptionMenu(true);
            }
            if (x.gB(fVar.fhH.csn())) {
                fVar.fhH.cte().showOptionMenu(2, true);
            } else {
                fVar.fhH.cte().showOptionMenu(true);
            }
        }

        public final int ctC() {
            return this.yEP.cuo();
        }

        protected void crO() {
            this.yEX = (ListView) findViewById(R.h.bUi);
            this.yEX.setVisibility(0);
            this.yi = 0;
            this.otm = (MMPullDownView) findViewById(R.h.bUR);
            this.otm.ylo = false;
            this.otm.mx(false);
            this.otm.ykU = new MMPullDownView.g() {
                public final boolean azU() {
                    boolean z;
                    int count;
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "summerbadcr onTopLoadData isChatroomChat[%b], talker[%s]", Boolean.valueOf(a.this.yAR), a.this.fBc.field_username);
                    if (a.this.yEG.yAH || a.this.yEG.yJu || a.this.yEG.yJr) {
                        a.this.yAM.yBQ = true;
                    }
                    a.this.yAM.yBW = true;
                    int count2 = a.this.yAM.getCount();
                    boolean csA = a.this.yAM.csA();
                    w wVar = a.this.yEw;
                    if (wVar.fhH.csS()) {
                        au auVar = (au) wVar.fhH.ctm().getItem(0);
                        if (auVar == null || auVar.field_msgId == 0) {
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onTopLoadData firstMsgInfo is null");
                        } else {
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onTopLoadData check fault[%d, %d, %d, %d, %d, %d, %d, %s]", Integer.valueOf(auVar.field_flag), Integer.valueOf(auVar.field_isSend), Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), Long.valueOf(auVar.field_msgSeq), Long.valueOf(auVar.field_createTime), Integer.valueOf(auVar.getType()), auVar.field_talker);
                            as.Hm();
                            if ((com.tencent.mm.y.c.Fh().H(auVar.field_talker, auVar.field_msgSeq).field_flag & 1) == 0) {
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onTopLoadData check fault found in cache but db is not[%d, %d, %d, %d, %d, %d, %d, %s] notify", Integer.valueOf(com.tencent.mm.y.c.Fh().H(auVar.field_talker, auVar.field_msgSeq).field_flag), Integer.valueOf(com.tencent.mm.y.c.Fh().H(auVar.field_talker, auVar.field_msgSeq).field_isSend), Long.valueOf(com.tencent.mm.y.c.Fh().H(auVar.field_talker, auVar.field_msgSeq).field_msgId), Long.valueOf(com.tencent.mm.y.c.Fh().H(auVar.field_talker, auVar.field_msgSeq).field_msgSvrId), Long.valueOf(com.tencent.mm.y.c.Fh().H(auVar.field_talker, auVar.field_msgSeq).field_msgSeq), Long.valueOf(com.tencent.mm.y.c.Fh().H(auVar.field_talker, auVar.field_msgSeq).field_createTime), Integer.valueOf(com.tencent.mm.y.c.Fh().H(auVar.field_talker, auVar.field_msgSeq).getType()), com.tencent.mm.y.c.Fh().H(auVar.field_talker, auVar.field_msgSeq).field_talker);
                                wVar.fhH.ctm().csy();
                            } else if (!((auVar.field_flag & 1) == 0 || (auVar.field_flag & 4) == 0)) {
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onTopLoadData check fault found");
                                wVar.fhH.ctm().mM(true);
                                as.Dt().F(new com.tencent.mm.ui.chatting.b.w.AnonymousClass12(auVar));
                                z = true;
                                if (z) {
                                    return false;
                                }
                                if (a.this.yEw.yJV) {
                                    a.this.yEw.yJV = false;
                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "summerbadcr silenceMsgImp.skipNextTopLoad is true");
                                    return true;
                                } else if (csA) {
                                    a.this.yAM.FO(18);
                                    a.this.yAM.csz();
                                    count = a.this.yAM.getCount();
                                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "onTopLoadData talker[%s], nowCount:%d, preCount:%d", a.this.fBc.field_username, Integer.valueOf(count), Integer.valueOf(count2));
                                    if (count > count2) {
                                        count -= count2;
                                        a.this.yAM.FP(count);
                                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "pullDownView nowCount > preCount on set position %d, set pullDownView.getTopHeight() %d", Integer.valueOf(count + 1), Integer.valueOf(a.this.yEP.cuo() + a.this.otm.ykW));
                                        com.tencent.mm.ui.chatting.b.t.a(a.this.yEX, count + 1, a.this.yEP.cuo() + a.this.otm.ykW, false);
                                    }
                                    return true;
                                } else {
                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "pullDownView showTopAll on set position %d, set pullDownView.getTopHeight() %d", Integer.valueOf(1), Integer.valueOf(a.this.otm.ykW));
                                    com.tencent.mm.ui.chatting.b.t.a(a.this.yEX, 1, a.this.otm.ykW, false);
                                    a.this.otm.mt(true);
                                    return true;
                                }
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        return false;
                    }
                    if (a.this.yEw.yJV) {
                        a.this.yEw.yJV = false;
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "summerbadcr silenceMsgImp.skipNextTopLoad is true");
                        return true;
                    } else if (csA) {
                        a.this.yAM.FO(18);
                        a.this.yAM.csz();
                        count = a.this.yAM.getCount();
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "onTopLoadData talker[%s], nowCount:%d, preCount:%d", a.this.fBc.field_username, Integer.valueOf(count), Integer.valueOf(count2));
                        if (count > count2) {
                            count -= count2;
                            a.this.yAM.FP(count);
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "pullDownView nowCount > preCount on set position %d, set pullDownView.getTopHeight() %d", Integer.valueOf(count + 1), Integer.valueOf(a.this.yEP.cuo() + a.this.otm.ykW));
                            com.tencent.mm.ui.chatting.b.t.a(a.this.yEX, count + 1, a.this.yEP.cuo() + a.this.otm.ykW, false);
                        }
                        return true;
                    } else {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "pullDownView showTopAll on set position %d, set pullDownView.getTopHeight() %d", Integer.valueOf(1), Integer.valueOf(a.this.otm.ykW));
                        com.tencent.mm.ui.chatting.b.t.a(a.this.yEX, 1, a.this.otm.ykW, false);
                        a.this.otm.mt(true);
                        return true;
                    }
                }
            };
            this.otm.ykV = new MMPullDownView.e() {
                public final boolean azR() {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "summerbadcr onBottomLoadData isChatroomChat[%b], needCheckHistoryTips[%b]", Boolean.valueOf(a.this.yAR), Boolean.valueOf(a.this.yEw.yJR));
                    if (a.this.yEG.yAH || a.this.yEG.yJu) {
                        a.this.yAM.yBR = true;
                    }
                    a.this.yAM.yBW = false;
                    if (a.this.yAR && a.this.yEw.yJR) {
                        return false;
                    }
                    if (a.this.yAM.csB()) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "pullDownView showButtomAll on set position %d", Integer.valueOf(a.this.yAM.getCount() - 1));
                        a.this.yEX.setSelection(a.this.yAM.getCount() - 1);
                        a.this.otm.mu(true);
                        return true;
                    }
                    int count = a.this.yAM.getCount();
                    a.this.yAM.a(null);
                    if (a.this.yAM.getCount() > count) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "pullDownView height: " + a.this.otm.getHeight() + ", chatHistoryList height: " + a.this.yEX.getHeight() + " header height: " + a.this.yEP.cuo() + " topHeight: " + a.this.otm.ykW);
                        com.tencent.mm.ui.chatting.b.t.a(a.this.yEX, count + 1, (a.this.yEX.getHeight() - a.this.yEP.cuo()) - a.this.otm.ykW, false);
                    }
                    return true;
                }
            };
            this.otm.mw(true);
            this.otm.ylg = new MMPullDownView.c() {
                public final boolean azT() {
                    View childAt = a.this.yEX.getChildAt(a.this.yEX.getChildCount() - 1);
                    if (childAt == null) {
                        return true;
                    }
                    if (childAt.getBottom() > a.this.yEX.getHeight() || a.this.yEX.getLastVisiblePosition() != a.this.yEX.getAdapter().getCount() - 1) {
                        return false;
                    }
                    return true;
                }
            };
            this.otm.ylh = new MMPullDownView.d() {
                public final boolean azS() {
                    View childAt = a.this.yEX.getChildAt(a.this.yEX.getFirstVisiblePosition());
                    return childAt != null && childAt.getTop() == 0;
                }
            };
            this.otm.ylz = new com.tencent.mm.ui.base.MMPullDownView.b() {
                public final void aFP() {
                }
            };
            this.otm.mu(true);
            this.otm.mv(this.yEG.yAH);
            this.otm.my(false);
            this.yEX.setOnScrollListener(new OnScrollListener() {
                public final void onScrollStateChanged(AbsListView absListView, int i) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "onScrollStateChanged mScrollState=%d, scrollState=%d", Integer.valueOf(a.this.yi), Integer.valueOf(i));
                    a.this.yi = i;
                    q qVar = a.this.yAM;
                    a aVar = a.this;
                    if (i == 0) {
                        w wVar = aVar.yEw;
                        View childAt = wVar.fhH.ctl().getChildAt(wVar.fhH.ctl().getFirstVisiblePosition());
                        com.tencent.mm.sdk.b.b rvVar;
                        if (childAt == null || childAt.getTop() != 0) {
                            try {
                                if (wVar.fhH.csS() && wVar.fhH.ctl().getChildAt(wVar.fhH.ctl().getChildCount() - 1) != null && wVar.fhH.ctl().getLastVisiblePosition() == wVar.fhH.ctl().getAdapter().getCount() - 1) {
                                    cg cgVar;
                                    cg cgVar2 = null;
                                    for (int i2 = 1; i2 < 5; i2++) {
                                        cgVar2 = (au) wVar.fhH.ctm().getItem(wVar.fhH.ctm().getCount() - i2);
                                        if (cgVar2 != null && cgVar2.field_msgId != 0 && (cgVar2.field_flag & 1) != 0) {
                                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr handleScrollChange bottom check fault found i[%s]", Integer.valueOf(i2));
                                            cgVar = cgVar2;
                                            break;
                                        }
                                    }
                                    cgVar = cgVar2;
                                    if (cgVar == null || cgVar.field_msgId == 0) {
                                        if ((((cgVar.field_flag & 2) != 0 ? 1 : 0) & (cgVar != null ? 1 : 0)) != 0) {
                                            as.Hm();
                                            cgVar2 = com.tencent.mm.y.c.Fh().Fd(cgVar.field_talker);
                                            if (!(cgVar2 == null || cgVar2.field_msgId == 0 || cgVar2.field_createTime <= cgVar.field_createTime)) {
                                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s] not need notify", Integer.valueOf(cgVar2.field_flag), Integer.valueOf(cgVar2.field_isSend), Long.valueOf(cgVar2.field_msgId), Long.valueOf(cgVar2.field_msgSvrId), Long.valueOf(cgVar2.field_msgSeq), Long.valueOf(cgVar2.field_createTime), Integer.valueOf(cgVar2.getType()), cgVar2.field_talker);
                                                wVar.fhH.ctm().csy();
                                            }
                                        }
                                    } else {
                                        cgVar2 = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().H(cgVar.field_talker, cgVar.field_msgSeq);
                                        if (cgVar2.field_msgId != 0 && cgVar2.field_msgId == cgVar.field_msgId && (cgVar2.field_flag & 1) == 0) {
                                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr handleScrollChange found msg not fault msgId[%s] flag[%s]", Long.valueOf(cgVar2.field_msgId), Integer.valueOf(cgVar2.field_flag));
                                            wVar.fhH.ctm().csy();
                                        } else {
                                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s]", Integer.valueOf(cgVar.field_flag), Integer.valueOf(cgVar.field_isSend), Long.valueOf(cgVar.field_msgId), Long.valueOf(cgVar.field_msgSvrId), Long.valueOf(cgVar.field_msgSeq), Long.valueOf(cgVar.field_createTime), Integer.valueOf(cgVar.getType()), cgVar.field_talker);
                                            if ((cgVar.field_flag & 1) != 0 && (cgVar.field_flag & 4) == 0) {
                                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr handleScrollChange forceBottomLoadData");
                                                wVar.fhH.ctn().mu(false);
                                                wVar.fhH.ctn().mv(true);
                                                wVar.fhH.ctn().my(true);
                                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr handleScrollChange bottom check fault found");
                                                wVar.fhH.ctm().mM(true);
                                                as.Dt().F(new com.tencent.mm.ui.chatting.b.w.AnonymousClass2(cgVar));
                                            }
                                        }
                                    }
                                }
                            } catch (Throwable e) {
                                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.ChattingUI", e, "silenceMsgImp handleIdelScrollChange", new Object[0]);
                            }
                            childAt = aVar.yEX.getChildAt(aVar.yEX.getFirstVisiblePosition());
                            if (childAt != null && childAt.getTop() == 0) {
                                aVar.otm.mx(true);
                            }
                            aVar.yEv.cuF();
                            rvVar = new rv();
                            rvVar.fKt.type = 5;
                            rvVar.fKt.fKu = aVar.yEX.getFirstVisiblePosition();
                            rvVar.fKt.fKv = aVar.yEX.getLastVisiblePosition();
                            rvVar.fKt.fKw = aVar.yEX.getHeaderViewsCount();
                            com.tencent.mm.sdk.b.a.xmy.m(rvVar);
                        } else {
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr handleScrollChange forceTopLoadData true");
                            if (wVar.fhH.csS()) {
                                au auVar = (au) wVar.fhH.ctm().getItem(0);
                                if (!(auVar == null || auVar.field_msgId == 0)) {
                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr handleScrollChange check fault[%d, %d, %d, %d, %d, %d, %d, %s]", Integer.valueOf(auVar.field_flag), Integer.valueOf(auVar.field_isSend), Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), Long.valueOf(auVar.field_msgSeq), Long.valueOf(auVar.field_createTime), Integer.valueOf(auVar.getType()), auVar.field_talker);
                                    if (!((auVar.field_flag & 1) == 0 || (auVar.field_flag & 4) == 0)) {
                                        wVar.fhH.ctn().mt(false);
                                    }
                                }
                            }
                            childAt = aVar.yEX.getChildAt(aVar.yEX.getFirstVisiblePosition());
                            aVar.otm.mx(true);
                            aVar.yEv.cuF();
                            rvVar = new rv();
                            rvVar.fKt.type = 5;
                            rvVar.fKt.fKu = aVar.yEX.getFirstVisiblePosition();
                            rvVar.fKt.fKv = aVar.yEX.getLastVisiblePosition();
                            rvVar.fKt.fKw = aVar.yEX.getHeaderViewsCount();
                            com.tencent.mm.sdk.b.a.xmy.m(rvVar);
                        }
                    }
                    if (i == 2) {
                        com.tencent.mm.bz.d.cmf().dh(ChattingUI.class.getName() + ".Listview", 4);
                        aVar.yEv.TN();
                    }
                    com.tencent.mm.ap.o.PG().bp(i);
                }

                public final synchronized void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (a.this.yFv) {
                        if (a.this.yEX.getLastVisiblePosition() == i3 - 1) {
                            a.this.yFv = false;
                        }
                    }
                    w wVar = a.this.yEw;
                    if (wVar.yJQ && i3 - i == (wVar.yJS << 1)) {
                        wVar.yJQ = false;
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr set dealHistoryGetMsg %b firstVisibleItem: %d, totalItemCount:%d mUnreadMessageBeforeCheckHistory:%d", Boolean.valueOf(wVar.yJQ), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(wVar.yJS));
                    }
                    if (a.this.yER > 0 && i3 - (i + 1) >= a.this.yER && a.this.yES != null && a.this.yES.getVisibility() == 0) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "summerbadcr jacks onScroll dismissGoBackToHistory mUnreadMessage[%d] [%d,%d]", Integer.valueOf(a.this.yER), Integer.valueOf(i3), Integer.valueOf(i));
                        a.this.ctI();
                    }
                }
            });
            if (this.yAM == null) {
                au auVar = new au();
                String csn = csn();
                ctj();
                this.yAM = new q(this, auVar, csn);
                if (this.vwT) {
                    this.yAM.yBV = true;
                }
            }
            this.yAM.mb(true);
            this.yAM.lKV = this.handler;
            this.yAM.xQN = new com.tencent.mm.ui.o.a() {
                private int count = 0;

                public final void XE() {
                    if (a.this.ctD()) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onPostRset fragment not foreground, return");
                        return;
                    }
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "summerbadcr onPostReset needCheckHistoryTips[%b], BADCR_SCROLL_DELAY[%d]", Boolean.valueOf(a.this.yEw.yJR), Integer.valueOf(w.yJP));
                    if (a.this.yEU && com.tencent.mm.k.a.ga(a.this.fBc.field_type) && a.this.fBc.ciN()) {
                        a.this.yEU = false;
                        if (!com.tencent.mm.af.f.eG(a.this.csn())) {
                            com.tencent.mm.af.y.Mu().b(a.this.csn(), a.this.yAM.getCount() > 0 ? (au) a.this.yAM.getItem(a.this.yAM.getCount() - 1) : null);
                        }
                    }
                    a.this.yEv.cuF();
                    a.this.yEX.post(new Runnable() {
                        public final void run() {
                            com.tencent.mm.plugin.report.service.f.vS(13);
                        }
                    });
                    a.this.otm.mt(a.this.yAM.csA());
                    a.this.otm.mu(a.this.yAM.csB());
                    MMPullDownView g = a.this.otm;
                    MMPullDownView.e((ViewGroup) g.yli, 4);
                    MMPullDownView.e((ViewGroup) g.xNM, 4);
                    if (a.this.yAM.hLP - this.count > 0 && !a.this.yEG.yAH) {
                        boolean z;
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "ncnt > 0 && (!isShowSearchChatResult) scroll to last");
                        w wVar = a.this.yEw;
                        if (!wVar.yJR || w.yJP <= 0) {
                            z = false;
                        } else {
                            wVar.fhH.ctl().getViewTreeObserver().addOnGlobalLayoutListener(new com.tencent.mm.ui.chatting.b.w.AnonymousClass4(System.currentTimeMillis()));
                            z = true;
                        }
                        if (!z) {
                            a.this.a(false, false, null);
                        }
                    }
                    if (!a.this.yEG.yJr && a.this.yEG.yJu && !a.this.yFm.yBT && a.this.yAM.csx()) {
                        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ChattingUI", "useEditSearchMode && !chattingMoreHelper.inShowMode() && adapter.triggerMoveToLast()");
                        a.this.a(false, false, null);
                    }
                    if (a.this.keyboardState() == 1) {
                        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ChattingUI", "kbshown scroll to last");
                        a.this.a(true, false, null);
                    }
                    a aVar = a.this;
                    if (aVar.ctD() ? false : aVar.yFk) {
                        as.Dt().F(new Runnable() {
                            public final void run() {
                                long currentTimeMillis = System.currentTimeMillis();
                                a.this.crP();
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "ChattingUI writeOpLogAndMarkRead last : %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            }
                        });
                    }
                }

                public final void XF() {
                    if (a.this.ctD()) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onPreReset fragment not foreground, return");
                        return;
                    }
                    com.tencent.mm.plugin.report.service.f.vR(13);
                    this.count = a.this.yAM.hLP;
                }
            };
            this.yEP.cud();
            as.Hm();
            com.tencent.mm.storage.ae XF = com.tencent.mm.y.c.Fk().XF(this.fBc.field_username);
            if (XF == null || XF.field_UnDeliverCount == 0) {
                a(XF, false);
            } else if (this.yES != null) {
                this.yES.setVisibility(8);
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "summerbadcr not updateGoBacktoHistroyMessage initList UnDeliver:%d, UnRead:%d", Integer.valueOf(XF.field_UnDeliverCount), Integer.valueOf(XF.field_unReadCount));
            }
            if (this.yEX.getAdapter() == null) {
                this.yEX.setAdapter(this.yAM);
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "chatHistoryList.setAdapter");
            }
            if (this.yEG.yAH) {
                this.yEX.setTranscriptMode(0);
            } else {
                this.yEX.setTranscriptMode(1);
            }
            this.yEX.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    a.this.yFs = true;
                    if (a.this.yFg) {
                        a.this.yEM.ctp().p(0, -1, false);
                    }
                    return false;
                }
            });
            registerForContextMenu(this.yEX);
        }

        public final void mS(boolean z) {
            if (this.yAM != null) {
                this.yAM.mM(z);
            }
        }

        private static boolean ZL(String str) {
            return x.gB(str) || x.Xf(str) || x.Xd(str) || com.tencent.mm.y.s.gX(str);
        }

        public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
            if (!ctD()) {
                super.onCreateOptionsMenu(menu, menuInflater);
            }
        }

        public final boolean ctD() {
            return (this.hJu || this.isCurrentActivity) ? false : true;
        }

        protected final void ctE() {
            this.yEx.cuK();
            if (this.isCurrentActivity || !isSupportNavigationSwipeBack()) {
                ctH();
                return;
            }
            SwipeBackLayout swipeBackLayout = getSwipeBackLayout();
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SwipeBackLayout", "scrollToFinishActivity, Scrolling %B, hasTranslucent %B, hasCallPopOut %B", Boolean.valueOf(swipeBackLayout.zBF), Boolean.valueOf(swipeBackLayout.zFA), Boolean.valueOf(swipeBackLayout.zFB));
            if (!swipeBackLayout.czV()) {
                com.tencent.mm.ui.widget.l.aI(0.0f);
                swipeBackLayout.zBF = true;
                swipeBackLayout.zFB = false;
                int width = (swipeBackLayout.Iv.getWidth() + swipeBackLayout.zFx.getIntrinsicWidth()) + 10;
                com.tencent.mm.ui.mogic.a aVar = swipeBackLayout.zFv;
                aVar.Fj = swipeBackLayout.Iv;
                aVar.fu = -1;
                aVar.f(width, 0, 0, 0);
                swipeBackLayout.invalidate();
                if (swipeBackLayout.zFD != null) {
                    swipeBackLayout.zFD.onDrag();
                }
                com.tencent.mm.ui.widget.l.B(true, 0);
            }
            this.yEJ.yKF = HardCoderJNI.startPerformance(HardCoderJNI.hcQuitChattingEnable, HardCoderJNI.hcQuitChattingDelay, HardCoderJNI.hcQuitChattingCPU, HardCoderJNI.hcQuitChattingIO, HardCoderJNI.hcQuitChattingThr ? g.Dt().cgq() : 0, HardCoderJNI.hcQuitChattingTimeout, HardCoderJNI.SCENE_QUIT_CHATTING, HardCoderJNI.hcQuitChattingAction, "MicroMsg.ChattingUI.TextImp");
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.TextImp", "hardCoderExitChattingStart %s", Integer.valueOf(r11.yKF));
        }

        private void goBack() {
            if (hideVKB()) {
                ah.h(new Runnable() {
                    public final void run() {
                        a.this.ctF();
                    }
                }, 300);
            } else {
                ctF();
            }
        }

        public void onSwipeBack() {
            this.yEx.cuK();
            ctH();
            if (isSupportNavigationSwipeBack()) {
                getSwipeBackLayout().mEnable = false;
                if (this.yAM != null) {
                    this.yAM.mM(false);
                }
            }
        }

        public void onDragBegin() {
            if (isSupportNavigationSwipeBack() && this.yAM != null) {
                this.yAM.mM(true);
                this.yFg = false;
            }
        }

        public void onCancelDrag() {
            if (isSupportNavigationSwipeBack() && this.yAM != null) {
                this.yAM.mM(false);
                this.yFg = true;
            }
        }

        private void ctF() {
            aa aaVar = this.yEu;
            Runnable anonymousClass9 = new Runnable() {
                public final void run() {
                    a.this.ctE();
                }
            };
            if (com.tencent.mm.pluginsdk.q.a.vje == null || !com.tencent.mm.pluginsdk.q.a.vje.dl(aaVar.fhH.csW().field_username, aaVar.fhH.ctj())) {
                anonymousClass9.run();
            } else {
                com.tencent.mm.ui.base.h.a(aaVar.fhH.cte().getContext(), aaVar.fhH.cte().getMMString(R.l.eRA), aaVar.fhH.cte().getMMString(R.l.dGZ), true, new com.tencent.mm.ui.chatting.b.aa.AnonymousClass1(anonymousClass9), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        }

        public final boolean ctG() {
            if (this.yFm == null || !this.yFm.yBT) {
                return false;
            }
            if (this.yEG.yJy) {
                this.yEG.cuJ();
                this.yFm.csG();
            } else {
                this.yFm.csF();
            }
            return true;
        }

        private void ctH() {
            boolean z = true;
            boolean z2 = false;
            ctG();
            ab abVar = this.yEr;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TransformImp", "clear VoiceTransTextAct");
            abVar.cuO();
            if (abVar.yLh) {
                com.tencent.mm.sdk.b.b fgVar = new fg();
                fgVar.fvl.fvo = 3;
                com.tencent.mm.sdk.b.a.xmy.m(fgVar);
            }
            abVar = this.yEr;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TransformImp", "alvinluo hide transformText");
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    synchronized (ab.this) {
                        ab.yLg.clear();
                        ab.yLf.clear();
                    }
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TransformImp", "alvinluo unsetTransformFlag cost: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
            }, "UnsetTransformFlag");
            List arrayList = new ArrayList(this.yFa);
            for (int i = 0; i < arrayList.size(); i++) {
                b bVar = (b) arrayList.get(i);
                if (bVar != null) {
                    bVar.ctO();
                }
            }
            super.onStop();
            Intent intent;
            if (x.Xd(csn())) {
                intent = new Intent();
                intent.addFlags(67108864);
                com.tencent.mm.bl.d.b(getContext(), "tmessage", ".ui.TConversationUI", intent);
            } else if (getIntExtra("chat_from_scene", 0) == 4) {
                finish();
                return;
            } else if ((getIntExtra("chat_from_scene", 0) == 1 || getIntExtra("chat_from_scene", 0) == 3) && this.fBc != null && this.fBc.ciN() && this.yEL.kKo != null && this.yEL.kKo.Ll() && this.yEL.kKo.bK(false) != null && this.yEL.kKo.bK(false).LM() != null && !bi.oN(this.yEL.kKo.Ls())) {
                finish();
                return;
            } else if (this.vwT) {
                finish();
            } else if (!this.yFe) {
                if (this.isCurrentActivity) {
                    intent = new Intent(getContext(), LauncherUI.class);
                    intent.addFlags(67108864);
                    startActivity(intent);
                    overridePendingTransition(com.tencent.mm.ui.MMFragmentActivity.a.xSN, com.tencent.mm.ui.MMFragmentActivity.a.xSO);
                    finish();
                    return;
                } else if (thisActivity() instanceof LauncherUI) {
                    LauncherUI launcherUI = (LauncherUI) thisActivity();
                    if (launcherUI != null) {
                        if (!isSupportNavigationSwipeBack()) {
                            z2 = true;
                        }
                        launcherUI.closeChatting(z2);
                        return;
                    }
                    return;
                } else if (thisActivity() instanceof BaseConversationUI) {
                    BaseConversationUI baseConversationUI = (BaseConversationUI) thisActivity();
                    if (baseConversationUI != null) {
                        if (isSupportNavigationSwipeBack()) {
                            z = false;
                        }
                        baseConversationUI.closeChatting(z);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            finish();
        }

        public final void mT(boolean z) {
            a(z, Looper.myLooper() != Looper.getMainLooper(), null);
        }

        @Deprecated
        protected final void a(final boolean z, boolean z2, a aVar) {
            if (z2) {
                this.handler.postDelayed(new Runnable(null) {
                    public final void run() {
                        a.this.mU(z);
                    }
                }, 10);
            } else {
                mU(z);
            }
        }

        private void mU(boolean z) {
            int count = this.yEX.getCount() - 1;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "mFirstScroll : %s, last visible/adapter=%s/%s %s", Boolean.valueOf(this.yEY), Integer.valueOf(this.yEX.getLastVisiblePosition()), Integer.valueOf(count), Boolean.valueOf(z));
            this.yEY = false;
            if (this.yEX.getLastVisiblePosition() >= count - 1 || z) {
                int count2 = this.yAM.getCount();
                if (count2 <= 1 || !((au) this.yAM.getItem(count2 - 2)).isSystem()) {
                    com.tencent.mm.ui.chatting.b.t.a(this.yEX, count, true);
                    return;
                }
                com.tencent.mm.ui.chatting.b.t.a(this.yEX, count - 1, 0, false);
            }
        }

        protected int getForceOrientation() {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "getForceOrientation");
            return -1;
        }

        public boolean supportNavigationSwipeBack() {
            if (this.isCurrentActivity) {
                return false;
            }
            g.Dr();
            if (!com.tencent.mm.compatible.f.b.aK(((com.tencent.mm.kernel.b.h) g.Dn().CU()).gUt)) {
                return true;
            }
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUI", "Running on a Chromebook, so we not support swipeback and so on");
            return false;
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            int i2 = false;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "chatting onKeyDown, code:%d action:%d", Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getAction()));
            if (keyEvent.getKeyCode() == 4) {
                if (ctD()) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onKeyDown back key fragment not foreground");
                    return false;
                } else if (isSupportNavigationSwipeBack() && getSwipeBackLayout().czU()) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUI", "ashutest::onKeyDown back ScrollToFinishing");
                    return true;
                } else {
                    if (keyEvent.getAction() == 0) {
                        this.mHasBackOnKeyDown = true;
                        this.mBackOnKeyDownTS = System.currentTimeMillis();
                    }
                    if (keyEvent.getAction() == 1) {
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "hasBack %B, %d", Boolean.valueOf(this.mHasBackOnKeyDown), Long.valueOf(System.currentTimeMillis() - this.mBackOnKeyDownTS));
                        if (!this.mHasBackOnKeyDown || System.currentTimeMillis() - this.mBackOnKeyDownTS > 30000) {
                            return true;
                        }
                        this.yFy = true;
                        if (this.yFm == null || !this.yFm.yBT) {
                            if (this.yEM.ctp() == null || !this.yEM.ctp().ccA()) {
                                goBack();
                            } else {
                                this.yEM.ctp().p(2, 23, false);
                            }
                        } else if (this.yEG.yJy) {
                            this.yEG.cuJ();
                            this.yFm.csG();
                        } else {
                            this.yFm.csF();
                        }
                    }
                    return true;
                }
            } else if (keyEvent.getKeyCode() == 67 && ctD()) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onKeyDown back key fragment not foreground");
                return false;
            } else {
                j jVar = this.yEH;
                if (keyEvent.getKeyCode() == 67) {
                    ChatFooter ctp;
                    if (keyEvent.getAction() == 0) {
                        char c;
                        ctp = jVar.fhH.ctp();
                        int selectionStart = ctp.oqa.getSelectionStart();
                        if (selectionStart <= 0) {
                            c = 'x';
                        } else {
                            c = ctp.ccf().charAt(selectionStart - 1);
                        }
                        if (c == 8197) {
                            jVar.yIv = true;
                        } else {
                            jVar.yIv = false;
                        }
                    }
                    if (keyEvent.getAction() == 1 && jVar.yIv) {
                        jVar.yIv = false;
                        ctp = jVar.fhH.ctp();
                        int selectionStart2 = ctp.oqa.getSelectionStart();
                        String substring = ctp.ccf().substring(0, selectionStart2);
                        int lastIndexOf = substring.lastIndexOf(64);
                        if (lastIndexOf < substring.length() && lastIndexOf >= 0) {
                            substring = substring.substring(0, lastIndexOf);
                            String substring2 = ctp.ccf().substring(selectionStart2);
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(substring).append(substring2);
                            ctp.Td(stringBuilder.toString());
                            ctp.oqa.setSelection(lastIndexOf);
                        }
                    }
                }
                com.tencent.mm.ui.chatting.b.c cVar = this.yEL;
                if (keyEvent.getKeyCode() == 82 && keyEvent.getAction() == 1 && (cVar.kKo == null || cVar.kKo.bK(false) == null || cVar.kKo.bK(false).LK() == null || cVar.kKo.bK(false).LK().hqO == null || cVar.kKo.bK(false).LK().hqO.isEmpty())) {
                    cVar.fhH.ctp().cca();
                }
                if (ctD()) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onKeyDown fragment not foreground");
                    return false;
                }
                ae aeVar = this.yyW;
                if (i == 25 && aeVar.yBy != null && aeVar.yBy.isPlaying() && (aeVar.kIH || !aeVar.yBy.kIE)) {
                    if (keyEvent.getAction() == 0) {
                        if (as.Hn().xS() && !as.Hn().xY()) {
                            i2 = as.Hn().ye();
                        }
                        as.Hn().fA(i2);
                    }
                    i2 = 1;
                } else if (i == 24 && aeVar.yBy != null && aeVar.yBy.isPlaying() && (aeVar.kIH || !aeVar.yBy.kIE)) {
                    if (keyEvent.getAction() == 0) {
                        if (as.Hn().xS() && !as.Hn().xY()) {
                            i2 = as.Hn().ye();
                        }
                        as.Hn().fz(i2);
                    }
                    i2 = 1;
                }
                if (i2 != 0) {
                    return true;
                }
                return super.onKeyDown(i, keyEvent);
            }
        }

        public boolean onKeyUp(int i, KeyEvent keyEvent) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "chatting ui fragment on key up, %d, %s", Integer.valueOf(i), keyEvent);
            return super.onKeyUp(i, keyEvent);
        }

        public final void a(final com.tencent.mm.storage.ae aeVar, boolean z) {
            this.yES = findViewById(R.h.bUg);
            if (this.yES != null) {
                if (this.yEw != null) {
                    this.yEw.yJT = -1;
                }
                com.tencent.mm.af.a.a aVar = null;
                if (this.yEL.vus) {
                    aVar = com.tencent.mm.af.y.Mo().aT(this.yEL.ctW());
                }
                if (!(aeVar == null && aVar == null) && (!(ZL(this.fBc.field_username) || com.tencent.mm.y.s.ho(this.fBc.field_username) || com.tencent.mm.y.s.gI(this.fBc.field_username) || com.tencent.mm.y.s.hj(this.fBc.field_username) || com.tencent.mm.y.s.gL(this.fBc.field_username)) || this.yAR || this.yEL.vus || ctK())) {
                    if (this.yEL.vus && aVar != null) {
                        this.yER = aVar.field_unReadCount;
                    } else if (aeVar != null) {
                        this.yER = aeVar.field_unReadCount;
                    } else {
                        this.yES.setVisibility(8);
                        return;
                    }
                    int i = this.yER;
                    if (z && aeVar != null && aeVar.field_UnDeliverCount > 0) {
                        i += aeVar.field_UnDeliverCount;
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "summerbadcr updateGoBacktoHistroyMessage mUnreadMessage fixUnreadMessage[%d, %d]", Integer.valueOf(i), Integer.valueOf(this.yER));
                        this.yEw.yJS = this.yER;
                    }
                    int i2 = i;
                    if (i2 >= (ctK() ? 5 : 10)) {
                        this.yES.setVisibility(0);
                        this.yET = (TextView) findViewById(R.h.bUh);
                        com.tencent.mm.booter.z zVar = com.tencent.mm.booter.z.gAC;
                        if (zVar.gAG == null) {
                            zVar.gAH = 1;
                        } else {
                            zVar.gAG.gAY = 1;
                        }
                        if (i2 > 999) {
                            this.yET.setText(String.format(getMMString(R.l.dRt), new Object[]{Integer.valueOf(999)}));
                        } else {
                            this.yET.setText(String.format(getMMString(R.l.dRt), new Object[]{Integer.valueOf(i2)}));
                        }
                        if (this.yEL.vus) {
                            as.Hm();
                            i = com.tencent.mm.y.c.Fi().as(this.fBc.field_username, this.yEL.ctW()) - this.yER;
                        } else {
                            as.Hm();
                            i = com.tencent.mm.y.c.Fh().Fs(this.fBc.field_username) - this.yER;
                            w wVar = this.yEw;
                            as.Hm();
                            wVar.yJT = com.tencent.mm.y.c.Fh().Fs(this.fBc.field_username);
                        }
                        this.yES.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                com.tencent.mm.booter.z zVar = com.tencent.mm.booter.z.gAC;
                                if (zVar.gAG != null) {
                                    zVar.gAG.gAY = 2;
                                }
                                if (aeVar == null || aeVar.field_UnDeliverCount <= 0) {
                                    a.this.ag(i, false);
                                    return;
                                }
                                w wVar = a.this.yEw;
                                ak akVar = aeVar;
                                int l = a.this.yER;
                                int i = i;
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr mGoBackToHistryMsgLayout Unread[%d] UnDeliver[%d] pos[%d]", Integer.valueOf(l), Integer.valueOf(akVar.field_UnDeliverCount), Integer.valueOf(i));
                                if (akVar.field_UnDeliverCount <= 0) {
                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr mGoBackToHistryMsgLayout undeliverCount[%d] less then one scene do normal", Integer.valueOf(r4));
                                } else {
                                    l = (int) akVar.field_firstUnDeliverSeq;
                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr mGoBackToHistryMsgLayout undeliverCount[%d] need get firstSeq[%d]", Integer.valueOf(r4), Integer.valueOf(l));
                                    if (l > 0) {
                                        as.Dt().F(new com.tencent.mm.ui.chatting.b.w.AnonymousClass3(l, akVar));
                                        return;
                                    }
                                }
                                wVar.fhH.ag(i, false);
                            }
                        });
                        this.yES.post(new Runnable() {
                            public final void run() {
                                if (a.this.yEu.yKW != null && a.this.yEu.yKW.getVisibility() == 0) {
                                    a.this.FT(1);
                                } else if (a.o(a.this)) {
                                    a.this.FT(3);
                                } else {
                                    a.this.FT(0);
                                }
                                Animation translateAnimation = new TranslateAnimation((float) a.this.yES.getWidth(), 0.0f, 0.0f, 0.0f);
                                translateAnimation.setDuration(300);
                                translateAnimation.setInterpolator(AnimationUtils.loadInterpolator(a.this.getContext(), 17432581));
                                a.this.yES.startAnimation(translateAnimation);
                                translateAnimation.setAnimationListener(new AnimationListener() {
                                    public final void onAnimationStart(Animation animation) {
                                        a.this.yES.setClickable(false);
                                    }

                                    public final void onAnimationRepeat(Animation animation) {
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                        a.this.yES.setClickable(true);
                                    }
                                });
                            }
                        });
                        return;
                    }
                }
                this.yES.setVisibility(8);
            }
        }

        public final void ctI() {
            if (this.yES != null) {
                this.yER = -1;
                if (this.yES.getVisibility() == 0) {
                    Animation translateAnimation = new TranslateAnimation(0.0f, (float) this.yES.getWidth(), 0.0f, 0.0f);
                    translateAnimation.setDuration(300);
                    translateAnimation.setInterpolator(AnimationUtils.loadInterpolator(getContext(), 17432581));
                    this.yES.startAnimation(translateAnimation);
                }
                this.yES.setVisibility(8);
            }
        }

        public final void FT(int i) {
            if (this.yER >= (ctK() ? 5 : 10) && this.yES != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.yES.getLayoutParams();
                switch (i) {
                    case -2:
                        if (this.yEu.yKW == null || this.yEu.yKW.getVisibility() != 0) {
                            layoutParams.setMargins(0, getMMResources().getDimensionPixelSize(R.f.bvw), 0, 0);
                            return;
                        }
                        return;
                    case 0:
                        layoutParams.setMargins(0, getMMResources().getDimensionPixelSize(R.f.bvw), 0, 0);
                        return;
                    case 1:
                        int i2;
                        int i3;
                        if (this.yEu.yKW == null || this.yEu.yKW.getVisibility() != 0) {
                            i2 = 0;
                        } else {
                            i2 = this.yEu.yKW.getHeight();
                        }
                        if (this.yEu.yKX == null || this.yEu.yKX.getVisibility() != 0) {
                            i3 = 0;
                        } else {
                            i3 = getMMResources().getDimensionPixelSize(R.f.bvH);
                        }
                        if (i3 > i2) {
                            i2 = i3;
                        }
                        layoutParams.setMargins(0, i2 + getMMResources().getDimensionPixelSize(R.f.bvw), 0, 0);
                        return;
                    case 3:
                        layoutParams.setMargins(0, getMMResources().getDimensionPixelSize(R.f.bvw) * 3, 0, 0);
                        return;
                    default:
                        return;
                }
            }
        }

        public final boolean ctJ() {
            if ((this.fBc.ciN() || com.tencent.mm.y.s.hn(csn()) || x.Xd(csn())) && !this.yEL.vus) {
                return false;
            }
            return true;
        }

        private boolean ctK() {
            if (com.tencent.mm.y.s.hl(csn())) {
                return true;
            }
            if (this.fBc.ciN() && this.yEL.kKo != null && (this.yEL.kKo.Li() || this.yEL.kKo.Lh())) {
                return true;
            }
            return false;
        }

        public final void ag(int i, boolean z) {
            int i2;
            int count;
            int count2 = this.yAM.getCount();
            int i3 = this.yAM.hLP - i;
            if (i3 <= 18) {
                i2 = count2 - i3;
            } else if (count2 > i3) {
                i2 = count2 - i3;
            } else {
                this.yAM.FO(i3 - count2);
                this.yAM.csz();
                i2 = 0;
            }
            if (z) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "summerbadcr goBackToHistroyMsg dzmonster get pos=%d, preCount=%d, totalCount=%d, msgCount =%d, select=%d, newTotalCount=%d, newCount=%d, stack[%s]", Integer.valueOf(i), Integer.valueOf(count2), Integer.valueOf(r4), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(this.yAM.hLP), Integer.valueOf(this.yAM.getCount()), bi.chl());
                count = this.yAM.getCount() - count2;
            } else {
                count = i2;
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "summerbadcr goBackToHistroyMsg dzmonster pos=%d, preCount=%d, totalCount=%d, msgCount =%d, fSelect=%d, newTotalCount=%d, newCount=%d, stack[%s]", Integer.valueOf(i), Integer.valueOf(count2), Integer.valueOf(r4), Integer.valueOf(i3), Integer.valueOf(count), Integer.valueOf(this.yAM.hLP), Integer.valueOf(this.yAM.getCount()), bi.chl());
            q qVar = this.yAM;
            au auVar = (au) qVar.getItem(count);
            if (!(auVar == null || auVar.field_msgId == 0)) {
                qVar.yBw = auVar.field_msgId;
            }
            ctI();
            this.yEX.post(new Runnable() {
                public final void run() {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "summerbadcr dz: scroll to fSelect:%d", Integer.valueOf(count));
                    com.tencent.mm.ui.tools.o oVar = new com.tencent.mm.ui.tools.o(a.this.yEX);
                    int headerViewsCount = a.this.yEX.getHeaderViewsCount() + count;
                    oVar.phN.removeCallbacks(oVar);
                    oVar.zvk = System.currentTimeMillis();
                    oVar.zvp = 0;
                    int firstVisiblePosition = oVar.phN.getFirstVisiblePosition();
                    int childCount = (oVar.phN.getChildCount() + firstVisiblePosition) - 1;
                    if (headerViewsCount <= firstVisiblePosition) {
                        firstVisiblePosition = (firstVisiblePosition - headerViewsCount) + 1;
                        oVar.mMode = 2;
                    } else if (headerViewsCount >= childCount) {
                        firstVisiblePosition = (headerViewsCount - childCount) + 1;
                        oVar.mMode = 1;
                    } else {
                        return;
                    }
                    if (firstVisiblePosition > 0) {
                        oVar.zvn = 1000 / firstVisiblePosition;
                    } else {
                        oVar.zvn = 1000;
                    }
                    oVar.zvl = headerViewsCount;
                    oVar.zvm = -1;
                    oVar.phN.post(oVar);
                }
            });
        }

        public final void az(final au auVar) {
            final com.tencent.mm.ui.chatting.h.b bVar = new com.tencent.mm.ui.chatting.h.b(getContext());
            bVar.yQW = new com.tencent.mm.ui.chatting.h.b.a() {
                public final void fY(long j) {
                    bVar.hide();
                    com.tencent.mm.plugin.report.service.g.pWK.a(795, 1, 1, false);
                    if (NetUtil.isConnected(a.this.getContext())) {
                        bdd bdd = new bdd();
                        bdd.lUo = (int) (j / 1000);
                        bdd.kzz = 1;
                        bdd.wMK = 1;
                        try {
                            String str;
                            ate ate = new ate();
                            ate.kyG = a.this.csn();
                            ate.vNT = auVar.field_msgSvrId;
                            a aVar = a.this;
                            cg cgVar = auVar;
                            if (cgVar.cjV() || cgVar.cka()) {
                                str = cgVar.field_content;
                                int hR = bb.hR(str);
                                if (hR != -1) {
                                    str = str.substring(hR + 1).trim();
                                }
                            } else {
                                Context context = aVar.getContext();
                                int type = cgVar.getType();
                                String str2 = cgVar.field_content;
                                aVar.csn();
                                str = AllRemindMsgUI.a(context, type, str2, cgVar.field_isSend);
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "[getRemindTitle] msgId:%s type:%s title:%s", Long.valueOf(cgVar.field_msgId), Integer.valueOf(cgVar.getType()), str);
                            }
                            ate.fpg = str;
                            bdd.wfV = new com.tencent.mm.bp.b(ate.toByteArray());
                        } catch (IOException e) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI", "[onOk] %s", e.toString());
                        }
                        as.CN().a(new com.tencent.mm.modelsimple.ah(1, bdd), 0);
                        return;
                    }
                    com.tencent.mm.ui.base.h.b(a.this.getContext(), a.this.getString(R.l.exR), a.this.getString(R.l.eEH), true);
                }

                public final void onCancel() {
                    bVar.hide();
                }
            };
            if (bVar.yQT != null) {
                bVar.yQT.show();
            }
            com.tencent.mm.plugin.report.service.g.pWK.a(795, 0, 1, false);
        }

        public final String aA(au auVar) {
            Object obj = (com.tencent.mm.app.plugin.b.uB() && auVar.ckl()) ? 1 : null;
            if (obj != null) {
                return dn(auVar.field_content, auVar.field_isSend) + "\n\n" + dn(auVar.field_transContent, auVar.field_isSend);
            }
            return dn(auVar.field_content, auVar.field_isSend);
        }

        public final String dn(String str, int i) {
            if (this.yEL.yHs || !this.yxU || str == null || i != 0) {
                return str;
            }
            return bb.hT(str);
        }

        public void onActivityResult(int i, int i2, Intent intent) {
            if (ctD()) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onActivityResult not foreground, return, requestCode:%d", Integer.valueOf(i));
                return;
            }
            Object obj;
            String str = "MicroMsg.ChattingUI";
            String str2 = "onActivityResult requestCode:%d, data is null:%b  rawUserName:%s ";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Boolean.valueOf(intent == null);
            objArr[2] = this.yAP;
            com.tencent.mm.sdk.platformtools.x.i(str, str2, objArr);
            if (intent == null && i == com.tencent.mm.plugin.appbrand.jsapi.media.e.CTRL_INDEX) {
                com.tencent.mm.ap.n Pt = com.tencent.mm.ap.n.Pt();
                str = csn();
                ArrayList arrayList = new ArrayList();
                if (!bi.oN(str)) {
                    for (com.tencent.mm.ap.n.e eVar : Pt.hDK.values()) {
                        if (str.equals(eVar.toUserName)) {
                            arrayList.add(eVar.hDY);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    intent = new Intent();
                    intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(Integer.valueOf(-1));
                    intent.putIntegerArrayListExtra("GalleryUI_ImgIdList", arrayList2);
                    i2 = -1;
                    com.tencent.mm.plugin.report.service.g.pWK.a(594, 4, 1, true);
                }
            }
            if (this.yAM.yBT && this.yEG.yJy) {
                this.yEG.cuJ();
            }
            com.tencent.mm.ui.chatting.b.c cVar = this.yEL;
            switch (i) {
                case TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_SUCCESS /*12001*/:
                    if (cVar.yHq != null) {
                        com.tencent.mm.app.plugin.a.a aVar = cVar.yHq;
                        if (aVar.fhH == null) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null, maybe has been released");
                        } else if (i2 == -1) {
                            Toast.makeText(aVar.fhH.cte().getContext(), R.l.edA, 0).show();
                            com.tencent.mm.sdk.b.b dvVar = new dv();
                            dvVar.ftn.op = 0;
                            dvVar.ftn.userName = aVar.fhH.csn();
                            dvVar.ftn.context = aVar.fhH.cte().getContext();
                            com.tencent.mm.sdk.b.a.xmy.m(dvVar);
                        } else if (i2 == 0) {
                            Toast.makeText(aVar.fhH.cte().getContext(), R.l.edz, 0).show();
                        }
                    }
                    obj = 1;
                    break;
                default:
                    obj = null;
                    break;
            }
            if (obj != null) {
                return;
            }
            String stringExtra;
            if (i == 221) {
                if (intent != null) {
                    stringExtra = intent.getStringExtra("result_msg");
                    if (!bi.oN(stringExtra)) {
                        com.tencent.mm.ui.base.h.b(getContext(), stringExtra, "", false);
                    }
                }
            } else if (i2 != -1) {
                if (i == 200 || i == 201 || i == 203) {
                    this.yEM.ctp().clearFocus();
                }
            } else if (!this.yEM.e(i, intent)) {
                ad adVar = this.yEA;
                switch (i) {
                    case com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX /*208*/:
                        adVar.al(intent);
                        obj = 1;
                        break;
                    case bp.CTRL_INDEX /*215*/:
                        adVar.al(intent);
                        obj = 1;
                        break;
                    case com.tencent.mm.plugin.appbrand.jsapi.media.f.CTRL_INDEX /*216*/:
                        adVar.am(intent);
                        obj = 1;
                        break;
                    case 218:
                        if (intent != null) {
                            if (intent.getBooleanExtra("from_record", false)) {
                                adVar.am(intent);
                            } else {
                                adVar.al(intent);
                            }
                        }
                        obj = 1;
                        break;
                    default:
                        obj = null;
                        break;
                }
                if (obj == null && !this.yEB.f(i, intent)) {
                    m mVar = this.yED;
                    switch (i) {
                        case 2002:
                            if (intent.getBooleanExtra("kfavorite", false)) {
                                com.tencent.mm.f.a.cg cgVar = new com.tencent.mm.f.a.cg();
                                com.tencent.mm.pluginsdk.model.f.a(cgVar, intent);
                                cgVar.frk.pL = mVar.fhH.cte();
                                cgVar.frk.frr = 42;
                                com.tencent.mm.sdk.b.a.xmy.m(cgVar);
                            }
                            obj = 1;
                            break;
                        default:
                            obj = null;
                            break;
                    }
                    if (obj == null && !this.yEE.e(i, i2, intent)) {
                        l lVar = this.yEy;
                        switch (i) {
                            case JsApiCheckIsSupportFaceDetect.CTRL_INDEX /*214*/:
                                ChatFooter.ccB();
                                lVar.fhH.ctp().ccz();
                                obj = 1;
                                break;
                            default:
                                obj = null;
                                break;
                        }
                        if (obj == null) {
                            j jVar = this.yEH;
                            switch (i) {
                                case com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX /*212*/:
                                    if (intent != null) {
                                        str = intent.getStringExtra("select_raw_user_name");
                                        str2 = intent.getStringExtra("Select_Conv_User");
                                        if (bi.oN(str2)) {
                                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.SearchImp", "@ %s", "[nobody]");
                                            jVar.fhH.ctp().Tb("");
                                            jVar.yIu = false;
                                        } else {
                                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.SearchImp", "@ %s", str2);
                                            jVar.fhH.ctp().Tb(str2);
                                            jVar.fhH.ctp().ae(jVar.fhH.csn(), str, str2);
                                            jVar.yIu = true;
                                        }
                                        obj = 1;
                                        break;
                                    }
                                    obj = 1;
                                    break;
                                default:
                                    obj = null;
                                    break;
                            }
                            if (obj == null) {
                                long longExtra;
                                String stringExtra2;
                                com.tencent.mm.ui.chatting.b.a aVar2 = this.yEI;
                                switch (i) {
                                    case com.tencent.mm.plugin.appbrand.jsapi.share.i.CTRL_INDEX /*210*/:
                                        if (i2 == -1) {
                                            longExtra = intent.getLongExtra("App_MsgId", 0);
                                            as.Hm();
                                            aVar2.aM(com.tencent.mm.y.c.Fh().dI(longExtra));
                                        }
                                        obj = 1;
                                        break;
                                    case 222:
                                        if (i2 == -1 && intent != null) {
                                            str2 = intent.getStringExtra("service_app_package_name");
                                            String stringExtra3 = intent.getStringExtra("service_app_openid");
                                            stringExtra2 = intent.getStringExtra("service_app_appid");
                                            String str3 = "MicroMsg.ChattingUI.AppImp";
                                            String str4 = "request send wx msg, wxmessage[%b], package[%s], appId[%s], openId[%s]";
                                            Object[] objArr2 = new Object[4];
                                            objArr2[0] = Boolean.valueOf(aVar2.yHi != null);
                                            objArr2[1] = str2;
                                            objArr2[2] = stringExtra2;
                                            objArr2[3] = stringExtra3;
                                            com.tencent.mm.sdk.platformtools.x.i(str3, str4, objArr2);
                                            if (bi.oN(stringExtra2)) {
                                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.AppImp", "REQUEST_CODE_SERVICE_APP openId is null");
                                                obj = 1;
                                                break;
                                            } else if (aVar2.yHi == null || bi.oN(str2)) {
                                                aVar2.n(com.tencent.mm.pluginsdk.model.app.g.aZ(stringExtra2, true));
                                                obj = 1;
                                                break;
                                            } else if (bi.oN(stringExtra3)) {
                                                an.biV().Pm(stringExtra2);
                                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.AppImp", "request send wx msg fail, openId is null, go get it");
                                                obj = 1;
                                                break;
                                            } else {
                                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.AppImp", "request send wx msg success = %b", Boolean.valueOf(aVar2.yHi.fS(str2, stringExtra3)));
                                                if (!aVar2.yHi.fS(str2, stringExtra3)) {
                                                    aVar2.n(com.tencent.mm.pluginsdk.model.app.g.aZ(stringExtra2, true));
                                                }
                                            }
                                        }
                                        obj = 1;
                                        break;
                                    default:
                                        obj = null;
                                        break;
                                }
                                if (obj == null) {
                                    y yVar = this.yEJ;
                                    switch (i) {
                                        case 207:
                                            yVar.dp(intent.getStringExtra("art_smiley_slelct_data"), 4);
                                            obj = 1;
                                            break;
                                        default:
                                            obj = null;
                                            break;
                                    }
                                    if (obj == null) {
                                        int nz;
                                        switch (i) {
                                            case com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX /*204*/:
                                                return;
                                            case com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX /*211*/:
                                                if (i2 == -1) {
                                                    Cursor managedQuery = managedQuery(intent.getData(), null, null, null, null);
                                                    if (managedQuery.moveToFirst()) {
                                                        startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/" + managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            case com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX /*213*/:
                                                if (intent != null && intent.getBooleanExtra("_delete_ok_", false)) {
                                                    finish();
                                                    return;
                                                }
                                                return;
                                            case 220:
                                                if (-1 == i2 && this.yFm != null && this.yFm.yBT) {
                                                    this.yFm.csF();
                                                    return;
                                                }
                                                return;
                                            case 225:
                                                stringExtra = intent.getStringExtra("enterprise_biz_name");
                                                longExtra = intent.getLongExtra("key_biz_chat_id", -1);
                                                s sVar = this.yFm;
                                                l.a(sVar.yAD, sVar, stringExtra, longExtra);
                                                return;
                                            case com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX /*226*/:
                                                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                                                if (sightCaptureResult == null) {
                                                    return;
                                                }
                                                boolean z;
                                                if (sightCaptureResult.owf) {
                                                    v vVar = this.yEB;
                                                    stringExtra2 = sightCaptureResult.own;
                                                    if (!bi.oN(stringExtra2)) {
                                                        try {
                                                            z = sightCaptureResult.owg;
                                                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SendImgImp", "doSendChattingImage, path: %s", stringExtra2);
                                                            as.CN().a(new com.tencent.mm.ap.l(z ? 2 : 1, com.tencent.mm.y.q.FY(), vVar.fhH.csW().field_username, stringExtra2, 0, null, 0, "", "", true, R.g.bAI), 0);
                                                            return;
                                                        } catch (Exception e) {
                                                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.SendImgImp", "doSendChattingImage error: %s", e.getMessage());
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                }
                                                ad adVar2 = this.yEA;
                                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.VideoImp", "video path %s thumb path ", sightCaptureResult.owh, sightCaptureResult.owi);
                                                com.tencent.mm.modelvideo.o.Ub();
                                                str2 = com.tencent.mm.modelvideo.s.nx(sightCaptureResult.owj);
                                                if (!sightCaptureResult.owh.equals(str2)) {
                                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.VideoImp", "filepath not videopath and move it %s %s", sightCaptureResult.owh, str2);
                                                    FileOp.at(sightCaptureResult.owh, str2);
                                                }
                                                str2 = sightCaptureResult.owj;
                                                int i3 = sightCaptureResult.owl;
                                                str = adVar2.fhH.csW().field_username;
                                                aqp aqp = sightCaptureResult.owm;
                                                com.tencent.mm.modelvideo.r rVar = new com.tencent.mm.modelvideo.r();
                                                rVar.fileName = str2;
                                                rVar.hXv = i3;
                                                rVar.fEx = str;
                                                rVar.hXn = (String) g.Dq().Db().get(2, (Object) "");
                                                rVar.hXs = bi.Wx();
                                                rVar.hXt = bi.Wx();
                                                rVar.hXF = aqp;
                                                rVar.hXz = 0;
                                                rVar.hXC = 1;
                                                com.tencent.mm.modelvideo.o.Ub();
                                                nz = com.tencent.mm.modelvideo.s.nz(com.tencent.mm.modelvideo.s.nx(str2));
                                                if (nz <= 0) {
                                                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.VideoLogic", "get Video size failed :" + str2);
                                                    z = false;
                                                } else {
                                                    rVar.hmZ = nz;
                                                    com.tencent.mm.modelvideo.o.Ub();
                                                    str = com.tencent.mm.modelvideo.s.ny(str2);
                                                    i3 = com.tencent.mm.modelvideo.s.nz(str);
                                                    if (i3 <= 0) {
                                                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.VideoLogic", "get Thumb size failed :" + str + " size:" + i3);
                                                        z = false;
                                                    } else {
                                                        rVar.hXr = i3;
                                                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.VideoLogic", "prepareMMSightRecord file:" + str2 + " thumbsize:" + rVar.hXr + " videosize:" + rVar.hmZ);
                                                        rVar.status = 102;
                                                        au auVar = new au();
                                                        auVar.dU(rVar.Uk());
                                                        auVar.setType(43);
                                                        auVar.eS(1);
                                                        auVar.dV(str2);
                                                        auVar.eR(1);
                                                        auVar.aq(bb.hU(rVar.Uk()));
                                                        rVar.hXw = (int) bb.i(auVar);
                                                        z = com.tencent.mm.modelvideo.o.Ub().a(rVar);
                                                    }
                                                }
                                                if (z) {
                                                    com.tencent.mm.modelvideo.t.nE(sightCaptureResult.owj);
                                                    return;
                                                } else {
                                                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.VideoImp", "prepareMMSightRecord failed");
                                                    return;
                                                }
                                            case GameJsApiGetOpenDeviceId.CTRL_BYTE /*227*/:
                                                if (i2 == -1 && intent != null) {
                                                    int gn;
                                                    this.yEB.f((int) com.tencent.mm.plugin.appbrand.jsapi.media.e.CTRL_INDEX, intent);
                                                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("selected_file_lst");
                                                    if (this.yAR) {
                                                        gn = com.tencent.mm.y.m.gn(this.yAP);
                                                    } else {
                                                        gn = 0;
                                                    }
                                                    Iterator it = stringArrayListExtra.iterator();
                                                    while (it.hasNext()) {
                                                        str = (String) it.next();
                                                        IMediaObject wXFileObject = new WXFileObject();
                                                        wXFileObject.setFilePath(str);
                                                        WXMediaMessage wXMediaMessage = new WXMediaMessage();
                                                        wXMediaMessage.mediaObject = wXFileObject;
                                                        File file = new File(str);
                                                        wXMediaMessage.title = file.getName();
                                                        wXMediaMessage.description = bi.by(file.length());
                                                        com.tencent.mm.pluginsdk.model.app.l.a(wXMediaMessage, "", "", this.yAP, 4, null);
                                                        nz = file.getName().lastIndexOf(".");
                                                        stringExtra = "";
                                                        if (nz >= 0 && nz < file.getName().length() - 1) {
                                                            stringExtra = file.getName().substring(nz + 1);
                                                        }
                                                        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                                                        Object[] objArr3 = new Object[5];
                                                        objArr3[0] = Long.valueOf(file.length());
                                                        objArr3[1] = Integer.valueOf(0);
                                                        objArr3[2] = Integer.valueOf(this.yAR ? 1 : 0);
                                                        objArr3[3] = Integer.valueOf(gn);
                                                        objArr3[4] = stringExtra;
                                                        gVar.h(14986, objArr3);
                                                    }
                                                    stringExtra = intent.getStringExtra("with_text_content");
                                                    if (!bi.oN(stringExtra)) {
                                                        com.tencent.mm.plugin.messenger.a.f.aZN().dq(stringExtra, this.yAP);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            default:
                                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI", "onActivityResult: not found this requestCode");
                                                return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        protected boolean crP() {
            boolean z = false;
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "writeOpLogAndMarkRead :" + csn());
            if (x.Xd(csn())) {
                as.Hm();
                Cursor Fn = com.tencent.mm.y.c.Fh().Fn(csn());
                Fn.moveToFirst();
                while (!Fn.isAfterLast()) {
                    cg auVar = new au();
                    auVar.b(Fn);
                    if (auVar.getType() != 34) {
                        auVar.eR(4);
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "writeOpLog: msgSvrId = " + auVar.field_msgSvrId + " status = " + auVar.field_status);
                    }
                    Fn.moveToNext();
                    z = true;
                }
                Fn.close();
                if (!z) {
                    return z;
                }
                as.Hm();
                com.tencent.mm.y.c.Fk().XH(csn());
                as.Hm();
                com.tencent.mm.y.c.Fh().Fl(csn());
                return z;
            }
            com.tencent.mm.ui.chatting.b.c cVar = this.yEL;
            if (cVar.fhH.csW().ciN() && cVar.kKo != null) {
                if (cVar.vus) {
                    return com.tencent.mm.af.y.Mo().aV(cVar.ctW());
                }
                if (cVar.kKo.Ll()) {
                    if (!(cVar.kKo.bK(false) == null || cVar.kKo.bK(false).LM() == null || bi.oN(cVar.kKo.Ls()))) {
                        as.Hm();
                        ak XR = com.tencent.mm.y.c.Fk().XR(cVar.kKo.Ls());
                        if (XR != null && XR.field_username.equals(cVar.fhH.csn()) && XR.field_unReadCount > 0) {
                            if (cVar.fhH.cte().getIntExtra("chat_from_scene", 0) == 2) {
                                return false;
                            }
                            as.Hm();
                            com.tencent.mm.y.c.Fk().XH(cVar.kKo.Ls());
                        }
                    }
                } else if (!(cVar.kKo.Lh() || cVar.kKo.Lj())) {
                    as.Hm();
                    ak cjz = com.tencent.mm.y.c.Fk().cjz();
                    if (cjz != null && cjz.field_username.equals(cVar.fhH.csn()) && cjz.field_unReadCount > 0) {
                        as.Hm();
                        com.tencent.mm.y.c.Fk().XH("officialaccounts");
                    }
                }
            }
            as.Hm();
            return com.tencent.mm.y.c.Fk().XH(cVar.fhH.csn());
        }

        public void finish() {
            hideVKB();
            ah.h(new Runnable() {
                public final void run() {
                    boolean z = true;
                    if (a.this.isCurrentActivity) {
                        super.finish();
                    } else if (a.this.thisActivity() instanceof LauncherUI) {
                        LauncherUI launcherUI = (LauncherUI) a.this.thisActivity();
                        if (launcherUI != null) {
                            if (a.this.isSupportNavigationSwipeBack()) {
                                z = false;
                            }
                            launcherUI.closeChatting(z);
                        }
                    } else if (a.this.thisActivity() instanceof BaseConversationUI) {
                        BaseConversationUI baseConversationUI = (BaseConversationUI) a.this.thisActivity();
                        if (baseConversationUI != null) {
                            if (a.this.isSupportNavigationSwipeBack()) {
                                z = false;
                            }
                            baseConversationUI.closeChatting(z);
                        }
                    }
                }
            }, 100);
        }

        public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " sceneType:" + kVar.getType());
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (this.yFc != null) {
                this.yFc.dismiss();
                this.yFc = null;
            }
            y yVar = this.yEJ;
            if (522 == kVar.getType()) {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcSendMsgEnable, yVar.yKG);
                yVar.yKG = 0;
            }
            if (ctD()) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onSceneEnd fragment not foreground, return");
            } else if (!bi.bF(getContext())) {
            } else {
                if (10 != kVar.getType() && o(i, i2, str)) {
                    return;
                }
                if (i == 0 && i2 == 0) {
                    switch (kVar.getType()) {
                        case 10:
                            if (!this.yEG.yAH && !this.yEG.yJp && !this.yEG.yJu) {
                                i iVar = this.yEt;
                                com.tencent.mm.modelsimple.j jVar = (com.tencent.mm.modelsimple.j) kVar;
                                if (jVar.hOy != null && jVar.hOy.equals(iVar.fhH.csn())) {
                                    if (jVar.content == null || jVar.content.length != 4) {
                                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.DirectScendImp", "unknown directsend op");
                                        return;
                                    }
                                    int p = com.tencent.mm.a.n.p(jVar.content, 0);
                                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.DirectScendImp", "directsend: status=" + p);
                                    switch (p) {
                                        case 1:
                                            iVar.yIs = true;
                                            iVar.fhH.cte().setMMTitle(R.l.dTn);
                                            iVar.handler.sendMessageDelayed(new Message(), 15000);
                                            com.tencent.mm.sdk.b.a.xmy.m(new mp());
                                            return;
                                        case 3:
                                            iVar.yIs = true;
                                            iVar.fhH.cte().setMMTitle(R.l.dTo);
                                            iVar.handler.sendMessageDelayed(new Message(), 15000);
                                            return;
                                        default:
                                            iVar.yIs = false;
                                            iVar.fhH.crM();
                                            iVar.fhH.cpZ();
                                            return;
                                    }
                                }
                                return;
                            }
                            return;
                        case 127:
                            com.tencent.mm.modelvoice.p og = com.tencent.mm.modelvoice.q.og(((com.tencent.mm.modelvoice.f) kVar).fileName);
                            if (og != null && og.status == 99) {
                                com.tencent.mm.sdk.platformtools.as.H(getContext(), R.l.dDI);
                                return;
                            }
                            return;
                        case 137:
                            List list = ((com.tencent.mm.pluginsdk.model.o) kVar).vkg;
                            if (list == null || list.contains(this.fBc.field_username)) {
                                com.tencent.mm.f.b.ag agVar = this.fBc;
                                as.Hm();
                                x Xv = com.tencent.mm.y.c.Ff().Xv(agVar.field_username);
                                if (Xv == null || ((int) Xv.gKO) == 0) {
                                    as.Hm();
                                    if (com.tencent.mm.y.c.Ff().R(agVar)) {
                                        as.Hm();
                                        Xv = com.tencent.mm.y.c.Ff().Xv(agVar.field_username);
                                    } else {
                                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.ChattingLogic", "insert contact failed, username = " + agVar.field_username);
                                        Xv = null;
                                    }
                                }
                                if (Xv != null) {
                                    com.tencent.mm.y.s.p(Xv);
                                    return;
                                }
                                return;
                            }
                            return;
                        case 525:
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "set msg remind!");
                            com.tencent.mm.ui.snackbar.a.a(getContext(), getContentView(), getString(R.l.epn), "");
                            return;
                        case 551:
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "cpan[refresh top btn]");
                            this.xTP = com.tencent.mm.y.m.gf(csn());
                            crN();
                            return;
                        case 594:
                            beq Ss = ((com.tencent.mm.modelsimple.z) kVar).Ss();
                            if (!bi.oN(Ss.wRi)) {
                                com.tencent.mm.ui.base.h.a(getContext(), Ss.wRi, "", getMMString(R.l.dSU), new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        if (dialogInterface != null) {
                                            dialogInterface.dismiss();
                                        }
                                    }
                                });
                                return;
                            }
                            return;
                        case 610:
                            au auVar = ((com.tencent.mm.plugin.chatroom.d.k) kVar).fFE;
                            auVar.ckn();
                            as.Hm();
                            com.tencent.mm.y.c.Fh().b(auVar.field_msgSvrId, auVar);
                            Toast.makeText(getContext(), getMMString(R.l.eqf), 0).show();
                            com.tencent.mm.plugin.report.service.g.pWK.a(219, 24, (long) ((com.tencent.mm.plugin.chatroom.d.k) kVar).lfj, true);
                            return;
                        default:
                            return;
                    }
                }
                if (i2 == -49) {
                    if (this.yFp == null) {
                        this.yFp = new com.tencent.mm.ui.bindqq.b(getContext(), new com.tencent.mm.ui.bindqq.b.a() {
                            public final boolean t(int i, int i2, String str) {
                                return a.this.o(i, i2, str);
                            }

                            public final void crs() {
                            }
                        });
                    }
                    this.yFp.crt();
                } else if (kVar.getType() == 109) {
                    com.tencent.mm.ui.base.h.h(getContext(), R.l.dRs, R.l.dGZ);
                }
                if (kVar.getType() == 594) {
                    Object obj;
                    beq Ss2 = ((com.tencent.mm.modelsimple.z) kVar).Ss();
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "[oneliang][revokeMsgTimeout] sysWording:%s", Ss2.wRj);
                    if (i2 == 0 || bi.oN(Ss2.wRj)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "[oneliang][revokeMsg] sysWording:%s", Ss2.wRj);
                        this.yFc = com.tencent.mm.ui.base.h.a(getContext(), Ss2.wRj, "", getMMString(R.l.dSU), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (a.this.yFc != null) {
                                    a.this.yFc.dismiss();
                                }
                            }
                        });
                    } else {
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "[oneliang][revokeMsg] errorCode:%s,sysWording:%s", Integer.valueOf(i2), Ss2.wRj);
                        this.yFc = com.tencent.mm.ui.base.h.a(getContext(), getMMString(R.l.dSV), "", getMMString(R.l.dSU), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (a.this.yFc != null) {
                                    a.this.yFc.dismiss();
                                }
                            }
                        });
                    }
                }
                if (kVar.getType() == 525) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", Integer.valueOf(525), Integer.valueOf(i2), Integer.valueOf(i), bi.oM(str));
                    com.tencent.mm.ui.base.h.b(getContext(), bi.oN(str) ? getString(R.l.eEG) : str, getString(R.l.eEH), true);
                    com.tencent.mm.plugin.report.service.g.pWK.a(795, 4, 1, false);
                }
                if (kVar.getType() == 610) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", Integer.valueOf(610), Integer.valueOf(i2), Integer.valueOf(i), bi.oM(str));
                    com.tencent.mm.ui.base.h.b(getContext(), getString(R.l.eqd), getString(R.l.dGZ), true);
                }
            }
        }

        public final String ctL() {
            if (this.yEL.vus) {
                if (this.yEL.yHs) {
                    if (this.yEL.yvJ == null) {
                        return null;
                    }
                    return this.yEL.yvJ.field_chatName;
                } else if (this.yEL.poq != null) {
                    return this.yEL.poq.field_userName;
                } else {
                    return null;
                }
            } else if (this.fBc != null) {
                return this.fBc.field_nickname;
            } else {
                return null;
            }
        }

        protected final boolean o(int i, int i2, String str) {
            if (com.tencent.mm.ui.t.a.a(getContext(), i, i2, str, 7) || com.tencent.mm.ui.t.a(getContext(), i, i2, new Intent().setClass(getContext(), LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                return true;
            }
            return false;
        }

        public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
            if (ctD()) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onNotifyChange fragment not foreground, return");
                return;
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onNotifyChange " + str);
            as.Hm();
            com.tencent.mm.f.b.ag Xv = com.tencent.mm.y.c.Ff().Xv(csn());
            if (Xv != null && ((int) Xv.gKO) != 0) {
                if (bi.oN(Xv.field_nickname)) {
                    Xv.dc(this.fBc.field_nickname);
                }
                this.fBc = Xv;
                crM();
                cpZ();
                if (this.yEL.yHs) {
                    this.xTP = com.tencent.mm.af.a.e.c(this.yEL.yvJ);
                } else {
                    this.xTP = com.tencent.mm.y.m.gf(csn());
                }
                this.yEP.cug();
            }
        }

        public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
            if (obj == null || !(obj instanceof String)) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
                return;
            }
            a((String) obj, null);
        }

        public void onConfigurationChanged(Configuration configuration) {
            int i;
            int i2 = 1;
            super.onConfigurationChanged(configuration);
            f fVar = this.yEP;
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.ChattingHeadereMgr", "getConfiguration().orientation = " + fVar.fhH.cte().getMMResources().getConfiguration().orientation + ", newConfig.orientation = " + configuration.orientation);
            fVar.fhH.cte().getMMResources().getConfiguration().orientation = configuration.orientation;
            ChatFooter ctp = fVar.fhH.ctp();
            ctp.cbj();
            ctp.ccF();
            ctp.CG(-1);
            ctp.vxm = true;
            if (ctp.oqc != null) {
                ctp.oqc.ti();
            }
            fVar.yEC.bTe();
            j jVar = fVar.yEH;
            jVar.yIw = jVar.fhH.ctp().ccf();
            jVar.cup();
            if (fVar.yHV != null) {
                i = 1;
            } else {
                i = 0;
            }
            if (fVar.yHY == null) {
                i2 = 0;
            }
            if ((i & i2) != 0) {
                i2 = com.tencent.mm.compatible.util.a.g(fVar.fhH.cte().thisActivity());
                fVar.yHY.setMinimumHeight(i2);
                LayoutParams layoutParams = fVar.yHY.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LayoutParams(-1, -1);
                }
                layoutParams.height = i2;
                fVar.yHY.setLayoutParams(layoutParams);
                layoutParams = fVar.yHV.getLayoutParams();
                layoutParams.height = i2;
                fVar.yHV.setLayoutParams(layoutParams);
            }
            if (fVar.yHW != null) {
                fVar.yHW.xSD.mActionBar.onConfigurationChanged(configuration);
            }
        }

        public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.c cVar, com.tencent.mm.plugin.messenger.foundation.a.a.c.c cVar2) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "on msg notify change");
            if (this.fBc.field_username.equals(cVar2.talker) && "insert".equals(cVar2.ouA) && cVar2.ouB.size() > 0 && ((au) cVar2.ouB.get(0)).field_isSend == 0) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "summerbadcr oreh onNotifyChange receive a new msg flag[%d], msgSeq[%d]", Integer.valueOf(((au) cVar2.ouB.get(0)).field_flag), Long.valueOf(((au) cVar2.ouB.get(0)).field_msgSeq));
                this.yFj = bi.Wy();
            }
        }

        public final boolean a(b bVar) {
            if (bVar == null || this.yFa.contains(bVar)) {
                return false;
            }
            return this.yFa.add(bVar);
        }

        public final boolean b(b bVar) {
            return this.yFa.remove(bVar);
        }
    }

    public interface b {
        void ctM();

        void ctN();

        void ctO();
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        getWindow().setFormat(-2);
        com.tencent.mm.pluginsdk.e.O(this);
        super.onCreate(null);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("Chat_User");
        boolean booleanExtra = intent.getBooleanExtra("key_is_biz_chat", false);
        if (!booleanExtra && stringExtra == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.BizMgr", "talker is null !!!");
            z = true;
        } else if (booleanExtra && intent.getLongExtra("key_biz_chat_id", -1) == -1) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.BizMgr", "bizChatId is null !!");
            z = true;
        } else {
            z = false;
        }
        if (z) {
            finish();
            return;
        }
        setContentView(R.i.dex);
        this.yEn = new a(true);
        Bundle extras = getIntent().getExtras();
        extras.putBoolean("FROM_CHATTING_ACTIVITY", true);
        this.yEn.setArguments(extras);
        getSupportFragmentManager().aT().a(R.h.cwx, this.yEn).commit();
        getSupportActionBar().show();
        d dVar = ((a) this.yEn).yEE;
        intent = getIntent();
        String stringExtra2 = intent.getStringExtra("Chat_User");
        String stringExtra3 = intent.getStringExtra("send_card_username");
        if (!bi.oN(stringExtra3)) {
            boolean booleanExtra2 = intent.getBooleanExtra("Is_Chatroom", false);
            String stringExtra4 = intent.getStringExtra("send_card_edittext");
            if (booleanExtra2) {
                as.CN().a(new com.tencent.mm.modelmulti.j(bi.aD(stringExtra2, ""), com.tencent.mm.ui.contact.y.aal(stringExtra3), x.Xg(stringExtra3) ? 66 : 42), 0);
            } else {
                List F = bi.F(bi.aD(stringExtra2, "").split(","));
                String aal = com.tencent.mm.ui.contact.y.aal(stringExtra3);
                for (int i = 0; i < F.size(); i++) {
                    as.CN().a(new com.tencent.mm.modelmulti.j((String) F.get(i), aal, x.Xg(stringExtra3) ? 66 : 42), 0);
                }
            }
            if (stringExtra4 != null) {
                com.tencent.mm.plugin.messenger.a.f.aZN().dq(stringExtra4, stringExtra2);
            }
        }
        if (getIntent().getBooleanExtra("resend_fail_messages", false)) {
            ah.h(new Runnable() {
                public final void run() {
                    com.tencent.mm.ui.base.h.a(ChattingUI.this, ChattingUI.this.getString(R.l.ezg), "", ChattingUI.this.getString(R.l.ezh), ChattingUI.this.getString(R.l.dEy), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.b.a.xmy.m(new nq());
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.b.a.xmy.m(new kt());
                        }
                    });
                }
            }, 500);
            getIntent().putExtra("is_need_resend_sns", false);
        }
        com.tencent.mm.permission.a.Wi().Wj();
        initNavigationSwipeBack();
        this.yyu.post(new Runnable() {
            public final void run() {
                if (ChattingUI.this.yEn != null) {
                    com.tencent.mm.pluginsdk.e.a(ChattingUI.this, ChattingUI.this.yEn.getBodyView());
                }
            }
        });
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "chatting ui dispatch key event %s", keyEvent);
        if (this.yEn == null || !this.yEn.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "chatting ui on key up");
        return super.onKeyUp(i, keyEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "chatting ui on key down, %d, %s", Integer.valueOf(i), keyEvent);
        return super.onKeyDown(i, keyEvent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        u uVar = this.yEn;
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.ChattingUI.ChattingPermissionsLogic";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bi.chl();
            com.tencent.mm.sdk.platformtools.x.w(str, str2, objArr);
            return;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.ChattingPermissionsLogic", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        int i2;
        switch (i) {
            case 18:
                if (iArr[0] != 0) {
                    i2 = "android.permission.CAMERA".equals(strArr[0]) ? R.l.ezZ : R.l.eAd;
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.h.a((Context) this, getString(i2), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new AnonymousClass4(this), new AnonymousClass5());
                        return;
                    }
                    return;
                } else if (uVar instanceof a) {
                    ((a) uVar).yEM.cuE();
                    return;
                } else {
                    return;
                }
            case 19:
            case 21:
            case 22:
                if (iArr[0] != 0) {
                    i2 = "android.permission.CAMERA".equals(strArr[0]) ? R.l.ezZ : R.l.eAd;
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.h.a((Context) this, getString(i2), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new AnonymousClass6(this), new AnonymousClass7());
                        return;
                    }
                    return;
                } else if (!(uVar instanceof a)) {
                    return;
                } else {
                    if (i == 19) {
                        ((a) uVar).yEM.bkj();
                        return;
                    } else if (i == 21) {
                        ((a) uVar).yEM.csq();
                        return;
                    } else {
                        ((a) uVar).yEM.cso();
                        return;
                    }
                }
            case 20:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.ezZ), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new AnonymousClass8(this), null);
                    return;
                } else if (uVar instanceof a) {
                    ((a) uVar).yEM.css();
                    return;
                } else {
                    return;
                }
            case 67:
            case 68:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eAc), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new AnonymousClass9(this), null);
                    return;
                } else if (!(uVar instanceof a)) {
                    return;
                } else {
                    if (i == 67) {
                        ((a) uVar).yEF.cuG();
                        return;
                    } else {
                        ((a) uVar).yEF.cuH();
                        return;
                    }
                }
            case 80:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eAd), "", getString(R.l.esG), getString(R.l.cancel), false, new com.tencent.mm.ui.chatting.b.h.AnonymousClass1(this), new AnonymousClass3());
                    return;
                } else if (uVar instanceof a) {
                    ((a) uVar).yEM.cuD();
                    return;
                } else {
                    return;
                }
            case 81:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eAd), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new AnonymousClass10(this), null);
                    return;
                } else if (uVar instanceof a) {
                    ((a) uVar).yEM.csr();
                    return;
                } else {
                    return;
                }
            case 82:
            case 83:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eAd), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new com.tencent.mm.ui.chatting.b.h.AnonymousClass2(this), null);
                    return;
                } else if (!(uVar instanceof a)) {
                    return;
                } else {
                    if (i == 82) {
                        ((a) uVar).yEM.bki();
                        return;
                    } else {
                        ((a) uVar).yEM.csp();
                        return;
                    }
                }
            default:
                return;
        }
    }
}
