package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.c.a;
import com.tencent.mm.plugin.wallet_core.ui.p;
import com.tencent.mm.plugin.wallet_core.ui.p.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import org.json.JSONObject;

public class SwitchRealnameVerifyModeUI extends WalletBaseUI implements OnClickListener {
    private int hAP = 0;
    private p osg = new p();
    private boolean sOv = false;
    private TextView sPA;
    private TextView sPB;
    private TextView sPC;
    private TextView sPD;
    private TextView sPE;
    private TextView sPF;
    private String sPG;
    private String sPH;
    private String sPI;
    private boolean sPJ;
    private boolean sPK = false;
    private int sPu = 500;
    private long sPv = 0;
    private View sPw;
    private View sPx;
    private View sPy;
    private TextView sPz;

    public void onResume() {
        super.onResume();
        this.osg.onResume();
    }

    public void onPause() {
        super.onPause();
        this.osg.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.sPK = this.vf.getBoolean("key_from_set_pwd", false);
        initView();
        cCT();
        this.hAP = this.vf.getInt("entry_scene", this.hAP);
        e.a(13, bi.Wx(), this.hAP);
        if (this.sPK) {
            setMMTitle(i.vcf);
        }
        this.osg.tdo = new b() {
            public final int aYZ() {
                return 1;
            }

            public final Context getContext() {
                return SwitchRealnameVerifyModeUI.this;
            }
        };
    }

    protected final void initView() {
        setMMTitle(i.vce);
        this.sPw = findViewById(f.uDj);
        this.sPx = findViewById(f.uDk);
        this.sPy = findViewById(f.uDl);
        this.sPx.setOnClickListener(this);
        this.sPw.setOnClickListener(this);
        this.sPy.setOnClickListener(this);
        this.sPz = (TextView) findViewById(f.umg);
        this.sPA = (TextView) findViewById(f.umf);
        this.sPB = (TextView) findViewById(f.umj);
        this.sPC = (TextView) findViewById(f.umi);
        this.sPD = (TextView) findViewById(f.uqB);
        this.sPE = (TextView) findViewById(f.uDT);
        this.sPF = (TextView) findViewById(f.uDS);
        if (this.sPK) {
            ((TextView) findViewById(f.uDi)).setText(i.vcg);
        }
        jN(false);
        k bVar = new com.tencent.mm.plugin.wallet_core.id_verify.model.b();
        jl(1666);
        l(bVar);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                c cCT = SwitchRealnameVerifyModeUI.this.cCT();
                if (cCT != null) {
                    e.a(14, bi.Wx(), SwitchRealnameVerifyModeUI.this.hAP);
                    cCT.d(SwitchRealnameVerifyModeUI.this, 0);
                    return true;
                }
                SwitchRealnameVerifyModeUI.this.finish();
                return false;
            }
        });
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof a) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.pluginsdk.wallet.f.TF(((a) kVar).bLs());
                jm(580);
                ((a) kVar).biB();
                c cCT = cCT();
                if (cCT != null) {
                    Bundle bundle = cCT.mym;
                    bundle.putInt("real_name_verify_mode", 1);
                    com.tencent.mm.wallet_core.a.j(this, bundle);
                }
                return true;
            }
        } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.b) {
            jm(1666);
            jN(true);
            this.sOv = ((com.tencent.mm.plugin.wallet_core.id_verify.model.b) kVar).sOv;
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            return;
        }
        if (i2 == -1) {
            this.osg.aYX();
        } else {
            this.osg.cancel();
        }
    }

    protected final int getLayoutId() {
        return g.uMl;
    }

    public void onClick(final View view) {
        if (System.currentTimeMillis() - this.sPv <= ((long) this.sPu)) {
            x.e("MicroMsg.SwitchRealnameVerifyModeUI", "process pass");
            return;
        }
        this.sPv = System.currentTimeMillis();
        this.osg.a(new p.a() {
            public final void aYX() {
                SwitchRealnameVerifyModeUI.this.bJ(view);
                SwitchRealnameVerifyModeUI.this.sOv = false;
            }

            public final void cancel() {
                SwitchRealnameVerifyModeUI.this.osg.fpU = false;
            }

            public final void aYY() {
                SwitchRealnameVerifyModeUI.this.bJ(view);
            }
        }, this.sOv);
    }

    public final void bJ(View view) {
        int id = view.getId();
        final c cCT = cCT();
        if (cCT != null) {
            Bundle bundle = cCT.mym;
            if (id == f.uDj) {
                e.a(15, bi.Wx(), this.hAP);
                if (bundle.getInt("realname_scene") != 1) {
                    bundle.putInt("real_name_verify_mode", 1);
                } else if (getIntent() == null) {
                    String str = "";
                    if (bi.oN(str)) {
                        str = getString(i.vdG);
                    }
                    h.a((Context) this, str, null, false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            SwitchRealnameVerifyModeUI.this.finish();
                        }
                    });
                    return;
                } else {
                    jl(580);
                    r(new a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL), 8, "idCardRealnameVerify", getIntent().getIntExtra("pay_channel", 0)));
                    return;
                }
            } else if (id == f.uDk) {
                e.a(17, bi.Wx(), this.hAP);
                bundle.putInt("real_name_verify_mode", 2);
            } else if (id == f.uDl) {
                e.a(16, bi.Wx(), this.hAP);
                if (!this.sPJ || bi.oN(this.sPI)) {
                    bundle.putInt("real_name_verify_mode", 3);
                    bundle.putString("verify_card_flag", "1");
                } else {
                    h.a((Context) this, this.sPI, "", this.sPH, false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Bundle bundle = cCT.mym;
                            bundle.putInt("real_name_verify_mode", 3);
                            bundle.putString("verify_card_flag", "1");
                            com.tencent.mm.wallet_core.a.j(SwitchRealnameVerifyModeUI.this, bundle);
                        }
                    });
                    return;
                }
            }
            com.tencent.mm.wallet_core.a.j(this, bundle);
        }
    }

    private static JSONObject bLy() {
        com.tencent.mm.kernel.g.Dr();
        Object obj = com.tencent.mm.kernel.g.Dq().Db().get(w.a.USERINFO_WALLET_REALNAME_SWITCH_WORDING_STRING_SYNC, (Object) "");
        if (obj != null) {
            String str = (String) obj;
            if (!bi.oN(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    long j = jSONObject.getLong("timestamp");
                    long j2 = jSONObject.getLong("cache_time");
                    x.i("MicroMsg.SwitchRealnameVerifyModeUI", " dddd time=" + currentTimeMillis + ";timestamp=" + j + ";cachetime=" + j2);
                    if (currentTimeMillis - j <= j2) {
                        return jSONObject;
                    }
                    x.e("MicroMsg.SwitchRealnameVerifyModeUI", "wording data from cache is out of date");
                    return null;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SwitchRealnameVerifyModeUI", e, "", new Object[0]);
                    x.e("MicroMsg.SwitchRealnameVerifyModeUI", "parse wording data form cache error");
                    return null;
                }
            }
        }
        x.i("MicroMsg.SwitchRealnameVerifyModeUI", "cache is null");
        return null;
    }

    private boolean jN(boolean z) {
        JSONObject jSONObject;
        JSONObject bLy = bLy();
        if (z && bLy == null) {
            jSONObject = new JSONObject();
        } else {
            jSONObject = bLy;
        }
        if (jSONObject == null) {
            return z;
        }
        CharSequence aD = bi.aD(jSONObject.optString("cache_header_titles", getString(i.uUU)), getString(i.uUU));
        if (this.sPK) {
            ((TextView) findViewById(f.uDi)).setText(i.vcg);
        } else {
            ((TextView) findViewById(f.uDi)).setText(aD);
        }
        if (jSONObject.optBoolean("isShowBindCardVerify", false)) {
            this.sPE.setText(jSONObject.optString("bindCardVerifyTitle"));
            this.sPF.setText(jSONObject.optString("bindCardVerifySubtitle"));
            this.sPy.setVisibility(0);
        } else {
            this.sPy.setVisibility(8);
        }
        if (jSONObject.optBoolean("isShowBindCard", false)) {
            this.sPz.setText(jSONObject.optString("bindcardTitle", getString(i.uUV)));
            this.sPA.setText(jSONObject.optString("bindcardSubTitle", getString(i.uUW)));
            this.sPw.setVisibility(0);
        } else {
            this.sPw.setVisibility(8);
        }
        if (jSONObject.optBoolean("isShowBindId", false)) {
            this.sPB.setText(jSONObject.optString("bindIdTitle", getString(i.uUX)));
            this.sPC.setText(jSONObject.optString("bindIdSubTitle", getString(i.uUY)));
            this.sPx.setVisibility(0);
        } else {
            this.sPx.setVisibility(8);
        }
        this.sPH = jSONObject.optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.sPI = jSONObject.optString("bindCardVerifyAlertViewContent", "");
        this.sPJ = jSONObject.optBoolean("isShowBindCardVerifyAlertView", false);
        CharSequence optString = jSONObject.optString("extral_wording", "");
        if (bi.oN(optString)) {
            this.sPD.setVisibility(8);
        } else {
            this.sPD.setText(optString);
            this.sPD.setVisibility(0);
        }
        this.sPH = jSONObject.optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.sPI = jSONObject.optString("bindCardVerifyAlertViewContent");
        this.sPJ = jSONObject.optBoolean("isShowBindCardVerifyAlertView", false);
        boolean optBoolean = jSONObject.optBoolean("question_answer_switch", false);
        this.sPG = jSONObject.optString("question_answer_url", "");
        if (optBoolean && !bi.oN(this.sPG)) {
            addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.e.ukw, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    e.a(18, bi.Wx(), SwitchRealnameVerifyModeUI.this.hAP);
                    e.l(SwitchRealnameVerifyModeUI.this.mController.xRr, SwitchRealnameVerifyModeUI.this.sPG, false);
                    return true;
                }
            });
        }
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            c cCT = cCT();
            if (cCT != null) {
                e.a(14, bi.Wx(), this.hAP);
                cCT.d(this, 0);
                return true;
            }
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }
}
