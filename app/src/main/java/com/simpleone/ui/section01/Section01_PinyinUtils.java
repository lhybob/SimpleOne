package com.simpleone.ui.section01;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import android.util.Log;

public class Section01_PinyinUtils {
    private static final String TAG = "Section01_PinyinUtils";

    /**
     * 将中文转换为拼音
     * @param chinese 中文文本
     * @return 拼音字符串
     */
    public static String convertToPinyin(String chinese) {
        StringBuilder pinyin = new StringBuilder();
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE); // 设置拼音大小写为小写
        format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK); // 设置声调符号显示声调

        char[] chars = chinese.toCharArray();
        for (char c : chars) {
            try {
                // 判断是否为中文字符
                if (Character.toString(c).matches("[\\u4e00-\\u9fa5]")) {
                    // 获取字符的拼音数组
                    String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c, format);
                    if (pinyinArray != null && pinyinArray.length > 0) {
                        pinyin.append(pinyinArray[0]);
                    }
                } else {
                    // 非中文字符直接添加
                    pinyin.append(c);
                }
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                Log.e(TAG, "BadHanyuPinyinOutputFormatCombination", e);
            }
        }
        Log.d(TAG, "Generated Pinyin: " + pinyin.toString()); // 添加日志输出
        return pinyin.toString();
    }
}
