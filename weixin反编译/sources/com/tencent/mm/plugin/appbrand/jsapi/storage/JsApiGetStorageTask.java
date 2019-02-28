package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.appstorage.c.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.x;

class JsApiGetStorageTask extends MainProcessTask {
    public static final Creator<JsApiGetStorageTask> CREATOR = new Creator<JsApiGetStorageTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            JsApiGetStorageTask jsApiGetStorageTask = new JsApiGetStorageTask();
            jsApiGetStorageTask.f(parcel);
            return jsApiGetStorageTask;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiGetStorageTask[i];
        }
    };
    public String aAM;
    public String appId;
    public Runnable jfW;
    private boolean juK;
    private int juL;
    private int juM;
    private int juN;
    public String type;
    public String value;

    public final void YA() {
        c Zr = e.Zr();
        if (Zr == null) {
            afF();
            return;
        }
        Object[] aP = Zr.aP(this.appId, this.aAM);
        if (((a) aP[0]) == a.NONE) {
            if (k.i((String) aP[1], (String) aP[2]) > 102400) {
                this.juM = k.i((String) aP[1]);
                this.juN = k.i(r1);
                try {
                    k.h(this.jeC, r0, r1);
                } catch (Exception e) {
                    x.e("MicroMsg.JsApiGetStorageTask", e.getMessage());
                }
                this.juK = true;
            } else {
                this.juK = false;
                this.value = r0;
                this.type = r1;
            }
        }
        afF();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void YB() {
        /*
        r4 = this;
        r0 = r4.juK;
        if (r0 == 0) goto L_0x0030;
    L_0x0004:
        r0 = r4.jeC;	 Catch:{ Exception -> 0x003a }
        r0 = com.tencent.mm.plugin.appbrand.jsapi.storage.k.tg(r0);	 Catch:{ Exception -> 0x003a }
        r1 = r0.length();	 Catch:{ Exception -> 0x003a }
        r2 = r4.juM;	 Catch:{ Exception -> 0x003a }
        r3 = r4.juN;	 Catch:{ Exception -> 0x003a }
        r2 = r2 + r3;
        if (r1 != r2) goto L_0x002b;
    L_0x0015:
        r1 = 0;
        r2 = r4.juM;	 Catch:{ Exception -> 0x003a }
        r1 = r0.substring(r1, r2);	 Catch:{ Exception -> 0x003a }
        r4.value = r1;	 Catch:{ Exception -> 0x003a }
        r1 = r4.juM;	 Catch:{ Exception -> 0x003a }
        r2 = r4.juM;	 Catch:{ Exception -> 0x003a }
        r3 = r4.juN;	 Catch:{ Exception -> 0x003a }
        r2 = r2 + r3;
        r0 = r0.substring(r1, r2);	 Catch:{ Exception -> 0x003a }
        r4.type = r0;	 Catch:{ Exception -> 0x003a }
    L_0x002b:
        r0 = r4.jeC;
        com.tencent.mm.plugin.appbrand.jsapi.storage.k.th(r0);
    L_0x0030:
        r0 = r4.jfW;
        if (r0 == 0) goto L_0x0039;
    L_0x0034:
        r0 = r4.jfW;
        r0.run();
    L_0x0039:
        return;
    L_0x003a:
        r0 = move-exception;
        r1 = "MicroMsg.JsApiGetStorageTask";
        r0 = r0.getMessage();	 Catch:{ all -> 0x004b }
        com.tencent.mm.sdk.platformtools.x.e(r1, r0);	 Catch:{ all -> 0x004b }
        r0 = r4.jeC;
        com.tencent.mm.plugin.appbrand.jsapi.storage.k.th(r0);
        goto L_0x0030;
    L_0x004b:
        r0 = move-exception;
        r1 = r4.jeC;
        com.tencent.mm.plugin.appbrand.jsapi.storage.k.th(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageTask.YB():void");
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.juK = parcel.readByte() != (byte) 0;
        this.juL = parcel.readInt();
        this.juM = parcel.readInt();
        this.juN = parcel.readInt();
        this.aAM = parcel.readString();
        this.value = parcel.readString();
        this.type = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeByte(this.juK ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.juL);
        parcel.writeInt(this.juM);
        parcel.writeInt(this.juN);
        parcel.writeString(this.aAM);
        parcel.writeString(this.value);
        parcel.writeString(this.type);
    }
}
