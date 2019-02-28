package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RecoveryStatusItem extends RecoveryPersistentItem {
    public static final Creator<RecoveryStatusItem> CREATOR = new Creator<RecoveryStatusItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            RecoveryStatusItem recoveryStatusItem = new RecoveryStatusItem();
            recoveryStatusItem.processName = parcel.readString();
            recoveryStatusItem.njL = parcel.readString();
            recoveryStatusItem.clientVersion = parcel.readString();
            recoveryStatusItem.Aay = parcel.readInt();
            recoveryStatusItem.AaB = parcel.readInt();
            recoveryStatusItem.AaA = parcel.readInt();
            recoveryStatusItem.timestamp = parcel.readLong();
            return recoveryStatusItem;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RecoveryStatusItem[i];
        }
    };
    public int AaA;
    public int AaB;
    public int Aay;
    public String clientVersion;
    public String njL;
    public String processName;
    public long timestamp;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.processName);
        parcel.writeString(this.njL);
        parcel.writeString(this.clientVersion);
        parcel.writeInt(this.Aay);
        parcel.writeInt(this.AaB);
        parcel.writeInt(this.AaA);
        parcel.writeLong(this.timestamp);
    }

    public final boolean abw(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            String[] split = str.split(",");
            this.processName = split[0];
            this.njL = split[1];
            this.clientVersion = split[2];
            this.Aay = Integer.valueOf(split[3]).intValue();
            this.AaB = Integer.valueOf(split[4]).intValue();
            this.AaA = Integer.valueOf(split[5]).intValue();
            this.timestamp = Long.valueOf(split[6]).longValue();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public final String cEe() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.processName);
        stringBuffer.append(",");
        stringBuffer.append(this.njL);
        stringBuffer.append(",");
        stringBuffer.append(this.clientVersion);
        stringBuffer.append(",");
        stringBuffer.append(this.Aay);
        stringBuffer.append(",");
        stringBuffer.append(this.AaB);
        stringBuffer.append(",");
        stringBuffer.append(this.AaA);
        stringBuffer.append(",");
        stringBuffer.append(this.timestamp);
        return stringBuffer.toString();
    }
}
