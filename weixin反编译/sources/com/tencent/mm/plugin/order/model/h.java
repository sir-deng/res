package com.tencent.mm.plugin.order.model;

import android.text.TextUtils;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends i {
    public MallOrderDetailObject pgM;
    private int pgN;

    public h(String str) {
        this(str, null, -1);
    }

    public h(String str, String str2) {
        this(str, str2, -1);
    }

    public h(String str, String str2, int i) {
        this.pgM = null;
        this.pgN = -1;
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str);
        if (!bi.oN(str2)) {
            hashMap.put("bill_id", str2);
        }
        if (this.pgN >= 0) {
            this.pgN = i;
        }
        D(hashMap);
    }

    public final int azx() {
        return 108;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.pgM = new MallOrderDetailObject();
            MallOrderDetailObject mallOrderDetailObject = this.pgM;
            if (jSONObject != null) {
                try {
                    mallOrderDetailObject.pfB = MallTransactionObject.Q(jSONObject);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MallOrderDetailObject", e, "", new Object[0]);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.MallOrderDetailObject", e2, "", new Object[0]);
                }
                try {
                    b bVar;
                    JSONObject jSONObject2 = jSONObject.getJSONObject("status_section");
                    if (jSONObject2 != null) {
                        bVar = new b();
                        bVar.pfK = jSONObject2.optString("last_status_name");
                        bVar.time = jSONObject2.optInt("time");
                        bVar.thumbUrl = jSONObject2.optString("thumb_url");
                        bVar.nkN = jSONObject2.optString("jump_url");
                        bVar.pfL = jSONObject2.optString("last_status_desc");
                    } else {
                        bVar = null;
                    }
                    mallOrderDetailObject.pfC = bVar;
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.MallOrderDetailObject", e22, "", new Object[0]);
                } catch (Throwable e222) {
                    x.printErrStackTrace("MicroMsg.MallOrderDetailObject", e222, "", new Object[0]);
                }
                try {
                    mallOrderDetailObject.pfD = MallOrderDetailObject.O(jSONObject);
                } catch (Throwable e2222) {
                    x.printErrStackTrace("MicroMsg.MallOrderDetailObject", e2222, "", new Object[0]);
                } catch (Throwable e22222) {
                    x.printErrStackTrace("MicroMsg.MallOrderDetailObject", e22222, "", new Object[0]);
                }
                try {
                    List list;
                    int i2;
                    JSONArray jSONArray = jSONObject.getJSONArray("normal_sections");
                    if (jSONArray == null || jSONArray.length() == 0) {
                        list = null;
                    } else {
                        List arrayList = new ArrayList();
                        i2 = 0;
                        boolean z = false;
                        while (i2 < jSONArray.length()) {
                            boolean z2;
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                            a aVar = new a();
                            aVar.kPM = jSONObject3.optInt("is_bar") != 0;
                            aVar.name = jSONObject3.optString("name");
                            if (TextUtils.isEmpty(aVar.name)) {
                                z2 = aVar.kPM;
                            } else {
                                if (z) {
                                    aVar.kPM = z;
                                }
                                z2 = aVar.kPM;
                                aVar.value = jSONObject3.optString(Columns.VALUE);
                                aVar.jumpUrl = jSONObject3.optString("jump_url");
                                aVar.jumpType = jSONObject3.optInt("jump_type");
                                arrayList.add(aVar);
                            }
                            i2++;
                            z = z2;
                        }
                        list = arrayList;
                    }
                    mallOrderDetailObject.pfE = list;
                    list = mallOrderDetailObject.pfE;
                    JSONObject optJSONObject = jSONObject.optJSONObject("evaluate_section");
                    if (optJSONObject != null) {
                        if (list == null) {
                            list = new ArrayList();
                        }
                        a aVar2 = new a();
                        if (optJSONObject.has(Columns.VALUE)) {
                            aVar2.value = optJSONObject.optString(Columns.VALUE);
                            aVar2.type = 2;
                        } else {
                            aVar2.type = 1;
                        }
                        i2 = optJSONObject.optInt("order", 0);
                        if (i2 >= 0 && i2 <= optJSONObject.length() + 1) {
                            list.add(i2, aVar2);
                        }
                    }
                } catch (Throwable e222222) {
                    x.printErrStackTrace("MicroMsg.MallOrderDetailObject", e222222, "", new Object[0]);
                } catch (Throwable e2222222) {
                    x.printErrStackTrace("MicroMsg.MallOrderDetailObject", e2222222, "", new Object[0]);
                }
                mallOrderDetailObject.pfH = jSONObject.optString("safeguard_url");
                mallOrderDetailObject.mbv = jSONObject.optString("share_url");
                mallOrderDetailObject.pfJ = jSONObject.optInt("modifyTimeStamp");
                if (mallOrderDetailObject.pfC != null && mallOrderDetailObject.pfJ <= 0) {
                    mallOrderDetailObject.pfJ = mallOrderDetailObject.pfC.time;
                }
                if (mallOrderDetailObject.pfB != null) {
                    mallOrderDetailObject.pfI = mallOrderDetailObject.pfB.pfI;
                    mallOrderDetailObject.fwG = mallOrderDetailObject.pfB.pgg;
                    mallOrderDetailObject.pfG = mallOrderDetailObject.pfB.pfG;
                    mallOrderDetailObject.pfF = mallOrderDetailObject.pfB.pfF;
                }
            }
        }
    }
}
