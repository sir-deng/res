package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.wenote.b.c;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f {
    public static String ah(float f) {
        if (f < 1024.0f) {
            return String.format("%.1fB", new Object[]{Float.valueOf(f)});
        } else if (f < 1048576.0f) {
            return String.format("%.1fKB", new Object[]{Float.valueOf(f / 1024.0f)});
        } else if (f < 1.07374182E9f) {
            return String.format("%.1fMB", new Object[]{Float.valueOf((f / 1024.0f) / 1024.0f)});
        } else {
            return String.format("%.1fGB", new Object[]{Float.valueOf(((f / 1024.0f) / 1024.0f) / 1024.0f)});
        }
    }

    public static float bw(long j) {
        float f = 1.0f;
        float f2 = ((float) j) / 1000.0f;
        if (f2 >= 1.0f) {
            f = f2;
        }
        return ((float) Math.round(f * 10.0f)) / 10.0f;
    }

    public static String s(Context context, int i) {
        b fwVar = new fw();
        fwVar.fwl.type = 21;
        fwVar.fwl.context = context;
        fwVar.fwl.fwt = i;
        a.xmy.m(fwVar);
        return fwVar.fwm.path;
    }

    public static String Rn(String str) {
        return g.s((str + 18 + System.currentTimeMillis()).getBytes());
    }

    public static String i(uz uzVar) {
        b fwVar = new fw();
        fwVar.fwl.type = 27;
        fwVar.fwl.fwn = uzVar;
        a.xmy.m(fwVar);
        return fwVar.fwm.fwx;
    }

    public static String o(uz uzVar) {
        b fwVar = new fw();
        fwVar.fwl.type = 27;
        fwVar.fwl.fwn = uzVar;
        a.xmy.m(fwVar);
        return fwVar.fwm.path;
    }

    public static com.tencent.mm.plugin.fav.a.f eb(long j) {
        return ((r) com.tencent.mm.kernel.g.k(r.class)).getFavItemInfoStorage().dc(j);
    }

    public static void s(long j, String str) {
        if (j > 0) {
            b fwVar = new fw();
            fwVar.fwl.type = 34;
            fwVar.fwl.frf = j;
            a.xmy.m(fwVar);
            if (fwVar.fwl.frm != null && fwVar.fwl.frm.wlY != null && fwVar.fwl.frm.wlY.size() > 1 && ((uz) fwVar.fwl.frm.wlY.get(0)).wkP == null) {
                x.i("MicroMsg.WNNoteFavLogic", "Note: Htmlid is null,  do updateFavItemHtmlIdStorage");
                if (!bi.oN(str) && e.bO(str)) {
                    try {
                        CharSequence RE = c.RE(str);
                        vn vnVar = fwVar.fwl.frm;
                        ArrayList arrayList = new ArrayList();
                        if (!bi.oN(RE) && RE.length() != 0) {
                            int indexOf;
                            Matcher matcher = Pattern.compile("<object[^>]*>", 2).matcher(RE);
                            String str2 = "WeNote_";
                            while (matcher.find()) {
                                String group = matcher.group();
                                int indexOf2 = group.indexOf(str2);
                                if (indexOf2 != -1) {
                                    int indexOf3 = group.indexOf("\"", indexOf2 + 1);
                                    if (indexOf3 != -1) {
                                        indexOf = group.indexOf(" ", indexOf2 + 1);
                                        if (indexOf != -1) {
                                            if (indexOf3 >= indexOf) {
                                                indexOf3 = indexOf;
                                            }
                                            arrayList.add(group.substring(indexOf2, indexOf3));
                                        }
                                    }
                                }
                            }
                            LinkedList linkedList = new LinkedList();
                            Iterator it = vnVar.wlY.iterator();
                            indexOf = 0;
                            int i = 0;
                            while (it.hasNext()) {
                                uz uzVar = (uz) it.next();
                                int i2;
                                if (i == 0) {
                                    uzVar.Us("WeNoteHtmlFile");
                                    i2 = i + 1;
                                    linkedList.add(uzVar);
                                    i = i2;
                                } else {
                                    if (uzVar.bjS == 1) {
                                        uzVar.Us("-1");
                                    } else {
                                        i2 = indexOf + 1;
                                        uzVar.Us((String) arrayList.get(indexOf));
                                        indexOf = i2;
                                    }
                                    linkedList.add(uzVar);
                                }
                            }
                            b fwVar2 = new fw();
                            fwVar2.fwl.type = 33;
                            fwVar2.fwl.frm = vnVar;
                            fwVar2.fwl.frm.wlY = linkedList;
                            fwVar2.fwl.frf = j;
                            a.xmy.m(fwVar2);
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.WNNoteFavLogic", "Note: FileNotFoundException :%s", e.getMessage());
                    }
                }
            }
        }
    }

    public static void Z(ArrayList<String> arrayList) {
        int i = 0;
        if (c.bWA().tWL == null) {
            x.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, getWnNoteBase() is null");
            return;
        }
        vn vnVar = c.bWA().tWL.tWX;
        List arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        if (vnVar == null) {
            x.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, protoItem is null");
            return;
        }
        uz uzVar;
        Iterator it = vnVar.wlY.iterator();
        while (it.hasNext()) {
            uzVar = (uz) it.next();
            if (!(bi.oN(uzVar.wkP) || uzVar.wkP.contains("WeNoteHtmlFile") || uzVar.wkP.contains("-1"))) {
                arrayList2.add(uzVar.wkP);
                hashMap.put(uzVar.wkP, uzVar);
            }
        }
        if (arrayList.size() == arrayList2.size() && arrayList2.containsAll(arrayList) && arrayList.containsAll(arrayList2)) {
            int i2;
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                if (!((String) arrayList2.get(i3)).trim().equals(((String) arrayList.get(i3)).trim())) {
                    i2 = 1;
                    break;
                }
            }
            i2 = 0;
            if (i2 != 0) {
                LinkedList linkedList = new LinkedList();
                while (i < arrayList.size()) {
                    linkedList.add(hashMap.get(arrayList.get(i)));
                    i++;
                }
                vnVar.aw(linkedList);
                bWC();
                hashMap.clear();
                return;
            }
            return;
        }
        arrayList2.removeAll(arrayList);
        if (arrayList2.size() != 0) {
            List<uz> arrayList3 = new ArrayList();
            Iterator it2 = vnVar.wlY.iterator();
            while (it2.hasNext()) {
                uzVar = (uz) it2.next();
                if (arrayList2.contains(uzVar.wkP)) {
                    arrayList3.add(uzVar);
                }
            }
            for (uz uzVar2 : arrayList3) {
                vnVar.wlY.remove(uzVar2);
            }
            bWC();
        }
    }

    private static void bWC() {
        b fwVar = new fw();
        fwVar.fwl.type = 30;
        if (c.bWA().tWL != null) {
            fwVar.fwl.frm = c.bWA().tWL.tWX;
            a.xmy.m(fwVar);
            c.bWA().tWL.Rl(fwVar.fwm.path);
        }
    }
}
