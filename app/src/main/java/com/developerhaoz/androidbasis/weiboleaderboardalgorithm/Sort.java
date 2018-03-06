package com.developerhaoz.androidbasis.weiboleaderboardalgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 对抽样后微博的数据进行排序
 *
 * 时间复杂度为：O(nlogn),空间复杂度为: O(n)
 *
 * @author Haoz
 * @date 2018/3/5.
 */
public class Sort {

    private Sort(){}

    public static void sort(Map<String,Integer> map){
        Map<String, Integer> resultMap = sortMapByValue(map);
        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    /**
     * 使用 Map 按 value 进行排序
     * @return
     */
    public static Map<String, Integer> sortMapByValue(Map<String, Integer> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(
                oriMap.entrySet());
        Collections.sort(entryList, new MapValueComparator());

        Iterator<Map.Entry<String, Integer>> iter = entryList.iterator();
        Map.Entry<String, Integer> tmpEntry = null;
        for (int i = 0; i < 10 && iter.hasNext(); i++) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
    }
}