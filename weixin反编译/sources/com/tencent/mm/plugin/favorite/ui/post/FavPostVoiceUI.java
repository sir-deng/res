package com.tencent.mm.plugin.favorite.ui.post;

import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.v;
import java.io.File;

public class FavPostVoiceUI extends MMBaseActivity {
    private static final int[] kJJ = new int[]{0, 15, 30, 45, 60, 75, 90, 100};
    private static final int[] kJK = new int[]{R.g.byD, R.g.byE, R.g.byF, R.g.byG, R.g.byH, R.g.byI, R.g.byJ};
    private long duration;
    private int kJC;
    private long kJN = -1;
    private Toast kJO;
    private ImageView kJS;
    private boolean kKa;
    private boolean kKb;
    private final al kKg = new al(new a() {
        public final boolean uG() {
            int maxAmplitude;
            int i = 0;
            j a = FavPostVoiceUI.this.mEy;
            if (a.status == 1) {
                maxAmplitude = a.fmz.getMaxAmplitude();
                if (maxAmplitude > j.fmB) {
                    j.fmB = maxAmplitude;
                }
                maxAmplitude = (maxAmplitude * 100) / j.fmB;
            } else {
                maxAmplitude = 0;
            }
            while (i < FavPostVoiceUI.kJK.length) {
                if (maxAmplitude >= FavPostVoiceUI.kJJ[i] && maxAmplitude < FavPostVoiceUI.kJJ[i + 1]) {
                    FavPostVoiceUI.this.kJS.setBackgroundResource(FavPostVoiceUI.kJK[i]);
                    break;
                }
                i++;
            }
            return true;
        }
    }, true);
    private final al kKh = new al(new a() {
        public final boolean uG() {
            if (FavPostVoiceUI.this.kJN == -1) {
                FavPostVoiceUI.this.kJN = bi.Wz();
            }
            long bB = bi.bB(FavPostVoiceUI.this.kJN);
            if (bB >= 3590000 && bB <= 3600000) {
                if (FavPostVoiceUI.this.kJO == null) {
                    FavPostVoiceUI.this.kJO = Toast.makeText(FavPostVoiceUI.this, FavPostVoiceUI.this.getString(R.l.duz, new Object[]{Integer.valueOf((int) ((3600000 - bB) / 1000))}), 0);
                } else {
                    FavPostVoiceUI.this.kJO.setText(FavPostVoiceUI.this.getString(R.l.duz, new Object[]{Integer.valueOf((int) ((3600000 - bB) / 1000))}));
                }
                FavPostVoiceUI.this.kJO.show();
            }
            if (bB < 3600000) {
                return true;
            }
            x.v("MicroMsg.FavPostVoiceUI", "record stop on countdown");
            FavPostVoiceUI.this.kKb = true;
            FavPostVoiceUI.this.aKu();
            return false;
        }
    }, true);
    private final ag kKj = new ag() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            FavPostVoiceUI.this.aKv();
            FavPostVoiceUI.this.mEq.setBackgroundResource(R.g.bFi);
            FavPostVoiceUI.this.mEq.setEnabled(true);
        }
    };
    private Button mEq;
    private long mEr;
    private View mEs;
    private View mEt;
    private View mEu;
    private View mEv;
    private TextView mEw;
    private View mEx;
    private j mEy;
    boolean mEz = false;
    private String path;

    static /* synthetic */ void j(FavPostVoiceUI favPostVoiceUI) {
        favPostVoiceUI.mEq.setKeepScreenOn(true);
        favPostVoiceUI.mEq.setBackgroundResource(R.g.bFi);
        favPostVoiceUI.mEq.setText(R.l.egD);
        favPostVoiceUI.kKb = false;
        favPostVoiceUI.mEy = favPostVoiceUI.aKt();
        if (favPostVoiceUI.mEy.cK(favPostVoiceUI.path)) {
            favPostVoiceUI.mEr = bi.Wz();
            favPostVoiceUI.kKh.K(200, 200);
            favPostVoiceUI.kJS.setVisibility(0);
            favPostVoiceUI.kKg.K(100, 100);
            favPostVoiceUI.mEw.setText(R.l.ege);
            return;
        }
        favPostVoiceUI.mEr = 0;
    }

    static /* synthetic */ void n(FavPostVoiceUI favPostVoiceUI) {
        favPostVoiceUI.mEq.setKeepScreenOn(false);
        favPostVoiceUI.mEy.vj();
        favPostVoiceUI.kKg.TN();
        favPostVoiceUI.kKh.TN();
        favPostVoiceUI.aKw();
        favPostVoiceUI.aKv();
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(v.fw(this).inflate(R.i.dhO, null));
        this.kJS = (ImageView) findViewById(R.h.cWP);
        this.mEu = findViewById(R.h.cWQ);
        this.mEv = findViewById(R.h.cWS);
        this.mEs = findViewById(R.h.cWW);
        this.mEt = findViewById(R.h.cWX);
        this.mEw = (TextView) findViewById(R.h.cWY);
        this.mEx = findViewById(R.h.cWR);
        findViewById(R.h.cWO).setVisibility(8);
        this.mEx.setVisibility(8);
        findViewById(R.h.cWO).setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                FavPostVoiceUI.this.aKx();
                return false;
            }
        });
        findViewById(R.h.cgW).setVisibility(8);
        this.mEy = aKt();
        this.mEq = (Button) findViewById(R.h.cgV);
        this.mEq.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (view == FavPostVoiceUI.this.mEq) {
                    int rawY = (int) motionEvent.getRawY();
                    int[] iArr = new int[2];
                    FavPostVoiceUI.this.kJC = FavPostVoiceUI.this.getResources().getDisplayMetrics().heightPixels;
                    FavPostVoiceUI.this.mEq.getLocationOnScreen(iArr);
                    int i = iArr[1];
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (!FavPostVoiceUI.this.kKa) {
                                FavPostVoiceUI.this.kKa = true;
                                FavPostVoiceUI.j(FavPostVoiceUI.this);
                                break;
                            }
                            break;
                        case 1:
                            if (FavPostVoiceUI.this.kKa) {
                                if (FavPostVoiceUI.this.mEv.getVisibility() != 0) {
                                    if (!FavPostVoiceUI.this.kKb) {
                                        FavPostVoiceUI.this.aKu();
                                        break;
                                    }
                                }
                                x.w("MicroMsg.FavPostVoiceUI", "action up -> cancel");
                                FavPostVoiceUI.n(FavPostVoiceUI.this);
                                break;
                            }
                            break;
                        case 2:
                            if (rawY <= FavPostVoiceUI.this.kJC - b.b(FavPostVoiceUI.this, 60.0f) && rawY < i) {
                                FavPostVoiceUI.this.mEu.setVisibility(8);
                                FavPostVoiceUI.this.mEv.setVisibility(0);
                                break;
                            }
                            FavPostVoiceUI.this.mEu.setVisibility(0);
                            FavPostVoiceUI.this.mEv.setVisibility(8);
                            break;
                        case 3:
                            x.w("MicroMsg.FavPostVoiceUI", "action cancel");
                            FavPostVoiceUI.n(FavPostVoiceUI.this);
                            break;
                    }
                }
                return false;
            }
        });
        aKv();
        String aJm = com.tencent.mm.plugin.favorite.a.j.aJm();
        File file = new File(aJm);
        if (!file.exists()) {
            file.mkdirs();
        }
        do {
            str = aJm + "/" + System.currentTimeMillis();
        } while (new File(str).exists());
        this.path = str;
        this.mEw.post(new Runnable() {
            public final void run() {
                FavPostVoiceUI.this.findViewById(R.h.cWO).setVisibility(0);
                FavPostVoiceUI.this.mEx.setVisibility(0);
                FavPostVoiceUI.this.findViewById(R.h.cgW).setVisibility(0);
                Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(300);
                Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
                translateAnimation.setDuration(300);
                FavPostVoiceUI.this.mEx.startAnimation(alphaAnimation);
                FavPostVoiceUI.this.findViewById(R.h.cWO).startAnimation(alphaAnimation);
                FavPostVoiceUI.this.findViewById(R.h.cgW).startAnimation(translateAnimation);
            }
        });
    }

    private j aKt() {
        com.tencent.mm.compatible.b.b.a aVar = com.tencent.mm.compatible.b.b.a.AMR;
        j jVar = new j();
        jVar.fmA = new j.a() {
            public final void onError() {
                FavPostVoiceUI.this.kKg.TN();
                FavPostVoiceUI.this.kKh.TN();
            }
        };
        return jVar;
    }

    private void aKu() {
        long j = 0;
        if (this.kKa) {
            boolean z;
            this.mEq.setKeepScreenOn(true);
            this.mEq.setBackgroundResource(R.g.bFh);
            this.mEq.setText(R.l.egp);
            this.mEy.vj();
            if (this.mEr != 0) {
                j = bi.bB(this.mEr);
            }
            this.duration = j;
            if (this.duration < 800) {
                z = true;
            } else {
                z = false;
            }
            this.kKg.TN();
            this.kKh.TN();
            if (z) {
                aKw();
                this.mEq.setEnabled(false);
                this.mEq.setBackgroundResource(R.g.bFg);
                this.mEt.setVisibility(0);
                this.mEs.setVisibility(8);
                this.kKj.sendEmptyMessageDelayed(0, 500);
            } else {
                String str = this.path;
                int i = (int) this.duration;
                if (bi.oN(str)) {
                    x.e("MicroMsg.FavPostLogic", "postVoice path null");
                } else {
                    f fVar = new f();
                    fVar.field_type = 3;
                    fVar.field_sourceType = 6;
                    c.j(fVar);
                    uz uzVar = new uz();
                    uzVar.Uj(str);
                    uzVar.Db(i);
                    uzVar.lA(true);
                    uzVar.Dc(fVar.field_type);
                    uzVar.Uf("amr");
                    fVar.field_favProto.wlY.add(uzVar);
                    com.tencent.mm.plugin.favorite.b.a.B(fVar);
                    g.pWK.h(10648, Integer.valueOf(1), Integer.valueOf(0));
                }
                setResult(-1);
                finish();
                overridePendingTransition(0, 0);
            }
            this.kKa = false;
        }
    }

    public final void aKv() {
        this.mEs.setVisibility(0);
        this.mEt.setVisibility(8);
        this.mEv.setVisibility(8);
        this.mEu.setVisibility(0);
        this.mEw.setText(R.l.eBi);
        this.mEq.setBackgroundResource(R.g.bFi);
        this.mEq.setText(R.l.egp);
        this.kJS.setVisibility(4);
        this.kKa = false;
    }

    private void aKw() {
        File file = new File(this.path);
        if (file.exists()) {
            file.delete();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        aKu();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 != i) {
            return super.onKeyDown(i, keyEvent);
        }
        aKx();
        return true;
    }

    private void aKx() {
        if (!this.mEz) {
            this.mEz = true;
            Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
            translateAnimation.setDuration(300);
            Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300);
            translateAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    FavPostVoiceUI.this.mEu.post(new Runnable() {
                        public final void run() {
                            FavPostVoiceUI.this.setResult(0);
                            FavPostVoiceUI.this.finish();
                            FavPostVoiceUI.this.overridePendingTransition(0, 0);
                        }
                    });
                }
            });
            findViewById(R.h.cWO).setVisibility(8);
            findViewById(R.h.cgW).setVisibility(8);
            this.mEx.setVisibility(8);
            this.mEx.startAnimation(alphaAnimation);
            findViewById(R.h.cWO).startAnimation(alphaAnimation);
            findViewById(R.h.cgW).startAnimation(translateAnimation);
        }
    }
}
