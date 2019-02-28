package com.tencent.xweb.xwalk.a;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.xweb.util.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xwalk.core.XWalkInitializer;

public final class a {

    public static class a {
        public String ACH;
        public String ACI;
        public c[] ACJ;
        public com.tencent.xweb.c.a.a[] ACK;
    }

    public static class b {
        public String ACH;
        public int ACL;
        public String ACM;
        public boolean ACN;
        public boolean bUseCdn;
    }

    public static class c {
        public String ACH;
        public String ACM;
        public boolean ACN;
        public int ACO;
        public int ACP;
        public b[] ACQ;
        public d ACR = new d();
        com.tencent.xweb.c.a.b AzW = new com.tencent.xweb.c.a.b();
        public boolean bUseCdn;
    }

    public static class d {
        public String ACS = "";
    }

    static String h(File file, int i) {
        try {
            byte[] bArr = new byte[i];
            int read = new FileInputStream(file).read(bArr, 0, bArr.length);
            if (read != bArr.length) {
                return null;
            }
            String str = new String(bArr, 0, read);
            int indexOf = str.indexOf("<Versions>");
            if (indexOf < 0) {
                return null;
            }
            bArr = MessageDigest.getInstance("MD5").digest(str.substring(indexOf).getBytes());
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder(bArr.length);
            for (byte b : bArr) {
                String toHexString = Integer.toHexString(b & 255);
                if (toHexString.length() == 1) {
                    stringBuilder.append(0);
                }
                stringBuilder.append(toHexString);
            }
            return stringBuilder.toString().toUpperCase();
        } catch (Exception e) {
            return null;
        }
    }

    private static int a(Element element, String str) {
        if (element == null) {
            return 0;
        }
        String attribute = element.getAttribute(str);
        if (attribute == null || attribute.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(attribute);
    }

    private static boolean b(Element element, String str) {
        if (element == null) {
            return false;
        }
        String attribute = element.getAttribute(str);
        if (attribute == null || attribute.isEmpty()) {
            return false;
        }
        return Boolean.parseBoolean(attribute);
    }

    private static b[] a(Element element) {
        NodeList elementsByTagName = element.getElementsByTagName("Patch");
        if (elementsByTagName == null || elementsByTagName.getLength() == 0) {
            return null;
        }
        b[] bVarArr = new b[elementsByTagName.getLength()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= elementsByTagName.getLength()) {
                return bVarArr;
            }
            b bVar = new b();
            Element element2 = (Element) elementsByTagName.item(i2);
            bVar.ACM = element2.getAttribute(SlookSmartClipMetaTag.TAG_TYPE_URL);
            bVar.ACL = a(element2, "targetVersion");
            bVar.ACH = element2.getAttribute("md5");
            bVar.ACN = b(element2, "useCellular");
            bVar.bUseCdn = b(element2, "useCdn");
            bVarArr[i2] = bVar;
            i = i2 + 1;
        }
    }

    private static void a(a aVar, Element element) {
        if (element != null) {
            try {
                NodeList elementsByTagName = element.getElementsByTagName("command");
                if (elementsByTagName != null && elementsByTagName.getLength() != 0) {
                    aVar.ACK = new com.tencent.xweb.c.a.a[elementsByTagName.getLength()];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < elementsByTagName.getLength()) {
                            com.tencent.xweb.c.a.a aVar2 = new com.tencent.xweb.c.a.a();
                            Element element2 = (Element) elementsByTagName.item(i2);
                            aVar2.AzW.AAc = a(element2, "apkMin");
                            aVar2.AzW.AAd = a(element2, "apkMax");
                            aVar2.AzW.AAa = a(element2, "sdkMin");
                            aVar2.AzW.AAb = a(element2, "sdkMax");
                            aVar2.AzW.AAe = a(element2, "apiMin");
                            aVar2.AzW.AAf = a(element2, "apiMax");
                            aVar2.AzW.AAg = element2.getAttribute("forbidDeviceRegex");
                            aVar2.AzW.AAh = a(element2, "grayMin");
                            aVar2.AzW.AAi = a(element2, "grayMax");
                            aVar2.AzX = element2.getAttribute("optype");
                            aVar2.AzY = element2.getAttribute("opvalue");
                            aVar2.AzZ = element2.getAttribute("module");
                            aVar.ACK[i2] = aVar2;
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public static a i(File file, String str) {
        a aVar = null;
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        try {
            InputStream fileInputStream = new FileInputStream(file);
            a aVar2 = new a();
            try {
                Element documentElement = newInstance.newDocumentBuilder().parse(fileInputStream).getDocumentElement();
                if (documentElement == null) {
                    XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                    return null;
                }
                aVar2.ACH = documentElement.getAttribute("checkvalue");
                if (aVar2.ACH == null || !aVar2.ACH.equalsIgnoreCase(str)) {
                    e.gC(34);
                    XWalkInitializer.addXWalkInitializeLog("parse config failed , md5 not match");
                    return null;
                }
                aVar2.ACI = documentElement.getAttribute("configVer");
                a(aVar2, documentElement);
                NodeList elementsByTagName = documentElement.getElementsByTagName("VersionInfo");
                if (!(elementsByTagName == null || elementsByTagName.getLength() == 0)) {
                    aVar2.ACJ = new c[elementsByTagName.getLength()];
                    for (int i = 0; i < elementsByTagName.getLength(); i++) {
                        c cVar = new c();
                        Element element = (Element) elementsByTagName.item(i);
                        cVar.ACM = element.getAttribute("fullurl");
                        cVar.ACH = element.getAttribute("md5");
                        cVar.AzW.AAg = element.getAttribute("forbidDeviceRegex");
                        cVar.AzW.AAa = a(element, "sdkMin");
                        cVar.AzW.AAb = a(element, "sdkMax");
                        cVar.AzW.AAe = a(element, "apiMin");
                        cVar.AzW.AAf = a(element, "apiMax");
                        cVar.ACP = a(element, "period");
                        cVar.ACO = a(element, "version");
                        cVar.ACN = b(element, "useCellular");
                        cVar.AzW.AAh = a(element, "grayMin");
                        cVar.AzW.AAi = a(element, "grayMax");
                        cVar.bUseCdn = b(element, "useCdn");
                        d dVar = cVar.ACR;
                        if (dVar != null) {
                            NodeList elementsByTagName2 = element.getElementsByTagName("Description");
                            if (!(elementsByTagName2 == null || elementsByTagName2.getLength() == 0)) {
                                dVar.ACS = ((Element) elementsByTagName2.item(0)).getAttribute("versionStr");
                            }
                        }
                        cVar.ACQ = a(element);
                        aVar2.ACJ[i] = cVar;
                    }
                }
                return aVar2;
            } catch (ParserConfigurationException e) {
                aVar = aVar2;
                XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                return aVar;
            } catch (SAXException e2) {
                aVar = aVar2;
                XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                return aVar;
            } catch (IOException e3) {
                aVar = aVar2;
                XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                return aVar;
            }
        } catch (ParserConfigurationException e4) {
            XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
            return aVar;
        } catch (SAXException e5) {
            XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
            return aVar;
        } catch (IOException e6) {
            XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
            return aVar;
        }
    }
}
