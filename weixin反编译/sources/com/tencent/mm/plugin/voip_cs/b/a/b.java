package com.tencent.mm.plugin.voip_cs.b.a;

import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.brandservice.a.j;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.k;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.ui.VoipBigIconButton;
import com.tencent.mm.plugin.voip.video.MovableVideoView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.pb.common.c.g;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Timer;
import java.util.TimerTask;

public final class b implements SurfaceTextureListener, OnClickListener, com.tencent.mm.plugin.voip.model.k.a, f {
    protected static int mScreenHeight;
    protected static int mScreenWidth;
    protected static final int[] swh = new int[]{-1, R.l.eVj, R.l.eVo, R.l.eVn};
    public boolean fwD = false;
    private ag hbP;
    private Timer jBG;
    public TextView kHt;
    private TextView ljv;
    private ImageButton oNR;
    private View oOj;
    public com.tencent.mm.plugin.voip.video.a oOu;
    public ObservableTextureView oOw;
    public al sDA = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            b.this.sDl.setText(ad.getContext().getString(R.l.eVq));
            b.this.sDm.setVisibility(0);
            com.tencent.mm.plugin.voip_cs.c.a c = b.this.sDw;
            TextView b = b.this.sDm;
            int[] iArr = b.swh;
            if (iArr == null || b == null) {
                x.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
            } else {
                c.bIQ();
                c.sww = 0;
                c.swu = iArr;
                c.kO = b;
                c.swv = 500;
                if (c.ind != null) {
                    long j = (long) c.swv;
                    c.ind.K(j, j);
                }
                x.j("MicroMsg.DynamicTextWrap", "start textview:" + b, new Object[0]);
            }
            return true;
        }
    }, false);
    a sDB = new a();
    c sDC;
    b sDD;
    String sDE = "";
    Drawable sDF = null;
    public VoipCSMainUI sDi;
    public RelativeLayout sDj;
    private TextView sDk;
    private TextView sDl;
    private TextView sDm;
    private TextView sDn;
    public ImageView sDo;
    private ag sDp;
    private boolean sDq = false;
    protected long sDr = -1;
    private boolean sDs = false;
    private boolean sDt = false;
    public int sDu = 60000;
    public int sDv = 5000;
    private com.tencent.mm.plugin.voip_cs.c.a sDw = new com.tencent.mm.plugin.voip_cs.c.a();
    public String sDx = "";
    public String sDy = "";
    public al sDz = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            x.i("MicroMsg.voipcs.VoipCSViewManager", "voipcs invite time out!opposite not responese");
            com.tencent.mm.plugin.voip_cs.b.b.bJE().bjS = 1;
            b.this.zr(6);
            return true;
        }
    }, false);
    private OpenGlView swF;
    private OpenGlView swG;
    public OpenGlRender swH;
    public OpenGlRender swI;
    private OnClickListener sxM = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.voipcs.VoipCSViewManager", "switch camera");
            b.this.sxc.setEnabled(false);
            if (com.tencent.mm.plugin.voip_cs.b.b.bJD().sDa > 1) {
                b.this.bJP();
            }
            b.this.sxc.setEnabled(true);
            if (b.this.oOu != null) {
                b.this.oOu.bJe();
            }
        }
    };
    private VoipBigIconButton sxc;
    private boolean sxu = false;

    private class a {
        int h;
        int[] oME;
        int w;

        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }
    }

    class b implements Runnable {
        b() {
        }

        public final void run() {
            b.this.sDF = b.Np(b.this.sDE);
            Message message = new Message();
            message.what = 12;
            b.this.sDp.sendMessage(message);
            e.remove(b.this.sDD);
        }
    }

    class c implements Runnable {
        boolean sqV = false;

        c() {
        }

        public final void run() {
            while (!this.sqV && !b.this.fwD) {
                if (com.tencent.mm.plugin.voip_cs.b.b.bJC().nKn.videoDecode(com.tencent.mm.plugin.voip_cs.b.b.bJC().nKn.svc) == 1) {
                    int i = com.tencent.mm.plugin.voip_cs.b.b.bJC().nKn.field_remoteImgWidth;
                    int i2 = com.tencent.mm.plugin.voip_cs.b.b.bJC().nKn.field_remoteImgHeight;
                    if (OpenGlRender.sAB == 1) {
                        if (b.this.sxu) {
                            b.this.swI.a(com.tencent.mm.plugin.voip_cs.b.b.bJC().nKn.svc, i, i2, OpenGlRender.sAh + OpenGlRender.sAn);
                        } else {
                            b.this.swH.a(com.tencent.mm.plugin.voip_cs.b.b.bJC().nKn.svc, i, i2, OpenGlRender.sAh + OpenGlRender.sAn);
                        }
                    } else if (b.this.sxu) {
                        b.this.swI.a(com.tencent.mm.plugin.voip_cs.b.b.bJC().nKn.svc, i, i2, OpenGlRender.sAk + OpenGlRender.sAn);
                    } else {
                        b.this.swH.a(com.tencent.mm.plugin.voip_cs.b.b.bJC().nKn.svc, i, i2, OpenGlRender.sAk + OpenGlRender.sAn);
                    }
                }
                try {
                    Thread.sleep(20);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.voipcs.VoipCSViewManager", e, "", new Object[0]);
                }
            }
        }
    }

    public b(VoipCSMainUI voipCSMainUI) {
        this.sDi = voipCSMainUI;
        WindowManager windowManager = (WindowManager) voipCSMainUI.getSystemService("window");
        int height = windowManager.getDefaultDisplay().getHeight() / 5;
        int width = (windowManager.getDefaultDisplay().getWidth() * height) / windowManager.getDefaultDisplay().getHeight();
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            ((RelativeLayout) voipCSMainUI.findViewById(R.h.cIp)).setPadding(0, 0, 0, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(voipCSMainUI.mController.xRr, 40.0f));
        }
        this.swG = new MovableVideoView(voipCSMainUI.getApplicationContext());
        ((MovableVideoView) this.swG).dV(width, height);
        this.swG.setVisibility(8);
        this.swH = new OpenGlRender(this.swG, OpenGlRender.sAr);
        this.swG.a(this.swH);
        this.swG.setRenderMode(0);
        if (Build.MODEL.equals("Nexus 6")) {
            this.swG.setZOrderOnTop(true);
        } else {
            this.swG.setZOrderMediaOverlay(true);
        }
        this.ljv = (TextView) voipCSMainUI.findViewById(R.h.cRz);
        this.ljv.setVisibility(0);
        this.jBG = new Timer("voip_cs_talking_time");
        this.sDk = (TextView) voipCSMainUI.findViewById(R.h.cXw);
        this.sDk.setVisibility(0);
        this.sDl = (TextView) voipCSMainUI.findViewById(R.h.cXB);
        if (voipCSMainUI.fLx.equals("1")) {
            if (voipCSMainUI.type.equals(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                this.sDl.setText(ad.getContext().getString(R.l.eUS));
            } else {
                this.sDl.setText(ad.getContext().getString(R.l.eUT));
            }
        } else if (voipCSMainUI.type.equals(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
            this.sDl.setText(ad.getContext().getString(R.l.eUU));
        } else {
            this.sDl.setText(ad.getContext().getString(R.l.eUT));
        }
        this.sDl.setVisibility(0);
        this.kHt = (TextView) voipCSMainUI.findViewById(R.h.cXD);
        this.kHt.setVisibility(0);
        this.sDo = (ImageView) voipCSMainUI.findViewById(R.h.cXx);
        this.sDo.setVisibility(0);
        this.sDn = (TextView) voipCSMainUI.findViewById(R.h.cXA);
        this.sDm = (TextView) voipCSMainUI.findViewById(R.h.cXC);
        this.sxc = (VoipBigIconButton) voipCSMainUI.findViewById(R.h.cXy);
        if (voipCSMainUI.sDO == null || !voipCSMainUI.sDO.equals("1")) {
            this.sxc.setVisibility(8);
        } else {
            this.sxc.setVisibility(0);
            this.sxc.setOnClickListener(this.sxM);
        }
        this.hbP = new ag();
        this.sDp = new ag() {
            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 12:
                        if (b.this.sDF != null) {
                            b.this.sDo.setImageDrawable(b.this.sDF);
                            return;
                        } else {
                            b.this.sDo.setImageResource(R.g.bBC);
                            return;
                        }
                    default:
                        return;
                }
            }
        };
        this.oOj = voipCSMainUI.findViewById(R.h.cXu);
        this.oNR = (ImageButton) voipCSMainUI.findViewById(R.h.cXz);
        this.sDj = (RelativeLayout) voipCSMainUI.findViewById(R.h.cXu);
        mScreenWidth = com.tencent.mm.bu.a.eB(voipCSMainUI.mController.xRr);
        mScreenHeight = com.tencent.mm.plugin.voip_cs.c.b.dJ(voipCSMainUI.mController.xRr);
        this.swF = (OpenGlView) voipCSMainUI.findViewById(R.h.cXv);
        this.swF.dW(mScreenWidth, mScreenHeight);
        this.swI = new OpenGlRender(this.swF, OpenGlRender.sAq);
        this.swF.a(this.swI);
        this.swF.setRenderMode(0);
        this.swF.setVisibility(0);
        x.i("MicroMsg.voipcs.VoipCSViewManager", "mScreenHeight %d", Integer.valueOf(mScreenHeight));
        this.oNR.setOnClickListener(this);
        this.sDj.addView(this.swG);
        this.swG.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                b.this.sxu = !b.this.sxu;
                Point b = b.this.jr(b.this.sxu);
                b.this.swG.dX(b.x, b.y);
            }
        });
        this.swH.szX = true;
        this.swI.szX = true;
        if (!d.dE(ad.getContext())) {
            d.dF(ad.getContext());
        }
        SharedPreferences cgg = ad.cgg();
        this.sDx = cgg.getString(bJM(), "");
        if (this.sDi.jmb != null && !this.sDi.jmb.equals("")) {
            No(this.sDi.jmb);
        } else if (!g.isNullOrEmpty(this.sDx)) {
            No(this.sDx);
        }
        this.sDy = cgg.getString(bJN(), "");
        if (!g.isNullOrEmpty(this.sDy)) {
            Nn(this.sDy);
        }
        com.tencent.mm.ad.e bJD = com.tencent.mm.plugin.voip_cs.b.b.bJD();
        String str = this.sDi.sDb;
        x.d("MicroMsg.voipcs.VoipCSService", "start getBizInfo for username:" + str);
        as.CN().a(455, bJD);
        as.CN().a(new j(str), 0);
    }

    public final void Nn(String str) {
        CharSequence charSequence;
        if (this.sDi.sDR) {
            charSequence = str + ad.getContext().getString(R.l.eUM);
        } else {
            charSequence = str + ad.getContext().getString(R.l.eUN);
        }
        this.kHt.setText(charSequence);
    }

    public final void No(String str) {
        if (!g.isNullOrEmpty(str)) {
            this.sDD = new b();
            if (this.sDi.jmb == null || this.sDi.jmb.equals("")) {
                this.sDE = str;
            } else {
                this.sDE = this.sDi.jmb;
            }
            e.b(this.sDD, "VOIPCS_netPic", 10);
        }
    }

    public final String bJM() {
        return "voip_cs_headImageUrl_" + this.sDi.sDb;
    }

    public final String bJN() {
        return "voip_cs_nickname_" + this.sDi.sDb;
    }

    private Point jr(boolean z) {
        int height = ((WindowManager) this.sDi.getSystemService("window")).getDefaultDisplay().getHeight() / 5;
        return new Point((int) (jp(!z) * ((float) height)), height);
    }

    private static float jp(boolean z) {
        byte[] bArr;
        float f = 0.74766356f;
        if (z) {
            try {
                bArr = com.tencent.mm.plugin.voip_cs.b.b.bJC().nKn.field_capInfo;
            } catch (Exception e) {
                x.e("MicroMsg.voipcs.VoipCSViewManager", "update failed: " + e.getMessage());
            }
        } else {
            bArr = com.tencent.mm.plugin.voip_cs.b.b.bJC().nKn.sul;
        }
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            if (wrap.getInt() > 65535) {
                wrap.order(ByteOrder.LITTLE_ENDIAN);
            }
            wrap.getShort();
            wrap.getShort();
            float f2 = ((float) wrap.getInt()) / 100.0f;
            if (f2 != 0.0f) {
                f = f2;
            }
            x.d("MicroMsg.voipcs.VoipCSViewManager", "use rate: %s, changed: %s", Float.valueOf(f), Boolean.valueOf(z));
        }
        return f;
    }

    public final void onClick(View view) {
        boolean z = false;
        if (view.getId() == R.h.cXz) {
            if (com.tencent.mm.plugin.voip_cs.b.b.bJD().sDa < 2) {
                com.tencent.mm.plugin.voip_cs.b.b.bJE().bjS = 2;
            } else {
                com.tencent.mm.plugin.voip_cs.b.b.bJE().bjS = 4;
            }
            com.tencent.mm.plugin.voip_cs.b.c bJE = com.tencent.mm.plugin.voip_cs.b.b.bJE();
            bJE.sCd = 1;
            bJE.sCA = 1;
            bJE.sCe = (int) (System.currentTimeMillis() / 1000);
            bJE = com.tencent.mm.plugin.voip_cs.b.b.bJE();
            x.d("MicroMsg.VoipCSReportHelper", "selfCancel");
            if (bJE.sCx == 0) {
                bJE.sCs = 3;
                if (bJE.sCB == 0 && bJE.sCN != 0) {
                    bJE.sCB = (long) (((int) (System.currentTimeMillis() / 1000)) - bJE.sCN);
                }
            }
            com.tencent.mm.plugin.voip_cs.b.b.bJE().bJF();
            x.d("MicroMsg.voipcs.VoipCSViewManager", "user click hangup button!");
            zr(0);
            return;
        }
        int i = this.oNR.getVisibility() == 0 ? 8 : 0;
        this.oNR.setVisibility(i);
        this.ljv.setVisibility(i);
        this.sDk.setVisibility(i);
        zq(i);
        if (i == 0) {
            z = true;
        }
        jw(z);
    }

    private void zq(int i) {
        if (this.sDi.sDO == null || !this.sDi.sDO.equals("1")) {
            this.sxc.setVisibility(8);
        } else {
            this.sxc.setVisibility(i);
        }
    }

    public final void bJO() {
        x.i("MicroMsg.voipcs.VoipCSViewManager", "stop capture render");
        if (this.oOw != null) {
            this.sDj.removeView(this.oOw);
            this.oOw = null;
        }
        if (this.oOu != null) {
            this.oOu.bJg();
            com.tencent.mm.plugin.voip.video.a.bJh();
            this.oOu = null;
        }
    }

    private void bJP() {
        x.i("MicroMsg.voipcs.VoipCSViewManager", "trigger dismiss button");
        this.hbP.postDelayed(new Runnable() {
            public final void run() {
                x.i("MicroMsg.voipcs.VoipCSViewManager", "dismiss button");
                if (!b.this.sDi.isFinishing()) {
                    b.this.oNR.setVisibility(8);
                    b.this.ljv.setVisibility(8);
                    b.this.sDk.setVisibility(8);
                    b.this.zq(8);
                    b.this.jw(false);
                }
            }
        }, 10000);
    }

    private void jw(boolean z) {
        if (Build.MANUFACTURER.equalsIgnoreCase("sony")) {
            x.i("MicroMsg.voipcs.VoipCSViewManager", "sony is not compatible,so we return.");
        } else if (z) {
            this.sDi.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        } else {
            this.sDi.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
    }

    public final void aTC() {
        this.sDz.TN();
        this.sDA.TN();
        this.sDw.bIQ();
        this.sDm.setVisibility(8);
        this.sDl.setText(R.l.eVm);
        this.sDk.setText(R.l.eVa);
        zq(0);
        this.oOj.setOnClickListener(this);
        if (this.sDi.sDP != null && this.sDi.sDP.equals("1")) {
            this.swG.setVisibility(0);
            this.sxu = true;
            Point jr = jr(this.sxu);
            ((MovableVideoView) this.swG).dV(jr.x, jr.y);
            bJQ();
        }
        bJP();
        this.sDs = true;
        if (this.jBG == null) {
            this.jBG = new Timer("voip_cs_talking_time");
        }
        if (!this.sDq) {
            if (this.sDr == -1) {
                this.sDr = bi.Wx();
            }
            this.sDq = true;
            this.jBG.schedule(new TimerTask() {
                public final void run() {
                    b.this.hbP.post(new Runnable() {
                        public final void run() {
                            b.this.ljv.setText(b.bq(bi.bz(b.this.sDr)));
                        }
                    });
                }
            }, 1000, 1000);
            k.bHR().bHS();
            k.bHR().ssN = this;
        }
    }

    public static Drawable Np(String str) {
        try {
            return Drawable.createFromStream((InputStream) new URL(str).getContent(), "urlDrawable");
        } catch (Exception e) {
            x.e("MicroMsg.voipcs.VoipCSViewManager", "parse Drawable faill!");
            return null;
        }
    }

    protected static String bq(long j) {
        return String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
    }

    public final void zr(int i) {
        x.i("MicroMsg.voipcs.VoipCSViewManager", "onRefreshed for action:" + i);
        if (this.jBG != null) {
            this.jBG.cancel();
            this.jBG = null;
        }
        if (!this.sDz.cgx()) {
            this.sDz.TN();
        }
        if (!this.sDA.cgx()) {
            this.sDA.TN();
        }
        this.sDw.bIQ();
        this.sDq = false;
        this.sDn.setVisibility(0);
        this.sDn.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.sDn.setBackgroundResource(R.g.bHI);
        this.sDn.setCompoundDrawables(null, null, null, null);
        this.sDn.setCompoundDrawablePadding(0);
        this.sDn.setText(zs(i));
        if (com.tencent.mm.plugin.voip_cs.b.b.bJD().sDa == 2) {
            e.post(new Runnable() {
                public final void run() {
                    a bJK = a.bJK();
                    if (bJK.str != null) {
                        bJK.str.e(R.k.dAw, false, 0);
                    }
                }
            }, "VoipCS_play_end_sound");
        }
        this.hbP.postDelayed(new Runnable() {
            public final void run() {
                b.this.sDi.finish();
            }
        }, 2000);
    }

    private static int zs(int i) {
        if (i == 1) {
            return R.l.eUR;
        }
        if (i == 0) {
            return R.l.eUW;
        }
        if (i == -1 || i == 5) {
            return R.l.eVh;
        }
        if (i == ap.CTRL_INDEX || i == TencentLocation.ERROR_UNKNOWN) {
            return R.l.eVp;
        }
        if (i == 6) {
            return R.l.eVk;
        }
        if (i == 1001) {
            return R.l.eVg;
        }
        if (i == 10) {
            return R.l.eUV;
        }
        if (com.tencent.mm.plugin.voip_cs.b.b.bJD().sDa < 2) {
            return R.l.eUQ;
        }
        return R.l.eUW;
    }

    public final void aTD() {
        this.sDn.setVisibility(0);
        this.sDn.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.sDn.setBackgroundResource(R.g.bHI);
        this.sDn.setCompoundDrawables(null, null, null, null);
        this.sDn.setCompoundDrawablePadding(0);
        this.sDn.setText(zs(1001));
    }

    public final void aTE() {
        this.sDn.setVisibility(8);
    }

    public final void c(byte[] bArr, long j, int i, int i2, int i3) {
        x.d("MicroMsg.voipcs.VoipCSViewManager", "receive frame data , isPause : " + this.fwD);
        if (!this.fwD) {
            if (this.sDB.oME == null) {
                this.sDB.w = i;
                this.sDB.h = i2;
                this.sDB.oME = new int[(this.sDB.w * this.sDB.h)];
            }
            int i4 = this.oOu.bJi() ? OpenGlRender.sAp : 0;
            int i5 = this.oOu.bJj() ? OpenGlRender.sAo : OpenGlRender.sAn;
            if (this.sDs) {
                x.d("MicroMsg.voipcs.VoipCSViewManager", "videoEncodeToSend , ret = " + com.tencent.mm.plugin.voip_cs.b.b.bJC().nKn.videoEncodeToSend(bArr, bArr.length, i, i2, i3));
                v2protocal v2protocal = com.tencent.mm.plugin.voip_cs.b.b.bJC().nKn;
                v2protocal.svv++;
            }
            com.tencent.mm.plugin.voip_cs.b.b.bJC().nKn.videoEncodeToLocal(bArr, (int) j, i, i2, i3, 0, 75, this.sDB.oME);
            if (OpenGlRender.sAB == 1) {
                if (this.sxu) {
                    this.swH.a(this.sDB.oME, i, i2, (OpenGlRender.sAi + i4) + i5);
                } else {
                    this.swI.a(this.sDB.oME, i, i2, (OpenGlRender.sAi + i4) + i5);
                }
            } else if (OpenGlRender.sAB != 2) {
            } else {
                if (this.sxu) {
                    this.swH.c(bArr, i, i2, (OpenGlRender.sAm + i4) + i5);
                } else {
                    this.swI.c(bArr, i, i2, (OpenGlRender.sAm + i4) + i5);
                }
            }
        }
    }

    public final void bdJ() {
        x.e("MicroMsg.voipcs.VoipCSViewManager", "init camera fail！");
    }

    public final void bJQ() {
        bJR();
        this.sDC = new c();
        e.b(this.sDC, "VOIPCS_VideoDecode", 10);
        x.d("MicroMsg.voipcs.VoipCSViewManager", "start video decode thread..");
    }

    public final void bJR() {
        if (this.sDC != null) {
            x.d("MicroMsg.voipcs.VoipCSViewManager", "stop videodecode thread...");
            this.sDC.sqV = true;
            e.remove(this.sDC);
            this.sDC = null;
        }
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
