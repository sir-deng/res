package com.tencent.mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;

public class WebViewJSSDKVideoItem extends WebViewJSSDKFileItem implements Parcelable {
    public static final Creator<WebViewJSSDKVideoItem> CREATOR = new Creator<WebViewJSSDKVideoItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WebViewJSSDKVideoItem(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WebViewJSSDKVideoItem[i];
        }
    };
    public int duration;
    public int height;
    public int size;
    public int width;

    public WebViewJSSDKVideoItem() {
        this.fuz = 4;
    }

    public final WebViewJSSDKFileItem bRz() {
        this.fvn = ai.OV(this.iOz);
        return this;
    }

    public final String bRA() {
        return "mp4";
    }

    public final String bRB() {
        return SlookAirButtonRecentMediaAdapter.VIDEO_TYPE;
    }

    protected WebViewJSSDKVideoItem(Parcel parcel) {
        super(parcel);
        this.fuz = parcel.readInt();
        this.duration = parcel.readInt();
        this.size = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.fuz);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.size);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }
}
