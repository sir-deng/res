package com.tencent.mm.plugin.game.gamewebview.jsapi;

import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.JavascriptInterface;
import com.tencent.mm.plugin.game.gamewebview.a.b;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

public final class d {
    public Handler iWP;
    private Map<String, c> jfb;
    protected com.tencent.mm.plugin.game.gamewebview.ui.d nbQ;
    public JSONObject nbR;
    public HashSet<String> nbS = new HashSet();

    public d(com.tencent.mm.plugin.game.gamewebview.ui.d dVar) {
        this.nbQ = dVar;
        this.jfb = e.aPt();
        HandlerThread handlerThread = new HandlerThread("GameWebviewAsyncJSThread");
        handlerThread.start();
        this.iWP = new Handler(handlerThread.getLooper());
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final String invokeHandler(final String str, final String str2, final int i, long j) {
        x.i("MicroMsg.GameJsApiInterface", "api: %s, time: %d", str, Long.valueOf(System.currentTimeMillis() - j));
        int Ce = b.Ce(str);
        if (Ce > 0) {
            g.pWK.a(157, (long) Ce, 1, false);
        }
        String str3 = "";
        try {
            String v;
            boolean z = this.jfb.get(str) instanceof f;
            if (z) {
                v = v(str, str2, i);
            } else {
                this.iWP.post(new Runnable() {
                    public final void run() {
                        d.this.v(str, str2, i);
                    }
                });
                v = str3;
            }
            String str4 = "MicroMsg.GameJsApiInterface";
            String str5 = "invokeHandler, api: %s, data size: %d, sync: %b, time: %d";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            if (str2 == null) {
                Ce = 0;
            } else {
                Ce = str2.length();
            }
            objArr[1] = Integer.valueOf(Ce);
            objArr[2] = Boolean.valueOf(z);
            objArr[3] = Long.valueOf(System.currentTimeMillis() - r10);
            x.i(str4, str5, objArr);
            return v;
        } catch (Exception e) {
            x.e("MicroMsg.GameJsApiInterface", "Invoke Error: %s, %s\n%s", str, e.getMessage(), e.getStackTrace());
            throw e;
        }
    }

    final String v(String str, String str2, int i) {
        if (this.nbQ == null || this.nbQ.aPO() == null) {
            x.e("MicroMsg.GameJsApiInterface", "activity is null");
            return "";
        }
        String Ck;
        c cVar = (c) this.jfb.get(str);
        boolean z = cVar instanceof f;
        JSONObject sx = sx(str2);
        if (cVar == null) {
            Ck = Ck("system:function_not_exist");
        } else {
            boolean z2;
            if (this.nbS.contains(cVar.getName())) {
                this.nbS.remove(cVar.getName());
                z2 = true;
            } else {
                z2 = this.nbQ.bs(cVar.getName(), cVar.aPp());
            }
            if (z2) {
                try {
                    if (this.nbR != null) {
                        if (!bi.oN(this.nbR.optString("srcUsername"))) {
                            sx.put("src_username", this.nbR.optString("srcUsername"));
                        }
                        if (!bi.oN(this.nbR.optString("srcDisplayname"))) {
                            sx.put("src_displayname", this.nbR.optString("srcDisplayname"));
                        }
                        if (!bi.oN(this.nbR.optString("KTemplateId"))) {
                            sx.put("tempalate_id", this.nbR.optString("KTemplateId"));
                        }
                        sx.put("message_id", this.nbR.optLong("message_id"));
                        sx.put("message_index", this.nbR.optInt("message_index"));
                        sx.put("webview_scene", this.nbR.optInt("scene"));
                        sx.put("stastic_scene", this.nbR.optInt("stastic_scene"));
                    }
                    sx.put("current_url", this.nbQ.aPR());
                    sx.put("current_appid", this.nbQ.aPS());
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.GameJsApiInterface", e, "", new Object[0]);
                }
                if (z) {
                    Ck = "";
                } else {
                    a aVar = (a) cVar;
                    if (aVar.aPr() == 2) {
                        GameJsApiActivityTask gameJsApiActivityTask = new GameJsApiActivityTask(this.nbQ.aPO());
                        gameJsApiActivityTask.nbK = this.nbQ;
                        gameJsApiActivityTask.jgb = i;
                        gameJsApiActivityTask.nbN = aVar.getName();
                        gameJsApiActivityTask.jiz = sx.toString();
                        gameJsApiActivityTask.aLl();
                        Ck = null;
                    } else if (aVar.aPr() == 1) {
                        GWMainProcessTask gameJsApiMMTask = new GameJsApiMMTask();
                        gameJsApiMMTask.nbK = this.nbQ;
                        gameJsApiMMTask.jgb = i;
                        gameJsApiMMTask.nbN = aVar.getName();
                        gameJsApiMMTask.jiz = sx.toString();
                        gameJsApiMMTask.afy();
                        GameWebViewMainProcessService.a(gameJsApiMMTask);
                        Ck = null;
                    } else {
                        aVar.a(this.nbQ, sx, i);
                        Ck = null;
                    }
                }
            } else {
                Ck = Ck("system:access_denied");
            }
        }
        if (z) {
            return Ck;
        }
        if (Ck != null) {
            this.nbQ.E(i, Ck);
        }
        return "";
    }

    private static String Ck(String str) {
        Map hashMap = new HashMap();
        hashMap.put("err_msg", str);
        return new JSONObject(hashMap).toString();
    }

    private static JSONObject sx(String str) {
        try {
            if (bi.oN(str)) {
                str = "{}";
            }
            return new JSONObject(str);
        } catch (Exception e) {
            x.e("MicroMsg.GameJsApiInterface", e.getMessage());
            return new JSONObject();
        }
    }
}
