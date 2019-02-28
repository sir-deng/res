package com.tencent.mm.plugin.recharge.model;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.m;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.awq;
import com.tencent.mm.protocal.c.awr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f extends k implements com.tencent.mm.network.k {
    public String appId;
    public int cmdId;
    public String desc;
    public int errCode;
    public String foE;
    private b gLB;
    private e gLE;
    public boolean pHL;
    public ArrayList<n> pHM;
    public ArrayList<n> pHN;
    public d pHO;
    public d pHP;
    public d pHQ;
    public d pHR;
    public d pHS;
    public m pHT;
    public List<a> pHU;
    public boolean pHV;
    public String pny;

    public f(String str) {
        this(str, 0);
    }

    public f(String str, int i) {
        this.pny = "";
        this.appId = "";
        this.pHL = false;
        this.desc = "";
        this.errCode = 0;
        this.foE = "";
        this.pHV = false;
        this.pny = str;
        a aVar = new a();
        aVar.hnT = new awq();
        aVar.hnU = new awr();
        aVar.uri = "/cgi-bin/mmpay-bin/paychargeproxy";
        aVar.hnS = 1571;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        awq awq = (awq) this.gLB.hnQ.hnY;
        awq.wet = i;
        this.cmdId = i;
        x.i("MicroMsg.NetScenePayChargeProxy", "cmdId: %d", Integer.valueOf(i));
        if (!bi.oN(this.pny)) {
            x.i("MicroMsg.NetScenePayChargeProxy", "hy: requesting phone num: %s", this.pny);
            awq.wKN = String.format("phone=%s", new Object[]{this.pny});
        }
    }

    public final int getType() {
        return 1571;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetScenePayChargeProxy", "hy: NetScenePayChargeProxy end: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.errCode = i3;
        if (i2 == 0 && i3 == 0) {
            try {
                int i4;
                String optString;
                String optString2;
                JSONArray optJSONArray;
                JSONObject optJSONObject;
                String optString3;
                JSONObject jSONObject = new JSONObject(((awr) ((b) qVar).hnR.hnY).wKO);
                x.d("MicroMsg.NetScenePayChargeProxy", "tofutest: json: %s", jSONObject.toString());
                this.appId = jSONObject.optString("appId");
                this.errCode = jSONObject.optInt("errCode", -1);
                this.foE = jSONObject.optString("errMsg", ad.getContext().getString(i.uYO));
                if (this.errCode < 0) {
                    this.pHL = true;
                } else {
                    this.pHL = false;
                }
                this.desc = jSONObject.optString("desc");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("productList");
                if (optJSONArray2 != null) {
                    this.pHM = new ArrayList();
                    this.pHN = new ArrayList();
                    for (i4 = 0; i4 < optJSONArray2.length(); i4++) {
                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i4);
                        n nVar = new n();
                        nVar.desc = jSONObject2.optString("desc", "");
                        nVar.id = jSONObject2.optString(SlookAirButtonFrequentContactAdapter.ID, "");
                        nVar.name = jSONObject2.optString("name", "");
                        nVar.status = jSONObject2.optInt(DownloadInfo.STATUS, 0);
                        nVar.url = jSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL, "");
                        nVar.type = jSONObject2.optInt(Columns.TYPE);
                        nVar.sJQ = jSONObject2.optString("typeName");
                        nVar.sJS = jSONObject2.optString("isColor", "0");
                        nVar.sJT = jSONObject2.optString("colorCode", "0");
                        nVar.sJU = jSONObject2.optInt("isReConfirm", 0);
                        if (nVar.type == 1) {
                            this.pHM.add(nVar);
                        } else {
                            nVar.sJR = jSONObject2.optString("productAttr");
                            this.pHN.add(nVar);
                        }
                    }
                } else {
                    this.pHM = null;
                    this.pHN = null;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("weSim");
                if (optJSONObject2 != null) {
                    optString = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    optString2 = optJSONObject2.optString("name");
                    if (bi.oN(optString) || bi.oN(optString2)) {
                        x.w("MicroMsg.NetScenePayChargeProxy", "tf: weSim is missing");
                        this.pHR = null;
                    } else {
                        this.pHR = new d();
                        this.pHR.url = optString;
                        this.pHR.name = optString2;
                    }
                }
                optJSONObject2 = jSONObject.optJSONObject("wxRemind");
                if (optJSONObject2 != null) {
                    optString = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    optString2 = optJSONObject2.optString("name");
                    if (bi.oN(optString) || bi.oN(optString2)) {
                        x.w("MicroMsg.NetScenePayChargeProxy", "hy: remind unicom unnecessary element missing");
                    } else {
                        this.pHO = new d();
                        this.pHO.url = optString;
                        this.pHO.name = optString2;
                        optJSONObject2 = jSONObject.optJSONObject("wxCard");
                        if (optJSONObject2 != null) {
                            optString = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                            optString2 = optJSONObject2.optString("name");
                            if (!bi.oN(optString) || bi.oN(optString2)) {
                                x.w("MicroMsg.NetScenePayChargeProxy", "hy: phone card necessary element missing");
                            } else {
                                this.pHP = new d();
                                this.pHP.url = optString;
                                this.pHP.name = optString2;
                                optJSONObject2 = jSONObject.optJSONObject("wxWt");
                                if (optJSONObject2 != null) {
                                    optString = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                    optString2 = optJSONObject2.optString("name");
                                    if (!bi.oN(optString) || bi.oN(optString2)) {
                                        x.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
                                    } else {
                                        this.pHQ = new d();
                                        this.pHQ.url = optString;
                                        this.pHQ.name = optString2;
                                        optJSONObject2 = jSONObject.optJSONObject("banner");
                                        if (optJSONObject2 == null) {
                                            this.pHT = new m();
                                            this.pHT.id = optJSONObject2.getInt(SlookAirButtonFrequentContactAdapter.ID);
                                            this.pHT.name = optJSONObject2.optString("name");
                                            this.pHT.url = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                        } else {
                                            this.pHT = null;
                                        }
                                        optJSONObject2 = jSONObject.optJSONObject("headEnter");
                                        if (optJSONObject2 != null) {
                                            optString = optJSONObject2.optString("name");
                                            optString2 = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                            if (!bi.oN(optString) || bi.oN(optString2)) {
                                                x.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                                            } else {
                                                this.pHS = new d();
                                                this.pHS.name = optString;
                                                this.pHS.url = optString2;
                                                optJSONArray = jSONObject.optJSONArray("numberList");
                                                if (optJSONArray != null) {
                                                    if (bi.oN(this.pny)) {
                                                        this.pHV = true;
                                                    }
                                                    if (optJSONArray.length() <= 0) {
                                                        x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", Integer.valueOf(optJSONArray.length()));
                                                        this.pHU = null;
                                                    } else {
                                                        this.pHU = new ArrayList();
                                                        for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                                            optJSONObject = optJSONArray.optJSONObject(i4);
                                                            if (optJSONObject != null) {
                                                                optString3 = optJSONObject.optString("number");
                                                                optString = optJSONObject.optString("desc");
                                                                if (!bi.oN(optString3)) {
                                                                    this.pHU.add(new a(optString3, "", optString, 2));
                                                                }
                                                            }
                                                        }
                                                        x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", Integer.valueOf(this.pHU.size()));
                                                    }
                                                } else {
                                                    this.pHU = null;
                                                    x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                                                }
                                            }
                                        }
                                        this.pHS = null;
                                        optJSONArray = jSONObject.optJSONArray("numberList");
                                        if (optJSONArray != null) {
                                            this.pHU = null;
                                            x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                                        } else {
                                            if (bi.oN(this.pny)) {
                                                this.pHV = true;
                                            }
                                            if (optJSONArray.length() <= 0) {
                                                this.pHU = new ArrayList();
                                                for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                                    optJSONObject = optJSONArray.optJSONObject(i4);
                                                    if (optJSONObject != null) {
                                                        optString3 = optJSONObject.optString("number");
                                                        optString = optJSONObject.optString("desc");
                                                        if (!bi.oN(optString3)) {
                                                            this.pHU.add(new a(optString3, "", optString, 2));
                                                        }
                                                    }
                                                }
                                                x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", Integer.valueOf(this.pHU.size()));
                                            } else {
                                                x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", Integer.valueOf(optJSONArray.length()));
                                                this.pHU = null;
                                            }
                                        }
                                    }
                                }
                                this.pHQ = null;
                                optJSONObject2 = jSONObject.optJSONObject("banner");
                                if (optJSONObject2 == null) {
                                    this.pHT = null;
                                } else {
                                    this.pHT = new m();
                                    this.pHT.id = optJSONObject2.getInt(SlookAirButtonFrequentContactAdapter.ID);
                                    this.pHT.name = optJSONObject2.optString("name");
                                    this.pHT.url = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                }
                                optJSONObject2 = jSONObject.optJSONObject("headEnter");
                                if (optJSONObject2 != null) {
                                    optString = optJSONObject2.optString("name");
                                    optString2 = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                    if (bi.oN(optString)) {
                                    }
                                    x.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                                }
                                this.pHS = null;
                                optJSONArray = jSONObject.optJSONArray("numberList");
                                if (optJSONArray != null) {
                                    if (bi.oN(this.pny)) {
                                        this.pHV = true;
                                    }
                                    if (optJSONArray.length() <= 0) {
                                        x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", Integer.valueOf(optJSONArray.length()));
                                        this.pHU = null;
                                    } else {
                                        this.pHU = new ArrayList();
                                        for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                            optJSONObject = optJSONArray.optJSONObject(i4);
                                            if (optJSONObject != null) {
                                                optString3 = optJSONObject.optString("number");
                                                optString = optJSONObject.optString("desc");
                                                if (!bi.oN(optString3)) {
                                                    this.pHU.add(new a(optString3, "", optString, 2));
                                                }
                                            }
                                        }
                                        x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", Integer.valueOf(this.pHU.size()));
                                    }
                                } else {
                                    this.pHU = null;
                                    x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                                }
                            }
                        }
                        this.pHP = null;
                        optJSONObject2 = jSONObject.optJSONObject("wxWt");
                        if (optJSONObject2 != null) {
                            optString = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                            optString2 = optJSONObject2.optString("name");
                            if (bi.oN(optString)) {
                            }
                            x.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
                        }
                        this.pHQ = null;
                        optJSONObject2 = jSONObject.optJSONObject("banner");
                        if (optJSONObject2 == null) {
                            this.pHT = new m();
                            this.pHT.id = optJSONObject2.getInt(SlookAirButtonFrequentContactAdapter.ID);
                            this.pHT.name = optJSONObject2.optString("name");
                            this.pHT.url = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                        } else {
                            this.pHT = null;
                        }
                        optJSONObject2 = jSONObject.optJSONObject("headEnter");
                        if (optJSONObject2 != null) {
                            optString = optJSONObject2.optString("name");
                            optString2 = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                            if (bi.oN(optString)) {
                            }
                            x.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                        }
                        this.pHS = null;
                        optJSONArray = jSONObject.optJSONArray("numberList");
                        if (optJSONArray != null) {
                            this.pHU = null;
                            x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                        } else {
                            if (bi.oN(this.pny)) {
                                this.pHV = true;
                            }
                            if (optJSONArray.length() <= 0) {
                                this.pHU = new ArrayList();
                                for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                    optJSONObject = optJSONArray.optJSONObject(i4);
                                    if (optJSONObject != null) {
                                        optString3 = optJSONObject.optString("number");
                                        optString = optJSONObject.optString("desc");
                                        if (!bi.oN(optString3)) {
                                            this.pHU.add(new a(optString3, "", optString, 2));
                                        }
                                    }
                                }
                                x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", Integer.valueOf(this.pHU.size()));
                            } else {
                                x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", Integer.valueOf(optJSONArray.length()));
                                this.pHU = null;
                            }
                        }
                    }
                }
                this.pHO = null;
                optJSONObject2 = jSONObject.optJSONObject("wxCard");
                if (optJSONObject2 != null) {
                    optString = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    optString2 = optJSONObject2.optString("name");
                    if (bi.oN(optString)) {
                    }
                    x.w("MicroMsg.NetScenePayChargeProxy", "hy: phone card necessary element missing");
                }
                this.pHP = null;
                optJSONObject2 = jSONObject.optJSONObject("wxWt");
                if (optJSONObject2 != null) {
                    optString = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    optString2 = optJSONObject2.optString("name");
                    if (bi.oN(optString)) {
                    }
                    x.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
                }
                this.pHQ = null;
                optJSONObject2 = jSONObject.optJSONObject("banner");
                if (optJSONObject2 == null) {
                    this.pHT = null;
                } else {
                    this.pHT = new m();
                    this.pHT.id = optJSONObject2.getInt(SlookAirButtonFrequentContactAdapter.ID);
                    this.pHT.name = optJSONObject2.optString("name");
                    this.pHT.url = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                }
                optJSONObject2 = jSONObject.optJSONObject("headEnter");
                if (optJSONObject2 != null) {
                    optString = optJSONObject2.optString("name");
                    optString2 = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    if (bi.oN(optString)) {
                    }
                    x.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                }
                this.pHS = null;
                optJSONArray = jSONObject.optJSONArray("numberList");
                if (optJSONArray != null) {
                    if (bi.oN(this.pny)) {
                        this.pHV = true;
                    }
                    if (optJSONArray.length() <= 0) {
                        x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", Integer.valueOf(optJSONArray.length()));
                        this.pHU = null;
                    } else {
                        this.pHU = new ArrayList();
                        for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                            optJSONObject = optJSONArray.optJSONObject(i4);
                            if (optJSONObject != null) {
                                optString3 = optJSONObject.optString("number");
                                optString = optJSONObject.optString("desc");
                                if (!bi.oN(optString3)) {
                                    this.pHU.add(new a(optString3, "", optString, 2));
                                }
                            }
                        }
                        x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", Integer.valueOf(this.pHU.size()));
                    }
                } else {
                    this.pHU = null;
                    x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                }
            } catch (Exception e) {
                x.e("MicroMsg.NetScenePayChargeProxy", "hy: exception occurred when parsing json: %s", e.toString());
                this.pHL = true;
                this.foE = ad.getContext().getString(i.uYO);
            }
        } else {
            this.pHL = true;
            if (bi.oN(str)) {
                str = ad.getContext().getString(i.uXI);
            }
            this.foE = str;
        }
        this.gLE.a(i2, i3, str, this);
    }
}
