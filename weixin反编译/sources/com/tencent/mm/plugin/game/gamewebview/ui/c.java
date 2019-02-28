package com.tencent.mm.plugin.game.gamewebview.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.widget.b;
import com.tencent.mm.plugin.game.widget.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends FrameLayout {
    private b nec;
    private b ned;
    b<b> nee;
    private GameWebViewUI nef;
    private Intent neg;
    private long neh;

    static /* synthetic */ void a(c cVar, b bVar) {
        if (bVar != null) {
            x.d("MicroMsg.GameWebPageContainer", "bringToFront begin : %d", Long.valueOf(System.currentTimeMillis() - cVar.neh));
            bVar.bringToFront();
            x.d("MicroMsg.GameWebPageContainer", "bringToFront end : %d", Long.valueOf(System.currentTimeMillis() - cVar.neh));
            cVar.requestLayout();
            cVar.invalidate();
            bVar.aeJ();
            Runnable anonymousClass6 = new Runnable() {
                public final void run() {
                    x.d("MicroMsg.GameWebPageContainer", "anim end : %d", Long.valueOf(System.currentTimeMillis() - c.this.neh));
                    c.this.postDelayed(new Runnable() {
                        public final void run() {
                            c.d(c.this);
                        }
                    }, 500);
                }
            };
            Animator ofFloat = ObjectAnimator.ofFloat(bVar, "translationX", new float[]{(float) bVar.getWidth(), 0.0f});
            ofFloat.setDuration(200);
            cVar.a(ofFloat, anonymousClass6);
        }
    }

    static /* synthetic */ void a(c cVar, b bVar, final b bVar2, boolean z) {
        if (bVar2 != null && bVar != null) {
            if (z) {
                Runnable anonymousClass8;
                Animator ofFloat;
                if (bVar2.mSwiping) {
                    cVar.a(bVar2);
                } else {
                    anonymousClass8 = new Runnable() {
                        public final void run() {
                            c.this.a(bVar2);
                        }
                    };
                    ofFloat = ObjectAnimator.ofFloat(bVar2, "translationX", new float[]{0.0f, (float) bVar2.getWidth()});
                    ofFloat.setDuration(200);
                    cVar.a(ofFloat, anonymousClass8);
                }
                bVar.aeJ();
                if (!bVar2.mSwiping) {
                    anonymousClass8 = new Runnable() {
                        public final void run() {
                        }
                    };
                    ofFloat = ObjectAnimator.ofFloat(bVar, "translationX", new float[]{-(((float) bVar.getWidth()) * 0.25f), 0.0f});
                    ofFloat.setDuration(200);
                    cVar.a(ofFloat, anonymousClass8);
                    return;
                }
                return;
            }
            cVar.a(bVar2);
            bVar.aeJ();
        }
    }

    static /* synthetic */ void a(c cVar, final b bVar, final boolean z, final boolean z2) {
        if (bVar != null) {
            if (z) {
                cVar.nee.remove(bVar);
            }
            Runnable anonymousClass5 = new Runnable() {
                public final void run() {
                    if (z2) {
                        bVar.fz(true);
                        bVar.hide();
                    }
                    if (z) {
                        c.this.a(bVar);
                    }
                }
            };
            ObjectAnimator.ofFloat(bVar, "translationX", new float[]{0.0f, -(((float) bVar.getWidth()) * 0.25f)}).setDuration(200);
            ObjectAnimator.ofFloat(bVar, "translationX", new float[]{0.0f}).setDuration(0);
            Animator animatorSet = new AnimatorSet();
            animatorSet.playSequentially(new Animator[]{r1, r2});
            cVar.a(animatorSet, anonymousClass5);
        }
    }

    static /* synthetic */ void d(c cVar) {
        cVar.ned = new b(cVar.nef, cVar);
        cVar.addView(cVar.ned, 0);
    }

    public c(final GameWebViewUI gameWebViewUI) {
        super(gameWebViewUI);
        this.nef = gameWebViewUI;
        this.nee = new b(new a() {
            public final void aPI() {
                gameWebViewUI.rb(c.this.nee.size());
            }

            public final void aPJ() {
                gameWebViewUI.rb(c.this.nee.size());
            }
        });
    }

    public final void cleanup() {
        while (!this.nee.isEmpty()) {
            ((b) this.nee.pop()).aeI();
        }
        if (this.ned != null) {
            this.ned.aeI();
        }
    }

    public final void c(Intent intent, boolean z) {
        this.neg = intent;
        String stringExtra = intent.getStringExtra("rawUrl");
        if (!bi.oN(stringExtra)) {
            b bVar = (b) this.nee.peek();
            if (bVar != null && bi.oM(bVar.nco.ndH).equals(stringExtra)) {
                bVar.vf.putBoolean("is_from_keep_top", aPF());
            } else if (!aPF() || this.nec == null) {
                View view;
                Object obj = (z || !intent.getBooleanExtra("needAnimation", true)) ? null : 1;
                x.d("MicroMsg.GameWebPageContainer", "createPage start : " + System.currentTimeMillis());
                this.neh = System.currentTimeMillis();
                View view2;
                if (this.ned != null) {
                    view2 = this.ned;
                    this.ned = null;
                    view = view2;
                } else {
                    x.d("MicroMsg.GameWebPageContainer", "createPage begin: " + System.currentTimeMillis());
                    view2 = new b(this.nef, this);
                    x.d("MicroMsg.GameWebPageContainer", "createPage end: " + System.currentTimeMillis());
                    view = view2;
                }
                Bundle extras = this.neg.getExtras();
                view.vf = extras;
                d aPC = view.aPC();
                aPC.vf = extras;
                aPC.nev.nbR = aPC.aPL();
                aPC.gBJ = aPC.vf.getString("geta8key_username");
                aPC.nfa = aPC.vf.getString("KPublisherId");
                aPC.scene = aPC.vf.getInt("geta8key_scene", 0);
                aPC.neZ = d.aq(aPC.scene, aPC.gBJ);
                aPC.neT = aPC.vf.getBoolean("neverGetA8Key", false);
                aPC.nfe = aPC.vf.getString("game_hv_menu_appid");
                x.d("MicroMsg.GameWebPageContainer", "LoadUrl begin : %d", Long.valueOf(System.currentTimeMillis() - this.neh));
                x.d("MicroMsg.GameWebPage", "loadUrl, url = %s, pageViewId = %d, this = %d", stringExtra, Integer.valueOf(view.nco.hashCode()), Integer.valueOf(view.hashCode()));
                d dVar = view.nco;
                if (bi.oN(stringExtra)) {
                    x.e("MicroMsg.GameWebPageView", "rawUrl is null");
                } else {
                    x.d("MicroMsg.GameWebPageView", "loadUrl, rawUrl = %s, this = %d", stringExtra, Integer.valueOf(dVar.hashCode()));
                    g.pWK.a(611, 1, 1, false);
                    dVar.ndH = stringExtra;
                    dVar.neI = new com.tencent.mm.plugin.webview.wepkg.a(dVar.nef, dVar.new, dVar.new.hashCode());
                    dVar.neI.tRR = new com.tencent.mm.plugin.webview.wepkg.a.a() {
                        public final boolean aQe() {
                            return d.this.nfd;
                        }
                    };
                    dVar.neI.Qs(dVar.ndH);
                    if (dVar.neI.Qt(dVar.ndH)) {
                        dVar.neB.setVisibility(0);
                    }
                    dVar.aPK();
                }
                x.d("MicroMsg.GameWebPageContainer", "LoadUrl end : %d", Long.valueOf(System.currentTimeMillis() - this.neh));
                bVar = (b) this.nee.peek();
                this.nee.push(view);
                if (obj != null) {
                    x.d("MicroMsg.GameWebPageContainer", "addView start : %d", Long.valueOf(System.currentTimeMillis() - this.neh));
                    if (view.getParent() == null) {
                        addView(view, 0);
                    }
                    x.d("MicroMsg.GameWebPageContainer", "addView end : %d", Long.valueOf(System.currentTimeMillis() - this.neh));
                    final boolean[] zArr = new boolean[]{false};
                    final Runnable anonymousClass2 = new Runnable() {
                        public final void run() {
                            boolean z = true;
                            x.i("MicroMsg.GameWebPageContainer", "loadUrl costTime = %d", Long.valueOf(System.currentTimeMillis() - c.this.neh));
                            if (!zArr[0]) {
                                zArr[0] = true;
                                synchronized (c.this) {
                                    if (bVar != null) {
                                        c cVar = c.this;
                                        b bVar = bVar;
                                        boolean booleanExtra = c.this.neg.getBooleanExtra("finish_recent_page", false);
                                        if (c.this.neg.getBooleanExtra("transparent_page", false)) {
                                            z = false;
                                        }
                                        c.a(cVar, bVar, booleanExtra, z);
                                    }
                                    c.a(c.this, view);
                                }
                            }
                        }
                    };
                    view.nco.neX = new b.a() {
                        public final void akx() {
                            x.d("MicroMsg.GameWebPageContainer", "onLoadFinish, costTime = %d", Long.valueOf(System.currentTimeMillis() - c.this.neh));
                            if (!zArr[0]) {
                                x.d("MicroMsg.GameWebPageContainer", "removeCallback, %d", Integer.valueOf(anonymousClass2.hashCode()));
                                c.this.removeCallbacks(anonymousClass2);
                                c.this.post(anonymousClass2);
                            }
                        }
                    };
                    x.d("MicroMsg.GameWebPageContainer", "post : %d", Long.valueOf(System.currentTimeMillis() - this.neh));
                    postDelayed(anonymousClass2, 300);
                    return;
                }
                addView(view);
                view.aeJ();
            } else {
                while (!this.nee.isEmpty()) {
                    a((b) this.nee.pop());
                }
                if (this.nec.getParent() == null) {
                    addView(this.nec);
                }
                this.nec.aeJ();
                this.nee.push(this.nec);
            }
        }
    }

    public final void fA(final boolean z) {
        if (this.nee.size() <= 1) {
            this.nef.finish();
            return;
        }
        Runnable anonymousClass4 = new Runnable() {
            public final void run() {
                b bVar = (b) c.this.nee.peek();
                c.a(c.this, bVar, (b) c.this.nee.pop(), z);
            }
        };
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            anonymousClass4.run();
        } else {
            post(anonymousClass4);
        }
    }

    final void a(b bVar) {
        if (bVar != null) {
            bVar.fz(false);
            bVar.setVisibility(8);
            removeView(bVar);
            if (bVar != this.nec) {
                bVar.aeI();
                return;
            }
            Animator ofFloat = ObjectAnimator.ofFloat(bVar, "translationX", new float[]{0.0f});
            ofFloat.setDuration(0);
            a(ofFloat, null);
        }
    }

    private void a(Animator animator, final Runnable runnable) {
        animator.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        animator.start();
    }

    private boolean aPF() {
        return this.neg.getBooleanExtra("is_from_keep_top", false);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        b bVar = (b) this.nee.peek();
        if (bVar != null) {
            if (bVar.nco.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (i == 4 && bVar.nco.aPV()) {
                return true;
            }
        }
        return false;
    }

    public final void b(b bVar) {
        x.d("MicroMsg.GameWebPageContainer", "keepPageTop");
        if (this.nec != bVar) {
            if (this.nec != null && !this.nee.contains(this.nec)) {
                this.nec.aeI();
            } else if (this.nec != null) {
                this.nec.aPE();
            }
            this.nec = bVar;
        }
    }

    public final void aPH() {
        x.d("MicroMsg.GameWebPageContainer", "cancelPageTop");
        if (this.nec != null && !this.nee.contains(this.nec)) {
            this.nec.aeI();
        } else if (this.nec != null) {
            this.nec.aPE();
        }
        this.nec = null;
    }
}
