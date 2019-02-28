package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.qqmail.b.p.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class j {
    List<a> gzt;
    long pum = 0;
    private e pun;
    a puo;
    private int pup = 0;
    int puq = 1;
    private int pur = 2;
    int pus = 3;
    int status = this.pup;

    public static abstract class a {
        public abstract void onComplete();
    }

    j(String str) {
        this.pun = new e(str, 1);
        byte[] readFromFile = e.readFromFile(this.pun.ptV + "address");
        if (readFromFile != null) {
            this.pun.a("address", null, readFromFile);
            b.deleteFile(this.pun.ptV + "address");
        } else {
            readFromFile = this.pun.k("address", null);
        }
        if (readFromFile != null) {
            try {
                this.puo = new a().aG(readFromFile);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Plugin.MailAddrMgr", e, "", new Object[0]);
                this.puo = new a();
                this.puo.Ij("");
            }
        } else {
            this.puo = new a();
            this.puo.Ij("");
        }
        this.gzt = new ArrayList();
    }

    protected final void finalize() {
        this.gzt.clear();
    }

    public final List<i> Io(String str) {
        List<i> list = this.puo.ptI;
        if (this.status <= this.puq) {
            bkP();
            return list;
        } else if (str == null || str.length() == 0) {
            return list;
        } else {
            List<i> arrayList = new ArrayList();
            for (i iVar : list) {
                if (iVar != null && ((iVar.name != null && iVar.name.contains(str)) || ((iVar.pul != null && iVar.pul.contains(str)) || (iVar.nWa != null && iVar.nWa.contains(str))))) {
                    a.b(iVar);
                    arrayList.add(iVar);
                }
            }
            return arrayList;
        }
    }

    public final void bkP() {
        if (this.status != this.pur) {
            if (bi.Wy() - this.pum <= 600000) {
                for (a onComplete : this.gzt) {
                    onComplete.onComplete();
                }
                return;
            }
            this.status = this.pur;
            Map hashMap = new HashMap();
            hashMap.put("syncinfo", this.puo.ptG == null ? "" : this.puo.ptG);
            x.d("MicroMsg.Plugin.MailAddrMgr", "%s", "sync~~~");
            w.bkZ().b("/cgi-bin/syncaddrlist", hashMap, new c(), new com.tencent.mm.plugin.qqmail.b.p.a() {
                public final void onSuccess(String str, Map<String, String> map) {
                    j jVar = j.this;
                    int i = bi.getInt((String) map.get(".Response.result.Count"), 0);
                    if (i > 0) {
                        int i2 = jVar.puo.ptI.size() == 0 ? 1 : 0;
                        int i3 = 0;
                        while (i3 < i) {
                            String str2 = ".Response.result.List.item" + (i3 > 0 ? String.valueOf(i3) : "") + ".";
                            String str3 = (String) map.get(str2 + "Del");
                            String str4 = (String) map.get(str2 + "Freq");
                            String str5 = (String) map.get(str2 + "Name");
                            str2 = (String) map.get(str2 + "Addr");
                            if (str2 != null && str2.length() != 0) {
                                if (str5 == null || str5.length() == 0) {
                                    str5 = str2;
                                }
                                int hashCode = str2.hashCode();
                                if (str3.equals("0")) {
                                    List list = jVar.puo.ptI;
                                    int i4 = 0;
                                    while (i2 == 0 && i4 < list.size() && ((i) list.get(i4)).puj != hashCode) {
                                        i4++;
                                    }
                                    if (i4 >= list.size() || i2 != 0) {
                                        i iVar = new i();
                                        iVar.puj = hashCode;
                                        iVar.name = str5;
                                        iVar.nWa = str2;
                                        iVar.puk = Integer.parseInt(str4);
                                        jVar.puo.a(iVar);
                                    }
                                } else {
                                    Iterator it = jVar.puo.ptI.iterator();
                                    int i5 = 0;
                                    while (it.hasNext()) {
                                        if (((i) it.next()).puj == hashCode) {
                                            jVar.puo.vq(i5);
                                            break;
                                        }
                                        i5++;
                                    }
                                }
                            }
                            i3++;
                        }
                        jVar.puo.Ij((String) map.get(".Response.result.SyncInfo"));
                        jVar.save();
                    }
                    if (((String) map.get(".Response.result.ContinueFlag")).equals("1")) {
                        new ag().postDelayed(new Runnable() {
                            public final void run() {
                                j.this.status = j.this.puq;
                                j.this.bkP();
                            }
                        }, 0);
                        return;
                    }
                    j.this.pum = bi.Wy();
                    for (a onComplete : j.this.gzt) {
                        onComplete.onComplete();
                    }
                }

                public final void onError(int i, String str) {
                    for (a onComplete : j.this.gzt) {
                        onComplete.onComplete();
                    }
                }

                public final void onComplete() {
                    j.this.status = j.this.pus;
                }
            });
        }
    }

    public final void a(a aVar) {
        for (a aVar2 : this.gzt) {
            if (aVar2 == aVar) {
                return;
            }
        }
        this.gzt.add(aVar);
    }

    public final void b(a aVar) {
        for (a aVar2 : this.gzt) {
            if (aVar2 == aVar) {
                this.gzt.remove(aVar2);
                return;
            }
        }
    }

    public final void br(List<i> list) {
        a aVar = this.puo;
        if (!(list == null || list.size() == 0)) {
            for (i iVar : list) {
                int i = 0;
                Iterator it = aVar.ptI.iterator();
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        break;
                    }
                    i iVar2 = (i) it.next();
                    if (iVar2.nWa.equalsIgnoreCase(iVar.nWa)) {
                        aVar.vq(i2);
                        iVar2.puk++;
                        aVar.a(iVar2);
                        break;
                    }
                    i = i2 + 1;
                }
            }
        }
        save();
    }

    final void save() {
        try {
            this.pun.a("address", null, this.puo.toByteArray());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Plugin.MailAddrMgr", e, "", new Object[0]);
        }
    }

    public static i Ip(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        int lastIndexOf = trim.trim().lastIndexOf(" ");
        if (lastIndexOf == -1) {
            return null;
        }
        i iVar = new i();
        iVar.name = trim.substring(0, lastIndexOf);
        iVar.nWa = trim.substring(lastIndexOf + 1);
        return iVar;
    }
}
