package com.tencent.mm.modelmulti;

import android.database.Cursor;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.atw;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.protocal.c.ot;
import com.tencent.mm.protocal.c.ou;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public final class t {
    private static ArrayList<bx> hJw = new ArrayList();
    private static ArrayList<x> hJx = new ArrayList();

    static /* synthetic */ void lN(String str) {
        Throwable e;
        int i = 0;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        i++;
                        String[] split = readLine.split("###");
                        if (split == null || split.length != 3) {
                            String str2 = "MicroMsg.TestSyncAddMsg";
                            String str3 = "readMsgFromFile parse line %d failed : len:%d ";
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(i);
                            objArr[1] = Integer.valueOf(split == null ? -1 : split.length);
                            com.tencent.mm.sdk.platformtools.x.e(str2, str3, objArr);
                        } else {
                            bx bxVar = new bx();
                            bxVar.vNN = new bet().Vf(q.FY());
                            bxVar.kyY = 2;
                            bxVar.vNQ = new bes().bl(new byte[0]);
                            bxVar.nlX = bi.getInt(split[0], 0);
                            bxVar.vNP = bi.getInt(split[1], 0);
                            bxVar.vNO = new bet().Vf(split[2]);
                            hJw.add(bxVar);
                        }
                    } else {
                        try {
                            bufferedReader.close();
                            return;
                        } catch (Exception e2) {
                            return;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
        } catch (Exception e4) {
            e = e4;
            bufferedReader = null;
            try {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.TestSyncAddMsg", "readMsgFromFile failed e:%s", e.getMessage());
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.TestSyncAddMsg", e, "", new Object[0]);
                try {
                    bufferedReader.close();
                } catch (Exception e5) {
                }
            } catch (Throwable th) {
                e = th;
                try {
                    bufferedReader.close();
                } catch (Exception e6) {
                }
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            bufferedReader.close();
            throw e;
        }
    }

    static /* synthetic */ void uc() {
        as.Hm();
        Cursor c = c.Ff().c(null, null, new ArrayList());
        while (c.moveToNext()) {
            x xVar = new x();
            xVar.b(c);
            hJx.add(xVar);
        }
        c.close();
    }

    public static void bd(final int i, final int i2) {
        as.Dt().F(new Runnable() {
            public final void run() {
                t.uc();
                t.lN(e.bnF + "/testaddmsg.txt");
                if (t.hJx.size() <= 0 || t.hJw.size() <= 0) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.TestSyncAddMsg", "syncAddMsg get source failed cmd:%d contact:%d", Integer.valueOf(t.hJw.size()), Integer.valueOf(t.hJx.size()));
                    return;
                }
                new al(as.Dt().oFY.getLooper(), new a() {
                    int hJA = i;

                    public final boolean uG() {
                        if (this.hJA <= 0) {
                            return false;
                        }
                        this.hJA--;
                        b bVar = new b();
                        bVar.vID.vYH = new ou();
                        int eI = bi.eI(i2, 1);
                        for (int i = 0; i < eI; i++) {
                            bx bxVar = (bx) t.hJw.get(bi.eI(t.hJw.size() - 1, 0));
                            bxVar.vNM = new bet().Vf(((x) t.hJx.get(bi.eI(t.hJx.size() - 1, 0))).field_username);
                            bxVar.pgR = (int) bi.Wx();
                            bxVar.vNT = (long) Math.abs(((int) bi.Wy()) % 10000000);
                            try {
                                ot otVar = new ot();
                                otVar.weu = new bes();
                                otVar.weu.bl(bxVar.toByteArray());
                                otVar.wet = 5;
                                bVar.vID.vYH.kyB.add(otVar);
                                ou ouVar = bVar.vID.vYH;
                                ouVar.kyA++;
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.TestSyncAddMsg", "syncAddMsg  loop:%d cnt:[%d,%d] cmdList:%d id:%d u:%s", Integer.valueOf(this.hJA), Integer.valueOf(i), Integer.valueOf(eI), Integer.valueOf(bVar.vID.vYH.kyB.size()), Long.valueOf(bxVar.vNT), bxVar.vNM.wRo);
                            } catch (Throwable e) {
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.TestSyncAddMsg", e.getMessage());
                                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.TestSyncAddMsg", e, "", new Object[0]);
                            }
                        }
                        bVar.vID.vWu = 0;
                        atw atw = bVar.vID;
                        as.Hm();
                        atw.vYE = n.N(bi.Wj(bi.oM((String) c.Db().get(8195, new byte[0]))));
                        bVar.vID.vQL = 0;
                        bVar.vID.kyY = 0;
                        q.Qj().a(bVar, 0, bi.Wx());
                        return true;
                    }
                }, true).K(3000, 3000);
            }
        });
    }
}
