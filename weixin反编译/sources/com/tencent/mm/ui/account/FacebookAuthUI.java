package com.tencent.mm.ui.account;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ax.i;
import com.tencent.mm.f.a.iz;
import com.tencent.mm.modelsimple.g;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.f.a.d;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacebookAuthUI extends MMPreference implements e {
    public static final String[] xWt = new String[]{"publish_actions", "email"};
    private f inW;
    private final Map<String, Preference> kIf = new HashMap();
    private OnCancelListener kbY;
    private c xWa;
    private ProgressDialog xWb;
    private g xWc;
    private boolean xWu = false;
    private boolean xWv = false;
    private com.tencent.mm.sdk.b.c xWw = new com.tencent.mm.sdk.b.c<iz>() {
        {
            this.xmG = iz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            iz izVar = (iz) bVar;
            if (izVar == null || izVar.fAw == null) {
                return false;
            }
            x.i("MicroMsg.FacebookAuthUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", izVar.fAw.content, izVar.fAw.url);
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

        /* synthetic */ a(FacebookAuthUI facebookAuthUI, byte b) {
            this();
        }

        public final void k(Bundle bundle) {
            x.d("MicroMsg.FacebookAuthUI", "token:" + FacebookAuthUI.this.xWa.ytm);
            as.Hm();
            com.tencent.mm.y.c.Db().set(65830, FacebookAuthUI.this.xWa.ytm);
            if (FacebookAuthUI.this.xWa.zkX != 0) {
                as.Hm();
                com.tencent.mm.y.c.Db().set(65832, Long.valueOf(FacebookAuthUI.this.xWa.zkX));
            }
            FacebookAuthUI.this.xWb = ProgressDialog.show(FacebookAuthUI.this, FacebookAuthUI.this.getString(R.l.dGZ), FacebookAuthUI.this.getString(R.l.eeq), true);
            FacebookAuthUI.this.xWb.setOnCancelListener(FacebookAuthUI.this.kbY);
            FacebookAuthUI.this.xWc = new g(1, FacebookAuthUI.this.xWa.ytm);
            as.CN().a(FacebookAuthUI.this.xWc, 0);
            FacebookAuthUI.mh(true);
            com.tencent.mm.plugin.report.service.g.pWK.a(582, 1, 1, false);
        }

        public final void a(d dVar) {
            x.d("MicroMsg.FacebookAuthUI", "onFacebookError:" + dVar.zle);
            h.b(FacebookAuthUI.this, dVar.getMessage(), FacebookAuthUI.this.getString(R.l.dVe), true);
            FacebookAuthUI.mh(false);
            com.tencent.mm.plugin.report.service.g.pWK.a(582, 2, 1, false);
        }

        public final void a(com.tencent.mm.ui.f.a.b bVar) {
            x.d("MicroMsg.FacebookAuthUI", "onError:" + bVar.getMessage());
            h.b(FacebookAuthUI.this, bVar.getMessage(), FacebookAuthUI.this.getString(R.l.dVe), true);
            FacebookAuthUI.mh(false);
            com.tencent.mm.plugin.report.service.g.pWK.a(582, 3, 1, false);
        }

        public final void onCancel() {
            x.d("MicroMsg.FacebookAuthUI", "onCancel");
            FacebookAuthUI.mh(false);
            com.tencent.mm.plugin.report.service.g.pWK.a(582, 4, 1, false);
        }
    }

    static /* synthetic */ void mh(boolean z) {
        List arrayList = new ArrayList();
        arrayList.add(new com.tencent.mm.ax.i.a(32, z ? "0" : "1"));
        as.Hm();
        com.tencent.mm.y.c.Fe().b(new i(arrayList));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.inW = this.yrJ;
        initView();
    }

    protected void onResume() {
        com.tencent.mm.sdk.b.a.xmy.b(this.xWw);
        super.onResume();
        as.CN().a(183, (e) this);
        as.CN().a((int) com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE, (e) this);
        coz();
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.xmy.c(this.xWw);
        as.CN().b(183, (e) this);
        as.CN().b((int) com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE, (e) this);
    }

    public final int XK() {
        return R.o.fbZ;
    }

    protected final void initView() {
        this.xWu = getIntent().getBooleanExtra("is_force_unbind", false);
        this.xWa = new c("290293790992170");
        this.kbY = new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (FacebookAuthUI.this.xWc != null) {
                    as.CN().c(FacebookAuthUI.this.xWc);
                }
            }
        };
        this.inW.addPreferencesFromResource(R.o.fbZ);
        Preference Zu = this.inW.Zu("facebook_auth_tip");
        if (Zu != null) {
            this.kIf.put("facebook_auth_tip", Zu);
        }
        Zu = this.inW.Zu("facebook_auth_cat");
        if (Zu != null) {
            this.kIf.put("facebook_auth_cat", Zu);
        }
        Zu = this.inW.Zu("facebook_auth_bind_btn");
        if (Zu != null) {
            this.kIf.put("facebook_auth_bind_btn", Zu);
        }
        Zu = this.inW.Zu("facebook_auth_account");
        if (Zu != null) {
            this.kIf.put("facebook_auth_account", Zu);
        }
        Zu = this.inW.Zu("facebook_auth_cat2");
        if (Zu != null) {
            this.kIf.put("facebook_auth_cat2", Zu);
        }
        Zu = this.inW.Zu("facebook_auth_unbind_btn");
        if (Zu != null) {
            this.kIf.put("facebook_auth_unbind_btn", Zu);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = FacebookAuthUI.this.getIntent();
                intent.putExtra("bind_facebook_succ", FacebookAuthUI.this.xWv);
                FacebookAuthUI.this.setResult(-1, intent);
                FacebookAuthUI.this.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.idX;
        if (str == null) {
            x.e("MicroMsg.FacebookAuthUI", "onPreferenceTreeClick, key is null");
            return true;
        } else if (str.equals("facebook_auth_bind_btn")) {
            try {
                this.xWa.fZ(this);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FacebookAuthUI", e, "", new Object[0]);
            }
            this.xWa = new c("290293790992170");
            this.xWa.a((Activity) this, xWt, new a());
            return true;
        } else if (!str.equals("facebook_auth_unbind_btn")) {
            return false;
        } else {
            h.a((Context) this, R.l.eeu, R.l.dGZ, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    FacebookAuthUI.this.xWb = ProgressDialog.show(FacebookAuthUI.this, FacebookAuthUI.this.getString(R.l.dGZ), FacebookAuthUI.this.getString(R.l.eew), true);
                    FacebookAuthUI.this.xWb.setOnCancelListener(FacebookAuthUI.this.kbY);
                    as.CN().a(new com.tencent.mm.modelsimple.h(com.tencent.mm.modelsimple.h.hOw), 0);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return true;
        }
    }

    private void coz() {
        Preference preference;
        this.inW.removeAll();
        boolean Gz = this.xWu ? false : q.Gz();
        if (this.kIf.containsKey("facebook_auth_tip")) {
            preference = (Preference) this.kIf.get("facebook_auth_tip");
            preference.setTitle(Gz ? R.l.eev : R.l.eep);
            this.inW.a(preference);
        }
        if (this.kIf.containsKey("facebook_auth_cat")) {
            this.inW.a((Preference) this.kIf.get("facebook_auth_cat"));
        }
        if (Gz) {
            if (this.kIf.containsKey("facebook_auth_account")) {
                preference = (Preference) this.kIf.get("facebook_auth_account");
                StringBuilder append = new StringBuilder().append(getString(R.l.eer));
                as.Hm();
                preference.setTitle(append.append(com.tencent.mm.y.c.Db().get(65826, null)).toString());
                this.inW.a(preference);
            }
            if (this.kIf.containsKey("facebook_auth_cat2")) {
                this.inW.a((Preference) this.kIf.get("facebook_auth_cat2"));
            }
            if (this.kIf.containsKey("facebook_auth_unbind_btn")) {
                this.inW.a((Preference) this.kIf.get("facebook_auth_unbind_btn"));
            }
        } else if (this.kIf.containsKey("facebook_auth_bind_btn")) {
            this.inW.a((Preference) this.kIf.get("facebook_auth_bind_btn"));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = "MicroMsg.FacebookAuthUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        x.i(str, str2, objArr);
        if (i2 == -1 && i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.FacebookAuthUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(bi.oN(stringExtra));
            objArr2[1] = Integer.valueOf(bi.oN(stringExtra) ? 0 : stringExtra.length());
            objArr2[2] = Integer.valueOf(intExtra);
            x.i(str2, str3, objArr2);
            if (intExtra == -217) {
                try {
                    this.xWa.fZ(this);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FacebookAuthUI", e, "", new Object[0]);
                }
                this.xWa = new c("290293790992170");
                this.xWa.a((Activity) this, xWt, new a());
                return;
            }
        }
        this.xWa.f(i, i2, intent);
    }

    public final void a(int i, int i2, String str, k kVar) {
        com.tencent.mm.g.a eC;
        if (kVar.getType() == com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE) {
            if (i == 0 && i2 == 0) {
                this.xWc = new g(0, "");
                as.CN().a(this.xWc, 0);
                return;
            }
            if (this.xWb != null) {
                this.xWb.dismiss();
            }
            if (i2 == -82) {
                h.a((Context) this, R.l.eKO, R.l.dGZ, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -83) {
                h.a((Context) this, R.l.eKL, R.l.dGZ, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -84) {
                h.a((Context) this, R.l.eKM, R.l.dGZ, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -85) {
                h.a((Context) this, R.l.eKK, R.l.dGZ, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -86) {
                h.a((Context) this, R.l.eKP, R.l.dGZ, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -106) {
                m.c(this, str, 0);
            } else if (i2 == -217) {
                m.a(this, com.tencent.mm.pluginsdk.a.a.a((v) kVar), i2);
            } else {
                eC = com.tencent.mm.g.a.eC(str);
                if (eC != null) {
                    eC.a(this, null, null);
                }
            }
        } else if (kVar.getType() == 183) {
            if (this.xWb != null) {
                this.xWb.dismiss();
            }
            int i3 = ((g) kVar).opType;
            if (i == 0 && i2 == 0) {
                Toast.makeText(this, i3 == 0 ? R.l.dVi : R.l.dVf, 1).show();
                this.xWu = false;
                coz();
                if (i3 == 1) {
                    as.Hm();
                    com.tencent.mm.y.c.Fk().XE("facebookapp");
                    as.Hm();
                    com.tencent.mm.y.c.Fh().Fj("facebookapp");
                    this.xWv = true;
                }
            } else if (i == 4 && i2 == -67) {
                Toast.makeText(this, R.l.ees, 1).show();
            } else if (i == 4 && i2 == -5) {
                Toast.makeText(this, i3 == 1 ? R.l.eeo : R.l.eet, 1).show();
            } else if (i2 == -106) {
                m.c(this, str, 0);
            } else {
                eC = com.tencent.mm.g.a.eC(str);
                if (eC != null) {
                    eC.a(this, null, null);
                } else {
                    Toast.makeText(this, i3 == 0 ? R.l.dVh : R.l.dVe, 1).show();
                }
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Intent intent = getIntent();
            intent.putExtra("bind_facebook_succ", this.xWv);
            setResult(-1, intent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
