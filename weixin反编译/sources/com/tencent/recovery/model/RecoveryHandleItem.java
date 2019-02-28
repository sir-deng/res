package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RecoveryHandleItem extends RecoveryPersistentItem {
    public static final Creator<RecoveryHandleItem> CREATOR = new Creator<RecoveryHandleItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            RecoveryHandleItem recoveryHandleItem = new RecoveryHandleItem();
            recoveryHandleItem.njL = parcel.readString();
            recoveryHandleItem.clientVersion = parcel.readString();
            recoveryHandleItem.aAM = parcel.readString();
            recoveryHandleItem.processName = parcel.readString();
            recoveryHandleItem.AaN = parcel.readString();
            recoveryHandleItem.timestamp = parcel.readLong();
            return recoveryHandleItem;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RecoveryHandleItem[i];
        }
    };
    public String AaN;
    public String aAM;
    public String clientVersion;
    public String njL;
    public String processName;
    public long timestamp;

    public final String cEe() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.njL);
        stringBuffer.append(",");
        stringBuffer.append(this.clientVersion);
        stringBuffer.append(",");
        stringBuffer.append(this.aAM);
        stringBuffer.append(",");
        stringBuffer.append(this.processName);
        stringBuffer.append(",");
        stringBuffer.append(this.AaN);
        stringBuffer.append(",");
        stringBuffer.append(this.timestamp);
        return stringBuffer.toString();
    }

    public final boolean abw(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            String[] split = str.split(",");
            this.njL = split[0];
            this.clientVersion = split[1];
            this.aAM = split[2];
            this.processName = split[3];
            this.AaN = split[4];
            this.timestamp = Long.valueOf(split[5]).longValue();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.njL);
        parcel.writeString(this.clientVersion);
        parcel.writeString(this.aAM);
        parcel.writeString(this.processName);
        parcel.writeString(this.AaN);
        parcel.writeLong(this.timestamp);
    }
}
