package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.f;
import java.nio.channels.FileLock;

class af {
    private static af AiT;
    private static FileLock AiW = null;
    boolean AfA;
    ag AiU;
    private boolean AiV;

    private af() {
    }

    public static af cFZ() {
        if (AiT == null) {
            synchronized (af.class) {
                if (AiT == null) {
                    AiT = new af();
                }
            }
        }
        return AiT;
    }

    public final synchronized void b(Context context, s sVar) {
        Object obj;
        Object obj2 = null;
        synchronized (this) {
            if (sVar != null) {
                sVar.b("x5_core_engine_init_sync", (byte) 2);
            }
            h nW = h.nW(true);
            nW.a(context, sVar);
            StringBuilder stringBuilder = new StringBuilder();
            if (sVar != null) {
                sVar.b("init_x5_core", (byte) 1);
            }
            aa cEO = nW.cEO();
            if (!nW.Afz || cEO == null) {
                this.AiV = false;
                stringBuilder.append("can not use X5 by !tbs available");
                obj = null;
            } else {
                if (!this.AfA) {
                    if (sVar != null) {
                        sVar.AgQ = true;
                    }
                    this.AiU = new ag(cEO.Ain);
                    try {
                        this.AiV = this.AiU.cGc();
                        if (!this.AiV) {
                            stringBuilder.append("can not use X5 by x5corewizard return false");
                        }
                        obj = null;
                    } catch (NoSuchMethodException e) {
                        this.AiV = true;
                        obj = null;
                    } catch (Throwable th) {
                        obj = th;
                        this.AiV = false;
                        stringBuilder.append("can not use x5 by throwable " + Log.getStackTraceString(obj));
                    }
                    if (this.AiV) {
                        CookieManager.getInstance().p(context, true);
                        CookieManager.getInstance().cEG();
                    }
                }
                obj = null;
            }
            if (!this.AiV) {
                TbsLog.e("X5CoreEngine", "mCanUseX5 is false --> report");
                if (nW.Afz && cEO != null && obj == null) {
                    try {
                        DexLoader dexLoader = cEO.Ain;
                        if (dexLoader != null) {
                            obj2 = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
                        }
                        if (obj2 instanceof Throwable) {
                            Throwable th2 = (Throwable) obj2;
                            stringBuilder.append("#" + th2.getMessage() + "; cause: " + th2.getCause() + "; th: " + th2);
                        }
                        if (obj2 instanceof String) {
                            stringBuilder.append("failure detail:" + obj2);
                        }
                    } catch (Throwable th3) {
                    }
                    if (stringBuilder.toString().contains("isPreloadX5Disabled:-10000")) {
                        m.cEY().a(context, av.CTRL_INDEX, new Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + stringBuilder.toString()));
                    } else {
                        m.cEY().a(context, JsApiPrivateAddContact.CTRL_INDEX, new Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + stringBuilder.toString()));
                    }
                } else if (nW.Afz) {
                    m.cEY().a(context, 409, new Throwable("mCanUseX5=false, available true, reason: " + obj));
                } else {
                    m.cEY().a(context, JsApiBatchGetContact.CTRL_INDEX, new Throwable("mCanUseX5=false, available false, reason: " + obj));
                }
            } else if (AiW == null) {
                hE(context);
            }
            this.AfA = true;
            if (sVar != null) {
                sVar.b("init_x5_core", (byte) 2);
            }
        }
    }

    public final boolean cGa() {
        return QbSdk.AeV ? false : this.AiV;
    }

    public final ag cGb() {
        return QbSdk.AeV ? null : this.AiU;
    }

    public final synchronized FileLock hE(Context context) {
        FileLock fileLock;
        if (AiW != null) {
            fileLock = AiW;
        } else {
            fileLock = f.hV(context);
            AiW = fileLock;
        }
        return fileLock;
    }
}
