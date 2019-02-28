package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.webview.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.webview.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.webview.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class WepkgDownloadProcessTask extends BaseWepkgProcessTask {
    public static final Creator<WepkgDownloadProcessTask> CREATOR = new Creator<WepkgDownloadProcessTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WepkgDownloadProcessTask(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WepkgDownloadProcessTask[i];
        }
    };
    public String downloadUrl;
    public String fNz;
    public int fileType;
    public String frM;
    public String iGz;
    public Runnable jfW;
    public String tTv;
    public long tTw;
    public int tTx;
    public RetCode tTy;
    public String version;

    /* synthetic */ WepkgDownloadProcessTask(Parcel parcel, byte b) {
        this(parcel);
    }

    private WepkgDownloadProcessTask(Parcel parcel) {
        f(parcel);
    }

    public final void YA() {
        afy();
        WePkgDownloader.bVT().a(this.fileType, bi.oM(this.fNz), bi.oM(this.tTv), bi.oM(this.downloadUrl), this.tTw, bi.oM(this.version), bi.oM(this.frM), this.tTx, new IWepkgUpdateCallback() {
            public final void a(String str, String str2, RetCode retCode) {
                x.i("MicroMsg.Wepkg.WepkgDownloadProcessTask", "onPkgUpdatingCallback errCode:%s", retCode);
                WepkgDownloadProcessTask.this.fNz = str;
                WepkgDownloadProcessTask.this.iGz = str2;
                WepkgDownloadProcessTask.this.tTy = retCode;
                WepkgDownloadProcessTask.this.afz();
                WepkgDownloadProcessTask.this.Du();
            }
        });
    }

    public final void YB() {
        if (this.jfW != null) {
            this.jfW.run();
        }
    }

    public final void j(Parcel parcel) {
        this.fileType = parcel.readInt();
        this.fNz = parcel.readString();
        this.tTv = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.tTw = parcel.readLong();
        this.version = parcel.readString();
        this.frM = parcel.readString();
        this.tTx = parcel.readInt();
        this.iGz = parcel.readString();
        this.tTy = (RetCode) parcel.readParcelable(RetCode.class.getClassLoader());
    }

    public final void v(Parcel parcel, int i) {
        parcel.writeInt(this.fileType);
        parcel.writeString(this.fNz);
        parcel.writeString(this.tTv);
        parcel.writeString(this.downloadUrl);
        parcel.writeLong(this.tTw);
        parcel.writeString(this.version);
        parcel.writeString(this.frM);
        parcel.writeInt(this.tTx);
        parcel.writeString(this.iGz);
        parcel.writeParcelable(this.tTy, i);
    }
}
