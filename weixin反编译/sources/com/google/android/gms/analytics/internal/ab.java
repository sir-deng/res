package com.google.android.gms.analytics.internal;

import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

abstract class ab<T extends aa> extends n {
    a<T> aHe;

    public interface a<U extends aa> {
        void e(String str, boolean z);

        void k(String str, int i);

        void l(String str, String str2);

        U nu();
    }

    public ab(q qVar, a<T> aVar) {
        super(qVar);
        this.aHe = aVar;
    }

    private T a(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String toLowerCase = xmlResourceParser.getName().toLowerCase();
                    Object attributeValue;
                    Object trim;
                    if (toLowerCase.equals("screenname")) {
                        CharSequence attributeValue2 = xmlResourceParser.getAttributeValue(null, "name");
                        CharSequence trim2 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue2)) {
                            TextUtils.isEmpty(trim2);
                        }
                    } else if (toLowerCase.equals("string")) {
                        attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        String trim3 = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || trim3 == null)) {
                            this.aHe.l(attributeValue, trim3);
                        }
                    } else if (toLowerCase.equals("bool")) {
                        attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || TextUtils.isEmpty(trim))) {
                            try {
                                this.aHe.e(attributeValue, Boolean.parseBoolean(trim));
                            } catch (NumberFormatException e) {
                                c("Error parsing bool configuration value", trim, e);
                            }
                        }
                    } else if (toLowerCase.equals("integer")) {
                        attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || TextUtils.isEmpty(trim))) {
                            try {
                                this.aHe.k(attributeValue, Integer.parseInt(trim));
                            } catch (NumberFormatException e2) {
                                c("Error parsing int configuration value", trim, e2);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e3) {
            f("Error parsing tracker configuration file", e3);
        } catch (IOException e4) {
            f("Error parsing tracker configuration file", e4);
        }
        return this.aHe.nu();
    }

    public final T db(int i) {
        try {
            return a(this.aFo.aFV.getResources().getXml(i));
        } catch (NotFoundException e) {
            e("inflate() called with unknown resourceId", e);
            return null;
        }
    }
}
