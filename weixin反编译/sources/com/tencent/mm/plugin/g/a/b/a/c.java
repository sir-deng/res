package com.tencent.mm.plugin.g.a.b.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.g.a.b.a.g.a;
import com.tencent.mm.plugin.g.a.b.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@TargetApi(18)
public class c {
    public static final String TAG = c.class.getName();
    private static HashMap<String, Long> kDu = new HashMap();
    private static HashMap<String, Long> kEF;

    static {
        HashMap hashMap = new HashMap();
        kEF = hashMap;
        hashMap.put(h.kDK, Long.valueOf(1));
        kEF.put(h.kDL, Long.valueOf(1));
        kEF.put(h.kDM, Long.valueOf(16));
        kEF.put(h.kDN, Long.valueOf(16));
        kEF.put(h.kDO, Long.valueOf(16));
        kEF.put(h.kDP, Long.valueOf(16));
        kDu.put(h.kDH, Long.valueOf(0));
        kDu.put(h.kDQ, Long.valueOf(2));
        kDu.put(h.kDT, Long.valueOf(4));
        kDu.put(h.kDX, Long.valueOf(8));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean ag(byte[] r12) {
        /*
        r11 = 16;
        r10 = 2;
        r1 = 1;
        r0 = 0;
        r2 = com.tencent.mm.sdk.platformtools.bi.by(r12);
        if (r2 == 0) goto L_0x0014;
    L_0x000b:
        r1 = TAG;
        r2 = "parseBroadcastServiceUuid error. broadcast data is null or nil";
        com.tencent.mm.sdk.platformtools.x.e(r1, r2);
    L_0x0013:
        return r0;
    L_0x0014:
        r2 = r0;
    L_0x0015:
        if (r2 < 0) goto L_0x0013;
    L_0x0017:
        r3 = r12.length;
        if (r2 >= r3) goto L_0x0013;
    L_0x001a:
        r4 = r2 + 1;
        r2 = r12[r2];
        r3 = r4 + r2;
        r5 = r12.length;
        if (r3 <= r5) goto L_0x0042;
    L_0x0023:
        r3 = TAG;
        r5 = "broadcast data len is not enough. offset = %d, current len = %d, broadcast len = %d";
        r6 = 3;
        r6 = new java.lang.Object[r6];
        r4 = java.lang.Integer.valueOf(r4);
        r6[r0] = r4;
        r2 = java.lang.Integer.valueOf(r2);
        r6[r1] = r2;
        r1 = r12.length;
        r1 = java.lang.Integer.valueOf(r1);
        r6[r10] = r1;
        com.tencent.mm.sdk.platformtools.x.w(r3, r5, r6);
        goto L_0x0013;
    L_0x0042:
        if (r2 > 0) goto L_0x0055;
    L_0x0044:
        r3 = TAG;
        r4 = "current part of data's len = %d.";
        r1 = new java.lang.Object[r1];
        r2 = java.lang.Integer.valueOf(r2);
        r1[r0] = r2;
        com.tencent.mm.sdk.platformtools.x.w(r3, r4, r1);
        goto L_0x0013;
    L_0x0055:
        r3 = r4 + 1;
        r4 = r12[r4];
        r2 = r2 + -1;
        switch(r4) {
            case -1: goto L_0x00f0;
            case 0: goto L_0x005e;
            case 1: goto L_0x005e;
            case 2: goto L_0x0060;
            case 3: goto L_0x0060;
            case 4: goto L_0x005e;
            case 5: goto L_0x005e;
            case 6: goto L_0x0118;
            case 7: goto L_0x0118;
            default: goto L_0x005e;
        };
    L_0x005e:
        r2 = r2 + r3;
        goto L_0x0015;
    L_0x0060:
        if (r10 > r2) goto L_0x0099;
    L_0x0062:
        r4 = r3 + 1;
        r3 = r12[r3];
        r5 = r3 & 255;
        r3 = r4 + 1;
        r4 = r12[r4];
        r4 = r4 & 255;
        r4 = r4 << 8;
        r4 = r4 | r5;
        r2 = r2 + -2;
        r5 = "%08x-0000-1000-8000-00805f9b34fb";
        r6 = new java.lang.Object[r1];
        r4 = java.lang.Integer.valueOf(r4);
        r6[r0] = r4;
        r4 = java.lang.String.format(r5, r6);
        r5 = TAG;
        r6 = "find 16-bit broacast service = %s";
        r7 = new java.lang.Object[r1];
        r7[r0] = r4;
        com.tencent.mm.sdk.platformtools.x.d(r5, r6, r7);
        r5 = kDu;
        r4 = r5.containsKey(r4);
        if (r4 == 0) goto L_0x0060;
    L_0x0096:
        r0 = r1;
        goto L_0x0013;
    L_0x0099:
        r2 = r2 + r3;
        goto L_0x0015;
    L_0x009c:
        r4 = r4 + 16;
        r2 = r3 + -16;
        r3 = r2;
    L_0x00a1:
        if (r11 > r3) goto L_0x00ec;
    L_0x00a3:
        r2 = 16;
        r2 = java.nio.ByteBuffer.wrap(r12, r4, r2);	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r5 = java.nio.ByteOrder.LITTLE_ENDIAN;	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r2 = r2.order(r5);	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r6 = r2.getLong();	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r8 = r2.getLong();	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r2 = new java.util.UUID;	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r2.<init>(r8, r6);	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r2 = r2.toString();	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r5 = TAG;	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r6 = "find 128-bit broacast service = %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r8 = 0;
        r7[r8] = r2;	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        com.tencent.mm.sdk.platformtools.x.d(r5, r6, r7);	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r5 = kDu;	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r2 = r5.containsKey(r2);	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        if (r2 == 0) goto L_0x009c;
    L_0x00d6:
        r0 = r1;
        goto L_0x0013;
    L_0x00d9:
        r2 = move-exception;
        r5 = "BlueToothDeviceFilter.parseUUID";
        r2 = r2.toString();	 Catch:{ all -> 0x00ea }
        com.tencent.mm.sdk.platformtools.x.e(r5, r2);	 Catch:{ all -> 0x00ea }
        r4 = r4 + 16;
        r2 = r3 + -16;
        r3 = r2;
        goto L_0x00a1;
    L_0x00ea:
        r0 = move-exception;
        throw r0;
    L_0x00ec:
        r2 = r4 + r3;
        goto L_0x0015;
    L_0x00f0:
        r4 = TAG;
        r5 = "Manufacturer Specific Data size = %s";
        r6 = new java.lang.Object[r1];
        r7 = java.lang.Integer.valueOf(r2);
        r6[r0] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        r4 = TAG;
        r5 = "Manufacturer Specific Data = %s";
        r6 = new java.lang.Object[r1];
        r7 = r3 + r2;
        r7 = java.util.Arrays.copyOfRange(r12, r3, r7);
        r7 = com.tencent.mm.plugin.exdevice.j.b.ar(r7);
        r6[r0] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        goto L_0x005e;
    L_0x0118:
        r4 = r3;
        r3 = r2;
        goto L_0x00a1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.g.a.b.a.c.ag(byte[]):boolean");
    }

    public static String bL(long j) {
        for (String str : kDu.keySet()) {
            if (((Long) kDu.get(str)).longValue() == j) {
                return str;
            }
        }
        if (kEF.containsValue(Long.valueOf(j))) {
            return h.kDH;
        }
        return null;
    }

    public static long a(BluetoothGattService bluetoothGattService) {
        long j = 0;
        if (bluetoothGattService == null) {
            x.e(TAG, "service is null");
            return 0;
        }
        String uuid = bluetoothGattService.getUuid().toString();
        Long l;
        if (!uuid.equalsIgnoreCase(h.kDH) || bluetoothGattService.getCharacteristic(UUID.fromString(h.kDK)) == null) {
            l = (Long) kDu.get(uuid);
            if (l != null) {
                j = l.longValue();
            }
            x.d(TAG, "service uuid = %s, profileType = %d", uuid, Long.valueOf(j));
            return j;
        }
        List characteristics = bluetoothGattService.getCharacteristics();
        long j2 = 0;
        int i = 0;
        while (i < characteristics.size()) {
            l = (Long) kEF.get(((BluetoothGattCharacteristic) characteristics.get(i)).getUuid().toString());
            i++;
            j2 = (l == null ? 0 : l.longValue()) | j2;
        }
        x.d(TAG, "wechat service, profileType = %d", Long.valueOf(j2));
        return j2;
    }

    public static boolean b(BluetoothGattService bluetoothGattService) {
        if (bluetoothGattService == null) {
            x.e(TAG, "service is null");
            return false;
        }
        long a = a(bluetoothGattService);
        BluetoothGattCharacteristic characteristic;
        int properties;
        if (0 != (1 & a)) {
            if (bluetoothGattService == null) {
                x.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kDK));
            if (characteristic == null) {
                x.e(TAG, "no step measurement characteristic found");
                return false;
            }
            properties = characteristic.getProperties();
            x.d(TAG, "step measurement characteristic properties = %d", Integer.valueOf(properties));
            if ((properties & 48) == 0 || (properties & 2) == 0) {
                x.e(TAG, "step measurement characteristic has incorrect proterties(%d)", Integer.valueOf(properties));
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kDL));
            if (characteristic != null) {
                properties = characteristic.getProperties();
                if ((properties & 2) == 0 || (properties & 32) == 0) {
                    x.e(TAG, "step target characteristic has incorrect proterties(%d)", Integer.valueOf(properties));
                    return false;
                }
            }
            return true;
        } else if (0 != (2 & a)) {
            if (bluetoothGattService == null) {
                x.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kDR));
            if (characteristic == null) {
                x.e(TAG, "weight scale feature characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 2) == 0) {
                x.e(TAG, "weight scale feature characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(2));
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kDS));
            if (characteristic == null) {
                x.e(TAG, "weight measurement characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 32) != 0) {
                return true;
            }
            x.e(TAG, "weight measurement characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(32));
            return false;
        } else if (0 != (4 & a)) {
            if (bluetoothGattService == null) {
                x.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kDU));
            if (characteristic == null) {
                x.e(TAG, "heart rate measurement characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 16) == 0) {
                x.e(TAG, "heart rate measurement characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(16));
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kDV));
            if (characteristic != null) {
                if ((characteristic.getProperties() & 2) == 0) {
                    x.e(TAG, "heart rate body sensor location characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(2));
                    return false;
                }
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kDW));
            if (characteristic != null) {
                if ((characteristic.getProperties() & 8) == 0) {
                    x.e(TAG, "heart rate control point characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(8));
                    return false;
                }
            }
            return true;
        } else if (0 != (8 & a)) {
            if (bluetoothGattService == null) {
                x.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kDY));
            if (characteristic == null) {
                x.e(TAG, "blood pressure measurement characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 32) == 0) {
                x.e(TAG, "blood pressure measurement characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(32));
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kEa));
            if (characteristic == null) {
                x.e(TAG, "blood pressure feature characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 2) == 0) {
                x.e(TAG, "blood pressure feature characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(2));
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kDZ));
            if (characteristic != null) {
                if ((characteristic.getProperties() & 16) == 0) {
                    x.e(TAG, "blood pressure intermediate cuff pressure characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(16));
                    return false;
                }
            }
            return true;
        } else if (0 == (a & 16)) {
            return false;
        } else {
            if (bluetoothGattService == null) {
                x.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kDM));
            if (characteristic == null) {
                x.e(TAG, "light color characteristic not found");
                return false;
            }
            properties = characteristic.getProperties();
            if ((properties & 32) == 0 || (properties & 16) == 0 || (properties & 2) == 0 || (properties & 8) == 0) {
                x.e(TAG, "light color characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(properties), Integer.valueOf(32));
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kDN));
            if (characteristic == null) {
                x.e(TAG, "light work state characteristic not found");
                return false;
            }
            properties = characteristic.getProperties();
            if ((properties & 32) == 0 || (properties & 2) == 0 || (properties & 8) == 0) {
                x.e(TAG, "light work state characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(properties), Integer.valueOf(32));
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kDO));
            if (characteristic == null) {
                x.e(TAG, "light state changed characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 32) == 0) {
                x.e(TAG, "light state changed characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(32));
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kDP));
            if (characteristic == null) {
                x.e(TAG, "control point characteristic not found");
                return false;
            }
            properties = characteristic.getProperties();
            if ((properties & 32) != 0 && (properties & 8) != 0) {
                return true;
            }
            x.e(TAG, "control point characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(properties), Integer.valueOf(32));
            return false;
        }
    }

    public static byte[] a(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        boolean z = false;
        if (bluetoothGattCharacteristic == null || bArr == null) {
            x.e(TAG, "characteristic or recvData is null");
            return null;
        }
        long j = 0;
        String uuid = bluetoothGattCharacteristic.getUuid().toString();
        BluetoothGattService service = bluetoothGattCharacteristic.getService();
        if (service != null) {
            j = a(service);
        } else {
            x.e(TAG, "the characteristic has no parent service");
        }
        x.d(TAG, "recv data. uuid = %s, data = %s", uuid, b.ar(bArr));
        boolean z2;
        int i;
        int i2;
        byte[] bq;
        if (0 != (1 & j) && (uuid.equalsIgnoreCase(f.kFh) || uuid.equalsIgnoreCase(f.kFi))) {
            f fVar = new f();
            if (bArr.length <= 0 || (bArr[0] & 1) == 0) {
                x.e(f.TAG, "pase step data error");
                z2 = false;
            } else if (uuid == null || !(uuid.equals(f.kFh) || uuid.equals(f.kFi))) {
                x.e(f.TAG, "uuid is not correct");
                z2 = false;
            } else {
                fVar.kEc = uuid;
                i = 4;
                if ((bArr[0] & 2) != 0) {
                    i = 7;
                }
                if ((bArr[0] & 4) != 0) {
                    i += 3;
                }
                if (i > bArr.length) {
                    x.e(f.TAG, "data len is not enough");
                    z2 = false;
                } else {
                    fVar.kFj = 0;
                    i2 = 0;
                    i = 1;
                    while (i2 < 3) {
                        fVar.kFj += (bArr[i] & 255) << (i2 * 8);
                        i2++;
                        i++;
                    }
                    if ((bArr[0] & 2) != 0) {
                        fVar.kFk = 0;
                        i2 = 0;
                        while (i2 < 3) {
                            fVar.kFk += (bArr[i] & 255) << (i2 * 8);
                            i2++;
                            i++;
                        }
                    }
                    if ((bArr[0] & 4) != 0) {
                        fVar.kFl = 0;
                        i2 = i;
                        for (i = 0; i < 3; i++) {
                            fVar.kFl += (bArr[i2] & 255) << (i * 8);
                            i2++;
                        }
                    }
                    z2 = true;
                }
            }
            if (z2) {
                bq = b.bq(fVar);
                x.d(TAG, "step info. stepCount=%d, stepDistance=%d, stepColarie=%d", Integer.valueOf(fVar.kFj), Integer.valueOf(fVar.kFk), Integer.valueOf(fVar.kFl));
                return bq;
            }
            x.e(TAG, "parse step data error");
            return null;
        } else if (0 != (2 & j) && (uuid.equalsIgnoreCase(g.kDS) || uuid.equalsIgnoreCase(g.kDR))) {
            g gVar = new g();
            if (uuid == null || uuid.length() <= 0 || bArr == null || bArr.length <= 0) {
                x.e(g.TAG, "characteristicUuid or data is null or nil");
                z2 = false;
            } else {
                gVar.kEc = uuid;
                String str;
                Object[] objArr;
                if (gVar.kEc.equalsIgnoreCase(g.kDR)) {
                    if (4 > bArr.length) {
                        x.e(g.TAG, "weight scale feature characteristic data is a 32bit value, but current value len is %d", Integer.valueOf(bArr.length));
                        z2 = false;
                    } else {
                        gVar.kFo = new com.tencent.mm.plugin.g.a.b.a.g.c();
                        gVar.kFo.kFu = (bArr[0] & 1) != 0;
                        gVar.kFo.kFv = (bArr[0] & 2) != 0;
                        gVar.kFo.kFw = (bArr[0] & 4) != 0;
                        gVar.kFo.kFx = (byte) ((bArr[0] & 120) >> 3);
                        gVar.kFo.kFy = (byte) (((bArr[0] & FileUtils.S_IWUSR) >> 7) + ((bArr[1] & 3) << 1));
                        uuid = g.TAG;
                        str = "timestampSupported = %s, multipleUsersSupported = %s, BMISupported = %s, weightResolution = %d, heightResolution = %d";
                        objArr = new Object[5];
                        objArr[0] = gVar.kFo.kFu ? "true" : "false";
                        objArr[1] = gVar.kFo.kFv ? "true" : "false";
                        objArr[2] = gVar.kFo.kFw ? "true" : "false";
                        objArr[3] = Byte.valueOf(gVar.kFo.kFx);
                        objArr[4] = Byte.valueOf(gVar.kFo.kFy);
                        x.d(uuid, str, objArr);
                    }
                } else if (gVar.kEc.equalsIgnoreCase(g.kDS)) {
                    byte b = bArr[0];
                    if ((b & 2) != 0) {
                        i = 10;
                    } else {
                        i = 3;
                    }
                    if ((b & 4) != 0) {
                        i++;
                    }
                    if ((b & 8) != 0) {
                        i += 4;
                    }
                    if (i > bArr.length) {
                        x.e(g.TAG, "data len is not enough for parse. current len = %d, needed len = %d", Integer.valueOf(bArr.length), Integer.valueOf(i));
                        z2 = false;
                    } else {
                        gVar.kFp = new g.b();
                        gVar.kFp.kFq = (b & 1) != 0;
                        gVar.kFp.kFr = (bArr[1] & 255) + ((bArr[2] & 255) << 8);
                        if ((b & 2) != 0) {
                            gVar.kFp.kFs = new a();
                            a aVar = gVar.kFp.kFs;
                            String str2 = g.TAG;
                            String str3 = "data size = %d, offset = %d, lenght = %d";
                            Object[] objArr2 = new Object[3];
                            objArr2[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                            objArr2[1] = Integer.valueOf(3);
                            objArr2[2] = Integer.valueOf(7);
                            x.d(str2, str3, objArr2);
                            if (bArr == null || bArr.length < 10) {
                                x.e(g.TAG, "data input error");
                            } else {
                                aVar.kEz = (bArr[3] & 255) + ((bArr[4] & 255) << 8);
                                aVar.kEA = bArr[5] & 255;
                                aVar.kEB = bArr[6] & 255;
                                aVar.kEC = bArr[7] & 255;
                                aVar.kED = bArr[8] & 255;
                                aVar.kEE = bArr[9] & 255;
                                x.d(g.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", Integer.valueOf(aVar.kEz), Integer.valueOf(aVar.kEA), Integer.valueOf(aVar.kEB), Integer.valueOf(aVar.kEC), Integer.valueOf(aVar.kED), Integer.valueOf(aVar.kEE));
                            }
                            i = 10;
                        } else {
                            i = 3;
                        }
                        if ((b & 4) != 0) {
                            gVar.kFp.kEs = bArr[i] & 255;
                            i++;
                        }
                        if ((b & 8) != 0) {
                            gVar.kFp.kFt = (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8);
                            i += 2;
                            gVar.kFp.mHeight = ((bArr[i + 1] & 255) << 8) + (bArr[i] & 255);
                        }
                        uuid = g.TAG;
                        str = "WeightAndHeightUnit = %s, Weight = %d, TimeStamp = %s, UserId = %d, BMI = %d, Height = %d";
                        objArr = new Object[6];
                        objArr[0] = gVar.kFp.kFq ? "lb&inch" : "kg&meter";
                        objArr[1] = Integer.valueOf(gVar.kFp.kFr);
                        objArr[2] = gVar.kFp.kFs == null ? "null" : "object";
                        objArr[3] = Integer.valueOf(gVar.kFp.kEs);
                        objArr[4] = Integer.valueOf(gVar.kFp.kFt);
                        objArr[5] = Integer.valueOf(gVar.kFp.mHeight);
                        x.d(uuid, str, objArr);
                    }
                }
                z2 = true;
            }
            if (z2) {
                bq = b.bq(gVar);
                x.d(TAG, "weight info. weight = %d", Integer.valueOf(gVar.kFp.kFr));
                return bq;
            }
            x.e(TAG, "parse weight scale data error");
            return null;
        } else if (0 != (4 & j) && (uuid.equalsIgnoreCase(d.kEe) || uuid.equalsIgnoreCase(d.kEG) || uuid.equalsIgnoreCase(d.kEH))) {
            d dVar = new d();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                x.e(d.TAG, "characteristicUuid or data is null");
            } else {
                dVar.kEc = uuid;
                int length = bArr.length;
                if (dVar.kEc.equalsIgnoreCase(d.kEe)) {
                    if (bArr.length < 2) {
                        x.e(d.TAG, "Received data length is not right:" + length);
                    } else {
                        int i3;
                        dVar.kEO = new a();
                        byte b2 = bArr[0];
                        x.d(d.TAG, "flag=" + b2);
                        if ((b2 & 1) == 1 && length >= 3) {
                            x.d(d.TAG, "Value Format = uint16");
                            dVar.kEO.kEP = (((bArr[2] << 8) & 65280) & 65280) + (bArr[1] & 255);
                            i = 3;
                        } else if (length >= 2) {
                            x.d(d.TAG, "Value Format = uint8");
                            dVar.kEO.kEP = bArr[1] & 255;
                            i = 2;
                        } else {
                            x.d(d.TAG, "receive data error");
                        }
                        x.v(d.TAG, "Data received from HR " + dVar.kEO.kEP);
                        if ((b2 & 6) == 4) {
                            x.d(d.TAG, "Sensor Contact feature is supported, but contact is not detected");
                            dVar.kEO.kEQ = 1;
                        } else if ((b2 & 6) == 6) {
                            x.d(d.TAG, "Sensor Contact feature is supported and contact is detected");
                            dVar.kEO.kEQ = 2;
                        } else {
                            x.d(d.TAG, "Sensor Contact feature is not supported in the current connection");
                            dVar.kEO.kEQ = 0;
                        }
                        if ((b2 & 8) == 8 && length >= i + 2) {
                            x.d(d.TAG, "Energy Expend Present");
                            i3 = (bArr[i + 1] << 8) & 65280;
                            dVar.kEO.kER = (bArr[i] & 255) + (i3 & 65280);
                            x.v("H7ConnectThread", "energyExp from HR energyExph " + i3 + " " + dVar.kEO.kER);
                            i += 2;
                        }
                        if ((b2 & 16) == 16 && length >= i + 2) {
                            x.d(d.TAG, "RR Interval Present");
                            i3 = (bArr[i + 1] & 255) << 8;
                            dVar.kEO.kES = (bArr[i] & 255) + (i3 & 65280);
                            x.v(d.TAG, "rrInterval from HR rrIntervalh" + i3 + " " + dVar.kEO.kES);
                        }
                    }
                } else if (dVar.kEc.equalsIgnoreCase(d.kEG)) {
                    switch (bArr[0]) {
                        case (byte) 0:
                            dVar.kEN = "Other";
                            break;
                        case (byte) 1:
                            dVar.kEN = "Chest";
                            break;
                        case (byte) 2:
                            dVar.kEN = "Wrist";
                            break;
                        case (byte) 3:
                            dVar.kEN = "Finger";
                            break;
                        case (byte) 4:
                            dVar.kEN = "Hand";
                            break;
                        case (byte) 5:
                            dVar.kEN = "Ear Lobe";
                            break;
                        case (byte) 6:
                            dVar.kEN = "Foot";
                            break;
                        default:
                            dVar.kEN = "Unknown";
                            break;
                    }
                    x.d(d.TAG, "position=" + dVar.kEN);
                }
                z = true;
            }
            if (z) {
                return b.bq(dVar);
            }
            x.e(TAG, "parse heart rate data error");
            return null;
        } else if (0 != (8 & j) && (uuid.equalsIgnoreCase(b.kEe) || uuid.equalsIgnoreCase(b.kEf) || uuid.equalsIgnoreCase(b.kEg))) {
            b bVar = new b();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                x.e(b.TAG, "characteristicUuid or data is null");
            } else {
                bVar.kEc = uuid;
                i = bArr.length;
                byte b3;
                if (bVar.kEc.equalsIgnoreCase(b.kEe)) {
                    if (i < 7) {
                        x.e(b.TAG, "data len is not right.");
                    } else {
                        bVar.kEm = new b();
                        b3 = bArr[0];
                        x.d(b.TAG, "flag=" + b3);
                        if ((b3 & 1) != 0) {
                            x.d(b.TAG, "the value unit is kPa.");
                            bVar.kEm.kEp = true;
                        } else {
                            x.d(b.TAG, "the value unit is mmHg.");
                            bVar.kEm.kEp = false;
                        }
                        bVar.kEm.kEw = b.H(bArr, 1);
                        bVar.kEm.kEx = b.H(bArr, 3);
                        bVar.kEm.kEy = b.H(bArr, 5);
                        i2 = 7;
                        if ((b3 & 2) == 0 || i < 14) {
                            x.d(b.TAG, "TimeStamp not Present.");
                        } else {
                            x.d(b.TAG, "TimeStamp Present.");
                            bVar.kEm.kEu.I(bArr, 7);
                            i2 = 14;
                        }
                        if ((b3 & 4) == 0 || i < i2 + 2) {
                            x.d(b.TAG, "PulseRate not Present.");
                        } else {
                            x.d(b.TAG, "PulseRate Present.");
                            bVar.kEm.kEr = (int) b.H(bArr, i2);
                            i2 += 2;
                            x.d(b.TAG, "PulseRate =" + bVar.kEm.kEr);
                        }
                        if ((b3 & 8) != 0) {
                            x.d(b.TAG, "UserId Present.");
                            i = i2 + 1;
                            bVar.kEm.kEs = bArr[i2];
                            x.d(b.TAG, "UserId = " + bVar.kEm.kEs);
                        } else {
                            x.d(b.TAG, "UserId not Present.");
                            i = i2;
                        }
                        if ((b3 & 16) != 0) {
                            x.d(b.TAG, "MeasurementStatus Present.");
                            bVar.kEm.kEt = (bArr[i] & 255) + (((bArr[i + 1] << 8) & 65280) & 65280);
                            x.d(b.TAG, "MeasurementStatus = " + bVar.kEm.kEt);
                        } else {
                            x.d(b.TAG, "MeasurementStatus not Present.");
                        }
                    }
                } else if (bVar.kEc.equalsIgnoreCase(b.kEf)) {
                    if (i < 3) {
                        x.e(b.TAG, "data len is not right.");
                    } else {
                        bVar.kEn = new a();
                        b3 = bArr[0];
                        x.d(b.TAG, "flag=" + b3);
                        if ((b3 & 1) != 0) {
                            x.d(b.TAG, "the value unit is kPa.");
                            bVar.kEn.kEp = true;
                        } else {
                            x.d(b.TAG, "the value unit is mmHg.");
                            bVar.kEn.kEp = false;
                        }
                        bVar.kEn.kEq = b.H(bArr, 1);
                        if ((b3 & 2) == 0 || i < 10) {
                            x.d(b.TAG, "TimeStamp not Present.");
                            i2 = 3;
                        } else {
                            x.d(b.TAG, "TimeStamp Present.");
                            bVar.kEn.kEu.I(bArr, 3);
                            i2 = 10;
                        }
                        if ((b3 & 4) == 0 || i < i2 + 2) {
                            x.d(b.TAG, "PulseRate not Present.");
                        } else {
                            x.d(b.TAG, "PulseRate Present.");
                            bVar.kEn.kEr = (int) b.H(bArr, i2);
                            i2 += 2;
                            x.d(b.TAG, "PulseRate =" + bVar.kEn.kEr);
                        }
                        if ((b3 & 8) != 0) {
                            x.d(b.TAG, "UserId Present.");
                            i = i2 + 1;
                            bVar.kEn.kEs = bArr[i2];
                            x.d(b.TAG, "UserId = " + bVar.kEn.kEs);
                        } else {
                            x.d(b.TAG, "UserId not Present.");
                            i = i2;
                        }
                        if ((b3 & 16) != 0) {
                            x.d(b.TAG, "MeasurementStatus Present.");
                            bVar.kEn.kEt = (bArr[i] & 255) + (((bArr[i + 1] << 8) & 65280) & 65280);
                            x.d(b.TAG, "MeasurementStatus = " + bVar.kEn.kEt);
                        } else {
                            x.d(b.TAG, "MeasurementStatus not Present.");
                        }
                    }
                } else if (bVar.kEc.equalsIgnoreCase(b.kEg)) {
                    x.d(b.TAG, "Blood Pressure Feature Characteristic.");
                    if (i < 2) {
                        x.e(b.TAG, "data len is not right.");
                    } else {
                        bVar.kEo = (((bArr[1] << 8) & 65280) & 65280) + (bArr[0] & 255);
                        x.d(b.TAG, "bloodPressureFeatureParameters=" + bVar.kEo);
                    }
                }
                z = true;
            }
            if (z) {
                return b.bq(bVar);
            }
            x.e(TAG, "parse blood pressure data error");
            return null;
        } else if (0 == (j & 16) || !(uuid.equalsIgnoreCase(e.kEU) || uuid.equalsIgnoreCase(e.kEV) || uuid.equalsIgnoreCase(e.kEW) || uuid.equalsIgnoreCase(e.kEX))) {
            x.e(TAG, "unknown characteristic uuid = %s", uuid);
            return null;
        } else {
            e eVar = new e();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                x.e(e.TAG, "characteristicUuid or data is null");
            } else {
                eVar.kEc = uuid;
                if (eVar.kEc.equalsIgnoreCase(e.kEU)) {
                    if (bArr.length != 3) {
                        x.e(e.TAG, "Data length incorrect");
                    } else {
                        eVar.kEY = bArr[0];
                        eVar.kEZ = bArr[1];
                        eVar.kFa = bArr[2];
                    }
                } else if (eVar.kEc.equalsIgnoreCase(e.kEV)) {
                    if (bArr.length != 1) {
                        x.e(e.TAG, "Data length incorrect");
                    } else {
                        eVar.kFb = bArr[0];
                    }
                } else if (eVar.kEc.equalsIgnoreCase(e.kEW)) {
                    if (bArr.length < 2) {
                        x.e(e.TAG, "Data length incorrect");
                    } else {
                        eVar.kFc[0] = bArr[0];
                        eVar.kFc[1] = bArr[1];
                    }
                } else if (!eVar.kEc.equalsIgnoreCase(e.kEX)) {
                    x.e(e.TAG, "characteristicUuid is incorrect");
                } else if (bArr.length < 4) {
                    x.e(e.TAG, "Data length incorrect");
                } else {
                    eVar.kFd = (bArr[0] & 255) + ((bArr[1] & 255) << 8);
                    eVar.kFf = bArr[2];
                    eVar.kFe = bArr[3];
                    if (bArr.length > 4) {
                        eVar.kFg = new byte[(bArr.length - 4)];
                        System.arraycopy(bArr, 4, eVar.kFg, 0, bArr.length - 4);
                    } else {
                        eVar.kFg = null;
                    }
                }
                z = true;
            }
            if (z) {
                return b.bq(eVar);
            }
            x.e(TAG, "parse light data error");
            return null;
        }
    }
}
