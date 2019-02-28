package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.sm;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.f;
import com.tencent.mm.plugin.voiceprint.model.l;
import com.tencent.mm.plugin.voiceprint.model.l.a;
import com.tencent.mm.plugin.voiceprint.model.m;
import com.tencent.mm.plugin.voiceprint.model.o;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public class VoiceCreateUI extends BaseVoicePrintUI implements a {
    private View lvm = null;
    private l snR;
    private o snS = null;
    private View snT;
    private NoiseDetectMaskView snU;
    private Button snV = null;
    private int snW = 0;
    private c snX = new c<sm>() {
        {
            this.xmG = sm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            x.d("MicroMsg.VoiceCreateUI", "detect finish, noise:%b", Boolean.valueOf(((sm) bVar).fLa.fLb));
            if (((sm) bVar).fLa.fLb) {
                VoiceCreateUI.a(VoiceCreateUI.this);
            } else {
                VoiceCreateUI.b(VoiceCreateUI.this);
            }
            return false;
        }
    };
    private int snd = 1;

    static /* synthetic */ void a(VoiceCreateUI voiceCreateUI) {
        g.pWK.h(11390, Integer.valueOf(4));
        NoiseDetectMaskView noiseDetectMaskView = voiceCreateUI.snU;
        if (noiseDetectMaskView.lvk != null) {
            noiseDetectMaskView.lvk.setVisibility(8);
        }
        noiseDetectMaskView.snK.setText(R.l.eTX);
        noiseDetectMaskView.snL.setVisibility(0);
    }

    static /* synthetic */ void b(VoiceCreateUI voiceCreateUI) {
        voiceCreateUI.lvm.setVisibility(0);
        voiceCreateUI.snT.setVisibility(0);
        voiceCreateUI.snw.setVisibility(0);
        View view = voiceCreateUI.snU;
        a.a anonymousClass6 = new a.a() {
            public final void bGx() {
            }

            public final void bGy() {
                VoiceCreateUI.this.snU.setVisibility(8);
                VoiceCreateUI.h(VoiceCreateUI.this);
            }
        };
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setFillAfter(true);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setAnimationListener(new com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass6(anonymousClass6));
        view.startAnimation(translateAnimation);
    }

    static /* synthetic */ void h(VoiceCreateUI voiceCreateUI) {
        voiceCreateUI.sny.bGF();
        voiceCreateUI.snd = 1;
        voiceCreateUI.snR.snd = 71;
        as.CN().a(new d(71, ""), 0);
    }

    protected final void bGw() {
        x.d("MicroMsg.VoiceCreateUI", "sendVoice, filename:%s", this.snA);
        if (!bi.oN(this.snA)) {
            this.snv.setEnabled(false);
            this.sny.bGF();
            l lVar;
            k fVar;
            if (this.snd == 1) {
                lVar = this.snR;
                fVar = new f(this.snA, 71, lVar.snf, 0);
                fVar.smM = true;
                as.CN().a(fVar, 0);
                lVar.snd = 71;
            } else if (this.snd == 2) {
                lVar = this.snR;
                fVar = new f(this.snA, 72, lVar.snf, lVar.smP);
                fVar.smM = true;
                as.CN().a(fVar, 0);
                lVar.snd = 72;
            }
        }
    }

    protected final void aWX() {
        this.snR = new l(this);
        findViewById(R.h.cIk).setVisibility(8);
        this.sny.yJ(R.l.eTY);
        this.sny.bGI();
        this.snv.setEnabled(false);
        this.snS = new o();
        this.snT = findViewById(R.h.cWo);
        this.snU = (NoiseDetectMaskView) findViewById(R.h.mask);
        this.lvm = findViewById(R.h.csO);
        this.snV = (Button) findViewById(R.h.cIk);
        this.snV.setVisibility(8);
        this.snV.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                VoiceCreateUI.this.bGu();
                a.a(VoiceCreateUI.this.sny, new a.a() {
                    public final void bGx() {
                        VoiceCreateUI.this.snV.setVisibility(8);
                        VoiceCreateUI.this.sny.yJ(R.l.eTY);
                        VoiceCreateUI.this.sny.soc.setVisibility(0);
                        VoiceCreateUI.this.snv.setEnabled(true);
                        VoiceCreateUI.this.snv.setVisibility(0);
                    }

                    public final void bGy() {
                    }
                });
            }
        });
        this.snU.snM = new NoiseDetectMaskView.b() {
            public final void bGA() {
                g.pWK.h(11390, Integer.valueOf(5));
                VoiceCreateUI.this.start();
            }
        };
        this.snU.snN = new NoiseDetectMaskView.a() {
            public final void bGz() {
                VoiceCreateUI.this.bGC();
                o f = VoiceCreateUI.this.snS;
                x.d("MicroMsg.VoicePrintNoiseDetector", "stopDetect");
                f.sni.vj();
                f.snj.TN();
                VoiceCreateUI.this.finish();
            }
        };
        com.tencent.mm.sdk.b.a.xmy.b(this.snX);
        this.lvm.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                VoiceCreateUI.this.bGC();
                VoiceCreateUI.this.finish();
            }
        });
        start();
    }

    private void start() {
        x.d("MicroMsg.VoiceCreateUI", "start create");
        this.snS.reset();
        NoiseDetectMaskView noiseDetectMaskView = this.snU;
        if (noiseDetectMaskView.lvk != null) {
            noiseDetectMaskView.lvk.setVisibility(0);
        }
        noiseDetectMaskView.snK.setText(R.l.eTV);
        noiseDetectMaskView.snL.setVisibility(8);
        x.d("MicroMsg.VoiceCreateUI", "start noise detect");
        this.lvm.setVisibility(4);
        this.snT.setVisibility(4);
        this.snw.setVisibility(4);
        this.snU.setVisibility(0);
        o oVar = this.snS;
        x.d("MicroMsg.VoicePrintNoiseDetector", "start detect noise");
        oVar.reset();
        if (oVar.sni.cI(m.aJ("voice_pt_voice_print_noise_detect.rec", true))) {
            x.d("MicroMsg.VoicePrintNoiseDetector", "start record");
        } else {
            oVar.sni.vj();
            oVar.reset();
            x.d("MicroMsg.VoicePrintNoiseDetector", "start record fail");
        }
        oVar.snj.K(100, 100);
    }

    public final void Nd(String str) {
        x.d("MicroMsg.VoiceCreateUI", "onGetFirstText");
        bGt();
        this.sne = str;
        this.sny.bGG();
        this.sny.bGH();
        this.sny.Ng(str);
        this.snv.setEnabled(true);
    }

    public final void Ne(String str) {
        x.d("MicroMsg.VoiceCreateUI", "onGetSecondText");
        this.sne = str;
        this.sny.bGG();
        this.sny.bGH();
        this.sny.Ng(str);
        this.snv.setEnabled(true);
    }

    public final void v(boolean z, int i) {
        x.d("MicroMsg.VoiceCreateUI", "onCreate, result:%b, step:%d", Boolean.valueOf(z), Integer.valueOf(i));
        if (z) {
            switch (i) {
                case org.xwalk.core.R.styleable.AppCompatTheme_listPreferredItemHeightLarge /*71*/:
                    x.d("MicroMsg.VoiceCreateUI", "finish create step 1");
                    this.snv.setEnabled(false);
                    this.snd = 2;
                    bGu();
                    a.a(this.sny, new a.a() {
                        public final void bGx() {
                            VoiceCreateUI.this.sny.reset();
                            VoiceCreateUI.this.sny.bGH();
                            VoiceCreateUI.this.sny.bGI();
                            VoiceCreateUI.this.snv.setVisibility(4);
                            VoiceCreateUI.this.sny.yJ(R.l.eTW);
                            VoiceCreateUI.this.snV.setVisibility(0);
                            VoiceCreateUI.this.sny.bGG();
                        }

                        public final void bGy() {
                        }
                    });
                    return;
                case 72:
                    this.snW = 0;
                    x.d("MicroMsg.VoiceCreateUI", "finish create step 2");
                    Intent intent = new Intent();
                    intent.putExtra("KIsCreateSuccess", true);
                    setResult(-1, intent);
                    intent = new Intent();
                    intent.setClass(this, VoicePrintFinishUI.class);
                    intent.putExtra("kscene_type", 72);
                    startActivity(intent);
                    finish();
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 72:
                bGC();
                this.snW++;
                if (this.snW >= 2) {
                    x.d("MicroMsg.VoiceCreateUI", "in second step, verify two times failed");
                    this.snW = 0;
                    startActivity(new Intent(this, VoiceReCreatePromptUI.class));
                    overridePendingTransition(R.a.bqB, R.a.bqA);
                    finish();
                    return;
                }
                this.snv.setEnabled(true);
                this.sny.bGG();
                this.sny.yK(R.l.eUa);
                this.sny.bGJ();
                return;
            default:
                return;
        }
    }

    public final void bGp() {
        bGv();
        bGC();
    }

    private void bGC() {
        Intent intent = new Intent();
        intent.putExtra("KIsCreateSuccess", false);
        setResult(-1, intent);
    }

    protected void onDestroy() {
        super.onDestroy();
        e eVar = this.snR;
        as.CN().b(611, eVar);
        as.CN().b(612, eVar);
        eVar.sng = null;
        com.tencent.mm.sdk.b.a.xmy.c(this.snX);
    }

    public void onBackPressed() {
        super.onBackPressed();
        bGC();
    }
}
