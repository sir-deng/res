package com.tencent.c.d.b;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class d {

    public static class a {
        public int AcK;
        public String AcL;
        public String name = "";
        public int pid;
        public int uid;

        a(int i, int i2, String str, int i3, String str2) {
            this.pid = i;
            this.AcK = i2;
            this.name = str;
            this.uid = i3;
            this.AcL = str2;
        }

        public final String toString() {
            return "PID=" + this.pid + " PPID=" + this.AcK + " NAME=" + this.name + " UID=" + this.uid + " CONTEXT=" + this.AcL;
        }
    }

    public static List<a> cEn() {
        List arrayList = new ArrayList();
        String[] list = new File("/proc").list();
        if (list != null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        char charAt = str.charAt(0);
                        if (charAt <= '9' && charAt >= '0') {
                            a Ih = Ih(Integer.parseInt(str));
                            if (Ih != null) {
                                arrayList.add(Ih);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        return arrayList;
    }

    private static String Ig(int i) {
        try {
            String str = "";
            byte[] dJ = a.dJ(String.format(Locale.ENGLISH, "/proc/%d/cmdline", new Object[]{Integer.valueOf(i)}), 100);
            if (dJ != null) {
                str = new String(dJ, 0, a(dJ, 0, 0));
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            dJ = a.dJ(String.format(Locale.ENGLISH, "/proc/%d/status", new Object[]{Integer.valueOf(i)}), 150);
            if (dJ == null) {
                return str;
            }
            int a = a(dJ, 7, 10);
            if (a == 0) {
                return "";
            }
            return new String(dJ, 6, a - 6);
        } catch (Throwable th) {
            return "";
        }
    }

    private static int a(byte[] bArr, int i, char c) {
        int i2 = i - 1;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= bArr.length) {
                return 0;
            }
            if (i3 == bArr.length || bArr[i3] == c) {
                return i3;
            }
            i2 = i3;
        }
    }

    private static a Ih(int i) {
        String Ig;
        String trim;
        int a;
        try {
            Ig = Ig(i);
            int i2;
            try {
                int parseInt;
                byte[] dJ = a.dJ(String.format(Locale.ENGLISH, "/proc/%d/status", new Object[]{Integer.valueOf(i)}), 150);
                if (dJ != null) {
                    a = a(dJ, 7, 10);
                    if (a != 0) {
                        a = a(dJ, a(dJ, a(dJ, a + 1, 10) + 1, 10) + 1, 10);
                        if (a != 0) {
                            i2 = a + 7;
                            int a2 = a(dJ, a + 1, 10);
                            if (a2 != 0) {
                                a = Integer.parseInt(new String(dJ, i2, a2 - i2));
                                try {
                                    i2 = a(dJ, a2 + 1, 10);
                                    if (i2 != 0) {
                                        i2 += 6;
                                        parseInt = Integer.parseInt(new String(dJ, i2, a(dJ, i2 + 1, 9) - i2));
                                    } else {
                                        parseInt = -1;
                                    }
                                    i2 = parseInt;
                                } catch (Exception e) {
                                    i2 = -1;
                                    trim = new String(a.abC(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
                                    if (Ig != null) {
                                    }
                                    return null;
                                }
                                trim = new String(a.abC(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
                                if (Ig != null || a == -1 || i2 == -1) {
                                    return null;
                                }
                                return new a(i, a, Ig, i2, trim);
                            }
                        }
                    }
                }
                parseInt = -1;
                a = -1;
                i2 = parseInt;
            } catch (Exception e2) {
                a = -1;
                i2 = -1;
                trim = new String(a.abC(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
                if (Ig != null) {
                }
                return null;
            }
        } catch (Exception e3) {
            a = -1;
            Ig = null;
        }
        try {
            trim = new String(a.abC(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
        } catch (Exception e4) {
            trim = null;
        }
        if (Ig != null) {
        }
        return null;
    }
}
