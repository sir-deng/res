package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.widget.Toast;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.bx;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.Locale;

public final class AppBrandPrepareTask {
    PrepareParams jCr = new PrepareParams();
    public volatile transient b jCs;
    volatile transient WeakReference<MMActivity> jCt;
    boolean jCu;

    private static final class PrepareParams implements Parcelable {
        public static final Creator<PrepareParams> CREATOR = new Creator<PrepareParams>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new PrepareParams(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new PrepareParams[i];
            }
        };
        private int jCD;
        private int jCE;
        private String jCF;
        private int jCG;
        private AppBrandLaunchReferrer jCH;
        private String jCI;
        private int jCJ;
        private boolean jCu;
        private String mAppId;

        public final String toShortString() {
            return String.format(Locale.US, "[%s|%d]", new Object[]{this.mAppId, Integer.valueOf(this.jCG)});
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.jCD);
            parcel.writeInt(this.jCE);
            parcel.writeString(this.jCF);
            parcel.writeString(this.mAppId);
            parcel.writeInt(this.jCG);
            parcel.writeParcelable(this.jCH, i);
            parcel.writeString(this.jCI);
            parcel.writeInt(this.jCJ);
            parcel.writeInt(this.jCu ? 1 : 0);
        }

        PrepareParams() {
        }

        PrepareParams(Parcel parcel) {
            this.jCD = parcel.readInt();
            this.jCE = parcel.readInt();
            this.jCF = parcel.readString();
            this.mAppId = parcel.readString();
            this.jCG = parcel.readInt();
            this.jCH = (AppBrandLaunchReferrer) parcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader());
            this.jCI = parcel.readString();
            this.jCJ = parcel.readInt();
            this.jCu = parcel.readInt() == 1;
        }
    }

    private static final class PrepareResult implements Parcelable {
        public static final Creator<PrepareResult> CREATOR = new Creator<PrepareResult>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new PrepareResult(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new PrepareResult[i];
            }
        };
        private AppBrandSysConfig isS;
        private int jCK;
        private AppBrandLaunchErrorAction jCL;
        private int jCM;
        private com.tencent.mm.plugin.appbrand.jsapi.version.a jCN;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.jCK);
            parcel.writeParcelable(this.jCL, i);
            parcel.writeParcelable(this.isS, i);
            parcel.writeInt(this.jCM);
            if (this.jCK == 5) {
                parcel.writeString(this.jCN.toString());
            }
        }

        PrepareResult() {
        }

        PrepareResult(Parcel parcel) {
            this.jCK = parcel.readInt();
            this.jCL = (AppBrandLaunchErrorAction) parcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader());
            this.isS = (AppBrandSysConfig) parcel.readParcelable(AppBrandSysConfig.class.getClassLoader());
            this.jCM = parcel.readInt();
            if (this.jCK == 5) {
                this.jCN = com.tencent.mm.plugin.appbrand.jsapi.version.a.ti(parcel.readString());
            }
        }
    }

    private static final class a implements h<PrepareParams, PrepareResult> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, final i iVar) {
            final PrepareParams prepareParams = (PrepareParams) obj;
            String a = prepareParams.mAppId;
            int b = prepareParams.jCG;
            int c = prepareParams.jCE;
            String d = prepareParams.jCF;
            b anonymousClass1 = new b() {
                public final void aiu() {
                    if (iVar != null) {
                        PrepareResult prepareResult = new PrepareResult();
                        prepareResult.jCK = 1;
                        iVar.as(prepareResult);
                    }
                }

                public final void lg(int i) {
                    if (iVar != null) {
                        PrepareResult prepareResult = new PrepareResult();
                        prepareResult.jCM = i;
                        prepareResult.jCK = 4;
                        iVar.as(prepareResult);
                    }
                }

                public final void a(AppBrandSysConfig appBrandSysConfig, AppBrandLaunchErrorAction appBrandLaunchErrorAction) {
                    if (iVar != null) {
                        if (appBrandSysConfig != null) {
                            g.Do();
                            appBrandSysConfig.uin = com.tencent.mm.kernel.a.Cn();
                        }
                        if (appBrandSysConfig != null) {
                            appBrandSysConfig.iRX = com.tencent.mm.plugin.appbrand.game.cgipkg.a.sc(appBrandSysConfig.appId);
                        }
                        PrepareResult prepareResult = new PrepareResult();
                        prepareResult.jCK = 2;
                        prepareResult.isS = appBrandSysConfig;
                        prepareResult.jCL = appBrandLaunchErrorAction;
                        iVar.as(prepareResult);
                        if (appBrandSysConfig != null) {
                            com.tencent.mm.cc.g.cDh().h(new com.tencent.mm.plugin.appbrand.launching.g.AnonymousClass1(new g(appBrandSysConfig.foe, prepareParams.jCE, new com.tencent.mm.plugin.appbrand.launching.g.a() {
                                public final void b(com.tencent.mm.plugin.appbrand.jsapi.version.a aVar) {
                                    x.i("MicroMsg.AppBrandPrepareTask", "[appversion] dispatch %s, %s", prepareParams.mAppId, aVar);
                                    PrepareResult prepareResult = new PrepareResult();
                                    prepareResult.jCK = 5;
                                    prepareResult.jCN = aVar;
                                    iVar.as(prepareResult);
                                }
                            })));
                        }
                    }
                }
            };
            d tD = d.tD(prepareParams.jCI);
            if (tD == null) {
                tD = new d(a, b, prepareParams.jCD, c, d, prepareParams.jCH, prepareParams.jCI, prepareParams.jCJ, false, prepareParams.jCu);
                com.tencent.mm.kernel.api.g anonymousClass2 = new com.tencent.mm.kernel.api.g() {
                    public final void um() {
                        g.Do();
                        boolean CE = com.tencent.mm.kernel.a.CE();
                        boolean Cz = com.tencent.mm.kernel.a.Cz();
                        if (!CE || Cz) {
                            x.i("MicroMsg.AppBrandPrepareTask", "prepareCall, startup done, hasLogin %B, hold %B", Boolean.valueOf(CE), Boolean.valueOf(Cz));
                            ah.y(new Runnable() {
                                public final void run() {
                                    Toast.makeText(ad.getContext(), j.iAJ, 0).show();
                                    try {
                                        Intent intent = new Intent();
                                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(67108864);
                                        d.a(ad.getContext(), "com.tencent.mm.ui.LauncherUI", intent);
                                    } catch (Exception e) {
                                    }
                                }
                            });
                            if (iVar != null) {
                                PrepareResult prepareResult = new PrepareResult();
                                prepareResult.jCK = 3;
                                iVar.as(prepareResult);
                                return;
                            }
                            return;
                        }
                        c anonymousClass2 = new c<bx>() {
                            {
                                this.xmG = bx.class.getName().hashCode();
                            }

                            private boolean a(bx bxVar) {
                                if (bxVar != null) {
                                    dead();
                                    x.i("MicroMsg.AppBrandPrepareTask", "prepareCall account notifyAllDone, start real prepare");
                                }
                                tD.ait();
                                return false;
                            }
                        };
                        if (g.Do().gRj) {
                            anonymousClass2.a(null);
                            return;
                        }
                        x.i("MicroMsg.AppBrandPrepareTask", "prepareCall account not notifyAllDone yet, wait for it");
                        anonymousClass2.cfB();
                    }

                    public final void aI(boolean z) {
                    }
                };
                if (g.Dr().gSp.gSI) {
                    anonymousClass2.um();
                } else {
                    x.i("MicroMsg.AppBrandPrepareTask", "prepareCall kernel startup not done yet, wait for it");
                    g.Dr().a(anonymousClass2);
                }
            }
            tD.jCT = anonymousClass1;
            if (tD.started && tD.jCU != null) {
                x.v("MicroMsg.AppBrand.AppLaunchPrepareProcess", "[applaunch] setCallback already done %s %d", tD.appId, Integer.valueOf(tD.iNi));
                tD.a(tD.jCU);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ WxaPkgWrappingInfo jCw;

        AnonymousClass4(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
            this.jCw = wxaPkgWrappingInfo;
        }

        public final void run() {
            x.i("MicroMsg.AppBrandPrepareTask", "runInClientProcess, prepare done, appPkg [%d | %s]", Integer.valueOf(this.jCw.iJb), bi.fK(this.jCw.iJc));
        }
    }

    public interface b {
        void a(com.tencent.mm.plugin.appbrand.jsapi.version.a aVar);

        void b(AppBrandSysConfig appBrandSysConfig);

        void jv(int i);

        void onDownloadStarted();
    }

    public AppBrandPrepareTask(MMActivity mMActivity, e eVar) {
        int i = 0;
        AppBrandStatObject appBrandStatObject = eVar.itc;
        this.jCt = new WeakReference(mMActivity);
        this.jCr.mAppId = eVar.mAppId;
        this.jCr.jCG = eVar.isR.iIZ;
        this.jCr.jCD = appBrandStatObject == null ? 0 : appBrandStatObject.fJn;
        PrepareParams prepareParams = this.jCr;
        if (appBrandStatObject != null) {
            i = appBrandStatObject.scene;
        }
        prepareParams.jCE = i;
        this.jCr.jCF = eVar.isR.iRi;
        this.jCr.jCH = eVar.isR.iRl;
        this.jCr.jCI = eVar.isR.iub;
        this.jCr.jCu = eVar.YI();
        this.jCu = eVar.YI();
    }

    public final void ait() {
        if (ah.isMainThread()) {
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    AppBrandPrepareTask.this.ait();
                }
            }, "AppBrandPrepareTask" + this.jCr.toShortString());
            return;
        }
        if (!ab.ZY()) {
            x.i("MicroMsg.AppBrandPrepareTask", "startPrepare(), CommLib not loaded, %s", this.jCr.toShortString());
            ab.kt();
        }
        this.jCr.jCJ = ab.aaa().iJb;
        XIPCInvoker.a("com.tencent.mm", this.jCr, a.class, new i<PrepareResult>() {
            public final /* synthetic */ void as(Object obj) {
                PrepareResult prepareResult = (PrepareResult) obj;
                AppBrandPrepareTask appBrandPrepareTask = AppBrandPrepareTask.this;
                x.i("MicroMsg.AppBrandPrepareTask", "[applaunch] runInClientProcess, event = %d, %s %d", Integer.valueOf(prepareResult.jCK), appBrandPrepareTask.jCr.mAppId, Integer.valueOf(appBrandPrepareTask.jCr.jCG));
                switch (prepareResult.jCK) {
                    case 1:
                        if (appBrandPrepareTask.jCs != null) {
                            appBrandPrepareTask.jCs.onDownloadStarted();
                            return;
                        }
                        return;
                    case 2:
                        if (prepareResult.isS == null && prepareResult.jCL == null) {
                            com.tencent.mm.plugin.appbrand.r.c.Dt().F(new Runnable() {
                                public final void run() {
                                    int i = 369;
                                    if (AppBrandPrepareTask.this.jCu) {
                                        i = 777;
                                    }
                                    com.tencent.mm.plugin.report.service.g.pWK.a((long) i, 3, 1, false);
                                    com.tencent.mm.plugin.appbrand.report.a.a(AppBrandPrepareTask.this.jCr.mAppId, 0, AppBrandPrepareTask.this.jCr.jCG, i, 3);
                                }
                            });
                        }
                        if (appBrandPrepareTask.jCs != null) {
                            if (prepareResult.isS != null) {
                                com.tencent.mm.plugin.appbrand.r.c.Dt().F(new AnonymousClass4(prepareResult.isS.iRU));
                                if (prepareResult.isS.iRX != null) {
                                    com.tencent.mm.plugin.appbrand.i.pF(prepareResult.isS.appId).iuh = prepareResult.isS.iRX;
                                }
                            } else {
                                x.i("MicroMsg.AppBrandPrepareTask", "runInClientProcess, config null");
                                if (!(prepareResult.jCL == null || appBrandPrepareTask.jCt == null || ((MMActivity) appBrandPrepareTask.jCt.get()) == null)) {
                                    prepareResult.jCL.cb(ad.getContext());
                                }
                            }
                            appBrandPrepareTask.jCs.b(prepareResult.isS);
                        } else {
                            x.e("MicroMsg.AppBrandPrepareTask", "runInClientProcess, prepare done, but callback is null");
                        }
                        com.tencent.mm.plugin.appbrand.r.c.bl(appBrandPrepareTask);
                        return;
                    case 3:
                        WeakReference weakReference = appBrandPrepareTask.jCt;
                        MMActivity mMActivity = weakReference == null ? null : (MMActivity) weakReference.get();
                        if (mMActivity != null) {
                            mMActivity.finish();
                            mMActivity.overridePendingTransition(0, 0);
                        }
                        Process.killProcess(Process.myPid());
                        return;
                    case 4:
                        if (appBrandPrepareTask.jCs != null) {
                            appBrandPrepareTask.jCs.jv(prepareResult.jCM);
                            return;
                        }
                        return;
                    case 5:
                        if (appBrandPrepareTask.jCs != null) {
                            appBrandPrepareTask.jCs.a(prepareResult.jCN);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
        x.i("MicroMsg.AppBrandPrepareTask", "[applaunch] startPrepare in appbrand %s, %d", this.jCr.mAppId, Integer.valueOf(this.jCr.jCG));
    }
}
