package com.tencent.mm.plugin.product.b;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.product.c.a;
import com.tencent.mm.plugin.product.c.c;
import com.tencent.mm.plugin.product.c.e;
import com.tencent.mm.plugin.product.c.f;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.j;
import com.tencent.mm.plugin.product.c.k;
import com.tencent.mm.plugin.product.c.l;
import com.tencent.mm.plugin.product.c.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class m {
    public String pjS;
    public int pjT;
    public int pjU = Integer.MAX_VALUE;
    public int pjV = Integer.MAX_VALUE;
    public c pjW;
    public n pjX;
    public LinkedList<l> pjY = new LinkedList();
    public f pjZ;
    public String pka;
    public String pkb;
    public String pkc;
    public int status = 6;

    public static m a(m mVar, String str) {
        m mVar2;
        if (mVar == null) {
            mVar2 = new m();
        } else {
            mVar2 = mVar;
        }
        try {
            int length;
            int i;
            int i2;
            JSONArray optJSONArray;
            JSONObject jSONObject = new JSONObject(str);
            mVar2.pjS = jSONObject.getString("product_id");
            mVar2.pjT = jSONObject.getInt("product_type");
            mVar2.pjU = jSONObject.optInt("quantity", Integer.MAX_VALUE);
            mVar2.pjV = jSONObject.optInt("left_buy_quantity", Integer.MAX_VALUE);
            mVar2.status = jSONObject.optInt(DownloadInfo.STATUS, 6);
            JSONObject optJSONObject = jSONObject.optJSONObject("ext_attr");
            if (optJSONObject != null) {
                mVar2.pjZ = new f();
                optJSONObject = optJSONObject.optJSONObject("product_ext");
                if (optJSONObject != null) {
                    f fVar = mVar2.pjZ;
                    j jVar = new j();
                    jVar.fEo = optJSONObject.getInt("flag");
                    fVar.pkv = jVar;
                } else {
                    mVar2.pjZ.pkw = jSONObject.optString("ext_attr");
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("base_attr");
            if (optJSONObject2 != null) {
                JSONObject jSONObject2;
                mVar2.pjW = new c();
                mVar2.pjW.name = optJSONObject2.getString("name");
                mVar2.pjW.pkh = optJSONObject2.getInt("ori_price");
                mVar2.pjW.pki = optJSONObject2.getInt("up_price");
                mVar2.pjW.pkj = optJSONObject2.getInt("low_price");
                mVar2.pjW.pkk = new LinkedList();
                JSONArray jSONArray = optJSONObject2.getJSONArray("img_info");
                length = jSONArray.length();
                for (i = 0; i < length; i++) {
                    String string = jSONArray.getString(i);
                    if (!bi.oN(string)) {
                        mVar2.pjW.pkk.add(string);
                    }
                }
                mVar2.pjW.hfQ = optJSONObject2.getString("digest");
                mVar2.pjW.pgf = optJSONObject2.getString("fee_type");
                mVar2.pjW.pkl = optJSONObject2.getString("detail");
                optJSONObject = optJSONObject2.optJSONObject("share_info");
                if (optJSONObject != null) {
                    mVar2.pjW.pkt = new k();
                    mVar2.pjW.pkt.pfi = optJSONObject.optString("icon_url");
                    mVar2.pjW.pkt.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                }
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("sku_table");
                if (optJSONArray2 != null) {
                    mVar2.pjW.pkr = new LinkedList();
                    int length2 = optJSONArray2.length();
                    for (i = 0; i < length2; i++) {
                        jSONObject2 = optJSONArray2.getJSONObject(i);
                        com.tencent.mm.plugin.product.c.m mVar3 = new com.tencent.mm.plugin.product.c.m();
                        mVar3.pkD = jSONObject2.getString(SlookAirButtonFrequentContactAdapter.ID);
                        mVar3.pkE = jSONObject2.getString("name");
                        mVar3.pkF = new LinkedList();
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("value_list");
                        int length3 = jSONArray2.length();
                        for (i2 = 0; i2 < length3; i2++) {
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                            h hVar = new h();
                            hVar.id = jSONObject3.getString(SlookAirButtonFrequentContactAdapter.ID);
                            hVar.name = jSONObject3.getString("name");
                            hVar.pkx = true;
                            mVar3.pkF.add(hVar);
                        }
                        mVar2.pjW.pkr.add(mVar3);
                    }
                }
                optJSONArray = optJSONObject2.optJSONArray("actiongroup_attr");
                if (optJSONArray != null) {
                    mVar2.pjW.pks = new LinkedList();
                    length = optJSONArray.length();
                    for (i = 0; i < length; i++) {
                        jSONObject2 = optJSONArray.getJSONObject(i);
                        a aVar = new a();
                        aVar.nkW = jSONObject2.getString("name");
                        aVar.kzz = 0;
                        if (!bi.oN(aVar.nkW)) {
                            mVar2.pjW.pks.add(aVar);
                        }
                        JSONArray jSONArray3 = jSONObject2.getJSONArray("action_list");
                        int length4 = jSONArray3.length();
                        for (i2 = 0; i2 < length4; i2++) {
                            JSONObject jSONObject4 = jSONArray3.getJSONObject(i2);
                            a aVar2 = new a();
                            aVar2.nkW = jSONObject4.getString("name");
                            aVar2.pke = jSONObject4.getString("tips");
                            aVar2.kzz = jSONObject4.getInt(Columns.TYPE);
                            aVar2.noL = jSONObject4.getString("content");
                            aVar2.nlA = jSONObject4.getString("icon_url");
                            mVar2.pjW.pks.add(aVar2);
                        }
                    }
                }
            }
            optJSONArray = jSONObject.optJSONArray("available_sku_list");
            if (optJSONArray != null) {
                length = optJSONArray.length();
                mVar2.pjY = new LinkedList();
                for (i2 = 0; i2 < length; i2++) {
                    optJSONObject = optJSONArray.getJSONObject(i2);
                    l lVar = new l();
                    lVar.pkA = optJSONObject.getString("id_info");
                    lVar.pkB = optJSONObject.getInt("price");
                    lVar.pjU = optJSONObject.getInt("quantity");
                    lVar.url = optJSONObject.getString("icon_url");
                    JSONArray jSONArray4 = optJSONObject.getJSONArray("express_fee");
                    int length5 = jSONArray4.length();
                    lVar.pkC = new LinkedList();
                    for (i = 0; i < length5; i++) {
                        JSONObject jSONObject5 = jSONArray4.getJSONObject(i);
                        e eVar = new e();
                        eVar.id = jSONObject5.getInt(SlookAirButtonFrequentContactAdapter.ID);
                        eVar.name = jSONObject5.getString("name");
                        eVar.value = jSONObject5.getInt("price");
                        lVar.pkC.add(eVar);
                    }
                    mVar2.pjY.add(lVar);
                }
            }
            optJSONObject = jSONObject.optJSONObject("seller_attr");
            if (optJSONObject != null) {
                mVar2.pjX = new n();
                mVar2.pjX.fGh = optJSONObject.getString("appid");
                mVar2.pjX.name = optJSONObject.getString("name");
                mVar2.pjX.username = optJSONObject.getString("username");
                mVar2.pjX.pkG = optJSONObject.optString("logo");
                mVar2.pjX.fEo = optJSONObject.optInt("flag", 0);
            }
            optJSONObject = jSONObject.optJSONObject("oss_info");
            if (optJSONObject != null) {
                mVar2.pkb = optJSONObject.optString("self_buy_button_word");
                mVar2.pkc = optJSONObject.optString("product_mixed_h5_html");
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ProductInfo", e, "", new Object[0]);
        }
        return mVar2;
    }

    public static m b(m mVar, String str) {
        int i = 0;
        if (mVar == null) {
            mVar = new m();
        }
        Map y = bj.y(str, "mallProductInfo");
        if (y == null) {
            return null;
        }
        mVar.pjS = bi.oM((String) y.get(".mallProductInfo.id"));
        mVar.pjT = bi.getInt((String) y.get(".mallProductInfo.type"), 0);
        mVar.pjW = new c();
        mVar.pjW.name = bi.oM((String) y.get(".mallProductInfo.name"));
        mVar.pjW.hfQ = bi.oM((String) y.get(".mallProductInfo.digest"));
        mVar.pjW.pki = bi.getInt((String) y.get(".mallProductInfo.highPrice"), 0);
        mVar.pjW.pkj = bi.getInt((String) y.get(".mallProductInfo.lowPrice"), 0);
        mVar.pjW.pkh = bi.getInt((String) y.get(".mallProductInfo.originPrice"), 0);
        mVar.pka = bi.oM((String) y.get(".mallProductInfo.sourceUrl"));
        int i2 = bi.getInt((String) y.get(".mallProductInfo.imgCount"), 0);
        if (i2 > 0) {
            mVar.pjW.pkk = new LinkedList();
            while (i < i2) {
                String oM;
                if (i == 0) {
                    oM = bi.oM((String) y.get(".mallProductInfo.imgList.imgUrl"));
                } else {
                    oM = bi.oM((String) y.get(".mallProductInfo.imgList.imgUrl" + i));
                }
                if (!bi.oN(oM)) {
                    mVar.pjW.pkk.add(oM);
                }
                i++;
            }
        }
        mVar.pjW.pkt = new k();
        mVar.pjW.pkt.url = bi.oM((String) y.get(".mallProductInfo.shareInfo.shareUrl"));
        mVar.pjW.pkt.pfi = bi.oM((String) y.get(".mallProductInfo.shareInfo.shareThumbUrl"));
        mVar.pjX = new n();
        mVar.pjX.fGh = bi.oM((String) y.get(".mallProductInfo.sellerInfo.appID"));
        mVar.pjX.name = bi.oM((String) y.get(".mallProductInfo.sellerInfo.appName"));
        mVar.pjX.username = bi.oM((String) y.get(".mallProductInfo.sellerInfo.usrName"));
        return mVar;
    }

    public final String bjO() {
        if (this.pjW != null && this.pjW.pkt != null && !bi.oN(this.pjW.pkt.pfi)) {
            return this.pjW.pkt.pfi;
        }
        if (this.pjW == null || this.pjW.pkk == null || this.pjW.pkk.size() <= 0) {
            return null;
        }
        return (String) this.pjW.pkk.get(0);
    }
}
