package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.protocal.c.acw;
import com.tencent.mm.protocal.c.dd;
import java.util.ArrayList;

public class AppBrandSysConfig implements Parcelable {
    public static final Creator<AppBrandSysConfig> CREATOR = new Creator<AppBrandSysConfig>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandSysConfig(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandSysConfig[i];
        }
    };
    public String appId;
    public String foe;
    public String fsi;
    public int iRA;
    public int iRB;
    public int iRC;
    public int iRD;
    public int iRE;
    public int iRF;
    public int iRG;
    public boolean iRH;
    public long iRI;
    public int iRJ;
    public boolean iRK;
    public boolean iRL;
    public ArrayList<String> iRM;
    public ArrayList<String> iRN;
    public ArrayList<String> iRO;
    public ArrayList<String> iRP;
    public boolean iRQ;
    public int iRR;
    public int iRS;
    public int iRT;
    public final WxaPkgWrappingInfo iRU;
    public AppBrandGlobalSystemConfig iRV;
    dd iRW;
    public acw iRX;
    public boolean iRh;
    public String iRs;
    public String iRt;
    public boolean iRu;
    public boolean iRv;
    public boolean iRw;
    public boolean iRx;
    public AppRuntimeApiPermissionBundle iRy;
    public boolean iRz;
    public int uin;

    public final long aco() {
        return this.iRW == null ? 0 : this.iRW.vOU;
    }

    public AppBrandSysConfig() {
        this.iRu = false;
        this.iRv = false;
        this.iRw = false;
        this.iRx = false;
        this.iRh = false;
        this.iRU = new WxaPkgWrappingInfo();
    }

    public String toString() {
        return "AppBrandSysConfig{uin=" + this.uin + ", brandId='" + this.foe + '\'' + ", brandName='" + this.fsi + '\'' + ", appId='" + this.appId + '\'' + ", appIconUrl='" + this.iRs + '\'' + ", debugEnabled=" + this.iRu + ", performancePanelEnabled=" + this.iRv + ", maxWebViewDepth=" + this.iRA + ", maxBackgroundLifeSpan=" + this.iRB + ", maxRequestConcurrent=" + this.iRC + ", maxUploadConcurrent=" + this.iRD + ", maxDownloadConcurrent=" + this.iRE + ", maxWebsocketConnect=" + this.iRF + ", websocketSkipPortCheck=" + this.iRH + ", requestDomains=" + this.iRM + ", socketDomains=" + this.iRN + ", uploadDomains=" + this.iRO + ", downloadDomains=" + this.iRP + ", appPkgInfo=" + this.iRU + ", systemSettings=" + this.iRV + ", runningFlag=" + n.a(this.iRW) + '}';
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        int i2;
        byte b2 = (byte) 1;
        parcel.writeInt(this.uin);
        parcel.writeString(this.foe);
        parcel.writeString(this.fsi);
        parcel.writeString(this.appId);
        parcel.writeString(this.iRs);
        parcel.writeString(this.iRt);
        parcel.writeByte(this.iRu ? (byte) 1 : (byte) 0);
        if (this.iRv) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.iRw) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeParcelable(this.iRy, i);
        if (this.iRz) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(this.iRA);
        parcel.writeInt(this.iRB);
        parcel.writeInt(this.iRC);
        parcel.writeInt(this.iRD);
        parcel.writeInt(this.iRE);
        parcel.writeInt(this.iRF);
        parcel.writeInt(this.iRG);
        if (this.iRH) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeLong(this.iRI);
        parcel.writeInt(this.iRJ);
        if (this.iRK) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.iRL) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeStringList(this.iRM);
        parcel.writeStringList(this.iRN);
        parcel.writeStringList(this.iRO);
        parcel.writeStringList(this.iRP);
        parcel.writeParcelable(this.iRU, i);
        parcel.writeParcelable(this.iRV, i);
        if (!this.iRQ) {
            b2 = (byte) 0;
        }
        parcel.writeByte(b2);
        parcel.writeInt(this.iRR);
        parcel.writeInt(this.iRS);
        parcel.writeInt(this.iRT);
        c.fo(com.tencent.mm.ipcinvoker.wx_extension.c.class.getName()).a(this.iRX, parcel);
        c.a(this.iRW, parcel);
    }

    protected AppBrandSysConfig(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.iRu = false;
        this.iRv = false;
        this.iRw = false;
        this.iRx = false;
        this.iRh = false;
        this.uin = parcel.readInt();
        this.foe = parcel.readString();
        this.fsi = parcel.readString();
        this.appId = parcel.readString();
        this.iRs = parcel.readString();
        this.iRt = parcel.readString();
        this.iRu = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.iRv = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.iRw = z;
        this.iRy = (AppRuntimeApiPermissionBundle) parcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader());
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.iRz = z;
        this.iRA = parcel.readInt();
        this.iRB = parcel.readInt();
        this.iRC = parcel.readInt();
        this.iRD = parcel.readInt();
        this.iRE = parcel.readInt();
        this.iRF = parcel.readInt();
        this.iRG = parcel.readInt();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.iRH = z;
        this.iRI = parcel.readLong();
        this.iRJ = parcel.readInt();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.iRK = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.iRL = z;
        this.iRM = parcel.createStringArrayList();
        this.iRN = parcel.createStringArrayList();
        this.iRO = parcel.createStringArrayList();
        this.iRP = parcel.createStringArrayList();
        this.iRU = (WxaPkgWrappingInfo) parcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader());
        this.iRV = (AppBrandGlobalSystemConfig) parcel.readParcelable(AppBrandGlobalSystemConfig.class.getClassLoader());
        if (parcel.readByte() <= (byte) 0) {
            z2 = false;
        }
        this.iRQ = z2;
        this.iRR = parcel.readInt();
        this.iRS = parcel.readInt();
        this.iRT = parcel.readInt();
        this.iRX = (acw) c.a(com.tencent.mm.ipcinvoker.wx_extension.c.class.getName(), parcel);
        this.iRW = (dd) c.a(com.tencent.mm.ipcinvoker.wx_extension.c.class.getName(), parcel);
    }
}
