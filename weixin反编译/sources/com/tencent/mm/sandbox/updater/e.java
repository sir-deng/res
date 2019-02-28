package com.tencent.mm.sandbox.updater;

import com.tencent.mm.c.i;
import com.tencent.mm.c.i.a;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.protocal.c.bpf;
import com.tencent.mm.protocal.c.bpg;
import com.tencent.mm.protocal.c.bph;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class e {
    public final int fileSize;
    public final Integer nGR;
    public HashMap<Integer, LinkedList<atf>> nGS = new HashMap();
    public final Integer nGT;
    public final Integer nGU;
    public final String nGV;
    public final String nGW;
    public final String nGX;
    public String nGY;
    public String nGZ;
    public int versionCode;

    public e(bph bph) {
        if (bph == null) {
            this.nGR = Integer.valueOf(1);
            this.nGV = "";
            this.nGW = "";
            this.nGT = Integer.valueOf(-1);
            this.nGU = Integer.valueOf(-1);
            this.nGX = "";
            this.fileSize = 0;
            this.nGY = "";
            this.nGZ = "";
            this.versionCode = 0;
            return;
        }
        if (bph.wYB != null) {
            this.nGW = bph.wYB.wgY;
            this.nGV = bph.wYB.nlE;
            this.fileSize = bph.wYB.wfl;
        } else {
            this.nGW = "";
            this.nGV = "";
            this.fileSize = 0;
        }
        this.nGR = Integer.valueOf(bph.state);
        this.nGU = Integer.valueOf(bph.wYA);
        if (!(bph.wYy == null || bph.wYy.isEmpty())) {
            int size = bph.wYy.size();
            for (int i = 0; i < size; i++) {
                bpg bpg = (bpg) bph.wYy.get(i);
                if (!(bpg.wYx == null || bpg.wYx.isEmpty())) {
                    this.nGS.put(Integer.valueOf(bpg.type), bpg.wYx);
                }
            }
        }
        this.nGT = Integer.valueOf(bph.wYz);
        this.nGX = bph.wdx;
        if (bph.wYD == null || bph.wYD.isEmpty()) {
            this.nGY = "";
            this.nGZ = "";
            this.versionCode = 0;
            return;
        }
        Iterator it = bph.wYD.iterator();
        while (it.hasNext()) {
            bpf bpf = (bpf) it.next();
            if (!(bpf == null || bi.oN(bpf.aAM))) {
                if (bpf.aAM.equalsIgnoreCase("newApkMd5")) {
                    this.nGY = bpf.value;
                } else if (bpf.aAM.equalsIgnoreCase("oldApkMd5")) {
                    this.nGZ = bpf.value;
                } else if (bpf.aAM.equalsIgnoreCase(DownloadInfoColumns.VERSIONCODE)) {
                    this.versionCode = bi.Wo(bpf.value);
                }
            }
        }
    }

    public final String cfe() {
        String substring = this.nGV.substring(0, this.nGV.lastIndexOf(47) + 1);
        String substring2 = this.nGV.substring(this.nGV.lastIndexOf(47) + 1);
        i iVar = new i(substring, Integer.valueOf(this.versionCode).intValue());
        iVar.a(new a(this.nGZ, this.nGY, this.nGW, substring2, this.fileSize));
        return iVar.ts();
    }

    public final String toString() {
        return "responseState:" + this.nGR + "\ncdnUrl:" + this.nGV + "\nfileMd5:" + this.nGW + "\npackageType:" + this.nGT + "\nnetworkType:" + this.nGU + "\npatchId:" + this.nGX;
    }
}
