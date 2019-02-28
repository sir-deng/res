package com.tencent.mm.plugin.fav.a.a;

import com.tencent.mm.a.g;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.va;
import com.tencent.mm.protocal.c.vb;
import com.tencent.mm.protocal.c.vc;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.protocal.c.vm;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vw;
import com.tencent.mm.protocal.c.wc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayInputStream;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class b {
    public static void a(String str, vn vnVar) {
        vnVar.wlY.clear();
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("datalist");
            if (elementsByTagName != null) {
                NodeList childNodes = elementsByTagName.item(0).getChildNodes();
                if (childNodes != null && childNodes.getLength() > 0) {
                    int length = childNodes.getLength();
                    for (int i = 0; i < length; i++) {
                        String str2;
                        Map y;
                        Node item = childNodes.item(i);
                        String b = bj.b(item);
                        NodeList elementsByTagName2 = ((Element) item).getElementsByTagName("recordxml");
                        if (elementsByTagName2 == null || elementsByTagName2.getLength() <= 0) {
                            str2 = null;
                        } else {
                            str2 = bj.b(elementsByTagName2.item(0).getFirstChild());
                        }
                        if (b.trim().startsWith("<dataitem")) {
                            y = bj.y(b, "dataitem");
                        } else {
                            y = null;
                        }
                        if (y != null) {
                            uz uzVar = new uz();
                            String str3 = ".dataitem";
                            uzVar.Dc(bi.getInt((String) y.get(str3 + ".$datatype"), 0));
                            uzVar.Un((String) y.get(str3 + ".$datasourceid"));
                            uzVar.Dd(bi.getInt((String) y.get(str3 + ".$datastatus"), 0));
                            uzVar.Uf((String) y.get(str3 + ".datafmt"));
                            uzVar.TV((String) y.get(str3 + ".datatitle"));
                            uzVar.TW((String) y.get(str3 + ".datadesc"));
                            uzVar.TX((String) y.get(str3 + ".cdn_thumburl"));
                            uzVar.TY((String) y.get(str3 + ".cdn_thumbkey"));
                            uzVar.CZ(bi.getInt((String) y.get(str3 + ".thumb_width"), 0));
                            uzVar.Da(bi.getInt((String) y.get(str3 + ".thumb_height"), 0));
                            uzVar.TZ((String) y.get(str3 + ".cdn_dataurl"));
                            uzVar.Ua((String) y.get(str3 + ".cdn_datakey"));
                            String str4 = (String) y.get(str3 + ".duration");
                            if (str4 != null && str4.length() > 0) {
                                uzVar.Db(bi.getInt(str4, 0));
                            }
                            uzVar.Uc((String) y.get(str3 + ".stream_dataurl"));
                            uzVar.Ud((String) y.get(str3 + ".stream_lowbandurl"));
                            uzVar.Ub((String) y.get(str3 + ".stream_weburl"));
                            uzVar.Uu((String) y.get(str3 + ".canvasPageXml"));
                            uzVar.Ug((String) y.get(str3 + ".fullmd5"));
                            uzVar.Uh((String) y.get(str3 + ".head256md5"));
                            str4 = (String) y.get(str3 + ".fullsize");
                            if (!bi.oN(str4)) {
                                uzVar.fx((long) bi.getInt(str4, 0));
                            }
                            uzVar.Ue((String) y.get(str3 + ".dataext"));
                            uzVar.Ul((String) y.get(str3 + ".thumbfullmd5"));
                            uzVar.Um((String) y.get(str3 + ".thumbhead256md5"));
                            str4 = (String) y.get(str3 + ".thumbfullsize");
                            if (!bi.oN(str4)) {
                                uzVar.fy((long) bi.getInt(str4, 0));
                            }
                            uzVar.Uo((String) y.get(str3 + ".stream_videoid"));
                            str4 = (String) y.get(str3 + ".$dataid");
                            if (bi.oN(str4) || str4.length() < 32) {
                                str4 = uzVar.toString();
                                str4 = g.s((str4 + uzVar.bjS + System.currentTimeMillis()).getBytes());
                            }
                            uzVar.Ui(str4);
                            uzVar.Up((String) y.get(str3 + ".datasrctitle"));
                            uzVar.Uq((String) y.get(str3 + ".datasrcname"));
                            uzVar.Ur((String) y.get(str3 + ".datasrctime"));
                            uzVar.Ut((String) y.get(str3 + ".statextstr"));
                            uzVar.Us((String) y.get(str3 + ".$htmlid"));
                            uzVar.De(bi.getInt((String) y.get(str3 + ".$dataillegaltype"), 0));
                            if (str2 != null) {
                                uzVar.Uv(str2);
                            }
                            vc vcVar = new vc();
                            vcVar.heZ = bi.aD((String) y.get(str3 + ".streamvideo.streamvideourl"), "");
                            vcVar.wlG = bi.Wo((String) y.get(str3 + ".streamvideo.streamvideototaltime"));
                            vcVar.hfb = bi.aD((String) y.get(str3 + ".streamvideo.streamvideotitle"), "");
                            vcVar.hfc = bi.aD((String) y.get(str3 + ".streamvideo.streamvideowording"), "");
                            vcVar.hfd = bi.aD((String) y.get(str3 + ".streamvideo.streamvideoweburl"), "");
                            vcVar.hff = bi.aD((String) y.get(str3 + ".streamvideo.streamvideoaduxinfo"), "");
                            vcVar.hfg = bi.aD((String) y.get(str3 + ".streamvideo.streamvideopublishid"), "");
                            uzVar.a(vcVar);
                            va vaVar = new va();
                            String str5 = str3 + ".dataitemsource";
                            if (y.containsKey(str5)) {
                                vb vbVar = new vb();
                                vbVar.Dg(bi.getInt((String) y.get(str5 + ".$sourcetype"), 0));
                                vbVar.Uy((String) y.get(str5 + ".$sourceid"));
                                vbVar.Uw((String) y.get(str5 + ".fromusr"));
                                vbVar.Ux((String) y.get(str5 + ".tousr"));
                                vbVar.Uz((String) y.get(str5 + ".realchatname"));
                                vbVar.fA(bi.getLong((String) y.get(str5 + ".createtime"), 0));
                                vbVar.UA((String) y.get(str5 + ".msgid"));
                                vbVar.fJM = (String) y.get(str5 + ".eventid");
                                vbVar.wlA = true;
                                vbVar.UB((String) y.get(str5 + ".appid"));
                                vbVar.UC((String) y.get(str5 + ".link"));
                                vbVar.UD((String) y.get(str5 + ".brandid"));
                                vaVar.c(vbVar);
                            } else {
                                x.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str5);
                            }
                            str5 = str3 + ".locitem";
                            if (y.containsKey(str5)) {
                                vg vgVar = new vg();
                                if (!bi.oN((String) y.get(str5 + ".label"))) {
                                    vgVar.UE((String) y.get(str5 + ".label"));
                                }
                                if (!bi.oN((String) y.get(str5 + ".poiname"))) {
                                    vgVar.UF((String) y.get(str5 + ".poiname"));
                                }
                                str4 = (String) y.get(str5 + ".lng");
                                if (!bi.oN(str4)) {
                                    vgVar.r(bi.getDouble(str4, 0.0d));
                                }
                                str4 = (String) y.get(str5 + ".lat");
                                if (!bi.oN(str4)) {
                                    vgVar.s(bi.getDouble(str4, 0.0d));
                                }
                                str4 = (String) y.get(str5 + ".scale");
                                if (!bi.oN(str4)) {
                                    if (str4.indexOf(46) != -1) {
                                        vgVar.Dh(bi.getInt(str4.substring(0, str4.indexOf(46)), -1));
                                    } else {
                                        vgVar.Dh(bi.getInt(str4, -1));
                                    }
                                }
                                vaVar.a(vgVar);
                            } else {
                                x.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str5);
                            }
                            str5 = str3 + ".weburlitem";
                            if (y.containsKey(str5)) {
                                wc wcVar = new wc();
                                wcVar.Vc((String) y.get(str5 + ".clean_url"));
                                wcVar.Vb((String) y.get(str5 + ".pagedesc"));
                                wcVar.Vd((String) y.get(str5 + ".pagethumb_url"));
                                wcVar.Va((String) y.get(str5 + ".pagetitle"));
                                wcVar.Dm(bi.getInt((String) y.get(str5 + ".opencache"), 0));
                                wcVar.Dn(bi.getInt((String) y.get(str5 + ".contentattr"), 0));
                                wcVar.Ve((String) y.get(str5 + ".canvasPageXml"));
                                vaVar.a(wcVar);
                            } else {
                                x.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str5);
                            }
                            str5 = str3 + ".productitem";
                            if (y.containsKey(str5)) {
                                vm vmVar = new vm();
                                vmVar.UG((String) y.get(str5 + ".producttitle"));
                                vmVar.UH((String) y.get(str5 + ".productdesc"));
                                vmVar.UI((String) y.get(str5 + ".productthumb_url"));
                                vmVar.UJ((String) y.get(str5 + ".productinfo"));
                                vmVar.Di(bi.getInt((String) y.get(str5 + ".$type"), 0));
                                vaVar.a(vmVar);
                            } else {
                                x.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str5);
                            }
                            str3 = str3 + ".tvitem";
                            if (y.containsKey(str3)) {
                                vw vwVar = new vw();
                                vwVar.UW((String) y.get(str3 + ".tvtitle"));
                                vwVar.UX((String) y.get(str3 + ".tvdesc"));
                                vwVar.UY((String) y.get(str3 + ".tvthumb_url"));
                                vwVar.UZ((String) y.get(str3 + ".tvinfo"));
                                vaVar.a(vwVar);
                            } else {
                                x.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str3);
                            }
                            uzVar.a(vaVar);
                            vnVar.wlY.add(uzVar);
                        }
                    }
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.FavProtoItemParser", "[parser] parseXML exception:%s", e.toString());
        }
    }
}
