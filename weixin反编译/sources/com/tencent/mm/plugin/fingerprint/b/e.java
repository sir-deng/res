package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class e {
    private static boolean mET = false;

    public static String getUserId() {
        return ac.VF(ac.VF(com.tencent.mm.wallet_core.ui.e.getUsername()) + ac.VF(q.yM()));
    }

    public static String aKX() {
        return h.bDC();
    }

    public static void aKY() {
        g.Dr();
        g.Dq().Db().a(a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_BOOLEAN_SYNC, Boolean.valueOf(true));
    }

    public static boolean aKZ() {
        g.Dr();
        Object obj = g.Dq().Db().get(a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_BOOLEAN_SYNC, Boolean.valueOf(false));
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static void aLa() {
        g.Dr();
        g.Dq().Db().a(a.USERINFO_FINGER_PRINT_SHOW_OPEN_HWFPMANAGER_BOOLEAN_SYNC, Boolean.valueOf(true));
    }

    public static void fn(boolean z) {
        g.Dr();
        g.Dq().Db().a(a.USERINFO_FINGER_PRINT_IS_OPEN_BOOLEAN_SYNC, Boolean.valueOf(z));
    }

    public static boolean aLb() {
        g.Dr();
        Object obj = g.Dq().Db().get(a.USERINFO_FINGER_PRINT_IS_OPEN_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static void fo(boolean z) {
        g.Dr();
        g.Dq().Db().a(a.USERINFO_FINGER_PRINT_IS_SO_LOAD_SUCCESS_BOOLEAN_SYNC, Boolean.valueOf(z));
    }

    public static boolean aLc() {
        g.Dr();
        Object obj = g.Dq().Db().get(a.USERINFO_FINGER_PRINT_IS_SO_LOAD_SUCCESS_BOOLEAN_SYNC, Boolean.valueOf(false));
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static void fp(boolean z) {
        mET = z;
    }

    public static boolean aLd() {
        return mET;
    }

    public static boolean aKP() {
        return c.aKG() && aLc() && mET;
    }

    public static boolean aLe() {
        x.i("MicroMsg.FingerPrintUtil", "isShowFPOpenGuide");
        if (aLb()) {
            x.e("MicroMsg.FingerPrintUtil", "the fingerprint is open ready");
            return false;
        } else if (!c.aKG()) {
            x.e("MicroMsg.FingerPrintUtil", "device is not support");
            return false;
        } else if (o.bMc().bMv() || o.bMc().bMz()) {
            x.e("MicroMsg.FingerPrintUtil", "user had not reg wxpay");
            return false;
        } else if (o.bMc().bMC().bMr()) {
            com.tencent.mm.plugin.fingerprint.a.aKz();
            com.tencent.mm.plugin.fingerprint.a.aKA();
            if (!c.aKI() || aKZ()) {
                return false;
            }
            x.i("MicroMsg.FingerPrintUtil", "will showOpenFingerPrintPayGuide()");
            return true;
        } else {
            x.e("MicroMsg.FingerPrintUtil", "isSupportTouchPay is false");
            return false;
        }
    }

    public static boolean aLf() {
        x.i("MicroMsg.FingerPrintUtil", "isShowFPSettingGuide");
        if (aLb()) {
            x.e("MicroMsg.FingerPrintUtil", "the fingerprint is open ready");
            return false;
        } else if (!c.aKG()) {
            x.e("MicroMsg.FingerPrintUtil", "device is not support");
            return false;
        } else if (o.bMc().bMv() || o.bMc().bMz()) {
            x.e("MicroMsg.FingerPrintUtil", "user had not reg wxpay");
            return false;
        } else if (o.bMc().bMC().bMr()) {
            c cVar = new c();
            if (!c.aKI()) {
                boolean booleanValue;
                g.Dr();
                Object obj = g.Dq().Db().get(a.USERINFO_FINGER_PRINT_SHOW_OPEN_HWFPMANAGER_BOOLEAN_SYNC, Boolean.valueOf(false));
                if (obj != null) {
                    booleanValue = ((Boolean) obj).booleanValue();
                } else {
                    booleanValue = false;
                }
                if (!booleanValue) {
                    x.i("MicroMsg.FingerPrintUtil", "will call showSetFingerPrintGuide()");
                    return true;
                }
            }
            return false;
        } else {
            x.e("MicroMsg.FingerPrintUtil", "isSupportTouchPay is false");
            return false;
        }
    }

    public static final String cF(Context context) {
        return context.getApplicationContext().getFilesDir().getAbsolutePath() + "/b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec";
    }

    public static int cG(Context context) {
        CharSequence i;
        InputStream open;
        Throwable e;
        Throwable th;
        int i2;
        InputStream open2;
        FileOutputStream fileOutputStream;
        byte[] bArr;
        int read;
        FileOutputStream fileOutputStream2 = null;
        String cF = cF(context);
        File file = new File(cF);
        if (file.exists()) {
            i = com.tencent.mm.a.g.i(file);
            CharSequence charSequence = "";
            try {
                open = context.getAssets().open("b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec");
                if (open != null) {
                    try {
                        charSequence = com.tencent.mm.a.g.a(open, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    } catch (IOException e2) {
                        e = e2;
                    }
                }
                if (open != null) {
                    try {
                        open.close();
                    } catch (Throwable e3) {
                        x.printErrStackTrace("MicroMsg.FingerPrintUtil", e3, "", new Object[0]);
                    }
                }
            } catch (Throwable e4) {
                e3 = e4;
                open = null;
            } catch (Throwable th2) {
                th = th2;
                open = null;
                if (open != null) {
                    try {
                        open.close();
                    } catch (Throwable e42) {
                        x.printErrStackTrace("MicroMsg.FingerPrintUtil", e42, "", new Object[0]);
                    }
                }
                throw th;
            }
            if (TextUtils.isEmpty(i) && !TextUtils.isEmpty(charSequence) && i.equals(charSequence)) {
                i2 = 0;
            } else if (TextUtils.isEmpty(i) && TextUtils.isEmpty(charSequence)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
        } else {
            i2 = 1;
            open = null;
        }
        if (i2 != 0) {
            return 0;
        }
        try {
            open2 = context.getAssets().open("b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec");
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        read = open2.read(bArr);
                        if (read != -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    if (open2 != null) {
                        try {
                            open2.close();
                        } catch (Throwable th3) {
                            x.printErrStackTrace("MicroMsg.FingerPrintUtil", th3, "", new Object[0]);
                            x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + th3.getMessage());
                        }
                    }
                    try {
                        fileOutputStream.close();
                        i2 = 0;
                    } catch (Throwable th32) {
                        x.printErrStackTrace("MicroMsg.FingerPrintUtil", th32, "", new Object[0]);
                        x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + th32.getMessage());
                        i2 = 0;
                    }
                } catch (Exception e5) {
                    th32 = e5;
                    fileOutputStream2 = fileOutputStream;
                    open = open2;
                    try {
                        x.printErrStackTrace("MicroMsg.FingerPrintUtil", th32, "", new Object[0]);
                        x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets Exception " + th32.getMessage());
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable th322) {
                                x.printErrStackTrace("MicroMsg.FingerPrintUtil", th322, "", new Object[0]);
                                x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + th322.getMessage());
                            }
                        }
                        if (fileOutputStream2 == null) {
                            i2 = -1;
                        } else {
                            try {
                                fileOutputStream2.close();
                                i2 = -1;
                            } catch (Throwable th3222) {
                                x.printErrStackTrace("MicroMsg.FingerPrintUtil", th3222, "", new Object[0]);
                                x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + th3222.getMessage());
                                i2 = -1;
                            }
                        }
                        if (Runtime.getRuntime().exec("chmod 777 " + cF).waitFor() != 0) {
                            x.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                            return i2;
                        }
                        x.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                        return i2;
                    } catch (Throwable th4) {
                        th3222 = th4;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable e422) {
                                x.printErrStackTrace("MicroMsg.FingerPrintUtil", e422, "", new Object[0]);
                                x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + e422.getMessage());
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable e4222) {
                                x.printErrStackTrace("MicroMsg.FingerPrintUtil", e4222, "", new Object[0]);
                                x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + e4222.getMessage());
                            }
                        }
                        throw th3222;
                    }
                } catch (Throwable th5) {
                    th3222 = th5;
                    fileOutputStream2 = fileOutputStream;
                    open = open2;
                    if (open != null) {
                        open.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th3222;
                }
            } catch (Exception e6) {
                th3222 = e6;
                open = open2;
                x.printErrStackTrace("MicroMsg.FingerPrintUtil", th3222, "", new Object[0]);
                x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets Exception " + th3222.getMessage());
                if (open != null) {
                    open.close();
                }
                if (fileOutputStream2 == null) {
                    fileOutputStream2.close();
                    i2 = -1;
                } else {
                    i2 = -1;
                }
                if (Runtime.getRuntime().exec("chmod 777 " + cF).waitFor() != 0) {
                    x.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                    return i2;
                }
                x.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                return i2;
            } catch (Throwable th6) {
                th3222 = th6;
                open = open2;
                if (open != null) {
                    open.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th3222;
            }
        } catch (Exception e7) {
            th3222 = e7;
        }
        try {
            if (Runtime.getRuntime().exec("chmod 777 " + cF).waitFor() != 0) {
                x.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                return i2;
            }
            x.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
            return i2;
        } catch (Exception e8) {
            x.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file Exception " + e8.getMessage());
            return i2;
        }
        try {
            x.printErrStackTrace("MicroMsg.FingerPrintUtil", e3, "", new Object[0]);
            if (open != null) {
                try {
                    open.close();
                } catch (Throwable e32) {
                    x.printErrStackTrace("MicroMsg.FingerPrintUtil", e32, "", new Object[0]);
                }
            }
            if (TextUtils.isEmpty(i)) {
            }
            if (TextUtils.isEmpty(i)) {
            }
            i2 = 1;
            if (i2 != 0) {
                return 0;
            }
            open2 = context.getAssets().open("b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec");
            fileOutputStream = new FileOutputStream(file);
            bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            while (true) {
                read = open2.read(bArr);
                if (read != -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            if (open2 != null) {
                open2.close();
            }
            fileOutputStream.close();
            i2 = 0;
            if (Runtime.getRuntime().exec("chmod 777 " + cF).waitFor() != 0) {
                x.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                return i2;
            }
            x.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
            return i2;
        } catch (Throwable th7) {
            th3222 = th7;
            if (open != null) {
                open.close();
            }
            throw th3222;
        }
    }
}
