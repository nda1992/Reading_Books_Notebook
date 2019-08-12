# coding=utf-8
# ~/anaconda3/bin/python3.6
'''
Author:NDA
E-mail:nongdingan@126.com
github:https://github.com/nda1992/Reading_Books_Notebook
'''
import random

def create_phone_number():
    # 第二位数字
    second = [3, 4, 5, 7, 8][random.randint(0, 4)]
    # 第三位数字
    third = {
        3: random.randint(0, 9),
        4: [5, 7, 9][random.randint(0, 2)],
        5: [i for i in range(10) if i != 4][random.randint(0, 8)],
        7: [i for i in range(10) if i not in [4, 9]][random.randint(0, 7)],
        8: random.randint(0, 9),
    }[second]
    # 最后八位数字
    suffix = random.randint(9999999, 100000000)
    # 拼接手机号
    return "1{}{}{}".format(second, third, suffix)

def get_phone_numbers(nums):
    list_phone_number=[]
    for i in range(nums):
        list_phone_number.append(create_phone_number())
    return list_phone_number


#随机生成姓名
def create_name(nums):
    list_Xing = ['赵', '钱', '孙', '李', '周', '吴', '郑', '王', '冯', '陈', '褚', '卫', '蒋', '沈', '韩', '杨', '张', '李']
    list_Ming = ['豫', '章', '故', '郡', '洪', '都', '新', '府', '星', '分', '翼', '轸', '地', '接', '衡', '庐', '襟', '三', '江', '', '而',
                 '带', '五', '湖', '控', '蛮', '荆', '而', '引', '瓯', '越', '物', '华', '天', '宝', '龙', '光', '射', '牛', '斗', '之',
                 '墟', '人', '杰', '地', '灵', '徐', '孺', '饯', '子','宝','晓','华','颖']
    list_name=[]
    for i in range(nums):
        name=random.choice(list_Xing)+random.choice(list_Ming)+random.choice(list_Ming)
        list_name.append(name)
    return list_name

#将“电话号码  姓名”的格式写到外部文件中
def write_out_phone_number(nums):
    phone=get_phone_numbers(nums)
    name=create_name(nums)
    file_out=open("/usr/C++/call.log",'w',encoding='utf8')
    for i in range(len(phone)):
        file_out.write(phone[i]+"\t"+name[i]+"\n")
    file_out.close()
write_out_phone_number(50)
