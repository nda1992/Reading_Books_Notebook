# coding=utf-8
# ~/anaconda3/bin/python3.6
'''
Author:NDA
E-mail:nongdingan@126.com
github:https://github.com/nda1992/Reading_Books_Notebook
'''

#压缩字符串："aaabbccccddd"=a3b2c4d3
def zipString(s):
    if len(s)==0:
        return
    char_index={}
    count = 1
    k=0
    for i in range(1,len(s)):
        if s[i]==s[i-1]:
            count += 1
        else:
            char_index[s[i-1]]=count
            count=1
        k+=1
    if(count==1):
        char_index[s[k]]=1
    else:
        char_index[s[k]]=count

    str1=[]
    for k,v in char_index.items():
        str1.append(k)
        str1.append(v)
    s=[]
    for i in str1:
        s.append(str(i))
    return "".join(s)

print(zipString("aaabbccccddd"))
