package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsApiBatchGetContact extends a {
    public static final int CTRL_INDEX = 410;
    public static final String NAME = "batchGetContact";

    private static class JsApiBatchGetContactTask extends MainProcessTask {
        public static final Creator<JsApiBatchGetContactTask> CREATOR = new Creator<JsApiBatchGetContactTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new JsApiBatchGetContactTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new JsApiBatchGetContactTask[i];
            }
        };
        private String foE;
        public ArrayList<String> jfY;
        private e jfZ;
        private j jga;
        private int jgb;
        private String jgc;

        public JsApiBatchGetContactTask(e eVar, j jVar, int i, ArrayList<String> arrayList) {
            this.jfZ = eVar;
            this.jga = jVar;
            this.jgb = i;
            this.jfY = arrayList;
        }

        public JsApiBatchGetContactTask(Parcel parcel) {
            f(parcel);
        }

        public final void YB() {
            if (bi.oN(this.jgc)) {
                this.jga.E(this.jgb, this.jfZ.e(this.foE, null));
            } else {
                this.jga.E(this.jgb, this.jgc);
            }
            afz();
        }

        public final void YA() {
            e.post(new Runnable() {
                public final void run() {
                    final boolean[] zArr = new boolean[]{false};
                    final Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        public final void run() {
                            synchronized (JsApiBatchGetContact.class) {
                                if (zArr[0]) {
                                    x.i("MicroMsg.JsApiBatchGetContact", "isCallBacked");
                                } else {
                                    zArr[0] = true;
                                    x.w("MicroMsg.JsApiBatchGetContact", "get contact timeout");
                                    JsApiBatchGetContactTask.this.foE = "fail:get contact timeout";
                                    JsApiBatchGetContactTask.this.afF();
                                }
                            }
                            cancel();
                            timer.cancel();
                        }
                    }, 60000);
                    try {
                        List arrayList = new ArrayList();
                        JSONArray jSONArray = new JSONArray();
                        Iterator it = JsApiBatchGetContactTask.this.jfY.iterator();
                        while (it.hasNext()) {
                            String str = (String) it.next();
                            Pair O = r.O(str, false);
                            if (O.second == null) {
                                arrayList.add(str);
                            }
                            synchronized (JsApiBatchGetContact.class) {
                                if (zArr[0]) {
                                    timer.cancel();
                                    return;
                                } else if (O.first == null || bi.oN(((WxaAttributes) O.first).field_appInfo)) {
                                    zArr[0] = true;
                                    JsApiBatchGetContactTask.this.foE = "fail:get contact fail";
                                    x.w("MicroMsg.JsApiBatchGetContact", "get contact fail");
                                    JsApiBatchGetContactTask.this.afF();
                                    timer.cancel();
                                    return;
                                } else {
                                    JSONObject optJSONObject = new JSONObject(((WxaAttributes) O.first).field_appInfo).optJSONObject("PluginInfo");
                                    if (optJSONObject == null) {
                                        optJSONObject = new JSONObject();
                                    }
                                    optJSONObject.put("appId", str);
                                    jSONArray.put(optJSONObject);
                                }
                            }
                        }
                        if (!bi.cC(arrayList)) {
                            x.i("MicroMsg.JsApiBatchGetContact", "needUpdateList size %d", Integer.valueOf(arrayList.size()));
                            if (!bi.cC(arrayList)) {
                                e.post(new com.tencent.mm.plugin.appbrand.config.r.AnonymousClass2(arrayList), "WxaAttrSync");
                            }
                        }
                        synchronized (JsApiBatchGetContact.class) {
                            if (zArr[0]) {
                                timer.cancel();
                                return;
                            }
                            zArr[0] = true;
                            x.i("MicroMsg.JsApiBatchGetContact", "try to stop timer");
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("errMsg", "batchGetContact:ok");
                            jSONObject.put("contactList", jSONArray);
                            JsApiBatchGetContactTask.this.jgc = jSONObject.toString();
                            JsApiBatchGetContactTask.this.afF();
                            timer.cancel();
                        }
                    } catch (Throwable e) {
                        try {
                            x.printErrStackTrace("MicroMsg.JsApiBatchGetContact", e, "", new Object[0]);
                            JsApiBatchGetContactTask.this.foE = "fail:" + e.getMessage();
                            JsApiBatchGetContactTask.this.afF();
                        } finally {
                            timer.cancel();
                        }
                    }
                }
            }, "AppBrandJsApiBatchGetContact");
        }

        public final void f(Parcel parcel) {
            this.jfY = parcel.readArrayList(getClass().getClassLoader());
            this.jgc = parcel.readString();
            this.foE = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeList(this.jfY);
            parcel.writeString(this.jgc);
            parcel.writeString(this.foE);
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiBatchGetContact", NAME);
        if (jSONObject == null) {
            jVar.E(i, e("fail:data is null or nil", null));
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("appIds");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            x.w("MicroMsg.JsApiBatchGetContact", "appIds is empty");
            jVar.E(i, e("fail:appIds is empty", null));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            arrayList.add(optJSONArray.optString(i2));
        }
        MainProcessTask jsApiBatchGetContactTask = new JsApiBatchGetContactTask(this, jVar, i, arrayList);
        jsApiBatchGetContactTask.afy();
        AppBrandMainProcessService.a(jsApiBatchGetContactTask);
    }
}
