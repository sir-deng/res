package com.tencent.mm.plugin.wallet_core.model.mall;

import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.r.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static int sWF = -256;
    public static int sWG = 621019136;
    public static int sWH = 637534720;

    public static ArrayList<MallNews> v(JSONArray jSONArray) {
        try {
            ArrayList<MallNews> arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                MallNews mallNews = new MallNews(jSONObject.optString("activity_jump_funcid"));
                mallNews.sWN = jSONObject.optString("activity_icon_link");
                mallNews.sWL = jSONObject.optString("activity_msg_content");
                mallNews.sWP = jSONObject.optString("activity_tips");
                arrayList.add(mallNews);
            }
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MallLogic", e, "", new Object[0]);
            return null;
        }
    }

    public static ArrayList<a> w(JSONArray jSONArray) {
        try {
            ArrayList<a> arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                a aVar = new a();
                aVar.sWx = jSONObject.optInt("banner_id");
                aVar.sWy = jSONObject.optString("banner_title");
                aVar.sWz = jSONObject.optString("banner_link");
                arrayList.add(aVar);
            }
            return arrayList;
        } catch (JSONException e) {
            x.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + e.getMessage());
            return null;
        }
    }

    public static SparseArray<String> x(JSONArray jSONArray) {
        try {
            SparseArray<String> sparseArray = new SparseArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                int optInt = jSONObject.optInt("type_id", 0);
                if (optInt != 0) {
                    sparseArray.put(optInt, jSONObject.optString("type_name"));
                }
            }
            return sparseArray;
        } catch (JSONException e) {
            x.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + e.getMessage());
            return null;
        }
    }

    public static void ch(List<a> list) {
        if (list == null || list.size() <= 0) {
            x.w("MicroMsg.MallLogic", "func[setBannerRedDotClick] actList null or empty");
            return;
        }
        int i = ((a) list.get(0)).sWx;
        x.d("MicroMsg.MallLogic", "func[setBannerRedDotClick], lastClickedListMaxId" + i);
        g.Dr();
        g.Dq().Db().set(270342, Integer.valueOf(i));
        g.Dr();
        g.Dq().Db().lO(true);
    }

    public static ArrayList<MallFunction> y(JSONArray jSONArray) {
        try {
            ArrayList<MallFunction> arrayList = new ArrayList();
            int length = jSONArray.length();
            x.d("MicroMsg.MallLogic", "functions.jsonArray.length : " + length);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                MallFunction mallFunction = new MallFunction();
                mallFunction.pHt = jSONObject.getString("func_id");
                mallFunction.fJD = jSONObject.getString("func_name");
                mallFunction.sWA = jSONObject.optString("func_icon_url");
                mallFunction.orf = jSONObject.optString("hd_icon_url");
                mallFunction.org = jSONObject.optString("func_foregroud_icon_url");
                mallFunction.fMx = jSONObject.optString("native_url");
                mallFunction.nAW = jSONObject.optString("h5_url");
                mallFunction.type = jSONObject.optInt("property_type", 0);
                mallFunction.sWD = jSONObject.optString("third_party_disclaimer");
                mallFunction.sWE = jSONObject.optInt("download_restrict", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("remark_name_list");
                if (optJSONArray != null) {
                    mallFunction.sWB = new ArrayList();
                    int length2 = optJSONArray.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        mallFunction.sWB.add(optJSONArray.getString(i2));
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("activity_info_list");
                if (!(optJSONArray2 == null || optJSONArray2.length() == 0)) {
                    String str = mallFunction.pHt;
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(0);
                    MallNews mallNews = new MallNews(str);
                    mallNews.sbN = jSONObject2.optString("activity_id");
                    mallNews.fsK = jSONObject2.optString("activity_ticket");
                    mallNews.sWL = jSONObject2.optString("activity_msg_content");
                    mallNews.sWM = jSONObject2.optString("activity_link");
                    mallNews.sWN = jSONObject2.optString("activity_icon_link");
                    mallNews.sWO = jSONObject2.optInt("activity_expired_time");
                    mallNews.sWP = jSONObject2.optString("activity_tips");
                    mallNews.sUJ = jSONObject2.optInt("activity_type");
                    mallNews.sWS = jSONObject2.optString("activity_url");
                    mallNews.sWQ = jSONObject2.optInt("is_msg_reserved");
                    mallFunction.sWC = mallNews;
                }
                arrayList.add(mallFunction);
            }
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MallLogic", e, "", new Object[0]);
            return null;
        }
    }

    public static String bMP() {
        TelephonyManager telephonyManager = (TelephonyManager) ad.getContext().getSystemService("phone");
        String str = "";
        if (telephonyManager != null) {
            return telephonyManager.getNetworkCountryIso();
        }
        return str;
    }

    public static void zC(int i) {
        boolean z;
        if ((d.vHl & sWF) == i) {
            g.Dr();
            int intValue = ((Integer) g.Dq().Db().get(270343, Integer.valueOf(0))).intValue();
            if (i != intValue) {
                x.d("MicroMsg.MallLogic", "Mall reddot show, targetV=" + i + ", clickedV=" + intValue);
                z = true;
                if (z && q.Gh()) {
                    x.d("MicroMsg.MallLogic", "Show mall entry redot");
                    c.Bx().o(262156, true);
                    g.Dr();
                    g.Dq().Db().set(270343, Integer.valueOf(i));
                    g.Dr();
                    g.Dq().Db().a(a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
                    return;
                }
            }
        }
        z = false;
        if (z) {
        }
    }
}
