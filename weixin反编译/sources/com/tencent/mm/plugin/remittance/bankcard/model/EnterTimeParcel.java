package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.tf;

public class EnterTimeParcel implements Parcelable {
    public static final Creator<EnterTimeParcel> CREATOR = new Creator<EnterTimeParcel>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new EnterTimeParcel(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new EnterTimeParcel[i];
        }
    };
    public String hdx;
    public int pNg;
    public String pNh;
    public String pNi;
    public int pNj;

    public EnterTimeParcel(tf tfVar) {
        this.pNg = tfVar.pNg;
        this.pNh = tfVar.pNh;
        this.pNi = tfVar.pNi;
        this.pNj = tfVar.pNj;
        this.hdx = tfVar.hdx;
    }

    public EnterTimeParcel(Parcel parcel) {
        this.pNg = parcel.readInt();
        this.pNh = parcel.readString();
        this.pNi = parcel.readString();
        this.pNj = parcel.readInt();
        this.hdx = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.pNg);
        parcel.writeString(this.pNh);
        parcel.writeString(this.pNi);
        parcel.writeInt(this.pNj);
        parcel.writeString(this.hdx);
    }
}
