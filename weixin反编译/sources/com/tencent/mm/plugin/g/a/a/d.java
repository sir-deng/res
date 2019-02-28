package com.tencent.mm.plugin.g.a.a;

import com.tencent.mm.sdk.platformtools.x;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Vector;
import junit.framework.Assert;

public final class d {
    private final HashMap<c, Vector<Integer>> gTK = new HashMap();
    private b kBI = null;

    public d(b bVar) {
        this.kBI = bVar;
    }

    public final void a(int i, String str, e eVar) {
        x.i("MicroMsg.exdevie.IBeaconManager", "advertismentProcess, brand = %s, rssi = %d", null, Integer.valueOf(i));
        if (eVar == null) {
            x.e("MicroMsg.exdevie.IBeaconManager", "null == aProtocal");
            return;
        }
        c cVar = new c();
        cVar.kBF = null;
        cVar.kBG = eVar;
        cVar.bpq = str;
        Vector vector;
        if (this.gTK.containsKey(cVar)) {
            vector = (Vector) this.gTK.get(cVar);
            vector.add(Integer.valueOf(i));
            if (1 <= vector.size()) {
                try {
                    a(vector, cVar);
                    return;
                } catch (Exception e) {
                    x.e("MicroMsg.exdevie.IBeaconManager", "calDistance failed!!!, %s", e.getMessage());
                    return;
                } finally {
                    vector.clear();
                }
            } else {
                return;
            }
        }
        vector = new Vector();
        vector.add(Integer.valueOf(i));
        this.gTK.put(cVar, vector);
    }

    private void a(Vector<Integer> vector, c cVar) {
        int i;
        int[] iArr;
        double d;
        double g;
        x.i("MicroMsg.exdevie.IBeaconManager", "calDistance");
        int[] iArr2 = new int[vector.size()];
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= iArr2.length) {
                break;
            }
            iArr2[i] = ((Integer) vector.elementAt(i)).intValue();
            i2 = i + 1;
        }
        a aVar = new a(iArr2);
        if (1 == aVar.kBE.length) {
            x.d("MicroMsg.exdevice.GaussianFilter", "data group length = 1, no need to filter, just return");
            iArr = aVar.kBE;
        } else {
            StringBuilder stringBuilder = new StringBuilder("");
            stringBuilder.append("Data Before GaussianFilter \r\n");
            for (int i3 : aVar.kBE) {
                stringBuilder.append(" " + i3);
            }
            x.d("MicroMsg.exdevice.GaussianFilter", stringBuilder.toString());
            d = i.d(aVar.kBE, 5);
            g = i.g(aVar.kBE);
            double doubleValue = i.g(0.15d, g).add(new BigDecimal(d)).doubleValue();
            double doubleValue2 = i.g(3.09d, g).add(new BigDecimal(d)).doubleValue();
            x.d("MicroMsg.exdevice.GaussianFilter", "Mean = " + d + "SD = " + g + "LowerLimit = " + doubleValue + " UpperLimit = " + doubleValue2);
            i = 0;
            int[] iArr3 = new int[aVar.kBE.length];
            i2 = 0;
            while (i2 < aVar.kBE.length) {
                if (((double) aVar.kBE[i2]) >= doubleValue && ((double) aVar.kBE[i2]) <= doubleValue2) {
                    int i4 = i + 1;
                    iArr3[i] = aVar.kBE[i2];
                    i = i4;
                }
                i2++;
            }
            Assert.assertTrue(i != 0);
            iArr2 = new int[i];
            for (i2 = 0; i2 < i; i2++) {
                iArr2[i2] = iArr3[i2];
            }
            stringBuilder = new StringBuilder("");
            stringBuilder.append("Data After GaussianFilter \r\n");
            for (int i32 : iArr2) {
                stringBuilder.append(" " + i32);
            }
            x.d("MicroMsg.exdevice.GaussianFilter", stringBuilder.toString());
            iArr = iArr2;
        }
        if (iArr == null || iArr.length == 0) {
            throw new NullPointerException("null == ret || 0 == ret.length");
        }
        double d2 = i.d(iArr, 5);
        cVar.kBH = new BigDecimal(d2).divide(new BigDecimal(1), 3, 4).doubleValue();
        d = (1.0d * d2) / ((double) cVar.kBG.kBK.kCo);
        if (d < 1.0d) {
            d = Math.pow(d, 10.0d);
        } else {
            d = (Math.pow(d, 9.9476d) * 0.92093d) + 0.54992d;
        }
        x.i("MicroMsg.exdevie.IBeaconManager", "txPower = %f , rssi = %f,distance = %f", Double.valueOf(g), Double.valueOf(d2), Double.valueOf(d));
        this.kBI.a(d, cVar);
    }
}
