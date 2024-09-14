/*
 Navicat Premium Data Transfer

 Source Server         : yyy
 Source Server Type    : MySQL
 Source Server Version : 90000
 Source Host           : localhost:3306
 Source Schema         : spring_boot

 Target Server Type    : MySQL
 Target Server Version : 90000
 File Encoding         : 65001

 Date: 14/09/2024 20:05:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for list
-- ----------------------------
DROP TABLE IF EXISTS `list`;
CREATE TABLE `list`  (
  `view_count` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `followers_count` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `is_following` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `banner` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `updated` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of list
-- ----------------------------
INSERT INTO `list` VALUES ('432149', '88', 'TRUE', '家人防跌倒指南', '伴随人口老龄化的加剧，有一个健康风险问题不容忽视：老年人失足跌倒的风险在逐步增加！据世界卫生组织发布的报告显示，全球每年有30多万人死于跌倒，其中60岁以上人群占一半以上。为了帮助家庭更好地预防老年人跌倒，在重阳节来临之际，知乎联合中国人口福利基金会、健康中国共同推出专题「家人防跌倒指南」。该专题通过科普、问答、互动等形式，向家庭成员介绍老年人防跌倒的相关知识和技巧。', 'https://pic4.zhimg.com/100/v2-3b82bba0d23dfb817767ebc22aece0c7_hd.png', '1698030956', '1696122791642906625');
INSERT INTO `list` VALUES ('6448092', '166', 'FALSE', '大道互通', NULL, 'https://pic4.zhimg.com/100/v2-f88fee47a83257a17fadb575dcff830b_hd.png', '1697685173', '1696227344438833152');
INSERT INTO `list` VALUES ('19178821', '135', 'TRUE', '2023丨孝满中华 德润人心', NULL, 'https://pic4.zhimg.com/100/v2-c46dcd563369f48d3226801d878efddb_hd.png', '1697599547', '1697567442224775168');
INSERT INTO `list` VALUES ('39128323', '790', 'TRUE', '品好书｜读懂优秀文化', NULL, 'https://pic3.zhimg.com/100/v2-a29c52831db46bff1d425012a3511446_hd.png', '1698672097', '1700933764044173312');
INSERT INTO `list` VALUES ('244138504', '42', 'FALSE', '向科学要答案', '该专题由北京宣传文化引导基金资助，围绕科技创新重点产业领域科技创新需求，开展广泛讨论，展现北京建设具有全球影响力的科技创新中心的生动实践。', 'https://pic3.zhimg.com/100/v2-62e6250c565a270e76fa6f37ef52d326_hd.png', '1713250204', '1713143889211383808');
INSERT INTO `list` VALUES ('535', '118', 'TRUE', '大咖聊网安', NULL, 'https://pic2.zhimg.com/100/v2-264c0641465123df00873b5ce64f9539_hd.png', '1701424282', '1713612084858806274');
INSERT INTO `list` VALUES ('323696302', '158', 'FALSE', '见证丨改革开放45周年', NULL, 'https://pic1.zhimg.com/100/v2-9eab849ba36d4a6eb496ee0662be3a64_hd.png', '1702620480', '1717590279350284288');
INSERT INTO `list` VALUES ('1532866', '75', 'TRUE', '2024丨元旦快乐', NULL, 'https://pic3.zhimg.com/100/v2-0400467a50c4da522c7d46ff051d830a_hd.png', '1704067304', '1722667261330825216');
INSERT INTO `list` VALUES ('43227722', '124', 'FALSE', '‘京•彩’新征程之经济展望', NULL, 'https://pic3.zhimg.com/100/v2-1f666d7156738412641fde754527a572_hd.png', '1706607879', '1728132030431174656');
INSERT INTO `list` VALUES ('3424815', '45', 'FALSE', '聚焦2024河南两会', NULL, 'https://pic3.zhimg.com/100/v2-f5683e85a229582bdfa3a46f8221a82e_hd.png', '1706421034', '1734281263714783232');
INSERT INTO `list` VALUES ('17761970', '84', 'TRUE', '龙腾九州 福满京华', NULL, 'https://pic2.zhimg.com/100/v2-2c6f40ee00546ec179f3a078fee98995_hd.png', '1725443941', '1735694700215025664');
INSERT INTO `list` VALUES ('43949913', '533', 'FALSE', '筑梦现代化 共绘新图景', NULL, 'https://pic3.zhimg.com/100/v2-177d867d2f8a6c524c435c1293a6c7ea_hd.png', '1710126826', '1747379177022484480');
INSERT INTO `list` VALUES ('26105592', '124', 'TRUE', '知乎上的四川', '知乎上的四川', 'https://pic1.zhimg.com/100/v2-a7556006256fbd78267bf95de518ead8_hd.png', '1716456607', '1755552296522809344');
INSERT INTO `list` VALUES ('797032', '47', 'FALSE', '2024清明节丨忆满九州 情思华夏', NULL, 'https://pic2.zhimg.com/100/v2-ef880640d6c7dd84befcab4722320c79_hd.png', '1712128162', '1758812756265066496');
INSERT INTO `list` VALUES ('55124274', '157', 'FALSE', 'E企跟党走 阅读悦生活', NULL, 'https://pic1.zhimg.com/100/v2-a70b5383623368eed1d2ab446562ca00_hd.png', '1713842500', '1765812015929524224');
INSERT INTO `list` VALUES ('52052989', '71', 'TRUE', '互联保苗丨网络防护从我做起', NULL, 'https://pic1.zhimg.com/100/v2-2683e036b2a863a98d37f07047dc8540_hd.png', '1724123692', '1774845716361523202');
INSERT INTO `list` VALUES ('3795275', '18', 'TRUE', '网络中国节·端午丨和满中华 奋进九州', NULL, 'https://pic1.zhimg.com/100/v2-6ff5545fcb222801b52304375f780030_hd.png', '1717732197', '1782373709593477120');
INSERT INTO `list` VALUES ('542003', '77', 'TRUE', '共建和谐亲子关系，助力儿童健康成长', '和谐亲子关系有哪些特征？如何有效沟通建立和谐亲子关系？暑期来临，全国妇联社联中心联合知乎围绕“共建和谐亲子关系，助力儿童健康成长”这一主题，邀请相关领域专家行家联动女性社会组织开展交流分享，凝聚社会力量关爱服务儿童，共建和谐家庭。一起来参加吧~', 'https://pic3.zhimg.com/100/v2-94bc803b7ab6e0e9447630064aad4c6e_hd.png', '1722321518', '1795139218252623872');
INSERT INTO `list` VALUES ('6660145', '4', 'FALSE', '2024中国网络文明大会', NULL, 'https://pic3.zhimg.com/100/v2-ac34582ace91462c3452d452f85fd1e6_hd.png', '1724753501', '1811814552964317187');
INSERT INTO `list` VALUES ('1411390', '27', 'TRUE', '2024国家网络安全宣传周', '2024年国家网络安全宣传周以「网络安全为人民，网络安全靠人民」为主题，将举办开幕式、网络安全技术高峰论坛主论坛暨粤港澳大湾区网络安全大会、网络安全博览会，集中发布一系列网络安全领域重要成果。同时将举行校园日、电信日、法治日、金融日、青少年日、个人信息保护日等系列主题日活动。', 'https://pic2.zhimg.com/100/v2-4cb676ecfc24da42feb6f8dba7d4c0d9_hd.png', '1726287986', '1814297848247885824');

SET FOREIGN_KEY_CHECKS = 1;
