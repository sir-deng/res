package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.text.ClipboardManager;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ad.e;
import com.tencent.mm.f.a.bu;
import com.tencent.mm.f.a.f;
import com.tencent.mm.f.a.gm;
import com.tencent.mm.f.a.ke;
import com.tencent.mm.f.a.ki;
import com.tencent.mm.f.a.kn;
import com.tencent.mm.f.a.ko;
import com.tencent.mm.f.a.ku;
import com.tencent.mm.f.a.nr;
import com.tencent.mm.f.a.pm;
import com.tencent.mm.f.a.pp;
import com.tencent.mm.f.a.pq;
import com.tencent.mm.f.a.pu;
import com.tencent.mm.f.a.pv;
import com.tencent.mm.f.a.pw;
import com.tencent.mm.f.a.qb;
import com.tencent.mm.f.a.qd;
import com.tencent.mm.f.a.qn;
import com.tencent.mm.f.a.rv;
import com.tencent.mm.f.a.sf;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kiss.WxPresenterActivity;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.i.h;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.j.b;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.model.t;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.y.an;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SnsTimeLineUI extends WxPresenterActivity implements e, com.tencent.mm.plugin.sns.b.h.a, u, an {
    private static final Set<Activity> rOH = new HashSet();
    private int hGs;
    private String jPV;
    private long kIK;
    private ActionBar mActionBar;
    private int mScreenHeight;
    private int mScreenWidth;
    private int oTt;
    protected g rFX;
    private final long rNL = 300;
    private long rNM = SystemClock.elapsedRealtime();
    private b rNN = ((b) q(b.class));
    private com.tencent.mm.plugin.sns.j.a rNO;
    private ax rNP;
    private LinearLayout rNQ;
    private QFadeImageView rNR;
    private boolean rNS;
    private boolean rNT;
    private j rNU;
    private a rNV;
    private TestTimeForSns rNW;
    private int rNX;
    private boolean rNY;
    private String rNZ;
    Runnable rOA;
    Runnable rOB;
    private Handler rOC;
    private Runnable rOD;
    private com.tencent.mm.plugin.sns.ui.bb.a rOE;
    private com.tencent.mm.vending.app.a.b rOF;
    boolean rOG;
    private OnMenuItemClickListener rOI;
    private View rOJ;
    private ImageView rOK;
    private View rOL;
    private MenuItem rOM;
    private ba rON;
    private OnClickListener rOO;
    private boolean rOP;
    private com.tencent.mm.plugin.sns.h.a rOa;
    private au rOb;
    private as rOc;
    private String rOd;
    private boolean rOe;
    private int rOf;
    private bb rOg;
    private Runnable rOh;
    private c rOi;
    private boolean rOj;
    private c rOk;
    private c rOl;
    private c rOm;
    private c rOn;
    private c rOo;
    private c rOp;
    private c rOq;
    private c rOr;
    private c rOs;
    private c rOt;
    private c rOu;
    private c rOv;
    private c rOw;
    private c rOx;
    private long rOy;
    boolean rOz;
    private c rdv;
    private boolean rhc;
    private boolean rxE;
    private boolean rzo;

    class a extends Animation {
        ListView nQn;
        float rPb;
        float rPc;
        float rPd = -1.0f;
        float rPe;
        float rPf = 0.0f;
        private float rPg;
        boolean rPh;
        int rPi;
        boolean rPj = false;
        int rPk = 0;
        float rPl = 0.0f;
        float rPm = 0.0f;

        public a(ListView listView) {
            this.nQn = listView;
        }

        public final void bCC() {
            x.d("MicroMsg.SnsTimeLineUI", "animtest playLoading");
            if (SnsTimeLineUI.this.rNR.getVisibility() == 0) {
                init();
                this.rPf = this.rPd + 20.0f;
                LayoutParams layoutParams = (LayoutParams) SnsTimeLineUI.this.rNR.getLayoutParams();
                layoutParams.y = (int) this.rPd;
                SnsTimeLineUI.this.rNR.setLayoutParams(layoutParams);
                bCD();
            }
        }

        public final void bCD() {
            if (SnsTimeLineUI.this.rNR.getVisibility() == 0) {
                init();
                SnsTimeLineUI.this.rNR.clearAnimation();
                SnsTimeLineUI.this.rNR.startAnimation(this);
                if (this.rPf >= this.rPd) {
                    setDuration(20000);
                    this.rPh = false;
                    return;
                }
                setDuration(600);
                this.rPh = true;
            }
        }

        final void init() {
            if (this.rPd == -1.0f || ((double) this.rPc) < 0.1d) {
                this.rPd = (float) BackwardSupportUtil.b.b(SnsTimeLineUI.this, 25.0f);
                this.rPb = (float) (SnsTimeLineUI.this.rNR.getWidth() / 2);
                this.rPc = (float) (SnsTimeLineUI.this.rNR.getHeight() / 2);
                this.rPe = (this.rPc * -2.0f) - 3.0f;
                x.d("MicroMsg.SnsTimeLineUI", "MIN_Y" + this.rPe);
                this.rPf = this.rPe;
                if (!this.rPj) {
                    x.i("MicroMsg.SnsTimeLineUI", "initState");
                    this.rPk = ((LayoutParams) SnsTimeLineUI.this.rNR.getLayoutParams()).y;
                    this.rPl = this.rPd;
                    this.rPm = this.rPf;
                }
                this.rPj = true;
            }
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            if (SnsTimeLineUI.this.rNR.getVisibility() == 0) {
                float duration = ((float) getDuration()) * (f - this.rPg);
                if (duration >= 2.0f) {
                    this.rPg = f;
                    SnsTimeLineUI.this.rNR.setImageResource(i.qOQ);
                    SnsTimeLineUI.this.rNR.a(com.tencent.mm.ui.widget.QImageView.a.MATRIX);
                    if (((float) getDuration()) * f >= ((float) (getDuration() - 600)) || this.rPh) {
                        LayoutParams layoutParams = (LayoutParams) SnsTimeLineUI.this.rNR.getLayoutParams();
                        this.rPf = ((float) layoutParams.y) - (duration / 3.0f);
                        layoutParams.y = (int) this.rPf;
                        SnsTimeLineUI.this.rNR.setLayoutParams(layoutParams);
                    } else {
                        SnsTimeLineUI.this.rNR.mMatrix.postRotate(duration / 2.5f, this.rPb, this.rPc);
                    }
                    SnsTimeLineUI.this.rNR.invalidate();
                }
            }
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            this.rPg = 0.0f;
            this.rPf = this.rPd;
        }
    }

    public SnsTimeLineUI() {
        this.rNO = this.rNN != null ? this.rNN.bDt() : null;
        this.rNS = false;
        this.rNT = false;
        this.rxE = false;
        this.rNX = 0;
        this.rNY = false;
        this.rNZ = "";
        this.rOa = new com.tencent.mm.plugin.sns.h.a();
        this.rFX = new g(1);
        this.rOb = new au();
        this.rOc = new as();
        this.rOh = new Runnable() {
            public final void run() {
                ax a = SnsTimeLineUI.this.rNP;
                if (a != null) {
                    a.rPy.bCb();
                    a.rPy.notifyVendingDataChange();
                }
            }
        };
        this.rOi = new c<sf>() {
            {
                this.xmG = sf.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                SnsTimeLineUI.this.Ed().K(com.tencent.mm.plugin.sns.j.c.b.class);
                return false;
            }
        };
        this.rOj = false;
        this.rhc = false;
        this.rOk = new c<kn>() {
            {
                this.xmG = kn.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                if (((kn) bVar) instanceof kn) {
                    SnsTimeLineUI.this.rNN.rXX.b(SnsTimeLineUI.this.jPV, SnsTimeLineUI.this.rOe, SnsTimeLineUI.this.rzo, SnsTimeLineUI.this.rOf);
                    SnsTimeLineUI.this.rNP.notifyDataSetChanged();
                }
                return false;
            }
        };
        this.rOl = new c<ko>() {
            {
                this.xmG = ko.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                SnsTimeLineUI.this.rNP.notifyDataSetChanged();
                return false;
            }
        };
        this.rOm = new c<ke>() {
            {
                this.xmG = ke.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                SnsTimeLineUI.this.rOj = true;
                return false;
            }
        };
        this.rOn = new c<ki>() {
            {
                this.xmG = ki.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                ki kiVar = (ki) bVar;
                SnsTimeLineUI.this.rhc = true;
                SnsTimeLineUI.this.rOa.rhc = SnsTimeLineUI.this.rhc;
                SnsTimeLineUI.a(SnsTimeLineUI.this, kiVar.fCz.position);
                return false;
            }
        };
        this.rOo = new c<qn>() {
            {
                this.xmG = qn.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                if (SnsTimeLineUI.this.rNU != null) {
                    com.tencent.mm.plugin.sns.h.b bVar2 = SnsTimeLineUI.this.rNU.rxw.rcW;
                    bVar2.rhD++;
                    SnsTimeLineUI.this.rNU.rxw.rcW.iu(false);
                }
                return false;
            }
        };
        this.rOp = new c<pp>() {
            {
                this.xmG = pp.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                pp ppVar = (pp) bVar;
                if (SnsTimeLineUI.this.rNU != null) {
                    com.tencent.mm.plugin.sns.h.b bVar2 = SnsTimeLineUI.this.rNU.rxw.rcW;
                    String str = ppVar.fIk.fIl;
                    bVar2.riT.add(ppVar.fIk.fAR);
                    bVar2.rjb.add(str);
                    bVar2.rhE = bVar2.rjb.size();
                }
                return false;
            }
        };
        this.rOq = new c<qd>() {
            {
                this.xmG = qd.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                qd qdVar = (qd) bVar;
                if (SnsTimeLineUI.this.rNU != null) {
                    com.tencent.mm.plugin.sns.h.b bVar2;
                    if (qdVar.fIC.fID) {
                        bVar2 = SnsTimeLineUI.this.rNU.rxw.rcW;
                        bVar2.rjd.add(qdVar.fIC.username);
                        bVar2.rhG = bVar2.rjd.size();
                    } else {
                        bVar2 = SnsTimeLineUI.this.rNU.rxw.rcW;
                        bVar2.rje.add(qdVar.fIC.username);
                        bVar2.rhH = bVar2.rje.size();
                    }
                }
                return false;
            }
        };
        this.rOr = new c<qb>() {
            {
                this.xmG = qb.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                SnsTimeLineUI.this.rNP.rPy.notifyVendingDataChange();
                return false;
            }
        };
        this.rOs = new c<gm>() {
            {
                this.xmG = gm.class.getName().hashCode();
            }

            public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                gm gmVar = (gm) bVar;
                SnsTimeLineUI.a(SnsTimeLineUI.this, gmVar.fxt.fxw, gmVar.fxt.fxv, gmVar);
                return false;
            }
        };
        this.rdv = new c<f>() {
            {
                this.xmG = f.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                boolean z = true;
                f fVar = (f) bVar;
                if (!(SnsTimeLineUI.this.rNU == null || SnsTimeLineUI.this.rNU.rxw == null)) {
                    com.tencent.mm.plugin.sns.h.b bVar2 = SnsTimeLineUI.this.rNU.rxw.rcW;
                    boolean z2 = fVar.fnL.ahf;
                    String str = fVar.fnL.className;
                    if (str.toLowerCase().indexOf("sns") < 0 && str.toLowerCase().indexOf("sightuploadui") < 0 && !str.contains("WebViewUI")) {
                        z = false;
                    }
                    if (!z) {
                        x.d("MicroMsg.SnsBrowseInfoHelper", "handleActivityStatusChanged, not sns scene, className" + str + ",_active=" + z2);
                    } else if (!z2) {
                        bVar2.rii = System.currentTimeMillis();
                    } else if (bVar2.rii > 0) {
                        bVar2.rih += System.currentTimeMillis() - bVar2.rii;
                        bVar2.rii = 0;
                    }
                }
                return false;
            }
        };
        this.rOt = new c<pm>() {
            {
                this.xmG = pm.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                if (!(SnsTimeLineUI.this.rNU == null || SnsTimeLineUI.this.rNU.rxw == null)) {
                    SnsTimeLineUI.this.rNU.rxw.rcW.iD(true);
                }
                return false;
            }
        };
        this.rOu = new c<pq>() {
            {
                this.xmG = pq.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                pq pqVar = (pq) bVar;
                if (!(SnsTimeLineUI.this.rNU == null || SnsTimeLineUI.this.rNU.rxw == null)) {
                    SnsTimeLineUI.this.rNU.rxw.rcW.em(pqVar.fIm.fsC, pqVar.fIm.fAR);
                }
                return false;
            }
        };
        this.rOv = new c<pu>() {
            {
                this.xmG = pu.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                pu puVar = (pu) bVar;
                if (!(SnsTimeLineUI.this.rNU == null || SnsTimeLineUI.this.rNU.rxw == null)) {
                    com.tencent.mm.plugin.sns.h.b bVar2 = SnsTimeLineUI.this.rNU.rxw.rcW;
                    bVar2.riZ.add(puVar.fIq.fAR);
                }
                return false;
            }
        };
        this.rOw = new c<pv>() {
            {
                this.xmG = pv.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                pv pvVar = (pv) bVar;
                if (!(SnsTimeLineUI.this.rNU == null || SnsTimeLineUI.this.rNU.rxw == null)) {
                    com.tencent.mm.plugin.sns.h.b bVar2 = SnsTimeLineUI.this.rNU.rxw.rcW;
                    bVar2.riY.add(pvVar.fIr.fAR);
                }
                return false;
            }
        };
        this.rOx = new c<pw>() {
            {
                this.xmG = pw.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                pw pwVar = (pw) bVar;
                if (!(SnsTimeLineUI.this.rNU == null || SnsTimeLineUI.this.rNU.rxw == null)) {
                    com.tencent.mm.plugin.sns.h.b bVar2 = SnsTimeLineUI.this.rNU.rxw.rcW;
                    bVar2.riV.add(pwVar.fIs.fAR);
                }
                return false;
            }
        };
        this.rOy = 0;
        this.rOz = false;
        this.oTt = 0;
        this.rOA = new Runnable() {
            public final void run() {
                if (SnsTimeLineUI.this.rNP != null && SnsTimeLineUI.this.rOz) {
                    ae.bwc().pause();
                }
            }
        };
        this.rOB = new Runnable() {
            public final void run() {
                if (SnsTimeLineUI.this.rNP != null && !SnsTimeLineUI.this.rOz) {
                    x.v("MicroMsg.SnsTimeLineUI", "zeustest update onFling notify resume %s", Integer.valueOf(SnsTimeLineUI.this.rOg.nQn.getFirstVisiblePosition() - SnsTimeLineUI.this.rOg.nQn.getHeaderViewsCount()));
                    ae.bwc().start();
                    SnsTimeLineUI.this.rNP.rPx.bCm();
                }
            }
        };
        this.rOC = ((com.tencent.mm.vending.h.b) d.zLY.zMe).mHandler;
        this.rOD = new Runnable() {
            public final void run() {
                SnsTimeLineUI.this.cnL();
                SnsTimeLineUI.this.bCq();
                SnsTimeLineUI.this.setMMTitle(SnsTimeLineUI.this.getString(j.qSy));
                SnsTimeLineUI.this.rOy = 0;
                SnsTimeLineUI.this.oTt = SnsTimeLineUI.this.rOg.nQn.getFirstVisiblePosition();
            }
        };
        this.rOE = new com.tencent.mm.plugin.sns.ui.bb.a() {
            private int rOU = 0;
            private int rOV = 0;

            public final void bCt() {
                SnsTimeLineUI.this.rNN.rXY.b(SnsTimeLineUI.this.jPV, SnsTimeLineUI.this.rOe, false, SnsTimeLineUI.this.rOf);
                x.d("MicroMsg.SnsTimeLineUI", "onLoadingMore here");
                if (SnsTimeLineUI.this.rOC == null) {
                    x.e("MicroMsg.SnsTimeLineUI", "mLogicHandler handler null");
                } else if (SnsTimeLineUI.this.rNU != null) {
                    SnsTimeLineUI.this.rOC.removeCallbacks(SnsTimeLineUI.this.rOh);
                    SnsTimeLineUI.this.rOC.postDelayed(SnsTimeLineUI.this.rOh, 3000);
                }
            }

            public final ListView bCu() {
                if (SnsTimeLineUI.this.rNU.nQn == null) {
                    SnsTimeLineUI.this.rNU.nQn = (ListView) SnsTimeLineUI.this.findViewById(com.tencent.mm.plugin.sns.i.f.qLj);
                }
                return SnsTimeLineUI.this.rNU.nQn;
            }

            public final MMPullDownView bCv() {
                return (MMPullDownView) SnsTimeLineUI.this.findViewById(com.tencent.mm.plugin.sns.i.f.qLq);
            }

            public final int getType() {
                return 1;
            }

            public final void a(int i, List<Integer> list, List<Integer> list2) {
                int i2 = 1;
                if (i > 0) {
                    m xG = ae.bwf().xG(i);
                    if (xG != null) {
                        if (xG.field_pravited > 0) {
                            Toast.makeText(SnsTimeLineUI.this, j.qRb, 1).show();
                        }
                        if (xG.field_pravited == 1) {
                            i2 = 0;
                        }
                    }
                }
                if (i2 != 0) {
                    BackwardSupportUtil.c.a(SnsTimeLineUI.this.rOg.nQn);
                }
                if (SnsTimeLineUI.this.rNP != null) {
                    SnsTimeLineUI.this.rNP.rPy.notifyVendingDataChange();
                }
            }

            public final boolean bCw() {
                return SnsTimeLineUI.this.rxE;
            }

            public final void bCx() {
                SnsTimeLineUI.this.bAb();
                if (SnsTimeLineUI.this.rNR != null) {
                    x.d("MicroMsg.SnsTimeLineUI", "refreshIv onLoadingTap");
                    SnsTimeLineUI.this.rNR.setVisibility(0);
                }
                SnsTimeLineUI.this.rNN.rXX.b(SnsTimeLineUI.this.jPV, SnsTimeLineUI.this.rOe, SnsTimeLineUI.this.rzo, SnsTimeLineUI.this.rOf);
            }

            public final void bCy() {
                SnsTimeLineUI.this.bAb();
            }

            public final void ye(int i) {
                int firstVisiblePosition = SnsTimeLineUI.this.rOg.nQn.getFirstVisiblePosition();
                int lastVisiblePosition = SnsTimeLineUI.this.rOg.nQn.getLastVisiblePosition();
                if (firstVisiblePosition != this.rOU || lastVisiblePosition != this.rOV) {
                    com.tencent.mm.plugin.sns.h.a.a aVar;
                    this.rOU = firstVisiblePosition;
                    this.rOV = lastVisiblePosition;
                    x.i("MicroMsg.SnsTimeLineUI", "onListViewScoll %s %s %s", Integer.valueOf(firstVisiblePosition), Integer.valueOf(lastVisiblePosition), Integer.valueOf(i));
                    if (i == 2) {
                        HardCoderJNI.stopPerformace(HardCoderJNI.hcSNSScrollEnable, SnsTimeLineUI.this.hGs);
                        SnsTimeLineUI.this.hGs = HardCoderJNI.startPerformance(HardCoderJNI.hcSNSScrollEnable, HardCoderJNI.hcSNSScrollDelay, HardCoderJNI.hcSNSScrollCPU, HardCoderJNI.hcSNSScrollIO, HardCoderJNI.hcSNSScrollThr ? Process.myTid() : 0, HardCoderJNI.hcSNSScrollTimeout, 701, HardCoderJNI.hcSNSScrollAction, "MicroMsg.SnsTimeLineUI");
                        x.i("MicroMsg.SnsTimeLineUI", "summer hardcoder sns startPerformance [%s]", Integer.valueOf(SnsTimeLineUI.this.hGs));
                    }
                    com.tencent.mm.plugin.sns.h.a f = SnsTimeLineUI.this.rOa;
                    av avVar = SnsTimeLineUI.this.rNP.rPx;
                    firstVisiblePosition = com.tencent.mm.modelsns.c.hQE;
                    if (firstVisiblePosition == 2) {
                        aVar = null;
                    } else if (firstVisiblePosition != 4 || f.rhc) {
                        long nanoTime = System.nanoTime();
                        com.tencent.mm.plugin.sns.h.a.a aVar2 = new com.tencent.mm.plugin.sns.h.a.a();
                        aVar2.rhd = System.currentTimeMillis();
                        aVar2.mScreenHeight = f.mScreenHeight;
                        aVar2.mScreenWidth = f.mScreenWidth;
                        lastVisiblePosition = f.rhb.getTop();
                        firstVisiblePosition = f.rhb.getHeight();
                        if (lastVisiblePosition < 0) {
                            firstVisiblePosition += lastVisiblePosition;
                        }
                        aVar2.rhf = firstVisiblePosition;
                        lastVisiblePosition = f.ipH.getFirstVisiblePosition() - 1;
                        int lastVisiblePosition2 = f.ipH.getLastVisiblePosition() - 1;
                        aVar2.rhe = lastVisiblePosition;
                        aVar2.mZw = lastVisiblePosition2;
                        int count = avVar.getCount();
                        boolean z = false;
                        if (f.ipH.getChildAt(0) != null) {
                            z = f.ipH.getChildAt(0) instanceof SnsHeader;
                        }
                        x.v("MicroMsg.CaptureSnsHelper", "first last %s %s isHeaderExist %s", Integer.valueOf(lastVisiblePosition), Integer.valueOf(lastVisiblePosition2), Boolean.valueOf(z));
                        firstVisiblePosition = z ? 1 : 0;
                        int childCount = f.ipH.getChildCount();
                        int i2 = lastVisiblePosition;
                        while (i2 <= lastVisiblePosition2) {
                            if (i2 < count && i2 >= 0) {
                                if (firstVisiblePosition >= childCount) {
                                    x.e("MicroMsg.CaptureSnsHelper", "childPos biger than childCount %d %d", Integer.valueOf(firstVisiblePosition), Integer.valueOf(childCount));
                                } else {
                                    int left;
                                    int height;
                                    int width;
                                    if (aVar2.rhg == null) {
                                        aVar2.rhg = new LinkedList();
                                    }
                                    com.tencent.mm.plugin.sns.h.a.b bVar = new com.tencent.mm.plugin.sns.h.a.b();
                                    aVar2.rhg.add(bVar);
                                    View childAt = f.ipH.getChildAt(firstVisiblePosition);
                                    lastVisiblePosition = firstVisiblePosition + 1;
                                    if (childAt != null) {
                                        firstVisiblePosition = childAt.getTop();
                                        left = childAt.getLeft();
                                        height = childAt.getHeight();
                                        width = childAt.getWidth();
                                        m xL = avVar.xL(i2);
                                        bVar.rhl = com.tencent.mm.plugin.sns.data.i.g(xL);
                                        bVar.rhj = xL.field_type;
                                        bVar.rhk = xL.xD(32);
                                        bVar.rhh = firstVisiblePosition;
                                        bVar.rhi = left;
                                        bVar.kkv = height;
                                        bVar.kku = width;
                                    }
                                    if (!(childAt == null || childAt.getTag() == null || !(childAt.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c))) {
                                        com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) childAt.getTag();
                                        if (cVar.rUm && cVar.rwJ != null) {
                                            int top = cVar.rwJ.getTop();
                                            left = cVar.rwJ.getLeft();
                                            height = cVar.rUe.getHeight();
                                            width = cVar.rUe.getWidth();
                                            int top2 = cVar.rUf.getTop() + top;
                                            int left2 = cVar.rUf.getLeft() + left;
                                            int height2 = cVar.rUf.getHeight();
                                            int width2 = cVar.rUf.getWidth();
                                            x.v("MicroMsg.CaptureSnsHelper", "holder position %s %s index %s", Integer.valueOf(cVar.position), Integer.valueOf(i2), Integer.valueOf(lastVisiblePosition));
                                            if (cVar.qUf.wUP != 0) {
                                                bVar.rhn = cVar.qUf.wUP;
                                                bVar.rho = top;
                                                bVar.rhp = left;
                                                bVar.rhq = width;
                                                bVar.rhr = height;
                                            }
                                            if (cVar.qUf.wUS != 0) {
                                                bVar.rhm = cVar.qUf.wUS;
                                                bVar.rht = left2;
                                                bVar.rhs = top2;
                                                bVar.rhu = width2;
                                                bVar.rhv = height2;
                                            }
                                        }
                                    }
                                    firstVisiblePosition = lastVisiblePosition;
                                }
                            }
                            i2++;
                        }
                        x.i("MicroMsg.CaptureSnsHelper", "end cap: " + (System.nanoTime() - nanoTime));
                        aVar = aVar2;
                    } else {
                        aVar = null;
                    }
                    com.tencent.mm.vending.g.g.cAN().c(new com.tencent.mm.vending.c.a<Void, Void>() {
                        public final /* synthetic */ Object call(Object obj) {
                            Void voidR = (Void) obj;
                            if (aVar != null) {
                                com.tencent.mm.plugin.sns.h.a.a aVar = aVar;
                                com.tencent.mm.modelsns.b ix = com.tencent.mm.modelsns.b.ix(HardCoderJNI.SCENE_DB);
                                ix.hQu = aVar.rhd;
                                ix.iA(aVar.mScreenWidth).iA(aVar.mScreenHeight);
                                ix.iA(aVar.rhf);
                                ix.iA(0);
                                ix.iA(aVar.rhe);
                                ix.iA(aVar.mZw);
                                ix.SE();
                                if (aVar.rhg != null) {
                                    for (com.tencent.mm.plugin.sns.h.a.b bVar : aVar.rhg) {
                                        com.tencent.mm.modelsns.b ix2 = com.tencent.mm.modelsns.b.ix(502);
                                        ix2.hQu = aVar.rhd;
                                        ix2.mF(bVar.rhl).iA(bVar.rhj).bW(bVar.rhk).iA(bVar.rhi).iA(bVar.rhh).iA(bVar.kku).iA(bVar.kkv);
                                        ix2.SE();
                                        x.v("MicroMsg.CaptureSnsHelper", "rootview top left %s %s viewWidth: %s viewHeight: %s", Integer.valueOf(bVar.rhh), Integer.valueOf(bVar.rhi), Integer.valueOf(bVar.kku), Integer.valueOf(bVar.kkv));
                                        x.v("MicroMsg.CaptureSnsHelper", "like %s %s likeheight: %s likewidth: %s", Integer.valueOf(bVar.rho), Integer.valueOf(bVar.rhp), Integer.valueOf(bVar.rhr), Integer.valueOf(bVar.rhq));
                                        x.v("MicroMsg.CaptureSnsHelper", "comment %s %s commentheight: %s commentwidth: %s", Integer.valueOf(bVar.rhs), Integer.valueOf(bVar.rht), Integer.valueOf(bVar.rhv), Integer.valueOf(bVar.rhu));
                                        if (bVar.rhn != 0) {
                                            ix2 = com.tencent.mm.modelsns.b.ix(503);
                                            ix2.hQu = aVar.rhd;
                                            ix2.mF(bVar.rhl).iA(bVar.rhj).bW(bVar.rhk).iA(bVar.rhn).iA(bVar.rhp).iA(bVar.rho).iA(bVar.rhq).iA(bVar.rhr);
                                            ix2.SE();
                                        }
                                        if (bVar.rhm != 0) {
                                            ix2 = com.tencent.mm.modelsns.b.ix(504);
                                            ix2.hQu = aVar.rhd;
                                            ix2.mF(bVar.rhl).iA(bVar.rhj).bW(bVar.rhk).iA(bVar.rhm).iA(bVar.rht).iA(bVar.rhs).iA(bVar.rhu).iA(bVar.rhv);
                                            ix2.SE();
                                        }
                                    }
                                }
                                ix = com.tencent.mm.modelsns.b.ix(506);
                                ix.hQu = aVar.rhd;
                                ix.SE();
                            }
                            return voidR;
                        }
                    });
                }
            }

            public final void M(int i, boolean z) {
                if (SnsTimeLineUI.this.rNP != null) {
                    SnsTimeLineUI.this.rNP.rPy.notifyVendingDataChange();
                }
                if (!z) {
                    SnsTimeLineUI.this.Ed().K(com.tencent.mm.plugin.sns.j.c.b.class);
                }
            }

            public final void iQ(boolean z) {
                SnsTimeLineUI snsTimeLineUI = SnsTimeLineUI.this;
                snsTimeLineUI.rOz = z;
                ag aOA = ae.aOA();
                com.tencent.mm.plugin.sns.model.g bwc = ae.bwc();
                com.tencent.mm.plugin.sns.model.b bwa = ae.bwa();
                if (z) {
                    if (bwc.qYE || bwa.qYE) {
                        aOA.removeCallbacks(snsTimeLineUI.rOA);
                        aOA.removeCallbacks(snsTimeLineUI.rOB);
                        aOA.postDelayed(snsTimeLineUI.rOA, 0);
                    }
                } else if (!bwc.qYE || !bwa.qYE) {
                    aOA.removeCallbacks(snsTimeLineUI.rOA);
                    aOA.removeCallbacks(snsTimeLineUI.rOB);
                    aOA.postDelayed(snsTimeLineUI.rOB, 0);
                }
            }
        };
        this.rOF = new com.tencent.mm.vending.app.a.b<com.tencent.mm.plugin.sns.j.c.b>() {
            public final /* synthetic */ void aX(Object obj) {
                com.tencent.mm.plugin.sns.j.c.b bVar = (com.tencent.mm.plugin.sns.j.c.b) obj;
                if (bVar.rYb > 0) {
                    SnsTimeLineUI.a(SnsTimeLineUI.this, bVar);
                    SnsTimeLineUI.this.rNQ.findViewById(com.tencent.mm.plugin.sns.i.f.qLd).setVisibility(0);
                } else {
                    SnsTimeLineUI.this.rNQ.findViewById(com.tencent.mm.plugin.sns.i.f.qLd).setVisibility(8);
                }
                if (SnsTimeLineUI.this.rOg.rhb != null && SnsTimeLineUI.this.rOg.rhb.bBE()) {
                    SnsTimeLineUI.this.rNQ.setVisibility(0);
                } else if (bVar.rYb == 0) {
                    SnsTimeLineUI.this.rNQ.setVisibility(8);
                }
                if (SnsTimeLineUI.this.rNP != null && SnsTimeLineUI.this.rNW.hasDrawed()) {
                    SnsTimeLineUI.this.rNP.rPy.notifyVendingDataChange();
                    x.i("MicroMsg.SnsTimeLineUI", "has not show view, pass");
                }
            }
        };
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.rOG = true;
        this.kIK = 0;
        this.rOI = new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SnsTimeLineUI.this.aWY();
                SnsTimeLineUI.this.finish();
                return false;
            }
        };
        this.rON = null;
        this.rOO = new OnClickListener() {
            public final void onClick(View view) {
                if (SystemClock.elapsedRealtime() - SnsTimeLineUI.this.rNM < 300) {
                    SnsTimeLineUI.E(SnsTimeLineUI.this);
                }
                SnsTimeLineUI.this.rNM = SystemClock.elapsedRealtime();
                ae.aOA().removeCallbacks(SnsTimeLineUI.this.rOD);
                SnsTimeLineUI.this.rOD.run();
            }
        };
        this.rOP = false;
    }

    static /* synthetic */ void C(SnsTimeLineUI snsTimeLineUI) {
        int i = 1;
        if (snsTimeLineUI.rNX <= 3) {
            int firstVisiblePosition = snsTimeLineUI.rOg.nQn.getFirstVisiblePosition();
            if (System.currentTimeMillis() - snsTimeLineUI.rOy > 1000 || firstVisiblePosition > snsTimeLineUI.oTt) {
                snsTimeLineUI.rOy = 0;
                snsTimeLineUI.oTt = snsTimeLineUI.rOg.nQn.getFirstVisiblePosition();
            }
            snsTimeLineUI.rOy = System.currentTimeMillis();
            if (snsTimeLineUI.oTt - firstVisiblePosition >= 10 && firstVisiblePosition > 10) {
                x.i("MicroMsg.SnsTimeLineUI", "showTopTip %d", Integer.valueOf(snsTimeLineUI.rNX));
                if (snsTimeLineUI.rNX <= 3) {
                    p pVar = snsTimeLineUI.mController;
                    if (pVar.mActionBar == null || pVar.mActionBar.getCustomView() == null || pVar.mActionBar.getCustomView().findViewById(com.tencent.mm.v.a.g.gWS) == null) {
                        i = 0;
                    }
                    if (i == 0) {
                        Animation loadAnimation = AnimationUtils.loadAnimation(snsTimeLineUI.mController.xRr, com.tencent.mm.plugin.sns.i.a.qEw);
                        CharSequence string = snsTimeLineUI.getString(j.qQr);
                        p pVar2 = snsTimeLineUI.mController;
                        if (pVar2.mActionBar != null) {
                            pVar2.mActionBar.setCustomView(p.xRJ);
                            TextView textView = (TextView) pVar2.mActionBar.getCustomView().findViewById(com.tencent.mm.v.a.g.gWS);
                            if (textView != null) {
                                textView.clearAnimation();
                                if (loadAnimation != null) {
                                    textView.startAnimation(loadAnimation);
                                }
                                if (!bi.oN(string)) {
                                    textView.setText(string);
                                }
                            }
                        }
                        snsTimeLineUI.mController.removeAllOptionMenu();
                        snsTimeLineUI.removeOptionMenu(16908332);
                        snsTimeLineUI.bCp();
                        snsTimeLineUI.rNX++;
                        ae.aOA().removeCallbacks(snsTimeLineUI.rOD);
                        ae.aOA().postDelayed(snsTimeLineUI.rOD, 4000);
                    }
                }
            }
        }
    }

    static /* synthetic */ void E(SnsTimeLineUI snsTimeLineUI) {
        x.i("MicroMsg.SnsTimeLineUI", "double click");
        BackwardSupportUtil.c.a(snsTimeLineUI.rOg.nQn);
        snsTimeLineUI.rNR.setVisibility(0);
        snsTimeLineUI.rOD.run();
        snsTimeLineUI.rNU.bzO();
        snsTimeLineUI.bAb();
        new ag().postDelayed(new Runnable() {
            public final void run() {
                SnsTimeLineUI.this.rOg.nQn.setSelection(0);
                a z = SnsTimeLineUI.this.rNV;
                if (z.rPj) {
                    LayoutParams layoutParams = (LayoutParams) z.rOQ.rNR.getLayoutParams();
                    layoutParams.y = z.rPk;
                    z.rOQ.rNR.setLayoutParams(layoutParams);
                    z.rPd = z.rPl;
                    z.rPf = z.rPm;
                }
                SnsTimeLineUI.this.rNV.bCC();
                SnsTimeLineUI.this.rNN.rXX.b(SnsTimeLineUI.this.jPV, SnsTimeLineUI.this.rOe, SnsTimeLineUI.this.rzo, SnsTimeLineUI.this.rOf);
            }
        }, 300);
    }

    static /* synthetic */ void F(SnsTimeLineUI snsTimeLineUI) {
        snsTimeLineUI.bCr();
        if (!(snsTimeLineUI.rNU == null || snsTimeLineUI.rNU.rxw == null)) {
            snsTimeLineUI.rNU.rxw.rcW.iu(true);
        }
        final com.tencent.mm.modelsns.b ix = com.tencent.mm.modelsns.b.ix(705);
        ix.iB(ix.hQt).mG(System.currentTimeMillis()).iB(ix.hQv).iB(1);
        snsTimeLineUI.rON = new ba(snsTimeLineUI);
        snsTimeLineUI.rON.rQF = new com.tencent.mm.ui.base.p.c() {
            public final void a(n nVar) {
                if (!r.igH) {
                    nVar.f(3, SnsTimeLineUI.this.getString(j.dFh));
                }
                nVar.f(1, SnsTimeLineUI.this.getString(j.dFl));
            }
        };
        snsTimeLineUI.rON.d(3, snsTimeLineUI.mController.xRr.getString(j.qPw));
        snsTimeLineUI.rON.rQG = new com.tencent.mm.ui.base.p.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1:
                        com.tencent.mm.plugin.report.service.g.pWK.h(13822, Integer.valueOf(2), Integer.valueOf(2));
                        com.tencent.mm.plugin.sns.h.e.rjJ.b(ix);
                        ix.SE();
                        SnsTimeLineUI.this.rOg.rRo = ix;
                        SnsTimeLineUI.this.rOg.yi(1);
                        return;
                    case 3:
                        SnsTimeLineUI.this.bCs();
                        return;
                    default:
                        return;
                }
            }
        };
        snsTimeLineUI.rON.bCH();
    }

    static /* synthetic */ void a(SnsTimeLineUI snsTimeLineUI, int i) {
        com.tencent.mm.modelsns.b ix = com.tencent.mm.modelsns.b.ix(507);
        int firstVisiblePosition = snsTimeLineUI.rOg.nQn.getFirstVisiblePosition() - 1;
        int lastVisiblePosition = snsTimeLineUI.rOg.nQn.getLastVisiblePosition() - 1;
        int count = snsTimeLineUI.rNP.getCount();
        while (firstVisiblePosition <= lastVisiblePosition) {
            if (firstVisiblePosition < count && firstVisiblePosition >= 0 && firstVisiblePosition != i) {
                if (i > firstVisiblePosition) {
                    String g = com.tencent.mm.plugin.sns.data.i.g(snsTimeLineUI.rNU.rfY.xL(firstVisiblePosition));
                    if (ix.SA()) {
                        if (ix.hQB.length() != 0) {
                            ix.hQB.append("||" + g);
                        } else if (bi.oN(g)) {
                            ix.hQB.append(" ");
                        } else {
                            ix.hQB.append(g);
                        }
                    }
                } else {
                    ix.mF(com.tencent.mm.plugin.sns.data.i.g(snsTimeLineUI.rNU.rfY.xL(firstVisiblePosition)));
                }
            }
            firstVisiblePosition++;
        }
        ix.SE();
    }

    static /* synthetic */ void a(SnsTimeLineUI snsTimeLineUI, int i, int i2, gm gmVar) {
        int firstVisiblePosition = snsTimeLineUI.rNU.nQn.getFirstVisiblePosition();
        int headerViewsCount = snsTimeLineUI.rNU.nQn.getHeaderViewsCount();
        m xL = snsTimeLineUI.rNU.rfY.xL(i2);
        if (xL != null) {
            bpb byF = xL.byF();
            if (byF.wYj.wfg == 1 && byF.wYj.wfh.size() == 4 && i > 1) {
                i++;
            }
        } else {
            x.e("MicroMsg.SnsTimeLineUI", "snsInfo is null");
        }
        View childAt = snsTimeLineUI.rNU.nQn.getChildAt((i2 - firstVisiblePosition) + headerViewsCount);
        if (childAt != null && childAt.getTag() != null && (childAt.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c)) {
            com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) childAt.getTag();
            if (cVar.rUj != null) {
                TagImageView xQ = cVar.rUj.xQ(i);
                if (xQ != null) {
                    int[] iArr = new int[2];
                    xQ.getLocationInWindow(iArr);
                    gmVar.fxu.fpF = iArr[0];
                    gmVar.fxu.fpG = iArr[1];
                    gmVar.fxu.fpH = xQ.getWidth();
                    gmVar.fxu.fpI = xQ.getHeight();
                }
            }
        }
    }

    static /* synthetic */ void a(SnsTimeLineUI snsTimeLineUI, com.tencent.mm.plugin.sns.j.c.b bVar) {
        snsTimeLineUI.rNQ.setVisibility(0);
        ((TextView) snsTimeLineUI.findViewById(com.tencent.mm.plugin.sns.i.f.qLg)).setText(snsTimeLineUI.getResources().getQuantityString(h.qOy, bVar.rYb, new Object[]{Integer.valueOf(bVar.rYb)}));
        com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) snsTimeLineUI.findViewById(com.tencent.mm.plugin.sns.i.f.qLe), bVar.rYa);
    }

    public final void a(final boolean z, final boolean z2, final String str, boolean z3, boolean z4, int i, long j) {
        this.rOC.removeCallbacks(this.rOh);
        com.tencent.mm.vending.g.g.cAN().c(new com.tencent.mm.vending.c.a<Void, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                Void voidR = (Void) obj;
                ax a = SnsTimeLineUI.this.rNP;
                if (a != null) {
                    a.rPy.rCC = str;
                    aw awVar = a.rPy;
                    awVar.looperCheckForVending();
                    x.i("MicroMsg.SnsTimeLineVendingSide", "resetSize %s", Boolean.valueOf(awVar.rPr));
                    if (!awVar.rPr) {
                        synchronized (awVar.rPs) {
                            awVar.mgB = awVar.q(0, awVar.mgB);
                        }
                    }
                    a.rPy.notifyVendingDataChange();
                }
                return voidR;
            }
        }).e(new com.tencent.mm.vending.c.a<Void, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                Void voidR = (Void) obj;
                SnsTimeLineUI.this.rOg.rRk = z2;
                if (z2) {
                    SnsTimeLineUI.this.rOg.iJ(false);
                } else if (z) {
                    SnsTimeLineUI.this.rNN.rXY.b("@__weixintimtline", SnsTimeLineUI.this.rOe, SnsTimeLineUI.this.rzo, 0);
                }
                return voidR;
            }
        });
    }

    public final void a(final boolean z, final String str, boolean z2, boolean z3, int i, long j) {
        this.rOC.removeCallbacks(this.rOh);
        com.tencent.mm.vending.g.g.cAN().c(new com.tencent.mm.vending.c.a<Void, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                Void voidR = (Void) obj;
                ax a = SnsTimeLineUI.this.rNP;
                if (a != null) {
                    a.rPy.rCC = str;
                    a.rPy.bCb();
                    a.rPy.notifyVendingDataChange();
                }
                return voidR;
            }
        }).e(new com.tencent.mm.vending.c.a<Void, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                Void voidR = (Void) obj;
                SnsTimeLineUI.this.rOg.rRk = z;
                x.d("MicroMsg.SnsTimeLineUI", "onNpSize %s", Boolean.valueOf(z));
                if (z) {
                    SnsTimeLineUI.this.rOg.iJ(false);
                }
                return voidR;
            }
        });
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i = 0;
        x.i("MicroMsg.SnsTimeLineUI", "dispatchKeyEvent %s", keyEvent.toString());
        int i2 = this.mController.xRL;
        j jVar = this.rNU;
        if (keyEvent.getKeyCode() == 4 && jVar.rxz.getVisibility() == 0) {
            jVar.rxz.setVisibility(8);
            i = 1;
        }
        if (i == 0 || i2 != 2) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public void onCreate(Bundle bundle) {
        int i = 1;
        if (this.mController != null) {
            this.mController.ae(2, true);
        }
        getIntent().setExtrasClassLoader(getClass().getClassLoader());
        com.tencent.mm.pluginsdk.e.h(this);
        super.onCreate(bundle);
        if (com.tencent.mm.kernel.g.Do().CF()) {
            int dd = com.tencent.mm.y.c.c.IM().dd("Sns_Private_Recent_Setting_Guide", 0);
            x.i("MicroMsg.SnsTimeLineUI", "Sns_Private_Recent_Setting_Guide abtestvalue = " + dd);
            if (dd == 1) {
                com.tencent.mm.kernel.g.Dr();
                if (!com.tencent.mm.kernel.g.Dq().Db().getBoolean(com.tencent.mm.storage.w.a.USERINFO_SNS_INTRODUCE_SETTING_DISPLAY_BOOLEAN_SYNC, false)) {
                    Intent intent = getIntent();
                    intent.setClass(this.mController.xRr, SnsSettingIntroduceUI.class);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                    finish();
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_SNS_INTRODUCE_SETTING_DISPLAY_BOOLEAN_SYNC, Boolean.valueOf(true));
                }
            }
            com.tencent.mm.bz.b.cme();
            this.rNO.a(com.tencent.mm.plugin.sns.j.c.b.class, this.rOF);
            this.rNO.a(this);
            com.tencent.mm.plugin.sns.j.c.a aVar = (com.tencent.mm.plugin.sns.j.c.a) this.rNO.J(com.tencent.mm.plugin.sns.j.c.a.class);
            this.jPV = aVar.jPV;
            this.rOd = aVar.rOd;
            this.rOe = aVar.rOe;
            this.rzo = aVar.rzo;
            this.rOf = aVar.rOf;
            String str = aVar.nqW;
            String str2 = aVar.rRn;
            this.rOg = new bb(this);
            this.rOg.rRm = this.rOE;
            ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.notification.b.a.class)).getNotification().fn(2);
            com.tencent.mm.plugin.sns.ui.widget.d.bDp().rXM = 0;
            com.tencent.mm.plugin.sns.ui.widget.b.bDn().rXM = 0;
            com.tencent.mm.modelsns.c cVar = com.tencent.mm.modelsns.c.hQF;
            com.tencent.mm.modelsns.c.SF();
            this.rNU = new j(this, getIntent().getBooleanExtra("is_sns_notify_open", true) ? 1 : 0, bi.aD(getIntent().getStringExtra("new_feed_id"), ""), getIntent().getIntExtra("sns_unread_count", 0));
            this.rxE = getIntent().getBooleanExtra("sns_resume_state", true);
            if (ae.bvO()) {
                this.rxE = false;
            } else if (this.rxE) {
                this.rxE = ae.bwm().bAK();
            }
            this.rNS = this.rxE;
            this.rOg.a(this.rOd, this.jPV, str, str2, this.rOe, this.rzo, this.rOf);
            this.rOg.onCreate();
            ae.bvW().init();
            this.mActionBar = getSupportActionBar();
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.a((int) com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX, (e) this);
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.a(682, (e) this);
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.a(218, (e) this);
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.a((int) com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX, (e) this);
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.a(683, (e) this);
            initView();
            com.tencent.mm.plugin.sns.f.c bvW = ae.bvW();
            ListView listView = this.rOg.nQn;
            av avVar = this.rNP.rPx;
            bvW.rfX = listView;
            bvW.rfY = avVar;
            e bvW2 = ae.bvW();
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.a((int) JsApiCreateAudioInstance.CTRL_INDEX, bvW2);
            this.rNT = getIntent().getBooleanExtra("sns_timeline_NeedFirstLoadint", false);
            this.rNU.mCW = (ClipboardManager) getSystemService("clipboard");
            if (ae.bvO()) {
                this.rxE = false;
            } else if (this.rxE) {
                this.rxE = ae.bwm().bAK();
            }
            com.tencent.mm.vending.app.a aVar2 = this.rNO;
            aVar2.rPy = this.rNP.rPy;
            aVar2.zKb.keep(aVar2.rPy);
            if (this.rxE) {
                this.rNT = false;
                dd = ae.bwm().position;
                aw awVar = this.rNP.rPy;
                String str3 = ae.bwm().mgB;
                synchronized (awVar.rPs) {
                    awVar.mgB = str3;
                }
                this.rNP.rPy.rCC = ae.bwm().rCC;
                this.rNP.rPy.rPr = true;
                this.rNP.kt();
                if (dd >= this.rNP.getCount()) {
                    dd = this.rNP.getCount() - 1;
                    x.e("MicroMsg.SnsTimeLineUI", "error position %s", Integer.valueOf(this.rNP.getCount()));
                }
                this.rOg.nQn.setAdapter(this.rNP);
                x.d("MicroMsg.SnsTimeLineUI", "resume position %s", Integer.valueOf(ae.bwm().rCD));
                this.rOg.nQn.setSelectionFromTop(dd, ae.bwm().rCD);
                this.rNR.setVisibility(4);
            } else {
                this.rOg.nQn.setAdapter(this.rNP);
                this.rNR.setVisibility(0);
                this.rNP.kt();
            }
            int count = this.rNP.getCount();
            dd = this.rOg.nQn.getFirstVisiblePosition();
            if (dd < count) {
                this.rNZ = com.tencent.mm.plugin.sns.data.i.g(this.rNP.xL(dd));
            }
            com.tencent.mm.kernel.g.Dr();
            this.rNX = ((Integer) com.tencent.mm.kernel.g.Dq().Db().get(327776, Integer.valueOf(0))).intValue();
            this.rNU.rxG = new bh(this, this.rNP.rPx, this.rNU.rft);
            this.rNU.rxI = new com.tencent.mm.plugin.sns.f.b(this, this.rNP.rPx.rfs, this.rNU.rft);
            this.rNU.rxH = new c(this, this.rNP.rPx.rfs, this.rNU.rft, this.rNU.rxI);
            if (this.rOc != null) {
                this.rOc.a(this.rNU.rxI);
            }
            if (count > 0) {
                m xL = this.rNP.xL(0);
                if (!(this.rNU.rxw == null || this.rNU.rxw.rcW == null)) {
                    this.rNU.rxw.rcW.rhx = xL.field_snsId;
                }
                com.tencent.mm.plugin.sns.h.d dVar = com.tencent.mm.plugin.sns.h.d.rjE;
                if (dVar.gNG != 0) {
                    if (dVar.rjF.isEmpty()) {
                        dVar.gAD.setLong(2, bi.Wx());
                        dVar.rjG.clear();
                    }
                    x.i("MicroMsg.SnsReportHelper", "enterTimeLine exposureFeedSize %d", Integer.valueOf(dVar.rjF.size()));
                }
            }
            com.tencent.mm.plugin.report.service.g.pWK.k(13312, "1," + bi.Wy());
            com.tencent.mm.sdk.b.a.xmy.b(this.rOi);
            if (getIntent().getBooleanExtra("is_need_resend_sns", false)) {
                ah.h(new Runnable() {
                    public final void run() {
                        com.tencent.mm.ui.base.h.a(SnsTimeLineUI.this, SnsTimeLineUI.this.getString(j.ezg), "", SnsTimeLineUI.this.getString(j.ezh), SnsTimeLineUI.this.getString(j.dEy), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.sdk.b.a.xmy.m(new nr());
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.sdk.b.a.xmy.m(new ku());
                            }
                        });
                    }
                }, 500);
                getIntent().putExtra("is_need_resend_sns", false);
            }
            com.tencent.mm.kernel.g.Dr();
            if (com.tencent.mm.kernel.g.Do().CF()) {
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dq().Db().set(589825, Boolean.valueOf(false));
            }
            this.rNU.rxv = this.rFX;
            g gVar = this.rFX;
            count = this.rOg.qUk;
            View customView = this.mActionBar.getCustomView();
            gVar.qUk = count;
            gVar.qVd = customView;
            gVar.activity = this;
            com.tencent.mm.sdk.b.a.xmy.b(this.rOm);
            com.tencent.mm.sdk.b.a.xmy.b(this.rOn);
            com.tencent.mm.sdk.b.a.xmy.b(this.rOo);
            com.tencent.mm.sdk.b.a.xmy.b(this.rOp);
            com.tencent.mm.sdk.b.a.xmy.b(this.rOq);
            com.tencent.mm.sdk.b.a.xmy.b(this.rOs);
            com.tencent.mm.sdk.b.a.xmy.b(this.rOr);
            com.tencent.mm.sdk.b.a.xmy.b(this.rdv);
            com.tencent.mm.sdk.b.a.xmy.b(this.rOt);
            com.tencent.mm.sdk.b.a.xmy.b(this.rOu);
            com.tencent.mm.sdk.b.a.xmy.b(this.rOw);
            com.tencent.mm.sdk.b.a.xmy.b(this.rOv);
            com.tencent.mm.sdk.b.a.xmy.b(this.rOx);
            com.tencent.mm.plugin.sns.abtest.c.buE();
            com.tencent.mm.plugin.sns.abtest.a.d(this, this.rNU.rft);
            if (this.rOa != null) {
                com.tencent.mm.plugin.sns.h.a aVar3 = this.rOa;
                listView = this.rOg.nQn;
                SnsHeader snsHeader = this.rOg.rhb;
                aVar3.ipH = listView;
                aVar3.rhb = snsHeader;
            }
            if (!(this.rNU == null || this.rNU.rxw == null)) {
                com.tencent.mm.plugin.sns.h.b bVar = this.rNU.rxw.rcW;
                x.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineCreate");
                bVar.rhw = true;
                bVar.rjt = System.currentTimeMillis();
            }
            boolean booleanExtra = getIntent().getBooleanExtra("enter_by_red", false);
            if (!(this.rNU == null || this.rNU.rxw == null)) {
                com.tencent.mm.plugin.sns.h.b bVar2 = this.rNU.rxw.rcW;
                if (!booleanExtra) {
                    i = 0;
                }
                bVar2.rhJ = i;
            }
            ae.bwc().qYY.clear();
            com.tencent.mm.pluginsdk.e.i(this);
            return;
        }
        finish();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        x.i("MicroMsg.SnsTimeLineUI", "onConfigurationChanged");
        com.tencent.mm.sdk.b.a.xmy.m(new bu());
        com.tencent.mm.pluginsdk.e.i(this);
        com.tencent.mm.plugin.sns.ui.widget.d.bDp().rXM = 0;
        com.tencent.mm.plugin.sns.ui.widget.b.bDn().rXM = 0;
        com.tencent.mm.kiss.widget.textview.c.gUU.Ei();
        this.rNP.rPx.bCh();
        this.rNP.rPy.resolvedClear();
    }

    public void onDestroy() {
        long j;
        int i;
        String str;
        int i2;
        this.rNY = true;
        x.i("MicroMsg.SnsTimeLineUI", "timeline on destory");
        com.tencent.mm.sdk.b.a.xmy.c(this.rOm);
        com.tencent.mm.sdk.b.a.xmy.c(this.rOn);
        com.tencent.mm.sdk.b.a.xmy.c(this.rOo);
        com.tencent.mm.sdk.b.a.xmy.c(this.rOp);
        com.tencent.mm.sdk.b.a.xmy.c(this.rOq);
        com.tencent.mm.sdk.b.a.xmy.c(this.rOs);
        com.tencent.mm.sdk.b.a.xmy.c(this.rOr);
        com.tencent.mm.sdk.b.a.xmy.c(this.rdv);
        com.tencent.mm.sdk.b.a.xmy.c(this.rOt);
        com.tencent.mm.sdk.b.a.xmy.c(this.rOu);
        com.tencent.mm.sdk.b.a.xmy.c(this.rOv);
        com.tencent.mm.sdk.b.a.xmy.c(this.rOw);
        com.tencent.mm.sdk.b.a.xmy.c(this.rOx);
        if (!(this.rNU == null || this.rNU.rxw == null)) {
            this.rNU.rxw.rcW.rhK = this.rOj ? 1 : 0;
        }
        com.tencent.mm.plugin.sns.h.d dVar = com.tencent.mm.plugin.sns.h.d.rjE;
        if (dVar.gNG != 0) {
            x.i("MicroMsg.SnsReportHelper", "exitTimeline exposureFeedSize %d, exposureAppIdSize %d", Integer.valueOf(dVar.rjF.size()), Integer.valueOf(dVar.rjG.size()));
            j = dVar.gAD.getLong(2, 0);
            if (dVar.rjF.isEmpty() || (dVar.rjF.size() <= dVar.rjH && bi.bz(j) <= ((long) dVar.rjI))) {
                dVar.gAD.set(3, dVar.rjF);
                dVar.gAD.set(4, dVar.rjG);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                i = 0;
                for (String str2 : dVar.rjF.keySet()) {
                    String str3 = (String) dVar.rjG.get(str2);
                    if (bi.oN(str3)) {
                        str3 = "";
                    } else {
                        i = 1;
                    }
                    int i3 = i;
                    str = str3;
                    i2 = i3;
                    stringBuffer.append(str2 + "#" + dVar.rjF.get(str2) + "#" + str + "|");
                    i = i2;
                }
                stringBuffer.append("," + j + "," + bi.Wx() + ",1," + i);
                x.v("MicroMsg.SnsReportHelper", "report(13226) %d: %s", Integer.valueOf(13226), stringBuffer);
                com.tencent.mm.plugin.report.service.g.pWK.k(13226, stringBuffer.toString());
                dVar.gAD.set(3, null);
                dVar.gAD.set(4, null);
                dVar.rjF.clear();
                dVar.rjG.clear();
                dVar.gAD.setLong(2, bi.Wx());
            }
        }
        com.tencent.mm.kernel.g.Dr();
        String str22 = (String) com.tencent.mm.kernel.g.Dq().Db().get(68377, null);
        int count = this.rNP.getCount();
        str = "";
        m mVar = null;
        if (count > 0) {
            mVar = this.rNP.xL(count - 1);
            str = com.tencent.mm.plugin.sns.data.i.g(mVar);
        }
        if (!(this.rNU == null || this.rNU.rxw == null)) {
            com.tencent.mm.plugin.sns.h.b bVar = this.rNU.rxw.rcW;
            i2 = mVar == null ? -1 : mVar.field_createTime;
            x.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineDestroy");
            j = System.currentTimeMillis() - bVar.rjt;
            bVar.rhy += j;
            x.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineEns passedtime: " + j + " BrowseTime: " + bVar.rhy + "BackgroundTime: " + bVar.rih);
            com.tencent.mm.sdk.f.e.b(new com.tencent.mm.plugin.sns.h.b.AnonymousClass2(i2), "onTimelineDestroy_report", 1);
            bVar.rhw = false;
        }
        com.tencent.mm.modelsns.b ix = com.tencent.mm.modelsns.b.ix(704);
        if (ix.SA()) {
            ix.bW(this.rOj);
            ix.bW(!bi.oN(str22));
            ix.mF(this.rNZ);
            ix.mF(str);
            ix.mF(str);
            ix.iA(this.rOg.rRl);
            ix.mF("");
            com.tencent.mm.modelsns.b.SD();
            ix.SE();
        }
        AdListView adListView = (AdListView) this.rOg.bCu();
        this.rOc.rdO.clear();
        ae.bvW().clean();
        ae.bvS().post(new Runnable() {
            public final void run() {
                i.d(i.this);
            }
        });
        adListView.rwa.clear();
        adListView.rwa = null;
        adListView.rwb.bvs();
        adListView.rwb = null;
        t.bvA();
        if (!ae.bvO()) {
            this.rOC.removeCallbacks(this.rOh);
        }
        com.tencent.mm.kernel.g.Dr();
        if (com.tencent.mm.kernel.g.Do().CF()) {
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.b((int) com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX, (e) this);
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.b(682, (e) this);
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.b(218, (e) this);
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.b((int) com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX, (e) this);
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.b(683, (e) this);
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dq().Db().set(327776, Integer.valueOf(this.rNX));
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dq().Db().set(589825, Boolean.valueOf(false));
        }
        if (this.rNU != null) {
            j jVar = this.rNU;
            jVar.rxJ.aCt();
            if (jVar.rxz != null) {
                jVar.rxz.aYy();
            }
            com.tencent.mm.sdk.b.a.xmy.c(jVar.rxL);
        }
        ae.aOA().removeCallbacks(this.rOD);
        if (this.rNP != null) {
            int i4;
            i = this.rOg.nQn.getFirstVisiblePosition();
            i2 = 0;
            for (i4 = 0; i4 < this.rOg.nQn.getCount(); i4++) {
                View childAt = this.rOg.nQn.getChildAt(i4);
                if (childAt != null && this.rOg.nQn.getPositionForView(childAt) == i) {
                    int[] iArr = new int[2];
                    childAt.getLocationInWindow(iArr);
                    x.d("MicroMsg.SnsTimeLineUI", "this is the pos for view %d x %d y %d", Integer.valueOf(r4), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                    i2 = iArr[1];
                }
            }
            i4 = BackwardSupportUtil.b.b((Context) this, 50.0f);
            if (!(ae.bvO() || this.rNO.bvV() == null)) {
                aj bwm = ae.bwm();
                String str4 = this.rNP.rPy.mgB;
                String str5 = this.rNP.rPy.rCC;
                long j2 = this.rNO.bvV().rdk;
                int i5 = i2 - i4;
                bwm.rCB = bi.Wz();
                bwm.mgB = str4;
                bwm.rCC = str5;
                bwm.rdk = j2;
                bwm.position = i;
                bwm.rCD = i5;
                x.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s", Long.valueOf(bwm.rCB), str4, str5, Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(bwm.rCD));
            }
            x.d("MicroMsg.SnsTimeLineUI", "top h %d", Integer.valueOf(i2 - i4));
            com.tencent.mm.sdk.b.a.xmy.c(this.rNP.rPx.jil);
            if (ae.bvO()) {
                x.e("MicroMsg.SnsTimeLineBaseAdapter", "is invalid to getSnsInfoStorage");
            } else {
                ae.bwc();
            }
            av avVar = this.rNP.rPx;
            if (avVar.rFO != null) {
                avVar.rFO.activity = null;
            }
            com.tencent.mm.sdk.b.a.xmy.c(this.rNP.rPx.jil);
            this.rNP.rPx.bCk();
        }
        az.clean();
        com.tencent.mm.sdk.b.a.xmy.c(this.rOi);
        com.tencent.mm.kernel.g.Dr();
        if (com.tencent.mm.kernel.g.Do().CF()) {
            ae.bwc().qYY.clear();
        }
        this.rNP = null;
        this.rNU = null;
        ax.bCF();
        com.tencent.mm.plugin.sns.abtest.c.buF();
        e bvW = ae.bvW();
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.b((int) JsApiCreateAudioInstance.CTRL_INDEX, bvW);
        com.tencent.mm.plugin.sns.abtest.a.clean();
        this.rOg.onDestroy();
        super.onDestroy();
        com.tencent.mm.kiss.widget.textview.c.gUU.Ei();
    }

    public void onResume() {
        int count;
        if (com.tencent.mm.sdk.a.b.cfx() && com.tencent.mm.sdk.a.b.cfv()) {
            rOH.add(this);
        }
        bb.onResume();
        super.onResume();
        this.kIK = bi.Wx();
        if (this.rOG) {
            this.rOG = false;
            count = this.rNP.getCount();
            if (getIntent().getBooleanExtra("is_from_find_more", false)) {
                com.tencent.mm.modelsns.b c = com.tencent.mm.modelsns.b.c(getIntent(), "enter_log");
                if (c != null) {
                    if (count > 0) {
                        String str;
                        m xL = this.rNP.xL(0);
                        if (xL == null) {
                            str = "0";
                        } else {
                            str = com.tencent.mm.plugin.sns.data.i.er(xL.field_snsId);
                        }
                        c.mF(str);
                        if (xL == null) {
                            str = "0";
                        } else {
                            str = xL.field_createTime;
                        }
                        c.mF(str);
                        c.mF(String.valueOf(count));
                    } else {
                        c.mF("");
                        c.mF("");
                        c.mF("0");
                    }
                    c.SE();
                }
            }
        }
        if (this.mScreenWidth == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.mScreenWidth = displayMetrics.widthPixels;
            this.mScreenHeight = displayMetrics.heightPixels;
            com.tencent.mm.plugin.sns.h.a aVar = this.rOa;
            count = this.mScreenWidth;
            int i = this.mScreenHeight;
            aVar.mScreenWidth = count;
            aVar.mScreenHeight = i;
        }
        if (ae.bvO()) {
            finish();
        }
        ae.bwc().qZa = this.rNP.rPx;
        Ed().K(com.tencent.mm.plugin.sns.j.c.b.class);
        t.a((an) this);
        if (this.rNT) {
            this.rNR.post(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.SnsTimeLineUI", "onResume go to playAnim " + SnsTimeLineUI.this.rNT);
                    if (SnsTimeLineUI.this.rNT) {
                        SnsTimeLineUI.this.rNT = false;
                        SnsTimeLineUI.this.rNV.bCC();
                    }
                }
            });
        } else {
            a aVar2 = this.rNV;
            if (aVar2.rOQ.rNR.getVisibility() == 0) {
                aVar2.init();
                LayoutParams layoutParams = (LayoutParams) aVar2.rOQ.rNR.getLayoutParams();
                layoutParams.y = (int) aVar2.rPe;
                aVar2.rOQ.rNR.setLayoutParams(layoutParams);
                aVar2.rOQ.rNR.invalidate();
            }
        }
        com.tencent.mm.sdk.b.b rvVar = new rv();
        rvVar.fKt.fKu = this.rOg.nQn.getFirstVisiblePosition();
        rvVar.fKt.fKv = this.rOg.nQn.getLastVisiblePosition();
        rvVar.fKt.fKw = this.rOg.nQn.getHeaderViewsCount();
        rvVar.fKt.type = 0;
        com.tencent.mm.sdk.b.a.xmy.m(rvVar);
        if (!(this.rNU == null || this.rNU.rxv == null)) {
            this.rNU.rxv.onResume();
        }
        if (this.rNP != null) {
            av avVar = this.rNP.rPx;
            com.tencent.mm.sdk.b.a.xmy.b(avVar.rGf);
            com.tencent.mm.sdk.b.a.xmy.b(avVar.rGe);
            com.tencent.mm.sdk.b.a.xmy.b(avVar.rGg);
        }
        if (!(this.rNU == null || this.rNU.rxw == null)) {
            this.rNU.rxw.rcW.iq(true);
            this.rNU.rxw.rcW.ir(false);
            this.rNU.rxw.rcW.is(false);
            this.rNU.rxw.rcW.it(false);
            this.rNU.rxw.rcW.iD(false);
            com.tencent.mm.plugin.sns.h.b bVar = this.rNU.rxw.rcW;
            bVar.iB(false);
            bVar.iC(false);
            bVar.iv(false);
            bVar.iA(false);
            bVar.iy(false);
            bVar.iA(false);
            bVar.iE(false);
            bVar.iz(false);
            bVar.iA(false);
            bVar.iw(false);
            bVar.ix(false);
        }
        com.tencent.mm.plugin.sns.model.g bwc = ae.bwc();
        bwc.qZb = 0;
        bwc.qZc = 0;
        com.tencent.mm.sdk.b.a.xmy.b(this.rOl);
        com.tencent.mm.sdk.b.a.xmy.b(this.rOk);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onPause() {
        this.rNR.clearAnimation();
        HardCoderJNI.stopPerformace(HardCoderJNI.hcSNSScrollEnable, this.hGs);
        this.hGs = 0;
        t.b(this);
        ae.bwc().qZa = null;
        com.tencent.mm.sdk.b.b rvVar = new rv();
        rvVar.fKt.type = 1;
        com.tencent.mm.sdk.b.a.xmy.m(rvVar);
        if (this.rNP != null) {
            av avVar = this.rNP.rPx;
            com.tencent.mm.sdk.b.a.xmy.c(avVar.rGf);
            com.tencent.mm.sdk.b.a.xmy.c(avVar.rGe);
            com.tencent.mm.sdk.b.a.xmy.c(avVar.rGg);
        }
        if (!(this.rNU == null || this.rNU.rxv == null)) {
            this.rNU.rxv.onPause();
        }
        if (!(this.rNU == null || this.rNU.rxw == null)) {
            this.rNU.rxw.rcW.iq(false);
        }
        com.tencent.mm.modelstat.d.g("SnsTimeLineUI", this.kIK, bi.Wx());
        bb.onPause();
        super.onPause();
        com.tencent.mm.sdk.b.a.xmy.c(this.rOl);
        com.tencent.mm.sdk.b.a.xmy.c(this.rOk);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.sns.i.g.qOi;
    }

    protected final void initView() {
        this.rOg.rhb.setDrawingCacheEnabled(false);
        this.rNU.rft = (FrameLayout) findViewById(com.tencent.mm.plugin.sns.i.f.qLO);
        setMMTitle(j.qSy);
        int i = ae.bwm().position;
        AdListView adListView = (AdListView) this.rOg.bCu();
        adListView.rwa = this.rFX;
        adListView.rwb = this.rOb;
        adListView.rwc = this.rOc;
        this.rOc.a(ae.bvW());
        x.i("MicroMsg.SnsTimeLineUI", "oncreate firstPosition %d isToResume: " + this.rxE, Integer.valueOf(i));
        this.rNR = (QFadeImageView) findViewById(com.tencent.mm.plugin.sns.i.f.qLr);
        this.rNR.setImageResource(i.qOQ);
        this.rNV = new a(this.rOg.bCu());
        this.rNV.setInterpolator(new LinearInterpolator());
        this.rNV.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                x.i("MicroMsg.SnsTimeLineUI", "refreshAnim start");
            }

            public final void onAnimationRepeat(Animation animation) {
                x.i("MicroMsg.SnsTimeLineUI", "refreshAnim repeat");
            }

            public final void onAnimationEnd(Animation animation) {
                x.i("MicroMsg.SnsTimeLineUI", "refreshAnim end");
            }
        });
        this.rNP = new ax(this, this.rOg.bCu(), this.rNU.rxJ, this.rNU, this.rOd);
        this.rNU.rxJ.rVY = new com.tencent.mm.plugin.sns.ui.av.a() {
            public final boolean bCo() {
                SnsTimeLineUI.this.Ed().K(com.tencent.mm.plugin.sns.j.c.b.class);
                return false;
            }
        };
        this.rNU.rfY = this.rNP.rPx;
        this.rNP.rPy.zJY = new com.tencent.mm.vending.a.b.a() {
            public final void bCz() {
                com.tencent.mm.plugin.report.service.f.vR(14);
            }

            public final void bCA() {
                com.tencent.mm.plugin.report.service.f.vS(14);
            }
        };
        this.rNW = (TestTimeForSns) this.rNU.rft;
        this.rNW.setListener(new com.tencent.mm.plugin.sns.ui.TestTimeForSns.a() {
            public final void aOR() {
                x.i("MicroMsg.SnsTimeLineUI", "sns has drawed");
                SnsTimeLineUI.this.rNW.post(new Runnable() {
                    public final void run() {
                        if (SnsTimeLineUI.this.rNP == null || SnsTimeLineUI.this.rNW == null) {
                            x.i("MicroMsg.SnsTimeLineUI", "onViewDrawed is error");
                            return;
                        }
                        SnsTimeLineUI.this.rNW.setListener(null);
                        SnsTimeLineUI.this.rxE = SnsTimeLineUI.this.rNS;
                        if (SnsTimeLineUI.this.rNY) {
                            x.w("MicroMsg.SnsTimeLineUI", "too fast that it finish");
                            return;
                        }
                        if (SnsTimeLineUI.this.rxE) {
                            ae.bvV().y(ae.bwm().rdk, -1);
                        }
                        if (!SnsTimeLineUI.this.rxE) {
                            SnsTimeLineUI.this.rNN.rXX.b(SnsTimeLineUI.this.jPV, SnsTimeLineUI.this.rOe, SnsTimeLineUI.this.rzo, SnsTimeLineUI.this.rOf);
                        }
                        SnsTimeLineUI.this.rxE = false;
                        if (SnsTimeLineUI.this.rFX != null) {
                            SnsTimeLineUI.this.rFX.buI();
                        }
                    }
                });
            }
        });
        this.rOg.nQn.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    SnsTimeLineUI.this.bAb();
                    if (SnsTimeLineUI.this.rOg.nQn != null && SnsTimeLineUI.this.rOg.nQn.getFirstVisiblePosition() == 0) {
                        x.d("MicroMsg.SnsTimeLineUI", "refreshIv onTouch set refreshIv visible");
                        SnsTimeLineUI.this.rNR.setVisibility(0);
                    }
                    SnsTimeLineUI.this.rNV.bCD();
                }
                if (motionEvent.getAction() == 0) {
                    if (SnsTimeLineUI.this.rOg.nQn != null && SnsTimeLineUI.this.rOg.nQn.getFirstVisiblePosition() == 0) {
                        SnsTimeLineUI.this.rNR.setVisibility(0);
                    }
                    SnsTimeLineUI.this.rNU.bzO();
                    SnsTimeLineUI.this.rNU.rxA.bCW();
                }
                if (SnsTimeLineUI.this.rFX != null) {
                    SnsTimeLineUI.this.rFX.buI();
                }
                return false;
            }
        });
        this.rOg.nQn.post(new Runnable() {
            public final void run() {
                if (SnsTimeLineUI.this.rNU != null) {
                    SnsTimeLineUI.this.rNU.rxA.rFH = SnsTimeLineUI.this.rOg.nQn.getBottom();
                    SnsTimeLineUI.this.rNU.rxA.rSS = SnsTimeLineUI.this.rOg.otm.getTop();
                    SnsTimeLineUI.this.rNV.rPi = SnsTimeLineUI.this.rOg.rhb.getTop();
                }
            }
        });
        this.rOg.otm.yln = new MMPullDownView.f() {
            public final void ax(float f) {
                SnsTimeLineUI.C(SnsTimeLineUI.this);
                if (SnsTimeLineUI.this.rOg.rhb.getTop() >= SnsTimeLineUI.this.rNV.rPi || f > 0.0f) {
                    a z = SnsTimeLineUI.this.rNV;
                    if (z.nQn != null) {
                        if (z.nQn.getFirstVisiblePosition() == 0) {
                            z.rOQ.rNR.setVisibility(0);
                        } else {
                            z.rOQ.rNR.setVisibility(8);
                        }
                    }
                    if (z.rOQ.rNR.getVisibility() == 0) {
                        z.rOQ.rNR.clearAnimation();
                        z.init();
                        z.rPf -= f / 2.0f;
                        float f2 = z.rPf;
                        if (f2 < z.rPe) {
                            f2 = z.rPe;
                            z.rPf = z.rPe;
                        }
                        float f3 = f2 > z.rPd ? z.rPd : f2;
                        f2 = f3 == z.rPd ? f * 2.0f : 5.0f * f;
                        z.rOQ.rNR.a(com.tencent.mm.ui.widget.QImageView.a.MATRIX);
                        z.rOQ.rNR.mMatrix.postRotate(f2, z.rPb, z.rPc);
                        z.rOQ.rNR.setImageResource(i.qOQ);
                        LayoutParams layoutParams = (LayoutParams) z.rOQ.rNR.getLayoutParams();
                        layoutParams.y = (int) f3;
                        z.rOQ.rNR.setLayoutParams(layoutParams);
                        z.rOQ.rNR.invalidate();
                    }
                }
                SnsTimeLineUI.this.rNU.bzO();
                SnsTimeLineUI.this.bAb();
                SnsTimeLineUI.this.rNU.rxA.bCW();
            }

            public final void bCB() {
                SnsTimeLineUI.this.rNV.bCD();
            }
        };
        this.rNU.rxz = (SnsCommentFooter) findViewById(com.tencent.mm.plugin.sns.i.f.qHI);
        this.rNU.rxz.post(new Runnable() {
            public final void run() {
                com.tencent.mm.compatible.util.j.h(SnsTimeLineUI.this);
            }
        });
        this.rNU.rxA = new bi(this.rOg.nQn, this.rNU.rxz);
        this.rNQ = (LinearLayout) this.rOg.rhb.findViewById(com.tencent.mm.plugin.sns.i.f.qLf);
        this.rNQ.findViewById(com.tencent.mm.plugin.sns.i.f.qLd).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (!(SnsTimeLineUI.this.rNU == null || SnsTimeLineUI.this.rNU.rxw == null)) {
                    SnsTimeLineUI.this.rNU.rxw.rcW.it(true);
                }
                com.tencent.mm.plugin.sns.j.c.b bVar = (com.tencent.mm.plugin.sns.j.c.b) SnsTimeLineUI.this.Ed().J(com.tencent.mm.plugin.sns.j.c.b.class);
                com.tencent.mm.modelsns.b ix = com.tencent.mm.modelsns.b.ix(725);
                ix.iA(bVar.rYb);
                ix.SE();
                Intent intent = new Intent();
                intent.setClass(SnsTimeLineUI.this, SnsMsgUI.class);
                SnsTimeLineUI.this.startActivityForResult(intent, 13);
            }
        });
        SnsHeader snsHeader = this.rOg.rhb;
        OnClickListener anonymousClass32 = new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(SnsTimeLineUI.this, SnsUserUI.class);
                Intent e = ae.bvV().e(intent, SnsTimeLineUI.this.rOd);
                if (e == null) {
                    SnsTimeLineUI.this.finish();
                    return;
                }
                com.tencent.mm.kernel.g.Dr();
                int a = bi.a((Integer) com.tencent.mm.kernel.g.Dq().Db().get(68388, null), 0);
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dq().Db().set(68388, Integer.valueOf(a + 1));
                SnsTimeLineUI.this.startActivity(e);
                if ((e.getFlags() & 67108864) != 0) {
                    SnsTimeLineUI.this.finish();
                }
            }
        };
        if (!(snsHeader.rHI == null || snsHeader.rHI.ikl == null)) {
            snsHeader.rHI.ikl.setOnClickListener(anonymousClass32);
        }
        this.rNU.rxB = new ao(this);
        bCq();
    }

    public final void onKeyboardStateChanged() {
        super.onKeyboardStateChanged();
        ah.y(new Runnable() {
            public final void run() {
                SnsTimeLineUI.this.bAb();
            }
        });
        if (this.mController.xRL == 2) {
            if (this.rNU != null && this.rNU.rxz != null && !this.rNU.rxz.bBx()) {
                x.i("MicroMsg.SnsTimeLineUI", "onKeyBoardStateChange find");
            }
        } else if (this.mController.xRL == 1 && this.rNU != null) {
            j jVar = this.rNU;
            if (jVar.rxx) {
                jVar.rxx = false;
                jVar.rxA.bCV();
            }
        }
    }

    private void bCp() {
        setTitleBarDoubleClickListener(new Runnable() {
            public final void run() {
                SnsTimeLineUI.E(SnsTimeLineUI.this);
            }
        });
    }

    public boolean supportNavigationSwipeBack() {
        return super.supportNavigationSwipeBack();
    }

    private void bCq() {
        bCp();
        setBackBtn(this.rOI, com.tencent.mm.plugin.sns.i.e.byz);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        this.rOM = menu.add(0, 0, 0, j.qPV);
        if (this.rOJ == null) {
            int dimensionPixelSize;
            int height = getSupportActionBar().getHeight();
            if (height == 0) {
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                dimensionPixelSize = displayMetrics.widthPixels > displayMetrics.heightPixels ? getResources().getDimensionPixelSize(com.tencent.mm.plugin.sns.i.d.buG) : getResources().getDimensionPixelSize(com.tencent.mm.plugin.sns.i.d.buH);
            } else {
                dimensionPixelSize = height;
            }
            int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(this, 56);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(fromDPToPix, dimensionPixelSize);
            this.rOJ = View.inflate(this, com.tencent.mm.plugin.sns.i.g.qOa, null);
            this.rOK = (ImageView) this.rOJ.findViewById(com.tencent.mm.plugin.sns.i.f.icon);
            this.rOL = this.rOJ.findViewById(com.tencent.mm.plugin.sns.i.f.cSf);
            this.rOJ.setLayoutParams(layoutParams);
            this.rOJ.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.byB);
            this.rOJ.setMinimumHeight(dimensionPixelSize);
            this.rOJ.setMinimumWidth(fromDPToPix);
            this.rOK.setImageResource(i.dxt);
            this.rOJ.setContentDescription(getString(j.eRy));
            this.rOJ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    SnsTimeLineUI.F(SnsTimeLineUI.this);
                }
            });
            this.rOJ.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    if (!(SnsTimeLineUI.this.rNU == null || SnsTimeLineUI.this.rNU.rxw == null)) {
                        SnsTimeLineUI.this.rNU.rxw.rcW.iu(true);
                    }
                    com.tencent.mm.kernel.g.Dr();
                    if (((Boolean) com.tencent.mm.kernel.g.Dq().Db().get(7490, Boolean.valueOf(true))).booleanValue()) {
                        SnsTimeLineUI.this.startActivity(new Intent().setClass(SnsTimeLineUI.this, SnsLongMsgUI.class));
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.kernel.g.Dq().Db().set(7490, Boolean.valueOf(false));
                    } else {
                        Intent intent = new Intent();
                        intent.setClass(SnsTimeLineUI.this, SnsUploadUI.class);
                        intent.putExtra("KSnsPostManu", true);
                        intent.putExtra("KTouchCameraTime", bi.Wx());
                        intent.putExtra("sns_comment_type", 1);
                        intent.putExtra("Ksnsupload_type", 9);
                        com.tencent.mm.modelsns.b ix = com.tencent.mm.modelsns.b.ix(705);
                        ix.iB(ix.hQt).mG(System.currentTimeMillis()).iB(ix.hQv).iB(1);
                        ix = com.tencent.mm.plugin.sns.h.e.rjJ.b(ix);
                        ix.SE();
                        ix.b(intent, "intent_key_StatisticsOplog");
                        SnsTimeLineUI.this.startActivityForResult(intent, 9);
                    }
                    return true;
                }
            });
            this.rOJ.post(new Runnable() {
                public final void run() {
                    SnsTimeLineUI.this.supportInvalidateOptionsMenu();
                }

                public final String toString() {
                    return super.toString() + "|supportInvalidateOptionsMenu";
                }
            });
        }
        android.support.v4.view.m.a(this.rOM, this.rOJ);
        android.support.v4.view.m.a(this.rOM, 2);
        this.rOM.setVisible(true);
        bCr();
        return onCreateOptionsMenu;
    }

    private void bCr() {
        if (this.rOL != null) {
            this.rOL.setVisibility(8);
        }
    }

    private void bCs() {
        if (!com.tencent.mm.o.a.aU(this)) {
            x.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 18, "", "")), bi.chl(), this);
            if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 18, "", "")) {
                x.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 18, "", "")), bi.chl(), this);
                if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 18, "", "")) {
                    com.tencent.mm.plugin.report.service.g.pWK.h(13822, Integer.valueOf(1), Integer.valueOf(2));
                    k.x(this.mController.xRr, new Intent());
                }
            }
        }
    }

    public final boolean cH(View view) {
        this.rNU.rxH.bwW();
        bh bhVar = this.rNU.rxG;
        if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c) {
            com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
            String str = cVar.fsC;
            if (bhVar.rSN != null) {
                if (bhVar.rSN.getTag() instanceof a) {
                    a aVar = (a) bhVar.rSN.getTag();
                    if (aVar.rfN.equals(str)) {
                        bhVar.cJ(aVar.qUh);
                        return true;
                    }
                    bhVar.bAb();
                }
                bhVar.rSN = null;
            }
            bhVar.rSN = new SnsCommentShowAbLayout(bhVar.mContext);
            l.bC(bhVar.rSN);
            bhVar.rSN.setId(com.tencent.mm.plugin.sns.i.f.dag);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            bhVar.rft.addView(bhVar.rSN);
            int b = BackwardSupportUtil.b.b(bhVar.mContext, 192.0f);
            int b2 = BackwardSupportUtil.b.b(bhVar.mContext, 76.0f);
            BackwardSupportUtil.b.b(bhVar.mContext, 20.0f);
            int b3 = BackwardSupportUtil.b.b(bhVar.mContext, 12.0f);
            int b4 = BackwardSupportUtil.b.b(bhVar.mContext, 40.0f);
            View inflate = v.fw(bhVar.mContext).inflate(com.tencent.mm.plugin.sns.i.g.qNj, null);
            Rect rect = new Rect();
            int[] iArr = new int[2];
            int eb = com.tencent.mm.pluginsdk.e.eb(bhVar.mContext);
            view.getLocationInWindow(iArr);
            bhVar.qVg = com.tencent.mm.pluginsdk.e.ec(bhVar.mContext);
            x.d("MicroMsg.TimeLineCommentHelper", "addCommentView getLocationInWindow " + iArr[0] + "  " + iArr[1] + " height: " + eb + " height_hardcode:" + b2 + " statusBarHeight: " + bhVar.qVg);
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2, (iArr[0] - b) + b3, ((iArr[1] - bhVar.qVg) - eb) - ((b4 / 2) - (view.getMeasuredHeight() / 2)));
            bhVar.rSN.setTag(new a(str, inflate));
            bhVar.rSN.addView(inflate, layoutParams2);
            if (cVar.kZv == 11) {
                inflate.findViewById(com.tencent.mm.plugin.sns.i.f.qGC).setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFf);
            }
            inflate.setVisibility(8);
            new ag().post(new com.tencent.mm.plugin.sns.ui.bh.AnonymousClass1(view, inflate));
            return true;
        }
        x.e("MicroMsg.TimeLineCommentHelper", "showCommentBtn err2");
        return false;
    }

    public final boolean bAb() {
        if (this.rNU == null || this.rNU.rxG == null) {
            return false;
        }
        if (!(this.rNU == null || this.rNU.rxH == null)) {
            this.rNU.rxH.bwW();
        }
        com.tencent.mm.plugin.sns.abtest.a.buz();
        return this.rNU.rxG.bAb();
    }

    public final void GZ() {
        Ed().K(com.tencent.mm.plugin.sns.j.c.b.class);
    }

    public final void Ha() {
    }

    public final void Hb() {
        if (!this.rOP) {
            x.v("MicroMsg.SnsTimeLineUI", "notifyHbReward imp");
            this.rOP = true;
            ae.aOA().postDelayed(new Runnable() {
                public final void run() {
                    if (SnsTimeLineUI.this.rNP != null) {
                        SnsTimeLineUI.this.rNP.rPy.notifyVendingDataChange();
                    }
                    SnsTimeLineUI.this.rOP = false;
                }
            }, 1000);
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        x.i("MicroMsg.SnsTimeLineUI", "uionSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType());
        if (kVar.getType() == 218) {
            q qVar = (q) kVar;
            if ((qVar.type == 1 || qVar.type == 6 || qVar.type == 4) && this.rNU.rxK != null) {
                this.rNU.rxK.dismiss();
            }
            if (qVar.type == 11) {
                if (this.rOg.tipDialog != null) {
                    this.rOg.tipDialog.dismiss();
                }
                if (this.rOK != null) {
                    this.rOK.setImageResource(i.dxt);
                }
            }
        }
        if (this.rNP != null) {
            this.rNP.rPy.notifyVendingDataChange();
        }
        if (kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX) {
            com.tencent.mm.plugin.sns.model.x xVar = (com.tencent.mm.plugin.sns.model.x) kVar;
            com.tencent.mm.modelsns.b ix;
            if (xVar.qZN) {
                ix = com.tencent.mm.modelsns.b.ix(727);
                ix.iA(this.rNP.getCount()).iA(xVar.Pb);
                ix.SE();
            } else {
                ix = com.tencent.mm.modelsns.b.ix(728);
                ix.iA(this.rNP.getCount()).iA(xVar.Pb).iA(0);
                ix.SE();
            }
            if (this.rNV != null) {
                this.rNT = false;
                Animation animation = this.rNV;
                x.i("MicroMsg.SnsTimeLineUI", "play end vis: %d, sumY %f MAX_Y %f", Integer.valueOf(animation.rOQ.rNR.getVisibility()), Float.valueOf(animation.rPf), Float.valueOf(animation.rPd));
                if (animation.rOQ.rNR.getVisibility() == 0) {
                    animation.init();
                    if (animation.rPf >= animation.rPd) {
                        animation.rOQ.rNR.clearAnimation();
                        animation.rOQ.rNR.startAnimation(animation);
                        animation.setDuration(1200);
                        animation.rPh = false;
                    }
                }
            }
        }
    }

    protected void finalize() {
        x.d("MicroMsg.SnsTimeLineUI", "finalize");
        super.finalize();
    }

    public final void Hc() {
        Ed().K(com.tencent.mm.plugin.sns.j.c.b.class);
    }

    public void onBackPressed() {
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.v("MicroMsg.SnsTimeLineUI", "on ActivityResult, requestCode %d, resultCode %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 15) {
            if (this.rNU != null && this.rNU.rxJ != null && this.rNU.rxJ.rVs != null) {
                this.rNU.rxJ.rVs.onActivityResult(i, i2, intent);
                ah.h(new Runnable() {
                    public final void run() {
                        SnsTimeLineUI.this.aWY();
                    }
                }, 300);
            }
        } else if (i == 16) {
            x.i("MicroMsg.SnsTimeLineUI", "REQUEST_CODE_FOR_FULLSCREEN");
        } else {
            super.onActivityResult(i, i2, intent);
            this.rOg.onActivityResult(i, i2, intent);
            if (i == 11) {
                this.rNN.rXX.b(this.jPV, this.rOe, this.rzo, this.rOf);
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.SnsTimeLineUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 18:
                if (iArr[0] == 0) {
                    bCs();
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? j.ezZ : j.eAd;
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(i2), getString(j.eAg), getString(j.esG), getString(j.dEy), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            SnsTimeLineUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }
}
