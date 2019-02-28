package com.tencent.mm.plugin.appbrand.permission;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.bp.b;
import com.tencent.mm.protocal.c.nk;

public final class AppRuntimeApiPermissionBundle implements Parcelable {
    public static final Creator<AppRuntimeApiPermissionBundle> CREATOR = new Creator<AppRuntimeApiPermissionBundle>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppRuntimeApiPermissionBundle(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppRuntimeApiPermissionBundle[i];
        }
    };
    final byte[] jMf;
    final byte[] jMg;
    final byte[] jMh;

    /* synthetic */ AppRuntimeApiPermissionBundle(Parcel parcel, byte b) {
        this(parcel);
    }

    public AppRuntimeApiPermissionBundle(nk nkVar) {
        this.jMf = nkVar.wcZ.toByteArray();
        this.jMg = ((b) nkVar.wda.get(0)).toByteArray();
        this.jMh = ((b) nkVar.wda.get(1)).toByteArray();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.jMf);
        parcel.writeByteArray(this.jMg);
        parcel.writeByteArray(this.jMh);
    }

    private AppRuntimeApiPermissionBundle(Parcel parcel) {
        this.jMf = parcel.createByteArray();
        this.jMg = parcel.createByteArray();
        this.jMh = parcel.createByteArray();
    }
}
