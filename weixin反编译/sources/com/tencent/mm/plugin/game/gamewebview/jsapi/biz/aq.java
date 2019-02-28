package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

public final class aq extends a {
    public static final int CTRL_BYTE = 240;
    public static final String NAME = "resumeDownloadTask";
    private long fnS;
    private int scene;

    public final void a(final d dVar, JSONObject jSONObject, final int i) {
        x.i("MicroMsg.GameJsApiResumeDownloadTask", "GameJsApiResumeDownloadTask");
        Context aPO = dVar.aPO();
        this.fnS = jSONObject.optLong("download_id");
        this.scene = jSONObject.optInt("scene", 1000);
        if (this.fnS <= 0) {
            x.e("MicroMsg.GameJsApiResumeDownloadTask", "fail, invalid downloadId = " + this.fnS);
            dVar.E(i, a.e("resume_download_task:fail_invalid_downloadid", null));
        } else if (ao.isWifi(aPO)) {
            b(dVar, i);
        } else {
            h.a(aPO, aPO.getString(R.l.eWR), aPO.getString(R.l.eWS), aPO.getString(R.l.eWM), aPO.getString(R.l.dEy), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    aq.this.b(dVar, i);
                    dialogInterface.dismiss();
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    d dVar = dVar;
                    int i2 = i;
                    aq aqVar = aq.this;
                    dVar.E(i2, a.e("add_download_task:fail_network_not_wifi", null));
                }
            }, R.e.buj);
        }
    }

    void b(d dVar, int i) {
        GWMainProcessTask doDownloadTask = new DoDownloadTask();
        doDownloadTask.type = 3;
        doDownloadTask.fnS = this.fnS;
        doDownloadTask.scene = this.scene;
        GameWebViewMainProcessService.b(doDownloadTask);
        if (doDownloadTask.fqR) {
            dVar.E(i, a.e("resume_download_task:ok", null));
        } else {
            dVar.E(i, a.e("resume_download_task:fail", null));
        }
    }
}
