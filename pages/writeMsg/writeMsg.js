// pages/writeMsg/writeMsg.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    
  },  
  bindFormSubmit:function(e) {
    var that = this;
    var bindFormData = e.detail.value;
    // wx.navigateTo({
    //   url: '/pages/compre/compre',
    // })
    wx.navigateBack()
    wx.request({
      url: 'http://localhost:8082/miniPro/superadmin/addmsg',
      method: 'POST',
      data: JSON.stringify(bindFormData),
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log(res.data)//打印到控制台
        var toastText = "秘密发表成功"
        if (res.data.addMsgSuc != true) {
          toastText = '秘密发表失败';
        }
        wx.showToast({
            title: toastText,
            icon: '',
            duration: 2000
        });
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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

  }
})