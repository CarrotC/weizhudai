var StringCompare={
    /**
     * 去除字符串中特殊符号
     * @param str
     * @returns {string | void}
     */
     filtSymbol:function(str) {
    var pattr = /[，。？！：·~；{}%#*【】,.?!:`;\[\]]/g;
    return str.replace(pattr, "");
},


/**
 * 优化后的编辑距离的算法
 * @returns {*}
 */
levenshshtein:function (str1,str2) {
    var len1 = str1.length;
    var len2 = str2.length;
    var leg=-1;
    //从前开始匹配
    for (var i = 0; i < len1; i++) {
        if (i < len2) {
            if (str2.charAt(i) == str1.charAt(i)) leg = i;
            else break;
        } else {
            break;
        }
    }
    //去除已经匹配成功的字符串
    str1 = str1.substring(leg+1, len1);
    str2 = str2.substring(leg+1, len2);
    len1 = str1.length;
    len2 = str2.length;
    leg=-1;
    //从后开始匹配
    for (var i = 1; i < len1; i++) {
        if (len2 - i < 0)
            break;
        if (str2.charAt(len2 - i) == str1.charAt(len1 - i))
            leg = i;
        else break;
    }

    str1 = str1.substring(0, len1 - leg+1);
    str2 = str2.substring(0, len2 - leg+1);
    len1 = str1.length;
    len2 = str2.length;

    var dif = new Array();
    //使用编辑距离算法求出新得到的两个字符串的差异步数
    for (var i = 0; i <= len1; i++) {
        dif[i] = new Array(len2 + 1)
        dif[i][0] = i;
    }
    for (var j = 0; j <= len2; j++)
        dif[0][j] = j;
    for (var i = 1; i <= len1; i++) {
        for (var j = 1; j <= len2; j++) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1))
                dif[i][j] = dif[i - 1][j - 1];
            else {
                var map = this.getMin(dif[i - 1][j - 1], dif[i - 1][j], dif[i][j - 1]);
                dif[i][j] = map["min"] + 1;
            }
        }
    }
    //输出差异步数
    return dif[len1][len2];
},

/**
 * 拿到三个值中的最小值，并且记录最小值的位置
 * @param a
 * @param b
 * @param c
 * @returns {any[]}
 */
 getMin:function(a,b,c) {
    var map = new Array();
    var min = a;
    var leg = 1;
    if (b < min) {
        min = b;
        leg = 2;
    }
    if (c < min) {
        min = c;
        leg = 2;
    }
    map["min"]= min;
    map["leg"]= leg;
    return map;
},

/**
 * 得到标准字符串中的关键字集合
 * @param string
 * @returns {any[]}
 */
 getKeyWorlds:function(string) {
    var map = {};
    var charArray = string.split("");

    var set = new Array();
    for (var thisChar in charArray) {
        if (charArray[thisChar] in map){
            map[charArray[thisChar]]=map[charArray[thisChar]]+ 1;
        }
        else{
            map[charArray[thisChar]]= 1;

        }
    }

    var leg = 0, i = 0;
    //拿出所有出现一次的字符，并且判断两者之间的距离大于5，才可作为第二个关键字，i记录位置，leg记录上一个关键字的位置
    for (var key in map) {
        if (map[key] == 1) {
            if (i - leg >= 5) {
                set.push(key);
                leg = i;
            }
        }
        i++;
    }
    return set;
},

/**
 * 根据差异步数，和标准字符串的长度算出分数
 * @param step
 * @param len1
 * @returns {number}
 */
 getScoreByStepAndLength:function(step,len){
    return 100-(step/len).toFixed(2)*100;
},

/**
 * 整合函数，输入两个字符串，算出用户输入字符串的分数
 * @param str1
 * @param str2
 * @returns {number}
 */
 getScore:function(str1,str2) {
    //把两个字符串中的符号过滤掉
    str1=this.filtSymbol(str1);
    str2=this.filtSymbol(str2);
    var step=this.levenshshtein(str1,str2);
    return this.getScoreByStepAndLength(step,Math.max(str1.length,str2.length));

}
}





