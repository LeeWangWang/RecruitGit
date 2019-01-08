/**@FileName:ConnectMySql.java
 * @Description: 
 * @Paclage:service
 * @Author:李旺旺
 * @Data:2018年12月30日下午6:54:11
 */
package util;

import java.sql.*;

/**@ClassName:ConnectMySql.java
 * @Description: 连接数据库，获取数据
 * @Extends: null
 * @Implements: null
 * @Author: 李旺旺
 * @Data:2018年12月30日下午6:54:11
 */
public class DBTool {
	//定义全局数据库连接
    private static Connection connection = null;
    /**
     * @Methodname: getConnection
     * @Description: 连接数据库,返回数据库连接对象
     * @param a
     * @return
     * Connection
     * @Author: 李旺旺
     * @Time: 2018年12月30日下午7:07:57
     */
    public static Connection getConnection(){
        try {
            //当数据库未连接,或者数据库已经关闭了
            if(connection == null || connection.isClosed()){
                try {
                    Class.forName("com.mysql.jdbc.Driver");//驱动程序名
                    //数据库名、用户名、密码
                    connection = DriverManager.getConnection(
                    		"jdbc:mysql://localhost:3306/recruit?useSSL=false","root", "123456");
                }catch (ClassNotFoundException e) {
                    e.printStackTrace();//未找到数据库
                }catch (SQLException e){
                    e.printStackTrace();//数据库异常
                }
            }
        }catch (SQLException e){
            e.printStackTrace();//数据库异常
        }
        return connection;
    }
    
    /**
     * @Methodname: closeMySql
     * @Description: 关闭数据库连接
     * void
     * @Author: 李旺旺
     * @Time: 2018年12月30日下午7:09:15
     */
    public static void closeConnection(){
        try {
            if(connection != null && !connection.isClosed()){
                connection.close();
                connection = null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
/*

    public static void main(String[] args){
        Connection connection;
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名book
        String url = "jdbc:mysql://localhost:3306/recruit?useSSL=false";//?useSSL=false
        //MYSQL配置时的用户名
        String user = "root";
        //MYSQL配置时的密码
        String password = "123456";
        //遍历查询结果
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            if (!connection.isClosed()) {
                System.out.println("数据库连接成功");
            }
            Statement statement = connection.createStatement();
            String sql = "select* from candidate";//表格的名字叫"candidate"
            ResultSet resultSet = statement.executeQuery(sql);
            String name;
            while (resultSet.next()) {
                name = resultSet.getString("candidateName");
                System.out.println("姓名:" + name);
            }
            resultSet.close();
            connection.close();
        }catch (ClassNotFoundException e){
            System.out.println("驱动库没有安装");
        }catch (SQLException e){
            System.out.println("数据库读取信息失败");
        }
    }
*/

/*
连接数据库获取数据
public static void main(String[] args){
    Connection connection;
    //驱动程序名
    String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名book
    String url = "jdbc:mysql://localhost:3306/recruit?useSSL=false";//?useSSL=false
    //MYSQL配置时的用户名
    String user = "root";
    //MYSQL配置时的密码
    String password = "123456";
    //遍历查询结果
    try {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, user, password);
        if (!connection.isClosed()) {
            System.out.println("数据库连接成功");
        }
        Statement statement = connection.createStatement();
        String sql = "select* from candidate";//表格的名字叫"candidate"
        ResultSet resultSet = statement.executeQuery(sql);
        String name;
        while (resultSet.next()) {
            name = resultSet.getString("candidateName");
            System.out.println("姓名:" + name);
        }
        resultSet.close();
        connection.close();
    }catch (ClassNotFoundException e){
        System.out.println("驱动库没有安装");
    }catch (SQLException e){
        System.out.println("数据库读取信息失败");
    }
}
更新数据库数据
*/


