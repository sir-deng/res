package com.tencent.mm.plugin.appbrand.r;

import android.util.Base64;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class l {
    public static final boolean a(j jVar, Map map, b bVar) {
        JSONException e;
        UnsupportedEncodingException e2;
        if (jVar == null || map == null || bVar == null) {
            return true;
        }
        String str;
        AppBrandSysConfig appBrandSysConfig = jVar.iuk.isS;
        d dVar = (d) jVar.ium.v(d.class);
        JSONArray jSONArray = new JSONArray();
        Object obj;
        if ((bVar instanceof com.tencent.mm.plugin.appbrand.jsapi.l) && ((com.tencent.mm.plugin.appbrand.jsapi.l) bVar).jfy == Thread.currentThread()) {
            obj = 1;
        } else {
            obj = null;
        }
        Iterator it = map.entrySet().iterator();
        int i = 0;
        Object obj2 = null;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value != null && (value instanceof ByteBuffer)) {
                int nativeBufferId;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", str);
                    if (dVar != null && (obj == null || dVar.ael())) {
                        nativeBufferId = dVar.getNativeBufferId();
                        if (nativeBufferId != -1) {
                            ByteBuffer byteBuffer = (ByteBuffer) value;
                            if (byteBuffer == null) {
                                x.w("MicroMsg.NativeBufferUtil", "processNativeBufferToJs byteBuffer is null");
                            } else {
                                dVar.setNativeBuffer(nativeBufferId, byteBuffer);
                                jSONObject.put(SlookAirButtonFrequentContactAdapter.ID, nativeBufferId);
                                nativeBufferId = i + byteBuffer.capacity();
                                jSONArray.put(jSONObject);
                                obj2 = 1;
                                value = obj2;
                                it.remove();
                                obj2 = value;
                                i = nativeBufferId;
                            }
                        }
                    }
                    jSONObject.put("base64", new String(Base64.encode(((ByteBuffer) value).array(), 2), ProtocolPackage.ServerEncoding));
                    nativeBufferId = i;
                    try {
                        jSONArray.put(jSONObject);
                        obj2 = 1;
                    } catch (JSONException e3) {
                        e = e3;
                        x.w("MicroMsg.NativeBufferUtil", "processNativeBuffer JSONException :%s", e.getMessage());
                        value = obj2;
                        it.remove();
                        obj2 = value;
                        i = nativeBufferId;
                    } catch (UnsupportedEncodingException e4) {
                        e2 = e4;
                        x.w("MicroMsg.NativeBufferUtil", "processNativeBuffer UnsupportedEncodingException :%s", e2.getMessage());
                        value = obj2;
                        it.remove();
                        obj2 = value;
                        i = nativeBufferId;
                    }
                } catch (JSONException e5) {
                    e = e5;
                    nativeBufferId = i;
                    x.w("MicroMsg.NativeBufferUtil", "processNativeBuffer JSONException :%s", e.getMessage());
                    value = obj2;
                    it.remove();
                    obj2 = value;
                    i = nativeBufferId;
                } catch (UnsupportedEncodingException e6) {
                    e2 = e6;
                    nativeBufferId = i;
                    x.w("MicroMsg.NativeBufferUtil", "processNativeBuffer UnsupportedEncodingException :%s", e2.getMessage());
                    value = obj2;
                    it.remove();
                    obj2 = value;
                    i = nativeBufferId;
                }
                value = obj2;
                it.remove();
                obj2 = value;
                i = nativeBufferId;
            }
        }
        String str2 = "MicroMsg.NativeBufferUtil";
        str = "ToJs useX5JSCore %b,bufferSize %d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(dVar != null);
        objArr[1] = Integer.valueOf(i);
        x.i(str2, str, objArr);
        if (i > appBrandSysConfig.iRV.iQH) {
            if (bVar instanceof f) {
                Map hashMap = new HashMap();
                hashMap.put("message", "convert native buffer parameter fail, event=" + bVar.getName() + ", error=native buffer exceed size limit");
                hashMap.put("stack", "");
                jVar.j("onError", new JSONObject(hashMap).toString(), 0);
            } else if (bVar instanceof e) {
                ((e) bVar).jfn = "fail convert native buffer parameter fail. native buffer exceed size limit";
            }
            return false;
        }
        if (obj2 != null) {
            map.put("__nativeBuffers__", jSONArray);
        }
        return true;
    }

    public static final boolean a(j jVar, JSONObject jSONObject, b bVar) {
        if (jVar == null || jSONObject == null) {
            return true;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("__nativeBuffers__");
        if (optJSONArray == null) {
            return true;
        }
        jSONObject.remove("__nativeBuffers__");
        int length = optJSONArray.length();
        boolean z = (bVar instanceof com.tencent.mm.plugin.appbrand.jsapi.l) && ((com.tencent.mm.plugin.appbrand.jsapi.l) bVar).jfy == Thread.currentThread();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("key");
                if (!bi.oN(optString)) {
                    int optInt = optJSONObject.optInt(SlookAirButtonFrequentContactAdapter.ID, -1);
                    if (optInt == -1) {
                        try {
                            String optString2 = optJSONObject.optString("base64", "");
                            if (bi.oN(optString2)) {
                                x.i("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs base64 is null");
                                jSONObject.put(optString, ByteBuffer.allocate(0));
                                i3 = i2;
                            } else {
                                jSONObject.put(optString, ByteBuffer.wrap(Base64.decode(optString2.getBytes(Charset.forName("UTF-8")), 2)));
                                i3 = i2;
                            }
                        } catch (JSONException e) {
                            x.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs JSONException :%s", e.getMessage());
                        }
                    } else {
                        d dVar = (d) jVar.ium.v(d.class);
                        if (dVar == null) {
                            x.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferAddon is null, not support");
                            i3 = i2;
                        } else if (!z || dVar.ael()) {
                            ByteBuffer ef = dVar.ef(optInt);
                            if (ef == null) {
                                x.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs byteBuffer is null");
                                i3 = i2;
                            } else {
                                ef.position(0);
                                jSONObject.put(optString, ef);
                                i3 = ef.capacity() + i2;
                            }
                        } else {
                            x.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferAddon sync operation not support");
                            i3 = i2;
                        }
                    }
                    i++;
                    i2 = i3;
                }
            }
            i3 = i2;
            i++;
            i2 = i3;
        }
        x.i("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferSize %d", Integer.valueOf(i2));
        if (i2 <= jVar.iuk.isS.iRV.iQH) {
            return true;
        }
        if (bVar instanceof e) {
            ((e) bVar).jfn = "fail convert native buffer parameter fail. native buffer exceed size limit";
        }
        return false;
    }
}
