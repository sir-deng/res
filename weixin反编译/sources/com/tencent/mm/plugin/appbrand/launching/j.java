package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import java.util.Locale;
import java.util.concurrent.Callable;

public interface j extends Callable<WxaPkgWrappingInfo> {

    public static final class a extends Error {
        final String jDj;

        static final class a {
            String jDj;
            String jDk;

            a() {
            }

            final a f(String str, Object... objArr) {
                this.jDj = String.format(Locale.US, str, objArr);
                return this;
            }

            final a g(String str, Object... objArr) {
                this.jDk = String.format(Locale.US, str, objArr);
                return this;
            }

            final a aiB() {
                return new a(this.jDk, this.jDj);
            }
        }

        a(String str, String str2) {
            super(str);
            this.jDj = str2;
        }
    }

    void lg(int i);
}
