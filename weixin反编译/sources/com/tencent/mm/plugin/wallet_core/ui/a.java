package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.bp.b;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.wallet.a.e;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class a {
    public f sXd = null;
    Map<String, q> sXe = null;
    Map<String, h> sXf = null;

    public static final class a {
        public String pgd;
        public h sXg;
        public double sXh;
        public String sXi;

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.sXg != null) {
                stringBuffer.append("|faovrComposeId: " + this.sXg.sJI);
            }
            stringBuffer.append("|bankName: " + this.pgd);
            stringBuffer.append("|bankFavorAmount: " + this.sXh);
            stringBuffer.append("|bankType: " + this.sXi);
            return stringBuffer.toString();
        }
    }

    public a(f fVar) {
        Assert.assertNotNull(fVar);
        this.sXd = fVar;
        Xc();
    }

    private void Xc() {
        int i = 0;
        this.sXe = new HashMap();
        List list = this.sXd.sJv;
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                q qVar = (q) list.get(i2);
                this.sXe.put(qVar.sJo, qVar);
            }
        } else {
            x.w("MicroMsg.FavorLogicHelper", "func[initData] favorList null");
        }
        this.sXf = new HashMap();
        if (this.sXd.sJw == null || this.sXd.sJw.sJG == null) {
            x.w("MicroMsg.FavorLogicHelper", "func[initData] favorComposeList null");
            return;
        }
        List list2 = this.sXd.sJw.sJG;
        while (i < list2.size()) {
            h hVar = (h) list2.get(i);
            this.sXf.put(hVar.sJI, hVar);
            i++;
        }
    }

    public final Map<String, a> NL(String str) {
        return aL(str, false);
    }

    public final h aK(String str, boolean z) {
        if (!"0".equals(str) && this.sXf.containsKey(str)) {
            return (h) this.sXf.get(str);
        }
        for (String str2 : this.sXf.keySet()) {
            h hVar = (h) this.sXf.get(str2);
            if (!(hVar.sJK == null || hVar.sJK.size() == 0)) {
                int i;
                int size = hVar.sJK.size();
                int i2 = 0;
                Iterator it = hVar.sJK.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    e eVar = (e) it.next();
                    if (!this.sXe.containsKey(eVar.sJo)) {
                        break;
                    }
                    q qVar = (q) this.sXe.get(eVar.sJo);
                    if (qVar.sKm.equals("") && qVar.sKo.size() == 0 && (!z || qVar.sKl == 0)) {
                        i++;
                    }
                    i2 = i;
                }
                if (i > 0 && i == size) {
                    return hVar;
                }
            }
        }
        return null;
    }

    public final Map<String, a> aL(String str, boolean z) {
        Map<String, a> hashMap = new HashMap();
        if (this.sXd.sJw != null && this.sXd.sJw.sJG != null) {
            double d;
            List list = this.sXd.sJw.sJG;
            if (this.sXf.containsKey(str)) {
                d = ((h) this.sXf.get(str)).sJJ;
            } else {
                d = 0.0d;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                h hVar = (h) list.get(i2);
                String str2 = null;
                if (str.equals("0") && !hVar.equals("0")) {
                    str2 = hVar.sJI;
                } else if (hVar.sJI.startsWith(str) && !str.equals(hVar.sJI)) {
                    str2 = hVar.sJI.replace(str + "-", "");
                }
                String[] NO = NO(str2);
                if (NO != null && NO.length > 0) {
                    q qVar = (q) this.sXe.get(NO[0]);
                    if (qVar != null) {
                        if ((qVar.sKl != 0 ? 1 : null) != null && !bi.oN(qVar.sKm) && qVar.sKo.size() <= 0 && (z || !qVar.sKm.equalsIgnoreCase("CFT"))) {
                            a aVar = (a) hashMap.get(qVar.sKm);
                            if (aVar == null || hVar.sJJ > aVar.sXg.sJJ) {
                                aVar = new a();
                                aVar.sXg = hVar;
                                aVar.pgd = qVar.pgd;
                                aVar.sXh = hVar.sJJ - d;
                                aVar.sXi = qVar.sKm;
                                hashMap.put(qVar.sKm, aVar);
                            }
                        }
                    }
                }
                i = i2 + 1;
            }
        } else {
            x.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
        }
        return hashMap;
    }

    public final List<q> NM(String str) {
        List<q> linkedList = new LinkedList();
        if (this.sXd.sJv != null) {
            Map NL = NL(str);
            for (int i = 0; i < this.sXd.sJv.size(); i++) {
                q qVar = (q) this.sXd.sJv.get(i);
                if (qVar != null) {
                    Object obj;
                    if (qVar.sKl != 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null && NL.containsKey(qVar.sKm)) {
                        linkedList.add(qVar);
                    }
                }
            }
        } else {
            x.w("MicroMsg.FavorLogicHelper", "fucn[getBankFavorListWithSelectedCompId] mFavorInfo.tradeFavList null");
        }
        return linkedList;
    }

    public final h NN(String str) {
        return (h) this.sXf.get(str);
    }

    public static String[] NO(String str) {
        if (bi.oN(str)) {
            return null;
        }
        return str.split("-");
    }

    public final String NP(String str) {
        return aM(str, false);
    }

    public final String aM(String str, boolean z) {
        String[] NO = NO(str);
        if (NO == null) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < NO.length; i++) {
            q qVar = (q) this.sXe.get(NO[i]);
            if (qVar != null) {
                Object obj;
                if (qVar.sKl != 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null || (bi.oN(qVar.sKm) && !z)) {
                    stringBuilder.append(NO[i]);
                    stringBuilder.append("-");
                }
            }
        }
        if (stringBuilder.length() == 0) {
            return "0";
        }
        return stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()).toString();
    }

    public final FavorPayInfo NQ(String str) {
        FavorPayInfo favorPayInfo = new FavorPayInfo();
        if (this.sXf.get(str) == null) {
            favorPayInfo.sTc = "0";
            if (this.sXd != null) {
                favorPayInfo.sTf = this.sXd.sJu;
            }
            favorPayInfo.sTd = 0;
            return favorPayInfo;
        }
        favorPayInfo.sTc = str;
        if (this.sXd != null) {
            favorPayInfo.sTf = this.sXd.sJu;
        }
        favorPayInfo.sTd = 0;
        String[] NO = NO(str);
        if (NO == null) {
            return favorPayInfo;
        }
        for (int length = NO.length - 1; length >= 0; length--) {
            q qVar = (q) this.sXe.get(NO[length]);
            if (qVar != null) {
                if ((qVar.sKl != 0 ? 1 : 0) == 0) {
                    break;
                }
                favorPayInfo.sTd = 1;
                if (qVar.sKo != null && qVar.sKo.size() > 0) {
                    favorPayInfo.sTh = new LinkedList();
                    Iterator it = qVar.sKo.iterator();
                    while (it.hasNext()) {
                        favorPayInfo.sTh.add(n.a((b) it.next()));
                    }
                }
                if (!bi.oN(qVar.sKm)) {
                    favorPayInfo.sTe = qVar.sKm;
                    break;
                }
            }
        }
        return favorPayInfo;
    }

    public static boolean a(FavorPayInfo favorPayInfo, Bankcard bankcard) {
        if (bankcard == null) {
            x.w("MicroMsg.FavorLogicHelper", "curBankcard null");
            return true;
        }
        if (!(favorPayInfo == null || bi.oN(favorPayInfo.sTc))) {
            boolean z;
            if (favorPayInfo.sTd != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z && !bi.oN(favorPayInfo.sTe) && favorPayInfo.sTh != null && favorPayInfo.sTh.contains(bankcard.field_bindSerial)) {
                return false;
            }
        }
        if (favorPayInfo.sTd != 0) {
            if (!bi.oN(favorPayInfo.sTe) && bankcard.field_bankcardType != null && !bankcard.field_bankcardType.equals(favorPayInfo.sTe)) {
                return true;
            }
            if (bi.oN(favorPayInfo.sTe) && bankcard.field_bankcardType.equals("CFT")) {
                return true;
            }
        }
        return false;
    }

    private static String cj(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return stringBuilder.toString();
            }
            stringBuilder.append(((String) list.get(i2)));
            if (i2 < list.size() - 1) {
                stringBuilder.append("-");
            }
            i = i2 + 1;
        }
    }

    public final String NR(String str) {
        int i;
        ArrayList jG = o.bMc().jG(true);
        Map hashMap = new HashMap();
        List arrayList = new ArrayList();
        for (i = 0; i < jG.size(); i++) {
            hashMap.put(((Bankcard) jG.get(i)).field_bankcardType, Integer.valueOf(0));
        }
        String[] NO = NO(str);
        if (NO != null) {
            for (Object obj : NO) {
                q qVar = (q) this.sXe.get(obj);
                if (qVar != null) {
                    boolean z;
                    if (qVar.sKl != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (hashMap.containsKey(qVar.sKm) || bi.oN(qVar.sKm)) {
                            arrayList.add(obj);
                        } else {
                        }
                    }
                }
                arrayList.add(obj);
            }
        }
        if (arrayList.size() == 0) {
            return "0";
        }
        return cj(arrayList);
    }

    public final List<q> bNa() {
        int i;
        ArrayList jG = o.bMc().jG(true);
        Map hashMap = new HashMap();
        for (i = 0; i < jG.size(); i++) {
            hashMap.put(((Bankcard) jG.get(i)).field_bankcardType, Integer.valueOf(0));
        }
        List<q> linkedList = new LinkedList();
        List list = this.sXd.sJv;
        if (list != null) {
            for (i = 0; i < list.size(); i++) {
                q qVar = (q) list.get(i);
                if (qVar != null) {
                    boolean z;
                    if (qVar.sKl != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (hashMap.containsKey(qVar.sKm) || bi.oN(qVar.sKm)) {
                            linkedList.add(qVar);
                        } else {
                        }
                    }
                }
                linkedList.add(qVar);
            }
        }
        return linkedList;
    }
}
