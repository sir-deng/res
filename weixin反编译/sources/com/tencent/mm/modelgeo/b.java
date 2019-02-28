package com.tencent.mm.modelgeo;

import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.u;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b implements e {
    public static String TAG = "MicroMsg.LocationAddr";
    private static b hzs;
    private c hzt = null;
    private LinkedList<c> hzu = new LinkedList();
    private HashMap<String, LinkedList<WeakReference<a>>> hzv = new HashMap();
    private at hzw = new at(1, "addr_worker");
    private boolean hzx = true;

    public interface a {
        void b(Addr addr);
    }

    private class b implements com.tencent.mm.sdk.platformtools.at.a {
        private Addr hzy = null;

        public final boolean JH() {
            if (b.this.hzt == null) {
                return false;
            }
            if (this.hzy == null || this.hzy.hzf == null || this.hzy.hzf.equals("")) {
                this.hzy = b.a(b.this.hzt.lat, b.this.hzt.lng, b.this.hzx);
            }
            return true;
        }

        public final boolean JI() {
            b.this.hzx = true;
            b.this.a(this.hzy);
            return true;
        }
    }

    class c {
        double lat;
        double lng;
        Object tag = "";

        public c(double d, double d2, Object obj) {
            this.lat = d;
            this.lng = d2;
            this.tag = obj;
        }

        public final String toString() {
            StringBuilder append = new StringBuilder().append((int) (this.lat * 1000000.0d)).append((int) (this.lng * 1000000.0d));
            String obj = this.tag == null ? "" : ((this.tag instanceof Integer) || (this.tag instanceof Long) || (this.tag instanceof Double) || (this.tag instanceof Float) || (this.tag instanceof String)) ? this.tag : this.tag.toString();
            return append.append(obj).toString();
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            return ((c) obj).toString().equals(toString());
        }
    }

    private b() {
    }

    public static b OT() {
        if (hzs == null) {
            hzs = new b();
        }
        return hzs;
    }

    public final boolean a(a aVar) {
        LinkedList linkedList;
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (String str : this.hzv.keySet()) {
            linkedList = (LinkedList) this.hzv.get(str);
            b(linkedList, aVar);
            this.hzv.put(str, linkedList);
            if (linkedList == null || linkedList.size() == 0) {
                linkedList3.add(str);
            }
        }
        Iterator it = linkedList3.iterator();
        while (it.hasNext()) {
            this.hzv.remove((String) it.next());
        }
        Iterator it2 = this.hzu.iterator();
        while (it2.hasNext()) {
            c cVar = (c) it2.next();
            linkedList = (LinkedList) this.hzv.get(cVar.toString());
            if (linkedList == null || linkedList.size() == 0) {
                linkedList2.add(cVar);
                this.hzv.remove(cVar.toString());
            }
        }
        it = linkedList2.iterator();
        while (it.hasNext()) {
            this.hzu.remove((c) it.next());
        }
        x.i(TAG, "remove taskLists %d listeners size %d", Integer.valueOf(this.hzu.size()), Integer.valueOf(this.hzv.size()));
        return true;
    }

    private static boolean a(LinkedList<WeakReference<a>> linkedList, a aVar) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(LinkedList<WeakReference<a>> linkedList, a aVar) {
        if (linkedList == null) {
            return false;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                linkedList.remove(weakReference);
                return true;
            }
        }
        return false;
    }

    public final boolean a(double d, double d2, a aVar, Object obj) {
        c cVar;
        if (obj != null) {
            Iterator it = this.hzu.iterator();
            while (it.hasNext()) {
                cVar = (c) it.next();
                if (cVar != null && cVar.tag != null && cVar.tag.equals(obj)) {
                    this.hzu.remove(cVar);
                    break;
                }
            }
        }
        cVar = new c(d, d2, obj);
        LinkedList linkedList = (LinkedList) this.hzv.get(cVar.toString());
        if (linkedList == null) {
            linkedList = new LinkedList();
        }
        if (!a(linkedList, aVar)) {
            linkedList.add(new WeakReference(aVar));
        }
        this.hzv.put(cVar.toString(), linkedList);
        Iterator it2 = this.hzu.iterator();
        while (it2.hasNext()) {
            if (((c) it2.next()).equals(cVar)) {
                OU();
                return false;
            }
        }
        if (this.hzt != null && cVar.equals(this.hzt)) {
            return false;
        }
        this.hzu.add(cVar);
        x.i(TAG, "push task size %d listeners %d", Integer.valueOf(this.hzu.size()), Integer.valueOf(this.hzv.size()));
        while (this.hzu.size() > 30) {
            x.i(TAG, "force remove task");
            cVar = (c) this.hzu.removeFirst();
            if (cVar != null) {
                this.hzv.remove(cVar.toString());
            }
        }
        OU();
        return true;
    }

    public final boolean a(double d, double d2, a aVar) {
        return a(d, d2, aVar, null);
    }

    private void OU() {
        if (this.hzt == null && this.hzu != null && this.hzu.size() > 0) {
            this.hzt = (c) this.hzu.removeFirst();
            if (bi.PZ()) {
                this.hzw.c(new b());
                return;
            }
            g.CN().a(655, (e) this);
            g.CN().a(new d(this.hzt.lat, this.hzt.lng), 0);
        }
    }

    private void a(Addr addr) {
        if (this.hzt != null) {
            if (addr == null) {
                addr = new Addr();
            }
            addr.tag = this.hzt.tag == null ? new Object() : this.hzt.tag;
            addr.hzq = (float) this.hzt.lat;
            addr.hzr = (float) this.hzt.lng;
            if (!bi.oN(addr.hzh)) {
                String string = ad.getContext().getResources().getString(h.luk);
                x.d(TAG, "city %s", string);
                if (!bi.PZ() && !bi.oN(string) && addr.hzh.endsWith(string)) {
                    addr.hzi = addr.hzh;
                    addr.hzh = addr.hzh.substring(0, addr.hzh.length() - string.length());
                } else if (bi.PZ() || bi.oN(string) || addr.hzf.indexOf(string) < 0) {
                    addr.hzi = addr.hzh;
                } else {
                    addr.hzi = addr.hzh + string;
                }
            }
            LinkedList linkedList = (LinkedList) this.hzv.get(this.hzt.toString());
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((a) weakReference.get()).b(addr);
                    }
                }
            }
            this.hzv.remove(this.hzt.toString());
            x.d(TAG, "postexecute2 listeners %d", Integer.valueOf(this.hzv.size()));
            this.hzt = null;
            OU();
            if (this.hzt == null && this.hzu.size() > 0) {
                g.CN().b(655, (e) this);
            }
        }
    }

    private static Addr a(double d, double d2, boolean z) {
        String format;
        InputStreamReader inputStreamReader;
        Throwable e;
        u uVar;
        String cfV = w.cfV();
        Addr addr = new Addr();
        if (z) {
            format = String.format("https://maps.google.com/maps/api/geocode/json?latlng=%f,%f&language=%s&sensor=false", new Object[]{Double.valueOf(d), Double.valueOf(d2), cfV});
        } else {
            format = String.format("https://maps.google.com/maps/api/geocode/json?latlng=%f,%f&language=%s&sensor=false", new Object[]{Double.valueOf(d), Double.valueOf(d2), "zh_CN"});
        }
        x.d(TAG, "url " + format);
        u a;
        try {
            a = com.tencent.mm.network.b.a(format, null);
            try {
                a.setConnectTimeout(10000);
                a.setRequestMethod("GET");
                x.d(TAG, "conn " + a.getResponseCode());
                inputStreamReader = new InputStreamReader(a.getInputStream());
                try {
                    String readLine;
                    String string;
                    String string2;
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    x.d(TAG, "sb " + stringBuffer.toString());
                    JSONArray jSONArray = new JSONObject(stringBuffer.toString()).getJSONArray("results");
                    JSONObject jSONObject = jSONArray.getJSONObject(0);
                    addr.hzf = jSONObject.getString("formatted_address");
                    JSONArray jSONArray2 = jSONArray.getJSONObject(0).getJSONArray("address_components");
                    for (int i = 0; i < jSONArray2.length(); i++) {
                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                        try {
                            string = jSONObject2.getString("long_name");
                            string2 = jSONObject2.getJSONArray("types").getString(0);
                            if (string2.equals("administrative_area_level_1")) {
                                addr.hzg = string;
                            } else if (string2.equals(TencentExtraKeys.LOCATION_KEY_LOCALITY)) {
                                addr.hzh = string;
                            } else if (string2.equals(TencentExtraKeys.LOCATION_KEY_SUBLOCALITY)) {
                                addr.hzj = string;
                            } else if (string2.equals("neighborhood")) {
                                addr.hzk = string;
                            } else if (string2.equals(TencentExtraKeys.LOCATION_KEY_ROUTE)) {
                                addr.hzl = string;
                            } else if (string2.equals("street_number")) {
                                addr.hzm = string;
                            } else if (string2.equals("country")) {
                                addr.country = string;
                            }
                        } catch (Exception e2) {
                        } catch (IOException e3) {
                            e = e3;
                            uVar = a;
                        }
                    }
                    format = ProtocolPackage.ServerEncoding;
                    string2 = URLEncoder.encode(addr.hzf, format);
                    readLine = URLEncoder.encode(jSONArray2.toString(), format);
                    string = URLEncoder.encode(jSONObject.getJSONObject("geometry").toString(), format);
                    String encode = URLEncoder.encode(jSONObject.getString("place_id"), format);
                    String encode2 = URLEncoder.encode(jSONObject.getJSONArray("types").toString(), format);
                    format = URLEncoder.encode(String.format("[%f,%f]", new Object[]{Double.valueOf(d), Double.valueOf(d2)}), format);
                    x.d(TAG, "google report, formattedaddr: %s, componentaddr: %s, geometry: %s, placeId: %s, types: %s, location: %s, curLanguage: %s", string2, readLine, string, encode, encode2, format, cfV);
                    com.tencent.mm.plugin.report.service.g.pWK.h(12886, readLine, string2, string, encode, encode2, format, cfV);
                    a.aBw.disconnect();
                } catch (IOException e32) {
                    e = e32;
                    uVar = a;
                } catch (Exception e4) {
                    e = e4;
                    try {
                        x.d(TAG, "error Exception");
                        x.e(TAG, "exception:%s", bi.i(e));
                        if (a != null) {
                            a.aBw.disconnect();
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (Throwable e5) {
                                x.e(TAG, "exception:%s", bi.i(e5));
                            }
                        }
                        return addr;
                    } catch (Throwable th) {
                        e5 = th;
                        if (a != null) {
                            a.aBw.disconnect();
                        }
                        throw e5;
                    }
                }
            } catch (IOException e6) {
                e5 = e6;
                inputStreamReader = null;
                uVar = a;
                try {
                    x.d(TAG, "error e");
                    x.e(TAG, "exception:%s", bi.i(e5));
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    return addr;
                } catch (Throwable th2) {
                    e5 = th2;
                    a = uVar;
                    if (a != null) {
                        a.aBw.disconnect();
                    }
                    throw e5;
                }
            } catch (Exception e7) {
                e5 = e7;
                inputStreamReader = null;
                x.d(TAG, "error Exception");
                x.e(TAG, "exception:%s", bi.i(e5));
                if (a != null) {
                    a.aBw.disconnect();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                return addr;
            }
        } catch (IOException e8) {
            e5 = e8;
            uVar = null;
            inputStreamReader = null;
            x.d(TAG, "error e");
            x.e(TAG, "exception:%s", bi.i(e5));
            if (uVar != null) {
                uVar.aBw.disconnect();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            return addr;
        } catch (Exception e9) {
            e5 = e9;
            a = null;
            inputStreamReader = null;
            x.d(TAG, "error Exception");
            x.e(TAG, "exception:%s", bi.i(e5));
            if (a != null) {
                a.aBw.disconnect();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            return addr;
        } catch (Throwable th3) {
            e5 = th3;
            a = null;
            if (a != null) {
                a.aBw.disconnect();
            }
            throw e5;
        }
        if (inputStreamReader != null) {
            inputStreamReader.close();
        }
        return addr;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 655) {
            Addr OY = ((d) kVar).OY();
            if (OY == null || OY.hzf == null || OY.hzf.equals("")) {
                this.hzw.c(new b());
            } else {
                a(OY);
            }
        }
    }
}
