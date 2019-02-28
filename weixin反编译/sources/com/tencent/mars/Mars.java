package com.tencent.mars;

import android.content.Context;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Arrays;

public class Mars {
    private static volatile boolean hasInitialized = false;
    private static ArrayList<String[]> libModules = new ArrayList();

    public static void loadDefaultMarsLibrary() {
        try {
            System.loadLibrary("stlport_shared");
        } catch (Throwable th) {
        }
    }

    public static synchronized void checkLoadedModules(ArrayList<String> arrayList, String str) {
        synchronized (Mars.class) {
            if (arrayList != null) {
                Object obj = new String[0];
                x.i(str, "loaded modules: " + Arrays.toString(arrayList.toArray(obj)));
                Arrays.sort(obj);
                libModules.add(obj);
                int i = 0;
                Object obj2 = 1;
                while (i < libModules.size()) {
                    if (Arrays.equals((Object[]) libModules.get(i), (Object[]) libModules.get(0))) {
                        obj = obj2;
                    } else {
                        obj = null;
                    }
                    i++;
                    obj2 = obj;
                }
                if (obj2 == null) {
                    for (i = 0; i < libModules.size(); i++) {
                        int i2 = i + 1;
                        while (true) {
                            int i3 = i2;
                            if (i3 < libModules.size()) {
                                if (hasInterSection((String[]) libModules.get(i), (String[]) libModules.get(i3))) {
                                    obj2 = null;
                                } else {
                                    obj2 = 1;
                                }
                                if (obj2 == null) {
                                    break;
                                }
                                i2 = i3 + 1;
                            } else {
                                break;
                            }
                        }
                        if (obj2 == null) {
                            break;
                        }
                    }
                }
                if (obj2 == null) {
                    throw new IllegalStateException("mars lib module custom made error, pls check your *.so.");
                }
            }
        }
    }

    public static void init(Context context, ag agVar) {
        PlatformComm.init(context, agVar);
        hasInitialized = true;
    }

    public static void onCreate(boolean z) {
        if (z && hasInitialized) {
            BaseEvent.onCreate();
        } else if (z) {
            throw new IllegalStateException("function MarsCore.init must be executed before Mars.onCreate when application firststartup.");
        } else {
            BaseEvent.onCreate();
        }
    }

    public static void onDestroy() {
        BaseEvent.onDestroy();
    }

    private static boolean hasInterSection(String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (Object add : strArr) {
            arrayList.add(add);
        }
        for (Object add2 : strArr2) {
            if (arrayList.contains(add2)) {
                return true;
            }
        }
        return false;
    }
}
