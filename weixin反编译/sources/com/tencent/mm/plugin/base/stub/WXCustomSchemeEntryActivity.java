package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.gi;
import com.tencent.mm.modelsimple.ak;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.d;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.protocal.c.bqb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author = 50, fComment = "checked", lastDate = "20141016", reviewer = 50, vComment = {EType.ACTIVITYCHECK})
public class WXCustomSchemeEntryActivity extends AutoLoginActivity {
    private List<String> kAY;

    public void onCreate(Bundle bundle) {
        x.i("MicroMsg.WXCustomSchemeEntryActivity", "onCreate");
        this.kAY = new ArrayList();
        this.kAY.add("cardpackage");
        this.kAY.add("connectToFreeWifi");
        this.kAY.add("wap");
        super.onCreate(bundle);
        setTitleVisibility(0);
    }

    protected final int getLayoutId() {
        return R.i.dbw;
    }

    protected final boolean z(Intent intent) {
        Uri data;
        try {
            data = getIntent().getData();
        } catch (Exception e) {
            x.e("MicroMsg.WXCustomSchemeEntryActivity", "get url from intent failed : %s", e.getMessage());
            data = null;
        }
        if (data != null) {
            if (d.RJ(data.toString())) {
                return true;
            }
            String scheme = data.getScheme();
            String host = data.getHost();
            String query = data.getQuery();
            x.i("MicroMsg.WXCustomSchemeEntryActivity", "uri is %s,scheme is %s, host is %s, query is %s", data.toString(), scheme, host, query);
            if (!bi.oN(host) && this.kAY.contains(host)) {
                x.i("MicroMsg.WXCustomSchemeEntryActivity", "match the host : %s", host);
                if (host.equals("cardpackage")) {
                    scheme = data.getQueryParameter("encrystr");
                    x.i("MicroMsg.WXCustomSchemeEntryActivity", "card encrypt value = %s", scheme);
                    if (!bi.oN(scheme) && scheme.length() < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                        return true;
                    }
                }
                if (host.equals("connectToFreeWifi")) {
                    if (!bi.oN(query) && query.startsWith("apKey=") && query.length() > 6) {
                        scheme = query.substring(6);
                        x.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", scheme);
                        if (!bi.oN(scheme) && scheme.length() < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                            return true;
                        }
                    } else if (data.toString().startsWith("weixin://connectToFreeWifi/friendWifi")) {
                        return true;
                    }
                }
                if (host.equals("wap") && data.toString().startsWith("weixin://wap/pay")) {
                    x.i("MicroMsg.WXCustomSchemeEntryActivity", "preLogin for WX_WAP_PAY");
                    return true;
                }
            }
        }
        finish();
        return false;
    }

    protected final void a(a aVar, Intent intent) {
        switch (aVar) {
            case LOGIN_OK:
                Uri data;
                try {
                    data = getIntent().getData();
                } catch (Exception e) {
                    x.e("MicroMsg.WXCustomSchemeEntryActivity", "post login get url from intent failed : %s", e.getMessage());
                    data = null;
                }
                if (data != null) {
                    Object obj;
                    if (data != null) {
                        int i = 2;
                        if (intent != null) {
                            i = t.a(intent, "translate_link_scene", 2);
                        }
                        int a = t.a(intent, "pay_channel", -1);
                        x.i("MicroMsg.WXCustomSchemeEntryActivity", "translateLinkScene = %d, payChannel = %d", Integer.valueOf(i), Integer.valueOf(a));
                        Bundle bundle = null;
                        if (a >= 0) {
                            x.i("MicroMsg.WXCustomSchemeEntryActivity", "doTicketsDeepLink put paychannel to extraData: %s", Integer.valueOf(a));
                            bundle = new Bundle();
                            bundle.putInt("pay_channel", a);
                        }
                        String host;
                        if (!d.RJ(data.toString())) {
                            String scheme = data.getScheme();
                            host = data.getHost();
                            Object query = data.getQuery();
                            x.i("MicroMsg.WXCustomSchemeEntryActivity", "scheme is %s, host is %s, query is %s", scheme, host, query);
                            if (!bi.oN(host) && this.kAY.contains(host)) {
                                if (host.equals("cardpackage") && !bi.oN(data.getQueryParameter("encrystr"))) {
                                    intent.setClassName(this, "com.tencent.mm.ui.CheckSmsCanAddCardUI");
                                    startActivity(intent);
                                }
                                if (host.equals("connectToFreeWifi")) {
                                    if (!bi.oN(query) && query.startsWith("apKey=")) {
                                        scheme = data.getQueryParameter("apKey");
                                        x.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", scheme);
                                        String queryParameter = data.getQueryParameter("ticket");
                                        if (!bi.oN(scheme) && scheme.length() < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                                            Intent intent2 = new Intent();
                                            intent2.putExtra("free_wifi_schema_uri", data.toString());
                                            intent2.putExtra("free_wifi_ap_key", scheme);
                                            intent2.putExtra("free_wifi_source", 5);
                                            intent2.putExtra("free_wifi_threeone_startup_type", 1);
                                            if (!bi.oN(queryParameter)) {
                                                intent2.putExtra("free_wifi_schema_ticket", queryParameter);
                                            }
                                            if (scheme.startsWith("_") || bi.oN(queryParameter)) {
                                                intent2.addFlags(67108864);
                                                com.tencent.mm.bl.d.b(this, "freewifi", ".ui.FreeWifiEntryUI", intent2);
                                            } else {
                                                b giVar = new gi();
                                                giVar.fxn.intent = intent2;
                                                com.tencent.mm.sdk.b.a.xmy.m(giVar);
                                            }
                                        }
                                    } else if (data.toString().startsWith("weixin://connectToFreeWifi/friendWifi")) {
                                        Intent intent3 = new Intent();
                                        intent3.putExtra("key_connected_router", data.toString());
                                        com.tencent.mm.bl.d.b(this, "exdevice", ".ui.ExdeviceConnectedRouterActivateStateUI", intent3);
                                        x.i("MicroMsg.WXCustomSchemeEntryActivity", "Jump to ExdeviceConnectedRouterUi.");
                                    }
                                }
                                if (host.equals("wap") && data.toString().startsWith("weixin://wap/pay")) {
                                    x.i("MicroMsg.WXCustomSchemeEntryActivity", "postLogin for WX_WAP_PAY");
                                    if (!TextUtils.isEmpty(query)) {
                                        h.a((Context) this, com.tencent.mm.pluginsdk.f.a.RU(query), false);
                                    }
                                }
                            }
                        } else if (d.j(data)) {
                            x.i("MicroMsg.WXCustomSchemeEntryActivity", "isTicketLink uri:%s, %b", data.toString(), Boolean.valueOf(d.k(data)));
                            if (d.k(data)) {
                                d.a((Context) this, data.toString(), i, bundle, new d.a() {
                                    public final void a(int i, int i2, String str, k kVar, boolean z) {
                                        x.i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                                        if (!(kVar == null || i == 0 || i2 == 0 || !(kVar instanceof ak))) {
                                            bqb Sx = ((ak) kVar).Sx();
                                            if (!(Sx == null || WXCustomSchemeEntryActivity.this.isFinishing())) {
                                                u.makeText(WXCustomSchemeEntryActivity.this, WXCustomSchemeEntryActivity.this.getString(R.l.dGZ) + " : " + bi.oM(Sx.wYS), 0).show();
                                            }
                                        }
                                        WXCustomSchemeEntryActivity.this.finish();
                                    }
                                });
                                obj = 1;
                                if (obj != null) {
                                    return;
                                }
                            }
                            d.a((Context) this, data.toString(), i, bundle, new d.a() {
                                public final void a(int i, int i2, String str, k kVar, boolean z) {
                                    WXCustomSchemeEntryActivity.this.finish();
                                }
                            });
                        } else if (d.RK(data.toString())) {
                            if (i == 1) {
                                com.tencent.mm.y.u.b hA = com.tencent.mm.y.u.GQ().hA("key_data_center_session_id");
                                if (hA == null) {
                                    x.e("MicroMsg.WXCustomSchemeEntryActivity", "null keyvalue for opensdk scene");
                                    finish();
                                } else {
                                    x.i("MicroMsg.WXCustomSchemeEntryActivity", "pkg = %s, sig = %s, intentpkg = %s, intentsig = %s", hA.getString("key_package_name", ""), hA.getString("key_package_signature", ""), intent.getStringExtra("key_package_name"), intent.getStringExtra("key_package_signature"));
                                    com.tencent.mm.y.u.GQ().hB("key_data_center_session_id");
                                    if (!(hA.getString("key_package_name", "").equals(intent.getStringExtra("key_package_name")) && r1.equals(r6))) {
                                        x.e("MicroMsg.WXCustomSchemeEntryActivity", "signature or package check failed");
                                        finish();
                                    }
                                }
                            }
                            d.a((Context) this, data.toString(), i, bundle, new d.a() {
                                public final void a(int i, int i2, String str, k kVar, boolean z) {
                                    x.i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                                    if (!(kVar == null || i == 0 || i2 == 0 || !(kVar instanceof ak))) {
                                        bqb Sx = ((ak) kVar).Sx();
                                        if (!(Sx == null || WXCustomSchemeEntryActivity.this.isFinishing())) {
                                            u.makeText(WXCustomSchemeEntryActivity.this, WXCustomSchemeEntryActivity.this.getString(R.l.dGZ) + " : " + bi.oM(Sx.wYS), 0).show();
                                        }
                                    }
                                    WXCustomSchemeEntryActivity.this.finish();
                                }
                            }, intent.getStringExtra("key_package_name"), intent.getStringExtra("key_package_signature"));
                            obj = 1;
                            if (obj != null) {
                                return;
                            }
                        } else {
                            host = q.FY();
                            x.i("MicroMsg.WXCustomSchemeEntryActivity", "not TicketLink uri:%s", data.toString());
                            d.a((Context) this, data.toString(), host, 23, data.toString(), new d.a() {
                                public final void a(int i, int i2, String str, k kVar, boolean z) {
                                    WXCustomSchemeEntryActivity.this.finish();
                                }
                            });
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        return;
                    }
                }
                break;
        }
        finish();
    }
}
