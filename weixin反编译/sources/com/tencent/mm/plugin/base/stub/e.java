package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.ca;
import com.tencent.mm.modelsimple.ak;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.net.URLDecoder;

public final class e {

    /* renamed from: com.tencent.mm.plugin.base.stub.e$1 */
    static class AnonymousClass1 implements com.tencent.mm.ad.e {
        final /* synthetic */ Runnable kAI;
        final /* synthetic */ Activity oZ;

        AnonymousClass1(Activity activity, Runnable runnable) {
            this.oZ = activity;
            this.kAI = runnable;
        }

        public final void a(int i, int i2, String str, k kVar) {
            as.CN().b((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (com.tencent.mm.ad.e) this);
            x.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult translateLink: errType = %d; errCode = %d; errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult respUriStr=%s", ((ak) kVar).Sw());
                try {
                    Uri parse = Uri.parse(((ak) kVar).Sw());
                    if (parse == null) {
                        x.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri null");
                        e.l(this.oZ);
                        return;
                    }
                    String queryParameter = parse.getQueryParameter("result");
                    if (queryParameter != null) {
                        x.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: result=%s", URLDecoder.decode(queryParameter));
                        b caVar = new ca();
                        caVar.fqV.activity = this.oZ;
                        caVar.fqV.fpo = queryParameter;
                        caVar.fqV.fqW = 19;
                        caVar.fqV.fqZ = 3;
                        caVar.fqV.fra = parse.getQueryParameter("appid");
                        caVar.fqV.frc = this.oZ.getIntent().getBundleExtra("_stat_obj");
                        a.xmy.m(caVar);
                        if (this.kAI != null) {
                            this.kAI.run();
                        }
                        ah.h(new Runnable() {
                            public final void run() {
                                AnonymousClass1.this.oZ.finish();
                            }
                        }, 100);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    x.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri parse exp=%s", e);
                    e.l(this.oZ);
                    return;
                }
            }
            x.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult: translate failed");
            e.l(this.oZ);
        }
    }

    static /* synthetic */ void l(Activity activity) {
        Intent intent = new Intent();
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setClassName(ad.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
        intent.putExtra("showShare", false);
        ad.getContext().startActivity(intent);
        if (activity != null) {
            activity.finish();
        }
    }
}
