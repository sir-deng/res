package com.tencent.mm.modelstat;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.mm.a.h;
import com.tencent.mm.a.o;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import junit.framework.Assert;

public class e {
    private static e hSu;
    private ArrayList<Pair<Float, Float>> hSA = new ArrayList();
    private ArrayList<Pair<Float, Float>> hSB = new ArrayList();
    private int hSv = -1;
    private int hSw = HardCoderJNI.sHCENCODEVIDEOTIMEOUT;
    private int hSx = 3000;
    private int hSy = 1000;
    private int hSz = 20;
    private long startTime = 0;

    class b {
        private SensorManager hSO;
        long hSP = 0;
        a hSQ = null;
        a hSR = null;
        a hSS = null;
        private Long hST = null;
        ArrayList<Long> hSU = new ArrayList();
        ArrayList<a> hSV = new ArrayList();
        ArrayList<a> hSW = new ArrayList();
        ArrayList<a> hSX = new ArrayList();
        ArrayList<float[]> hSY = new ArrayList();
        private SensorEventListener hSZ = new SensorEventListener() {
            public final void onAccuracyChanged(Sensor sensor, int i) {
            }

            public final void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null) {
                    long Wy = bi.Wy();
                    if (sensorEvent.sensor.getType() == 1) {
                        b.this.hSQ = new a(sensorEvent);
                    } else if (sensorEvent.sensor.getType() == 2) {
                        b.this.hSR = new a(sensorEvent);
                    } else if (sensorEvent.sensor.getType() == 4) {
                        b.this.hSS = new a(sensorEvent);
                    }
                    long j = Wy - b.this.hjl;
                    if (b.this.hSQ != null && b.this.hSR != null && b.this.hSS != null) {
                        if (j > b.this.hSP || j < 0) {
                            float[] fArr = new float[9];
                            SensorManager.getRotationMatrix(fArr, null, b.this.hSQ.values, b.this.hSR.values);
                            Object obj = new float[3];
                            SensorManager.getOrientation(fArr, obj);
                            b.this.hjl = Wy;
                            b.this.hSU.add(Long.valueOf(Wy));
                            b.this.hSV.add(b.this.hSQ);
                            b.this.hSW.add(b.this.hSR);
                            b.this.hSX.add(b.this.hSS);
                            b.this.hSY.add(obj);
                            int size = b.this.hSV.size() - 1;
                            x.i("MicroMsg.IndoorReporter", "RES ,  %d  acc[%d,%f,%f,%f]  ", Integer.valueOf(b.this.hSV.size()), Integer.valueOf(((a) b.this.hSV.get(size)).accuracy), Float.valueOf(((a) b.this.hSV.get(size)).values[0]), Float.valueOf(((a) b.this.hSV.get(size)).values[1]), Float.valueOf(((a) b.this.hSV.get(size)).values[2]));
                            x.v("MicroMsg.IndoorReporter", "Res:%d acc[%d,%f,%f,%f] mag[%d,%f,%f,%f] gyr[%d,%f,%f,%f] ori[%f,%f,%f]", Long.valueOf(j), Integer.valueOf(b.this.hSQ.accuracy), Float.valueOf(b.this.hSQ.values[0]), Float.valueOf(b.this.hSQ.values[1]), Float.valueOf(b.this.hSQ.values[2]), Integer.valueOf(b.this.hSR.accuracy), Float.valueOf(b.this.hSR.values[0]), Float.valueOf(b.this.hSR.values[1]), Float.valueOf(b.this.hSR.values[2]), Integer.valueOf(b.this.hSS.accuracy), Float.valueOf(b.this.hSS.values[0]), Float.valueOf(b.this.hSS.values[1]), Float.valueOf(b.this.hSS.values[2]), Float.valueOf(obj[0]), Float.valueOf(obj[1]), Float.valueOf(obj[2]));
                        }
                    }
                }
            }
        };
        private HandlerThread handlerThread = null;
        long hjl = 0;

        b() {
        }

        public final boolean u(Context context, int i) {
            boolean z;
            try {
                if (this.hSO == null) {
                    this.hSO = (SensorManager) context.getSystemService("sensor");
                }
                if (this.handlerThread == null) {
                    this.handlerThread = com.tencent.mm.sdk.f.e.dc("MicroMsg.IndoorReporter", 1);
                    this.handlerThread.start();
                }
                Handler handler = new Handler(this.handlerThread.getLooper());
                z = this.hSO.registerListener(this.hSZ, this.hSO.getDefaultSensor(1), 3, handler) && this.hSO.registerListener(this.hSZ, this.hSO.getDefaultSensor(4), 3, handler) && this.hSO.registerListener(this.hSZ, this.hSO.getDefaultSensor(2), 3, handler);
            } catch (Exception e) {
                x.e("MicroMsg.IndoorReporter", "start except:%s", e.getMessage());
                z = false;
            }
            if (!z) {
                try {
                    if (this.hSO != null) {
                        this.hSO.unregisterListener(this.hSZ);
                        this.hSO = null;
                    }
                } catch (Exception e2) {
                }
                try {
                    if (this.handlerThread != null) {
                        this.handlerThread.quit();
                        this.handlerThread = null;
                    }
                } catch (Exception e3) {
                }
            }
            this.hSP = (long) i;
            this.hST = Long.valueOf(bi.Wy());
            return z;
        }

        public final String Ta() {
            try {
                if (this.hSO != null) {
                    this.hSO.unregisterListener(this.hSZ);
                    this.hSO = null;
                }
            } catch (Exception e) {
            }
            try {
                if (this.handlerThread != null) {
                    this.handlerThread.quit();
                    this.handlerThread = null;
                }
            } catch (Exception e2) {
            }
            x.i("MicroMsg.IndoorReporter", "stop sampling Res Count: %d", Integer.valueOf(this.hSU.size()));
            String str = this.hST + ";" + this.hSU.size() + ";#";
            int i = 0;
            while (i < this.hSU.size()) {
                String str2 = (str + (((Long) this.hSU.get(i)).longValue() - this.hST.longValue()) + ";") + a((a) this.hSV.get(i));
                x.i("MicroMsg.IndoorReporter", "%d accResArr [%d,%f,%f,%f]  %s", Integer.valueOf(i), Integer.valueOf(((a) this.hSV.get(i)).accuracy), Float.valueOf(((a) this.hSV.get(i)).values[0]), Float.valueOf(((a) this.hSV.get(i)).values[1]), Float.valueOf(((a) this.hSV.get(i)).values[2]), a((a) this.hSV.get(i)));
                i++;
                str = ((str2 + a((a) this.hSX.get(i))) + a((a) this.hSW.get(i))) + String.format("%.3f;%.3f;%.3f;#", new Object[]{Float.valueOf(((float[]) this.hSY.get(i))[0]), Float.valueOf(((float[]) this.hSY.get(i))[1]), Float.valueOf(((float[]) this.hSY.get(i))[2])});
            }
            x.i("MicroMsg.IndoorReporter", "stop  Res: %d [%s]", Integer.valueOf(str.length()), str);
            return str;
        }

        private static String a(a aVar) {
            try {
                String str = new String();
                return String.format("%d;%.3f;%.3f;%.3f;", new Object[]{Integer.valueOf(aVar.accuracy), Float.valueOf(aVar.values[0]), Float.valueOf(aVar.values[1]), Float.valueOf(aVar.values[2])});
            } catch (Exception e) {
                return "0;0;0;0;";
            }
        }
    }

    static class a {
        public int accuracy = 0;
        public float[] values;

        public a(SensorEvent sensorEvent) {
            if (sensorEvent != null) {
                this.accuracy = sensorEvent.accuracy;
                this.values = new float[sensorEvent.values.length];
                System.arraycopy(sensorEvent.values, 0, this.values, 0, sensorEvent.values.length);
            }
        }
    }

    class c {
        WifiManager bni;
        int hSz = 0;
        int hTb = 0;
        boolean hTc = false;
        List<String> hTd = new ArrayList();
        long startTime = 0;
        Thread thread = com.tencent.mm.sdk.f.e.b(new Runnable() {
            public final void run() {
                x.i("MicroMsg.IndoorReporter", "start wifi");
                while (c.this.hTc) {
                    try {
                        int i;
                        long Wy = bi.Wy();
                        List scanResults = c.this.bni.getScanResults();
                        String str = "";
                        if (scanResults == null || scanResults.size() <= 0) {
                            i = 0;
                        } else {
                            Collections.sort(scanResults, new Comparator<ScanResult>() {
                                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                                    return ((ScanResult) obj2).level - ((ScanResult) obj).level;
                                }
                            });
                            int i2 = 0;
                            i = 0;
                            while (i2 < scanResults.size()) {
                                int i3;
                                ScanResult scanResult = (ScanResult) scanResults.get(i2);
                                if (scanResult != null && !bi.oN(scanResult.BSSID) && !bi.oN(scanResult.SSID)) {
                                    str = str + scanResult.SSID.replace(";", "").replace(" ", "").replace(",", "").replace("#", "") + ";" + scanResult.BSSID + ";" + scanResult.level + ";";
                                    i3 = i + 1;
                                    if (i3 >= c.this.hSz) {
                                        i = i3;
                                        break;
                                    }
                                } else {
                                    i3 = i;
                                }
                                i2++;
                                str = str;
                                i = i3;
                            }
                        }
                        x.i("MicroMsg.IndoorReporter", "%d %s", Integer.valueOf(((Wy - c.this.startTime) + ";" + (scanResults != null ? scanResults.size() : 0) + ";" + i + ";" + str).length()), (Wy - c.this.startTime) + ";" + (scanResults != null ? scanResults.size() : 0) + ";" + i + ";" + str);
                        c.this.hTd.add(r0);
                        c.this.bni.startScan();
                        Thread.sleep((long) c.this.hTb);
                    } catch (Exception e) {
                        x.e("MicroMsg.IndoorReporter", "Except:%s", e.getMessage());
                        return;
                    }
                }
            }
        }, "MicroMsg.IndoorReporter_WIFI_Scan");

        c() {
        }

        public final String Ta() {
            this.hTc = false;
            try {
                if (this.thread != null && this.thread.isAlive()) {
                    this.thread.join(500);
                }
            } catch (Exception e) {
                x.e("MicroMsg.IndoorReporter", "stop, join Thread failed:%s ", e.getMessage());
            }
            String str = this.hTd.size() + ";#";
            int i = false;
            while (i < this.hTd.size()) {
                String str2 = str + ((String) this.hTd.get(i)) + "#";
                i++;
                str = str2;
            }
            return str;
        }
    }

    static /* synthetic */ boolean o(float f, float f2) {
        return ((double) Math.abs(f - f2)) < Math.pow(0.1d, 2.0d);
    }

    public static e SZ() {
        if (hSu == null) {
            synchronized (e.class) {
                if (hSu == null) {
                    hSu = new e();
                }
            }
        }
        return hSu;
    }

    public final void a(int i, boolean z, boolean z2, float f, float f2, int i2) {
        x.i("MicroMsg.IndoorReporter", "report scene:%d agps:%b mars:%b lon:%f lat:%f acc:%d", Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2));
        if (g.Do().CF()) {
            g.Do();
            if (!com.tencent.mm.kernel.a.Cz()) {
                com.tencent.mm.bc.b Rr = com.tencent.mm.bc.b.Rr();
                String str = "";
                String str2 = "";
                int i3 = z2 ? 1 : 0;
                if (g.Do().CF()) {
                    g.Do();
                    if (!com.tencent.mm.kernel.a.Cz()) {
                        g.Dr();
                        g.Dt().F(new com.tencent.mm.bc.b.AnonymousClass1(i3, f, f2, i, i2, 0, str, str2));
                    }
                }
                if (this.hSB.size() != 0 || this.hSA.size() != 0 || mP(com.tencent.mm.j.g.Af().getValue("AndroidIndoorSensorReport"))) {
                    if (!com.tencent.mm.sdk.a.b.cfx()) {
                        g.Do();
                        int aJ = h.aJ(com.tencent.mm.kernel.a.Cn() + 5, 100);
                        if (aJ > this.hSv) {
                            r3 = new Object[3];
                            g.Do();
                            r3[0] = Long.valueOf(new o(com.tencent.mm.kernel.a.Cn()).longValue());
                            r3[1] = Integer.valueOf(aJ);
                            r3[2] = Integer.valueOf(this.hSv);
                            x.d("MicroMsg.IndoorReporter", "report uin:%s hash:%d config:%d", r3);
                            return;
                        }
                    }
                    g.Dr();
                    final boolean z3 = z2;
                    final float f3 = f;
                    final float f4 = f2;
                    final int i4 = i;
                    final boolean z4 = z;
                    final int i5 = i2;
                    g.Dt().F(new Runnable() {
                        public final void run() {
                            try {
                                if (g.Do().CF()) {
                                    g.Do();
                                    if (!com.tencent.mm.kernel.a.Cz()) {
                                        long Wy = bi.Wy();
                                        if (e.this.startTime == 0 || Wy - e.this.startTime >= 1800000) {
                                            List b;
                                            Pair pair;
                                            if (z3) {
                                                b = e.this.hSA;
                                            } else {
                                                Object b2 = e.this.hSB;
                                            }
                                            int i = 0;
                                            while (i < b2.size()) {
                                                if (e.o(f3, ((Float) ((Pair) b2.get(i)).first).floatValue()) && e.o(f4, ((Float) ((Pair) b2.get(i)).second).floatValue())) {
                                                    pair = (Pair) b2.get(i);
                                                    break;
                                                }
                                                i++;
                                            }
                                            pair = null;
                                            if (pair == null) {
                                                x.d("MicroMsg.IndoorReporter", "Ignore this report, no hit any Point");
                                                return;
                                            }
                                            int i2;
                                            e.this.startTime = Wy;
                                            StringBuilder stringBuilder = new StringBuilder();
                                            g.Do();
                                            final String stringBuilder2 = stringBuilder.append(new o(com.tencent.mm.kernel.a.Cn()).toString()).append("_").append(e.this.startTime).toString();
                                            StringBuilder append = new StringBuilder().append(pair.first).append(",").append(pair.second).append(",").append(i4).append(",");
                                            int i3 = z4 ? 1 : 2;
                                            if (z3) {
                                                i2 = 10;
                                            } else {
                                                i2 = 20;
                                            }
                                            final String stringBuilder3 = append.append(i2 + i3).append(",").append(f3).append(",").append(f4).append(",0,").append(i5).append(",").append(e.this.startTime).append(",").toString();
                                            final c cVar = new c();
                                            Context context = ad.getContext();
                                            i3 = e.this.hSx;
                                            int e = e.this.hSz;
                                            if (cVar.bni == null) {
                                                cVar.bni = (WifiManager) context.getSystemService("wifi");
                                            }
                                            cVar.hTb = i3;
                                            cVar.hSz = e;
                                            cVar.startTime = bi.Wy();
                                            cVar.hTc = true;
                                            cVar.thread.start();
                                            final b bVar = new b();
                                            if (bVar.u(ad.getContext(), e.this.hSy)) {
                                                g.Dr();
                                                new al(g.Dt().oFY.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
                                                    boolean hSI = false;

                                                    public final boolean uG() {
                                                        boolean dg = m.dg(ad.getContext());
                                                        long Wy = bi.Wy();
                                                        long a = Wy - e.this.startTime;
                                                        if (a <= ((long) e.this.hSw)) {
                                                            if (dg) {
                                                                this.hSI = false;
                                                                return true;
                                                            } else if (!this.hSI) {
                                                                this.hSI = true;
                                                                return true;
                                                            }
                                                        }
                                                        x.i("MicroMsg.IndoorReporter", "Stop Now goingbg:%b fg:%b runtime:%d", Boolean.valueOf(this.hSI), Boolean.valueOf(dg), Long.valueOf(a));
                                                        e.this.startTime = 0;
                                                        String Ta = bVar.Ta();
                                                        String Ta2 = cVar.Ta();
                                                        try {
                                                            if (bi.oN(Ta) || bi.oN(Ta2)) {
                                                                x.e("MicroMsg.IndoorReporter", "get Res Failed [%s][%s]", Ta, Ta2);
                                                                com.tencent.mm.plugin.report.service.g.pWK.k(13381, stringBuilder3 + stringBuilder2 + (!bi.oN(Ta) ? ",-10011,ERROR:StopFailed." : ",-10012,ERROR:StopFailed."));
                                                                return false;
                                                            }
                                                            String str = Ta + Ta2;
                                                            int ceil = (int) Math.ceil(((double) str.length()) / 5400.0d);
                                                            for (int i = 0; i < ceil; i++) {
                                                                x.i("MicroMsg.IndoorReporter", "reportKV [%d/%d] res:%d kv:%d [%s]", Integer.valueOf(i), Integer.valueOf(ceil), Integer.valueOf(str.length()), Integer.valueOf((stringBuilder3 + stringBuilder2 + "_" + Wy + "_" + ceil + "_" + (a > ((long) e.this.hSw) ? "1" : "2") + "," + (i + 1) + "," + str.substring(i * 5400, Math.min((i + 1) * 5400, str.length()))).length()), stringBuilder3 + stringBuilder2 + "_" + Wy + "_" + ceil + "_" + (a > ((long) e.this.hSw) ? "1" : "2") + "," + (i + 1) + "," + str.substring(i * 5400, Math.min((i + 1) * 5400, str.length())));
                                                                com.tencent.mm.plugin.report.service.g.pWK.k(13381, Ta);
                                                            }
                                                            return false;
                                                        } catch (Exception e) {
                                                            x.e("MicroMsg.IndoorReporter", "reprot Stop exception:%s", e.getMessage());
                                                        }
                                                    }
                                                }, true).K(3000, 3000);
                                                return;
                                            }
                                            x.e("MicroMsg.IndoorReporter", "Ignore this report. Error:start wifi:%b sensor:%b  ", Boolean.valueOf(true), Boolean.valueOf(bVar.u(ad.getContext(), e.this.hSy)));
                                            bVar.Ta();
                                            cVar.Ta();
                                            com.tencent.mm.plugin.report.service.g.pWK.k(13381, stringBuilder3 + stringBuilder2 + ",-10002,ERROR:StartFailed.");
                                            return;
                                        }
                                        x.e("MicroMsg.IndoorReporter", "Ignore this Report,Another Report is Running & not timeout:%d.", Long.valueOf(Wy - e.this.startTime));
                                    }
                                }
                            } catch (Exception e2) {
                                x.e("MicroMsg.IndoorReporter", "reprot Start exception:%s", e2.getMessage());
                            }
                        }
                    });
                }
            }
        }
    }

    public final boolean mP(String str) {
        if (bi.oN(str)) {
            return false;
        }
        try {
            String[] split = str.split(",");
            this.hSv = bi.getInt(split[0], -1);
            if (this.hSv > 101) {
                Assert.assertTrue(false);
            }
            this.hSw = bi.getInt(split[1], HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
            this.hSx = bi.getInt(split[2], 3000);
            this.hSy = bi.getInt(split[3], 1000);
            this.hSz = bi.getInt(split[4], 20);
            int i = bi.getInt(split[5], 0);
            for (int i2 = 0; i2 < i; i2++) {
                String[] split2 = split[i2 + 6].split(";");
                if ("1".equals(split2[0])) {
                    this.hSA.add(new Pair(Float.valueOf(bi.Wr(split2[1])), Float.valueOf(bi.Wr(split2[2]))));
                } else {
                    this.hSB.add(new Pair(Float.valueOf(bi.Wr(split2[1])), Float.valueOf(bi.Wr(split2[2]))));
                }
            }
            x.i("MicroMsg.IndoorReporter", "parseConfig: max:%d wifiFreq:%d sensorFreq:%d maxWifiCount:%d cnt:%d mars:%d earth:%d", Integer.valueOf(this.hSw), Integer.valueOf(this.hSx), Integer.valueOf(this.hSy), Integer.valueOf(this.hSz), Integer.valueOf(i), Integer.valueOf(this.hSA.size()), Integer.valueOf(this.hSB.size()));
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.IndoorReporter", "parseConfig e:%s  [%s]", e.getMessage(), str);
            return false;
        }
    }
}
