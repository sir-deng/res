package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public interface ILaunchWxaAppInfoNotify {
    public static final ILaunchWxaAppInfoNotify jDl = new ILaunchWxaAppInfoNotify() {
        public final void a(String str, int i, String str2, u uVar) {
            d tE = d.tE(str2);
            if (tE != null) {
                tE.a(str, i, str2, uVar);
                return;
            }
            Parcelable launchInfoIpcWrapper = new LaunchInfoIpcWrapper();
            launchInfoIpcWrapper.appId = str;
            launchInfoIpcWrapper.iNi = i;
            launchInfoIpcWrapper.iRy = new AppRuntimeApiPermissionBundle(uVar.field_jsapiInfo);
            a aVar = AppBrandLaunchErrorAction.CREATOR;
            launchInfoIpcWrapper.jDm = a.a(str, i, uVar);
            d.a(launchInfoIpcWrapper);
        }
    };

    public static class LaunchInfoIpcWrapper implements Parcelable {
        public static final Creator<LaunchInfoIpcWrapper> CREATOR = new Creator<LaunchInfoIpcWrapper>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LaunchInfoIpcWrapper(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LaunchInfoIpcWrapper[i];
            }
        };
        public String appId;
        public int iNi;
        public AppRuntimeApiPermissionBundle iRy;
        public AppBrandLaunchErrorAction jDm;

        LaunchInfoIpcWrapper() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeInt(this.iNi);
            parcel.writeParcelable(this.iRy, i);
            parcel.writeParcelable(this.jDm, i);
        }

        LaunchInfoIpcWrapper(Parcel parcel) {
            this.appId = parcel.readString();
            this.iNi = parcel.readInt();
            this.iRy = (AppRuntimeApiPermissionBundle) parcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader());
            this.jDm = (AppBrandLaunchErrorAction) parcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader());
        }
    }

    public static class a {

        /* renamed from: com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify$a$2 */
        static class AnonymousClass2 implements com.tencent.mm.plugin.appbrand.b.b.a {
            final /* synthetic */ com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.a jDn;

            public AnonymousClass2(com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.a aVar) {
                this.jDn = aVar;
            }

            public final void a(com.tencent.mm.plugin.appbrand.b.a aVar) {
                if (aVar == com.tencent.mm.plugin.appbrand.b.a.DESTROYED) {
                    MMToClientEvent.b(this.jDn);
                }
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify$a$1 */
        static class AnonymousClass1 implements com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.a {
            final /* synthetic */ e iFi;

            public AnonymousClass1(e eVar) {
                this.iFi = eVar;
            }

            public final void bc(Object obj) {
                if (obj instanceof LaunchInfoIpcWrapper) {
                    LaunchInfoIpcWrapper launchInfoIpcWrapper = (LaunchInfoIpcWrapper) obj;
                    if (!this.iFi.mAppId.equals(launchInfoIpcWrapper.appId) || this.iFi.isR.iIZ != launchInfoIpcWrapper.iNi) {
                        return;
                    }
                    if (launchInfoIpcWrapper.jDm != null) {
                        AppBrandLaunchErrorAction appBrandLaunchErrorAction = launchInfoIpcWrapper.jDm;
                        e eVar = this.iFi;
                        if (eVar == null) {
                            eVar = com.tencent.mm.plugin.appbrand.a.pi(appBrandLaunchErrorAction.appId);
                        }
                        if (eVar != null && appBrandLaunchErrorAction.iNi == eVar.isR.iIZ) {
                            Context context;
                            e YD = eVar.YD();
                            eVar.finish();
                            if (YD == null) {
                                context = ad.getContext();
                            } else {
                                n nVar = YD.isX;
                                if (nVar != null) {
                                    MMActivity context2 = (MMActivity) nVar.getContext();
                                    if (context2.isFinishing() || context2.xQV) {
                                        return;
                                    }
                                }
                                return;
                            }
                            appBrandLaunchErrorAction.cb(context2);
                            return;
                        }
                        return;
                    }
                    c a = c.a(this.iFi, false);
                    if (a != null) {
                        a.a(launchInfoIpcWrapper.iRy);
                    }
                }
            }
        }
    }

    void a(String str, int i, String str2, u uVar);
}
