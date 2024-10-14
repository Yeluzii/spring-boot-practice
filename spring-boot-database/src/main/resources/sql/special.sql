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

 Date: 12/10/2024 18:59:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for special
-- ----------------------------
DROP TABLE IF EXISTS `special`;
CREATE TABLE `special`  (
  `id` bigint(0) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `view_count` int(0) NULL DEFAULT NULL,
  `followers_count` int(0) NULL DEFAULT NULL,
  `is_following` tinyint(1) NULL DEFAULT NULL,
  `banner_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `updated` bigint(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of special
-- ----------------------------
INSERT INTO `special` VALUES (1735694700215025664, '龙腾九州 福满京华', '', 17764671, 85, 0, 'https://pic2.zhimg.com/100/v2-2c6f40ee00546ec179f3a078fee98995_hd.png', 1726287986);
INSERT INTO `special` VALUES (1747379177022484480, '筑梦现代化 共绘新图景', '', 44108511, 533, 0, 'https://pic3.zhimg.com/100/v2-177d867d2f8a6c524c435c1293a6c7ea_hd.png', 1724753501);
INSERT INTO `special` VALUES (1755552296522809344, '知乎上的四川', '知乎上的四川', 30237988, 128, 0, 'https://pic1.zhimg.com/100/v2-a7556006256fbd78267bf95de518ead8_hd.png', 1722321518);
INSERT INTO `special` VALUES (1758812756265066496, '2024清明节丨忆满九州 情思华夏', '', 797781, 47, 0, 'https://pic2.zhimg.com/100/v2-ef880640d6c7dd84befcab4722320c79_hd.png', 1722321518);
INSERT INTO `special` VALUES (1765812015929524224, 'E企跟党走 阅读悦生活', '', 55855878, 164, 0, 'https://pic1.zhimg.com/100/v2-a70b5383623368eed1d2ab446562ca00_hd.png', 1724123692);
INSERT INTO `special` VALUES (1774845716361523202, '互联保苗丨网络防护从我做起', '', 52072501, 72, 0, 'https://pic1.zhimg.com/100/v2-2683e036b2a863a98d37f07047dc8540_hd.png', 1712128162);
INSERT INTO `special` VALUES (1782373709593477120, '网络中国节·端午丨和满中华 奋进九州', '', 3797699, 18, 0, 'https://pic1.zhimg.com/100/v2-6ff5545fcb222801b52304375f780030_hd.png', 1716456607);
INSERT INTO `special` VALUES (1795139218252623872, '共建和谐亲子关系，助力儿童健康成长', '和谐亲子关系有哪些特征？如何有效沟通建立和谐亲子关系？暑期来临，全国妇联社联中心联合知乎围绕“共建和谐亲子关系，助力儿童健康成长”这一主题，邀请相关领域专家行家联动女性社会组织开展交流分享，凝聚社会力量关爱服务儿童，共建和谐家庭。一起来参加吧~', 546162, 82, 0, 'https://pic3.zhimg.com/100/v2-94bc803b7ab6e0e9447630064aad4c6e_hd.png', 1710126826);
INSERT INTO `special` VALUES (1811814552964317187, '2024中国网络文明大会', '', 6686299, 6, 0, 'https://pic3.zhimg.com/100/v2-ac34582ace91462c3452d452f85fd1e6_hd.png', 1725443941);
INSERT INTO `special` VALUES (1814297848247885824, '2024国家网络安全宣传周', '2024年国家网络安全宣传周以「网络安全为人民，网络安全靠人民」为主题，将举办开幕式、网络安全技术高峰论坛主论坛暨粤港澳大湾区网络安全大会、网络安全博览会，集中发布一系列网络安全领域重要成果。同时将举行校园日、电信日、法治日、金融日、青少年日、个人信息保护日等系列主题日活动。', 1418386, 43, 0, 'https://pic2.zhimg.com/100/v2-4cb676ecfc24da42feb6f8dba7d4c0d9_hd.png', 1725443941);

SET FOREIGN_KEY_CHECKS = 1;
