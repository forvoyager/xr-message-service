package com.xr.base.common;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-19 16:33:00 <br>
 * <b>description</b>: <br>
 */
public final class EnvUtils {
  private EnvUtils(){}

  /**
   * 获取当前JVM PID
   * @return
   */
  public static int getPid() {
    RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
    // pid@hostname 如：618@DEoap-ss
    String name = runtime.getName();

    try {
      return Integer.parseInt(name.substring(0, name.indexOf(64)));
    } catch (Exception var3) {
      return -1;
    }
  }

  public static String getHostname() {
    RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
    // pid@hostname 如：618@DEoap-ss
    String name = runtime.getName();

    try {
      return name.substring(name.indexOf(64));
    } catch (Exception var3) {
      return "";
    }
  }

  /**
   * 获取本机ip
   * @return
   */
  public static String getIP() {
    try {
      Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
      InetAddress ip = null;
      byte[] internalIP = null;

      while(allNetInterfaces.hasMoreElements()) {
        NetworkInterface netInterface = (NetworkInterface)allNetInterfaces.nextElement();
        Enumeration addresses = netInterface.getInetAddresses();

        while(true) {
          ip = (InetAddress)addresses.nextElement();
          if(ip == null){continue;}

          byte[] ipByte;
          if (ip instanceof Inet4Address) {
            ipByte = ip.getAddress();
            if (ipByte.length == 4 && ipCheck(ipByte)) {
              if (!isInternalIP(ipByte)) {
                return ipToIPv4Str(ipByte);
              }

              if (internalIP == null) {
                internalIP = ipByte;
              }
            }
          } else if (ip instanceof Inet6Address) {
            // todo v6地址暂不处理
          }
        }
      }

      if (internalIP != null) {
        return ipToIPv4Str(internalIP);
      } else {
        throw new RuntimeException("Can not get local ip");
      }
    } catch (Exception var6) {
      throw new RuntimeException("Can not get local ip", var6);
    }
  }

  private static boolean isInternalIP(byte[] ip) {
    if (ip.length != 4) {
      throw new RuntimeException("illegal ipv4 bytes");
    } else if (ip[0] == 10) {
      return true;
    } else {
      if (ip[0] == -84) {
        if (ip[1] >= 16 && ip[1] <= 31) {
          return true;
        }
      } else if (ip[0] == -64 && ip[1] == -88) {
        return true;
      }

      return false;
    }
  }

  private static boolean ipCheck(byte[] ip) {
    if (ip.length != 4) {
      throw new RuntimeException("illegal ipv4 bytes");
    } else if (ip[0] >= 1 && ip[0] <= 126) {
      if (ip[1] == 1 && ip[2] == 1 && ip[3] == 1) {
        return false;
      } else {
        return ip[1] != 0 || ip[2] != 0 || ip[3] != 0;
      }
    } else if (ip[0] >= -128 && ip[0] <= -65) {
      if (ip[2] == 1 && ip[3] == 1) {
        return false;
      } else {
        return ip[2] != 0 || ip[3] != 0;
      }
    } else if (ip[0] >= -64 && ip[0] <= -33) {
      if (ip[3] == 1) {
        return false;
      } else {
        return ip[3] != 0;
      }
    } else {
      return false;
    }
  }

  private static String ipToIPv4Str(byte[] ip) {
    return ip.length != 4 ? null : (ip[0] & 255) + "." + (ip[1] & 255) + "." + (ip[2] & 255) + "." + (ip[3] & 255);
  }
}
