package com.developerhaoz.androidbasis.weiboleaderboardalgorithm;

import java.util.Comparator;
import java.util.Map;

/**
 * 自定义的比较器
 *
 * @author Haoz
 * @date 2018/3/5.
 */
class MapValueComparator implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
        return -m1.getValue().compareTo(m2.getValue());
    }
}
