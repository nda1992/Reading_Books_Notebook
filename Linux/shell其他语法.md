### shell其他语法



- for循环

```bash
sum=0
for((i=1; i<=100; i++))
do
	((sum+=i))
done
echo $sum


#另一种方式
for i in (1..100)
do
	echo $i
	((sum+=i))
done

```



- if

```bash
a=500
b=200
if(( $a>$b ));
then
echo "a>b"
fi
```



























