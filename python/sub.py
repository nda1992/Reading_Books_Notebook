# coding=utf-8
# ~/anaconda3/bin/python3.6
'''
Author:NDA
E-mail:nongdingan@126.com
github:https://github.com/nda1992/Reading_Books_Notebook
'''

#使用Python批量替换指定目录下的所有文件的内容（将$HADOOP$替换为/home/oectl/app/hadoop）

'''
$HADOOP_HOME$ adaf dfa $HADOOP_HOME$ 
aaa $HADOOP_HOME$  bbb
ccc ddd $HADOOP_HOME$ 
$HADOOP_HOME$  eee fff
'''
import os

filepath='/home/aaa/Linux_shell/data1/'

files = os.listdir(filepath)

def sub(FileName):
    with open(filepath+FileName,'r',encoding='utf8') as f:
        lines = f.readlines()
        for line in lines:
            str1 = line.strip().replace("$HADOOP_HOME$","/home/octel/hadoop")
            with open(filepath + FileName, 'a+', encoding='utf8') as f1:
                f1.write(str1+'\n')

def util():
    for file in files:
        sub(file)
    print("finished")
if __name__=='__main__':
    util()

