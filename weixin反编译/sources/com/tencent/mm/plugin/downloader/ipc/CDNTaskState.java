package com.tencent.mm.plugin.downloader.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CDNTaskState implements Parcelable {
    public static final Creator<CDNTaskState> CREATOR = new Creator<CDNTaskState>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            CDNTaskState cDNTaskState = new CDNTaskState();
            cDNTaskState.taskState = parcel.readInt();
            cDNTaskState.completeSize = parcel.readInt();
            cDNTaskState.fileTotalSize = parcel.readInt();
            return cDNTaskState;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CDNTaskState[i];
        }
    };
    public int completeSize = 0;
    public int fileTotalSize = 0;
    public int taskState = -100;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.taskState);
        parcel.writeInt(this.completeSize);
        parcel.writeInt(this.fileTotalSize);
    }
}
