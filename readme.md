word break:

构建：
cd consumerBreakWord2
mvn clean package


运行：
cd target/classes
java com.test.breakWord2.App


运行结果：
（遇到匹配不到词的情况用了 ‘ 连接符连接，明显一点）


个人词典：
{ i, like, sam, sung, samsung, mobile, ice, cream, man go} 
用户自定义词典：
{ i, like, sam, sung, mobile, icecream, man go, mango} 
输入的字符串input：
ilikesamsungmobileicecreamman go
(词典与输入字符串可在代码App.java中自定义随意修改)
只匹配个人词典结果：
 i like sam sung mobile i‘c‘e cream man go
 i like sam sung mobile ice cream man go
 i like samsung mobile i‘c‘e cream man go
 i like samsung mobile ice cream man go

只匹配用户自定义词典结果：
 i like sam sung mobile i‘c‘e‘c‘r‘e‘a‘m man go
 i like sam sung mobile icecream man go

匹配个人词典与用户自定义词典结果：
 i like sam sung mobile i‘c‘e cream man go
 i like sam sung mobile ice cream man go
 i like sam sung mobile icecream man go
 i like samsung mobile i‘c‘e cream man go
 i like samsung mobile ice cream man go
 i like samsung mobile icecream man go

