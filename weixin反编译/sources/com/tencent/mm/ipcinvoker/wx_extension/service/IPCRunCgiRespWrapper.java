package com.tencent.mm.ipcinvoker.wx_extension.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ad.b;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.ipcinvoker.wx_extension.a;

public class IPCRunCgiRespWrapper implements Parcelable {
    public static final Creator<IPCRunCgiRespWrapper> CREATOR = new Creator<IPCRunCgiRespWrapper>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IPCRunCgiRespWrapper(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCRunCgiRespWrapper[i];
        }
    };
    public int errCode;
    public int errType;
    public String foE;
    public b gLB;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.errType);
        parcel.writeInt(this.errCode);
        parcel.writeString(this.foE);
        c.a(this.gLB, parcel);
    }

    IPCRunCgiRespWrapper(Parcel parcel) {
        this.errType = parcel.readInt();
        this.errCode = parcel.readInt();
        this.foE = parcel.readString();
        this.gLB = (b) c.a(a.class.getName(), parcel);
    }

    public static IPCRunCgiRespWrapper BN() {
        IPCRunCgiRespWrapper iPCRunCgiRespWrapper = new IPCRunCgiRespWrapper();
        iPCRunCgiRespWrapper.gLB = null;
        iPCRunCgiRespWrapper.foE = null;
        iPCRunCgiRespWrapper.errType = 3;
        iPCRunCgiRespWrapper.errCode = -2;
        return iPCRunCgiRespWrapper;
    }
}
