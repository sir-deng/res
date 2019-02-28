package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.sdk.platformtools.x;

public class SightCaptureResult implements Parcelable {
    public static final Creator<SightCaptureResult> CREATOR = new Creator<SightCaptureResult>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SightCaptureResult(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SightCaptureResult[i];
        }
    };
    public boolean owe = false;
    public boolean owf = false;
    public boolean owg = true;
    public String owh = "";
    public String owi = "";
    public String owj = "";
    public String owk = "";
    public int owl = 0;
    public aqp owm = new aqp();
    public String own = "";

    public SightCaptureResult(boolean z, String str, String str2, String str3, String str4, int i, aqp aqp) {
        this.owg = z;
        this.owh = str;
        this.owi = str2;
        this.owj = str3;
        this.owl = i;
        this.owm = aqp;
        this.owk = str4;
        this.owe = true;
        this.owf = false;
    }

    public SightCaptureResult(boolean z, String str) {
        this.owg = z;
        this.own = str;
        this.owe = false;
        this.owf = true;
    }

    protected SightCaptureResult(Parcel parcel) {
        boolean z;
        this.owe = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.owf = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.owg = z;
        this.owh = parcel.readString();
        this.owi = parcel.readString();
        this.owj = parcel.readString();
        this.owk = parcel.readString();
        this.owl = parcel.readInt();
        this.own = parcel.readString();
        try {
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            this.owm = new aqp();
            this.owm.aH(bArr);
        } catch (Exception e) {
            x.e("MicroMsg.SightCaptureResult", "read ext info error: %s", e.getMessage());
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeByte((byte) (this.owe ? 1 : 0));
        if (this.owf) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.owg) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(this.owh);
        parcel.writeString(this.owi);
        parcel.writeString(this.owj);
        parcel.writeString(this.owk);
        parcel.writeInt(this.owl);
        parcel.writeString(this.own);
        try {
            byte[] toByteArray = this.owm.toByteArray();
            parcel.writeInt(toByteArray.length);
            parcel.writeByteArray(toByteArray);
        } catch (Exception e) {
            x.e("MicroMsg.SightCaptureResult", "write ext info error");
        }
    }
}
