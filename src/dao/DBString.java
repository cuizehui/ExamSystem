package dao;

public  class DBString {
	
 public static String createDB="CREATE TABLE `grade_table_reset` (\n" + 
 		"  `name` char(20) NOT NULL DEFAULT '' COMMENT '姓名',\n" + 
 		"  `jobnumber` char(11) NOT NULL unique  COMMENT '工号'  ,\n" + 
 		"  `grade` int(10)  COMMENT '分数',\n" + 
 		"  `current_time` timestamp not null default current_timestamp  on update current_timestamp COMMENT '最新更新时间',\n" + 
 		"  PRIMARY KEY (`jobnumber`)\n" + 
 		") ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;\n";
 
public  static String DB_grade_table_NAME="grade_table_reset";
 public static String DBNAME="grade_manager_db";
 /*
 工号位数 需要前段设置
 时间设置年月日 时分秒
 
INSERT INTO `grade_table_reset` VALUES ('张三','98547',90,'2017-12-01 17:03:00');
*/
 
 
}
