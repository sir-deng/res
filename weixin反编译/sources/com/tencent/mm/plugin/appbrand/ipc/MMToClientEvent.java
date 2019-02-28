package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MMToClientEvent extends MainProcessTask {
    public static final Creator<MMToClientEvent> CREATOR = new Creator<MMToClientEvent>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MMToClientEvent(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MMToClientEvent[i];
        }
    };
    private static volatile MMToClientEvent jeJ;
    private static final Set<a> jeK = new HashSet();
    public String appId;
    int fof;
    String fvi;
    public int jeG;
    String jeH;
    Object jeI;
    public int type;

    public interface a {
        void bc(Object obj);
    }

    /* synthetic */ MMToClientEvent(Parcel parcel, byte b) {
        this(parcel);
    }

    private MMToClientEvent() {
    }

    private MMToClientEvent(Parcel parcel) {
        f(parcel);
    }

    private static MMToClientEvent afE() {
        if (jeJ == null) {
            synchronized (MMToClientEvent.class) {
                if (jeJ == null) {
                    jeJ = new MMToClientEvent();
                }
            }
        }
        return jeJ;
    }

    public final void YA() {
        switch (this.jeG) {
            case 1:
                d.a(this);
                return;
            case 2:
                d.b(this);
                return;
            default:
                return;
        }
    }

    public static void sv(String str) {
        afE().jeG = 1;
        afE().appId = str;
        AppBrandMainProcessService.a(afE());
    }

    public static void sw(String str) {
        afE().jeG = 2;
        afE().appId = str;
        AppBrandMainProcessService.a(afE());
    }

    public static void a(a aVar) {
        synchronized (jeK) {
            jeK.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            synchronized (jeK) {
                jeK.remove(aVar);
            }
        }
    }

    private void bb(final Object obj) {
        if (obj != null) {
            final List linkedList = new LinkedList();
            synchronized (jeK) {
                for (a add : jeK) {
                    linkedList.add(add);
                }
            }
            c.Dt().F(new Runnable() {
                public final void run() {
                    for (a bc : linkedList) {
                        bc.bc(obj);
                    }
                }
            });
        }
    }

    public final void YB() {
        Map hashMap;
        switch (this.jeG) {
            case 3:
                com.tencent.mm.plugin.appbrand.jsapi.w.a aVar = new com.tencent.mm.plugin.appbrand.jsapi.w.a();
                hashMap = new HashMap();
                hashMap.put(Columns.TYPE, Integer.valueOf(this.type));
                hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, this.fvi);
                aVar.aA(this.appId, 0).v(hashMap).afI();
                return;
            case 4:
                com.tencent.mm.plugin.appbrand.jsapi.contact.d.a aVar2 = new com.tencent.mm.plugin.appbrand.jsapi.contact.d.a();
                hashMap = new HashMap();
                hashMap.put("count", Integer.valueOf(this.fof));
                hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, this.fvi);
                aVar2.aA(this.appId, 0).v(hashMap).afI();
                return;
            case 5:
                bb(this.jeI);
                return;
            default:
                return;
        }
    }

    public final void f(Parcel parcel) {
        this.jeG = parcel.readInt();
        this.appId = parcel.readString();
        this.type = parcel.readInt();
        this.fvi = parcel.readString();
        this.fof = parcel.readInt();
        try {
            this.jeH = parcel.readString();
            if (!bi.oN(this.jeH)) {
                Class cls = Class.forName(this.jeH);
                if (cls != null) {
                    this.jeI = parcel.readParcelable(cls.getClassLoader());
                }
            }
        } catch (Exception e) {
            x.v("MicroMsg.MMToClientEvent", "unparcel custom data e %s", e);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.jeG);
        parcel.writeString(this.appId);
        parcel.writeInt(this.type);
        parcel.writeString(this.fvi);
        parcel.writeInt(this.fof);
        if (!bi.oN(this.jeH) && this.jeI != null) {
            parcel.writeString(this.jeH);
            parcel.writeParcelable((Parcelable) this.jeI, i);
        }
    }
}
