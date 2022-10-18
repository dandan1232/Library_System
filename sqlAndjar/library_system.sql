/*
 Navicat Premium Data Transfer

 Source Server         : lindandan
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : library_system

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 18/10/2022 16:13:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书编码',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书名',
  `num` int NOT NULL COMMENT '图书剩余数量',
  `times` int NOT NULL COMMENT '该图书被借阅的次数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('A001', '《社会主义平等思想与实践》', 89, 13);
INSERT INTO `book` VALUES ('A002', '《马克思主义中国化》', 91, 22);
INSERT INTO `book` VALUES ('A003', '《什么是列宁主义》', 19, 47);
INSERT INTO `book` VALUES ('A004', '《思想的浮水》', 787, 62);
INSERT INTO `book` VALUES ('A005', '《绝对亢奋》', 100, 1);
INSERT INTO `book` VALUES ('B006', '《韩非子大讲堂》', 98, 73);
INSERT INTO `book` VALUES ('B007', '《艺术哲学》', 99, 53);
INSERT INTO `book` VALUES ('B008', '《中国哲学史大纲》', 99, 77);
INSERT INTO `book` VALUES ('B009', '《道德经》', 100, 45);
INSERT INTO `book` VALUES ('B010', '《寒山寺佛学》', 100, 38);
INSERT INTO `book` VALUES ('C011', '《医学旧金山》', 99, 36);
INSERT INTO `book` VALUES ('C012', '《播音主持艺术13》', 99, 54);
INSERT INTO `book` VALUES ('C013', '《网络传播消费主义现象批判》', 100, 35);
INSERT INTO `book` VALUES ('C014', '《语言文学前沿》', 100, 78);
INSERT INTO `book` VALUES ('C015', '《跨屏传播策略研究》', 101, 72);
INSERT INTO `book` VALUES ('D016', '《入党培训教材》', 100, 35);
INSERT INTO `book` VALUES ('D017', '《实现中国梦的战略布局》', 100, 21);
INSERT INTO `book` VALUES ('D018', '《我们台湾这些年中国》', 100, 77);
INSERT INTO `book` VALUES ('D019', '《学习札记》', 99, 79);
INSERT INTO `book` VALUES ('D020', '《中国法制史》', 99, 36);
INSERT INTO `book` VALUES ('E021', '《易经》', 99, 54);
INSERT INTO `book` VALUES ('E022', '《孙子》', 99, 44);
INSERT INTO `book` VALUES ('E023', '《战争论》', 99, 36);
INSERT INTO `book` VALUES ('E024', '《海权论》', 100, 34);
INSERT INTO `book` VALUES ('E025', '《国富论》', 100, 34);
INSERT INTO `book` VALUES ('F026', '《道德情操论》', 100, 34);
INSERT INTO `book` VALUES ('F027', '《经济坐标·经济卷》', 100, 34);
INSERT INTO `book` VALUES ('F028', '《伊斯兰经济思想》', 100, 38);
INSERT INTO `book` VALUES ('F029', '《梁启超的经济面向》', 100, 78);
INSERT INTO `book` VALUES ('F030', '《大学类解》', 100, 18);
INSERT INTO `book` VALUES ('G031', '《中国传统文化经典丛书》', 100, 86);
INSERT INTO `book` VALUES ('G032', '《中国文化常识》', 100, 83);
INSERT INTO `book` VALUES ('G033', '《文化经典与文学名著导读》', 100, 88);
INSERT INTO `book` VALUES ('G034', '《传统太极拳》', 100, 69);
INSERT INTO `book` VALUES ('G035', '《资本论》', 100, 35);
INSERT INTO `book` VALUES ('H036', '《普通语言学教程》', 100, 38);
INSERT INTO `book` VALUES ('H037', '《句法结构》', 100, 45);
INSERT INTO `book` VALUES ('H038', '《语言的突破》', 100, 83);
INSERT INTO `book` VALUES ('H039', '《语言艺术全书》', 100, 64);
INSERT INTO `book` VALUES ('H040', '《清代文字狱》', 100, 53);
INSERT INTO `book` VALUES ('I041', '《家春秋》', 100, 51);
INSERT INTO `book` VALUES ('I042', '《雷雨》', 100, 35);
INSERT INTO `book` VALUES ('I043', '《莎士比亚悲剧喜剧全集》', 100, 34);
INSERT INTO `book` VALUES ('I044', '《红楼梦》', 100, 41);
INSERT INTO `book` VALUES ('I045', '《生如夏花》', 100, 35);
INSERT INTO `book` VALUES ('J046', '《艺术发展史》', 100, 87);
INSERT INTO `book` VALUES ('J047', '《西方美术教育史》', 100, 87);
INSERT INTO `book` VALUES ('J048', '《通过艺术的教育》', 100, 45);
INSERT INTO `book` VALUES ('J049', '《美学基本原则》', 100, 34);
INSERT INTO `book` VALUES ('J050', '《工艺美术概论》', 100, 24);
INSERT INTO `book` VALUES ('K051', '《万历十五年》', 100, 34);
INSERT INTO `book` VALUES ('K052', '《中国人史纲》', 100, 12);
INSERT INTO `book` VALUES ('K053', '《明朝那些事》', 100, 34);
INSERT INTO `book` VALUES ('K054', '《张居正大传》', 100, 74);
INSERT INTO `book` VALUES ('K055', '《全球通史》', 100, 24);
INSERT INTO `book` VALUES ('N056', '《宇宙发展史概论》', 100, 12);
INSERT INTO `book` VALUES ('N057', '《科学的意义》', 100, 14);
INSERT INTO `book` VALUES ('N058', '《科学理论》', 99, 41);
INSERT INTO `book` VALUES ('N059', '《疯狂实验史》', 100, 12);
INSERT INTO `book` VALUES ('N060', '《科学与方法》', 100, 45);
INSERT INTO `book` VALUES ('O061', '《AIC从入门到精通》', 100, 52);
INSERT INTO `book` VALUES ('O062', '《AIC网格划分技术实例详解》', 100, 62);
INSERT INTO `book` VALUES ('O063', '《ABAQUS有限元分析从入门到精通》', 100, 74);
INSERT INTO `book` VALUES ('O064', '《凸优化》', 100, 22);
INSERT INTO `book` VALUES ('O065', '《ABAQUS基础入门与案例精通》', 100, 86);
INSERT INTO `book` VALUES ('P066', '《时间简史》', 100, 45);
INSERT INTO `book` VALUES ('P067', '《宇宙之书》', 100, 73);
INSERT INTO `book` VALUES ('P068', '《天文学新概论》', 100, 123);
INSERT INTO `book` VALUES ('P069', '《基础天文学》', 100, 63);
INSERT INTO `book` VALUES ('P070', '《天文知识大观》', 100, 46);
INSERT INTO `book` VALUES ('Q071', '《癌症·新知：科学终结恐慌》', 100, 432);
INSERT INTO `book` VALUES ('Q072', '《上帝的手术刀：基因编辑简史》', 100, 246);
INSERT INTO `book` VALUES ('Q073', '《草木深圳·郊野篇》', 100, 46);
INSERT INTO `book` VALUES ('Q074', '《大森林》', 100, 16);
INSERT INTO `book` VALUES ('Q075', '《驱魔》', 100, 89);
INSERT INTO `book` VALUES ('R076', '《Roitt‘s essential immunology》', 100, 86);
INSERT INTO `book` VALUES ('R077', '《MRI from picture to proton》', 100, 42);
INSERT INTO `book` VALUES ('R078', '《Molecular biology of cancer》', 100, 251);
INSERT INTO `book` VALUES ('R079', '《Cognition, brain, and consciousness》', 100, 17);
INSERT INTO `book` VALUES ('R080', '《Development of the nervous system》', 100, 72);
INSERT INTO `book` VALUES ('S081', '《有机蔬菜科学用药》', 100, 75);
INSERT INTO `book` VALUES ('S082', '《植物工厂系统与实践》', 99, 82);
INSERT INTO `book` VALUES ('S083', '《有机农业》', 99, 43);
INSERT INTO `book` VALUES ('S084', '《左手刀塔，右手韶华》', 100, 59);
INSERT INTO `book` VALUES ('S085', '《智慧农业》', 99, 86);
INSERT INTO `book` VALUES ('T086', '《电镀故障手册》', 100, 52);
INSERT INTO `book` VALUES ('T087', '《FANUC数控》', 100, 21);
INSERT INTO `book` VALUES ('T088', '《VERICUT数控仿真培训教程》', 100, 44);
INSERT INTO `book` VALUES ('T089', '《密封原理应用与维护》', 100, 77);
INSERT INTO `book` VALUES ('T090', '《数控宏程度应用技术及实例精辟》', 99, 78);
INSERT INTO `book` VALUES ('U091', '《交通运输企业管理》', 100, 34);
INSERT INTO `book` VALUES ('U092', '《城市轨道交通运输设备及应用》', 100, 16);
INSERT INTO `book` VALUES ('U093', '《交通运输环境污染与控制》', 100, 21);
INSERT INTO `book` VALUES ('U094', '《交通影响评价》', 100, 37);
INSERT INTO `book` VALUES ('U095', '《道路交通管理》', 99, 16);
INSERT INTO `book` VALUES ('V096', '《中国火箭与卫星》', 100, 63);
INSERT INTO `book` VALUES ('V097', '《踏上月球》', 100, 83);
INSERT INTO `book` VALUES ('V098', '《直升机》', 100, 38);
INSERT INTO `book` VALUES ('V099', '《空间站》', 100, 16);
INSERT INTO `book` VALUES ('V100', '《航空史话》', 100, 61);
INSERT INTO `book` VALUES ('W101', '《环境科学知识》', 99, 85);
INSERT INTO `book` VALUES ('W102', '《绿色生活与环境科学》', 100, 72);
INSERT INTO `book` VALUES ('W103', '《日益重要的环境科学》', 100, 52);
INSERT INTO `book` VALUES ('W104', '《城市生态与环境》', 100, 75);
INSERT INTO `book` VALUES ('W105', '《环境哲学》', 100, 38);
INSERT INTO `book` VALUES ('Wfdsf', '《fdsf》', 151, 0);
INSERT INTO `book` VALUES ('Z106', '《生肖运程》', 100, 58);
INSERT INTO `book` VALUES ('Z107', '《观手识人》', 100, 75);
INSERT INTO `book` VALUES ('Z108', '《华西语文学刊》', 100, 41);
INSERT INTO `book` VALUES ('Z109', '《我的第一本开运书》', 99, 421);
INSERT INTO `book` VALUES ('Z110', '《血型密码全集》', 100, 41);

-- ----------------------------
-- Table structure for book_type
-- ----------------------------
DROP TABLE IF EXISTS `book_type`;
CREATE TABLE `book_type`  (
  `id` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_type
-- ----------------------------
INSERT INTO `book_type` VALUES ('A', '马列主义毛邓思想');
INSERT INTO `book_type` VALUES ('B', '哲学');
INSERT INTO `book_type` VALUES ('C', '社会科学总论');
INSERT INTO `book_type` VALUES ('D', '政治、法律');
INSERT INTO `book_type` VALUES ('E', '军事');
INSERT INTO `book_type` VALUES ('F', '经济');
INSERT INTO `book_type` VALUES ('G', '文化、科学、教育、体育');
INSERT INTO `book_type` VALUES ('H', '语言、文字');
INSERT INTO `book_type` VALUES ('I', '文学');
INSERT INTO `book_type` VALUES ('J', '艺术');
INSERT INTO `book_type` VALUES ('K', '历史、地理');
INSERT INTO `book_type` VALUES ('N', '自然科学总论');
INSERT INTO `book_type` VALUES ('O', '数理科学和化学');
INSERT INTO `book_type` VALUES ('P', '天文学、地理科学');
INSERT INTO `book_type` VALUES ('Q', '生物科学');
INSERT INTO `book_type` VALUES ('R', '医药、卫生');
INSERT INTO `book_type` VALUES ('S', '农业科学');
INSERT INTO `book_type` VALUES ('T', '工业技术');
INSERT INTO `book_type` VALUES ('U', '交通运输');
INSERT INTO `book_type` VALUES ('V', '航空、航天');
INSERT INTO `book_type` VALUES ('W', '环境科学、安全科学');
INSERT INTO `book_type` VALUES ('Z', '综合性图书');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `operate` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '无',
  `borrow_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '无',
  `return_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '无',
  `num` int NULL DEFAULT 0,
  `note` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '无'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月21日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '添加图书', 'A005', '无', '无', 100, '成功添加A005编码的图书100本');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '添加图书', 'A范德萨范德萨', '无', '无', 43234, '成功添加A范德萨范德萨编码的图书43234本');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '删除图书', 'A范德萨范德萨', '无', '无', 43234, '成功删除A范德萨范德萨编码的图书');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '删除图书', 'S范德萨范德萨发', '无', '无', 324, '成功删除S范德萨范德萨发编码的图书');
INSERT INTO `log` VALUES ('2019年06月23日', '1802343124', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '1802343124', '学生', '借阅图书', 'Z隔热隔热隔热个体个', '2019年06月23日', '无', 1, '成功借阅');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '删除图书', 'Z柔肤水大多数', '无', '无', 34324, '成功删除Z柔肤水大多数编码的图书');
INSERT INTO `log` VALUES ('2019年06月23日', '1802343124', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '1802343124', '学生', '归还图书', 'Z隔热隔热隔热个体个', '2019年06月23日', NULL, 1, '成功归还');
INSERT INTO `log` VALUES ('2019年06月23日', '1802343124', '学生', '借阅图书', 'Z隔热隔热隔热个体个', '2019年06月23日', '无', 1, '成功借阅');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '删除图书', 'Z隔热隔热隔热个体个', '无', '无', 5344, '成功删除Z隔热隔热隔热个体个编码的图书');
INSERT INTO `log` VALUES ('2019年06月23日', '1802343124', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '1802343124', '学生', '归还图书', 'Z隔热隔热隔热个体个', '2019年06月23日', NULL, 1, '成功归还');
INSERT INTO `log` VALUES ('2019年06月23日', '1802343124', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '1802343124', '学生', '归还图书', 'D016', '2019年06月18日', NULL, 1, '成功归还');
INSERT INTO `log` VALUES ('2019年06月23日', '1802343124', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '添加图书', 'A范德萨范德萨发', '无', '无', 324, '成功添加A范德萨范德萨发编码的图书324本');
INSERT INTO `log` VALUES ('2019年06月23日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '1', '学生', '借阅图书', 'A范德萨范德萨发', '2019年06月23日', '无', 1, '成功借阅');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '1', '学生', '归还图书', 'A范德萨范德萨发', '2019年06月23日', NULL, 1, '成功归还');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '删除图书', 'A范德萨范德萨发', '无', '无', 324, '成功删除A范德萨范德萨发编码的图书');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '管理员修改学生姓名', '无', '无', '无', 0, '无');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '管理员修改学生姓名', '无', '无', '无', 0, '无');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '管理员删除学生信息', '无', '无', '无', 0, '无');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '注册日志', '无', '无', '无', 0, '管理员2注册了一名新同学');
INSERT INTO `log` VALUES ('2019年06月23日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月23日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '借阅图书', 'A005', '2019年06月25日', '无', 1, '成功借阅');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '归还图书', 'A001', '2019年06月18日', NULL, 1, '成功归还');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '借阅图书', 'R079', '2019年06月25日', '无', 1, '成功借阅');
INSERT INTO `log` VALUES ('2019年06月25日', '1802343116', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '1802343116', '学生', '借阅图书', 'H036', '2019年06月25日', '无', 1, '成功借阅');
INSERT INTO `log` VALUES ('2019年06月25日', '1802343116', '学生', '归还图书', 'H036', '2019年06月25日', NULL, 1, '成功归还');
INSERT INTO `log` VALUES ('2019年06月25日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '2', '管理员', '修改图书', 'T088', '无', '无', 100, 'T088编码的图书修改后的数量为100本');
INSERT INTO `log` VALUES ('2019年06月25日', '2', '管理员', '添加图书', 'R飞的去覅偶鞥缺乏', '无', '无', 324, '成功添加R飞的去覅偶鞥缺乏编码的图书324本');
INSERT INTO `log` VALUES ('2019年06月25日', '2', '管理员', '删除图书', 'R飞的去覅偶鞥缺乏', '无', '无', 324, '成功删除R飞的去覅偶鞥缺乏编码的图书');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '归还图书', 'A002', '2019年06月16日', NULL, 1, '成功归还');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '归还图书', 'A003', '2019年06月18日', NULL, 1, '成功归还');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '归还图书', 'A004', '2019年06月18日', NULL, 1, '成功归还');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '归还图书', 'B006', '2019年06月18日', NULL, 1, '成功归还');
INSERT INTO `log` VALUES ('2019年06月25日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '2', '管理员', '修改图书', 'F028', '无', '无', 100, 'F028编码的图书修改后的数量为100本');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '借阅图书', 'A001', '2019年06月25日', '无', 1, '成功借阅');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '归还图书', 'A001', '2019年06月18日', NULL, 1, '成功归还');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '借阅图书', 'A002', '2019年06月25日', '无', 1, '成功借阅');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '借阅图书', 'A001', '2019年06月25日', '无', 1, '成功借阅');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '借阅图书', 'A003', '2019年06月25日', '无', 1, '成功借阅');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '借阅图书', 'B010', '2019年06月25日', '无', 1, '成功借阅');
INSERT INTO `log` VALUES ('2019年06月25日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月25日', '2', '管理员', '修改图书', 'B007', '无', '无', 99, 'B007编码的图书修改后的数量为99本');
INSERT INTO `log` VALUES ('2019年06月25日', '2', '管理员', '管理员修改学生姓名', '无', '无', '无', 0, '无');
INSERT INTO `log` VALUES ('2019年06月26日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月26日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月26日', '2', '管理员', '修改图书', 'A002', '无', '无', 90, 'A002编码的图书修改后的数量为90本');
INSERT INTO `log` VALUES ('2019年06月26日', '1802343124', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月26日', '1802343124', '学生', '借阅图书', 'D019', '2019年06月26日', '无', 1, '成功借阅');
INSERT INTO `log` VALUES ('2019年06月26日', '1802343124', '学生', '借阅图书', 'D020', '2019年06月26日', '无', 1, '成功借阅');
INSERT INTO `log` VALUES ('2019年06月26日', '1802343124', '学生', '借阅图书', 'E021', '2019年06月26日', '无', 1, '成功借阅');
INSERT INTO `log` VALUES ('2019年06月26日', '1802343124', '学生', '借阅图书', 'E022', '2019年06月26日', '无', 1, '成功借阅');
INSERT INTO `log` VALUES ('2019年06月26日', '1802343124', '学生', '借阅图书', 'E023', '2019年06月26日', '无', 1, '成功借阅');
INSERT INTO `log` VALUES ('2019年06月26日', '1802343124', '学生', '借阅图书', 'C011', '2019年06月26日', '无', 1, '成功借阅');
INSERT INTO `log` VALUES ('2019年06月26日', '1802343124', '学生', '借阅图书', 'C012', '2019年06月26日', '无', 1, '成功借阅');
INSERT INTO `log` VALUES ('2019年06月26日', '1802343124', '学生', '借阅图书', 'B006', '2019年06月26日', '无', 1, '成功借阅');
INSERT INTO `log` VALUES ('2019年06月26日', '1802343124', '学生', '归还图书', 'G032', '2019年06月18日', NULL, 1, '成功归还');
INSERT INTO `log` VALUES ('2019年06月26日', '1802343124', '学生', '归还图书', 'H036', '2019年06月18日', NULL, 1, '成功归还');
INSERT INTO `log` VALUES ('2019年06月26日', '1802343124', '学生', '归还图书', 'D018', '2019年06月18日', NULL, 1, '成功归还');
INSERT INTO `log` VALUES ('2019年06月26日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月26日', '2', '管理员', '添加图书', 'Agfdg', '无', '无', 645, '成功添加Agfdg编码的图书645本');
INSERT INTO `log` VALUES ('2019年06月26日', '2', '管理员', '添加图书', 'Wfdsf', '无', '无', 151, '成功添加Wfdsf编码的图书151本');
INSERT INTO `log` VALUES ('2019年06月26日', '2', '管理员', '修改图书', 'A003', '无', '无', 19, 'A003编码的图书修改后的数量为19本');
INSERT INTO `log` VALUES ('2019年06月26日', '2', '管理员', '删除图书', 'Agfdg', '无', '无', 645, '成功删除Agfdg编码的图书');
INSERT INTO `log` VALUES ('2019年06月26日', '2', '管理员', '管理员修改学生姓名', '无', '无', '无', 0, '无');
INSERT INTO `log` VALUES ('2019年06月26日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月26日', '1', '学生', '归还图书', 'A001', '2019年06月18日', NULL, 1, '成功归还');
INSERT INTO `log` VALUES ('2019年06月26日', '1', '学生', '归还图书', 'Q074', '2019年06月21日', NULL, 1, '成功归还');
INSERT INTO `log` VALUES ('2019年06月26日', '1', '学生', '归还图书', 'G033', '2019年06月21日', NULL, 1, '成功归还');
INSERT INTO `log` VALUES ('2019年06月26日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月26日', '1', '学生', '归还图书', 'A002', '2019年06月16日', NULL, 1, '成功归还');
INSERT INTO `log` VALUES ('2019年06月26日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月26日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月26日', '1', '学生', '归还图书', 'A005', '2019年06月18日', NULL, 1, '成功归还');
INSERT INTO `log` VALUES ('2019年06月26日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2019年06月26日', '1', '学生', '归还图书', 'R079', '2019年06月25日', '2019年06月26日', 1, '成功归还');
INSERT INTO `log` VALUES ('2019年06月26日', '1', '学生', '归还图书', 'B010', '2019年06月25日', '2019年06月26日', 1, '成功归还');
INSERT INTO `log` VALUES ('2019年06月26日', '2', '管理员', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2022年10月18日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');
INSERT INTO `log` VALUES ('2022年10月18日', '1', '学生', '登录日志', '无', '无', '无', 0, '正常登录');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('2', '2', '2');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `student_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `borrow_date` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `return_date` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '未还'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', 'A001', '2019年06月18日', '2019年06月26日', '已还');
INSERT INTO `record` VALUES ('1 ', 'A002', '2019年06月16日', '2019年06月26日', '已还');
INSERT INTO `record` VALUES ('1', 'A003', '2019年06月18日', '2019年06月25日', '已还');
INSERT INTO `record` VALUES ('1', 'A004', '2019年06月18日', '2019年06月25日', '已还');
INSERT INTO `record` VALUES ('1', 'A005', '2019年06月18日', '2019年06月26日', '已还');
INSERT INTO `record` VALUES ('1', 'B006', '2019年06月18日', '2019年06月25日', '已还');
INSERT INTO `record` VALUES ('1', 'B007', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1', 'B008', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1', 'C015', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1', 'D016', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1', 'D017', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1', 'D018', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1', 'D019', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1', 'D020', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1', 'E021', '2019年06月18日', '2019年06月19日', '已还');
INSERT INTO `record` VALUES ('1', 'E022', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1', 'E023', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1', 'E024', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1', 'E025', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1', 'F027', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1', 'G031', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1', 'G035', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1', 'I041', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1', 'Z108', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1', 'Z110', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1802343124', 'A001', '2019年06月18日', NULL, '未还');
INSERT INTO `record` VALUES ('1802343124', 'A002', '2019年06月18日', NULL, '未还');
INSERT INTO `record` VALUES ('1802343124', 'A005', '2019年06月18日', NULL, '未还');
INSERT INTO `record` VALUES ('1', 'A002', '2019年06月18日', '2019年06月26日', '已还');
INSERT INTO `record` VALUES ('1', 'A001', '2019年06月18日', '2019年06月26日', '已还');
INSERT INTO `record` VALUES ('1', 'A002', '2019年06月18日', '2019年06月26日', '已还');
INSERT INTO `record` VALUES ('1', 'A003', '2019年06月18日', '2019年06月25日', '已还');
INSERT INTO `record` VALUES ('1', 'A004', '2019年06月18日', '2019年06月25日', '已还');
INSERT INTO `record` VALUES ('1', 'J047', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1', 'A002', '2019年06月18日', '2019年06月26日', '已还');
INSERT INTO `record` VALUES ('1802343114', 'A001', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1802343114', 'E022', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1802343114', 'A002', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1802343114', 'A001', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1802343114', 'A003', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1802343114', 'A005', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1802343140', 'E025', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1802343114', 'A001', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1802343114', 'A004', '2019年06月18日', NULL, '未还');
INSERT INTO `record` VALUES ('1802343119', 'E023', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1802343119', 'A001', '2019年06月18日', NULL, '未还');
INSERT INTO `record` VALUES ('1802343119', 'A003', '2019年06月18日', '2019年06月18日', '已还');
INSERT INTO `record` VALUES ('1802343119', 'A004', '2019年06月18日', NULL, '未还');
INSERT INTO `record` VALUES ('1802343119', 'A005', '2019年06月18日', NULL, '未还');
INSERT INTO `record` VALUES ('1802343119', 'B006', '2019年06月18日', NULL, '未还');
INSERT INTO `record` VALUES ('1802343119', 'Z109', '2019年06月18日', NULL, '未还');
INSERT INTO `record` VALUES ('1802343119', 'B008', '2019年06月18日', NULL, '未还');
INSERT INTO `record` VALUES ('1802343124', 'A003', '2019年06月18日', NULL, '未还');
INSERT INTO `record` VALUES ('1802343124', 'B007', '2019年06月18日', NULL, '未还');
INSERT INTO `record` VALUES ('1802343124', 'N058', '2019年06月18日', NULL, '未还');
INSERT INTO `record` VALUES ('1802343124', 'G032', '2019年06月18日', '2019年06月26日', '已还');
INSERT INTO `record` VALUES ('1802343124', 'H036', '2019年06月18日', '2019年06月26日', '已还');
INSERT INTO `record` VALUES ('1802343124', 'D018', '2019年06月18日', '2019年06月26日', '已还');
INSERT INTO `record` VALUES ('1802343124', 'D016', '2019年06月18日', '2019年06月23日', '已还');
INSERT INTO `record` VALUES ('1', 'A002', '2019年06月18日', '2019年06月26日', '已还');
INSERT INTO `record` VALUES ('1802343134', 'A004', '2019年06月19日', '2019年06月19日', '已还');
INSERT INTO `record` VALUES ('1802343134', 'B006', '2019年06月19日', '2019年06月19日', '已还');
INSERT INTO `record` VALUES ('1802343134', 'D017', '2019年06月19日', '2019年06月19日', '已还');
INSERT INTO `record` VALUES ('1802343134', 'C015', '2019年06月19日', '2019年06月19日', '已还');
INSERT INTO `record` VALUES ('1802343134', 'D018', '2019年06月19日', '2019年06月19日', '已还');
INSERT INTO `record` VALUES ('1802343134', 'E024', '2019年06月19日', '2019年06月19日', '已还');
INSERT INTO `record` VALUES ('1802343134', 'Z110', '2019年06月19日', '2019年06月19日', '已还');
INSERT INTO `record` VALUES ('1802343134', 'B008', '2019年06月19日', '2019年06月19日', '已还');
INSERT INTO `record` VALUES ('1802343134', 'D016', '2019年06月19日', '2019年06月19日', '已还');
INSERT INTO `record` VALUES ('1', 'E021', '2019年06月19日', '2019年06月19日', '已还');
INSERT INTO `record` VALUES ('1', 'A001', '2019年06月20日', '2019年06月26日', '已还');
INSERT INTO `record` VALUES ('1', 'Q074', '2019年06月21日', '2019年06月26日', '已还');
INSERT INTO `record` VALUES ('1', 'G033', '2019年06月21日', '2019年06月26日', '已还');
INSERT INTO `record` VALUES ('1', 'W101', '2019年06月21日', NULL, '未还');
INSERT INTO `record` VALUES ('1', 'S082', '2019年06月21日', NULL, '未还');
INSERT INTO `record` VALUES ('1', 'A002', '2019年06月21日', '2019年06月26日', '已还');
INSERT INTO `record` VALUES ('1', 'U095', '2019年06月21日', NULL, '未还');
INSERT INTO `record` VALUES ('1', 'T090', '2019年06月21日', NULL, '未还');
INSERT INTO `record` VALUES ('1', 'H040', '2019年06月21日', '2019年06月21日', '已还');
INSERT INTO `record` VALUES ('1', 'S083', '2019年06月21日', NULL, '未还');
INSERT INTO `record` VALUES ('1', 'S084', '2019年06月21日', '2019年06月21日', '已还');
INSERT INTO `record` VALUES ('1', 'S085', '2019年06月21日', NULL, '未还');
INSERT INTO `record` VALUES ('1', 'A004', '2019年06月21日', '2019年06月25日', '已还');
INSERT INTO `record` VALUES ('1', 'B006', '2019年06月21日', '2019年06月25日', '已还');
INSERT INTO `record` VALUES ('1', 'A003', '2019年06月21日', '2019年06月25日', '已还');
INSERT INTO `record` VALUES ('1802343124', 'Z隔热隔热隔热个体个', '2019年06月23日', '2019年06月23日', '已还');
INSERT INTO `record` VALUES ('1802343124', 'Z隔热隔热隔热个体个', '2019年06月23日', '2019年06月23日', '已还');
INSERT INTO `record` VALUES ('1', 'A范德萨范德萨发', '2019年06月23日', '2019年06月23日', '已还');
INSERT INTO `record` VALUES ('1', 'A005', '2019年06月25日', '2019年06月26日', '已还');
INSERT INTO `record` VALUES ('1', 'R079', '2019年06月25日', '2019年06月26日', '已还');
INSERT INTO `record` VALUES ('1802343116', 'H036', '2019年06月25日', '2019年06月25日', '已还');
INSERT INTO `record` VALUES ('1', 'A001', '2019年06月25日', '2019年06月26日', '已还');
INSERT INTO `record` VALUES ('1', 'A002', '2019年06月25日', '2019年06月26日', '已还');
INSERT INTO `record` VALUES ('1', 'A001', '2019年06月25日', '2019年06月26日', '已还');
INSERT INTO `record` VALUES ('1', 'A003', '2019年06月25日', NULL, '未还');
INSERT INTO `record` VALUES ('1', 'B010', '2019年06月25日', '2019年06月26日', '已还');
INSERT INTO `record` VALUES ('1802343124', 'D019', '2019年06月26日', NULL, '未还');
INSERT INTO `record` VALUES ('1802343124', 'D020', '2019年06月26日', NULL, '未还');
INSERT INTO `record` VALUES ('1802343124', 'E021', '2019年06月26日', NULL, '未还');
INSERT INTO `record` VALUES ('1802343124', 'E022', '2019年06月26日', NULL, '未还');
INSERT INTO `record` VALUES ('1802343124', 'E023', '2019年06月26日', NULL, '未还');
INSERT INTO `record` VALUES ('1802343124', 'C011', '2019年06月26日', NULL, '未还');
INSERT INTO `record` VALUES ('1802343124', 'C012', '2019年06月26日', NULL, '未还');
INSERT INTO `record` VALUES ('1802343124', 'B006', '2019年06月26日', NULL, '未还');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1', '1');

SET FOREIGN_KEY_CHECKS = 1;
