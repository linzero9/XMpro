package com.gotop.deviceManagement.action;

import com.eos.system.annotation.Bizlet;
import com.eos.system.exception.EOSRuntimeException;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.lang.StringUtils;

@Bizlet("字符串操作工具类")
public class StringUtil
{
  private static char[] bcdLookup = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

  @Bizlet("是否是空字符串")
  public static boolean isBlank(String value)
  {
    return StringUtils.isBlank(value);
  }

  @Bizlet("用指定的字符右补齐字符串")
  public static String rightPad(String originalText, String padString, int destLength)
  {
    if (originalText == null)
      return originalText;
    if (originalText.length() >= destLength)
      return originalText;
    int originalLength = originalText.length();
    int padLength = destLength - originalLength;
    if (padString == null)
      padString = " ";
    StringBuffer result = new StringBuffer();
    result.append(originalText);
    for (int i = 0; i < padLength; i++) {
      int j = i % padString.length();
      result.append(padString.charAt(j));
    }
    return result.toString();
  }

  @Bizlet("用指定的字符左补齐字符串")
  public static String leftPad(String originalText, String padString, int destLength)
  {
    if (originalText == null)
      return originalText;
    StringBuffer result = new StringBuffer();
    result.append(rightPad("", padString, destLength - originalText.length()));

    result.append(originalText);
    return result.toString();
  }

  @Bizlet("把数组或集合转换成字符串")
  public static String collectionToString(Object object, String joinString)
  {
    if (object == null)
      return null;
    if (joinString == null)
      joinString = ",";
    StringBuffer result = new StringBuffer();
    boolean isFirst = true;
    if ((object instanceof Collection)) {
      Collection collection = (Collection)object;
      for (Iterator it = collection.iterator(); it.hasNext(); ) {
        Object obj = it.next();
        if (obj != null) {
          if (!isFirst) {
            result.append(joinString);
          }
          result.append(obj.toString());
          isFirst = false;
        }
      }
      return result.toString();
    }
    if (object.getClass().isArray()) {
      int length = Array.getLength(object);
      for (int i = 0; i < length; i++) {
        Object element = Array.get(object, i);
        if (element != null) {
          if (!isFirst) {
            result.append(joinString);
          }
          result.append(element.toString());
          isFirst = false;
        }
      }
      return result.toString();
    }
    throw new EOSRuntimeException("24000008", new String[] { object.getClass().getName() });
  }

  @Bizlet("用给定的连接符把变长字符串数组拼成一个字符串输出")
  public static String concat(String joinString, String[] strings)
  {
    if (strings == null)
      return null;
    if (joinString == null) {
      joinString = "";
    }
    int length = strings.length;
    StringBuffer result = new StringBuffer();
    boolean flag = false;
    for (int i = 0; i < length; i++)
      if (strings[i] != null)
      {
        if (flag == true) {
          result.append(joinString);
        }
        result.append(strings[i]);
        flag = true;
      }
    return result.toString();
  }

  @Bizlet("字符串是否是双精度数字")
  public static boolean isDouble(String text)
  {
    try
    {
      new Double(text);
      return true; } catch (Exception e) {
    }
    return false;
  }

  @Bizlet("16进制字符串转换成byte数组")
  public static byte[] hexStringToBytes(String hex)
  {
    if (isBlank(hex))
      return new byte[0];
    if (hex.length() % 2 != 0) {
      throw new EOSRuntimeException("24000016", new Integer[] { Integer.valueOf(hex.length()) });
    }

    byte[] bytes = new byte[hex.length() / 2];
    for (int i = 0; i < bytes.length; i++) {
      try {
        bytes[i] = ((byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16));
      }
      catch (NumberFormatException e) {
        throw new EOSRuntimeException("24000017", new String[] { hex.substring(2 * i, 2 * i + 2) });
      }
    }

    return bytes;
  }

  @Bizlet("byte数组转换成16进制字符串")
  public static final String bytesToHexString(byte[] bytes)
  {
    if ((bytes == null) || (bytes.length == 0))
      return "";
    StringBuffer s = new StringBuffer(bytes.length * 2);
    for (int i = 0; i < bytes.length; i++) {
      s.append(bcdLookup[(bytes[i] >>> 4 & 0xF)]);
      s.append(bcdLookup[(bytes[i] & 0xF)]);
    }
    return s.toString();
  }
}
