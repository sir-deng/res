package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.luckymoney.b.ag;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.luckymoney.b.s;
import com.tencent.mm.plugin.luckymoney.b.t;
import com.tencent.mm.plugin.luckymoney.b.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;

@a(3)
public class LuckyMoneyBusiReceiveUI extends LuckyMoneyBaseUI {
    private ImageView ogl;
    private ImageView olX;
    private TextView omA;
    private TextView omB;
    private Button omC;
    private View omD;
    private View omE;
    private ImageView omF;
    private TextView omG;
    private View omH;
    private TextView omI;
    private Button omJ;
    private TextView omK;
    private CheckBox omL;
    private int omM;
    private String omN = null;
    private int omO = 0;
    private t omP;
    private RealnameGuideHelper omQ;
    private TextView omb;
    private String omj = null;
    private String oml = null;
    private int omn = 0;
    private TextView omz;
    private r tipDialog = null;

    static /* synthetic */ void i(LuckyMoneyBusiReceiveUI luckyMoneyBusiReceiveUI) {
        luckyMoneyBusiReceiveUI.b(new s(luckyMoneyBusiReceiveUI.omP.oeH, luckyMoneyBusiReceiveUI.omP.fMx, luckyMoneyBusiReceiveUI.omP.oix, luckyMoneyBusiReceiveUI.getIntent().getStringExtra("packageExt"), luckyMoneyBusiReceiveUI.getIntent().getStringExtra("key_username")), false);
        n.a(luckyMoneyBusiReceiveUI.omC);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oml = getIntent().getStringExtra("key_native_url");
        this.omM = getIntent().getIntExtra("key_way", 5);
        this.omn = getIntent().getIntExtra("key_static_from_scene", 0);
        x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "nativeurl=" + bi.oM(this.oml) + ", mWay=" + this.omM);
        init();
        g.pWK.h(11701, Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
        initView();
        jl(980);
    }

    private void init() {
        this.tipDialog = h.a(this.mController.xRr, getString(i.ctG), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (LuckyMoneyBusiReceiveUI.this.tipDialog != null && LuckyMoneyBusiReceiveUI.this.tipDialog.isShowing()) {
                    LuckyMoneyBusiReceiveUI.this.tipDialog.dismiss();
                }
                LuckyMoneyBusiReceiveUI.this.olU.aXI();
                if (LuckyMoneyBusiReceiveUI.this.mController.contentView.getVisibility() == 8 || LuckyMoneyBusiReceiveUI.this.mController.contentView.getVisibility() == 4) {
                    x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "user cancel & finish");
                    LuckyMoneyBusiReceiveUI.this.finish();
                }
            }
        });
        if (this.omM == 3) {
            b(new com.tencent.mm.plugin.luckymoney.b.r(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL)), false);
        } else if (this.omM == 4) {
            b(new com.tencent.mm.plugin.luckymoney.b.r(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("key_wxapi_sign"), getIntent().getStringExtra("key_wxapi_package_name")), false);
        } else {
            try {
                this.omj = Uri.parse(bi.oM(this.oml)).getQueryParameter("sendid");
            } catch (Exception e) {
            }
            if (bi.oN(this.omj)) {
                finish();
                x.w("MicroMsg.LuckyMoneyBusiReceiveUI", "sendid null & finish");
            } else {
                b(new t(this.omj, this.oml, this.omM, getIntent().getStringExtra("packageExt")), false);
            }
        }
        aw(0, "");
    }

    protected void onNewIntent(Intent intent) {
        if (intent != null && intent.hasExtra("key_is_realname_verify_process")) {
            if (intent.getIntExtra("realname_verify_process_ret", 0) == -1) {
                x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process succ");
                init();
                return;
            }
            x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process cancel");
            aw(-1, "");
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        jm(980);
    }

    protected final void initView() {
        this.omE = findViewById(f.uti);
        this.olX = (ImageView) findViewById(f.utm);
        this.omz = (TextView) findViewById(f.utn);
        this.omB = (TextView) findViewById(f.utj);
        this.omA = (TextView) findViewById(f.utq);
        this.omC = (Button) findViewById(f.utk);
        this.ogl = (ImageView) findViewById(f.utt);
        this.omD = findViewById(f.uth);
        this.omb = (TextView) findViewById(f.utg);
        this.omF = (ImageView) findViewById(f.utu);
        this.omG = (TextView) findViewById(f.uts);
        this.omH = findViewById(f.uto);
        this.omI = (TextView) findViewById(f.utp);
        this.omJ = (Button) findViewById(f.utv);
        this.omK = (TextView) findViewById(f.utl);
        this.omL = (CheckBox) findViewById(f.utw);
        this.ogl.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
                bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                if (LuckyMoneyBusiReceiveUI.this.omQ == null || !LuckyMoneyBusiReceiveUI.this.omQ.a(LuckyMoneyBusiReceiveUI.this, bundle, null, true)) {
                    LuckyMoneyBusiReceiveUI.this.finish();
                } else {
                    LuckyMoneyBusiReceiveUI.this.omQ = null;
                }
            }
        });
        uV(8);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        Intent intent;
        if (kVar instanceof t) {
            if (i == 0 && i2 == 0) {
                this.omP = (t) kVar;
                this.omj = this.omP.oeH;
                this.omO = this.omP.ohq;
                g.pWK.h(13050, Integer.valueOf(this.omn), Integer.valueOf(1), this.omP.oit);
                if (this.omP.fMz == 2) {
                    aw(-1, "");
                    b(new v(this.omj, 11, 0, this.oml, "v1.0"), false);
                } else {
                    if (this.tipDialog != null && this.tipDialog.isShowing()) {
                        this.tipDialog.hide();
                    }
                    n.a(this.olX, this.omP.oiy, true);
                    n.a(this.mController.xRr, this.omz, this.omP.oin);
                    n.h(this.omF, this.omP.ohK);
                    if (this.omP.fMz == 1 || this.omP.fMy == 4 || this.omP.fMy == 5 || this.omP.fMy == 1) {
                        g.pWK.h(11701, Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
                        this.omA.setVisibility(4);
                        this.omB.setText(this.omP.ohr);
                        this.omC.setVisibility(8);
                        if (this.omO == 1) {
                            this.omG.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    g.pWK.h(11701, Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4));
                                    Intent intent = new Intent();
                                    intent.setClass(LuckyMoneyBusiReceiveUI.this.mController.xRr, LuckyMoneyBusiDetailUI.class);
                                    intent.putExtra("key_native_url", LuckyMoneyBusiReceiveUI.this.oml);
                                    intent.putExtra("key_sendid", LuckyMoneyBusiReceiveUI.this.omP.oeH);
                                    intent.putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.this.omn);
                                    LuckyMoneyBusiReceiveUI.this.startActivity(intent);
                                    LuckyMoneyBusiReceiveUI.this.finish();
                                }
                            });
                            this.omG.setVisibility(0);
                        } else {
                            this.omG.setVisibility(8);
                        }
                    } else {
                        if (!bi.oN(this.omP.oit)) {
                            this.omN = this.omP.oit;
                            if (this.omP.oiu == 1) {
                                this.omL.setVisibility(8);
                            } else {
                                x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "show checkbox for " + this.omP.oit);
                                if (this.omP.oir == 1) {
                                    this.omL.setChecked(true);
                                } else {
                                    this.omL.setChecked(false);
                                }
                                this.omL.setText(this.omP.ois);
                            }
                        }
                        this.omC.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                g.pWK.h(11701, Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
                                if (LuckyMoneyBusiReceiveUI.this.omL.isChecked()) {
                                    g.pWK.h(13050, Integer.valueOf(LuckyMoneyBusiReceiveUI.this.omn), Integer.valueOf(2), LuckyMoneyBusiReceiveUI.this.omP.oit);
                                } else {
                                    g.pWK.h(13050, Integer.valueOf(LuckyMoneyBusiReceiveUI.this.omn), Integer.valueOf(2), "");
                                }
                                LuckyMoneyBusiReceiveUI.i(LuckyMoneyBusiReceiveUI.this);
                            }
                        });
                        if (bi.oN(this.omP.ohr)) {
                            this.omA.setVisibility(8);
                        } else {
                            this.omA.setText(this.omP.ohr);
                        }
                        if (bi.oN(this.omP.oiz)) {
                            this.omB.setVisibility(8);
                        } else {
                            this.omB.setText(this.omP.oiz);
                        }
                    }
                    n.a(this.omE, null);
                    this.mController.contentView.setVisibility(0);
                }
                return true;
            }
        } else if (kVar instanceof s) {
            n.c(this.omC);
            if (i == 0 && i2 == 0) {
                aw(-1, "");
                final s sVar = (s) kVar;
                if (sVar.fMz != 2) {
                    this.omA.setVisibility(4);
                    this.omB.setText(sVar.ohr);
                    this.omC.setVisibility(8);
                    if (this.omO == 1) {
                        this.omG.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                Intent intent = new Intent();
                                intent.setClass(LuckyMoneyBusiReceiveUI.this.mController.xRr, LuckyMoneyBusiDetailUI.class);
                                if (sVar.oiw != null) {
                                    intent.putExtra("key_realname_guide_helper", sVar.oiw);
                                }
                                intent.putExtra("key_native_url", LuckyMoneyBusiReceiveUI.this.oml);
                                intent.putExtra("key_sendid", sVar.oeH);
                                intent.putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.this.omn);
                                LuckyMoneyBusiReceiveUI.this.startActivity(intent);
                                LuckyMoneyBusiReceiveUI.this.finish();
                            }
                        });
                        this.omG.setVisibility(0);
                    } else {
                        this.omG.setVisibility(8);
                    }
                } else if (sVar.lon <= 1 || !(sVar.ohH == null || sVar.ohH.gGi == 1)) {
                    x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can not atomic go detail");
                    intent = new Intent();
                    intent.putExtra("key_sendid", sVar.oeH);
                    intent.putExtra("key_static_from_scene", this.omn);
                    if (sVar.oiw != null) {
                        intent.putExtra("key_realname_guide_helper", sVar.oiw);
                    }
                    try {
                        intent.putExtra("key_detail_info", sVar.oiv.toByteArray());
                        intent.putExtra("key_jump_from", 2);
                    } catch (IOException e) {
                        x.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e.getLocalizedMessage());
                    }
                    if (com.tencent.mm.j.g.Af().getInt("PlayCoinSound", 0) > 0) {
                        intent.putExtra("play_sound", true);
                    }
                    d.b(this.mController.xRr, "luckymoney", ".ui.LuckyMoneyBusiDetailUI", intent);
                    finish();
                    return true;
                } else {
                    CharSequence string;
                    final View findViewById = findViewById(f.utr);
                    Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-findViewById.getHeight()));
                    translateAnimation.setDuration(400);
                    translateAnimation.setFillAfter(true);
                    translateAnimation.setAnimationListener(new AnimationListener() {
                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            findViewById.setVisibility(8);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    findViewById.startAnimation(translateAnimation);
                    this.omb.setText(e.t(((double) sVar.fMM) / 100.0d));
                    this.omz.setText(sVar.oin);
                    this.omA.setVisibility(8);
                    this.omB.setVisibility(8);
                    this.omD.setVisibility(0);
                    this.omC.setVisibility(8);
                    if (bi.oN(sVar.oiq)) {
                        string = getString(i.uRw);
                    } else {
                        string = sVar.oiq;
                    }
                    this.omJ.setText(string);
                    this.omK.setVisibility(0);
                    g.pWK.h(11701, Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
                    x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "totalNum:" + sVar.lon);
                    if (sVar.lon > 1 || (sVar.ohH != null && sVar.ohH.gGi == 1)) {
                        x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can atomic");
                        this.omQ = sVar.oiw;
                        this.omJ.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                CharSequence string;
                                LuckyMoneyBusiReceiveUI.this.omE.setVisibility(4);
                                LuckyMoneyBusiReceiveUI.this.omK.setVisibility(8);
                                LuckyMoneyBusiReceiveUI.this.omD.setVisibility(8);
                                if (sVar.ohH == null || bi.oN(sVar.ohH.ohc)) {
                                    string = LuckyMoneyBusiReceiveUI.this.getString(i.uRx);
                                } else {
                                    string = sVar.ohH.ohc;
                                }
                                LuckyMoneyBusiReceiveUI.this.omJ.setText(string);
                                LuckyMoneyBusiReceiveUI.this.omI.setText(sVar.oio);
                                LuckyMoneyBusiReceiveUI.this.omH.setVisibility(0);
                                LuckyMoneyBusiReceiveUI.this.omJ.setOnClickListener(new OnClickListener() {
                                    public final void onClick(View view) {
                                        g.pWK.h(11701, Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
                                        n.a(LuckyMoneyBusiReceiveUI.this, 1, false);
                                    }
                                });
                                n.a(LuckyMoneyBusiReceiveUI.this.omE, new AnimationListener() {
                                    public final void onAnimationStart(Animation animation) {
                                        LuckyMoneyBusiReceiveUI.this.omE.setVisibility(0);
                                    }

                                    public final void onAnimationRepeat(Animation animation) {
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                    }
                                });
                            }
                        });
                    } else {
                        this.omJ.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                LuckyMoneyBusiReceiveUI.this.finish();
                            }
                        });
                    }
                    this.omJ.setVisibility(0);
                }
                return true;
            } else if (i2 == 416) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.hide();
                }
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
                bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                this.omC.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.uje);
                return n.a(this, i2, kVar, bundle, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, new c.a() {
                    public final Intent l(int i, Bundle bundle) {
                        x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "re");
                        return null;
                    }
                }, 1005);
            }
        } else if (kVar instanceof ag) {
            if (i == 0 && i2 == 0) {
                h.bu(this, getString(i.epo));
                g.pWK.h(11701, Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4));
                finish();
                return true;
            }
            h.bu(this, str);
            return true;
        } else if (kVar instanceof com.tencent.mm.plugin.luckymoney.b.r) {
            if (i == 0 && i2 == 0) {
                l(new t(this.omj, this.oml, this.omM, getIntent().getStringExtra("packageExt")));
                return true;
            }
        } else if (kVar instanceof o) {
            return true;
        } else {
            if (kVar instanceof v) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.hide();
                }
                if (i == 0 && i2 == 0) {
                    v vVar = (v) kVar;
                    intent = new Intent();
                    intent.setClass(this.mController.xRr, LuckyMoneyBusiDetailUI.class);
                    try {
                        intent.putExtra("key_detail_info", vVar.oiv.toByteArray());
                        intent.putExtra("key_jump_from", 2);
                    } catch (IOException e2) {
                        x.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e2.getLocalizedMessage());
                    }
                    intent.putExtra("key_native_url", this.oml);
                    intent.putExtra("key_sendid", this.omj);
                    intent.putExtra("key_static_from_scene", this.omn);
                    startActivity(intent);
                    finish();
                    return true;
                }
            }
        }
        if (!(i == 0 && i2 == 0)) {
            aw(2, str);
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    g.pWK.h(11701, Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), stringExtra);
                    if (!bi.oN(stringExtra)) {
                        l(new ag(stringExtra, this.omj, "v1.0"));
                        break;
                    }
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uIO;
    }

    private void aw(int i, String str) {
        x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "markResult resultCode:%d errMsg:%s", Integer.valueOf(i), str);
        Intent intent = new Intent();
        intent.putExtra("key_result_errmsg", str);
        setResult(i, intent);
    }
}
