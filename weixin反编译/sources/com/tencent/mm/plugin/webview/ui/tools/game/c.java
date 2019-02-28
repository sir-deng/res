package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.mm.f.a.go;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    long mStartTime = 0;
    long nrp = 0;
    long nrq = 0;
    private long tLP = 0;
    Bundle tLQ;
    public a tLR = new a();

    public class a {
        public final void bUT() {
            c.this.tLQ = null;
            c.this.mStartTime = 0;
            c.this.nrp = 0;
            c.this.mStartTime = 0;
            c.this.nrq = 0;
        }

        public final void bUU() {
            c.this.mStartTime = System.currentTimeMillis();
            c.this.nrq = System.currentTimeMillis();
        }

        public final void Z(Bundle bundle) {
            c.this.tLQ = bundle;
            x.i("MicroMsg.GamePageTimeReport", "setGamePageReportData");
            if (bundle != null && bundle.getBoolean("game_page_report_time_begin")) {
                c.this.nrp = 0;
                c.this.mStartTime = System.currentTimeMillis();
                c.this.nrq = System.currentTimeMillis();
            }
        }

        public final void onResume() {
            if (c.this.nrq != 0) {
                c.this.nrq = System.currentTimeMillis();
            }
        }

        public final void onPause() {
            if (c.this.nrq != 0) {
                c.this.nrp += System.currentTimeMillis() - c.this.nrq;
            }
        }
    }

    public static /* synthetic */ void a(c cVar) {
        if (cVar.mStartTime != 0) {
            cVar.tLP = System.currentTimeMillis() - cVar.mStartTime;
            x.i("MicroMsg.GamePageTimeReport", "visit page(%s), stayTime:%sms, foregroundTime:%sms", Integer.valueOf(cVar.hashCode()), Long.valueOf(cVar.tLP), Long.valueOf(cVar.nrp));
            if (cVar.tLQ == null) {
                x.i("MicroMsg.GamePageTimeReport", "report game page time fail. ReportData is null");
                return;
            }
            String string = cVar.tLQ.getString("game_page_report_format_data");
            String string2 = cVar.tLQ.getString("game_page_report_tabs_format_data");
            if (!bi.oN(string)) {
                cVar.tLQ.putString("game_page_report_format_data", string.replace("__ALLSTAYTIME__", String.valueOf(cVar.tLP / 1000)).replace("__FOREGROUNDTIME__", String.valueOf(cVar.nrp / 1000)));
                x.i("MicroMsg.GamePageTimeReport", "visit page(%s), after replace time, reportFormatData:%s", Integer.valueOf(cVar.hashCode()), string);
            } else if (!bi.oN(string2)) {
                string = cVar.Qe(string2);
                if (!bi.oN(string)) {
                    cVar.tLQ.putString("game_page_report_tabs_format_data", string);
                    x.i("MicroMsg.GamePageTimeReport", "visit page(%s), after replace time, reportTabsFormatdata:%s", Integer.valueOf(cVar.hashCode()), string);
                } else {
                    return;
                }
            } else {
                return;
            }
            if (ad.cgj()) {
                Y(cVar.tLQ);
            } else {
                cVar.A(cVar.tLQ);
            }
            cVar.tLQ = null;
        }
    }

    public static void Y(Bundle bundle) {
        if (bundle != null) {
            Set<String> keySet = bundle.keySet();
            if (keySet != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    for (String str : keySet) {
                        jSONObject.put(str, bundle.get(str));
                    }
                    b goVar = new go();
                    goVar.fxy.pK = 4;
                    goVar.fxy.fxA = jSONObject.toString();
                    com.tencent.mm.sdk.b.a.xmy.m(goVar);
                } catch (JSONException e) {
                }
            }
        }
    }

    public void A(Bundle bundle) {
    }

    private String Qe(String str) {
        Matcher matcher = Pattern.compile("\\(.*?\\)").matcher(str);
        while (matcher.find()) {
            try {
                CharSequence oM = bi.oM(matcher.group());
                String replace = oM.replace("(", "").replace(")", "").replace(" ", "");
                CharSequence replace2;
                String[] split;
                if (replace.contains("__ALLSTAYTIME__")) {
                    replace2 = replace.replace("__ALLSTAYTIME__", String.valueOf(this.tLP / 1000));
                    split = replace2.split("\\+");
                    if (split.length == 2) {
                        replace2 = String.valueOf(Long.parseLong(split[0]) + Long.parseLong(split[1]));
                    }
                    str = str.replace(oM, replace2);
                } else if (oM.contains("__FOREGROUNDTIME__")) {
                    replace2 = replace.replace("__FOREGROUNDTIME__", String.valueOf(this.nrp / 1000));
                    split = replace2.split("\\+");
                    if (split.length == 2) {
                        replace2 = String.valueOf(Long.parseLong(split[0]) + Long.parseLong(split[1]));
                    }
                    str = str.replace(oM, replace2);
                }
            } catch (NumberFormatException e) {
                x.i("MicroMsg.GamePageTimeReport", "matchTimeMark, err:%s", e.getMessage());
                return null;
            }
        }
        return str;
    }
}
