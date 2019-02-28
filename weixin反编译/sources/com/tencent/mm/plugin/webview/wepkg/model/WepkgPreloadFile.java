package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.webview.wepkg.a.a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONException;
import org.json.JSONObject;

public class WepkgPreloadFile implements Parcelable {
    public static final Creator<WepkgPreloadFile> CREATOR = new Creator<WepkgPreloadFile>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WepkgPreloadFile(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WepkgPreloadFile[i];
        }
    };
    public String aAM;
    public String downloadUrl;
    public String filePath;
    public String frM;
    public long hXs;
    public String mimeType;
    public int size;
    public String tTK;
    public boolean tTL;
    public String tTv;
    public int tTx;
    public String version;

    public WepkgPreloadFile(Parcel parcel) {
        this.aAM = parcel.readString();
        this.tTK = parcel.readString();
        this.version = parcel.readString();
        this.filePath = parcel.readString();
        this.tTv = parcel.readString();
        this.mimeType = parcel.readString();
        this.frM = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.size = parcel.readInt();
        this.tTx = parcel.readInt();
        this.tTL = parcel.readByte() != (byte) 0;
        this.hXs = parcel.readLong();
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.aAM = aVar.field_key;
            this.tTK = aVar.field_pkgId;
            this.version = aVar.field_version;
            this.filePath = aVar.field_filePath;
            this.tTv = aVar.field_rid;
            this.mimeType = aVar.field_mimeType;
            this.frM = aVar.field_md5;
            this.downloadUrl = aVar.field_downloadUrl;
            this.size = aVar.field_size;
            this.tTx = aVar.field_downloadNetType;
            this.tTL = aVar.field_completeDownload;
            this.hXs = aVar.field_createTime;
        }
    }

    public final JSONObject bVX() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", this.aAM);
            jSONObject.put("pkgId", this.tTK);
            jSONObject.put("version", this.version);
            jSONObject.put(DownloadInfoColumns.FILEPATH, this.filePath);
            jSONObject.put("rid", this.tTv);
            jSONObject.put("mimeType", this.mimeType);
            jSONObject.put("md5", this.frM);
            jSONObject.put("downloadUrl", this.downloadUrl);
            jSONObject.put("size", this.size);
            jSONObject.put("downloadNetType", this.tTx);
            jSONObject.put("completeDownload", this.tTL);
            jSONObject.put("createTime", this.hXs);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aAM);
        parcel.writeString(this.tTK);
        parcel.writeString(this.version);
        parcel.writeString(this.filePath);
        parcel.writeString(this.tTv);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.frM);
        parcel.writeString(this.downloadUrl);
        parcel.writeInt(this.size);
        parcel.writeInt(this.tTx);
        parcel.writeByte((byte) (this.tTL ? 1 : 0));
        parcel.writeLong(this.hXs);
    }
}
