word break:

������
cd consumerBreakWord2
mvn clean package


���У�
cd target/classes
java com.test.breakWord2.App


���н����
������ƥ�䲻���ʵ�������� �� ���ӷ����ӣ�����һ�㣩


���˴ʵ䣺
{ i, like, sam, sung, samsung, mobile, ice, cream, man go} 
�û��Զ���ʵ䣺
{ i, like, sam, sung, mobile, icecream, man go, mango} 
������ַ���input��
ilikesamsungmobileicecreamman go
(�ʵ��������ַ������ڴ���App.java���Զ��������޸�)
ֻƥ����˴ʵ�����
 i like sam sung mobile i��c��e cream man go
 i like sam sung mobile ice cream man go
 i like samsung mobile i��c��e cream man go
 i like samsung mobile ice cream man go

ֻƥ���û��Զ���ʵ�����
 i like sam sung mobile i��c��e��c��r��e��a��m man go
 i like sam sung mobile icecream man go

ƥ����˴ʵ����û��Զ���ʵ�����
 i like sam sung mobile i��c��e cream man go
 i like sam sung mobile ice cream man go
 i like sam sung mobile icecream man go
 i like samsung mobile i��c��e cream man go
 i like samsung mobile ice cream man go
 i like samsung mobile icecream man go

