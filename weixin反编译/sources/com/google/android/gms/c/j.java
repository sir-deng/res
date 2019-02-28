package com.google.android.gms.c;

import android.os.Binder;

public abstract class j<T> {
    private static final Object aEw = new Object();
    static a aXt = null;
    private static int aXu = 0;
    private static String aXv = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    private T aIl = null;
    protected final String aXw;
    protected final T aXx;

    private interface a {
        Boolean pB();

        Long pC();

        Integer pD();

        Float pE();

        String pF();
    }

    protected j(String str, T t) {
        this.aXw = str;
        this.aXx = t;
    }

    public static j<Float> a(String str, Float f) {
        return new j<Float>(str, f) {
            protected final /* synthetic */ Object pz() {
                return j.aXt.pE();
            }
        };
    }

    public static j<Integer> a(String str, Integer num) {
        return new j<Integer>(str, num) {
            protected final /* synthetic */ Object pz() {
                return j.aXt.pD();
            }
        };
    }

    public static j<Long> a(String str, Long l) {
        return new j<Long>(str, l) {
            protected final /* synthetic */ Object pz() {
                return j.aXt.pC();
            }
        };
    }

    public static j<Boolean> h(String str, boolean z) {
        return new j<Boolean>(str, Boolean.valueOf(z)) {
            protected final /* synthetic */ Object pz() {
                return j.aXt.pB();
            }
        };
    }

    public static boolean isInitialized() {
        return aXt != null;
    }

    public static j<String> n(String str, String str2) {
        return new j<String>(str, str2) {
            protected final /* synthetic */ Object pz() {
                return j.aXt.pF();
            }
        };
    }

    public static int py() {
        return aXu;
    }

    public final T get() {
        return this.aIl != null ? this.aIl : pz();
    }

    public final T pA() {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            T t = get();
            return t;
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    protected abstract T pz();
}
