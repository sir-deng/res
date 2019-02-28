package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.File;

public class OfflineVideoView extends RelativeLayout implements com.tencent.mm.pluginsdk.ui.tools.f.a {
    private int aBO;
    private int duration;
    private ag kXJ;
    private boolean kYN;
    public f kYP;
    private al kYV;
    private ImageView mBj;
    private boolean mBl;
    private boolean mBm;
    private ProgressBar mBp;
    private Context mContext;
    private RelativeLayout mDg;
    public a rAM;
    private boolean rAN;
    private boolean rAO;
    private int rAP;
    private e rAQ;

    public interface a {
        boolean a(PString pString);

        void onStart(int i);

        void vi();

        void xr(int i);
    }

    public OfflineVideoView(Context context) {
        this(context, null);
    }

    public OfflineVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OfflineVideoView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        super(context, attributeSet, i);
        this.mContext = null;
        this.kYN = false;
        this.mBl = false;
        this.rAN = false;
        this.rAO = true;
        this.rAP = -1;
        this.aBO = 0;
        this.duration = 0;
        this.kXJ = new ag(Looper.getMainLooper());
        this.kYV = new al(new com.tencent.mm.sdk.platformtools.al.a() {
            public final boolean uG() {
                if (OfflineVideoView.this.kYP == null) {
                    return false;
                }
                if (((View) OfflineVideoView.this.kYP).getAlpha() < 1.0f) {
                    OfflineVideoView.this.a(true, 1.0f);
                }
                if (OfflineVideoView.this.kYP.isPlaying()) {
                    OfflineVideoView.this.aVF();
                    OfflineVideoView offlineVideoView = OfflineVideoView.this;
                    int currentPosition = OfflineVideoView.this.kYP.getCurrentPosition() / 1000;
                    if (offlineVideoView.rAM != null) {
                        offlineVideoView.rAM.xr(currentPosition);
                    }
                }
                return true;
            }
        }, true);
        this.rAQ = new e() {
            public final void bcn() {
                x.i("MicroMsg.OfflineVideoView", "%d on texture update.", Integer.valueOf(OfflineVideoView.this.hashCode()));
                try {
                    OfflineVideoView.this.a(true, 1.0f);
                } catch (Exception e) {
                    x.e("MicroMsg.OfflineVideoView", "texture view update. error " + e.toString());
                }
            }
        };
        this.mContext = context;
        x.i("MicroMsg.OfflineVideoView", "%d ui init view.", Integer.valueOf(hashCode()));
        LayoutInflater.from(this.mContext).inflate(g.qOo, this);
        this.mBj = (ImageView) findViewById(i.f.cVD);
        this.mDg = (RelativeLayout) findViewById(i.f.cVB);
        this.mBp = (ProgressBar) findViewById(i.f.cVi);
        if (d.fO(18)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.mBm = true;
            this.kYP = new VideoPlayerTextureView(this.mContext);
        } else {
            this.mBm = false;
            this.kYP = new VideoTextureView(this.mContext);
        }
        this.kYP.a((com.tencent.mm.pluginsdk.ui.tools.f.a) this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.mDg.addView((View) this.kYP, layoutParams);
        a(false, 0.0f);
    }

    public final void setMute(boolean z) {
        this.kYN = z;
        this.kYP.setMute(this.kYN);
    }

    private void onResume() {
        x.d("MicroMsg.OfflineVideoView", "%d on resume %s", Integer.valueOf(hashCode()), bi.chl());
        if (!this.mBl) {
            bAq();
        }
        this.rAN = true;
    }

    public final void onDestroy() {
        x.d("MicroMsg.OfflineVideoView", "%d on destroy %s", Integer.valueOf(hashCode()), bi.chl());
        x.i("MicroMsg.OfflineVideoView", "%d logic unInit", Integer.valueOf(hashCode()));
        this.kXJ.removeCallbacksAndMessages(null);
        this.kYV.TN();
        if (this.kYP != null) {
            this.kYP.stop();
        }
    }

    public final void bAq() {
        if (this.rAM != null) {
            PString pString = new PString();
            PString pString2 = new PString();
            if (this.rAM.a(pString)) {
                if (!bi.oN(pString2.value)) {
                    Mx(pString2.value);
                }
                if (!bi.oN(pString.value)) {
                    AZ(pString.value);
                    return;
                }
                return;
            }
            this.kXJ.post(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.OfflineVideoView", "%d show loading. downloadMode %d", Integer.valueOf(OfflineVideoView.this.hashCode()), Integer.valueOf(OfflineVideoView.this.hashCode()));
                    if (OfflineVideoView.this.mBp != null && OfflineVideoView.this.mBp.getVisibility() != 0) {
                        OfflineVideoView.this.mBp.setVisibility(0);
                    }
                }
            });
            a(false, 0.0f);
            return;
        }
        x.w("MicroMsg.OfflineVideoView", "%d toggle video but video callback is null", Integer.valueOf(hashCode()));
    }

    public final void Mx(final String str) {
        if (!bi.oN(str)) {
            this.kXJ.post(new Runnable() {
                public final void run() {
                    if (OfflineVideoView.this.mBj != null) {
                        x.i("MicroMsg.OfflineVideoView", "%d fresh thumb image", Integer.valueOf(hashCode()));
                        OfflineVideoView.this.mBj.setImageBitmap(b.b(str, 1.0f));
                    }
                }
            });
        }
    }

    public final void onError(int i, int i2) {
        x.e("MicroMsg.OfflineVideoView", "%d on play video error what %d extra %d isMMVideoPlayer %b errorCount %d", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.mBm), Integer.valueOf(this.aBO));
        this.aBO++;
        final String Uy = this.kYP.Uy();
        this.kYP.stop();
        this.mBl = true;
        a(false, 0.0f);
        if (this.aBO <= 3) {
            this.kXJ.postDelayed(new Runnable() {
                public final void run() {
                    OfflineVideoView.this.AZ(Uy);
                }
            }, 200);
        } else if (!bi.oN(Uy)) {
            x.w("MicroMsg.OfflineVideoView", "%d start third player to play", Integer.valueOf(hashCode()));
            this.kXJ.post(new Runnable() {
                public final void run() {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.fromFile(new File(Uy)), "video/*");
                    try {
                        OfflineVideoView.this.getContext().startActivity(intent);
                    } catch (Exception e) {
                        x.e("MicroMsg.OfflineVideoView", "startActivity fail, activity not found");
                        h.h(OfflineVideoView.this.getContext(), j.egf, j.egg);
                    }
                }
            });
        }
    }

    private void a(final boolean z, final float f) {
        this.kXJ.post(new Runnable() {
            public final void run() {
                x.i("MicroMsg.OfflineVideoView", "%d switch video model isVideoPlay %b %f", Integer.valueOf(OfflineVideoView.this.hashCode()), Boolean.valueOf(z), Float.valueOf(f));
                View view = (View) OfflineVideoView.this.kYP;
                if (z) {
                    view.setAlpha(f);
                    view.setVisibility(0);
                    OfflineVideoView.this.mDg.setVisibility(0);
                    OfflineVideoView.this.mDg.setAlpha(f);
                    if (((double) f) >= 1.0d) {
                        OfflineVideoView.this.mBj.setVisibility(8);
                        return;
                    }
                    return;
                }
                view.setVisibility(0);
                OfflineVideoView.this.mDg.setVisibility(0);
                OfflineVideoView.this.mDg.setAlpha(0.0f);
                OfflineVideoView.this.mBj.setVisibility(0);
            }
        });
    }

    public final void hY() {
        a(true, 0.0f);
        this.mBl = false;
        aVF();
        this.duration = this.kYP.getDuration() / 1000;
        x.i("MicroMsg.OfflineVideoView", "%d on prepared. shouldPlayWhenPrepared [%b] shouldSeekTimeWhenPrepared[%d]", Integer.valueOf(hashCode()), Boolean.valueOf(this.rAO), Integer.valueOf(this.rAP));
        if (this.rAO) {
            if (this.rAP <= 0) {
                this.kYP.start();
            } else {
                G(this.rAP, true);
            }
            alw();
            if (this.rAM != null) {
                this.rAM.onStart(this.duration);
            }
        } else {
            G(this.rAP > 0 ? this.rAP : 0, false);
        }
        this.rAP = -1;
    }

    private void aVF() {
        this.kXJ.post(new Runnable() {
            public final void run() {
                if (OfflineVideoView.this.mBp != null && OfflineVideoView.this.mBp.getVisibility() != 8) {
                    x.i("MicroMsg.OfflineVideoView", "%d hide loading.", Integer.valueOf(OfflineVideoView.this.hashCode()));
                    OfflineVideoView.this.mBp.setVisibility(8);
                }
            }
        });
    }

    public final void alw() {
        this.kYV.K(500, 500);
    }

    public final void vi() {
        x.i("MicroMsg.OfflineVideoView", "%d on completion", Integer.valueOf(hashCode()));
        if (this.rAM != null) {
            this.rAM.vi();
        } else if (d.fP(18) || !this.mBm) {
            G(0, true);
        } else if (this.kYP != null) {
            String Uy = this.kYP.Uy();
            this.kYP.stop();
            AZ(Uy);
        }
    }

    public final void AZ(String str) {
        x.i("MicroMsg.OfflineVideoView", "%d prepare video  filePath %s", Integer.valueOf(hashCode()), str);
        if (bi.oN(str)) {
            x.w("MicroMsg.OfflineVideoView", "%d prepare video but filepath is null.", Integer.valueOf(hashCode()));
        } else if (this.kYP != null) {
            this.kYP.a(this.rAQ);
            this.kYP.setVideoPath(str);
        }
    }

    public final void G(int i, boolean z) {
        x.i("MicroMsg.OfflineVideoView", "%d seek second %d afterSeekPlay %b", Integer.valueOf(hashCode()), Integer.valueOf(i), Boolean.valueOf(z));
        aVF();
        this.kYP.c((double) (i * 1000), z);
        alw();
    }

    public final void bAr() {
        x.i("MicroMsg.OfflineVideoView", "%d pause", Integer.valueOf(hashCode()));
        x.d("MicroMsg.OfflineVideoView", "%d on pause %s ", Integer.valueOf(hashCode()), bi.chl());
        this.rAO = false;
        if (this.kYP.isPlaying()) {
            this.rAP = this.kYP.getCurrentPosition() / 1000;
        }
        x.i("MicroMsg.OfflineVideoView", "%d pause play", Integer.valueOf(hashCode()));
        this.kYP.pause();
        aVF();
        this.kYV.TN();
    }

    public final void bAs() {
        x.i("MicroMsg.OfflineVideoView", "%d start hasResumed[%b]", Integer.valueOf(hashCode()), Boolean.valueOf(this.rAN));
        this.rAO = true;
        if (!this.rAN) {
            onResume();
        } else if (bi.oN(this.kYP.Uy())) {
            onResume();
        } else if (this.kYP.start() && this.rAM != null) {
            this.rAM.onStart(this.duration);
        }
        alw();
    }

    public final void N(int i, boolean z) {
        x.i("MicroMsg.OfflineVideoView", "%d ui touch seek second %d afterSeekPlay %b", Integer.valueOf(hashCode()), Integer.valueOf(i), Boolean.valueOf(z));
        G(i, z);
        alw();
    }

    public final boolean isPlaying() {
        return this.kYP != null ? this.kYP.isPlaying() : false;
    }

    public final int ck(int i, int i2) {
        return 0;
    }

    public final void cl(int i, int i2) {
    }

    public final int getCurrentPosition() {
        if (this.kYP != null) {
            return this.kYP.getCurrentPosition() / 1000;
        }
        return 0;
    }
}
