package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.d.b.b;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Timer;
import java.util.TimerTask;

public final class c implements b {
    private static String TAG = "MicroMsg.NormalFaceMotion";
    private static long mni = 500;
    private boolean mnj = false;
    private boolean mnk = false;
    private View mnl = null;
    private View mnm = null;
    private String mnn;
    private long mno;
    private final Object mnp = new Object();
    private Timer mnq = null;
    private volatile boolean mnr = false;
    private Animation mns;
    private volatile boolean mnt = false;
    private volatile boolean mnu = false;

    public c(String str, long j) {
        this.mnn = str;
        this.mno = j;
        this.mns = AnimationUtils.loadAnimation(ad.getContext(), a.bqB);
    }

    public final boolean aHB() {
        return this.mnj && this.mnk;
    }

    public final TextView aHG() {
        if (!this.mnj && this.mnl != null) {
            return (TextView) this.mnl.findViewById(e.mjg);
        }
        if (!this.mnj || this.mnm == null) {
            return null;
        }
        return (TextView) this.mnm.findViewById(e.mjg);
    }

    public final void a(Context context, ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.mnl = LayoutInflater.from(context).inflate(g.mjp, viewGroup);
        this.mnm = LayoutInflater.from(context).inflate(g.mjq, viewGroup2);
        this.mnm.setVisibility(4);
        if (aHG() != null) {
            aHG().setText(this.mnn);
        }
        x.i(TAG, "hy: starting tween timer: tween: %d", Long.valueOf(this.mno));
        if (this.mnq != null) {
            this.mnq.cancel();
        }
        this.mnq = new Timer("FaceDetect_hint", true);
        this.mnr = true;
        this.mnq.scheduleAtFixedRate(new TimerTask() {
            public final void run() {
                synchronized (c.this.mnp) {
                    if (!c.this.mnr) {
                        x.w(c.TAG, "hy: already stopped");
                        cancel();
                    }
                    ah.y(new Runnable() {
                        public final void run() {
                            if (c.this.aHG() != null) {
                                c.this.aHG().startAnimation(c.this.mns);
                            }
                        }
                    });
                }
            }
        }, 0, r4);
    }

    public final boolean aHC() {
        return false;
    }

    public final boolean a(FaceCharacteristicsResult faceCharacteristicsResult) {
        if (!this.mnj || faceCharacteristicsResult == null || faceCharacteristicsResult.errCode != 18) {
            return false;
        }
        x.d(TAG, "hy: ignore too active");
        return true;
    }

    public final boolean b(FaceCharacteristicsResult faceCharacteristicsResult) {
        if (faceCharacteristicsResult.errCode == -1) {
            this.mnj = true;
            if (!this.mnt) {
                as.H(ad.getContext(), h.eBF);
                TextView textView = (TextView) this.mnl.findViewById(e.mjg);
                Animation loadAnimation = AnimationUtils.loadAnimation(ad.getContext(), a.bpY);
                Animation loadAnimation2 = AnimationUtils.loadAnimation(ad.getContext(), a.bpZ);
                loadAnimation.setDuration(mni);
                loadAnimation2.setDuration(mni);
                textView.startAnimation(loadAnimation);
                textView.setVisibility(4);
                this.mnm.setVisibility(0);
                this.mnm.startAnimation(loadAnimation2);
                this.mnm.findViewById(e.miM).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        c.this.mnk = true;
                    }
                });
                this.mnt = true;
                return true;
            }
        }
        return false;
    }

    public final void aHD() {
        this.mnr = false;
        if (this.mnq != null) {
            this.mnq.cancel();
        }
        this.mnj = false;
        this.mnt = false;
        this.mnu = false;
        this.mnk = false;
    }

    public final b aHE() {
        if (this.mnj) {
            return new b(90025, "user cancelled in intermediate page");
        }
        return new b(90004, "user cancelled in processing");
    }

    public final b.a aHF() {
        if (!this.mnj || this.mnu) {
            return null;
        }
        this.mnu = true;
        return new b.a();
    }
}
