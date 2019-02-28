package com.tencent.mm.plugin.location.model;

import com.tencent.mm.modelgeo.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import java.util.Set;

public final class a {

    public static class a {
        Set<Long> nWk;
        private com.tencent.mm.modelgeo.b.a nWl = new com.tencent.mm.modelgeo.b.a() {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void b(com.tencent.mm.modelgeo.Addr r11) {
                /*
                r10 = this;
                r1 = 0;
                r7 = -1;
                r3 = com.tencent.mm.plugin.location.model.a.a.this;
                r0 = r11.tag;
                if (r0 == 0) goto L_0x0198;
            L_0x0008:
                r0 = r11.tag;
                r0 = r0 instanceof java.lang.Long;
                if (r0 == 0) goto L_0x0198;
            L_0x000e:
                r0 = r11.tag;
                r0 = (java.lang.Long) r0;
                r4 = r0.longValue();
                com.tencent.mm.y.as.Hm();
                r0 = com.tencent.mm.y.c.Fh();
                r4 = r0.dI(r4);
                r0 = r11.hzf;
                r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
                if (r0 != 0) goto L_0x0198;
            L_0x0029:
                r2 = r4.field_content;
                r0 = r4.field_isSend;
                if (r0 != 0) goto L_0x0199;
            L_0x002f:
                r0 = 1;
            L_0x0030:
                r5 = r4.field_talker;
                r5 = com.tencent.mm.y.s.eX(r5);
                if (r5 == 0) goto L_0x004a;
            L_0x0038:
                if (r0 == 0) goto L_0x004a;
            L_0x003a:
                r6 = com.tencent.mm.y.bb.hR(r2);
                if (r6 == r7) goto L_0x004a;
            L_0x0040:
                r6 = r6 + 1;
                r2 = r2.substring(r6);
                r2 = r2.trim();
            L_0x004a:
                r6 = com.tencent.mm.storage.au.b.XZ(r2);
                r2 = r11.OS();
                r6.label = r2;
                r2 = "";
                if (r5 == 0) goto L_0x019e;
            L_0x0059:
                if (r0 == 0) goto L_0x019e;
            L_0x005b:
                r0 = r4.field_content;
                r0 = com.tencent.mm.y.bb.hR(r0);
                if (r0 == r7) goto L_0x019e;
            L_0x0063:
                r7 = r4.field_content;
                r0 = r7.substring(r1, r0);
                r0 = r0.trim();
                r1 = r0.length();
                if (r1 <= 0) goto L_0x019e;
            L_0x0073:
                r1 = r6.xHT;
                if (r1 == 0) goto L_0x0082;
            L_0x0077:
                r1 = r6.xHT;
                r2 = "";
                r1 = r1.equals(r2);
                if (r1 == 0) goto L_0x0087;
            L_0x0082:
                r1 = "";
                r6.xHT = r1;
            L_0x0087:
                r1 = r6.xHS;
                if (r1 == 0) goto L_0x0096;
            L_0x008b:
                r1 = r6.xHS;
                r2 = "";
                r1 = r1.equals(r2);
                if (r1 == 0) goto L_0x009b;
            L_0x0096:
                r1 = "";
                r6.xHT = r1;
            L_0x009b:
                r1 = r6.xHR;
                if (r1 == 0) goto L_0x00aa;
            L_0x009f:
                r1 = r6.xHR;
                r2 = "";
                r1 = r1.equals(r2);
                if (r1 == 0) goto L_0x00af;
            L_0x00aa:
                r1 = "";
                r6.xHR = r1;
            L_0x00af:
                r1 = r6.sfb;
                if (r1 == 0) goto L_0x00be;
            L_0x00b3:
                r1 = r6.sfb;
                r2 = "";
                r1 = r1.equals(r2);
                if (r1 == 0) goto L_0x00c3;
            L_0x00be:
                r1 = "";
                r6.sfb = r1;
            L_0x00c3:
                r1 = r6.label;
                if (r1 == 0) goto L_0x00d2;
            L_0x00c7:
                r1 = r6.label;
                r2 = "";
                r1 = r1.equals(r2);
                if (r1 == 0) goto L_0x00d7;
            L_0x00d2:
                r1 = "";
                r6.label = r1;
            L_0x00d7:
                r1 = r6.xHQ;
                if (r1 == 0) goto L_0x00e6;
            L_0x00db:
                r1 = r6.xHQ;
                r2 = "";
                r1 = r1.equals(r2);
                if (r1 == 0) goto L_0x00eb;
            L_0x00e6:
                r1 = "";
                r6.xHQ = r1;
            L_0x00eb:
                r1 = new java.lang.StringBuilder;
                r2 = "<msg><location x=\"";
                r1.<init>(r2);
                r8 = r6.nWe;
                r1 = r1.append(r8);
                r2 = "\" y=\"";
                r1 = r1.append(r2);
                r8 = r6.nWf;
                r1 = r1.append(r8);
                r2 = "\" scale=\"";
                r1 = r1.append(r2);
                r2 = r6.fAq;
                r1 = r1.append(r2);
                r2 = "\" label=\"";
                r1 = r1.append(r2);
                r2 = r6.label;
                r1 = r1.append(r2);
                r2 = "\" maptype=\"";
                r1 = r1.append(r2);
                r2 = r6.xHQ;
                r1 = r1.append(r2);
                r2 = "\"  fromusername=\"";
                r1 = r1.append(r2);
                r2 = r6.sfb;
                r1 = r1.append(r2);
                r2 = "\" /></msg>";
                r1 = r1.append(r2);
                r1 = r1.toString();
                if (r5 == 0) goto L_0x019c;
            L_0x0147:
                r2 = "";
                r2 = r0.equals(r2);
                if (r2 != 0) goto L_0x019c;
            L_0x0150:
                r2 = new java.lang.StringBuilder;
                r2.<init>();
                r0 = r2.append(r0);
                r2 = ":\n";
                r0 = r0.append(r2);
                r0 = r0.append(r1);
                r0 = r0.toString();
            L_0x0168:
                r1 = "MicroMsg.LocationServer";
                r2 = new java.lang.StringBuilder;
                r5 = "xml: ";
                r2.<init>(r5);
                r2 = r2.append(r0);
                r2 = r2.toString();
                com.tencent.mm.sdk.platformtools.x.d(r1, r2);
                r4.setContent(r0);
                com.tencent.mm.y.as.Hm();
                r0 = com.tencent.mm.y.c.Fh();
                r6 = r4.field_msgId;
                r0.a(r6, r4);
                r0 = r3.nWk;
                r2 = r4.field_msgId;
                r1 = java.lang.Long.valueOf(r2);
                r0.remove(r1);
            L_0x0198:
                return;
            L_0x0199:
                r0 = r1;
                goto L_0x0030;
            L_0x019c:
                r0 = r1;
                goto L_0x0168;
            L_0x019e:
                r0 = r2;
                goto L_0x0073;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.location.model.a.a.1.b(com.tencent.mm.modelgeo.Addr):void");
            }
        };

        public final void aVS() {
            if (this.nWk != null) {
                this.nWk.clear();
            }
            b.OT().a(this.nWl);
        }

        public final String[] N(au auVar) {
            int i = 1;
            String[] strArr = new String[2];
            String str = auVar.field_content;
            if (bi.oN(str)) {
                strArr[0] = "";
                strArr[1] = "";
                return strArr;
            }
            String trim;
            au.b Fr;
            long j;
            int i2 = auVar.field_isSend == 0 ? 1 : 0;
            if (s.eX(auVar.field_talker) && i2 != 0) {
                i2 = bb.hR(str);
                if (i2 != -1) {
                    trim = str.substring(i2 + 1).trim();
                    as.Hm();
                    Fr = c.Fh().Fr(trim);
                    if (Fr.ckw()) {
                        strArr[0] = Fr.label;
                        strArr[1] = "";
                    } else {
                        str = Fr.label;
                        trim = Fr.nYL;
                        strArr[0] = str;
                        strArr[1] = trim;
                    }
                    if (bi.oN(strArr[0]) && bi.oN(strArr[1])) {
                        x.i("MicroMsg.LocationServer", "pull from sever");
                        j = auVar.field_msgId;
                        if (!(this.nWk == null || this.nWk.contains(Long.valueOf(j)))) {
                            trim = auVar.field_content;
                            if (auVar.field_isSend != 0) {
                                i = 0;
                            }
                            if (s.eX(auVar.field_talker) && i != 0) {
                                i = bb.hR(trim);
                                if (i != -1) {
                                    trim = trim.substring(i + 1).trim();
                                }
                            }
                            Fr = au.b.XZ(trim);
                            this.nWk.add(Long.valueOf(j));
                            b.OT().a(Fr.nWe, Fr.nWf, this.nWl, Long.valueOf(auVar.field_msgId));
                        }
                    }
                    return strArr;
                }
            }
            trim = str;
            as.Hm();
            Fr = c.Fh().Fr(trim);
            if (Fr.ckw()) {
                strArr[0] = Fr.label;
                strArr[1] = "";
            } else {
                str = Fr.label;
                trim = Fr.nYL;
                strArr[0] = str;
                strArr[1] = trim;
            }
            x.i("MicroMsg.LocationServer", "pull from sever");
            j = auVar.field_msgId;
            trim = auVar.field_content;
            if (auVar.field_isSend != 0) {
                i = 0;
            }
            i = bb.hR(trim);
            if (i != -1) {
                trim = trim.substring(i + 1).trim();
            }
            Fr = au.b.XZ(trim);
            this.nWk.add(Long.valueOf(j));
            b.OT().a(Fr.nWe, Fr.nWf, this.nWl, Long.valueOf(auVar.field_msgId));
            return strArr;
        }
    }
}
