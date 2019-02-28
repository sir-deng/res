package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.f.a.ib;
import com.tencent.mm.plugin.appbrand.c.c;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.sdk.platformtools.x;

public class HCEEventLogic {
    private static String jrW = null;
    private static b jrX = null;
    private static com.tencent.mm.plugin.appbrand.c.b jrY = new com.tencent.mm.plugin.appbrand.c.b() {
        public final void onCreate() {
            super.onCreate();
            HCEEventLogic.c(HCEEventLogic.jrW, 21, null);
        }

        public final void onResume() {
            super.onResume();
            HCEEventLogic.c(HCEEventLogic.jrW, 22, null);
        }

        public final void a(c cVar) {
            super.a(cVar);
            HCEEventLogic.c(HCEEventLogic.jrW, 23, null);
        }

        public final void onDestroy() {
            super.onDestroy();
            HCEEventLogic.c(HCEEventLogic.jrW, 24, null);
        }
    };

    public static final class HCEMMToAppBrandMessageEvent implements Parcelable {
        public static final Creator<HCEMMToAppBrandMessageEvent> CREATOR = new Creator<HCEMMToAppBrandMessageEvent>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new HCEMMToAppBrandMessageEvent(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new HCEMMToAppBrandMessageEvent[i];
            }
        };
        private String appId;
        private int jsa;
        private Bundle jsb;

        /* synthetic */ HCEMMToAppBrandMessageEvent(int i, String str, Bundle bundle, byte b) {
            this(i, str, bundle);
        }

        private HCEMMToAppBrandMessageEvent(int i, String str, Bundle bundle) {
            this.jsa = i;
            this.appId = str;
            this.jsb = bundle;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.jsa);
            parcel.writeString(this.appId);
            parcel.writeBundle(this.jsb);
        }

        HCEMMToAppBrandMessageEvent(Parcel parcel) {
            this.jsa = parcel.readInt();
            this.appId = parcel.readString();
            this.jsb = parcel.readBundle();
        }
    }

    private static class SendHCEEventToMMTask extends MainProcessTask {
        public static final Creator<SendHCEEventToMMTask> CREATOR = new Creator<SendHCEEventToMMTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SendHCEEventToMMTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SendHCEEventToMMTask[i];
            }
        };
        private String appId;
        private int jsa;
        private Bundle jsb;

        /* synthetic */ SendHCEEventToMMTask(String str, int i, Bundle bundle, byte b) {
            this(str, i, bundle);
        }

        private SendHCEEventToMMTask(String str, int i, Bundle bundle) {
            this.jsa = i;
            this.appId = str;
            this.jsb = bundle;
        }

        protected SendHCEEventToMMTask(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            com.tencent.mm.sdk.b.b ibVar = new ib();
            ibVar.fzt.type = this.jsa;
            ibVar.fzt.appId = this.appId;
            ibVar.fzt.extras = this.jsb;
            com.tencent.mm.sdk.b.a.xmy.m(ibVar);
            afF();
        }

        public final void YB() {
            super.YB();
            com.tencent.mm.plugin.appbrand.r.c.bl(this);
        }

        public int describeContents() {
            return 0;
        }

        public final void f(Parcel parcel) {
            super.f(parcel);
            this.jsa = parcel.readInt();
            this.appId = parcel.readString();
            this.jsb = parcel.readBundle();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.jsa);
            parcel.writeString(this.appId);
            parcel.writeBundle(this.jsb);
        }
    }

    public static final class a {
        private static boolean jrZ = false;

        public static synchronized void agT() {
            synchronized (a.class) {
                if (!jrZ) {
                    MMToClientEvent.a(new com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.a() {
                        public final void bc(Object obj) {
                            if (obj instanceof HCEMMToAppBrandMessageEvent) {
                                HCEMMToAppBrandMessageEvent hCEMMToAppBrandMessageEvent = (HCEMMToAppBrandMessageEvent) obj;
                                x.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic HCEMMToAppBrandMessageEvent onCustomDataNotify eventType: %d, appId: %s", Integer.valueOf(hCEMMToAppBrandMessageEvent.jsa), hCEMMToAppBrandMessageEvent.appId);
                                switch (hCEMMToAppBrandMessageEvent.jsa) {
                                    case 12:
                                        if (hCEMMToAppBrandMessageEvent.jsb != null) {
                                            HCEEventLogic.l(hCEMMToAppBrandMessageEvent.appId, hCEMMToAppBrandMessageEvent.jsb.getInt("errCode"), hCEMMToAppBrandMessageEvent.jsb.getString("errMsg"));
                                            return;
                                        }
                                        return;
                                    case 31:
                                    case 41:
                                        e pi = com.tencent.mm.plugin.appbrand.a.pi(hCEMMToAppBrandMessageEvent.appId);
                                        if (pi != null) {
                                            a.a(pi.mAppId, hCEMMToAppBrandMessageEvent.jsa, hCEMMToAppBrandMessageEvent.jsb);
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            }
                        }
                    });
                    jrZ = true;
                }
            }
        }
    }

    public interface b {
        void m(String str, int i, String str2);
    }

    static /* synthetic */ void l(String str, int i, String str2) {
        b bVar;
        synchronized (HCEEventLogic.class) {
            bVar = jrX;
        }
        if (bVar != null) {
            bVar.m(str, i, str2);
        }
    }

    public static void sZ(String str) {
        if (!(jrW == null || jrY == null)) {
            x.i("MicroMsg.HCEEventLogic", "alvinluo remove HCELifeCycleListener before add, appId: %s", jrW);
            com.tencent.mm.plugin.appbrand.c.b(jrW, jrY);
        }
        jrW = str;
        com.tencent.mm.plugin.appbrand.c.a(str, jrY);
    }

    public static void ta(String str) {
        if (str != null) {
            com.tencent.mm.plugin.appbrand.c.b(str, jrY);
        }
    }

    public static void a(b bVar) {
        synchronized (HCEEventLogic.class) {
            jrX = bVar;
        }
    }

    public static void b(String str, int i, Bundle bundle) {
        x.i("MicroMsg.HCEEventLogic", "alvinluo HCE EVENT mm to AppBrand, type: %d, appId: %s", Integer.valueOf(i), str);
        d.a(new HCEMMToAppBrandMessageEvent(i, str, bundle, (byte) 0));
    }

    public static void c(String str, int i, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        x.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic sendHCEEventToMM appId: %s, eventType: %d", str, Integer.valueOf(i));
        MainProcessTask sendHCEEventToMMTask = new SendHCEEventToMMTask(str, i, bundle, (byte) 0);
        com.tencent.mm.plugin.appbrand.r.c.bk(sendHCEEventToMMTask);
        AppBrandMainProcessService.a(sendHCEEventToMMTask);
    }
}
