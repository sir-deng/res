package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.R;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.q.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bg;
import com.tencent.mm.y.c;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class e implements f {
    public static e pGj = new e();

    private e() {
    }

    public final void a(int i, Map<String, bx> map, boolean z) {
        x.i("MicroMsg.ReaderFuncMsgUpdateMgr", "onFunctionMsgUpdate, op: %s, msgIdMap.size: %s, needUpdateTime: %s", Integer.valueOf(i), Integer.valueOf(map.size()), Boolean.valueOf(z));
        for (String str : map.keySet()) {
            bx bxVar = (bx) map.get(str);
            List<bg> a = a(bxVar, str);
            if (a != null) {
                long j = ((long) bxVar.pgR) * 1000;
                if (!(a == null || a.size() == 0)) {
                    x.i("MicroMsg.ReaderFuncMsgUpdateMgr", "processInfoList, op: %s, infoList.size: %s", Integer.valueOf(i), Integer.valueOf(a.size()));
                    bg bgVar;
                    if (i == 1) {
                        for (bg bgVar2 : a) {
                            x.i("MicroMsg.ReaderFuncMsgUpdateMgr", "delete info, functionMsgId: %s", bgVar2.HT());
                            g.bmV().a(bgVar2.HT(), bgVar2.type, true, true);
                        }
                    } else if (i == 0) {
                        bg bgVar3 = null;
                        List H = g.bmV().H(str, ((bg) a.get(0)).type);
                        bg bgVar4 = null;
                        x.i("MicroMsg.ReaderFuncMsgUpdateMgr", "update info, functionMsgId: %s, oldInfoList: %s", str, H);
                        Object obj = null;
                        int i2 = 0;
                        int i3 = 0;
                        for (bg bgVar5 : a) {
                            if (bgVar3 == null) {
                                i3 = bgVar5.type;
                                bgVar5.hiU = 1;
                                bgVar3 = bgVar5;
                            }
                            if (H == null) {
                                x.i("MicroMsg.ReaderFuncMsgUpdateMgr", "update info, insert new msg, functionMsgId: %s", bgVar5.HT());
                                i2++;
                                g.bmV().a(bgVar5);
                            } else {
                                int i4;
                                Object obj2;
                                if (z) {
                                    bgVar5.time = j;
                                    if (bgVar3 != null) {
                                        bgVar3.time = j;
                                    }
                                    i4 = i2 + 1;
                                } else {
                                    if (bgVar4 == null) {
                                        bgVar2 = (bg) H.get(0);
                                        Iterator it = H.iterator();
                                        while (true) {
                                            bgVar4 = bgVar2;
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            bgVar2 = (bg) it.next();
                                            if (bgVar2.hiU != 1) {
                                                bgVar2 = bgVar4;
                                            }
                                        }
                                    }
                                    bgVar5.time = bgVar4.time;
                                    if (bgVar3 != null) {
                                        bgVar3.time = bgVar4.time;
                                    }
                                    i4 = i2;
                                }
                                x.i("MicroMsg.ReaderFuncMsgUpdateMgr", "update info, update the exist one, functionMsgId: %s, time: %s", bgVar5.HT(), Long.valueOf(bgVar5.time));
                                if (obj == null) {
                                    g.bmV().a(bgVar5.HT(), bgVar5.type, false, false);
                                    obj2 = 1;
                                } else {
                                    obj2 = obj;
                                }
                                g.bmV().a(bgVar5);
                                obj = obj2;
                                i2 = i4;
                            }
                        }
                        if (i2 > 0) {
                            as.Hm();
                            ae XF = c.Fk().XF(bg.gW(i3));
                            if (XF == null || !XF.field_username.equals(bg.gW(i3))) {
                                ae aeVar = new ae();
                                aeVar.setUsername(bg.gW(i3));
                                aeVar.setContent(bgVar3 == null ? "" : bgVar3.getTitle());
                                aeVar.aj(bgVar3 == null ? bi.Wy() : bgVar3.time);
                                aeVar.eS(0);
                                aeVar.eP(1);
                                as.Hm();
                                c.Fk().d(aeVar);
                            } else {
                                XF.aj(bgVar3.time);
                                XF.eS(0);
                                if (!(bi.oN(bgVar3.getTitle()) || bgVar3.getTitle().equals(XF.field_content)) || XF.field_unReadCount == 0) {
                                    XF.setContent(bgVar3.getTitle());
                                    XF.eP(XF.field_unReadCount + 1);
                                }
                                as.Hm();
                                c.Fk().a(XF, bg.gW(i3));
                            }
                        }
                        g.bmV().doNotify();
                    }
                }
            }
        }
    }

    private static List<bg> a(bx bxVar, String str) {
        String trim = n.a(bxVar.vNO).trim();
        if (trim.indexOf("<") != -1) {
            trim = trim.substring(trim.indexOf("<"));
        }
        long j = ((long) bxVar.pgR) * 1000;
        x.d("MicroMsg.ReaderFuncMsgUpdateMgr", "parseMsg, createTime: %s, content: %s", Integer.valueOf(bxVar.pgR), trim);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        List<bg> arrayList = new ArrayList();
        try {
            Map y = bj.y(trim, "mmreader");
            int i = 0;
            while (i <= 0) {
                String str2 = ".mmreader.category" + (i > 0 ? Integer.valueOf(i) : "");
                int i2 = bi.getInt((String) y.get(str2 + ".$type"), 0);
                if (i2 != 0) {
                    if (i2 != 20 && i2 != 11) {
                        x.e("MicroMsg.ReaderFuncMsgUpdateMgr", "get " + str2 + ".$type  error Type:" + i2);
                        break;
                    }
                    trim = (String) y.get(str2 + ".name");
                    if (bi.oN(trim)) {
                        x.e("MicroMsg.ReaderFuncMsgUpdateMgr", "get " + str2 + ".name  error");
                        break;
                    }
                    String str3 = (String) y.get(str2 + ".topnew.cover");
                    String str4 = (String) y.get(str2 + ".topnew.digest");
                    int i3 = bi.getInt((String) y.get(str2 + ".$count"), 0);
                    if (i3 == 0) {
                        x.e("MicroMsg.ReaderFuncMsgUpdateMgr", "get " + str2 + ".$count  error");
                        break;
                    }
                    if (i3 > 1) {
                        str2 = str2 + (i2 == 20 ? ".newitem" : ".item");
                    } else {
                        str2 = str2 + ".item";
                    }
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= i3) {
                            break;
                        }
                        String str5 = str2 + (i5 > 0 ? Integer.valueOf(i5) : "");
                        bg bgVar = new bg();
                        bgVar.aM((long) bxVar.vNL);
                        bgVar.title = (String) y.get(str5 + ".title");
                        if (i5 == 0) {
                            bgVar.hiU = 1;
                            bgVar.hfO = str3;
                            bgVar.hfQ = bi.oN(str4) ? (String) y.get(str5 + ".digest") : str4;
                        } else {
                            bgVar.hfO = (String) y.get(str5 + ".cover");
                            bgVar.hfQ = (String) y.get(str5 + ".digest");
                        }
                        bgVar.hiV = y.containsKey(new StringBuilder().append(str5).append(".vedio").toString()) ? 1 : 0;
                        bgVar.url = (String) y.get(str5 + ".url");
                        bgVar.hiP = (String) y.get(str5 + ".shorturl");
                        bgVar.hiQ = (String) y.get(str5 + ".longurl");
                        bgVar.hiR = bi.getLong((String) y.get(str5 + ".pub_time"), 0);
                        String str6 = (String) y.get(str5 + ".tweetid");
                        if (str6 == null || "".equals(str6)) {
                            str6 = "N" + simpleDateFormat.format(new Date(System.currentTimeMillis() + ((long) i5)));
                            x.d("MicroMsg.ReaderFuncMsgUpdateMgr", "create tweetID = " + str6);
                        }
                        bgVar.hiO = str6;
                        bgVar.hiS = (String) y.get(str5 + ".sources.source.name");
                        bgVar.hiT = (String) y.get(str5 + ".sources.source.icon");
                        bgVar.time = ((long) i) + j;
                        bgVar.type = i2;
                        bgVar.name = trim;
                        bgVar.hiX = str;
                        arrayList.add(bgVar);
                        String[] strArr = new Object[2];
                        strArr[0] = com.tencent.mm.pluginsdk.h.n.ak(ad.getContext().getString(R.l.eiJ), bgVar.hiR);
                        strArr[1] = com.tencent.mm.pluginsdk.h.n.c(ad.getContext(), bgVar.time, false);
                        x.d("MicroMsg.ReaderFuncMsgUpdateMgr", "parse info, pubtime: %s, time: %s", strArr);
                        i4 = i5 + 1;
                    }
                    i++;
                } else {
                    x.e("MicroMsg.ReaderFuncMsgUpdateMgr", "get " + str2 + ".$type  error");
                    break;
                }
            }
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ReaderFuncMsgUpdateMgr", e, "", new Object[0]);
            x.e("MicroMsg.ReaderFuncMsgUpdateMgr", "parseMsg error: %s", e.getMessage());
            return null;
        }
    }
}
