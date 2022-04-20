package com.HelloToby.Consumer.pages;

import java.util.HashMap;
import java.util.Random;

public class RandomSelectPackage {

    HashMap<Integer, String> pack = new HashMap<>();

    public int randomSelectPackage() {

        Random rand = new Random();
        String[] packID = {PageConstant.Android.HCHOOPKGNEW, PageConstant.Android.HOCDPKGNEW, PageConstant.Android.HCDEPKGNEW, PageConstant.Android.HCUNPKGNEW, PageConstant.Android.HCCLPKGNEW, PageConstant.Android.HCFOPKGNEW, PageConstant.Android.HCHPCPKGNEW, PageConstant.Android.HCLAPKGNEW
                , PageConstant.Android.HCMIPKGNEW, PageConstant.Android.HCMOPKGNEW, PageConstant.Android.HCRUPKGNEW, PageConstant.Android.HQAIPKGNEW, PageConstant.Android.SMINPKGNEW};
        for (int i = 0; i < packID.length; i++) {
            pack.put(i, packID[i]);
        }
        return rand.nextInt(packID.length);
    }
}
