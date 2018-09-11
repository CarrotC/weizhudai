package org.seckill.util;

import java.security.MessageDigest;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static boolean isEmpty(String s){
        return s == null || "".equals(s.trim());
    }

    public static boolean isEmpty(Object o){
        if(o == null) {
            return true;
        }
        if(o instanceof Integer)
            return (Integer) o == 0;
        else{
            return isEmpty(o.toString());
        }
    }

    public static String UUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String MD5(String str) {
        String result = null;
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");

            md5.update((str).getBytes("UTF-8"));
            byte[] b = md5.digest();

            int i;
            StringBuffer buf = new StringBuffer();

            for(int offset=0; offset<b.length; offset++){
                i = b[offset];
                if(i<0){
                    i+=256;
                }
                if(i<16){
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 将元数据前补零，补后的总长度为指定的长度，以字符串的形式返回
     * @param sourceDate
     * @param formatLength
     * @return 重组后的数据
     */
    public static String frontCompWithZore(int sourceDate,int formatLength)
    {
        /*
         * 0 指前面补充零
         * formatLength 字符总长度为 formatLength
         * d 代表为正数。
         */
        String newString = String.format("%0"+formatLength+"d", sourceDate);
        return  newString;
    }

    public String numberToChar(int number) {
        return String.valueOf((char) number);
    }

    /**
     * 去除字符串中的特殊符号
     *
     * @param str
     * @return
     */
    public static String filtSymbol(String str) {
        String regEx = "[`~!@#$%^&*()+=|{}:;\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’,.。，、？]";
        return Pattern.compile(regEx).matcher(str).replaceAll("").trim();
    }

    /**
     * 去除html字符串的标签，返回纯String字符串
     * @param htmlStr
     * @return
     */
    public static String delHTMLTag(String htmlStr){
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式

        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
        Matcher m_script=p_script.matcher(htmlStr);
        htmlStr=m_script.replaceAll(""); //过滤script标签

        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
        Matcher m_style=p_style.matcher(htmlStr);
        htmlStr=m_style.replaceAll(""); //过滤style标签

        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
        Matcher m_html=p_html.matcher(htmlStr);
        htmlStr=m_html.replaceAll(""); //过滤html标签

        return htmlStr.trim(); //返回文本字符串
    }
}
