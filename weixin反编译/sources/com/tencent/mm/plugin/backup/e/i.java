package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.beu;
import com.tencent.mm.protocal.c.ev;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class i {

    public static class a {
        String filePath;
        int fuz;
        u ksN;
        ev ksQ;
        LinkedList<u> ksR;
        boolean ksS = true;
        String ksT;
        boolean ksU;

        public a(String str, ev evVar, LinkedList<u> linkedList, int i, boolean z, boolean z2, u uVar) {
            this.filePath = str;
            this.ksQ = evVar;
            this.ksR = linkedList;
            this.fuz = i;
            this.ksS = z;
            this.ksU = z2;
            this.ksN = uVar;
        }

        public a(String str, ev evVar, LinkedList<u> linkedList, int i, boolean z, String str2, boolean z2) {
            this.filePath = str;
            this.ksQ = evVar;
            this.ksR = linkedList;
            this.fuz = i;
            this.ksS = z;
            this.ksT = str2;
            this.ksU = z2;
            this.ksN = null;
        }
    }

    public static int a(a aVar) {
        if (aVar.ksQ == null) {
            x.e("MicroMsg.BackupPackUtil", "packBackupItem %s is null!", "backupItemInfo.backupitem");
            return 0;
        }
        int bN = e.bN(aVar.filePath);
        if (bN <= 0) {
            x.e("MicroMsg.BackupPackUtil", "packBackupItem filePath error:" + aVar.filePath);
            return 0;
        } else if (aVar.ksS) {
            return bN;
        } else {
            if (aVar.ksR == null) {
                x.e("MicroMsg.BackupPackUtil", "packBackupItem error mediaInfoList null");
                return 0;
            }
            String str = aVar.ksQ.vNM.toString() + "_" + aVar.ksQ.vNN.toString() + "_" + aVar.ksQ.vNT + "_backup_" + (aVar.ksT == null ? "" : aVar.ksT);
            x.d("MicroMsg.BackupPackUtil", "packBackupItem mediaId:%s, filePath:%s", str, aVar.filePath);
            aVar.ksQ.vQU.add(new bet().Vf(str));
            aVar.ksQ.vQV.add(new beu().Dp(aVar.fuz));
            aVar.ksQ.vQT = aVar.ksQ.vQU.size();
            if (aVar.ksN == null) {
                aVar.ksN = new u();
            }
            aVar.ksN.kzw = aVar.ksQ.vNT;
            aVar.ksN.mediaId = str;
            aVar.ksN.path = aVar.filePath;
            aVar.ksN.type = aVar.fuz;
            if (!aVar.ksU) {
                aVar.ksR.add(aVar.ksN);
            }
            return 0;
        }
    }
}
