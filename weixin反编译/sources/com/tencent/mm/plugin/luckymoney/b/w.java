package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class w extends aa {
    public int loD;
    public String loF;
    public ah ohJ;
    public String ohn;
    public String oho;
    public String oht;
    public String oiJ;
    public boolean oiK;
    public int oiL;
    public String oiM;
    public ah oiN;
    public ah oiO;
    public ah oiP;
    public int oiQ = 0;
    public LinkedList<k> oiR;

    public w(String str) {
        Map hashMap = new HashMap();
        hashMap.put("scene", "8");
        hashMap.put("ver", str);
        g.Dr();
        hashMap.put("walletType", String.valueOf(g.Dq().Db().get(339975, null)));
        D(hashMap);
    }

    public w(String str, byte b) {
        Map hashMap = new HashMap();
        hashMap.put("ver", str);
        g.Dr();
        hashMap.put("walletType", String.valueOf(g.Dq().Db().get(339975, null)));
        D(hashMap);
    }

    public final int getType() {
        return 1554;
    }

    public final String azu() {
        return "/cgi-bin/mmpay-bin/operationwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            this.oiL = jSONObject.optInt("randomAmount");
            this.oiJ = jSONObject.optString("randomWishing");
            this.loF = jSONObject.optString("notice");
            this.oiM = jSONObject.optString("notice_url");
            this.oiK = jSONObject.optInt("hasCanShareHongBao") == 1;
            this.loD = jSONObject.optInt("currency");
            this.ohn = jSONObject.optString("currencyUint");
            this.oho = jSONObject.optString("currencyWording");
            x.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "currency=" + this.loD + ";currencyUint=" + this.ohn + ";currencyWording=" + this.oho);
            c cVar = new c();
            cVar.ohh = jSONObject.optString("groupHint");
            cVar.ohi = jSONObject.optString("personalHint");
            cVar.ohg = ((double) jSONObject.optLong("totalAmount", 200000)) / 100.0d;
            cVar.ohf = jSONObject.optInt("totalNum", 100);
            cVar.ohj = ((double) jSONObject.optLong("perPersonMaxValue", 20000)) / 100.0d;
            cVar.ohk = ((double) jSONObject.optLong("perGroupMaxValue", 20000)) / 100.0d;
            cVar.ohl = ((double) jSONObject.optLong("perMinValue", 1)) / 100.0d;
            cVar.ohm = jSONObject.optInt("payShowBGFlag");
            cVar.loD = this.loD;
            cVar.ohn = this.ohn;
            cVar.oho = this.oho;
            a.aXv();
            d aXw = a.aXw();
            aXw.ohp = cVar;
            x.i("MicroMsg.LuckyMoneyConfigManager", "setConfig maxTotalAmount:" + aXw.ohp.ohg + " maxTotalNum:" + aXw.ohp.ohf + " perGroupMaxValue:" + aXw.ohp.ohk + " perMinValue:" + aXw.ohp.ohl + " perPersonMaxValue:" + aXw.ohp.ohj);
            try {
                String str2 = new String(aXw.ohp.toByteArray(), "ISO-8859-1");
                g.Dr();
                g.Dq().Db().set(356355, str2);
                g.Dr();
                g.Dq().Db().lO(true);
            } catch (UnsupportedEncodingException e) {
                x.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + e.getLocalizedMessage());
            } catch (IOException e2) {
                x.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + e2.getLocalizedMessage());
            }
            this.oiN = l.K(jSONObject.optJSONObject("operationHeader"));
            this.ohJ = l.K(jSONObject.optJSONObject("operationTail"));
            this.oiO = l.K(jSONObject.optJSONObject("operationNext"));
            this.oiP = l.K(jSONObject.optJSONObject("operationMiddle"));
            int optInt = jSONObject.optInt("sceneSwitch");
            g.Dr();
            g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_LUCKY_MONEY_NEWYEAR_SWITCH_INT_SYNC, Integer.valueOf(optInt));
            x.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "sceneSwitch:" + optInt);
            this.oiQ = jSONObject.optInt("scenePicSwitch");
            x.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "scenePicSwitch:" + this.oiQ);
            this.oht = jSONObject.optString("wishing");
            x.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "wishing: %s", this.oht);
            JSONArray optJSONArray = jSONObject.optJSONArray("yearMess");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                x.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson is empty!");
                return;
            }
            x.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson length:" + optJSONArray.length());
            this.oiR = new LinkedList();
            for (optInt = 0; optInt < optJSONArray.length(); optInt++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(optInt);
                k kVar = new k();
                kVar.oig = optJSONObject.optInt("yearAmount", 0);
                kVar.oih = optJSONObject.optString("yearWish");
                this.oiR.add(kVar);
            }
            return;
        }
        x.e("MicroMsg.NetSceneLuckyMoneyGetConfig", "hongbao operation fail, errCode:" + i + ", errMsg:" + str);
    }
}
