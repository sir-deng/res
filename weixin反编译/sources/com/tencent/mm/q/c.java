package com.tencent.mm.q;

import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.q.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class c {
    volatile boolean gLu = false;
    private volatile boolean gLv = false;
    public List<Map<String, String>> gLw = new CopyOnWriteArrayList();

    public final synchronized boolean Bj() {
        boolean z;
        if (this.gLw.size() <= 0) {
            x.i("MicroMsg.FunctionMsgFetcher", "processNextNewXml, all process finished");
            z = false;
        } else if (this.gLv) {
            x.i("MicroMsg.FunctionMsgFetcher", "processNextNewXml, processing new xml");
            z = false;
        } else {
            this.gLv = true;
            Map map = (Map) this.gLw.remove(0);
            String str = (String) map.get(".sysmsg.functionmsg.cgi");
            int i = bi.getInt((String) map.get(".sysmsg.functionmsg.cmdid"), 0);
            String str2 = (String) map.get(".sysmsg.functionmsg.functionmsgid");
            long j = bi.getLong((String) map.get(".sysmsg.functionmsg.version"), 0);
            int i2 = bi.getInt((String) map.get(".sysmsg.functionmsg.op"), 0);
            String str3 = (String) map.get(".sysmsg.functionmsg.custombuff");
            x.d("MicroMsg.FunctionMsgFetcher", "processNextNewXml, cgi: %s, cmdId: %s, functionMsgId: %s, version: %s, op: %s, retryInterval: %s, reportId: %s, successKey: %s, failKey: %s, finalKey: %s, customBuff: %s", str, Integer.valueOf(i), str2, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(bi.getInt((String) map.get(".sysmsg.functionmsg.retryinterval"), 0)), Integer.valueOf(bi.getInt((String) map.get(".sysmsg.functionmsg.reportid"), 0)), Integer.valueOf(bi.getInt((String) map.get(".sysmsg.functionmsg.successkey"), 0)), Integer.valueOf(bi.getInt((String) map.get(".sysmsg.functionmsg.failkey"), 0)), Integer.valueOf(bi.getInt((String) map.get(".sysmsg.functionmsg.finalfailkey"), 0)), str3);
            com.tencent.mm.sdk.e.c dVar = new d();
            if (!bi.oN(str)) {
                dVar.field_cgi = str;
            }
            dVar.field_cmdid = i;
            if (!bi.oN(str2)) {
                dVar.field_functionmsgid = str2;
            }
            dVar.field_version = j;
            dVar.field_retryinterval = r10;
            dVar.field_reportid = r11;
            dVar.field_successkey = r12;
            dVar.field_failkey = r13;
            dVar.field_finalfailkey = r14;
            if (!bi.oN(str3)) {
                dVar.field_custombuff = str3;
            }
            dVar.field_status = -1;
            dVar.b(null);
            int intValue = Integer.valueOf((String) map.get("FUNCTION_MSG_ADD_MSG_CREATE_TIME_KEY")).intValue();
            com.tencent.mm.sdk.e.c fe = i.Bs().fe(dVar.field_functionmsgid);
            if (fe != null) {
                x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgItem.status: %s, version: %s, preVersion: %s", Integer.valueOf(fe.field_status), Long.valueOf(fe.field_version), Long.valueOf(fe.field_preVersion));
            }
            x.d("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgItem: %s", fe);
            String str4;
            Object[] objArr;
            if (i2 == 0) {
                dVar.field_needShow = true;
                if (fe == null) {
                    x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update, insert a new one", dVar.field_functionmsgid);
                    i.Bs().b(dVar);
                } else if (fe.field_version < dVar.field_version) {
                    x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update, update the exist one", dVar.field_functionmsgid);
                    fe.field_preVersion = fe.field_version;
                    dVar.field_preVersion = fe.field_version;
                    i.Bs().a(fe.field_functionmsgid, dVar);
                }
                Bl();
            } else if (i2 == 1) {
                x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, op delete");
                if (fe != null) {
                    x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op delete, newFunctionMsgItem.version: %s, functionMsgItem.version: %s", fe.field_functionmsgid, Long.valueOf(dVar.field_version), Long.valueOf(fe.field_version));
                    if (dVar.field_version == fe.field_version || dVar.field_version == 0) {
                        if (fe != null) {
                            try {
                                bx a = a(fe.field_addMsg);
                                str3 = "MicroMsg.FunctionMsgFetcher";
                                str4 = "callbackToDelete, msgContent==null: %s";
                                objArr = new Object[1];
                                objArr[0] = Boolean.valueOf(a == null);
                                x.d(str3, str4, objArr);
                                if (a != null) {
                                    Map singletonMap = Collections.singletonMap(fe.field_functionmsgid, fe.field_addMsg);
                                    List<f> list = (List) i.Br().gLL.get(Integer.valueOf(a.nlX));
                                    if (list != null) {
                                        for (f a2 : list) {
                                            a2.a(1, singletonMap, false);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                x.e("MicroMsg.FunctionMsgFetcher", "callbackToDelete error: %s", e.getMessage());
                            }
                        }
                        i.Bs().a(fe, new String[0]);
                    }
                } else {
                    x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op delete, the origin one not exist", dVar.field_functionmsgid);
                }
                Bm();
            } else if (i2 == 2) {
                dVar.field_needShow = false;
                if (fe == null) {
                    x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update but no show, insert a new one", dVar.field_functionmsgid);
                    i.Bs().b(dVar);
                } else if (fe.field_version < dVar.field_version) {
                    x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update but no show, update the exist one, preVersion: %s", dVar.field_functionmsgid, Long.valueOf(fe.field_preVersion));
                    fe.field_preVersion = fe.field_version;
                    dVar.field_preVersion = fe.field_version;
                    i.Bs().a(fe.field_functionmsgid, dVar);
                }
                Bl();
            } else {
                if (i2 == 3) {
                    x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op show, functionMsgItem: %s", dVar.field_functionmsgid, fe);
                    dVar.field_needShow = true;
                    if (fe != null) {
                        str3 = "MicroMsg.FunctionMsgFetcher";
                        str4 = "fetchInternal, op show, newFunctionMsgItem.version: %s, functionMsgItem.version: %s, functionMsgItem.msgContent == null: %s";
                        objArr = new Object[3];
                        objArr[0] = Long.valueOf(dVar.field_version);
                        objArr[1] = Long.valueOf(fe.field_version);
                        objArr[2] = Boolean.valueOf(fe.field_addMsg == null);
                        x.i(str3, str4, objArr);
                        if (fe.field_version >= dVar.field_version || dVar.field_version == 0) {
                            fe.field_needShow = true;
                            if (fe.field_addMsg != null) {
                                x.i("MicroMsg.FunctionMsgFetcher", "show, update create time to: %s", Integer.valueOf(intValue));
                                fe.field_addMsg.pgR = intValue;
                            }
                            i.Bs().a(fe.field_functionmsgid, fe);
                            if (fe.field_addMsg != null) {
                                b(Collections.singletonList(fe), true);
                            }
                        }
                    }
                }
                Bm();
            }
            z = true;
        }
        return z;
    }

    private static bx a(bx bxVar) {
        boolean z = true;
        if (bxVar == null) {
            return null;
        }
        String str = "MicroMsg.FunctionMsgFetcher";
        String str2 = "processAddMsg, fromUser: %s, msgType: %s, content==null: %s";
        Object[] objArr = new Object[3];
        objArr[0] = bxVar.vNM;
        objArr[1] = Integer.valueOf(bxVar.nlX);
        if (bxVar.vNO != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        String oM = bi.oM(n.a(bxVar.vNM));
        if ("readerapp".equals(oM)) {
            bxVar.vNM = n.oK("newsapp");
            bxVar.nlX = 12399999;
        }
        if (!"blogapp".equals(oM) && !"newsapp".equals(oM)) {
            return bxVar;
        }
        bxVar.nlX = 12399999;
        return bxVar;
    }

    public final synchronized boolean Bk() {
        return this.gLu;
    }

    public final synchronized void Bl() {
        if (this.gLu) {
            x.k("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed, isFetching, ignore this", new Object[0]);
            Bm();
        } else if (ao.isNetworkConnected(ad.getContext())) {
            this.gLu = true;
            List Bn = i.Bs().Bn();
            x.d("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed, fetchItems: %s", Bn);
            if (Bn == null || Bn.size() <= 0) {
                this.gLu = false;
                Bm();
            } else {
                x.i("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed, fetchItem.size: %s", Integer.valueOf(Bn.size()));
                new b(Bn, new a() {
                    public final void z(List<d> list) {
                        c.this.gLu = false;
                        if (list != null) {
                            x.i("MicroMsg.FunctionMsgFetcher", "onFetchFinish, fetchSuccessList.size: %s", list);
                            c.b(list, false);
                        }
                        c.this.Bm();
                    }
                }).start();
            }
        } else {
            x.k("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed network not connected, ignore this", new Object[0]);
            Bm();
        }
    }

    final void Bm() {
        x.k("MicroMsg.FunctionMsgFetcher", "loopToNextNewXml", new Object[0]);
        this.gLv = false;
        Bj();
    }

    static void b(List<d> list, boolean z) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    Collection arrayList = new ArrayList();
                    for (d dVar : list) {
                        if (dVar.field_needShow) {
                            dVar.b(a(dVar.field_addMsg));
                            arrayList.add(dVar);
                        }
                    }
                    x.d("MicroMsg.FunctionMsgFetcher", "callbackToUpdate, msgList.size: %s, isShow: %s", Integer.valueOf(arrayList.size()), Boolean.valueOf(z));
                    Map c = c(arrayList);
                    for (Integer intValue : c.keySet()) {
                        int intValue2 = intValue.intValue();
                        List<d> list2 = (List) c.get(Integer.valueOf(intValue2));
                        Map hashMap = new HashMap();
                        for (d dVar2 : list2) {
                            hashMap.put(dVar2.field_functionmsgid, dVar2.field_addMsg);
                        }
                        List<f> list3 = (List) i.Br().gLL.get(Integer.valueOf(intValue2));
                        if (list3 != null) {
                            for (f a : list3) {
                                a.a(0, hashMap, z);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.FunctionMsgFetcher", "callbackToUpdate error: %s", e.getMessage());
            }
        }
    }

    private static Map<Integer, List<d>> c(Collection<d> collection) {
        Map<Integer, List<d>> hashMap = new HashMap();
        for (d dVar : collection) {
            if (dVar.field_addMsg != null) {
                List list = (List) hashMap.get(Integer.valueOf(dVar.field_addMsg.nlX));
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(dVar);
                hashMap.put(Integer.valueOf(dVar.field_addMsg.nlX), list);
            }
        }
        return hashMap;
    }
}
