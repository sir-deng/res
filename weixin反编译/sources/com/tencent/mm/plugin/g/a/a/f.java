package com.tencent.mm.plugin.g.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.r;
import com.tencent.mm.plugin.exdevice.service.v;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public final class f implements LeScanCallback, r, b {
    private static boolean kBN = false;
    public static boolean kBP = false;
    private final b kBI;
    private final d kBL;
    private final HashSet<UUID> kBM;
    private boolean kBO = false;
    private BluetoothAdapter kBQ;
    private boolean kBR = true;
    private int kBS = 0;
    private String kBT = "";
    private e kBU = null;
    private Map<String, Long> kBV = new ConcurrentHashMap();
    private final al kBW = new al(v.aFu().hPO.oFY.getLooper(), new a() {
        public final boolean uG() {
            f.this.mHandler.post(new Runnable() {
                public final void run() {
                    f.this.kBL.a(f.this.kBS, f.this.kBT, f.this.kBU);
                }
            });
            return false;
        }
    }, true);
    private final al kBX = new al(v.aFu().hPO.oFY.getLooper(), new a() {
        public final boolean uG() {
            if (f.this.kBM.size() > 0) {
                x.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now start");
                if (f.g(f.this).booleanValue()) {
                    x.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan ok");
                } else {
                    x.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan fail");
                }
                f.kBP = ad.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false);
                if (!f.kBP) {
                    if (!f.this.kBY.cgx()) {
                        f.this.kBY.TN();
                    }
                    if (!f.this.kBX.cgx()) {
                        f.this.kBX.TN();
                    }
                }
            }
            return false;
        }
    }, true);
    private final al kBY = new al(v.aFu().hPO.oFY.getLooper(), new a() {
        public final boolean uG() {
            if (f.this.kBM.size() <= 0) {
                return false;
            }
            x.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now stop");
            f.j(f.this);
            if (f.this.kBX.cgx()) {
                f.this.kBX.K(2000, 2000);
            }
            return true;
        }
    }, true);
    private final al kBZ = new al(v.aFu().hPO.oFY.getLooper(), new a() {
        public final boolean uG() {
            x.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]make isScanning status false");
            f.kBN = false;
            return false;
        }
    }, true);
    private final al kCa = new al(v.aFu().hPO.oFY.getLooper(), new a() {
        public final boolean uG() {
            x.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]time out ,let's stop this new method scan");
            f.this.arM();
            return false;
        }
    }, true);
    public final ag mHandler;

    /* renamed from: com.tencent.mm.plugin.g.a.a.f$6 */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ UUID kCd;

        public AnonymousClass6(UUID uuid) {
            this.kCd = uuid;
        }

        public final void run() {
            if (!f.a(f.this, this.kCd)) {
                x.e("MicroMsg.exdevice.IBeaconServer", "startRanging failed!!!");
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.g.a.a.f$7 */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ UUID kCd;

        public AnonymousClass7(UUID uuid) {
            this.kCd = uuid;
        }

        public final void run() {
            if (!f.b(f.this, this.kCd)) {
                x.e("MicroMsg.exdevice.IBeaconServer", "stopRanging failed!!!");
            }
        }
    }

    static /* synthetic */ boolean a(f fVar, UUID uuid) {
        x.i("MicroMsg.exdevice.IBeaconServer", "startRanging");
        if (uuid == null) {
            x.e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
            return false;
        }
        if (!fVar.kBM.contains(uuid)) {
            fVar.kBM.add(uuid);
        }
        fVar.arN();
        return true;
    }

    static /* synthetic */ boolean b(f fVar, UUID uuid) {
        x.i("MicroMsg.exdevice.IBeaconServer", "stopRanging");
        if (uuid == null) {
            x.e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
            return false;
        }
        fVar.kBM.remove(uuid);
        fVar.arM();
        return true;
    }

    static /* synthetic */ Boolean g(f fVar) {
        return fVar.kBQ != null ? Boolean.valueOf(fVar.kBQ.startLeScan(fVar)) : Boolean.valueOf(false);
    }

    static /* synthetic */ void j(f fVar) {
        if (fVar.kBQ != null) {
            fVar.kBQ.stopLeScan(fVar);
        }
    }

    public f(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("aCallback is null");
        }
        this.kBM = new HashSet();
        this.kBL = new d(this);
        this.kBI = bVar;
        this.mHandler = new ag(v.aFu().hPO.oFY.getLooper());
        this.kBQ = ((BluetoothManager) ad.getContext().getSystemService("bluetooth")).getAdapter();
    }

    private void arM() {
        this.kBV.clear();
        kBN = false;
        if (!this.kBZ.cgx()) {
            this.kBZ.TN();
        }
        if (!this.kBY.cgx()) {
            this.kBY.TN();
        }
        if (!this.kBX.cgx()) {
            this.kBX.TN();
        }
        if (!this.kBW.cgx()) {
            this.kBW.TN();
        }
        if (!this.kCa.cgx()) {
            this.kCa.TN();
        }
        if (this.kBO && this.kBQ != null) {
            this.kBQ.stopLeScan(this);
            this.kBO = false;
        }
    }

    private synchronized void arN() {
        if (this.kBZ.cgx()) {
            this.kBZ.K(2000, 2000);
        }
        if (kBP && this.kBY.cgx()) {
            this.kBY.K(10000, 10000);
        }
        if (this.kCa.cgx()) {
            if (kBP) {
                this.kCa.K(1800000, 1800000);
            } else {
                this.kCa.K(120000, 120000);
            }
        }
        if (!kBN) {
            this.kBR = true;
            Boolean valueOf = Boolean.valueOf(this.kBQ.startLeScan(this));
            if (valueOf.booleanValue() || kBN) {
                this.kBO = true;
                kBN = true;
                x.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
            } else {
                int i = 0;
                while (!valueOf.booleanValue() && i < 3 && !kBN) {
                    i++;
                    this.kBQ.stopLeScan(this);
                    x.e("MicroMsg.exdevice.IBeaconServer", "start IBEACON BLE scan failed,retry no " + i + " time");
                    valueOf = Boolean.valueOf(this.kBQ.startLeScan(this));
                    if (valueOf.booleanValue()) {
                        kBN = true;
                        this.kBO = true;
                        x.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
                    }
                }
            }
        }
    }

    public final void a(double d, c cVar) {
        x.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback, distance = %f", Double.valueOf(d));
        String ar = b.ar(cVar.kBG.kBK.kCl);
        if (ar.length() >= 32) {
            ar = ar.substring(0, 8) + "-" + ar.substring(8, 12) + "-" + ar.substring(12, 16) + "-" + ar.substring(16, 20) + "-" + ar.substring(20);
        }
        String str = ar + cVar.kBG.kBK.kCm + cVar.kBG.kBK.kCn;
        if (this.kBV.containsKey(str)) {
            long longValue = ((Long) this.kBV.get(str)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 500) {
                this.kBV.put(str, Long.valueOf(currentTimeMillis));
                this.kBI.a(d, cVar);
                return;
            }
            return;
        }
        this.kBV.put(str, Long.valueOf(System.currentTimeMillis()));
        this.kBI.a(d, cVar);
        x.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback,uuid = " + ar + ",major = " + cVar.kBG.kBK.kCm + ",minor = " + (cVar.kBG.kBK.kCn & 65535));
    }

    public final void nv(int i) {
        if (i == 0) {
            arM();
        }
    }

    public final void a(final String str, String str2, int i, final int i2, byte[] bArr) {
        x.d("MicroMsg.exdevice.IBeaconServer", "onScanFound, device mac = %s, device name = %s, bluetooth version = %d, rssi = %d, advertisment = %s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), b.ar(bArr));
        if (i == 0) {
            final e eVar = new e();
            if (eVar.ad(bArr)) {
                UUID at = b.at(eVar.kBK.kCl);
                if (at == null) {
                    x.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
                    return;
                } else if (this.kBM.contains(at)) {
                    if (this.kBR) {
                        this.kBT = str;
                    }
                    this.mHandler.post(new Runnable() {
                        public final void run() {
                            f.this.kBL.a(i2, str, eVar);
                        }
                    });
                    return;
                } else {
                    x.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
                    return;
                }
            }
            x.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
        }
    }

    public final void ws(String str) {
        x.e("MicroMsg.exdevice.IBeaconServer", "------onScanError------ error code = %s, error msg = %s", Integer.valueOf(-1), str);
    }

    public final void onLeScan(final BluetoothDevice bluetoothDevice, final int i, byte[] bArr) {
        final e eVar = new e();
        if (eVar.ad(bArr)) {
            UUID at = b.at(eVar.kBK.kCl);
            if (at == null) {
                x.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
                return;
            } else if (this.kBM.contains(at)) {
                if (this.kBR) {
                    this.kBS = i;
                    this.kBU = eVar;
                    if (this.kBW.cgx()) {
                        this.kBW.K(2000, 2000);
                    }
                    this.kBR = false;
                }
                this.mHandler.post(new Runnable() {
                    public final void run() {
                        f.this.kBL.a(i, bluetoothDevice.getAddress(), eVar);
                    }
                });
                return;
            } else {
                x.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
                return;
            }
        }
        x.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
    }
}
