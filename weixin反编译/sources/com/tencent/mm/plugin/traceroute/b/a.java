package com.tencent.mm.plugin.traceroute.b;

import com.tencent.mm.a.q;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public final class a {
    public static String skU;
    public static c skV;
    private final String TAG = "MicroMsg.MMTraceRoute";
    private final int skW = 64;
    private boolean skX = false;
    f skY = new f();
    public Map<String, Set<Integer>> skZ = new HashMap();
    public e sla;
    public d slb;
    public c slc;
    public b sld;
    String userName;

    private class a implements Runnable {
        private String ip;
        private Set<Integer> sle;

        public a(String str, Set<Integer> set) {
            this.ip = str;
            this.sle = set;
        }

        public final void run() {
            Socket socket;
            Throwable e;
            a.this.a(this.ip, String.format("connect %s: ", new Object[]{this.ip}), Integer.valueOf(1));
            for (Integer num : this.sle) {
                a aVar = a.this;
                String str = this.ip;
                int intValue = num.intValue();
                try {
                    socket = new Socket();
                    try {
                        socket.setSoTimeout(5000);
                        long Wy = bi.Wy();
                        socket.connect(new InetSocketAddress(str, intValue));
                        long Wy2 = bi.Wy();
                        x.i("MicroMsg.MMTraceRoute", "connect success" + str + ":" + intValue);
                        aVar.a(str, String.format("port = %d, time = %dms ", new Object[]{Integer.valueOf(intValue), Long.valueOf(Wy2 - Wy)}), Integer.valueOf(1));
                        try {
                            socket.close();
                        } catch (Throwable e2) {
                            x.e("MicroMsg.MMTraceRoute", "close err: " + e2.getMessage());
                            x.printErrStackTrace("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                        }
                    } catch (UnknownHostException e3) {
                        e2 = e3;
                        try {
                            aVar.a(str, String.format("connect err; UnknownHostException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e2.toString()}), Integer.valueOf(1));
                            x.e("MicroMsg.MMTraceRoute", "connect err: " + e2.getMessage());
                            x.printErrStackTrace("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                            if (socket != null) {
                                try {
                                    socket.close();
                                } catch (Throwable e22) {
                                    x.e("MicroMsg.MMTraceRoute", "close err: " + e22.getMessage());
                                    x.printErrStackTrace("MicroMsg.MMTraceRoute", e22, "", new Object[0]);
                                }
                            }
                        } catch (Throwable th) {
                            e22 = th;
                        }
                    } catch (IOException e4) {
                        e22 = e4;
                        aVar.a(str, String.format("connect err; IOException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e22.toString()}), Integer.valueOf(1));
                        x.e("MicroMsg.MMTraceRoute", "connect err:" + e22.getMessage());
                        x.printErrStackTrace("MicroMsg.MMTraceRoute", e22, "", new Object[0]);
                        if (socket != null) {
                            try {
                                socket.close();
                            } catch (Throwable e222) {
                                x.e("MicroMsg.MMTraceRoute", "close err: " + e222.getMessage());
                                x.printErrStackTrace("MicroMsg.MMTraceRoute", e222, "", new Object[0]);
                            }
                        }
                    } catch (Exception e5) {
                        e222 = e5;
                        aVar.a(str, String.format("connect err; Exception: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e222.toString()}), Integer.valueOf(1));
                        x.e("MicroMsg.MMTraceRoute", "connect err:" + e222.toString());
                        x.printErrStackTrace("MicroMsg.MMTraceRoute", e222, "", new Object[0]);
                        if (socket != null) {
                            try {
                                socket.close();
                            } catch (Throwable e2222) {
                                x.e("MicroMsg.MMTraceRoute", "close err: " + e2222.getMessage());
                                x.printErrStackTrace("MicroMsg.MMTraceRoute", e2222, "", new Object[0]);
                            }
                        }
                    }
                } catch (UnknownHostException e6) {
                    e2222 = e6;
                    socket = null;
                    aVar.a(str, String.format("connect err; UnknownHostException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e2222.toString()}), Integer.valueOf(1));
                    x.e("MicroMsg.MMTraceRoute", "connect err: " + e2222.getMessage());
                    x.printErrStackTrace("MicroMsg.MMTraceRoute", e2222, "", new Object[0]);
                    if (socket != null) {
                        socket.close();
                    }
                } catch (IOException e7) {
                    e2222 = e7;
                    socket = null;
                    aVar.a(str, String.format("connect err; IOException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e2222.toString()}), Integer.valueOf(1));
                    x.e("MicroMsg.MMTraceRoute", "connect err:" + e2222.getMessage());
                    x.printErrStackTrace("MicroMsg.MMTraceRoute", e2222, "", new Object[0]);
                    if (socket != null) {
                        socket.close();
                    }
                } catch (Exception e8) {
                    e2222 = e8;
                    socket = null;
                    aVar.a(str, String.format("connect err; Exception: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e2222.toString()}), Integer.valueOf(1));
                    x.e("MicroMsg.MMTraceRoute", "connect err:" + e2222.toString());
                    x.printErrStackTrace("MicroMsg.MMTraceRoute", e2222, "", new Object[0]);
                    if (socket != null) {
                        socket.close();
                    }
                } catch (Throwable th2) {
                    e2222 = th2;
                    socket = null;
                }
            }
            a.this.a(this.ip, "\n", Integer.valueOf(1));
            return;
            if (socket != null) {
                try {
                    socket.close();
                } catch (Throwable e9) {
                    x.e("MicroMsg.MMTraceRoute", "close err: " + e9.getMessage());
                    x.printErrStackTrace("MicroMsg.MMTraceRoute", e9, "", new Object[0]);
                }
            }
            throw e2222;
            throw e2222;
        }
    }

    public interface c {
        void bGg();
    }

    public interface d {
        void bGh();
    }

    private class f extends ConcurrentHashMap<String, ConcurrentHashMap<Integer, StringBuilder>> {

        /* renamed from: com.tencent.mm.plugin.traceroute.b.a$f$1 */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ int slg;
            final /* synthetic */ String slh;
            final /* synthetic */ PByteArray sli;

            AnonymousClass1(int i, String str, PByteArray pByteArray) {
                this.slg = i;
                this.slh = str;
                this.sli = pByteArray;
            }

            public final void run() {
                String str = "http://" + ad.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com");
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str + "/cgi-bin/mmsupport-bin/stackreport?version=");
                stringBuffer.append(Integer.toHexString(com.tencent.mm.protocal.d.vHl));
                stringBuffer.append("&devicetype=");
                stringBuffer.append(com.tencent.mm.protocal.d.DEVICE_TYPE);
                stringBuffer.append("&filelength=");
                stringBuffer.append(this.slg);
                stringBuffer.append("&sum=");
                stringBuffer.append(this.slh);
                stringBuffer.append("&reporttype=");
                stringBuffer.append(4);
                if (!(a.this.userName == null || a.this.userName.equals(""))) {
                    stringBuffer.append("&username=");
                    stringBuffer.append(a.this.userName);
                }
                x.d("MicroMsg.MMTraceRoute", "traceroute report url:" + stringBuffer.toString());
                f.a(f.this, stringBuffer.toString(), this.sli.value);
            }
        }

        private f() {
        }

        /* synthetic */ f(a aVar, byte b) {
            this();
        }

        static /* synthetic */ void a(f fVar, String str, byte[] bArr) {
            int i = 3;
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                    HttpUriRequest httpPost = new HttpPost(str);
                    try {
                        HttpEntity byteArrayEntity = new ByteArrayEntity(bArr);
                        byteArrayEntity.setContentType("binary/octet-stream");
                        httpPost.setEntity(byteArrayEntity);
                        x.i("MicroMsg.MMTraceRoute", "http pose returnContent : " + bi.convertStreamToString(defaultHttpClient.execute(httpPost).getEntity().getContent()));
                        a aVar = a.this;
                        if (aVar.slc != null) {
                            aVar.slc.bGg();
                            return;
                        }
                        return;
                    } catch (Throwable e) {
                        x.e("MicroMsg.MMTraceRoute", "http post IllegalStateException: " + e.getMessage());
                        x.printErrStackTrace("MicroMsg.MMTraceRoute", e, "", new Object[0]);
                        i = i2;
                    } catch (Throwable e2) {
                        x.e("MicroMsg.MMTraceRoute", "http post IOException: " + e2.getMessage());
                        x.printErrStackTrace("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                        i = i2;
                    }
                } else {
                    a.a(a.this);
                    return;
                }
            }
        }
    }

    private class h implements Runnable {
        private String ip;
        private int sln;

        public h(String str, int i) {
            this.ip = str;
            this.sln = i;
        }

        public final void run() {
            boolean z = true;
            x.i("MicroMsg.MMTraceRoute", "ttl= " + this.sln);
            a aVar = a.this;
            String str = this.ip;
            int i = this.sln;
            List A = b.A(new String[]{"ping", "-c 1", "-t " + String.valueOf(i), str});
            if (A.size() != 2) {
                aVar.a(str, String.format("%d : can not get roupter ip\n", new Object[]{Integer.valueOf(i)}), Integer.valueOf(i + 1));
            } else {
                String str2 = (String) A.get(0);
                if (str2.length() == 0) {
                    x.e("MicroMsg.MMTraceRoute", "runcommand err");
                } else {
                    String str3;
                    int indexOf = str2.indexOf("From ");
                    if (indexOf < 0) {
                        indexOf = str2.indexOf("from ");
                        if (indexOf < 0) {
                            str3 = null;
                            if (bi.oN(str3)) {
                                if (b.Nb(str2) <= 0) {
                                    str2 = String.format("%d : can not get roupter ip\n", new Object[]{Integer.valueOf(i)});
                                    x.e("MicroMsg.MMTraceRoute", "can not get route ip and ttl" + str);
                                    aVar.a(str, str2, Integer.valueOf(i + 1));
                                }
                                if (!z) {
                                }
                            }
                            if (!str.equals(str3)) {
                                aVar.a(str, String.format("%d : FIN %s\n\n", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                            } else if (b.Nb(str2) > 0) {
                                aVar.a(str, String.format("%d : FIN %s\n\n ", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                                if (a.skV != null) {
                                    a.skV.execute(new g(str3, str, true, Integer.valueOf(i + 1)));
                                }
                            } else {
                                aVar.a(str, String.format("%d : %s", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                                if (a.skV != null) {
                                    a.skV.execute(new g(str3, str, false, Integer.valueOf(i + 1)));
                                }
                            }
                            if (!z) {
                            }
                        }
                    }
                    int indexOf2 = str2.indexOf(" ", indexOf);
                    if (indexOf2 < 0) {
                        indexOf = str2.indexOf(":", indexOf);
                        if (indexOf < 0) {
                            str3 = null;
                            if (bi.oN(str3)) {
                                if (!str.equals(str3)) {
                                    aVar.a(str, String.format("%d : FIN %s\n\n", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                                } else if (b.Nb(str2) > 0) {
                                    aVar.a(str, String.format("%d : %s", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                                    if (a.skV != null) {
                                        a.skV.execute(new g(str3, str, false, Integer.valueOf(i + 1)));
                                    }
                                } else {
                                    aVar.a(str, String.format("%d : FIN %s\n\n ", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                                    if (a.skV != null) {
                                        a.skV.execute(new g(str3, str, true, Integer.valueOf(i + 1)));
                                    }
                                }
                                if (!z) {
                                }
                            }
                            if (b.Nb(str2) <= 0) {
                                str2 = String.format("%d : can not get roupter ip\n", new Object[]{Integer.valueOf(i)});
                                x.e("MicroMsg.MMTraceRoute", "can not get route ip and ttl" + str);
                                aVar.a(str, str2, Integer.valueOf(i + 1));
                            }
                            if (!z) {
                            }
                        }
                    }
                    indexOf = indexOf2;
                    indexOf++;
                    indexOf2 = str2.indexOf(" ", indexOf);
                    str3 = indexOf2 < 0 ? null : str2.substring(indexOf, indexOf2).replace(":", "");
                    if (bi.oN(str3)) {
                        if (b.Nb(str2) <= 0) {
                            str2 = String.format("%d : can not get roupter ip\n", new Object[]{Integer.valueOf(i)});
                            x.e("MicroMsg.MMTraceRoute", "can not get route ip and ttl" + str);
                            aVar.a(str, str2, Integer.valueOf(i + 1));
                        }
                        if (!z) {
                        }
                    }
                    if (!str.equals(str3)) {
                        aVar.a(str, String.format("%d : FIN %s\n\n", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                    } else if (b.Nb(str2) > 0) {
                        aVar.a(str, String.format("%d : FIN %s\n\n ", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                        if (a.skV != null) {
                            a.skV.execute(new g(str3, str, true, Integer.valueOf(i + 1)));
                        }
                    } else {
                        aVar.a(str, String.format("%d : %s", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                        if (a.skV != null) {
                            a.skV.execute(new g(str3, str, false, Integer.valueOf(i + 1)));
                        }
                    }
                    if (!z) {
                    }
                }
            }
            z = false;
            if (!z) {
            }
        }
    }

    private class j implements Runnable {
        private j() {
        }

        public /* synthetic */ j(a aVar, byte b) {
            this();
        }

        public final void run() {
            long Wy;
            a.this.je(false);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long Wy2 = bi.Wy();
            x.i("MicroMsg.MMTraceRoute", "mmtraceroute start time " + simpleDateFormat.format(new Date(Wy2)));
            for (Entry entry : a.this.skZ.entrySet()) {
                Runnable iVar = new i((String) entry.getKey());
                if (a.skV != null) {
                    a.skV.execute(iVar);
                }
                iVar = new a((String) entry.getKey(), (Set) entry.getValue());
                if (a.skV != null) {
                    a.skV.execute(iVar);
                }
            }
            while (!a.this.bGd() && a.skV.getActiveCount() > 0) {
                x.d("MicroMsg.MMTraceRoute", "task count: " + String.valueOf(a.skV.getActiveCount()));
                Wy = bi.Wy();
                if (Wy - Wy2 >= 120000) {
                    x.i("MicroMsg.MMTraceRoute", "traceroute timeout: " + ((Wy - Wy2) / 1000));
                    a.this.je(true);
                    a.this.stop();
                    if (a.this.sla != null) {
                        a.this.sla.bGi();
                        return;
                    }
                    return;
                }
                try {
                    Thread.sleep(500);
                } catch (Throwable e) {
                    x.e("MicroMsg.MMTraceRoute", "wait for command end err: " + e.getMessage());
                    x.printErrStackTrace("MicroMsg.MMTraceRoute", e, "", new Object[0]);
                }
            }
            Wy = bi.Wy();
            x.i("MicroMsg.MMTraceRoute", "mmtraceroute end time " + simpleDateFormat.format(new java.util.Date(Wy)));
            x.i("MicroMsg.MMTraceRoute", "mmtraceroute total time " + ((Wy - Wy2) / 1000));
            if (a.this.slb != null && !a.this.bGd()) {
                a.this.slb.bGh();
            }
        }
    }

    public interface e {
        void bGi();
    }

    private class g implements Runnable {
        private String serverIP;
        private String slk;
        private boolean sll;
        private Integer slm;

        public g(String str, String str2, boolean z, Integer num) {
            this.slk = str;
            this.serverIP = str2;
            this.sll = z;
            this.slm = num;
        }

        public final void run() {
            a aVar = a.this;
            String str = this.slk;
            String str2 = this.serverIP;
            Integer num = this.slm;
            for (int i = 1; i <= 3; i++) {
                List A = b.A(new String[]{"ping", "-c 1", new StringBuilder("-t 64").toString(), str});
                if (A.size() == 2) {
                    String str3 = (String) A.get(0);
                    if (bi.oN(str3)) {
                        x.e("MicroMsg.MMTraceRoute", "runcommand err " + str);
                        aVar.a(str2, "run command err ", num);
                    } else {
                        String obj = A.get(1).toString();
                        if (b.Nb(str3) > 0) {
                            if (!bi.oN(b.Na(str3))) {
                                str3 = String.format(" %sms ", new Object[]{b.Na(str3)});
                            } else if (bi.oN(obj)) {
                                str3 = String.format("unable to get time", new Object[0]);
                            } else {
                                str3 = String.format(" %sms ", new Object[]{obj});
                            }
                        } else {
                            str3 = String.format(" router no response ", new Object[0]);
                        }
                        if (i == 3) {
                            str3 = str3 + "\n";
                        }
                        aVar.a(str2, str3, num);
                    }
                } else if (i == 3) {
                    aVar.a(str2, " router no response\n", num);
                } else {
                    aVar.a(str2, " router no response", num);
                }
            }
        }
    }

    private class i implements Runnable {
        private String ip;

        public i(String str) {
            this.ip = str;
        }

        public final void run() {
            int i = 1;
            List A = b.A(new String[]{"ping", "-c 1", new StringBuilder("-t 64").toString(), this.ip});
            if (A.size() != 2) {
                a.this.a(this.ip, "failed to ping: \n" + this.ip, Integer.valueOf(0));
                return;
            }
            String str = (String) A.get(0);
            if (bi.oN(str)) {
                a.this.a(this.ip, "failed to ping: \n" + this.ip, Integer.valueOf(0));
                x.e("MicroMsg.MMTraceRoute", "runcommand err");
                return;
            }
            int Nb = b.Nb(str);
            if (Nb <= 0) {
                x.e("MicroMsg.MMTraceRoute", "failed to touch server:" + this.ip);
                a.this.a(this.ip, "failed to touch server: " + this.ip + "\n", Integer.valueOf(0));
                return;
            }
            String obj = A.get(1).toString();
            if (!bi.oN(b.Na(str))) {
                str = String.format("server: %s, TTL: %d, Time = %sms", new Object[]{this.ip, Integer.valueOf(Nb), b.Na(str)});
            } else if (bi.oN(obj)) {
                str = String.format("server: %s, TTL: %d, Time = %sms", new Object[]{this.ip, Integer.valueOf(Nb), "unknown"});
            } else {
                str = String.format("server: %s, TTL: %d, Time = %sms", new Object[]{this.ip, Integer.valueOf(Nb), obj});
            }
            a.this.a(this.ip, str + "\n", Integer.valueOf(0));
            int i2 = (64 - Nb) + 5;
            if (i2 < 0) {
                i2 = 64;
            }
            while (i < i2 && !a.this.bGd()) {
                Runnable hVar = new h(this.ip, i);
                if (a.skV != null) {
                    a.skV.execute(hVar);
                }
                i++;
            }
        }
    }

    public interface b {
        void bGf();
    }

    static /* synthetic */ void a(a aVar) {
        if (aVar.sld != null) {
            aVar.sld.bGf();
        }
    }

    final synchronized boolean bGd() {
        return this.skX;
    }

    final synchronized void je(boolean z) {
        this.skX = z;
    }

    public a(String str) {
        this.userName = str;
        skU = com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath() + "/tencent/traceroute_log_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date()).toString() + ".log";
    }

    public final void stop() {
        je(true);
        if (skV != null) {
            try {
                skV.shutdownNow();
            } catch (Exception e) {
                x.e("MicroMsg.MMTraceRoute", "failed to shutdown threadpool: " + e.getMessage());
            }
        }
    }

    public final void b(String[] strArr, boolean z) {
        if (strArr == null || strArr.length == 0) {
            x.e("MicroMsg.MMTraceRoute", "no ip contains");
            return;
        }
        String str = "";
        if (z) {
            str = str + "long: ";
        } else {
            str = str + "short: ";
        }
        int length = strArr.length;
        int i = 0;
        String str2 = str;
        while (i < length) {
            str = strArr[i];
            String[] split = str.split(":");
            if (split == null || split.length != 3) {
                x.e("MicroMsg.MMTraceRoute", "err ip " + str);
                str = str2;
            } else if (this.skZ.containsKey(split[0])) {
                ((Set) this.skZ.get(split[0])).add(Integer.valueOf(bi.getInt(split[1], 0)));
                str = str2;
            } else {
                Set hashSet = new HashSet();
                hashSet.add(Integer.valueOf(bi.getInt(split[1], 0)));
                this.skZ.put(split[0], hashSet);
                str = str2 + split[0] + " ";
            }
            i++;
            str2 = str;
        }
        com.tencent.mm.a.e.d(skU, (str2 + "\n").getBytes());
    }

    final synchronized void a(String str, String str2, Integer num) {
        if (!(str == null || str2 == null)) {
            if (num.intValue() >= 0) {
                if (!this.skY.containsKey(str)) {
                    Map concurrentHashMap = new ConcurrentHashMap();
                    concurrentHashMap.put(num, new StringBuilder(str2));
                    this.skY.put(str, (ConcurrentHashMap) concurrentHashMap);
                } else if (((ConcurrentHashMap) this.skY.get(str)).containsKey(num)) {
                    ((StringBuilder) ((ConcurrentHashMap) this.skY.get(str)).get(num)).append(str2);
                } else {
                    new ConcurrentHashMap().put(num, new StringBuilder(str2));
                    ((ConcurrentHashMap) this.skY.get(str)).put(num, new StringBuilder(str2));
                }
            }
        }
    }

    public final synchronized void bGe() {
        if (this.skY != null) {
            String str;
            f fVar = this.skY;
            File file = new File(skU);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                    com.tencent.mm.a.e.d(skU, (fVar.slf.userName + "\n").getBytes());
                } catch (Throwable e) {
                    x.e("MicroMsg.MMTraceRoute", "create log file err " + e.getMessage());
                    x.printErrStackTrace("MicroMsg.MMTraceRoute", e, "", new Object[0]);
                    a(fVar.slf);
                }
            }
            for (Entry key : fVar.slf.skY.entrySet()) {
                String str2 = (String) key.getKey();
                if (!bi.oN(str2) && fVar.slf.skY.containsKey(str2)) {
                    Map map = (Map) fVar.slf.skY.get(str2);
                    if (map != null) {
                        String str3 = "";
                        if (map.size() != 1 || map.get(Integer.valueOf(1)) == null) {
                            int i = 0;
                            Object obj = null;
                            while (i < map.size() && obj == null) {
                                Object obj2;
                                if (map.get(Integer.valueOf(i)) != null) {
                                    String stringBuilder = ((StringBuilder) map.get(Integer.valueOf(i))).toString();
                                    if (!bi.oN(stringBuilder)) {
                                        str = str3 + stringBuilder;
                                        obj2 = stringBuilder.contains("FIN") ? 1 : obj;
                                        i++;
                                        obj = obj2;
                                        str3 = str;
                                    }
                                }
                                str = str3;
                                obj2 = obj;
                                i++;
                                obj = obj2;
                                str3 = str;
                            }
                        } else {
                            str3 = str3 + ((StringBuilder) map.get(Integer.valueOf(1))).toString();
                        }
                        if (str3.length() > 0) {
                            x.i("MicroMsg.MMTraceRoute", str2 + str3);
                            com.tencent.mm.a.e.d(skU, str3.getBytes());
                        }
                    } else {
                        continue;
                    }
                }
            }
            byte[] d = com.tencent.mm.a.e.d(skU, 0, -1);
            if (bi.by(d)) {
                x.e("MicroMsg.MMTraceRoute", "read log failed");
                a(fVar.slf);
            } else {
                str = com.tencent.mm.a.g.s(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(com.tencent.mm.protocal.d.vHl), Integer.valueOf(d.length)}).getBytes()).toLowerCase();
                d = q.q(d);
                PByteArray pByteArray = new PByteArray();
                com.tencent.mm.a.c.a(pByteArray, d, str.getBytes());
                com.tencent.mm.sdk.f.e.post(new AnonymousClass1(r1, str, pByteArray), "MMTraceRoute_uploadLog");
            }
        }
        return;
    }
}
