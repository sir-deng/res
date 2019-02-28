package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.b.c.a;
import com.tencent.mm.plugin.appbrand.appcache.b.d.b;
import com.tencent.mm.plugin.appbrand.config.m;
import com.tencent.mm.plugin.appbrand.config.m.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

class JsApiGetAppConfigTask extends MainProcessTask {
    public static final Creator<JsApiGetAppConfigTask> CREATOR = new Creator<JsApiGetAppConfigTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsApiGetAppConfigTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiGetAppConfigTask[i];
        }
    };
    public String aAM;
    public String appId;
    public Runnable jfW;
    public int scene;
    public int type;
    public String value;

    public JsApiGetAppConfigTask(Parcel parcel) {
        f(parcel);
    }

    public final void YA() {
        Pair v = ((b) e.u(b.class)).v(this.appId, 4, this.scene);
        if (((Boolean) v.first).booleanValue()) {
            int i = a.iJQ;
            a.o((long) ((Integer) v.second).intValue(), 166);
        }
        m.a(this.appId, this.type, 0, new c() {
            public final void qe(String str) {
                JsApiGetAppConfigTask.this.value = str;
                JsApiGetAppConfigTask.this.afF();
            }
        }, !((Boolean) v.first).booleanValue());
    }

    public final void YB() {
        if (this.jfW != null) {
            this.jfW.run();
        }
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.aAM = parcel.readString();
        this.value = parcel.readString();
        this.type = parcel.readInt();
        this.scene = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.aAM);
        parcel.writeString(this.value);
        parcel.writeInt(this.type);
        parcel.writeInt(this.scene);
    }
}
