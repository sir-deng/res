package com.tencent.mm.plugin.music.model.a;

import android.text.TextUtils;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure;
import com.tencent.qqmusic.mediaplayer.ILog;
import com.tencent.qqmusic.mediaplayer.ISoLibraryLoader;

public class c {
    public static void bes() {
        x.i("MicroMsg..Audio.AudioPlayerUtils", "configQQMusicSdkConfig");
        AudioPlayerConfigure.setLog(new ILog() {
            public final void d(String str, String str2) {
                x.d(str, str2);
            }

            public final void w(String str, String str2) {
                x.w(str, str2);
            }

            public final void e(String str, String str2) {
                x.e(str, str2);
            }

            public final void i(String str, String str2) {
                x.i(str, str2);
            }

            public final void i(String str, String str2, Throwable th) {
                x.printErrStackTrace(str, th, str2, new Object[0]);
            }

            public final void e(String str, Throwable th) {
                x.printErrStackTrace(str, th, " throwable", new Object[0]);
            }

            public final void e(String str, String str2, Throwable th) {
                x.printErrStackTrace(str, th, str2, new Object[0]);
            }

            public final void e(String str, String str2, Object... objArr) {
                x.e(str, String.format(str2, objArr));
            }
        });
        AudioPlayerConfigure.setSoLibraryLoader(new ISoLibraryLoader() {
            public final boolean load(String str) {
                if (TextUtils.isEmpty(str)) {
                    x.e("MicroMsg..Audio.AudioPlayerUtils", "LoadLibrary lib_name is null");
                    return false;
                } else if (k.eN(str)) {
                    return true;
                } else {
                    x.i("MicroMsg..Audio.AudioPlayerUtils", "load library %s", str);
                    ClassLoader classLoader = c.class.getClassLoader();
                    if (TextUtils.isEmpty(k.eO(str))) {
                        x.e("MicroMsg..Audio.AudioPlayerUtils", "LoadLibrary can't find the lib %s so", str);
                        return false;
                    }
                    x.i("MicroMsg..Audio.AudioPlayerUtils", "LoadLibrary find and load the lib %s so", k.eO(str));
                    k.b(str, classLoader);
                    return true;
                }
            }
        });
    }
}
