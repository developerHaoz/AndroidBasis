package com.developerhaoz.androidbasis.weiboleaderboardalgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 实现微博的事件热度实时排行榜
 *
 * 算法思路：
 *
 * 1、首先微博的数量的非常庞大的，直接将数据完全导入到内存中的做法不现实。最终想出两种做法
 *
 * a、如果采用分段排序的方法，先对微博的数据进行分割，然后将比较少的数据进行排序，
 * 最后再对各个部分排前的数据进行一次排序。
 *
 * b、因为事件的样本太大，所以对样本进行抽样，可以按时间段来决定抽样率，越接近现在，抽样率越高
 *
 * 最终采用 b 方案，决定采用抽样的方式来实现。
 *
 *
 * 2、因为要统计事件的热度，所以得采取一个标准对某个事件热度进行排序，我采用的是
 * 热度 = 转发数 + 评论数 的一个标准。最终得到一个 Map<String, Long>，key 代表事件的名字
 * value 代表热度。
 *
 *
 * 3、最后对 Map<String, key> 进行排序
 *
 * @author Haoz
 * @date 2018/3/5.
 */
public class WeiboLeaderboardAlgorithm {

    public static void main(String[] args) {
        /**
         * 使用的样本代码
         */
        List<Weibo> weiboList = new ArrayList<>();
        List<Weibo> sampleWeiboList = sample(0.001, 0.0001, 0.00001, weiboList);
        Map sampleWeiboMap = toWeiboMap(sampleWeiboList);
        Sort.sort(sampleWeiboMap);
    }

    /**
     * 实时数据的话，统计比较久远的数据意义不大，所以只抽取一天内的微博数据
     * 对微博的数据根据时间进行抽样，按照一分钟内、一小时内和一天内三个数量级对微博的
     * 数据进行抽样。
     * <p>
     * 因为微博的数据都是实时插入的，所以这里默认 List<Weibo> 是已经按照时间排序好的
     *
     * @param minuteProportion 一分钟内的抽样比例
     * @param hourProportion   一小时内的抽样比例
     * @param dayProportion    一天内的抽样比例
     * @param weibos           原始的微博数据
     * @return 抽样后返回的数据
     */
    private static List<Weibo> sample(double minuteProportion, double hourProportion, double dayProportion, List<Weibo> weibos) {
        List<Weibo> resultList = new ArrayList<>();
        long currentTime = System.currentTimeMillis();
        long weiboNum = weibos.size();
        int minute = 60;
        int hour = 60 * 60;
        /**
         * 抽样范围：一分钟内：minutePositionStart 到 minutePositionEnd
         * 一小时内： hourPositionStart 到 hourPositionEnd
         * 一天内：0 到 weiboNum - 1
         */
        long minutePositionStart = binSearch(weibos, currentTime - 60);
        long minutePositionEnd = binSearch(weibos, currentTime + 60);
        long hourPositionStart = binSearch(weibos, currentTime - 3600);
        long hourPositionEnd = binSearch(weibos, currentTime + 3600);

        long minNum = (long) ((minutePositionEnd - minutePositionStart) * minuteProportion);
        long hourNum = (long) ((hourPositionEnd - hourPositionStart) * hourProportion);
        long dayNum = (long) ((weiboNum - 1) * dayProportion);

        for (int i = 0; i < minNum; i++) {
            resultList.add(weibos.get((int) (getRandom(minutePositionStart, minutePositionEnd))));
        }

        for (int j = 0; j < hourNum; j++) {
            resultList.add(weibos.get((int) (getRandom(hourPositionStart, hourPositionEnd))));
        }

        for (int k = 0; k < dayNum; k++) {
            resultList.add(weibos.get((int) (getRandom(0, weiboNum - 1))));
        }
        return resultList;
    }

    /**
     * 二分查找算法
     *
     * @param weibos
     * @param key
     * @return
     */
    public static int binSearch(List<Weibo> weibos, long key) {
        int mid;
        int start = 0;
        int end = weibos.size() - 1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (key < weibos.get(mid).getHeat()) {
                end = mid - 1;
            } else if (key > weibos.get(mid).getHeat()) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 获取指定范围的随机数
     *
     * @param min 最小值
     * @param max 最大值
     * @return 指定范围的随机数
     */
    private static long getRandom(long min, long max) {
        Random random = new Random();
        return random.nextInt((int) max) % (max - min + 1) + min;
    }

    /**
     * 将包含微博实体类的 List 转换成 Map
     *
     * @param weiboList 包含微博实体类的 List
     * @return 包含微博实体类的 Map
     */
    private static Map<String, Long> toWeiboMap(List<Weibo> weiboList){
        Map<String,Long> resultMap = new HashMap<>();
        for (Weibo weibo : weiboList) {
            resultMap.put(weibo.getContent(), weibo.getHeat());
        }
        return resultMap;
    }

}
