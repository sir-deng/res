package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.text.TextUtils;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

public class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 45;
    private static final String NAME = "reportAction";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String str;
        int i2;
        long Wx;
        String str2;
        String str3;
        String str4;
        Throwable e;
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString(Columns.VALUE);
        x.i("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey =  %s, actionValue =  %s", optString, optString2);
        if (bi.oN(optString) || bi.oN(optString2)) {
            x.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue is null");
            jVar.E(i, e("fail", null));
            return;
        } else if (optString.length() <= 0 || optString.length() > 32 || optString2.length() <= 0 || optString2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            x.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue size is bad");
            jVar.E(i, e("fail", null));
            return;
        } else {
            str = "";
            String str5 = "";
            String str6 = "";
            if (TextUtils.isEmpty(jVar.mAppId)) {
                x.e("MicroMsg.JsApiReportAction", "doReportActionInfo, appId is empty");
                jVar.E(i, e("fail", null));
                return;
            }
            x.i("MicroMsg.JsApiReportAction", "doReportActionInfo, appId %s", jVar.mAppId);
            i2 = 0;
            if (ao.isConnected(jVar.getContext())) {
                if (ao.isWifi(jVar.getContext())) {
                    i2 = 1;
                } else if (ao.is4G(jVar.getContext())) {
                    i2 = 4;
                } else if (ao.is3G(jVar.getContext())) {
                    i2 = 3;
                } else if (ao.is2G(jVar.getContext())) {
                    i2 = 2;
                }
                x.i("MicroMsg.JsApiReportAction", "doReportActionInfo, get networkType %d", Integer.valueOf(i2));
            }
            Wx = bi.Wx();
            x.d("MicroMsg.JsApiReportAction", "report(%s), clickTimestamp : %d, appID %s, networkType %d, userAgent %s, url : %s, sessionID : %s, actionKey : %s, actionValue : %s", Long.valueOf(Wx), Integer.valueOf(13579), r12, Integer.valueOf(i2), str5, str6, str, optString, optString2);
            str2 = "";
            str3 = "";
            String str7 = "";
            str4 = "";
            try {
                str2 = URLEncoder.encode(bi.oM(str5), "UTF-8");
                str3 = URLEncoder.encode(str6, "UTF-8");
                optString = URLEncoder.encode(optString, "UTF-8");
                try {
                    str4 = URLEncoder.encode(optString2, "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                }
            } catch (Throwable e3) {
                Throwable th = e3;
                optString = str7;
                e = th;
            }
            g.pWK.h(13579, r12, Integer.valueOf(i2), str2, str3, str, optString, str4, Long.valueOf(Wx), Long.valueOf(Wx));
            jVar.E(i, e("ok", null));
        }
        x.printErrStackTrace("MicroMsg.JsApiReportAction", e, "", new Object[0]);
        g.pWK.h(13579, r12, Integer.valueOf(i2), str2, str3, str, optString, str4, Long.valueOf(Wx), Long.valueOf(Wx));
        jVar.E(i, e("ok", null));
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        String str;
        int i2;
        long Wx;
        String str2;
        String str3;
        String str4;
        Throwable e;
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString(Columns.VALUE);
        x.i("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey =  %s, actionValue =  %s", optString, optString2);
        if (bi.oN(optString) || bi.oN(optString2)) {
            x.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue is null");
            pVar.E(i, e("fail", null));
            return;
        } else if (optString.length() <= 0 || optString.length() > 32 || optString2.length() <= 0 || optString2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            x.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue size is bad");
            pVar.E(i, e("fail", null));
            return;
        } else {
            str = "";
            String str5 = "";
            String str6 = "";
            if (TextUtils.isEmpty(pVar.mAppId)) {
                x.e("MicroMsg.JsApiReportAction", "doReportActionInfo, appId is empty");
                pVar.E(i, e("fail", null));
                return;
            }
            x.i("MicroMsg.JsApiReportAction", "doReportActionInfo, appId %s", pVar.mAppId);
            i2 = 0;
            if (ao.isConnected(pVar.mContext)) {
                if (ao.isWifi(pVar.mContext)) {
                    i2 = 1;
                } else if (ao.is4G(pVar.mContext)) {
                    i2 = 4;
                } else if (ao.is3G(pVar.mContext)) {
                    i2 = 3;
                } else if (ao.is2G(pVar.mContext)) {
                    i2 = 2;
                }
                x.i("MicroMsg.JsApiReportAction", "doReportActionInfo, get networkType %d", Integer.valueOf(i2));
            }
            Wx = bi.Wx();
            x.d("MicroMsg.JsApiReportAction", "report(%s), clickTimestamp : %d, appID %s, networkType %d, userAgent %s, url : %s, sessionID : %s, actionKey : %s, actionValue : %s", Long.valueOf(Wx), Integer.valueOf(13579), r12, Integer.valueOf(i2), str5, str6, str, optString, optString2);
            str2 = "";
            str3 = "";
            String str7 = "";
            str4 = "";
            try {
                str2 = URLEncoder.encode(bi.oM(str5), "UTF-8");
                str3 = URLEncoder.encode(str6, "UTF-8");
                optString = URLEncoder.encode(optString, "UTF-8");
                try {
                    str4 = URLEncoder.encode(optString2, "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                }
            } catch (Throwable e3) {
                Throwable th = e3;
                optString = str7;
                e = th;
            }
            g.pWK.h(13579, r12, Integer.valueOf(i2), str2, str3, str, optString, str4, Long.valueOf(Wx), Long.valueOf(Wx));
            pVar.E(i, e("ok", null));
        }
        x.printErrStackTrace("MicroMsg.JsApiReportAction", e, "", new Object[0]);
        g.pWK.h(13579, r12, Integer.valueOf(i2), str2, str3, str, optString, str4, Long.valueOf(Wx), Long.valueOf(Wx));
        pVar.E(i, e("ok", null));
    }
}
