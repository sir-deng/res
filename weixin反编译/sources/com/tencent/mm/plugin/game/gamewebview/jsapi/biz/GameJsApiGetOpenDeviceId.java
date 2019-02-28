package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class GameJsApiGetOpenDeviceId extends a {
    public static final int CTRL_BYTE = 227;
    public static final String NAME = "getOpenDeviceId";

    private static class GetDeviceIdTask extends GWMainProcessTask {
        public static final Creator<GetDeviceIdTask> CREATOR = new Creator<GetDeviceIdTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new GetDeviceIdTask(parcel, (byte) 0);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetDeviceIdTask[i];
            }
        };
        public String ffG;
        public String ncu;

        /* synthetic */ GetDeviceIdTask(Parcel parcel, byte b) {
            this(parcel);
        }

        public final void YA() {
            this.ffG = q.yL();
            this.ncu = q.yM();
        }

        public final void f(Parcel parcel) {
            this.ffG = parcel.readString();
            this.ncu = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.ffG);
            parcel.writeString(this.ncu);
        }

        private GetDeviceIdTask(Parcel parcel) {
            f(parcel);
        }
    }

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiGetOpenDeviceId", "invoke");
        GWMainProcessTask getDeviceIdTask = new GetDeviceIdTask();
        GameWebViewMainProcessService.b(getDeviceIdTask);
        String aPS = dVar.aPS();
        if (bi.oN(getDeviceIdTask.ffG) || bi.oN(getDeviceIdTask.ncu) || bi.oN(aPS)) {
            dVar.E(i, a.e("getOpenDeviceId:fail", null));
            return;
        }
        String VF = ac.VF(ac.VF(aPS + getDeviceIdTask.ffG));
        String VF2 = ac.VF(ac.VF(aPS + getDeviceIdTask.ncu));
        Map hashMap = new HashMap();
        hashMap.put("deviceid", VF);
        hashMap.put("newDeviceId", VF2);
        dVar.E(i, a.e("getOpenDeviceId:ok", hashMap));
    }
}
