package com.tencent.mm.protocal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public class JsapiPermissionWrapper implements Parcelable {
    public static final Creator<JsapiPermissionWrapper> CREATOR = new Creator<JsapiPermissionWrapper>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsapiPermissionWrapper(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsapiPermissionWrapper[i];
        }
    };
    public static final JsapiPermissionWrapper vHA = new JsapiPermissionWrapper(3);
    public static final JsapiPermissionWrapper vHB = new JsapiPermissionWrapper(4);
    public static final JsapiPermissionWrapper vHy = new JsapiPermissionWrapper(1);
    public static final JsapiPermissionWrapper vHz = new JsapiPermissionWrapper(2);
    public byte[] vHC;
    private int vHD;
    private Set<Integer> vHE;
    private Set<Integer> vHF;

    /* synthetic */ JsapiPermissionWrapper(Parcel parcel, byte b) {
        this(parcel);
    }

    public JsapiPermissionWrapper() {
        this.vHC = null;
        this.vHD = 0;
        this.vHC = null;
    }

    public JsapiPermissionWrapper(byte[] bArr) {
        this.vHC = null;
        this.vHD = 0;
        if (bArr == null) {
            this.vHC = null;
        } else {
            this.vHC = bArr;
        }
    }

    public JsapiPermissionWrapper(int i) {
        this.vHC = null;
        this.vHD = 0;
        this.vHD = i;
        this.vHC = new byte[0];
    }

    public final int CY(int i) {
        int i2;
        if (this.vHF == null || !this.vHF.contains(Integer.valueOf(i))) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i2 != 0) {
            return 1;
        }
        if (this.vHE == null || !this.vHE.contains(Integer.valueOf(i))) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i2 != 0) {
            return 0;
        }
        if (this.vHD == 1) {
            if (i != 34 && i != 75) {
                return 1;
            }
            x.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", Integer.valueOf(i));
            return 0;
        } else if (this.vHD == 2) {
            if (i != -3) {
                return 0;
            }
            return 1;
        } else if (this.vHD == 3) {
            if (i != 34 && i != 75 && i != 23) {
                return 1;
            }
            x.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", Integer.valueOf(i));
            return 0;
        } else if (this.vHD == 4) {
            if (i != 34 && i != 75) {
                return 1;
            }
            x.i("MicroMsg.JsapiPermissionWrapper", "hy: on reserved bytes control : %d", Integer.valueOf(i));
            return 0;
        } else if (i == -2 || i == -3) {
            return 1;
        } else {
            if (this.vHC == null || i < 0 || i >= this.vHC.length) {
                return 0;
            }
            return this.vHC[i];
        }
    }

    public final void a(int i, byte b) {
        int i2 = 0;
        if (this.vHC == null || i < 0 || i >= this.vHC.length) {
            String str = "MicroMsg.JsapiPermissionWrapper";
            String str2 = "setPermission pos out of range, %s, %s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i);
            if (this.vHC != null) {
                i2 = this.vHC.length;
            }
            objArr[1] = Integer.valueOf(i2);
            x.e(str, str2, objArr);
            return;
        }
        this.vHC[i] = b;
    }

    public final boolean go(int i) {
        if (CY(i) == 1) {
            return true;
        }
        return false;
    }

    public static boolean ces() {
        return true;
    }

    public String toString() {
        if (this.vHC == null) {
            return "null";
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder(180);
        for (byte append : this.vHC) {
            stringBuilder.append(append);
        }
        String stringBuilder2 = stringBuilder.toString();
        x.d("MicroMsg.JsapiPermissionWrapper", "toString cost %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return stringBuilder2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.vHC);
        parcel.writeInt(this.vHD);
        parcel.writeIntArray(cet());
        parcel.writeIntArray(ceu());
    }

    private JsapiPermissionWrapper(Parcel parcel) {
        this.vHC = null;
        this.vHD = 0;
        this.vHC = parcel.createByteArray();
        this.vHD = parcel.readInt();
        n(parcel.createIntArray());
        o(parcel.createIntArray());
    }

    public final void toBundle(Bundle bundle) {
        bundle.putByteArray("jsapi_perm_wrapper_bytes", this.vHC);
        bundle.putInt("jsapi_perm_wrapper_hardcodePermission", this.vHD);
        bundle.putIntArray("jsapi_perm_wrapper_blacklist", cet());
        bundle.putIntArray("jsapi_perm_wrapper_whitelist", ceu());
    }

    public final void fromBundle(Bundle bundle) {
        this.vHC = bundle.getByteArray("jsapi_perm_wrapper_bytes");
        this.vHD = bundle.getInt("jsapi_perm_wrapper_hardcodePermission");
        n(bundle.getIntArray("jsapi_perm_wrapper_blacklist"));
        o(bundle.getIntArray("jsapi_perm_wrapper_whitelist"));
    }

    private int[] cet() {
        if (this.vHE == null) {
            return new int[0];
        }
        int[] iArr = new int[this.vHE.size()];
        int i = 0;
        for (Integer num : this.vHE) {
            int i2 = i + 1;
            iArr[i] = num == null ? 0 : num.intValue();
            i = i2;
        }
        return iArr;
    }

    public final void n(int[] iArr) {
        if (this.vHE == null) {
            this.vHE = new HashSet();
        } else {
            this.vHE.clear();
        }
        if (iArr != null && iArr.length > 0) {
            for (int valueOf : iArr) {
                this.vHE.add(Integer.valueOf(valueOf));
            }
        }
    }

    private int[] ceu() {
        if (this.vHF == null) {
            return new int[0];
        }
        int[] iArr = new int[this.vHF.size()];
        int i = 0;
        for (Integer num : this.vHF) {
            int i2 = i + 1;
            iArr[i] = num == null ? 0 : num.intValue();
            i = i2;
        }
        return iArr;
    }

    public final void o(int[] iArr) {
        if (this.vHF == null) {
            this.vHF = new HashSet();
        } else {
            this.vHF.clear();
        }
        if (iArr != null && iArr.length > 0) {
            for (int valueOf : iArr) {
                this.vHF.add(Integer.valueOf(valueOf));
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JsapiPermissionWrapper)) {
            return false;
        }
        JsapiPermissionWrapper jsapiPermissionWrapper = (JsapiPermissionWrapper) obj;
        if (this.vHC == jsapiPermissionWrapper.vHC) {
            return true;
        }
        if (this.vHC == null || jsapiPermissionWrapper.vHC == null || this.vHC.length != jsapiPermissionWrapper.vHC.length) {
            return false;
        }
        for (int i = 0; i < this.vHC.length; i++) {
            if (this.vHC[i] != jsapiPermissionWrapper.vHC[i]) {
                return false;
            }
        }
        return true;
    }
}
