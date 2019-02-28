package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.webview.wepkg.a.c;
import org.json.JSONException;
import org.json.JSONObject;

public class WepkgVersion implements Parcelable {
    public static final Creator<WepkgVersion> CREATOR = new Creator<WepkgVersion>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WepkgVersion(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WepkgVersion[i];
        }
    };
    public String appId;
    public String charset;
    public String downloadUrl;
    public String fNc;
    public String frM;
    public long hXs;
    public String iGz;
    public String tTK;
    public int tTx;
    public boolean tUa;
    public long tUb;
    public long tUc;
    public int tUd;
    public int tUe;
    public long tUf;
    public boolean tUg;
    public boolean tUh;
    public boolean tUi;
    public int tUj;
    public String version;

    public WepkgVersion(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.tTK = parcel.readString();
        this.appId = parcel.readString();
        this.version = parcel.readString();
        this.iGz = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.tUa = z;
        this.tUb = parcel.readLong();
        this.tUc = parcel.readLong();
        this.tUd = parcel.readInt();
        this.fNc = parcel.readString();
        this.frM = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.tUe = parcel.readInt();
        this.tTx = parcel.readInt();
        this.tUf = parcel.readLong();
        this.hXs = parcel.readLong();
        this.charset = parcel.readString();
        this.tUg = parcel.readByte() != (byte) 0;
        this.tUh = parcel.readByte() != (byte) 0;
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.tUi = z2;
        this.tUj = parcel.readInt();
    }

    public final void a(c cVar) {
        if (cVar != null) {
            this.tTK = cVar.field_pkgId;
            this.appId = cVar.field_appId;
            this.version = cVar.field_version;
            this.iGz = cVar.field_pkgPath;
            this.tUa = cVar.field_disableWvCache;
            this.tUb = cVar.field_clearPkgTime;
            this.tUc = cVar.field_checkIntervalTime;
            this.tUd = cVar.field_packMethod;
            this.fNc = cVar.field_domain;
            this.frM = cVar.field_md5;
            this.downloadUrl = cVar.field_downloadUrl;
            this.tUe = cVar.field_pkgSize;
            this.tTx = cVar.field_downloadNetType;
            this.tUf = cVar.field_nextCheckTime;
            this.hXs = cVar.field_createTime;
            this.charset = cVar.field_charset;
            this.tUg = cVar.field_bigPackageReady;
            this.tUh = cVar.field_preloadFilesReady;
            this.tUi = cVar.field_preloadFilesAtomic;
            this.tUj = cVar.field_totalDownloadCount;
        }
    }

    public final JSONObject bVX() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", this.appId);
            jSONObject.put("version", this.version);
            jSONObject.put("pkgPath", this.iGz);
            jSONObject.put("disableWvCache", this.tUa);
            jSONObject.put("clearPkgTime", this.tUb);
            jSONObject.put("checkIntervalTime", this.tUc);
            jSONObject.put("packMethod", this.tUd);
            jSONObject.put("domain", this.fNc);
            jSONObject.put("md5", this.frM);
            jSONObject.put("downloadUrl", this.downloadUrl);
            jSONObject.put("pkgSize", this.tUe);
            jSONObject.put("downloadNetType", this.tTx);
            jSONObject.put("nextCheckTime", this.tUf);
            jSONObject.put("charset", this.charset);
            jSONObject.put("bigPackageReady", this.tUg);
            jSONObject.put("preloadFilesReady", this.tUh);
            jSONObject.put("preloadFilesAtomic", this.tUi);
            jSONObject.put("totalDownloadCount", this.tUj);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.tTK);
        parcel.writeString(this.appId);
        parcel.writeString(this.version);
        parcel.writeString(this.iGz);
        parcel.writeByte((byte) (this.tUa ? 1 : 0));
        parcel.writeLong(this.tUb);
        parcel.writeLong(this.tUc);
        parcel.writeInt(this.tUd);
        parcel.writeString(this.fNc);
        parcel.writeString(this.frM);
        parcel.writeString(this.downloadUrl);
        parcel.writeInt(this.tUe);
        parcel.writeInt(this.tTx);
        parcel.writeLong(this.tUf);
        parcel.writeLong(this.hXs);
        parcel.writeString(this.charset);
        parcel.writeByte((byte) (this.tUg ? 1 : 0));
        if (this.tUh) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.tUi) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeInt(this.tUj);
    }
}
