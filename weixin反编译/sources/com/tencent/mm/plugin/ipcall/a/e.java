package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.f.a.bc;
import com.tencent.mm.plugin.ipcall.a.g.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Map;

public final class e {
    private static e nId = null;
    c inf = new c<bc>() {
        {
            this.xmG = bc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            bc bcVar = (bc) bVar;
            if (bcVar.fqf.fqg == 39) {
                x.i("MicroMsg.IPCallFeedbackConfigUpdater", "checkResUpdateListener callback");
                byte[] e = com.tencent.mm.a.e.e(bcVar.fqf.filePath, 0, -1);
                if (e != null) {
                    e.this.aB(e);
                } else {
                    x.e("MicroMsg.IPCallFeedbackConfigUpdater", "checkResUpdateListener file not exist");
                }
            }
            return false;
        }
    };
    public ArrayList<f> nIe = null;

    private e() {
    }

    public static e aTX() {
        if (nId == null) {
            nId = new e();
        }
        return nId;
    }

    public final boolean aB(byte[] bArr) {
        try {
            try {
                Map y = bj.y(new String(bArr), "feedbackconfig");
                if (y != null) {
                    String str = ".feedbackconfig.resourceslist.resources";
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (true) {
                        String str2 = str + (i == 0 ? "" : Integer.valueOf(i));
                        String str3 = (String) y.get(str2 + ".$langid");
                        if (str3 != null) {
                            int i2 = i + 1;
                            f fVar = new f();
                            fVar.nMs = str3;
                            fVar.nMt = new ArrayList();
                            String str4 = str2 + ".string";
                            int i3 = 0;
                            while (true) {
                                com.tencent.mm.plugin.ipcall.a.g.e eVar = new com.tencent.mm.plugin.ipcall.a.g.e();
                                String str5 = str4 + (i3 == 0 ? "" : Integer.valueOf(i3));
                                str3 = (String) y.get(str5);
                                if (str3 == null) {
                                    break;
                                }
                                str5 = (String) y.get(str5 + ".$id");
                                if (str5 == null) {
                                    break;
                                }
                                i3++;
                                eVar.nMq = str5;
                                eVar.nMr = str3;
                                fVar.nMt.add(eVar);
                            }
                            x.d("MicroMsg.IPCallFeedbackConfigUpdater", "feedbackResource parse id:%s,wording count:%d", fVar.nMs, Integer.valueOf(fVar.nMt.size()));
                            arrayList.add(fVar);
                            i = i2;
                        } else {
                            x.i("MicroMsg.IPCallFeedbackConfigUpdater", "feedbackResource parse finished count:%d", Integer.valueOf(arrayList.size()));
                            this.nIe = arrayList;
                            return true;
                        }
                    }
                }
                x.e("MicroMsg.IPCallFeedbackConfigUpdater", "parse xml feedbackconfig error");
                return false;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.IPCallFeedbackConfigUpdater", e, "", new Object[0]);
                x.e("MicroMsg.IPCallFeedbackConfigUpdater", "parse ipcall feedback config error: %s", e.getMessage());
                return false;
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.IPCallFeedbackConfigUpdater", e2, "", new Object[0]);
            x.e("MicroMsg.IPCallFeedbackConfigUpdater", "parse ipcall feedback config new string error: %s", e2.getMessage());
            return false;
        }
    }
}
