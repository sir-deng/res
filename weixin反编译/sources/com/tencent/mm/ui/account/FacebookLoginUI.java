package com.tencent.mm.ui.account;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.iz;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.f.a.d;
import com.tencent.mm.y.as;
import com.tencent.mm.y.be;
import com.tencent.wcdb.database.SQLiteDatabase;

public class FacebookLoginUI extends MMPreference implements e {
    private String fJB = "";
    private OnCancelListener kbY;
    private String pXN;
    private c xWF;
    private String xWG = "";
    private v xWH;
    private b xWI;
    boolean xWJ = true;
    private ProgressDialog xWb;
    private com.tencent.mm.sdk.b.c xWw = new com.tencent.mm.sdk.b.c<iz>() {
        {
            this.xmG = iz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            iz izVar = (iz) bVar;
            if (izVar == null || izVar.fAw == null) {
                return false;
            }
            x.i("MicroMsg.FacebookLoginUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", izVar.fAw.content, izVar.fAw.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", izVar.fAw.content);
            intent.putExtra("key_disaster_url", izVar.fAw.url);
            intent.setClass(ad.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ad.getContext().startActivity(intent);
            return true;
        }
    };

    private final class a implements com.tencent.mm.ui.f.a.c.a {
        private a() {
        }

        /* synthetic */ a(FacebookLoginUI facebookLoginUI, byte b) {
            this();
        }

        public final void k(Bundle bundle) {
            FacebookLoginUI.this.xWb = ProgressDialog.show(FacebookLoginUI.this, FacebookLoginUI.this.getString(R.l.dGZ), FacebookLoginUI.this.getString(R.l.eeq), true);
            FacebookLoginUI.this.xWb.setOnCancelListener(FacebookLoginUI.this.kbY);
            FacebookLoginUI.this.xWG = FacebookLoginUI.this.xWF.ytm;
            x.i("MicroMsg.FacebookLoginUI", "dkwt Ready to Facebook auth user[%s] token[%d][%s]", "facebook@wechat_auth", Integer.valueOf(FacebookLoginUI.this.xWG.length()), FacebookLoginUI.this.xWG.substring(0, 4));
            FacebookLoginUI.this.xWH = new v("facebook@wechat_auth", FacebookLoginUI.this.xWG, 0, "", "", "", 0, "", true, false);
            as.CN().a(FacebookLoginUI.this.xWH, 0);
            FacebookLoginUI.mi(true);
            com.tencent.mm.plugin.c.b.pa(as.CI() + "," + FacebookLoginUI.this.getClass().getName() + ",L14," + as.fJ("L14") + ",2");
            g.pWK.a(582, 6, 1, false);
        }

        public final void a(d dVar) {
            x.d("MicroMsg.FacebookLoginUI", "onFacebookError:" + dVar.zle);
            h.b(FacebookLoginUI.this, dVar.getMessage(), FacebookLoginUI.this.getString(R.l.dVe), true);
            FacebookLoginUI.mi(false);
            com.tencent.mm.plugin.c.b.pa(as.CI() + "," + FacebookLoginUI.this.getClass().getName() + ",L14," + as.fJ("L14") + ",2");
            g.pWK.a(582, 7, 1, false);
        }

        public final void a(com.tencent.mm.ui.f.a.b bVar) {
            x.d("MicroMsg.FacebookLoginUI", "onError:" + bVar.getMessage());
            h.b(FacebookLoginUI.this, bVar.getMessage(), FacebookLoginUI.this.getString(R.l.dVe), true);
            FacebookLoginUI.mi(false);
            com.tencent.mm.plugin.c.b.pa(as.CI() + "," + FacebookLoginUI.this.getClass().getName() + ",L14," + as.fJ("L14") + ",2");
            g.pWK.a(582, 8, 1, false);
        }

        public final void onCancel() {
            x.d("MicroMsg.FacebookLoginUI", "onCancel");
            FacebookLoginUI.mi(false);
            com.tencent.mm.plugin.c.b.pa(as.CI() + "," + FacebookLoginUI.this.getClass().getName() + ",L14," + as.fJ("L14") + ",2");
            g.pWK.a(582, 9, 1, false);
        }
    }

    static /* synthetic */ void mi(boolean z) {
        int i = z ? 19 : 20;
        as.Hk().set(i, Integer.valueOf(bi.a((Integer) as.Hk().get(i), 0) + 1));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.app_name);
        com.tencent.mm.plugin.c.a.ihO.uq();
        this.pXN = com.tencent.mm.plugin.c.b.Xw();
        initView();
        as.CN().a(701, (e) this);
    }

    protected void onDestroy() {
        super.onDestroy();
        as.CN().b(701, (e) this);
    }

    protected void onResume() {
        com.tencent.mm.sdk.b.a.xmy.b(this.xWw);
        super.onResume();
        com.tencent.mm.plugin.c.b.b(true, as.CI() + "," + getClass().getName() + ",L100_200_FB," + as.fJ("L100_200_FB") + ",1");
        com.tencent.mm.plugin.c.b.oY("L100_200_FB");
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.xmy.c(this.xWw);
        com.tencent.mm.plugin.c.b.b(false, as.CI() + "," + getClass().getName() + ",L100_200_FB," + as.fJ("L100_200_FB") + ",2");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        com.tencent.mm.plugin.c.b.oZ(this.pXN);
        finish();
    }

    private void coA() {
        try {
            if (this.xWF != null) {
                this.xWF.fZ(this);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FacebookLoginUI", e, "", new Object[0]);
        }
        com.tencent.mm.plugin.c.b.pa(as.CI() + "," + getClass().getName() + ",L14," + as.fJ("L14") + ",1");
        this.xWF = new c("290293790992170");
        this.xWF.a((Activity) this, FacebookAuthUI.xWt, new a());
        g.pWK.a(582, 5, 1, false);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FacebookLoginUI", "dkwt onSceneEnd: hash:%d type:%d [%d,%d,%s]", Integer.valueOf(kVar.hashCode()), Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.xWb != null) {
            this.xWb.dismiss();
            this.xWb = null;
        }
        if (bi.bF(this) && (kVar instanceof v)) {
            boolean z;
            this.fJB = ((v) kVar).Sf();
            if (kVar.getType() == 701 && i == 4 && (i2 == -16 || i2 == -17)) {
                as.CN().a(new be(new com.tencent.mm.y.be.a() {
                    public final void a(com.tencent.mm.network.e eVar) {
                        if (eVar != null) {
                            com.tencent.mm.network.c KD = eVar.KD();
                            byte[] bArr = new byte[0];
                            as.Hm();
                            KD.v(bArr, com.tencent.mm.y.c.Cn());
                        }
                    }
                }), 0);
                z = true;
            } else {
                z = false;
            }
            if (z || (i == 0 && i2 == 0)) {
                as.unhold();
                m.oJ("");
                com.tencent.mm.modelsimple.d.bq(this);
                m.a(this, new Runnable() {
                    public final void run() {
                        as.Hm();
                        Intent at;
                        if ((bi.a((Integer) com.tencent.mm.y.c.Db().get(65833, null), 0) > 0 ? 1 : 0) != 0) {
                            at = com.tencent.mm.plugin.c.a.ihN.at(FacebookLoginUI.this);
                            at.addFlags(67108864);
                            Intent intent = new Intent(FacebookLoginUI.this.mController.xRr, BindMContactIntroUI.class);
                            intent.putExtra("key_upload_scene", 1);
                            MMWizardActivity.b(FacebookLoginUI.this, intent, at);
                        } else {
                            at = com.tencent.mm.plugin.c.a.ihN.at(FacebookLoginUI.this);
                            at.addFlags(67108864);
                            FacebookLoginUI.this.startActivity(at);
                            com.tencent.mm.plugin.c.b.pa(as.CI() + "," + FacebookLoginUI.this.getClass().getName() + ",L14," + as.fJ("L14") + ",4");
                        }
                        FacebookLoginUI.this.finish();
                    }
                }, false, 2);
            } else if (i2 == -106) {
                m.c(this, str, 0);
            } else if (i2 == -217) {
                m.a(this, com.tencent.mm.pluginsdk.a.a.a((v) kVar), i2);
            } else if (i2 == -6 || i2 == -311 || i2 == -310) {
                if (this.xWI == null) {
                    this.xWI = new b() {
                        public final k a(k kVar, String str) {
                            return new v("facebook@wechat_auth", FacebookLoginUI.this.xWG, ((v) kVar).Sg(), str, ((v) kVar).Ov(), ((v) kVar).Sh(), 0, "", true, false);
                        }
                    };
                }
                SecurityImage.b bVar = this.xWI;
                byte[] Ou = ((v) kVar).Ou();
                bVar.xVU = kVar;
                if (bVar.xSF == null) {
                    bVar.xSF = com.tencent.mm.ui.applet.SecurityImage.a.a(this, R.l.eEv, 0, Ou, "", "", new com.tencent.mm.ui.account.b.AnonymousClass1(this), null, new OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                            b.this.xSF = null;
                        }
                    }, bVar);
                } else {
                    bVar.xSF.a(0, Ou, "", "");
                }
            } else {
                if (i == 4) {
                    switch (i2) {
                        case -107:
                            h.h(this.mController.xRr, R.l.eeH, R.l.dGZ);
                            z = true;
                            break;
                        case -75:
                            m.bE(this.mController.xRr);
                            z = true;
                            break;
                        case -72:
                            h.h(this.mController.xRr, R.l.eEo, R.l.dGZ);
                            z = true;
                            break;
                        case -30:
                            if (com.tencent.mm.protocal.d.vHo) {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", this.fJB);
                                intent.putExtra("showShare", false);
                                intent.putExtra("show_bottom", false);
                                intent.putExtra("needRedirect", false);
                                intent.putExtra("neverGetA8Key", true);
                                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
                                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
                                com.tencent.mm.plugin.c.a.ihN.j(intent, this);
                            }
                            z = true;
                            break;
                        case -9:
                            h.h(this, R.l.etI, R.l.etJ);
                            z = true;
                            break;
                        case -7:
                            h.h(this.mController.xRr, R.l.eeG, R.l.dGZ);
                            z = true;
                            break;
                        case -1:
                            if (as.CN().Ks() == 5) {
                                h.h(this, R.l.exT, R.l.exS);
                                z = true;
                                break;
                            }
                        case -4:
                        case -3:
                            h.h(this, R.l.ecw, R.l.etJ);
                            z = true;
                            break;
                    }
                }
                z = com.tencent.mm.plugin.c.a.ihO.a(this.mController.xRr, i, i2, str);
                if (!z) {
                    if (kVar.getType() == 701) {
                        com.tencent.mm.g.a eC = com.tencent.mm.g.a.eC(str);
                        if (eC != null && eC.a(this, null, null)) {
                            return;
                        }
                    }
                    Toast.makeText(this, getString(R.l.eiB, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        }
    }

    protected final void initView() {
        this.xWF = new c("290293790992170");
        this.kbY = new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (FacebookLoginUI.this.xWH != null) {
                    as.CN().c(FacebookLoginUI.this.xWH);
                }
            }
        };
        coA();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FacebookLoginUI.this.goBack();
                return true;
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        String str = "MicroMsg.FacebookLoginUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        x.i(str, str2, objArr);
        if (i2 == -1 && i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.FacebookLoginUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(bi.oN(stringExtra));
            if (!bi.oN(stringExtra)) {
                i3 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i3);
            objArr2[2] = Integer.valueOf(intExtra);
            x.i(str2, str3, objArr2);
            if (intExtra == -217) {
                coA();
                return;
            }
        }
        this.xWF.f(i, i2, intent);
    }

    public final int XK() {
        return R.o.fca;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.idX;
        if (str == null) {
            x.e("MicroMsg.FacebookLoginUI", "onPreferenceTreeClick, key is null");
            return true;
        } else if (!str.equals("facebook_auth_bind_btn")) {
            return false;
        } else {
            coA();
            return true;
        }
    }
}
