/*
package com.leonard.bigdata.Demo;

import kafka.serializer.StringDecoder;
import org.apache.log4j.lf5.viewer.configure.ConfigurationManager;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaPairInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;
import scala.Tuple2;

import java.util.*;

*/
/**
 * @Description
 * @Author wanghc
 * @Date 2019/3/21 9:38
 *//*

public class SparkStreamAd {

    public static void main(String[] args) {
        // 构建Spark Streaming上下文
        SparkConf conf = new SparkConf()
                .setMaster("local[2]")
                .setAppName("AdClickRealTimeStatSpark")
                .set("spark.streaming.receiver.writeAheadLog.enable", "true");

        // spark streaming的上下文是构建JavaStreamingContext对象
        // 而不是像之前的JavaSparkContext、SQLContext/HiveContext
        // 传入的第一个参数，和之前的spark上下文一样，也是SparkConf对象；第二个参数则不太一样

        // 第二个参数是spark streaming类型作业比较有特色的一个参数
        // 实时处理batch的interval
        // spark streaming，每隔一小段时间，会去收集一次数据源（kafka）中的数据，做成一个batch
        // 每次都是处理一个batch中的数据

        // 通常来说，batch interval，就是指每隔多少时间收集一次数据源中的数据，然后进行处理
        // 一遍spark streaming的应用，都是设置数秒到数十秒（很少会超过1分钟）

        // 咱们这里项目中，就设置5秒钟的batch interval
        // 每隔5秒钟，咱们的spark streaming作业就会收集最近5秒内的数据源接收过来的数据
        JavaStreamingContext jssc = new JavaStreamingContext(
                conf, Durations.seconds(5));
        jssc.checkpoint("hdfs://192.168.1.105:9000/streaming_checkpoint");

        // 正式开始进行代码的编写
        // 实现咱们需要的实时计算的业务逻辑和功能

        // 创建针对Kafka数据来源的输入DStream（离线流，代表了一个源源不断的数据来源，抽象）
        // 选用kafka direct api（很多好处，包括自己内部自适应调整每次接收数据量的特性，等等）

        // 构建kafka参数map
        // 主要要放置的就是，你要连接的kafka集群的地址（broker集群的地址列表）
        Map<String, String> kafkaParams = new HashMap<String, String>();
        kafkaParams.put("metadata.broker.list",
                ConfigurationManager.getProperty(Constants.KAFKA_METADATA_BROKER_LIST));

        // 构建topic set
        String kafkaTopics = ConfigurationManager.getProperty(Constants.KAFKA_TOPICS);
        String[] kafkaTopicsSplited = kafkaTopics.split(",");

        Set<String> topics = new HashSet<String>();
        for (String kafkaTopic : kafkaTopicsSplited) {
            topics.add(kafkaTopic);
        }

        // 基于kafka direct api模式，构建出了针对kafka集群中指定topic的输入DStream
        // 两个值，val1，val2；val1没有什么特殊的意义；val2中包含了kafka topic中的一条一条的实时日志数据
        JavaPairInputDStream<String, String> adRealTimeLogDStream = KafkaUtils.createDirectStream(
                jssc,
                String.class,
                String.class,
                StringDecoder.class,
                StringDecoder.class,
                kafkaParams,
                topics);

//      adRealTimeLogDStream.repartition(1000);

        // 根据动态黑名单进行数据过滤
        JavaPairDStream<String, String> filteredAdRealTimeLogDStream = filterByBlacklist(adRealTimeLogDStream);

        // 生成动态黑名单
        generateDynamicBlacklist(filteredAdRealTimeLogDStream);

        // 业务功能一：计算广告点击流量实时统计结果（yyyyMMdd_province_city_adid,clickCount）
        // 最粗
        JavaPairDStream<String, Long> adRealTimeStatDStream = calculateRealTimeStat(
                filteredAdRealTimeLogDStream);

        // 业务功能二：实时统计每天每个省份top3热门广告
        // 统计的稍微细一些了
        calculateProvinceTop3Ad(adRealTimeStatDStream);

        // 业务功能三：实时统计每天每个广告在最近1小时的滑动窗口内的点击趋势（每分钟的点击量）
        // 统计的非常细了
        // 我们每次都可以看到每个广告，最近一小时内，每分钟的点击量
        // 每支广告的点击趋势
        calculateAdClickCountByWindow(adRealTimeLogDStream);

        try {
            // 构建完spark streaming上下文之后，记得要进行上下文的启动、等待执行结束、关闭
            jssc.start();
            jssc.awaitTermination();
            jssc.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    */
/**
     * 计算广告点击流量实时统计
     *
     * @param filteredAdRealTimeLogDStream
     * @return
     *//*

    private static JavaPairDStream<String, Long> calculateRealTimeStat(
            JavaPairDStream<String, String> filteredAdRealTimeLogDStream) {
        // 业务逻辑一
        // 广告点击流量实时统计
        // 上面的黑名单实际上是广告类的实时系统中，比较常见的一种基础的应用
        // 实际上，我们要实现的业务功能，不是黑名单

        // 计算每天各省各城市各广告的点击量
        // 这份数据，实时不断地更新到mysql中的，J2EE系统，是提供实时报表给用户查看的
        // j2ee系统每隔几秒钟，就从mysql中搂一次最新数据，每次都可能不一样
        // 设计出来几个维度：日期、省份、城市、广告
        // j2ee系统就可以非常的灵活
        // 用户可以看到，实时的数据，比如2015-11-01，历史数据
        // 2015-12-01，当天，可以看到当天所有的实时数据（动态改变），比如江苏省南京市
        // 广告可以进行选择（广告主、广告名称、广告类型来筛选一个出来）
        // 拿着date、province、city、adid，去mysql中查询最新的数据
        // 等等，基于这几个维度，以及这份动态改变的数据，是可以实现比较灵活的广告点击流量查看的功能的

        // date province city userid adid
        // date_province_city_adid，作为key；1作为value
        // 通过spark，直接统计出来全局的点击次数，在spark集群中保留一份；在mysql中，也保留一份
        // 我们要对原始数据进行map，映射成<date_province_city_adid,1>格式
        // 然后呢，对上述格式的数据，执行updateStateByKey算子
        // spark streaming特有的一种算子，在spark集群内存中，维护一份key的全局状态
        JavaPairDStream<String, Long> mappedDStream = filteredAdRealTimeLogDStream.mapToPair(

                new PairFunction<Tuple2<String, String>, String, Long>() {

                    private static final long serialVersionUID = 1L;

                    @Override
                    public Tuple2<String, Long> call(Tuple2<String, String> tuple)
                            throws Exception {
                        String log = tuple._2;
                        String[] logSplited = log.split(" ");

                        String timestamp = logSplited[0];
                        Date date = new Date(Long.valueOf(timestamp));
                        String datekey = DateUtils.formatDateKey(date); // yyyyMMdd

                        String province = logSplited[1];
                        String city = logSplited[2];
                        long adid = Long.valueOf(logSplited[4]);

                        String key = datekey + "_" + province + "_" + city + "_" + adid;

                        return new Tuple2<String, Long>(key, 1L);
                    }

                });

        // 在这个dstream中，就相当于，有每个batch rdd累加的各个key（各天各省份各城市各广告的点击次数）
        // 每次计算出最新的值，就在aggregatedDStream中的每个batch rdd中反应出来
        JavaPairDStream<String, Long> aggregatedDStream = mappedDStream.updateStateByKey(

                new Function2<List<Long>, Optional<Long>, Optional<Long>>() {

                    private static final long serialVersionUID = 1L;

                    @Override
                    public Optional<Long> call(List<Long> values, Optional<Long> optional)
                            throws Exception {
                        // 举例来说
                        // 对于每个key，都会调用一次这个方法
                        // 比如key是<20151201_Jiangsu_Nanjing_10001,1>，就会来调用一次这个方法7
                        // 10个

                        // values，(1,1,1,1,1,1,1,1,1,1)

                        // 首先根据optional判断，之前这个key，是否有对应的状态
                        long clickCount = 0L;

                        // 如果说，之前是存在这个状态的，那么就以之前的状态作为起点，进行值的累加
                        if (optional.isPresent()) {
                            clickCount = optional.get();
                        }

                        // values，代表了，batch rdd中，每个key对应的所有的值
                        for (Long value : values) {
                            clickCount += value;
                        }

                        return Optional.of(clickCount);
                    }

                });

        // 将计算出来的最新结果，同步一份到mysql中，以便于j2ee系统使用
        aggregatedDStream.foreachRDD(new Function<JavaPairRDD<String, Long>, Void>() {

            private static final long serialVersionUID = 1L;

            @Override
            public Void call(JavaPairRDD<String, Long> rdd) throws Exception {

                rdd.foreachPartition(new VoidFunction<Iterator<Tuple2<String, Long>>>() {

                    private static final long serialVersionUID = 1L;

                    @Override
                    public void call(Iterator<Tuple2<String, Long>> iterator)
                            throws Exception {
                        List<AdStat> adStats = new ArrayList<AdStat>();

                        while (iterator.hasNext()) {
                            Tuple2<String, Long> tuple = iterator.next();

                            String[] keySplited = tuple._1.split("_");
                            String date = keySplited[0];
                            String province = keySplited[1];
                            String city = keySplited[2];
                            long adid = Long.valueOf(keySplited[3]);

                            long clickCount = tuple._2;

                            AdStat adStat = new AdStat();
                            adStat.setDate(date);
                            adStat.setProvince(province);
                            adStat.setCity(city);
                            adStat.setAdid(adid);
                            adStat.setClickCount(clickCount);

                            adStats.add(adStat);
                        }

                        IAdStatDAO adStatDAO = DAOFactory.getAdStatDAO();
                        adStatDAO.updateBatch(adStats);
                    }

                });

                return null;
            }

        });

        return aggregatedDStream;
    }
}
*/
