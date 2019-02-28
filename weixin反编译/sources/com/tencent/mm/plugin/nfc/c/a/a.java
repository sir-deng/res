package com.tencent.mm.plugin.nfc.c.a;

import android.content.Context;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import com.tencent.mm.plugin.nfc.a.c;
import com.tencent.mm.plugin.nfc.c.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends b {
    private static a oXz = null;
    private Set<String> oXA;
    public d oXB = null;

    public static a bgb() {
        if (oXz == null) {
            oXz = new a();
        }
        return oXz;
    }

    public final boolean a(Tag tag) {
        super.a(tag);
        this.oXA = new HashSet();
        for (String str : tag.getTechList()) {
            x.d("MicroMsg.ApduEngine", "[NFC]tech : " + str);
            this.oXA.add(str);
        }
        try {
            if (this.oXB != null && this.oXB.isConnected()) {
                this.oXB.close();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ApduEngine", e, "", new Object[0]);
            x.e("MicroMsg.ApduEngine", e.toString());
        }
        if (this.oXA.contains(IsoDep.class.getName())) {
            this.oXB = new b(tag);
            return true;
        } else if (this.oXA.contains(NfcA.class.getName())) {
            this.oXB = new c(tag);
            return true;
        } else {
            x.i("MicroMsg.ApduEngine", "[NFC]ApduEngine not support this tag");
            return false;
        }
    }

    public final c a(com.tencent.mm.plugin.nfc.a.a aVar) {
        com.tencent.mm.plugin.nfc.c.a aVar2 = new com.tencent.mm.plugin.nfc.c.a(1, "def", aVar);
        a(aVar2);
        return aVar2.oXw;
    }

    private boolean a(com.tencent.mm.plugin.nfc.c.a aVar) {
        if (this.oXB == null) {
            x.e("MicroMsg.ApduEngine", "[NFC]ApduEngine not ready !");
            throw new IllegalStateException("ApduEngine not ready !");
        } else if (aVar == null || aVar.oXv == null) {
            x.e("MicroMsg.ApduEngine", "[NFC]apdu is null !");
            throw new IllegalArgumentException("apdu is null !");
        } else {
            x.i("MicroMsg.ApduEngine", "[NFC][" + aVar.name + "] do cmd : " + aVar.oXv.toString());
            aVar.oXw = this.oXB.a(aVar.oXv);
            c cVar = aVar.oXw;
            if (((short) (cVar.bga() | (cVar.bfZ() << 8))) == (short) -28672) {
                x.i("MicroMsg.ApduEngine", "[NFC][" + aVar.name + "] result==> OK : " + aVar.oXw.toString());
                return true;
            }
            x.e("MicroMsg.ApduEngine", "[NFC][" + aVar.name + "] result==> fail : " + aVar.oXw.toString());
            return false;
        }
    }

    public final boolean a(List<com.tencent.mm.plugin.nfc.c.a> list, boolean z, boolean z2) {
        for (com.tencent.mm.plugin.nfc.c.a a : list) {
            boolean a2 = a(a);
            if (!a2 && z) {
                return false;
            }
            if (a2 && z2) {
                return false;
            }
        }
        return true;
    }

    public final int dj(Context context) {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(context);
        if (defaultAdapter == null) {
            x.i("MicroMsg.ApduEngine", "[NFC] No nfc chip !");
            return 0;
        } else if (!defaultAdapter.isEnabled()) {
            return 1;
        } else {
            if (this.oXB == null) {
                return 4;
            }
            try {
                if (this.oXB == null || !this.oXB.isConnected()) {
                    return 2;
                }
                return 3;
            } catch (IOException e) {
                x.e("MicroMsg.ApduEngine", "[NFC] IOException : " + e.toString());
                return 2;
            }
        }
    }

    public final int dk(Context context) {
        int dj = dj(context);
        if (dj != 3 && dj != 2) {
            return dj;
        }
        try {
            if (this.oXB != null) {
                this.oXB.connect();
                if (this.oXB.isConnected()) {
                    return 3;
                }
            }
            return 2;
        } catch (IOException e) {
            x.e("MicroMsg.ApduEngine", "[NFC] IOException : " + e.toString());
            return 2;
        }
    }

    public final String getInfo() {
        if (this.oXx == null) {
            x.w("MicroMsg.ApduEngine", "lo-nfc-getInfo: tag null");
            return null;
        }
        long Wy = bi.Wy();
        JSONObject jSONObject = new JSONObject();
        x.d("MicroMsg.ApduEngine", "lo-nfc-getInfo: mTechList = " + this.oXA.size());
        for (String str : this.oXA) {
            x.d("MicroMsg.ApduEngine", "lo-nfc-getInfo: tech = " + str);
            Object obj;
            if (str.equals(NfcA.class.getName())) {
                NfcA nfcA = NfcA.get(this.oXx);
                if (nfcA == null) {
                    x.w("MicroMsg.ApduEngineNfcA", "lo-nfc-getInfoJsonObject: get nfcA null");
                    obj = null;
                } else {
                    try {
                        obj = new JSONObject();
                        obj.put("atqa", com.tencent.mm.plugin.nfc.d.a.byteArrayToHexString(nfcA.getAtqa()));
                        obj.put("sak", com.tencent.mm.plugin.nfc.d.a.byteArrayToHexString(com.tencent.mm.plugin.nfc.d.a.b(nfcA.getSak())));
                    } catch (JSONException e) {
                        x.w("MicroMsg.ApduEngine", "lo-nfc-getInfo: exp:+" + e.getLocalizedMessage());
                        return jSONObject.toString();
                    }
                }
                jSONObject.put(NfcA.class.getSimpleName(), obj);
            } else if (str.equals(IsoDep.class.getName())) {
                IsoDep isoDep = IsoDep.get(this.oXx);
                if (isoDep == null) {
                    x.w("MicroMsg.ApduEngineIsoDep", "lo-nfc-getInfoJsonObject: get IsoDep null");
                    obj = null;
                } else {
                    obj = new JSONObject();
                    obj.put("hiLayerResponse", com.tencent.mm.plugin.nfc.d.a.byteArrayToHexString(isoDep.getHiLayerResponse()));
                    obj.put("historicalBytes", com.tencent.mm.plugin.nfc.d.a.byteArrayToHexString(isoDep.getHistoricalBytes()));
                }
                jSONObject.put(IsoDep.class.getSimpleName(), obj);
            }
        }
        x.v("MicroMsg.ApduEngine", "lo-nfc-getInfo: cost=" + (bi.Wy() - Wy));
        x.v("MicroMsg.ApduEngine", "lo-nfc-getInfo: res=" + jSONObject.toString());
        return jSONObject.toString();
    }
}
