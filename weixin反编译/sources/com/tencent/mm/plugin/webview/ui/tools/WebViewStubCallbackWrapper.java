package com.tencent.mm.plugin.webview.ui.tools;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.stub.e.a;

public class WebViewStubCallbackWrapper implements Parcelable {
    public static final Creator<WebViewStubCallbackWrapper> CREATOR = new Creator<WebViewStubCallbackWrapper>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            return readStrongBinder != null ? new WebViewStubCallbackWrapper(readStrongBinder, (byte) 0) : null;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WebViewStubCallbackWrapper[i];
        }
    };
    public int id;
    public e tEI;

    /* synthetic */ WebViewStubCallbackWrapper(IBinder iBinder, byte b) {
        this(iBinder);
    }

    public WebViewStubCallbackWrapper(e eVar, int i) {
        this.tEI = eVar;
        this.id = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.tEI.asBinder());
    }

    private WebViewStubCallbackWrapper(IBinder iBinder) {
        this.tEI = a.Y(iBinder);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof WebViewStubCallbackWrapper) && ((WebViewStubCallbackWrapper) obj).id == this.id) {
            return true;
        }
        return false;
    }
}
