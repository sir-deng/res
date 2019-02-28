package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.a.d;
import com.tencent.mm.plugin.webview.fts.topstory.ui.widget.TopStoryVideoViewControlBar;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebDotPercentIndicator;
import com.tencent.mm.pluginsdk.ui.AbstractVideoView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.UUID;

public final class f extends RelativeLayout {
    private static com.tencent.mm.ap.a.a.c twf;
    private boolean acS;
    private String frp = "";
    private boolean kYN;
    int position;
    d skA;
    public View tvA;
    public View tvB;
    public View tvC;
    private View tvD;
    public View tvE;
    public LinearLayout tvF;
    private FtsWebDotPercentIndicator tvG;
    private TextView tvH;
    private ImageView tvI;
    public ImageView tvJ;
    public ImageView tvK;
    public ImageView tvL;
    private Button tvM;
    private TextView tvN;
    public TextView tvO;
    private TextView tvP;
    private com.tencent.mm.plugin.webview.fts.topstory.ui.widget.a tvQ;
    private com.tencent.mm.plugin.webview.fts.topstory.ui.widget.a tvR;
    public ImageView tvS;
    public TextView tvT;
    public ImageView tvU;
    private View tvV;
    public FrameLayout tvW;
    private ImageView tvX;
    private ImageView tvY;
    private int tvZ = c.twp;
    b tvu;
    h tvv;
    private a tvw = a.AUTO;
    public FrameLayout tvx;
    public TextView tvy;
    TopStoryVideoViewControlBar tvz;
    private View twa;
    private TextView twb;
    private al twc;
    private int twd = -1;
    boolean twe;
    com.tencent.mm.pluginsdk.ui.h.b twg = new com.tencent.mm.pluginsdk.ui.h.b() {
        public final void c(String str, String str2, String str3, int i, int i2) {
            int i3 = 0;
            x.e("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onError errorMsg=%s what=%d extra=%d", str3, Integer.valueOf(i), Integer.valueOf(i2));
            f.this.eQ(f.this.getContext().getString(R.l.eTl, new Object[]{i + ":" + i2}), f.this.getContext().getString(R.l.eTF));
            com.tencent.mm.plugin.webview.fts.topstory.a.d.Au(i);
            if (com.tencent.mm.plugin.webview.fts.topstory.a.d.tun != null && com.tencent.mm.plugin.webview.fts.topstory.a.d.tun.skt > 0) {
                i3 = ((int) (System.currentTimeMillis() - com.tencent.mm.plugin.webview.fts.topstory.a.d.tun.skt)) / 1000;
            }
            com.tencent.mm.plugin.webview.fts.topstory.a.d.a(f.this.skA, i, str3, i3);
        }

        public final void bn(String str, String str2) {
            x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onPrepared");
            com.tencent.mm.plugin.webview.fts.topstory.ui.widget.a h = f.this.tvQ;
            h.jwR = -1;
            h.jwS = 0;
            h.jwQ = 0.0f;
            f.this.tvz.ku(f.this.acS);
            if (!f.this.acS) {
                f.this.bQB();
            }
        }

        public final void bo(String str, String str2) {
            x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onVideoEnded");
            g bQQ = g.bQQ();
            if (bQQ.twv != null && bQQ.twv.frp.equals(str)) {
                if (com.tencent.mm.plugin.webview.fts.topstory.a.d.tun != null) {
                    com.tencent.mm.plugin.webview.fts.topstory.a.d.tun.skw = 1;
                }
                bQQ.stopPlay();
            }
            if (!((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).aCJ()) {
                f.this.bQE();
            } else if (d.bQo().nhE) {
                f.this.bQI();
            } else {
                com.tencent.mm.plugin.webview.fts.topstory.a.d.tuo = 1;
                f.this.tvu.Av(f.this.position + 1);
            }
            f.this.tvz.setVisibility(8);
            f.this.acS = false;
        }

        public final void e(String str, String str2, int i, int i2) {
            x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onGetVideoSize width=%d height=%d", Integer.valueOf(i), Integer.valueOf(i2));
            if (f.this.tvw == a.AUTO) {
                f.this.tvw = i < i2 ? a.PORTRAIT : a.LANDSCAPE;
                x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onGetVideoSize adjust direction from AUTO to %s", f.this.tvw);
            }
        }

        public final void bp(String str, String str2) {
        }

        public final void bq(String str, String str2) {
        }

        public final void br(String str, String str2) {
            x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onVideoWaiting");
            f.this.bQG();
            f.this.acS = true;
        }

        public final void bs(String str, String str2) {
            x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onVideoWaitingEnd");
            f.this.acS = false;
            f.this.tvz.bRe();
            f.this.bQB();
        }
    };
    private OnClickListener twh = new OnClickListener() {
        public final void onClick(View view) {
            d.bQo().bQq();
        }
    };
    private OnClickListener twi = new OnClickListener() {
        public final void onClick(View view) {
            d.bQo().a(f.this, true);
            if (f.this.tvv != null) {
                f.this.tvv.bQs();
                f.this.tvv = null;
            }
        }
    };

    private enum a {
        AUTO,
        LANDSCAPE,
        PORTRAIT
    }

    private enum c {
        ;

        static {
            twp = 1;
            twq = 2;
            twr = 3;
            tws = new int[]{twp, twq, twr};
        }
    }

    class b implements com.tencent.mm.plugin.webview.fts.topstory.ui.widget.b {
        private float two;

        b() {
            this.two = (float) com.tencent.mm.bu.a.eC(f.this.getContext());
        }

        public final void ahi() {
            x.d("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onSingleTap");
            if (f.r(f.this)) {
                f.this.tvz.ku(f.this.acS);
            }
            if (f.this.tvv != null) {
                f.this.tvv.bQm();
                f.this.tvv.bQl();
            }
        }

        public final void ahj() {
            x.d("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onDoubleTap");
        }

        public final void ahk() {
            f.this.tvy.setVisibility(0);
            f.this.tvz.bRh();
        }

        public final int e(int i, float f) {
            x.d("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onDragProgress:" + i + "/" + f);
            float f2 = f / this.two;
            int ahy = g.bQQ().ahy();
            int ahA = ((int) (f2 * ((float) ahy))) + g.bQQ().ahA();
            if (ahA < 0) {
                ahA = 0;
            } else if (ahA > ahy) {
                ahA = ahy;
            }
            f.this.tvy.setText(com.tencent.mm.plugin.webview.fts.c.c.bq(((long) ahA) * 1000) + "/" + com.tencent.mm.plugin.webview.fts.c.c.bq(((long) ahy) * 1000));
            return ahA;
        }

        public final void f(int i, float f) {
            f.this.tvz.bRi();
            f.this.tvy.setVisibility(8);
            int ahA = g.bQQ().ahA();
            f.seekTo(i);
            f.this.tvz.bRi();
            x.d("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", Integer.valueOf(i), Integer.valueOf(ahA), Float.valueOf(f));
        }

        public final boolean bQP() {
            if (f.this.bQL()) {
                return false;
            }
            return true;
        }

        public final int getCurrentPosition() {
            return g.bQQ().ahA();
        }

        @SuppressLint({"ResourceType"})
        public final void Y(float f) {
            f.this.tvG.X(f);
            f.this.tvH.setText(R.l.elh);
            f.this.tvI.setImageResource(R.k.dyU);
            f.this.tvF.setVisibility(0);
            x.d("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onAdjustVolume:" + f);
        }

        @SuppressLint({"ResourceType"})
        public final void Z(float f) {
            f.this.tvG.X(f);
            f.this.tvH.setText(R.l.elg);
            f.this.tvI.setImageResource(R.k.dyS);
            f.this.tvF.setVisibility(0);
            x.d("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onAdjustBrightness:" + f);
        }

        public final void ahl() {
            f.this.tvF.setVisibility(8);
            com.tencent.mm.plugin.aj.a.a.a.qq(23);
        }

        public final void ahm() {
            f.this.tvF.setVisibility(8);
            com.tencent.mm.plugin.aj.a.a.a.qq(24);
        }
    }

    static /* synthetic */ boolean r(f fVar) {
        return !fVar.bQL();
    }

    public f(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.i.dtl, this);
        this.tvx = (FrameLayout) findViewById(R.h.cVL);
        this.tvy = (TextView) findViewById(R.h.cEj);
        this.tvA = findViewById(R.h.cUL);
        this.tvB = findViewById(R.h.cVF);
        this.tvC = findViewById(R.h.cUM);
        this.tvF = (LinearLayout) findViewById(R.h.bJy);
        this.tvD = findViewById(R.h.cVg);
        this.tvG = (FtsWebDotPercentIndicator) findViewById(R.h.bJz);
        this.tvH = (TextView) findViewById(R.h.bJw);
        this.tvI = (ImageView) findViewById(R.h.bJx);
        this.tvV = findViewById(R.h.cVj);
        this.tvJ = (ImageView) findViewById(R.h.bZu);
        this.tvP = (TextView) findViewById(R.h.cVC);
        this.tvG.bQW();
        this.tvK = (ImageView) findViewById(R.h.bZp);
        this.tvL = (ImageView) findViewById(R.h.bZq);
        this.tvO = (TextView) findViewById(R.h.cHK);
        this.tvM = (Button) findViewById(R.h.cRV);
        this.tvN = (TextView) findViewById(R.h.cRW);
        this.tvS = (ImageView) findViewById(R.h.cfJ);
        this.tvT = (TextView) findViewById(R.h.cks);
        this.tvU = (ImageView) findViewById(R.h.cNT);
        this.tvE = findViewById(R.h.cko);
        this.twa = findViewById(R.h.cCO);
        this.twb = (TextView) findViewById(R.h.cCP);
        this.tvE.setVisibility(8);
        this.tvS.setOnClickListener(this.twh);
        this.tvX = (ImageView) findViewById(R.h.cCS);
        this.tvY = (ImageView) findViewById(R.h.cCR);
        this.tvW = (FrameLayout) findViewById(R.h.cCT);
        this.tvM.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (f.this.tvZ == c.twq) {
                    ((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).bFZ();
                }
                if (((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).isConnected()) {
                    if (g.bQQ().twx) {
                        g.bQQ().bFk();
                    } else {
                        f.this.kn(true);
                    }
                    com.tencent.mm.plugin.aj.a.a.a.qq(19);
                    return;
                }
                com.tencent.mm.plugin.aj.a.a.a.qq(20);
            }
        });
        this.twa.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                f.this.bQJ();
                f.this.ko(false);
                com.tencent.mm.plugin.aj.a.a.a.qq(18);
            }
        });
        this.tvK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (f.this.tvv == null || f.this.tvv.hashCode() != ((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).bGb()) {
                    f.this.tvu.Av(f.this.position);
                    com.tencent.mm.plugin.webview.fts.topstory.a.d.OH(f.this.skA.skE);
                    com.tencent.mm.plugin.webview.fts.topstory.a.d.b(f.this.skA, f.this.position, false);
                    return;
                }
                f.this.kn(true);
            }
        });
        this.tvL.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                f.this.bQA();
                f.this.bQJ();
                f.this.tvz.bRe();
                g bQQ = g.bQQ();
                d e = f.this.skA;
                String g = f.this.frp;
                com.tencent.mm.plugin.webview.fts.topstory.a.d.bQf();
                bQQ.twv.setKeepScreenOn(true);
                bQQ.twv.bQz();
                bQQ.twv.OL(g);
                bQQ.tww = e;
                bQQ.twx = true;
                bQQ.twy = false;
                bQQ.bQR();
                f.this.bQB();
                if (d.bQo().nhE) {
                    com.tencent.mm.plugin.aj.a.a.a.qq(17);
                } else {
                    com.tencent.mm.plugin.aj.a.a.a.qq(12);
                }
            }
        });
        this.tvA.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (!d.bQo().nhE && f.this.tvv != null && f.this.tvv.hashCode() != ((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).bGb()) {
                    f.this.tvu.Av(f.this.position);
                    com.tencent.mm.plugin.webview.fts.topstory.a.d.OH(f.this.skA.skE);
                    com.tencent.mm.plugin.webview.fts.topstory.a.d.b(f.this.skA, f.this.position, false);
                }
            }
        });
        this.tvU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (d.bQo().nhE) {
                    com.tencent.mm.plugin.aj.a.a.a.qq(10);
                    f.this.bQJ();
                    TopStoryVideoItemView.a(f.this.getContext(), f.this, f.this.position);
                }
            }
        });
        this.tvR = new com.tencent.mm.plugin.webview.fts.topstory.ui.widget.a(getContext(), this, new b());
        this.tvQ = new com.tencent.mm.plugin.webview.fts.topstory.ui.widget.a(getContext(), this, new b());
        this.tvQ.twP = true;
        this.tvQ.twO = true;
        this.tvz = new TopStoryVideoViewControlBar(getContext());
        this.tvz.setVisibility(8);
        this.tvz.k(this.twi);
        this.tvz.l(this.twh);
        this.tvz.txb = new com.tencent.mm.plugin.webview.fts.topstory.ui.widget.TopStoryVideoViewControlBar.a() {
            public final void update(int i, int i2) {
                int width;
                if (i2 > 0) {
                    width = (f.this.tvY.getWidth() * i) / i2;
                } else {
                    width = 0;
                }
                LayoutParams layoutParams = (LayoutParams) f.this.tvX.getLayoutParams();
                layoutParams.width = width;
                f.this.tvX.setLayoutParams(layoutParams);
                f.this.tvX.requestLayout();
            }

            public final void bQM() {
                f.this.tvW.setVisibility(8);
            }

            public final void bQN() {
                if (!g.bQQ().twx || (!(g.bQQ().bQT() || g.bQQ().twy) || d.bQo().nhE)) {
                    f.this.tvW.setVisibility(8);
                } else {
                    f.this.tvW.setVisibility(0);
                }
            }
        };
        this.tvz.j(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.plugin.aj.a.a.a.qq(21);
                f.this.kYN = !f.this.kYN;
                g.bQQ().setMute(f.this.kYN);
                if (f.this.kYN) {
                    f.this.tvz.AA();
                } else {
                    f.this.tvz.bRc();
                }
                f.this.tvz.bRe();
            }
        });
        this.tvz.qAn = new com.tencent.mm.plugin.sight.decode.ui.b() {
            public final void ahn() {
                x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onSeekPre");
                f.this.tvz.bRd();
            }

            public final void kK(int i) {
                x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onSeekTo %d", Integer.valueOf(i));
                f.seekTo(i);
                f.this.tvz.bRe();
                com.tencent.mm.plugin.aj.a.a.a.qq(22);
            }
        };
        this.tvz.h(new OnClickListener() {
            public final void onClick(View view) {
                if (g.bQQ().twx) {
                    com.tencent.mm.plugin.webview.fts.topstory.a.d.OH(f.this.skA.skE);
                    if (g.bQQ().bQT()) {
                        g.bQQ().byf();
                        f.this.tvz.bRd();
                        f.this.tvz.bRg();
                    } else {
                        g.bQQ().bFk();
                        f.this.tvz.bRe();
                        f.this.tvz.bRf();
                    }
                    f.this.bQB();
                    return;
                }
                x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "no video play now");
            }
        });
        this.tvz.txV = new com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoViewControlBar.a() {
            public final int ahg() {
                g bQQ = g.bQQ();
                return bQQ.twv != null ? bQQ.twv.TO() : 0;
            }

            public final int ahh() {
                return g.bQQ().ahy();
            }

            public final int bQO() {
                g bQQ = g.bQQ();
                return bQQ.twv != null ? bQQ.twv.ahz() : 0;
            }
        };
        TopStoryVideoViewControlBar topStoryVideoViewControlBar = this.tvz;
        topStoryVideoViewControlBar.twX.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (d.bQo().nhE) {
                    com.tencent.mm.plugin.aj.a.a.a.qq(10);
                    TopStoryVideoItemView.a(f.this.getContext(), f.this, f.this.position);
                }
            }
        });
    }

    public final void bQA() {
        this.frp = UUID.randomUUID().toString();
    }

    public final void bQB() {
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "setPlayingContainerStatus");
        this.tvA.setVisibility(8);
        this.tvJ.setVisibility(8);
        this.tvF.setVisibility(8);
        this.tvy.setVisibility(8);
        this.tvx.setVisibility(0);
        this.tvx.setAlpha(1.0f);
    }

    public final void bQC() {
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "setStopContainerStatus");
        this.tvJ.setVisibility(0);
        this.tvA.setVisibility(0);
        this.tvS.setVisibility(8);
        this.tvT.setVisibility(8);
        this.tvU.setVisibility(8);
        this.tvW.setVisibility(8);
        this.tvB.setVisibility(8);
        this.tvC.setVisibility(0);
        this.tvE.setVisibility(8);
        this.tvK.setVisibility(0);
        this.tvL.setVisibility(8);
        this.tvO.setVisibility(8);
        if (((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).bFX()) {
            this.tvP.setText(bi.a(this.skA.skS, 100.0d));
            this.tvP.setVisibility(0);
            return;
        }
        this.tvP.setVisibility(8);
    }

    public final void bQD() {
        eQ(bQF(), this.tvu.bQk().getString(R.l.eTF));
    }

    public final void eQ(String str, String str2) {
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "setWarningTipContainerStatus %s %s", str, str2);
        this.tvJ.setVisibility(0);
        this.tvA.setVisibility(0);
        this.tvS.setVisibility(8);
        this.tvT.setVisibility(8);
        this.tvU.setVisibility(8);
        this.tvB.setVisibility(0);
        this.tvC.setVisibility(8);
        this.tvE.setVisibility(8);
        this.tvD.setVisibility(0);
        this.tvV.setVisibility(8);
        if (TextUtils.isEmpty(str)) {
            this.tvN.setVisibility(8);
        } else {
            this.tvN.setText(str);
            this.tvN.setVisibility(0);
        }
        if (TextUtils.isEmpty(str2)) {
            this.tvM.setVisibility(8);
            return;
        }
        this.tvM.setText(str2);
        this.tvM.setVisibility(0);
    }

    public final void bQE() {
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "setReplayContainerStatus");
        this.tvJ.setVisibility(0);
        this.tvA.setVisibility(0);
        this.tvy.setVisibility(8);
        this.tvF.setVisibility(8);
        this.tvB.setVisibility(8);
        this.tvC.setVisibility(0);
        this.tvK.setVisibility(8);
        this.tvP.setVisibility(8);
        this.tvL.setVisibility(0);
        this.tvO.setVisibility(0);
        if (d.bQo().nhE) {
            this.tvS.setVisibility(0);
            this.tvT.setVisibility(0);
            this.tvU.setVisibility(0);
        } else {
            this.tvS.setVisibility(8);
            this.tvT.setVisibility(8);
            this.tvU.setVisibility(8);
        }
        if (this.twe && ((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).aCJ()) {
            this.tvE.setVisibility(0);
        } else {
            this.tvE.setVisibility(8);
        }
    }

    static {
        com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
        aVar.hFl = true;
        aVar.hFk = true;
        twf = aVar.PQ();
    }

    private String bQF() {
        return getContext().getString(R.l.eTv);
    }

    public final boolean kn(boolean z) {
        if (!((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).isConnected()) {
            this.tvZ = c.twr;
            this.tvz.setVisibility(8);
            eQ(bQF(), getContext().getString(R.l.eTF));
            return false;
        } else if (z && ((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).bFX() && !((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).bFY()) {
            String string;
            this.tvZ = c.twq;
            this.tvz.setVisibility(8);
            if (this.skA.skS == 0) {
                string = getContext().getString(R.l.eTx);
            } else {
                string = getContext().getString(R.l.eTw, new Object[]{bi.a(this.skA.skS, 100.0d)});
            }
            eQ(string, getContext().getString(R.l.eTj));
            return false;
        } else {
            bQA();
            this.tvZ = c.twp;
            x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "setStartPlayContainerStatus");
            this.tvA.setVisibility(0);
            this.tvS.setVisibility(8);
            this.tvT.setVisibility(8);
            this.tvU.setVisibility(8);
            this.tvC.setVisibility(8);
            this.tvE.setVisibility(8);
            this.tvW.setVisibility(8);
            this.tvB.setVisibility(0);
            this.tvD.setVisibility(8);
            this.tvV.setVisibility(0);
            this.tvV.setVisibility(0);
            this.tvV.setAlpha(0.0f);
            this.tvV.animate().setDuration(2000).setInterpolator(new AccelerateInterpolator()).alpha(1.0f).start();
            this.tvJ.setVisibility(0);
            this.tvF.setVisibility(8);
            this.tvy.setVisibility(8);
            this.tvx.setVisibility(0);
            this.tvx.setAlpha(0.0f);
            this.tvz.bRf();
            g bQQ = g.bQQ();
            if (bQQ.twv == null) {
                AbstractVideoView topStoryVideoView = new TopStoryVideoView(ad.getContext());
                topStoryVideoView.twz = bQQ.twz;
                bQQ.twv = topStoryVideoView;
            }
            if (bQQ.twv.getParent() != null) {
                ((ViewGroup) bQQ.twv.getParent()).removeView(bQQ.twv);
            }
            this.tvx.addView(bQQ.twv);
            bQQ.twv.a(this.tvz);
            bQQ.twv.jwv = this.twg;
            bQQ.twu.a(bQQ.twA);
            g bQQ2 = g.bQQ();
            d dVar = this.skA;
            x.i("MicroMsg.WebSearch.TopStoryVideoViewMgr", "start play %s %s", dVar.title, this.frp);
            if (bQQ2.tww != null) {
                if (!bQQ2.tww.skQ.equals(dVar.skQ)) {
                    bQQ2.twv.stop();
                    com.tencent.mm.plugin.webview.fts.topstory.a.d.bQf();
                }
                return true;
            }
            if (bi.oN(dVar.videoUrl)) {
                x.e("MicroMsg.WebSearch.TopStoryVideoViewMgr", "video url is null");
            } else {
                bQQ2.twv.b(false, dVar.videoUrl, dVar.skD);
                bQQ2.twv.setMute(false);
                bQQ2.twv.setKeepScreenOn(true);
                bQQ2.twv.OL(r4);
                bQQ2.twv.bQz();
                bQQ2.tww = dVar;
                bQQ2.twx = true;
                bQQ2.twy = false;
                bQQ2.bQR();
            }
            return true;
        }
    }

    final void av() {
        this.tvJ.setImageDrawable(null);
        o.PG().a(this.skA.skC, this.tvJ, twf);
        this.tvw = a.LANDSCAPE;
        this.tvz.wD(this.skA.skD);
        TopStoryVideoViewControlBar topStoryVideoViewControlBar = this.tvz;
        topStoryVideoViewControlBar.twY.setText(this.skA.title);
        this.tvT.setText(this.skA.title);
        if (this.tvv != null && this.tvv.hashCode() != ((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).bGb()) {
            if (((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).isConnected()) {
                bQC();
            } else {
                eQ(bQF(), getContext().getString(R.l.eTF));
            }
        }
    }

    public static void seekTo(int i) {
        int ahA = g.bQQ().ahA();
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "seek to position=%d current=%d", Integer.valueOf(i), Integer.valueOf(ahA));
        g bQQ = g.bQQ();
        if (bQQ.twv != null) {
            bQQ.twv.s(i, true);
        }
        if (com.tencent.mm.plugin.webview.fts.topstory.a.d.tun != null) {
            com.tencent.mm.plugin.webview.fts.topstory.a.d.tun.skx = 1;
        }
    }

    public final void bQG() {
        if (this.tvz != null) {
            this.tvz.setVisibility(8);
        }
    }

    public final void bQH() {
        if (this.tvz != null) {
            this.tvz.kp(false);
        }
    }

    public final void setMute(boolean z) {
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "setMute isMute=%b", Boolean.valueOf(z));
        this.kYN = z;
        g.bQQ().setMute(z);
        if (z) {
            this.tvz.AA();
        } else {
            this.tvz.bRc();
        }
    }

    public final void bQI() {
        bQE();
        if (((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).aCJ()) {
            if (this.twc == null) {
                this.twc = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
                    public final boolean uG() {
                        f.this.twd = f.this.twd - 1;
                        f.this.twb.setText(f.this.getContext().getString(R.l.eCI, new Object[]{Integer.valueOf(f.this.twd)}));
                        if (f.this.twd > 0) {
                            return true;
                        }
                        f.this.ko(true);
                        return false;
                    }
                }, true);
            }
            this.twd = 2;
            this.twb.setVisibility(0);
            this.twb.setText(getContext().getString(R.l.eCI, new Object[]{Integer.valueOf(this.twd)}));
            this.twc.K(1000, 1000);
            x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "%s startPlayNextCountDown, position: %s", Integer.valueOf(hashCode()), Integer.valueOf(this.position));
            return;
        }
        bQJ();
    }

    public final void bQJ() {
        if (this.twc != null) {
            this.twc.TN();
        }
        this.twb.setVisibility(8);
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "%s stopPlayNextCountDown, position: %s", Integer.valueOf(hashCode()), Integer.valueOf(this.position));
    }

    public final void ko(boolean z) {
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "playNextVideo %b", Boolean.valueOf(z));
        if (this.position + 1 < com.tencent.mm.plugin.webview.fts.topstory.a.b.bQb() - 1) {
            this.position++;
            this.skA = (d) com.tencent.mm.plugin.webview.fts.topstory.a.b.ttW.get(this.position);
            av();
            if (z) {
                com.tencent.mm.plugin.webview.fts.topstory.a.d.tuo = 1;
            }
            kn(true);
            return;
        }
        this.tvu.a(new c() {
            public final void bQn() {
                if (d.bQo().nhE) {
                    f.this.twe = true;
                    f.this.bQI();
                    return;
                }
                f.this.tvu.Av(f.this.position + 1);
            }
        });
        bQG();
        this.twe = false;
        bQE();
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (d.bQo().nhE) {
            if (this.tvQ != null) {
                this.tvQ.F(motionEvent);
            }
        } else if (this.tvR != null) {
            this.tvR.F(motionEvent);
        }
        return true;
    }

    public final void bQK() {
        if (((AudioManager) getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3) <= 1) {
            setMute(true);
        } else {
            setMute(false);
        }
    }

    private boolean bQL() {
        return this.tvA.getVisibility() == 0;
    }

    public final void em(int i, int i2) {
        if (i == 0) {
            if (g.bQQ().twx) {
                bQB();
            } else {
                bQC();
            }
        } else if (i2 == 0) {
            bQD();
        }
    }
}
