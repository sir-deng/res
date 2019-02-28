package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.luckymoney.b.e;
import com.tencent.mm.plugin.luckymoney.f2f.a.b;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.protocal.c.bcj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.y.s;
import java.io.IOException;

@a(3)
public class LuckyMoneyF2FReceiveUI extends LuckyMoneyBaseUI {
    private DisplayMetrics ieH;
    private String lUI;
    private String oeH;
    private String oeJ;
    private int oeK;
    private String oeP;
    private ImageView ofe;
    private TextView off;
    private View ogj;
    private TextView ogk;
    private ImageView ogl;
    private ValueAnimator ogm;
    private ValueAnimator ogn;
    private Intent ogo;
    private boolean ogp = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ogj = findViewById(f.uvK);
        this.ofe = (ImageView) findViewById(f.uvM);
        this.off = (TextView) findViewById(f.uvN);
        this.ogk = (TextView) findViewById(f.uvO);
        this.ogl = (ImageView) findViewById(f.uvS);
        this.ogl.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                LuckyMoneyF2FReceiveUI.this.ogn.cancel();
                LuckyMoneyF2FReceiveUI.this.finish();
            }
        });
        this.mController.contentView.setVisibility(8);
        this.lUI = getIntent().getStringExtra("key_share_url");
        i.i(this, 6);
        b(new b(this.lUI), true);
        this.ieH = getResources().getDisplayMetrics();
        this.ogm = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(300);
        this.ogn = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(300);
        this.ogn.setStartDelay(1000);
        this.ogm.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LuckyMoneyF2FReceiveUI.this.ogj.setTranslationY((-((Float) valueAnimator.getAnimatedValue()).floatValue()) * ((float) LuckyMoneyF2FReceiveUI.this.ieH.heightPixels));
            }
        });
        this.ogm.addListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                x.i("LuckyMoneyF2FReceiveUI", "packet top in animator end");
                LuckyMoneyF2FReceiveUI.this.ogn.start();
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        this.ogn.addListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                x.i("LuckyMoneyF2FReceiveUI", "packet exit animator end");
                if (LuckyMoneyF2FReceiveUI.this.ogo != null) {
                    LuckyMoneyF2FReceiveUI.this.a(LuckyMoneyDetailUI.class, LuckyMoneyF2FReceiveUI.this.ogo);
                }
                LuckyMoneyF2FReceiveUI.this.setResult(-1, null);
                LuckyMoneyF2FReceiveUI.this.finish();
                if (LuckyMoneyF2FReceiveUI.this.ogo != null) {
                    LuckyMoneyF2FReceiveUI.this.overridePendingTransition(com.tencent.mm.plugin.wxpay.a.a.bqk, com.tencent.mm.plugin.wxpay.a.a.bql);
                }
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
    }

    protected final int getLayoutId() {
        return g.uIU;
    }

    protected void onResume() {
        super.onResume();
        jl(1997);
        if (this.ogp) {
            finish();
        }
    }

    protected void onStop() {
        super.onStop();
        jm(1997);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.i("LuckyMoneyF2FReceiveUI", "errType: %d,errCode: %d,errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (!(kVar instanceof b)) {
            return true;
        }
        b bVar = (b) kVar;
        int i3 = bVar.fMy;
        int i4 = bVar.oeI;
        this.oeK = bVar.oeK;
        int i5 = bVar.oeM;
        String str2 = bVar.oeN;
        String str3 = bVar.oeO;
        x.i("LuckyMoneyF2FReceiveUI", "hbStatus: %d, recvStatus:%d, errorType:%d", Integer.valueOf(bVar.fMy), Integer.valueOf(bVar.oeI), Integer.valueOf(bVar.frq));
        bcj bcj;
        if (i4 == 2) {
            if (i3 == 5) {
                h.a((Context) this, getString(com.tencent.mm.plugin.wxpay.a.i.uQx), "", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        LuckyMoneyF2FReceiveUI.this.finish();
                    }
                });
            } else {
                this.oeH = bVar.oeH;
                this.oeJ = bVar.oeJ;
                this.oeP = bVar.oeP;
                this.ogo = new Intent();
                if (!(bi.oN(this.oeJ) || s.gH(this.oeJ))) {
                    com.tencent.mm.ac.h hVar = new com.tencent.mm.ac.h();
                    hVar.username = this.oeJ;
                    n.JW().a(hVar);
                }
                com.tencent.mm.plugin.luckymoney.b.n.a(this.ofe, null, this.oeJ);
                e eVar = new e();
                eVar.fMM = (long) this.oeK;
                eVar.oeH = this.oeH;
                eVar.fMy = i3;
                eVar.fMz = i4;
                eVar.oeO = str3;
                eVar.oeM = i5;
                eVar.ohP = this.oeJ;
                eVar.oeN = str2;
                eVar.ohu = com.tencent.mm.plugin.luckymoney.b.n.gv(this.oeJ);
                eVar.oeP = this.oeP;
                eVar.ohq = 2;
                x.i("LuckyMoneyF2FReceiveUI", "is most lucky %d", Integer.valueOf(bVar.oeQ));
                if (bVar.oeQ > 0) {
                    eVar.ohs = getString(com.tencent.mm.plugin.wxpay.a.i.uQS);
                }
                eVar.ohv = com.tencent.mm.plugin.luckymoney.b.n.EB(this.oeJ);
                try {
                    this.ogo.putExtra("key_detail_info", eVar.toByteArray());
                    bcj = bVar.oeL;
                    if (bcj != null) {
                        Parcelable realnameGuideHelper = new RealnameGuideHelper();
                        realnameGuideHelper.a(String.valueOf(bcj.vKC), bcj.oja, bcj.ojb, bcj.ojc, bcj.ojd, kVar.getType());
                        this.ogo.putExtra("key_realname_guide_helper", realnameGuideHelper);
                    }
                } catch (IOException e) {
                    x.e("LuckyMoneyF2FReceiveUI", "lucky detail toBytes error: " + e.getMessage());
                }
                if (!bi.G(this.oeH, this.oeJ)) {
                    com.tencent.mm.plugin.luckymoney.b.n.a((Context) this, this.off, com.tencent.mm.plugin.luckymoney.b.n.gv(this.oeJ));
                    com.tencent.mm.plugin.luckymoney.b.n.a((Context) this, this.ogk, this.oeP);
                    this.ogm.start();
                    this.mController.contentView.setVisibility(0);
                }
            }
            return true;
        }
        if (bVar.oeL != null) {
            x.i("LuckyMoneyF2FReceiveUI", "need real name verify");
            bcj = bVar.oeL;
            RealnameGuideHelper realnameGuideHelper2 = new RealnameGuideHelper();
            realnameGuideHelper2.a(String.valueOf(bcj.vKC), bcj.oja, bcj.ojb, bcj.ojc, bcj.ojd, kVar.getType());
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".f2f.ui.LuckyMoneyF2FReceiveUI");
            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
            DialogInterface.OnClickListener anonymousClass6 = new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    LuckyMoneyF2FReceiveUI.this.finish();
                }
            };
            AnonymousClass7 anonymousClass7 = new c.a() {
                public final Intent l(int i, Bundle bundle) {
                    LuckyMoneyF2FReceiveUI.this.finish();
                    return null;
                }
            };
            if (realnameGuideHelper2.a(this, bundle, anonymousClass6, false)) {
                this.ogp = true;
                return true;
            }
        }
        if (bi.oN(str)) {
            str = getString(com.tencent.mm.plugin.wxpay.a.i.uQB);
        }
        h.a((Context) this, str, "", new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                LuckyMoneyF2FReceiveUI.this.finish();
            }
        });
        return true;
    }
}
