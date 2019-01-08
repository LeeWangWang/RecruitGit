/**@FileName:ConnectMySql.java
 * @Description: 
 * @Paclage:service
 * @Author:������
 * @Data:2018��12��30������6:54:11
 */
package util;

import java.sql.*;

/**@ClassName:ConnectMySql.java
 * @Description: �������ݿ⣬��ȡ����
 * @Extends: null
 * @Implements: null
 * @Author: ������
 * @Data:2018��12��30������6:54:11
 */
public class DBTool {
	//����ȫ�����ݿ�����
    private static Connection connection = null;
    /**
     * @Methodname: getConnection
     * @Description: �������ݿ�,�������ݿ����Ӷ���
     * @param a
     * @return
     * Connection
     * @Author: ������
     * @Time: 2018��12��30������7:07:57
     */
    public static Connection getConnection(){
        try {
            //�����ݿ�δ����,�������ݿ��Ѿ��ر���
            if(connection == null || connection.isClosed()){
                try {
                    Class.forName("com.mysql.jdbc.Driver");//����������
                    //���ݿ������û���������
                    connection = DriverManager.getConnection(
                    		"jdbc:mysql://localhost:3306/recruit?useSSL=false","root", "123456");
                }catch (ClassNotFoundException e) {
                    e.printStackTrace();//δ�ҵ����ݿ�
                }catch (SQLException e){
                    e.printStackTrace();//���ݿ��쳣
                }
            }
        }catch (SQLException e){
            e.printStackTrace();//���ݿ��쳣
        }
        return connection;
    }
    
    /**
     * @Methodname: closeMySql
     * @Description: �ر����ݿ�����
     * void
     * @Author: ������
     * @Time: 2018��12��30������7:09:15
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
        //����������
        String driver = "com.mysql.jdbc.Driver";
        //URLָ��Ҫ���ʵ����ݿ���book
        String url = "jdbc:mysql://localhost:3306/recruit?useSSL=false";//?useSSL=false
        //MYSQL����ʱ���û���
        String user = "root";
        //MYSQL����ʱ������
        String password = "123456";
        //������ѯ���
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            if (!connection.isClosed()) {
                System.out.println("���ݿ����ӳɹ�");
            }
            Statement statement = connection.createStatement();
            String sql = "select* from candidate";//�������ֽ�"candidate"
            ResultSet resultSet = statement.executeQuery(sql);
            String name;
            while (resultSet.next()) {
                name = resultSet.getString("candidateName");
                System.out.println("����:" + name);
            }
            resultSet.close();
            connection.close();
        }catch (ClassNotFoundException e){
            System.out.println("������û�а�װ");
        }catch (SQLException e){
            System.out.println("���ݿ��ȡ��Ϣʧ��");
        }
    }
*/

/*
�������ݿ��ȡ����
public static void main(String[] args){
    Connection connection;
    //����������
    String driver = "com.mysql.jdbc.Driver";
    //URLָ��Ҫ���ʵ����ݿ���book
    String url = "jdbc:mysql://localhost:3306/recruit?useSSL=false";//?useSSL=false
    //MYSQL����ʱ���û���
    String user = "root";
    //MYSQL����ʱ������
    String password = "123456";
    //������ѯ���
    try {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, user, password);
        if (!connection.isClosed()) {
            System.out.println("���ݿ����ӳɹ�");
        }
        Statement statement = connection.createStatement();
        String sql = "select* from candidate";//�������ֽ�"candidate"
        ResultSet resultSet = statement.executeQuery(sql);
        String name;
        while (resultSet.next()) {
            name = resultSet.getString("candidateName");
            System.out.println("����:" + name);
        }
        resultSet.close();
        connection.close();
    }catch (ClassNotFoundException e){
        System.out.println("������û�а�װ");
    }catch (SQLException e){
        System.out.println("���ݿ��ȡ��Ϣʧ��");
    }
}
�������ݿ�����
*/


