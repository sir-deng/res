package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class WxaPkgWrappingInfo extends ModulePkgInfo implements Parcelable {
    public static final Creator<WxaPkgWrappingInfo> CREATOR = new Creator<WxaPkgWrappingInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WxaPkgWrappingInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WxaPkgWrappingInfo[i];
        }
    };
    public int iJa;
    public int iJb;
    public long iJc;
    public boolean iJd;
    public final LinkedList<ModulePkgInfo> iJe;
    public final Map<String, String> iJf;

    final void aaB() {
        Iterator it = this.iJe.iterator();
        while (it.hasNext()) {
            ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
            String pQ = a.pQ(modulePkgInfo.name);
            this.iJf.put(pQ, modulePkgInfo.name);
            modulePkgInfo.name = pQ;
        }
    }

    public static WxaPkgWrappingInfo qh(String str) {
        if (bi.oN(str)) {
            return null;
        }
        ag agVar = new ag(new File(str));
        if (!agVar.iHO) {
            x.e("MicroMsg.WxaPkgWrappingInfo#obtain", "wxPkg invalid, path = %s ", str);
            agVar.close();
            return null;
        } else if (agVar.aai()) {
            agVar.close();
            WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo();
            wxaPkgWrappingInfo.iGz = str;
            wxaPkgWrappingInfo.iJd = false;
            wxaPkgWrappingInfo.frM = g.bV(str);
            return wxaPkgWrappingInfo;
        } else {
            x.e("MicroMsg.WxaPkgWrappingInfo#obtain", "wxPkg read info failed, path = %s ", str);
            agVar.close();
            return null;
        }
    }

    public WxaPkgWrappingInfo() {
        this.iJe = new LinkedList();
        this.iJf = new HashMap();
        this.name = "__APP__";
    }

    public WxaPkgWrappingInfo(Parcel parcel) {
        this();
        readFromParcel(parcel);
    }

    public final void a(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        wxaPkgWrappingInfo.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        readFromParcel(obtain);
        obtain.recycle();
    }

    public final String toString() {
        return "WxaPkgWrappingInfo{pkgDebugType=" + this.iJa + ", pkgVersion=" + this.iJb + ", pkgCreateTime=" + this.iJc + ", localPkg=" + this.iJd + ", md5='" + this.frM + '\'' + ", pkgPath='" + this.iGz + '\'' + '}';
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.iJa);
        parcel.writeInt(this.iJb);
        parcel.writeLong(this.iJc);
        parcel.writeByte(this.iJd ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.iJe);
    }

    public final void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.iJa = parcel.readInt();
        this.iJb = parcel.readInt();
        this.iJc = parcel.readLong();
        this.iJd = parcel.readByte() != (byte) 0;
        parcel.readTypedList(this.iJe, ModulePkgInfo.CREATOR);
    }
}
