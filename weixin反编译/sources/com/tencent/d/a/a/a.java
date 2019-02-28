package com.tencent.d.a.a;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.CancellationSignal;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public final class a {
    static final e AkT;
    private Context mContext;

    public static abstract class b {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void bDE() {
        }

        public void onAuthenticationFailed() {
        }

        public void aLk() {
        }
    }

    public static final class c {
        private d AkW;

        public c(d dVar) {
            this.AkW = dVar;
        }
    }

    public static class d {
        final Signature AkX;
        final Cipher AkY;
        final Mac AkZ;

        public d(Signature signature) {
            this.AkX = signature;
            this.AkY = null;
            this.AkZ = null;
        }

        public d(Cipher cipher) {
            this.AkY = cipher;
            this.AkX = null;
            this.AkZ = null;
        }

        public d(Mac mac) {
            this.AkZ = mac;
            this.AkY = null;
            this.AkX = null;
        }
    }

    private interface e {
        void a(Context context, d dVar, int i, CancellationSignal cancellationSignal, b bVar, Handler handler);

        boolean ii(Context context);

        boolean ij(Context context);
    }

    private static class a implements e {
        static /* synthetic */ boolean a(com.tencent.d.a.a.b.a aVar, Context context) {
            if (c.cGI()) {
                com.tencent.d.a.c.c.v("Soter.FingerprintManagerCompat", "soter: using system anti brute force strategy", new Object[0]);
                return false;
            } else if (c.io(context)) {
                if (c.ip(context)) {
                    return false;
                }
                com.tencent.d.a.c.c.v("Soter.FingerprintManagerCompat", "soter: unfreeze former frozen status", new Object[0]);
                c.in(context);
                return false;
            } else if (c.ip(context)) {
                com.tencent.d.a.c.c.v("Soter.FingerprintManagerCompat", "soter: failure time available", new Object[0]);
                return false;
            } else {
                a(aVar);
                return true;
            }
        }

        public final boolean ii(Context context) {
            return b.ii(context);
        }

        public final boolean ij(Context context) {
            return b.ij(context);
        }

        public final void a(final Context context, d dVar, int i, CancellationSignal cancellationSignal, final b bVar, Handler handler) {
            com.tencent.d.a.a.b.c cVar;
            com.tencent.d.a.a.b.a anonymousClass1;
            FingerprintManager ik;
            CryptoObject cryptoObject;
            if (dVar != null) {
                if (dVar.AkY != null) {
                    cVar = new com.tencent.d.a.a.b.c(dVar.AkY);
                } else if (dVar.AkX != null) {
                    cVar = new com.tencent.d.a.a.b.c(dVar.AkX);
                } else if (dVar.AkZ != null) {
                    cVar = new com.tencent.d.a.a.b.c(dVar.AkZ);
                }
                anonymousClass1 = new com.tencent.d.a.a.b.a() {
                    private boolean AkU = false;

                    public final void onAuthenticationError(int i, CharSequence charSequence) {
                        while (true) {
                            com.tencent.d.a.c.c.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationError", new Object[0]);
                            if (!this.AkU) {
                                this.AkU = true;
                                if (i == 5) {
                                    com.tencent.d.a.c.c.i("Soter.FingerprintManagerCompat", "soter: user cancelled fingerprint authen", new Object[0]);
                                    bVar.aLk();
                                    return;
                                } else if (i == 7) {
                                    com.tencent.d.a.c.c.i("Soter.FingerprintManagerCompat", "soter: system call too many trial.", new Object[0]);
                                    if (!(c.ip(context) || c.io(context) || c.cGI())) {
                                        c.im(context);
                                    }
                                    this.AkU = false;
                                    i = 10308;
                                    charSequence = "Too many failed times";
                                } else {
                                    bVar.onAuthenticationError(i, charSequence);
                                    return;
                                }
                            }
                            return;
                        }
                    }

                    public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                        com.tencent.d.a.c.c.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationHelp", new Object[0]);
                        if (!this.AkU && !a.a(this, context)) {
                            bVar.onAuthenticationHelp(i, charSequence);
                        }
                    }

                    public final void a(com.tencent.d.a.a.b.b bVar) {
                        com.tencent.d.a.c.c.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationSucceeded", new Object[0]);
                        if (!this.AkU && !a.a(this, context)) {
                            d dVar;
                            c cVar;
                            if (!c.cGI()) {
                                c.in(context);
                            }
                            this.AkU = true;
                            b bVar2 = bVar;
                            com.tencent.d.a.a.b.c cVar2 = bVar.Alb;
                            if (cVar2 != null) {
                                if (cVar2.AkY != null) {
                                    dVar = new d(cVar2.AkY);
                                } else if (cVar2.AkX != null) {
                                    dVar = new d(cVar2.AkX);
                                } else if (cVar2.AkZ != null) {
                                    dVar = new d(cVar2.AkZ);
                                }
                                cVar = new c(dVar);
                                bVar2.bDE();
                            }
                            dVar = null;
                            cVar = new c(dVar);
                            bVar2.bDE();
                        }
                    }

                    public final void onAuthenticationFailed() {
                        com.tencent.d.a.c.c.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationFailed", new Object[0]);
                        if (!this.AkU && !a.a(this, context)) {
                            if (!c.cGI()) {
                                Context context = context;
                                c.as(context, Integer.valueOf(Integer.valueOf(c.il(context)).intValue() + 1).intValue());
                                if (!c.ip(context)) {
                                    com.tencent.d.a.c.c.w("Soter.FingerprintManagerCompat", "soter: too many fail trials", new Object[0]);
                                    c.im(context);
                                    a.a(this);
                                    return;
                                }
                            }
                            bVar.onAuthenticationFailed();
                        }
                    }
                };
                if (b.b(context, "android.permission.USE_FINGERPRINT") == 0) {
                    com.tencent.d.a.c.c.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: authenticate", new Object[0]);
                }
                try {
                    ik = b.ik(context);
                    if (ik == null) {
                        if (cVar != null) {
                            if (cVar.AkY != null) {
                                cryptoObject = new CryptoObject(cVar.AkY);
                            } else if (cVar.AkX != null) {
                                cryptoObject = new CryptoObject(cVar.AkX);
                            } else if (cVar.AkZ != null) {
                                cryptoObject = new CryptoObject(cVar.AkZ);
                            }
                            ik.authenticate(cryptoObject, cancellationSignal, 0, new com.tencent.d.a.a.b.AnonymousClass1(anonymousClass1), null);
                            return;
                        }
                        cryptoObject = null;
                        ik.authenticate(cryptoObject, cancellationSignal, 0, new com.tencent.d.a.a.b.AnonymousClass1(anonymousClass1), null);
                        return;
                    }
                    com.tencent.d.a.c.c.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in authenticate! Should never happen", new Object[0]);
                    return;
                } catch (SecurityException e) {
                    com.tencent.d.a.c.c.e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in authenticate! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
                    return;
                }
            }
            cVar = null;
            anonymousClass1 = /* anonymous class already generated */;
            if (b.b(context, "android.permission.USE_FINGERPRINT") == 0) {
                ik = b.ik(context);
                if (ik == null) {
                    com.tencent.d.a.c.c.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in authenticate! Should never happen", new Object[0]);
                    return;
                }
                if (cVar != null) {
                    if (cVar.AkY != null) {
                        cryptoObject = new CryptoObject(cVar.AkY);
                    } else if (cVar.AkX != null) {
                        cryptoObject = new CryptoObject(cVar.AkX);
                    } else if (cVar.AkZ != null) {
                        cryptoObject = new CryptoObject(cVar.AkZ);
                    }
                    ik.authenticate(cryptoObject, cancellationSignal, 0, new com.tencent.d.a.a.b.AnonymousClass1(anonymousClass1), null);
                    return;
                }
                cryptoObject = null;
                ik.authenticate(cryptoObject, cancellationSignal, 0, new com.tencent.d.a.a.b.AnonymousClass1(anonymousClass1), null);
                return;
            }
            com.tencent.d.a.c.c.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: authenticate", new Object[0]);
        }

        static void a(com.tencent.d.a.a.b.a aVar) {
            com.tencent.d.a.c.c.w("Soter.FingerprintManagerCompat", "soter: too many fail fingerprint callback. inform it.", new Object[0]);
            aVar.onAuthenticationError(10308, "Too many failed times");
        }
    }

    private static class f implements e {
        public final boolean ii(Context context) {
            return false;
        }

        public final boolean ij(Context context) {
            return false;
        }

        public final void a(Context context, d dVar, int i, CancellationSignal cancellationSignal, b bVar, Handler handler) {
        }
    }

    public static a ih(Context context) {
        return new a(context);
    }

    private a(Context context) {
        this.mContext = context;
    }

    static {
        if (com.tencent.d.a.a.cGB()) {
            AkT = new a();
        } else {
            AkT = new f();
        }
    }

    public final boolean hasEnrolledFingerprints() {
        return AkT.ii(this.mContext);
    }

    public final boolean isHardwareDetected() {
        return AkT.ij(this.mContext);
    }

    public final void a(d dVar, CancellationSignal cancellationSignal, b bVar) {
        AkT.a(this.mContext, dVar, 0, cancellationSignal, bVar, null);
    }
}
