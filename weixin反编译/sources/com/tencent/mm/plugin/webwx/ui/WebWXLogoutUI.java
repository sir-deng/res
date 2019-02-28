package com.tencent.mm.plugin.webwx.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.qy;
import com.tencent.mm.j.f;
import com.tencent.mm.modelsimple.am;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.ao;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;

@a(3)
public class WebWXLogoutUI extends MMActivity implements e, ao {
    private boolean kNs;
    private ProgressDialog qob = null;
    private c rcw = new c<qy>() {
        {
            this.xmG = qy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            qy qyVar = (qy) bVar;
            x.d("MicroMsg.WebWXLogoutUI", "status Notify function");
            if (qyVar.fJC.fvo == 8) {
                WebWXLogoutUI.this.finish();
            }
            return false;
        }
    };
    private boolean tUY = false;
    private boolean tVe;
    private ImageButton tVf;
    private ImageButton tVg;
    private ImageView tVh;
    private int tVi;
    private int tVj;
    private int tVk;
    private Animator tVl;
    private int tVm;

    static /* synthetic */ boolean b(WebWXLogoutUI webWXLogoutUI) {
        if (!as.Hp()) {
            return false;
        }
        int Ge = q.Ge();
        Ge = webWXLogoutUI.tVe ? Ge | 8192 : Ge & -8193;
        f.fS(Ge);
        as.Hm();
        com.tencent.mm.y.c.Db().set(40, Integer.valueOf(Ge));
        webWXLogoutUI.tUY = true;
        webWXLogoutUI.alq();
        return true;
    }

    static /* synthetic */ void e(WebWXLogoutUI webWXLogoutUI) {
        if (webWXLogoutUI.kNs) {
            as.CN().a(new com.tencent.mm.plugin.webwx.a.b(2), 0);
            x.d("MicroMsg.WebWXLogoutUI", "doScene netSceneExtDeviceControl : UNLOCK");
            return;
        }
        as.CN().a(new com.tencent.mm.plugin.webwx.a.b(1), 0);
        x.d("MicroMsg.WebWXLogoutUI", "doScene netSceneExtDeviceControl : LOCK");
    }

    static /* synthetic */ boolean f(WebWXLogoutUI webWXLogoutUI) {
        if (webWXLogoutUI.tVm == com.tencent.mm.modelsimple.q.Sa()) {
            h.a(webWXLogoutUI.mController.xRr, com.tencent.mm.modelsimple.q.hPa, webWXLogoutUI.getString(R.l.dGZ), webWXLogoutUI.getString(R.l.eXA), webWXLogoutUI.getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    final k amVar = new am(1);
                    as.CN().a(amVar, 0);
                    WebWXLogoutUI webWXLogoutUI = WebWXLogoutUI.this;
                    Context context = WebWXLogoutUI.this.mController.xRr;
                    WebWXLogoutUI.this.getString(R.l.dGZ);
                    webWXLogoutUI.qob = h.a(context, null, true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            as.CN().c(amVar);
                            if (WebWXLogoutUI.this.qob != null) {
                                WebWXLogoutUI.this.qob.cancel();
                            }
                        }
                    });
                }
            }, null);
        } else {
            webWXLogoutUI.finish();
        }
        return true;
    }

    static /* synthetic */ int g(WebWXLogoutUI webWXLogoutUI) {
        int[] iArr = new int[2];
        View findViewById = webWXLogoutUI.findViewById(R.h.cZk);
        int height = findViewById.getHeight();
        findViewById.getLocationInWindow(iArr);
        int i = iArr[1];
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            webWXLogoutUI.getWindowManager().getDefaultDisplay().getRealSize(point);
        } else {
            webWXLogoutUI.getWindowManager().getDefaultDisplay().getSize(point);
        }
        x.d("MicroMsg.WebWXLogoutUI", "statusbarheight:%d,screenheight:%d,actionbarheight:%d", Integer.valueOf(i), Integer.valueOf(point.y), Integer.valueOf(height));
        return (((int) (((double) point.y) / 4.0d)) - i) - height;
    }

    protected final int getLayoutId() {
        return R.i.dut;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.a.bpQ, R.a.bqm);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        if (getIntent() != null) {
            this.tVm = getIntent().getIntExtra("intent.key.online_version", 0);
        }
        initView();
        overridePendingTransition(R.a.bqo, R.a.bpQ);
        as.CN().a(281, (e) this);
        as.CN().a(792, (e) this);
        as.Hm();
        com.tencent.mm.y.c.a(this);
        com.tencent.mm.sdk.b.a.xmy.b(this.rcw);
    }

    protected void onPause() {
        super.onPause();
        if (this.tUY && as.Hp()) {
            com.tencent.mm.bp.a wuVar = new wu();
            wuVar.wnP = 27;
            wuVar.wnQ = q.gM(q.Ge()) ? 1 : 2;
            as.Hm();
            com.tencent.mm.y.c.Fe().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(23, wuVar));
            this.tUY = false;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        overridePendingTransition(R.a.bpQ, R.a.bqm);
        as.CN().b(281, (e) this);
        as.CN().b(792, (e) this);
        as.Hm();
        com.tencent.mm.y.c.b(this);
        com.tencent.mm.sdk.b.a.xmy.c(this.rcw);
    }

    protected final void initView() {
        setMMTitle("");
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.e.btT));
        }
        if (com.tencent.mm.j.a.zv()) {
            this.tVg = (ImageButton) findViewById(R.h.cZa);
            if (q.gM(q.Ge())) {
                this.tVe = true;
            } else {
                this.tVe = false;
            }
            kL(this.tVe);
            this.tVg.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    WebWXLogoutUI.this.tVe = !WebWXLogoutUI.this.tVe;
                    WebWXLogoutUI.this.kL(WebWXLogoutUI.this.tVe);
                    WebWXLogoutUI.b(WebWXLogoutUI.this);
                }
            });
        } else {
            findViewById(R.h.bWk).setVisibility(8);
            this.tVe = false;
        }
        this.tVh = (ImageView) findViewById(R.h.cPw);
        x.d("MicroMsg.WebWXLogoutUI", "need hide lock bt ?: " + com.tencent.mm.modelsimple.q.Sb());
        if (com.tencent.mm.modelsimple.q.Sb()) {
            findViewById(R.h.cuk).setVisibility(8);
        } else {
            final Animator loadAnimator = AnimatorInflater.loadAnimator(this, R.b.bqL);
            loadAnimator.setTarget(findViewById(R.h.cZf));
            this.tVl = AnimatorInflater.loadAnimator(this, R.b.bqM);
            this.tVl.setTarget(findViewById(R.h.cZf));
            this.tVl.addListener(new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    WebWXLogoutUI.this.kK(WebWXLogoutUI.this.kNs);
                }
            });
            this.kNs = com.tencent.mm.modelsimple.q.RZ();
            this.tVf = (ImageButton) findViewById(R.h.cZd);
            kK(this.kNs);
            this.tVf.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (WebWXLogoutUI.this.kNs) {
                        WebWXLogoutUI.this.tVf.setImageResource(R.k.dye);
                    } else {
                        WebWXLogoutUI.this.tVf.setImageResource(R.k.dyd);
                    }
                    WebWXLogoutUI.e(WebWXLogoutUI.this);
                    WebWXLogoutUI.this.findViewById(R.h.cZf).setVisibility(0);
                    loadAnimator.start();
                }
            });
        }
        ImageButton imageButton = (ImageButton) findViewById(R.h.cZb);
        x.d("MicroMsg.WebWXLogoutUI", "need hide file bt ?: " + com.tencent.mm.modelsimple.q.Sc());
        if (com.tencent.mm.modelsimple.q.Sc()) {
            imageButton.setVisibility(8);
        } else {
            imageButton.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", "filehelper");
                    intent.putExtra("key_show_bottom_app_panel", true);
                    com.tencent.mm.plugin.webwx.a.ihN.e(intent, WebWXLogoutUI.this);
                    x.d("MicroMsg.WebWXLogoutUI", "clicked file transfer bt, start filehelper");
                    WebWXLogoutUI.this.finish();
                }
            });
        }
        Button button = (Button) findViewById(R.h.cZl);
        button.setText(com.tencent.mm.modelsimple.q.hPd);
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                x.d("MicroMsg.WebWXLogoutUI", "logout webwx");
                WebWXLogoutUI.f(WebWXLogoutUI.this);
            }
        });
        ((TextView) findViewById(R.h.cZm)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                WebWXLogoutUI.this.finish();
            }
        });
        Drawable drawable;
        Drawable drawable2;
        if (com.tencent.mm.modelsimple.q.RX() == 1) {
            drawable = getResources().getDrawable(R.k.dyk);
            drawable2 = getResources().getDrawable(R.k.dyl);
            if (!(drawable == null || drawable2 == null)) {
                this.tVi = drawable.getIntrinsicWidth();
                this.tVj = drawable2.getIntrinsicWidth();
            }
        } else if (com.tencent.mm.modelsimple.q.RX() == 2) {
            drawable = getResources().getDrawable(R.k.dyg);
            drawable2 = getResources().getDrawable(R.k.dyi);
            if (!(drawable == null || drawable2 == null)) {
                this.tVi = drawable.getIntrinsicWidth();
                this.tVj = drawable2.getIntrinsicWidth();
            }
        }
        this.tVh.post(new Runnable() {
            public final void run() {
                WebWXLogoutUI.this.tVk = WebWXLogoutUI.g(WebWXLogoutUI.this);
                WebWXLogoutUI.this.alq();
            }
        });
    }

    private void alq() {
        if (!bi.oN(com.tencent.mm.modelsimple.q.hOV)) {
            ((TextView) findViewById(R.h.cPv)).setText(com.tencent.mm.modelsimple.q.hOV);
            if (com.tencent.mm.modelsimple.q.RX() == 1) {
                if (!this.tVe) {
                    this.tVh.setImageResource(R.k.dyl);
                    this.tVh.setPadding(this.tVj - this.tVi, this.tVk, 0, 0);
                    return;
                }
            } else if (com.tencent.mm.modelsimple.q.RX() == 2) {
                if (this.tVe) {
                    ((TextView) findViewById(R.h.cEl)).setText(R.l.eXD);
                } else if (!com.tencent.mm.j.a.zv()) {
                    ((TextView) findViewById(R.h.cEl)).setText("");
                }
                if (this.kNs) {
                    ((TextView) findViewById(R.h.cPv)).setText(getString(R.l.eXt, new Object[]{"Mac"}));
                    this.tVh.setImageResource(R.k.dyh);
                    this.tVh.setPadding(0, this.tVk, 0, 0);
                    if (com.tencent.mm.j.a.zv() && !this.tVe) {
                        ((TextView) findViewById(R.h.cEl)).setText(R.l.eXs);
                        this.tVh.setImageResource(R.k.dyj);
                        this.tVh.setPadding(this.tVj - this.tVi, this.tVk, 0, 0);
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.h.cPv)).setText(getString(R.l.eXv, new Object[]{"Mac"}));
                this.tVh.setImageResource(R.k.dyg);
                this.tVh.setPadding(0, this.tVk, 0, 0);
                if (com.tencent.mm.j.a.zv() && !this.tVe) {
                    ((TextView) findViewById(R.h.cEl)).setText(R.l.eXs);
                    this.tVh.setImageResource(R.k.dyi);
                    this.tVh.setPadding(this.tVj - this.tVi, this.tVk, 0, 0);
                    return;
                }
                return;
            } else if (com.tencent.mm.modelsimple.q.RX() == 3) {
                this.tVh.setImageResource(R.k.dyf);
                this.tVh.setPadding(0, this.tVk, 0, 0);
                return;
            }
            this.tVh.setImageResource(R.k.dyk);
            this.tVh.setPadding(0, this.tVk, 0, 0);
        }
    }

    private void kK(boolean z) {
        if (this.tVf == null) {
            return;
        }
        if (z) {
            this.tVf.setImageResource(R.g.bHV);
            ((TextView) findViewById(R.h.cZe)).setText(R.l.eXE);
            return;
        }
        this.tVf.setImageResource(R.g.bHT);
        ((TextView) findViewById(R.h.cZe)).setText(R.l.cZd);
    }

    private void kL(boolean z) {
        if (this.tVg == null) {
            return;
        }
        if (z) {
            this.tVg.setImageResource(R.g.bHS);
        } else {
            this.tVg.setImageResource(R.g.bHU);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.qob != null) {
            this.qob.dismiss();
            this.qob = null;
        }
        if (kVar.getType() == 281) {
            if (!(i == 0 && i2 == 0)) {
                Toast.makeText(this, R.l.eXB, 1).show();
            }
            finish();
        } else if (kVar.getType() == 792) {
            int i3 = ((com.tencent.mm.plugin.webwx.a.b) kVar).fvo;
            if (this.tVl != null) {
                this.tVl.start();
            }
            if (i == 0 && i2 == 0) {
                boolean z;
                if (i3 == 1) {
                    z = true;
                } else {
                    z = false;
                }
                this.kNs = z;
                com.tencent.mm.modelsimple.q.bV(this.kNs);
                alq();
                String str2 = "MicroMsg.WebWXLogoutUI";
                String str3 = "%s extDevice success";
                Object[] objArr = new Object[1];
                objArr[0] = this.kNs ? "lock" : "unlock";
                x.d(str2, str3, objArr);
            } else if (i3 == 1) {
                Toast.makeText(this, R.l.eXu, 0).show();
            } else {
                Toast.makeText(this, R.l.eXF, 0).show();
            }
        }
    }

    public final void Hd() {
        as.Hm();
        if (!com.tencent.mm.y.c.Fa()) {
            finish();
        } else if (com.tencent.mm.modelsimple.q.RZ() && !this.kNs) {
            x.d("MicroMsg.WebWXLogoutUI", "extDevice remote lock");
            this.kNs = true;
            kK(this.kNs);
            alq();
        }
    }
}
