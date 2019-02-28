package com.tencent.mm.plugin.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FileDownloadTaskInfo implements Parcelable {
    public static Creator<FileDownloadTaskInfo> CREATOR = new Creator<FileDownloadTaskInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FileDownloadTaskInfo(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FileDownloadTaskInfo[0];
        }
    };
    public String appId;
    public String frM;
    public int fxC;
    public long fxa;
    public long fxb;
    public long id;
    public boolean lyv;
    public String path;
    public int status;
    public String url;

    /* synthetic */ FileDownloadTaskInfo(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeString(this.url);
        parcel.writeInt(this.status);
        parcel.writeString(this.path);
        parcel.writeString(this.frM);
        parcel.writeString(this.appId);
        parcel.writeLong(this.fxa);
        parcel.writeLong(this.fxb);
        parcel.writeByte((byte) (this.lyv ? 1 : 0));
        parcel.writeInt(this.fxC);
    }

    public FileDownloadTaskInfo() {
        this.id = -1;
        this.url = "";
        this.status = 0;
        this.path = "";
        this.frM = "";
        this.appId = "";
        this.fxa = 0;
        this.fxb = 0;
        this.lyv = false;
        this.fxC = 2;
    }

    private FileDownloadTaskInfo(Parcel parcel) {
        boolean z = true;
        this.id = -1;
        this.url = "";
        this.status = 0;
        this.path = "";
        this.frM = "";
        this.appId = "";
        this.fxa = 0;
        this.fxb = 0;
        this.lyv = false;
        this.fxC = 2;
        this.id = parcel.readLong();
        this.url = parcel.readString();
        this.status = parcel.readInt();
        this.path = parcel.readString();
        this.frM = parcel.readString();
        this.appId = parcel.readString();
        this.fxa = parcel.readLong();
        this.fxb = parcel.readLong();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.lyv = z;
        this.fxC = parcel.readInt();
    }
}
