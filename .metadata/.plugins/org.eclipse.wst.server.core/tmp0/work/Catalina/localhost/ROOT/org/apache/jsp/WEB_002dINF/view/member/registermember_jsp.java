/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2016-03-18 08:04:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registermember_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/common/header.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/common/login.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/common/footer.jsp", out, false);
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"resource/js/json2.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready( function() {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#doRegister\").click( function() {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// ID Check\r\n");
      out.write("\t\t\tvar id = $(\"#id\").val();\r\n");
      out.write("\t\t\tid = $.trim( id );\r\n");
      out.write("\t\t\tif ( id == \"\" ) {\r\n");
      out.write("\t\t\t\talert(\"ID 입력\");\r\n");
      out.write("\t\t\t\t$(\"#id\").focus();\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// PASSWORD Check\r\n");
      out.write("\t\t\tvar password = $(\"#password\").val();\r\n");
      out.write("\t\t\tpassword = $.trim( password );\r\n");
      out.write("\t\t\tif ( password == \"\" ) {\r\n");
      out.write("\t\t\t\talert(\"PASSWORD 입력\");\r\n");
      out.write("\t\t\t\t$(\"#password\").focus();\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// NICKNAME Check\r\n");
      out.write("\t\t\tvar nickname = $(\"#nickname\").val();\r\n");
      out.write("\t\t\tnickname = $.trim( nickname );\r\n");
      out.write("\t\t\tif ( nickname == \"\" ) {\r\n");
      out.write("\t\t\t\talert(\"NICKNAME 입력\");\r\n");
      out.write("\t\t\t\t$(\"#nickname\").focus();\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// E-MAIL Check\r\n");
      out.write("\t\t\tvar email = $(\"#email\").val();\r\n");
      out.write("\t\t\temail = $.trim( email );\r\n");
      out.write("\t\t\tif ( email == \"\" ) {\r\n");
      out.write("\t\t\t\talert(\"E-MAIL 입력\");\r\n");
      out.write("\t\t\t\t$(\"#email\").focus();\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// FOAM Submit\r\n");
      out.write("\t\t\tvar form = $(\"#registerForm\");\r\n");
      out.write("\t\t\tform.attr(\"method\", \"POST\");\r\n");
      out.write("\t\t\tform.attr(\"action\", \"/addNewMember\");\r\n");
      out.write("\t\t\tform.submit();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t} );\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#cancle\").click( function() {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tlocation.href=\"/\";\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t} );\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#check\").click( function() {\r\n");
      out.write("\t\t\tvar memberId = document.getElementById('id').value;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tconsole.log(memberId);\r\n");
      out.write("/* \t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype:\"POST\",\r\n");
      out.write("\t\t\t\turl:\"/checkId\",\r\n");
      out.write("\t\t\t\tdata:this.memberId,\r\n");
      out.write("\t\t\t\tdataType:\"memberId\",\r\n");
      out.write("\t\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\t\tvar jsonData =  JSON.parse(data);\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tconsole.log(jsonData);\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tif ( jsonData.isCheck ) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#id\").text(\"\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#id\").reset();\r\n");
      out.write("\t\t\t\t\t\talert(\"이미 존재하는 아이디입니다.\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse if ( jsonData.isCheck ) {\r\n");
      out.write("\t\t\t\t\t\talert(\"사용할 수 있는 아이디입니다.\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t} \r\n");
      out.write("\t\t\t}) */\r\n");
      out.write(" \t\t\t$.post(\r\n");
      out.write("\t\t\t\t\t\"/checkId\"\r\n");
      out.write("\t\t\t\t\t, { \"memberId\" : $(\"#id\").val() }\r\n");
      out.write("\t\t\t\t\t, function(data){\r\n");
      out.write("\t\t\t\t\t\tvar jsonData = {};\r\n");
      out.write("\t\t\t\t\t\ttry{\r\n");
      out.write("\t\t\t\t\t\t\tjsonData = JSON.parse(data);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\tcatch(e) {\r\n");
      out.write("\t\t\t\t\t\t\talert(\"으아아앙앙\")\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tconsole.log(jsonData);\r\n");
      out.write("\t\t\t\t\t\tif ( jsonData.isCheck ) {\r\n");
      out.write("\t\t\t\t\t\t\tvar text = $(\"#id\").text();\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#id\").text(\"\");\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#id\").reset();\r\n");
      out.write("\t\t\t\t\t\t\talert(\"이미 존재하는 아이디입니다.\");\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\telse if ( jsonData.isCheck ) {\r\n");
      out.write("\t\t\t\t\t\t\talert(\"사용할 수 있는 아이디입니다.\");\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t} \r\n");
      out.write("\t\t\t\t);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t} );\r\n");
      out.write("</script>   \r\n");
      out.write("\r\n");
      out.write("<br/>\r\n");
      out.write("\r\n");
      out.write("<form id=\"registerForm\">\r\n");
      out.write("\t<table id=\"tb\" align=\"center\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>ID :</th>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"id\" name=\"id\" style=\"width: 250px;\" /><input type=\"button\" id=\"check\" name=\"check\" value=\"중복체크\" />\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>Password :</th>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<input type=\"password\" id=\"password\" name=\"password\" style=\"width: 250px;\" />\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>닉네임 :</th>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"nickname\" name=\"nickname\" style=\"width: 250px;\" />\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>E-mail :</th>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<input type=\"email\" id=\"email\" name=\"email\" style=\"width: 250px;\" />\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t<input type=\"button\" id=\"doRegister\" value=\"등록!\" />\r\n");
      out.write("\t<input type=\"reset\" value=\"다시 쓰기\" />\r\n");
      out.write("\t<input type=\"button\" id=\"cancle\" value=\"취소\" />\r\n");
      out.write("\t</div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
