//logs.js
const app = getApp();
var inputVal = '';
var msgList = [];
var windowWidth = wx.getSystemInfoSync().windowWidth;
var windowHeight = wx.getSystemInfoSync().windowHeight;
var keyHeight = 0;
var question = '';
var content ='';
var that = this;
/**
 * 初始化数据
 */
function initData(that) {
  inputVal = '';

  msgList = [{
      speaker: 'server',
      contentType: 'text',
      content: '你好呀！欢迎来到小程序简钰，希望你每天都能开开心心地~'
    }
  ]
  that.setData({
    msgList,
    inputVal
  })
}

Page({

  /**
   * 页面的初始数据
   */
  data: {
    scrollHeight: '100vh',
    inputBottom: 0,
    userInfo:{},
  },


  giveResponse: function (that,question){
    wx.request({
      url: app.globalData.URL + question,
      success:res=>{
        if(res.data.code == 200){
          that.setData({
            content:res.data.newslist[0].reply
          })
        }else{
          that.setData({
            content:res.data.msg
          })
        }
        console.log(this.data.content);
        msgList.push({
          speaker: 'server',
          contentType: 'text',
          content: this.data.content
        });
        console.log(this.data.content),
        that.setData({
          msgList: msgList
        });
      },
      fail:res=>{
        console.log(err)
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    initData(this);
    this.setData({
      userInfo: app.globalData.userInfo,
    });
  },
  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 获取聚焦
   */
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

  //失去聚焦(软键盘消失)
  blur: function(e) {
    this.setData({
      scrollHeight: '100vh',
      inputBottom: 0
    })
    this.setData({
      toView: 'msg-' + (msgList.length - 1)
    })

  },

  /**
   * 发送点击监听
   */
  sendClick: function(e){
    msgList.push({
      speaker: 'customer',
      contentType: 'text',
      content: e.detail.value
    });
    inputVal = '';
    question = e.detail.value;
    this.setData({
      msgList,
      inputVal
    });
    console.log(question)

    this.giveResponse(this,question)
  },

  /**
   * 退回上一页
   */
  toBackClick: function() {
    wx.navigateBack({})
  }

})