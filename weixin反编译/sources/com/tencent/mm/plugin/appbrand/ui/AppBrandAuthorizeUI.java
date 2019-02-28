package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.q.m;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.protocal.c.art;
import com.tencent.mm.protocal.c.cce;
import com.tencent.mm.protocal.c.ccf;
import com.tencent.mm.protocal.c.cco;
import com.tencent.mm.protocal.c.ccp;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.statusbar.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppBrandAuthorizeUI extends MMPreference {
    private String jPV;
    List<dy> jPW = new ArrayList();
    private t jPX;
    protected f jPY;
    private boolean jPZ = false;
    private boolean jQa = true;
    private boolean jQb = false;
    private b jQc = null;
    private String mAppId;

    static /* synthetic */ void a(AppBrandAuthorizeUI appBrandAuthorizeUI, String str) {
        a aVar = new a();
        aVar.hnT = new cce();
        aVar.hnU = new ccf();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp_getauthinfo";
        aVar.hnS = 1196;
        aVar.hnV = 0;
        aVar.hnW = 0;
        com.tencent.mm.bp.a cce = new cce();
        cce.appId = str;
        aVar.hnT = cce;
        u.a(aVar.Kf(), new u.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                x.d("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0) {
                    ccf ccf = (ccf) bVar.hnR.hnY;
                    if (ccf == null) {
                        AppBrandAuthorizeUI.this.di(true);
                        x.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq failed, response is null!");
                    } else {
                        int i3 = ccf.xhT.errCode;
                        String str2 = ccf.xhT.foE;
                        if (i3 == 0) {
                            AppBrandAuthorizeUI.this.jPW = ccf.xhU;
                            AppBrandAuthorizeUI.a(AppBrandAuthorizeUI.this, AppBrandAuthorizeUI.this.jPW);
                        } else {
                            AppBrandAuthorizeUI.this.di(true);
                            x.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq error %s", str2);
                        }
                    }
                } else {
                    AppBrandAuthorizeUI.this.di(true);
                }
                return 0;
            }
        }, true);
    }

    static /* synthetic */ void a(AppBrandAuthorizeUI appBrandAuthorizeUI, String str, List list) {
        LinkedList linkedList = new LinkedList();
        for (dy dyVar : list) {
            art art = new art();
            art.qmb = dyVar.scope;
            art.qmc = dyVar.state;
            linkedList.add(art);
        }
        a aVar = new a();
        aVar.hnT = new cco();
        aVar.hnU = new ccp();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp_modauth";
        aVar.hnS = 1188;
        aVar.hnV = 0;
        aVar.hnW = 0;
        com.tencent.mm.bp.a cco = new cco();
        cco.appId = str;
        cco.xie = linkedList;
        aVar.hnT = cco;
        u.a(aVar.Kf(), new u.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                x.d("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0) {
                    ccp ccp = (ccp) bVar.hnR.hnY;
                    if (ccp == null) {
                        x.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq failed, response is null!");
                    } else {
                        int i3 = ccp.xhT.errCode;
                        String str2 = ccp.xhT.foE;
                        if (i3 == 0) {
                            x.d("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq OK!");
                            try {
                                q.rl(AppBrandAuthorizeUI.this.jPV);
                            } catch (Exception e) {
                            }
                        } else {
                            x.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq error %s", str2);
                        }
                    }
                }
                return 0;
            }
        }, true);
    }

    static /* synthetic */ void a(AppBrandAuthorizeUI appBrandAuthorizeUI, final List list) {
        if (list == null || list.size() <= 0) {
            x.e("MicroMsg.AppBrandAuthorizeUI", "authItems is empty");
            appBrandAuthorizeUI.di(true);
            return;
        }
        appBrandAuthorizeUI.di(false);
        appBrandAuthorizeUI.runOnUiThread(new Runnable() {
            public final void run() {
                x.d("MicroMsg.AppBrandAuthorizeUI", "initAuthItem authItems.size = %d", Integer.valueOf(list.size()));
                for (dy dyVar : list) {
                    boolean z;
                    Preference checkBoxPreference = new CheckBoxPreference(AppBrandAuthorizeUI.this);
                    checkBoxPreference.ysp = false;
                    checkBoxPreference.setKey(dyVar.scope);
                    checkBoxPreference.setTitle(dyVar.vPO);
                    if (dyVar.state == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    checkBoxPreference.tYU = z;
                    AppBrandAuthorizeUI.this.jPY.a(checkBoxPreference);
                }
                AppBrandAuthorizeUI.this.jPY.notifyDataSetChanged();
                x.d("MicroMsg.AppBrandAuthorizeUI", "initAuthItem finish");
            }
        });
    }

    public final int XK() {
        return m.iFb;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppBrandAuthorizeUI.this.alf();
                AppBrandAuthorizeUI.this.finish();
                return false;
            }
        });
        setMMTitle(j.iAX);
        this.jPY = this.yrJ;
        String stringExtra = getIntent().getStringExtra("key_username");
        this.jPV = stringExtra;
        if (bi.oN(stringExtra)) {
            finish();
            return;
        }
        this.jQb = getIntent().getBooleanExtra("key_app_authorize_jsapi", false);
        this.jPX = q.ri(this.jPV);
        if (this.jPX == null) {
            x.e("MicroMsg.AppBrandAuthorizeUI", "AppBrandBizInfo is Null");
            return;
        }
        this.mAppId = this.jPX.appId;
        c.Dt().F(new Runnable() {
            public final void run() {
                AppBrandAuthorizeUI.a(AppBrandAuthorizeUI.this, AppBrandAuthorizeUI.this.mAppId);
            }
        });
    }

    protected void initSwipeBack() {
        super.initSwipeBack();
        if (getSwipeBackLayout() != null && getSwipeBackLayout().getChildCount() > 0) {
            View childAt = getSwipeBackLayout().getChildAt(0);
            getSwipeBackLayout().removeView(childAt);
            this.jQc = new b(this);
            this.jQc.addView(childAt, new LayoutParams(-1, -1));
            this.jQc.setStatusBarColor(getResources().getColor(d.btT));
            getSwipeBackLayout().addView(this.jQc);
            getSwipeBackLayout().Iv = this.jQc;
        }
    }

    public final boolean a(final f fVar, final Preference preference) {
        x.d("MicroMsg.AppBrandAuthorizeUI", "onPreferenceTreeClcik.(key : %s)", preference.idX);
        if (this.jPW == null) {
            x.w("MicroMsg.AppBrandAuthorizeUI", "mAuthItem == null");
        } else {
            String str = preference.idX;
            if (bi.oN(str)) {
                x.e("MicroMsg.AppBrandAuthorizeUI", "key is null");
            } else {
                for (final dy dyVar : this.jPW) {
                    if (str.equals(bi.oM(dyVar.scope))) {
                        this.jPZ = true;
                        if (((CheckBoxPreference) preference).isChecked()) {
                            dyVar.state = 1;
                        } else if (this.jQa) {
                            this.jQa = false;
                            i.a aVar = new i.a(this);
                            aVar.Zn(getString(j.iAO));
                            aVar.Zp(getString(j.iAN));
                            aVar.a(new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dyVar.state = 2;
                                    x.d("MicroMsg.AppBrandAuthorizeUI", "set authItem.state close");
                                }
                            });
                            aVar.Zq(getString(j.dEy));
                            aVar.b(new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    x.d("MicroMsg.AppBrandAuthorizeUI", "set authItem.state open");
                                    dyVar.state = 1;
                                    ((CheckBoxPreference) preference).tYU = true;
                                    fVar.notifyDataSetChanged();
                                }
                            });
                            aVar.d(new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    x.d("MicroMsg.AppBrandAuthorizeUI", "on cancel click!");
                                    dyVar.state = 1;
                                    ((CheckBoxPreference) preference).tYU = true;
                                    fVar.notifyDataSetChanged();
                                }
                            });
                            i ale = aVar.ale();
                            ale.setCanceledOnTouchOutside(false);
                            ale.show();
                        } else {
                            dyVar.state = 2;
                        }
                    }
                }
            }
        }
        return false;
    }

    private void di(final boolean z) {
        runOnUiThread(new Runnable() {
            public final void run() {
                Preference preference = new Preference(AppBrandAuthorizeUI.this);
                preference.ysp = false;
                if (z) {
                    preference.setLayoutResource(h.ize);
                    preference.setTitle(AppBrandAuthorizeUI.this.getString(j.iAP, new Object[]{AppBrandAuthorizeUI.this.jPX.fqG}));
                } else {
                    preference.setLayoutResource(h.izf);
                    preference.setTitle(AppBrandAuthorizeUI.this.getString(j.iAQ, new Object[]{AppBrandAuthorizeUI.this.jPX.fqG}));
                }
                AppBrandAuthorizeUI.this.jPY.a(preference);
                AppBrandAuthorizeUI.this.jPY.notifyDataSetChanged();
            }
        });
    }

    protected void onPause() {
        if (this.jPZ) {
            x.d("MicroMsg.AppBrandAuthorizeUI", "onPause key change!");
            ah.y(new Runnable() {
                public final void run() {
                    if (AppBrandAuthorizeUI.this.jPZ) {
                        AppBrandAuthorizeUI.this.jPZ = false;
                        AppBrandAuthorizeUI.a(AppBrandAuthorizeUI.this, AppBrandAuthorizeUI.this.mAppId, AppBrandAuthorizeUI.this.jPW);
                    }
                }
            });
        }
        super.onPause();
    }

    public void onBackPressed() {
        x.d("MicroMsg.AppBrandAuthorizeUI", "onBackPressed !");
        alf();
        super.onBackPressed();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private void alf() {
        if (this.jQb) {
            JSONArray jSONArray = new JSONArray();
            for (dy dyVar : this.jPW) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("scope", dyVar.scope);
                    jSONObject.put("state", dyVar.state);
                    jSONObject.put("desc", dyVar.vPO);
                    jSONArray.put(jSONObject);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppBrandAuthorizeUI", e, "", new Object[0]);
                }
            }
            x.d("MicroMsg.AppBrandAuthorizeUI", "authInfo %s", jSONArray);
            Intent intent = new Intent();
            intent.putExtra("key_app_authorize_state", jSONArray.toString());
            setResult(-1, intent);
        }
    }
}
