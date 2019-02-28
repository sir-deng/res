package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.MovableVideoView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.widget.VoIPVideoView;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public final class e extends d {
    private Timer bnp;
    private TextView nTz;
    int[] oME = null;
    Bitmap oMV = null;
    private CaptureView srU;
    private OpenGlView swF;
    private OpenGlView swG;
    private OpenGlRender swH;
    private OpenGlRender swI;
    private View swJ;
    private ImageView swK;
    private TextView swL;
    private TextView swM;
    private TextView swN;
    private View swO;
    private TextView swP;
    private TextView swQ;
    private TextView swR;
    private RelativeLayout swS;
    private Button swT;
    private VoipSmallIconButton swU;
    private VoipSmallIconButton swV;
    private VoipSmallIconButton swW;
    private VoipBigIconButton swX;
    private VoipBigIconButton swY;
    private VoipBigIconButton swZ;
    private a sxA;
    private OnClickListener sxB = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
            if (e.this.svT != null && e.this.svT.get() != null && ((c) e.this.svT.get()).bHt()) {
                e.this.sxb.setEnabled(false);
                e.this.sxa.setEnabled(false);
                e.this.cr(e.this.getString(R.l.eVy), -1);
            }
        }
    };
    private OnClickListener sxC = new OnClickListener() {
        public final void onClick(View view) {
            if (e.this.svT != null && e.this.svT.get() != null) {
                ((c) e.this.svT.get()).bHC();
            }
        }
    };
    private OnClickListener sxD = new OnClickListener() {
        public final void onClick(View view) {
            if (e.this.svT != null && e.this.svT.get() != null) {
                ((c) e.this.svT.get()).bHC();
            }
        }
    };
    private OnClickListener sxE = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
            if (ao.isWifi(e.this.getActivity()) || l.bHV()) {
                e.c(e.this);
            } else {
                h.a(e.this.getActivity(), R.l.eVS, R.l.eVT, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        l.bHU();
                        e.c(e.this);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        e.d(e.this);
                    }
                });
            }
        }
    };
    private OnClickListener sxF = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
            if (ao.isWifi(e.this.getActivity()) || (l.bHV() && !ao.is2G(e.this.getActivity()))) {
                e.e(e.this);
            } else {
                h.a(e.this.getActivity(), R.l.eVS, R.l.eVT, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (!ao.is2G(e.this.getActivity())) {
                            l.bHU();
                        }
                        e.e(e.this);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        e.d(e.this);
                    }
                });
            }
        }
    };
    private OnClickListener sxG = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.Voip.VoipVideoFragment", "click reject video invite button");
            e.d(e.this);
        }
    };
    private OnClickListener sxH = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
            if (e.this.svT != null && e.this.svT.get() != null && ((c) e.this.svT.get()).bHz()) {
                e.this.sxb.setEnabled(false);
                e.this.swX.setEnabled(false);
                e.this.swQ.setVisibility(0);
                e.this.swQ.setText(R.l.eUK);
            }
        }
    };
    private OnClickListener sxI = new OnClickListener() {
        public final void onClick(View view) {
            g.pWK.h(11618, Integer.valueOf(2), Integer.valueOf(1));
            if (!(e.this.svT == null || e.this.svT.get() == null)) {
                ((c) e.this.svT.get()).jm(true);
            }
            if (e.this.swm != null) {
                e.this.swm.D(false, true);
            }
        }
    };
    private OnClickListener sxJ = new OnClickListener() {
        public final void onClick(View view) {
            g.pWK.h(11619, Integer.valueOf(2));
            if (e.this.svT != null && e.this.svT.get() != null) {
                ((c) e.this.svT.get()).bHO();
            }
        }
    };
    private OnClickListener sxK = new OnClickListener() {
        public final void onClick(View view) {
            e.this.sxn = !e.this.sxn;
            if (!e.this.sxn) {
                e.this.sxk.setVisibility(8);
            }
            Toast.makeText(e.this.getActivity(), String.format("mIsShowFaceRect:%b", new Object[]{Boolean.valueOf(e.this.sxn)}), 0).show();
        }
    };
    private OnClickListener sxL = new OnClickListener() {
        public final void onClick(View view) {
            boolean a = bi.a((Boolean) view.getTag(), false);
            view.setTag(Boolean.valueOf(!a));
            if (a) {
                e.this.sxk.setVisibility(8);
                Toast.makeText(e.this.getActivity(), "stop face detect", 0).show();
            } else {
                Toast.makeText(e.this.getActivity(), "start face detect", 0).show();
            }
            if (e.this.svT != null && e.this.svT.get() != null) {
                ((c) e.this.svT.get()).bHP();
            }
        }
    };
    private OnClickListener sxM = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
            e.this.sxc.setEnabled(false);
            e.this.bIR();
            e.this.sxc.setEnabled(true);
            if (e.this.svT != null && e.this.svT.get() != null) {
                ((c) e.this.svT.get()).bHB();
            }
        }
    };
    private Runnable sxN = new Runnable() {
        public final void run() {
            x.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
            e.this.sxt = e.this.sxt - 1;
            if (e.this.getActivity() != null && !e.this.getActivity().isFinishing() && e.this.sxt <= 0) {
                e.this.sxc.setVisibility(8);
                e.this.swT.setVisibility(8);
                e.this.swP.setVisibility(8);
                e.this.sxb.setVisibility(8);
                e.this.sxa.setVisibility(8);
                e.d(e.this, false);
            }
        }
    };
    private Runnable sxO = new Runnable() {
        public final void run() {
            if (e.this.getActivity() != null && !e.this.getActivity().isFinishing()) {
                e.this.swQ.setVisibility(8);
            }
        }
    };
    int sxP = 0;
    private VoipBigIconButton sxa;
    private VoipBigIconButton sxb;
    private VoipBigIconButton sxc;
    private TextView sxd;
    private TextView sxe;
    private TextView sxf;
    private TextView sxg;
    private TextView sxh;
    private TextView sxi;
    private VoIPVideoView sxj;
    private com.tencent.mm.plugin.voip.video.e sxk = null;
    private Button sxl = null;
    private Button sxm = null;
    private boolean sxn = false;
    private int sxo;
    private int sxp;
    private int sxq;
    private int sxr;
    private int sxs;
    private int sxt = 0;
    private boolean sxu = false;
    private boolean sxv = false;
    private boolean sxw = false;
    private boolean sxx;
    public long sxy = 0;
    private Bitmap sxz = null;

    public class a implements Runnable {
        final /* synthetic */ e sxQ;

        public final void run() {
            x.i("MicroMsg.Voip.VoipVideoFragment", "try load blur bitmap");
            final Bitmap A = this.sxQ.sxz;
            this.sxQ.jQE.post(new Runnable() {
                public final void run() {
                    if (a.this.sxQ.swj != null) {
                        a.this.sxQ.swj.setBackgroundDrawable(new BitmapDrawable(A));
                    }
                    a.this.sxQ.sxA = null;
                }
            });
        }
    }

    static /* synthetic */ void c(e eVar) {
        x.i("MicroMsg.Voip.VoipVideoFragment", "accept video invite use voice");
        g.pWK.a(11526, true, true, Integer.valueOf(d.bGT().bHZ()), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(3));
        if (eVar.svT != null && eVar.svT.get() != null && ((c) eVar.svT.get()).bHu()) {
            eVar.swW.setEnabled(false);
            eVar.swZ.setEnabled(false);
            eVar.swY.setEnabled(false);
            eVar.swM.setText(R.l.eWr);
            eVar.swn.a(eVar.swN, swh);
        }
    }

    static /* synthetic */ void d(e eVar) {
        x.i("MicroMsg.Voip.VoipVideoFragment", "reject video invite");
        g.pWK.a(11526, true, true, Integer.valueOf(d.bGT().bHZ()), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(4));
        if (eVar.svT != null && eVar.svT.get() != null && ((c) eVar.svT.get()).bHv()) {
            eVar.cr(eVar.getString(R.l.eVX), -1);
            eVar.swY.setEnabled(false);
            eVar.swZ.setEnabled(false);
            eVar.swW.setEnabled(false);
        }
    }

    static /* synthetic */ void d(e eVar, boolean z) {
        if (z) {
            eVar.getActivity().getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        } else {
            eVar.getActivity().getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
    }

    static /* synthetic */ void e(e eVar) {
        x.i("MicroMsg.Voip.VoipVideoFragment", "accept video invite");
        g.pWK.a(11526, true, true, Integer.valueOf(d.bGT().bHZ()), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(1));
        if (eVar.svT != null && eVar.svT.get() != null && ((c) eVar.svT.get()).bHw()) {
            eVar.swZ.setEnabled(false);
            eVar.swY.setEnabled(false);
            eVar.swW.setEnabled(false);
            eVar.swX.setVisibility(8);
        }
    }

    static /* synthetic */ void t(e eVar) {
        m bGT = d.bGT();
        int i = eVar.sxp;
        com.tencent.mm.plugin.voip.model.g gVar = bGT.ssY.soQ.sql;
        gVar.soQ.sqj.svk = i;
        gVar.soQ.sqj.svl = 0;
        if (r.igy) {
            long Wx = bi.Wx();
            int i2 = (int) (Wx - eVar.sxy);
            if (i2 <= 1) {
                i2 = 1;
            }
            CharSequence format = String.format(Locale.US, "Cap Fps: %d", new Object[]{Integer.valueOf(eVar.sxp)});
            CharSequence format2 = String.format(Locale.US, "Send Fps: %d", new Object[]{Integer.valueOf(eVar.sxo)});
            CharSequence format3 = String.format(Locale.US, "Recv Fps: %d", new Object[]{Integer.valueOf(eVar.sxq)});
            int i3 = d.bGT().ssY.soQ.sql.soQ.sqj.field_sendVideoLen;
            int i4 = d.bGT().ssY.soQ.sql.soQ.sqj.field_recvVideoLen;
            eVar.sxr = (int) ((((double) (i3 - eVar.sxr)) * 8.0d) / ((double) (i2 * 1000)));
            eVar.sxs = (int) ((((double) (i4 - eVar.sxs)) * 8.0d) / ((double) (i2 * 1000)));
            CharSequence format4 = String.format(Locale.US, "Send Br: %d", new Object[]{Integer.valueOf(eVar.sxr)});
            CharSequence format5 = String.format(Locale.US, "Recv Br: %d", new Object[]{Integer.valueOf(eVar.sxs)});
            byte[] bArr = d.bGT().ssY.soQ.sqj.svm;
            if (bArr != null) {
                try {
                    eVar.sxi.setText(new String(bArr, "UTF-8"));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Voip.VoipVideoFragment", e, "", new Object[0]);
                }
            }
            eVar.sxd.setText(format);
            eVar.sxe.setText(format2);
            eVar.sxf.setText(format3);
            eVar.sxh.setText(format5);
            eVar.sxg.setText(format4);
            eVar.sxr = i3;
            eVar.sxs = i4;
            eVar.sxy = Wx;
        }
        eVar.sxp = 0;
        eVar.sxo = 0;
        eVar.sxq = 0;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.swi = (RelativeLayout) layoutInflater.inflate(R.i.dtX, viewGroup, false);
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            ((RelativeLayout) this.swi.findViewById(R.h.cIo)).setPadding(0, 0, 0, b.b(getActivity(), 40.0f));
        }
        this.swj = (ImageView) this.swi.findViewById(R.h.cXq);
        this.swk = (ImageView) this.swi.findViewById(R.h.cXV);
        this.swS = (RelativeLayout) this.swi.findViewById(R.h.ctp);
        this.swF = (OpenGlView) this.swi.findViewById(R.h.bMZ);
        this.swF.dW(mScreenWidth, mScreenHeight);
        this.sxc = (VoipBigIconButton) this.swi.findViewById(R.h.cXR);
        this.sxc.setOnClickListener(this.sxM);
        this.sxb = (VoipBigIconButton) this.swi.findViewById(R.h.cYe);
        this.sxb.setOnClickListener(this.sxC);
        this.swX = (VoipBigIconButton) this.swi.findViewById(R.h.cXr);
        this.swX.setOnClickListener(this.sxH);
        this.sxa = (VoipBigIconButton) this.swi.findViewById(R.h.cXG);
        this.sxa.setOnClickListener(this.sxB);
        this.swZ = (VoipBigIconButton) this.swi.findViewById(R.h.cXo);
        this.swZ.setOnClickListener(this.sxF);
        this.swW = (VoipSmallIconButton) this.swi.findViewById(R.h.cXp);
        this.swW.setOnClickListener(this.sxE);
        this.swY = (VoipBigIconButton) this.swi.findViewById(R.h.cXO);
        this.swY.setOnClickListener(this.sxG);
        this.swV = (VoipSmallIconButton) this.swi.findViewById(R.h.cXS);
        this.swV.setOnClickListener(this.sxD);
        this.sxx = com.tencent.mm.plugin.voip.b.d.oC("VOIPBlockIgnoreButton") == 0;
        this.swU = (VoipSmallIconButton) this.swi.findViewById(R.h.cXH);
        this.swU.setOnClickListener(this.sxJ);
        if (!this.sxx) {
            this.swU.setVisibility(8);
        }
        this.swP = (TextView) this.swi.findViewById(R.h.cYf);
        this.swJ = this.swi.findViewById(R.h.cYb);
        this.swK = (ImageView) this.swi.findViewById(R.h.cYa);
        com.tencent.mm.pluginsdk.ui.a.b.a(this.swK, this.gBJ, 0.05882353f, true);
        this.swL = (TextView) this.swi.findViewById(R.h.cYc);
        this.swM = (TextView) this.swi.findViewById(R.h.cXX);
        this.swN = (TextView) this.swi.findViewById(R.h.cXZ);
        this.swO = this.swi.findViewById(R.h.cXY);
        b(this.swN, getResources().getString(R.l.eWd));
        this.swQ = (TextView) this.swi.findViewById(R.h.cXW);
        this.swR = (TextView) this.swi.findViewById(R.h.cYd);
        this.swT = (Button) this.swi.findViewById(R.h.bPg);
        this.nTz = (TextView) this.swi.findViewById(R.h.cXK);
        if (r.igy) {
            this.sxd = (TextView) this.swi.findViewById(R.h.cXs);
            this.sxe = (TextView) this.swi.findViewById(R.h.cXP);
            this.sxf = (TextView) this.swi.findViewById(R.h.cXM);
            this.sxg = (TextView) this.swi.findViewById(R.h.cXQ);
            this.sxh = (TextView) this.swi.findViewById(R.h.cXN);
            this.sxi = (TextView) this.swi.findViewById(R.h.ceB);
        }
        this.sxl = (Button) this.swi.findViewById(R.h.cXE);
        this.sxm = (Button) this.swi.findViewById(R.h.cXF);
        this.sxl.setVisibility(8);
        this.sxm.setVisibility(8);
        this.sxl.setOnClickListener(this.sxK);
        this.sxm.setOnClickListener(this.sxL);
        this.sxk = new com.tencent.mm.plugin.voip.video.e(getActivity());
        this.swi.addView(this.sxk);
        this.sxk.setVisibility(8);
        this.swT.setOnClickListener(this.sxI);
        c(this.srU);
        int fL = u.fL(getActivity());
        x.d("MicroMsg.Voip.VoipVideoFragment", "statusHeight: " + fL);
        d.F(this.swT, fL);
        d.F(this.swi.findViewById(R.h.cXU), fL);
        d.F(this.swJ, fL);
        this.sxp = 0;
        this.sxo = 0;
        this.sxq = 0;
        this.sxr = 0;
        this.sxs = 0;
        WindowManager windowManager = (WindowManager) getActivity().getSystemService("window");
        int height = windowManager.getDefaultDisplay().getHeight() / 5;
        int width = (windowManager.getDefaultDisplay().getWidth() * height) / windowManager.getDefaultDisplay().getHeight();
        this.swG = new MovableVideoView(getActivity().getApplicationContext());
        ((MovableVideoView) this.swG).dV(width, height);
        this.swG.setVisibility(8);
        this.swH = new OpenGlRender(this.swG, OpenGlRender.sAr);
        this.swG.a(this.swH);
        this.swG.setRenderMode(0);
        this.swI = new OpenGlRender(this.swF, OpenGlRender.sAq);
        this.swF.a(this.swI);
        this.swF.setRenderMode(0);
        if (Build.MODEL.equals("Nexus 6")) {
            this.swG.setZOrderOnTop(true);
        } else {
            this.swG.setZOrderMediaOverlay(true);
        }
        this.swi.addView(this.swG);
        this.swG.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                boolean z;
                e eVar = e.this;
                if (e.this.sxu) {
                    z = false;
                } else {
                    z = true;
                }
                eVar.sxu = z;
                eVar = e.this;
                if (e.this.sxu) {
                    z = false;
                } else {
                    z = true;
                }
                Point c = eVar.jr(z);
                e.this.swG.dX(c.x, c.y);
                g.pWK.h(11079, Integer.valueOf(3));
            }
        });
        this.swL.setText(i.b(getActivity(), com.tencent.mm.y.r.gw(this.gBJ), this.swL.getTextSize()));
        if (this.srZ) {
            this.jQE.postDelayed(new Runnable() {
                public final void run() {
                    e.this.swM.setText(R.l.eVK);
                    e.this.swn.a(e.this.swN, d.swh);
                }
            }, 2000);
        }
        this.sxj = (VoIPVideoView) this.swi.findViewById(R.h.cXT);
        this.bnp = new Timer("VoIP_video_talking_count");
        this.sxw = true;
        dU(0, this.mStatus);
        return this.swi;
    }

    public final void onDestroy() {
        this.sxv = false;
        super.onDestroy();
    }

    private void bIR() {
        x.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
        this.sxt++;
        this.jQE.postDelayed(this.sxN, 10000);
    }

    public final void dU(int i, int i2) {
        super.dU(i, i2);
        x.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + com.tencent.mm.plugin.voip.b.b.zg(i2));
        if (this.swi == null) {
            x.i("MicroMsg.Voip.VoipVideoFragment", "fragment no create, return first, onCreateView will call it again");
            return;
        }
        switch (i2) {
            case 0:
            case 2:
                this.swO.setVisibility(0);
                this.swS.setVisibility(0);
                this.swF.setVisibility(0);
                this.swM.setText(R.l.eVK);
                this.swj.setVisibility(8);
                this.swQ.setVisibility(8);
                this.swR.setVisibility(8);
                if (d.bGT().ssw != null) {
                    this.swR.setVisibility(0);
                    this.swR.setText(d.bGT().ssw);
                }
                this.swn.a(this.swN, swh);
                this.sxc.setVisibility(8);
                this.sxb.setVisibility(8);
                this.swX.setVisibility(0);
                this.sxa.setVisibility(8);
                this.swZ.setVisibility(8);
                this.swW.setVisibility(8);
                this.swY.setVisibility(8);
                this.swV.setVisibility(0);
                this.swU.setVisibility(8);
                return;
            case 4:
            case 258:
                this.swM.setText(R.l.eWr);
                this.swn.a(this.swN, swh);
                return;
            case 6:
            case GameJsApiLaunchApplication.CTRL_BYTE /*260*/:
                this.swi.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        int i;
                        boolean z = false;
                        g.pWK.h(11079, Integer.valueOf(4));
                        if (!(e.this.sxu || e.this.svT.get() == null)) {
                            e.this.sxc.getVisibility();
                        }
                        if (e.this.sxc.getVisibility() == 0) {
                            i = 4;
                        } else {
                            boolean i2 = false;
                        }
                        int i3 = i2 == 0 ? 0 : 8;
                        e.this.sxc.setVisibility(i3);
                        e.this.swT.setVisibility(i3);
                        e.this.swP.setVisibility(i3);
                        e.this.sxa.setVisibility(i3);
                        e.this.sxb.setVisibility(i3);
                        e eVar = e.this;
                        if (i3 == 0) {
                            z = true;
                        }
                        e.d(eVar, z);
                        if (r.igy) {
                            e.this.sxd.setVisibility(i3);
                            e.this.sxe.setVisibility(i3);
                            e.this.sxf.setVisibility(i3);
                            e.this.sxg.setVisibility(i3);
                            e.this.sxh.setVisibility(i3);
                            e.this.sxi.setVisibility(i3);
                        }
                        if (i2 == 0) {
                            e.this.bIR();
                        }
                    }
                });
                if (this.swk != null) {
                    this.swk.setVisibility(8);
                }
                if (this.swG.getVisibility() != 0) {
                    if (this.srZ) {
                        this.sxu = !this.sxu;
                        Point jr = jr(!this.sxu);
                        this.swG.dX(jr.x, jr.y);
                    } else {
                        this.sxu = !this.sxu;
                        this.sxj.setVisibility(8);
                    }
                    if (r.igy) {
                        this.sxd.setVisibility(0);
                        this.sxe.setVisibility(0);
                        this.sxf.setVisibility(0);
                        this.sxg.setVisibility(0);
                        this.sxh.setVisibility(0);
                        this.sxi.setVisibility(0);
                    }
                    this.swJ.setVisibility(8);
                    this.swF.setVisibility(0);
                    this.swG.setVisibility(0);
                    this.swP.setVisibility(0);
                    this.swT.setVisibility(0);
                    this.swS.setVisibility(0);
                    this.sxc.setVisibility(0);
                    this.sxb.setVisibility(0);
                    this.swX.setVisibility(8);
                    this.sxa.setVisibility(0);
                    this.swZ.setVisibility(8);
                    this.swW.setVisibility(8);
                    this.swY.setVisibility(8);
                    this.swV.setVisibility(8);
                    this.swU.setVisibility(8);
                    Point jr2 = jr(!this.sxu);
                    ((MovableVideoView) this.swG).dV(jr2.x, jr2.y);
                    if (!(this.bnp == null || this.sxv)) {
                        if (-1 == this.svV) {
                            this.svV = bi.Wx();
                        }
                        this.sxy = this.svV;
                        this.sxv = true;
                        this.bnp.schedule(new TimerTask() {
                            public final void run() {
                                e.this.jQE.post(new Runnable() {
                                    public final void run() {
                                        e.this.swP.setText(d.bq(bi.bz(e.this.svV)));
                                        e.t(e.this);
                                    }
                                });
                            }
                        }, 1000, 1000);
                    }
                    if (ad.cgg().getBoolean("voipfaceDebug", false)) {
                        this.sxl.setVisibility(0);
                        this.sxm.setVisibility(0);
                    }
                    bIR();
                    return;
                }
                return;
            case 8:
            case 262:
                this.swn.bIQ();
                this.swX.setEnabled(false);
                this.sxb.setEnabled(false);
                this.sxa.setEnabled(false);
                this.swZ.setEnabled(false);
                this.swY.setEnabled(false);
                this.swW.setEnabled(false);
                this.sxc.setEnabled(false);
                this.swV.setEnabled(false);
                this.swU.setEnabled(false);
                switch (i) {
                    case 4105:
                        this.swQ.setVisibility(0);
                        this.swQ.setText(R.l.eVR);
                        break;
                }
                if (this.swm != null) {
                    this.swm.D(true, false);
                    return;
                }
                return;
            case 256:
                this.swF.setVisibility(0);
                this.swS.setVisibility(0);
                if (this.swk != null) {
                    bIP();
                }
                this.swJ.setVisibility(0);
                this.swL.setVisibility(0);
                this.swM.setText(R.l.eVM);
                this.swO.setVisibility(0);
                this.swK.setVisibility(0);
                this.swn.a(this.swN, swh);
                this.sxc.setVisibility(8);
                this.sxb.setVisibility(8);
                this.swX.setVisibility(8);
                this.sxa.setVisibility(8);
                this.swZ.setVisibility(0);
                this.swW.setVisibility(0);
                this.swY.setVisibility(0);
                this.swV.setVisibility(8);
                if (this.sxx) {
                    this.swU.setVisibility(0);
                }
                this.swR.setVisibility(8);
                if (d.bGT().ssw != null) {
                    this.swR.setVisibility(0);
                    this.swR.setText(d.bGT().ssw);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void b(CaptureView captureView) {
        this.srU = captureView;
        c(this.srU);
    }

    public final void uninit() {
        this.swG.setVisibility(4);
        if (this.srU != null) {
            this.swi.removeView(this.srU);
            this.srU = null;
            x.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView removed");
        }
        if (this.sxA != null) {
            com.tencent.mm.sdk.f.e.remove(this.sxA);
            this.sxA = null;
        }
        super.uninit();
    }

    public final void setMute(boolean z) {
    }

    public final void onStop() {
        this.swI.bJo();
        this.swH.bJo();
        super.onStop();
    }

    public final void onStart() {
        this.swI.szX = true;
        this.swH.szX = true;
        super.onStart();
    }

    protected final void Ni(String str) {
        if (this.swR != null) {
            this.swR.setVisibility(0);
            this.swR.setText(str);
        }
    }

    protected final void cr(String str, int i) {
        if (this.swQ != null) {
            this.swQ.setText(bi.oM(str));
            this.swQ.setVisibility(0);
            this.swQ.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.swQ.setBackgroundResource(R.g.bHN);
            this.swQ.setCompoundDrawables(null, null, null, null);
            this.swQ.setCompoundDrawablePadding(0);
            this.jQE.removeCallbacks(this.sxO);
            if (-1 != i) {
                this.jQE.postDelayed(this.sxO, (long) i);
            }
        }
    }

    protected final void bIM() {
        if (this.nTz != null) {
            this.nTz.clearAnimation();
            this.nTz.setVisibility(0);
        }
    }

    protected final void bIN() {
        if (this.nTz != null) {
            this.nTz.clearAnimation();
            this.nTz.setVisibility(8);
        }
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.sxw) {
            if (OpenGlRender.sAB == 1) {
                if (this.sxP < i * i2) {
                    this.oME = null;
                }
                if (this.oME == null) {
                    this.sxP = i * i2;
                    this.oME = new int[this.sxP];
                }
                if (d.bGT().a(bArr, (int) j, i3 & 31, i, i2, this.oME, true) >= 0 && this.oME != null) {
                    if (this.sxu) {
                        this.swH.a(this.oME, i, i2, (OpenGlRender.sAi + i4) + i5);
                    } else {
                        this.swI.a(this.oME, i, i2, (OpenGlRender.sAi + i4) + i5);
                    }
                } else {
                    return;
                }
            } else if (OpenGlRender.sAB == 2) {
                if (this.sxu) {
                    this.swH.c(bArr, i, i2, (OpenGlRender.sAm + i4) + i5);
                } else {
                    this.swI.c(bArr, i, i2, (OpenGlRender.sAm + i4) + i5);
                }
            }
            this.sxp++;
            if (i6 > 0) {
                this.sxo++;
            }
            com.tencent.mm.plugin.voip.video.e eVar = this.sxk;
            eVar.szz = i;
            eVar.szA = i2;
            eVar = this.sxk;
            int width = this.swi.getWidth();
            int height = this.swi.getHeight();
            eVar.szy = width;
            eVar.fp = height;
        }
    }

    public final void b(int i, int i2, int[] iArr) {
        if (this.sxw) {
            this.sxq++;
            if (OpenGlRender.sAB == 1) {
                if (this.sxu) {
                    this.swI.a(iArr, i, i2, OpenGlRender.sAi + OpenGlRender.sAn);
                } else {
                    this.swH.a(iArr, i, i2, OpenGlRender.sAi + OpenGlRender.sAn);
                }
            } else if (this.sxu) {
                this.swI.a(iArr, i, i2, OpenGlRender.sAk + OpenGlRender.sAn);
            } else {
                this.swH.a(iArr, i, i2, OpenGlRender.sAk + OpenGlRender.sAn);
            }
        }
    }

    public final void bHJ() {
        if (this.sxw) {
            this.swI.bJp();
            this.swH.bJp();
        }
    }

    private void c(CaptureView captureView) {
        if (this.swi != null && captureView != null) {
            this.swi.removeView(this.srU);
            this.srU = null;
            this.srU = captureView;
            this.swi.addView(captureView, new LayoutParams(1, 1));
            this.srU.setVisibility(0);
            x.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView added");
        }
    }

    public final void onDetach() {
        x.i("MicroMsg.Voip.VoipVideoFragment", "onDetach");
        if (this.bnp != null) {
            this.bnp.cancel();
            this.bnp = null;
        }
        super.onDetach();
    }

    public final void zc(int i) {
    }

    private Point jr(boolean z) {
        int height = (int) (((double) getActivity().getWindowManager().getDefaultDisplay().getHeight()) / 5.0d);
        float f = (float) height;
        d.bGT();
        return new Point((int) (f * m.jp(z)), height);
    }
}
