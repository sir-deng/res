package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.d;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.sdk.platformtools.bi;

public abstract class AppBrandLaunchErrorAction implements Parcelable {
    public static final a CREATOR = new a();
    final String appId;
    final int iNi;

    static final class a implements Creator<AppBrandLaunchErrorAction> {
        a() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return i(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandLaunchErrorAction[i];
        }

        private static AppBrandLaunchErrorAction i(Parcel parcel) {
            String readString = parcel.readString();
            if (readString == null) {
                return null;
            }
            try {
                return (AppBrandLaunchErrorAction) Class.forName(readString).getDeclaredConstructor(new Class[]{Parcel.class}).newInstance(new Object[]{parcel});
            } catch (Exception e) {
                return null;
            }
        }

        static AppBrandLaunchErrorAction a(String str, int i, u uVar) {
            if (uVar == null || uVar.field_launchAction == null) {
                return null;
            }
            AppBrandLaunchErrorAction appBrandLaunchErrorActionStartActivity;
            switch (uVar.field_launchAction.vKQ) {
                case 2:
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", uVar.field_launchAction.wBW);
                    intent.putExtra("forceHideShare", true);
                    appBrandLaunchErrorActionStartActivity = new AppBrandLaunchErrorActionStartActivity(str, i, "webview", ".ui.tools.WebViewUI", intent);
                    break;
                case 3:
                    appBrandLaunchErrorActionStartActivity = new AppBrandLaunchErrorActionAlert(str, i, uVar.field_launchAction.wwx, uVar.field_launchAction.wBY);
                    break;
                default:
                    appBrandLaunchErrorActionStartActivity = null;
                    break;
            }
            if (appBrandLaunchErrorActionStartActivity != null) {
                b.aP(str, i);
            } else {
                ((d) e.u(d.class)).t(q.rn(str), bi.Wx());
            }
            return appBrandLaunchErrorActionStartActivity;
        }
    }

    abstract void cb(Context context);

    AppBrandLaunchErrorAction(Parcel parcel) {
        this.appId = parcel.readString();
        this.iNi = parcel.readInt();
    }

    AppBrandLaunchErrorAction(String str, int i) {
        this.appId = str;
        this.iNi = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getClass().getName());
        parcel.writeString(this.appId);
        parcel.writeInt(this.iNi);
    }

    public final int describeContents() {
        return 0;
    }
}
