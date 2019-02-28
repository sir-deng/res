package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.protocal.c.cce;
import com.tencent.mm.protocal.c.ccf;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiGetSetting extends a {
    public static final int CTRL_INDEX = 236;
    public static final String NAME = "getSetting";

    private static final class GetSettingTask extends MainProcessTask {
        public static final Creator<GetSettingTask> CREATOR = new Creator<GetSettingTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new GetSettingTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetSettingTask[i];
            }
        };
        public j isW;
        public int jfG;
        private String jgn;
        public String mAppId;

        public GetSettingTask(Parcel parcel) {
            f(parcel);
        }

        public final void YB() {
            x.i("MicroMsg.JsApiGetSetting", "runInClientProcess");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errMsg", "getSetting:ok");
                jSONObject.put("authSetting", new JSONArray(bi.oM(this.jgn)));
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiGetSetting", "set json error!");
            }
            this.isW.E(this.jfG, jSONObject.toString());
            c.bl(this);
        }

        public final void YA() {
            a aVar = new a();
            aVar.hnT = new cce();
            aVar.hnU = new ccf();
            aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp_getauthinfo";
            aVar.hnS = 1196;
            aVar.hnV = 0;
            aVar.hnW = 0;
            com.tencent.mm.bp.a cce = new cce();
            cce.appId = this.mAppId;
            aVar.hnT = cce;
            u.a(aVar.Kf(), new u.a() {
                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    x.d("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (i == 0 && i2 == 0) {
                        ccf ccf = (ccf) bVar.hnR.hnY;
                        if (ccf == null) {
                            x.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq failed, response is null!");
                        } else {
                            int i3 = ccf.xhT.errCode;
                            String str2 = ccf.xhT.foE;
                            if (i3 == 0) {
                                LinkedList linkedList = ccf.xhU;
                                JSONArray jSONArray = new JSONArray();
                                Iterator it = linkedList.iterator();
                                while (it.hasNext()) {
                                    dy dyVar = (dy) it.next();
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("scope", dyVar.scope);
                                        jSONObject.put("state", dyVar.state);
                                        jSONObject.put("desc", dyVar.vPO);
                                        jSONArray.put(jSONObject);
                                    } catch (Exception e) {
                                        x.e("MicroMsg.JsApiGetSetting", "parse json failed : %s", e.getMessage());
                                    }
                                }
                                GetSettingTask.this.jgn = jSONArray.toString();
                                x.d("MicroMsg.JsApiGetSetting", "authInfo %s", jSONArray);
                            } else {
                                x.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq error %s", str2);
                            }
                        }
                        GetSettingTask.this.afF();
                    }
                    return 0;
                }
            }, true);
        }

        public final void f(Parcel parcel) {
            this.jgn = parcel.readString();
            this.mAppId = parcel.readString();
            this.jfG = parcel.readInt();
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.jgn);
            parcel.writeString(this.mAppId);
            parcel.writeInt(this.jfG);
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        MainProcessTask getSettingTask = new GetSettingTask();
        getSettingTask.mAppId = jVar.mAppId;
        getSettingTask.jfG = i;
        getSettingTask.isW = jVar;
        c.bk(getSettingTask);
        AppBrandMainProcessService.a(getSettingTask);
    }
}
