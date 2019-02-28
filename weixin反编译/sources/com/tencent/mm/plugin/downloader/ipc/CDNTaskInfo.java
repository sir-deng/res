package com.tencent.mm.plugin.downloader.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CDNTaskInfo implements Parcelable {
    public static final Creator<CDNTaskInfo> CREATOR = new Creator<CDNTaskInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CDNTaskInfo(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CDNTaskInfo[i];
        }
    };
    public String downloadUrl;
    public String filePath;
    public boolean hvk;
    public String lxk;
    public String lxl;
    public int lxm;
    public int lxn;
    public boolean lxo;
    public boolean lxp;
    public String mediaId;

    /* synthetic */ CDNTaskInfo(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        byte b2 = (byte) 1;
        parcel.writeByte(this.hvk ? (byte) 1 : (byte) 0);
        parcel.writeString(this.downloadUrl);
        parcel.writeString(this.mediaId);
        parcel.writeString(this.filePath);
        parcel.writeString(this.lxk);
        parcel.writeString(this.lxl);
        parcel.writeInt(this.lxm);
        parcel.writeInt(this.lxn);
        if (this.lxo) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (!this.lxp) {
            b2 = (byte) 0;
        }
        parcel.writeByte(b2);
    }

    private CDNTaskInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.hvk = parcel.readByte() == (byte) 1;
        this.downloadUrl = parcel.readString();
        this.mediaId = parcel.readString();
        this.filePath = parcel.readString();
        this.lxk = parcel.readString();
        this.lxl = parcel.readString();
        this.lxm = parcel.readInt();
        this.lxn = parcel.readInt();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.lxo = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.lxp = z2;
    }

    public boolean equals(Object obj) {
        return obj == this || (obj != null && (obj instanceof CDNTaskInfo) && ((CDNTaskInfo) obj).downloadUrl.equals(this.downloadUrl));
    }

    public int hashCode() {
        return this.downloadUrl.hashCode();
    }

    public CDNTaskInfo(String str) {
        this.downloadUrl = str;
    }
}
