package com.tencent.mm.plugin.webview.modeltools;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.charset.Charset;

public final class WebViewClipBoardHelper implements OnPrimaryClipChangedListener {
    private long lastReportTime = 0;
    private WebViewUI tBG;
    public ClipboardManager tBH;

    private static final class a implements h<ClipBoardDataWrapper, Object> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, i iVar) {
            ClipBoardDataWrapper clipBoardDataWrapper = (ClipBoardDataWrapper) obj;
            if (clipBoardDataWrapper != null) {
                int i = com.tencent.mm.plugin.secinforeport.a.a.qlf;
                com.tencent.mm.plugin.secinforeport.a.a.d(3, clipBoardDataWrapper.url, clipBoardDataWrapper.length);
                return;
            }
            x.e("MicroMsg.WebViewClipBoardHelper", "InvokeTask, mm received invalid data");
        }
    }

    private static final class ClipBoardDataWrapper implements Parcelable {
        public static final Creator<ClipBoardDataWrapper> CREATOR = new Creator<ClipBoardDataWrapper>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ClipBoardDataWrapper(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ClipBoardDataWrapper[i];
            }
        };
        int length;
        String url;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.url);
            parcel.writeInt(this.length);
        }

        ClipBoardDataWrapper() {
        }

        ClipBoardDataWrapper(Parcel parcel) {
            this.url = parcel.readString();
            this.length = parcel.readInt();
        }
    }

    public WebViewClipBoardHelper(WebViewUI webViewUI) {
        this.tBG = webViewUI;
        this.tBH = (ClipboardManager) this.tBG.getSystemService("clipboard");
        try {
            this.tBH.addPrimaryClipChangedListener(this);
        } catch (Exception e) {
        }
    }

    public final void onPrimaryClipChanged() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastReportTime >= 200) {
            this.lastReportTime = currentTimeMillis;
            ClipData primaryClip = this.tBH.getPrimaryClip();
            if (primaryClip != null) {
                Item itemAt = primaryClip.getItemAt(0);
                if (itemAt != null) {
                    ClipBoardDataWrapper clipBoardDataWrapper = new ClipBoardDataWrapper();
                    clipBoardDataWrapper.url = this.tBG.aPR();
                    if (bi.N(itemAt.getText())) {
                        x.w("MicroMsg.WebViewClipBoardHelper", "onPrimaryClipChanged text is null");
                        return;
                    }
                    clipBoardDataWrapper.length = itemAt.getText().toString().getBytes(Charset.forName("UTF-8")).length;
                    XIPCInvoker.a("com.tencent.mm", clipBoardDataWrapper, a.class, null);
                }
            }
        }
    }
}
