package c.t.m.g;

import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class aa {
    public JSONObject a;

    final class a {
        public String a;
        public boolean b = true;
        public boolean c = false;
        public boolean d = false;
        public boolean e = false;
        public boolean f = false;
        public boolean g = false;
        private String[] h;

        public a(String str, int i, String str2, String str3, String str4, String str5) {
            this.a = str;
            String[] split = str.split("-");
            if (split.length < 5) {
                this.h = new String[]{"all", "all", "all", "all", "all"};
                for (int i2 = 0; i2 < split.length; i2++) {
                    this.h[i2] = split[i2];
                }
            } else {
                this.h = split;
            }
            this.c = a(0, String.valueOf(i));
            this.d = a(1, str2);
            this.e = a(2, str3);
            this.f = a(3, str4);
            this.g = a(4, str5);
            this.h = null;
        }

        private boolean a(int i, String str) {
            if (this.h.length < i + 1) {
                return false;
            }
            boolean equals = this.h[i].equals(str);
            if (equals || this.h[i].equals("all")) {
                return equals;
            }
            this.b = false;
            return equals;
        }
    }

    public final synchronized String a() {
        return this.a == null ? "" : this.a.toString();
    }

    public final synchronized String a(String str, int i, String str2, String str3, String str4, String str5) {
        String str6;
        if (this.a == null || TextUtils.isEmpty(str)) {
            str6 = "";
        } else {
            JSONObject optJSONObject = this.a.optJSONObject(SlookAirButtonFrequentContactAdapter.DATA);
            if (optJSONObject == null) {
                str6 = "";
            } else {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(str);
                if (optJSONObject2 == null) {
                    str6 = "";
                } else {
                    a aVar;
                    List arrayList = new ArrayList();
                    Iterator keys = optJSONObject2.keys();
                    while (keys.hasNext()) {
                        String str7 = (String) keys.next();
                        if (!TextUtils.isEmpty(str7)) {
                            if (str7.equals("deviceid")) {
                                str6 = optJSONObject2.optString("deviceid");
                                break;
                            }
                            aVar = new a(str7, i, str2, str3, str4, str5);
                            if (aVar.b) {
                                arrayList.add(aVar);
                            }
                        }
                    }
                    if (arrayList.size() == 0) {
                        str6 = "";
                    } else if (arrayList.size() == 1) {
                        str6 = optJSONObject2.optString(((a) arrayList.get(0)).a);
                    } else {
                        a aVar2;
                        aVar = (a) arrayList.get(0);
                        int i2 = 1;
                        while (true) {
                            int i3 = i2;
                            aVar2 = aVar;
                            if (i3 >= arrayList.size()) {
                                break;
                            }
                            boolean z;
                            aVar = (a) arrayList.get(i3);
                            if (aVar2.b) {
                                if (aVar.c != aVar2.c) {
                                    z = aVar.c;
                                } else if (aVar.d != aVar2.d) {
                                    z = aVar.d;
                                } else if (aVar.e != aVar2.e) {
                                    z = aVar.e;
                                } else if (aVar.f != aVar2.f) {
                                    z = aVar.f;
                                } else if (aVar.g != aVar2.g) {
                                    z = aVar.g;
                                }
                                if (z) {
                                    aVar = aVar2;
                                }
                                i2 = i3 + 1;
                            }
                            z = true;
                            if (z) {
                                aVar = aVar2;
                            }
                            i2 = i3 + 1;
                        }
                        str6 = optJSONObject2.optString(aVar2.a);
                    }
                }
            }
        }
        return str6;
    }

    public final synchronized void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (this.a == null) {
                    this.a = jSONObject;
                } else {
                    JSONObject optJSONObject = jSONObject.optJSONObject(SlookAirButtonFrequentContactAdapter.DATA);
                    CharSequence optString = jSONObject.optString("version");
                    if (!(optJSONObject == null || TextUtils.isEmpty(optString))) {
                        JSONObject optJSONObject2 = this.a.optJSONObject(SlookAirButtonFrequentContactAdapter.DATA);
                        if (optJSONObject2 == null) {
                            this.a.putOpt(SlookAirButtonFrequentContactAdapter.DATA, optJSONObject);
                        } else {
                            Iterator keys = optJSONObject.keys();
                            while (keys.hasNext()) {
                                String str2 = (String) keys.next();
                                if (!TextUtils.isEmpty(str2)) {
                                    JSONObject optJSONObject3 = optJSONObject.optJSONObject(str2);
                                    if (optJSONObject3 != null) {
                                        optJSONObject2.putOpt(str2, optJSONObject3);
                                    }
                                }
                            }
                        }
                        this.a.put("version", optString);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    public final synchronized void b() {
        this.a = null;
    }

    public final synchronized String c() {
        return this.a != null ? this.a.optString("version") : "";
    }
}
