package com.tencent.mm.plugin.fav.a.a;

import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.va;
import com.tencent.mm.protocal.c.vb;
import com.tencent.mm.protocal.c.vc;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.protocal.c.vm;
import com.tencent.mm.protocal.c.vw;
import com.tencent.mm.protocal.c.wc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class a {
    public static String aI(List<uz> list) {
        if (list == null || list.size() == 0) {
            x.v("MicroMsg.FavDataItemParser", "klem toXml data list empty");
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
                stringBuffer.append(" htmlid='").append(bi.Wm(uzVar.wkP)).append("'");
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
                stringBuffer.append("<cdn_thumburl>").append(bi.Wm(uzVar.hcU)).append("</cdn_thumburl>");
            }
            if (uzVar.wjL) {
                stringBuffer.append("<thumb_width>").append(uzVar.hcZ).append("</thumb_width>");
            }
            if (uzVar.wjM) {
                stringBuffer.append("<thumb_height>").append(uzVar.hcY).append("</thumb_height>");
            }
            if (uzVar.wjO) {
                stringBuffer.append("<cdn_dataurl>").append(bi.Wm(uzVar.wjN)).append("</cdn_dataurl>");
            }
            if (uzVar.wjK) {
                stringBuffer.append("<cdn_thumbkey>").append(bi.Wm(uzVar.wjJ)).append("</cdn_thumbkey>");
            }
            if (uzVar.wjQ) {
                stringBuffer.append("<cdn_datakey>").append(bi.Wm(uzVar.wjP)).append("</cdn_datakey>");
            }
            if (uzVar.wjS) {
                stringBuffer.append("<cdn_encryver>").append(uzVar.wjR).append("</cdn_encryver>");
            }
            if (uzVar.wjT) {
                stringBuffer.append("<duration>").append(uzVar.duration).append("</duration>");
            }
            if (uzVar.wjV) {
                stringBuffer.append("<stream_weburl>").append(bi.Wm(uzVar.wjU)).append("</stream_weburl>");
            }
            if (uzVar.wjX) {
                stringBuffer.append("<stream_dataurl>").append(bi.Wm(uzVar.wjW)).append("</stream_dataurl>");
            }
            if (uzVar.wjZ) {
                stringBuffer.append("<stream_lowbandurl>").append(bi.Wm(uzVar.wjY)).append("</stream_lowbandurl>");
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
                stringBuffer.append("<fullsize>").append(uzVar.wki).append("</fullsize>");
            }
            if (uzVar.wkq) {
                stringBuffer.append("<thumbfullmd5>").append(uzVar.wkp).append("</thumbfullmd5>");
            }
            if (uzVar.wks) {
                stringBuffer.append("<thumbhead256md5>").append(uzVar.wkr).append("</thumbhead256md5>");
            }
            if (uzVar.wku) {
                stringBuffer.append("<thumbfullsize>").append(uzVar.wkt).append("</thumbfullsize>");
            }
            if (uzVar.wky) {
                stringBuffer.append("<stream_videoid>").append(bi.Wm(uzVar.wkx)).append("</stream_videoid>");
            }
            if (uzVar.wkG) {
                stringBuffer.append("<datasrctitle>").append(bi.Wm(uzVar.wkF)).append("</datasrctitle>");
            }
            if (uzVar.wkK) {
                stringBuffer.append("<datasrcname>").append(bi.Wm(uzVar.wkJ)).append("</datasrcname>");
            }
            if (uzVar.wkM) {
                stringBuffer.append("<datasrctime>").append(bi.Wm(uzVar.wkL)).append("</datasrctime>");
            }
            if (uzVar.wkS && (uzVar.wkH == null || uzVar.wkH.wlf == null || uzVar.wkH.wlf.bkL() == 0)) {
                stringBuffer.append("<canvasPageXml>").append(bi.Wm(uzVar.canvasPageXml)).append("</canvasPageXml>");
            }
            if (uzVar.wkR) {
                stringBuffer.append("<statextstr>").append(bi.Wm(uzVar.fHB)).append("</statextstr>");
            }
            if (uzVar.wkY) {
                stringBuffer.append("<recordxml>").append(uzVar.wkX).append("</recordxml>");
            }
            vc vcVar = uzVar.wkN;
            if (vcVar != null) {
                stringBuffer.append("<streamvideo>");
                stringBuffer.append("<streamvideourl>").append(bi.Wm(vcVar.heZ)).append("</streamvideourl>");
                stringBuffer.append("<streamvideototaltime>").append(vcVar.wlG).append("</streamvideototaltime>");
                stringBuffer.append("<streamvideotitle>").append(bi.Wm(vcVar.hfb)).append("</streamvideotitle>");
                stringBuffer.append("<streamvideowording>").append(bi.Wm(vcVar.hfc)).append("</streamvideowording>");
                stringBuffer.append("<streamvideoweburl>").append(bi.Wm(vcVar.hfd)).append("</streamvideoweburl>");
                stringBuffer.append("<streamvideoaduxinfo>").append(bi.Wm(vcVar.hff)).append("</streamvideoaduxinfo>");
                stringBuffer.append("<streamvideopublishid>").append(bi.Wm(vcVar.hfg)).append("</streamvideopublishid>");
                stringBuffer.append("</streamvideo>");
            }
            va vaVar = uzVar.wkH;
            if (vaVar == null || vaVar.wlb == null || vaVar.wlb.bkL() == 0) {
                x.v("MicroMsg.FavDataItemParser", "klem toXml, data source item empty");
            } else {
                vb vbVar = vaVar.wlb;
                stringBuffer.append("<dataitemsource");
                if (vbVar.wls) {
                    stringBuffer.append(" sourcetype='").append(vbVar.fqY).append("'");
                }
                if (vbVar.wlw) {
                    stringBuffer.append(" sourceid='").append(vbVar.wlv).append("'");
                }
                stringBuffer.append(">");
                if (vbVar.wlt) {
                    stringBuffer.append("<fromusr>").append(bi.Wm(vbVar.fAJ)).append("</fromusr>");
                }
                if (vbVar.wlu) {
                    stringBuffer.append("<tousr>").append(bi.Wm(vbVar.toUser)).append("</tousr>");
                }
                if (vbVar.wly) {
                    stringBuffer.append("<realchatname>").append(bi.Wm(vbVar.wlx)).append("</realchatname>");
                }
                if (vbVar.wlz) {
                    stringBuffer.append("<msgid>").append(vbVar.fEE).append("</msgid>");
                }
                if (vbVar.wlA) {
                    stringBuffer.append("<eventid>").append(vbVar.fJM).append("</eventid>");
                }
                if (vbVar.wlB) {
                    stringBuffer.append("<appid>").append(vbVar.appId).append("</appid>");
                }
                if (vbVar.wlC) {
                    stringBuffer.append("<link>").append(bi.Wm(vbVar.hPT)).append("</link>");
                }
                if (vbVar.wlF) {
                    stringBuffer.append("<brandid>").append(bi.Wm(vbVar.foe)).append("</brandid>");
                }
                stringBuffer.append("</dataitemsource>");
            }
            vaVar = uzVar.wkH;
            if (vaVar == null || vaVar.wld == null || vaVar.wld.bkL() == 0) {
                x.v("MicroMsg.FavDataItemParser", "klem toXml, loc item empty");
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
                x.v("MicroMsg.FavDataItemParser", "klem toXml, url item empty");
            } else {
                wc wcVar = vaVar.wlf;
                stringBuffer.append("<weburlitem>");
                if (wcVar.wmE) {
                    stringBuffer.append("<clean_url>").append(bi.Wm(wcVar.wmD)).append("</clean_url>");
                }
                if (wcVar.wjH) {
                    stringBuffer.append("<pagedesc>").append(bi.Wm(wcVar.desc)).append("</pagedesc>");
                }
                if (wcVar.wlT) {
                    stringBuffer.append("<pagethumb_url>").append(bi.Wm(wcVar.thumbUrl)).append("</pagethumb_url>");
                }
                if (wcVar.wjG) {
                    stringBuffer.append("<pagetitle>").append(bi.Wm(wcVar.title)).append("</pagetitle>");
                }
                if (wcVar.wmG) {
                    stringBuffer.append("<opencache>").append(wcVar.wmF).append("</opencache>");
                }
                if (wcVar.wmH) {
                    stringBuffer.append("<contentattr>").append(wcVar.hcR).append("</contentattr>");
                }
                if (wcVar.wkS) {
                    stringBuffer.append("<canvasPageXml>").append(bi.Wm(wcVar.canvasPageXml)).append("</canvasPageXml>");
                }
                stringBuffer.append("</weburlitem>");
            }
            vaVar = uzVar.wkH;
            if (vaVar == null || vaVar.wlh == null || vaVar.wlh.bkL() == 0) {
                x.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
            } else {
                vm vmVar = vaVar.wlh;
                stringBuffer.append("<productitem");
                if (vmVar.wlV) {
                    stringBuffer.append(" type='").append(vmVar.type).append("'");
                }
                stringBuffer.append(">");
                if (vmVar.wjG) {
                    stringBuffer.append("<producttitle>").append(bi.Wm(vmVar.title)).append("</producttitle>");
                }
                if (vmVar.wjH) {
                    stringBuffer.append("<productdesc>").append(bi.Wm(vmVar.desc)).append("</productdesc>");
                }
                if (vmVar.wlT) {
                    stringBuffer.append("<productthumb_url>").append(bi.Wm(vmVar.thumbUrl)).append("</productthumb_url>");
                }
                if (vmVar.wlU) {
                    stringBuffer.append("<productinfo>").append(bi.Wm(vmVar.info)).append("</productinfo>");
                }
                stringBuffer.append("</productitem>");
            }
            va vaVar2 = uzVar.wkH;
            if (vaVar2 == null || vaVar2.wlj == null || vaVar2.wlj.bkL() == 0) {
                x.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
            } else {
                vw vwVar = vaVar2.wlj;
                stringBuffer.append("<tvitem>");
                if (vwVar.wjG) {
                    stringBuffer.append("<tvtitle>").append(bi.Wm(vwVar.title)).append("</tvtitle>");
                }
                if (vwVar.wjH) {
                    stringBuffer.append("<tvdesc>").append(bi.Wm(vwVar.desc)).append("</tvdesc>");
                }
                if (vwVar.wlT) {
                    stringBuffer.append("<tvthumb_url>").append(bi.Wm(vwVar.thumbUrl)).append("</tvthumb_url>");
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
