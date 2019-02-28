package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.d.a.h.a;
import com.tencent.mm.protocal.c.ale;
import com.tencent.mm.protocal.c.alf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.bj;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends k implements com.tencent.mm.network.k {
    int action;
    private e gLE;
    final b hGV;
    private long qvJ;

    public d(Collection<a> collection, float f, float f2, int i) {
        int i2;
        this.action = 1;
        this.qvJ = 0;
        this.action = 1;
        b.a aVar = new b.a();
        aVar.hnT = new ale();
        aVar.hnU = new alf();
        aVar.uri = "/cgi-bin/micromsg-bin/ibeaconboardcast";
        aVar.hnS = 658;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hGV = aVar.Kf();
        bj HW = bj.HW();
        String oM = bi.oM(HW.hjh);
        String oM2 = bi.oM(HW.hjg);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        ale ale = (ale) this.hGV.hnQ.hnY;
        ale.wzf = bi.oM(null);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"Beacons\":[");
        if (collection != null) {
            i2 = 0;
            int size = collection.size();
            Iterator it = collection.iterator();
            while (true) {
                int i3 = i2;
                if (!it.hasNext()) {
                    break;
                }
                a aVar2 = (a) it.next();
                stringBuilder.append("{\"UUID\":\"" + aVar2.njL + "\",\"Location\":{\"Major\":" + aVar2.major + ",\"Minor\":" + aVar2.minor + "},\"Distance\":" + aVar2.hNI + ",\"Extra\":\"\",\"MacAddress\":\"" + aVar2.qvT + "\",\"Rssi\":\"" + aVar2.qvU + "\",\"MeasurePower\":\"" + aVar2.qvV + "\"}");
                if (i3 < size - 1) {
                    stringBuilder.append(",");
                }
                i2 = i3 + 1;
            }
        }
        i2 = 1;
        boolean hasSystemFeature = ad.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        if (defaultAdapter != null && defaultAdapter.getState() == 12 && VERSION.SDK_INT >= 18 && hasSystemFeature) {
            i2 = 0;
        }
        stringBuilder.append("],\"Action\":1" + ",\"LBS\":{\"Latitude\":" + f + ",\"Longitude\":" + f2 + ",\"Province\":\"" + oM + "\",\"City\":\"" + oM2 + "\"},\"MachineID\":\"" + q.yM() + "\",\"ZBBeaconState\":\"" + i2 + "\"}");
        ale.noL = stringBuilder.toString();
        String str = "MicroMsg.NetSceneShakeIbeacon";
        oM = "[oneliang]beaconCollection.size:%d,json:%s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(collection != null ? collection.size() : 0);
        objArr[1] = ale.noL;
        x.i(str, oM, objArr);
        o.a(TXLiveConstants.PLAY_EVT_START_VIDEO_DECODER, f2, f, i);
    }

    public final int getType() {
        return 658;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.qvJ = System.currentTimeMillis();
        this.gLE = eVar2;
        return a(eVar, this.hGV, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gLE.a(i2, i3, str, this);
        this.qvJ = System.currentTimeMillis() - this.qvJ;
        g.pWK.h(11497, String.valueOf((int) (((double) (this.qvJ / 1000)) + 0.5d)), Integer.valueOf(1), Integer.valueOf((int) this.qvJ));
        int i4;
        String string;
        JSONObject jSONObject;
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end ok");
            alf alf = (alf) this.hGV.hnR.hnY;
            try {
                JSONObject jSONObject2 = new JSONObject(((ale) this.hGV.hnQ.hnY).noL);
                JSONArray jSONArray = jSONObject2.getJSONArray("Beacons");
                int length = jSONArray.length();
                JSONObject jSONObject3 = jSONObject2.getJSONObject("LBS");
                i4 = jSONObject2.getInt("Action");
                String string2 = jSONObject3.getString("Latitude");
                string = jSONObject3.getString("Longitude");
                if (length > 0) {
                    jSONObject = jSONArray.getJSONObject(0);
                    String string3 = jSONObject.getString("UUID");
                    jSONObject = jSONObject.getJSONObject("Location");
                    int i5 = jSONObject.getInt("Major");
                    int i6 = jSONObject.getInt("Minor");
                    if (alf.wzg.wcX == 0) {
                        String str2 = alf.wzg.nlB;
                        if (i4 == 1 && str2 != null && !str2.equals("") && new JSONObject(str2).getJSONArray("msgs").length() == 0) {
                            g.pWK.h(12659, Integer.valueOf(1), Integer.valueOf(length), string3, Integer.valueOf(i5), Integer.valueOf(i6), string2, string, Integer.valueOf(2), Integer.valueOf(alf.wzg.wcX));
                            return;
                        }
                        return;
                    }
                    g.pWK.h(12659, Integer.valueOf(1), Integer.valueOf(length), string3, Integer.valueOf(i5), Integer.valueOf(i6), string2, string, Integer.valueOf(2), Integer.valueOf(alf.wzg.wcX));
                    return;
                }
                g.pWK.h(12659, Integer.valueOf(1), Integer.valueOf(length), "", Integer.valueOf(0), Integer.valueOf(0), string2, string, Integer.valueOf(2), Integer.valueOf(alf.wzg.wcX));
                return;
            } catch (JSONException e) {
                x.e("MicroMsg.NetSceneShakeIbeacon", "parse IBeaconBoardcastRequest json error!");
                return;
            }
        }
        x.d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end not ok");
        try {
            jSONObject = new JSONObject(((ale) this.hGV.hnQ.hnY).noL);
            JSONArray jSONArray2 = jSONObject.getJSONArray("Beacons");
            i4 = jSONArray2.length();
            jSONObject = jSONObject.getJSONObject("LBS");
            String string4 = jSONObject.getString("Latitude");
            String string5 = jSONObject.getString("Longitude");
            if (i4 > 0) {
                JSONObject jSONObject4 = jSONArray2.getJSONObject(0);
                string = jSONObject4.getString("UUID");
                jSONObject4 = jSONObject4.getJSONObject("Location");
                int i7 = jSONObject4.getInt("Major");
                int i8 = jSONObject4.getInt("Minor");
                g.pWK.h(12659, Integer.valueOf(1), Integer.valueOf(i4), string, Integer.valueOf(i7), Integer.valueOf(i8), string4, string5, Integer.valueOf(1), Integer.valueOf(i3));
                return;
            }
            g.pWK.h(12659, Integer.valueOf(1), Integer.valueOf(i4), "", Integer.valueOf(0), Integer.valueOf(0), string4, string5, Integer.valueOf(1), Integer.valueOf(i3));
        } catch (JSONException e2) {
            x.e("MicroMsg.NetSceneShakeIbeacon", "parse IBeaconBoardcastRequest json error!");
        }
    }
}
