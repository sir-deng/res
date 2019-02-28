package com.tencent.mm.plugin.nfc_open.a;

import android.content.Context;
import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.f.a.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

public final class a extends c<k> {
    public a() {
        this.xmG = k.class.getName().hashCode();
    }

    private static boolean a(k kVar) {
        if ((kVar instanceof k) && kVar.fnU != null) {
            int i = kVar.fnU.actionCode;
            Context context = kVar.fnU.context;
            Bundle bundle = new Bundle();
            String str;
            switch (i) {
                case 4001:
                    bundle.putInt(DownloadInfo.STATUS, com.tencent.mm.plugin.nfc.c.a.a.bgb().dj(context));
                    break;
                case 4002:
                    bundle.putInt(DownloadInfo.STATUS, com.tencent.mm.plugin.nfc.c.a.a.bgb().dk(context));
                    break;
                case 4003:
                    str = kVar.fnU.fnW;
                    if (!bi.oN(str)) {
                        try {
                            bundle.putString("result", com.tencent.mm.plugin.nfc.c.a.a.bgb().a(new com.tencent.mm.plugin.nfc.a.a(str)).toString());
                            break;
                        } catch (Throwable e) {
                            x.e("MicroMsg.ApduEngineFuncListener", "alex: exec nfc command exception");
                            x.printErrStackTrace("MicroMsg.ApduEngineFuncListener", e, "", new Object[0]);
                            bundle.putString("result", null);
                            break;
                        }
                    }
                    x.e("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu is null");
                    break;
                case 4004:
                    try {
                        str = kVar.fnU.fnW;
                        boolean z = kVar.fnU.fnX;
                        boolean z2 = kVar.fnU.fnY;
                        if (bi.oN(str)) {
                            x.e("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu is null");
                            break;
                        }
                        String[] split = str.split("\\|");
                        List<com.tencent.mm.plugin.nfc.c.a> arrayList = new ArrayList();
                        for (String str2 : split) {
                            if (bi.oN(str2)) {
                                x.w("MicroMsg.ApduEngineFuncListener", "[NFC] batch transceive apduStr is null");
                            } else {
                                String[] split2 = str2.split(":");
                                if (split2 == null || split2.length < 2) {
                                    x.w("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu's size is wrong");
                                } else {
                                    int i2 = bi.getInt(split2[0], 0);
                                    arrayList.add(new com.tencent.mm.plugin.nfc.c.a(i2, String.valueOf(i2), new com.tencent.mm.plugin.nfc.a.a(split2[1])));
                                }
                            }
                        }
                        com.tencent.mm.plugin.nfc.c.a.a.bgb().a(arrayList, z, z2);
                        StringBuilder stringBuilder = new StringBuilder();
                        for (com.tencent.mm.plugin.nfc.c.a aVar : arrayList) {
                            if (aVar.oXw == null) {
                                bundle.putString("result", stringBuilder.toString());
                                break;
                            }
                            stringBuilder.append(aVar.id);
                            stringBuilder.append(":");
                            stringBuilder.append(aVar.oXw.toString());
                            stringBuilder.append("|");
                        }
                        bundle.putString("result", stringBuilder.toString());
                    } catch (Throwable e2) {
                        x.e("MicroMsg.ApduEngineFuncListener", "alex: exec nfc command exception");
                        x.printErrStackTrace("MicroMsg.ApduEngineFuncListener", e2, "", new Object[0]);
                        bundle.putString("result", null);
                        break;
                    }
                    break;
                case 4005:
                    bundle.putString(SlookAirButtonFrequentContactAdapter.ID, com.tencent.mm.plugin.nfc.d.a.byteArrayToHexString(com.tencent.mm.plugin.nfc.c.a.a.bgb().oXy));
                    break;
                case 4008:
                    bundle.putString("info", com.tencent.mm.plugin.nfc.c.a.a.bgb().getInfo());
                    break;
            }
            kVar.fnV.fnZ = bundle;
        }
        return false;
    }
}
