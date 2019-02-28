package com.tencent.mm.plugin.appbrand.game.b;

import android.graphics.Typeface;
import com.tencent.magicbrush.handler.a.b;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class a {

    /* renamed from: com.tencent.mm.plugin.appbrand.game.b.a$1 */
    static class AnonymousClass1 implements b {
        final /* synthetic */ e jbs;

        public AnonymousClass1(e eVar) {
            this.jbs = eVar;
        }

        public final Typeface bA(String str) {
            Typeface typeface = null;
            x.i("MBFontManagerRegistry", "loadFont at path[%s]", str);
            if (str == null || str.length() == 0) {
                return typeface;
            }
            String g;
            if (str.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
                g = AnonymousClass1.g(this.jbs, str);
            } else {
                g = AnonymousClass1.h(this.jbs, str);
            }
            if (g == null) {
                return typeface;
            }
            try {
                return Typeface.createFromFile(g);
            } catch (Exception e) {
                x.e("MBFontManagerRegistry", "Create typeface from file failed. pkgPath = [%s], filePath = [%s]", str, g);
                return typeface;
            }
        }

        private static String g(e eVar, String str) {
            try {
                File ql = eVar.isU.ql(str);
                if (ql != null) {
                    return ql.getAbsolutePath();
                }
                x.e("MBFontManagerRegistry", "Read [%s] from filesystem failed, no file", str);
                return null;
            } catch (Exception e) {
                x.e("MBFontManagerRegistry", "Read [%s] from filesystem failed", str);
                return null;
            }
        }

        private static String h(e eVar, String str) {
            String str2 = null;
            try {
                return ao.f(eVar, str);
            } catch (Exception e) {
                x.e("MBFontManagerRegistry", "Read [%s] from WxaPkgRuntimeReader failed", str);
                return str2;
            }
        }
    }
}
