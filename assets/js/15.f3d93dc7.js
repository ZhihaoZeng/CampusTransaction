(window.webpackJsonp=window.webpackJsonp||[]).push([[15],{504:function(_,v,t){"use strict";t.r(v);var d=t(4),r=Object(d.a)({},(function(){var _=this,v=_.$createElement,t=_._self._c||v;return t("ContentSlotsDistributor",{attrs:{"slot-key":_.$parent.slotKey}},[t("h1",{attrs:{id:"_1-引言"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#_1-引言"}},[_._v("#")]),_._v(" 1. 引言")]),_._v(" "),t("h2",{attrs:{id:"_1-1-编写目的"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#_1-1-编写目的"}},[_._v("#")]),_._v(" 1.1 编写目的")]),_._v(" "),t("p",[_._v("本测试报告为武汉大学二手交易平台项目的测试报告, 目的在于总结测试阶段的测试以及分析测试结果, 描述系统是否符合需求. 预期参考人员包括用户、测试人员、开发人员、项目管理者、其他质量管理人员和需要阅读本报告的高层经理.")]),_._v(" "),t("h2",{attrs:{id:"_1-2-项目背景"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#_1-2-项目背景"}},[_._v("#")]),_._v(" 1.2 项目背景")]),_._v(" "),t("ol",[t("li",[_._v("项目名称: 武汉大学校园二手交易平台.")]),_._v(" "),t("li",[_._v("项目提出者: 陈炳生，高战立，马如云，曾志昊.")]),_._v(" "),t("li",[_._v("项目开发者: 陈炳生，高战立，马如云，曾志昊.")]),_._v(" "),t("li",[_._v("项目用户: 武汉大学校内师生")]),_._v(" "),t("li",[_._v("项目开发单位: 武汉大学计算机学院.")])]),_._v(" "),t("h2",{attrs:{id:"_1-3-系统简介"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#_1-3-系统简介"}},[_._v("#")]),_._v(" 1.3 系统简介")]),_._v(" "),t("p",[_._v("​\t武汉大学二手交易平台，旨在为武大师生提供一个更加方便快捷的闲置物品交易与需求交流平台，服务范围小，但是目标用户群体更加精准，功能更加集中，追求简单，便捷，贴心。在平台上，武大在校师生可以发布和预约通告，提出需求，还可在线交流，集论坛，电商，通讯于一体。")]),_._v(" "),t("h1",{attrs:{id:"_2-测试任务概述"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#_2-测试任务概述"}},[_._v("#")]),_._v(" 2. 测试任务概述")]),_._v(" "),t("h2",{attrs:{id:"_2-1-目标"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#_2-1-目标"}},[_._v("#")]),_._v(" 2.1 目标")]),_._v(" "),t("p",[_._v("本项目的需求主要有:")]),_._v(" "),t("ol",[t("li",[_._v("通告（商品，需求）发布功能：用户可以在平台上发布自己的通告，商品，也可以发布自己的需求，其他用户可以在商品详情页下进行评论和询问，可以进行预约，交易。")]),_._v(" "),t("li",[_._v("通告搜索功能：用户可以在分类页上对通告，商品和需求进行搜索，更快定位到自己想要的内容。")]),_._v(" "),t("li",[_._v("在线聊天功能：用户可以通过在线聊天的方式与卖家进行联系。")]),_._v(" "),t("li",[_._v("消息推送功能：平台实时推送消息给用户，如订阅，预约通过，收到预约等等。")])]),_._v(" "),t("h2",{attrs:{id:"_2-2-运行环境"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#_2-2-运行环境"}},[_._v("#")]),_._v(" 2.2 运行环境")]),_._v(" "),t("p",[t("strong",[_._v("数据库与连接")])]),_._v(" "),t("p",[_._v("服务器使用Mybatis-Plus和关系型数据库MySQL进行连接和操作")]),_._v(" "),t("p",[t("strong",[_._v("Web 服务器软件")])]),_._v(" "),t("p",[_._v("用户使用支持 J2EE 规范的 Web 服务器软件.")]),_._v(" "),t("p",[t("strong",[_._v("平台要求")])]),_._v(" "),t("p",[_._v("用户系统版本必须在Android 8.0及以上。")]),_._v(" "),t("h1",{attrs:{id:"_3-测试计划"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#_3-测试计划"}},[_._v("#")]),_._v(" 3. 测试计划")]),_._v(" "),t("h2",{attrs:{id:"_3-1-测试方案"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#_3-1-测试方案"}},[_._v("#")]),_._v(" 3.1 测试方案")]),_._v(" "),t("p",[_._v("采用黑盒测试的方法, 对各种功能需求逐一进行测试")]),_._v(" "),t("h2",{attrs:{id:"_3-2-测试内容"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#_3-2-测试内容"}},[_._v("#")]),_._v(" 3.2 测试内容")]),_._v(" "),t("p",[_._v("1.用户在首页查看最新通告")]),_._v(" "),t("p",[_._v("目的: 用户能刷新得最新的通告")]),_._v(" "),t("p",[_._v("内容: 用户在首页刷新")]),_._v(" "),t("p",[_._v("2.用户搜索商品")]),_._v(" "),t("p",[_._v("目的: 最新通告中不一定有用户想要找的商品")]),_._v(" "),t("p",[_._v("内容: 用户在搜索界面搜索")]),_._v(" "),t("p",[_._v("3.用户查看商品，评论")]),_._v(" "),t("p",[_._v("目的: 方便用户了解商品特性，与通告发布者交流")]),_._v(" "),t("p",[_._v("内容: 用户在商品详情界面查看和发布评论，查看商品参数和图片")]),_._v(" "),t("p",[_._v("4.用户提交修改和取消预约")]),_._v(" "),t("p",[_._v("目的: 对心仪商品(需求)的预约，以及对预约的操作")]),_._v(" "),t("p",[_._v("内容: 用户填写预约信息并提交，用户重新更新预约信息")]),_._v(" "),t("p",[_._v("5.查看消息推送")]),_._v(" "),t("p",[_._v("目的: 提醒用户最新的相关消息")]),_._v(" "),t("p",[_._v("内容: 用户通知栏实时推送最新消息")]),_._v(" "),t("p",[_._v("6.发布和结束通告")]),_._v(" "),t("p",[_._v("目的: 用户可以发布自己的商品和需求，并且进行取消，完成和删除等操作")]),_._v(" "),t("p",[_._v("内容: 用户在发布和管理界面分别进行上传信息和管理操作")]),_._v(" "),t("p",[_._v("7.在线聊天")]),_._v(" "),t("p",[_._v("目的: 方便买卖家之间的交流")]),_._v(" "),t("p",[_._v("内容: 用户在聊天窗口上可以实时发送和接收信息")]),_._v(" "),t("h2",{attrs:{id:"_3-3-测试准备"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#_3-3-测试准备"}},[_._v("#")]),_._v(" 3.3 测试准备")]),_._v(" "),t("ol",[t("li",[_._v("根据要求配置相应的测试环境")]),_._v(" "),t("li",[_._v("阅读软件规格说明书、概要设计说明书、详细设计说明书，并以此作为总的提纲;")]),_._v(" "),t("li",[_._v("选择合适的输入/输出数据;")]),_._v(" "),t("li",[_._v("编写测试用例.")])]),_._v(" "),t("h1",{attrs:{id:"_4-具体测试说明"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#_4-具体测试说明"}},[_._v("#")]),_._v(" 4.具体测试说明")]),_._v(" "),t("table",[t("thead",[t("tr",[t("th",[_._v("序号")]),_._v(" "),t("th",[_._v("功能名称")]),_._v(" "),t("th",[_._v("详细操作")]),_._v(" "),t("th",[_._v("预期效果")])])]),_._v(" "),t("tbody",[t("tr",[t("td",[_._v("1")]),_._v(" "),t("td",[_._v("用户注册")]),_._v(" "),t("td",[_._v("点击注册按钮，填写信息")]),_._v(" "),t("td",[_._v("实现用户注册")])]),_._v(" "),t("tr",[t("td",[_._v("2")]),_._v(" "),t("td",[_._v("用户登录")]),_._v(" "),t("td",[_._v("输入用户名、密码等信息")]),_._v(" "),t("td",[_._v("登录成功")])]),_._v(" "),t("tr",[t("td",[_._v("3")]),_._v(" "),t("td",[_._v("忘记密码")]),_._v(" "),t("td",[_._v("点击忘记密码，确认邮箱或手机验证码")]),_._v(" "),t("td",[_._v("实现密码重置")])]),_._v(" "),t("tr",[t("td",[_._v("4")]),_._v(" "),t("td",[_._v("最新通告")]),_._v(" "),t("td",[_._v("登录后点击首页")]),_._v(" "),t("td",[_._v("显示最新公告信息")])]),_._v(" "),t("tr",[t("td",[_._v("5")]),_._v(" "),t("td",[_._v("商品搜索")]),_._v(" "),t("td",[_._v("输入框输入商品名称进行检索")]),_._v(" "),t("td",[_._v("显示商品名模糊查找结果")])]),_._v(" "),t("tr",[t("td",[_._v("6")]),_._v(" "),t("td",[_._v("商品评论")]),_._v(" "),t("td",[_._v("商品详情界面输入评价并发布")]),_._v(" "),t("td",[_._v("评论发布成功")])]),_._v(" "),t("tr",[t("td",[_._v("7")]),_._v(" "),t("td",[_._v("评论删除")]),_._v(" "),t("td",[_._v("发布者点击删除评论")]),_._v(" "),t("td",[_._v("评论删除成功")])]),_._v(" "),t("tr",[t("td",[_._v("8")]),_._v(" "),t("td",[_._v("评论回复")]),_._v(" "),t("td",[_._v("用户回复其他用户的评价")]),_._v(" "),t("td",[_._v("评论回复成功")])]),_._v(" "),t("tr",[t("td",[_._v("9")]),_._v(" "),t("td",[_._v("商品价格区间筛选")]),_._v(" "),t("td",[_._v("检索出商品后点击价格区间按钮")]),_._v(" "),t("td",[_._v("商品会按价格区间筛选并按价格升序排列")])]),_._v(" "),t("tr",[t("td",[_._v("10")]),_._v(" "),t("td",[_._v("商品主人信誉排序")]),_._v(" "),t("td",[_._v("检索出商品后点击信誉排序按钮")]),_._v(" "),t("td",[_._v("商品会按发布者信誉降序排列")])]),_._v(" "),t("tr",[t("td",[_._v("11")]),_._v(" "),t("td",[_._v("修改商品信息")]),_._v(" "),t("td",[_._v("发布者修改商品信息")]),_._v(" "),t("td",[_._v("在进行用户验证后，更新商品信息")])]),_._v(" "),t("tr",[t("td",[_._v("12")]),_._v(" "),t("td",[_._v("发布通告")]),_._v(" "),t("td",[_._v("发布者编辑通告信息")]),_._v(" "),t("td",[_._v("完善相关信息后，成功发布公告")])]),_._v(" "),t("tr",[t("td",[_._v("13")]),_._v(" "),t("td",[_._v("发布商品")]),_._v(" "),t("td",[_._v("发布者编辑商品信息")]),_._v(" "),t("td",[_._v("在完善通告信息之后，填写商品信息，发布商品")])]),_._v(" "),t("tr",[t("td",[_._v("14")]),_._v(" "),t("td",[_._v("修改通告信息")]),_._v(" "),t("td",[_._v("发布者修改通告信息")]),_._v(" "),t("td",[_._v("在用户身份被验证的情况下，更新通告信息")])]),_._v(" "),t("tr",[t("td",[_._v("15")]),_._v(" "),t("td",[_._v("删除通告")]),_._v(" "),t("td",[_._v("发布者删除通告")]),_._v(" "),t("td",[_._v("在用户身份被验证的情况下，删除通告")])]),_._v(" "),t("tr",[t("td",[_._v("16")]),_._v(" "),t("td",[_._v("删除商品")]),_._v(" "),t("td",[_._v("发布者删除某款商品")]),_._v(" "),t("td",[_._v("在用户身份被验证的情况下，删除商品")])]),_._v(" "),t("tr",[t("td",[_._v("17")]),_._v(" "),t("td",[_._v("预约商品")]),_._v(" "),t("td",[_._v("用户在商品界面点击预约按钮")]),_._v(" "),t("td",[_._v("预约被成功添加到预约队列中")])]),_._v(" "),t("tr",[t("td",[_._v("18")]),_._v(" "),t("td",[_._v("取消预约")]),_._v(" "),t("td",[_._v("用户在个人界面点击取消预约")]),_._v(" "),t("td",[_._v("在用户身份被验证的情况下，从商品预约队列中删除该条预约")])]),_._v(" "),t("tr",[t("td",[_._v("19")]),_._v(" "),t("td",[_._v("消息推送")]),_._v(" "),t("td",[_._v("商品被预约或评论被回复")]),_._v(" "),t("td",[_._v("用户会接受到消息提醒")])]),_._v(" "),t("tr",[t("td",[_._v("20")]),_._v(" "),t("td",[_._v("查看个人信息")]),_._v(" "),t("td",[_._v("点击其他用户头像")]),_._v(" "),t("td",[_._v("页面跳转到该用户个人界面")])]),_._v(" "),t("tr",[t("td",[_._v("21")]),_._v(" "),t("td",[_._v("编辑个人信息")]),_._v(" "),t("td",[_._v("在个人信息界面修改并提交")]),_._v(" "),t("td",[_._v("在用户身份被验证的情况下，更新用户信息")])]),_._v(" "),t("tr",[t("td",[_._v("22")]),_._v(" "),t("td",[_._v("查看预约记录")]),_._v(" "),t("td",[_._v("点击我的预约按钮")]),_._v(" "),t("td",[_._v("显示用户预约记录")])]),_._v(" "),t("tr",[t("td",[_._v("23")]),_._v(" "),t("td",[_._v("查看被预约记录")]),_._v(" "),t("td",[_._v("点击我的发布按钮")]),_._v(" "),t("td",[_._v("系统跳转到我的发布界面并显示发布的商品被预约的情况")])]),_._v(" "),t("tr",[t("td",[_._v("24")]),_._v(" "),t("td",[_._v("在线聊天")]),_._v(" "),t("td",[_._v("点击发送消息按钮")]),_._v(" "),t("td",[_._v("在双方达成预约意向的情况下，进入聊天界面")])]),_._v(" "),t("tr",[t("td",[_._v("25")]),_._v(" "),t("td",[_._v("类型筛选")]),_._v(" "),t("td",[_._v("点击各个类型描述按钮")]),_._v(" "),t("td",[_._v("跳转到对应类型商品的界面")])]),_._v(" "),t("tr",[t("td",[_._v("26")]),_._v(" "),t("td",[_._v("退出登录")]),_._v(" "),t("td",[_._v("点击退出按钮")]),_._v(" "),t("td",[_._v("退出登录")])])])]),_._v(" "),t("h1",{attrs:{id:"_5-评价"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#_5-评价"}},[_._v("#")]),_._v(" 5.评价")]),_._v(" "),t("h2",{attrs:{id:"_5-1-测试结果及缺陷分析"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#_5-1-测试结果及缺陷分析"}},[_._v("#")]),_._v(" 5.1 测试结果及缺陷分析")]),_._v(" "),t("p",[_._v("1.当商品界面评论数比较多时，评论内容的排布可能有点混乱，不太美观；\n2.商品信息的发布是在通告界面完成的，即使用户发布的商品较少，也要通过通告界面，增加了用户发布的负担。")]),_._v(" "),t("h2",{attrs:{id:"_5-2-测试结论"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#_5-2-测试结论"}},[_._v("#")]),_._v(" 5.2 测试结论")]),_._v(" "),t("p",[_._v("除上述缺陷外, 系统的各项功能均能正常运行, 响应时间均＜1秒, 界面显示的结果均正确, 系统的总体完成度较高, 建议可以通过验收.")])])}),[],!1,null,null,null);v.default=r.exports}}]);