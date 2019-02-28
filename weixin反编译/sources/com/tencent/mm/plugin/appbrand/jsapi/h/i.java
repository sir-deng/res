package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePicker;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.d;
import com.tencent.mm.plugin.appbrand.widget.picker.d.a;
import com.tencent.mm.plugin.appbrand.widget.picker.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class i extends c {
    int jta = -1;
    int jtb = -1;
    int jtc = Integer.MAX_VALUE;
    int jtd = Integer.MAX_VALUE;
    int jte = -1;
    int jtf = -1;

    i() {
    }

    final void s(JSONObject jSONObject) {
        int[] vL;
        JSONObject optJSONObject = jSONObject.optJSONObject("range");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("start");
            String optString2 = optJSONObject.optString("end");
            int[] vL2 = g.vL(optString);
            if (vL2 != null) {
                this.jta = vL2[0];
                this.jtb = vL2[1];
            }
            vL = g.vL(optString2);
            if (vL != null) {
                this.jtc = vL[0];
                this.jtd = vL[1];
            }
        }
        this.jta = Math.max(this.jta, 0);
        this.jtb = Math.max(this.jtb, 0);
        this.jtc = Math.min(this.jtc, 23);
        this.jtd = Math.min(this.jtd, 59);
        vL = g.vL(jSONObject.optString("current"));
        if (vL != null) {
            this.jte = vL[0];
            this.jtf = vL[1];
        }
        c.runOnUiThread(new Runnable() {
            public final void run() {
                b bVar = i.this;
                AppBrandTimePicker appBrandTimePicker = (AppBrandTimePicker) bVar.y(AppBrandTimePicker.class);
                if (appBrandTimePicker == null) {
                    bVar.f("fail cant init view", null);
                    return;
                }
                d dVar = bVar.kiC;
                int i = bVar.jta;
                int i2 = bVar.jtb;
                appBrandTimePicker.jta = i;
                appBrandTimePicker.jtb = i2;
                if (g.mG(appBrandTimePicker.jta) && appBrandTimePicker.kjh != null) {
                    appBrandTimePicker.kjh.setMinValue(appBrandTimePicker.jta);
                }
                i = bVar.jtc;
                i2 = bVar.jtd;
                appBrandTimePicker.jtc = i;
                appBrandTimePicker.jtd = i2;
                if (g.mG(appBrandTimePicker.jtc) && appBrandTimePicker.kjh != null) {
                    appBrandTimePicker.kjh.setMaxValue(appBrandTimePicker.jtc);
                }
                i = bVar.jte;
                i2 = bVar.jtf;
                if (g.mG(i) && g.mF(i2)) {
                    appBrandTimePicker.setCurrentHour(Integer.valueOf(i));
                    appBrandTimePicker.setCurrentMinute(Integer.valueOf(i2));
                }
                appBrandTimePicker.aou();
                dVar.kjc = new a<String>() {
                    public final /* synthetic */ void f(boolean z, Object obj) {
                        String str = (String) obj;
                        b bVar = i.this;
                        if (bVar.kiC != null) {
                            bVar.kiC.hide();
                        }
                        if (!z) {
                            bVar.f("cancel", null);
                        } else if (bi.oN(str)) {
                            bVar.f("fail", null);
                        } else {
                            Map hashMap = new HashMap(1);
                            hashMap.put(Columns.VALUE, str);
                            bVar.f("ok", hashMap);
                        }
                    }
                };
                dVar.show();
            }
        });
    }
}
