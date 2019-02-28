package com.tenpay.ndk;

import android.content.Context;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import java.io.File;
import java.security.MessageDigest;

public class CertUtil {
    public static final String TAG = CertUtil.class.getSimpleName();
    private static CertUtil instance = null;
    private String cert_dir;
    private String cert_id = null;
    private byte[] certid_buf = null;
    private byte[] cipher_buf = null;
    private byte[] csr_buf = null;
    private String deskey = null;
    private String iccid = null;
    private String imei = null;
    private String imsi = null;
    private String login_ip = null;
    private Context mContext = null;
    private String mac = null;
    private String plain_buf = null;
    private byte[] plain_buf2 = null;
    private String priv_dir;
    private String publ_dir;
    private String qq_id = null;
    private byte[] sig_buf = null;
    private String sig_raw_buf = null;
    private String sm4Key = null;
    private String softid = null;
    private String svr_cert = null;
    private String token = null;
    private byte[] token_buf = null;
    private String token_dir;
    private int token_len = 0;
    private int useSM4 = 0;

    private native boolean encrypt();

    private native boolean genCertApplyCsr();

    private native boolean genCertApplyCsrNew(int i);

    private native boolean genQrcode();

    private native boolean getCertid();

    private native boolean getToken();

    private native int getTokenCount();

    private native boolean importCert();

    private native boolean isCertExist();

    private native boolean setToken();

    private native boolean usrSig();

    public native int getLastError();

    private CertUtil() {
    }

    public static CertUtil getInstance() {
        if (instance == null) {
            synchronized (CertUtil.class) {
                instance = new CertUtil();
            }
        }
        return instance;
    }

    public void init(Context context) {
        this.mContext = context.getApplicationContext();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        try {
            this.imsi = telephonyManager.getSubscriberId();
            this.iccid = telephonyManager.getSimSerialNumber();
            this.imei = telephonyManager.getDeviceId();
            this.softid = System.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
        }
        this.deskey = this.imei;
    }

    private String getCertDir() {
        return this.mContext.getFilesDir().getParentFile().getAbsolutePath() + "/cert";
    }

    private void setAndCheckDir(String str) {
        String certDir = getCertDir();
        String str2 = certDir + "/" + hexdigest(str + this.imei);
        this.cert_dir = str2 + "/cert";
        this.priv_dir = str2 + "/priv";
        this.publ_dir = str2 + "/publ";
        this.token_dir = str2 + "/auth";
        checkDir(certDir);
        checkDir(this.token_dir);
    }

    private void setDir(String str) {
        String str2 = getCertDir() + "/" + hexdigest(str + this.imei);
        this.cert_dir = str2 + "/cert";
        this.priv_dir = str2 + "/priv";
        this.publ_dir = str2 + "/publ";
        this.token_dir = str2 + "/auth";
    }

    private void checkDir(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        } else if (!file.isDirectory()) {
            file.delete();
            file.mkdirs();
        }
    }

    private boolean create_dir(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = new java.io.File;	 Catch:{ Exception -> 0x0014 }
        r0.<init>(r3);	 Catch:{ Exception -> 0x0014 }
        r1 = r0.exists();	 Catch:{ Exception -> 0x0014 }
        if (r1 != 0) goto L_0x0012;	 Catch:{ Exception -> 0x0014 }
    L_0x000b:
        r0 = r0.mkdirs();	 Catch:{ Exception -> 0x0014 }
        if (r0 != 0) goto L_0x0011;
    L_0x0011:
        return r0;
    L_0x0012:
        r0 = 1;
        goto L_0x0011;
    L_0x0014:
        r0 = move-exception;
        r0 = 0;
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tenpay.ndk.CertUtil.create_dir(java.lang.String):boolean");
    }

    private boolean del_all_files(String str) {
        int i = 0;
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        String[] list = file.list();
        boolean z = false;
        while (i < list.length) {
            File file2;
            if (str.endsWith(File.separator)) {
                file2 = new File(str + list[i]);
            } else {
                file2 = new File(str + File.separator + list[i]);
            }
            if (file2.isFile()) {
                file2.delete();
            } else if (file2.isDirectory()) {
                del_all_files(str + File.separator + list[i]);
                del_dir(str + File.separator + list[i], true);
                z = true;
            }
            i++;
        }
        return z;
    }

    private void del_dir(String str, boolean z) {
        try {
            del_all_files(str);
            if (z) {
                new File(str.toString()).delete();
            }
        } catch (Exception e) {
        }
    }

    private boolean isNotEmptyDir(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory() && file.listFiles() != null) {
            return true;
        }
        return false;
    }

    private boolean isValidDir(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        return false;
    }

    private String hexdigest(String str) {
        int i = 0;
        if (str == null) {
            return "";
        }
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            char[] cArr2 = new char[32];
            int i2 = 0;
            while (i < 16) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
                i++;
            }
            return new String(cArr2);
        } catch (Exception e) {
            return null;
        }
    }

    private boolean isNullOrEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    public synchronized String getCertApplyCSR(String str) {
        String str2 = null;
        synchronized (this) {
            String str3;
            this.qq_id = str;
            this.csr_buf = null;
            if (!genCertApplyCsr() || this.csr_buf == null) {
                str3 = null;
            } else {
                try {
                    str3 = new String(this.csr_buf, "ASCII");
                } catch (Exception e) {
                }
            }
            str2 = str3;
        }
        return str2;
    }

    public synchronized String getCertApplyCSR(String str, int i) {
        String str2 = null;
        synchronized (this) {
            String str3;
            this.qq_id = str;
            this.csr_buf = null;
            if (!genCertApplyCsrNew(i) || this.csr_buf == null) {
                str3 = null;
            } else {
                try {
                    str3 = new String(this.csr_buf, "ASCII");
                } catch (Exception e) {
                }
            }
            str2 = str3;
        }
        return str2;
    }

    public synchronized boolean importCert(String str, String str2) {
        boolean z;
        if (str2.length() <= 0) {
            z = false;
        } else {
            try {
                this.svr_cert = new String(str2.getBytes(), "ASCII");
            } catch (Exception e) {
            }
            clearCert(str);
            setAndCheckDir(str);
            create_dir(this.cert_dir);
            create_dir(this.priv_dir);
            create_dir(this.publ_dir);
            z = importCert();
        }
        return z;
    }

    public synchronized boolean isCertExist(String str) {
        boolean z = false;
        synchronized (this) {
            if (!isNullOrEmpty(str)) {
                setDir(str);
                if (isNotEmptyDir(this.cert_dir) && isNotEmptyDir(this.publ_dir) && isNotEmptyDir(this.priv_dir)) {
                    this.cert_id = str;
                    z = isCertExist();
                }
            }
        }
        return z;
    }

    public synchronized void clearAllCert() {
        del_dir(getCertDir(), true);
    }

    public synchronized void clearCert(String str) {
        del_dir(getCertDir() + "/" + hexdigest(str + this.imei), true);
    }

    public synchronized String encrypt(String str, String str2) {
        String str3 = null;
        synchronized (this) {
            if (!(isNullOrEmpty(str) || isNullOrEmpty(str2))) {
                setAndCheckDir(str);
                if (isNotEmptyDir(this.cert_dir) && isNotEmptyDir(this.publ_dir) && isNotEmptyDir(this.priv_dir)) {
                    String str4;
                    this.cert_id = str;
                    this.plain_buf = str2;
                    this.cipher_buf = null;
                    if (!encrypt() || this.cipher_buf == null) {
                        str4 = null;
                    } else {
                        try {
                            str4 = new String(this.cipher_buf, "UTF-8");
                        } catch (Exception e) {
                        }
                    }
                    str3 = str4;
                }
            }
        }
        return str3;
    }

    public synchronized String genUserSig(String str, String str2) {
        String str3 = null;
        synchronized (this) {
            if (!(isNullOrEmpty(str) || isNullOrEmpty(str2))) {
                setAndCheckDir(str);
                if (isNotEmptyDir(this.cert_dir) && isNotEmptyDir(this.publ_dir) && isNotEmptyDir(this.priv_dir) && str != null && str2 != null && str.length() > 0 && str2.length() > 0) {
                    String str4;
                    this.cert_id = str;
                    this.sig_raw_buf = str2;
                    this.sig_buf = null;
                    if (!usrSig() || this.sig_buf == null) {
                        str4 = null;
                    } else {
                        try {
                            str4 = new String(this.sig_buf, "UTF-8");
                        } catch (Exception e) {
                        }
                    }
                    str3 = str4;
                }
            }
        }
        return str3;
    }

    public synchronized byte[] genQrcode(String str, byte[] bArr, String str2) {
        byte[] bArr2 = null;
        synchronized (this) {
            if (!(isNullOrEmpty(str) || isNullOrEmpty(str2) || bArr == null || bArr.length == 0)) {
                setAndCheckDir(str);
                if (isNotEmptyDir(this.cert_dir) && isNotEmptyDir(this.publ_dir) && isNotEmptyDir(this.priv_dir)) {
                    this.cert_id = str;
                    this.plain_buf2 = bArr;
                    this.cipher_buf = null;
                    this.token = str2;
                    if (genQrcode() && this.cipher_buf != null) {
                        try {
                            bArr2 = this.cipher_buf;
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
        return bArr2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean setTokens(java.lang.String r4, java.lang.String r5, boolean r6, java.lang.String r7) {
        /*
        r3 = this;
        r0 = 0;
        monitor-enter(r3);
        r1 = r3.isNullOrEmpty(r4);	 Catch:{ all -> 0x0047 }
        if (r1 != 0) goto L_0x000e;
    L_0x0008:
        r1 = r3.isNullOrEmpty(r5);	 Catch:{ all -> 0x0047 }
        if (r1 == 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r3);
        return r0;
    L_0x0010:
        if (r6 == 0) goto L_0x001c;
    L_0x0012:
        if (r7 == 0) goto L_0x001c;
    L_0x0014:
        r1 = r7.length();	 Catch:{ all -> 0x0047 }
        r2 = 16;
        if (r1 != r2) goto L_0x000e;
    L_0x001c:
        r3.setAndCheckDir(r4);	 Catch:{ all -> 0x0047 }
        r1 = r3.cert_dir;	 Catch:{ all -> 0x0047 }
        r1 = r3.isValidDir(r1);	 Catch:{ all -> 0x0047 }
        if (r1 == 0) goto L_0x000e;
    L_0x0027:
        r1 = r3.token_dir;	 Catch:{ all -> 0x0047 }
        r1 = r3.isValidDir(r1);	 Catch:{ all -> 0x0047 }
        if (r1 == 0) goto L_0x000e;
    L_0x002f:
        if (r6 == 0) goto L_0x0032;
    L_0x0031:
        r0 = 1;
    L_0x0032:
        r3.useSM4 = r0;	 Catch:{ all -> 0x0047 }
        r3.sm4Key = r7;	 Catch:{ all -> 0x0047 }
        r3.cert_id = r4;	 Catch:{ all -> 0x0047 }
        r3.token = r5;	 Catch:{ all -> 0x0047 }
        r0 = r3.token;	 Catch:{ all -> 0x0047 }
        r0 = r0.length();	 Catch:{ all -> 0x0047 }
        r3.token_len = r0;	 Catch:{ all -> 0x0047 }
        r0 = r3.setToken();	 Catch:{ all -> 0x0047 }
        goto L_0x000e;
    L_0x0047:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tenpay.ndk.CertUtil.setTokens(java.lang.String, java.lang.String, boolean, java.lang.String):boolean");
    }

    public synchronized String getToken(String str) {
        String str2 = null;
        synchronized (this) {
            if (!isNullOrEmpty(str)) {
                setAndCheckDir(str);
                if (isNotEmptyDir(this.token_dir)) {
                    String str3;
                    this.cert_id = str;
                    if (!getToken() || this.token_buf == null) {
                        str3 = null;
                    } else {
                        try {
                            str3 = new String(this.token_buf, "UTF-8");
                        } catch (Exception e) {
                        }
                    }
                    str2 = str3;
                }
            }
        }
        return str2;
    }

    public synchronized void clearToken(String str) {
        if (!isNullOrEmpty(str)) {
            setDir(str);
            del_dir(this.token_dir, true);
        }
    }

    public synchronized int getTokenCount(String str) {
        int i;
        if (isNullOrEmpty(str)) {
            i = 0;
        } else {
            setDir(str);
            this.cert_id = str;
            i = getTokenCount();
        }
        return i;
    }
}
