package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class JsApiRemoveStorageTask extends MainProcessTask {
    public static final Creator<JsApiRemoveStorageTask> CREATOR = new Creator<JsApiRemoveStorageTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            JsApiRemoveStorageTask jsApiRemoveStorageTask = new JsApiRemoveStorageTask();
            jsApiRemoveStorageTask.f(parcel);
            return jsApiRemoveStorageTask;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiRemoveStorageTask[i];
        }
    };
    public String aAM;
    public String appId;

    public final void YA() {
        c Zr = e.Zr();
        if (Zr != null) {
            Zr.aQ(this.appId, this.aAM);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.aAM);
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.aAM = parcel.readString();
    }
}
