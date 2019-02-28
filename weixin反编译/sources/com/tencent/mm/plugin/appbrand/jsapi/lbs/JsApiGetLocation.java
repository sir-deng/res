package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiGetLocation extends a {
    public static final int CTRL_INDEX = 37;
    public static final String NAME = "getLocation";
    private static final HashSet<String> jnD;
    private static final HashSet<a> jnE = new HashSet();

    private static final class LocationTask extends MainProcessTask {
        public static final Creator<LocationTask> CREATOR = new Creator<LocationTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LocationTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LocationTask[i];
            }
        };
        private double bhF;
        private double bhG;
        private double bhI;
        private j isW;
        private int jfG;
        private int jiv = 0;
        private JsApiGetLocation jnF;
        private boolean jnG = false;
        private String jnH;
        private boolean jnI;
        private boolean jnJ;
        private float jnK;
        private float jnL;
        private double jnM;
        private double jnN;
        private int jnO;
        private volatile a jnP = null;
        private int jnQ = 0;
        private long jnR = 0;
        private WeakReference<p> mPageRef;

        static /* synthetic */ void a(LocationTask locationTask) {
            c.bk(locationTask);
            ah.y(new Runnable() {
                public final void run() {
                    LocationTask.b(LocationTask.this);
                }
            });
            locationTask.jnQ = 1;
            AppBrandMainProcessService.a((MainProcessTask) locationTask);
        }

        static /* synthetic */ void b(LocationTask locationTask) {
            if (locationTask.mPageRef != null) {
                p pVar = (p) locationTask.mPageRef.get();
                if (pVar != null) {
                    locationTask.jiv = com.tencent.mm.plugin.appbrand.page.a.q(pVar.iuk).a(com.tencent.mm.plugin.appbrand.page.a.a.LBS);
                    locationTask.jnR = System.currentTimeMillis();
                }
            }
        }

        static /* synthetic */ void e(LocationTask locationTask) {
            com.tencent.mm.modelgeo.c.OV().c(locationTask.jnP);
            JsApiGetLocation.jnE.remove(locationTask.jnP);
            locationTask.jnP = null;
        }

        static /* synthetic */ boolean h(LocationTask locationTask) {
            return locationTask.jnP != null && JsApiGetLocation.jnE.contains(locationTask.jnP);
        }

        public final void YB() {
            super.YB();
            agG();
            c.bl(this);
            if (this.isW != null) {
                if (this.jnJ) {
                    Map hashMap = new HashMap(4);
                    hashMap.put("latitude", Float.valueOf(this.jnK));
                    hashMap.put("longitude", Float.valueOf(this.jnL));
                    hashMap.put("speed", Double.valueOf(this.bhI));
                    hashMap.put("accuracy", Double.valueOf(this.bhG));
                    if (this.jnI) {
                        hashMap.put("altitude", Double.valueOf(this.bhF));
                    }
                    if (b.cfx()) {
                        hashMap.put("provider", Integer.valueOf(this.jnO));
                    }
                    hashMap.put("verticalAccuracy", Double.valueOf(this.jnM));
                    hashMap.put("horizontalAccuracy", Double.valueOf(this.jnN));
                    this.isW.E(this.jfG, this.jnF.e("ok", hashMap));
                } else {
                    this.isW.E(this.jfG, this.jnF.e("fail", null));
                }
                this.jnG = true;
            }
        }

        public final void YA() {
            c.bk(this);
            switch (this.jnQ) {
                case 1:
                    this.jnP = new a() {
                        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                            if (!z) {
                                return true;
                            }
                            x.v("MicroMsg.JsApiGetLocation", "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f, altitude : %s", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3));
                            LocationTask.this.jnJ = true;
                            LocationTask.this.jnK = f2;
                            LocationTask.this.jnL = f;
                            LocationTask locationTask = LocationTask.this;
                            if (d == 0.0d) {
                                d = -1.0d;
                            }
                            locationTask.bhI = d;
                            LocationTask.this.bhG = d2;
                            LocationTask.this.bhF = d3;
                            LocationTask.this.jnM = 0.0d;
                            LocationTask.this.jnN = d2;
                            LocationTask.this.jnO = i;
                            if (d3 == 0.0d && LocationTask.this.jnI) {
                                g.Dt().g(new Runnable() {
                                    public final void run() {
                                        LocationTask.e(LocationTask.this);
                                        LocationTask.this.afF();
                                    }
                                }, 5000);
                                x.i("MicroMsg.JsApiGetLocation", "post delay 5 sec.");
                            } else {
                                x.i("MicroMsg.JsApiGetLocation", "Stop callback");
                                LocationTask.e(LocationTask.this);
                                LocationTask.this.afF();
                            }
                            return false;
                        }
                    };
                    new ag(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public final void run() {
                            x.i("MicroMsg.JsApiGetLocation", "Timeout, callback running? %b", Boolean.valueOf(LocationTask.h(LocationTask.this)));
                            if (LocationTask.h(LocationTask.this)) {
                                LocationTask.e(LocationTask.this);
                                LocationTask.this.jnJ = false;
                                LocationTask.this.afF();
                            }
                        }
                    }, 20000);
                    if (this.jnH.equalsIgnoreCase("gcj02")) {
                        com.tencent.mm.modelgeo.c.OV().b(this.jnP, false);
                    } else if (this.jnH.equalsIgnoreCase("wgs84")) {
                        com.tencent.mm.modelgeo.c.OV().a(this.jnP, false);
                    }
                    JsApiGetLocation.jnE.add(this.jnP);
                    return;
                case 2:
                    Iterator it = JsApiGetLocation.jnE.iterator();
                    while (it.hasNext()) {
                        com.tencent.mm.modelgeo.c.OV().c((a) it.next());
                    }
                    JsApiGetLocation.jnE.clear();
                    x.i("MicroMsg.JsApiGetLocation", "Stop All Location Callbacks");
                    return;
                default:
                    this.jnJ = false;
                    afF();
                    return;
            }
        }

        private void agG() {
            if (this.mPageRef != null) {
                p pVar = (p) this.mPageRef.get();
                if (pVar != null) {
                    long currentTimeMillis = System.currentTimeMillis() - this.jnR;
                    if (currentTimeMillis < 3000) {
                        pVar.getContentView().postDelayed(new Runnable() {
                            public final void run() {
                                LocationTask.this.agG();
                            }
                        }, 3000 - currentTimeMillis);
                        return;
                    } else {
                        com.tencent.mm.plugin.appbrand.page.a.q(pVar.iuk).ls(this.jiv);
                        return;
                    }
                }
            }
            if (this.isW != null) {
                com.tencent.mm.plugin.appbrand.page.a.q(this.isW.iuk).ls(this.jiv);
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            byte b = (byte) 1;
            super.writeToParcel(parcel, i);
            parcel.writeString(this.jnH);
            parcel.writeByte(this.jnI ? (byte) 1 : (byte) 0);
            if (!this.jnJ) {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            parcel.writeFloat(this.jnK);
            parcel.writeFloat(this.jnL);
            parcel.writeDouble(this.bhI);
            parcel.writeDouble(this.bhG);
            parcel.writeDouble(this.bhF);
            parcel.writeDouble(this.jnM);
            parcel.writeDouble(this.jnN);
            parcel.writeInt(this.jnQ);
            parcel.writeInt(this.jnO);
        }

        public final void f(Parcel parcel) {
            boolean z = true;
            super.f(parcel);
            this.jnH = parcel.readString();
            this.jnI = parcel.readByte() != (byte) 0;
            if (parcel.readByte() == (byte) 0) {
                z = false;
            }
            this.jnJ = z;
            this.jnK = parcel.readFloat();
            this.jnL = parcel.readFloat();
            this.bhI = parcel.readDouble();
            this.bhG = parcel.readDouble();
            this.bhF = parcel.readDouble();
            this.jnM = parcel.readDouble();
            this.jnN = parcel.readDouble();
            this.jnQ = parcel.readInt();
            this.jnO = parcel.readInt();
        }

        LocationTask() {
        }

        LocationTask(Parcel parcel) {
            f(parcel);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        jnD = hashSet;
        hashSet.add("gcj02");
        jnD.add("wgs84");
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        com.tencent.mm.plugin.report.service.g.pWK.h(840, 0);
        String optString = jSONObject.optString(Columns.TYPE, "wgs84");
        x.v("MicroMsg.JsApiGetLocation", "doGeoLocation, geoType = %s", optString);
        if (bi.oN(optString)) {
            optString = "wgs84";
        }
        if (bi.oN(optString) || jnD.contains(optString)) {
            p b = e.b(jVar);
            if (b == null) {
                jVar.E(i, e("fail", null));
                return;
            }
            LocationTask locationTask = new LocationTask();
            locationTask.isW = jVar;
            locationTask.jfG = i;
            locationTask.jnF = this;
            locationTask.jnH = optString;
            locationTask.mPageRef = new WeakReference(b);
            locationTask.jnI = jSONObject.optBoolean("altitude", false);
            if (a.i(jVar)) {
                com.tencent.mm.plugin.report.service.g.pWK.h(840, 1);
                LocationTask.a(locationTask);
                return;
            }
            com.tencent.mm.plugin.report.service.g.pWK.h(840, 2);
            jVar.E(i, e("fail:system permission denied", null));
            return;
        }
        x.e("MicroMsg.JsApiGetLocation", "doGeoLocation fail, unsupported type = %s", optString);
        com.tencent.mm.plugin.report.service.g.pWK.h(840, 3);
        jVar.E(i, e("fail:unsupported type", null));
    }
}
