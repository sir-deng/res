package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.AnonymousClass2;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.e;
import com.tencent.mm.plugin.appbrand.dynamic.j.d;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import junit.framework.Assert;

public final class WxaWidgetInitializer {

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ String fhk;
        final /* synthetic */ int hNw;
        final /* synthetic */ int iFk;
        final /* synthetic */ int iVv;
        final /* synthetic */ int iVw;
        final /* synthetic */ String iVx;
        final /* synthetic */ a iVy;
        final /* synthetic */ String iVz;
        final /* synthetic */ String uR;

        AnonymousClass1(String str, int i, int i2, String str2, int i3, int i4, String str3, a aVar, String str4) {
            this.uR = str;
            this.iFk = i;
            this.iVv = i2;
            this.fhk = str2;
            this.iVw = i3;
            this.hNw = i4;
            this.iVx = str3;
            this.iVy = aVar;
            this.iVz = str4;
        }

        public final void run() {
            x.d("MicroMsg.WxaWidgetInitializer", "initialize(id : %s, pkgType : %s, version : %s)", this.uR, Integer.valueOf(this.iFk), Integer.valueOf(this.iVv));
            final d a = com.tencent.mm.plugin.appbrand.dynamic.j.a.a(this.fhk, this.iFk, this.iVv, this.iVw, this.hNw, this.iVx);
            if (a == null) {
                x.e("MicroMsg.WxaWidgetInitializer", "getLaunchWxaWidgetInfo(id : %s, pkgType : %s, version : %s) return null.", this.uR, Integer.valueOf(this.iFk), Integer.valueOf(this.iVv));
                if (this.iVy != null) {
                    this.iVy.a(this.uR, this.fhk, false, null);
                    return;
                }
                return;
            }
            WxaPkgWrappingInfo a2 = com.tencent.mm.plugin.appbrand.dynamic.j.a.a(this.uR, this.fhk, this.iVz, this.iFk, this.iVv);
            if (a2 != null) {
                WxaWidgetContext a3 = WxaWidgetInitializer.a(this.uR, this.fhk, a2, a);
                if (this.iVy != null) {
                    this.iVy.a(this.uR, this.fhk, a3 != null, a3);
                    return;
                }
                return;
            }
            x.e("MicroMsg.WxaWidgetInitializer", "get widget PkgWrappingInfo(id : %s, pkgType : %s, version : %s) return null.", this.uR, Integer.valueOf(this.iFk), Integer.valueOf(this.iVv));
            if (this.iVy != null) {
                this.iVy.ba(this.uR, this.fhk);
            }
            String str = this.uR;
            String str2 = this.fhk;
            String str3 = this.iVz;
            int i = this.iFk;
            e anonymousClass1 = new e() {
                public final void Q(String str, boolean z) {
                    boolean z2 = false;
                    WxaWidgetContext wxaWidgetContext = null;
                    x.d("MicroMsg.WxaWidgetInitializer", "tryToUpdate(id : %s, pkgType : %s, version : %s), callback(%s, %s).", AnonymousClass1.this.uR, Integer.valueOf(AnonymousClass1.this.iFk), Integer.valueOf(AnonymousClass1.this.iVv), str, Boolean.valueOf(z));
                    if (z) {
                        WxaPkgWrappingInfo a = com.tencent.mm.plugin.appbrand.dynamic.j.a.a(AnonymousClass1.this.uR, str, AnonymousClass1.this.iVz, AnonymousClass1.this.iFk, 0);
                        if (a != null) {
                            wxaWidgetContext = WxaWidgetInitializer.a(AnonymousClass1.this.uR, str, a, a);
                        } else {
                            z = false;
                        }
                    }
                    if (AnonymousClass1.this.iVy != null) {
                        a aVar = AnonymousClass1.this.iVy;
                        String str2 = AnonymousClass1.this.uR;
                        if (z && wxaWidgetContext != null) {
                            z2 = true;
                        }
                        aVar.a(str2, str, z2, wxaWidgetContext);
                    }
                }
            };
            if (i != Integer.MIN_VALUE && com.tencent.mm.plugin.appbrand.dynamic.j.a.a(str, str2, str3, i, 0) == null) {
                Parcelable bundle = new Bundle();
                bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
                bundle.putString("appId", str2);
                bundle.putInt("debugType", i);
                f.a("com.tencent.mm", bundle, d.class, new AnonymousClass2(anonymousClass1));
            }
        }
    }

    public interface a {
        void a(String str, String str2, boolean z, WxaWidgetContext wxaWidgetContext);

        void ba(String str, String str2);
    }

    private static class WxaWidgetContextImpl implements WxaWidgetContext {
        public static final Creator<WxaWidgetContextImpl> CREATOR = new Creator<WxaWidgetContextImpl>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new WxaWidgetContextImpl(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WxaWidgetContextImpl[i];
            }
        };
        String gQA;
        WxaPkgWrappingInfo iVC;
        WxaPkgWrappingInfo iVD;
        byte[] iVE;
        int iVF;
        DebuggerInfo iVG;
        WidgetSysConfig iVH;
        WidgetRuntimeConfig iVI;
        String mAppId;

        public WxaWidgetContextImpl(Parcel parcel) {
            ClassLoader classLoader = getClass().getClassLoader();
            this.gQA = parcel.readString();
            this.mAppId = parcel.readString();
            this.iVD = (WxaPkgWrappingInfo) parcel.readParcelable(classLoader);
            this.iVC = (WxaPkgWrappingInfo) parcel.readParcelable(classLoader);
            this.iVE = parcel.createByteArray();
            this.iVF = parcel.readInt();
            this.iVG = (DebuggerInfo) parcel.readParcelable(classLoader);
            this.iVH = (WidgetSysConfig) parcel.readParcelable(classLoader);
            this.iVI = (WidgetRuntimeConfig) parcel.readParcelable(classLoader);
        }

        public WxaWidgetContextImpl(WxaPkgWrappingInfo wxaPkgWrappingInfo, WxaPkgWrappingInfo wxaPkgWrappingInfo2) {
            Assert.assertNotNull(wxaPkgWrappingInfo);
            Assert.assertNotNull(wxaPkgWrappingInfo2);
            this.iVD = wxaPkgWrappingInfo;
            this.iVC = wxaPkgWrappingInfo2;
        }

        public final WxaPkgWrappingInfo acY() {
            return this.iVC;
        }

        public final WxaPkgWrappingInfo acZ() {
            return this.iVD;
        }

        public final String getId() {
            return this.gQA;
        }

        public final String getAppId() {
            return this.mAppId;
        }

        public final int ada() {
            return this.iVC != null ? this.iVC.iJa : 0;
        }

        public final int adb() {
            return this.iVC != null ? this.iVC.iJb : 0;
        }

        public final byte[] adc() {
            return this.iVE;
        }

        public final int ade() {
            return this.iVF;
        }

        public final DebuggerInfo adf() {
            return this.iVG;
        }

        public final WidgetSysConfig adg() {
            return this.iVH;
        }

        public final WidgetRuntimeConfig adh() {
            return this.iVI;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.gQA);
            parcel.writeString(this.mAppId);
            parcel.writeParcelable(this.iVD, i);
            parcel.writeParcelable(this.iVC, i);
            parcel.writeByteArray(this.iVE);
            parcel.writeInt(this.iVF);
            parcel.writeParcelable(this.iVG, i);
            parcel.writeParcelable(this.iVH, i);
            parcel.writeParcelable(this.iVI, i);
        }
    }

    static WxaWidgetContextImpl a(String str, String str2, WxaPkgWrappingInfo wxaPkgWrappingInfo, d dVar) {
        int i = 1;
        x.i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", str);
        WxaPkgWrappingInfo aaa = ab.aaa();
        if (aaa == null) {
            x.e("MicroMsg.WxaWidgetInitializer", "getLibPkgInfo return null.");
            return null;
        }
        WxaWidgetContextImpl wxaWidgetContextImpl = new WxaWidgetContextImpl(aaa, wxaPkgWrappingInfo);
        wxaWidgetContextImpl.gQA = str;
        wxaWidgetContextImpl.mAppId = str2;
        wxaWidgetContextImpl.iVG = dVar.iYf;
        if (wxaWidgetContextImpl.iVG == null) {
            wxaWidgetContextImpl.iVG = new DebuggerInfo();
        }
        wxaWidgetContextImpl.iVH = dVar.iYg;
        wxaWidgetContextImpl.iVI = dVar.iYh;
        try {
            byte[] toByteArray = (dVar.iYj == null || dVar.iYj.wcZ == null) ? new byte[0] : dVar.iYj.wcZ.toByteArray();
            wxaWidgetContextImpl.iVE = toByteArray;
        } catch (Throwable e) {
            x.e("MicroMsg.WxaWidgetInitializer", bi.i(e));
        }
        if (wxaWidgetContextImpl.iVG.iWh) {
            wxaWidgetContextImpl.iVF = 2;
            f.acX().av(str, TXLiveConstants.PLAY_WARNING_VIDEO_DECODE_FAIL);
        } else {
            if (dVar.iYi != null) {
                i = dVar.iYi.vKQ;
            }
            wxaWidgetContextImpl.iVF = i;
        }
        return wxaWidgetContextImpl;
    }

    public static String bc(String str, String str2) {
        return str + "#" + str2;
    }
}
