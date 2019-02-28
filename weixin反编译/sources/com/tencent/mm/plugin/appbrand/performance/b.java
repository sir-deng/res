package com.tencent.mm.plugin.appbrand.performance;

import android.util.SparseArray;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact;
import com.tencent.mm.plugin.appbrand.jsapi.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.appbrand.q.j;

public final class b {
    public static final int[] jLD = new int[4];
    public static final SparseArray<Integer> jLE = new SparseArray();

    static {
        jLD[0] = j.iCH;
        jLD[1] = j.iCU;
        jLD[2] = j.iDa;
        jLD[3] = j.iCY;
        jLE.put(101, Integer.valueOf(j.iCI));
        jLE.put(102, Integer.valueOf(j.iCW));
        jLE.put(103, Integer.valueOf(j.iCX));
        jLE.put(201, Integer.valueOf(j.iCL));
        jLE.put(202, Integer.valueOf(j.iCV));
        jLE.put(203, Integer.valueOf(j.iDc));
        jLE.put(301, Integer.valueOf(j.iCS));
        jLE.put(HardCoderJNI.SCENE_QUIT_CHATTING, Integer.valueOf(j.iCZ));
        jLE.put(303, Integer.valueOf(j.iCT));
        jLE.put(401, Integer.valueOf(j.iDb));
        jLE.put(e.CTRL_INDEX, Integer.valueOf(j.iDe));
        jLE.put(ap.CTRL_INDEX, Integer.valueOf(j.iDf));
        jLE.put(TencentLocation.ERROR_UNKNOWN, Integer.valueOf(j.iDg));
        jLE.put(405, Integer.valueOf(j.iDh));
        jLE.put(au.CTRL_INDEX, Integer.valueOf(j.iDi));
        jLE.put(JsApiPrivateAddContact.CTRL_INDEX, Integer.valueOf(j.iDj));
    }
}
