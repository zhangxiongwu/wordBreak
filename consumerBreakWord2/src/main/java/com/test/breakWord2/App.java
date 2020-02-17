package com.test.breakWord2;

import java.util.List;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
class BreakWord 
{
	List<String> dict; // 个人词典
	List<String> customerDict; // 用户自定义词典
	List<String> dealDict; // 最终处理的词典
	List<String> outputLine; // 输出结果的各行
	String inputStr; // 输入的字符串
	String outputOnly; // 只匹配个人词典结果
	String outputCustomerOnly; // 只匹配用户自定义词典结果
	String outputBoth; // 匹配个人词典与用户自定义词典结果
	int dictMixWordLen; // 字典里面的最短字符位数

	// 初始化
    private void init(){
    	// 个人词典
    	this.dict = new ArrayList<String>();
    	this.dict.add("i");
    	this.dict.add("like");
    	this.dict.add("sam");
    	this.dict.add("sung");
    	this.dict.add("samsung");
    	this.dict.add("mobile");
    	this.dict.add("ice");
    	this.dict.add("cream");
    	this.dict.add("man go");
    	// 自定义词典
    	this.customerDict = new ArrayList<String>();
    	this.customerDict.add("i");
    	this.customerDict.add("like");
    	this.customerDict.add("sam");
    	this.customerDict.add("sung");
    	this.customerDict.add("mobile");
    	this.customerDict.add("icecream");
    	this.customerDict.add("man go");
    	this.customerDict.add("mango");
    	// 输入的字符串
    	this.inputStr = "ilikesamsungmobileicecreamman go";
    	this.outputOnly = "";
    	this.outputCustomerOnly = "";
    	this.outputBoth = "";
    }

    // 类处理方法
    public void deal()
    {
    	this.init(); // 初始化
    	System.out.println("个人词典：");
        System.out.println( "{ i, like, sam, sung, samsung, mobile, ice, cream, man go} " );
    	System.out.println("用户自定义词典：");
        System.out.println( "{ i, like, sam, sung, mobile, icecream, man go, mango} " );
    	System.out.println("输入的字符串input：");
        System.out.println(this.inputStr);
    	System.out.println("(词典与输入字符串可在代码App.java中自定义随意修改)");

    	this.outputOnly = this.dealBreakWord(this.dict);
    	System.out.println("只匹配个人词典结果：");
        System.out.println(this.outputOnly);

    	this.outputCustomerOnly = this.dealBreakWord(this.customerDict);
    	System.out.println("只匹配用户自定义词典结果：");
        System.out.println(this.outputCustomerOnly);

        // 合字典
        List<String> mergeDict = new ArrayList<String>();
        for(int i=0; i<this.dict.size(); i++)    {   
        	if(!mergeDict.contains(this.dict.get(i))) {
       			mergeDict.add(this.dict.get(i));
        	}
   		}
   		for(int j=0; j<this.customerDict.size(); j++)    {   
       		if(!mergeDict.contains(this.customerDict.get(j))) {
       			mergeDict.add(this.customerDict.get(j));
        	}
   		}
    	this.outputBoth = this.dealBreakWord(mergeDict);
    	System.out.println("匹配个人词典与用户自定义词典结果：");
        System.out.println(this.outputBoth);
    }

    // 处理词分隔
    private String dealBreakWord(List<String> inDict){
    	String reStr = "";
		this.outputLine = new ArrayList<String>(); // 输出结果的各行重新初始化
    	this.dealDict = new ArrayList<String>(); 
    	this.dictMixWordLen = 9999999;
    	for(int i=0; i<inDict.size(); i++)    {   
       		this.dealDict.add(inDict.get(i));
       		if(inDict.get(i).length() < this.dictMixWordLen) { // 统计最长字符位数
       			this.dictMixWordLen = inDict.get(i).length();
       		}
   		}
   		// 递归处理词分隔
   		this.nestBreakWord("", 0);
   		// 遍历输出结果
		for(int j=0; j<this.outputLine.size(); j++)    {   
			// 过滤掉分词失败的部分
			// if(!this.outputLine.get(j).contains("‘")) {
       			reStr += this.outputLine.get(j) + "\n";
			// }
   		}

   		return reStr;
    }

    // 递归处理分隔词
    // 入参前字符串 preStr
    // 入参处理的位置 pos
    private void nestBreakWord(String preStr, int pos){
    	// 递归出口
    	if(pos >= this.inputStr.length()) {
    		this.outputLine.add(preStr);
    		return;
    	}

    	boolean isInDict = false; // 从pos位置开始找字符串是否匹配了字典
    	for(int i=0; i<this.dealDict.size(); i++) { // 遍历词典
       		for(int j=pos; j<this.inputStr.length(); j++) { // 遍历输入字符串
       			String tmpStr = this.inputStr.substring(pos, j+1);
        		// System.out.println(tmpStr);
        		// System.out.println(this.dealDict.get(i));
       			if(tmpStr.equals(this.dealDict.get(i))){
       				isInDict = true;
       				this.nestBreakWord(preStr + " " + this.dealDict.get(i), j+1);
       			}
       		}
   		}

   		// 若不在字典中则寻找的位数往后移
   		if(!isInDict) {
   			int afterPos = pos + this.dictMixWordLen - 1;
   			if(afterPos >= this.inputStr.length() - 1) {
   				this.outputLine.add(preStr + " " + this.inputStr.substring(pos, this.inputStr.length()) + "’");
    			return;
   			} else {
   				this.nestBreakWord(preStr + " " + this.inputStr.substring(pos, afterPos + 1) + "’", afterPos + 1);
   			}
   		}
    }
}

public class App 
{
	public static void main( String[] args )
    {
		BreakWord b = new BreakWord();
		b.deal();
    }
}
