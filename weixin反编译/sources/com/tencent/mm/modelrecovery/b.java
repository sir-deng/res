package com.tencent.mm.modelrecovery;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.recovery.model.RecoveryStatusItem;
import com.tencent.recovery.report.RecoveryReporter;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public final class b {
    public static HashMap<String, Integer> hLO;

    public static class b {
        public int hLV;
        public int hLW;
        public int hLX;
        public int hLY;
        public int hLZ;
        public int hMa;
        public int hMb;
        public int hMc;
        public int hMd;
        public int hMe;
        public int hMf;
        public int hMg;

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.hLV > 0) {
                stringBuffer.append("appForegroundExpCount:" + this.hLV + " ");
            }
            if (this.hLW > 0) {
                stringBuffer.append("appBackgroundExpCount:" + this.hLW + " ");
            }
            if (this.hLX > 0) {
                stringBuffer.append("componentForegroundExpCount:" + this.hLX + " ");
            }
            if (this.hLY > 0) {
                stringBuffer.append("componentBackgroundExpCount:" + this.hLY + " ");
            }
            if (this.hLZ > 0) {
                stringBuffer.append("appForegroundCrashOrAnrExpCount:" + this.hLZ + " ");
            }
            if (this.hMa > 0) {
                stringBuffer.append("appBackgroundCrashOrAnrExpCount:" + this.hMa + " ");
            }
            if (this.hMb > 0) {
                stringBuffer.append("componentForegroundCrashOrAnrExpCount:" + this.hMb + " ");
            }
            if (this.hMc > 0) {
                stringBuffer.append("componentBackgroundCrashOrAnrExpCount:" + this.hMc + " ");
            }
            if (this.hMd > 0) {
                stringBuffer.append("appForegroundTimeoutExpCount:" + this.hMd + " ");
            }
            if (this.hMe > 0) {
                stringBuffer.append("appBackgroundTimeoutExpCount:" + this.hMe + " ");
            }
            if (this.hMf > 0) {
                stringBuffer.append("componentForegroundTimeoutExpCount:" + this.hMf + " ");
            }
            if (this.hMg > 0) {
                stringBuffer.append("componentBackgroundTimeoutExpCount:" + this.hMg + " ");
            }
            return stringBuffer.toString();
        }
    }

    public static class a {
        public int hLP;
        public int hLQ;
        public int hLR;
        public int hLS;
        public int hLT;
        public int hLU;

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.hLP > 0) {
                stringBuffer.append("totalCount:" + this.hLP + " ");
            }
            if (this.hLQ > 0) {
                stringBuffer.append("enterRecoveryCount:" + this.hLQ + " ");
            }
            if (this.hLR > 0) {
                stringBuffer.append("existRecoveryProcessCount:" + this.hLR + " ");
            }
            if (this.hLS > 0) {
                stringBuffer.append("foregroundExpCount:" + this.hLS + " ");
            }
            if (this.hLT > 0) {
                stringBuffer.append("backgroundExpCount:" + this.hLT + " ");
            }
            if (this.hLU > 0) {
                stringBuffer.append("normalCount:" + this.hLU + " ");
            }
            return stringBuffer.toString();
        }
    }

    public static void QR() {
        List<RecoveryStatusItem> a = RecoveryReporter.a(ad.getContext(), "ProcessStatus", RecoveryStatusItem.class);
        x.i("MicroMsg.Recovery.WXRecoveryReporter", "reportStatus " + a.size());
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (RecoveryStatusItem recoveryStatusItem : a) {
            a aVar = hashMap.containsKey(recoveryStatusItem.processName) ? (a) hashMap.get(recoveryStatusItem.processName) : new a();
            b bVar = hashMap2.containsKey(recoveryStatusItem.processName) ? (b) hashMap2.get(recoveryStatusItem.processName) : new b();
            aVar.hLP++;
            if (recoveryStatusItem.Aay == 1) {
                aVar.hLS++;
            } else {
                aVar.hLT++;
            }
            Object obj = null;
            int obj2;
            switch (recoveryStatusItem.AaA) {
                case 1:
                    if (recoveryStatusItem.Aay != 1) {
                        bVar.hLW++;
                        switch (recoveryStatusItem.AaB) {
                            case Downloads.RECV_BUFFER_SIZE /*4096*/:
                                bVar.hMe++;
                                obj2 = 1;
                                break;
                            case 65536:
                            case 1048576:
                                bVar.hMa++;
                                obj2 = 1;
                                break;
                        }
                    }
                    bVar.hLV++;
                    switch (recoveryStatusItem.AaB) {
                        case Downloads.RECV_BUFFER_SIZE /*4096*/:
                            bVar.hMd++;
                            obj2 = 1;
                            break;
                        case 65536:
                        case 1048576:
                            bVar.hLZ++;
                            obj2 = 1;
                            break;
                    }
                    break;
                case 16:
                    if (recoveryStatusItem.Aay != 1) {
                        bVar.hLY++;
                        switch (recoveryStatusItem.AaB) {
                            case Downloads.RECV_BUFFER_SIZE /*4096*/:
                                bVar.hMg++;
                                obj2 = 1;
                                break;
                            case 65536:
                            case 1048576:
                                bVar.hMc++;
                                obj2 = 1;
                                break;
                        }
                    }
                    bVar.hLX++;
                    switch (recoveryStatusItem.AaB) {
                        case Downloads.RECV_BUFFER_SIZE /*4096*/:
                            bVar.hMf++;
                            obj2 = 1;
                            break;
                        case 65536:
                        case 1048576:
                            bVar.hMb++;
                            obj2 = 1;
                            break;
                    }
                    break;
            }
            if (obj2 == null) {
                x.i("MicroMsg.Recovery.WXRecoveryReporter", "recovery statics not set exception");
            }
            hashMap.put(recoveryStatusItem.processName, aVar);
            hashMap2.put(recoveryStatusItem.processName, bVar);
        }
        i(hashMap);
        j(hashMap2);
        RecoveryReporter.bB(ad.getContext(), "ProcessStatus");
    }

    private static void i(HashMap<String, a> hashMap) {
        ArrayList arrayList = new ArrayList();
        for (Entry entry : hashMap.entrySet()) {
            if (hLO.containsKey(entry.getKey())) {
                IDKey iDKey;
                int intValue = ((Integer) hLO.get(entry.getKey())).intValue();
                a aVar = (a) entry.getValue();
                if (aVar.hLP > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 0);
                    iDKey.SetValue((long) aVar.hLP);
                    arrayList.add(iDKey);
                }
                if (aVar.hLQ > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 1);
                    iDKey.SetValue((long) aVar.hLQ);
                    arrayList.add(iDKey);
                }
                if (aVar.hLR > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 2);
                    iDKey.SetValue((long) aVar.hLR);
                    arrayList.add(iDKey);
                }
                if (aVar.hLS > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 3);
                    iDKey.SetValue((long) aVar.hLS);
                    arrayList.add(iDKey);
                }
                if (aVar.hLT > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 4);
                    iDKey.SetValue((long) aVar.hLT);
                    arrayList.add(iDKey);
                }
                if (aVar.hLU > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 5);
                    iDKey.SetValue((long) aVar.hLU);
                    arrayList.add(iDKey);
                }
            }
        }
        if (arrayList.size() > 0) {
            g.pWK.a(arrayList, true);
        }
        x.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery generalObj %s %s", ad.By(), hashMap.toString());
    }

    private static void j(HashMap<String, b> hashMap) {
        ArrayList arrayList = new ArrayList();
        for (Entry entry : hashMap.entrySet()) {
            if (hLO.containsKey(entry.getKey())) {
                IDKey iDKey;
                int intValue = ((Integer) hLO.get(entry.getKey())).intValue();
                b bVar = (b) entry.getValue();
                if (bVar.hLV > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 0);
                    iDKey.SetValue((long) bVar.hLV);
                    arrayList.add(iDKey);
                }
                if (bVar.hLW > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 1);
                    iDKey.SetValue((long) bVar.hLW);
                    arrayList.add(iDKey);
                }
                if (bVar.hLX > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 2);
                    iDKey.SetValue((long) bVar.hLX);
                    arrayList.add(iDKey);
                }
                if (bVar.hLY > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 3);
                    iDKey.SetValue((long) bVar.hLY);
                    arrayList.add(iDKey);
                }
                if (bVar.hLZ > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 4);
                    iDKey.SetValue((long) bVar.hLZ);
                    arrayList.add(iDKey);
                }
                if (bVar.hMa > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 5);
                    iDKey.SetValue((long) bVar.hMa);
                    arrayList.add(iDKey);
                }
                if (bVar.hMb > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 6);
                    iDKey.SetValue((long) bVar.hMb);
                    arrayList.add(iDKey);
                }
                if (bVar.hMc > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 7);
                    iDKey.SetValue((long) bVar.hMc);
                    arrayList.add(iDKey);
                }
                if (bVar.hMd > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 8);
                    iDKey.SetValue((long) bVar.hMd);
                    arrayList.add(iDKey);
                }
                if (bVar.hMe > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 9);
                    iDKey.SetValue((long) bVar.hMe);
                    arrayList.add(iDKey);
                }
                if (bVar.hMf > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 10);
                    iDKey.SetValue((long) bVar.hMf);
                    arrayList.add(iDKey);
                }
                if (bVar.hMg > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 11);
                    iDKey.SetValue((long) bVar.hMg);
                    arrayList.add(iDKey);
                }
            }
        }
        if (arrayList.size() > 0) {
            g.pWK.a(arrayList, true);
        }
        x.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery statusObj %s %s", ad.By(), hashMap.toString());
    }

    static {
        HashMap hashMap = new HashMap();
        hLO = hashMap;
        hashMap.put(ad.getPackageName(), Integer.valueOf(0));
        hLO.put(ad.getPackageName() + ":push", Integer.valueOf(20));
        hLO.put(ad.getPackageName() + ":tools", Integer.valueOf(40));
        hLO.put(ad.getPackageName() + ":exdevice", Integer.valueOf(60));
        hLO.put(ad.getPackageName() + ":sandbox", Integer.valueOf(80));
    }
}
