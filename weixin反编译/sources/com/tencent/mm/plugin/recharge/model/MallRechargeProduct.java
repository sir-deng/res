package com.tencent.mm.plugin.recharge.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MallRechargeProduct implements Parcelable {
    public static final Creator<MallRechargeProduct> CREATOR = new Creator<MallRechargeProduct>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MallRechargeProduct(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MallRechargeProduct[i];
        }
    };
    public String appId;
    public String frQ;
    public boolean isDefault;
    public String lKx;
    public int pHA;
    public final boolean pHB;
    public boolean pHC = true;
    public String pHt;
    public String pHu;
    public float pHv = 0.0f;
    public float pHw = 0.0f;
    public boolean pHx;
    public int pHy;
    public int pHz;

    public MallRechargeProduct(boolean z) {
        this.pHB = z;
    }

    public final boolean isValid() {
        if (!this.pHx || this.pHy > 0) {
            return true;
        }
        return false;
    }

    public static void a(MallRechargeProduct mallRechargeProduct, MallRechargeProduct mallRechargeProduct2) {
        mallRechargeProduct2.appId = mallRechargeProduct.appId;
        mallRechargeProduct2.pHt = mallRechargeProduct.pHt;
        mallRechargeProduct2.frQ = mallRechargeProduct.frQ;
        mallRechargeProduct2.lKx = mallRechargeProduct.lKx;
        mallRechargeProduct2.pHu = mallRechargeProduct.pHu;
        mallRechargeProduct2.pHv = mallRechargeProduct.pHv;
        mallRechargeProduct2.pHw = mallRechargeProduct.pHw;
        mallRechargeProduct2.pHx = mallRechargeProduct.pHx;
        mallRechargeProduct2.pHy = mallRechargeProduct.pHy;
        mallRechargeProduct2.pHz = mallRechargeProduct.pHz;
        mallRechargeProduct2.isDefault = mallRechargeProduct.isDefault;
        mallRechargeProduct2.pHC = mallRechargeProduct.pHC;
        mallRechargeProduct2.pHA = mallRechargeProduct.pHA;
    }

    public int describeContents() {
        return 0;
    }

    public MallRechargeProduct(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.pHt = parcel.readString();
        this.appId = parcel.readString();
        this.frQ = parcel.readString();
        this.lKx = parcel.readString();
        this.pHu = parcel.readString();
        this.pHv = parcel.readFloat();
        this.pHw = parcel.readFloat();
        this.pHx = parcel.readInt() == 1;
        this.pHy = parcel.readInt();
        this.pHz = parcel.readInt();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isDefault = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.pHB = z2;
        this.pHA = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.pHt);
        parcel.writeString(this.appId);
        parcel.writeString(this.frQ);
        parcel.writeString(this.lKx);
        parcel.writeString(this.pHu);
        parcel.writeFloat(this.pHv);
        parcel.writeFloat(this.pHw);
        parcel.writeInt(this.pHx ? 1 : 0);
        parcel.writeInt(this.pHy);
        parcel.writeInt(this.pHz);
        if (this.isDefault) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.pHB) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeInt(this.pHA);
    }
}
