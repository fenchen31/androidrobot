# androidrobot
                                             Android启动界面机器人（自定义view）
效果图：![Image text](https://github.com/fenchen31/picture/blob/master/AndroidRobot.jpg) 
      或者直接目录 app/src/main/res/androidrobot.jpg
                v1.0版本
1.canvas的绘制
2.canvas的平移和旋转（注意倒序和canvas状态的保存和恢复问题）

不足：在绘制过程中都是直接使用大小，比如300等，这导致了在屏幕尺寸或者控件尺寸不够大时会
    出现部分显示问题，在后续的版本中会在获取控件宽高然后进行一定比例压缩的绘制
