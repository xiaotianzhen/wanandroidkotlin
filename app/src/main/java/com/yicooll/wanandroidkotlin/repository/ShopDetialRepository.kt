package com.yicooll.wanandroidkotlin.repository

import android.arch.lifecycle.MutableLiveData
import com.yicooll.wanandroidkotlin.entity.ModelGoodsComment
import com.yicooll.wanandroidkotlin.entity.ModelGoodsInfo

class ShopDetialRepository {


    private var goodsInfoLiveData = MutableLiveData<ModelGoodsInfo>()
    private var recommendLiveData = MutableLiveData<List<List<ModelGoodsInfo>>>()
    private var commentLiveData = MutableLiveData<List<ModelGoodsComment>>()

    init {
        getGoodsInfo()
        getRecommendList()
        getCommentList()
    }

    fun getCommentLiveData(): MutableLiveData<List<ModelGoodsComment>> {
        return commentLiveData
    }


    fun getRecommendLiveData(): MutableLiveData<List<List<ModelGoodsInfo>>> {
        return recommendLiveData
    }

    fun getGoodsInfoLiveData(): MutableLiveData<ModelGoodsInfo> {
        return goodsInfoLiveData
    }

    /**
     * 评论
     */
    fun getCommentList() {

        val commentList = ArrayList<ModelGoodsComment>()
        val data1 = ModelGoodsComment("http://i10.hoopchina.com.cn/hupuapp/bbs/966/16313966/thread_16313966_20180726164538_s_65949_o_w1024_h1024_62044.jpg?x-oss-process=image/resize,w_800/format,jpg",
                "噶***蛋", "手机到了刚弄好，非常流畅", 5f)
        commentList.add(data1)
        val data2 = ModelGoodsComment("https://img4.duitang.com/uploads/item/201602/01/20160201111345_4kvQA.jpeg",
                "王***想", "最重要的还是手机，各种操作都很流畅信号各方面都没有问题，谢谢！", 2f)
        commentList.add(data2)
        val data3 = ModelGoodsComment("https://img4.duitang.com/uploads/item/201601/16/20160116161347_svH5y.thumb.224_0.jpeg",
                "阿***蛋", "物流速度很给力，同时店家也很有耐心客服也很有责任心各种操作都很流畅信号各方面都没有问题，谢谢！", 3f)
        commentList.add(data3)
        val data4 = ModelGoodsComment("http://img1.touxiang.cn/uploads/20130927/27-020608_93.jpg",
                "P***去", "雷总果然强大，谢谢！", 1f)
        commentList.add(data4)
        val data5 = ModelGoodsComment("http://imgsrc.baidu.com/imgad/pic/item/ca1349540923dd54afaa0d4bdb09b3de9c82483c.jpg",
                "补***萨", "雷总果然强大，家里好多电器都是小米的", 3f)
        commentList.add(data5)
        commentLiveData.value = commentList
    }


    /**
     * 推荐商品
     */
    fun getRecommendList() {

        val recommendList1 = ArrayList<ModelGoodsInfo>()
        val recommendList2 = ArrayList<ModelGoodsInfo>()
        val recommendGropList = ArrayList<List<ModelGoodsInfo>>()
        val data1 = ModelGoodsInfo("1", "小米（MI） 小米mix3 手机 黑色 全网通6G RAM 128G ROM ", "https://img14.360buyimg.com/n0/jfs/t1/8925/38/4406/349935/5bdad9b1Eb8638a99/0c7c764b234e0c02.jpg",
                "4699", "8888", "", "", "", 0, false, null)
        recommendList1.add(data1)
        val data2 = ModelGoodsInfo("1", "小米（MI） 送豪礼 Mix3手机 全面屏 黑色 8G+256G ", "https://img14.360buyimg.com/n0/jfs/t1/8996/26/2402/124002/5bd27d42E7c3950db/f51f482b3c0a50e6.jpg",
                "4699", "8888", "", "", "", 0, false, null)
        recommendList1.add(data2)
        val data3 = ModelGoodsInfo("1", "小米（MI） MIX2S 全面屏手机 游戏手机 白 全网通(6G+128G)", "https://img14.360buyimg.com/n0/jfs/t1/8996/26/2402/124002/5bd27d42E7c3950db/f51f482b3c0a50e6.jpg",
                "5688", "10001", "", "", "", 0, false, null)
        recommendList2.add(data3)
        val data4 = ModelGoodsInfo("1", "小米（MI） 小米 MIX2 手机s 黑色 全网通（6G+64G）", "https://img14.360buyimg.com/n0/jfs/t26539/294/374934442/170031/37ad9714/5b8f9d4eN5455c30c.jpg",
                "2049", "3333", "", "", "", 0, false, null)
        recommendList2.add(data4)

        recommendGropList.add(recommendList1)
        recommendGropList.add(recommendList2)

        recommendLiveData.value = recommendGropList
    }

    /**
     * 商品详情
     */
    fun getGoodsInfo() {
        //造伪数据
        var goodsImags = ArrayList<String>()
        goodsImags.add("https://img14.360buyimg.com/n0/jfs/t1/1867/31/11716/401006/5bd072f8E6db292ab/f3610e2e816ade0f.jpg")
        goodsImags.add("https://img14.360buyimg.com/n0/jfs/t1/2695/31/11550/73677/5bd072f8E7a7372dc/0a3da61ccc9e3762.jpg")
        goodsImags.add("https://img14.360buyimg.com/n0/jfs/t1/708/33/12050/20042/5bd072f9E6702c378/3d2b5d137aea371a.jpg")
        var data = ModelGoodsInfo("1", "小米Mix3 6GB+128GB黑色 骁龙845 全网通4G 双卡双待 全面屏拍照游戏智能手机", "https://img14.360buyimg.com/n0/jfs/t1/1768/16/11748/360528/5bd072f8E06e4e532/b5d152da8a5dd0dc.jpg",
                "39990", "9999", "1", "97.8%", "999", 0, false, goodsImags)
        goodsInfoLiveData.value = data
    }
}