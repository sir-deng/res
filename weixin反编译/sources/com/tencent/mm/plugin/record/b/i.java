package com.tencent.mm.plugin.record.b;

import com.tencent.mm.af.a.e;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.va;
import com.tencent.mm.protocal.c.vb;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.protocal.c.vm;
import com.tencent.mm.protocal.c.vw;
import com.tencent.mm.protocal.c.wc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.s;
import java.util.List;

public final class i {
    public static String aI(List<uz> list) {
        if (list == null || list.size() == 0) {
            x.w("MicroMsg.RecordMsgParser", "klem toXml data list empty");
            return "";
        }
        int size = list.size();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<datalist count='").append(size).append("'>");
        for (int i = 0; i < size; i++) {
            uz uzVar = (uz) list.get(i);
            stringBuffer.append("<dataitem ");
            if (uzVar.wkb) {
                stringBuffer.append("datatype='").append(uzVar.bjS).append("'");
            }
            if (uzVar.wkE) {
                stringBuffer.append(" datastatus='").append(uzVar.wkD).append("'");
            }
            if (uzVar.wkk) {
                stringBuffer.append(" dataid='").append(uzVar.mBr).append("'");
            }
            if (uzVar.wkQ) {
                stringBuffer.append(" htmlid='").append(uzVar.wkP).append("'");
            }
            if (uzVar.wkW) {
                stringBuffer.append(" dataillegaltype='").append(uzVar.wkV).append("'");
            }
            if (uzVar.wkw) {
                stringBuffer.append(" datasourceid='").append(uzVar.wkv).append("'");
            }
            stringBuffer.append(">");
            if (uzVar.wkd) {
                stringBuffer.append("<datafmt>").append(uzVar.wkc).append("</datafmt>");
            }
            if (uzVar.wjG) {
                stringBuffer.append("<datatitle>").append(bi.Wm(uzVar.title)).append("</datatitle>");
            }
            if (uzVar.wjH) {
                stringBuffer.append("<datadesc>").append(bi.Wm(uzVar.desc)).append("</datadesc>");
            }
            if (uzVar.wjI) {
                stringBuffer.append("<cdnthumburl>").append(bi.Wm(uzVar.hcU)).append("</cdnthumburl>");
            }
            if (uzVar.wjL) {
                stringBuffer.append("<thumbwidth>").append(uzVar.hcZ).append("</thumbwidth>");
            }
            if (uzVar.wjM) {
                stringBuffer.append("<thumbheight>").append(uzVar.hcY).append("</thumbheight>");
            }
            if (uzVar.wjO) {
                stringBuffer.append("<cdndataurl>").append(bi.Wm(uzVar.wjN)).append("</cdndataurl>");
            }
            if (uzVar.wjK) {
                stringBuffer.append("<cdnthumbkey>").append(bi.Wm(uzVar.wjJ)).append("</cdnthumbkey>");
            }
            if (uzVar.wjQ) {
                stringBuffer.append("<cdndatakey>").append(bi.Wm(uzVar.wjP)).append("</cdndatakey>");
            }
            if (uzVar.wjS) {
                stringBuffer.append("<cdnencryver>").append(uzVar.wjR).append("</cdnencryver>");
            }
            if (uzVar.wjT) {
                stringBuffer.append("<duration>").append(uzVar.duration).append("</duration>");
            }
            if (uzVar.wjV) {
                stringBuffer.append("<streamweburl>").append(bi.Wm(uzVar.wjU)).append("</streamweburl>");
            }
            if (uzVar.wjX) {
                stringBuffer.append("<streamdataurl>").append(bi.Wm(uzVar.wjW)).append("</streamdataurl>");
            }
            if (uzVar.wjZ) {
                stringBuffer.append("<streamlowbandurl>").append(bi.Wm(uzVar.wjY)).append("</streamlowbandurl>");
            }
            if (uzVar.wka) {
                stringBuffer.append("<dataext>").append(bi.Wm(uzVar.fra)).append("</dataext>");
            }
            if (uzVar.wkf) {
                stringBuffer.append("<fullmd5>").append(uzVar.wke).append("</fullmd5>");
            }
            if (uzVar.wkh) {
                stringBuffer.append("<head256md5>").append(uzVar.wkg).append("</head256md5>");
            }
            if (uzVar.wkj) {
                stringBuffer.append("<datasize>").append(uzVar.wki).append("</datasize>");
            }
            if (uzVar.wkq) {
                stringBuffer.append("<thumbfullmd5>").append(uzVar.wkp).append("</thumbfullmd5>");
            }
            if (uzVar.wks) {
                stringBuffer.append("<thumbhead256md5>").append(uzVar.wkr).append("</thumbhead256md5>");
            }
            if (uzVar.wku) {
                stringBuffer.append("<thumbsize>").append(uzVar.wkt).append("</thumbsize>");
            }
            if (uzVar.wky) {
                stringBuffer.append("<streamvideoid>").append(bi.Wm(uzVar.wkx)).append("</streamvideoid>");
            }
            if (uzVar.wkG) {
                stringBuffer.append("<sourcetitle>").append(bi.Wm(uzVar.wkF)).append("</sourcetitle>");
            }
            if (uzVar.wkK) {
                stringBuffer.append("<sourcename>").append(bi.Wm(uzVar.wkJ)).append("</sourcename>");
            }
            if (uzVar.wkM) {
                stringBuffer.append("<sourcetime>").append(bi.Wm(uzVar.wkL)).append("</sourcetime>");
            }
            if (uzVar.wkR) {
                stringBuffer.append("<statextstr>").append(bi.Wm(uzVar.fHB)).append("</statextstr>");
            }
            if (uzVar.wkY) {
                stringBuffer.append("<recordxml>").append(uzVar.wkX).append("</recordxml>");
            }
            va vaVar = uzVar.wkH;
            if (vaVar == null || vaVar.wlb == null || vaVar.wlb.bkL() == 0) {
                x.w("MicroMsg.RecordMsgParser", "klem toXml, data source item empty");
            } else {
                vb vbVar = vaVar.wlb;
                if (vbVar.wlB) {
                    stringBuffer.append("<appid>").append(vbVar.appId).append("</appid>");
                }
                if (vbVar.wlC) {
                    stringBuffer.append("<link>").append(bi.Wm(vbVar.hPT)).append("</link>");
                }
                if (vbVar.wlF) {
                    stringBuffer.append("<brandid>").append(bi.Wm(vbVar.foe)).append("</brandid>");
                }
                if (vbVar.wlt && vbVar.wly) {
                    if (vbVar.fAJ.equals(vbVar.wlx)) {
                        stringBuffer.append("<dataitemsource><fromusr>").append(bi.Wm(vbVar.fAJ)).append("</fromusr></dataitemsource>");
                    } else if (s.eX(vbVar.fAJ) || e.kp(vbVar.wlx)) {
                        stringBuffer.append("<dataitemsource><realchatname>").append(bi.Wm(vbVar.wlx)).append("</realchatname></dataitemsource>");
                    }
                } else if (vbVar.wlt) {
                    stringBuffer.append("<dataitemsource><fromusr>").append(bi.Wm(vbVar.fAJ)).append("</fromusr></dataitemsource>");
                } else if (vbVar.wly) {
                    stringBuffer.append("<dataitemsource><realchatname>").append(bi.Wm(vbVar.wlx)).append("</realchatname></dataitemsource>");
                }
            }
            vaVar = uzVar.wkH;
            if (vaVar == null || vaVar.wld == null || vaVar.wld.bkL() == 0) {
                x.w("MicroMsg.RecordMsgParser", "klem toXml, loc item empty");
            } else {
                vg vgVar = vaVar.wld;
                stringBuffer.append("<locitem>");
                if (vgVar.wlN) {
                    stringBuffer.append("<label>").append(bi.Wm(vgVar.label)).append("</label>");
                }
                if (vgVar.wlL) {
                    stringBuffer.append("<lat>").append(vgVar.lat).append("</lat>");
                }
                if (vgVar.wlK) {
                    stringBuffer.append("<lng>").append(vgVar.lng).append("</lng>");
                }
                if (vgVar.wlM) {
                    stringBuffer.append("<scale>").append(vgVar.fAq).append("</scale>");
                }
                if (vgVar.wlO) {
                    stringBuffer.append("<poiname>").append(vgVar.fEp).append("</poiname>");
                }
                stringBuffer.append("</locitem>");
            }
            vaVar = uzVar.wkH;
            if (vaVar == null || vaVar.wlf == null || vaVar.wlf.bkL() == 0) {
                x.w("MicroMsg.RecordMsgParser", "klem toXml, url item empty");
            } else {
                wc wcVar = vaVar.wlf;
                stringBuffer.append("<weburlitem>");
                if (wcVar.wmE) {
                    stringBuffer.append("<link>").append(bi.Wm(wcVar.wmD)).append("</link>");
                }
                if (wcVar.wjH) {
                    stringBuffer.append("<desc>").append(bi.Wm(wcVar.desc)).append("</desc>");
                }
                if (wcVar.wlT) {
                    stringBuffer.append("<thumburl>").append(bi.Wm(wcVar.thumbUrl)).append("</thumburl>");
                }
                if (wcVar.wjG) {
                    stringBuffer.append("<title>").append(bi.Wm(wcVar.title)).append("</title>");
                }
                if (wcVar.wmG) {
                    stringBuffer.append("<opencache>").append(wcVar.wmF).append("</opencache>");
                }
                if (wcVar.wmH) {
                    stringBuffer.append("<contentattr>").append(wcVar.hcR).append("</contentattr>");
                }
                stringBuffer.append("</weburlitem>");
            }
            vaVar = uzVar.wkH;
            if (vaVar == null || vaVar.wlh == null || vaVar.wlh.bkL() == 0) {
                x.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
            } else {
                vm vmVar = vaVar.wlh;
                stringBuffer.append("<productitem");
                if (vmVar.wlV) {
                    stringBuffer.append(" type='").append(vmVar.type).append("'");
                }
                stringBuffer.append(">");
                if (vmVar.wjG) {
                    stringBuffer.append("<title>").append(bi.Wm(vmVar.title)).append("</title>");
                }
                if (vmVar.wjH) {
                    stringBuffer.append("<desc>").append(bi.Wm(vmVar.desc)).append("</desc>");
                }
                if (vmVar.wlT) {
                    stringBuffer.append("<thumburl>").append(bi.Wm(vmVar.thumbUrl)).append("</thumburl>");
                }
                if (vmVar.wlU) {
                    stringBuffer.append("<productinfo>").append(bi.Wm(vmVar.info)).append("</productinfo>");
                }
                stringBuffer.append("</productitem>");
            }
            va vaVar2 = uzVar.wkH;
            if (vaVar2 == null || vaVar2.wlj == null || vaVar2.wlj.bkL() == 0) {
                x.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
            } else {
                vw vwVar = vaVar2.wlj;
                stringBuffer.append("<tvitem>");
                if (vwVar.wjG) {
                    stringBuffer.append("<title>").append(bi.Wm(vwVar.title)).append("</title>");
                }
                if (vwVar.wjH) {
                    stringBuffer.append("<desc>").append(bi.Wm(vwVar.desc)).append("</desc>");
                }
                if (vwVar.wlT) {
                    stringBuffer.append("<thumburl>").append(bi.Wm(vwVar.thumbUrl)).append("</thumburl>");
                }
                if (vwVar.wlU) {
                    stringBuffer.append("<tvinfo>").append(bi.Wm(vwVar.info)).append("</tvinfo>");
                }
                stringBuffer.append("</tvitem>");
            }
            stringBuffer.append("</dataitem>");
        }
        stringBuffer.append("</datalist>");
        return stringBuffer.toString();
    }
}
