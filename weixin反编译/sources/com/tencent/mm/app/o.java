package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.splash.b;
import com.tencent.mm.splash.e;
import com.tencent.mm.splash.k;
import com.tencent.mm.xlog.app.XLogSetup;

public final class o {
    private static h fgj;
    private static a fgk;
    private static boolean fgl = false;
    private static boolean fgm = false;
    private static com.tencent.mm.splash.k.a fgn;

    public interface a {
        void a(Application application, String str, MMApplicationLike mMApplicationLike);

        void c(com.tencent.mm.splash.k.a aVar);

        void ul();
    }

    public static h uf() {
        return fgj;
    }

    public static void a(h hVar) {
        fgj = hVar;
    }

    public static void ug() {
        e.a(new b() {
            public final void c(Activity activity) {
                if (o.fgj != null && o.fgj.DZ()) {
                    SharedPreferences sharedPreferences = activity.getSharedPreferences("system_config_prefs", 4);
                    if (sharedPreferences.getBoolean("first_launch_weixin", true)) {
                        sharedPreferences.edit().putBoolean("first_launch_weixin", false).commit();
                        XLogSetup.realSetupXlog();
                    }
                }
            }

            public final void a(Throwable th, String str) {
                x.printErrStackTrace("WxSplash.WeChatSplash", th, str, new Object[0]);
                if (str == null) {
                    str = "";
                }
                e.cil().xuJ.add(str + "  " + Log.getStackTraceString(th));
            }

            public final void a(String str, String str2, Object... objArr) {
                x.i(str, str2, objArr);
            }
        });
    }

    public static void a(Application application, String str, final String str2) {
        boolean z;
        com.tencent.mm.blink.a.av(MMApplicationLike.sAppStartTime);
        ug();
        e.a(new k() {
            public final void b(com.tencent.mm.splash.k.a aVar) {
                x.i("WxSplash.WeChatSplash", "do one more thing");
                o.fgn = aVar;
                o.cv(str2);
                o.uh();
            }
        });
        e.E(WeChatSplashActivity.class);
        e.F(WeChatFallbackSplashActivity.class);
        e.cil().mStartTimestamp = System.currentTimeMillis();
        if (!application.getPackageName().equals(str)) {
            e.a("WxSplash.WeChatSplash", "not main process(%s), no hack, do fallback.", str);
            z = true;
        } else if (e.e(application)) {
            z = false;
            e.cig();
        } else {
            e.cil().e(675, 5, 1);
            e.fl(application);
            e.a("WxSplash.WeChatSplash", "hack failed, do fallback logic.", new Object[0]);
            z = true;
        }
        fgl = z;
        com.tencent.mm.blink.a.fi(1);
        if (z) {
            if (com.tencent.mm.splash.a.ff(application)) {
                try {
                    com.tencent.mm.splash.a.fh(application);
                    e.a("WxSplash.WeChatSplash", "block checking dex opt result: %s", Boolean.valueOf(com.tencent.mm.splash.a.fj(application)));
                    if (!com.tencent.mm.splash.a.fj(application)) {
                        e.a("WxSplash.WeChatSplash", "dexopt service return failed or timeout. kill self.", new Object[0]);
                        e.cif();
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("WxSplash.WeChatSplash", e, "", new Object[0]);
                    throw new RuntimeException(e);
                }
            }
            com.tencent.mm.splash.a.fg(application);
        }
        if (com.tencent.mm.e.a.oG || z) {
            cv(str2);
        }
    }

    private static void cv(String str) {
        if (fgk == null) {
            a cw = cw(str);
            cw.a(fgj.gUt, fgj.gQd, fgj.gUv);
            fgk = cw;
        }
    }

    private static void uh() {
        if (fgm && fgn != null) {
            fgk.c(fgn);
        }
    }

    public static void ui() {
        if (fgm) {
            e.a("WxSplash.WeChatSplash", "applicationOnCreate sApplicationOnCreated", new Object[0]);
            return;
        }
        e.a("WxSplash.WeChatSplash", "applicationOnCreate", new Object[0]);
        e.cib();
        fgm = true;
        if (fgl) {
            fgk.ul();
        } else {
            uh();
        }
    }

    private static a cw(String str) {
        try {
            return (a) Class.forName(str).newInstance();
        } catch (Throwable e) {
            x.printErrStackTrace("WxSplash.WeChatSplash", e, "%s has problem!", str);
            throw new RuntimeException(e);
        }
    }
}
