package com.tencent.mapsdk.rastercore.tile.b;

import com.tencent.mapsdk.rastercore.b;
import com.tencent.wcdb.FileUtils;
import java.net.MalformedURLException;
import java.net.URL;

public final class e extends a {
    private String[] a = new String[]{"https://m0.map.gtimg.com/hwap", "https://m1.map.gtimg.com/hwap", "https://m2.map.gtimg.com/hwap", "https://m3.map.gtimg.com/hwap"};

    public e(int i) {
        super(i);
    }

    public final URL getTileUrl(int i, int i2, int i3, Object... objArr) {
        boolean parseBoolean;
        int i4;
        Object obj;
        String str;
        int i5;
        String str2;
        boolean z;
        int a;
        int pow;
        StringBuilder stringBuilder;
        StringBuffer stringBuffer;
        int i6 = b.a;
        boolean z2 = false;
        Object obj2 = null;
        if (objArr != null) {
            String str3;
            try {
                if (objArr.length > 0) {
                    i6 = Integer.parseInt(objArr[0].toString());
                    if (objArr.length == 3) {
                        String obj3 = objArr[1].toString();
                        try {
                            str3 = obj3;
                            parseBoolean = Boolean.parseBoolean(objArr[2].toString());
                            i4 = i6;
                            obj = null;
                            str = str3;
                        } catch (Exception e) {
                            str3 = obj3;
                            i5 = i6;
                            str2 = str3;
                            str3 = str2;
                            obj = null;
                            str = str3;
                            z = z2;
                            i4 = i5;
                            parseBoolean = z;
                            a = a.a(i + i2, this.a.length);
                            pow = (int) ((Math.pow(2.0d, (double) i3) - ((double) i2)) - 1.0d);
                            stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
                            stringBuilder.append(this.a[a]);
                            stringBuilder.append("?");
                            stringBuilder.append("z=");
                            stringBuilder.append(i3 - 1);
                            stringBuilder.append("&x=");
                            stringBuilder.append(i);
                            stringBuilder.append("&y=");
                            stringBuilder.append(pow);
                            stringBuilder.append("&styleid=");
                            if (obj == null) {
                                stringBuilder.append(7);
                            } else {
                                stringBuilder.append(com.tencent.mapsdk.rastercore.d.e.y());
                            }
                            stringBuilder.append("&version=");
                            stringBuilder.append(i4);
                            stringBuffer = new StringBuffer(stringBuilder.toString());
                            if (parseBoolean) {
                                stringBuffer.append("&md5=").append(str);
                            }
                            return new URL(stringBuffer.toString());
                        }
                        a = a.a(i + i2, this.a.length);
                        pow = (int) ((Math.pow(2.0d, (double) i3) - ((double) i2)) - 1.0d);
                        stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
                        stringBuilder.append(this.a[a]);
                        stringBuilder.append("?");
                        stringBuilder.append("z=");
                        stringBuilder.append(i3 - 1);
                        stringBuilder.append("&x=");
                        stringBuilder.append(i);
                        stringBuilder.append("&y=");
                        stringBuilder.append(pow);
                        stringBuilder.append("&styleid=");
                        if (obj == null) {
                            stringBuilder.append(7);
                        } else {
                            stringBuilder.append(com.tencent.mapsdk.rastercore.d.e.y());
                        }
                        stringBuilder.append("&version=");
                        stringBuilder.append(i4);
                        stringBuffer = new StringBuffer(stringBuilder.toString());
                        if (parseBoolean) {
                            stringBuffer.append("&md5=").append(str);
                        }
                        return new URL(stringBuffer.toString());
                    } else if (objArr.length == 2) {
                        obj2 = 7 == Integer.parseInt(objArr[1].toString()) ? 1 : null;
                    }
                }
            } catch (Exception e2) {
                i5 = i6;
                str2 = null;
                str3 = str2;
                obj = null;
                str = str3;
                z = z2;
                i4 = i5;
                parseBoolean = z;
                a = a.a(i + i2, this.a.length);
                pow = (int) ((Math.pow(2.0d, (double) i3) - ((double) i2)) - 1.0d);
                stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
                stringBuilder.append(this.a[a]);
                stringBuilder.append("?");
                stringBuilder.append("z=");
                stringBuilder.append(i3 - 1);
                stringBuilder.append("&x=");
                stringBuilder.append(i);
                stringBuilder.append("&y=");
                stringBuilder.append(pow);
                stringBuilder.append("&styleid=");
                if (obj == null) {
                    stringBuilder.append(com.tencent.mapsdk.rastercore.d.e.y());
                } else {
                    stringBuilder.append(7);
                }
                stringBuilder.append("&version=");
                stringBuilder.append(i4);
                stringBuffer = new StringBuffer(stringBuilder.toString());
                if (parseBoolean) {
                    stringBuffer.append("&md5=").append(str);
                }
                return new URL(stringBuffer.toString());
            }
        }
        parseBoolean = z2;
        i4 = i6;
        obj = obj2;
        str = null;
        try {
            a = a.a(i + i2, this.a.length);
            pow = (int) ((Math.pow(2.0d, (double) i3) - ((double) i2)) - 1.0d);
            stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
            stringBuilder.append(this.a[a]);
            stringBuilder.append("?");
            stringBuilder.append("z=");
            stringBuilder.append(i3 - 1);
            stringBuilder.append("&x=");
            stringBuilder.append(i);
            stringBuilder.append("&y=");
            stringBuilder.append(pow);
            stringBuilder.append("&styleid=");
            if (obj == null) {
                stringBuilder.append(com.tencent.mapsdk.rastercore.d.e.y());
            } else {
                stringBuilder.append(7);
            }
            stringBuilder.append("&version=");
            stringBuilder.append(i4);
            stringBuffer = new StringBuffer(stringBuilder.toString());
            if (parseBoolean) {
                stringBuffer.append("&md5=").append(str);
            }
            return new URL(stringBuffer.toString());
        } catch (MalformedURLException e3) {
            new StringBuilder("Error new URL with str:").append(null);
            return null;
        }
    }
}
