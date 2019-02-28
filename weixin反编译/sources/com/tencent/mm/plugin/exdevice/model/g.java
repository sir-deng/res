package com.tencent.mm.plugin.exdevice.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.dy;
import com.tencent.mm.f.a.ec;
import com.tencent.mm.f.a.hu;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.network.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.c.akx;
import com.tencent.mm.protocal.c.aky;
import com.tencent.mm.protocal.c.akz;
import com.tencent.mm.protocal.c.ala;
import com.tencent.mm.protocal.c.alb;
import com.tencent.mm.protocal.c.alc;
import com.tencent.mm.protocal.c.ald;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.protocal.c.bpy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.R;

public final class g implements e {
    String fAO;
    long gBK;
    long gNA;
    String hCY = "";
    public a hDi = new a() {
        public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
            x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s] sentToCloud:[%s]", g.this.hCY, Integer.valueOf(i), keep_progressinfo, keep_sceneresult, Boolean.valueOf(g.this.lRN));
            if (keep_progressinfo != null) {
                try {
                    int i2;
                    int i3 = (int) ((((float) keep_progressinfo.field_finishedLength) / ((float) keep_progressinfo.field_toltalLength)) * 100.0f);
                    x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sent to cloud progress %d", Integer.valueOf(i3));
                    if (i3 >= 100) {
                        i2 = 99;
                    } else {
                        i2 = i3;
                    }
                    for (String a : g.this.lRP.keySet()) {
                        g.a(g.this, a, i2);
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdnCallback Exception %s", e);
                }
            }
            if (keep_sceneresult != null) {
                if (g.this.lRN) {
                    aky aky = new aky();
                    g.this.a(aky, g.this.gBK);
                    g.this.lRN = false;
                    if (g.cq(g.this.gBK).booleanValue() || g.cr(g.this.gBK).booleanValue()) {
                        aky.wyS.vXE = keep_sceneresult.field_aesKey;
                        aky.wyS.wyW = g.this.lRR;
                        aky.wyS.vXI = keep_sceneresult.field_fileId;
                        aky.wyS.nlE = keep_sceneresult.field_fileUrl;
                        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "image_msg.url:[%s]", aky.wyS.nlE);
                    } else if (g.cp(g.this.gBK).booleanValue()) {
                        aky.wyT.vXE = keep_sceneresult.field_aesKey;
                        aky.wyT.vXI = keep_sceneresult.field_fileId;
                        aky.wyT.nlE = keep_sceneresult.field_fileUrl;
                        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file_msg.url:[%s]", aky.wyT.nlE);
                    } else if (g.cs(g.this.gBK).booleanValue()) {
                        aky.wyV.nlE = keep_sceneresult.field_fileUrl;
                        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "video_msg.url:[%s]", aky.wyV.nlE);
                    }
                    g.this.lRQ = aky;
                    for (String a2 : g.this.lRP.keySet()) {
                        as.CN().a(new n(aky, (String) g.this.lRP.get(a2), a2, 1), 0);
                    }
                    g.this.lRP.clear();
                }
            }
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getCdnAuthInfo mediaId = " + str);
        }

        public final byte[] h(String str, byte[] bArr) {
            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "decodePrepareResponse ");
            return bArr;
        }
    };
    boolean lRE = false;
    boolean lRF = false;
    boolean lRG = false;
    String lRH;
    String lRI;
    int lRJ;
    String lRK = "send_data_sucess";
    String lRL = "send_data_failed";
    private String lRM = "send_data_sending";
    boolean lRN = false;
    boolean lRO = false;
    public HashMap<String, String> lRP = new HashMap();
    aky lRQ;
    long lRR;
    List<b> lRS = null;
    List<b> lRT = new ArrayList();
    HashMap<String, String> lRU = new HashMap();
    HashMap<String, Integer> lRV = new HashMap();
    HashMap<String, Boolean> lRW = new HashMap();
    j.a lRX;
    j.a lRY;
    j.a lRZ;
    j.a lSa;
    Runnable lSb = new Runnable() {
        public final void run() {
            Throwable e;
            akz akz;
            String str;
            String str2;
            int i;
            String str3;
            String str4 = null;
            try {
                String str5 = com.tencent.mm.compatible.util.e.gJe + String.format("%s%d.%s", new Object[]{SlookAirButtonRecentMediaAdapter.IMAGE_TYPE, Integer.valueOf(g.this.fAO.hashCode()), "jpg"});
                byte[] zy = g.zy(g.this.fAO);
                if (zy != null) {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(zy, 0, zy.length);
                    g gVar = g.this;
                    BufferedOutputStream bufferedOutputStream;
                    try {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str5)));
                        try {
                            decodeByteArray.compress(CompressFormat.JPEG, 80, bufferedOutputStream);
                            bufferedOutputStream.flush();
                            try {
                                bufferedOutputStream.close();
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2, "", new Object[0]);
                            }
                        } catch (IOException e3) {
                            e2 = e3;
                            try {
                                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Exception in saveImageToFile !");
                                g.ct(gVar.lSe, gVar.lRL);
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2, "", new Object[0]);
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (Throwable e22) {
                                        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22, "", new Object[0]);
                                    }
                                }
                                g.this.lRI = str5;
                                if (g.this.lRI == null) {
                                }
                                akz = new akz();
                                str = g.this.lRI;
                                if (str != null) {
                                }
                                str2 = null;
                                i = -1;
                                str3 = null;
                                akz.whT = str4;
                                akz.nkW = str3;
                                akz.kzt = i;
                                akz.wgP = str2;
                                g.this.lSc.wyS = akz;
                                g.this.lSc.wyP = 3;
                                as.CN().a(new n(g.this.lSc, g.this.lSd, g.this.lSe, g.this.lSf), 0);
                                return;
                            } catch (Throwable th) {
                                e22 = th;
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (Throwable e4) {
                                        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e4, "", new Object[0]);
                                    }
                                }
                                throw e22;
                            }
                        }
                    } catch (IOException e5) {
                        e22 = e5;
                        bufferedOutputStream = null;
                        x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Exception in saveImageToFile !");
                        g.ct(gVar.lSe, gVar.lRL);
                        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22, "", new Object[0]);
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        g.this.lRI = str5;
                        if (g.this.lRI == null) {
                        }
                        akz = new akz();
                        str = g.this.lRI;
                        if (str != null) {
                        }
                        str2 = null;
                        i = -1;
                        str3 = null;
                        akz.whT = str4;
                        akz.nkW = str3;
                        akz.kzt = i;
                        akz.wgP = str2;
                        g.this.lSc.wyS = akz;
                        g.this.lSc.wyP = 3;
                        as.CN().a(new n(g.this.lSc, g.this.lSd, g.this.lSe, g.this.lSf), 0);
                        return;
                    } catch (Throwable th2) {
                        e22 = th2;
                        bufferedOutputStream = null;
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        throw e22;
                    }
                    g.this.lRI = str5;
                    if (g.this.lRI == null || FileOp.bO(g.this.lRI)) {
                        akz = new akz();
                        str = g.this.lRI;
                        if (str != null || str.length() <= 0) {
                            str2 = null;
                            i = -1;
                            str3 = null;
                        } else {
                            File file = new File(str);
                            str3 = file.getName();
                            i = (int) file.length();
                            str4 = str3.substring(str3.lastIndexOf(".") + 1, str3.length());
                            str2 = com.tencent.mm.a.g.i(file);
                            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "downloadImageRunnable filePath %s", str);
                            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "downloadImageRunnable fileSize %s", Integer.valueOf(i));
                            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "downloadImageRunnable fileMd5 %s", str2);
                        }
                        akz.whT = str4;
                        akz.nkW = str3;
                        akz.kzt = i;
                        akz.wgP = str2;
                        g.this.lSc.wyS = akz;
                        g.this.lSc.wyP = 3;
                        as.CN().a(new n(g.this.lSc, g.this.lSd, g.this.lSe, g.this.lSf), 0);
                        return;
                    }
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mSnsImagePath is null or file not exist!");
                    g.ct(g.this.lSe, g.this.lRL);
                    return;
                }
                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get image error !");
                g.ct(g.this.lSe, g.this.lRL);
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e222, "", new Object[0]);
            }
        }
    };
    aky lSc;
    String lSd;
    String lSe;
    int lSf;
    HashMap<Integer, String> lSg = new HashMap();

    static /* synthetic */ void a(g gVar, String str, int i) {
        com.tencent.mm.sdk.b.b ecVar = new ec();
        ecVar.ftD.ffG = str;
        if (i >= 100) {
            ecVar.ftD.ftF = gVar.lRK;
        } else {
            ecVar.ftD.ftF = gVar.lRM;
        }
        ecVar.ftD.progress = i;
        com.tencent.mm.sdk.b.a.xmy.m(ecVar);
    }

    static /* synthetic */ void a(g gVar, List list) {
        List arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            HashMap hashMap = new HashMap();
            hashMap.put("deviceType", ((b) list.get(i)).field_deviceType);
            hashMap.put("deviceID", ((b) list.get(i)).field_deviceID);
            hashMap.put("displayName", c((b) list.get(i)));
            hashMap.put("iconUrl", ((b) list.get(i)).iconUrl);
            hashMap.put("ability", ((b) list.get(i)).ggR);
            hashMap.put("abilityInf", ((b) list.get(i)).ggS);
            arrayList.add(hashMap);
        }
        com.tencent.mm.sdk.b.b dyVar = new dy();
        dyVar.fts.fsF = arrayList;
        com.tencent.mm.sdk.b.a.xmy.m(dyVar);
    }

    public g() {
        this.lRT.clear();
        this.lRU.clear();
        this.lRW.clear();
        this.lRS = ad.aER().aFv();
        if (this.lRS != null && this.lRS.size() > 0) {
            x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Bind Device Size is %d", Integer.valueOf(this.lRS.size()));
            int size = this.lRS.size();
            int i = 0;
            while (i < size) {
                if (((b) this.lRS.get(i)).ggR.contains("internet_to_device") && !((b) this.lRS.get(i)).ggR.contains("wechat_to_device")) {
                    this.lRT.add(this.lRS.get(i));
                }
                i++;
            }
            this.lSa = new j.a() {
                public final void e(int i, Object... objArr) {
                    int i2;
                    Object obj;
                    if (i == 15 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof Integer) && (objArr[1] instanceof byte[])) {
                        int intValue = ((Integer) objArr[0]).intValue();
                        try {
                            x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file transfer update json %s", new String((byte[]) objArr[1]));
                            int i3 = new JSONObject(r1).getInt("progress");
                            try {
                                g.a(g.this, (String) g.this.lSg.get(Integer.valueOf(intValue)), i3);
                                if (i3 >= 100) {
                                    g.this.lSg.remove(Integer.valueOf(intValue));
                                }
                                i2 = i3;
                            } catch (JSONException e) {
                                JSONException jSONException = e;
                                i2 = i3;
                                JSONException obj2 = jSONException;
                                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in file transfer update callback %s", obj2);
                                x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "progress %d", Integer.valueOf(i2));
                            }
                        } catch (JSONException e2) {
                            obj2 = e2;
                            i2 = 0;
                        }
                        x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "progress %d", Integer.valueOf(i2));
                    }
                }
            };
            this.lRX = new j.a() {
                public final void e(int i, Object... objArr) {
                    Exception e;
                    String str = null;
                    if (i == 14 && objArr != null && objArr.length > 0 && (objArr[0] instanceof byte[])) {
                        JSONObject jSONObject;
                        String string;
                        try {
                            JSONObject jSONObject2 = new JSONObject(new String((byte[]) objArr[0]));
                            jSONObject = jSONObject2.getJSONObject("deviceInfo");
                            try {
                                string = jSONObject.getString("deviceType");
                            } catch (Exception e2) {
                                e = e2;
                                string = null;
                            }
                            JSONObject jSONObject3;
                            Object obj;
                            Object obj2;
                            int size;
                            int i2;
                            try {
                                str = jSONObject.getString("deviceId");
                                if (jSONObject2.isNull("profile")) {
                                    x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "json have not profile, return");
                                    return;
                                }
                                JSONArray jSONArray = jSONObject2.getJSONArray("profile");
                                x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package profiles %s", jSONArray.toString());
                                String obj3 = string;
                                string = str;
                                jSONObject3 = jSONObject;
                                if (!(obj3 == null || obj2 == null)) {
                                    x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package deviceType %s, deviceId %s", obj3, obj2);
                                }
                                size = g.this.lRS.size();
                                i2 = 0;
                                while (i2 < size) {
                                    if (((b) g.this.lRS.get(i2)).field_deviceID.equals(obj2) && ((b) g.this.lRS.get(i2)).field_deviceType.equals(obj3) && ((b) g.this.lRS.get(i2)).ggR.contains("wechat_to_device") && !g.this.lRT.contains(g.this.lRS.get(i2))) {
                                        g.this.lRU.put(obj2, jSONObject3.toString());
                                        g.this.lRT.add(g.this.lRS.get(i2));
                                        g.a(g.this, g.this.lRT);
                                    }
                                    i2++;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in discover package callback %s", e);
                                obj3 = string;
                                obj2 = str;
                                jSONObject3 = jSONObject;
                                x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package deviceType %s, deviceId %s", obj3, obj2);
                                size = g.this.lRS.size();
                                i2 = 0;
                                while (i2 < size) {
                                    g.this.lRU.put(obj2, jSONObject3.toString());
                                    g.this.lRT.add(g.this.lRS.get(i2));
                                    g.a(g.this, g.this.lRT);
                                    i2++;
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            jSONObject = null;
                            string = null;
                        }
                    }
                }
            };
            this.lRY = new j.a() {
                public final void e(int i, Object... objArr) {
                    if (i == 12 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof Integer) && (objArr[1] instanceof byte[])) {
                        int intValue = ((Integer) objArr[0]).intValue();
                        byte[] bArr = (byte[]) objArr[1];
                        if (intValue > 0) {
                            String str = (String) g.this.lSg.get(Integer.valueOf(intValue));
                            if (str != null) {
                                try {
                                    x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "receive response json %s", new String(bArr));
                                    JSONObject jSONObject = new JSONObject(r2);
                                    if (jSONObject.isNull("errcode") || jSONObject.getInt("errcode") == 0) {
                                        g.ct(str, g.this.lRK);
                                        x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "send data success!");
                                        return;
                                    }
                                    g.ct(str, g.this.lRL);
                                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "send msg failed data %s", r2);
                                    return;
                                } catch (JSONException e) {
                                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode mUseWCLanDeviceServiceCmdId failed %s", e);
                                    return;
                                }
                            }
                        }
                        x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "receive cmdId =" + intValue);
                    }
                }
            };
            this.lRZ = new j.a() {
                public final void e(int i, Object... objArr) {
                    if (i == 13 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof String) && (objArr[1] instanceof Integer)) {
                        String str = (String) objArr[0];
                        int intValue = ((Integer) objArr[1]).intValue();
                        Object obj = null;
                        try {
                            JSONObject jSONObject = new JSONObject(new String(str));
                            obj = jSONObject.getString("deviceId");
                            jSONObject.getString("deviceType");
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e, "", new Object[0]);
                            x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in device ConnState notify callback");
                        }
                        switch (intValue) {
                            case -2:
                            case -1:
                            case 0:
                                g.this.lRW.put(obj, Boolean.valueOf(false));
                                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "device not connect stateCode = " + intValue);
                                return;
                            case 1:
                                g.this.lRW.put(obj, Boolean.valueOf(true));
                                x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "device connect");
                                return;
                            default:
                                return;
                        }
                    }
                }
            };
            as.CN().a(1717, (e) this);
            j.aEI().a(14, this.lRX);
            j.aEI().a(12, this.lRY);
            j.aEI().a(13, this.lRZ);
            j.aEI().a(15, this.lSa);
            x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "initWCLanDeviceLib...");
            Java2CExDevice.initWCLanDeviceLib();
        }
    }

    static Boolean cp(long j) {
        boolean z = false;
        as.Hm();
        cg dI = c.Fh().dI(j);
        if (dI.field_msgId == 0) {
            return Boolean.valueOf(false);
        }
        String str = dI.field_content;
        if (dI.getType() == 49) {
            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(str);
            if (fV != null && fV.type == 6) {
                z = true;
            }
        }
        return Boolean.valueOf(z);
    }

    static Boolean cq(long j) {
        boolean z = false;
        as.Hm();
        cg dI = c.Fh().dI(j);
        if (dI.field_msgId == 0) {
            return Boolean.valueOf(false);
        }
        if (dI.getType() == 3) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    static Boolean cr(long j) {
        boolean z = false;
        as.Hm();
        cg dI = c.Fh().dI(j);
        if (dI.field_msgId == 0) {
            return Boolean.valueOf(false);
        }
        if (dI.ckb()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    static Boolean cs(long j) {
        boolean z = false;
        as.Hm();
        cg dI = c.Fh().dI(j);
        if (dI.field_msgId == 0) {
            return Boolean.valueOf(false);
        }
        if (dI.getType() == 62) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public static byte[] zy(String str) {
        Throwable e;
        Throwable th;
        byte[] bArr = null;
        x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "url %s", str);
        u a;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            a = com.tencent.mm.network.b.a(str, null);
            try {
                a.setRequestMethod("GET");
                a.setConnectTimeout(25000);
                a.setReadTimeout(25000);
                inputStream = a.getInputStream();
                try {
                    if (a.getResponseCode() == 200) {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                            while (true) {
                                int read = inputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            }
                            byteArrayOutputStream.close();
                            inputStream.close();
                            a.aBw.disconnect();
                            bArr = byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2, "", new Object[0]);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e22) {
                                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22, "", new Object[0]);
                                }
                            }
                            a.aBw.disconnect();
                        } catch (Exception e3) {
                            e22 = e3;
                        }
                    } else {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e222) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e222, "", new Object[0]);
                            }
                        }
                        a.aBw.disconnect();
                    }
                } catch (Exception e4) {
                    e222 = e4;
                    byteArrayOutputStream = bArr;
                    try {
                        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e222, "", new Object[0]);
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e2222) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2222, "", new Object[0]);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e22222) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22222, "", new Object[0]);
                            }
                        }
                        if (a != null) {
                            a.aBw.disconnect();
                        }
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e222222) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e222222, "", new Object[0]);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e2222222) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2222222, "", new Object[0]);
                            }
                        }
                        if (a != null) {
                            a.aBw.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable e22222222) {
                    byteArrayOutputStream = bArr;
                    th = e22222222;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (a != null) {
                        a.aBw.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e22222222 = e5;
                inputStream = bArr;
                byteArrayOutputStream = bArr;
            } catch (Throwable e222222222) {
                inputStream = bArr;
                byteArrayOutputStream = bArr;
                th = e222222222;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (a != null) {
                    a.aBw.disconnect();
                }
                throw th;
            }
        } catch (Exception e6) {
            e222222222 = e6;
            a = bArr;
            inputStream = bArr;
            byteArrayOutputStream = bArr;
        } catch (Throwable e2222222222) {
            a = bArr;
            inputStream = bArr;
            byteArrayOutputStream = bArr;
            th = e2222222222;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (a != null) {
                a.aBw.disconnect();
            }
            throw th;
        }
        return bArr;
    }

    public final bpb aEG() {
        com.tencent.mm.sdk.b.b huVar = new hu();
        huVar.fyW.fsC = this.lRH;
        com.tencent.mm.sdk.b.a.xmy.m(huVar);
        return huVar.fyX.fyY;
    }

    final boolean a(aky aky, long j) {
        int i = -1;
        String str = null;
        String str2 = null;
        String str3 = null;
        String ct = ct(j);
        if (ct != null && ct.length() > 0) {
            File file = new File(ct);
            str2 = file.getName();
            i = (int) file.length();
            str3 = str2.substring(str2.lastIndexOf(".") + 1, str2.length());
            str = com.tencent.mm.a.g.i(file);
            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "filePath %s", ct);
            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileSize %s", Integer.valueOf(i));
            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileMd5 %s", str);
        }
        as.Hm();
        cg dI = c.Fh().dI(j);
        if (dI.field_msgId == 0) {
            x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "msgInfo or msgInfo.getMsgId() = 0");
            return false;
        }
        switch (dI.getType()) {
            case 3:
                akz akz = new akz();
                akz.whT = str3;
                akz.nkW = str2;
                akz.kzt = i;
                akz.wgP = str;
                aky.wyS = akz;
                aky.wyP = 3;
                break;
            case R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                as.Hm();
                au.b Fr = c.Fh().Fr(dI.field_content);
                ala ala = new ala();
                ala.vUR = (float) Fr.nWe;
                ala.vUS = (float) Fr.nWf;
                ala.wyX = (float) Fr.fAq;
                ala.npE = Fr.label;
                ala.wyY = Fr.nYL;
                aky.wyR = ala;
                aky.wyP = 2;
                break;
            case R.styleable.AppCompatTheme_actionButtonStyle /*49*/:
            case 268435505:
                com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(dI.field_content);
                if (fV != null) {
                    if (fV.type != 3) {
                        if (fV.type != 6) {
                            if (fV.type != 5) {
                                if (fV.type == 2) {
                                    akz akz2 = new akz();
                                    akz2.whT = "jpg";
                                    akz2.nkW = str2;
                                    akz2.kzt = i;
                                    akz2.wgP = str;
                                    aky.wyS = akz2;
                                    aky.wyP = 3;
                                    break;
                                }
                            }
                            alc alc = new alc();
                            alc.nlE = fV.url;
                            alc.fpg = fV.title;
                            alc.wyZ = fV.description;
                            alc.noG = fV.appName;
                            aky.wyU = alc;
                            aky.wyP = 5;
                            break;
                        }
                        akx akx = new akx();
                        akx.whT = fV.hcN;
                        akx.nkW = fV.title;
                        akx.kzt = i;
                        akx.wgP = str;
                        aky.wyT = akx;
                        aky.wyP = 4;
                        break;
                    }
                    alb alb = new alb();
                    alb.fpg = fV.title;
                    alb.wyZ = fV.description;
                    alb.nlE = fV.url;
                    alb.wza = fV.hcL;
                    alb.wdh = fV.hdd;
                    alb.wzb = fV.hde;
                    alb.noG = fV.appName;
                    alb.wzc = fV.hcU;
                    alb.wzd = fV.hcV;
                    alb.wze = fV.hdb;
                    aky.wyQ = alb;
                    aky.wyP = 1;
                    break;
                }
                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get content is null");
                return false;
                break;
            case 62:
                ald ald = new ald();
                ald.whT = str3;
                ald.kzt = i;
                ald.wgP = str;
                ald.nkW = str2;
                aky.wyV = ald;
                aky.wyP = 6;
                break;
        }
        return true;
    }

    static String x(String str, long j) {
        Throwable e;
        IOException e2;
        if (str == null) {
            return null;
        }
        String substring = str.substring(0, str.lastIndexOf("/"));
        substring = substring + "/" + ("image_hd_" + str.hashCode());
        OutputStream cVar;
        InputStream openRead;
        try {
            cVar = new com.tencent.mm.modelsfs.c(new File(substring), j);
            try {
                openRead = FileOp.openRead(str);
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (openRead.read(bArr) != -1) {
                        cVar.write(bArr);
                    }
                    try {
                        cVar.flush();
                        cVar.close();
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (Throwable e3) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e3, "", new Object[0]);
                                return null;
                            }
                        }
                        return substring;
                    } catch (Throwable e32) {
                        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e32, "", new Object[0]);
                        return null;
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    try {
                        x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "enc image error %s", e2.getMessage());
                        if (cVar != null) {
                            try {
                                cVar.flush();
                                cVar.close();
                            } catch (Throwable e322) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e322, "", new Object[0]);
                                return null;
                            }
                        }
                        if (openRead != null) {
                            return null;
                        }
                        try {
                            openRead.close();
                            return null;
                        } catch (Throwable e3222) {
                            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e3222, "", new Object[0]);
                            return null;
                        }
                    } catch (Throwable th) {
                        e3222 = th;
                        if (cVar != null) {
                            try {
                                cVar.flush();
                                cVar.close();
                            } catch (Throwable e32222) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e32222, "", new Object[0]);
                                return null;
                            }
                        }
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (Throwable e322222) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e322222, "", new Object[0]);
                                return null;
                            }
                        }
                        throw e322222;
                    }
                }
            } catch (IOException e5) {
                e2 = e5;
                openRead = null;
                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "enc image error %s", e2.getMessage());
                if (cVar != null) {
                    cVar.flush();
                    cVar.close();
                }
                if (openRead != null) {
                    return null;
                }
                openRead.close();
                return null;
            } catch (Throwable th2) {
                e322222 = th2;
                openRead = null;
                if (cVar != null) {
                    cVar.flush();
                    cVar.close();
                }
                if (openRead != null) {
                    openRead.close();
                }
                throw e322222;
            }
        } catch (IOException e6) {
            e2 = e6;
            openRead = null;
            cVar = null;
            x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "enc image error %s", e2.getMessage());
            if (cVar != null) {
                cVar.flush();
                cVar.close();
            }
            if (openRead != null) {
                return null;
            }
            openRead.close();
            return null;
        } catch (Throwable th3) {
            e322222 = th3;
            openRead = null;
            cVar = null;
            if (cVar != null) {
                cVar.flush();
                cVar.close();
            }
            if (openRead != null) {
                openRead.close();
            }
            throw e322222;
        }
    }

    private String ct(long j) {
        String str = "";
        as.Hm();
        cg dI = c.Fh().dI(j);
        if (dI.field_msgId == 0) {
            return "";
        }
        int type = dI.getType();
        String str2 = dI.field_content;
        if (dI.aNJ()) {
            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(str2);
            if (fV != null && (fV.type == 6 || fV.type == 2)) {
                com.tencent.mm.pluginsdk.model.app.b Se = an.aqK().Se(fV.for);
                if (Se != null) {
                    return Se.field_fileFullPath;
                }
                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getFilePath attInfo is null");
                return str;
            } else if (fV == null) {
                return str;
            } else {
                if (fV.type != 3 && fV.type != 5) {
                    return str;
                }
                this.lRF = true;
                return str;
            }
        } else if (type == 3) {
            com.tencent.mm.ap.e n = o.PC().n(dI);
            if (n == null) {
                return str;
            }
            str = o.PC().lp(n.hBB);
            if (bi.oN(str)) {
                return o.PC().lp(n.hBD);
            }
            return str;
        } else if (type == 62) {
            com.tencent.mm.modelvideo.o.Ub();
            return s.nx(dI.field_imgPath);
        } else if (type != 48) {
            return str;
        } else {
            this.lRF = true;
            return str;
        }
    }

    static void ct(String str, String str2) {
        com.tencent.mm.sdk.b.b ecVar = new ec();
        ecVar.ftD.ftF = str2;
        ecVar.ftD.ffG = str;
        com.tencent.mm.sdk.b.a.xmy.m(ecVar);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar == null) {
            x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "scene is null.");
        } else if (kVar instanceof n) {
            n nVar = (n) kVar;
            if (i == 0 && i2 == 0) {
                bpy bpy = (nVar.gLB == null || nVar.gLB.hnR.hnY == null) ? null : (bpy) nVar.gLB.hnR.hnY;
                String str2 = bpy.wYO;
                if (1 == nVar.lSN) {
                    ct(nVar.ffG, this.lRK);
                    return;
                }
                String str3 = nVar.ffG;
                String str4 = (String) this.lRU.get(str3);
                ct(str3, this.lRM);
                String ct = (!this.lRG || this.lRH == null) ? ct(this.gBK) : this.lRI;
                if (str4 == null || str4.length() == 0) {
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mDeviceInfo error");
                    ct(str3, this.lRL);
                    return;
                }
                if (!this.lRE) {
                    x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onItemClick stop scan...");
                    Java2CExDevice.stopScanWCLanDevice();
                    this.lRE = true;
                }
                if (!(this.lRW.containsKey(str3) && ((Boolean) this.lRW.get(str3)).booleanValue())) {
                    x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice mDeviceInfo: " + str4);
                    if (Java2CExDevice.connectWCLanDevice(str4.getBytes(), true) != 0) {
                        ct(str3, this.lRL);
                        x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice error!");
                    }
                }
                int useWCLanDeviceService;
                if (this.lRF) {
                    useWCLanDeviceService = Java2CExDevice.useWCLanDeviceService(str4.getBytes(), str2.getBytes());
                    if (useWCLanDeviceService != 0) {
                        this.lSg.put(Integer.valueOf(useWCLanDeviceService), str3);
                        this.lRV.put(str3, Integer.valueOf(useWCLanDeviceService));
                        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get useWCLanDeviceService mCallBackCmdId: " + useWCLanDeviceService);
                        return;
                    }
                    ct(str3, this.lRL);
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "useWCLanDeviceService error!");
                    return;
                } else if (ct == null || ct.length() == 0) {
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file path is error");
                    ct(str3, this.lRL);
                    return;
                } else {
                    useWCLanDeviceService = Java2CExDevice.sendFileToWCLanDevice(str4.getBytes(), str2.getBytes(), ct.getBytes());
                    if (useWCLanDeviceService != 0) {
                        this.lSg.put(Integer.valueOf(useWCLanDeviceService), str3);
                        this.lRV.put(str3, Integer.valueOf(useWCLanDeviceService));
                        x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get sendFileToWCLanDevice mCallBackCmdId =" + useWCLanDeviceService);
                        return;
                    }
                    ct(str3, this.lRL);
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sendFileToWCLanDevice error!");
                    return;
                }
            }
            x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "NetSceneGetAppMsgInfo onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i), Integer.valueOf(i2), str);
            ct(nVar.ffG, this.lRL);
        }
    }

    static String c(b bVar) {
        if (bVar == null) {
            return "";
        }
        String str = null;
        if (!bi.oN(bVar.ggL)) {
            str = bVar.ggL;
        } else if (!bi.oN(bVar.ggM)) {
            str = bVar.ggM;
        } else if (bVar.field_mac != 0) {
            str = com.tencent.mm.plugin.exdevice.j.b.cL(bVar.field_mac);
        } else if (!bi.oN(bVar.field_deviceID)) {
            str = bVar.field_deviceID;
        }
        return bi.oM(str);
    }
}
