package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.tencent.wcdb.FileUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Locale;

public final class a extends o {
    public static boolean aEQ;
    private com.google.android.gms.a.a.a.a aER;
    private final j aES;
    private String aET;
    private boolean aEU = false;
    private Object aEV = new Object();

    a(q qVar) {
        super(qVar);
        this.aES = new j(qVar.aFD);
    }

    private boolean a(com.google.android.gms.a.a.a.a aVar, com.google.android.gms.a.a.a.a aVar2) {
        String str = null;
        String str2 = aVar2 == null ? null : aVar2.aEq;
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        String nr = this.aFo.mY().nr();
        synchronized (this.aEV) {
            boolean ap;
            if (!this.aEU) {
                this.aET = ml();
                this.aEU = true;
            } else if (TextUtils.isEmpty(this.aET)) {
                if (aVar != null) {
                    str = aVar.aEq;
                }
                if (str == null) {
                    ap = ap(str2 + nr);
                    return ap;
                }
                this.aET = ao(str + nr);
            }
            Object ao = ao(str2 + nr);
            if (TextUtils.isEmpty(ao)) {
                return false;
            } else if (ao.equals(this.aET)) {
                return true;
            } else {
                if (TextUtils.isEmpty(this.aET)) {
                    str = nr;
                } else {
                    au("Resetting the client id because Advertising Id changed.");
                    str = this.aFo.mY().ns();
                    c("New client Id", str);
                }
                ap = ap(str2 + str);
                return ap;
            }
        }
    }

    private static String ao(String str) {
        if (k.as("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, k.as("MD5").digest(str.getBytes()))});
    }

    private boolean ap(String str) {
        try {
            String ao = ao(str);
            au("Storing hashed adid.");
            FileOutputStream openFileOutput = this.aFo.mContext.openFileOutput("gaClientIdData", 0);
            openFileOutput.write(ao.getBytes());
            openFileOutput.close();
            this.aET = ao;
            return true;
        } catch (IOException e) {
            f("Error creating hash file", e);
            return false;
        }
    }

    private synchronized com.google.android.gms.a.a.a.a mj() {
        if (this.aES.V(1000)) {
            this.aES.start();
            com.google.android.gms.a.a.a.a mk = mk();
            if (a(this.aER, mk)) {
                this.aER = mk;
            } else {
                ay("Failed to reset client id on adid change. Not using adid");
                this.aER = new com.google.android.gms.a.a.a.a("", false);
            }
        }
        return this.aER;
    }

    private com.google.android.gms.a.a.a.a mk() {
        com.google.android.gms.a.a.a.a aVar = null;
        try {
            return com.google.android.gms.a.a.a.x(this.aFo.mContext);
        } catch (IllegalStateException e) {
            ax("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
            return aVar;
        } catch (Throwable th) {
            if (aEQ) {
                return aVar;
            }
            aEQ = true;
            e("Error getting advertiser id", th);
            return aVar;
        }
    }

    private String ml() {
        Object e;
        String str = null;
        try {
            FileInputStream openFileInput = this.aFo.mContext.openFileInput("gaClientIdData");
            byte[] bArr = new byte[FileUtils.S_IWUSR];
            int read = openFileInput.read(bArr, 0, FileUtils.S_IWUSR);
            if (openFileInput.available() > 0) {
                ax("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                this.aFo.mContext.deleteFile("gaClientIdData");
                return null;
            } else if (read <= 0) {
                au("Hash file is empty.");
                openFileInput.close();
                return null;
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    return str2;
                } catch (FileNotFoundException e2) {
                    return str2;
                } catch (IOException e3) {
                    IOException iOException = e3;
                    str = str2;
                    IOException e4 = iOException;
                    e("Error reading Hash file, deleting it", e4);
                    this.aFo.mContext.deleteFile("gaClientIdData");
                    return str;
                }
            }
        } catch (FileNotFoundException e5) {
            return null;
        } catch (IOException e6) {
            e4 = e6;
            e("Error reading Hash file, deleting it", e4);
            this.aFo.mContext.deleteFile("gaClientIdData");
            return str;
        }
    }

    protected final void mg() {
    }

    public final boolean mh() {
        mR();
        com.google.android.gms.a.a.a.a mj = mj();
        return (mj == null || mj.aEr) ? false : true;
    }

    public final String mi() {
        mR();
        com.google.android.gms.a.a.a.a mj = mj();
        CharSequence charSequence = mj != null ? mj.aEq : null;
        return TextUtils.isEmpty(charSequence) ? null : charSequence;
    }
}
