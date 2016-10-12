package test.httpClient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.GetMethod;

import java.util.Iterator;
import java.util.Map;
import java.net.SocketTimeoutException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 
 *最简单的HTTP客户端,用来演示通过GET或者POST方式访问某个页面
  *@authorLiudong
*/
public class SimpleClient {
public static void main(String[] args) throws IOException 
{
  HttpClient client = new HttpClient(); 
      // 设置代理服务器地址和端口      
      //client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port); 
      // 使用 GET 方法 ，如果服务器需要通过 HTTPS 连接，那只需要将下面 URL 中的 http 换成 https 
//         HttpMethod method=new GetMethod("http://java.sun.com");
	  HttpMethod method=new PostMethod("http://taoke.dedecms.com/api/t.php");
      //使用POST方法
      //HttpMethod method = new PostMethod("http://java.sun.com");
      client.executeMethod(method);

      //打印服务器返回的状态
      System.out.println(method.getStatusLine());
      
      //打印服务器返回的状态码
      System.out.println(method.getStatusCode());
      
      //打印请求的程序路径
      System.out.println(method.getPath());
      
      //打印请求的程序路径
      System.out.println(method.getFollowRedirects());
      
    
      //打印返回的信息
      System.out.println(method.getResponseBodyAsString());
      //释放连接
      method.releaseConnection();
   }
}