package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.bl.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.sport.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class JsApiOpenWeRunSetting extends a {
    public static final int CTRL_INDEX = 228;
    public static final String NAME = "openWeRunSetting";
    private OpenWeRunSetting jgR;

    private static class OpenWeRunSetting extends MainProcessTask {
        public static final Creator<OpenWeRunSetting> CREATOR = new Creator<OpenWeRunSetting>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new OpenWeRunSetting(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OpenWeRunSetting[i];
            }
        };
        private boolean fKG = false;
        private e jfZ;
        private boolean jgS = false;
        private boolean jgT;
        private j jga;
        private int jgb;

        public OpenWeRunSetting(e eVar, j jVar, int i, boolean z) {
            x.i("MicroMsg.JsApiOpenWeRunSetting", "OpenWeRunSetting");
            this.jfZ = eVar;
            this.jga = jVar;
            this.jgb = i;
            this.jgT = z;
        }

        public OpenWeRunSetting(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            this.jgS = ((b) g.h(b.class)).dA(ad.getContext());
            if (!this.jgT || this.jgS) {
                afL();
            } else {
                ((a) g.h(a.class)).a(new a.a() {
                    public final void m(boolean z, boolean z2) {
                        boolean z3;
                        OpenWeRunSetting openWeRunSetting = OpenWeRunSetting.this;
                        if (z && z2) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        openWeRunSetting.jgS = z3;
                        x.i("MicroMsg.JsApiOpenWeRunSetting", "After getUserState requestOk %b, hasStep %b", Boolean.valueOf(z), Boolean.valueOf(z2));
                        OpenWeRunSetting.this.afL();
                    }
                });
            }
        }

        private void afL() {
            if (!this.jgT || this.jgS) {
                this.fKG = ((b) g.h(b.class)).bDN();
                if (this.jgT && this.fKG) {
                    ((b) g.h(b.class)).bDM();
                }
            }
            afF();
        }

        public final void YB() {
            if (this.jgT && !this.jgS) {
                this.jga.E(this.jgb, this.jfZ.e("fail device not support", null));
                afz();
            } else if (this.fKG) {
                this.jga.E(this.jgb, this.jfZ.e("ok", null));
                afz();
            } else {
                Context a = this.jfZ.a(this.jga);
                if (a == null) {
                    this.jga.E(this.jgb, this.jfZ.e("fail", null));
                    afz();
                    return;
                }
                AppBrandSysConfig appBrandSysConfig = this.jga.iuk.isS;
                if (appBrandSysConfig == null || bi.oN(appBrandSysConfig.fsi)) {
                    this.jga.E(this.jgb, this.jfZ.e("fail", null));
                    afz();
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("OpenWeRunSettingName", appBrandSysConfig.fsi);
                a.jCj = new MMActivity.a() {
                    public final void b(int i, int i2, Intent intent) {
                        if (i != (OpenWeRunSetting.this.hashCode() & 65535)) {
                            OpenWeRunSetting.this.afz();
                        } else if (i2 == -1) {
                            OpenWeRunSetting.this.jga.E(OpenWeRunSetting.this.jgb, OpenWeRunSetting.this.jfZ.e("ok", null));
                            OpenWeRunSetting.this.afz();
                        } else if (i2 == 0) {
                            OpenWeRunSetting.this.jga.E(OpenWeRunSetting.this.jgb, OpenWeRunSetting.this.jfZ.e("cancel", null));
                            OpenWeRunSetting.this.afz();
                        } else {
                            OpenWeRunSetting.this.jga.E(OpenWeRunSetting.this.jgb, OpenWeRunSetting.this.jfZ.e("fail", null));
                            OpenWeRunSetting.this.afz();
                        }
                    }
                };
                d.a(a, "appbrand", ".ui.AppBrandOpenWeRunSettingUI", intent, hashCode() & 65535, false);
                afz();
            }
        }

        public final void f(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.jgS = z;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.fKG = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.jgT = z2;
        }

        public void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            if (this.jgS) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (this.fKG) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.jgT) {
                b2 = (byte) 0;
            }
            parcel.writeByte(b2);
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        boolean z = true;
        if (jSONObject != null) {
            z = jSONObject.optBoolean("checkSupport", true);
        }
        this.jgR = new OpenWeRunSetting(this, jVar, i, z);
        this.jgR.afy();
        AppBrandMainProcessService.a(this.jgR);
    }
}
