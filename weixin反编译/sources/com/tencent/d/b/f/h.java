package com.tencent.d.b.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.d.a.a.a.d;
import com.tencent.d.a.c.i;
import com.tencent.d.b.c.b;
import com.tencent.d.b.e.c;
import com.tencent.d.b.e.f;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.security.Signature;
import junit.framework.Assert;

public final class h extends d implements a {
    String AlV = null;
    private c AmD = null;
    f AmE = null;
    private WeakReference<Context> AmF = null;
    com.tencent.d.b.c.a AmG = null;
    b AmH = null;
    i AmI = null;
    private a AmJ = null;
    boolean AmK;
    boolean AmL;
    boolean AmM;
    private int itU = -1;
    String tnS = null;

    private class a extends com.tencent.d.a.a.a.b {
        Signature AmO;

        /* synthetic */ a(h hVar, Signature signature, byte b) {
            this(signature);
        }

        private a(Signature signature) {
            this.AmO = null;
            this.AmO = signature;
        }

        static String X(CharSequence charSequence) {
            return charSequence == null ? "unknown error" : charSequence.toString();
        }

        public final void onAuthenticationError(final int i, final CharSequence charSequence) {
            com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: on authentication fatal error: %d, %s", Integer.valueOf(i), charSequence);
            if (i != 10308) {
                g.cHd().y(new Runnable() {
                    public final void run() {
                        if (h.this.AmH != null) {
                            h.this.AmH.onAuthenticationError(i, charSequence);
                        }
                    }
                });
                h.this.b(new com.tencent.d.b.a.a(21, X(charSequence)));
            } else {
                h.this.b(new com.tencent.d.b.a.a(25, X(charSequence)));
            }
            cHf();
        }

        public final void onAuthenticationHelp(final int i, final CharSequence charSequence) {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: on authentication help. you do not need to cancel the authentication: %d, %s", Integer.valueOf(i), charSequence);
            g.cHd().y(new Runnable() {
                public final void run() {
                    if (h.this.AmH != null) {
                        h.this.AmH.onAuthenticationHelp(i, a.X(charSequence));
                    }
                }
            });
        }

        public final void bDE() {
            com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: authentication succeed. start sign and upload upload signature", new Object[0]);
            g.cHd().A(new Runnable() {
                public final void run() {
                    if (com.tencent.d.a.c.f.oN(h.this.tnS)) {
                        com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: challenge is null. should not happen here", new Object[0]);
                        a.this.onAuthenticationError(DownloadResult.CODE_UNDEFINED, "challenge is null");
                        return;
                    }
                    try {
                        a.this.AmO.update(h.this.tnS.getBytes(Charset.forName("UTF-8")));
                        h hVar = h.this;
                        try {
                            hVar.AmI = com.tencent.d.a.a.bP(a.this.AmO.sign());
                            if (hVar.AmE == null) {
                                com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: no upload wrapper, return directly", new Object[0]);
                                hVar.b(new com.tencent.d.b.a.a(hVar.AmI));
                            } else if (hVar.AmI == null) {
                                hVar.b(new com.tencent.d.b.a.a(22, "sign failed even after user authenticated the key."));
                            } else {
                                hVar.AmE.br(new com.tencent.d.b.e.f.a(hVar.AmI.signature, hVar.AmI.AlM, hVar.AmI.AlL));
                                hVar.AmE.a(new com.tencent.d.b.e.b<f.b>() {
                                    public final /* synthetic */ void cz(Object obj) {
                                        if (((f.b) obj).mkY) {
                                            com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: upload and verify succeed", new Object[0]);
                                            h.this.b(new com.tencent.d.b.a.a(h.this.AmI));
                                            return;
                                        }
                                        com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: upload or verify failed", new Object[0]);
                                        h.this.b(new com.tencent.d.b.a.a(23));
                                    }
                                });
                                hVar.AmE.execute();
                            }
                        } catch (Throwable e) {
                            com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: sign failed due to exception: %s", e.getMessage());
                            com.tencent.d.a.c.c.a("Soter.TaskAuthentication", e, "soter: sign failed due to exception");
                            hVar.b(new com.tencent.d.b.a.a(22, "sign failed even after user authenticated the key."));
                        }
                    } catch (Throwable e2) {
                        com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: exception in update", new Object[0]);
                        com.tencent.d.a.c.c.a("Soter.TaskAuthentication", e2, "soter: exception in update");
                        com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: remove the auth key: %s", h.this.AlV);
                        com.tencent.d.a.a.bt(h.this.AlV, false);
                        a.this.onAuthenticationError(DownloadResult.CODE_UNDEFINED, "update signature failed");
                    }
                }
            });
            g.cHd().y(new Runnable() {
                public final void run() {
                    if (h.this.AmH != null) {
                        h.this.AmH.aLj();
                    }
                }
            });
            cHf();
        }

        public final void onAuthenticationFailed() {
            super.onAuthenticationFailed();
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: authentication failed once", new Object[0]);
            g.cHd().y(new Runnable() {
                public final void run() {
                    if (h.this.AmH != null) {
                        h.this.AmH.onAuthenticationFailed();
                    }
                }
            });
            if (h.this.AmK) {
                com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: should compat lower android version logic.", new Object[0]);
                h.this.AmG.od(false);
                g.cHd().A(new Runnable() {
                    public final void run() {
                        h.this.AmG.cGU();
                    }
                });
                g.cHd().k(new Runnable() {
                    public final void run() {
                        h.this.a(a.this.AmO);
                    }
                }, 1000);
            }
        }

        public final void aLk() {
            com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: called onAuthenticationCancelled", new Object[0]);
            if (h.this.AmM) {
                com.tencent.d.a.c.c.v("Soter.TaskAuthentication", "soter: during ignore cancel period", new Object[0]);
                return;
            }
            super.aLk();
            g.cHd().y(new Runnable() {
                public final void run() {
                    if (h.this.AmH != null) {
                        h.this.AmH.aLk();
                    }
                }
            });
            h.this.b(new com.tencent.d.b.a.a(24, "user cancelled authentication"));
            cHf();
        }

        @SuppressLint({"NewApi"})
        private void cHf() {
            if (h.this.AmL) {
                h.this.AmG.od(false);
                h.this.AmM = true;
            }
        }
    }

    public h(b bVar) {
        boolean z = true;
        boolean z2 = VERSION.SDK_INT < 23 && Build.MANUFACTURER.equalsIgnoreCase("vivo");
        this.AmK = z2;
        if (VERSION.SDK_INT >= 23) {
            z = false;
        }
        this.AmL = z;
        this.AmM = false;
        if (bVar == null) {
            throw new IllegalArgumentException("param is null!");
        }
        this.itU = bVar.itU;
        this.AmD = bVar.Ami;
        this.AmE = bVar.Amj;
        this.AmF = new WeakReference(bVar.mContext);
        this.AmH = bVar.Amk;
        this.AmG = bVar.mFo;
        this.tnS = bVar.tnS;
    }

    @SuppressLint({"DefaultLocale", "NewApi"})
    final boolean cGZ() {
        if (!com.tencent.d.b.b.a.cGQ().isInit()) {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: not initialized yet", new Object[0]);
            b(new com.tencent.d.b.a.a(14));
            return true;
        } else if (com.tencent.d.b.b.a.cGQ().cGP()) {
            boolean z;
            if (VERSION.SDK_INT >= 16) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            this.AlV = (String) com.tencent.d.b.b.a.cGQ().cGS().get(this.itU, "");
            if (com.tencent.d.a.c.f.oN(this.AlV)) {
                com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
                b(new com.tencent.d.b.a.a(15, String.format("auth scene %d not initialized in map", new Object[]{Integer.valueOf(this.itU)})));
                return true;
            } else if (!com.tencent.d.a.a.cGF()) {
                com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: app secure key not exists. need re-generate", new Object[0]);
                b(new com.tencent.d.b.a.a(3));
                return true;
            } else if (!com.tencent.d.a.a.acd(this.AlV) || com.tencent.d.a.a.acf(this.AlV) == null) {
                com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: auth key %s not exists. need re-generate", this.AlV);
                b(new com.tencent.d.b.a.a(12, String.format("the auth key to scene %d not exists. it may because you haven't prepare it, or user removed them already in system settings. please prepare the key again", new Object[]{Integer.valueOf(this.itU)})));
                return true;
            } else if (!com.tencent.d.a.a.ace(this.AlV)) {
                com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: auth key %s has already expired, and we've already deleted them. need re-generate", this.AlV);
                b(new com.tencent.d.b.a.a(11, String.format("the auth key to scene %d has already been expired. in Android versions above 6.0, a key would be expired when user enrolls a new fingerprint. please prepare the key again", new Object[]{Integer.valueOf(this.itU)})));
                return true;
            } else if (this.AmD == null && com.tencent.d.a.c.f.oN(this.tnS)) {
                com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: challenge wrapper is null!", new Object[0]);
                b(new com.tencent.d.b.a.a(16, "neither get challenge wrapper nor challenge str is found in request parameter"));
                return true;
            } else {
                Context context = (Context) this.AmF.get();
                if (context == null) {
                    com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: context instance released in preExecute", new Object[0]);
                    b(new com.tencent.d.b.a.a(17));
                    return true;
                } else if (!com.tencent.d.a.a.a.ih(context).hasEnrolledFingerprints()) {
                    com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: user has not enrolled any fingerprint in system.", new Object[0]);
                    b(new com.tencent.d.b.a.a(18));
                    return true;
                } else if (com.tencent.d.a.a.ig(context)) {
                    com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: fingerprint sensor frozen", new Object[0]);
                    b(new com.tencent.d.b.a.a(25, "Too many failed times"));
                    return true;
                } else if (this.AmG == null) {
                    com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: did not pass cancellation obj. We suggest you pass one", new Object[0]);
                    this.AmG = new com.tencent.d.b.c.a();
                    return false;
                } else {
                    if (this.AmE == null) {
                        com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "hy: we strongly recommend you to check the final authentication data in server! Please make sure you upload and check later", new Object[0]);
                    }
                    return false;
                }
            }
        } else {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: not support soter", new Object[0]);
            b(new com.tencent.d.b.a.a(2));
            return true;
        }
    }

    final void cHa() {
        if (this.AmG != null) {
            this.AmG.od(true);
        }
    }

    final void execute() {
        if (com.tencent.d.a.c.f.oN(this.tnS)) {
            com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: not provide the challenge. we will do the job", new Object[0]);
            this.AmD.br(new com.tencent.d.b.e.c.a());
            this.AmD.a(new com.tencent.d.b.e.b<c.b>() {
                public final /* synthetic */ void cz(Object obj) {
                    c.b bVar = (c.b) obj;
                    if (com.tencent.d.a.c.f.oN(bVar.mFv)) {
                        com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: get challenge failed", new Object[0]);
                        h.this.b(new com.tencent.d.b.a.a(19));
                        return;
                    }
                    h.this.tnS = bVar.mFv;
                    h.this.cHe();
                }
            });
            this.AmD.execute();
            return;
        }
        com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: already provided the challenge. directly authenticate", new Object[0]);
        cHe();
    }

    final void cHe() {
        Signature acg = com.tencent.d.a.a.acg(this.AlV);
        if (acg == null) {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: error occurred when init sign", new Object[0]);
            b(new com.tencent.d.b.a.a(13));
            return;
        }
        this.AmJ = new a(this, acg, (byte) 0);
        a(acg);
        g.cHd().y(new Runnable() {
            public final void run() {
                if (h.this.AmH != null) {
                    h.this.AmH.aLi();
                }
            }
        });
    }

    @SuppressLint({"NewApi"})
    final void a(Signature signature) {
        if (this.AlZ) {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: already finished. can not authenticate", new Object[0]);
            return;
        }
        Context context = (Context) this.AmF.get();
        if (context == null) {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: context instance released in startAuthenticate", new Object[0]);
            b(new com.tencent.d.b.a.a(17));
            return;
        }
        try {
            com.tencent.d.a.c.c.v("Soter.TaskAuthentication", "soter: performing start", new Object[0]);
            com.tencent.d.a.a.a.ih(context).a(new d(signature), this.AmG != null ? this.AmG.AlR : null, this.AmJ);
        } catch (Throwable e) {
            String message = e.getMessage();
            com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: caused exception when authenticating: %s", message);
            com.tencent.d.a.c.c.a("Soter.TaskAuthentication", e, "soter: caused exception when authenticating");
            b(new com.tencent.d.b.a.a(20, String.format("start authentication failed due to %s", new Object[]{message})));
        }
    }

    public final void cGY() {
        com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: called from cancellation signal", new Object[0]);
        if (this.AmJ != null) {
            this.AmJ.aLk();
        }
    }

    public final boolean isCancelled() {
        return this.AmM;
    }
}
