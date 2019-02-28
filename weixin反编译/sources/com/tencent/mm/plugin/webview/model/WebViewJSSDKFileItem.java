package com.tencent.mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public abstract class WebViewJSSDKFileItem implements Parcelable {
    public String appId;
    public String fileName;
    public int fuz;
    public String fvn;
    public String iOA;
    public boolean iOC;
    public boolean iOD = true;
    public boolean iOE = true;
    public String iOz;
    public String jlG;
    public String mediaId;
    public a tyS;

    public static class a {
        public String field_aesKey;
        public String field_fileId;
        public int field_fileLength;
        public String field_fileUrl;
    }

    public abstract String bRA();

    public abstract String bRB();

    public abstract WebViewJSSDKFileItem bRz();

    public static WebViewJSSDKFileItem OP(String str) {
        WebViewJSSDKFileItem webViewJSSDKImageItem = new WebViewJSSDKImageItem();
        webViewJSSDKImageItem.iOz = str;
        webViewJSSDKImageItem.bRz();
        webViewJSSDKImageItem.mediaId = d.a("jsupimg", bi.Wy(), webViewJSSDKImageItem.fvn, webViewJSSDKImageItem.fvn);
        return webViewJSSDKImageItem;
    }

    public static WebViewJSSDKFileItem OQ(String str) {
        WebViewJSSDKFileItem webViewJSSDKVoiceItem = new WebViewJSSDKVoiceItem();
        webViewJSSDKVoiceItem.fileName = str;
        webViewJSSDKVoiceItem.bRz();
        webViewJSSDKVoiceItem.mediaId = d.a("jsupvoice", bi.Wy(), webViewJSSDKVoiceItem.fvn, webViewJSSDKVoiceItem.fvn);
        return webViewJSSDKVoiceItem;
    }

    public static WebViewJSSDKFileItem x(int i, String str, String str2) {
        WebViewJSSDKFileItem webViewJSSDKUpFileItem = new WebViewJSSDKUpFileItem();
        webViewJSSDKUpFileItem.fileType = i;
        webViewJSSDKUpFileItem.ndB = str;
        webViewJSSDKUpFileItem.iOz = str2;
        webViewJSSDKUpFileItem.bRz();
        webViewJSSDKUpFileItem.mediaId = d.a("jsupfile", bi.Wy(), webViewJSSDKUpFileItem.fvn, webViewJSSDKUpFileItem.fvn);
        x.d("MicroMsg.WebViewJSSDKFileItem", "fileType=%d, origFilePath=%s, localId=%s", Integer.valueOf(i), str2, webViewJSSDKUpFileItem.fvn);
        return webViewJSSDKUpFileItem;
    }

    public static WebViewJSSDKVideoItem OR(String str) {
        WebViewJSSDKVideoItem webViewJSSDKVideoItem = new WebViewJSSDKVideoItem();
        webViewJSSDKVideoItem.iOz = str;
        webViewJSSDKVideoItem.bRz();
        webViewJSSDKVideoItem.mediaId = d.a("jsvideofile", bi.Wy(), webViewJSSDKVideoItem.fvn, webViewJSSDKVideoItem.fvn);
        x.d("MicroMsg.WebViewJSSDKFileItem", "filepath = %s, localid = %s, mediaid = %s", str, webViewJSSDKVideoItem.fvn, webViewJSSDKVideoItem.mediaId);
        return webViewJSSDKVideoItem;
    }

    public void c(keep_SceneResult keep_sceneresult) {
        if (this.tyS == null) {
            this.tyS = new a();
        }
        if (keep_sceneresult == null) {
            x.e("MicroMsg.WebViewJSSDKFileItem", "sceneResult info is null");
            return;
        }
        this.tyS.field_aesKey = keep_sceneresult.field_aesKey;
        this.tyS.field_fileId = keep_sceneresult.field_fileId;
        this.tyS.field_fileUrl = keep_sceneresult.field_fileUrl;
        this.tyS.field_fileLength = keep_sceneresult.field_fileLength;
    }

    protected WebViewJSSDKFileItem(Parcel parcel) {
        this.appId = parcel.readString();
        this.fvn = parcel.readString();
        this.jlG = parcel.readString();
        this.iOz = parcel.readString();
        this.fuz = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.fvn);
        parcel.writeString(this.jlG);
        parcel.writeString(this.iOz);
        parcel.writeInt(this.fuz);
    }
}
