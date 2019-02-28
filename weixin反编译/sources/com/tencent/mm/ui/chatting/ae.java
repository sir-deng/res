package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.f.a.iy;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.x.g;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.m;
import com.tencent.mm.y.q;
import com.tencent.mm.y.r;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class ae {
    private Context context;
    private x fBc = null;
    private SimpleDateFormat ksc = new SimpleDateFormat("yyyy-MM-dd");
    String mTH = null;
    List<au> yAp;
    private String yFX = null;
    ArrayList<Uri> yFY = new ArrayList();

    public ae(Context context, List<au> list, x xVar) {
        this.context = context;
        this.yAp = list;
        this.fBc = xVar;
    }

    public final String ctQ() {
        String str = "MicroMsg.OtherMailHistoryExporter";
        String str2 = "export: history is null? %B, selectItems.size = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.mTH == null);
        objArr[1] = Integer.valueOf(this.yAp.size());
        com.tencent.mm.sdk.platformtools.x.d(str, str2, objArr);
        if (this.mTH != null) {
            return this.mTH;
        }
        this.yFY.clear();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ctR());
        stringBuilder.append("\n\n");
        for (au auVar : this.yAp) {
            if (this.yFX == null) {
                this.yFX = gb(auVar.field_createTime);
                stringBuilder.append(String.format("—————  %s  —————\n\n", new Object[]{this.yFX}));
                stringBuilder.append("\n");
            } else {
                str = gb(auVar.field_createTime);
                if (!str.equals(this.yFX)) {
                    this.yFX = str;
                    stringBuilder.append(String.format("—————  %s  —————\n\n", new Object[]{this.yFX}));
                    stringBuilder.append("\n");
                }
            }
            String str3;
            if (auVar.cjV()) {
                if (!auVar.cjV()) {
                    str3 = null;
                } else if (auVar.field_isSend == 1) {
                    str3 = String.format("%s\n\n%s\n\n", new Object[]{aC(auVar), auVar.field_content});
                } else if (this.fBc.field_username.endsWith("@chatroom")) {
                    str3 = bb.hR(auVar.field_content) != -1 ? String.format("%s\n\n%s\n\n", new Object[]{aC(auVar), auVar.field_content.substring(bb.hR(auVar.field_content) + 1).trim()}) : null;
                } else {
                    str3 = String.format("%s\n\n%s\n\n", new Object[]{aC(auVar), auVar.field_content});
                }
                stringBuilder.append(str3);
            } else if (auVar.cjT()) {
                if (auVar.cjT()) {
                    long j = auVar.field_msgId;
                    long j2 = auVar.field_msgSvrId;
                    str = ab.fZ(j);
                    if (bi.oN(str)) {
                        str = ab.ga(j2);
                    }
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.OtherMailHistoryExporter", "hdPath[%s]", str);
                    if (!bi.oN(str)) {
                        this.yFY.add(Uri.parse("file://" + str));
                        str = String.format("[%s: %s(%s)]", new Object[]{this.context.getString(R.l.dZB), new File(str).getName(), this.context.getString(R.l.dZx)});
                        str3 = String.format("%s\n\n%s\n\n", new Object[]{aC(auVar), str});
                        stringBuilder.append(str3);
                    }
                }
                str3 = null;
                stringBuilder.append(str3);
            } else {
                if (auVar.cjL()) {
                    str = String.format("[%s]", new Object[]{this.context.getString(R.l.dZG)});
                } else if (auVar.cjP()) {
                    str = auVar.field_isSend == 1 ? this.context.getString(R.l.dZE) : this.context.getString(R.l.dZD);
                } else if (auVar.aNL()) {
                    b iyVar = new iy();
                    iyVar.fAs.fAm = 1;
                    iyVar.fAs.fou = auVar;
                    a.xmy.m(iyVar);
                    str = String.format("[%s]", new Object[]{iyVar.fAt.fxq});
                } else {
                    if (auVar.aNJ()) {
                        g.a fV = g.a.fV(bi.Wn(auVar.field_content));
                        if (fV != null) {
                            switch (fV.type) {
                                case 4:
                                case 6:
                                    com.tencent.mm.pluginsdk.model.app.b Se = an.aqK().Se(fV.for);
                                    if (Se != null) {
                                        File file = new File(Se.field_fileFullPath);
                                        if (file.exists()) {
                                            this.yFY.add(Uri.fromFile(file));
                                            break;
                                        }
                                    }
                                    break;
                            }
                            f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fV.appId, true);
                            if (aZ == null) {
                                str = "";
                            } else {
                                String str4 = aZ.field_appName;
                                str = 6 == fV.type ? String.format("[%s: %s(%s)]", new Object[]{this.context.getString(R.l.dZw), str4, this.context.getString(R.l.dZx)}) : String.format("[%s: %s]", new Object[]{this.context.getString(R.l.dZw), str4});
                            }
                        }
                    } else if (auVar.cjU()) {
                        as.Hm();
                        str = c.Fh().Fq(auVar.field_content).fqG;
                        str = String.format("[%s: %s]", new Object[]{this.context.getString(R.l.dZy), str});
                    } else if (auVar.cjW()) {
                        r7 = new Object[3];
                        o.Ub();
                        r7[1] = new File(s.nx(auVar.field_imgPath)).getName();
                        r7[2] = this.context.getString(R.l.dZx);
                        str = String.format("[%s: %s(%s)]", r7);
                        o.Ub();
                        File file2 = new File(s.nx(auVar.field_imgPath));
                        if (file2.exists()) {
                            this.yFY.add(Uri.fromFile(file2));
                        }
                    } else if (auVar.cjY() || auVar.cjZ()) {
                        str = String.format("[%s]", new Object[]{this.context.getString(R.l.dZz)});
                    }
                    str = null;
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.OtherMailHistoryExporter", "formatOtherMsg, msgStr = %s", str);
                stringBuilder.append(String.format("%s\n\n%s\n\n", new Object[]{aC(auVar), str}));
            }
        }
        stringBuilder.append("\n\n");
        this.mTH = stringBuilder.toString();
        return this.mTH;
    }

    private String ctR() {
        String str;
        if (this.fBc.field_username.endsWith("@chatroom")) {
            if (bi.oN(this.fBc.field_nickname)) {
                String str2;
                str = "";
                Iterator it = m.gl(this.fBc.field_username).iterator();
                while (true) {
                    str2 = str;
                    if (!it.hasNext()) {
                        break;
                    }
                    str = str2 + r.gw((String) it.next()) + ", ";
                }
                str = str2.substring(0, str2.length() - 2);
            } else {
                str = this.fBc.AW();
            }
            return String.format(this.context.getString(R.l.eKd), new Object[]{str});
        }
        str = this.context.getString(R.l.eKe);
        Object[] objArr = new Object[2];
        objArr[0] = this.fBc.AW();
        as.Hm();
        objArr[1] = c.Db().get(4, null);
        return String.format(str, objArr);
    }

    private String aC(au auVar) {
        String str;
        String str2 = null;
        if (this.fBc.field_username.endsWith("@chatroom")) {
            str = auVar.field_content;
            int hR = bb.hR(str);
            if (hR != -1) {
                str2 = r.gw(str.substring(0, hR).trim());
            }
        } else {
            str2 = r.gw(auVar.field_talker);
        }
        if (auVar.field_isSend == 1) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.OtherMailHistoryExporter", "isSend");
            str2 = q.Ga();
        }
        str = new SimpleDateFormat("HH:mm").format(new Date(auVar.field_createTime));
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(str2);
        stringBuilder.append("  ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private String gb(long j) {
        return this.ksc.format(new Date(j));
    }
}
