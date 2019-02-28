package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class y extends aa {
    public String oiI;
    public g oiS;
    public List<String> oiT;
    public String oiU;
    public String oiV = null;

    public y(int i, int i2, int i3, String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("limit", String.valueOf(i));
        hashMap.put("offset", String.valueOf(i2));
        hashMap.put(Columns.TYPE, String.valueOf(i3));
        hashMap.put("year", str);
        hashMap.put("ver", str2);
        hashMap.put("processContent", str3);
        D(hashMap);
    }

    public final int getType() {
        return 1514;
    }

    public final String azu() {
        return "/cgi-bin/mmpay-bin/qrylistwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        try {
            int i2;
            g gVar = new g();
            gVar.ohR = jSONObject.optInt("recTotalNum");
            gVar.ohS = jSONObject.optLong("recTotalAmount");
            gVar.ohT = jSONObject.optInt("sendTotalNum");
            gVar.ohU = jSONObject.optLong("sendTotalAmount");
            gVar.ohE = jSONObject.optInt("isContinue");
            gVar.hMB = jSONObject.optInt("gameCount");
            JSONArray optJSONArray = jSONObject.optJSONArray("record");
            LinkedList linkedList = new LinkedList();
            if (optJSONArray != null) {
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    h hVar = new h();
                    hVar.ohV = jSONObject2.optString("sendName");
                    hVar.ohv = jSONObject2.optString("sendHeadImg");
                    hVar.ohW = jSONObject2.optLong("receiveAmount");
                    hVar.ohX = jSONObject2.optString("receiveTime");
                    hVar.ohq = jSONObject2.optInt("hbType");
                    hVar.ohY = jSONObject2.optString("sendTitle");
                    hVar.ohZ = jSONObject2.optString("sendTime");
                    hVar.ohA = jSONObject2.optLong("totalAmount");
                    hVar.oia = jSONObject2.optLong("totalNum");
                    hVar.ohy = jSONObject2.optLong("recNum");
                    hVar.status = jSONObject2.optInt(DownloadInfo.STATUS);
                    hVar.oib = jSONObject2.optInt("thxCount");
                    hVar.ohB = jSONObject2.optString("receiveId");
                    hVar.oeH = jSONObject2.optString("sendId");
                    hVar.ohM = jSONObject2.optInt("hbKind");
                    linkedList.add(hVar);
                }
            }
            gVar.ohN = linkedList;
            this.oiS = gVar;
            this.oiT = new ArrayList();
            String optString = jSONObject.optString("years");
            if (!bi.oN(optString)) {
                String[] split = optString.split("\\|");
                if (split != null) {
                    for (Object add : split) {
                        this.oiT.add(add);
                    }
                }
            }
            this.oiU = jSONObject.optString("recordYear");
            this.oiV = jSONObject.optString("clickedUrl");
            this.oiI = jSONObject.optString("processContent");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyNormalBase", e, "", new Object[0]);
        }
    }

    public final boolean aXO() {
        if (this.oiS == null || this.oiS.ohE == 1) {
            return true;
        }
        return false;
    }
}
