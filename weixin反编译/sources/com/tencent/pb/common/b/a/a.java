package com.tencent.pb.common.b.a;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardData;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.wcdb.FileUtils;
import java.util.Arrays;
import org.xwalk.core.R;

public interface a {

    public static final class a extends com.google.a.a.e {
        public String groupId;
        public int srH;
        public long srI;
        public int[] zVV;
        public int zVW;
        public String[] zVX;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                int b;
                Object obj;
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.srH = aVar.rz();
                        continue;
                    case 24:
                        this.srI = aVar.rA();
                        continue;
                    case 32:
                        b = com.google.a.a.g.b(aVar, 32);
                        ry = this.zVV == null ? 0 : this.zVV.length;
                        obj = new int[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zVV, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = aVar.rz();
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = aVar.rz();
                        this.zVV = obj;
                        continue;
                    case 34:
                        int dQ = aVar.dQ(aVar.rz());
                        b = aVar.getPosition();
                        ry = 0;
                        while (aVar.rC() > 0) {
                            aVar.rz();
                            ry++;
                        }
                        aVar.dS(b);
                        b = this.zVV == null ? 0 : this.zVV.length;
                        Object obj2 = new int[(ry + b)];
                        if (b != 0) {
                            System.arraycopy(this.zVV, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = aVar.rz();
                            b++;
                        }
                        this.zVV = obj2;
                        aVar.dR(dQ);
                        continue;
                    case 40:
                        this.zVW = aVar.rz();
                        continue;
                    case 802:
                        b = com.google.a.a.g.b(aVar, 802);
                        ry = this.zVX == null ? 0 : this.zVX.length;
                        obj = new String[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zVX, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = aVar.readString();
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = aVar.readString();
                        this.zVX = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public a() {
            this.groupId = "";
            this.srH = 0;
            this.srI = 0;
            this.zVV = com.google.a.a.g.bfR;
            this.zVW = 0;
            this.zVX = com.google.a.a.g.EMPTY_STRING_ARRAY;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.srH != 0) {
                bVar.aB(2, this.srH);
            }
            if (this.srI != 0) {
                bVar.k(3, this.srI);
            }
            if (this.zVV != null && this.zVV.length > 0) {
                for (int aC : this.zVV) {
                    bVar.aC(4, aC);
                }
            }
            if (this.zVW != 0) {
                bVar.aB(5, this.zVW);
            }
            if (this.zVX != null && this.zVX.length > 0) {
                while (i < this.zVX.length) {
                    String str = this.zVX[i];
                    if (str != null) {
                        bVar.g(100, str);
                    }
                    i++;
                }
            }
            super.a(bVar);
        }

        protected final int rM() {
            int i;
            int i2;
            int i3 = 0;
            int rM = super.rM();
            if (!this.groupId.equals("")) {
                rM += com.google.a.a.b.h(1, this.groupId);
            }
            if (this.srH != 0) {
                rM += com.google.a.a.b.aD(2, this.srH);
            }
            if (this.srI != 0) {
                rM += com.google.a.a.b.m(3, this.srI);
            }
            if (this.zVV != null && this.zVV.length > 0) {
                i = 0;
                for (int dZ : this.zVV) {
                    i += com.google.a.a.b.dZ(dZ);
                }
                rM = (rM + i) + (this.zVV.length * 1);
            }
            if (this.zVW != 0) {
                rM += com.google.a.a.b.aD(5, this.zVW);
            }
            if (this.zVX == null || this.zVX.length <= 0) {
                return rM;
            }
            i2 = 0;
            i = 0;
            while (i3 < this.zVX.length) {
                String str = this.zVX[i3];
                if (str != null) {
                    i++;
                    i2 += com.google.a.a.b.bm(str);
                }
                i3++;
            }
            return (rM + i2) + (i * 2);
        }
    }

    public static final class ab extends com.google.a.a.e {
        public String groupId;
        public int srH;
        public long srI;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.srH = aVar.rz();
                        continue;
                    case 24:
                        this.srI = aVar.rA();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public ab() {
            this.groupId = "";
            this.srH = 0;
            this.srI = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.srH != 0) {
                bVar.aB(2, this.srH);
            }
            if (this.srI != 0) {
                bVar.k(3, this.srI);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (!this.groupId.equals("")) {
                rM += com.google.a.a.b.h(1, this.groupId);
            }
            if (this.srH != 0) {
                rM += com.google.a.a.b.aD(2, this.srH);
            }
            if (this.srI != 0) {
                return rM + com.google.a.a.b.m(3, this.srI);
            }
            return rM;
        }
    }

    public static final class ac extends com.google.a.a.e {
        public String groupId;
        public at zWa;
        public int zXD;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 18:
                        if (this.zWa == null) {
                            this.zWa = new at();
                        }
                        aVar.a(this.zWa);
                        continue;
                    case 24:
                        this.zXD = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public ac() {
            this.groupId = "";
            this.zWa = null;
            this.zXD = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.zWa != null) {
                bVar.a(2, this.zWa);
            }
            if (this.zXD != 0) {
                bVar.aB(3, this.zXD);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (!this.groupId.equals("")) {
                rM += com.google.a.a.b.h(1, this.groupId);
            }
            if (this.zWa != null) {
                rM += com.google.a.a.b.b(2, this.zWa);
            }
            if (this.zXD != 0) {
                return rM + com.google.a.a.b.aD(3, this.zXD);
            }
            return rM;
        }
    }

    public static final class d extends com.google.a.a.e {
        public int netType;
        public String zVY;
        public at zWa;
        public int[] zWb;
        public ba zWc;
        public int zWd;
        public int zWe;
        public ay zWf;
        public String zWg;
        public String[] zWh;
        public m[] zWi;
        public int zWj;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                int b;
                Object obj;
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        if (this.zWa == null) {
                            this.zWa = new at();
                        }
                        aVar.a(this.zWa);
                        continue;
                    case 16:
                        b = com.google.a.a.g.b(aVar, 16);
                        ry = this.zWb == null ? 0 : this.zWb.length;
                        obj = new int[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zWb, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = aVar.rz();
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = aVar.rz();
                        this.zWb = obj;
                        continue;
                    case 18:
                        int dQ = aVar.dQ(aVar.rz());
                        b = aVar.getPosition();
                        ry = 0;
                        while (aVar.rC() > 0) {
                            aVar.rz();
                            ry++;
                        }
                        aVar.dS(b);
                        b = this.zWb == null ? 0 : this.zWb.length;
                        Object obj2 = new int[(ry + b)];
                        if (b != 0) {
                            System.arraycopy(this.zWb, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = aVar.rz();
                            b++;
                        }
                        this.zWb = obj2;
                        aVar.dR(dQ);
                        continue;
                    case 26:
                        if (this.zWc == null) {
                            this.zWc = new ba();
                        }
                        aVar.a(this.zWc);
                        continue;
                    case 32:
                        this.zWd = aVar.rz();
                        continue;
                    case 40:
                        this.zWe = aVar.rz();
                        continue;
                    case 50:
                        if (this.zWf == null) {
                            this.zWf = new ay();
                        }
                        aVar.a(this.zWf);
                        continue;
                    case 58:
                        this.zVY = aVar.readString();
                        continue;
                    case 66:
                        this.zWg = aVar.readString();
                        continue;
                    case 72:
                        this.netType = aVar.rz();
                        continue;
                    case 802:
                        b = com.google.a.a.g.b(aVar, 802);
                        ry = this.zWh == null ? 0 : this.zWh.length;
                        obj = new String[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zWh, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = aVar.readString();
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = aVar.readString();
                        this.zWh = obj;
                        continue;
                    case 1618:
                        b = com.google.a.a.g.b(aVar, 1618);
                        ry = this.zWi == null ? 0 : this.zWi.length;
                        obj = new m[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zWi, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new m();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new m();
                        aVar.a(obj[ry]);
                        this.zWi = obj;
                        continue;
                    case 1920:
                        this.zWj = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public d() {
            this.zWa = null;
            this.zWb = com.google.a.a.g.bfR;
            this.zWc = null;
            this.zWd = 0;
            this.zWe = 0;
            this.zWf = null;
            this.zVY = "";
            this.zWg = "";
            this.netType = 0;
            this.zWh = com.google.a.a.g.EMPTY_STRING_ARRAY;
            this.zWi = m.cDB();
            this.zWj = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (this.zWa != null) {
                bVar.a(1, this.zWa);
            }
            if (this.zWb != null && this.zWb.length > 0) {
                for (int aC : this.zWb) {
                    bVar.aC(2, aC);
                }
            }
            if (this.zWc != null) {
                bVar.a(3, this.zWc);
            }
            if (this.zWd != 0) {
                bVar.aC(4, this.zWd);
            }
            if (this.zWe != 0) {
                bVar.aC(5, this.zWe);
            }
            if (this.zWf != null) {
                bVar.a(6, this.zWf);
            }
            if (!this.zVY.equals("")) {
                bVar.g(7, this.zVY);
            }
            if (!this.zWg.equals("")) {
                bVar.g(8, this.zWg);
            }
            if (this.netType != 0) {
                bVar.aC(9, this.netType);
            }
            if (this.zWh != null && this.zWh.length > 0) {
                for (String str : this.zWh) {
                    if (str != null) {
                        bVar.g(100, str);
                    }
                }
            }
            if (this.zWi != null && this.zWi.length > 0) {
                while (i < this.zWi.length) {
                    com.google.a.a.e eVar = this.zWi[i];
                    if (eVar != null) {
                        bVar.a(202, eVar);
                    }
                    i++;
                }
            }
            if (this.zWj != 0) {
                bVar.aC(240, this.zWj);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int i;
            int i2;
            int i3 = 0;
            int rM = super.rM();
            if (this.zWa != null) {
                rM += com.google.a.a.b.b(1, this.zWa);
            }
            if (this.zWb != null && this.zWb.length > 0) {
                i = 0;
                for (int i22 : this.zWb) {
                    i += com.google.a.a.b.dZ(i22);
                }
                rM = (rM + i) + (this.zWb.length * 1);
            }
            if (this.zWc != null) {
                rM += com.google.a.a.b.b(3, this.zWc);
            }
            if (this.zWd != 0) {
                rM += com.google.a.a.b.aE(4, this.zWd);
            }
            if (this.zWe != 0) {
                rM += com.google.a.a.b.aE(5, this.zWe);
            }
            if (this.zWf != null) {
                rM += com.google.a.a.b.b(6, this.zWf);
            }
            if (!this.zVY.equals("")) {
                rM += com.google.a.a.b.h(7, this.zVY);
            }
            if (!this.zWg.equals("")) {
                rM += com.google.a.a.b.h(8, this.zWg);
            }
            if (this.netType != 0) {
                rM += com.google.a.a.b.aE(9, this.netType);
            }
            if (this.zWh != null && this.zWh.length > 0) {
                i = 0;
                i22 = 0;
                for (String str : this.zWh) {
                    if (str != null) {
                        i22++;
                        i += com.google.a.a.b.bm(str);
                    }
                }
                rM = (rM + i) + (i22 * 2);
            }
            if (this.zWi != null && this.zWi.length > 0) {
                while (i3 < this.zWi.length) {
                    com.google.a.a.e eVar = this.zWi[i3];
                    if (eVar != null) {
                        rM += com.google.a.a.b.b(202, eVar);
                    }
                    i3++;
                }
            }
            if (this.zWj != 0) {
                return rM + com.google.a.a.b.aE(240, this.zWj);
            }
            return rM;
        }
    }

    public static final class aa extends com.google.a.a.e {
        public String groupId;
        public int srH;
        public long srI;
        public as zWF;
        public av[] zWJ;
        public at zWa;
        public int zWk;
        public int zWy;
        public int zXA;
        public int zXB;
        public byte[] zXC;
        public av[] zXq;
        public o[] zXr;
        public aw[] zXs;
        public int zXt;
        public int[] zXu;
        public o[] zXv;
        public int zXw;
        public int zXx;
        public o[] zXy;
        public int zXz;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                int b;
                Object obj;
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.srH = aVar.rz();
                        continue;
                    case 24:
                        this.srI = aVar.rA();
                        continue;
                    case 34:
                        b = com.google.a.a.g.b(aVar, 34);
                        ry = this.zXr == null ? 0 : this.zXr.length;
                        obj = new o[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXr, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new o();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new o();
                        aVar.a(obj[ry]);
                        this.zXr = obj;
                        continue;
                    case R.styleable.AppCompatTheme_dialogTheme /*42*/:
                        b = com.google.a.a.g.b(aVar, 42);
                        ry = this.zXq == null ? 0 : this.zXq.length;
                        obj = new av[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXq, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new av();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new av();
                        aVar.a(obj[ry]);
                        this.zXq = obj;
                        continue;
                    case 50:
                        if (this.zWF == null) {
                            this.zWF = new as();
                        }
                        aVar.a(this.zWF);
                        continue;
                    case 56:
                        this.zXt = aVar.rz();
                        continue;
                    case 64:
                        b = com.google.a.a.g.b(aVar, 64);
                        ry = this.zXu == null ? 0 : this.zXu.length;
                        obj = new int[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXu, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = aVar.rz();
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = aVar.rz();
                        this.zXu = obj;
                        continue;
                    case 66:
                        int dQ = aVar.dQ(aVar.rz());
                        b = aVar.getPosition();
                        ry = 0;
                        while (aVar.rC() > 0) {
                            aVar.rz();
                            ry++;
                        }
                        aVar.dS(b);
                        b = this.zXu == null ? 0 : this.zXu.length;
                        Object obj2 = new int[(ry + b)];
                        if (b != 0) {
                            System.arraycopy(this.zXu, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = aVar.rz();
                            b++;
                        }
                        this.zXu = obj2;
                        aVar.dR(dQ);
                        continue;
                    case 72:
                        this.zWk = aVar.rz();
                        continue;
                    case 82:
                        b = com.google.a.a.g.b(aVar, 82);
                        ry = this.zXs == null ? 0 : this.zXs.length;
                        obj = new aw[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXs, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new aw();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new aw();
                        aVar.a(obj[ry]);
                        this.zXs = obj;
                        continue;
                    case 90:
                        if (this.zWa == null) {
                            this.zWa = new at();
                        }
                        aVar.a(this.zWa);
                        continue;
                    case 96:
                        this.zWy = aVar.rz();
                        continue;
                    case 106:
                        b = com.google.a.a.g.b(aVar, 106);
                        ry = this.zXv == null ? 0 : this.zXv.length;
                        obj = new o[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXv, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new o();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new o();
                        aVar.a(obj[ry]);
                        this.zXv = obj;
                        continue;
                    case 114:
                        b = com.google.a.a.g.b(aVar, 114);
                        ry = this.zXy == null ? 0 : this.zXy.length;
                        obj = new o[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXy, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new o();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new o();
                        aVar.a(obj[ry]);
                        this.zXy = obj;
                        continue;
                    case 120:
                        this.zXz = aVar.rz();
                        continue;
                    case FileUtils.S_IWUSR /*128*/:
                        this.zXA = aVar.rz();
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.map.h.CTRL_INDEX /*136*/:
                        this.zXB = aVar.rz();
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX /*146*/:
                        this.zXC = aVar.readBytes();
                        continue;
                    case 800:
                        this.zXw = aVar.rz();
                        continue;
                    case 808:
                        this.zXx = aVar.rz();
                        continue;
                    case 818:
                        b = com.google.a.a.g.b(aVar, 818);
                        ry = this.zWJ == null ? 0 : this.zWJ.length;
                        obj = new av[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zWJ, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new av();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new av();
                        aVar.a(obj[ry]);
                        this.zWJ = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public aa() {
            this.groupId = "";
            this.srH = 0;
            this.srI = 0;
            this.zXr = o.cDD();
            this.zXq = av.cDJ();
            this.zWF = null;
            this.zXt = 0;
            this.zXu = com.google.a.a.g.bfR;
            this.zWk = 0;
            this.zXs = aw.cDK();
            this.zWa = null;
            this.zWy = 0;
            this.zXv = o.cDD();
            this.zXy = o.cDD();
            this.zXz = 0;
            this.zXA = 0;
            this.zXB = 0;
            this.zXC = com.google.a.a.g.bfX;
            this.zXw = 0;
            this.zXx = 0;
            this.zWJ = av.cDJ();
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.srH != 0) {
                bVar.aB(2, this.srH);
            }
            if (this.srI != 0) {
                bVar.k(3, this.srI);
            }
            if (this.zXr != null && this.zXr.length > 0) {
                for (com.google.a.a.e eVar : this.zXr) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.zXq != null && this.zXq.length > 0) {
                for (com.google.a.a.e eVar2 : this.zXq) {
                    if (eVar2 != null) {
                        bVar.a(5, eVar2);
                    }
                }
            }
            if (this.zWF != null) {
                bVar.a(6, this.zWF);
            }
            if (this.zXt != 0) {
                bVar.aB(7, this.zXt);
            }
            if (this.zXu != null && this.zXu.length > 0) {
                for (int aB : this.zXu) {
                    bVar.aB(8, aB);
                }
            }
            if (this.zWk != 0) {
                bVar.aB(9, this.zWk);
            }
            if (this.zXs != null && this.zXs.length > 0) {
                for (com.google.a.a.e eVar22 : this.zXs) {
                    if (eVar22 != null) {
                        bVar.a(10, eVar22);
                    }
                }
            }
            if (this.zWa != null) {
                bVar.a(11, this.zWa);
            }
            if (this.zWy != 0) {
                bVar.aC(12, this.zWy);
            }
            if (this.zXv != null && this.zXv.length > 0) {
                for (com.google.a.a.e eVar222 : this.zXv) {
                    if (eVar222 != null) {
                        bVar.a(13, eVar222);
                    }
                }
            }
            if (this.zXy != null && this.zXy.length > 0) {
                for (com.google.a.a.e eVar2222 : this.zXy) {
                    if (eVar2222 != null) {
                        bVar.a(14, eVar2222);
                    }
                }
            }
            if (this.zXz != 0) {
                bVar.aB(15, this.zXz);
            }
            if (this.zXA != 0) {
                bVar.aB(16, this.zXA);
            }
            if (this.zXB != 0) {
                bVar.aB(17, this.zXB);
            }
            if (!Arrays.equals(this.zXC, com.google.a.a.g.bfX)) {
                bVar.a(18, this.zXC);
            }
            if (this.zXw != 0) {
                bVar.aC(100, this.zXw);
            }
            if (this.zXx != 0) {
                bVar.aC(101, this.zXx);
            }
            if (this.zWJ != null && this.zWJ.length > 0) {
                while (i < this.zWJ.length) {
                    com.google.a.a.e eVar3 = this.zWJ[i];
                    if (eVar3 != null) {
                        bVar.a(102, eVar3);
                    }
                    i++;
                }
            }
            super.a(bVar);
        }

        protected final int rM() {
            int i;
            int i2 = 0;
            int rM = super.rM();
            if (!this.groupId.equals("")) {
                rM += com.google.a.a.b.h(1, this.groupId);
            }
            if (this.srH != 0) {
                rM += com.google.a.a.b.aD(2, this.srH);
            }
            if (this.srI != 0) {
                rM += com.google.a.a.b.m(3, this.srI);
            }
            if (this.zXr != null && this.zXr.length > 0) {
                i = rM;
                for (com.google.a.a.e eVar : this.zXr) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(4, eVar);
                    }
                }
                rM = i;
            }
            if (this.zXq != null && this.zXq.length > 0) {
                i = rM;
                for (com.google.a.a.e eVar2 : this.zXq) {
                    if (eVar2 != null) {
                        i += com.google.a.a.b.b(5, eVar2);
                    }
                }
                rM = i;
            }
            if (this.zWF != null) {
                rM += com.google.a.a.b.b(6, this.zWF);
            }
            if (this.zXt != 0) {
                rM += com.google.a.a.b.aD(7, this.zXt);
            }
            if (this.zXu != null && this.zXu.length > 0) {
                int i3 = 0;
                for (int dV : this.zXu) {
                    i3 += com.google.a.a.b.dV(dV);
                }
                rM = (rM + i3) + (this.zXu.length * 1);
            }
            if (this.zWk != 0) {
                rM += com.google.a.a.b.aD(9, this.zWk);
            }
            if (this.zXs != null && this.zXs.length > 0) {
                i = rM;
                for (com.google.a.a.e eVar22 : this.zXs) {
                    if (eVar22 != null) {
                        i += com.google.a.a.b.b(10, eVar22);
                    }
                }
                rM = i;
            }
            if (this.zWa != null) {
                rM += com.google.a.a.b.b(11, this.zWa);
            }
            if (this.zWy != 0) {
                rM += com.google.a.a.b.aE(12, this.zWy);
            }
            if (this.zXv != null && this.zXv.length > 0) {
                i = rM;
                for (com.google.a.a.e eVar222 : this.zXv) {
                    if (eVar222 != null) {
                        i += com.google.a.a.b.b(13, eVar222);
                    }
                }
                rM = i;
            }
            if (this.zXy != null && this.zXy.length > 0) {
                i = rM;
                for (com.google.a.a.e eVar2222 : this.zXy) {
                    if (eVar2222 != null) {
                        i += com.google.a.a.b.b(14, eVar2222);
                    }
                }
                rM = i;
            }
            if (this.zXz != 0) {
                rM += com.google.a.a.b.aD(15, this.zXz);
            }
            if (this.zXA != 0) {
                rM += com.google.a.a.b.aD(16, this.zXA);
            }
            if (this.zXB != 0) {
                rM += com.google.a.a.b.aD(17, this.zXB);
            }
            if (!Arrays.equals(this.zXC, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(18, this.zXC);
            }
            if (this.zXw != 0) {
                rM += com.google.a.a.b.aE(100, this.zXw);
            }
            if (this.zXx != 0) {
                rM += com.google.a.a.b.aE(101, this.zXx);
            }
            if (this.zWJ != null && this.zWJ.length > 0) {
                while (i2 < this.zWJ.length) {
                    com.google.a.a.e eVar3 = this.zWJ[i2];
                    if (eVar3 != null) {
                        rM += com.google.a.a.b.b(102, eVar3);
                    }
                    i2++;
                }
            }
            return rM;
        }
    }

    public static final class ah extends com.google.a.a.e {
        public au[] zXM;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        int b = com.google.a.a.g.b(aVar, 10);
                        ry = this.zXM == null ? 0 : this.zXM.length;
                        Object obj = new au[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXM, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new au();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new au();
                        aVar.a(obj[ry]);
                        this.zXM = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public ah() {
            this.zXM = au.cDI();
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.zXM != null && this.zXM.length > 0) {
                for (com.google.a.a.e eVar : this.zXM) {
                    if (eVar != null) {
                        bVar.a(1, eVar);
                    }
                }
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.zXM != null && this.zXM.length > 0) {
                for (com.google.a.a.e eVar : this.zXM) {
                    if (eVar != null) {
                        rM += com.google.a.a.b.b(1, eVar);
                    }
                }
            }
            return rM;
        }
    }

    public static final class ai extends com.google.a.a.e {
        public int ret;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.ret = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public ai() {
            this.ret = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.ret != 0) {
                bVar.aB(1, this.ret);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.ret != 0) {
                return rM + com.google.a.a.b.aD(1, this.ret);
            }
            return rM;
        }
    }

    public static final class ao extends com.google.a.a.e {
        private static volatile ao[] zXR;
        public int fps;
        public int nJK;
        public int zXE;
        public int zXS;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.nJK = aVar.rz();
                        continue;
                    case 16:
                        this.zXS = aVar.rz();
                        continue;
                    case 24:
                        this.fps = aVar.rz();
                        continue;
                    case 32:
                        this.zXE = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public static ao[] cDG() {
            if (zXR == null) {
                synchronized (com.google.a.a.c.bfP) {
                    if (zXR == null) {
                        zXR = new ao[0];
                    }
                }
            }
            return zXR;
        }

        public ao() {
            this.nJK = 0;
            this.zXS = 0;
            this.fps = 0;
            this.zXE = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.nJK != 0) {
                bVar.aB(1, this.nJK);
            }
            if (this.zXS != 0) {
                bVar.aB(2, this.zXS);
            }
            if (this.fps != 0) {
                bVar.aB(3, this.fps);
            }
            if (this.zXE != 0) {
                bVar.aB(4, this.zXE);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.nJK != 0) {
                rM += com.google.a.a.b.aD(1, this.nJK);
            }
            if (this.zXS != 0) {
                rM += com.google.a.a.b.aD(2, this.zXS);
            }
            if (this.fps != 0) {
                rM += com.google.a.a.b.aD(3, this.fps);
            }
            if (this.zXE != 0) {
                return rM + com.google.a.a.b.aD(4, this.zXE);
            }
            return rM;
        }
    }

    public static final class b extends com.google.a.a.e {
        public int aAk;
        public String zVY;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        this.zVY = aVar.readString();
                        continue;
                    case 16:
                        this.aAk = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public b() {
            this.zVY = "";
            this.aAk = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.zVY.equals("")) {
                bVar.g(1, this.zVY);
            }
            if (this.aAk != 0) {
                bVar.aB(2, this.aAk);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (!this.zVY.equals("")) {
                rM += com.google.a.a.b.h(1, this.zVY);
            }
            if (this.aAk != 0) {
                return rM + com.google.a.a.b.aD(2, this.aAk);
            }
            return rM;
        }
    }

    public static final class bb extends com.google.a.a.e {
        public String groupId;
        public int srH;
        public long srI;
        public int zWd;
        public av[] zXq;
        public String zYE;
        public int zZo;
        public String zZp;
        public String[] zZq;
        public long zZr;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                int b;
                Object obj;
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.srH = aVar.rz();
                        continue;
                    case 24:
                        this.srI = aVar.rA();
                        continue;
                    case 32:
                        this.zWd = aVar.rz();
                        continue;
                    case 40:
                        this.zZo = aVar.rz();
                        continue;
                    case 50:
                        this.zYE = aVar.readString();
                        continue;
                    case 58:
                        b = com.google.a.a.g.b(aVar, 58);
                        ry = this.zXq == null ? 0 : this.zXq.length;
                        obj = new av[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXq, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new av();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new av();
                        aVar.a(obj[ry]);
                        this.zXq = obj;
                        continue;
                    case 66:
                        this.zZp = aVar.readString();
                        continue;
                    case 74:
                        b = com.google.a.a.g.b(aVar, 74);
                        ry = this.zZq == null ? 0 : this.zZq.length;
                        obj = new String[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zZq, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = aVar.readString();
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = aVar.readString();
                        this.zZq = obj;
                        continue;
                    case 80:
                        this.zZr = aVar.rA();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public bb() {
            this.groupId = "";
            this.srH = 0;
            this.srI = 0;
            this.zWd = 0;
            this.zZo = 0;
            this.zYE = "";
            this.zXq = av.cDJ();
            this.zZp = "";
            this.zZq = com.google.a.a.g.EMPTY_STRING_ARRAY;
            this.zZr = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.srH != 0) {
                bVar.aB(2, this.srH);
            }
            if (this.srI != 0) {
                bVar.k(3, this.srI);
            }
            if (this.zWd != 0) {
                bVar.aC(4, this.zWd);
            }
            if (this.zZo != 0) {
                bVar.aB(5, this.zZo);
            }
            if (!this.zYE.equals("")) {
                bVar.g(6, this.zYE);
            }
            if (this.zXq != null && this.zXq.length > 0) {
                for (com.google.a.a.e eVar : this.zXq) {
                    if (eVar != null) {
                        bVar.a(7, eVar);
                    }
                }
            }
            if (!this.zZp.equals("")) {
                bVar.g(8, this.zZp);
            }
            if (this.zZq != null && this.zZq.length > 0) {
                while (i < this.zZq.length) {
                    String str = this.zZq[i];
                    if (str != null) {
                        bVar.g(9, str);
                    }
                    i++;
                }
            }
            if (this.zZr != 0) {
                bVar.j(10, this.zZr);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int i;
            int i2 = 0;
            int rM = super.rM();
            if (!this.groupId.equals("")) {
                rM += com.google.a.a.b.h(1, this.groupId);
            }
            if (this.srH != 0) {
                rM += com.google.a.a.b.aD(2, this.srH);
            }
            if (this.srI != 0) {
                rM += com.google.a.a.b.m(3, this.srI);
            }
            if (this.zWd != 0) {
                rM += com.google.a.a.b.aE(4, this.zWd);
            }
            if (this.zZo != 0) {
                rM += com.google.a.a.b.aD(5, this.zZo);
            }
            if (!this.zYE.equals("")) {
                rM += com.google.a.a.b.h(6, this.zYE);
            }
            if (this.zXq != null && this.zXq.length > 0) {
                i = rM;
                for (com.google.a.a.e eVar : this.zXq) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(7, eVar);
                    }
                }
                rM = i;
            }
            if (!this.zZp.equals("")) {
                rM += com.google.a.a.b.h(8, this.zZp);
            }
            if (this.zZq != null && this.zZq.length > 0) {
                i = 0;
                int i3 = 0;
                while (i2 < this.zZq.length) {
                    String str = this.zZq[i2];
                    if (str != null) {
                        i3++;
                        i += com.google.a.a.b.bm(str);
                    }
                    i2++;
                }
                rM = (rM + i) + (i3 * 1);
            }
            if (this.zZr != 0) {
                return rM + com.google.a.a.b.l(10, this.zZr);
            }
            return rM;
        }
    }

    public static final class c extends com.google.a.a.e {
        public w[] zVZ;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        int b = com.google.a.a.g.b(aVar, 10);
                        ry = this.zVZ == null ? 0 : this.zVZ.length;
                        Object obj = new w[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zVZ, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new w();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new w();
                        aVar.a(obj[ry]);
                        this.zVZ = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public c() {
            this.zVZ = w.cDE();
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.zVZ != null && this.zVZ.length > 0) {
                for (com.google.a.a.e eVar : this.zVZ) {
                    if (eVar != null) {
                        bVar.a(1, eVar);
                    }
                }
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.zVZ != null && this.zVZ.length > 0) {
                for (com.google.a.a.e eVar : this.zVZ) {
                    if (eVar != null) {
                        rM += com.google.a.a.b.b(1, eVar);
                    }
                }
            }
            return rM;
        }
    }

    public static final class h extends com.google.a.a.e {
        public String groupId;
        public String liU;
        public int nJe;
        public long nJf;
        public long timestamp;

        public h() {
            this.nJe = 0;
            this.nJf = 0;
            this.liU = "";
            this.groupId = "";
            this.timestamp = 0;
            this.bfQ = -1;
        }

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.nJe = aVar.rz();
                        continue;
                    case 16:
                        this.nJf = aVar.rA();
                        continue;
                    case 26:
                        this.liU = aVar.readString();
                        continue;
                    case 34:
                        this.groupId = aVar.readString();
                        continue;
                    case 40:
                        this.timestamp = aVar.rA();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public final void a(com.google.a.a.b bVar) {
            bVar.aB(1, this.nJe);
            bVar.k(2, this.nJf);
            bVar.g(3, this.liU);
            if (!this.groupId.equals("")) {
                bVar.g(4, this.groupId);
            }
            if (this.timestamp != 0) {
                bVar.j(5, this.timestamp);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = ((super.rM() + com.google.a.a.b.aD(1, this.nJe)) + com.google.a.a.b.m(2, this.nJf)) + com.google.a.a.b.h(3, this.liU);
            if (!this.groupId.equals("")) {
                rM += com.google.a.a.b.h(4, this.groupId);
            }
            return this.timestamp != 0 ? rM + com.google.a.a.b.l(5, this.timestamp) : rM;
        }
    }

    public static final class j extends com.google.a.a.e {
        public String groupId;
        public int srH;
        public long srI;
        public ba zWc;
        public int zWe;
        public byte[] zWo;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.srH = aVar.rz();
                        continue;
                    case 24:
                        this.srI = aVar.rA();
                        continue;
                    case 34:
                        if (this.zWc == null) {
                            this.zWc = new ba();
                        }
                        aVar.a(this.zWc);
                        continue;
                    case 40:
                        this.zWe = aVar.rz();
                        continue;
                    case 1602:
                        this.zWo = aVar.readBytes();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public j() {
            this.groupId = "";
            this.srH = 0;
            this.srI = 0;
            this.zWc = null;
            this.zWe = 0;
            this.zWo = com.google.a.a.g.bfX;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.srH != 0) {
                bVar.aB(2, this.srH);
            }
            if (this.srI != 0) {
                bVar.k(3, this.srI);
            }
            if (this.zWc != null) {
                bVar.a(4, this.zWc);
            }
            if (this.zWe != 0) {
                bVar.aC(5, this.zWe);
            }
            if (!Arrays.equals(this.zWo, com.google.a.a.g.bfX)) {
                bVar.a(200, this.zWo);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (!this.groupId.equals("")) {
                rM += com.google.a.a.b.h(1, this.groupId);
            }
            if (this.srH != 0) {
                rM += com.google.a.a.b.aD(2, this.srH);
            }
            if (this.srI != 0) {
                rM += com.google.a.a.b.m(3, this.srI);
            }
            if (this.zWc != null) {
                rM += com.google.a.a.b.b(4, this.zWc);
            }
            if (this.zWe != 0) {
                rM += com.google.a.a.b.aE(5, this.zWe);
            }
            if (Arrays.equals(this.zWo, com.google.a.a.g.bfX)) {
                return rM;
            }
            return rM + com.google.a.a.b.b(200, this.zWo);
        }
    }

    public static final class ad extends com.google.a.a.e {
        public String groupId;
        public int srH;
        public long srI;
        public String zVY;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.srH = aVar.rz();
                        continue;
                    case 24:
                        this.srI = aVar.rA();
                        continue;
                    case 34:
                        this.zVY = aVar.readString();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public ad() {
            this.groupId = "";
            this.srH = 0;
            this.srI = 0;
            this.zVY = "";
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.srH != 0) {
                bVar.aB(2, this.srH);
            }
            if (this.srI != 0) {
                bVar.k(3, this.srI);
            }
            if (!this.zVY.equals("")) {
                bVar.g(4, this.zVY);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (!this.groupId.equals("")) {
                rM += com.google.a.a.b.h(1, this.groupId);
            }
            if (this.srH != 0) {
                rM += com.google.a.a.b.aD(2, this.srH);
            }
            if (this.srI != 0) {
                rM += com.google.a.a.b.m(3, this.srI);
            }
            if (this.zVY.equals("")) {
                return rM;
            }
            return rM + com.google.a.a.b.h(4, this.zVY);
        }
    }

    public static final class af extends com.google.a.a.e {
        public int nJe;
        public long nJf;
        public int zXE;
        public int zXF;
        public int zXG;
        public int zXH;
        public int zXI;
        public int zXJ;
        public int zXK;
        public int zXL;

        public af() {
            this.zXE = 0;
            this.nJe = 0;
            this.nJf = 0;
            this.zXF = 0;
            this.zXG = 0;
            this.zXH = 0;
            this.zXI = 0;
            this.zXJ = 0;
            this.zXK = -1;
            this.zXL = 0;
            this.bfQ = -1;
        }

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.zXE = aVar.rz();
                        continue;
                    case 16:
                        this.nJe = aVar.rz();
                        continue;
                    case 24:
                        this.nJf = aVar.rA();
                        continue;
                    case 32:
                        this.zXF = aVar.rz();
                        continue;
                    case 40:
                        this.zXG = aVar.rz();
                        continue;
                    case R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                        this.zXH = aVar.rz();
                        continue;
                    case 56:
                        this.zXI = aVar.rz();
                        continue;
                    case 64:
                        this.zXJ = aVar.rz();
                        continue;
                    case 72:
                        this.zXK = aVar.rz();
                        continue;
                    case 80:
                        this.zXL = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.zXE != 0) {
                bVar.aC(1, this.zXE);
            }
            if (this.nJe != 0) {
                bVar.aB(2, this.nJe);
            }
            if (this.nJf != 0) {
                bVar.k(3, this.nJf);
            }
            if (this.zXF != 0) {
                bVar.aC(4, this.zXF);
            }
            if (this.zXG != 0) {
                bVar.aC(5, this.zXG);
            }
            if (this.zXH != 0) {
                bVar.aC(6, this.zXH);
            }
            if (this.zXI != 0) {
                bVar.aC(7, this.zXI);
            }
            if (this.zXJ != 0) {
                bVar.aC(8, this.zXJ);
            }
            if (this.zXK != -1) {
                bVar.aB(9, this.zXK);
            }
            if (this.zXL != 0) {
                bVar.aB(10, this.zXL);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.zXE != 0) {
                rM += com.google.a.a.b.aE(1, this.zXE);
            }
            if (this.nJe != 0) {
                rM += com.google.a.a.b.aD(2, this.nJe);
            }
            if (this.nJf != 0) {
                rM += com.google.a.a.b.m(3, this.nJf);
            }
            if (this.zXF != 0) {
                rM += com.google.a.a.b.aE(4, this.zXF);
            }
            if (this.zXG != 0) {
                rM += com.google.a.a.b.aE(5, this.zXG);
            }
            if (this.zXH != 0) {
                rM += com.google.a.a.b.aE(6, this.zXH);
            }
            if (this.zXI != 0) {
                rM += com.google.a.a.b.aE(7, this.zXI);
            }
            if (this.zXJ != 0) {
                rM += com.google.a.a.b.aE(8, this.zXJ);
            }
            if (this.zXK != -1) {
                rM += com.google.a.a.b.aD(9, this.zXK);
            }
            return this.zXL != 0 ? rM + com.google.a.a.b.aD(10, this.zXL) : rM;
        }
    }

    public static final class ak extends com.google.a.a.e {
        public String groupId;
        public int srH;
        public long srI;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.srH = aVar.rz();
                        continue;
                    case 24:
                        this.srI = aVar.rA();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public ak() {
            this.groupId = "";
            this.srH = 0;
            this.srI = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.srH != 0) {
                bVar.aB(2, this.srH);
            }
            if (this.srI != 0) {
                bVar.k(3, this.srI);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (!this.groupId.equals("")) {
                rM += com.google.a.a.b.h(1, this.groupId);
            }
            if (this.srH != 0) {
                rM += com.google.a.a.b.aD(2, this.srH);
            }
            if (this.srI != 0) {
                return rM + com.google.a.a.b.m(3, this.srI);
            }
            return rM;
        }
    }

    public static final class am extends com.google.a.a.e {
        private static volatile am[] zXN;
        public int nJK;
        public int vJp;
        public String zXO;
        public int zXP;

        public am() {
            this.nJK = 0;
            this.zXO = "";
            this.vJp = 0;
            this.zXP = 0;
            this.bfQ = -1;
        }

        public static am[] cDF() {
            if (zXN == null) {
                synchronized (com.google.a.a.c.bfP) {
                    if (zXN == null) {
                        zXN = new am[0];
                    }
                }
            }
            return zXN;
        }

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.nJK = aVar.rz();
                        continue;
                    case 18:
                        this.zXO = aVar.readString();
                        continue;
                    case 24:
                        this.vJp = aVar.rz();
                        continue;
                    case 32:
                        this.zXP = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.nJK != 0) {
                bVar.aC(1, this.nJK);
            }
            if (!this.zXO.equals("")) {
                bVar.g(2, this.zXO);
            }
            if (this.vJp != 0) {
                bVar.aC(3, this.vJp);
            }
            if (this.zXP != 0) {
                bVar.aC(4, this.zXP);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.nJK != 0) {
                rM += com.google.a.a.b.aE(1, this.nJK);
            }
            if (!this.zXO.equals("")) {
                rM += com.google.a.a.b.h(2, this.zXO);
            }
            if (this.vJp != 0) {
                rM += com.google.a.a.b.aE(3, this.vJp);
            }
            return this.zXP != 0 ? rM + com.google.a.a.b.aE(4, this.zXP) : rM;
        }
    }

    public static final class at extends com.google.a.a.e {
        public byte[] bjO;
        public int fws;
        public String name;
        public byte[] zYA;
        public int zYB;
        public n[] zYC;
        public byte[] zYj;
        public long zYk;
        public byte[] zYl;
        public byte[] zYm;
        public byte[] zYn;
        public ax zYo;
        public byte[] zYp;
        public ap zYq;
        public String zYr;
        public String zYs;
        public long zYt;
        public byte[] zYu;
        public byte[] zYv;
        public byte[] zYw;
        public byte[] zYx;
        public int zYy;
        public byte[] zYz;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        this.name = aVar.readString();
                        continue;
                    case 18:
                        this.zYj = aVar.readBytes();
                        continue;
                    case 24:
                        this.fws = aVar.rz();
                        continue;
                    case 32:
                        this.zYk = aVar.rA();
                        continue;
                    case R.styleable.AppCompatTheme_dialogTheme /*42*/:
                        this.zYl = aVar.readBytes();
                        continue;
                    case 50:
                        this.zYm = aVar.readBytes();
                        continue;
                    case 58:
                        this.zYn = aVar.readBytes();
                        continue;
                    case 66:
                        if (this.zYo == null) {
                            this.zYo = new ax();
                        }
                        aVar.a(this.zYo);
                        continue;
                    case 74:
                        this.zYp = aVar.readBytes();
                        continue;
                    case 82:
                        if (this.zYq == null) {
                            this.zYq = new ap();
                        }
                        aVar.a(this.zYq);
                        continue;
                    case 802:
                        this.zYr = aVar.readString();
                        continue;
                    case 810:
                        this.zYs = aVar.readString();
                        continue;
                    case 1600:
                        this.zYt = aVar.rA();
                        continue;
                    case 1610:
                        this.zYu = aVar.readBytes();
                        continue;
                    case 1618:
                        this.zYv = aVar.readBytes();
                        continue;
                    case 1626:
                        this.zYw = aVar.readBytes();
                        continue;
                    case 1634:
                        this.zYx = aVar.readBytes();
                        continue;
                    case 1760:
                        this.zYy = aVar.rz();
                        continue;
                    case 1770:
                        this.zYz = aVar.readBytes();
                        continue;
                    case 1778:
                        this.zYA = aVar.readBytes();
                        continue;
                    case 1786:
                        this.bjO = aVar.readBytes();
                        continue;
                    case 1792:
                        this.zYB = aVar.rz();
                        continue;
                    case 1802:
                        int b = com.google.a.a.g.b(aVar, 1802);
                        ry = this.zYC == null ? 0 : this.zYC.length;
                        Object obj = new n[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zYC, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new n();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new n();
                        aVar.a(obj[ry]);
                        this.zYC = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public at() {
            this.name = "";
            this.zYj = com.google.a.a.g.bfX;
            this.fws = 0;
            this.zYk = 0;
            this.zYl = com.google.a.a.g.bfX;
            this.zYm = com.google.a.a.g.bfX;
            this.zYn = com.google.a.a.g.bfX;
            this.zYo = null;
            this.zYp = com.google.a.a.g.bfX;
            this.zYq = null;
            this.zYr = "";
            this.zYs = "";
            this.zYt = 0;
            this.zYu = com.google.a.a.g.bfX;
            this.zYv = com.google.a.a.g.bfX;
            this.zYw = com.google.a.a.g.bfX;
            this.zYx = com.google.a.a.g.bfX;
            this.zYy = 0;
            this.zYz = com.google.a.a.g.bfX;
            this.zYA = com.google.a.a.g.bfX;
            this.bjO = com.google.a.a.g.bfX;
            this.zYB = 0;
            this.zYC = n.cDC();
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.name.equals("")) {
                bVar.g(1, this.name);
            }
            if (!Arrays.equals(this.zYj, com.google.a.a.g.bfX)) {
                bVar.a(2, this.zYj);
            }
            if (this.fws != 0) {
                bVar.aB(3, this.fws);
            }
            if (this.zYk != 0) {
                bVar.j(4, this.zYk);
            }
            if (!Arrays.equals(this.zYl, com.google.a.a.g.bfX)) {
                bVar.a(5, this.zYl);
            }
            if (!Arrays.equals(this.zYm, com.google.a.a.g.bfX)) {
                bVar.a(6, this.zYm);
            }
            if (!Arrays.equals(this.zYn, com.google.a.a.g.bfX)) {
                bVar.a(7, this.zYn);
            }
            if (this.zYo != null) {
                bVar.a(8, this.zYo);
            }
            if (!Arrays.equals(this.zYp, com.google.a.a.g.bfX)) {
                bVar.a(9, this.zYp);
            }
            if (this.zYq != null) {
                bVar.a(10, this.zYq);
            }
            if (!this.zYr.equals("")) {
                bVar.g(100, this.zYr);
            }
            if (!this.zYs.equals("")) {
                bVar.g(101, this.zYs);
            }
            if (this.zYt != 0) {
                bVar.j(200, this.zYt);
            }
            if (!Arrays.equals(this.zYu, com.google.a.a.g.bfX)) {
                bVar.a(201, this.zYu);
            }
            if (!Arrays.equals(this.zYv, com.google.a.a.g.bfX)) {
                bVar.a(202, this.zYv);
            }
            if (!Arrays.equals(this.zYw, com.google.a.a.g.bfX)) {
                bVar.a(203, this.zYw);
            }
            if (!Arrays.equals(this.zYx, com.google.a.a.g.bfX)) {
                bVar.a((int) com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX, this.zYx);
            }
            if (this.zYy != 0) {
                bVar.aB(220, this.zYy);
            }
            if (!Arrays.equals(this.zYz, com.google.a.a.g.bfX)) {
                bVar.a(221, this.zYz);
            }
            if (!Arrays.equals(this.zYA, com.google.a.a.g.bfX)) {
                bVar.a(222, this.zYA);
            }
            if (!Arrays.equals(this.bjO, com.google.a.a.g.bfX)) {
                bVar.a(223, this.bjO);
            }
            if (this.zYB != 0) {
                bVar.aC(224, this.zYB);
            }
            if (this.zYC != null && this.zYC.length > 0) {
                for (com.google.a.a.e eVar : this.zYC) {
                    if (eVar != null) {
                        bVar.a(225, eVar);
                    }
                }
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (!this.name.equals("")) {
                rM += com.google.a.a.b.h(1, this.name);
            }
            if (!Arrays.equals(this.zYj, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(2, this.zYj);
            }
            if (this.fws != 0) {
                rM += com.google.a.a.b.aD(3, this.fws);
            }
            if (this.zYk != 0) {
                rM += com.google.a.a.b.l(4, this.zYk);
            }
            if (!Arrays.equals(this.zYl, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(5, this.zYl);
            }
            if (!Arrays.equals(this.zYm, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(6, this.zYm);
            }
            if (!Arrays.equals(this.zYn, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(7, this.zYn);
            }
            if (this.zYo != null) {
                rM += com.google.a.a.b.b(8, this.zYo);
            }
            if (!Arrays.equals(this.zYp, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(9, this.zYp);
            }
            if (this.zYq != null) {
                rM += com.google.a.a.b.b(10, this.zYq);
            }
            if (!this.zYr.equals("")) {
                rM += com.google.a.a.b.h(100, this.zYr);
            }
            if (!this.zYs.equals("")) {
                rM += com.google.a.a.b.h(101, this.zYs);
            }
            if (this.zYt != 0) {
                rM += com.google.a.a.b.l(200, this.zYt);
            }
            if (!Arrays.equals(this.zYu, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(201, this.zYu);
            }
            if (!Arrays.equals(this.zYv, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(202, this.zYv);
            }
            if (!Arrays.equals(this.zYw, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(203, this.zYw);
            }
            if (!Arrays.equals(this.zYx, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b((int) com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX, this.zYx);
            }
            if (this.zYy != 0) {
                rM += com.google.a.a.b.aD(220, this.zYy);
            }
            if (!Arrays.equals(this.zYz, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(221, this.zYz);
            }
            if (!Arrays.equals(this.zYA, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(222, this.zYA);
            }
            if (!Arrays.equals(this.bjO, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(223, this.bjO);
            }
            if (this.zYB != 0) {
                rM += com.google.a.a.b.aE(224, this.zYB);
            }
            if (this.zYC == null || this.zYC.length <= 0) {
                return rM;
            }
            int i = rM;
            for (com.google.a.a.e eVar : this.zYC) {
                if (eVar != null) {
                    i += com.google.a.a.b.b(225, eVar);
                }
            }
            return i;
        }
    }

    public static final class au extends com.google.a.a.e {
        private static volatile au[] zYD;
        public String groupId;
        public int srH;
        public long srI;
        public int zWd;
        public av[] zXq;
        public String zYE;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.srH = aVar.rz();
                        continue;
                    case 24:
                        this.srI = aVar.rA();
                        continue;
                    case 34:
                        int b = com.google.a.a.g.b(aVar, 34);
                        ry = this.zXq == null ? 0 : this.zXq.length;
                        Object obj = new av[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXq, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new av();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new av();
                        aVar.a(obj[ry]);
                        this.zXq = obj;
                        continue;
                    case 40:
                        this.zWd = aVar.rz();
                        continue;
                    case 50:
                        this.zYE = aVar.readString();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public static au[] cDI() {
            if (zYD == null) {
                synchronized (com.google.a.a.c.bfP) {
                    if (zYD == null) {
                        zYD = new au[0];
                    }
                }
            }
            return zYD;
        }

        public au() {
            this.groupId = "";
            this.srH = 0;
            this.srI = 0;
            this.zXq = av.cDJ();
            this.zWd = 0;
            this.zYE = "";
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.srH != 0) {
                bVar.aB(2, this.srH);
            }
            if (this.srI != 0) {
                bVar.k(3, this.srI);
            }
            if (this.zXq != null && this.zXq.length > 0) {
                for (com.google.a.a.e eVar : this.zXq) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.zWd != 0) {
                bVar.aC(5, this.zWd);
            }
            if (!this.zYE.equals("")) {
                bVar.g(6, this.zYE);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (!this.groupId.equals("")) {
                rM += com.google.a.a.b.h(1, this.groupId);
            }
            if (this.srH != 0) {
                rM += com.google.a.a.b.aD(2, this.srH);
            }
            if (this.srI != 0) {
                rM += com.google.a.a.b.m(3, this.srI);
            }
            if (this.zXq != null && this.zXq.length > 0) {
                int i = rM;
                for (com.google.a.a.e eVar : this.zXq) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(4, eVar);
                    }
                }
                rM = i;
            }
            if (this.zWd != 0) {
                rM += com.google.a.a.b.aE(5, this.zWd);
            }
            if (this.zYE.equals("")) {
                return rM;
            }
            return rM + com.google.a.a.b.h(6, this.zYE);
        }
    }

    public static final class av extends com.google.a.a.e {
        private static volatile av[] zYF;
        public int aAk;
        public int nJK;
        public int sCH;
        public int status;
        public int vJp;
        public int zWj;
        public byte[] zWo;
        public String zXO;
        public int zYG;
        public int zYH;
        public aq zYI;
        public int zYJ;
        public String zYK;
        public ar[] zYL;
        public int zYM;
        public int[] zYN;
        public int zYO;
        public int zYP;
        public int zYQ;
        public int zYR;
        public an zYS;
        public String zYT;
        public int zYU;
        public s zYV;
        public int zYW;
        public String zYX;
        public int zYY;
        public int zYZ;
        public int zZa;
        public int zZb;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                int b;
                Object obj;
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.vJp = aVar.rz();
                        continue;
                    case 16:
                        this.zYG = aVar.rz();
                        continue;
                    case 24:
                        this.status = aVar.rz();
                        continue;
                    case 32:
                        this.aAk = aVar.rz();
                        continue;
                    case 40:
                        this.nJK = aVar.rz();
                        continue;
                    case R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                        this.zYH = aVar.rz();
                        continue;
                    case 58:
                        if (this.zYI == null) {
                            this.zYI = new aq();
                        }
                        aVar.a(this.zYI);
                        continue;
                    case 64:
                        this.zYJ = aVar.rz();
                        continue;
                    case 74:
                        this.zYK = aVar.readString();
                        continue;
                    case 82:
                        b = com.google.a.a.g.b(aVar, 82);
                        ry = this.zYL == null ? 0 : this.zYL.length;
                        obj = new ar[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zYL, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new ar();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new ar();
                        aVar.a(obj[ry]);
                        this.zYL = obj;
                        continue;
                    case R.styleable.AppCompatTheme_colorButtonNormal /*88*/:
                        this.zYM = aVar.rz();
                        continue;
                    case 96:
                        b = com.google.a.a.g.b(aVar, 96);
                        ry = this.zYN == null ? 0 : this.zYN.length;
                        obj = new int[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zYN, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = aVar.rz();
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = aVar.rz();
                        this.zYN = obj;
                        continue;
                    case 98:
                        int dQ = aVar.dQ(aVar.rz());
                        b = aVar.getPosition();
                        ry = 0;
                        while (aVar.rC() > 0) {
                            aVar.rz();
                            ry++;
                        }
                        aVar.dS(b);
                        b = this.zYN == null ? 0 : this.zYN.length;
                        Object obj2 = new int[(ry + b)];
                        if (b != 0) {
                            System.arraycopy(this.zYN, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = aVar.rz();
                            b++;
                        }
                        this.zYN = obj2;
                        aVar.dR(dQ);
                        continue;
                    case 104:
                        this.zYO = aVar.rz();
                        continue;
                    case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
                        this.zYP = aVar.rz();
                        continue;
                    case 120:
                        this.zYQ = aVar.rz();
                        continue;
                    case FileUtils.S_IWUSR /*128*/:
                        this.zYR = aVar.rz();
                        continue;
                    case 138:
                        if (this.zYS == null) {
                            this.zYS = new an();
                        }
                        aVar.a(this.zYS);
                        continue;
                    case 802:
                        this.zXO = aVar.readString();
                        continue;
                    case 810:
                        this.zYT = aVar.readString();
                        continue;
                    case 816:
                        this.zYU = aVar.rz();
                        continue;
                    case 1602:
                        this.zWo = aVar.readBytes();
                        continue;
                    case 1610:
                        if (this.zYV == null) {
                            this.zYV = new s();
                        }
                        aVar.a(this.zYV);
                        continue;
                    case 1616:
                        this.zYW = aVar.rz();
                        continue;
                    case 1626:
                        this.zYX = aVar.readString();
                        continue;
                    case 1632:
                        this.zYY = aVar.rz();
                        continue;
                    case 1640:
                        this.zYZ = aVar.rz();
                        continue;
                    case 1648:
                        this.sCH = aVar.rz();
                        continue;
                    case 1656:
                        this.zZa = aVar.rz();
                        continue;
                    case 1664:
                        this.zZb = aVar.rz();
                        continue;
                    case 1920:
                        this.zWj = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public static av[] cDJ() {
            if (zYF == null) {
                synchronized (com.google.a.a.c.bfP) {
                    if (zYF == null) {
                        zYF = new av[0];
                    }
                }
            }
            return zYF;
        }

        public av() {
            this.vJp = 0;
            this.zYG = 0;
            this.status = 0;
            this.aAk = 0;
            this.nJK = -1;
            this.zYH = 0;
            this.zYI = null;
            this.zYJ = 0;
            this.zYK = "";
            this.zYL = ar.cDH();
            this.zYM = 0;
            this.zYN = com.google.a.a.g.bfR;
            this.zYO = 0;
            this.zYP = 0;
            this.zYQ = 0;
            this.zYR = 0;
            this.zYS = null;
            this.zXO = "";
            this.zYT = "";
            this.zYU = 0;
            this.zWo = com.google.a.a.g.bfX;
            this.zYV = null;
            this.zYW = -1;
            this.zYX = "";
            this.zYY = 0;
            this.zYZ = 0;
            this.sCH = 0;
            this.zZa = 0;
            this.zZb = 0;
            this.zWj = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (this.vJp != 0) {
                bVar.aC(1, this.vJp);
            }
            if (this.zYG != 0) {
                bVar.aC(2, this.zYG);
            }
            if (this.status != 0) {
                bVar.aC(3, this.status);
            }
            if (this.aAk != 0) {
                bVar.aC(4, this.aAk);
            }
            if (this.nJK != -1) {
                bVar.aB(5, this.nJK);
            }
            if (this.zYH != 0) {
                bVar.aC(6, this.zYH);
            }
            if (this.zYI != null) {
                bVar.a(7, this.zYI);
            }
            if (this.zYJ != 0) {
                bVar.aC(8, this.zYJ);
            }
            if (!this.zYK.equals("")) {
                bVar.g(9, this.zYK);
            }
            if (this.zYL != null && this.zYL.length > 0) {
                for (com.google.a.a.e eVar : this.zYL) {
                    if (eVar != null) {
                        bVar.a(10, eVar);
                    }
                }
            }
            if (this.zYM != 0) {
                bVar.aC(11, this.zYM);
            }
            if (this.zYN != null && this.zYN.length > 0) {
                while (i < this.zYN.length) {
                    bVar.aC(12, this.zYN[i]);
                    i++;
                }
            }
            if (this.zYO != 0) {
                bVar.aC(13, this.zYO);
            }
            if (this.zYP != 0) {
                bVar.aC(14, this.zYP);
            }
            if (this.zYQ != 0) {
                bVar.aC(15, this.zYQ);
            }
            if (this.zYR != 0) {
                bVar.aC(16, this.zYR);
            }
            if (this.zYS != null) {
                bVar.a(17, this.zYS);
            }
            if (!this.zXO.equals("")) {
                bVar.g(100, this.zXO);
            }
            if (!this.zYT.equals("")) {
                bVar.g(101, this.zYT);
            }
            if (this.zYU != 0) {
                bVar.aC(102, this.zYU);
            }
            if (!Arrays.equals(this.zWo, com.google.a.a.g.bfX)) {
                bVar.a(200, this.zWo);
            }
            if (this.zYV != null) {
                bVar.a(201, this.zYV);
            }
            if (this.zYW != -1) {
                bVar.aB(202, this.zYW);
            }
            if (!this.zYX.equals("")) {
                bVar.g(203, this.zYX);
            }
            if (this.zYY != 0) {
                bVar.aB(com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX, this.zYY);
            }
            if (this.zYZ != 0) {
                bVar.aC(com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX, this.zYZ);
            }
            if (this.sCH != 0) {
                bVar.aC(com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX, this.sCH);
            }
            if (this.zZa != 0) {
                bVar.aC(207, this.zZa);
            }
            if (this.zZb != 0) {
                bVar.aC(com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX, this.zZb);
            }
            if (this.zWj != 0) {
                bVar.aC(240, this.zWj);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int i;
            int i2 = 0;
            int rM = super.rM();
            if (this.vJp != 0) {
                rM += com.google.a.a.b.aE(1, this.vJp);
            }
            if (this.zYG != 0) {
                rM += com.google.a.a.b.aE(2, this.zYG);
            }
            if (this.status != 0) {
                rM += com.google.a.a.b.aE(3, this.status);
            }
            if (this.aAk != 0) {
                rM += com.google.a.a.b.aE(4, this.aAk);
            }
            if (this.nJK != -1) {
                rM += com.google.a.a.b.aD(5, this.nJK);
            }
            if (this.zYH != 0) {
                rM += com.google.a.a.b.aE(6, this.zYH);
            }
            if (this.zYI != null) {
                rM += com.google.a.a.b.b(7, this.zYI);
            }
            if (this.zYJ != 0) {
                rM += com.google.a.a.b.aE(8, this.zYJ);
            }
            if (!this.zYK.equals("")) {
                rM += com.google.a.a.b.h(9, this.zYK);
            }
            if (this.zYL != null && this.zYL.length > 0) {
                i = rM;
                for (com.google.a.a.e eVar : this.zYL) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(10, eVar);
                    }
                }
                rM = i;
            }
            if (this.zYM != 0) {
                rM += com.google.a.a.b.aE(11, this.zYM);
            }
            if (this.zYN != null && this.zYN.length > 0) {
                i = 0;
                while (i2 < this.zYN.length) {
                    i += com.google.a.a.b.dZ(this.zYN[i2]);
                    i2++;
                }
                rM = (rM + i) + (this.zYN.length * 1);
            }
            if (this.zYO != 0) {
                rM += com.google.a.a.b.aE(13, this.zYO);
            }
            if (this.zYP != 0) {
                rM += com.google.a.a.b.aE(14, this.zYP);
            }
            if (this.zYQ != 0) {
                rM += com.google.a.a.b.aE(15, this.zYQ);
            }
            if (this.zYR != 0) {
                rM += com.google.a.a.b.aE(16, this.zYR);
            }
            if (this.zYS != null) {
                rM += com.google.a.a.b.b(17, this.zYS);
            }
            if (!this.zXO.equals("")) {
                rM += com.google.a.a.b.h(100, this.zXO);
            }
            if (!this.zYT.equals("")) {
                rM += com.google.a.a.b.h(101, this.zYT);
            }
            if (this.zYU != 0) {
                rM += com.google.a.a.b.aE(102, this.zYU);
            }
            if (!Arrays.equals(this.zWo, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(200, this.zWo);
            }
            if (this.zYV != null) {
                rM += com.google.a.a.b.b(201, this.zYV);
            }
            if (this.zYW != -1) {
                rM += com.google.a.a.b.aD(202, this.zYW);
            }
            if (!this.zYX.equals("")) {
                rM += com.google.a.a.b.h(203, this.zYX);
            }
            if (this.zYY != 0) {
                rM += com.google.a.a.b.aD(com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX, this.zYY);
            }
            if (this.zYZ != 0) {
                rM += com.google.a.a.b.aE(com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX, this.zYZ);
            }
            if (this.sCH != 0) {
                rM += com.google.a.a.b.aE(com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX, this.sCH);
            }
            if (this.zZa != 0) {
                rM += com.google.a.a.b.aE(207, this.zZa);
            }
            if (this.zZb != 0) {
                rM += com.google.a.a.b.aE(com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX, this.zZb);
            }
            if (this.zWj != 0) {
                return rM + com.google.a.a.b.aE(240, this.zWj);
            }
            return rM;
        }
    }

    public static final class aw extends com.google.a.a.e {
        private static volatile aw[] zZc;
        public String pIQ;
        public String username;
        public int vJp;
        public long zZd;
        public String zZe;
        public String zZf;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.vJp = aVar.rz();
                        continue;
                    case 18:
                        this.username = aVar.readString();
                        continue;
                    case 26:
                        this.pIQ = aVar.readString();
                        continue;
                    case 32:
                        this.zZd = aVar.rA();
                        continue;
                    case R.styleable.AppCompatTheme_dialogTheme /*42*/:
                        this.zZe = aVar.readString();
                        continue;
                    case 50:
                        this.zZf = aVar.readString();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public static aw[] cDK() {
            if (zZc == null) {
                synchronized (com.google.a.a.c.bfP) {
                    if (zZc == null) {
                        zZc = new aw[0];
                    }
                }
            }
            return zZc;
        }

        public aw() {
            this.vJp = 0;
            this.username = "";
            this.pIQ = "";
            this.zZd = 0;
            this.zZe = "";
            this.zZf = "";
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.vJp != 0) {
                bVar.aC(1, this.vJp);
            }
            if (!this.username.equals("")) {
                bVar.g(2, this.username);
            }
            if (!this.pIQ.equals("")) {
                bVar.g(3, this.pIQ);
            }
            if (this.zZd != 0) {
                bVar.j(4, this.zZd);
            }
            if (!this.zZe.equals("")) {
                bVar.g(5, this.zZe);
            }
            if (!this.zZf.equals("")) {
                bVar.g(6, this.zZf);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.vJp != 0) {
                rM += com.google.a.a.b.aE(1, this.vJp);
            }
            if (!this.username.equals("")) {
                rM += com.google.a.a.b.h(2, this.username);
            }
            if (!this.pIQ.equals("")) {
                rM += com.google.a.a.b.h(3, this.pIQ);
            }
            if (this.zZd != 0) {
                rM += com.google.a.a.b.l(4, this.zZd);
            }
            if (!this.zZe.equals("")) {
                rM += com.google.a.a.b.h(5, this.zZe);
            }
            if (this.zZf.equals("")) {
                return rM;
            }
            return rM + com.google.a.a.b.h(6, this.zZf);
        }
    }

    public static final class f extends com.google.a.a.e {
        public int aAk;
        public String groupId;
        public int srH;
        public long srI;
        public int zWn;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.srH = aVar.rz();
                        continue;
                    case 24:
                        this.srI = aVar.rA();
                        continue;
                    case 32:
                        this.aAk = aVar.rz();
                        continue;
                    case 40:
                        this.zWn = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public f() {
            this.groupId = "";
            this.srH = 0;
            this.srI = 0;
            this.aAk = 0;
            this.zWn = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.srH != 0) {
                bVar.aB(2, this.srH);
            }
            if (this.srI != 0) {
                bVar.k(3, this.srI);
            }
            if (this.aAk != 0) {
                bVar.aB(4, this.aAk);
            }
            if (this.zWn != 0) {
                bVar.aB(5, this.zWn);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (!this.groupId.equals("")) {
                rM += com.google.a.a.b.h(1, this.groupId);
            }
            if (this.srH != 0) {
                rM += com.google.a.a.b.aD(2, this.srH);
            }
            if (this.srI != 0) {
                rM += com.google.a.a.b.m(3, this.srI);
            }
            if (this.aAk != 0) {
                rM += com.google.a.a.b.aD(4, this.aAk);
            }
            if (this.zWn != 0) {
                return rM + com.google.a.a.b.aD(5, this.zWn);
            }
            return rM;
        }
    }

    public static final class m extends com.google.a.a.e {
        private static volatile m[] zWv;
        public String fqG;
        public int vJp;
        public String zWw;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.vJp = aVar.rz();
                        continue;
                    case 18:
                        this.fqG = aVar.readString();
                        continue;
                    case 26:
                        this.zWw = aVar.readString();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public static m[] cDB() {
            if (zWv == null) {
                synchronized (com.google.a.a.c.bfP) {
                    if (zWv == null) {
                        zWv = new m[0];
                    }
                }
            }
            return zWv;
        }

        public m() {
            this.vJp = 0;
            this.fqG = "";
            this.zWw = "";
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.vJp != 0) {
                bVar.aC(1, this.vJp);
            }
            if (!this.fqG.equals("")) {
                bVar.g(2, this.fqG);
            }
            if (!this.zWw.equals("")) {
                bVar.g(3, this.zWw);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.vJp != 0) {
                rM += com.google.a.a.b.aE(1, this.vJp);
            }
            if (!this.fqG.equals("")) {
                rM += com.google.a.a.b.h(2, this.fqG);
            }
            if (this.zWw.equals("")) {
                return rM;
            }
            return rM + com.google.a.a.b.h(3, this.zWw);
        }
    }

    public static final class o extends com.google.a.a.e {
        private static volatile o[] zWA;
        public int port;
        public int zWB;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.zWB = aVar.rz();
                        continue;
                    case 16:
                        this.port = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public static o[] cDD() {
            if (zWA == null) {
                synchronized (com.google.a.a.c.bfP) {
                    if (zWA == null) {
                        zWA = new o[0];
                    }
                }
            }
            return zWA;
        }

        public o() {
            this.zWB = 0;
            this.port = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.zWB != 0) {
                bVar.aC(1, this.zWB);
            }
            if (this.port != 0) {
                bVar.aB(2, this.port);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.zWB != 0) {
                rM += com.google.a.a.b.aE(1, this.zWB);
            }
            if (this.port != 0) {
                return rM + com.google.a.a.b.aD(2, this.port);
            }
            return rM;
        }
    }

    public static final class q extends com.google.a.a.e {
        public int zWK;

        public q() {
            this.zWK = 0;
            this.bfQ = -1;
        }

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.zWK = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public final void a(com.google.a.a.b bVar) {
            bVar.aC(1, this.zWK);
            super.a(bVar);
        }

        protected final int rM() {
            return super.rM() + com.google.a.a.b.aE(1, this.zWK);
        }
    }

    public static final class s extends com.google.a.a.e {
        public String username;
        public long vUv;
        public long vUw;
        public String xps;
        public String zWM;
        public String zWN;
        public int zWO;
        public String zWP;
        public long zWQ;
        public int zWR;
        public long zWS;
        public int zWT;
        public String zWw;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.vUv = aVar.rA();
                        continue;
                    case 18:
                        this.zWM = aVar.readString();
                        continue;
                    case 26:
                        this.zWN = aVar.readString();
                        continue;
                    case 32:
                        this.zWO = aVar.rz();
                        continue;
                    case R.styleable.AppCompatTheme_dialogTheme /*42*/:
                        this.username = aVar.readString();
                        continue;
                    case 50:
                        this.zWP = aVar.readString();
                        continue;
                    case 58:
                        this.zWw = aVar.readString();
                        continue;
                    case 64:
                        this.zWQ = aVar.rA();
                        continue;
                    case 72:
                        this.zWR = aVar.rz();
                        continue;
                    case 82:
                        this.xps = aVar.readString();
                        continue;
                    case R.styleable.AppCompatTheme_colorButtonNormal /*88*/:
                        this.zWS = aVar.rA();
                        continue;
                    case 96:
                        this.zWT = aVar.rz();
                        continue;
                    case 104:
                        this.vUw = aVar.rA();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public s() {
            this.vUv = 0;
            this.zWM = "";
            this.zWN = "";
            this.zWO = 1;
            this.username = "";
            this.zWP = "";
            this.zWw = "";
            this.zWQ = 0;
            this.zWR = 0;
            this.xps = "";
            this.zWS = 0;
            this.zWT = 0;
            this.vUw = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.vUv != 0) {
                bVar.j(1, this.vUv);
            }
            if (!this.zWM.equals("")) {
                bVar.g(2, this.zWM);
            }
            if (!this.zWN.equals("")) {
                bVar.g(3, this.zWN);
            }
            if (this.zWO != 1) {
                bVar.aB(4, this.zWO);
            }
            if (!this.username.equals("")) {
                bVar.g(5, this.username);
            }
            if (!this.zWP.equals("")) {
                bVar.g(6, this.zWP);
            }
            if (!this.zWw.equals("")) {
                bVar.g(7, this.zWw);
            }
            if (this.zWQ != 0) {
                bVar.j(8, this.zWQ);
            }
            if (this.zWR != 0) {
                bVar.aC(9, this.zWR);
            }
            if (!this.xps.equals("")) {
                bVar.g(10, this.xps);
            }
            if (this.zWS != 0) {
                bVar.j(11, this.zWS);
            }
            if (this.zWT != 0) {
                bVar.aC(12, this.zWT);
            }
            if (this.vUw != 0) {
                bVar.j(13, this.vUw);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.vUv != 0) {
                rM += com.google.a.a.b.l(1, this.vUv);
            }
            if (!this.zWM.equals("")) {
                rM += com.google.a.a.b.h(2, this.zWM);
            }
            if (!this.zWN.equals("")) {
                rM += com.google.a.a.b.h(3, this.zWN);
            }
            if (this.zWO != 1) {
                rM += com.google.a.a.b.aD(4, this.zWO);
            }
            if (!this.username.equals("")) {
                rM += com.google.a.a.b.h(5, this.username);
            }
            if (!this.zWP.equals("")) {
                rM += com.google.a.a.b.h(6, this.zWP);
            }
            if (!this.zWw.equals("")) {
                rM += com.google.a.a.b.h(7, this.zWw);
            }
            if (this.zWQ != 0) {
                rM += com.google.a.a.b.l(8, this.zWQ);
            }
            if (this.zWR != 0) {
                rM += com.google.a.a.b.aE(9, this.zWR);
            }
            if (!this.xps.equals("")) {
                rM += com.google.a.a.b.h(10, this.xps);
            }
            if (this.zWS != 0) {
                rM += com.google.a.a.b.l(11, this.zWS);
            }
            if (this.zWT != 0) {
                rM += com.google.a.a.b.aE(12, this.zWT);
            }
            if (this.vUw != 0) {
                return rM + com.google.a.a.b.l(13, this.vUw);
            }
            return rM;
        }
    }

    public static final class t extends com.google.a.a.e {
        public byte[] data;
        public String iconUrl;
        public String lUI;
        public int status;
        public int zWU;
        public byte[] zWV;
        public byte[] zWW;
        public byte[] zWX;
        public int zWY;
        public int zWZ;
        public byte[] zXa;
        public byte[] zXb;
        public byte[] zXc;
        public byte[] zXd;
        public byte[] zXe;
        public byte[] zXf;
        public byte[] zXg;
        public byte[] zXh;
        public byte[] zXi;
        public byte[] zXj;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.zWU = aVar.rz();
                        continue;
                    case 18:
                        this.zWV = aVar.readBytes();
                        continue;
                    case 26:
                        this.iconUrl = aVar.readString();
                        continue;
                    case 34:
                        this.zWW = aVar.readBytes();
                        continue;
                    case R.styleable.AppCompatTheme_dialogTheme /*42*/:
                        this.zWX = aVar.readBytes();
                        continue;
                    case R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                        this.zWY = aVar.rz();
                        continue;
                    case 58:
                        this.data = aVar.readBytes();
                        continue;
                    case 64:
                        this.zWZ = aVar.rz();
                        continue;
                    case 74:
                        this.zXa = aVar.readBytes();
                        continue;
                    case 82:
                        this.lUI = aVar.readString();
                        continue;
                    case 90:
                        this.zXb = aVar.readBytes();
                        continue;
                    case 98:
                        this.zXc = aVar.readBytes();
                        continue;
                    case 106:
                        this.zXd = aVar.readBytes();
                        continue;
                    case 114:
                        this.zXe = aVar.readBytes();
                        continue;
                    case 122:
                        this.zXf = aVar.readBytes();
                        continue;
                    case 130:
                        this.zXg = aVar.readBytes();
                        continue;
                    case 138:
                        this.zXh = aVar.readBytes();
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX /*146*/:
                        this.zXi = aVar.readBytes();
                        continue;
                    case JsApiMakeVoIPCall.CTRL_INDEX /*154*/:
                        this.zXj = aVar.readBytes();
                        continue;
                    case JsApiSetBackgroundAudioState.CTRL_INDEX /*160*/:
                        this.status = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public t() {
            this.zWU = 0;
            this.zWV = com.google.a.a.g.bfX;
            this.iconUrl = "";
            this.zWW = com.google.a.a.g.bfX;
            this.zWX = com.google.a.a.g.bfX;
            this.zWY = 0;
            this.data = com.google.a.a.g.bfX;
            this.zWZ = 0;
            this.zXa = com.google.a.a.g.bfX;
            this.lUI = "";
            this.zXb = com.google.a.a.g.bfX;
            this.zXc = com.google.a.a.g.bfX;
            this.zXd = com.google.a.a.g.bfX;
            this.zXe = com.google.a.a.g.bfX;
            this.zXf = com.google.a.a.g.bfX;
            this.zXg = com.google.a.a.g.bfX;
            this.zXh = com.google.a.a.g.bfX;
            this.zXi = com.google.a.a.g.bfX;
            this.zXj = com.google.a.a.g.bfX;
            this.status = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.zWU != 0) {
                bVar.aC(1, this.zWU);
            }
            if (!Arrays.equals(this.zWV, com.google.a.a.g.bfX)) {
                bVar.a(2, this.zWV);
            }
            if (!this.iconUrl.equals("")) {
                bVar.g(3, this.iconUrl);
            }
            if (!Arrays.equals(this.zWW, com.google.a.a.g.bfX)) {
                bVar.a(4, this.zWW);
            }
            if (!Arrays.equals(this.zWX, com.google.a.a.g.bfX)) {
                bVar.a(5, this.zWX);
            }
            if (this.zWY != 0) {
                bVar.aC(6, this.zWY);
            }
            if (!Arrays.equals(this.data, com.google.a.a.g.bfX)) {
                bVar.a(7, this.data);
            }
            if (this.zWZ != 0) {
                bVar.aC(8, this.zWZ);
            }
            if (!Arrays.equals(this.zXa, com.google.a.a.g.bfX)) {
                bVar.a(9, this.zXa);
            }
            if (!this.lUI.equals("")) {
                bVar.g(10, this.lUI);
            }
            if (!Arrays.equals(this.zXb, com.google.a.a.g.bfX)) {
                bVar.a(11, this.zXb);
            }
            if (!Arrays.equals(this.zXc, com.google.a.a.g.bfX)) {
                bVar.a(12, this.zXc);
            }
            if (!Arrays.equals(this.zXd, com.google.a.a.g.bfX)) {
                bVar.a(13, this.zXd);
            }
            if (!Arrays.equals(this.zXe, com.google.a.a.g.bfX)) {
                bVar.a(14, this.zXe);
            }
            if (!Arrays.equals(this.zXf, com.google.a.a.g.bfX)) {
                bVar.a(15, this.zXf);
            }
            if (!Arrays.equals(this.zXg, com.google.a.a.g.bfX)) {
                bVar.a(16, this.zXg);
            }
            if (!Arrays.equals(this.zXh, com.google.a.a.g.bfX)) {
                bVar.a(17, this.zXh);
            }
            if (!Arrays.equals(this.zXi, com.google.a.a.g.bfX)) {
                bVar.a(18, this.zXi);
            }
            if (!Arrays.equals(this.zXj, com.google.a.a.g.bfX)) {
                bVar.a(19, this.zXj);
            }
            if (this.status != 0) {
                bVar.aC(20, this.status);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.zWU != 0) {
                rM += com.google.a.a.b.aE(1, this.zWU);
            }
            if (!Arrays.equals(this.zWV, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(2, this.zWV);
            }
            if (!this.iconUrl.equals("")) {
                rM += com.google.a.a.b.h(3, this.iconUrl);
            }
            if (!Arrays.equals(this.zWW, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(4, this.zWW);
            }
            if (!Arrays.equals(this.zWX, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(5, this.zWX);
            }
            if (this.zWY != 0) {
                rM += com.google.a.a.b.aE(6, this.zWY);
            }
            if (!Arrays.equals(this.data, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(7, this.data);
            }
            if (this.zWZ != 0) {
                rM += com.google.a.a.b.aE(8, this.zWZ);
            }
            if (!Arrays.equals(this.zXa, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(9, this.zXa);
            }
            if (!this.lUI.equals("")) {
                rM += com.google.a.a.b.h(10, this.lUI);
            }
            if (!Arrays.equals(this.zXb, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(11, this.zXb);
            }
            if (!Arrays.equals(this.zXc, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(12, this.zXc);
            }
            if (!Arrays.equals(this.zXd, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(13, this.zXd);
            }
            if (!Arrays.equals(this.zXe, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(14, this.zXe);
            }
            if (!Arrays.equals(this.zXf, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(15, this.zXf);
            }
            if (!Arrays.equals(this.zXg, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(16, this.zXg);
            }
            if (!Arrays.equals(this.zXh, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(17, this.zXh);
            }
            if (!Arrays.equals(this.zXi, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(18, this.zXi);
            }
            if (!Arrays.equals(this.zXj, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(19, this.zXj);
            }
            if (this.status != 0) {
                return rM + com.google.a.a.b.aE(20, this.status);
            }
            return rM;
        }
    }

    public static final class v extends com.google.a.a.e {
        public byte[] body;
        public u zXm;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        if (this.zXm == null) {
                            this.zXm = new u();
                        }
                        aVar.a(this.zXm);
                        continue;
                    case 18:
                        this.body = aVar.readBytes();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public v() {
            this.zXm = null;
            this.body = com.google.a.a.g.bfX;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.zXm != null) {
                bVar.a(1, this.zXm);
            }
            if (!Arrays.equals(this.body, com.google.a.a.g.bfX)) {
                bVar.a(2, this.body);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.zXm != null) {
                rM += com.google.a.a.b.b(1, this.zXm);
            }
            if (Arrays.equals(this.body, com.google.a.a.g.bfX)) {
                return rM;
            }
            return rM + com.google.a.a.b.b(2, this.body);
        }
    }

    public static final class x extends com.google.a.a.e {
        public String groupId;
        public int srH;
        public long srI;
        public at zWa;
        public av[] zXq;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.srH = aVar.rz();
                        continue;
                    case 24:
                        this.srI = aVar.rA();
                        continue;
                    case 34:
                        int b = com.google.a.a.g.b(aVar, 34);
                        ry = this.zXq == null ? 0 : this.zXq.length;
                        Object obj = new av[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXq, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new av();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new av();
                        aVar.a(obj[ry]);
                        this.zXq = obj;
                        continue;
                    case R.styleable.AppCompatTheme_dialogTheme /*42*/:
                        if (this.zWa == null) {
                            this.zWa = new at();
                        }
                        aVar.a(this.zWa);
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public x() {
            this.groupId = "";
            this.srH = 0;
            this.srI = 0;
            this.zXq = av.cDJ();
            this.zWa = null;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.srH != 0) {
                bVar.aB(2, this.srH);
            }
            if (this.srI != 0) {
                bVar.k(3, this.srI);
            }
            if (this.zXq != null && this.zXq.length > 0) {
                for (com.google.a.a.e eVar : this.zXq) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.zWa != null) {
                bVar.a(5, this.zWa);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (!this.groupId.equals("")) {
                rM += com.google.a.a.b.h(1, this.groupId);
            }
            if (this.srH != 0) {
                rM += com.google.a.a.b.aD(2, this.srH);
            }
            if (this.srI != 0) {
                rM += com.google.a.a.b.m(3, this.srI);
            }
            if (this.zXq != null && this.zXq.length > 0) {
                int i = rM;
                for (com.google.a.a.e eVar : this.zXq) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(4, eVar);
                    }
                }
                rM = i;
            }
            if (this.zWa != null) {
                return rM + com.google.a.a.b.b(5, this.zWa);
            }
            return rM;
        }
    }

    public static final class al extends com.google.a.a.e {
        public byte[] buffer;
        public int wRk;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.wRk = aVar.rz();
                        continue;
                    case 18:
                        this.buffer = aVar.readBytes();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public al() {
            this.wRk = 0;
            this.buffer = com.google.a.a.g.bfX;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            bVar.aC(1, this.wRk);
            if (!Arrays.equals(this.buffer, com.google.a.a.g.bfX)) {
                bVar.a(2, this.buffer);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM() + com.google.a.a.b.aE(1, this.wRk);
            if (Arrays.equals(this.buffer, com.google.a.a.g.bfX)) {
                return rM;
            }
            return rM + com.google.a.a.b.b(2, this.buffer);
        }
    }

    public static final class ap extends com.google.a.a.e {
        public int zXT;
        public int zXU;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.zXT = aVar.rz();
                        continue;
                    case 16:
                        this.zXU = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public ap() {
            this.zXT = 0;
            this.zXU = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.zXT != 0) {
                bVar.aB(1, this.zXT);
            }
            if (this.zXU != 0) {
                bVar.aB(2, this.zXU);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.zXT != 0) {
                rM += com.google.a.a.b.aD(1, this.zXT);
            }
            if (this.zXU != 0) {
                return rM + com.google.a.a.b.aD(2, this.zXU);
            }
            return rM;
        }
    }

    public static final class aq extends com.google.a.a.e {
        public int sceneType;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.sceneType = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public aq() {
            this.sceneType = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.sceneType != 0) {
                bVar.aB(1, this.sceneType);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.sceneType != 0) {
                return rM + com.google.a.a.b.aD(1, this.sceneType);
            }
            return rM;
        }
    }

    public static final class ar extends com.google.a.a.e {
        private static volatile ar[] zXV;
        public int zXW;
        public int zXX;
        public byte[] zXY;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.zXW = aVar.rz();
                        continue;
                    case 16:
                        this.zXX = aVar.rz();
                        continue;
                    case 26:
                        this.zXY = aVar.readBytes();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public static ar[] cDH() {
            if (zXV == null) {
                synchronized (com.google.a.a.c.bfP) {
                    if (zXV == null) {
                        zXV = new ar[0];
                    }
                }
            }
            return zXV;
        }

        public ar() {
            this.zXW = 0;
            this.zXX = 0;
            this.zXY = com.google.a.a.g.bfX;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.zXW != 0) {
                bVar.aB(1, this.zXW);
            }
            if (this.zXX != 0) {
                bVar.aB(2, this.zXX);
            }
            if (!Arrays.equals(this.zXY, com.google.a.a.g.bfX)) {
                bVar.a(3, this.zXY);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.zXW != 0) {
                rM += com.google.a.a.b.aD(1, this.zXW);
            }
            if (this.zXX != 0) {
                rM += com.google.a.a.b.aD(2, this.zXX);
            }
            if (Arrays.equals(this.zXY, com.google.a.a.g.bfX)) {
                return rM;
            }
            return rM + com.google.a.a.b.b(3, this.zXY);
        }
    }

    public static final class as extends com.google.a.a.e {
        public int hvV;
        public int hvW;
        public int zXZ;
        public int zYa;
        public int zYb;
        public int zYc;
        public int zYd;
        public int zYe;
        public int zYf;
        public int zYg;
        public int zYh;
        public int zYi;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.zXZ = aVar.rz();
                        continue;
                    case 16:
                        this.hvV = aVar.rz();
                        continue;
                    case 24:
                        this.hvW = aVar.rz();
                        continue;
                    case 32:
                        this.zYa = aVar.rz();
                        continue;
                    case 40:
                        this.zYb = aVar.rz();
                        continue;
                    case R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                        this.zYc = aVar.rz();
                        continue;
                    case 56:
                        this.zYd = aVar.rz();
                        continue;
                    case 64:
                        this.zYe = aVar.rz();
                        continue;
                    case 72:
                        this.zYf = aVar.rz();
                        continue;
                    case 80:
                        this.zYg = aVar.rz();
                        continue;
                    case R.styleable.AppCompatTheme_colorButtonNormal /*88*/:
                        this.zYh = aVar.rz();
                        continue;
                    case 96:
                        this.zYi = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public as() {
            this.zXZ = 0;
            this.hvV = 0;
            this.hvW = 0;
            this.zYa = 0;
            this.zYb = 0;
            this.zYc = 0;
            this.zYd = 0;
            this.zYe = 0;
            this.zYf = 0;
            this.zYg = 0;
            this.zYh = 0;
            this.zYi = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.zXZ != 0) {
                bVar.aB(1, this.zXZ);
            }
            if (this.hvV != 0) {
                bVar.aB(2, this.hvV);
            }
            if (this.hvW != 0) {
                bVar.aB(3, this.hvW);
            }
            if (this.zYa != 0) {
                bVar.aB(4, this.zYa);
            }
            if (this.zYb != 0) {
                bVar.aB(5, this.zYb);
            }
            if (this.zYc != 0) {
                bVar.aB(6, this.zYc);
            }
            if (this.zYd != 0) {
                bVar.aB(7, this.zYd);
            }
            if (this.zYe != 0) {
                bVar.aB(8, this.zYe);
            }
            if (this.zYf != 0) {
                bVar.aB(9, this.zYf);
            }
            if (this.zYg != 0) {
                bVar.aB(10, this.zYg);
            }
            if (this.zYh != 0) {
                bVar.aB(11, this.zYh);
            }
            if (this.zYi != 0) {
                bVar.aB(12, this.zYi);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.zXZ != 0) {
                rM += com.google.a.a.b.aD(1, this.zXZ);
            }
            if (this.hvV != 0) {
                rM += com.google.a.a.b.aD(2, this.hvV);
            }
            if (this.hvW != 0) {
                rM += com.google.a.a.b.aD(3, this.hvW);
            }
            if (this.zYa != 0) {
                rM += com.google.a.a.b.aD(4, this.zYa);
            }
            if (this.zYb != 0) {
                rM += com.google.a.a.b.aD(5, this.zYb);
            }
            if (this.zYc != 0) {
                rM += com.google.a.a.b.aD(6, this.zYc);
            }
            if (this.zYd != 0) {
                rM += com.google.a.a.b.aD(7, this.zYd);
            }
            if (this.zYe != 0) {
                rM += com.google.a.a.b.aD(8, this.zYe);
            }
            if (this.zYf != 0) {
                rM += com.google.a.a.b.aD(9, this.zYf);
            }
            if (this.zYg != 0) {
                rM += com.google.a.a.b.aD(10, this.zYg);
            }
            if (this.zYh != 0) {
                rM += com.google.a.a.b.aD(11, this.zYh);
            }
            if (this.zYi != 0) {
                return rM + com.google.a.a.b.aD(12, this.zYi);
            }
            return rM;
        }
    }

    public static final class ax extends com.google.a.a.e {
        public int zZg;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.zZg = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public ax() {
            this.zZg = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.zZg != 0) {
                bVar.aC(1, this.zZg);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.zZg != 0) {
                return rM + com.google.a.a.b.aE(1, this.zZg);
            }
            return rM;
        }
    }

    public static final class ay extends com.google.a.a.e {
        public int srH;
        public long srI;
        public int zZh;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.srH = aVar.rz();
                        continue;
                    case 16:
                        this.srI = aVar.rA();
                        continue;
                    case 24:
                        this.zZh = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public ay() {
            this.srH = 0;
            this.srI = 0;
            this.zZh = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.srH != 0) {
                bVar.aB(1, this.srH);
            }
            if (this.srI != 0) {
                bVar.k(2, this.srI);
            }
            if (this.zZh != 0) {
                bVar.aC(3, this.zZh);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.srH != 0) {
                rM += com.google.a.a.b.aD(1, this.srH);
            }
            if (this.srI != 0) {
                rM += com.google.a.a.b.m(2, this.srI);
            }
            if (this.zZh != 0) {
                return rM + com.google.a.a.b.aE(3, this.zZh);
            }
            return rM;
        }
    }

    public static final class az extends com.google.a.a.e {
        private static volatile az[] zZi;
        public int cRQ;
        public int zZj;
        public int zZk;
        public int zZl;
        public int zZm;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.cRQ = aVar.rz();
                        continue;
                    case 16:
                        this.zZj = aVar.rz();
                        continue;
                    case 24:
                        this.zZk = aVar.rz();
                        continue;
                    case 32:
                        this.zZl = aVar.rz();
                        continue;
                    case 40:
                        this.zZm = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public static az[] cDL() {
            if (zZi == null) {
                synchronized (com.google.a.a.c.bfP) {
                    if (zZi == null) {
                        zZi = new az[0];
                    }
                }
            }
            return zZi;
        }

        public az() {
            this.cRQ = 0;
            this.zZj = 0;
            this.zZk = 0;
            this.zZl = 0;
            this.zZm = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.cRQ != 0) {
                bVar.aB(1, this.cRQ);
            }
            if (this.zZj != 0) {
                bVar.aB(2, this.zZj);
            }
            if (this.zZk != 0) {
                bVar.aB(3, this.zZk);
            }
            if (this.zZl != 0) {
                bVar.aB(4, this.zZl);
            }
            if (this.zZm != 0) {
                bVar.aB(5, this.zZm);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.cRQ != 0) {
                rM += com.google.a.a.b.aD(1, this.cRQ);
            }
            if (this.zZj != 0) {
                rM += com.google.a.a.b.aD(2, this.zZj);
            }
            if (this.zZk != 0) {
                rM += com.google.a.a.b.aD(3, this.zZk);
            }
            if (this.zZl != 0) {
                rM += com.google.a.a.b.aD(4, this.zZl);
            }
            if (this.zZm != 0) {
                return rM + com.google.a.a.b.aD(5, this.zZm);
            }
            return rM;
        }
    }

    public static final class ba extends com.google.a.a.e {
        public int type;
        public al zZn;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.type = aVar.rz();
                        continue;
                    case 18:
                        if (this.zZn == null) {
                            this.zZn = new al();
                        }
                        aVar.a(this.zZn);
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public ba() {
            this.type = 0;
            this.zZn = null;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.type != 0) {
                bVar.aB(1, this.type);
            }
            if (this.zZn != null) {
                bVar.a(2, this.zZn);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.type != 0) {
                rM += com.google.a.a.b.aD(1, this.type);
            }
            if (this.zZn != null) {
                return rM + com.google.a.a.b.b(2, this.zZn);
            }
            return rM;
        }
    }

    public static final class i extends com.google.a.a.e {
        public int action;
        public String groupId;
        public int nJe;
        public long nJf;
        public long timestamp;

        public i() {
            this.action = 0;
            this.nJe = 0;
            this.nJf = 0;
            this.groupId = "";
            this.timestamp = 0;
            this.bfQ = -1;
        }

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.action = aVar.rz();
                        continue;
                    case 16:
                        this.nJe = aVar.rz();
                        continue;
                    case 24:
                        this.nJf = aVar.rA();
                        continue;
                    case 34:
                        this.groupId = aVar.readString();
                        continue;
                    case 40:
                        this.timestamp = aVar.rA();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public final void a(com.google.a.a.b bVar) {
            bVar.aC(1, this.action);
            bVar.aB(2, this.nJe);
            bVar.k(3, this.nJf);
            if (!this.groupId.equals("")) {
                bVar.g(4, this.groupId);
            }
            if (this.timestamp != 0) {
                bVar.j(5, this.timestamp);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = ((super.rM() + com.google.a.a.b.aE(1, this.action)) + com.google.a.a.b.aD(2, this.nJe)) + com.google.a.a.b.m(3, this.nJf);
            if (!this.groupId.equals("")) {
                rM += com.google.a.a.b.h(4, this.groupId);
            }
            return this.timestamp != 0 ? rM + com.google.a.a.b.l(5, this.timestamp) : rM;
        }
    }

    public static final class k extends com.google.a.a.e {
        public String groupId;
        public int nJK;
        public int netType;
        public int srH;
        public long srI;
        public int zWe;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.srH = aVar.rz();
                        continue;
                    case 24:
                        this.srI = aVar.rA();
                        continue;
                    case 32:
                        this.nJK = aVar.rz();
                        continue;
                    case 40:
                        this.zWe = aVar.rz();
                        continue;
                    case R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                        this.netType = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public k() {
            this.groupId = "";
            this.srH = 0;
            this.srI = 0;
            this.nJK = -1;
            this.zWe = 0;
            this.netType = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.srH != 0) {
                bVar.aB(2, this.srH);
            }
            if (this.srI != 0) {
                bVar.k(3, this.srI);
            }
            if (this.nJK != -1) {
                bVar.aB(4, this.nJK);
            }
            if (this.zWe != 0) {
                bVar.aC(5, this.zWe);
            }
            if (this.netType != 0) {
                bVar.aC(6, this.netType);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (!this.groupId.equals("")) {
                rM += com.google.a.a.b.h(1, this.groupId);
            }
            if (this.srH != 0) {
                rM += com.google.a.a.b.aD(2, this.srH);
            }
            if (this.srI != 0) {
                rM += com.google.a.a.b.m(3, this.srI);
            }
            if (this.nJK != -1) {
                rM += com.google.a.a.b.aD(4, this.nJK);
            }
            if (this.zWe != 0) {
                rM += com.google.a.a.b.aE(5, this.zWe);
            }
            if (this.netType != 0) {
                return rM + com.google.a.a.b.aE(6, this.netType);
            }
            return rM;
        }
    }

    public static final class p extends com.google.a.a.e {
        public long frh;
        public String groupId;
        public int srH;
        public long srI;
        public int zWC;
        public aw[] zWD;
        public av[] zWE;
        public as zWF;
        public int zWG;
        public byte[] zWH;
        public byte[] zWI;
        public av[] zWJ;
        public at zWa;
        public int zWd;
        public ay zWf;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                int b;
                Object obj;
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.zWC = aVar.rz();
                        continue;
                    case 18:
                        this.groupId = aVar.readString();
                        continue;
                    case 24:
                        this.srH = aVar.rz();
                        continue;
                    case 32:
                        this.srI = aVar.rA();
                        continue;
                    case 40:
                        this.zWd = aVar.rz();
                        continue;
                    case 50:
                        if (this.zWa == null) {
                            this.zWa = new at();
                        }
                        aVar.a(this.zWa);
                        continue;
                    case 58:
                        b = com.google.a.a.g.b(aVar, 58);
                        ry = this.zWD == null ? 0 : this.zWD.length;
                        obj = new aw[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zWD, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new aw();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new aw();
                        aVar.a(obj[ry]);
                        this.zWD = obj;
                        continue;
                    case 66:
                        b = com.google.a.a.g.b(aVar, 66);
                        ry = this.zWE == null ? 0 : this.zWE.length;
                        obj = new av[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zWE, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new av();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new av();
                        aVar.a(obj[ry]);
                        this.zWE = obj;
                        continue;
                    case 74:
                        if (this.zWF == null) {
                            this.zWF = new as();
                        }
                        aVar.a(this.zWF);
                        continue;
                    case 82:
                        if (this.zWf == null) {
                            this.zWf = new ay();
                        }
                        aVar.a(this.zWf);
                        continue;
                    case 808:
                        this.frh = aVar.rA();
                        continue;
                    case 816:
                        this.zWG = aVar.rz();
                        continue;
                    case 826:
                        this.zWH = aVar.readBytes();
                        continue;
                    case 1602:
                        this.zWI = aVar.readBytes();
                        continue;
                    case 1610:
                        b = com.google.a.a.g.b(aVar, 1610);
                        ry = this.zWJ == null ? 0 : this.zWJ.length;
                        obj = new av[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zWJ, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new av();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new av();
                        aVar.a(obj[ry]);
                        this.zWJ = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public p() {
            this.zWC = 0;
            this.groupId = "";
            this.srH = 0;
            this.srI = 0;
            this.zWd = 0;
            this.zWa = null;
            this.zWD = aw.cDK();
            this.zWE = av.cDJ();
            this.zWF = null;
            this.zWf = null;
            this.frh = 0;
            this.zWG = 0;
            this.zWH = com.google.a.a.g.bfX;
            this.zWI = com.google.a.a.g.bfX;
            this.zWJ = av.cDJ();
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (this.zWC != 0) {
                bVar.aB(1, this.zWC);
            }
            if (!this.groupId.equals("")) {
                bVar.g(2, this.groupId);
            }
            if (this.srH != 0) {
                bVar.aB(3, this.srH);
            }
            if (this.srI != 0) {
                bVar.k(4, this.srI);
            }
            if (this.zWd != 0) {
                bVar.aC(5, this.zWd);
            }
            if (this.zWa != null) {
                bVar.a(6, this.zWa);
            }
            if (this.zWD != null && this.zWD.length > 0) {
                for (com.google.a.a.e eVar : this.zWD) {
                    if (eVar != null) {
                        bVar.a(7, eVar);
                    }
                }
            }
            if (this.zWE != null && this.zWE.length > 0) {
                for (com.google.a.a.e eVar2 : this.zWE) {
                    if (eVar2 != null) {
                        bVar.a(8, eVar2);
                    }
                }
            }
            if (this.zWF != null) {
                bVar.a(9, this.zWF);
            }
            if (this.zWf != null) {
                bVar.a(10, this.zWf);
            }
            if (this.frh != 0) {
                bVar.j(101, this.frh);
            }
            if (this.zWG != 0) {
                bVar.aC(102, this.zWG);
            }
            if (!Arrays.equals(this.zWH, com.google.a.a.g.bfX)) {
                bVar.a(103, this.zWH);
            }
            if (!Arrays.equals(this.zWI, com.google.a.a.g.bfX)) {
                bVar.a(200, this.zWI);
            }
            if (this.zWJ != null && this.zWJ.length > 0) {
                while (i < this.zWJ.length) {
                    com.google.a.a.e eVar3 = this.zWJ[i];
                    if (eVar3 != null) {
                        bVar.a(201, eVar3);
                    }
                    i++;
                }
            }
            super.a(bVar);
        }

        protected final int rM() {
            int i;
            int i2 = 0;
            int rM = super.rM();
            if (this.zWC != 0) {
                rM += com.google.a.a.b.aD(1, this.zWC);
            }
            if (!this.groupId.equals("")) {
                rM += com.google.a.a.b.h(2, this.groupId);
            }
            if (this.srH != 0) {
                rM += com.google.a.a.b.aD(3, this.srH);
            }
            if (this.srI != 0) {
                rM += com.google.a.a.b.m(4, this.srI);
            }
            if (this.zWd != 0) {
                rM += com.google.a.a.b.aE(5, this.zWd);
            }
            if (this.zWa != null) {
                rM += com.google.a.a.b.b(6, this.zWa);
            }
            if (this.zWD != null && this.zWD.length > 0) {
                i = rM;
                for (com.google.a.a.e eVar : this.zWD) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(7, eVar);
                    }
                }
                rM = i;
            }
            if (this.zWE != null && this.zWE.length > 0) {
                i = rM;
                for (com.google.a.a.e eVar2 : this.zWE) {
                    if (eVar2 != null) {
                        i += com.google.a.a.b.b(8, eVar2);
                    }
                }
                rM = i;
            }
            if (this.zWF != null) {
                rM += com.google.a.a.b.b(9, this.zWF);
            }
            if (this.zWf != null) {
                rM += com.google.a.a.b.b(10, this.zWf);
            }
            if (this.frh != 0) {
                rM += com.google.a.a.b.l(101, this.frh);
            }
            if (this.zWG != 0) {
                rM += com.google.a.a.b.aE(102, this.zWG);
            }
            if (!Arrays.equals(this.zWH, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(103, this.zWH);
            }
            if (!Arrays.equals(this.zWI, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(200, this.zWI);
            }
            if (this.zWJ != null && this.zWJ.length > 0) {
                while (i2 < this.zWJ.length) {
                    com.google.a.a.e eVar3 = this.zWJ[i2];
                    if (eVar3 != null) {
                        rM += com.google.a.a.b.b(201, eVar3);
                    }
                    i2++;
                }
            }
            return rM;
        }
    }

    public static final class r extends com.google.a.a.e {
        public am[] zWL;

        public r() {
            this.zWL = am.cDF();
            this.bfQ = -1;
        }

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        int b = com.google.a.a.g.b(aVar, 10);
                        ry = this.zWL == null ? 0 : this.zWL.length;
                        Object obj = new am[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zWL, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new am();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new am();
                        aVar.a(obj[ry]);
                        this.zWL = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.zWL != null && this.zWL.length > 0) {
                for (com.google.a.a.e eVar : this.zWL) {
                    if (eVar != null) {
                        bVar.a(1, eVar);
                    }
                }
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.zWL != null && this.zWL.length > 0) {
                for (com.google.a.a.e eVar : this.zWL) {
                    if (eVar != null) {
                        rM += com.google.a.a.b.b(1, eVar);
                    }
                }
            }
            return rM;
        }
    }

    public static final class u extends com.google.a.a.e {
        public int pK;
        public int ret;
        public String userName;
        public int vJp;
        public int zWd;
        public int zXk;
        public int zXl;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 18:
                        this.userName = aVar.readString();
                        continue;
                    case 24:
                        this.pK = aVar.rz();
                        continue;
                    case 32:
                        this.zXk = aVar.rz();
                        continue;
                    case 40:
                        this.ret = aVar.rz();
                        continue;
                    case R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                        this.zXl = aVar.rz();
                        continue;
                    case 56:
                        this.zWd = aVar.rz();
                        continue;
                    case 64:
                        this.vJp = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public u() {
            this.userName = "";
            this.pK = 0;
            this.zXk = 0;
            this.ret = 0;
            this.zXl = 0;
            this.zWd = 0;
            this.vJp = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.userName.equals("")) {
                bVar.g(2, this.userName);
            }
            if (this.pK != 0) {
                bVar.aB(3, this.pK);
            }
            if (this.zXk != 0) {
                bVar.aC(4, this.zXk);
            }
            if (this.ret != 0) {
                bVar.aB(5, this.ret);
            }
            if (this.zXl != 0) {
                bVar.aB(6, this.zXl);
            }
            if (this.zWd != 0) {
                bVar.aC(7, this.zWd);
            }
            if (this.vJp != 0) {
                bVar.aC(8, this.vJp);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (!this.userName.equals("")) {
                rM += com.google.a.a.b.h(2, this.userName);
            }
            if (this.pK != 0) {
                rM += com.google.a.a.b.aD(3, this.pK);
            }
            if (this.zXk != 0) {
                rM += com.google.a.a.b.aE(4, this.zXk);
            }
            if (this.ret != 0) {
                rM += com.google.a.a.b.aD(5, this.ret);
            }
            if (this.zXl != 0) {
                rM += com.google.a.a.b.aD(6, this.zXl);
            }
            if (this.zWd != 0) {
                rM += com.google.a.a.b.aE(7, this.zWd);
            }
            if (this.vJp != 0) {
                return rM + com.google.a.a.b.aE(8, this.vJp);
            }
            return rM;
        }
    }

    public static final class y extends com.google.a.a.e {
        public String zVY;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        this.zVY = aVar.readString();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public y() {
            this.zVY = "";
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.zVY.equals("")) {
                bVar.g(1, this.zVY);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.zVY.equals("")) {
                return rM;
            }
            return rM + com.google.a.a.b.h(1, this.zVY);
        }
    }

    public static final class z extends com.google.a.a.e {
        public String groupId;
        public int srH;
        public long srI;
        public String zVY;
        public av[] zWE;
        public as zWF;
        public av[] zWJ;
        public at zWa;
        public int zWd;
        public int zWy;
        public int zXA;
        public int zXB;
        public byte[] zXC;
        public o[] zXr;
        public aw[] zXs;
        public int zXt;
        public int[] zXu;
        public o[] zXv;
        public int zXw;
        public int zXx;
        public o[] zXy;
        public int zXz;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                int b;
                Object obj;
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.srH = aVar.rz();
                        continue;
                    case 24:
                        this.srI = aVar.rA();
                        continue;
                    case 32:
                        this.zWd = aVar.rz();
                        continue;
                    case R.styleable.AppCompatTheme_dialogTheme /*42*/:
                        b = com.google.a.a.g.b(aVar, 42);
                        ry = this.zXr == null ? 0 : this.zXr.length;
                        obj = new o[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXr, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new o();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new o();
                        aVar.a(obj[ry]);
                        this.zXr = obj;
                        continue;
                    case 50:
                        b = com.google.a.a.g.b(aVar, 50);
                        ry = this.zXs == null ? 0 : this.zXs.length;
                        obj = new aw[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXs, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new aw();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new aw();
                        aVar.a(obj[ry]);
                        this.zXs = obj;
                        continue;
                    case 58:
                        if (this.zWF == null) {
                            this.zWF = new as();
                        }
                        aVar.a(this.zWF);
                        continue;
                    case 66:
                        this.zVY = aVar.readString();
                        continue;
                    case 74:
                        b = com.google.a.a.g.b(aVar, 74);
                        ry = this.zWE == null ? 0 : this.zWE.length;
                        obj = new av[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zWE, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new av();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new av();
                        aVar.a(obj[ry]);
                        this.zWE = obj;
                        continue;
                    case 80:
                        this.zXt = aVar.rz();
                        continue;
                    case R.styleable.AppCompatTheme_colorButtonNormal /*88*/:
                        b = com.google.a.a.g.b(aVar, 88);
                        ry = this.zXu == null ? 0 : this.zXu.length;
                        obj = new int[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXu, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = aVar.rz();
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = aVar.rz();
                        this.zXu = obj;
                        continue;
                    case 90:
                        int dQ = aVar.dQ(aVar.rz());
                        b = aVar.getPosition();
                        ry = 0;
                        while (aVar.rC() > 0) {
                            aVar.rz();
                            ry++;
                        }
                        aVar.dS(b);
                        b = this.zXu == null ? 0 : this.zXu.length;
                        Object obj2 = new int[(ry + b)];
                        if (b != 0) {
                            System.arraycopy(this.zXu, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = aVar.rz();
                            b++;
                        }
                        this.zXu = obj2;
                        aVar.dR(dQ);
                        continue;
                    case 98:
                        if (this.zWa == null) {
                            this.zWa = new at();
                        }
                        aVar.a(this.zWa);
                        continue;
                    case 104:
                        this.zWy = aVar.rz();
                        continue;
                    case 114:
                        b = com.google.a.a.g.b(aVar, 114);
                        ry = this.zXv == null ? 0 : this.zXv.length;
                        obj = new o[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXv, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new o();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new o();
                        aVar.a(obj[ry]);
                        this.zXv = obj;
                        continue;
                    case 120:
                        this.zXw = aVar.rz();
                        continue;
                    case FileUtils.S_IWUSR /*128*/:
                        this.zXx = aVar.rz();
                        continue;
                    case 138:
                        b = com.google.a.a.g.b(aVar, 138);
                        ry = this.zWJ == null ? 0 : this.zWJ.length;
                        obj = new av[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zWJ, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new av();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new av();
                        aVar.a(obj[ry]);
                        this.zWJ = obj;
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX /*146*/:
                        b = com.google.a.a.g.b(aVar, com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX);
                        ry = this.zXy == null ? 0 : this.zXy.length;
                        obj = new o[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXy, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new o();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new o();
                        aVar.a(obj[ry]);
                        this.zXy = obj;
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.contact.d.CTRL_INDEX /*152*/:
                        this.zXz = aVar.rz();
                        continue;
                    case JsApiSetBackgroundAudioState.CTRL_INDEX /*160*/:
                        this.zXA = aVar.rz();
                        continue;
                    case JsApiSetClipboardData.CTRL_INDEX /*168*/:
                        this.zXB = aVar.rz();
                        continue;
                    case 178:
                        this.zXC = aVar.readBytes();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public z() {
            this.groupId = "";
            this.srH = 0;
            this.srI = 0;
            this.zWd = 0;
            this.zXr = o.cDD();
            this.zXs = aw.cDK();
            this.zWF = null;
            this.zVY = "";
            this.zWE = av.cDJ();
            this.zXt = 0;
            this.zXu = com.google.a.a.g.bfR;
            this.zWa = null;
            this.zWy = 0;
            this.zXv = o.cDD();
            this.zXw = 0;
            this.zXx = 0;
            this.zWJ = av.cDJ();
            this.zXy = o.cDD();
            this.zXz = 0;
            this.zXA = 0;
            this.zXB = 0;
            this.zXC = com.google.a.a.g.bfX;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.srH != 0) {
                bVar.aB(2, this.srH);
            }
            if (this.srI != 0) {
                bVar.k(3, this.srI);
            }
            if (this.zWd != 0) {
                bVar.aC(4, this.zWd);
            }
            if (this.zXr != null && this.zXr.length > 0) {
                for (com.google.a.a.e eVar : this.zXr) {
                    if (eVar != null) {
                        bVar.a(5, eVar);
                    }
                }
            }
            if (this.zXs != null && this.zXs.length > 0) {
                for (com.google.a.a.e eVar2 : this.zXs) {
                    if (eVar2 != null) {
                        bVar.a(6, eVar2);
                    }
                }
            }
            if (this.zWF != null) {
                bVar.a(7, this.zWF);
            }
            if (!this.zVY.equals("")) {
                bVar.g(8, this.zVY);
            }
            if (this.zWE != null && this.zWE.length > 0) {
                for (com.google.a.a.e eVar22 : this.zWE) {
                    if (eVar22 != null) {
                        bVar.a(9, eVar22);
                    }
                }
            }
            if (this.zXt != 0) {
                bVar.aB(10, this.zXt);
            }
            if (this.zXu != null && this.zXu.length > 0) {
                for (int aB : this.zXu) {
                    bVar.aB(11, aB);
                }
            }
            if (this.zWa != null) {
                bVar.a(12, this.zWa);
            }
            if (this.zWy != 0) {
                bVar.aC(13, this.zWy);
            }
            if (this.zXv != null && this.zXv.length > 0) {
                for (com.google.a.a.e eVar222 : this.zXv) {
                    if (eVar222 != null) {
                        bVar.a(14, eVar222);
                    }
                }
            }
            if (this.zXw != 0) {
                bVar.aC(15, this.zXw);
            }
            if (this.zXx != 0) {
                bVar.aC(16, this.zXx);
            }
            if (this.zWJ != null && this.zWJ.length > 0) {
                for (com.google.a.a.e eVar2222 : this.zWJ) {
                    if (eVar2222 != null) {
                        bVar.a(17, eVar2222);
                    }
                }
            }
            if (this.zXy != null && this.zXy.length > 0) {
                while (i < this.zXy.length) {
                    com.google.a.a.e eVar3 = this.zXy[i];
                    if (eVar3 != null) {
                        bVar.a(18, eVar3);
                    }
                    i++;
                }
            }
            if (this.zXz != 0) {
                bVar.aB(19, this.zXz);
            }
            if (this.zXA != 0) {
                bVar.aB(20, this.zXA);
            }
            if (this.zXB != 0) {
                bVar.aB(21, this.zXB);
            }
            if (!Arrays.equals(this.zXC, com.google.a.a.g.bfX)) {
                bVar.a(22, this.zXC);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int i;
            int i2 = 0;
            int rM = super.rM();
            if (!this.groupId.equals("")) {
                rM += com.google.a.a.b.h(1, this.groupId);
            }
            if (this.srH != 0) {
                rM += com.google.a.a.b.aD(2, this.srH);
            }
            if (this.srI != 0) {
                rM += com.google.a.a.b.m(3, this.srI);
            }
            if (this.zWd != 0) {
                rM += com.google.a.a.b.aE(4, this.zWd);
            }
            if (this.zXr != null && this.zXr.length > 0) {
                i = rM;
                for (com.google.a.a.e eVar : this.zXr) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(5, eVar);
                    }
                }
                rM = i;
            }
            if (this.zXs != null && this.zXs.length > 0) {
                i = rM;
                for (com.google.a.a.e eVar2 : this.zXs) {
                    if (eVar2 != null) {
                        i += com.google.a.a.b.b(6, eVar2);
                    }
                }
                rM = i;
            }
            if (this.zWF != null) {
                rM += com.google.a.a.b.b(7, this.zWF);
            }
            if (!this.zVY.equals("")) {
                rM += com.google.a.a.b.h(8, this.zVY);
            }
            if (this.zWE != null && this.zWE.length > 0) {
                i = rM;
                for (com.google.a.a.e eVar22 : this.zWE) {
                    if (eVar22 != null) {
                        i += com.google.a.a.b.b(9, eVar22);
                    }
                }
                rM = i;
            }
            if (this.zXt != 0) {
                rM += com.google.a.a.b.aD(10, this.zXt);
            }
            if (this.zXu != null && this.zXu.length > 0) {
                int i3 = 0;
                for (int dV : this.zXu) {
                    i3 += com.google.a.a.b.dV(dV);
                }
                rM = (rM + i3) + (this.zXu.length * 1);
            }
            if (this.zWa != null) {
                rM += com.google.a.a.b.b(12, this.zWa);
            }
            if (this.zWy != 0) {
                rM += com.google.a.a.b.aE(13, this.zWy);
            }
            if (this.zXv != null && this.zXv.length > 0) {
                i = rM;
                for (com.google.a.a.e eVar222 : this.zXv) {
                    if (eVar222 != null) {
                        i += com.google.a.a.b.b(14, eVar222);
                    }
                }
                rM = i;
            }
            if (this.zXw != 0) {
                rM += com.google.a.a.b.aE(15, this.zXw);
            }
            if (this.zXx != 0) {
                rM += com.google.a.a.b.aE(16, this.zXx);
            }
            if (this.zWJ != null && this.zWJ.length > 0) {
                i = rM;
                for (com.google.a.a.e eVar2222 : this.zWJ) {
                    if (eVar2222 != null) {
                        i += com.google.a.a.b.b(17, eVar2222);
                    }
                }
                rM = i;
            }
            if (this.zXy != null && this.zXy.length > 0) {
                while (i2 < this.zXy.length) {
                    com.google.a.a.e eVar3 = this.zXy[i2];
                    if (eVar3 != null) {
                        rM += com.google.a.a.b.b(18, eVar3);
                    }
                    i2++;
                }
            }
            if (this.zXz != 0) {
                rM += com.google.a.a.b.aD(19, this.zXz);
            }
            if (this.zXA != 0) {
                rM += com.google.a.a.b.aD(20, this.zXA);
            }
            if (this.zXB != 0) {
                rM += com.google.a.a.b.aD(21, this.zXB);
            }
            if (Arrays.equals(this.zXC, com.google.a.a.g.bfX)) {
                return rM;
            }
            return rM + com.google.a.a.b.b(22, this.zXC);
        }
    }

    public static final class ae extends com.google.a.a.e {
        public int nJe;
        public long nJf;

        public ae() {
            this.nJe = 0;
            this.nJf = 0;
            this.bfQ = -1;
        }

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.nJe = aVar.rz();
                        continue;
                    case 16:
                        this.nJf = aVar.rA();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.nJe != 0) {
                bVar.aB(1, this.nJe);
            }
            if (this.nJf != 0) {
                bVar.k(2, this.nJf);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.nJe != 0) {
                rM += com.google.a.a.b.aD(1, this.nJe);
            }
            return this.nJf != 0 ? rM + com.google.a.a.b.m(2, this.nJf) : rM;
        }
    }

    public static final class ag extends com.google.a.a.e {
        public String groupId;
        public int srH;
        public long srI;
        public as zWF;
        public av[] zWJ;
        public at zWa;
        public av[] zXq;
        public o[] zXr;
        public aw[] zXs;
        public int zXt;
        public int[] zXu;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                int b;
                Object obj;
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.srH = aVar.rz();
                        continue;
                    case 24:
                        this.srI = aVar.rA();
                        continue;
                    case 34:
                        b = com.google.a.a.g.b(aVar, 34);
                        ry = this.zXr == null ? 0 : this.zXr.length;
                        obj = new o[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXr, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new o();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new o();
                        aVar.a(obj[ry]);
                        this.zXr = obj;
                        continue;
                    case R.styleable.AppCompatTheme_dialogTheme /*42*/:
                        if (this.zWF == null) {
                            this.zWF = new as();
                        }
                        aVar.a(this.zWF);
                        continue;
                    case R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                        this.zXt = aVar.rz();
                        continue;
                    case 56:
                        b = com.google.a.a.g.b(aVar, 56);
                        ry = this.zXu == null ? 0 : this.zXu.length;
                        obj = new int[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXu, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = aVar.rz();
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = aVar.rz();
                        this.zXu = obj;
                        continue;
                    case 58:
                        int dQ = aVar.dQ(aVar.rz());
                        b = aVar.getPosition();
                        ry = 0;
                        while (aVar.rC() > 0) {
                            aVar.rz();
                            ry++;
                        }
                        aVar.dS(b);
                        b = this.zXu == null ? 0 : this.zXu.length;
                        Object obj2 = new int[(ry + b)];
                        if (b != 0) {
                            System.arraycopy(this.zXu, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = aVar.rz();
                            b++;
                        }
                        this.zXu = obj2;
                        aVar.dR(dQ);
                        continue;
                    case 1602:
                        b = com.google.a.a.g.b(aVar, 1602);
                        ry = this.zXq == null ? 0 : this.zXq.length;
                        obj = new av[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXq, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new av();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new av();
                        aVar.a(obj[ry]);
                        this.zXq = obj;
                        continue;
                    case 1610:
                        b = com.google.a.a.g.b(aVar, 1610);
                        ry = this.zXs == null ? 0 : this.zXs.length;
                        obj = new aw[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXs, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new aw();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new aw();
                        aVar.a(obj[ry]);
                        this.zXs = obj;
                        continue;
                    case 1618:
                        if (this.zWa == null) {
                            this.zWa = new at();
                        }
                        aVar.a(this.zWa);
                        continue;
                    case 1626:
                        b = com.google.a.a.g.b(aVar, 1626);
                        ry = this.zWJ == null ? 0 : this.zWJ.length;
                        obj = new av[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zWJ, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new av();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new av();
                        aVar.a(obj[ry]);
                        this.zWJ = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public ag() {
            this.groupId = "";
            this.srH = 0;
            this.srI = 0;
            this.zXr = o.cDD();
            this.zWF = null;
            this.zXt = 0;
            this.zXu = com.google.a.a.g.bfR;
            this.zXq = av.cDJ();
            this.zXs = aw.cDK();
            this.zWa = null;
            this.zWJ = av.cDJ();
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.srH != 0) {
                bVar.aB(2, this.srH);
            }
            if (this.srI != 0) {
                bVar.k(3, this.srI);
            }
            if (this.zXr != null && this.zXr.length > 0) {
                for (com.google.a.a.e eVar : this.zXr) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.zWF != null) {
                bVar.a(5, this.zWF);
            }
            if (this.zXt != 0) {
                bVar.aB(6, this.zXt);
            }
            if (this.zXu != null && this.zXu.length > 0) {
                for (int aB : this.zXu) {
                    bVar.aB(7, aB);
                }
            }
            if (this.zXq != null && this.zXq.length > 0) {
                for (com.google.a.a.e eVar2 : this.zXq) {
                    if (eVar2 != null) {
                        bVar.a(200, eVar2);
                    }
                }
            }
            if (this.zXs != null && this.zXs.length > 0) {
                for (com.google.a.a.e eVar22 : this.zXs) {
                    if (eVar22 != null) {
                        bVar.a(201, eVar22);
                    }
                }
            }
            if (this.zWa != null) {
                bVar.a(202, this.zWa);
            }
            if (this.zWJ != null && this.zWJ.length > 0) {
                while (i < this.zWJ.length) {
                    com.google.a.a.e eVar3 = this.zWJ[i];
                    if (eVar3 != null) {
                        bVar.a(203, eVar3);
                    }
                    i++;
                }
            }
            super.a(bVar);
        }

        protected final int rM() {
            int i;
            int i2 = 0;
            int rM = super.rM();
            if (!this.groupId.equals("")) {
                rM += com.google.a.a.b.h(1, this.groupId);
            }
            if (this.srH != 0) {
                rM += com.google.a.a.b.aD(2, this.srH);
            }
            if (this.srI != 0) {
                rM += com.google.a.a.b.m(3, this.srI);
            }
            if (this.zXr != null && this.zXr.length > 0) {
                i = rM;
                for (com.google.a.a.e eVar : this.zXr) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(4, eVar);
                    }
                }
                rM = i;
            }
            if (this.zWF != null) {
                rM += com.google.a.a.b.b(5, this.zWF);
            }
            if (this.zXt != 0) {
                rM += com.google.a.a.b.aD(6, this.zXt);
            }
            if (this.zXu != null && this.zXu.length > 0) {
                int i3 = 0;
                for (int dV : this.zXu) {
                    i3 += com.google.a.a.b.dV(dV);
                }
                rM = (rM + i3) + (this.zXu.length * 1);
            }
            if (this.zXq != null && this.zXq.length > 0) {
                i = rM;
                for (com.google.a.a.e eVar2 : this.zXq) {
                    if (eVar2 != null) {
                        i += com.google.a.a.b.b(200, eVar2);
                    }
                }
                rM = i;
            }
            if (this.zXs != null && this.zXs.length > 0) {
                i = rM;
                for (com.google.a.a.e eVar22 : this.zXs) {
                    if (eVar22 != null) {
                        i += com.google.a.a.b.b(201, eVar22);
                    }
                }
                rM = i;
            }
            if (this.zWa != null) {
                rM += com.google.a.a.b.b(202, this.zWa);
            }
            if (this.zWJ != null && this.zWJ.length > 0) {
                while (i2 < this.zWJ.length) {
                    com.google.a.a.e eVar3 = this.zWJ[i2];
                    if (eVar3 != null) {
                        rM += com.google.a.a.b.b(203, eVar3);
                    }
                    i2++;
                }
            }
            return rM;
        }
    }

    public static final class aj extends com.google.a.a.e {
        public String groupId;
        public int srH;
        public long srI;
        public as zWF;
        public av[] zWJ;
        public at zWa;
        public int zXA;
        public int zXB;
        public byte[] zXC;
        public av[] zXq;
        public o[] zXr;
        public aw[] zXs;
        public int zXt;
        public int[] zXu;
        public o[] zXv;
        public o[] zXy;
        public int zXz;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                int b;
                Object obj;
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.srH = aVar.rz();
                        continue;
                    case 24:
                        this.srI = aVar.rA();
                        continue;
                    case 34:
                        b = com.google.a.a.g.b(aVar, 34);
                        ry = this.zXr == null ? 0 : this.zXr.length;
                        obj = new o[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXr, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new o();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new o();
                        aVar.a(obj[ry]);
                        this.zXr = obj;
                        continue;
                    case R.styleable.AppCompatTheme_dialogTheme /*42*/:
                        b = com.google.a.a.g.b(aVar, 42);
                        ry = this.zXq == null ? 0 : this.zXq.length;
                        obj = new av[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXq, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new av();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new av();
                        aVar.a(obj[ry]);
                        this.zXq = obj;
                        continue;
                    case 50:
                        if (this.zWF == null) {
                            this.zWF = new as();
                        }
                        aVar.a(this.zWF);
                        continue;
                    case 56:
                        this.zXt = aVar.rz();
                        continue;
                    case 64:
                        b = com.google.a.a.g.b(aVar, 64);
                        ry = this.zXu == null ? 0 : this.zXu.length;
                        obj = new int[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXu, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = aVar.rz();
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = aVar.rz();
                        this.zXu = obj;
                        continue;
                    case 66:
                        int dQ = aVar.dQ(aVar.rz());
                        b = aVar.getPosition();
                        ry = 0;
                        while (aVar.rC() > 0) {
                            aVar.rz();
                            ry++;
                        }
                        aVar.dS(b);
                        b = this.zXu == null ? 0 : this.zXu.length;
                        Object obj2 = new int[(ry + b)];
                        if (b != 0) {
                            System.arraycopy(this.zXu, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = aVar.rz();
                            b++;
                        }
                        this.zXu = obj2;
                        aVar.dR(dQ);
                        continue;
                    case 74:
                        b = com.google.a.a.g.b(aVar, 74);
                        ry = this.zXs == null ? 0 : this.zXs.length;
                        obj = new aw[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXs, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new aw();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new aw();
                        aVar.a(obj[ry]);
                        this.zXs = obj;
                        continue;
                    case 82:
                        if (this.zWa == null) {
                            this.zWa = new at();
                        }
                        aVar.a(this.zWa);
                        continue;
                    case 90:
                        b = com.google.a.a.g.b(aVar, 90);
                        ry = this.zXv == null ? 0 : this.zXv.length;
                        obj = new o[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXv, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new o();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new o();
                        aVar.a(obj[ry]);
                        this.zXv = obj;
                        continue;
                    case 98:
                        b = com.google.a.a.g.b(aVar, 98);
                        ry = this.zWJ == null ? 0 : this.zWJ.length;
                        obj = new av[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zWJ, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new av();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new av();
                        aVar.a(obj[ry]);
                        this.zWJ = obj;
                        continue;
                    case 106:
                        b = com.google.a.a.g.b(aVar, 106);
                        ry = this.zXy == null ? 0 : this.zXy.length;
                        obj = new o[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zXy, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new o();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new o();
                        aVar.a(obj[ry]);
                        this.zXy = obj;
                        continue;
                    case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
                        this.zXz = aVar.rz();
                        continue;
                    case 120:
                        this.zXA = aVar.rz();
                        continue;
                    case FileUtils.S_IWUSR /*128*/:
                        this.zXB = aVar.rz();
                        continue;
                    case 138:
                        this.zXC = aVar.readBytes();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public aj() {
            this.groupId = "";
            this.srH = 0;
            this.srI = 0;
            this.zXr = o.cDD();
            this.zXq = av.cDJ();
            this.zWF = null;
            this.zXt = 0;
            this.zXu = com.google.a.a.g.bfR;
            this.zXs = aw.cDK();
            this.zWa = null;
            this.zXv = o.cDD();
            this.zWJ = av.cDJ();
            this.zXy = o.cDD();
            this.zXz = 0;
            this.zXA = 0;
            this.zXB = 0;
            this.zXC = com.google.a.a.g.bfX;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.srH != 0) {
                bVar.aB(2, this.srH);
            }
            if (this.srI != 0) {
                bVar.k(3, this.srI);
            }
            if (this.zXr != null && this.zXr.length > 0) {
                for (com.google.a.a.e eVar : this.zXr) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.zXq != null && this.zXq.length > 0) {
                for (com.google.a.a.e eVar2 : this.zXq) {
                    if (eVar2 != null) {
                        bVar.a(5, eVar2);
                    }
                }
            }
            if (this.zWF != null) {
                bVar.a(6, this.zWF);
            }
            if (this.zXt != 0) {
                bVar.aB(7, this.zXt);
            }
            if (this.zXu != null && this.zXu.length > 0) {
                for (int aB : this.zXu) {
                    bVar.aB(8, aB);
                }
            }
            if (this.zXs != null && this.zXs.length > 0) {
                for (com.google.a.a.e eVar22 : this.zXs) {
                    if (eVar22 != null) {
                        bVar.a(9, eVar22);
                    }
                }
            }
            if (this.zWa != null) {
                bVar.a(10, this.zWa);
            }
            if (this.zXv != null && this.zXv.length > 0) {
                for (com.google.a.a.e eVar222 : this.zXv) {
                    if (eVar222 != null) {
                        bVar.a(11, eVar222);
                    }
                }
            }
            if (this.zWJ != null && this.zWJ.length > 0) {
                for (com.google.a.a.e eVar2222 : this.zWJ) {
                    if (eVar2222 != null) {
                        bVar.a(12, eVar2222);
                    }
                }
            }
            if (this.zXy != null && this.zXy.length > 0) {
                while (i < this.zXy.length) {
                    com.google.a.a.e eVar3 = this.zXy[i];
                    if (eVar3 != null) {
                        bVar.a(13, eVar3);
                    }
                    i++;
                }
            }
            if (this.zXz != 0) {
                bVar.aB(14, this.zXz);
            }
            if (this.zXA != 0) {
                bVar.aB(15, this.zXA);
            }
            if (this.zXB != 0) {
                bVar.aB(16, this.zXB);
            }
            if (!Arrays.equals(this.zXC, com.google.a.a.g.bfX)) {
                bVar.a(17, this.zXC);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int i;
            int i2 = 0;
            int rM = super.rM();
            if (!this.groupId.equals("")) {
                rM += com.google.a.a.b.h(1, this.groupId);
            }
            if (this.srH != 0) {
                rM += com.google.a.a.b.aD(2, this.srH);
            }
            if (this.srI != 0) {
                rM += com.google.a.a.b.m(3, this.srI);
            }
            if (this.zXr != null && this.zXr.length > 0) {
                i = rM;
                for (com.google.a.a.e eVar : this.zXr) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(4, eVar);
                    }
                }
                rM = i;
            }
            if (this.zXq != null && this.zXq.length > 0) {
                i = rM;
                for (com.google.a.a.e eVar2 : this.zXq) {
                    if (eVar2 != null) {
                        i += com.google.a.a.b.b(5, eVar2);
                    }
                }
                rM = i;
            }
            if (this.zWF != null) {
                rM += com.google.a.a.b.b(6, this.zWF);
            }
            if (this.zXt != 0) {
                rM += com.google.a.a.b.aD(7, this.zXt);
            }
            if (this.zXu != null && this.zXu.length > 0) {
                int i3 = 0;
                for (int dV : this.zXu) {
                    i3 += com.google.a.a.b.dV(dV);
                }
                rM = (rM + i3) + (this.zXu.length * 1);
            }
            if (this.zXs != null && this.zXs.length > 0) {
                i = rM;
                for (com.google.a.a.e eVar22 : this.zXs) {
                    if (eVar22 != null) {
                        i += com.google.a.a.b.b(9, eVar22);
                    }
                }
                rM = i;
            }
            if (this.zWa != null) {
                rM += com.google.a.a.b.b(10, this.zWa);
            }
            if (this.zXv != null && this.zXv.length > 0) {
                i = rM;
                for (com.google.a.a.e eVar222 : this.zXv) {
                    if (eVar222 != null) {
                        i += com.google.a.a.b.b(11, eVar222);
                    }
                }
                rM = i;
            }
            if (this.zWJ != null && this.zWJ.length > 0) {
                i = rM;
                for (com.google.a.a.e eVar2222 : this.zWJ) {
                    if (eVar2222 != null) {
                        i += com.google.a.a.b.b(12, eVar2222);
                    }
                }
                rM = i;
            }
            if (this.zXy != null && this.zXy.length > 0) {
                while (i2 < this.zXy.length) {
                    com.google.a.a.e eVar3 = this.zXy[i2];
                    if (eVar3 != null) {
                        rM += com.google.a.a.b.b(13, eVar3);
                    }
                    i2++;
                }
            }
            if (this.zXz != 0) {
                rM += com.google.a.a.b.aD(14, this.zXz);
            }
            if (this.zXA != 0) {
                rM += com.google.a.a.b.aD(15, this.zXA);
            }
            if (this.zXB != 0) {
                rM += com.google.a.a.b.aD(16, this.zXB);
            }
            if (Arrays.equals(this.zXC, com.google.a.a.g.bfX)) {
                return rM;
            }
            return rM + com.google.a.a.b.b(17, this.zXC);
        }
    }

    public static final class an extends com.google.a.a.e {
        public long hMO;
        public int hQv;
        public int zXQ;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.hMO = aVar.rA();
                        continue;
                    case 16:
                        this.hQv = aVar.rz();
                        continue;
                    case 24:
                        this.zXQ = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public an() {
            this.hMO = 0;
            this.hQv = 0;
            this.zXQ = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.hMO != 0) {
                bVar.j(1, this.hMO);
            }
            if (this.hQv != 0) {
                bVar.aC(2, this.hQv);
            }
            if (this.zXQ != 0) {
                bVar.aC(3, this.zXQ);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.hMO != 0) {
                rM += com.google.a.a.b.l(1, this.hMO);
            }
            if (this.hQv != 0) {
                rM += com.google.a.a.b.aE(2, this.hQv);
            }
            if (this.zXQ != 0) {
                return rM + com.google.a.a.b.aE(3, this.zXQ);
            }
            return rM;
        }
    }

    public static final class e extends com.google.a.a.e {
        public String groupId;
        public int netType;
        public int srH;
        public long srI;
        public int zVW;
        public at zWa;
        public ba zWc;
        public int zWe;
        public String[] zWh;
        public m[] zWi;
        public int zWj;
        public int zWk;
        public s zWl;
        public int zWm;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                int b;
                Object obj;
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.srH = aVar.rz();
                        continue;
                    case 24:
                        this.srI = aVar.rA();
                        continue;
                    case 34:
                        if (this.zWc == null) {
                            this.zWc = new ba();
                        }
                        aVar.a(this.zWc);
                        continue;
                    case 40:
                        this.zWk = aVar.rz();
                        continue;
                    case R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                        this.zWe = aVar.rz();
                        continue;
                    case 56:
                        this.zVW = aVar.rz();
                        continue;
                    case 64:
                        this.netType = aVar.rz();
                        continue;
                    case 1602:
                        if (this.zWa == null) {
                            this.zWa = new at();
                        }
                        aVar.a(this.zWa);
                        continue;
                    case 1610:
                        b = com.google.a.a.g.b(aVar, 1610);
                        ry = this.zWh == null ? 0 : this.zWh.length;
                        obj = new String[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zWh, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = aVar.readString();
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = aVar.readString();
                        this.zWh = obj;
                        continue;
                    case 1618:
                        b = com.google.a.a.g.b(aVar, 1618);
                        ry = this.zWi == null ? 0 : this.zWi.length;
                        obj = new m[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zWi, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new m();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new m();
                        aVar.a(obj[ry]);
                        this.zWi = obj;
                        continue;
                    case 1626:
                        if (this.zWl == null) {
                            this.zWl = new s();
                        }
                        aVar.a(this.zWl);
                        continue;
                    case 1632:
                        this.zWm = aVar.rz();
                        continue;
                    case 1920:
                        this.zWj = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public e() {
            this.groupId = "";
            this.srH = 0;
            this.srI = 0;
            this.zWc = null;
            this.zWk = 0;
            this.zWe = 0;
            this.zVW = 0;
            this.netType = 0;
            this.zWa = null;
            this.zWh = com.google.a.a.g.EMPTY_STRING_ARRAY;
            this.zWi = m.cDB();
            this.zWl = null;
            this.zWm = 0;
            this.zWj = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.srH != 0) {
                bVar.aB(2, this.srH);
            }
            if (this.srI != 0) {
                bVar.k(3, this.srI);
            }
            if (this.zWc != null) {
                bVar.a(4, this.zWc);
            }
            if (this.zWk != 0) {
                bVar.aB(5, this.zWk);
            }
            if (this.zWe != 0) {
                bVar.aC(6, this.zWe);
            }
            if (this.zVW != 0) {
                bVar.aB(7, this.zVW);
            }
            if (this.netType != 0) {
                bVar.aC(8, this.netType);
            }
            if (this.zWa != null) {
                bVar.a(200, this.zWa);
            }
            if (this.zWh != null && this.zWh.length > 0) {
                for (String str : this.zWh) {
                    if (str != null) {
                        bVar.g(201, str);
                    }
                }
            }
            if (this.zWi != null && this.zWi.length > 0) {
                while (i < this.zWi.length) {
                    com.google.a.a.e eVar = this.zWi[i];
                    if (eVar != null) {
                        bVar.a(202, eVar);
                    }
                    i++;
                }
            }
            if (this.zWl != null) {
                bVar.a(203, this.zWl);
            }
            if (this.zWm != 0) {
                bVar.aC(com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX, this.zWm);
            }
            if (this.zWj != 0) {
                bVar.aC(240, this.zWj);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int i = 0;
            int rM = super.rM();
            if (!this.groupId.equals("")) {
                rM += com.google.a.a.b.h(1, this.groupId);
            }
            if (this.srH != 0) {
                rM += com.google.a.a.b.aD(2, this.srH);
            }
            if (this.srI != 0) {
                rM += com.google.a.a.b.m(3, this.srI);
            }
            if (this.zWc != null) {
                rM += com.google.a.a.b.b(4, this.zWc);
            }
            if (this.zWk != 0) {
                rM += com.google.a.a.b.aD(5, this.zWk);
            }
            if (this.zWe != 0) {
                rM += com.google.a.a.b.aE(6, this.zWe);
            }
            if (this.zVW != 0) {
                rM += com.google.a.a.b.aD(7, this.zVW);
            }
            if (this.netType != 0) {
                rM += com.google.a.a.b.aE(8, this.netType);
            }
            if (this.zWa != null) {
                rM += com.google.a.a.b.b(200, this.zWa);
            }
            if (this.zWh != null && this.zWh.length > 0) {
                int i2 = 0;
                int i3 = 0;
                for (String str : this.zWh) {
                    if (str != null) {
                        i3++;
                        i2 += com.google.a.a.b.bm(str);
                    }
                }
                rM = (rM + i2) + (i3 * 2);
            }
            if (this.zWi != null && this.zWi.length > 0) {
                while (i < this.zWi.length) {
                    com.google.a.a.e eVar = this.zWi[i];
                    if (eVar != null) {
                        rM += com.google.a.a.b.b(202, eVar);
                    }
                    i++;
                }
            }
            if (this.zWl != null) {
                rM += com.google.a.a.b.b(203, this.zWl);
            }
            if (this.zWm != 0) {
                rM += com.google.a.a.b.aE(com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX, this.zWm);
            }
            if (this.zWj != 0) {
                return rM + com.google.a.a.b.aE(240, this.zWj);
            }
            return rM;
        }
    }

    public static final class g extends com.google.a.a.e {
        public int aAk;
        public String groupId;
        public int srH;
        public long srI;
        public String zVY;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.srH = aVar.rz();
                        continue;
                    case 24:
                        this.srI = aVar.rA();
                        continue;
                    case 32:
                        this.aAk = aVar.rz();
                        continue;
                    case R.styleable.AppCompatTheme_dialogTheme /*42*/:
                        this.zVY = aVar.readString();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public g() {
            this.groupId = "";
            this.srH = 0;
            this.srI = 0;
            this.aAk = 0;
            this.zVY = "";
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.srH != 0) {
                bVar.aB(2, this.srH);
            }
            if (this.srI != 0) {
                bVar.k(3, this.srI);
            }
            if (this.aAk != 0) {
                bVar.aB(4, this.aAk);
            }
            if (!this.zVY.equals("")) {
                bVar.g(5, this.zVY);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (!this.groupId.equals("")) {
                rM += com.google.a.a.b.h(1, this.groupId);
            }
            if (this.srH != 0) {
                rM += com.google.a.a.b.aD(2, this.srH);
            }
            if (this.srI != 0) {
                rM += com.google.a.a.b.m(3, this.srI);
            }
            if (this.aAk != 0) {
                rM += com.google.a.a.b.aD(4, this.aAk);
            }
            if (this.zVY.equals("")) {
                return rM;
            }
            return rM + com.google.a.a.b.h(5, this.zVY);
        }
    }

    public static final class l extends com.google.a.a.e {
        public String groupId;
        public int hVH;
        public int nJK;
        public int srH;
        public long srI;
        public int zWp;
        public byte[] zWq;
        public az[] zWr;
        public ao[] zWs;
        public int zWt;
        public int zWu;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                int b;
                Object obj;
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.srH = aVar.rz();
                        continue;
                    case 24:
                        this.srI = aVar.rA();
                        continue;
                    case 32:
                        this.nJK = aVar.rz();
                        continue;
                    case 40:
                        this.zWp = aVar.rz();
                        continue;
                    case 50:
                        this.zWq = aVar.readBytes();
                        continue;
                    case 58:
                        b = com.google.a.a.g.b(aVar, 58);
                        ry = this.zWr == null ? 0 : this.zWr.length;
                        obj = new az[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zWr, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new az();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new az();
                        aVar.a(obj[ry]);
                        this.zWr = obj;
                        continue;
                    case 66:
                        b = com.google.a.a.g.b(aVar, 66);
                        ry = this.zWs == null ? 0 : this.zWs.length;
                        obj = new ao[(b + ry)];
                        if (ry != 0) {
                            System.arraycopy(this.zWs, 0, obj, 0, ry);
                        }
                        while (ry < obj.length - 1) {
                            obj[ry] = new ao();
                            aVar.a(obj[ry]);
                            aVar.ry();
                            ry++;
                        }
                        obj[ry] = new ao();
                        aVar.a(obj[ry]);
                        this.zWs = obj;
                        continue;
                    case 72:
                        this.zWt = aVar.rz();
                        continue;
                    case 80:
                        this.zWu = aVar.rz();
                        continue;
                    case R.styleable.AppCompatTheme_colorButtonNormal /*88*/:
                        this.hVH = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public l() {
            this.groupId = "";
            this.srH = 0;
            this.srI = 0;
            this.nJK = -1;
            this.zWp = 0;
            this.zWq = com.google.a.a.g.bfX;
            this.zWr = az.cDL();
            this.zWs = ao.cDG();
            this.zWt = 0;
            this.zWu = 0;
            this.hVH = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.srH != 0) {
                bVar.aB(2, this.srH);
            }
            if (this.srI != 0) {
                bVar.k(3, this.srI);
            }
            if (this.nJK != -1) {
                bVar.aB(4, this.nJK);
            }
            if (this.zWp != 0) {
                bVar.aB(5, this.zWp);
            }
            if (!Arrays.equals(this.zWq, com.google.a.a.g.bfX)) {
                bVar.a(6, this.zWq);
            }
            if (this.zWr != null && this.zWr.length > 0) {
                for (com.google.a.a.e eVar : this.zWr) {
                    if (eVar != null) {
                        bVar.a(7, eVar);
                    }
                }
            }
            if (this.zWs != null && this.zWs.length > 0) {
                while (i < this.zWs.length) {
                    com.google.a.a.e eVar2 = this.zWs[i];
                    if (eVar2 != null) {
                        bVar.a(8, eVar2);
                    }
                    i++;
                }
            }
            if (this.zWt != 0) {
                bVar.aB(9, this.zWt);
            }
            if (this.zWu != 0) {
                bVar.aB(10, this.zWu);
            }
            if (this.hVH != 0) {
                bVar.aB(11, this.hVH);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int i = 0;
            int rM = super.rM();
            if (!this.groupId.equals("")) {
                rM += com.google.a.a.b.h(1, this.groupId);
            }
            if (this.srH != 0) {
                rM += com.google.a.a.b.aD(2, this.srH);
            }
            if (this.srI != 0) {
                rM += com.google.a.a.b.m(3, this.srI);
            }
            if (this.nJK != -1) {
                rM += com.google.a.a.b.aD(4, this.nJK);
            }
            if (this.zWp != 0) {
                rM += com.google.a.a.b.aD(5, this.zWp);
            }
            if (!Arrays.equals(this.zWq, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(6, this.zWq);
            }
            if (this.zWr != null && this.zWr.length > 0) {
                int i2 = rM;
                for (com.google.a.a.e eVar : this.zWr) {
                    if (eVar != null) {
                        i2 += com.google.a.a.b.b(7, eVar);
                    }
                }
                rM = i2;
            }
            if (this.zWs != null && this.zWs.length > 0) {
                while (i < this.zWs.length) {
                    com.google.a.a.e eVar2 = this.zWs[i];
                    if (eVar2 != null) {
                        rM += com.google.a.a.b.b(8, eVar2);
                    }
                    i++;
                }
            }
            if (this.zWt != 0) {
                rM += com.google.a.a.b.aD(9, this.zWt);
            }
            if (this.zWu != 0) {
                rM += com.google.a.a.b.aD(10, this.zWu);
            }
            if (this.hVH != 0) {
                return rM + com.google.a.a.b.aD(11, this.hVH);
            }
            return rM;
        }
    }

    public static final class n extends com.google.a.a.e {
        private static volatile n[] zWx;
        public byte[] fzJ;
        public int zWy;
        public int zWz;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 8:
                        this.zWy = aVar.rz();
                        continue;
                    case 18:
                        this.fzJ = aVar.readBytes();
                        continue;
                    case 24:
                        this.zWz = aVar.rz();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public static n[] cDC() {
            if (zWx == null) {
                synchronized (com.google.a.a.c.bfP) {
                    if (zWx == null) {
                        zWx = new n[0];
                    }
                }
            }
            return zWx;
        }

        public n() {
            this.zWy = 0;
            this.fzJ = com.google.a.a.g.bfX;
            this.zWz = 0;
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.zWy != 0) {
                bVar.aB(1, this.zWy);
            }
            if (!Arrays.equals(this.fzJ, com.google.a.a.g.bfX)) {
                bVar.a(2, this.fzJ);
            }
            if (this.zWz != 0) {
                bVar.aC(3, this.zWz);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (this.zWy != 0) {
                rM += com.google.a.a.b.aD(1, this.zWy);
            }
            if (!Arrays.equals(this.fzJ, com.google.a.a.g.bfX)) {
                rM += com.google.a.a.b.b(2, this.fzJ);
            }
            if (this.zWz != 0) {
                return rM + com.google.a.a.b.aE(3, this.zWz);
            }
            return rM;
        }
    }

    public static final class w extends com.google.a.a.e {
        private static volatile w[] zXn;
        public String zXo;
        public String zXp;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int ry = aVar.ry();
                switch (ry) {
                    case 0:
                        break;
                    case 10:
                        this.zXo = aVar.readString();
                        continue;
                    case 18:
                        this.zXp = aVar.readString();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, ry)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public static w[] cDE() {
            if (zXn == null) {
                synchronized (com.google.a.a.c.bfP) {
                    if (zXn == null) {
                        zXn = new w[0];
                    }
                }
            }
            return zXn;
        }

        public w() {
            this.zXo = "";
            this.zXp = "";
            this.bfQ = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.zXo.equals("")) {
                bVar.g(1, this.zXo);
            }
            if (!this.zXp.equals("")) {
                bVar.g(2, this.zXp);
            }
            super.a(bVar);
        }

        protected final int rM() {
            int rM = super.rM();
            if (!this.zXo.equals("")) {
                rM += com.google.a.a.b.h(1, this.zXo);
            }
            if (this.zXp.equals("")) {
                return rM;
            }
            return rM + com.google.a.a.b.h(2, this.zXp);
        }
    }
}
