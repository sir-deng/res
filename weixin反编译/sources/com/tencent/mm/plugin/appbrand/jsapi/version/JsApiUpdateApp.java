package com.tencent.mm.plugin.appbrand.jsapi.version;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.config.r.b;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.ah;
import org.json.JSONObject;

public final class JsApiUpdateApp extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 359;
    private static final String NAME = "updateApp";

    private static final class SyncResult implements Parcelable {
        public static final Creator<SyncResult> CREATOR = new Creator<SyncResult>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SyncResult(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SyncResult[i];
            }
        };
        private int fJh;
        private boolean jva;

        SyncResult(boolean z, int i) {
            this.jva = z;
            this.fJh = i;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeByte(this.jva ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.fJh);
        }

        SyncResult(Parcel parcel) {
            this.jva = parcel.readByte() != (byte) 0;
            this.fJh = parcel.readInt();
        }
    }

    private static final class a implements h<IPCString, SyncResult> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, final i iVar) {
            r.a(((IPCString) obj).value, true, new b<WxaAttributes>() {
                public final /* synthetic */ void d(int i, Object obj) {
                    WxaAttributes wxaAttributes = (WxaAttributes) obj;
                    switch (i) {
                        case 1:
                        case 2:
                            iVar.as(new SyncResult(true, wxaAttributes.acs().fJh));
                            return;
                        case 3:
                            iVar.as(new SyncResult(false, -1));
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        XIPCInvoker.a("com.tencent.mm", new IPCString(jVar.iuk.isS.foe), a.class, new i<SyncResult>() {
            public final /* synthetic */ void as(Object obj) {
                SyncResult syncResult = (SyncResult) obj;
                if (!syncResult.jva) {
                    jVar.E(i, JsApiUpdateApp.this.e("fail sync error", null));
                } else if (jVar.iuk.isS.iRU.iJa == 0 && syncResult.fJh == jVar.iuk.isS.iRU.iJb) {
                    jVar.E(i, JsApiUpdateApp.this.e("fail the current version is the latest version", null));
                } else {
                    ah.y(new Runnable() {
                        public final void run() {
                            com.tencent.mm.plugin.appbrand.widget.c.h bVar = new com.tencent.mm.plugin.appbrand.widget.c.b(jVar.getContext());
                            bVar.setMessage(jVar.getContext().getString(jVar.iuk.YI() ? q.j.iCo : q.j.iCp, new Object[]{jVar.iuk.isR.fsi}));
                            OnClickListener anonymousClass1 = new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    s.g(jVar.iuk);
                                }
                            };
                            if (jVar.iuk.isS.iRU.iJa != 0) {
                                bVar.a(q.j.iCn, anonymousClass1);
                                bVar.b(q.j.iCl, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        jVar.E(i, JsApiUpdateApp.this.e("fail user canceled updateApp", null));
                                    }
                                });
                            } else {
                                bVar.a(q.j.iCm, anonymousClass1);
                            }
                            jVar.iuk.a(bVar);
                        }
                    });
                }
            }
        });
    }
}
