package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import java.util.ArrayList;

public class JsApiGetStorageInfoTask extends MainProcessTask {
    public static final Creator<JsApiGetStorageInfoTask> CREATOR = new Creator<JsApiGetStorageInfoTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            JsApiGetStorageInfoTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
            jsApiGetStorageInfoTask.f(parcel);
            return jsApiGetStorageInfoTask;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiGetStorageInfoTask[i];
        }
    };
    public String appId;
    public int asN;
    public Runnable jfW;
    public ArrayList<String> juJ;
    public int size;

    public final void YA() {
        c Zr = e.Zr();
        if (Zr == null) {
            afF();
            return;
        }
        Object[] qm = Zr.qm(this.appId);
        this.juJ = (ArrayList) qm[0];
        this.size = (int) Math.ceil(((Integer) qm[1]).doubleValue() / 1000.0d);
        this.asN = (int) Math.ceil(((Integer) qm[2]).doubleValue() / 1000.0d);
        afF();
    }

    public final void YB() {
        if (this.jfW != null) {
            this.jfW.run();
        }
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.juJ = parcel.createStringArrayList();
        this.size = parcel.readInt();
        this.asN = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeStringList(this.juJ);
        parcel.writeInt(this.size);
        parcel.writeInt(this.asN);
    }
}
