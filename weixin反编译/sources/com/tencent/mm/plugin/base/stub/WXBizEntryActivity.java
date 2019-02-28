package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.modelsimple.ak;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.c.bqb;
import com.tencent.mm.protocal.c.co;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.u;
import com.tencent.rtmp.TXLivePushConfig;
import java.util.LinkedList;

public class WXBizEntryActivity extends AutoLoginActivity {
    private int kAF;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitleVisibility(0);
    }

    protected final int getLayoutId() {
        return R.i.dbw;
    }

    protected final boolean z(Intent intent) {
        return true;
    }

    protected final void a(a aVar, Intent intent) {
        Uri uri = null;
        x.i("MicroMsg.WXBizEntryActivity", "postLogin, loginResult = " + aVar);
        if (getIntent() != null) {
            this.kAF = getIntent().getIntExtra("key_command_id", 0);
        }
        switch (aVar) {
            case LOGIN_OK:
                x.i("MicroMsg.WXBizEntryActivity", "req type = %d", Integer.valueOf(this.kAF));
                Intent intent2;
                Uri data;
                switch (this.kAF) {
                    case 7:
                    case 8:
                        intent2 = getIntent();
                        intent2.setClassName(this, "com.tencent.mm.ui.CheckCanSubscribeBizUI");
                        startActivity(intent2);
                        finish();
                        return;
                    case 9:
                        d.a((Context) this, "card", ".ui.CardAddEntranceUI", getIntent(), false);
                        finish();
                        return;
                    case 11:
                        intent2 = getIntent();
                        intent2.putExtra("device_type", 1);
                        d.a((Context) this, "exdevice", ".ui.ExdeviceRankInfoUI", intent2, false);
                        finish();
                        return;
                    case 12:
                        try {
                            uri = getIntent().getData();
                        } catch (Exception e) {
                            x.e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", e.getMessage());
                        }
                        if (uri != null && com.tencent.mm.pluginsdk.d.RK(uri.toString())) {
                            u.GQ().hB("key_data_center_session_id");
                            com.tencent.mm.pluginsdk.d.a((Context) this, uri.toString(), getIntent().getIntExtra("translate_link_scene", 1), new com.tencent.mm.pluginsdk.d.a() {
                                public final void a(int i, int i2, String str, k kVar, boolean z) {
                                    x.i("MicroMsg.WXBizEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                                    if (!(kVar == null || i == 0 || i2 == 0 || !(kVar instanceof ak))) {
                                        bqb Sx = ((ak) kVar).Sx();
                                        if (!(Sx == null || WXBizEntryActivity.this.isFinishing())) {
                                            com.tencent.mm.ui.base.u.makeText(WXBizEntryActivity.this, WXBizEntryActivity.this.getString(R.l.dGZ) + " : " + bi.oM(Sx.wYS), 0).show();
                                        }
                                    }
                                    WXBizEntryActivity.this.finish();
                                }
                            }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                            return;
                        }
                        return;
                    case 13:
                        intent2 = getIntent();
                        intent2.putExtra("key_static_from_scene", 100001);
                        d.a((Context) this, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent2, false);
                        finish();
                        return;
                    case 14:
                    case 15:
                        new a(this, getIntent().getStringExtra("key_app_id"), getIntent().getStringExtra("open_id"), new d.a() {
                            public final void dT(boolean z) {
                                if (z) {
                                    d.a(WXBizEntryActivity.this, "game", ".ui.CreateOrJoinChatroomUI", WXBizEntryActivity.this.getIntent(), false);
                                } else {
                                    x.e("MicroMsg.WXBizEntryActivity", "openIdCheck false");
                                }
                                WXBizEntryActivity.this.finish();
                            }
                        }).arC();
                        return;
                    case 16:
                        d.a((Context) this, "card", ".ui.CardListSelectedUI", getIntent(), false);
                        finish();
                        return;
                    case 17:
                        try {
                            data = getIntent().getData();
                            Runnable anonymousClass2 = new Runnable() {
                                public final void run() {
                                    WXBizEntryActivity.this.findViewById(R.h.cww).setVisibility(8);
                                }
                            };
                            String stringExtra = getIntent().getStringExtra("key_package_name");
                            String stringExtra2 = getIntent().getStringExtra("key_package_signature");
                            int intExtra = getIntent().getIntExtra("translate_link_scene", 1);
                            x.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: callPackage=%s, packageSignature=%s", stringExtra, stringExtra2);
                            if (bi.oN(stringExtra) || bi.oN(stringExtra2)) {
                                x.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult:packageName or signature null");
                                return;
                            }
                            LinkedList linkedList = new LinkedList();
                            co coVar = new co();
                            x.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult package name = %s", stringExtra);
                            coVar.vOq = stringExtra;
                            coVar.signature = stringExtra2;
                            linkedList.add(coVar);
                            k akVar = new ak(data.toString(), intExtra, linkedList);
                            as.CN().a((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, new com.tencent.mm.plugin.base.stub.e.AnonymousClass1(this, anonymousClass2));
                            as.CN().a(akVar, 0);
                            return;
                        } catch (Exception e2) {
                            x.e("MicroMsg.WXBizEntryActivity", "get url from intent failed : %s", e2.getMessage());
                            return;
                        }
                    case 19:
                        try {
                            data = getIntent().getData();
                        } catch (Exception e22) {
                            x.e("MicroMsg.WXBizEntryActivity", "get data from intent for launch wxminiprogram failed : %s", e22.getMessage());
                            data = uri;
                        }
                        if (data != null) {
                            com.tencent.mm.pluginsdk.d.a((Context) this, data.toString(), getIntent().getIntExtra("translate_link_scene", 1), new com.tencent.mm.pluginsdk.d.a() {
                                public final void a(int i, int i2, String str, k kVar, boolean z) {
                                    x.i("MicroMsg.WXBizEntryActivity", "launchWXMiniprogram, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                                    if (!(kVar == null || i == 0 || i2 == 0 || !(kVar instanceof ak))) {
                                        bqb Sx = ((ak) kVar).Sx();
                                        if (!(Sx == null || WXBizEntryActivity.this.isFinishing())) {
                                            com.tencent.mm.ui.base.u.makeText(WXBizEntryActivity.this, WXBizEntryActivity.this.getString(R.l.dGZ) + " : " + bi.oM(Sx.wYS), 0).show();
                                        }
                                    }
                                    WXBizEntryActivity.this.finish();
                                }
                            }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                            return;
                        }
                        return;
                    default:
                        finish();
                        return;
                }
            case LOGIN_CANCEL:
            case LOGIN_FAIL:
                x.e("MicroMsg.WXBizEntryActivity", "postLogin fail, loginResult = " + aVar);
                break;
            default:
                x.e("MicroMsg.WXBizEntryActivity", "postLogin, unknown login result = " + aVar);
                break;
        }
        finish();
    }
}
