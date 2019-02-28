package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.bf.e;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public class VoiceSearchLayout extends LinearLayout {
    private static final int[] kJK = new int[]{R.g.bHD, R.g.bHE, R.g.bHF, R.g.bHG, R.g.bHr, R.g.bHs, R.g.bHt, R.g.bHu, R.g.bHv, R.g.bHw, R.g.bHx, R.g.bHy, R.g.bHz, R.g.bHA};
    private static final int[] vto = new int[]{R.g.bHD, R.g.bHD, R.g.bHD, R.g.bHE, R.g.bHF, R.g.bHE, R.g.bHD, R.g.bHG, R.g.bHD, R.g.bHD};
    private static final int[] vtp = new int[]{R.g.bHB, R.g.bHC, R.g.bHC, R.g.bHC, R.g.bHB};
    public boolean fBn = false;
    private int fqZ = 0;
    public final al kKg = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            if (VoiceSearchLayout.this.vtm != null) {
                if (VoiceSearchLayout.this.vts < VoiceSearchLayout.vtp.length) {
                    VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.vtp[VoiceSearchLayout.this.vts = VoiceSearchLayout.this.vts + 1]);
                } else {
                    e a = VoiceSearchLayout.this.vtm;
                    x.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + a.iac);
                    int i = a.iac;
                    a.iac = 0;
                    if (i > e.fmB) {
                        e.fmB = i;
                    }
                    x.d("getMaxAmplitude", " map: " + i + " max:" + e.fmB + " per:" + ((i * 100) / e.fmB));
                    int i2 = (i * 100) / e.fmB;
                    x.d("MicroMsg.VoiceSearchLayout", "addr vol:" + i2);
                    i = VoiceSearchLayout.this.fqZ;
                    if (VoiceSearchLayout.this.fqZ == VoiceSearchLayout.this.vtq) {
                        if (i2 <= 10) {
                            VoiceSearchLayout.f(VoiceSearchLayout.this);
                            if (VoiceSearchLayout.this.vtr >= VoiceSearchLayout.vto.length) {
                                VoiceSearchLayout.this.vtr = 0;
                            }
                            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.vto[VoiceSearchLayout.this.vtr]);
                        } else {
                            i2 /= 5;
                            if (i2 >= VoiceSearchLayout.kJK.length) {
                                i2 = VoiceSearchLayout.kJK.length - 1;
                            }
                            x.d("MicroMsg.VoiceSearchLayout", "addr mvol:" + i2);
                            VoiceSearchLayout.this.vtq = i2;
                        }
                    } else if (VoiceSearchLayout.this.fqZ > VoiceSearchLayout.this.vtq) {
                        VoiceSearchLayout.i(VoiceSearchLayout.this);
                    } else {
                        VoiceSearchLayout.j(VoiceSearchLayout.this);
                    }
                    VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.kJK[i]);
                }
            }
            return true;
        }
    }, true);
    public View mcj = null;
    public a vtf = null;
    private Button vtg;
    public boolean vth = false;
    public int vti = 0;
    public b vtj;
    private View vtk;
    private AnimationDrawable vtl;
    public e vtm;
    private boolean vtn = false;
    private int vtq = 0;
    private int vtr = 0;
    public int vts = 0;

    public interface a {
        void a(boolean z, String[] strArr, long j);

        void cbA();

        void cbz();
    }

    public interface b {
        void lg(boolean z);
    }

    static /* synthetic */ void a(VoiceSearchLayout voiceSearchLayout, int i) {
        if (voiceSearchLayout.vtg != null) {
            voiceSearchLayout.vtg.setBackgroundResource(i);
        }
    }

    static /* synthetic */ int f(VoiceSearchLayout voiceSearchLayout) {
        int i = voiceSearchLayout.vtr + 1;
        voiceSearchLayout.vtr = i;
        return i;
    }

    static /* synthetic */ int i(VoiceSearchLayout voiceSearchLayout) {
        int i = voiceSearchLayout.fqZ - 1;
        voiceSearchLayout.fqZ = i;
        return i;
    }

    static /* synthetic */ int j(VoiceSearchLayout voiceSearchLayout) {
        int i = voiceSearchLayout.fqZ + 1;
        voiceSearchLayout.fqZ = i;
        return i;
    }

    static /* synthetic */ void k(VoiceSearchLayout voiceSearchLayout) {
        voiceSearchLayout.vth = true;
        voiceSearchLayout.lf(true);
    }

    @TargetApi(11)
    public VoiceSearchLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public VoiceSearchLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public VoiceSearchLayout(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.mcj = inflate(context, R.i.dtR, this);
        this.vtg = (Button) this.mcj.findViewById(R.h.cXe);
        this.vtk = this.mcj.findViewById(R.h.cXc);
        lf(false);
        reset();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.vth) {
            x.d("MicroMsg.VoiceSearchLayout", "checkStop " + this.fBn);
            if (this.fBn) {
                cbm();
                this.fBn = false;
            }
        }
        return true;
    }

    public final void cbm() {
        x.d("MicroMsg.VoiceSearchLayout", "doCancel " + this.fBn);
        if (this.fBn) {
            this.fBn = false;
            if (this.vtf != null) {
                this.vtf.cbA();
            }
        }
        reset();
        if (getVisibility() == 0) {
            setVisibility(8);
            if (this.vtj != null) {
                this.vtj.lg(false);
            }
        }
        ya();
        if (this.vtm != null) {
            this.vtm.cancel();
        }
        if (this.kKg != null) {
            this.kKg.TN();
        }
    }

    public final void reset() {
        lf(false);
        this.fBn = false;
        this.vth = false;
        this.vtg.setBackgroundResource(R.g.bHq);
        this.vtk.setBackgroundDrawable(getResources().getDrawable(R.g.bHp));
    }

    private void lf(boolean z) {
        if (z) {
            this.vtg.setBackgroundResource(R.g.bHn);
            this.vtl = (AnimationDrawable) this.vtg.getBackground();
            if (this.vtl != null) {
                this.vtl.start();
                return;
            }
            return;
        }
        this.vtg.setBackgroundResource(R.g.bHq);
    }

    public void setVisibility(int i) {
        if (super.getVisibility() != i && !this.vtn) {
            Animation loadAnimation;
            if (i == 8) {
                loadAnimation = AnimationUtils.loadAnimation(getContext(), R.a.bqa);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getContext(), R.a.bpZ);
            }
            startAnimation(loadAnimation);
            super.setVisibility(i);
            if (this.vtj != null) {
                this.vtj.lg(i == 0);
            }
        }
    }

    public final void Cn(int i) {
        LayoutParams layoutParams = (LayoutParams) this.vtk.getLayoutParams();
        layoutParams.topMargin = i;
        this.vtk.setLayoutParams(layoutParams);
    }

    public final void a(boolean z, i iVar) {
        if (z) {
            x.d("MicroMsg.VoiceSearchLayout", "pauseMusic");
            as.Hn().xZ();
        } else {
            ya();
        }
        MediaPlayer jVar = new j();
        if (z) {
            try {
                jVar.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.k.dAf));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VoiceSearchLayout", e, "", new Object[0]);
                return;
            }
        }
        jVar.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.k.dzH));
        jVar.setAudioStreamType(5);
        jVar.setOnCompletionListener(new OnCompletionListener(null) {
            public final void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
        jVar.setOnErrorListener(new OnErrorListener(null) {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                return false;
            }
        });
        jVar.prepare();
        jVar.setLooping(false);
        jVar.start();
    }

    private static void ya() {
        x.d("MicroMsg.VoiceSearchLayout", "resumeMusic");
        as.Hn().ya();
    }
}
