package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.x;

class JsApiSetStorageTask extends MainProcessTask {
    public static final Creator<JsApiSetStorageTask> CREATOR = new Creator<JsApiSetStorageTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            JsApiSetStorageTask jsApiSetStorageTask = new JsApiSetStorageTask();
            jsApiSetStorageTask.f(parcel);
            return jsApiSetStorageTask;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiSetStorageTask[i];
        }
    };
    private String aAM;
    public String appId;
    public Runnable jfW;
    private boolean juK;
    private int juL;
    private int juM;
    private int juN;
    public String result;
    private String type;
    private String value;

    JsApiSetStorageTask() {
    }

    public final void B(String str, String str2, String str3) {
        if (k.i(str, str2, str3) > 102400) {
            this.juL = k.i(str);
            this.juM = k.i(str2);
            this.juN = k.i(str3);
            try {
                k.h(this.jeC, str, str2, str3);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiSetStorageTask", e.getMessage());
            }
            this.juK = true;
            return;
        }
        this.juK = false;
        this.aAM = str;
        this.value = str2;
        this.type = str3;
    }

    private void ahc() {
        this.aAM = null;
        this.value = null;
        this.type = null;
    }

    public final void YB() {
        if (this.jfW != null) {
            this.jfW.run();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void YA() {
        /*
        r5 = this;
        r0 = r5.juK;
        if (r0 == 0) goto L_0x0046;
    L_0x0004:
        r0 = r5.jeC;	 Catch:{ Exception -> 0x0058 }
        r0 = com.tencent.mm.plugin.appbrand.jsapi.storage.k.tg(r0);	 Catch:{ Exception -> 0x0058 }
        r1 = r0.length();	 Catch:{ Exception -> 0x0058 }
        r2 = r5.juL;	 Catch:{ Exception -> 0x0058 }
        r3 = r5.juM;	 Catch:{ Exception -> 0x0058 }
        r2 = r2 + r3;
        r3 = r5.juN;	 Catch:{ Exception -> 0x0058 }
        r2 = r2 + r3;
        if (r1 != r2) goto L_0x0041;
    L_0x0018:
        r1 = 0;
        r2 = r5.juL;	 Catch:{ Exception -> 0x0058 }
        r1 = r0.substring(r1, r2);	 Catch:{ Exception -> 0x0058 }
        r5.aAM = r1;	 Catch:{ Exception -> 0x0058 }
        r1 = r5.juL;	 Catch:{ Exception -> 0x0058 }
        r2 = r5.juL;	 Catch:{ Exception -> 0x0058 }
        r3 = r5.juM;	 Catch:{ Exception -> 0x0058 }
        r2 = r2 + r3;
        r1 = r0.substring(r1, r2);	 Catch:{ Exception -> 0x0058 }
        r5.value = r1;	 Catch:{ Exception -> 0x0058 }
        r1 = r5.juL;	 Catch:{ Exception -> 0x0058 }
        r2 = r5.juM;	 Catch:{ Exception -> 0x0058 }
        r1 = r1 + r2;
        r2 = r5.juL;	 Catch:{ Exception -> 0x0058 }
        r3 = r5.juM;	 Catch:{ Exception -> 0x0058 }
        r2 = r2 + r3;
        r3 = r5.juN;	 Catch:{ Exception -> 0x0058 }
        r2 = r2 + r3;
        r0 = r0.substring(r1, r2);	 Catch:{ Exception -> 0x0058 }
        r5.type = r0;	 Catch:{ Exception -> 0x0058 }
    L_0x0041:
        r0 = r5.jeC;
        com.tencent.mm.plugin.appbrand.jsapi.storage.k.th(r0);
    L_0x0046:
        r0 = com.tencent.mm.plugin.appbrand.app.e.Zr();
        if (r0 != 0) goto L_0x0070;
    L_0x004c:
        r0 = "fail";
        r5.result = r0;
        r5.ahc();
        r5.afF();
    L_0x0057:
        return;
    L_0x0058:
        r0 = move-exception;
        r1 = "MicroMsg.JsApiSetStorageTask";
        r0 = r0.getMessage();	 Catch:{ all -> 0x0069 }
        com.tencent.mm.sdk.platformtools.x.e(r1, r0);	 Catch:{ all -> 0x0069 }
        r0 = r5.jeC;
        com.tencent.mm.plugin.appbrand.jsapi.storage.k.th(r0);
        goto L_0x0046;
    L_0x0069:
        r0 = move-exception;
        r1 = r5.jeC;
        com.tencent.mm.plugin.appbrand.jsapi.storage.k.th(r1);
        throw r0;
    L_0x0070:
        r1 = r5.appId;
        r2 = r5.aAM;
        r3 = r5.value;
        r4 = r5.type;
        r0 = r0.f(r1, r2, r3, r4);
        r1 = com.tencent.mm.plugin.appbrand.appstorage.c.a.NONE;
        if (r0 != r1) goto L_0x008c;
    L_0x0080:
        r0 = "ok";
        r5.result = r0;
    L_0x0085:
        r5.ahc();
        r5.afF();
        goto L_0x0057;
    L_0x008c:
        r1 = com.tencent.mm.plugin.appbrand.appstorage.c.a.QUOTA_REACHED;
        if (r0 != r1) goto L_0x0096;
    L_0x0090:
        r0 = "fail:quota reached";
        r5.result = r0;
        goto L_0x0085;
    L_0x0096:
        r0 = "fail";
        r5.result = r0;
        goto L_0x0085;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiSetStorageTask.YA():void");
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
        this.result = parcel.readString();
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
        parcel.writeString(this.result);
    }
}
