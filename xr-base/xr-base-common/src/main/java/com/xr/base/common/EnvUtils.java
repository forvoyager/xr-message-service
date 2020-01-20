package com.xr.base.common;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.regex.Pattern;

/**
 * <b>author</b>: forvoyager@outlook.com
 * <b>time</b>: 2020-01-19 16:33:00 <br>
 * <b>description</b>: <br>
 */
public final class EnvUtils {

  public static final String ANYHOST = "0.0.0.0";

  public static final String LOCALHOST = "127.0.0.1";

  public static final Pattern IP_PATTERN = Pattern.compile("\\d{1,3}(\\.\\d{1,3}){3,5}$");

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
  public static String getIP() throws Exception {
    InetAddress localAddress = InetAddress.getLocalHost();
    if (isValidAddress(localAddress)) {
      return localAddress.getHostAddress();
    }

    // 获取本机所有网卡
    Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
    if (interfaces != null) {
      NetworkInterface network = null;
      while (interfaces.hasMoreElements()) {
        network = interfaces.nextElement();

        // 获取网卡绑定的IP地址
        Enumeration<InetAddress> addresses = network.getInetAddresses();
        if (addresses != null) {
          while (addresses.hasMoreElements()) {
            InetAddress address = addresses.nextElement();
            if (isValidAddress(address)) {
              return address.getHostAddress();
            }
          }
        }
      }
    }

    throw new RuntimeException("no available IP address.");
  }

  private static boolean isValidAddress(InetAddress address) {
    if (address == null || address.isLoopbackAddress()) {
      return false;
    }
    String name = address.getHostAddress();
    return (name != null
            && !ANYHOST.equals(name)
            && !LOCALHOST.equals(name)
            && IP_PATTERN.matcher(name).matches());
  }
}
