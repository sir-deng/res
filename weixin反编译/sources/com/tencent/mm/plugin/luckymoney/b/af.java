package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class af extends aa {
    public String fMx;
    public int fMy;
    public int fMz;
    public int fei;
    long frh;
    public int msgType = 1;
    public String oeH;
    public String oeP;
    public int ohD;
    public ah ohJ;
    public String ohK;
    public String ohP;
    public int ohq;
    public String ohr;
    public String oht;
    public String ohv;
    public int oiA = 1;
    public String oiB = null;
    public String oiC = null;
    public String oiD = null;
    public String oiE = null;
    public String oiF = null;
    public long oiG = 0;
    public int oiQ = 0;
    public String ojf;
    public long ojg;
    public long ojh;
    public int oji;
    public String ojj;
    String talker;

    public af(int i, String str, String str2, int i2, String str3) {
        this.fei = i;
        this.oeH = str;
        this.fMx = str2;
        Map hashMap = new HashMap();
        hashMap.put("msgType", "1");
        hashMap.put(DownloadInfoColumns.CHANNELID, String.valueOf(i));
        hashMap.put("sendId", str);
        hashMap.put("inWay", String.valueOf(i2));
        hashMap.put("ver", str3);
        g.Dr();
        long longValue = ((Long) g.Dq().Db().get(a.USERINFO_WALLET_REALNAME_DISCLAIMER_QUERY_EXPIRED_TIME_LONG_SYNC, Long.valueOf(0))).longValue();
        if (longValue > 0) {
            if (System.currentTimeMillis() < longValue) {
                hashMap.put("agreeDuty", "0");
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                g.Dr();
                hashMap.put("agreeDuty", stringBuilder.append((Integer) g.Dq().Db().get(a.USERINFO_WALLET_DISCLAIMER_NEED_AGERR_INT_SYNC, Integer.valueOf(1))).toString());
            }
        }
        if (!bi.oN(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        D(hashMap);
    }

    public final int getType() {
        return 1581;
    }

    public final String azu() {
        return "/cgi-bin/mmpay-bin/receivewxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.ojf = jSONObject.optString("sendNick");
        this.ohv = jSONObject.optString("sendHeadImg");
        this.fMy = jSONObject.optInt("hbStatus");
        this.fMz = jSONObject.optInt("receiveStatus");
        this.ohr = jSONObject.optString("statusMess");
        this.oht = jSONObject.optString("wishing");
        this.ohD = jSONObject.optInt("isSender");
        this.ojg = jSONObject.optLong("sceneAmount");
        this.ojh = jSONObject.optLong("sceneRecTimeStamp");
        this.ohq = jSONObject.optInt("hbType");
        this.ohK = jSONObject.optString("watermark");
        this.oeP = jSONObject.optString("externMess");
        this.ohP = jSONObject.optString("sendUserName");
        if (!bi.oN(this.ohP) && bi.oN(this.ojf)) {
            this.ojf = ((b) g.h(b.class)).gw(this.ohP);
        }
        this.ohJ = l.K(jSONObject.optJSONObject("operationTail"));
        this.oiQ = jSONObject.optInt("scenePicSwitch");
        JSONObject optJSONObject = jSONObject.optJSONObject("agree_duty");
        if (optJSONObject != null) {
            this.oiB = optJSONObject.optString("agreed_flag", "-1");
            this.oiC = optJSONObject.optString("title", "");
            this.oiD = optJSONObject.optString("service_protocol_wording", "");
            this.oiE = optJSONObject.optString("service_protocol_url", "");
            this.oiF = optJSONObject.optString("button_wording", "");
            this.oiG = optJSONObject.optLong("delay_expired_time", 0);
        }
        if (this.oiG > 0) {
            g.Dr();
            g.Dq().Db().a(a.USERINFO_WALLET_REALNAME_DISCLAIMER_QUERY_EXPIRED_TIME_LONG_SYNC, Long.valueOf(System.currentTimeMillis() + (this.oiG * 1000)));
        }
        x.i("MicroMsg.NetSceneReceiveLuckyMoney", "scenePicSwitch:" + this.oiQ);
        this.oji = jSONObject.optInt("preStrainFlag", 1);
        x.i("MicroMsg.NetSceneReceiveLuckyMoney", "preStrainFlag:" + this.oji);
        g.Dr();
        g.Dq().Db().a(a.USERINFO_NEWYEAR_HONGBAO_IMAGE_PRESTRAIN_FLAG_INT_SYNC, Integer.valueOf(this.oji));
        this.ojj = jSONObject.optString("timingIdentifier");
    }

    public final boolean aXP() {
        return this.ohD == 1;
    }
}
