package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.plugin.voiceprint.model.m;
import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import java.util.Arrays;

public abstract class BaseVoicePrintUI extends MMActivity {
    private boolean oah = false;
    private final al oaq = new al(new a() {
        public final boolean uG() {
            if (BaseVoicePrintUI.this.snz != null) {
                int maxAmplitude;
                p a = BaseVoicePrintUI.this.snz;
                if (a.fhZ != null) {
                    maxAmplitude = a.fhZ.getMaxAmplitude();
                    if (maxAmplitude > p.fmB) {
                        p.fmB = maxAmplitude;
                    }
                    x.d("MicroMsg.VoicePrintRecoder", " map: " + maxAmplitude + " max:" + p.fmB + " per:" + ((maxAmplitude * 100) / p.fmB));
                    maxAmplitude = (maxAmplitude * 100) / p.fmB;
                } else {
                    maxAmplitude = 0;
                }
                BaseVoicePrintUI.a(BaseVoicePrintUI.this, (float) maxAmplitude);
            }
            return true;
        }
    }, true);
    String snA = null;
    private boolean snB = false;
    private View snC;
    private boolean snD = false;
    private final p.a snE = new p.a() {
        public final void bGs() {
            p a = BaseVoicePrintUI.this.snz;
            if (a.fhZ != null) {
                a.fhZ.vj();
                x.e("MicroMsg.VoicePrintRecoder", "Reset recorder.stopReocrd");
            }
            a.fileName = "";
            a.snn = null;
            a.scF = 0;
            a.mEr = 0;
            if (a.hZB != null) {
                a.hZB.zk();
            }
            x.e("MicroMsg.BaseVoicePrintUI", "record stop on error");
            BaseVoicePrintUI.this.snA = null;
            ah.y(new Runnable() {
                public final void run() {
                    BaseVoicePrintUI.this.sny.yK(R.l.eTZ);
                    BaseVoicePrintUI.this.sny.bGJ();
                    BaseVoicePrintUI.this.snv.setPressed(false);
                    BaseVoicePrintUI.this.snv.setEnabled(false);
                    BaseVoicePrintUI.this.snx.stop();
                }
            });
        }
    };
    al snF = new al(new a() {
        public final boolean uG() {
            VoiceTipInfoView c = BaseVoicePrintUI.this.sny;
            if (c.soc.getAnimation() == null) {
                View view = c.soc;
                Context context = c.getContext();
                a.a anonymousClass1 = new a.a() {
                    public final void bGx() {
                    }

                    public final void bGy() {
                    }
                };
                float width = (float) view.getWidth();
                x.d("MicroMsg.VoiceViewAnimationHelper", "target " + width);
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                int i = (int) (width + ((float) iArr[0]));
                x.d("MicroMsg.VoiceViewAnimationHelper", "location %d %d preX=%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(i));
                Animation loadAnimation = AnimationUtils.loadAnimation(context, R.a.bqF);
                loadAnimation.setDuration(200);
                loadAnimation.setStartOffset(0);
                loadAnimation.setRepeatCount(0);
                loadAnimation.setFillAfter(true);
                loadAnimation.setAnimationListener(new com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass1(anonymousClass1));
                view.startAnimation(loadAnimation);
            }
            return false;
        }
    }, true);
    private ag snG = new ag(Looper.getMainLooper(), new ag.a() {
        public final boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            x.d("MicroMsg.BaseVoicePrintUI", "start record");
            as.b(ad.getContext(), R.l.eRj, new as.a() {
                public final void vi() {
                    x.i("MicroMsg.BaseVoicePrintUI", "play press sound end");
                }
            });
            BaseVoicePrintUI.this.snA = "voice_pt_voice_print_record.rec";
            f.a a = BaseVoicePrintUI.this.snz;
            String d = BaseVoicePrintUI.this.snA;
            Context context = BaseVoicePrintUI.this;
            a.fileName = d;
            x.d("MicroMsg.VoicePrintRecoder", "start filename %s", a.fileName);
            com.tencent.mm.y.as.Hn().a(a);
            int xP = com.tencent.mm.y.as.Hn().xP();
            a.scC = false;
            a.hZB = new b(context);
            if (xP != 0) {
                a.er(100);
            } else {
                new ag() {
                    public final void handleMessage(Message message) {
                        x.d("MicroMsg.VoicePrintRecoder", " Recorder handleMessage");
                        if (!p.this.scC) {
                            com.tencent.mm.y.as.Hn().b(p.this);
                            com.tencent.mm.y.as.Hn().xQ();
                            p.this.er(200);
                        }
                    }
                }.sendEmptyMessageDelayed(0, 50);
            }
            BaseVoicePrintUI.this.oaq.K(100, 100);
            BaseVoicePrintUI baseVoicePrintUI = BaseVoicePrintUI.this;
            baseVoicePrintUI.sny.bGK();
            VoiceTipInfoView voiceTipInfoView = baseVoicePrintUI.sny;
            x.d("MicroMsg.VoiceTipInfoView", "hideTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", Integer.valueOf(voiceTipInfoView.jOY.getVisibility()), Boolean.valueOf(voiceTipInfoView.soB));
            if (voiceTipInfoView.jOY.getVisibility() != 0 || voiceTipInfoView.soB) {
                x.d("MicroMsg.VoiceTipInfoView", "hideTitle, directly set to INVISIBLE");
                voiceTipInfoView.jOY.clearAnimation();
                voiceTipInfoView.jOY.setVisibility(4);
                voiceTipInfoView.jOY.invalidate();
            } else {
                voiceTipInfoView.jOY.clearAnimation();
                voiceTipInfoView.soB = true;
                a.a(voiceTipInfoView.jOY, voiceTipInfoView.getContext(), new a.a() {
                    public final void bGx() {
                    }

                    public final void bGy() {
                        VoiceTipInfoView.this.jOY.setVisibility(4);
                        VoiceTipInfoView.this.soB = false;
                    }
                });
            }
            baseVoicePrintUI.sny.Ng(baseVoicePrintUI.sne);
            baseVoicePrintUI.snF.TN();
            baseVoicePrintUI.snF.K(500, 500);
            baseVoicePrintUI.snw.setVisibility(0);
            VoicePrintVolumeMeter voicePrintVolumeMeter = baseVoicePrintUI.snx;
            voicePrintVolumeMeter.reset();
            voicePrintVolumeMeter.mIsPlaying = true;
            long j = (long) VoicePrintVolumeMeter.obh;
            voicePrintVolumeMeter.sok.K(j, j);
            voicePrintVolumeMeter.bGD();
            return true;
        }
    });
    String sne = null;
    Button snv;
    View snw;
    VoicePrintVolumeMeter snx;
    VoiceTipInfoView sny;
    p snz = null;

    protected abstract void aWX();

    protected abstract void bGw();

    static /* synthetic */ void a(BaseVoicePrintUI baseVoicePrintUI, float f) {
        float f2 = 10.0f;
        if (f >= 10.0f) {
            f2 = f;
        }
        if (f2 > 100.0f) {
            f2 = 100.0f;
        }
        VoicePrintVolumeMeter voicePrintVolumeMeter = baseVoicePrintUI.snx;
        f2 /= 100.0f;
        if (f2 > voicePrintVolumeMeter.mVolume) {
            voicePrintVolumeMeter.soy = true;
        } else {
            voicePrintVolumeMeter.soy = false;
        }
        voicePrintVolumeMeter.mVolume = f2;
    }

    static /* synthetic */ void i(BaseVoicePrintUI baseVoicePrintUI) {
        baseVoicePrintUI.snC.setVisibility(0);
        if (baseVoicePrintUI.snD) {
            baseVoicePrintUI.snC.setVisibility(0);
            return;
        }
        baseVoicePrintUI.snD = true;
        View view = baseVoicePrintUI.snC;
        View view2 = baseVoicePrintUI.snv;
        a.a anonymousClass8 = new a.a() {
            public final void bGx() {
            }

            public final void bGy() {
                BaseVoicePrintUI.this.snC.setVisibility(0);
                BaseVoicePrintUI.this.snD = false;
            }
        };
        view.clearAnimation();
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        x.d("MicroMsg.VoiceViewAnimationHelper", "showFromAnchorView, anchorLocation:%s", Arrays.toString(iArr));
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        x.d("MicroMsg.VoiceViewAnimationHelper", "showFromAnchorView, yStartDelta:%d", Integer.valueOf(iArr[1] - iArr2[1]));
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) r1, 0.0f);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        Animation animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setInterpolator(new AccelerateInterpolator());
        animationSet.setDuration(300);
        animationSet.setFillAfter(true);
        animationSet.setRepeatCount(0);
        animationSet.setAnimationListener(new com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass7(anonymousClass8));
        view.startAnimation(animationSet);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.sny = (VoiceTipInfoView) findViewById(R.h.cRX);
        this.snv = (Button) findViewById(R.h.cGA);
        this.snw = findViewById(R.h.cYA);
        this.snx = (VoicePrintVolumeMeter) findViewById(R.h.cYB);
        this.snC = findViewById(R.h.bPk);
        this.sny.bGK();
        this.snx.oaV = this.snv;
        this.snz = new p();
        this.snz.snq = this.snE;
        this.snv.setOnTouchListener(new OnTouchListener() {
            private long oaO = 0;
            private boolean snJ = false;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        BaseVoicePrintUI.this.oah = false;
                        if (!bi.oN(BaseVoicePrintUI.this.sne)) {
                            this.oaO = System.currentTimeMillis();
                            BaseVoicePrintUI.this.snv.setPressed(true);
                            BaseVoicePrintUI.this.snB = true;
                            BaseVoicePrintUI.this.bGu();
                            BaseVoicePrintUI.this.snG.sendEmptyMessageDelayed(1, 300);
                            x.i("MicroMsg.BaseVoicePrintUI", "mic press down");
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        BaseVoicePrintUI.this.snv.setPressed(false);
                        BaseVoicePrintUI.this.snG.removeMessages(1);
                        if (System.currentTimeMillis() - this.oaO < 300) {
                            x.d("MicroMsg.BaseVoicePrintUI", "just little touch the button, set touchDown to false");
                            BaseVoicePrintUI.this.oah = false;
                        } else {
                            BaseVoicePrintUI.this.oah = true;
                        }
                        x.i("MicroMsg.BaseVoicePrintUI", "mic press up %d, hasTouchDown:%b", Integer.valueOf(motionEvent.getAction()), Boolean.valueOf(BaseVoicePrintUI.this.oah));
                        BaseVoicePrintUI.this.snx.stop();
                        BaseVoicePrintUI.this.oaq.TN();
                        BaseVoicePrintUI.this.snz.vp();
                        if (!BaseVoicePrintUI.this.oah) {
                            BaseVoicePrintUI.this.sny.yK(R.l.eTR);
                            BaseVoicePrintUI.this.sny.bGJ();
                            break;
                        }
                        BaseVoicePrintUI baseVoicePrintUI = BaseVoicePrintUI.this;
                        x.d("MicroMsg.BaseVoicePrintUI", "releaseMic");
                        if (!baseVoicePrintUI.snz.snp) {
                            baseVoicePrintUI.snF.TN();
                            baseVoicePrintUI.sny.yK(R.l.eTR);
                            baseVoicePrintUI.sny.bGJ();
                            baseVoicePrintUI.snA = null;
                        }
                        baseVoicePrintUI.snw.setVisibility(8);
                        baseVoicePrintUI.sny.bGH();
                        baseVoicePrintUI.sny.Ng(baseVoicePrintUI.sne);
                        x.d("MicroMsg.BaseVoicePrintUI", "localMsgFileName %s", BaseVoicePrintUI.this.snA);
                        if (!bi.oN(BaseVoicePrintUI.this.snA)) {
                            BaseVoicePrintUI.this.bGw();
                        }
                        this.oaO = 0;
                        this.snJ = false;
                        BaseVoicePrintUI.this.oah = false;
                        break;
                }
                return false;
            }
        });
        findViewById(R.h.csO).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                BaseVoicePrintUI.this.finish();
            }
        });
        aWX();
    }

    protected final void bGt() {
        ah.h(new Runnable() {
            public final void run() {
                if (!BaseVoicePrintUI.this.snB) {
                    BaseVoicePrintUI.i(BaseVoicePrintUI.this);
                }
            }
        }, 1300);
    }

    protected final void bGu() {
        if (this.snC.getVisibility() != 4 && this.snC.getVisibility() != 8) {
            if (this.snD) {
                this.snC.setVisibility(4);
                return;
            }
            this.snD = true;
            a.a(this.snC, this, new a.a() {
                public final void bGx() {
                }

                public final void bGy() {
                    BaseVoicePrintUI.this.snC.setVisibility(4);
                    BaseVoicePrintUI.this.snD = false;
                }
            });
        }
    }

    protected final int getLayoutId() {
        return R.i.dtN;
    }

    protected void onDestroy() {
        super.onDestroy();
        VoicePrintVolumeMeter voicePrintVolumeMeter = this.snx;
        voicePrintVolumeMeter.sok.TN();
        voicePrintVolumeMeter.soj.oFY.getLooper().quit();
        x.d("MicroMsg.VoicePrintVolumeMeter", "destroy, quit factor thread");
        x.d("MicroMsg.VoicePrintLogic", "delete voiceprint voice file");
        File file = new File(m.aJ("voice_pt_voice_print_record.rec", false));
        if (file.exists()) {
            file.delete();
        }
        file = new File(m.aJ("voice_pt_voice_print_noise_detect.rec", false));
        if (file.exists()) {
            file.delete();
        }
    }

    protected final void bGv() {
        yI(R.l.eTU);
    }

    protected final void yI(int i) {
        this.sny.bGG();
        this.sny.yK(i);
        this.sny.bGJ();
    }
}
