/*
 Navicat Premium Data Transfer

 Source Server         : zgf
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : fruitburning

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 08/01/2024 21:09:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for consumerback
-- ----------------------------
DROP TABLE IF EXISTS `consumerback`;
CREATE TABLE `consumerback`  (
  `c_id` int(11) NULL DEFAULT NULL COMMENT '主键',
  `s_id` int(11) NULL DEFAULT NULL COMMENT '门店编号 门店外键',
  `o_id` int(11) NULL DEFAULT NULL COMMENT '订单编号 订单外键',
  `c_num` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '退货单编号',
  `fruit_id` int(11) NULL DEFAULT NULL COMMENT '水果编号 水果表外键',
  `fruitname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果名称',
  `number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '数量',
  `unitprice` decimal(64, 16) NULL DEFAULT NULL COMMENT '单价',
  `money` decimal(64, 16) NULL DEFAULT NULL COMMENT '退款金额',
  `time` datetime NULL DEFAULT NULL COMMENT '退货时间',
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_status` int(11) NULL DEFAULT 1
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '消费者退货单 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consumerback
-- ----------------------------

-- ----------------------------
-- Table structure for doororder
-- ----------------------------
DROP TABLE IF EXISTS `doororder`;
CREATE TABLE `doororder`  (
  `o_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `s_id` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '门店编号 门店外键',
  `o_num` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单编号 订单编号',
  `money` decimal(64, 2) NULL DEFAULT NULL COMMENT '总金额 订单总金额',
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_status` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`o_id`) USING BTREE,
  UNIQUE INDEX `o_num`(`o_num` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 59 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '门店顶单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doororder
-- ----------------------------
INSERT INTO `doororder` VALUES (1, '12345678910', '202312270900401968', 40.14, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (2, '12345678910', '202312270914277230', 31.56, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (3, '123456789', '202312271731075047', 455.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (4, '123456789', '202312271732205284', 479.50, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (5, '4', '202312271742548908', 260.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (6, '5', '202312271743096792', 269.80, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (7, '3', '202312271743449586', 309.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (8, '8', '202312271744191728', 374.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (9, '6', '202312271744238124', 374.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (10, '1', '202312271744244867', 374.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (11, '4', '202312271744241409', 374.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (12, '8', '202312271744245950', 374.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (13, '9', '202312271801304742', 219.50, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (14, '3', '202312281801304731', 222.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (15, '4', '202312281025598652', 390.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (16, '7', '202312281408244799', 559.20, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (17, '3', '202312281408534131', 0.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (18, '6', '202312281409174370', 9.80, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (19, '8', '202312281738485394', 2166645.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (20, '7', '202312281742078077', 10111010.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (21, '7', '202312281742374569', 10111010.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (22, '2', '202312281742383937', 10111010.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (23, '7', '202312281746248500', 117.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (24, '7', '202312281746259969', 117.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (25, '7', '202312281746268107', 117.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (26, '2', '202312281750285183', 0.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (27, '2', '202312291924374407', 0.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (28, '99', '202401020914115828', 0.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (29, '99', '202401020923519599', 0.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (30, '99', '202401020925221763', 0.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (31, '99', '202401020925515586', 0.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (32, '99', '202401020928391382', 0.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (33, '99', '202401020930567998', 0.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (34, '99', '202401020934173883', 0.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (35, '99', '202401020940187129', 0.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (36, '99', '202401020949526591', 0.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (37, '99', '202401020954286386', 0.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (38, '99', '202401021022032510', 0.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (39, '99', '202401021046505428', 0.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (40, '110001', '202401021108077732', 0.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (41, '99', '202401021120475738', NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (42, '99', '202401021120511238', NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (43, '110001', '202401021140051288', 0.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (44, '110001', '202401021534485272', 0.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (45, '110001', '202401021654571926', 63.60, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (46, '206', '202401032035398440', 24.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (47, '206', '202401041712028840', 24.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (48, '206', '202401041737024137', 24.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (49, '206', '202401041741582559', 24.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (50, '206', '202401041746126133', 24.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (51, '206', '202401041919457372', 24.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (52, '206', '202401041921402876', 24.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (53, '206', '202401041941231089', 24.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (54, '206', '202401042024006947', 24.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (55, '206', '202401042033543909', 700.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (56, '206', '202401051527229543', 36.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (57, '206', '202401051532322937', 36.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (58, '206', '202401061149064806', 158.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `doororder` VALUES (59, '206', '202401061458319148', 72.00, NULL, NULL, NULL, NULL, NULL, 1);

-- ----------------------------
-- Table structure for fruit_price
-- ----------------------------
DROP TABLE IF EXISTS `fruit_price`;
CREATE TABLE `fruit_price`  (
  `p_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果编号',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果名称',
  `maxprice` decimal(32, 2) NULL DEFAULT NULL COMMENT '最大金额',
  `price` decimal(32, 2) NULL DEFAULT NULL COMMENT '零售价',
  `zhekou` decimal(4, 2) NULL DEFAULT NULL COMMENT '折扣',
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`p_id`) USING BTREE,
  UNIQUE INDEX `code`(`code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '水果价格表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fruit_price
-- ----------------------------
INSERT INTO `fruit_price` VALUES (1, '001001', '东方红苹果', 120.00, 120.00, 0.50, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruit_price` VALUES (2, '005001', NULL, 0.75, 0.75, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruit_price` VALUES (3, '001002', '嘎啦苹果', 9.80, 9.80, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruit_price` VALUES (6, '001007', NULL, 0.80, 0.80, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruit_price` VALUES (7, '004002', '云南小米蕉', 2.13, 1.07, 0.50, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruit_price` VALUES (8, '002003', '压砂瓜', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruit_price` VALUES (9, '004001', '帝王蕉', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruit_price` VALUES (10, '003002', '名晶草莓', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruit_price` VALUES (11, '002004', '甘美西瓜', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruit_price` VALUES (13, '001003', '水晶富士', 65.00, 65.00, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruit_price` VALUES (14, '003001', '香草莓', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruit_price` VALUES (17, '001005', '花牛苹果', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for fruits
-- ----------------------------
DROP TABLE IF EXISTS `fruits`;
CREATE TABLE `fruits`  (
  `fruit_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `fruitTypes_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果种类表外键',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果编号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果名称',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果图片',
  `is_status` int(10) UNSIGNED NULL DEFAULT 1 COMMENT '状态',
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`fruit_id`) USING BTREE,
  UNIQUE INDEX `code`(`code` ASC) USING BTREE,
  INDEX `fruitTypes_id`(`fruitTypes_id` ASC) USING BTREE,
  CONSTRAINT `fruits_ibfk_1` FOREIGN KEY (`fruitTypes_id`) REFERENCES `fruittypes` (`code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '水果表 水果' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fruits
-- ----------------------------
INSERT INTO `fruits` VALUES (1, '100101', '001001', '东方红苹果', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (2, '100101', '001002', '嘎啦苹果', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (3, '100101', '001003', '水晶富士', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (4, '100101', '001004', '阿克苏苹果', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (5, '100101', '001005', '花牛苹果', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (6, '100101', '001006', '金帅苹果', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (7, '100101', '001007', '乐其苹果', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (8, '100102', '002001', '麒麟瓜', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (9, '100102', '002003', '压砂瓜', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (10, '100102', '002004', '甘美西瓜', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (11, '100102', '002005', '花皮有籽瓜', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (12, '100102', '002006', '黑美人西瓜', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (13, '100102', '002007', '黄瓤西瓜', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (14, '100103', '003001', '香草莓', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (15, '100103', '003002', '名晶草莓', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (16, '100103', '003003', '丹东草莓', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (17, '100103', '003004', '红宝玉草莓', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (18, '100103', '003005', '章吉草莓', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (20, '100104', '004001', '帝王蕉', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (21, '100105', '005001', '金美人', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (22, '100101', '001008', '蛇果', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (23, '100105', '005002', '网纹蜜瓜', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (24, '100105', '005003', '东方密一号', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (25, '100105', '005004', '新疆吐鲁番哈密瓜', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (26, '100104', '004002', '云南小米蕉', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (27, '100104', '004003', '云南威尼斯香蕉', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (28, '100104', '004004', '高山甜香蕉', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (29, '100104', '004005', '红皮香蕉', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (30, '100104', '004006', '佳农香蕉', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (31, '100104', '004007', '香蕉干', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (32, '100104', '004008', '海南香蕉', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (33, '100104', '004009', '海南香蕉', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (34, '100104', '004010', '云南高山香蕉', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/%E5%8D%83%E4%B8%8E%E5%8D%83%E5%AF%BB%E8%83%8C%E6%99%AF%E5%9B%BE.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (35, '100104', '009009', '芭蕉', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/QQ%E6%88%AA%E5%9B%BE20231213201620.jpg', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruits` VALUES (37, '100101', '0010011-', '苹果', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/6d56fbebd24177355962e92cc59d98f8.jpg.source.jpg', 1, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for fruittypes
-- ----------------------------
DROP TABLE IF EXISTS `fruittypes`;
CREATE TABLE `fruittypes`  (
  `fruitTypes_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 主键id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果种类名称',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果种类编号',
  `is_status` int(11) NULL DEFAULT 1 COMMENT '水果种类状态',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  PRIMARY KEY (`fruitTypes_id`) USING BTREE,
  UNIQUE INDEX `code`(`code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '水果种类表 水果的种类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fruittypes
-- ----------------------------
INSERT INTO `fruittypes` VALUES (1, '苹果', '100101', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruittypes` VALUES (2, '西瓜', '100102', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruittypes` VALUES (3, '草莓', '100103', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruittypes` VALUES (4, '香蕉', '100104', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruittypes` VALUES (5, '蜜瓜', '100105', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruittypes` VALUES (6, '橙子', '100106', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruittypes` VALUES (7, '葡萄', '100107', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruittypes` VALUES (8, '桃子', '100108', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruittypes` VALUES (9, '蓝莓', '100109', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruittypes` VALUES (10, '柠檬', '100110', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fruittypes` VALUES (11, '梨子', '100111', 1, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for outbound
-- ----------------------------
DROP TABLE IF EXISTS `outbound`;
CREATE TABLE `outbound`  (
  `o_id` int(11) NOT NULL COMMENT '主键',
  `o_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '出库单编号',
  `fruitTypes_id` int(11) NULL DEFAULT NULL COMMENT '水果类型编号',
  `fruit_id` int(11) NULL DEFAULT NULL COMMENT '水果编号',
  `fruit_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果名称',
  `fruit_count` decimal(64, 16) NULL DEFAULT NULL COMMENT '水果数量',
  `o_date` date NULL DEFAULT NULL COMMENT '出库时间',
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_status` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`o_id`) USING BTREE,
  UNIQUE INDEX `o_number`(`o_number` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '门店出库单 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of outbound
-- ----------------------------

-- ----------------------------
-- Table structure for purchaseorderdetails
-- ----------------------------
DROP TABLE IF EXISTS `purchaseorderdetails`;
CREATE TABLE `purchaseorderdetails`  (
  `P_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `s_id` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '门店编号',
  `p_number` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果进货单号',
  `fruitTypes_id` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果种类编号',
  `fruit_id` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果编号',
  `fruit_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果名称',
  `number` double(64, 2) NULL DEFAULT NULL COMMENT '数量 来货数量',
  `price` decimal(64, 2) NULL DEFAULT NULL COMMENT '进货单价 来货价',
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_status` int(11) NULL DEFAULT 1 COMMENT '订单状态(0:驳回, 1: 审批中, 2:审批通过,正在出库, 3:订单完成 )',
  PRIMARY KEY (`P_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '进货单明细表 京货单明细' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of purchaseorderdetails
-- ----------------------------
INSERT INTO `purchaseorderdetails` VALUES (22, '206', '2024146925', '100104', '004001', '帝王蕉', 10.00, 0.50, NULL, NULL, NULL, NULL, NULL, 3);
INSERT INTO `purchaseorderdetails` VALUES (24, '206', '2024143663', '100101', '001001', '东方红苹果', 10.00, 100.00, NULL, NULL, NULL, NULL, NULL, 3);
INSERT INTO `purchaseorderdetails` VALUES (25, '206', '2024143663', '100102', '002004', '甘美西瓜', 10.00, 0.80, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `purchaseorderdetails` VALUES (26, '206', '2024143663', '100104', '004002', '云南小米蕉', 7.00, 1.25, NULL, NULL, NULL, NULL, NULL, 3);
INSERT INTO `purchaseorderdetails` VALUES (27, '206', '2024143663', '100102', '002003', '压砂瓜', 2.00, 0.50, NULL, NULL, NULL, NULL, NULL, 3);
INSERT INTO `purchaseorderdetails` VALUES (28, '206', '2024143663', '100104', '004001', '帝王蕉', 20.00, 0.50, NULL, NULL, NULL, NULL, NULL, 2);
INSERT INTO `purchaseorderdetails` VALUES (30, '206', '2024142201', '100101', '001001', '东方红苹果', 1.00, 100.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `purchaseorderdetails` VALUES (31, '206', '2024154989', '100101', '001001', '东方红苹果', 1.00, 100.00, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `purchaseorderdetails` VALUES (33, '215', '2024152148', '100102', '002004', '甘美西瓜', 10.00, 0.80, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `purchaseorderdetails` VALUES (34, '219', '2024143665', '100103', '003002', '名晶草莓', 10.00, 100.00, NULL, NULL, NULL, NULL, NULL, 3);
INSERT INTO `purchaseorderdetails` VALUES (46, '206', '2024165702', '100102', '002004', '甘美西瓜', 10.00, 0.80, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `purchaseorderdetails` VALUES (47, '206', '2024163046', '100101', '001001', '东方红苹果', 10.00, 100.00, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `purchaseorderdetails` VALUES (48, '206', '2024163046', '100101', '001001', '东方红苹果', 20.00, 100.00, NULL, NULL, NULL, NULL, NULL, 3);
INSERT INTO `purchaseorderdetails` VALUES (49, '206', '2024169943', '100102', '002004', '甘美西瓜', 10.00, 0.80, NULL, NULL, NULL, NULL, NULL, 2);

-- ----------------------------
-- Table structure for reportinglosses
-- ----------------------------
DROP TABLE IF EXISTS `reportinglosses`;
CREATE TABLE `reportinglosses`  (
  `r_id` decimal(11, 0) NOT NULL COMMENT '主键',
  `s_id` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '门店编号 门店外键',
  `o_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单编号',
  `datetime` datetime NULL DEFAULT NULL COMMENT '日期',
  `fruits_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果编号',
  `number` decimal(64, 2) NULL DEFAULT NULL COMMENT '数量',
  `unit_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '单价',
  `total_price` decimal(10, 0) NULL DEFAULT NULL COMMENT '单品总价',
  `cause` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '报损原因',
  `is_status` int(10) NULL DEFAULT 1 COMMENT '状态',
  `REVISION` int(11) NULL DEFAULT 1 COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`r_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '报损表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reportinglosses
-- ----------------------------
INSERT INTO `reportinglosses` VALUES (1, '206', '202401032035398440', '2024-01-04 18:02:04', '003001', 1.20, 20.00, 24, '好多原因', 1, 1, NULL, NULL, NULL, NULL);
INSERT INTO `reportinglosses` VALUES (4, '206', '202401041737024137', '2024-01-04 18:33:35', '003001', 0.60, 20.00, 24, '短期内内部变质', 1, 1, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for return_particulars
-- ----------------------------
DROP TABLE IF EXISTS `return_particulars`;
CREATE TABLE `return_particulars`  (
  `m_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `rd_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '退货编号',
  `time` datetime NULL DEFAULT NULL COMMENT '操作时间',
  `judge` int(11) NULL DEFAULT NULL COMMENT '是否退货成功(0成功1失败)',
  `s_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '门店id',
  `fruit_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果编号',
  `rd_count` double(255, 2) NULL DEFAULT NULL COMMENT '水果重量',
  PRIMARY KEY (`m_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '退货详情' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of return_particulars
-- ----------------------------
INSERT INTO `return_particulars` VALUES (1, '13232312', '2023-12-29 09:10:43', 0, NULL, NULL, NULL);
INSERT INTO `return_particulars` VALUES (2, '13232312', '2023-12-29 09:11:59', 0, NULL, NULL, NULL);
INSERT INTO `return_particulars` VALUES (3, '13232312', '2023-12-29 09:25:44', 0, NULL, NULL, NULL);
INSERT INTO `return_particulars` VALUES (4, '13232312', '2023-12-29 09:37:17', 0, NULL, NULL, NULL);
INSERT INTO `return_particulars` VALUES (5, '20', '2023-12-29 09:42:23', 0, '1', '003001', 20.00);
INSERT INTO `return_particulars` VALUES (6, '13232312', '2023-12-29 14:28:32', 1, '1', '003001', 10.00);
INSERT INTO `return_particulars` VALUES (7, '13232312', '2023-12-29 14:31:42', 1, '1', '003001', 10.00);
INSERT INTO `return_particulars` VALUES (8, NULL, '2024-01-02 14:53:57', 0, '1', '11', 1.00);
INSERT INTO `return_particulars` VALUES (9, '12.0', '2024-01-02 14:54:02', 1, '110001', '100110', 5.00);
INSERT INTO `return_particulars` VALUES (10, '1229171210', '2024-01-02 17:02:27', 1, '110001', '003001', 5.00);
INSERT INTO `return_particulars` VALUES (11, '1229171210', '2024-01-02 17:03:56', 1, '110001', '003001', 5.00);
INSERT INTO `return_particulars` VALUES (12, '12.0', '2024-01-02 17:06:42', 0, '110001', '100110', 5.00);
INSERT INTO `return_particulars` VALUES (13, NULL, '2024-01-02 17:06:49', 1, NULL, '001007', 5.00);
INSERT INTO `return_particulars` VALUES (14, '1229171210', '2024-01-02 17:10:11', 1, '110001', '003001', 5.00);
INSERT INTO `return_particulars` VALUES (15, '1229171210', '2024-01-02 17:12:30', 0, '110001', '003001', 5.00);

-- ----------------------------
-- Table structure for return_statistics
-- ----------------------------
DROP TABLE IF EXISTS `return_statistics`;
CREATE TABLE `return_statistics`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `s_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '门店id',
  `fruit_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果编号',
  `rd_count` double(255, 2) NULL DEFAULT NULL COMMENT '退货重量',
  `return_time` datetime NULL DEFAULT NULL COMMENT '退货审批通过时间',
  `is_status` int(11) NULL DEFAULT 1 COMMENT '逻辑删除',
  `warehouse_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '仓房id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '退货统计表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of return_statistics
-- ----------------------------
INSERT INTO `return_statistics` VALUES (3, '110001', '100110', 5.00, '2024-01-02 17:06:42', 1, NULL);
INSERT INTO `return_statistics` VALUES (4, '110001', '003001', 5.00, '2024-01-02 17:12:30', 1, NULL);

-- ----------------------------
-- Table structure for returnorderdetails
-- ----------------------------
DROP TABLE IF EXISTS `returnorderdetails`;
CREATE TABLE `returnorderdetails`  (
  `rd_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `s_id` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '门店编号 门店外键*',
  `warehousing_id` int(11) NULL DEFAULT NULL COMMENT '入库单编号 入库单外键',
  `rd_number` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '退货编号 退货单外键*',
  `fruitTypes_id` int(11) NULL DEFAULT NULL COMMENT '水果类型',
  `fruit_id` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果编号*',
  `rd_count` double(64, 2) NULL DEFAULT NULL COMMENT '重量*',
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_status` int(11) NOT NULL DEFAULT 1 COMMENT '逻辑删除',
  `examine` int(11) NOT NULL DEFAULT 0 COMMENT '审批',
  PRIMARY KEY (`rd_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '退货单明细表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of returnorderdetails
-- ----------------------------
INSERT INTO `returnorderdetails` VALUES (20, '206', 2024142201, '0105085642', 100101, '001001', 1.00, NULL, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `returnorderdetails` VALUES (21, '206', 2024142201, '0105090229', 100101, '001001', 1.00, NULL, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `returnorderdetails` VALUES (22, '206', 2024142201, '0105090918', 100101, '001001', 5.00, NULL, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `returnorderdetails` VALUES (23, '206', 2024142201, '0105091902', 100101, '001001', 1.00, NULL, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `returnorderdetails` VALUES (24, '206', 2024142201, '0105091918', 100101, '001001', 2.00, NULL, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `returnorderdetails` VALUES (25, '206', 2024142201, '0105092134', 100101, '001001', 2.00, NULL, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `returnorderdetails` VALUES (26, '206', 2024169943, '0106142919', 100102, '甘美西瓜', -10.00, NULL, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `returnorderdetails` VALUES (27, '206', 2024169943, '0106143008', 100102, '甘美西瓜', 10.00, NULL, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `returnorderdetails` VALUES (28, '206', 2024169943, '0106143028', 100102, '甘美西瓜', 10.00, NULL, NULL, NULL, NULL, NULL, 1, 0);

-- ----------------------------
-- Table structure for sales_statistics
-- ----------------------------
DROP TABLE IF EXISTS `sales_statistics`;
CREATE TABLE `sales_statistics`  (
  `sales_statistic_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `o_id` int(11) NULL DEFAULT NULL COMMENT '订单表id',
  `s_id` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '门店信息表id',
  `date` date NULL DEFAULT NULL COMMENT '日期',
  `turnover` decimal(64, 2) NULL DEFAULT NULL COMMENT '营业额',
  `passenger_flow` int(11) NULL DEFAULT NULL COMMENT '客流量',
  `avg_sales` decimal(10, 2) NULL DEFAULT NULL COMMENT '平均销售额 由来客人数/营业额',
  `revision` int(11) NULL DEFAULT 0 COMMENT '乐观锁',
  `is_status` int(11) NULL DEFAULT 1 COMMENT '是否被删除\r\n\r\n',
  `created_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`sales_statistic_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '销售统计表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sales_statistics
-- ----------------------------
INSERT INTO `sales_statistics` VALUES (1, NULL, '3', '2023-12-25', 1000.00, 50, 20.00, 0, 1, NULL, NULL, NULL, NULL);
INSERT INTO `sales_statistics` VALUES (2, NULL, '7', '2023-12-28', 20222371.00, 5, 4044474.20, 0, 1, NULL, NULL, NULL, '2023-12-28 17:46:27');
INSERT INTO `sales_statistics` VALUES (3, NULL, '2', '2023-12-28', 10111010.00, 2, 5055505.00, 0, 1, NULL, NULL, NULL, '2023-12-28 17:50:28');
INSERT INTO `sales_statistics` VALUES (4, NULL, '2', '2023-12-29', 0.00, 1, 0.00, 0, 1, NULL, NULL, NULL, NULL);
INSERT INTO `sales_statistics` VALUES (5, NULL, NULL, '2024-01-02', 0.00, 12, 0.00, 0, 1, NULL, NULL, NULL, '2024-01-02 10:46:50');
INSERT INTO `sales_statistics` VALUES (6, NULL, '110001', '2024-01-02', 0.00, 3, 0.00, 0, 1, NULL, NULL, NULL, '2024-01-04 14:40:50');
INSERT INTO `sales_statistics` VALUES (7, NULL, '206', '2024-01-03', 24.00, 1, 24.00, 0, 1, NULL, NULL, NULL, NULL);
INSERT INTO `sales_statistics` VALUES (8, NULL, '206', '2024-01-04', 868.00, 8, 108.50, 0, 1, NULL, NULL, NULL, '2024-01-04 20:33:55');
INSERT INTO `sales_statistics` VALUES (9, NULL, '206', '2024-01-05', 72.00, 2, 36.00, 0, 1, NULL, NULL, NULL, '2024-01-05 15:32:33');
INSERT INTO `sales_statistics` VALUES (10, NULL, '206', '2024-01-06', 230.00, 2, 115.00, 0, 1, NULL, NULL, NULL, '2024-01-06 14:58:32');

-- ----------------------------
-- Table structure for salesdetails
-- ----------------------------
DROP TABLE IF EXISTS `salesdetails`;
CREATE TABLE `salesdetails`  (
  `SalesDetail_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `fruit_id` int(11) NULL DEFAULT NULL COMMENT '水果编号 水果表的外键',
  `date` date NULL DEFAULT NULL COMMENT '日期',
  `number` decimal(64, 16) NULL DEFAULT NULL COMMENT '销售数量',
  `salesAmount` decimal(64, 16) NULL DEFAULT NULL COMMENT '销售金额',
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_status` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`SalesDetail_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '水果销售明细表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of salesdetails
-- ----------------------------

-- ----------------------------
-- Table structure for salesorderdetails
-- ----------------------------
DROP TABLE IF EXISTS `salesorderdetails`;
CREATE TABLE `salesorderdetails`  (
  `SalesOrderDetails_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `o_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单编号 销售订单的外键',
  `fruitPrice_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果编号 水果价格表的外键',
  `count` decimal(64, 2) NULL DEFAULT NULL COMMENT '重量 购买水果的重量',
  `money` decimal(64, 2) NULL DEFAULT NULL COMMENT '单品金额 水果单价',
  `totalmoney` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '金额 数量X单价',
  `datetime` datetime NULL DEFAULT NULL COMMENT '消费时间 购买时间',
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_status` int(11) NULL DEFAULT 1 COMMENT '状态',
  `s_id` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '门店编号',
  PRIMARY KEY (`SalesOrderDetails_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 106 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '销售订单明细表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of salesorderdetails
-- ----------------------------
INSERT INTO `salesorderdetails` VALUES (3, '202312270856383102', '001001', 0.60, 12.00, '31.56', '2023-12-27 08:56:38', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (4, '202312270856383102', '001002', 0.60, 14.30, '31.56', '2023-12-27 08:56:38', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (5, '202312270857256585', '001001', 1.20, 12.00, '31.56', '2023-12-27 08:57:25', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (6, '202312270857256585', '001002', 1.20, 14.30, '31.56', '2023-12-27 08:57:25', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (7, '202312270900401968', '001001', 0.60, 12.00, '40.14', '2023-12-27 09:00:40', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (8, '202312270900401968', '001002', 1.80, 14.30, '40.14', '2023-12-27 09:00:40', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (9, '1234567890202312270914277230', '001002', 0.60, 14.30, '31.56', '2023-12-27 09:14:28', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (10, '1234567890202312270914277230', '001001', 1.20, 12.00, '31.56', '2023-12-27 09:14:28', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (11, '202312271731075047', '001001', 3.50, 130.00, '455.00', '2023-12-27 17:31:07', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (12, '202312271732205284', '001001', 3.50, 130.00, '479.50', '2023-12-27 17:32:20', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (13, '202312271732205284', '001002', 2.50, 9.80, '479.50', '2023-12-27 17:32:20', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (14, '202312271742548908', '001001', 2.00, 130.00, '260.00', '2023-12-27 17:42:55', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (15, '202312271742548908', '001003', 1.00, NULL, '260.00', '2023-12-27 17:42:55', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (16, '202312271743096792', '001001', 2.00, 130.00, '269.80', '2023-12-27 17:43:10', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (17, '202312271743096792', '001003', 1.00, NULL, '269.80', '2023-12-27 17:43:10', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (18, '202312271743096792', '001004', 0.50, NULL, '269.80', '2023-12-27 17:43:10', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (19, '202312271743096792', '001002', 1.00, 9.80, '269.80', '2023-12-27 17:43:10', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (20, '202312271743449586', '001001', 2.00, 130.00, '309.00', '2023-12-27 17:43:45', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (21, '202312271743449586', '001003', 1.00, NULL, '309.00', '2023-12-27 17:43:45', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (22, '202312271743449586', '001004', 0.50, NULL, '309.00', '2023-12-27 17:43:45', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (23, '202312271743449586', '001002', 5.00, 9.80, '309.00', '2023-12-27 17:43:45', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (24, '202312271744191728', '001001', 2.50, 130.00, '374.00', '2023-12-27 17:44:20', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (25, '202312271744191728', '001003', 1.00, NULL, '374.00', '2023-12-27 17:44:20', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (26, '202312271744191728', '001004', 0.50, NULL, '374.00', '2023-12-27 17:44:20', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (27, '202312271744191728', '001002', 5.00, 9.80, '374.00', '2023-12-27 17:44:20', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (28, '202312271744191728', '002001', 0.50, NULL, '374.00', '2023-12-27 17:44:20', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (29, '202312271744238124', '001001', 2.50, 130.00, '374.00', '2023-12-27 17:44:24', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (30, '202312271744238124', '001003', 1.00, NULL, '374.00', '2023-12-27 17:44:24', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (31, '202312271744238124', '001004', 0.50, NULL, '374.00', '2023-12-27 17:44:24', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (32, '202312271744238124', '001002', 5.00, 9.80, '374.00', '2023-12-27 17:44:24', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (33, '202312271744238124', '002001', 0.50, NULL, '374.00', '2023-12-27 17:44:24', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (34, '202312271744244867', '001001', 2.50, 130.00, '374.00', '2023-12-27 17:44:24', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (35, '202312271744244867', '001003', 1.00, NULL, '374.00', '2023-12-27 17:44:24', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (36, '202312271744244867', '001004', 0.50, NULL, '374.00', '2023-12-27 17:44:24', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (37, '202312271744244867', '001002', 5.00, 9.80, '374.00', '2023-12-27 17:44:24', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (38, '202312271744244867', '002001', 0.50, NULL, '374.00', '2023-12-27 17:44:24', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (39, '202312271744241409', '001001', 2.50, 130.00, '374.00', '2023-12-27 17:44:24', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (40, '202312271744241409', '001003', 1.00, NULL, '374.00', '2023-12-27 17:44:24', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (41, '202312271744241409', '001004', 0.50, NULL, '374.00', '2023-12-27 17:44:24', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (42, '202312271744241409', '001002', 5.00, 9.80, '374.00', '2023-12-27 17:44:24', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (43, '202312271744241409', '002001', 0.50, NULL, '374.00', '2023-12-27 17:44:24', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (44, '202312271744245950', '001001', 2.50, 130.00, '374.00', '2023-12-27 17:44:25', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (45, '202312271744245950', '001003', 1.00, NULL, '374.00', '2023-12-27 17:44:25', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (46, '202312271744245950', '001004', 0.50, NULL, '374.00', '2023-12-27 17:44:25', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (47, '202312271744245950', '001002', 5.00, 9.80, '374.00', '2023-12-27 17:44:25', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (48, '202312271744245950', '002001', 0.50, NULL, '374.00', '2023-12-27 17:44:25', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (49, '202312271801304742', '001001', 1.50, 130.00, '219.50', '2023-12-27 18:01:30', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (50, '202312271801304742', '001002', 2.50, 9.80, '219.50', '2023-12-27 18:01:30', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (51, '202312281025598652', '001001', 3.00, 130.00, '390.00', '2023-12-28 10:26:00', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (52, '202312281408244799', '001001', 2.00, 130.00, '559.20', '2023-12-28 14:08:25', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (53, '202312281408244799', '001002', 2.00, 9.80, '559.20', '2023-12-28 14:08:25', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (54, '202312281408534131', '001004', 3.00, NULL, '0.00', '2023-12-28 14:08:54', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (55, '202312281409174370', '001004', 3.00, NULL, '9.80', '2023-12-28 14:09:18', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (56, '202312281409174370', '001002', 0.50, 9.80, '9.80', '2023-12-28 14:09:18', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (57, '202312281738485394', '001001', 33333.00, 65.00, '2166645.00', '2023-12-28 17:38:48', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (58, '202312281742078077', '001001', 155554.00, 65.00, '10111010.00', '2023-12-28 17:42:07', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (59, '202312281742374569', '001001', 155554.00, 65.00, '10111010.00', '2023-12-28 17:42:38', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (60, '202312281742383937', '001001', 155554.00, 65.00, '10111010.00', '2023-12-28 17:42:39', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (61, '202312281746248500', '001001', 1.80, 65.00, '117.00', '2023-12-28 17:46:24', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (62, '202312281746259969', '001001', 1.80, 65.00, '117.00', '2023-12-28 17:46:26', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (63, '202312281746268107', '001001', 1.80, 65.00, '117.00', '2023-12-28 17:46:27', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (64, '202312281750285183', '001003', 11111.00, NULL, '0.00', '2023-12-28 17:50:28', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (65, '202312291924374407', '003003', 0.60, NULL, '0.00', '2023-12-29 19:24:37', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (66, '202401020914115828', '003004', 1.20, NULL, '0.00', '2024-01-02 09:14:11', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (67, '202401020914115828', '003003', 0.60, NULL, '0.00', '2024-01-02 09:14:11', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (68, '202401020914115828', '003001', 0.60, NULL, '0.00', '2024-01-02 09:14:11', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (69, '202401020923519599', '003003', 1.20, NULL, '0.00', '2024-01-02 09:23:51', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (70, '202401020925221763', '003003', 1.20, NULL, '0.00', '2024-01-02 09:25:22', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (71, '202401020925515586', '003004', 11111.00, NULL, '0.00', '2024-01-02 09:25:52', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (72, '202401020928391382', '003004', 0.60, NULL, '0.00', '2024-01-02 09:28:40', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (73, '202401020930567998', '003001', 0.60, NULL, '0.00', '2024-01-02 09:30:56', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (74, '202401020930567998', '003003', 0.60, NULL, '0.00', '2024-01-02 09:30:56', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (75, '202401020934173883', '003003', 0.60, NULL, '0.00', '2024-01-02 09:34:18', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (76, '202401020934173883', '003004', 0.60, NULL, '0.00', '2024-01-02 09:34:18', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (77, '202401020940187129', '003004', 1.20, NULL, '0.00', '2024-01-02 09:40:19', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (78, '202401020940187129', '003001', 0.60, NULL, '0.00', '2024-01-02 09:40:19', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (79, '202401020949526591', '003004', 0.60, NULL, '0.00', '2024-01-02 09:49:52', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (80, '202401020949526591', '003003', 0.60, NULL, '0.00', '2024-01-02 09:49:52', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (81, '202401020954286386', '003004', 0.50, NULL, '0.00', '2024-01-02 09:54:28', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (82, '202401020954286386', '003001', 0.50, NULL, '0.00', '2024-01-02 09:54:28', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (83, '202401021022032510', '003004', 0.60, NULL, '0.00', '2024-01-02 10:22:04', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (84, '202401021046505428', '003004', 0.60, NULL, '0.00', '2024-01-02 10:46:50', NULL, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `salesorderdetails` VALUES (85, '202401021046505428', '003003', 0.60, NULL, '0.00', '2024-01-02 10:46:50', NULL, NULL, NULL, 'admin', '2024-01-03 20:55:26', 0, NULL);
INSERT INTO `salesorderdetails` VALUES (86, '202401021108077732', '003004', 0.60, NULL, '0.00', '2024-01-02 11:08:07', NULL, NULL, NULL, NULL, NULL, 1, '110001');
INSERT INTO `salesorderdetails` VALUES (87, '202401021140051288', '003004', 0.60, NULL, '0.00', '2024-01-02 11:40:05', NULL, NULL, NULL, NULL, NULL, 1, '110001');
INSERT INTO `salesorderdetails` VALUES (88, '202401021534485272', '003003', 0.50, NULL, '0.00', '2024-01-02 15:34:48', NULL, NULL, NULL, NULL, NULL, 1, '110001');
INSERT INTO `salesorderdetails` VALUES (89, '202401021654571926', '003004', 0.60, 15.00, '63.60', '2024-01-02 16:54:57', NULL, NULL, NULL, NULL, NULL, 1, '110001');
INSERT INTO `salesorderdetails` VALUES (90, '202401021654571926', '003003', 0.60, 18.00, '63.60', '2024-01-02 16:54:57', NULL, NULL, NULL, NULL, NULL, 1, '110001');
INSERT INTO `salesorderdetails` VALUES (91, '202401021654571926', '003001', 0.60, 20.00, '63.60', '2024-01-02 16:54:57', NULL, NULL, NULL, 'admin', '2024-01-04 14:40:50', 1, '110001');
INSERT INTO `salesorderdetails` VALUES (92, '202401032035398440', '003001', 1.20, 20.00, '24.00', '2024-01-03 20:35:40', NULL, NULL, NULL, 'admin', '2024-01-04 16:19:33', 1, '206');
INSERT INTO `salesorderdetails` VALUES (93, '202401041712028840', '003001', 0.60, 20.00, '24.00', '2024-01-04 17:12:03', NULL, NULL, NULL, NULL, NULL, 1, '206');
INSERT INTO `salesorderdetails` VALUES (94, '202401041737024137', '003001', 0.60, 20.00, '24.00', '2024-01-04 17:37:03', NULL, NULL, NULL, 'admin', '2024-01-04 18:33:35', 0, '206');
INSERT INTO `salesorderdetails` VALUES (95, '202401041741582559', '003001', 0.60, 20.00, '24.00', '2024-01-04 17:41:58', NULL, NULL, NULL, NULL, NULL, 1, '206');
INSERT INTO `salesorderdetails` VALUES (96, '202401041746126133', '003001', 0.60, 20.00, '24.00', '2024-01-04 17:46:12', NULL, NULL, NULL, NULL, NULL, 1, '206');
INSERT INTO `salesorderdetails` VALUES (97, '202401041919457372', '003001', 0.60, 20.00, '24.00', '2024-01-04 19:19:45', NULL, NULL, NULL, NULL, NULL, 1, '206');
INSERT INTO `salesorderdetails` VALUES (98, '202401041921402876', '003001', 0.60, 20.00, '24.00', '2024-01-04 19:21:40', NULL, NULL, NULL, NULL, NULL, 1, '206');
INSERT INTO `salesorderdetails` VALUES (99, '202401041941231089', '003001', 0.60, 20.00, '24.00', '2024-01-04 19:41:23', NULL, NULL, NULL, NULL, NULL, 1, '206');
INSERT INTO `salesorderdetails` VALUES (100, '202401042024006947', '003001', 1.20, 20.00, '24.00', '2024-01-04 20:24:00', NULL, NULL, NULL, NULL, NULL, 1, '206');
INSERT INTO `salesorderdetails` VALUES (101, '202401042033543909', '003001', 10.00, 20.00, '700.00', '2024-01-04 20:33:54', NULL, NULL, NULL, NULL, NULL, 1, '206');
INSERT INTO `salesorderdetails` VALUES (102, '202401042033543909', '003004', 20.00, 15.00, '700.00', '2024-01-04 20:33:54', NULL, NULL, NULL, NULL, NULL, 1, '206');
INSERT INTO `salesorderdetails` VALUES (103, '202401051527229543', '003003', 1.00, 18.00, '36.00', '2024-01-05 15:27:23', NULL, NULL, NULL, NULL, NULL, 1, '206');
INSERT INTO `salesorderdetails` VALUES (104, '202401051532322937', '003003', 1.00, 18.00, '36.00', '2024-01-05 15:32:32', NULL, NULL, NULL, NULL, NULL, 1, '206');
INSERT INTO `salesorderdetails` VALUES (105, '202401061149064806', '001003', 1.00, 79.00, '158.00', '2024-01-06 11:49:06', NULL, NULL, NULL, 'nyshop', '2024-01-06 15:03:19', 0, '206');
INSERT INTO `salesorderdetails` VALUES (106, '202401061458319148', '003003', 2.00, 18.00, '72.00', '2024-01-06 14:58:32', NULL, NULL, NULL, NULL, NULL, 1, '206');

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop`  (
  `s_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `s_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '门店编号',
  `s_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '门店名称',
  `s_address` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '门店地址',
  `ren` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系人 员工表的外键',
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '营业执照',
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_status` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`s_id`) USING BTREE,
  UNIQUE INDEX `s_number`(`s_number` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '门店信息表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES (3, '206', '果燃|能源互联网大厦店', '山西省太原市小店区学府街能源互联网大厦', '范子豪', '13717170017', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/001.jpg', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `shop` VALUES (6, '215', '果燃|万象城店', '山西省太原市小店区,XXX', '果燃|王府井店', '', 'http://zgfjava1218.oss-cn-hangzhou.aliyuncs.com/001.jpg', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `shop` VALUES (7, '219', '果燃|天安门店', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `shop` VALUES (8, '221', '果燃|清华大学店', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);

-- ----------------------------
-- Table structure for shopprice
-- ----------------------------
DROP TABLE IF EXISTS `shopprice`;
CREATE TABLE `shopprice`  (
  `shopprice_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `s_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '门店编号',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果编号',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果名称',
  `price` decimal(32, 2) NULL DEFAULT NULL COMMENT '水果零售价',
  `zhekou` decimal(64, 2) NULL DEFAULT NULL COMMENT '折扣',
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`shopprice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = ' ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shopprice
-- ----------------------------
INSERT INTO `shopprice` VALUES (1, '206', '001001', '东方红苹果', 28.20, 0.79, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `shopprice` VALUES (2, '206', '003004', NULL, 15.00, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `shopprice` VALUES (3, '206', '003001', NULL, 20.00, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `shopprice` VALUES (4, '206', '003003', NULL, 18.00, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `shopprice` VALUES (5, '206', '002004', NULL, 25.00, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `shopprice` VALUES (6, '206', '001003', '水晶富士', 79.00, 0.79, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for storeinventory
-- ----------------------------
DROP TABLE IF EXISTS `storeinventory`;
CREATE TABLE `storeinventory`  (
  `InentoryDetails_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `shop_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '门店编号',
  `fruittypes_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果种类编号',
  `fruit_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果编号 水果表的外键',
  `number` double(64, 2) NULL DEFAULT NULL COMMENT '重量 水果库存',
  `is_status` int(11) NULL DEFAULT 1 COMMENT '状态',
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`InentoryDetails_id`) USING BTREE,
  INDEX `shop_id`(`shop_id` ASC) USING BTREE,
  INDEX `fruittypes_id`(`fruittypes_id` ASC) USING BTREE,
  INDEX `fruit_id`(`fruit_id` ASC) USING BTREE,
  CONSTRAINT `storeinventory_ibfk_1` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`s_number`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `storeinventory_ibfk_2` FOREIGN KEY (`fruittypes_id`) REFERENCES `fruittypes` (`code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `storeinventory_ibfk_3` FOREIGN KEY (`fruit_id`) REFERENCES `fruits` (`code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '门店库存 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of storeinventory
-- ----------------------------
INSERT INTO `storeinventory` VALUES (1, '206', '100103', '003004', 10100.00, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `storeinventory` VALUES (2, '206', '100102', '002004', 10.00, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `storeinventory` VALUES (3, '206', '100103', '003003', 6.00, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `storeinventory` VALUES (5, '206', '100103', '003001', 0.00, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `storeinventory` VALUES (14, '206', '100102', '002003', 10.00, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `storeinventory` VALUES (17, '206', '100101', '001001', 10.00, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `storeinventory` VALUES (18, '215', '100101', '001001', 10.00, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `storeinventory` VALUES (19, '219', '100102', '002003', 10.00, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `storeinventory` VALUES (20, '219', '100102', '002004', 10.00, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `storeinventory` VALUES (21, '219', '100103', '003002', 10.00, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `storeinventory` VALUES (22, '206', '100101', '001003', 99.00, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `storeinventory` VALUES (24, '206', '100102', '002006', 10.00, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `storeinventory` VALUES (25, '206', '100102', '002007', 10.00, 1, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse`  (
  `w_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `w_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '仓库编号',
  `w_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '仓库名称',
  `w_address` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '仓库地址',
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话 员工表的外键',
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_status` int(11) NULL DEFAULT 1 COMMENT '状态',
  PRIMARY KEY (`w_id`) USING BTREE,
  UNIQUE INDEX `w_number`(`w_number` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '仓库信息 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES (1, '203', '龙城仓库', '山西省太原市龙城大厦', '13717170017', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `warehouse` VALUES (3, '205', '首都仓库', '中国首都', '15345253652', NULL, NULL, NULL, NULL, NULL, 1);

-- ----------------------------
-- Table structure for warehousestock
-- ----------------------------
DROP TABLE IF EXISTS `warehousestock`;
CREATE TABLE `warehousestock`  (
  `wh_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `w_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '仓库编号 仓库编号',
  `fruitTypes_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果种类编号',
  `fruit_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果编号 水果表外键',
  `fruit_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果名称',
  `jinjia` decimal(64, 2) NULL DEFAULT NULL COMMENT '进价',
  `wh_count` double(64, 2) NULL DEFAULT NULL COMMENT '重量(kg)',
  `is_status` int(11) NULL DEFAULT 1 COMMENT '状态',
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`wh_id`) USING BTREE,
  INDEX `fruit_id`(`fruit_id` ASC) USING BTREE,
  INDEX `warehousestock_ibfk_1`(`fruitTypes_id` ASC) USING BTREE,
  INDEX `warehousestock_ibfk_2`(`w_id` ASC) USING BTREE,
  CONSTRAINT `warehousestock_ibfk_1` FOREIGN KEY (`fruitTypes_id`) REFERENCES `fruittypes` (`code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `warehousestock_ibfk_2` FOREIGN KEY (`w_id`) REFERENCES `warehouse` (`w_number`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `warehousestock_ibfk_3` FOREIGN KEY (`fruit_id`) REFERENCES `fruits` (`code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '仓库库存明细 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of warehousestock
-- ----------------------------
INSERT INTO `warehousestock` VALUES (1, '203', '100101', '001001', '东方红苹果', 100.00, 30.00, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `warehousestock` VALUES (2, '203', '100102', '002004', '甘美西瓜', 0.80, 30.00, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `warehousestock` VALUES (3, '203', '100102', '002007', '黄瓤西瓜', 1.25, 0.00, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `warehousestock` VALUES (6, '203', '100102', '002006', '黑美人西瓜', 11.70, 0.00, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `warehousestock` VALUES (7, '205', '100102', '002003', '压砂瓜', 0.50, 0.00, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `warehousestock` VALUES (8, '203', '100105', '005001', '金美人', 0.50, 0.00, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `warehousestock` VALUES (10, '203', '100101', '001007', '乐其苹果', 0.50, 0.00, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `warehousestock` VALUES (11, '203', '100104', '004002', '云南小米蕉', 1.25, 12.56, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `warehousestock` VALUES (21, '205', '100101', '001005', '花牛苹果', 10.00, 10.00, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `warehousestock` VALUES (22, '205', '100101', '001001', '东方红苹果', 10.00, 10.00, 1, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for warehousing
-- ----------------------------
DROP TABLE IF EXISTS `warehousing`;
CREATE TABLE `warehousing`  (
  `warehousing_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `s_id` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '门店编号 门店外键',
  `P_id` int(11) NULL DEFAULT NULL COMMENT '进货单编号 进货单的外键',
  `warehousing_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '入库单编号',
  `fruitTypes_id` int(11) NULL DEFAULT NULL COMMENT '水果种类编号',
  `fruit_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果编号',
  `fruit_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '水果名称',
  `fruit_count` double(64, 2) NULL DEFAULT NULL COMMENT '预计入库数量 进货单',
  `number` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '实际入库数量',
  `money` decimal(64, 2) NULL DEFAULT NULL COMMENT '进货价 进货单',
  `warehousing_date` date NULL DEFAULT NULL COMMENT '入库时间',
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_status` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`warehousing_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '门店入库单 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of warehousing
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
