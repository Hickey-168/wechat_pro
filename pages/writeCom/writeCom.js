// pages/writeCom.js
var inputVal = '';
var windowWidth = wx.getSystemInfoSync().windowWidth;
var windowHeight = wx.getSystemInfoSync().windowHeight;
var keyHeight = 0;
var commentlist = [];

Page({

  /**
   * 页面的初始数据
   */
  data: {
    scrollHeight: '100vh',
    inputBottom: 0,
    value:'更多秘密',
 
    hideFlag: true,//true-隐藏  false-显示
    animationData: {},//
    message:'test',
    mid: undefined//留言id
  },

  //点击选项1
  getOption1:function(){
    wx.navigateTo({
      url: '../compre/compre',
    })
  },
  //点击选项2
  getOption2:function(){
    wx.showToast({
      title: '感谢您的反馈！',
      icon:'success',
      duration:1500
    })
  },
  //取消
  mCancel: function () {
    var that = this;
    that.hideModal();
  },

   // ----------------------------------------------------------------------modal
  // 显示遮罩层
  showModal: function () {
    var that = this;
    that.setData({
      hideFlag: false
    })
    // 创建动画实例
    var animation = wx.createAnimation({
      duration: 400,//动画的持续时间
      timingFunction: 'ease',//动画的效果 默认值是linear->匀速，ease->动画以低速开始，然后加快，在结束前变慢
    })
    this.animation = animation; //将animation变量赋值给当前动画
    var time1 = setTimeout(function () {
      that.slideIn();//调用动画--滑入
      clearTimeout(time1);
      time1 = null;
    }, 100)
  },
 
  // 隐藏遮罩层
  hideModal: function () {
    var that = this;
    var animation = wx.createAnimation({
      duration: 400,//动画的持续时间 默认400ms
      timingFunction: 'ease',//动画的效果 默认值是linear
    })
    this.animation = animation
    that.slideDown();//调用动画--滑出
    var time1 = setTimeout(function () {
      that.setData({
        hideFlag: true
      })
      clearTimeout(time1);
      time1 = null;
    }, 220)//先执行下滑动画，再隐藏模块
    
  },
  //动画 -- 滑入
  slideIn: function () {
    this.animation.translateY(0).step() // 在y轴偏移，然后用step()完成一个动画
    this.setData({
      //动画实例的export方法导出动画数据传递给组件的animation属性
      animationData: this.animation.export()
    })
  },
  //动画 -- 滑出
  slideDown: function () {
    this.animation.translateY(300).step()
    this.setData({
      animationData: this.animation.export(),
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (e) {
    var that = this;
    that.setData({
      mid: e.mid,
      message: e.message
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    var that = this;
    wx.request({
      url: getApp().globalData.myurl + '/getmsgcomment',
      method: 'GET',
      header: {
        'content-type': 'application/json' // 默认值
      },
      data:{
        "mid": that.data.mid
      },
      success: function(res) {
        console.log(res.data)//打印到控制台
        var list = res.data.msgCommentList;
        if(list == null) {
          var toastText = '获取数据失败' + res.data.errMsg;
          wx.showToast({
            title: toastText,
            icon:'',
            duration: 2000
          });
        } else {
          that.setData({
            commentlist: list
          });
        };
      }
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  focus: function(e) {
    keyHeight = e.detail.height;
    this.setData({
      scrollHeight: (windowHeight - keyHeight) + 'px'
    });
    this.setData({
      toView: 'msg-' + (msgList.length - 1),
      inputBottom: keyHeight + 'px'
    })
    //计算msg高度
    // calScrollHeight(this, keyHeight);

  },

  blur: function(e) {
    this.setData({
      scrollHeight: '100vh',
      inputBottom: 0
    })
    this.setData({
      toView: 'msg-' + (msgList.length - 1)
    })

  },

  sendClick: function(e){
    var that = this;
    inputVal ='';
    this.setData({
      inputVal,
    });
    var commentdemo = ({
      "mid": that.data.mid,
      "comment": e.detail.value
    })
    that.data.commentlist.push(commentdemo);
    this.setData({
      commentlist:that.data.commentlist
    })
    var comment = e.detail.value;
    wx.request({
      url: getApp().globalData.myurl + '/addcomment',
      method: 'POST',
      data: {
        "comment": JSON.stringify(comment),
        "mid": that.data.mid
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log(res.data)//打印到控制台
        var toastText = "评论发表成功"
        if (res.data.addCommentSuc != true) {
          toastText = '评论发表失败';
        }
        wx.showToast({
            title: toastText,
            icon: '',
            duration: 2000
        });
      }
    })
  },
})