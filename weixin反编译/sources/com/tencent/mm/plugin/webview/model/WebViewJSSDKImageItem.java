package com.tencent.mm.plugin.webview.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public class WebViewJSSDKImageItem extends WebViewJSSDKFileItem implements Parcelable {
    public static final Creator<WebViewJSSDKImageItem> CREATOR = new Creator<WebViewJSSDKImageItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WebViewJSSDKImageItem(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WebViewJSSDKImageItem[i];
        }
    };

    public WebViewJSSDKImageItem() {
        this.fuz = 1;
    }

    public final void bRD() {
        if (new File(this.iOz).exists()) {
            this.jlG = ai.OT(System.currentTimeMillis());
            Bitmap a = d.a(this.iOz, 640, 640, false, null, 0);
            if (a != null) {
                x.i("MicroMsg.WebViewJSSDkImageItem", "extract thumbnail bitmap");
                a = d.b(a, (float) ExifHelper.Vo(this.iOz));
                if (a != null) {
                    try {
                        d.a(a, 100, CompressFormat.JPEG, this.jlG, true);
                    } catch (Exception e) {
                        x.e("MicroMsg.WebViewJSSDkImageItem", "save bitmap to file failed : %s", e.getMessage());
                    }
                }
            }
            x.i("MicroMsg.WebViewJSSDkImageItem", "Thumb Path: %s", this.jlG);
            return;
        }
        x.i("MicroMsg.WebViewJSSDkImageItem", "Original file not existed");
    }

    public final WebViewJSSDKFileItem bRz() {
        this.fvn = ai.OV(this.iOz);
        bRD();
        return this;
    }

    public final String bRA() {
        return "jpeg";
    }

    public final String bRB() {
        return SlookAirButtonRecentMediaAdapter.IMAGE_TYPE;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    protected WebViewJSSDKImageItem(Parcel parcel) {
        super(parcel);
    }
}
