# Hbase

### HBase的增删改查操作

```java
package com.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;


import java.io.IOException;

public class HBase {
    static Configuration conf = null;
    static {
        conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum","192.168.0.131");
        conf.set("hbase.zookeeper.property.clientPort","2181");
    }

    /**
     * 创建表
     * @param tableName 表名
     * @param family 列族
     */
    public static void createTable(String tableName,String[] family) throws Exception{
        HBaseAdmin admin = new HBaseAdmin(conf);
        HTableDescriptor desc = new HTableDescriptor(tableName);
        for (int i = 0; i < family.length; i++) {
            desc.addFamily(new HColumnDescriptor(family[i]));
        }
        if (admin.tableExists(tableName)){
            System.out.println("表已经存在");
            System.exit(0);
        }else {
            admin.createTable(desc);
            System.out.println("建表成功");
        }
    }

    /**
     * 向表中添加数据(需要知道该表中有多少列族)
     * @param rowKey 行健
     * @param tableName 表名
     * @param col1  第一个列族列表
     * @param value1  第一个列的值
     * @throws IOException
     */
    public static void addData(String rowKey,String tableName,String[] col1,String[] value1) throws IOException {
        Put put = new Put(Bytes.toBytes(rowKey));
        //HTable对象负责记录相关增删改查操作
        HTable table = new HTable(conf,Bytes.toBytes(tableName));

        HColumnDescriptor[] columnFamilies = table.getTableDescriptor().getColumnFamilies();
        for (int i = 0; i < columnFamilies.length; i++) {
            String FamilyName = columnFamilies[i].getNameAsString();    //获取列族名称
            if (FamilyName.equals("info")){
                for (int j = 0; j < col1.length; j++) {
                    put.add(Bytes.toBytes(FamilyName),Bytes.toBytes(col1[j]),Bytes.toBytes(value1[j]));
                }
            }
        }
        table.put(put);
        System.out.println("添加数据成功");
    }


    /**
     * 查询表数据
     * @param tableName 表名
     * @param rowKey    行健
     * @return  result
     * @throws IOException
     */
    public static Result getResult(String tableName,String rowKey) throws IOException {
        Get get = new Get(Bytes.toBytes(rowKey));
        HTable table = new HTable(conf,Bytes.toBytes(tableName));

        Result result = table.get(get);

        for (KeyValue keyValue : result.list()) {
            System.out.println("family:"+Bytes.toString(keyValue.getFamily()));
            System.out.println("qualifier:"+Bytes.toString(keyValue.getQualifier()));
            System.out.println("value:"+Bytes.toString(keyValue.getValue()));
            System.out.println("Timestamp:"+keyValue.getTimestamp());
            System.out.println("=============================================");
        }
        return result;
    }


    /**
     * 遍历查询hbase表
     * @param tableName 表名
     * @throws IOException
     */
    public static void getResultScann(String tableName) throws IOException{
        Scan scan = new Scan();
        ResultScanner rs = null;
        HTable table = new HTable(conf,Bytes.toBytes(tableName));

        try{
            rs = table.getScanner(scan);
            for (Result r : rs) {
                for (KeyValue keyValue : r.list()) {
                    System.out.println("row:"+Bytes.toString(keyValue.getRow()));
                    System.out.println("family:"+Bytes.toString(keyValue.getFamily()));
                    System.out.println("qualifier:"+Bytes.toString(keyValue.getQualifier()));
                    System.out.println("value:"+Bytes.toString(keyValue.getRow()));
                    System.out.println("timestamp:"+keyValue.getTimestamp());
                    System.out.println("===================================");
                }
            }
        }finally {
            rs.close();
        }
    }


    /**
     * @param tableName 表名
     * @param rowKey    行健
     * @param familyName    列族
     * @param columnName    列名
     * @throws IOException
     */
    public static void getResultByColumn(String tableName,String rowKey,String familyName,String columnName)throws IOException{
        HTable table = new HTable(conf,Bytes.toBytes(tableName));

        Get get = new Get(Bytes.toBytes(rowKey));
        //获取指定列族和列修饰符对应的列
        get.addColumn(Bytes.toBytes(familyName),Bytes.toBytes(columnName));

        Result result = table.get(get);
        for (KeyValue keyValue : result.list()) {
            System.out.println("family:"+Bytes.toString(keyValue.getFamily()));
            System.out.println("qualifier:"+Bytes.toString(keyValue.getQualifier()));
            System.out.println("value:"+Bytes.toString(keyValue.getValue()));
            System.out.println("timestamp:"+keyValue.getTimestamp());
            System.out.println("===================================");
        }
    }

    /**
     * @param tableName 表名
     * @param rowKey 行健
     * @param familyName 列族
     * @param columnName 列名
     * @param value 更新后的值
     * @throws IOException
     */
    public static void updateTable(String tableName,String rowKey,String familyName,String columnName,String value)throws IOException{
        HTable table = new HTable(conf,Bytes.toBytes(tableName));
        Put put = new Put(Bytes.toBytes(rowKey));
        put.add(Bytes.toBytes(familyName), Bytes.toBytes(columnName),Bytes.toBytes(value));
        table.put(put);
        System.out.println("更新表成功");
    }


    /**
     * 查询某列数据的多个版本
     * @param tableName   表名
     * @param rowKey    行健
     * @param familyName    列族名
     * @param columnName    列名
     * @throws IOException
     */
    public static void getResultVersion(String tableName,String rowKey,String familyName,String columnName)throws IOException{
        HTable table = new HTable(conf,Bytes.toBytes(tableName));
        Get get = new Get(Bytes.toBytes(rowKey));
        get.addColumn(Bytes.toBytes(familyName),Bytes.toBytes(columnName));
        get.setMaxVersions(5);
        Result result = table.get(get);
        for (KeyValue keyValue : result.list()) {
            System.out.println("family:"+Bytes.toString(keyValue.getFamily()));
            System.out.println("qualifier:"+Bytes.toString(keyValue.getQualifier()));
            System.out.println("value:"+Bytes.toString(keyValue.getValue()));
            System.out.println("timestamp:"+keyValue.getTimestamp());
            System.out.println("===================================");
        }
    }

    /**
     * 删除指定的列
     * @param tableName 表名
     * @param rowKey    行健
     * @param familyName 列族
     * @param columnName    列名
     * @throws IOException
     */
    public static void deleteColumn(String tableName,String rowKey,String familyName,String columnName)throws IOException{
        HTable table = new HTable(conf,Bytes.toBytes(tableName));
        Delete deleteColumn = new Delete(Bytes.toBytes(rowKey));
        deleteColumn.deleteColumns(Bytes.toBytes(familyName),Bytes.toBytes(columnName));
        table.delete(deleteColumn);
        System.out.println(familyName+":"+columnName+"已经删除");
    }

    /**
     * 删除表
     * @param tableName 表名
     * @throws IOException
     */
    public static void deleteTable(String tableName)throws IOException{
        HBaseAdmin admin = new HBaseAdmin(conf);
        admin.disableTable(tableName);
        admin.deleteTable(tableName);
        System.out.println(tableName+"已经删除");
    }
}


//测试类
package com.hbase;

/**
 * 执行Hbase相关操作的类
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String tableName = "teacher";
        String[] family = {"info"};
        String rowKey = "1011";
//
//        //建表
//        HBase.createTable(tableName,family);

        //添加数据到表中

//        String[] value1 = {"18"};
//        String[] info = {"age"};

//        HBase.addData(rowKey,tableName,info,value1);

        //查询表中的数据
//        Result info = HBase.getResult(tableName, rowKey);


//        HBase.getResultScann(tableName);

//        HBase.getResultByColumn(tableName,rowKey,"info","age");

//        HBase.updateTable(tableName,rowKey,"info","age","20");
//        HBase.getResultVersion(tableName,rowKey,"info","age");
//        HBase.deleteColumn(tableName,rowKey,"info","age");

//        HBase.deleteTable(tableName);

    }
}
```

