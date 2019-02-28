package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AppBrandInitConfig implements Parcelable {
    public static final Creator<AppBrandInitConfig> CREATOR = new Creator<AppBrandInitConfig>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandInitConfig(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandInitConfig[i];
        }
    };
    public String appId;
    public String extInfo;
    public int foo;
    public String fsi;
    public String hlj;
    public String hlk;
    public int iIZ;
    public boolean iRc;
    public boolean iRd;
    public String iRe;
    public String iRf;
    private Boolean iRg;
    public boolean iRh;
    public String iRi;
    public boolean iRj;
    public boolean iRk;
    public final AppBrandLaunchReferrer iRl;
    public String iconUrl;
    public String iub;
    public long startTime;
    public String username;

    /* synthetic */ AppBrandInitConfig(Parcel parcel, byte b) {
        this(parcel);
    }

    AppBrandInitConfig() {
        this.iRl = new AppBrandLaunchReferrer();
    }

    public final void acj() {
        this.iub = "SessionId@" + hashCode() + "#" + bi.Wy();
    }

    public final boolean YI() {
        return 4 == this.foo;
    }

    public final boolean ack() {
        if (this.iRg != null) {
            return this.iRg.booleanValue();
        }
        if (bi.oN(this.iRf)) {
            this.iRg = Boolean.valueOf(false);
            return this.iRg.booleanValue();
        }
        try {
            JSONArray optJSONArray = new JSONObject(this.iRf).optJSONArray("call_plugin_info");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                this.iRg = Boolean.valueOf(false);
                return this.iRg.booleanValue();
            }
            this.iRg = Boolean.valueOf(true);
            return this.iRg.booleanValue();
        } catch (Exception e) {
            this.iRg = Boolean.valueOf(false);
        }
    }

    private AppBrandInitConfig(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.iRl = new AppBrandLaunchReferrer();
        this.username = parcel.readString();
        this.appId = parcel.readString();
        this.fsi = parcel.readString();
        this.iconUrl = parcel.readString();
        this.iIZ = parcel.readInt();
        this.foo = parcel.readInt();
        this.iRc = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.iRd = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.iRh = z;
        this.iRe = parcel.readString();
        this.iRf = parcel.readString();
        this.extInfo = parcel.readString();
        this.iRi = parcel.readString();
        this.hlj = parcel.readString();
        this.hlk = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.iRj = z;
        this.startTime = parcel.readLong();
        this.iRl.g(parcel);
        this.iub = parcel.readString();
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.iRk = z2;
    }

    public final String toString() {
        return "AppBrandInitConfig{visitingSessionId='" + this.iub + '\'' + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.fsi + '\'' + ", debugType=" + this.iIZ + ", isPluginApp=" + this.iRc + ", preferRunInTools=" + this.iRd + ", orientation='" + this.iRe + '\'' + ", enterPath='" + this.iRi + '\'' + ", shareName='" + this.hlj + '\'' + ", shareKey='" + this.hlk + '\'' + ", isStick=" + this.iRj + ", startTime=" + this.startTime + ", attrsFromCgi=" + this.iRk + ", referrer=" + this.iRl + ", extInfo=" + this.extInfo + '}';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        byte b;
        int i2 = 1;
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeString(this.fsi);
        parcel.writeString(this.iconUrl);
        parcel.writeInt(this.iIZ);
        parcel.writeInt(this.foo);
        parcel.writeByte(this.iRc ? (byte) 1 : (byte) 0);
        if (this.iRd) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.iRh) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeString(this.iRe);
        parcel.writeString(this.iRf);
        parcel.writeString(this.extInfo);
        parcel.writeString(this.iRi);
        parcel.writeString(this.hlj);
        parcel.writeString(this.hlk);
        if (this.iRj) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeLong(this.startTime);
        this.iRl.writeToParcel(parcel, i);
        parcel.writeString(this.iub);
        if (!this.iRk) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
    }

    public final int describeContents() {
        return 0;
    }

    public final JSONObject acl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("shareKey", this.hlk);
            jSONObject.put("shareName", this.hlj);
            if (jSONObject.length() == 0) {
                return null;
            }
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
