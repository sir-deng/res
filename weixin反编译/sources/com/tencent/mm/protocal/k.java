package com.tencent.mm.protocal;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.fh;
import com.tencent.mm.protocal.c.fi;
import com.tencent.mm.sdk.platformtools.x;

public final class k {

    public interface a {
        boolean a(PByteArray pByteArray, int i, byte[] bArr, byte[] bArr2, int i2);
    }

    public interface b {
        byte[] Hw();

        int Hx();

        boolean cev();
    }

    public interface c {
        int E(byte[] bArr);

        boolean cev();
    }

    public static class d {
        public byte[] bjP = new byte[0];
        public int vHR = 0;
        public int vHS = 0;
        public String vHT = "";
        public String vHU = "";
        public int vHV = 0;
        public boolean vHW = true;
        public a vHX;
        public byte[] vHY;
        public ac vHZ = new ac("", "", 0);
        public long vIa = 0;

        public void eE(int i) {
            this.vHR = i;
        }

        public int getCmdId() {
            return 0;
        }

        public boolean cev() {
            return false;
        }

        public boolean KN() {
            return this.vHW;
        }
    }

    public static class e {
        public long vIa = 0;
        public int vIb = -99;
        public int vIc = 255;
        public String vId = "";

        public int getCmdId() {
            return 0;
        }

        public boolean cev() {
            return false;
        }
    }

    public static fh a(d dVar) {
        fh fhVar = new fh();
        fhVar.vRR = dVar.vHS;
        fhVar.sfa = dVar.vHV;
        fhVar.lTO = dVar.vHR;
        fhVar.vRQ = com.tencent.mm.bp.b.be(dVar.vHU.getBytes());
        if (fhVar.vRQ.oz.length >= 16) {
            fhVar.vRQ = fhVar.vRQ.CW(16);
        }
        fhVar.vRS = com.tencent.mm.bp.b.be(dVar.vHT.getBytes());
        if (fhVar.vRS.oz.length >= 132) {
            fhVar.vRS = fhVar.vRS.CW(132);
        }
        fhVar.vRP = com.tencent.mm.bp.b.be(dVar.bjP);
        if (fhVar.vRP.oz.length >= 36) {
            fhVar.vRP = fhVar.vRP.CW(36);
        }
        return fhVar;
    }

    public static void a(e eVar, fi fiVar) {
        if (fiVar.vRT != null) {
            eVar.vId = fiVar.vRT.wRo;
            return;
        }
        eVar.vId = "";
        x.e("MicroMsg.MMBase", "ErrMsg is Null!!!!!!");
    }
}
