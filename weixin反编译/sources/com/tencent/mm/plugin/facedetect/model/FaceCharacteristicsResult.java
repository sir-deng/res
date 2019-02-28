package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceStatus;

public class FaceCharacteristicsResult implements Parcelable {
    public static final Creator<FaceCharacteristicsResult> CREATOR = new Creator<FaceCharacteristicsResult>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FaceCharacteristicsResult(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FaceCharacteristicsResult[i];
        }
    };
    public int errCode;
    public String foE;
    public FaceStatus mlM;

    protected FaceCharacteristicsResult(Parcel parcel) {
        this.errCode = parcel.readInt();
        this.foE = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mlM, i);
        parcel.writeInt(this.errCode);
        parcel.writeString(this.foE);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "FaceCharacteristicsResult{mStatus=" + this.mlM + ", errCode=" + this.errCode + ", errMsg='" + this.foE + '\'' + '}';
    }

    public static boolean pJ(int i) {
        return i >= 10 && i < 100;
    }

    public static boolean pK(int i) {
        return i > 0 && i < 10;
    }

    public static boolean pL(int i) {
        return i <= 0;
    }

    public final void ag(int i, String str) {
        this.errCode = i;
        this.foE = str;
    }
}
