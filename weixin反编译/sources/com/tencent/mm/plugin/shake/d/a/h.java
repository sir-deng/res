package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.c.alf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends b implements e {
    public static int qvR = 3;
    private float gAh = -85.0f;
    private float gAi = -1000.0f;
    private com.tencent.mm.modelgeo.a.a gAn = new com.tencent.mm.modelgeo.a.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return true;
            }
            h.this.gAh = f2;
            h.this.gAi = f;
            h.this.qev = (int) d2;
            return false;
        }
    };
    private c hry;
    private int qev = DownloadResult.CODE_UNDEFINED;
    private d qvM;
    public Collection<a> qvN = null;
    private int qvO = 10001;
    private int qvP = 10002;
    private int qvQ = 10003;

    public static final class a {
        public double hNI = 0.0d;
        public int major = 0;
        public int minor = 0;
        public String njL = null;
        public String qvT = "";
        public double qvU = 0.0d;
        public int qvV = 0;
    }

    public h(com.tencent.mm.plugin.shake.b.l.a aVar) {
        super(aVar);
    }

    public final void init() {
        as.CN().a(658, (e) this);
        brY();
    }

    public final void reset() {
        if (this.qvM != null) {
            as.CN().c(this.qvM);
        }
    }

    public final void start() {
        x.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:start");
        init();
        reset();
        if (this.hry == null) {
            brY();
        }
        this.hry.b(this.gAn, true);
        if (!(VERSION.RELEASE.equals("6.0") || VERSION.RELEASE.equals("6.0.0") || VERSION.SDK_INT < 23)) {
            boolean isProviderEnabled;
            LocationManager locationManager = (LocationManager) ad.getContext().getSystemService("location");
            if (locationManager != null) {
                isProviderEnabled = locationManager.isProviderEnabled("gps");
            } else {
                isProviderEnabled = true;
            }
            if (!isProviderEnabled) {
                new ag().postDelayed(new Runnable() {
                    public final void run() {
                        h.this.qtT.d(null, 8);
                    }
                }, 1000);
                return;
            }
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && defaultAdapter.getState() != 12) {
            new ag().postDelayed(new Runnable() {
                public final void run() {
                    h.this.qtT.d(null, 9);
                }
            }, 1000);
        } else if (defaultAdapter == null) {
            new ag().postDelayed(new Runnable() {
                public final void run() {
                    h.this.qtT.d(null, 10);
                }
            }, 1000);
        } else {
            int size;
            String str = "MicroMsg.ShakeIbeaconService";
            String str2 = "[oneliang][ShakeIbeaconService][shakezb]:beaconCollection.size:%d";
            Object[] objArr = new Object[1];
            if (this.qvN != null) {
                size = this.qvN.size();
            } else {
                size = 0;
            }
            objArr[0] = Integer.valueOf(size);
            x.i(str, str2, objArr);
            this.qvM = new d(this.qvN, this.gAh, this.gAi, this.qev);
            as.CN().a(this.qvM, 0);
        }
    }

    public final void pause() {
        if (this.hry != null) {
            this.hry.c(this.gAn);
        }
    }

    public final void resume() {
        if (this.hry != null) {
            this.hry.a(this.gAn, true);
        }
    }

    private void brY() {
        this.hry = c.OV();
        this.hry.a(this.gAn, true);
    }

    public final void brZ() {
        super.brZ();
        as.CN().b(658, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService]onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            d dVar = (d) kVar;
            if (658 == kVar.getType() && dVar.action == 1) {
                alf alf = (alf) dVar.hGV.hnR.hnY;
                if (alf.wzg.wcX == 0) {
                    x.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]onSceneEnd :message:%s,tips:%s,result:%s", alf.wzg.nlB, alf.wzg.pke, Integer.valueOf(alf.wzg.wcX));
                    try {
                        JSONObject jSONObject = new JSONObject(alf.wzg.nlB);
                        JSONArray jSONArray = jSONObject.getJSONArray("msgs");
                        JSONObject jSONObject2 = jSONObject.getJSONObject("guide_switch");
                        int i3 = jSONObject2.getInt("channel_open_method");
                        long j = jSONObject2.getLong("channel_open_time");
                        int i4 = jSONObject2.getInt("shake_tab_display");
                        int i5 = jSONObject.getJSONObject("gated_launch_option").getInt("tab_state");
                        as.Hm();
                        com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_CHANNEL_OPEN_METHOD_INT, Integer.valueOf(i3));
                        as.Hm();
                        com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_CHANNEL_OPEN_TIME_LONG, Long.valueOf(j));
                        as.Hm();
                        com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_SHAKE_TAB_DISPLAY_INT, Integer.valueOf(i4));
                        as.Hm();
                        com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(i5));
                        x.i("MicroMsg.ShakeIbeaconService", "[shakezb]channel_open_method is " + i3 + " ,channel_open_time is " + j + ", shake_tab_display is " + i4);
                        int length = jSONArray.length();
                        List list = null;
                        com.tencent.mm.plugin.shake.b.e bsm = m.bsm();
                        bsm.bse();
                        if (length > 0) {
                            list = new ArrayList();
                            for (i5 = 0; i5 < length; i5++) {
                                d dVar2 = new d();
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i5);
                                String string = jSONObject3.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                String string2 = jSONObject3.getString("content");
                                String string3 = jSONObject3.getString("title");
                                String string4 = jSONObject3.getString("picurl");
                                String string5 = jSONObject3.getString("shopid");
                                JSONObject jSONObject4 = jSONObject3.getJSONObject("beacon");
                                String string6 = jSONObject4.getString("uuid");
                                String string7 = jSONObject4.getString("major");
                                String string8 = jSONObject4.getString("minor");
                                int i6 = jSONObject3.getInt("guide_state");
                                String string9 = jSONObject3.getString("wxa_username");
                                String string10 = jSONObject3.getString("wxa_path");
                                int i7 = jSONObject3.getInt("wxa_version_type");
                                dVar2.field_type = 11;
                                dVar2.field_username = string3;
                                dVar2.field_nickname = string3;
                                dVar2.field_signature = string2;
                                dVar2.field_province = string4;
                                dVar2.field_city = string;
                                if (i6 == 1) {
                                    dVar2.field_sex = qvR;
                                }
                                dVar2.field_lvbuffer = (String.valueOf(string5) + "," + String.valueOf(string6) + "," + String.valueOf(string7) + "," + String.valueOf(string8)).getBytes(ProtocolPackage.ServerEncoding);
                                dVar2.field_insertBatch = 2;
                                dVar2.field_reserved3 = string9 + "," + string10 + "," + i7;
                                list.add(dVar2);
                                bsm.a(dVar2, true);
                                if (dVar2.field_sex == qvR && i3 == 1) {
                                    a(dVar2);
                                }
                            }
                        }
                        this.qtT.d(list, 1);
                        return;
                    } catch (Exception e) {
                        x.e("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb] parse error.%s", bi.oM(e.getMessage()));
                        this.qtT.d(null, 1);
                        return;
                    }
                } else if (alf.wzg.wcX == this.qvO) {
                    this.qtT.d(null, 6);
                    return;
                } else if (alf.wzg.wcX == this.qvP) {
                    this.qtT.d(null, 7);
                    return;
                } else if (alf.wzg.wcX == this.qvQ) {
                    this.qtT.d(null, 8);
                    return;
                } else {
                    this.qtT.d(null, 1);
                    return;
                }
            }
            return;
        }
        this.qtT.d(null, 3);
    }

    public static void a(d dVar) {
        if (dVar != null && dVar.field_sex == qvR) {
            String str;
            as.Hm();
            com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.valueOf(true));
            long Wx = bi.Wx();
            as.Hm();
            com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_OPEN_TIEMSTAMP_LONG, Long.valueOf(Wx));
            try {
                str = new String(dVar.field_lvbuffer, ProtocolPackage.ServerEncoding);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ShakeIbeaconService", e, "%s", "Unsupported");
                str = null;
            }
            if (str != null) {
                String[] split = str.split(",");
                if (split.length == 4) {
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_SHOP_ID_LONG, Long.valueOf(split[0]));
                }
            }
        }
    }

    public static void b(d dVar) {
        if (dVar != null) {
            String str;
            try {
                str = new String(dVar.field_lvbuffer, ProtocolPackage.ServerEncoding);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ShakeIbeaconService", e, "%s", "Unsupported");
                str = null;
            }
            if (str != null) {
                String[] split = str.split(",");
                if (split.length == 4) {
                    String str2 = split[1];
                    String str3 = split[2];
                    str = split[3];
                    a aVar = new a();
                    aVar.njL = str2;
                    aVar.major = bi.getInt(str3, 0);
                    aVar.minor = bi.getInt(str, 0);
                }
            }
        }
    }
}
