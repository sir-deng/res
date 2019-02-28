package com.tencent.mm.sdk.e;

import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public final class a {
    private String filePath;
    private Properties xrP;

    public a(String str) {
        Exception e;
        Throwable th;
        this.xrP = null;
        this.filePath = null;
        this.xrP = new Properties();
        this.filePath = str;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                this.xrP.load(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    x.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", str, e2.getLocalizedMessage());
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    x.e("MicroMsg.ReadConfig", "Read File: %s Failed. [%s]", str, e.getLocalizedMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e22) {
                            x.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", str, e22.getLocalizedMessage());
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            x.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", str, e4.getLocalizedMessage());
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
            x.e("MicroMsg.ReadConfig", "Read File: %s Failed. [%s]", str, e.getLocalizedMessage());
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public final boolean fB(String str, String str2) {
        Exception e;
        Throwable th;
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(this.filePath);
            try {
                this.xrP.setProperty(str, str2);
                this.xrP.store(fileOutputStream, "");
                try {
                    fileOutputStream.close();
                    return true;
                } catch (IOException e2) {
                    x.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", this.filePath, e2.getLocalizedMessage());
                    return true;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    x.e("MicroMsg.ReadConfig", "Write File: %s Failed. [%s]", this.filePath, e.getLocalizedMessage());
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (IOException e22) {
                        x.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", this.filePath, e22.getLocalizedMessage());
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            x.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", this.filePath, e4.getLocalizedMessage());
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
            x.e("MicroMsg.ReadConfig", "Write File: %s Failed. [%s]", this.filePath, e.getLocalizedMessage());
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public final boolean am(String str, long j) {
        return fB(str, String.valueOf(j));
    }

    public final boolean da(String str, int i) {
        return fB(str, String.valueOf(i));
    }

    public final String getValue(String str) {
        if (this.xrP == null || !this.xrP.containsKey(str)) {
            return null;
        }
        return this.xrP.getProperty(str);
    }

    public final Long WG(String str) {
        Long l = null;
        String value = getValue(str);
        if (value == null) {
            return l;
        }
        try {
            return Long.valueOf(Long.parseLong(value));
        } catch (Exception e) {
            x.e("MicroMsg.ReadConfig", "getLongValue ParseLong : %s Failed. [%s]", value, e.getLocalizedMessage());
            return l;
        }
    }

    public final Integer WH(String str) {
        Integer num = null;
        String value = getValue(str);
        if (value == null) {
            return num;
        }
        try {
            return Integer.valueOf(Integer.parseInt(value));
        } catch (Exception e) {
            x.e("MicroMsg.ReadConfig", "getIntegerValue ParseInteger : %s Failed. [%s]", value, e.getLocalizedMessage());
            return num;
        }
    }

    public static String getValue(String str, String str2) {
        return new a(str).getValue(str2);
    }

    public static Long fC(String str, String str2) {
        return new a(str).WG(str2);
    }

    public static boolean ah(String str, String str2, String str3) {
        return new a(str).fB(str2, str3);
    }

    public static boolean h(String str, String str2, long j) {
        return new a(str).am(str2, j);
    }
}
