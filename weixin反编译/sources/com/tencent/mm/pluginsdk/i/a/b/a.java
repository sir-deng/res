package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.pluginsdk.i.a.d.f.b;
import com.tencent.mm.pluginsdk.i.a.d.q;
import com.tencent.mm.sdk.platformtools.bi;

public final class a implements b {
    final String filePath;
    final int fqg;
    final int fqh;
    final int fqi;
    final boolean fqj;
    final String url;
    final String vmK;
    final boolean vmL;
    final boolean vmM;
    final String vmN;
    final int vmO;
    final byte[] vmP;
    final String vmQ;
    final boolean vmR;
    final long vmS;
    final String vmT;
    final int vmU;
    final int vmV;

    private a(String str, int i, int i2, int i3, boolean z, String str2, boolean z2, boolean z3, String str3, int i4, byte[] bArr, String str4, boolean z4, long j, String str5, String str6, int i5, int i6) {
        this.vmK = str;
        this.fqg = i;
        this.fqh = i2;
        this.fqi = i3;
        this.fqj = z;
        this.filePath = str2;
        this.vmL = z2;
        this.vmM = z3;
        this.vmN = str3;
        this.vmO = i4;
        this.vmP = bArr;
        this.vmQ = str4;
        this.vmR = z4;
        this.vmS = j;
        this.vmT = str5;
        this.url = str6;
        this.vmU = i5;
        this.vmV = i6;
    }

    public final String bZW() {
        return this.vmK;
    }

    public static a a(q qVar) {
        return new a(qVar.field_urlKey, qVar.field_resType, qVar.field_subType, bi.getInt(qVar.field_fileVersion, 0), qVar.field_fileUpdated, qVar.field_filePath, qVar.field_fileEncrypt, qVar.field_fileCompress, qVar.field_encryptKey, qVar.field_keyVersion, qVar.field_eccSignature, qVar.field_originalMd5, bi.oM(qVar.field_groupId2).equals("NewXml"), qVar.field_reportId, qVar.field_sampleId, qVar.field_url, qVar.field_maxRetryTimes, qVar.field_retryTimes);
    }
}
