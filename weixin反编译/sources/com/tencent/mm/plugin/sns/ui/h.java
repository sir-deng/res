package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.protocal.c.ajv;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.ci;
import com.tencent.mm.protocal.c.dt;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class h extends e<are> {
    private List<are> list = new ArrayList();
    private String nWh = "";
    private String path = "";
    private dt rwL;
    private ci rwM;
    private a rwN;
    private int rwu = 0;
    private int rwv = 0;

    public interface a {
        void a(List<are> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, int i, int i2, dt dtVar);

        void bzE();
    }

    public h(a aVar) {
        this.rwN = aVar;
    }

    public final void bV(List<are> list) {
        if (this.rwN == null) {
            return;
        }
        if (list != null) {
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap();
            hashMap.clear();
            hashMap2.clear();
            int size = list.size();
            x.d("MicroMsg.ArtistAdapterHelper", "initFixType " + size);
            int i = 0;
            int i2 = 0;
            int i3;
            for (int i4 = 0; i4 < size; i4 = i3 + i4) {
                String str = ((are) list.get(i4)).nkL;
                i3 = i4 + 1 < size ? !str.equals(((are) list.get(i4 + 1)).nkL) ? 1 : i4 + 2 < size ? !str.equals(((are) list.get(i4 + 2)).nkL) ? 2 : 3 : 2 : 1;
                hashMap.put(Integer.valueOf(i), Integer.valueOf(i2));
                hashMap2.put(Integer.valueOf(i), Integer.valueOf(i3));
                i2 += i3;
                i++;
            }
            this.rwu = i + 1;
            this.rwv = list.size();
            x.d("MicroMsg.ArtistAdapterHelper", "icount " + this.rwu);
            this.list = list;
            this.rwN.a(this.list, hashMap, hashMap2, this.rwv, this.rwu, this.rwL);
            return;
        }
        this.rwN.bzE();
    }

    public final List<are> bzD() {
        List<are> arrayList = new ArrayList();
        try {
            arrayList.clear();
            this.rwM = null;
            String str = this.path + this.nWh + "_ARTISTF.mm";
            if (FileOp.bO(str)) {
                this.rwM = (ci) new ci().aH(FileOp.d(str, 0, -1));
            }
            if (this.rwM == null) {
                String str2 = this.path + this.nWh + "_ARTIST.mm";
                this.rwM = com.tencent.mm.plugin.sns.g.a.Lv(new String(FileOp.d(str2, 0, (int) FileOp.mi(str2))));
                if (this.rwM == null) {
                    FileOp.deleteFile(str2);
                    return null;
                }
                FileOp.deleteFile(str);
                FileOp.j(str, this.rwM.toByteArray());
            }
            if (this.rwM == null) {
                return null;
            }
            Iterator it = this.rwM.vOp.iterator();
            while (it.hasNext()) {
                ajv ajv = (ajv) it.next();
                String str3 = ajv.nkW;
                Iterator it2 = ajv.wfh.iterator();
                while (it2.hasNext()) {
                    are are = (are) it2.next();
                    are.nkL = str3;
                    arrayList.add(are);
                }
            }
            this.rwL = this.rwM.vOo;
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ArtistAdapterHelper", e, "loadData failed.", new Object[0]);
            return null;
        }
    }

    public final void ev(String str, String str2) {
        this.nWh = str;
        this.path = str2;
        fG(true);
    }
}
