package com.tencent.mm.network;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class b {
    static a ibl;

    public interface a {
        e CR();
    }

    public static class b {
        public String host = null;
        public int ibm = 0;
        private ArrayList<String> ibn = new ArrayList();
        public String ibo;
        public boolean ibp = false;
        private boolean ibq = false;
        public String ip = "";
        URL url = null;

        public b(String str) {
            this.ibo = str;
            try {
                this.url = new URL(str);
                this.host = this.url.getHost();
                ArrayList arrayList = new ArrayList();
                String str2;
                if (b.ibl == null || b.ibl.CR() == null) {
                    String str3 = "MicroMsg.GprsSetting";
                    String str4 = "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]";
                    Object[] objArr = new Object[2];
                    if (b.ibl == null) {
                        str2 = "-1";
                    } else {
                        str2 = b.ibl.CR();
                    }
                    objArr[0] = str2;
                    objArr[1] = bi.chl();
                    x.e(str3, str4, objArr);
                    return;
                }
                this.ibm = b.ibl.CR().getHostByName(this.host, arrayList);
                x.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s", Integer.valueOf(this.ibm), this.host, str);
                if (arrayList.size() <= 0) {
                    this.ibm = 0;
                } else if (1 == this.ibm) {
                    str2 = (String) arrayList.get((int) (bi.Wy() % ((long) arrayList.size())));
                    this.ip = str2;
                    this.url = new URL(str.replaceFirst(this.host, str2));
                }
            } catch (Throwable e) {
                x.e("MicroMsg.GprsSetting", "exception:%s", bi.i(e));
            }
        }

        public b(String str, boolean z) {
            this.ibp = z;
            this.ibo = str;
            try {
                this.url = new URL(str);
                this.host = this.url.getHost();
                if (b.ibl == null || b.ibl.CR() == null) {
                    String str2;
                    String str3 = "MicroMsg.GprsSetting";
                    String str4 = "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]";
                    Object[] objArr = new Object[2];
                    if (b.ibl == null) {
                        str2 = "-1";
                    } else {
                        str2 = b.ibl.CR();
                    }
                    objArr[0] = str2;
                    objArr[1] = bi.chl();
                    x.e(str3, str4, objArr);
                    return;
                }
                this.ibm = b.ibl.CR().a(this.host, z, this.ibn);
                Random random = new Random();
                random.setSeed(bi.Wy());
                Collections.shuffle(this.ibn, random);
                x.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s ips:%s", Integer.valueOf(this.ibm), this.host, str, this.ibn);
                if (this.ibn.size() <= 0) {
                    this.ibm = 0;
                } else if (1 == this.ibm) {
                    this.ip = (String) this.ibn.remove(0);
                    this.url = new URL(str.replaceFirst(this.host, this.ip));
                }
            } catch (Throwable e) {
                x.e("MicroMsg.GprsSetting", "exception:%s", bi.i(e));
            }
        }
    }

    public static void a(a aVar) {
        x.i("MicroMsg.GprsSetting", "sethostimpl %b, [%s]", Boolean.valueOf(false), bi.chl());
        ibl = aVar;
    }

    public static int a(boolean z, List<String> list, String str) {
        int i = -1;
        if (ibl == null) {
            return i;
        }
        try {
            return ibl.CR().a(str, z, list);
        } catch (Throwable e) {
            x.e("MicroMsg.GprsSetting", "exception:%s", bi.i(e));
            return i;
        }
    }

    public static int a(String str, boolean z, List<String> list) {
        if (ibl == null || ibl.CR() == null) {
            return -1;
        }
        return ibl.CR().a(str, z, list);
    }

    public static void reportFailIp(String str) {
        if (ibl != null && ibl.CR() != null) {
            ibl.CR().reportFailIp(str);
        }
    }

    public static InputStream l(String str, int i, int i2) {
        u a = a(str, null);
        a.setConnectTimeout(i);
        a.setReadTimeout(i2);
        a.setRequestMethod("GET");
        if (a(a) != 0) {
            return null;
        }
        return a.getInputStream();
    }

    public static u a(String str, b bVar) {
        if (bVar == null) {
            bVar = new b(str);
        }
        x.i("MicroMsg.GprsSetting", "hy: url redirect host: %s, url: %s, ip: %s, dns_type: %d", bVar.host, bVar.url, bVar.ip, Integer.valueOf(bVar.ibm));
        u uVar = new u(bVar.url, bVar.ibm);
        uVar.icj = bVar.ip;
        if (1 == bVar.ibm) {
            uVar.setRequestProperty("Host", bVar.host);
            uVar.setRequestProperty("X-Online-Host", bVar.host);
        }
        return uVar;
    }

    public static int a(u uVar) {
        try {
            if (uVar.getResponseCode() != 200) {
                return -1;
            }
            return 0;
        } catch (Throwable e) {
            x.e("MicroMsg.GprsSetting", "exception:%s", bi.i(e));
            return -3;
        }
    }

    public static v ol(String str) {
        return new v(str);
    }
}
