package b.c;

import b.c.b.e;
import b.e.b;
import b.i;
import com.tencent.tmassistantsdk.downloadservice.DownloadSetting;

public final class a {
    public static final <T> Class<T> a(b<T> bVar) {
        e.i(bVar, "$receiver");
        Class<T> cKq = ((b.c.b.b) bVar).cKq();
        if (cKq.isPrimitive()) {
            String name = cKq.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -1325958191:
                        if (name.equals("double")) {
                            cKq = Double.class;
                            break;
                        }
                        break;
                    case 104431:
                        if (name.equals("int")) {
                            cKq = Integer.class;
                            break;
                        }
                        break;
                    case 3039496:
                        if (name.equals("byte")) {
                            cKq = Byte.class;
                            break;
                        }
                        break;
                    case 3052374:
                        if (name.equals("char")) {
                            cKq = Character.class;
                            break;
                        }
                        break;
                    case 3327612:
                        if (name.equals("long")) {
                            cKq = Long.class;
                            break;
                        }
                        break;
                    case 64711720:
                        if (name.equals(DownloadSetting.TYPE_BOOLEAN)) {
                            cKq = Boolean.class;
                            break;
                        }
                        break;
                    case 97526364:
                        if (name.equals("float")) {
                            cKq = Float.class;
                            break;
                        }
                        break;
                    case 109413500:
                        if (name.equals("short")) {
                            cKq = Short.class;
                            break;
                        }
                        break;
                }
            }
            if (cKq == null) {
                throw new i("null cannot be cast to non-null type java.lang.Class<T>");
            }
        } else if (cKq == null) {
            throw new i("null cannot be cast to non-null type java.lang.Class<T>");
        }
        return cKq;
    }
}
