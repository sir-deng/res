package com.tencent.mm.plugin.exdevice.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Parcelable;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.f.a.dm;
import com.tencent.mm.f.a.dn;
import com.tencent.mm.f.a.do;
import com.tencent.mm.f.a.dp;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import org.json.JSONObject;

public final class ExdeviceWCLanSDKUtil {
    BroadcastReceiver jle;
    HashMap<String, byte[]> lRU;
    HashMap<String, Boolean> lRW;
    a lRX;
    a lRZ;
    private int lSn;
    private int lSo;
    a lSp;
    a lSq;
    HashMap<String, String> lSr;
    boolean lSs;
    boolean lSt;
    boolean lSu;
    int lSv;
    Context mContext;

    public class LanStateChangeReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
                Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                if (parcelableExtra != null) {
                    boolean z = ((NetworkInfo) parcelableExtra).getState() == State.CONNECTED;
                    x.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "isConnected =" + z);
                    if (ExdeviceWCLanSDKUtil.this.lSt || ExdeviceWCLanSDKUtil.this.lSs != z) {
                        b dpVar = new dp();
                        dpVar.ftf.ftg = z;
                        com.tencent.mm.sdk.b.a.xmy.m(dpVar);
                        ExdeviceWCLanSDKUtil.this.lSt = false;
                        ExdeviceWCLanSDKUtil.this.lSs = z;
                    }
                }
            }
        }
    }

    public ExdeviceWCLanSDKUtil() {
        this.lSn = 0;
        this.lSo = 0;
        this.lRU = new HashMap();
        this.lRW = new HashMap();
        this.lSr = new HashMap();
        this.mContext = null;
        this.lSs = false;
        this.lSt = false;
        this.lSu = false;
        this.lSs = true;
        this.lSt = true;
        this.lRU.clear();
        this.lRW.clear();
        this.lSr.clear();
        this.mContext = ad.getContext();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        if (this.jle == null) {
            this.jle = new LanStateChangeReceiver();
        }
        this.mContext.registerReceiver(this.jle, intentFilter);
        this.lSp = new a() {
            public final void e(int i, Object... objArr) {
                String string;
                Throwable e;
                String str = null;
                if (i == 10 && objArr != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(new String((byte[]) objArr[0]));
                        JSONObject jSONObject2 = jSONObject.getJSONObject("deviceInfo");
                        string = jSONObject2.getString("deviceType");
                        try {
                            str = jSONObject2.getString("deviceId");
                            if (!jSONObject.isNull("manufacturerData")) {
                                ExdeviceWCLanSDKUtil.this.lSr.put(str, jSONObject.getString("manufacturerData"));
                            }
                            b doVar = new do();
                            doVar.ftd.ffG = str;
                            if (ExdeviceWCLanSDKUtil.this.lSr.containsKey(str)) {
                                String str2 = (String) ExdeviceWCLanSDKUtil.this.lSr.get(str);
                                if (!bi.oN(str2)) {
                                    doVar.ftd.fte = str2.getBytes();
                                }
                                ExdeviceWCLanSDKUtil.this.lSr.remove(str);
                            }
                            doVar.ftd.aow = false;
                            com.tencent.mm.sdk.b.a.xmy.m(doVar);
                        } catch (Exception e2) {
                            e = e2;
                            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                            x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "json decode failed in disc package callback!");
                            if (string != null) {
                            }
                            x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanDeviceDiscPackageCallbackReceiver! ");
                        }
                    } catch (Exception e3) {
                        e = e3;
                        string = null;
                    }
                    if (string != null || str == null) {
                        x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanDeviceDiscPackageCallbackReceiver! ");
                    }
                }
            }
        };
        this.lRX = new a() {
            public final void e(int i, Object... objArr) {
                String string;
                Exception e;
                String str = null;
                if (i == 14 && objArr != null && objArr.length > 0 && (objArr[0] instanceof byte[])) {
                    JSONObject jSONObject;
                    try {
                        jSONObject = new JSONObject(new String((byte[]) objArr[0])).getJSONObject("deviceInfo");
                        try {
                            string = jSONObject.getString("deviceType");
                            try {
                                str = jSONObject.getString("deviceId");
                            } catch (Exception e2) {
                                e = e2;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            string = str;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        jSONObject = str;
                        string = str;
                    }
                    if (string != null || str == null) {
                        x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanGetDeviceProfileCallbackReceiver! ");
                    }
                    x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get device deviceType =" + string + ",deviceId = " + str);
                    if (ad.aER().zM(str) == null) {
                        x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "hdInfo null, %s", str);
                        return;
                    }
                    ExdeviceWCLanSDKUtil.this.lRU.put(str, jSONObject.toString().getBytes());
                    b doVar = new do();
                    doVar.ftd.ffG = str;
                    if (ExdeviceWCLanSDKUtil.this.lSr.containsKey(str)) {
                        String str2 = (String) ExdeviceWCLanSDKUtil.this.lSr.get(str);
                        if (!bi.oN(str2)) {
                            doVar.ftd.fte = str2.getBytes();
                        }
                        ExdeviceWCLanSDKUtil.this.lSr.remove(str);
                    }
                    doVar.ftd.aow = false;
                    com.tencent.mm.sdk.b.a.xmy.m(doVar);
                    return;
                }
                return;
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in get device profile callback %s", e);
                if (string != null) {
                }
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanGetDeviceProfileCallbackReceiver! ");
            }
        };
        this.lRZ = new a() {
            public final void e(int i, Object... objArr) {
                int intValue;
                String string;
                Throwable e;
                b dmVar;
                String str = null;
                if (i == 13 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof String) && (objArr[1] instanceof Integer)) {
                    String str2 = (String) objArr[0];
                    intValue = ((Integer) objArr[1]).intValue();
                    try {
                        JSONObject jSONObject = new JSONObject(new String(str2));
                        string = jSONObject.getString("deviceId");
                        try {
                            str = jSONObject.getString("deviceType");
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        string = str;
                    }
                    switch (intValue) {
                        case 1:
                            ExdeviceWCLanSDKUtil.this.lSv = 2;
                            ExdeviceWCLanSDKUtil.this.lRW.put(string, Boolean.valueOf(true));
                            x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device connect!");
                            break;
                        default:
                            ExdeviceWCLanSDKUtil.this.lSv = 0;
                            ExdeviceWCLanSDKUtil.this.lRW.put(string, Boolean.valueOf(false));
                            x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device disconnect!");
                            break;
                    }
                    if (ExdeviceWCLanSDKUtil.this.lSu) {
                        if (ExdeviceWCLanSDKUtil.this.lSv == 2) {
                            ExdeviceWCLanSDKUtil.this.f(true, string);
                        }
                        dmVar = new dm();
                        dmVar.fta.ffG = string;
                        dmVar.fta.ftb = ExdeviceWCLanSDKUtil.this.lSv;
                        dmVar.fta.fsi = str;
                        com.tencent.mm.sdk.b.a.xmy.m(dmVar);
                    }
                }
                return;
                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in device ConnState notify callback");
                switch (intValue) {
                    case 1:
                        ExdeviceWCLanSDKUtil.this.lSv = 2;
                        ExdeviceWCLanSDKUtil.this.lRW.put(string, Boolean.valueOf(true));
                        x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device connect!");
                        break;
                    default:
                        ExdeviceWCLanSDKUtil.this.lSv = 0;
                        ExdeviceWCLanSDKUtil.this.lRW.put(string, Boolean.valueOf(false));
                        x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device disconnect!");
                        break;
                }
                if (ExdeviceWCLanSDKUtil.this.lSu) {
                    if (ExdeviceWCLanSDKUtil.this.lSv == 2) {
                        ExdeviceWCLanSDKUtil.this.f(true, string);
                    }
                    dmVar = new dm();
                    dmVar.fta.ffG = string;
                    dmVar.fta.ftb = ExdeviceWCLanSDKUtil.this.lSv;
                    dmVar.fta.fsi = str;
                    com.tencent.mm.sdk.b.a.xmy.m(dmVar);
                }
            }
        };
        this.lSq = new a() {
            public final void e(int i, Object... objArr) {
                String string;
                String str;
                Throwable th;
                b dnVar;
                if (i == 16 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof String) && (objArr[1] instanceof byte[])) {
                    byte[] bArr = (byte[]) objArr[1];
                    try {
                        JSONObject jSONObject = new JSONObject(new String((String) objArr[0]));
                        String string2 = jSONObject.getString("deviceType");
                        try {
                            string = jSONObject.getString("deviceId");
                            str = string2;
                        } catch (Throwable e) {
                            Throwable th2 = e;
                            string = string2;
                            th = th2;
                            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", th, "", new Object[0]);
                            x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in receive notify callback");
                            str = string;
                            string = null;
                            x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "receive data = " + new String(bArr));
                            dnVar = new dn();
                            dnVar.ftc.ffG = string;
                            dnVar.ftc.data = bArr;
                            dnVar.ftc.fsi = str;
                            com.tencent.mm.sdk.b.a.xmy.m(dnVar);
                        }
                    } catch (Throwable e2) {
                        th = e2;
                        string = null;
                    }
                    x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "receive data = " + new String(bArr));
                    dnVar = new dn();
                    dnVar.ftc.ffG = string;
                    dnVar.ftc.data = bArr;
                    dnVar.ftc.fsi = str;
                    com.tencent.mm.sdk.b.a.xmy.m(dnVar);
                }
            }
        };
    }

    public final boolean f(boolean z, String str) {
        if (str == null || !this.lRU.containsKey(str)) {
            x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in openOrCloseDevice");
            return false;
        }
        byte[] bArr = (byte[]) this.lRU.get(str);
        try {
            JSONObject jSONObject = new JSONObject();
            if (z) {
                x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "open device!");
                jSONObject.put("cmd", "open");
            } else {
                x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "close device!");
                jSONObject.put("cmd", "close");
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("wxmsg_jsapi", jSONObject);
            jSONObject = new JSONObject();
            jSONObject.put("services", jSONObject2);
            this.lSo = Java2CExDevice.useWCLanDeviceService(bArr, jSONObject.toString().getBytes());
            if (this.lSo != 0) {
                x.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get openOrCloseDevice mCallBackCmdId =" + this.lSo);
            } else {
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "openOrCloseDevice error!");
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
            x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON encode failed in openOrCloseDevice");
            return false;
        }
    }

    public final boolean ae(String str, boolean z) {
        if (str == null || !this.lRU.containsKey(str)) {
            x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in connectWCLanDevice");
            return false;
        }
        byte[] bArr = (byte[]) this.lRU.get(str);
        this.lSu = true;
        if (z) {
            try {
                String string = new JSONObject(new String(bArr)).getString("deviceType");
                x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "connectWCLanDevice deviceId: " + str);
                if (Java2CExDevice.connectWCLanDevice(bArr, false) != 0) {
                    x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "connectWCLanDevice error!");
                    return false;
                }
                b dmVar = new dm();
                dmVar.fta.ffG = str;
                dmVar.fta.ftb = 1;
                dmVar.fta.fsi = string;
                com.tencent.mm.sdk.b.a.xmy.m(dmVar);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in connectWCLanDevice!");
                return false;
            }
        }
        f(false, str);
        x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "disconnectWCLanDevice...");
        Java2CExDevice.disconnectWCLanDevice(bArr);
        return true;
    }

    public final boolean cu(String str, String str2) {
        if (!zz(str)) {
            x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceId " + str + " not connected!");
            return false;
        } else if (str == null || !this.lRU.containsKey(str)) {
            x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in useWCLanDeviceService");
            return false;
        } else {
            byte[] bArr = (byte[]) this.lRU.get(str);
            this.lSn = 0;
            try {
                boolean z;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, str2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("wxmsg_jsapi", jSONObject);
                jSONObject = new JSONObject();
                jSONObject.put("services", jSONObject2);
                this.lSn = Java2CExDevice.useWCLanDeviceService(bArr, jSONObject.toString().getBytes());
                if (this.lSn != 0) {
                    z = true;
                    x.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get useWCLanDeviceService mCallBackCmdId =" + this.lSn);
                } else {
                    x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "useWCLanDeviceService error!");
                    z = false;
                }
                return z;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON encode failed in useWCLanDeviceService");
                return false;
            }
        }
    }

    public final boolean zz(String str) {
        if (str == null || !this.lRW.containsKey(str)) {
            return false;
        }
        return ((Boolean) this.lRW.get(str)).booleanValue();
    }
}
