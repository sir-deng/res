package com.tencent.mm.plugin.setting.ui.setting;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.ja;
import com.tencent.mm.f.a.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.am;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.setting.modelsimple.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.b;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.ar;
import com.tencent.mm.y.as;
import com.tencent.mm.y.br;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@a(19)
public class SettingsSwitchAccountUI extends MMActivity implements e {
    private SwitchAccountGridView qmU;
    private String qmX;
    private Map<String, SwitchAccountModel> qmZ = new HashMap();
    private boolean qpD;
    private TextView qrf;
    private TextView qrg;
    private View qrh;
    private View qri;
    private TextView qrj;
    private ValueAnimator qrk;
    private al qrl;
    private boolean qrm;
    private boolean qrn;
    private int scene;
    private TextView titleView;

    static /* synthetic */ void a(SettingsSwitchAccountUI settingsSwitchAccountUI, String str) {
        x.i("MicroMsg.SettingsSwitchAccountUI", "switch to %s, current %s", str, settingsSwitchAccountUI.qmX);
        if (str.equals(settingsSwitchAccountUI.qmX)) {
            settingsSwitchAccountUI.finish();
            return;
        }
        logout();
        ad.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putString("last_switch_account_to_wx_username", str).commit();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        Intent intent;
        setMMTitle("");
        cnK();
        getSupportActionBar().hide();
        this.scene = getIntent().getIntExtra("key_scene", 0);
        this.qrh = findViewById(R.h.cPW);
        this.qri = findViewById(R.h.cPU);
        this.titleView = (TextView) findViewById(R.h.cPV);
        this.qrj = (TextView) findViewById(R.h.cPR);
        this.qrf = (TextView) findViewById(R.h.cPS);
        this.qrg = (TextView) findViewById(R.h.cPQ);
        this.qmU = (SwitchAccountGridView) findViewById(R.h.cPT);
        this.qmU.setRowCount(1);
        this.qmU.qti = new b() {
            public final void JG(String str) {
                if (bi.oN(str)) {
                    ad.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putString("last_switch_account_to_wx_username", "").commit();
                    if (SettingsSwitchAccountUI.this.scene == 0) {
                        SettingsSwitchAccountUI.logout();
                        return;
                    }
                    Intent intent = new Intent(SettingsSwitchAccountUI.this, MobileInputUI.class);
                    intent.putExtra("mobile_input_purpose", 1);
                    intent.putExtra("from_switch_account", true);
                    SettingsSwitchAccountUI.this.startActivity(intent);
                    com.tencent.mm.ui.base.b.fF(SettingsSwitchAccountUI.this);
                } else if (SettingsSwitchAccountUI.this.scene == 0) {
                    SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, str);
                } else {
                    SettingsSwitchAccountUI.this.JF(str);
                }
            }
        };
        if (this.scene == 0) {
            this.qrg.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    SettingsSwitchAccountUI.this.goBack();
                }
            });
        } else {
            this.qrg.setVisibility(8);
        }
        Set<String> Ib = br.hju.Ib();
        this.qmX = ar.hhz.H("login_weixin_username", "");
        x.i("MicroMsg.SettingsSwitchAccountUI", "scene %d， lastLoginWxUsername %s", Integer.valueOf(this.scene), this.qmX);
        if (bi.oN(this.qmX) || Ib.contains(this.qmX)) {
            if (!Ib.isEmpty()) {
                for (String str : Ib) {
                    this.qmZ.put(str, new SwitchAccountModel(str, br.hju.getString(str, "login_user_name"), br.hju.getString(str, "last_avatar_path"), br.hju.getString(str, "last_logout_no_pwd_ticket"), bi.Wo(br.hju.getString(str, "last_login_use_voice"))));
                }
            }
        } else if (this.scene != 2 || br.hju.if(this.qmX)) {
            this.qmZ.put(this.qmX, new SwitchAccountModel(this.qmX, ar.hhz.H("login_user_name", ""), ar.hhz.He(), "", bi.Wo(ar.hhz.H("last_login_use_voice", ""))));
        }
        if (this.qmZ.size() == 0) {
            intent = new Intent(this, MobileInputUI.class);
            intent.putExtra("mobile_input_purpose", 1);
            intent.putExtra("can_finish", true);
            startActivity(intent);
            finish();
            com.tencent.mm.ui.base.b.fI(this);
        }
        N(this.qmZ);
        this.qmU.O(this.qmZ);
        if (this.scene == 1) {
            String string = ad.getContext().getSharedPreferences("switch_account_preferences", 0).getString("last_switch_account_to_wx_username", "");
            x.i("MicroMsg.SettingsSwitchAccountUI", "switch to %s", string);
            if (bi.oN(string)) {
                this.qrm = false;
                intent = new Intent(this, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 1);
                intent.putExtra("from_switch_account", true);
                startActivity(intent);
                com.tencent.mm.ui.base.b.fF(this);
            } else {
                g.Do();
                if (com.tencent.mm.kernel.a.CE()) {
                    x.w("MicroMsg.SettingsSwitchAccountUI", "already login ,quit");
                    finish();
                } else {
                    JF(string);
                }
            }
        } else if (this.scene == 0) {
            this.qmU.qmX = this.qmX;
        }
        this.qmU.brW();
        brF();
        this.qmU.qtk = new c() {
            public final void JH(final String str) {
                h.a(SettingsSwitchAccountUI.this, SettingsSwitchAccountUI.this.getString(R.l.eNA, new Object[]{((SwitchAccountModel) SettingsSwitchAccountUI.this.qmZ.get(str)).username}), SettingsSwitchAccountUI.this.getString(R.l.dGZ), SettingsSwitchAccountUI.this.getString(R.l.dHo), SettingsSwitchAccountUI.this.getString(R.l.dGc), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        x.i("MicroMsg.SettingsSwitchAccountUI", "delete %s", str);
                        SettingsSwitchAccountUI.this.qrn = true;
                        br.hju.ic(str);
                        SettingsSwitchAccountUI.this.qmZ.remove(str);
                        SwitchAccountGridView d = SettingsSwitchAccountUI.this.qmU;
                        String str = str;
                        if (d.qtf.contains(str)) {
                            int indexOf = d.qtf.indexOf(str);
                            d.qtf.remove(str);
                            d.qtg.remove(indexOf);
                            d.qth.remove(indexOf);
                        }
                        SettingsSwitchAccountUI.this.qmU.brW();
                        SettingsSwitchAccountUI.this.brF();
                        if (SettingsSwitchAccountUI.this.scene != 0) {
                            return;
                        }
                        if (br.hju.Ib().size() > 0) {
                            com.tencent.mm.plugin.report.service.g.pWK.h(14978, Integer.valueOf(1), Integer.valueOf(4));
                            return;
                        }
                        com.tencent.mm.plugin.report.service.g.pWK.h(14978, Integer.valueOf(0), Integer.valueOf(4));
                    }
                }, null);
            }
        };
        this.qrk = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.qrk.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SettingsSwitchAccountUI.this.qmU.setTranslationY((-((Float) valueAnimator.getAnimatedValue()).floatValue()) * ((float) SettingsSwitchAccountUI.this.qmU.getHeight()));
            }
        });
        this.qrk.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                x.i("MicroMsg.SettingsSwitchAccountUI", "up animation end");
                Intent at = com.tencent.mm.plugin.c.a.ihN.at(SettingsSwitchAccountUI.this);
                at.addFlags(67108864);
                SettingsSwitchAccountUI.this.startActivity(at);
                SettingsSwitchAccountUI.this.finish();
                com.tencent.mm.ui.base.b.fH(SettingsSwitchAccountUI.this);
            }
        });
        this.qrk.setDuration(500);
    }

    private static void N(Map<String, SwitchAccountModel> map) {
        if (map.size() == 2) {
            String[] strArr = new String[2];
            int i = 0;
            for (SwitchAccountModel switchAccountModel : map.values()) {
                int i2 = i + 1;
                strArr[i] = switchAccountModel.username;
                i = i2;
            }
            if (!bi.G(strArr[0], strArr[1]) && strArr[0].equals(strArr[1])) {
                for (String ic : map.keySet()) {
                    br.hju.ic(ic);
                }
                throw new NullPointerException(String.format("tow accounts have the same username!!! , %s, %s", new Object[]{strArr[0], strArr[1]}));
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void JF(String str) {
        SwitchAccountModel switchAccountModel = (SwitchAccountModel) this.qmZ.get(str);
        if (switchAccountModel != null && !this.qrm) {
            this.qrm = true;
            g.CN().a(new v(str, switchAccountModel.username, switchAccountModel.qmf, ""), 0);
            this.qmU.qtc = str;
            this.qmU.brW();
            brF();
        }
    }

    private void brF() {
        if (this.qrm) {
            this.qrf.setVisibility(8);
        } else if (this.qmZ.size() <= 1 && this.scene == 0) {
            this.qrf.setVisibility(8);
            this.qpD = false;
            this.qmU.qsZ = false;
        } else if (this.qpD) {
            this.titleView.setText(R.l.eNB);
            this.qrj.setVisibility(0);
            if (this.qrn) {
                this.qrf.setText(getString(R.l.dFw));
                this.qrf.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        SettingsSwitchAccountUI.this.qpD = false;
                        SettingsSwitchAccountUI.this.qrn = false;
                        SettingsSwitchAccountUI.this.qmU.qsZ = false;
                        SettingsSwitchAccountUI.this.qmU.brW();
                        SettingsSwitchAccountUI.this.brF();
                        if (SettingsSwitchAccountUI.this.qmU.qtf.size() == 0) {
                            if (br.hju.Ib().size() > 1) {
                                com.tencent.mm.plugin.report.service.g.pWK.h(14978, Integer.valueOf(1), Integer.valueOf(11));
                            } else {
                                com.tencent.mm.plugin.report.service.g.pWK.h(14978, Integer.valueOf(0), Integer.valueOf(11));
                            }
                            Intent at = com.tencent.mm.plugin.c.a.ihN.at(SettingsSwitchAccountUI.this);
                            at.addFlags(67108864);
                            SettingsSwitchAccountUI.this.startActivity(at);
                            SettingsSwitchAccountUI.this.finish();
                            com.tencent.mm.ui.base.b.fH(SettingsSwitchAccountUI.this);
                            SettingsSwitchAccountUI.this.qrm = false;
                        }
                    }
                });
                return;
            }
            this.qrf.setText(getString(R.l.dEy));
            this.qrf.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    SettingsSwitchAccountUI.this.qpD = false;
                    SettingsSwitchAccountUI.this.qrn = false;
                    SettingsSwitchAccountUI.this.qmU.qsZ = false;
                    SettingsSwitchAccountUI.this.qmU.brW();
                    SettingsSwitchAccountUI.this.brF();
                }
            });
        } else {
            this.titleView.setText(R.l.eND);
            this.qrj.setVisibility(8);
            this.qrf.setText(getString(R.l.eNB));
            this.qrf.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (!SettingsSwitchAccountUI.this.qpD) {
                        SettingsSwitchAccountUI.this.qpD = true;
                        SettingsSwitchAccountUI.this.qmU.qsZ = SettingsSwitchAccountUI.this.qpD;
                        SettingsSwitchAccountUI.this.qmU.brW();
                        SettingsSwitchAccountUI.this.brF();
                        if (br.hju.Ib().size() > 1) {
                            com.tencent.mm.plugin.report.service.g.pWK.h(14978, Integer.valueOf(1), Integer.valueOf(3));
                            return;
                        }
                        com.tencent.mm.plugin.report.service.g.pWK.h(14978, Integer.valueOf(0), Integer.valueOf(3));
                    }
                }
            });
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.scene == 1 || this.scene == 2) {
            g.CN().a(701, (e) this);
        }
        if (this.scene == 0) {
            g.CN().a(281, (e) this);
            g.CN().a(282, (e) this);
            g.CN().a(255, (e) this);
        }
        this.qmU.brW();
        brF();
        if (this.scene == 1 || this.scene == 2) {
            g.Do();
            if (com.tencent.mm.kernel.a.CE()) {
                this.qrm = true;
                Intent at = com.tencent.mm.plugin.c.a.ihN.at(this);
                at.addFlags(67108864);
                startActivity(at);
                finish();
                com.tencent.mm.ui.base.b.fH(this);
            }
        }
    }

    protected void onStop() {
        super.onStop();
        if (this.scene == 1) {
            SwitchAccountGridView switchAccountGridView = this.qmU;
            if (switchAccountGridView.qtd) {
                switchAccountGridView.qtd = false;
                if (switchAccountGridView.qte != null) {
                    switchAccountGridView.qte.end();
                }
            }
        }
        g.CN().b(701, (e) this);
        g.CN().b(281, (e) this);
        g.CN().b(282, (e) this);
        g.CN().b(255, (e) this);
    }

    public final void a(int r9, int r10, java.lang.String r11, com.tencent.mm.ad.k r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = "MicroMsg.SettingsSwitchAccountUI";
        r1 = "errCode %d, errMsg %s, scene %s, this %s";
        r2 = 4;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = java.lang.Integer.valueOf(r10);
        r2[r3] = r4;
        r3 = 1;
        r2[r3] = r11;
        r3 = 2;
        r2[r3] = r12;
        r3 = 3;
        r2[r3] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = r12.getType();
        r1 = 701; // 0x2bd float:9.82E-43 double:3.463E-321;
        if (r0 != r1) goto L_0x00e0;
    L_0x0024:
        if (r9 != 0) goto L_0x0112;
    L_0x0026:
        if (r10 != 0) goto L_0x0112;
    L_0x0028:
        r0 = r8.qrh;
        r1 = 4;
        r0.setVisibility(r1);
        r0 = r8.qri;
        r1 = 4;
        r0.setVisibility(r1);
        r0 = r8.qmU;
        r1 = r0.qtd;
        if (r1 != 0) goto L_0x00aa;
    L_0x003a:
        r1 = r0.qte;
        if (r1 != 0) goto L_0x009e;
    L_0x003e:
        r1 = r0.qtc;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 != 0) goto L_0x009e;
    L_0x0046:
        r1 = 2;
        r2 = r0.qtf;
        r2 = r2.size();
        r1 = java.lang.Math.min(r1, r2);
        r2 = 2;
        r2 = new float[r2];
        r2 = {0, 1065353216};
        r2 = android.animation.ValueAnimator.ofFloat(r2);
        r3 = new com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView$4;
        r3.<init>(r1);
        r2.addUpdateListener(r3);
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r2.setDuration(r4);
        r3 = 2;
        r3 = new float[r3];
        r3 = {0, 1065353216};
        r3 = android.animation.ValueAnimator.ofFloat(r3);
        r4 = new com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView$5;
        r4.<init>(r1);
        r2.addUpdateListener(r4);
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r3.setDuration(r4);
        r1 = new android.animation.AnimatorSet;
        r1.<init>();
        r0.qte = r1;
        r1 = r0.qte;
        r4 = new com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView$6;
        r4.<init>();
        r1.addListener(r4);
        r1 = r0.qte;
        r4 = 2;
        r4 = new android.animation.Animator[r4];
        r5 = 0;
        r4[r5] = r2;
        r2 = 1;
        r4[r2] = r3;
        r1.playSequentially(r4);
    L_0x009e:
        r1 = r0.qte;
        if (r1 == 0) goto L_0x00aa;
    L_0x00a2:
        r1 = 1;
        r0.qtd = r1;
        r0 = r0.qte;
        r0.start();
    L_0x00aa:
        com.tencent.mm.y.as.unhold();
        com.tencent.mm.modelsimple.d.bq(r8);
        r0 = com.tencent.mm.y.br.hju;
        r0 = r0.Ib();
        r0 = r0.size();
        r1 = 1;
        if (r0 <= r1) goto L_0x00f7;
    L_0x00bd:
        r0 = com.tencent.mm.plugin.report.service.g.pWK;
        r1 = 14978; // 0x3a82 float:2.0989E-41 double:7.4E-320;
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.h(r1, r2);
    L_0x00d7:
        r0 = r8.qmU;
        r1 = new com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI$10;
        r1.<init>();
        r0.qtj = r1;
    L_0x00e0:
        r0 = r12.getType();
        r1 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r0 != r1) goto L_0x0233;
    L_0x00e8:
        r12 = (com.tencent.mm.modelsimple.x) r12;
        r0 = r12.hPA;
        r1 = 2;
        if (r0 != r1) goto L_0x00f6;
    L_0x00ef:
        if (r9 != 0) goto L_0x01c3;
    L_0x00f1:
        if (r10 != 0) goto L_0x01c3;
    L_0x00f3:
        r8.brG();
    L_0x00f6:
        return;
    L_0x00f7:
        r0 = com.tencent.mm.plugin.report.service.g.pWK;
        r1 = 14978; // 0x3a82 float:2.0989E-41 double:7.4E-320;
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.h(r1, r2);
        goto L_0x00d7;
    L_0x0112:
        r0 = r8.qmU;
        r1 = "";
        r0.qtc = r1;
        r0 = 0;
        r8.qrm = r0;
        r0 = com.tencent.mm.R.l.eNC;
        r0 = r8.getString(r0);
        com.tencent.mm.ui.base.h.bu(r8, r0);
        r0 = r12;
        r0 = (com.tencent.mm.modelsimple.v) r0;
        r1 = r0.hPq;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r0 != 0) goto L_0x0178;
    L_0x0130:
        r0 = r8.qmZ;
        r0 = r0.containsKey(r1);
        if (r0 == 0) goto L_0x0178;
    L_0x0138:
        r2 = new android.content.Intent;
        r2.<init>();
        r0 = r8.qmZ;
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.plugin.setting.modelsimple.SwitchAccountModel) r0;
        r3 = "MicroMsg.SettingsSwitchAccountUI";
        r4 = "wxID %s, plugSwitch: %d";
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r5[r6] = r1;
        r6 = 1;
        r7 = r0.qmg;
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
        r0 = r0.qmg;
        r3 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r0 = r0 & r3;
        if (r0 == 0) goto L_0x01a1;
    L_0x0164:
        r0 = com.tencent.mm.ui.account.LoginVoiceUI.class;
        r2.setClass(r8, r0);
    L_0x0169:
        r0 = "switch_login_wx_id";
        r2.putExtra(r0, r1);
        r8.startActivity(r2);
        r8.finish();
        com.tencent.mm.ui.base.b.fI(r8);
    L_0x0178:
        r0 = com.tencent.mm.y.br.hju;
        r0 = r0.Ib();
        r0 = r0.size();
        r1 = 1;
        if (r0 <= r1) goto L_0x01a7;
    L_0x0185:
        r0 = com.tencent.mm.plugin.report.service.g.pWK;
        r1 = 14978; // 0x3a82 float:2.0989E-41 double:7.4E-320;
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.h(r1, r2);
        goto L_0x00e0;
    L_0x01a1:
        r0 = com.tencent.mm.ui.account.LoginPasswordUI.class;
        r2.setClass(r8, r0);
        goto L_0x0169;
    L_0x01a7:
        r0 = com.tencent.mm.plugin.report.service.g.pWK;
        r1 = 14978; // 0x3a82 float:2.0989E-41 double:7.4E-320;
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.h(r1, r2);
        goto L_0x00e0;
    L_0x01c3:
        r0 = -3;
        if (r10 != r0) goto L_0x0229;
    L_0x01c6:
        r0 = 4;
        if (r9 != r0) goto L_0x0229;
    L_0x01c9:
        r0 = com.tencent.mm.y.br.hju;
        r0 = r0.Ib();
        r0 = r0.size();
        r1 = 1;
        if (r0 <= r1) goto L_0x020e;
    L_0x01d6:
        r0 = com.tencent.mm.plugin.report.service.g.pWK;
        r1 = 14978; // 0x3a82 float:2.0989E-41 double:7.4E-320;
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = 7;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.h(r1, r2);
    L_0x01f0:
        r0 = new android.content.Intent;
        r1 = r8.mController;
        r1 = r1.xRr;
        r2 = com.tencent.mm.ui.account.RegByMobileSetPwdUI.class;
        r0.<init>(r1, r2);
        r1 = "kintent_hint";
        r2 = com.tencent.mm.R.l.eEg;
        r2 = r8.getString(r2);
        r0.putExtra(r1, r2);
        r1 = 701; // 0x2bd float:9.82E-43 double:3.463E-321;
        r8.startActivityForResult(r0, r1);
        goto L_0x00f6;
    L_0x020e:
        r0 = com.tencent.mm.plugin.report.service.g.pWK;
        r1 = 14978; // 0x3a82 float:2.0989E-41 double:7.4E-320;
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = 7;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.h(r1, r2);
        goto L_0x01f0;
    L_0x0229:
        r0 = com.tencent.mm.plugin.setting.a.ihO;
        r0 = r0.a(r8, r9, r10, r11);
        if (r0 == 0) goto L_0x00f6;
    L_0x0231:
        goto L_0x00f6;
    L_0x0233:
        r0 = r12.getType();
        r1 = 282; // 0x11a float:3.95E-43 double:1.393E-321;
        if (r0 != r1) goto L_0x00f6;
    L_0x023b:
        com.tencent.mm.kernel.g.Do();
        r0 = com.tencent.mm.kernel.a.CE();
        if (r0 == 0) goto L_0x00f6;
    L_0x0244:
        r12 = (com.tencent.mm.modelsimple.u) r12;
        r0 = r12.gLB;
        r0 = r0.hnR;
        r0 = r0.hnY;
        r0 = (com.tencent.mm.protocal.c.apo) r0;
        r0 = r0.wDb;
        r1 = "MicroMsg.SettingsSwitchAccountUI";
        r2 = "logout return";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r1 == 0) goto L_0x0268;
    L_0x025f:
        r1 = "MicroMsg.SettingsSwitchAccountUI";
        r2 = "no pwd ticket is null!";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
    L_0x0268:
        r1 = com.tencent.mm.y.ar.hhz;
        r2 = "login_weixin_username";
        r3 = "";
        r1 = r1.H(r2, r3);
        r2 = com.tencent.mm.y.br.hju;
        r3 = "last_logout_no_pwd_ticket";
        r2.j(r1, r3, r0);
        r0 = r8.qrl;
        if (r0 == 0) goto L_0x00f6;
    L_0x0280:
        r0 = r8.qrl;
        r0 = r0.cgx();
        if (r0 != 0) goto L_0x00f6;
    L_0x0288:
        r0 = r8.qrl;
        r0.TN();
        r8.brH();
        goto L_0x00f6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.a(int, int, java.lang.String, com.tencent.mm.ad.k):void");
    }

    private void goBack() {
        if (this.scene == 2 || this.scene == 1) {
            Intent at = com.tencent.mm.plugin.c.a.ihN.at(this);
            at.addFlags(67108864);
            at.putExtra("can_finish", true);
            startActivity(at);
            finish();
            com.tencent.mm.ui.base.b.fH(this);
            this.qrm = false;
            return;
        }
        finish();
    }

    protected final int getLayoutId() {
        return R.i.dst;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 701 && i2 == -1) {
            brG();
        }
    }

    private static void logout() {
        if (!(as.CN() == null || as.CN().hoF == null)) {
            as.CN().hoF.bH(false);
        }
        Object[] objArr = new Object[1];
        as.Hm();
        objArr[0] = Integer.valueOf(com.tencent.mm.y.c.Cn());
        x.w("MicroMsg.SettingsSwitchAccountUI", "dklogout User LOGOUT Now uin:%d , clear cookie", objArr);
        com.tencent.mm.modelstat.c.SV().SW();
        k xVar = new com.tencent.mm.modelsimple.x(2);
        xVar.hPz = 1;
        as.CN().a(xVar, 0);
    }

    private void brG() {
        as.Hm();
        if (com.tencent.mm.y.c.Fa()) {
            as.CN().a(new am(2), 0);
        }
        as.CN().a(new u(), 0);
        this.qmU.qta = true;
        this.qmU.brW();
        if (this.qrl == null) {
            this.qrl = new al(Looper.getMainLooper(), new al.a() {
                public final boolean uG() {
                    SettingsSwitchAccountUI.this.brH();
                    return false;
                }
            }, false);
            this.qrl.K(8000, 8000);
        }
    }

    private void brH() {
        x.i("MicroMsg.SettingsSwitchAccountUI", "switch account logout");
        com.tencent.mm.plugin.setting.a.ihO.ut();
        com.tencent.mm.sdk.b.b jaVar = new ja();
        jaVar.fAx.status = 0;
        jaVar.fAx.aAk = 0;
        com.tencent.mm.sdk.b.a.xmy.m(jaVar);
        jaVar = new y();
        jaVar.foJ.foK = true;
        com.tencent.mm.sdk.b.a.xmy.m(jaVar);
        af.VJ("show_whatsnew");
        com.tencent.mm.kernel.k.e(this, true);
        d.B(this, null);
        if (g.Do().CF()) {
            Object iZ = com.tencent.mm.ac.b.iZ(q.FY());
            ar.hhz.hP(iZ);
            g.Dq().Db().a(w.a.USERINFO_LAST_LOGIN_AVATAR_PATH_STRING, iZ);
        }
        x.i("MicroMsg.SettingsSwitchAccountUI", "last login username in sp %s", ar.hhz.H("login_user_name", ""));
        Map GH = q.GH();
        if (bi.oN((String) GH.get("login_user_name"))) {
            GH.put("login_user_name", ar.hhz.H("login_user_name", ""));
        }
        br.hju.c(q.FY(), GH);
        ad.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", true).commit();
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Intro_Switch", true);
        intent.putExtra("key_transit_to_switch_account", true);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.qmZ.values());
        intent.putParcelableArrayListExtra("key_switch_account_users", arrayList);
        com.tencent.mm.plugin.setting.a.ihN.s(intent, this);
        finish();
        com.tencent.mm.ui.base.b.fI(this);
    }
}
