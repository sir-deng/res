package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.f;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.pa;
import com.tencent.mm.protocal.c.pb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends k implements com.tencent.mm.network.k {
    private String clientId = null;
    private String fAJ;
    private b gLB;
    private e gLE;
    private f hCU;
    private int hmZ = 0;
    private int hna = 0;
    private String puD = null;
    private String puE;
    private int puF = 0;

    public m(java.lang.String r7, java.lang.String r8, java.lang.String[] r9, int r10, com.tencent.mm.ad.f r11) {
        /* JADX: method processing error */
/*
Error: java.lang.IndexOutOfBoundsException: bitIndex < 0: -1
	at java.util.BitSet.get(BitSet.java:623)
	at jadx.core.dex.visitors.CodeShrinker$ArgsInfo.usedArgAssign(CodeShrinker.java:138)
	at jadx.core.dex.visitors.CodeShrinker$ArgsInfo.access$300(CodeShrinker.java:43)
	at jadx.core.dex.visitors.CodeShrinker.canMoveBetweenBlocks(CodeShrinker.java:282)
	at jadx.core.dex.visitors.CodeShrinker.shrinkBlock(CodeShrinker.java:232)
	at jadx.core.dex.visitors.CodeShrinker.shrinkMethod(CodeShrinker.java:38)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkArrayForEach(LoopRegionVisitor.java:196)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkForIndexedLoop(LoopRegionVisitor.java:119)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.processLoopRegion(LoopRegionVisitor.java:65)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.enterRegion(LoopRegionVisitor.java:52)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:56)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1080)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:46)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
        /*
        r6 = this;
        r0 = 0;
        r1 = 0;
        r6.<init>();
        r6.puD = r0;
        r6.hmZ = r1;
        r6.clientId = r0;
        r6.hna = r1;
        r6.puF = r1;
        r6.puD = r7;
        r6.puF = r10;
        r6.hCU = r11;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r7);
        if (r0 != 0) goto L_0x005e;
    L_0x001b:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = r7.getBytes();
        r2 = com.tencent.mm.a.g.s(r2);
        r0 = r0.append(r2);
        r2 = "_";
        r0 = r0.append(r2);
        r2 = java.lang.System.nanoTime();
        r0 = r0.append(r2);
        r2 = "_";
        r0 = r0.append(r2);
        r2 = new java.util.Random;
        r2.<init>();
        r2 = r2.nextInt();
        r0 = r0.append(r2);
        r0 = r0.toString();
        r6.clientId = r0;
        r0 = r7.getBytes();
        r0 = r0.length;
        r6.hmZ = r0;
        r6.hna = r1;
    L_0x005e:
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r8);
        if (r0 != 0) goto L_0x0066;
    L_0x0064:
        r6.fAJ = r8;
    L_0x0066:
        if (r9 == 0) goto L_0x00a2;
    L_0x0068:
        r0 = "";
        r6.puE = r0;
        r2 = r9.length;
        r0 = r1;
    L_0x006f:
        if (r0 >= r2) goto L_0x0092;
    L_0x0071:
        r3 = r9[r0];
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = r6.puE;
        r4 = r4.append(r5);
        r3 = r4.append(r3);
        r4 = ",";
        r3 = r3.append(r4);
        r3 = r3.toString();
        r6.puE = r3;
        r0 = r0 + 1;
        goto L_0x006f;
    L_0x0092:
        r0 = r6.puE;
        r2 = r6.puE;
        r2 = r2.length();
        r2 = r2 + -1;
        r0 = r0.substring(r1, r2);
        r6.puE = r0;
    L_0x00a2:
        r0 = "MicroMsg.NetSceneComposeSend";
        r2 = "NetSceneComposeSend, clientId: %s, totalLen: %d";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = r6.clientId;
        r3[r1] = r4;
        r1 = 1;
        r4 = r6.hmZ;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r1] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.qqmail.b.m.<init>(java.lang.String, java.lang.String, java.lang.String[], int, com.tencent.mm.ad.f):void");
    }

    protected final int Bo() {
        return 100;
    }

    protected final int a(q qVar) {
        if (!bi.oN(this.puD)) {
            return b.hoz;
        }
        x.e("MicroMsg.NetSceneComposeSend", "securityVerificationChecked failed, content is null");
        return b.hoA;
    }

    protected final void a(a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneComposeSend", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.hna = ((pb) ((b) qVar).hnR.hnY).vPt;
            if (this.gLE != null) {
                this.gLE.a(i2, i3, str, this);
            }
            if (this.hCU != null) {
                this.hCU.a(this.hna, this.hmZ, this);
            }
            if (this.hna < this.hmZ) {
                x.i("MicroMsg.NetSceneComposeSend", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", Integer.valueOf(this.hna), Integer.valueOf(this.hmZ));
                if (a(this.hok, this.gLE) < 0) {
                    x.e("MicroMsg.NetSceneComposeSend", "continue to upload fail");
                    return;
                }
                return;
            }
            x.i("MicroMsg.NetSceneComposeSend", "finished upload");
        } else if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 485;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        if (bi.oN(this.puD)) {
            x.e("MicroMsg.NetSceneComposeSend", "doScene, sendContent is null");
            return -1;
        }
        int min = Math.min(this.hmZ - this.hna, WXMediaMessage.THUMB_LENGTH_LIMIT);
        x.i("MicroMsg.NetSceneComposeSend", "doScene, dataLen: %d", Integer.valueOf(min));
        byte[] bArr = new byte[min];
        byte[] bytes = this.puD.getBytes();
        int i = 0;
        for (int i2 = this.hna; i2 < this.hna + min; i2++) {
            bArr[i] = bytes[i2];
            i++;
        }
        if (bi.by(bArr)) {
            x.e("MicroMsg.NetSceneComposeSend", "doScene, sendData is null");
            return -1;
        }
        a aVar = new a();
        aVar.hnT = new pa();
        aVar.hnU = new pb();
        aVar.uri = "/cgi-bin/micromsg-bin/composesend";
        aVar.hnS = 485;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        pa paVar = (pa) this.gLB.hnQ.hnY;
        paVar.vNF = this.clientId;
        paVar.vPs = this.hmZ;
        paVar.vPt = this.hna;
        paVar.vPu = min;
        paVar.weE = this.fAJ;
        paVar.weF = this.puE;
        paVar.weG = (int) (((float) this.hmZ) + (((float) this.puF) * 1.3333334f));
        x.i("MicroMsg.NetSceneComposeSend", "doScene, realSize: %d", Integer.valueOf(paVar.weG));
        paVar.weD = n.N(bArr);
        x.i("MicroMsg.NetSceneComposeSend", "doScene, ret: %d", Integer.valueOf(a(eVar, this.gLB, this)));
        return a(eVar, this.gLB, this);
    }
}
