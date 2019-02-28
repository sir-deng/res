package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.launching.k.b;

public abstract class RuntimeLoadModuleTask {
    public final LoadParams jEa;

    private static final class a implements h<LoadParams, WxaPkgWrappingInfo> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, final i iVar) {
            LoadParams loadParams = (LoadParams) obj;
            k g = com.tencent.mm.plugin.appbrand.launching.k.a.g(loadParams.appId, loadParams.iHe, loadParams.fwH, loadParams.iJb);
            g.a(new b() {
                public final void b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                    if (iVar != null) {
                        iVar.as(wxaPkgWrappingInfo);
                    }
                }
            });
            g.prepareAsync();
        }
    }

    private static final class LoadParams implements Parcelable {
        public static final Creator<LoadParams> CREATOR = new Creator<LoadParams>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LoadParams(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LoadParams[i];
            }
        };
        public final String appId;
        public final int fwH;
        public final String iHe;
        public final int iJb;

        /* synthetic */ LoadParams(String str, int i, int i2, String str2, byte b) {
            this(str, i, i2, str2);
        }

        private LoadParams(String str, int i, int i2, String str2) {
            this.appId = str;
            this.fwH = i;
            this.iJb = i2;
            this.iHe = str2;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeInt(this.fwH);
            parcel.writeInt(this.iJb);
            parcel.writeString(this.iHe);
        }

        LoadParams(Parcel parcel) {
            this.appId = parcel.readString();
            this.fwH = parcel.readInt();
            this.iJb = parcel.readInt();
            this.iHe = parcel.readString();
        }
    }

    public abstract void pN(String str);

    public RuntimeLoadModuleTask(String str, int i, int i2, String str2) {
        this.jEa = new LoadParams(str, i, i2, str2, (byte) 0);
    }
}
