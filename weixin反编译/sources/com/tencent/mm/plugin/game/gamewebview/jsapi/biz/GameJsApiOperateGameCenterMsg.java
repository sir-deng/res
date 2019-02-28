package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.f.a.gr;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class GameJsApiOperateGameCenterMsg extends a {
    public static final int CTRL_BYTE = 174;
    public static final String NAME = "operateGameCenterMsg";

    private static class OperateGameCenterMsgTask extends GWMainProcessTask {
        public static Creator<OperateGameCenterMsgTask> CREATOR = new Creator<OperateGameCenterMsgTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new OperateGameCenterMsgTask(parcel, (byte) 0);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OperateGameCenterMsgTask[i];
            }
        };
        public String fxA;
        public Runnable jfW;
        public int pK;
        public String result;

        /* synthetic */ OperateGameCenterMsgTask(Parcel parcel, byte b) {
            this(parcel);
        }

        public final void YA() {
            b grVar = new gr();
            grVar.fxF.pK = this.pK;
            grVar.fxF.fxA = this.fxA;
            com.tencent.mm.sdk.b.a.xmy.m(grVar);
            this.result = grVar.fxG.fxH;
            afF();
        }

        public final void YB() {
            if (this.jfW != null) {
                this.jfW.run();
            }
        }

        public final void f(Parcel parcel) {
            this.pK = parcel.readInt();
            this.fxA = parcel.readString();
            this.result = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.pK);
            parcel.writeString(this.fxA);
            parcel.writeString(this.result);
        }

        private OperateGameCenterMsgTask(Parcel parcel) {
            f(parcel);
        }
    }

    public final void a(final d dVar, JSONObject jSONObject, final int i) {
        String str = null;
        x.i("MicroMsg.GameJsApiOperateGameCenterMsg", "invoke");
        if (jSONObject == null) {
            x.i("MicroMsg.GameJsApiOperateGameCenterMsg", "data is null");
            dVar.E(i, a.e("getGameMessages:fail_invalid_data", null));
            return;
        }
        int optInt = jSONObject.optInt("cmd");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        final GWMainProcessTask operateGameCenterMsgTask = new OperateGameCenterMsgTask();
        operateGameCenterMsgTask.pK = optInt;
        if (optJSONObject != null) {
            str = optJSONObject.toString();
        }
        operateGameCenterMsgTask.fxA = str;
        operateGameCenterMsgTask.jfW = new Runnable() {
            public final void run() {
                operateGameCenterMsgTask.afz();
                Map hashMap = new HashMap();
                hashMap.put("result", bi.oM(operateGameCenterMsgTask.result));
                dVar.E(i, a.e("getGameMessages:ok", hashMap));
            }
        };
        operateGameCenterMsgTask.afy();
        GameWebViewMainProcessService.a(operateGameCenterMsgTask);
    }
}
