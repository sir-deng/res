package com.tencent.mm.plugin.voip.ui;

import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.r;
import java.util.Timer;
import java.util.TimerTask;

public final class f extends d {
    private Timer bnp;
    private boolean mIsMute = false;
    private TextView nTz;
    private int sse = 1;
    private Button swT;
    private OnClickListener sxI = new OnClickListener() {
        public final void onClick(View view) {
            g.pWK.h(11618, Integer.valueOf(3), Integer.valueOf(1));
            if (!(f.this.svT == null || f.this.svT.get() == null)) {
                ((c) f.this.svT.get()).jm(true);
            }
            if (f.this.swm != null) {
                f.this.swm.D(false, true);
            }
        }
    };
    private OnClickListener sxJ = new OnClickListener() {
        public final void onClick(View view) {
            g.pWK.h(11619, Integer.valueOf(3));
            if (f.this.svT != null && f.this.svT.get() != null) {
                ((c) f.this.svT.get()).bHO();
            }
        }
    };
    private Runnable sxO = new Runnable() {
        public final void run() {
            if (f.this.getActivity() != null && !f.this.getActivity().isFinishing()) {
                f.this.syi.setVisibility(8);
            }
        }
    };
    private View sxV;
    private ImageView sxW;
    private TextView sxX;
    private TextView sxY;
    private TextView sxZ;
    private boolean sxv = false;
    private boolean sxx = false;
    private TextView sya;
    private View syb;
    private RelativeLayout syc;
    private MMCheckBox syd;
    private TextView sye;
    private RelativeLayout syf;
    private MMCheckBox syg;
    private TextView syh;
    private TextView syi;
    private TextView syj;
    private VoipBigIconButton syk;
    private VoipBigIconButton syl;
    private VoipBigIconButton sym;
    private VoipBigIconButton syn;
    private VoipSmallIconButton syo;
    private OnClickListener syp = new OnClickListener() {
        public final void onClick(View view) {
            boolean isChecked = f.this.syd.isChecked();
            x.i("MicroMsg.VoipVoiceFragment", "onSpeakerClick, status: %b", Boolean.valueOf(isChecked));
            f.this.syd.setEnabled(false);
            if (!(f.this.svT == null || f.this.svT.get() == null)) {
                ((c) f.this.svT.get()).jl(isChecked);
            }
            f.this.sse = isChecked ? 1 : 2;
            f.this.syd.setEnabled(true);
        }
    };
    private OnClickListener syq = new OnClickListener() {
        public final void onClick(View view) {
            boolean isChecked = f.this.syg.isChecked();
            x.i("MicroMsg.VoipVoiceFragment", "onMicClick, status: %b", Boolean.valueOf(isChecked));
            f.this.syg.setEnabled(false);
            if (!(f.this.svT == null || f.this.svT.get() == null)) {
                ((c) f.this.svT.get()).gQ(isChecked);
            }
            f.this.mIsMute = isChecked;
            f.this.syg.setEnabled(true);
        }
    };
    private OnClickListener syr = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.VoipVoiceFragment", "click accept voice invite button");
            g.pWK.a(11526, true, true, Integer.valueOf(d.bGT().bHZ()), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(2));
            if (f.this.svT != null && f.this.svT.get() != null && ((c) f.this.svT.get()).bHy()) {
                f.this.syk.setEnabled(false);
                f.this.sxZ.setText(R.l.eWr);
                f.this.swn.a(f.this.sya, d.swh);
                f.this.syb.setVisibility(0);
                f.this.sxY.setVisibility(8);
                f.this.syk.setVisibility(8);
                f.this.syl.setVisibility(8);
                f.this.sym.setVisibility(0);
            }
        }
    };
    private OnClickListener sys = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.VoipVoiceFragment", "click reject voice invite button");
            g.pWK.a(11526, true, true, Integer.valueOf(d.bGT().bHZ()), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(5));
            if (f.this.svT != null && f.this.svT.get() != null && ((c) f.this.svT.get()).bHx()) {
                f.this.syl.setEnabled(false);
                f.this.syk.setEnabled(false);
                f.this.cr(f.this.getString(R.l.eVX), -1);
                if (f.this.swm != null) {
                    f.this.swm.D(true, false);
                }
            }
        }
    };
    private OnClickListener syt = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.VoipVoiceFragment", "click hangup voice talking button");
            if (f.this.svT != null && f.this.svT.get() != null && ((c) f.this.svT.get()).bHt()) {
                f.this.cr(f.this.getString(R.l.eVy), -1);
            }
        }
    };
    private OnClickListener syu = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.VoipVoiceFragment", "click cancel voice invite button");
            if (f.this.svT != null && f.this.svT.get() != null && ((c) f.this.svT.get()).bHA()) {
                f.this.cr(f.this.getString(R.l.eUK), -1);
                f.this.syn.setEnabled(false);
            }
        }
    };

    public final void onDestroy() {
        this.sxv = false;
        super.onDestroy();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) layoutInflater.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        x.i("MicroMsg.VoipVoiceFragment", "dpi: " + (((float) displayMetrics.heightPixels) / displayMetrics.density));
        if (((float) displayMetrics.heightPixels) / displayMetrics.density <= 540.0f) {
            this.swi = (RelativeLayout) layoutInflater.inflate(R.i.dtZ, viewGroup, false);
        } else {
            this.swi = (RelativeLayout) layoutInflater.inflate(R.i.dtY, viewGroup, false);
            if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
                ((RelativeLayout) this.swi.findViewById(R.h.cIq)).setPadding(0, 0, 0, b.b(getActivity(), 40.0f));
            }
        }
        this.swj = (ImageView) this.swi.findViewById(R.h.cXq);
        this.sxV = this.swi.findViewById(R.h.cYh);
        this.sxW = (ImageView) this.swi.findViewById(R.h.cYt);
        a.b.a(this.sxW, this.gBJ, 0.0375f, true);
        this.sxX = (TextView) this.swi.findViewById(R.h.cYu);
        this.sxX.setText(i.b(getActivity(), r.gw(this.gBJ), this.sxX.getTextSize()));
        this.sxY = (TextView) this.swi.findViewById(R.h.cYz);
        this.sxZ = (TextView) this.swi.findViewById(R.h.cYl);
        this.sya = (TextView) this.swi.findViewById(R.h.cYn);
        this.syb = this.swi.findViewById(R.h.cYm);
        this.syi = (TextView) this.swi.findViewById(R.h.cYi);
        this.syj = (TextView) this.swi.findViewById(R.h.cYv);
        this.nTz = (TextView) this.swi.findViewById(R.h.cXK);
        b(this.sya, getResources().getString(R.l.eWd));
        this.syf = (RelativeLayout) this.swi.findViewById(R.h.cYp);
        this.syg = (MMCheckBox) this.swi.findViewById(R.h.cYo);
        this.syg.setChecked(this.mIsMute);
        this.syh = (TextView) this.swi.findViewById(R.h.cYq);
        this.syh.setText(R.l.eVN);
        this.syc = (RelativeLayout) this.swi.findViewById(R.h.cYx);
        this.syd = (MMCheckBox) this.swi.findViewById(R.h.cYw);
        this.sye = (TextView) this.swi.findViewById(R.h.cYy);
        this.sye.setText(R.l.eWb);
        bIS();
        this.syk = (VoipBigIconButton) this.swi.findViewById(R.h.cYg);
        this.syk.setOnClickListener(this.syr);
        this.syl = (VoipBigIconButton) this.swi.findViewById(R.h.cYs);
        this.syl.setOnClickListener(this.sys);
        this.sym = (VoipBigIconButton) this.swi.findViewById(R.h.cYk);
        this.sym.setOnClickListener(this.syt);
        this.syn = (VoipBigIconButton) this.swi.findViewById(R.h.cYj);
        this.syn.setOnClickListener(this.syu);
        this.sxx = com.tencent.mm.plugin.voip.b.d.oC("VOIPBlockIgnoreButton") == 0;
        this.syo = (VoipSmallIconButton) this.swi.findViewById(R.h.cXI);
        this.syo.setOnClickListener(this.sxJ);
        if (!this.sxx) {
            this.syo.setVisibility(8);
        }
        this.syd.setOnClickListener(this.syp);
        this.syg.setOnClickListener(this.syq);
        this.swT = (Button) this.swi.findViewById(R.h.bPg);
        this.swT.setOnClickListener(this.sxI);
        int fL = u.fL(getActivity());
        x.d("MicroMsg.VoipVoiceFragment", "statusHeight: " + fL);
        d.F(this.swT, fL);
        if (this.srZ && 2 == this.sse) {
            cr(getString(R.l.eUs), 10000);
        }
        this.bnp = new Timer();
        dU(this.swl, this.mStatus);
        return this.swi;
    }

    public final void dU(int i, int i2) {
        super.dU(i, i2);
        x.i("MicroMsg.VoipVoiceFragment", "newState: " + com.tencent.mm.plugin.voip.b.b.zg(i2));
        if (this.swi == null) {
            x.i("MicroMsg.VoipVoiceFragment", "fragment no create, return first, onCreateView will call it again");
            return;
        }
        switch (i2) {
            case 1:
                this.sxV.setVisibility(0);
                this.sxY.setVisibility(8);
                this.sxZ.setText(R.l.eVV);
                this.swn.a(this.sya, swh);
                this.syb.setVisibility(0);
                this.syk.setVisibility(8);
                this.syl.setVisibility(8);
                this.sym.setVisibility(8);
                this.syn.setVisibility(0);
                this.syo.setVisibility(8);
                this.syf.setVisibility(0);
                this.syg.setEnabled(false);
                this.syg.setBackgroundResource(R.g.bHQ);
                this.syh.setTextColor(1728053247);
                this.syj.setVisibility(8);
                if (d.bGT().ssw != null) {
                    this.syj.setVisibility(0);
                    this.syj.setText(d.bGT().ssw);
                }
                bIS();
                this.syg.setChecked(this.mIsMute);
                this.syc.setVisibility(0);
                if (2 == this.sse) {
                    cr(getString(R.l.eUs), 10000);
                }
                bIO();
                return;
            case 3:
                this.sxV.setVisibility(0);
                this.sxY.setVisibility(8);
                this.sxZ.setText(R.l.eVK);
                this.swn.a(this.sya, swh);
                this.syb.setVisibility(0);
                this.syk.setVisibility(8);
                this.syl.setVisibility(8);
                this.sym.setVisibility(8);
                this.syn.setVisibility(0);
                this.syo.setVisibility(8);
                this.syf.setVisibility(0);
                this.syg.setEnabled(false);
                this.syg.setBackgroundResource(R.g.bHQ);
                this.syh.setTextColor(1728053247);
                bIS();
                this.syg.setChecked(this.mIsMute);
                this.syc.setVisibility(0);
                if (i != 4097 && 2 == this.sse) {
                    cr(getString(R.l.eUs), 10000);
                }
                bIO();
                this.syj.setVisibility(8);
                if (d.bGT().ssw != null) {
                    this.syj.setVisibility(0);
                    this.syj.setText(d.bGT().ssw);
                    return;
                }
                return;
            case 5:
                this.sxZ.setText(R.l.eWr);
                this.swn.a(this.sya, swh);
                this.syk.setVisibility(8);
                this.syl.setVisibility(8);
                this.sym.setVisibility(0);
                this.syn.setVisibility(8);
                this.syo.setVisibility(8);
                return;
            case 7:
            case 261:
                this.syn.setVisibility(8);
                this.syk.setVisibility(8);
                this.syl.setVisibility(8);
                this.syo.setVisibility(8);
                this.syb.setVisibility(8);
                this.swn.bIQ();
                this.sym.setVisibility(0);
                this.sxY.setVisibility(0);
                this.syf.setVisibility(0);
                this.syc.setVisibility(0);
                this.sxV.setVisibility(0);
                this.swT.setVisibility(0);
                this.syg.setEnabled(true);
                this.syg.setBackgroundResource(R.g.bHL);
                this.syh.setTextColor(-1);
                bIS();
                this.syg.setChecked(this.mIsMute);
                if (2 == this.sse) {
                    cr(getString(R.l.eUs), 10000);
                }
                bIO();
                if (!(this.bnp == null || this.sxv)) {
                    if (-1 == this.svV) {
                        this.svV = bi.Wx();
                    }
                    this.sxv = true;
                    this.bnp.schedule(new TimerTask() {
                        public final void run() {
                            f.this.jQE.post(new Runnable() {
                                public final void run() {
                                    f.this.sxY.setText(d.bq(bi.bz(f.this.svV)));
                                }
                            });
                        }
                    }, 50, 1000);
                }
                this.syj.setVisibility(8);
                if (d.bGT().ssw != null) {
                    this.syj.setVisibility(0);
                    this.syj.setText(d.bGT().ssw);
                    return;
                }
                return;
            case 8:
            case 262:
                this.swn.bIQ();
                this.sym.setEnabled(false);
                this.syn.setEnabled(false);
                this.syk.setEnabled(false);
                this.syl.setEnabled(false);
                this.syo.setEnabled(false);
                return;
            case 257:
                this.sxV.setVisibility(0);
                this.syb.setVisibility(0);
                this.sxZ.setText(R.l.eVL);
                this.swn.a(this.sya, swh);
                bIS();
                this.syk.setVisibility(0);
                this.syl.setVisibility(0);
                this.sym.setVisibility(8);
                this.syn.setVisibility(8);
                if (this.sxx) {
                    this.syo.setVisibility(0);
                }
                cr(getString(R.l.eUt), 10000);
                bIO();
                this.syj.setVisibility(8);
                if (d.bGT().ssw != null) {
                    this.syj.setVisibility(0);
                    this.syj.setText(d.bGT().ssw);
                    return;
                }
                return;
            case 259:
                this.sxV.setVisibility(0);
                this.syb.setVisibility(0);
                this.sxZ.setText(R.l.eWr);
                this.swn.a(this.sya, swh);
                this.syk.setVisibility(8);
                this.syl.setVisibility(8);
                this.sym.setVisibility(0);
                this.syn.setVisibility(8);
                this.syo.setVisibility(8);
                cr(getString(R.l.eUt), 10000);
                bIO();
                return;
            default:
                return;
        }
    }

    public final void b(CaptureView captureView) {
    }

    public final void uninit() {
        if (this.bnp != null) {
            this.bnp.cancel();
            this.bnp = null;
        }
        super.uninit();
    }

    protected final void Ni(String str) {
        if (this.syj != null) {
            this.syj.setVisibility(0);
            this.syj.setText(str);
        }
    }

    protected final void cr(String str, int i) {
        if (this.syi != null) {
            this.syi.setText(bi.oM(str));
            this.syi.setVisibility(0);
            this.syi.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.syi.setBackgroundResource(R.g.bHN);
            this.syi.setCompoundDrawables(null, null, null, null);
            this.syi.setCompoundDrawablePadding(0);
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

    public final void setMute(boolean z) {
        this.mIsMute = z;
        if (this.syg != null && this.syh != null) {
            this.syg.setChecked(z);
        }
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
    }

    public final void b(int i, int i2, int[] iArr) {
    }

    public final void bHJ() {
    }

    public final void zc(int i) {
        this.sse = i;
        bIS();
    }

    private void bIS() {
        boolean z = false;
        if (this.syd == null || this.sye == null) {
            x.e("MicroMsg.VoipVoiceFragment", "speaker is null");
        } else if (4 == this.sse || 3 == this.sse) {
            this.syd.setEnabled(false);
            this.sye.setTextColor(1728053247);
            this.syd.setBackgroundResource(R.g.bHK);
        } else {
            if (this.sse == 1) {
                z = true;
            }
            this.syd.setBackgroundResource(R.g.bHM);
            this.syd.setEnabled(true);
            this.sye.setTextColor(-1);
            this.syd.setChecked(z);
        }
    }
}
