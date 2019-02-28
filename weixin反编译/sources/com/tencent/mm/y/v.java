package com.tencent.mm.y;

import com.tencent.mm.ad.d;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.ad.d.b;
import com.tencent.mm.f.a.cd;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class v implements d {
    public final b b(a aVar) {
        bx bxVar = aVar.hoa;
        if (bxVar == null || bxVar.vNO == null) {
            x.f("MicroMsg.DeletePackageMsgExtension", "[oneliang]DeletePackageMsgExtension failed, invalid cmdAM");
        } else {
            x.i("MicroMsg.DeletePackageMsgExtension", "[oneliang]DeletePackageMsgExtension start");
            try {
                Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(n.a(bxVar.vNO).getBytes(ProtocolPackage.ServerEncoding))));
                parse.normalize();
                NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("deletepackage");
                if (elementsByTagName != null && elementsByTagName.getLength() == 1) {
                    NodeList childNodes = elementsByTagName.item(0).getChildNodes();
                    int length = childNodes.getLength();
                    for (int i = 0; i < length; i++) {
                        Node item = childNodes.item(i);
                        if (!(item == null || item.getNodeName() == null || !item.getNodeName().equals("pack"))) {
                            NamedNodeMap attributes = item.getAttributes();
                            if (attributes != null) {
                                item = attributes.getNamedItem(Columns.TYPE);
                                if (item != null) {
                                    int i2 = bi.getInt(item.getNodeValue(), 0);
                                    com.tencent.mm.sdk.b.b cdVar = new cd();
                                    cdVar.fri.frj = i2;
                                    com.tencent.mm.sdk.b.a.xmy.m(cdVar);
                                }
                            }
                        }
                    }
                }
                x.i("MicroMsg.DeletePackageMsgExtension", "[oneliang]DeletePackageMsgExtension end");
            } catch (Throwable e) {
                x.e("MicroMsg.DeletePackageMsgExtension", "exception:%s", bi.i(e));
            }
        }
        return null;
    }

    public final void h(au auVar) {
    }
}
